package com.android.server.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.service.notification.RateEstimator;
import android.text.TextUtils;
import android.util.ArraySet;
import com.android.internal.logging.MetricsLogger;
import com.android.server.alwaysonrecord.RequestHolder;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationUsageStats {
    private static final boolean DEBUG = false;
    private static final String DEVICE_GLOBAL_STATS = "__global";
    private static final long EMIT_PERIOD = 14400000;
    private static final AggregatedStats[] EMPTY_AGGREGATED_STATS = null;
    private static final boolean ENABLE_AGGREGATED_IN_MEMORY_STATS = true;
    public static final int FOUR_HOURS = 14400000;
    private static final int MSG_EMIT = 1;
    private static final String TAG = "NotificationUsageStats";
    public static final int TEN_SECONDS = 10000;
    private final Context mContext;
    private final Handler mHandler;
    private long mLastEmitTime;
    private ArraySet<String> mStatExpiredkeys;
    private final Map<String, AggregatedStats> mStats;
    private final ArrayDeque<AggregatedStats[]> mStatsArrays;

    public static class Aggregate {
        double avg;
        long numSamples;
        double sum2;
        double var;

        public Aggregate() {
        }

        public void addSample(long sample) {
            this.numSamples++;
            double n = this.numSamples;
            double delta = sample - this.avg;
            double divisor = 1.0d;
            this.avg += (1.0d / n) * delta;
            this.sum2 += (((n - 1.0d) / n) * delta) * delta;
            if (this.numSamples == 1) goto L6;
            divisor = n - 1.0d;
        L6:
            this.var = this.sum2 / divisor;
        }

        public String toString() {
            return "Aggregate{numSamples=" + this.numSamples + ", avg=" + this.avg + ", var=" + this.var + '}';
        }
    }

    private static class AggregatedStats {
        public AlertRateLimiter alertRate;
        public RateEstimator enqueueRate;
        public ImportanceHistogram finalImportance;
        public final String key;
        private final Context mContext;
        private final long mCreated;
        public long mLastAccessTime;
        private AggregatedStats mPrevious;
        public ImportanceHistogram noisyImportance;
        public int numAlertViolations;
        public int numAutoCancel;
        public int numBlocked;
        public int numEnqueuedByApp;
        public int numForegroundService;
        public int numImagesRemoved;
        public int numInterrupt;
        public int numOngoing;
        public int numPeopleCacheHit;
        public int numPeopleCacheMiss;
        public int numPostedByApp;
        public int numPrivate;
        public int numQuotaViolations;
        public int numRateViolations;
        public int numRemovedByApp;
        public int numSecret;
        public int numSuspendedByAdmin;
        public int numTooOld;
        public int numUndecoratedRemoteViews;
        public int numUpdatedByApp;
        public int numUserInitiatedJob;
        public int numWithActions;
        public int numWithBigPicture;
        public int numWithBigText;
        public int numWithInbox;
        public int numWithInfoText;
        public int numWithLargeIcon;
        public int numWithMediaSession;
        public int numWithStaredPeople;
        public int numWithSubText;
        public int numWithText;
        public int numWithTitle;
        public int numWithValidPeople;
        public ImportanceHistogram quietImportance;

        /* JADX INFO: renamed from: -$$Nest$fgetmCreated, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m6277$$Nest$fgetmCreated(AggregatedStats r2) {
            return r2.mCreated;
        }

        public AggregatedStats(Context context, String key) {
            this.key = key;
            this.mContext = context;
            this.mCreated = SystemClock.elapsedRealtime();
            this.noisyImportance = new ImportanceHistogram(context, "note_imp_noisy_");
            this.quietImportance = new ImportanceHistogram(context, "note_imp_quiet_");
            this.finalImportance = new ImportanceHistogram(context, "note_importance_");
            this.enqueueRate = new RateEstimator();
            this.alertRate = new AlertRateLimiter();
        }

        public AggregatedStats getPrevious() {
            if (this.mPrevious != null) goto L6;
            this.mPrevious = new AggregatedStats(this.mContext, this.key);
        L6:
            return this.mPrevious;
        }

        public void countApiUse(NotificationRecord record) {
            Notification n = record.getNotification();
            if (n.actions == null) goto L6;
            this.numWithActions++;
        L6:
            if ((n.flags & 64) == 0) goto L9;
            this.numForegroundService++;
        L9:
            if ((n.flags & 32768) == 0) goto L12;
            this.numUserInitiatedJob++;
        L12:
            if ((n.flags & 2) == 0) goto L15;
            this.numOngoing++;
        L15:
            if ((n.flags & 16) == 0) goto L18;
            this.numAutoCancel++;
        L18:
            if ((n.defaults & 1) == 0) goto L20;
        L25:
            this.numInterrupt++;
        L27:
            switch(n.visibility) {
                case -1: goto L30;
                case 0: goto L29;
                default: goto L32;
            };
        L29:
            this.numPrivate++;
            goto L32
        L30:
            this.numSecret++;
        L32:
            if (record.stats.isNoisy == false) goto L34;
            this.noisyImportance.increment(record.stats.requestedImportance);
        L35:
            this.finalImportance.increment(record.getImportance());
            Set<String> names = n.extras.keySet();
            if (names.contains("android.bigText") == false) goto L39;
            this.numWithBigText++;
        L39:
            if (names.contains("android.picture") == false) goto L42;
            this.numWithBigPicture++;
        L42:
            if (names.contains("android.largeIcon") == false) goto L45;
            this.numWithLargeIcon++;
        L45:
            if (names.contains("android.textLines") == false) goto L48;
            this.numWithInbox++;
        L48:
            if (names.contains("android.mediaSession") == false) goto L51;
            this.numWithMediaSession++;
        L51:
            if (names.contains("android.title") == false) goto L56;
            if (TextUtils.isEmpty(n.extras.getCharSequence("android.title")) == true) goto L56;
            this.numWithTitle++;
        L56:
            if (names.contains("android.text") == false) goto L61;
            if (TextUtils.isEmpty(n.extras.getCharSequence("android.text")) == true) goto L61;
            this.numWithText++;
        L61:
            if (names.contains("android.subText") == false) goto L66;
            if (TextUtils.isEmpty(n.extras.getCharSequence("android.subText")) == true) goto L66;
            this.numWithSubText++;
        L66:
            if (names.contains("android.infoText") == true) goto L68;
            return;
        L68:
            if (TextUtils.isEmpty(n.extras.getCharSequence("android.infoText")) == true) goto L72;
            this.numWithInfoText++;
            return;
        L72:
            return;
        L34:
            this.quietImportance.increment(record.stats.requestedImportance);
            goto L35
        L20:
            if ((n.defaults & 2) != 0) goto L25;
            if (n.sound != null) goto L25;
            if (n.vibrate == null) goto L27;
            goto L25
        }

        public void emit() {
            AggregatedStats previous = getPrevious();
            maybeCount("note_enqueued", this.numEnqueuedByApp - previous.numEnqueuedByApp);
            maybeCount("note_post", this.numPostedByApp - previous.numPostedByApp);
            maybeCount("note_update", this.numUpdatedByApp - previous.numUpdatedByApp);
            maybeCount("note_remove", this.numRemovedByApp - previous.numRemovedByApp);
            maybeCount("note_with_people", this.numWithValidPeople - previous.numWithValidPeople);
            maybeCount("note_with_stars", this.numWithStaredPeople - previous.numWithStaredPeople);
            maybeCount("people_cache_hit", this.numPeopleCacheHit - previous.numPeopleCacheHit);
            maybeCount("people_cache_miss", this.numPeopleCacheMiss - previous.numPeopleCacheMiss);
            maybeCount("note_blocked", this.numBlocked - previous.numBlocked);
            maybeCount("note_suspended", this.numSuspendedByAdmin - previous.numSuspendedByAdmin);
            maybeCount("note_with_actions", this.numWithActions - previous.numWithActions);
            maybeCount("note_private", this.numPrivate - previous.numPrivate);
            maybeCount("note_secret", this.numSecret - previous.numSecret);
            maybeCount("note_interupt", this.numInterrupt - previous.numInterrupt);
            maybeCount("note_big_text", this.numWithBigText - previous.numWithBigText);
            maybeCount("note_big_pic", this.numWithBigPicture - previous.numWithBigPicture);
            maybeCount("note_fg", this.numForegroundService - previous.numForegroundService);
            maybeCount("note_uij", this.numUserInitiatedJob - previous.numUserInitiatedJob);
            maybeCount("note_ongoing", this.numOngoing - previous.numOngoing);
            maybeCount("note_auto", this.numAutoCancel - previous.numAutoCancel);
            maybeCount("note_large_icon", this.numWithLargeIcon - previous.numWithLargeIcon);
            maybeCount("note_inbox", this.numWithInbox - previous.numWithInbox);
            maybeCount("note_media", this.numWithMediaSession - previous.numWithMediaSession);
            maybeCount("note_title", this.numWithTitle - previous.numWithTitle);
            maybeCount("note_text", this.numWithText - previous.numWithText);
            maybeCount("note_sub_text", this.numWithSubText - previous.numWithSubText);
            maybeCount("note_info_text", this.numWithInfoText - previous.numWithInfoText);
            maybeCount("note_over_rate", this.numRateViolations - previous.numRateViolations);
            maybeCount("note_over_alert_rate", this.numAlertViolations - previous.numAlertViolations);
            maybeCount("note_over_quota", this.numQuotaViolations - previous.numQuotaViolations);
            maybeCount("note_images_removed", this.numImagesRemoved - previous.numImagesRemoved);
            maybeCount("not_too_old", this.numTooOld - previous.numTooOld);
            this.noisyImportance.maybeCount(previous.noisyImportance);
            this.quietImportance.maybeCount(previous.quietImportance);
            this.finalImportance.maybeCount(previous.finalImportance);
            previous.numEnqueuedByApp = this.numEnqueuedByApp;
            previous.numPostedByApp = this.numPostedByApp;
            previous.numUpdatedByApp = this.numUpdatedByApp;
            previous.numRemovedByApp = this.numRemovedByApp;
            previous.numPeopleCacheHit = this.numPeopleCacheHit;
            previous.numPeopleCacheMiss = this.numPeopleCacheMiss;
            previous.numWithStaredPeople = this.numWithStaredPeople;
            previous.numWithValidPeople = this.numWithValidPeople;
            previous.numBlocked = this.numBlocked;
            previous.numSuspendedByAdmin = this.numSuspendedByAdmin;
            previous.numWithActions = this.numWithActions;
            previous.numPrivate = this.numPrivate;
            previous.numSecret = this.numSecret;
            previous.numInterrupt = this.numInterrupt;
            previous.numWithBigText = this.numWithBigText;
            previous.numWithBigPicture = this.numWithBigPicture;
            previous.numForegroundService = this.numForegroundService;
            previous.numUserInitiatedJob = this.numUserInitiatedJob;
            previous.numOngoing = this.numOngoing;
            previous.numAutoCancel = this.numAutoCancel;
            previous.numWithLargeIcon = this.numWithLargeIcon;
            previous.numWithInbox = this.numWithInbox;
            previous.numWithMediaSession = this.numWithMediaSession;
            previous.numWithTitle = this.numWithTitle;
            previous.numWithText = this.numWithText;
            previous.numWithSubText = this.numWithSubText;
            previous.numWithInfoText = this.numWithInfoText;
            previous.numRateViolations = this.numRateViolations;
            previous.numAlertViolations = this.numAlertViolations;
            previous.numQuotaViolations = this.numQuotaViolations;
            previous.numImagesRemoved = this.numImagesRemoved;
            previous.numTooOld = this.numTooOld;
            this.noisyImportance.update(previous.noisyImportance);
            this.quietImportance.update(previous.quietImportance);
            this.finalImportance.update(previous.finalImportance);
        }

        void maybeCount(String name, int value) {
            if (value <= 0) goto L5;
            MetricsLogger.count(this.mContext, name, value);
            return;
        }

        public void dump(PrintWriter pw, String indent) {
            pw.println(toStringWithIndent(indent));
        }

        public String toString() {
            return toStringWithIndent("");
        }

        public float getEnqueueRate() {
            return getEnqueueRate(SystemClock.elapsedRealtime());
        }

        public float getEnqueueRate(long now) {
            return this.enqueueRate.getRate(now);
        }

        public void updateInterarrivalEstimate(long now) {
            this.enqueueRate.update(now);
        }

        public boolean isAlertRateLimited() {
            boolean limited = this.alertRate.shouldRateLimitAlert(SystemClock.elapsedRealtime());
            if (limited == false) goto L5;
            this.numAlertViolations++;
        L5:
            return limited;
        }

        private String toStringWithIndent(String indent) {
            StringBuilder output = new StringBuilder();
            output.append(indent);
            output.append("AggregatedStats{\n");
            String indentPlusTwo = indent + "  ";
            output.append(indentPlusTwo);
            output.append("key='");
            output.append(this.key);
            output.append("',\n");
            output.append(indentPlusTwo);
            output.append("numEnqueuedByApp=");
            output.append(this.numEnqueuedByApp);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numPostedByApp=");
            output.append(this.numPostedByApp);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numUpdatedByApp=");
            output.append(this.numUpdatedByApp);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numRemovedByApp=");
            output.append(this.numRemovedByApp);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numPeopleCacheHit=");
            output.append(this.numPeopleCacheHit);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numWithStaredPeople=");
            output.append(this.numWithStaredPeople);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numWithValidPeople=");
            output.append(this.numWithValidPeople);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numPeopleCacheMiss=");
            output.append(this.numPeopleCacheMiss);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numBlocked=");
            output.append(this.numBlocked);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numSuspendedByAdmin=");
            output.append(this.numSuspendedByAdmin);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numWithActions=");
            output.append(this.numWithActions);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numPrivate=");
            output.append(this.numPrivate);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numSecret=");
            output.append(this.numSecret);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numInterrupt=");
            output.append(this.numInterrupt);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numWithBigText=");
            output.append(this.numWithBigText);
            output.append(",\n");
            output.append(indentPlusTwo);
            output.append("numWithBigPicture=");
            output.append(this.numWithBigPicture);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numForegroundService=");
            output.append(this.numForegroundService);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numUserInitiatedJob=");
            output.append(this.numUserInitiatedJob);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numOngoing=");
            output.append(this.numOngoing);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numAutoCancel=");
            output.append(this.numAutoCancel);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithLargeIcon=");
            output.append(this.numWithLargeIcon);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithInbox=");
            output.append(this.numWithInbox);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithMediaSession=");
            output.append(this.numWithMediaSession);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithTitle=");
            output.append(this.numWithTitle);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithText=");
            output.append(this.numWithText);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithSubText=");
            output.append(this.numWithSubText);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numWithInfoText=");
            output.append(this.numWithInfoText);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numRateViolations=");
            output.append(this.numRateViolations);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numAlertViolations=");
            output.append(this.numAlertViolations);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numQuotaViolations=");
            output.append(this.numQuotaViolations);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numImagesRemoved=");
            output.append(this.numImagesRemoved);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numTooOld=");
            output.append(this.numTooOld);
            output.append("\n");
            output.append(indentPlusTwo);
            output.append(this.noisyImportance.toString());
            output.append("\n");
            output.append(indentPlusTwo);
            output.append(this.quietImportance.toString());
            output.append("\n");
            output.append(indentPlusTwo);
            output.append(this.finalImportance.toString());
            output.append("\n");
            output.append(indentPlusTwo);
            output.append("numUndecorateRVs=");
            output.append(this.numUndecoratedRemoteViews);
            output.append("\n");
            output.append(indent);
            output.append("}");
            return output.toString();
        }

        public JSONObject dumpJson() throws JSONException {
            AggregatedStats previous = getPrevious();
            JSONObject dump = new JSONObject();
            dump.put("key", this.key);
            dump.put(RequestHolder.KEY_DURATION, SystemClock.elapsedRealtime() - this.mCreated);
            maybePut(dump, "numEnqueuedByApp", this.numEnqueuedByApp);
            maybePut(dump, "numPostedByApp", this.numPostedByApp);
            maybePut(dump, "numUpdatedByApp", this.numUpdatedByApp);
            maybePut(dump, "numRemovedByApp", this.numRemovedByApp);
            maybePut(dump, "numPeopleCacheHit", this.numPeopleCacheHit);
            maybePut(dump, "numPeopleCacheMiss", this.numPeopleCacheMiss);
            maybePut(dump, "numWithStaredPeople", this.numWithStaredPeople);
            maybePut(dump, "numWithValidPeople", this.numWithValidPeople);
            maybePut(dump, "numBlocked", this.numBlocked);
            maybePut(dump, "numSuspendedByAdmin", this.numSuspendedByAdmin);
            maybePut(dump, "numWithActions", this.numWithActions);
            maybePut(dump, "numPrivate", this.numPrivate);
            maybePut(dump, "numSecret", this.numSecret);
            maybePut(dump, "numInterrupt", this.numInterrupt);
            maybePut(dump, "numWithBigText", this.numWithBigText);
            maybePut(dump, "numWithBigPicture", this.numWithBigPicture);
            maybePut(dump, "numForegroundService", this.numForegroundService);
            maybePut(dump, "numUserInitiatedJob", this.numUserInitiatedJob);
            maybePut(dump, "numOngoing", this.numOngoing);
            maybePut(dump, "numAutoCancel", this.numAutoCancel);
            maybePut(dump, "numWithLargeIcon", this.numWithLargeIcon);
            maybePut(dump, "numWithInbox", this.numWithInbox);
            maybePut(dump, "numWithMediaSession", this.numWithMediaSession);
            maybePut(dump, "numWithTitle", this.numWithTitle);
            maybePut(dump, "numWithText", this.numWithText);
            maybePut(dump, "numWithSubText", this.numWithSubText);
            maybePut(dump, "numWithInfoText", this.numWithInfoText);
            maybePut(dump, "numRateViolations", this.numRateViolations);
            maybePut(dump, "numQuotaLViolations", this.numQuotaViolations);
            maybePut(dump, "notificationEnqueueRate", getEnqueueRate());
            maybePut(dump, "numAlertViolations", this.numAlertViolations);
            maybePut(dump, "numImagesRemoved", this.numImagesRemoved);
            maybePut(dump, "numTooOld", this.numTooOld);
            this.noisyImportance.maybePut(dump, previous.noisyImportance);
            this.quietImportance.maybePut(dump, previous.quietImportance);
            this.finalImportance.maybePut(dump, previous.finalImportance);
            return dump;
        }

        private void maybePut(JSONObject dump, String name, int value) throws JSONException {
            if (value <= 0) goto L5;
            dump.put(name, value);
            return;
        }

        private void maybePut(JSONObject dump, String name, float value) throws JSONException {
            if (value <= 0.0d) goto L6;
            dump.put(name, value);
            return;
        }
    }

    private static class ImportanceHistogram {
        private static final String[] IMPORTANCE_NAMES = null;
        private static final int NUM_IMPORTANCES = 6;
        private final Context mContext;
        private int[] mCount;
        private final String[] mCounterNames;
        private final String mPrefix;

        static {
            IMPORTANCE_NAMES = new String[]{"none", "min", "low", "default", "high", "max"};
        }

        ImportanceHistogram(Context context, String prefix) {
            this.mContext = context;
            this.mCount = new int[6];
            this.mCounterNames = new String[6];
            this.mPrefix = prefix;
            int i = 0;
        L3:
            if (i >= 6) goto L6;
            this.mCounterNames[i] = this.mPrefix + IMPORTANCE_NAMES[i];
            i = i + 1;
            goto L3
        }

        void increment(int imp) {
            int imp2 = Math.max(0, Math.min(imp, this.mCount.length - 1));
            int[] r0 = this.mCount;
            r0[imp2] = r0[imp2] + 1;
        }

        void maybeCount(ImportanceHistogram prev) {
            int i = 0;
        L4:
            if (i >= 6) goto L10;
            int value = this.mCount[i] - prev.mCount[i];
            if (value <= 0) goto L8;
            MetricsLogger.count(this.mContext, this.mCounterNames[i], value);
        L8:
            i = i + 1;
            goto L4
        }

        void update(ImportanceHistogram that) {
            int i = 0;
        L4:
            if (i >= 6) goto L7;
            this.mCount[i] = that.mCount[i];
            i = i + 1;
            goto L4
        }

        public void maybePut(JSONObject dump, ImportanceHistogram prev) throws JSONException {
            dump.put(this.mPrefix, new JSONArray(this.mCount));
        }

        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(this.mPrefix);
            output.append(": [");
            int i = 0;
        L4:
            if (i >= 6) goto L9;
            output.append(this.mCount[i]);
            if (i >= 5) goto L8;
            output.append(", ");
        L8:
            i = i + 1;
            goto L4
        L9:
            output.append("]");
            return output.toString();
        }
    }

    public static class SingleNotificationStats {
        public long airtimeCount;
        public long airtimeExpandedMs;
        public long airtimeMs;
        public long currentAirtimeExpandedStartElapsedMs;
        public long currentAirtimeStartElapsedMs;
        private boolean isExpanded;
        public boolean isNoisy;
        private boolean isVisible;
        public int naturalImportance;
        public long posttimeElapsedMs;
        public long posttimeToDismissMs;
        public long posttimeToFirstAirtimeMs;
        public long posttimeToFirstClickMs;
        public long posttimeToFirstVisibleExpansionMs;
        public int requestedImportance;
        public long userExpansionCount;

        public SingleNotificationStats() {
            this.isVisible = false;
            this.isExpanded = false;
            this.posttimeElapsedMs = -1;
            this.posttimeToFirstClickMs = -1;
            this.posttimeToDismissMs = -1;
            this.airtimeCount = 0;
            this.posttimeToFirstAirtimeMs = -1;
            this.currentAirtimeStartElapsedMs = -1;
            this.airtimeMs = 0;
            this.posttimeToFirstVisibleExpansionMs = -1;
            this.currentAirtimeExpandedStartElapsedMs = -1;
            this.airtimeExpandedMs = 0;
            this.userExpansionCount = 0;
        }

        public long getCurrentPosttimeMs() {
            if (this.posttimeElapsedMs >= 0) goto L6;
            return 0;
        L6:
            return SystemClock.elapsedRealtime() - this.posttimeElapsedMs;
        }

        public long getCurrentAirtimeMs() {
            long result = this.airtimeMs;
            if (this.currentAirtimeStartElapsedMs >= 0) goto L5;
            return result;
        L5:
            return result + (SystemClock.elapsedRealtime() - this.currentAirtimeStartElapsedMs);
        }

        public long getCurrentAirtimeExpandedMs() {
            long result = this.airtimeExpandedMs;
            if (this.currentAirtimeExpandedStartElapsedMs >= 0) goto L5;
            return result;
        L5:
            return result + (SystemClock.elapsedRealtime() - this.currentAirtimeExpandedStartElapsedMs);
        }

        public void onClick() {
            if (this.posttimeToFirstClickMs >= 0) goto L6;
            this.posttimeToFirstClickMs = SystemClock.elapsedRealtime() - this.posttimeElapsedMs;
            return;
        }

        public void onDismiss() {
            if (this.posttimeToDismissMs >= 0) goto L5;
            this.posttimeToDismissMs = SystemClock.elapsedRealtime() - this.posttimeElapsedMs;
        L5:
            finish();
        }

        public void onCancel() {
            finish();
        }

        public void onRemoved() {
            finish();
        }

        public void onVisibilityChanged(boolean visible) {
            long elapsedNowMs = SystemClock.elapsedRealtime();
            boolean wasVisible = this.isVisible;
            this.isVisible = visible;
            if (visible == false) goto L11;
            if (this.currentAirtimeStartElapsedMs >= 0) goto L8;
            this.airtimeCount++;
            this.currentAirtimeStartElapsedMs = elapsedNowMs;
        L8:
            if (this.posttimeToFirstAirtimeMs >= 0) goto L14;
            this.posttimeToFirstAirtimeMs = elapsedNowMs - this.posttimeElapsedMs;
        L14:
            if (wasVisible == this.isVisible) goto L17;
            updateVisiblyExpandedStats();
            return;
        L17:
            return;
        L11:
            if (this.currentAirtimeStartElapsedMs < 0) goto L14;
            this.airtimeMs += elapsedNowMs - this.currentAirtimeStartElapsedMs;
            this.currentAirtimeStartElapsedMs = -1;
            goto L14
        }

        public void onExpansionChanged(boolean userAction, boolean expanded) {
            this.isExpanded = expanded;
            if (this.isExpanded == false) goto L6;
            if (userAction == false) goto L6;
            this.userExpansionCount++;
        L6:
            updateVisiblyExpandedStats();
        }

        public boolean hasBeenVisiblyExpanded() {
            if (this.posttimeToFirstVisibleExpansionMs < 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void updateVisiblyExpandedStats() {
            long elapsedNowMs = SystemClock.elapsedRealtime();
            if (this.isExpanded == false) goto L13;
            if (this.isVisible == false) goto L13;
            if (this.currentAirtimeExpandedStartElapsedMs >= 0) goto L10;
            this.currentAirtimeExpandedStartElapsedMs = elapsedNowMs;
        L10:
            if (this.posttimeToFirstVisibleExpansionMs >= 0) goto L16;
            this.posttimeToFirstVisibleExpansionMs = elapsedNowMs - this.posttimeElapsedMs;
            return;
        L16:
            return;
        L13:
            if (this.currentAirtimeExpandedStartElapsedMs < 0) goto L18;
            this.airtimeExpandedMs += elapsedNowMs - this.currentAirtimeExpandedStartElapsedMs;
            this.currentAirtimeExpandedStartElapsedMs = -1;
            return;
        }

        public void finish() {
            onVisibilityChanged(false);
        }

        public String toString() {
            return "SingleNotificationStats{posttimeElapsedMs=" + this.posttimeElapsedMs + ", posttimeToFirstClickMs=" + this.posttimeToFirstClickMs + ", posttimeToDismissMs=" + this.posttimeToDismissMs + ", airtimeCount=" + this.airtimeCount + ", airtimeMs=" + this.airtimeMs + ", currentAirtimeStartElapsedMs=" + this.currentAirtimeStartElapsedMs + ", airtimeExpandedMs=" + this.airtimeExpandedMs + ", posttimeToFirstVisibleExpansionMs=" + this.posttimeToFirstVisibleExpansionMs + ", currentAirtimeExpandedStartElapsedMs=" + this.currentAirtimeExpandedStartElapsedMs + ", requestedImportance=" + this.requestedImportance + ", naturalImportance=" + this.naturalImportance + ", isNoisy=" + this.isNoisy + '}';
        }

        public void updateFrom(SingleNotificationStats old) {
            this.posttimeElapsedMs = old.posttimeElapsedMs;
            this.posttimeToFirstClickMs = old.posttimeToFirstClickMs;
            this.airtimeCount = old.airtimeCount;
            this.posttimeToFirstAirtimeMs = old.posttimeToFirstAirtimeMs;
            this.currentAirtimeStartElapsedMs = old.currentAirtimeStartElapsedMs;
            this.airtimeMs = old.airtimeMs;
            this.posttimeToFirstVisibleExpansionMs = old.posttimeToFirstVisibleExpansionMs;
            this.currentAirtimeExpandedStartElapsedMs = old.currentAirtimeExpandedStartElapsedMs;
            this.airtimeExpandedMs = old.airtimeExpandedMs;
            this.userExpansionCount = old.userExpansionCount;
        }
    }

    static {
        EMPTY_AGGREGATED_STATS = new AggregatedStats[0];
    }

    public NotificationUsageStats(Context context) {
        this.mStats = new HashMap();
        this.mStatsArrays = new ArrayDeque();
        this.mStatExpiredkeys = new ArraySet();
        this.mContext = context;
        this.mLastEmitTime = SystemClock.elapsedRealtime();
        final Looper r1 = this.mContext.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mHandler.sendEmptyMessageDelayed(1, 14400000);
    }

    public synchronized float getAppEnqueueRate(String packageName) {
        monitor-enter(this);
        AggregatedStats stats = getOrCreateAggregatedStatsLocked(packageName);     // Catch: Throwable -> L6
        float r1 = stats.getEnqueueRate(SystemClock.elapsedRealtime());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isAlertRateLimited(String packageName) {
        monitor-enter(this);
        AggregatedStats stats = getOrCreateAggregatedStatsLocked(packageName);     // Catch: Throwable -> L6
        boolean r1 = stats.isAlertRateLimited();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerEnqueuedByApp(String packageName) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(packageName);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numEnqueuedByApp++;     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerEnqueuedByAppAndAccepted(String packageName) {
        monitor-enter(this);
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(packageName);     // Catch: Throwable -> L6
        int r3 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r4];     // Catch: Throwable -> L6
        stats.updateInterarrivalEstimate(now);     // Catch: Throwable -> L6
        r4 = r4 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerPostedByApp(NotificationRecord notification) {
        monitor-enter(this);
        notification.stats.posttimeElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L10
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L12;
        AggregatedStats stats = aggregatedStatsArray[r3];     // Catch: Throwable -> L10
        int r6 = 1;
        stats.numPostedByApp++;     // Catch: Throwable -> L10
        stats.countApiUse(notification);     // Catch: Throwable -> L10
        int r5 = stats.numUndecoratedRemoteViews;     // Catch: Throwable -> L10
        if (notification.hasUndecoratedRemoteView() == true) goto L9;
        r6 = 0;
    L9:
        stats.numUndecoratedRemoteViews = r5 + r6;     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L4
    L12:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void registerUpdatedByApp(NotificationRecord notification, NotificationRecord old) {
        monitor-enter(this);
        notification.stats.updateFrom(old.stats);     // Catch: Throwable -> L6
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numUpdatedByApp++;     // Catch: Throwable -> L6
        stats.countApiUse(notification);     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerRemovedByApp(NotificationRecord notification) {
        monitor-enter(this);
        notification.stats.onRemoved();     // Catch: Throwable -> L6
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numRemovedByApp++;     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerDismissedByUser(NotificationRecord notification) {
        monitor-enter(this);
        MetricsLogger.histogram(this.mContext, "note_dismiss_longevity", ((int) (System.currentTimeMillis() - notification.getRankingTimeMs())) / 60000);     // Catch: Throwable -> L6
        notification.stats.onDismiss();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerClickedByUser(NotificationRecord notification) {
        monitor-enter(this);
        MetricsLogger.histogram(this.mContext, "note_click_longevity", ((int) (System.currentTimeMillis() - notification.getRankingTimeMs())) / 60000);     // Catch: Throwable -> L6
        notification.stats.onClick();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerPeopleAffinity(NotificationRecord notification, boolean valid, boolean starred, boolean cached) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L8
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L8
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L16;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L8
        if (valid == false) goto L10;
        stats.numWithValidPeople++;     // Catch: Throwable -> L8
    L10:
        if (starred == false) goto L12;
        stats.numWithStaredPeople++;     // Catch: Throwable -> L8
    L12:
        if (cached == false) goto L14;
        stats.numPeopleCacheHit++;     // Catch: Throwable -> L8
    L15:
        r2 = r2 + 1;     // Catch: Throwable -> L8
        goto L4
    L14:
        stats.numPeopleCacheMiss++;     // Catch: Throwable -> L8
        goto L15
    L16:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void registerBlocked(NotificationRecord notification) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numBlocked++;     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerSuspendedByAdmin(NotificationRecord notification) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numSuspendedByAdmin++;     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerOverRateQuota(String packageName) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(packageName);     // Catch: Throwable -> L7
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L7
        stats.numRateViolations++;     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void registerOverCountQuota(String packageName) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(packageName);     // Catch: Throwable -> L7
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L7
        stats.numQuotaViolations++;     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void registerImageRemoved(String packageName) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(packageName);     // Catch: Throwable -> L7
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L7
        stats.numImagesRemoved++;     // Catch: Throwable -> L7
        r2 = r2 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void registerTooOldBlocked(NotificationRecord notification) {
        monitor-enter(this);
        AggregatedStats[] aggregatedStatsArray = getAggregatedStatsLocked(notification);     // Catch: Throwable -> L6
        int r1 = aggregatedStatsArray.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        AggregatedStats stats = aggregatedStatsArray[r2];     // Catch: Throwable -> L6
        stats.numTooOld++;     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        releaseAggregatedStatsLocked(aggregatedStatsArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private AggregatedStats[] getAggregatedStatsLocked(NotificationRecord record) {
        return getAggregatedStatsLocked(record.getSbn().getPackageName());
    }

    private AggregatedStats[] getAggregatedStatsLocked(String packageName) {
        AggregatedStats[] array = this.mStatsArrays.poll();
        if (array != null) goto L5;
        array = new AggregatedStats[2];
    L5:
        array[0] = getOrCreateAggregatedStatsLocked(DEVICE_GLOBAL_STATS);
        array[1] = getOrCreateAggregatedStatsLocked(packageName);
        return array;
    }

    private void releaseAggregatedStatsLocked(AggregatedStats[] array) {
        int i = 0;
    L4:
        if (i >= array.length) goto L6;
        array[i] = null;
        i = i + 1;
        goto L4
    L6:
        this.mStatsArrays.offer(array);
    }

    private AggregatedStats getOrCreateAggregatedStatsLocked(String key) {
        AggregatedStats result = this.mStats.get(key);
        if (result != null) goto L5;
        result = new AggregatedStats(this.mContext, key);
        this.mStats.put(key, result);
    L5:
        result.mLastAccessTime = SystemClock.elapsedRealtime();
        return result;
    }

    public synchronized JSONObject dumpJson(NotificationManagerService.DumpFilter filter) {
        monitor-enter(this);
        JSONObject dump = new JSONObject();     // Catch: Throwable -> L12
        JSONArray aggregatedStats = new JSONArray();     // Catch: Throwable -> L12 JSONException -> L14
        Iterator<AggregatedStats> r2 = this.mStats.values().iterator();     // Catch: Throwable -> L12 JSONException -> L14
    L6:
        if (r2.hasNext() == false) goto L17;
        AggregatedStats as = r2.next();     // Catch: Throwable -> L12 JSONException -> L14
        if (filter == null) goto L16;
        if (filter.matches(as.key) == false) goto L6;
    L16:
        aggregatedStats.put(as.dumpJson());     // Catch: Throwable -> L12 JSONException -> L14
        goto L6
    L17:
        dump.put("current", aggregatedStats);     // Catch: Throwable -> L12 JSONException -> L14
    L18:
        monitor-exit(this);
        return dump;
    L12:
        th = move-exception;
        throw th;
    }

    public PulledStats remoteViewStats(long startMs, boolean aggregate) {
        PulledStats stats = new PulledStats(startMs);
        Iterator<AggregatedStats> r1 = this.mStats.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AggregatedStats as = r1.next();
        if (as.numUndecoratedRemoteViews <= 0) goto L4;
        stats.addUndecoratedPackage(as.key, AggregatedStats.m6277$$Nest$fgetmCreated(as));
        goto L4
    L9:
        return stats;
    }

    public synchronized void dump(PrintWriter pw, String indent, NotificationManagerService.DumpFilter filter) {
        monitor-enter(this);
        Iterator<AggregatedStats> r0 = this.mStats.values().iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L14;
        AggregatedStats as = r0.next();     // Catch: Throwable -> L11
        if (filter == null) goto L13;
        if (filter.matches(as.key) == false) goto L5;
    L13:
        as.dump(pw, indent);     // Catch: Throwable -> L11
        goto L5
    L14:
        pw.println(indent + "mStatsArrays.size(): " + this.mStatsArrays.size());     // Catch: Throwable -> L11
        pw.println(indent + "mStats.size(): " + this.mStats.size());     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void emit() {
        monitor-enter(this);
        AggregatedStats stats = getOrCreateAggregatedStatsLocked(DEVICE_GLOBAL_STATS);     // Catch: Throwable -> L9
        stats.emit();     // Catch: Throwable -> L9
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L9
        this.mHandler.sendEmptyMessageDelayed(1, 14400000);     // Catch: Throwable -> L9
        Iterator<String> r1 = this.mStats.keySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L12;
        String key = r1.next();     // Catch: Throwable -> L9
        if (this.mStats.get(key).mLastAccessTime >= this.mLastEmitTime) goto L5;
        this.mStatExpiredkeys.add(key);     // Catch: Throwable -> L9
        goto L5
    L12:
        Iterator<String> r2 = this.mStatExpiredkeys.iterator();     // Catch: Throwable -> L9
    L14:
        if (r2.hasNext() == false) goto L16;
        String key2 = r2.next();     // Catch: Throwable -> L9
        this.mStats.remove(key2);     // Catch: Throwable -> L9
        goto L14
    L16:
        this.mStatExpiredkeys.clear();     // Catch: Throwable -> L9
        this.mLastEmitTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
