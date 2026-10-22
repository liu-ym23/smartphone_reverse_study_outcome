package com.android.server.notification;

import android.app.NotificationHistory;
import android.os.Handler;
import android.util.AtomicFile;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHistoryDatabase {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_CURRENT_VERSION = 1;
    private static final int HISTORY_RETENTION_DAYS = 1;
    private static final long INVALID_FILE_TIME_MS = -1;
    private static final String TAG = "NotiHistoryDatabase";
    private static final long WRITE_BUFFER_INTERVAL_MS = 1200000;
    NotificationHistory mBuffer;
    private int mCurrentVersion;
    private final Handler mFileWriteHandler;
    private final File mHistoryDir;
    final List<AtomicFile> mHistoryFiles;
    private final Object mLock;
    private final File mVersionFile;
    private final WriteBufferRunnable mWriteBufferRunnable;

    final class RemoveChannelRunnable implements Runnable {
        private String mChannelId;
        private NotificationHistory mNotificationHistory;
        private String mPkg;
        final /* synthetic */ NotificationHistoryDatabase this$0;

        RemoveChannelRunnable(NotificationHistoryDatabase this$0, String pkg, String channelId) {
            this.this$0 = this$0;
            this.mPkg = pkg;
            this.mChannelId = channelId;
        }

        void setNotificationHistory(NotificationHistory nh) {
            this.mNotificationHistory = nh;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationHistoryDatabase.m6115$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(NotificationHistoryDatabase.TAG, "RemoveChannelRunnable");
        L5:
            Object r0 = NotificationHistoryDatabase.m6113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mBuffer.removeChannelFromWrite(this.mPkg, this.mChannelId);     // Catch: Throwable -> L14
            Iterator<AtomicFile> historyFileItr = this.this$0.mHistoryFiles.iterator();     // Catch: Throwable -> L14
        L9:
            if (historyFileItr.hasNext() == false) goto L27;
            AtomicFile af = historyFileItr.next();     // Catch: Throwable -> L14
            if (this.mNotificationHistory == null) goto L18;
            NotificationHistory notificationHistory = this.mNotificationHistory;     // Catch: Throwable -> L14 Exception -> L16
        L19:
            NotificationHistoryDatabase.m6116$$Nest$smreadLocked(af, notificationHistory, new NotificationHistoryFilter.Builder().build());     // Catch: Throwable -> L14 Exception -> L16
            if (notificationHistory.removeChannelFromWrite(this.mPkg, this.mChannelId) == false) goto L9;
            NotificationHistoryDatabase.m6114$$Nest$mwriteLocked(this.this$0, af, notificationHistory);     // Catch: Throwable -> L14 Exception -> L16
            goto L9
        L18:
            notificationHistory = new NotificationHistory();     // Catch: Throwable -> L14 Exception -> L16
            goto L19
        L16:
            e = move-exception;
            Slog.e(NotificationHistoryDatabase.TAG, "Cannot clean up file on channel removal " + af.getBaseFile().getName(), e);     // Catch: Throwable -> L14
            goto L9
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    final class RemoveConversationRunnable implements Runnable {
        private Set<String> mConversationIds;
        private NotificationHistory mNotificationHistory;
        private String mPkg;
        final /* synthetic */ NotificationHistoryDatabase this$0;

        public RemoveConversationRunnable(NotificationHistoryDatabase this$0, String pkg, Set<String> conversationIds) {
            this.this$0 = this$0;
            this.mPkg = pkg;
            this.mConversationIds = conversationIds;
        }

        void setNotificationHistory(NotificationHistory nh) {
            this.mNotificationHistory = nh;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationHistoryDatabase.m6115$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(NotificationHistoryDatabase.TAG, "RemoveConversationRunnable " + this.mPkg + " " + this.mConversationIds);
        L5:
            Object r0 = NotificationHistoryDatabase.m6113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mBuffer.removeConversationsFromWrite(this.mPkg, this.mConversationIds);     // Catch: Throwable -> L14
            Iterator<AtomicFile> historyFileItr = this.this$0.mHistoryFiles.iterator();     // Catch: Throwable -> L14
        L9:
            if (historyFileItr.hasNext() == false) goto L27;
            AtomicFile af = historyFileItr.next();     // Catch: Throwable -> L14
            if (this.mNotificationHistory == null) goto L18;
            NotificationHistory notificationHistory = this.mNotificationHistory;     // Catch: Throwable -> L14 Exception -> L16
        L19:
            NotificationHistoryDatabase.m6116$$Nest$smreadLocked(af, notificationHistory, new NotificationHistoryFilter.Builder().build());     // Catch: Throwable -> L14 Exception -> L16
            if (notificationHistory.removeConversationsFromWrite(this.mPkg, this.mConversationIds) == false) goto L9;
            NotificationHistoryDatabase.m6114$$Nest$mwriteLocked(this.this$0, af, notificationHistory);     // Catch: Throwable -> L14 Exception -> L16
            goto L9
        L18:
            notificationHistory = new NotificationHistory();     // Catch: Throwable -> L14 Exception -> L16
            goto L19
        L16:
            e = move-exception;
            Slog.e(NotificationHistoryDatabase.TAG, "Cannot clean up file on conversation removal " + af.getBaseFile().getName(), e);     // Catch: Throwable -> L14
            goto L9
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    final class RemoveNotificationRunnable implements Runnable {
        private NotificationHistory mNotificationHistory;
        private String mPkg;
        private long mPostedTime;
        final /* synthetic */ NotificationHistoryDatabase this$0;

        public RemoveNotificationRunnable(NotificationHistoryDatabase this$0, String pkg, long postedTime) {
            this.this$0 = this$0;
            this.mPkg = pkg;
            this.mPostedTime = postedTime;
        }

        void setNotificationHistory(NotificationHistory nh) {
            this.mNotificationHistory = nh;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationHistoryDatabase.m6115$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(NotificationHistoryDatabase.TAG, "RemoveNotificationRunnable");
        L5:
            Object r0 = NotificationHistoryDatabase.m6113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mBuffer.removeNotificationFromWrite(this.mPkg, this.mPostedTime);     // Catch: Throwable -> L14
            Iterator<AtomicFile> historyFileItr = this.this$0.mHistoryFiles.iterator();     // Catch: Throwable -> L14
        L9:
            if (historyFileItr.hasNext() == false) goto L27;
            AtomicFile af = historyFileItr.next();     // Catch: Throwable -> L14
            if (this.mNotificationHistory == null) goto L18;
            NotificationHistory notificationHistory = this.mNotificationHistory;     // Catch: Throwable -> L14 Exception -> L16
        L19:
            NotificationHistoryDatabase.m6116$$Nest$smreadLocked(af, notificationHistory, new NotificationHistoryFilter.Builder().build());     // Catch: Throwable -> L14 Exception -> L16
            if (notificationHistory.removeNotificationFromWrite(this.mPkg, this.mPostedTime) == false) goto L9;
            NotificationHistoryDatabase.m6114$$Nest$mwriteLocked(this.this$0, af, notificationHistory);     // Catch: Throwable -> L14 Exception -> L16
            goto L9
        L18:
            notificationHistory = new NotificationHistory();     // Catch: Throwable -> L14 Exception -> L16
            goto L19
        L16:
            e = move-exception;
            Slog.e(NotificationHistoryDatabase.TAG, "Cannot clean up file on notification removal " + af.getBaseFile().getName(), e);     // Catch: Throwable -> L14
            goto L9
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    private final class RemovePackageRunnable implements Runnable {
        private String mPkg;
        final /* synthetic */ NotificationHistoryDatabase this$0;

        public RemovePackageRunnable(NotificationHistoryDatabase r1, String pkg) {
            this.this$0 = r1;
            this.mPkg = pkg;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationHistoryDatabase.m6115$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(NotificationHistoryDatabase.TAG, "RemovePackageRunnable " + this.mPkg);
        L5:
            Object r0 = NotificationHistoryDatabase.m6113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mBuffer.removeNotificationsFromWrite(this.mPkg);     // Catch: Throwable -> L13
            Iterator<AtomicFile> historyFileItr = this.this$0.mHistoryFiles.iterator();     // Catch: Throwable -> L13
        L9:
            if (historyFileItr.hasNext() == false) goto L19;
            AtomicFile af = historyFileItr.next();     // Catch: Throwable -> L13
            NotificationHistory notifications = new NotificationHistory();     // Catch: Throwable -> L13 Exception -> L15
            NotificationHistoryDatabase.m6116$$Nest$smreadLocked(af, notifications, new NotificationHistoryFilter.Builder().build());     // Catch: Throwable -> L13 Exception -> L15
            notifications.removeNotificationsFromWrite(this.mPkg);     // Catch: Throwable -> L13 Exception -> L15
            NotificationHistoryDatabase.m6114$$Nest$mwriteLocked(this.this$0, af, notifications);     // Catch: Throwable -> L13 Exception -> L15
        L15:
            e = move-exception;
            Slog.e(NotificationHistoryDatabase.TAG, "Cannot clean up file on pkg removal " + af.getBaseFile().getAbsolutePath(), e);     // Catch: Throwable -> L13
            goto L9
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    final class WriteBufferRunnable implements Runnable {
        final /* synthetic */ NotificationHistoryDatabase this$0;

        WriteBufferRunnable(NotificationHistoryDatabase this$0) {
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            long time = System.currentTimeMillis();
            run(new AtomicFile(new File(NotificationHistoryDatabase.m6112$$Nest$fgetmHistoryDir(this.this$0), String.valueOf(time))));
        }

        void run(AtomicFile file) {
            Object r0 = NotificationHistoryDatabase.m6113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (NotificationHistoryDatabase.m6115$$Nest$sfgetDEBUG() == false) goto L18;
            Slog.d(NotificationHistoryDatabase.TAG, "WriteBufferRunnable " + file.getBaseFile().getAbsolutePath());     // Catch: Throwable -> L8
        L18:
            NotificationHistoryDatabase.m6114$$Nest$mwriteLocked(this.this$0, file, this.this$0.mBuffer);     // Catch: Throwable -> L8 IOException -> L12
            this.this$0.mHistoryFiles.add(0, file);     // Catch: Throwable -> L8 IOException -> L12
            this.this$0.mBuffer = new NotificationHistory();     // Catch: Throwable -> L8 IOException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L12:
            e = move-exception;
            Slog.e(NotificationHistoryDatabase.TAG, "Failed to write buffer to disk. not flushing buffer", e);     // Catch: Throwable -> L8
            goto L14
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$JhjpdU2jSty5R-BO7N9RPwTLH3Y, reason: not valid java name */
    public static /* synthetic */ int m6111$r8$lambda$JhjpdU2jSty5RBO7N9RPwTLH3Y(File r0, File r1) {
        return lambda$indexFilesLocked$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHistoryDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m6112$$Nest$fgetmHistoryDir(NotificationHistoryDatabase r0) {
        return r0.mHistoryDir;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6113$$Nest$fgetmLock(NotificationHistoryDatabase r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6114$$Nest$mwriteLocked(NotificationHistoryDatabase r0, AtomicFile r1, NotificationHistory r2) {
        r0.writeLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6115$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smreadLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6116$$Nest$smreadLocked(AtomicFile r0, NotificationHistory r1, NotificationHistoryFilter r2) {
        readLocked(r0, r1, r2);
    }

    static {
        DEBUG = NotificationManagerService.DBG;
    }

    public NotificationHistoryDatabase(Handler fileWriteHandler, File dir) {
        this.mLock = new Object();
        this.mCurrentVersion = 1;
        this.mFileWriteHandler = fileWriteHandler;
        this.mVersionFile = new File(dir, "version");
        this.mHistoryDir = new File(dir, "history");
        this.mHistoryFiles = new ArrayList();
        this.mBuffer = new NotificationHistory();
        this.mWriteBufferRunnable = new WriteBufferRunnable(this);
    }

    public void init() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        e = move-exception;
        Slog.e(TAG, "could not create needed files", e);     // Catch: Throwable -> L11
    L19:
        checkVersionAndBuildLocked();     // Catch: Throwable -> L11
        indexFilesLocked();     // Catch: Throwable -> L11
        prune();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L5:
        if (this.mHistoryDir.exists() == true) goto L15;
        if (this.mHistoryDir.mkdir() == true) goto L15;
        throw new IllegalStateException("could not create history directory");     // Catch: Throwable -> L11 Exception -> L13
    L15:
        this.mVersionFile.createNewFile();     // Catch: Throwable -> L11 Exception -> L13
    L11:
        th = move-exception;
        throw th;
    }

    private void indexFilesLocked() {
        this.mHistoryFiles.clear();
        File[] files = this.mHistoryDir.listFiles();
        if (files != null) goto L5;
        return;
    L5:
        Arrays.sort(files, new NotificationHistoryDatabase$$ExternalSyntheticLambda0());
        int r1 = files.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        File file = files[r2];
        this.mHistoryFiles.add(new AtomicFile(file));
        r2 = r2 + 1;
        goto L6
    }

    private static /* synthetic */ int lambda$indexFilesLocked$0(File lhs, File rhs) {
        return Long.compare(safeParseLong(rhs.getName()), safeParseLong(lhs.getName()));
    }

    private void checkVersionAndBuildLocked() {
        BufferedReader reader = new BufferedReader(new FileReader(this.mVersionFile));     // Catch: Throwable -> L6
        int version = Integer.parseInt(reader.readLine());     // Catch: Throwable -> L8
        reader.close();     // Catch: Throwable -> L6 Throwable -> L6
    L16:
        if (version != this.mCurrentVersion) goto L18;
        return;
    L18:
        if (this.mVersionFile.exists() == false) goto L44;
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.mVersionFile));     // Catch: IOException -> L23
        writer.write(Integer.toString(this.mCurrentVersion));     // Catch: Throwable -> L25
        writer.write("\n");     // Catch: Throwable -> L25
        writer.flush();     // Catch: Throwable -> L25
        writer.close();     // Catch: IOException -> L23
        return;
    L25:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: IOException -> L23
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L23
    L23:
        e = move-exception;
        Slog.e(TAG, "Failed to write new version");
        throw new RuntimeException(e);
    L44:
        return;
    L8:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L6 Throwable -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6 Throwable -> L6
        goto L13
    L14:
        version = 0;
        goto L16
    }

    public void forceWriteToDisk() {
        this.mFileWriteHandler.post(this.mWriteBufferRunnable);
    }

    public void onPackageRemoved(String packageName) {
        RemovePackageRunnable rpr = new RemovePackageRunnable(this, packageName);
        this.mFileWriteHandler.post(rpr);
    }

    public void deleteNotificationHistoryItem(String pkg, long postedTime) {
        RemoveNotificationRunnable rnr = new RemoveNotificationRunnable(this, pkg, postedTime);
        this.mFileWriteHandler.post(rnr);
    }

    public void deleteConversations(String pkg, Set<String> conversationIds) {
        RemoveConversationRunnable rcr = new RemoveConversationRunnable(this, pkg, conversationIds);
        this.mFileWriteHandler.post(rcr);
    }

    public void deleteNotificationChannel(String pkg, String channelId) {
        RemoveChannelRunnable rcr = new RemoveChannelRunnable(this, pkg, channelId);
        this.mFileWriteHandler.post(rcr);
    }

    public void addNotification(NotificationHistory.HistoricalNotification notification) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBuffer.addNewNotificationToWrite(notification);     // Catch: Throwable -> L7
        if (this.mBuffer.getHistoryCount() != 1) goto L9;
        this.mFileWriteHandler.postDelayed(this.mWriteBufferRunnable, WRITE_BUFFER_INTERVAL_MS);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public NotificationHistory readNotificationHistory() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationHistory notifications = new NotificationHistory();     // Catch: Throwable -> L10
        notifications.addNotificationsToWrite(this.mBuffer);     // Catch: Throwable -> L10
        Iterator<AtomicFile> r2 = this.mHistoryFiles.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L15;
        AtomicFile file = r2.next();     // Catch: Throwable -> L10
        readLocked(file, notifications, new NotificationHistoryFilter.Builder().build());     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "error reading " + file.getBaseFile().getAbsolutePath(), e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return notifications;
    L10:
        th = move-exception;
        throw th;
    }

    public NotificationHistory readNotificationHistory(String packageName, String channelId, int maxNotifications) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationHistory notifications = new NotificationHistory();     // Catch: Throwable -> L12
        Iterator<AtomicFile> r2 = this.mHistoryFiles.iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L17;
        AtomicFile file = r2.next();     // Catch: Throwable -> L12
        readLocked(file, notifications, new NotificationHistoryFilter.Builder().setPackage(packageName).setChannel(packageName, channelId).setMaxNotifications(maxNotifications).build());     // Catch: Throwable -> L12 Exception -> L14
        if (maxNotifications != notifications.getHistoryCount()) goto L6;
    L14:
        e = move-exception;
        Slog.e(TAG, "error reading " + file.getBaseFile().getAbsolutePath(), e);     // Catch: Throwable -> L12
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return notifications;
    L12:
        th = move-exception;
        throw th;
    }

    public void disableHistory() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<AtomicFile> r1 = this.mHistoryFiles.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        AtomicFile file = r1.next();     // Catch: Throwable -> L8
        file.delete();     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mHistoryDir.delete();     // Catch: Throwable -> L8
        this.mHistoryFiles.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void prune() {
        prune(1, System.currentTimeMillis());
    }

    void prune(int retentionDays, long currentTimeMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        GregorianCalendar retentionBoundary = new GregorianCalendar();     // Catch: Throwable -> L9
        retentionBoundary.setTimeInMillis(currentTimeMillis);     // Catch: Throwable -> L9
        retentionBoundary.add(5, retentionDays * (-1));     // Catch: Throwable -> L9
        int i = this.mHistoryFiles.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L16;
        AtomicFile currentOldestFile = this.mHistoryFiles.get(i);     // Catch: Throwable -> L9
        long creationTime = safeParseLong(currentOldestFile.getBaseFile().getName());     // Catch: Throwable -> L9
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "File " + currentOldestFile.getBaseFile().getName() + " created on " + creationTime);     // Catch: Throwable -> L9
    L12:
        if (creationTime > retentionBoundary.getTimeInMillis()) goto L14;
        deleteFile(currentOldestFile);     // Catch: Throwable -> L9
    L14:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void removeFilePathFromHistory(String filePath) {
        if (filePath != null) goto L4;
        return;
    L4:
        Iterator<AtomicFile> historyFileItr = this.mHistoryFiles.iterator();
    L6:
        if (historyFileItr.hasNext() == false) goto L14;
        AtomicFile af = historyFileItr.next();
        if (af == null) goto L6;
        if (filePath.equals(af.getBaseFile().getAbsolutePath()) == false) goto L6;
        historyFileItr.remove();
        return;
    }

    private void deleteFile(AtomicFile file) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Removed " + file.getBaseFile().getName());
    L5:
        file.delete();
        removeFilePathFromHistory(file.getBaseFile().getAbsolutePath());
    }

    private void writeLocked(AtomicFile file, NotificationHistory notifications) throws IOException {
        FileOutputStream fos = file.startWrite();
        NotificationHistoryProtoHelper.write(fos, notifications, this.mCurrentVersion);     // Catch: Throwable -> L6
        file.finishWrite(fos);     // Catch: Throwable -> L6
        file.failWrite(null);
        return;
    L6:
        th = move-exception;
        file.failWrite(fos);
        throw th;
    }

    private static void readLocked(AtomicFile file, NotificationHistory notificationsOut, NotificationHistoryFilter filter) throws IOException {
        FileInputStream in = null;
        in = file.openRead();     // Catch: Throwable -> L7 FileNotFoundException -> L9
        NotificationHistoryProtoHelper.read(in, notificationsOut, filter);     // Catch: Throwable -> L7 FileNotFoundException -> L9
        if (in == null) goto L18;
        in.close();
        return;
    L18:
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Cannot open " + file.getBaseFile().getAbsolutePath(), e);     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (in == null) goto L14;
        in.close();
    L14:
        throw th;
    }

    private static long safeParseLong(String fileName) {
        return Long.parseLong(fileName);
    L5:
        return -1;
    }
}
