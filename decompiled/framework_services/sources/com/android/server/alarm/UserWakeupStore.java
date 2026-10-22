package com.android.server.alarm;

import android.os.Environment;
import android.os.SystemClock;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.jobs.FastXmlSerializer;
import com.android.internal.util.jobs.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class UserWakeupStore {
    private static final String ATTR_USER_ID = "user_id";
    private static final String ATTR_VERSION = "version";
    static final long BUFFER_TIME_MS = 0;
    private static final boolean DEBUG = false;
    static final long INITIAL_USER_START_SCHEDULING_DELAY_MS = 0;
    static final String ROOT_DIR_NAME = "alarms";
    private static final String TAG_USER = "user";
    private static final String TAG_USERS = "users";
    static final String USERS_FILE_NAME = "usersWithAlarmClocks.xml";
    static final long USER_START_TIME_DEVIATION_LIMIT_MS = 0;
    private static final File USER_WAKEUP_DIR = null;
    static final String USER_WAKEUP_TAG = null;
    public static final int XML_VERSION_CURRENT = 1;
    private static final Random sRandom = null;
    private Executor mBackgroundExecutor;
    private final SparseLongArray mUserStarts;
    private final Object mUserWakeupLock;

    /* JADX INFO: renamed from: $r8$lambda$RRPL7G24EIHFeMe-T-tGIgJID68, reason: not valid java name */
    public static /* synthetic */ long m1050$r8$lambda$RRPL7G24EIHFeMeTtGIgJID68(Pair r2) {
        return lambda$writeUserIdList$1(r2);
    }

    public static /* synthetic */ void $r8$lambda$RtPOqbDBIOvatsb3ac7h25ScrKA(UserWakeupStore r0) {
        r0.lambda$updateUserListFile$0();
    }

    public static /* synthetic */ void $r8$lambda$pWSHEtk9BW_hVoHWFYf0q0jjP9E(UserWakeupStore r0) {
        r0.readUserIdList();
    }

    public UserWakeupStore() {
        this.mUserWakeupLock = new Object();
        this.mUserStarts = new SparseLongArray();
    }

    static {
        USER_WAKEUP_TAG = UserWakeupStore.class.getSimpleName();
        BUFFER_TIME_MS = TimeUnit.SECONDS.toMillis(30);
        USER_START_TIME_DEVIATION_LIMIT_MS = TimeUnit.SECONDS.toMillis(5);
        INITIAL_USER_START_SCHEDULING_DELAY_MS = TimeUnit.SECONDS.toMillis(5);
        USER_WAKEUP_DIR = new File(Environment.getDataSystemDirectory(), ROOT_DIR_NAME);
        sRandom = new Random(500);
    }

    public void init() {
        this.mBackgroundExecutor = BackgroundThread.getExecutor();
        this.mBackgroundExecutor.execute(new UserWakeupStore$$ExternalSyntheticLambda2(this));
    }

    public void addUserWakeup(int userId, long alarmTime) {
        Object r0 = this.mUserWakeupLock;
        monitor-enter(r0);
        this.mUserStarts.put(userId, (alarmTime - BUFFER_TIME_MS) + getUserWakeupOffset());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateUserListFile();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void removeUserWakeup(int userId) {
        if (deleteWakeupFromUserStarts(userId) == false) goto L6;
        updateUserListFile();
        return;
    }

    public int[] getUserIdsToWakeup(long nowElapsed) {
        Object r0 = this.mUserWakeupLock;
        monitor-enter(r0);
        int[] userIds = new int[this.mUserStarts.size()];     // Catch: Throwable -> L9
        int index = 0;
        int i = this.mUserStarts.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L12;
        if (this.mUserStarts.valueAt(i) > nowElapsed) goto L11;
        userIds[index] = this.mUserStarts.keyAt(i);     // Catch: Throwable -> L9
        index = index + 1;     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        int[] r3 = Arrays.copyOfRange(userIds, 0, index);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    private void updateUserListFile() {
        this.mBackgroundExecutor.execute(new UserWakeupStore$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$updateUserListFile$0() {
        writeUserIdList();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(USER_WAKEUP_TAG, "Failed to write " + e.getLocalizedMessage());
    }

    long getWakeupTimeForUser(int userId) {
        Object r0 = this.mUserWakeupLock;
        monitor-enter(r0);
        long r1 = this.mUserStarts.get(userId, -1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUserStarting(int userId) {
        if (deleteWakeupFromUserStarts(userId) == false) goto L6;
        updateUserListFile();
        return;
    }

    public void onUserRemoved(int userId) {
        if (deleteWakeupFromUserStarts(userId) == false) goto L6;
        updateUserListFile();
        return;
    }

    private boolean deleteWakeupFromUserStarts(int userId) {
        Object r0 = this.mUserWakeupLock;
        monitor-enter(r0);
        int index = this.mUserStarts.indexOfKey(userId);     // Catch: Throwable -> L10
        if (index < 0) goto L12;
        this.mUserStarts.removeAt(index);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public long getNextWakeupTime() {
        long nextWakeupTime = -1;
        Object r2 = this.mUserWakeupLock;
        monitor-enter(r2);
        int i = 0;
    L20:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUserStarts.size()) goto L16;
        if (this.mUserStarts.valueAt(i) >= nextWakeupTime) goto L10;
    L11:
        nextWakeupTime = this.mUserStarts.valueAt(i);     // Catch: Throwable -> L13
    L12:
        i = i + 1;     // Catch: Throwable -> L13
        goto L20
    L10:
        if (nextWakeupTime != (-1)) goto L12;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return nextWakeupTime;
    }

    private static long getUserWakeupOffset() {
        return sRandom.nextLong(USER_START_TIME_DEVIATION_LIMIT_MS * 2) - USER_START_TIME_DEVIATION_LIMIT_MS;
    }

    private void writeUserIdList() {
        AtomicFile file = getUserWakeupFile();
        if (file != null) goto L42;
        return;
    L42:
        FileOutputStream fos = file.startWrite(SystemClock.uptimeMillis());     // Catch: IOException -> L26
        XmlSerializer out = new FastXmlSerializer();     // Catch: Throwable -> L20
        out.setOutput(fos, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L20
        out.startDocument(null, true);     // Catch: Throwable -> L20
        out.startTag(null, "users");     // Catch: Throwable -> L20
        XmlUtils.writeIntAttribute(out, ATTR_VERSION, 1);     // Catch: Throwable -> L20
        List<Pair<Integer, Long>> listOfUsers = new ArrayList();     // Catch: Throwable -> L20
        Object r4 = this.mUserWakeupLock;     // Catch: Throwable -> L20
        monitor-enter(r4);     // Catch: Throwable -> L20
        int i = 0;
    L40:
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L10:
        if (i >= this.mUserStarts.size()) goto L15;
        listOfUsers.add(new Pair(Integer.valueOf(this.mUserStarts.keyAt(i)), Long.valueOf(this.mUserStarts.valueAt(i))));     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L40
    L15:
        monitor-exit(r4);     // Catch: Throwable -> L12
        Collections.sort(listOfUsers, Comparator.comparingLong(new UserWakeupStore$$ExternalSyntheticLambda0()));     // Catch: Throwable -> L20
        int i2 = 0;
    L18:
        if (i2 >= listOfUsers.size()) goto L22;
        out.startTag(null, TAG_USER);     // Catch: Throwable -> L20
        XmlUtils.writeIntAttribute(out, ATTR_USER_ID, ((Integer) listOfUsers.get(i2).first).intValue());     // Catch: Throwable -> L20
        out.endTag(null, TAG_USER);     // Catch: Throwable -> L20
        i2 = i2 + 1;     // Catch: Throwable -> L20
        goto L18
    L22:
        out.endTag(null, "users");     // Catch: Throwable -> L20
        out.endDocument();     // Catch: Throwable -> L20
        file.finishWrite(fos);     // Catch: Throwable -> L20
        if (fos == null) goto L48;
        fos.close();     // Catch: IOException -> L26
        return;
    L48:
        return;
    L20:
        th = move-exception;
        if (fos != null) goto L43;
    L37:
        throw th;     // Catch: IOException -> L26
    L43:
        fos.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        Slog.wtf(USER_WAKEUP_TAG, "Error writing user wakeup data", e);
        file.delete();
    }

    private static /* synthetic */ long lambda$writeUserIdList$1(Pair pair) {
        return ((Long) pair.second).longValue();
    }

    private void readUserIdList() {
        AtomicFile userWakeupFile = getUserWakeupFile();
        if (userWakeupFile != null) goto L6;
        return;
    L6:
        if (userWakeupFile.exists() == true) goto L9;
        Slog.w(USER_WAKEUP_TAG, "User wakeup file not available: " + userWakeupFile.getBaseFile());
        return;
    L9:
        Object r3 = this.mUserWakeupLock;
        monitor-enter(r3);
        this.mUserStarts.clear();     // Catch: Throwable -> L67
        monitor-exit(r3);     // Catch: Throwable -> L67
        FileInputStream fis = userWakeupFile.openRead();     // Catch: Throwable -> L25
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L28
    L16:
        int type = parser.next();     // Catch: Throwable -> L28
        int id = 1;
        int r7 = 2;
        if (type == 2) goto L20;
        if (type != 1) goto L16;
    L20:
        if (type == 2) goto L32;
        Slog.e(USER_WAKEUP_TAG, "Unable to read user list. No start tag found in " + userWakeupFile.getBaseFile());     // Catch: Throwable -> L28
        if (fis == null) goto L27;
        fis.close();     // Catch: Throwable -> L25 Throwable -> L25
        return;
    L27:
        return;
    L32:
        if (parser.getName().equals("users") == false) goto L35;
        int r8 = parser.getAttributeInt(null, ATTR_VERSION, -1);     // Catch: Throwable -> L28
    L35:
        long counter = 0;
        long currentTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        long scheduleOffset = (BUFFER_TIME_MS + currentTime) + getUserWakeupOffset();     // Catch: Throwable -> L28
    L36:
        int type2 = parser.next();     // Catch: Throwable -> L28
        if (type2 == id) goto L55;
        if (type2 != r7) goto L53;
        if (parser.getName().equals(TAG_USER) == false) goto L53;
        int id2 = parser.getAttributeInt(null, ATTR_USER_ID);     // Catch: Throwable -> L28
        Object r9 = this.mUserWakeupLock;     // Catch: Throwable -> L28
        monitor-enter(r9);     // Catch: Throwable -> L28
    L80:
        th = th;
    L51:
        monitor-exit(r9);     // Catch: Throwable -> L50
    L50:
        th = th;
        goto L51
    L52:
        throw th;     // Catch: Throwable -> L28
    L44:
        long counter2 = counter + 1;
        this.mUserStarts.put(id2, (counter * INITIAL_USER_START_SCHEDULING_DELAY_MS) + scheduleOffset);     // Catch: Throwable -> L48
        monitor-exit(r9);     // Catch: Throwable -> L48
        counter = counter2;
        id = 1;
        r7 = 2;
    L48:
        th = th;
    L53:
        id = 1;
        r7 = 2;
        goto L36
    L55:
        if (fis == null) goto L96;
        fis.close();     // Catch: Throwable -> L25 Throwable -> L25
        return;
    L96:
        return;
    L28:
        th = move-exception;
        if (fis == null) goto L93;
        fis.close();     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L25 Throwable -> L25
    L61:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 Throwable -> L25
        throw th;     // Catch: Throwable -> L25 Throwable -> L25
    L93:
        throw th;     // Catch: Throwable -> L25 Throwable -> L25
    L25:
        e = move-exception;
        Slog.wtf(USER_WAKEUP_TAG, "Error reading user wakeup data", e);
        return;
    L67:
        th = move-exception;
        throw th;
    }

    private AtomicFile getUserWakeupFile() {
        if (USER_WAKEUP_DIR.exists() == false) goto L5;
    L8:
        File userFile = new File(USER_WAKEUP_DIR, USERS_FILE_NAME);
        return new AtomicFile(userFile);
    L5:
        if (USER_WAKEUP_DIR.mkdir() == true) goto L8;
        Slog.wtf(USER_WAKEUP_TAG, "Failed to mkdir() user list file: " + USER_WAKEUP_DIR);
        return null;
    }

    void dump(IndentingPrintWriter pw, long nowELAPSED) {
        Object r0 = this.mUserWakeupLock;
        monitor-enter(r0);
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print("User wakeup store file path: ");     // Catch: Throwable -> L7
        AtomicFile file = getUserWakeupFile();     // Catch: Throwable -> L7
        if (file != null) goto L9;
        pw.println("null");     // Catch: Throwable -> L7
    L10:
        pw.println(this.mUserStarts.size() + " user wakeups scheduled: ");     // Catch: Throwable -> L7
        int i = 0;
    L12:
        if (i >= this.mUserStarts.size()) goto L14;
        pw.print("UserId: ");     // Catch: Throwable -> L7
        pw.print(this.mUserStarts.keyAt(i));     // Catch: Throwable -> L7
        pw.print(", userStartTime: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mUserStarts.valueAt(i), nowELAPSED, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L12
    L14:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        pw.println(file.getBaseFile().getAbsolutePath());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
