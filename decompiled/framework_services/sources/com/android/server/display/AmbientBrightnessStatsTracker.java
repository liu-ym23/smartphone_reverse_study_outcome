package com.android.server.display;

import android.hardware.display.AmbientBrightnessDayStats;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.display.utils.DebugUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class AmbientBrightnessStatsTracker {
    static final float[] BUCKET_BOUNDARIES_FOR_NEW_STATS = null;
    private static final boolean DEBUG = false;
    static final int MAX_DAYS_TO_TRACK = 7;
    private static final String TAG = "AmbientBrightnessStatsTracker";
    private final AmbientBrightnessStats mAmbientBrightnessStats;
    private float mCurrentAmbientBrightness;
    private int mCurrentUserId;
    private final Injector mInjector;
    private final Timer mTimer;
    private final UserManager mUserManager;

    class AmbientBrightnessStats {
        private static final String ATTR_BUCKET_BOUNDARIES = "bucket-boundaries";
        private static final String ATTR_BUCKET_STATS = "bucket-stats";
        private static final String ATTR_LOCAL_DATE = "local-date";
        private static final String ATTR_USER = "user";
        private static final String TAG_AMBIENT_BRIGHTNESS_DAY_STATS = "ambient-brightness-day-stats";
        private static final String TAG_AMBIENT_BRIGHTNESS_STATS = "ambient-brightness-stats";
        private Map<Integer, Deque<AmbientBrightnessDayStats>> mStats;
        final /* synthetic */ AmbientBrightnessStatsTracker this$0;

        public AmbientBrightnessStats(AmbientBrightnessStatsTracker this$0) {
            this.this$0 = this$0;
            this.mStats = new HashMap();
        }

        public void log(int userId, LocalDate localDate, float ambientBrightness, float durationSec) {
            Deque<AmbientBrightnessDayStats> userStats = getOrCreateUserStats(this.mStats, userId);
            AmbientBrightnessDayStats dayStats = getOrCreateDayStats(userStats, localDate);
            dayStats.log(ambientBrightness, durationSec);
        }

        public ArrayList<AmbientBrightnessDayStats> getUserStats(int userId) {
            if (this.mStats.containsKey(Integer.valueOf(userId)) == true) goto L5;
            return null;
        L5:
            return new ArrayList(this.mStats.get(Integer.valueOf(userId)));
        }

        public void writeToXML(OutputStream stream) throws IOException {
            TypedXmlSerializer out = Xml.resolveSerializer(stream);
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            LocalDate cutOffDate = AmbientBrightnessStatsTracker.m3561$$Nest$fgetmInjector(this.this$0).getLocalDate().minusDays(7);
            out.startTag(null, TAG_AMBIENT_BRIGHTNESS_STATS);
            Iterator<Map.Entry<Integer, Deque<AmbientBrightnessDayStats>>> r4 = this.mStats.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L21;
            Map.Entry<Integer, Deque<AmbientBrightnessDayStats>> entry = r4.next();
            Iterator<AmbientBrightnessDayStats> r6 = entry.getValue().iterator();
        L7:
            if (r6.hasNext() == false) goto L4;
            AmbientBrightnessDayStats userDayStats = r6.next();
            int userSerialNumber = AmbientBrightnessStatsTracker.m3561$$Nest$fgetmInjector(this.this$0).getUserSerialNumber(AmbientBrightnessStatsTracker.m3562$$Nest$fgetmUserManager(this.this$0), entry.getKey().intValue());
            if (userSerialNumber == (-1)) goto L7;
            if (userDayStats.getLocalDate().isAfter(cutOffDate) == false) goto L7;
            out.startTag(null, TAG_AMBIENT_BRIGHTNESS_DAY_STATS);
            out.attributeInt(null, ATTR_USER, userSerialNumber);
            out.attribute(null, ATTR_LOCAL_DATE, userDayStats.getLocalDate().toString());
            StringBuilder bucketBoundariesValues = new StringBuilder();
            StringBuilder timeSpentValues = new StringBuilder();
            int i = 0;
        L14:
            if (i >= userDayStats.getBucketBoundaries().length) goto L18;
            if (i <= 0) goto L17;
            bucketBoundariesValues.append(",");
            timeSpentValues.append(",");
        L17:
            bucketBoundariesValues.append(userDayStats.getBucketBoundaries()[i]);
            timeSpentValues.append(userDayStats.getStats()[i]);
            i = i + 1;
            goto L14
        L18:
            out.attribute(null, ATTR_BUCKET_BOUNDARIES, bucketBoundariesValues.toString());
            out.attribute(null, ATTR_BUCKET_STATS, timeSpentValues.toString());
            out.endTag(null, TAG_AMBIENT_BRIGHTNESS_DAY_STATS);
            goto L7
        L21:
            out.endTag(null, TAG_AMBIENT_BRIGHTNESS_STATS);
            out.endDocument();
            stream.flush();
        }

        public void readFromXML(InputStream stream) throws IOException {
            String r0 = ",";
            Map<Integer, Deque<AmbientBrightnessDayStats>> parsedStats = new HashMap();     // Catch: Throwable -> L19
            TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L19
        L4:
            int type = parser.next();     // Catch: Throwable -> L19
            int r6 = 1;
            if (type == 1) goto L9;
            if (type != 2) goto L4;
        L9:
            String tag = parser.getName();     // Catch: Throwable -> L19
            if (TAG_AMBIENT_BRIGHTNESS_STATS.equals(tag) == false) goto L50;
            LocalDate cutOffDate = AmbientBrightnessStatsTracker.m3561$$Nest$fgetmInjector(this.this$0).getLocalDate().minusDays(7);     // Catch: Throwable -> L19
            int outerDepth = parser.getDepth();     // Catch: Throwable -> L19
        L12:
            int type2 = parser.next();     // Catch: Throwable -> L19
            if (type2 == r6) goto L47;
            if (type2 == 3) goto L17;
        L21:
            if (type2 != 3) goto L23;
            r0 = r0;
        L45:
            r0 = r0;
            r6 = 1;
            goto L12
        L23:
            if (type2 != 4) goto L26;
            r0 = r0;
            goto L45
        L26:
            if (TAG_AMBIENT_BRIGHTNESS_DAY_STATS.equals(parser.getName()) == false) goto L44;
            int userSerialNumber = parser.getAttributeInt(null, ATTR_USER);     // Catch: Throwable -> L19
            LocalDate localDate = LocalDate.parse(parser.getAttributeValue(null, ATTR_LOCAL_DATE));     // Catch: Throwable -> L19
            String[] bucketBoundaries = parser.getAttributeValue(null, ATTR_BUCKET_BOUNDARIES).split(r0);     // Catch: Throwable -> L19
            String[] bucketStats = parser.getAttributeValue(null, ATTR_BUCKET_STATS).split(r0);     // Catch: Throwable -> L19
            if (bucketBoundaries.length != bucketStats.length) goto L43;
            if (bucketBoundaries.length < r6) goto L43;
            float[] parsedBucketBoundaries = new float[bucketBoundaries.length];     // Catch: Throwable -> L19
            float[] parsedBucketStats = new float[bucketStats.length];     // Catch: Throwable -> L19
            int i = 0;
        L33:
            if (i >= bucketBoundaries.length) goto L35;
            parsedBucketBoundaries[i] = Float.parseFloat(bucketBoundaries[i]);     // Catch: Throwable -> L19
            parsedBucketStats[i] = Float.parseFloat(bucketStats[i]);     // Catch: Throwable -> L19
            i = i + 1;     // Catch: Throwable -> L19
            goto L33
        L35:
            int userId = AmbientBrightnessStatsTracker.m3561$$Nest$fgetmInjector(this.this$0).getUserId(AmbientBrightnessStatsTracker.m3562$$Nest$fgetmUserManager(this.this$0), userSerialNumber);     // Catch: Throwable -> L19
            if (userId == (-1)) goto L45;
            if (localDate.isAfter(cutOffDate) == false) goto L45;
            Deque<AmbientBrightnessDayStats> userStats = getOrCreateUserStats(parsedStats, userId);     // Catch: Throwable -> L19
            userStats.offer(new AmbientBrightnessDayStats(localDate, parsedBucketBoundaries, parsedBucketStats));     // Catch: Throwable -> L19
        L43:
            throw new IOException("Invalid brightness stats string.");     // Catch: Throwable -> L19
        L44:
            r0 = r0;
            goto L45
        L17:
            if (parser.getDepth() > outerDepth) goto L21;
        L47:
            this.mStats = parsedStats;     // Catch: Throwable -> L19
            return;
        L50:
            throw new XmlPullParserException("Ambient brightness stats not found in tracker file " + tag);     // Catch: Throwable -> L19
        L19:
            e = move-exception;
            throw new IOException("Failed to parse brightness stats file.", e);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            Iterator<Map.Entry<Integer, Deque<AmbientBrightnessDayStats>>> r1 = this.mStats.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            Map.Entry<Integer, Deque<AmbientBrightnessDayStats>> entry = r1.next();
            Iterator<AmbientBrightnessDayStats> r3 = entry.getValue().iterator();
        L7:
            if (r3.hasNext() == false) goto L4;
            AmbientBrightnessDayStats dayStats = r3.next();
            builder.append("  ");
            builder.append(entry.getKey());
            builder.append(" ");
            builder.append(dayStats);
            builder.append("\n");
            goto L7
        L11:
            return builder.toString();
        }

        private Deque<AmbientBrightnessDayStats> getOrCreateUserStats(Map<Integer, Deque<AmbientBrightnessDayStats>> stats, int userId) {
            if (stats.containsKey(Integer.valueOf(userId)) == true) goto L6;
            stats.put(Integer.valueOf(userId), new ArrayDeque());
        L6:
            return stats.get(Integer.valueOf(userId));
        }

        private AmbientBrightnessDayStats getOrCreateDayStats(Deque<AmbientBrightnessDayStats> userStats, LocalDate localDate) {
            AmbientBrightnessDayStats lastBrightnessStats = userStats.peekLast();
            if (lastBrightnessStats != null) goto L5;
        L7:
            if (lastBrightnessStats == null) goto L9;
            FrameworkStatsLog.write(FrameworkStatsLog.AMBIENT_BRIGHTNESS_STATS_REPORTED, lastBrightnessStats.getStats(), lastBrightnessStats.getBucketBoundaries());
        L9:
            AmbientBrightnessDayStats dayStats = new AmbientBrightnessDayStats(localDate, AmbientBrightnessStatsTracker.BUCKET_BOUNDARIES_FOR_NEW_STATS);
            if (userStats.size() != 7) goto L12;
            userStats.poll();
        L12:
            userStats.offer(dayStats);
            return dayStats;
        L5:
            if (lastBrightnessStats.getLocalDate().equals(localDate) == false) goto L7;
            return lastBrightnessStats;
        }
    }

    interface Clock {
        long elapsedTimeMillis();
    }

    static class Injector {
        Injector() {
        }

        public long elapsedRealtimeMillis() {
            return SystemClock.elapsedRealtime();
        }

        public int getUserSerialNumber(UserManager userManager, int userId) {
            return userManager.getUserSerialNumber(userId);
        }

        public int getUserId(UserManager userManager, int userSerialNumber) {
            return userManager.getUserHandle(userSerialNumber);
        }

        public LocalDate getLocalDate() {
            return LocalDate.now();
        }
    }

    static class Timer {
        private final Clock clock;
        private long startTimeMillis;
        private boolean started;

        public Timer(Clock clock) {
            this.clock = clock;
        }

        public void reset() {
            this.started = false;
        }

        public void start() {
            if (this.started == true) goto L6;
            this.startTimeMillis = this.clock.elapsedTimeMillis();
            this.started = true;
            return;
        }

        public boolean isRunning() {
            return this.started;
        }

        public float totalDurationSec() {
            if (this.started == true) goto L5;
            return 0.0f;
        L5:
            return (float) ((this.clock.elapsedTimeMillis() - this.startTimeMillis) / 1000.0d);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$fAbjbj4ACWU53j1Xe-MqKuY4efU, reason: not valid java name */
    public static /* synthetic */ long m3560$r8$lambda$fAbjbj4ACWU53j1XeMqKuY4efU(AmbientBrightnessStatsTracker r2) {
        return r2.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m3561$$Nest$fgetmInjector(AmbientBrightnessStatsTracker r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m3562$$Nest$fgetmUserManager(AmbientBrightnessStatsTracker r0) {
        return r0.mUserManager;
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        BUCKET_BOUNDARIES_FOR_NEW_STATS = new float[]{0.0f, 0.1f, 0.3f, 1.0f, 3.0f, 10.0f, 30.0f, 100.0f, 300.0f, 1000.0f, 3000.0f, 10000.0f};
    }

    public AmbientBrightnessStatsTracker(UserManager userManager, Injector injector) {
        this.mUserManager = userManager;
        if (injector == null) goto L5;
        this.mInjector = injector;
    L6:
        this.mAmbientBrightnessStats = new AmbientBrightnessStats(this);
        this.mTimer = new Timer(new AmbientBrightnessStatsTracker$$ExternalSyntheticLambda0(this));
        this.mCurrentAmbientBrightness = -1.0f;
        return;
    L5:
        this.mInjector = new Injector();
        goto L6
    }

    private /* synthetic */ long lambda$new$0() {
        return this.mInjector.elapsedRealtimeMillis();
    }

    public synchronized void start() {
        monitor-enter(this);
        this.mTimer.reset();     // Catch: Throwable -> L6
        this.mTimer.start();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mTimer.isRunning() == false) goto L8;
        this.mAmbientBrightnessStats.log(this.mCurrentUserId, this.mInjector.getLocalDate(), this.mCurrentAmbientBrightness, this.mTimer.totalDurationSec());     // Catch: Throwable -> L6
    L8:
        this.mTimer.reset();     // Catch: Throwable -> L6
        this.mCurrentAmbientBrightness = -1.0f;     // Catch: Throwable -> L6
        monitor-exit(this);
    }

    public synchronized void add(int userId, float newAmbientBrightness) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTimer.isRunning() == false) goto L16;
        if (userId != this.mCurrentUserId) goto L11;
        this.mAmbientBrightnessStats.log(this.mCurrentUserId, this.mInjector.getLocalDate(), this.mCurrentAmbientBrightness, this.mTimer.totalDurationSec());     // Catch: Throwable -> L8
    L14:
        this.mTimer.reset();     // Catch: Throwable -> L8
        this.mTimer.start();     // Catch: Throwable -> L8
        this.mCurrentAmbientBrightness = newAmbientBrightness;     // Catch: Throwable -> L8
    L18:
        monitor-exit(this);
        return;
    L11:
        if (DEBUG == false) goto L13;
        Slog.v(TAG, "User switched since last sensor event.");     // Catch: Throwable -> L8
    L13:
        this.mCurrentUserId = userId;     // Catch: Throwable -> L8
        goto L14
    L16:
        if (DEBUG == false) goto L18;
        Slog.e(TAG, "Timer not running while trying to add brightness stats.");     // Catch: Throwable -> L8
        goto L18
    }

    public synchronized void writeStats(OutputStream stream) throws IOException {
        monitor-enter(this);
        this.mAmbientBrightnessStats.writeToXML(stream);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void readStats(InputStream stream) throws IOException {
        monitor-enter(this);
        this.mAmbientBrightnessStats.readFromXML(stream);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<AmbientBrightnessDayStats> getUserStats(int userId) {
        monitor-enter(this);
        ArrayList<AmbientBrightnessDayStats> r0 = this.mAmbientBrightnessStats.getUserStats(userId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(PrintWriter pw) {
        monitor-enter(this);
        pw.println("AmbientBrightnessStats:");     // Catch: Throwable -> L6
        pw.print(this.mAmbientBrightnessStats);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
