package com.android.server.wm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.FileUtils;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public class TaskPersister implements PersisterQueue.Listener {
    static final boolean DEBUG = false;
    private static final String IMAGES_DIRNAME = "recent_images";
    static final String IMAGE_EXTENSION = ".png";
    private static final String PERSISTED_TASK_IDS_FILENAME = "persisted_taskIds.txt";
    static final String TAG = "TaskPersister";
    private static final String TAG_TASK = "task";
    private static final String TASKS_DIRNAME = "recent_tasks";
    private static final String TASK_FILENAME_SUFFIX = "_task.xml";
    private final Object mIoLock;
    private final PersisterQueue mPersisterQueue;
    private final RecentTasks mRecentTasks;
    private final ActivityTaskManagerService mService;
    private final File mTaskIdsDir;
    private final SparseArray<SparseBooleanArray> mTaskIdsInFile;
    private final ActivityTaskSupervisor mTaskSupervisor;
    private final ArraySet<Integer> mTmpTaskIds;

    private static class ImageWriteQueueItem implements PersisterQueue.WriteQueueItem<ImageWriteQueueItem> {
        final String mFilePath;
        Bitmap mImage;

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public /* bridge */ /* synthetic */ boolean matches(PersisterQueue.WriteQueueItem r1) {
            return matches((ImageWriteQueueItem) r1);
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public /* bridge */ /* synthetic */ void updateFrom(PersisterQueue.WriteQueueItem r1) {
            updateFrom((ImageWriteQueueItem) r1);
        }

        ImageWriteQueueItem(String filePath, Bitmap image) {
            this.mFilePath = filePath;
            this.mImage = image;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            String filePath = this.mFilePath;
            if (TaskPersister.m10318$$Nest$smcreateParentDirectory(filePath) == true) goto L6;
            Slog.e(TaskPersister.TAG, "Error while creating images directory for file: " + filePath);
            return;
        L6:
            Bitmap bitmap = this.mImage;
            FileOutputStream imageFile = null;
            imageFile = new FileOutputStream(new File(filePath));     // Catch: Throwable -> L9 Exception -> L11
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, imageFile);     // Catch: Throwable -> L9 Exception -> L11
        L8:
            IoUtils.closeQuietly(imageFile);
            return;
        L11:
            e = move-exception;
            Slog.e(TaskPersister.TAG, "saveImage: unable to save " + filePath, e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            IoUtils.closeQuietly(imageFile);
            throw th;
        }

        public boolean matches(ImageWriteQueueItem item) {
            return this.mFilePath.equals(item.mFilePath);
        }

        public void updateFrom(ImageWriteQueueItem item) {
            this.mImage = item.mImage;
        }

        public String toString() {
            return "ImageWriteQueueItem{path=" + this.mFilePath + ", image=(" + this.mImage.getWidth() + "x" + this.mImage.getHeight() + ")}";
        }
    }

    private static class RecentTaskFile {
        final File mFile;
        final int mTaskId;
        final ByteArrayInputStream mXmlContent;

        RecentTaskFile(int taskId, File file) throws IOException {
            this.mTaskId = taskId;
            this.mFile = file;
            this.mXmlContent = new ByteArrayInputStream(Files.readAllBytes(file.toPath()));
        }
    }

    static class RecentTaskFiles {
        final ArrayList<RecentTaskFile> mLoadedFiles;
        final File[] mUserTaskFiles;

        RecentTaskFiles(File[] userFiles, ArrayList<RecentTaskFile> loadedFiles) {
            this.mUserTaskFiles = userFiles;
            this.mLoadedFiles = loadedFiles;
        }
    }

    private static class TaskWriteQueueItem implements PersisterQueue.WriteQueueItem {
        private final ActivityTaskManagerService mService;
        private final Task mTask;

        /* JADX INFO: renamed from: -$$Nest$fgetmTask, reason: not valid java name */
        static /* bridge */ /* synthetic */ Task m10320$$Nest$fgetmTask(TaskWriteQueueItem r0) {
            return r0.mTask;
        }

        TaskWriteQueueItem(Task task, ActivityTaskManagerService service) {
            this.mTask = task;
            this.mService = service;
        }

        private byte[] saveToXml(Task task) throws Exception {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TypedXmlSerializer xmlSerializer = Xml.resolveSerializer(os);
            xmlSerializer.startDocument(null, true);
            xmlSerializer.startTag(null, TaskPersister.TAG_TASK);
            task.saveToXml(xmlSerializer);
            xmlSerializer.endTag(null, TaskPersister.TAG_TASK);
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            return os.toByteArray();
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            byte[] data = null;
            Task task = this.mTask;
            WindowManagerGlobalLock r2 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (task.inRecents == true) goto L35;
        L11:
            monitor-exit(r2);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            if (data == null) goto L38;
            AtomicFile atomicFile = null;
            File userTasksDir = TaskPersister.m10319$$Nest$smgetUserTasksDir(task.mUserId);     // Catch: IOException -> L21
            if (userTasksDir.isDirectory() == false) goto L18;
        L23:
            AtomicFile atomicFile2 = new AtomicFile(new File(userTasksDir, String.valueOf(task.mTaskId) + TaskPersister.TASK_FILENAME_SUFFIX));     // Catch: IOException -> L21
            FileOutputStream file = atomicFile2.startWrite();     // Catch: IOException -> L21
            file.write(data);     // Catch: IOException -> L21
            atomicFile2.finishWrite(file);     // Catch: IOException -> L21
            return;
        L18:
            if (userTasksDir.mkdirs() == true) goto L23;
            Slog.e(TaskPersister.TAG, "Failure creating tasks directory for user " + task.mUserId + ": " + userTasksDir + " Dropping persistence for task " + task);     // Catch: IOException -> L21
            return;
        L21:
            e = move-exception;
            if (0 == 0) goto L28;
            atomicFile.failWrite(null);
        L28:
            Slog.e(TaskPersister.TAG, "Unable to open null for persisting. " + e);
            return;
        L38:
            return;
        L35:
            data = saveToXml(task);     // Catch: Throwable -> L8 Exception -> L10
            goto L11
        }

        public String toString() {
            return "TaskWriteQueueItem{task=" + this.mTask + "}";
        }
    }

    public static /* synthetic */ boolean $r8$lambda$IgLTXPTuoQRyxU9SMbP_qRBIWl8(Task r0, ImageWriteQueueItem r1) {
        return lambda$removeThumbnails$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$UUczPqCiQuK2X01tlca68TfPJpE(String r0, ImageWriteQueueItem r1) {
        return lambda$getImageFromWriteQueue$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$hpGvDr585n6hexBdLZakDSAsCLU(Task r0, TaskWriteQueueItem r1) {
        return lambda$wakeup$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateParentDirectory, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10318$$Nest$smcreateParentDirectory(String r0) {
        return createParentDirectory(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUserTasksDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m10319$$Nest$smgetUserTasksDir(int r0) {
        return getUserTasksDir(r0);
    }

    TaskPersister(File systemDir, ActivityTaskSupervisor taskSupervisor, ActivityTaskManagerService service, RecentTasks recentTasks, PersisterQueue persisterQueue) {
        this.mTaskIdsInFile = new SparseArray();
        this.mIoLock = new Object();
        this.mTmpTaskIds = new ArraySet();
        File legacyImagesDir = new File(systemDir, IMAGES_DIRNAME);
        if (legacyImagesDir.exists() == true) goto L5;
    L9:
        File legacyTasksDir = new File(systemDir, TASKS_DIRNAME);
        if (legacyTasksDir.exists() == true) goto L12;
    L16:
        this.mTaskIdsDir = new File(Environment.getDataDirectory(), "system_de");
        this.mTaskSupervisor = taskSupervisor;
        this.mService = service;
        this.mRecentTasks = recentTasks;
        this.mPersisterQueue = persisterQueue;
        this.mPersisterQueue.addListener(this);
        return;
    L12:
        if (FileUtils.deleteContents(legacyTasksDir) == true) goto L14;
    L15:
        Slog.i(TAG, "Failure deleting legacy tasks directory: " + legacyTasksDir);
        goto L16
    L14:
        if (legacyTasksDir.delete() == true) goto L16;
    L5:
        if (FileUtils.deleteContents(legacyImagesDir) == true) goto L7;
    L8:
        Slog.i(TAG, "Failure deleting legacy images directory: " + legacyImagesDir);
        goto L9
    L7:
        if (legacyImagesDir.delete() == true) goto L9;
        goto L8
    }

    TaskPersister(File workingDir) {
        this.mTaskIdsInFile = new SparseArray();
        this.mIoLock = new Object();
        this.mTmpTaskIds = new ArraySet();
        this.mTaskIdsDir = workingDir;
        this.mTaskSupervisor = null;
        this.mService = null;
        this.mRecentTasks = null;
        this.mPersisterQueue = new PersisterQueue();
        this.mPersisterQueue.addListener(this);
    }

    private void removeThumbnails(final Task task) {
        this.mPersisterQueue.removeItems(new TaskPersister$$ExternalSyntheticLambda0(task), ImageWriteQueueItem.class);
    }

    private static /* synthetic */ boolean lambda$removeThumbnails$0(Task task, ImageWriteQueueItem item) {
        File file = new File(item.mFilePath);
        return file.getName().startsWith(Integer.toString(task.mTaskId));
    }

    SparseBooleanArray readPersistedTaskIdsFromFileForUser(int userId) {
        SparseBooleanArray persistedTaskIds = new SparseBooleanArray();
        Object r1 = this.mIoLock;
        monitor-enter(r1);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(getUserPersistedTaskIdsFile(userId)));     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
    L6:
        String line = reader.readLine();     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        if (line == null) goto L18;
        String[] r3 = line.split("\\s+");     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        int r5 = r3.length;     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L6;
        String taskIdString = r3[r6];     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        int id = Integer.parseInt(taskIdString);     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        persistedTaskIds.put(id, true);     // Catch: Throwable -> L12 Exception -> L14 FileNotFoundException -> L16
        r6 = r6 + 1;
        goto L9
        goto L24
    L18:
        IoUtils.closeQuietly(reader);     // Catch: Throwable -> L20
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L20
        Slog.i(TAG, "Loaded persisted task ids for user " + userId);
        return persistedTaskIds;
    L14:
        e = move-exception;
        Slog.e(TAG, "Error while reading taskIds file for user " + userId, e);     // Catch: Throwable -> L12
    L24:
        IoUtils.closeQuietly(reader);     // Catch: Throwable -> L20
    L12:
        th = move-exception;
        IoUtils.closeQuietly(reader);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    void writePersistedTaskIdsForUser(SparseBooleanArray taskIds, int userId) {
        if (userId >= 0) goto L4;
        return;
    L4:
        File persistedTaskIdsFile = getUserPersistedTaskIdsFile(userId);
        Object r1 = this.mIoLock;
        monitor-enter(r1);
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(persistedTaskIdsFile));     // Catch: Throwable -> L14 Exception -> L16
        int i = 0;
    L9:
        if (i >= taskIds.size()) goto L20;
        if (taskIds.valueAt(i) == false) goto L18;
        writer.write(String.valueOf(taskIds.keyAt(i)));     // Catch: Throwable -> L14 Exception -> L16
        writer.newLine();     // Catch: Throwable -> L14 Exception -> L16
    L18:
        i = i + 1;
        goto L9
    L20:
        IoUtils.closeQuietly(writer);     // Catch: Throwable -> L22
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L14:
        th = move-exception;
        IoUtils.closeQuietly(writer);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L16:
        e = move-exception;
        Slog.e(TAG, "Error while writing taskIds file for user " + userId, e);     // Catch: Throwable -> L14
        IoUtils.closeQuietly(writer);     // Catch: Throwable -> L22
        goto L27
    }

    void setPersistedTaskIds(int userId, SparseBooleanArray taskIds) {
        this.mTaskIdsInFile.put(userId, taskIds);
    }

    void unloadUserDataFromMemory(int userId) {
        this.mTaskIdsInFile.delete(userId);
    }

    void wakeup(final Task task, boolean flush) {
        PersisterQueue r0 = this.mPersisterQueue;
        monitor-enter(r0);
        if (task == null) goto L17;
        TaskWriteQueueItem item = (TaskWriteQueueItem) this.mPersisterQueue.findLastItem(new TaskPersister$$ExternalSyntheticLambda1(task), TaskWriteQueueItem.class);     // Catch: Throwable -> L10
        if (item != null) goto L8;
    L12:
        if (item != null) goto L18;
        if (task.isPersistable == false) goto L18;
        this.mPersisterQueue.addItem(new TaskWriteQueueItem(task, this.mService), flush);     // Catch: Throwable -> L10
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mPersisterQueue.yieldIfQueueTooDeep();
        return;
    L8:
        if (task.inRecents == true) goto L12;
        removeThumbnails(task);     // Catch: Throwable -> L10
        goto L12
    L17:
        this.mPersisterQueue.addItem(PersisterQueue.EMPTY_ITEM, flush);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$wakeup$1(Task task, TaskWriteQueueItem queueItem) {
        if (task != TaskWriteQueueItem.m10320$$Nest$fgetmTask(queueItem)) goto L5;
        return true;
    L5:
        return false;
    }

    void flush() {
        this.mPersisterQueue.flush();
    }

    void saveImage(Bitmap image, String filePath) {
        this.mPersisterQueue.updateLastOrAddItem(new ImageWriteQueueItem(filePath, image), false);
    }

    Bitmap getTaskDescriptionIcon(String filePath) {
        Bitmap icon = getImageFromWriteQueue(filePath);
        if (icon == null) goto L6;
        return icon;
    L6:
        return restoreImage(filePath);
    }

    private Bitmap getImageFromWriteQueue(final String filePath) {
        ImageWriteQueueItem item = (ImageWriteQueueItem) this.mPersisterQueue.findLastItem(new TaskPersister$$ExternalSyntheticLambda2(filePath), ImageWriteQueueItem.class);
        if (item != null) goto L7;
        return null;
    L7:
        return item.mImage;
    }

    private static /* synthetic */ boolean lambda$getImageFromWriteQueue$2(String filePath, ImageWriteQueueItem queueItem) {
        return queueItem.mFilePath.equals(filePath);
    }

    private static String fileToString(File file) {
        String newline = System.lineSeparator();
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));     // Catch: Throwable -> L7 IOException -> L9
        StringBuffer sb = new StringBuffer(((int) file.length()) * 2);     // Catch: Throwable -> L7 IOException -> L9
    L4:
        String line = reader.readLine();     // Catch: Throwable -> L7 IOException -> L9
        if (line == null) goto L11;
        sb.append(line + newline);     // Catch: Throwable -> L7 IOException -> L9
        goto L4
    L11:
        String r3 = sb.toString();     // Catch: Throwable -> L7 IOException -> L9
        IoUtils.closeQuietly(reader);
        return r3;
    L7:
        th = move-exception;
        IoUtils.closeQuietly(reader);
        throw th;
    L15:
        Slog.e(TAG, "Couldn't read file " + file.getName());     // Catch: Throwable -> L7
        IoUtils.closeQuietly(reader);
        return null;
    }

    private Task taskIdToTask(int taskId, ArrayList<Task> tasks) {
        if (taskId >= 0) goto L5;
        return null;
    L5:
        int taskNdx = tasks.size() - 1;
    L6:
        if (taskNdx < 0) goto L11;
        Task task = tasks.get(taskNdx);
        if (task.mTaskId == taskId) goto L9;
        taskNdx = taskNdx - 1;
        goto L6
    L9:
        return task;
    L11:
        Slog.e(TAG, "Restore affiliation error looking for taskId=" + taskId);
        return null;
    }

    static RecentTaskFiles loadTasksForUser(int userId) {
        ArrayList<RecentTaskFile> taskFiles = new ArrayList();
        File userTasksDir = getUserTasksDir(userId);
        File[] recentFiles = userTasksDir.listFiles();
        if (recentFiles != null) goto L6;
        Slog.i(TAG, "loadTasksForUser: Unable to list files from " + userTasksDir + " exists=" + userTasksDir.exists());
        return new RecentTaskFiles(new File[0], taskFiles);
    L6:
        int r5 = recentFiles.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L20;
        File taskFile = recentFiles[r6];
        if (taskFile.getName().endsWith(TASK_FILENAME_SUFFIX) == false) goto L18;
        int taskId = Integer.parseInt(taskFile.getName().substring(0, taskFile.getName().length() - TASK_FILENAME_SUFFIX.length()));     // Catch: NumberFormatException -> L16
        taskFiles.add(new RecentTaskFile(taskId, taskFile));     // Catch: IOException -> L14
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to read file: " + fileToString(taskFile), e);
        taskFile.delete();
    L16:
        e = move-exception;
        Slog.w(TAG, "Unexpected task file name", e);
    L18:
        r6 = r6 + 1;
        goto L7
    L20:
        return new RecentTaskFiles(recentFiles, taskFiles);
    }

    ArrayList<Task> restoreTasksForUserLocked(int userId, RecentTaskFiles recentTaskFiles, IntArray existedTaskIds) {
        ArrayList<Task> tasks = new ArrayList();
        ArrayList<RecentTaskFile> taskFiles = recentTaskFiles.mLoadedFiles;
        if (taskFiles.isEmpty() == false) goto L5;
        return tasks;
    L5:
        ArraySet<Integer> recoveredTaskIds = new ArraySet();
        int taskNdx = 0;
    L6:
        int event = 1;
        if (taskNdx >= taskFiles.size()) goto L86;
        RecentTaskFile recentTask = taskFiles.get(taskNdx);
        if (existedTaskIds.contains(recentTask.mTaskId) == false) goto L11;
        Slog.w(TAG, "Task #" + recentTask.mTaskId + " has already been created, so skip restoring");
        taskFiles = taskFiles;
        taskNdx = taskNdx;
    L82:
        taskNdx = taskNdx + 1;
        taskFiles = taskFiles;
        goto L6
    L11:
        File taskFile = recentTask.mFile;
        InputStream is = recentTask.mXmlContent;     // Catch: Throwable -> L73 Exception -> L75
    L93:
        XmlPullParser r0 = Xml.resolvePullParser(is);     // Catch: Throwable -> L53
    L15:
        int event2 = r0.next();     // Catch: Throwable -> L53
        if (event2 == event) goto L57;
        if (event2 == 3) goto L57;
        String name = r0.getName();     // Catch: Throwable -> L53
        taskFiles = taskFiles;
        if (event2 == 2) goto L100;
        r0 = r0;
        taskNdx = taskNdx;
        RecentTaskFile recentTask2 = recentTask;
    L51:
        XmlUtils.skipCurrentTag(r0);     // Catch: Throwable -> L33
        taskFiles = taskFiles;
        r0 = r0;
        taskNdx = taskNdx;
        recentTask = recentTask2;
        event = 1;
        goto L15
    L100:
    L45:
        th = move-exception;
        taskNdx = taskNdx;
        Throwable r5 = th;
    L66:
        if (is != null) goto L98;
    L97:
        throw r5;     // Catch: Throwable -> L60 Exception -> L62
    L62:
        e = e;
    L78:
        Slog.wtf(TAG, "Unable to parse " + taskFile + ". Error ", e);     // Catch: Throwable -> L60
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L60
        r6.append("Failing file: ");     // Catch: Throwable -> L60
        r6.append(fileToString(taskFile));     // Catch: Throwable -> L60
        Slog.e(TAG, r6.toString());     // Catch: Throwable -> L60
        if (1 == 0) goto L82;
        taskFile.delete();
    L60:
        th = th;
    L83:
        if (0 == 0) goto L85;
        taskFile.delete();
    L85:
        throw th;
    L98:
        is.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r5.addSuppressed(th);     // Catch: Throwable -> L60 Exception -> L62
        goto L97
    L23:
        if (TAG_TASK.equals(name) == false) goto L49;
        Task task = Task.restoreFromXml(r0, this.mTaskSupervisor);     // Catch: Throwable -> L45
        if (task == null) goto L47;
        int taskId = task.mTaskId;     // Catch: Throwable -> L45
        boolean persistedTask = task.hasActivity();     // Catch: Throwable -> L45
        taskNdx = taskNdx;
        if (persistedTask == false) goto L35;
        recentTask2 = recentTask;
        if (this.mRecentTasks.getTask(taskId) == null) goto L36;
        Slog.wtf(TAG, "Existing persisted task with taskId " + taskId + " found");     // Catch: Throwable -> L33
    L36:
        if (persistedTask == true) goto L41;
        if (this.mService.mRootWindowContainer.anyTaskForId(taskId, 1) == null) goto L41;
        Slog.wtf(TAG, "Existing task with taskId " + taskId + " found");     // Catch: Throwable -> L33
    L41:
        if (userId == task.mUserId) goto L43;
        Slog.wtf(TAG, "Task with userId " + task.mUserId + " found in " + taskFile.getAbsolutePath());     // Catch: Throwable -> L33
        goto L51
    L43:
        this.mTaskSupervisor.setNextTaskIdForUser(taskId, userId);     // Catch: Throwable -> L33
        task.isPersistable = true;     // Catch: Throwable -> L33
        tasks.add(task);     // Catch: Throwable -> L33
        recoveredTaskIds.add(Integer.valueOf(taskId));     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r5 = th;
        goto L66
    L35:
        recentTask2 = recentTask;
        goto L36
    L47:
        taskNdx = taskNdx;
        recentTask2 = recentTask;
        Slog.e(TAG, "restoreTasksForUserLocked: Unable to restore taskFile=" + taskFile + ": " + fileToString(taskFile));     // Catch: Throwable -> L33
        goto L51
    L49:
        r0 = r0;
        taskNdx = taskNdx;
        recentTask2 = recentTask;
        Slog.wtf(TAG, "restoreTasksForUserLocked: Unknown xml event=" + event2 + " name=" + name);     // Catch: Throwable -> L33
    L57:
        if (is != null) goto L91;
    L64:
        if (0 == 0) goto L82;
        taskFile.delete();
        goto L82
    L91:
        is.close();     // Catch: Throwable -> L60 Exception -> L62
    L53:
        th = move-exception;
        taskFiles = taskFiles;
        taskNdx = taskNdx;
        r5 = th;
    L75:
        e = e;
        taskFiles = taskFiles;
        taskNdx = taskNdx;
    L73:
        th = th;
        goto L83
    L86:
        removeObsoleteFiles(recoveredTaskIds, recentTaskFiles.mUserTaskFiles);
        int taskNdx2 = tasks.size() - 1;
    L87:
        if (taskNdx2 < 0) goto L89;
        Task task2 = tasks.get(taskNdx2);
        task2.setPrevAffiliate(taskIdToTask(task2.mPrevAffiliateTaskId, tasks));
        task2.setNextAffiliate(taskIdToTask(task2.mNextAffiliateTaskId, tasks));
        taskNdx2 = taskNdx2 - 1;
        goto L87
    L89:
        Collections.sort(tasks, new AnonymousClass1(this));
        return tasks;
    }

    @Override // com.android.server.wm.PersisterQueue.Listener
    public void onPreProcessItem(boolean queueEmpty) {
        if (queueEmpty == false) goto L12;
        this.mTmpTaskIds.clear();
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRecentTasks.getPersistableTaskIds(this.mTmpTaskIds);     // Catch: Throwable -> L8
        this.mService.mWindowManager.removeObsoleteTaskFiles(this.mTmpTaskIds, this.mRecentTasks.usersWithRecentsLoadedLocked());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        removeObsoleteFiles(this.mTmpTaskIds);
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L12:
        writeTaskIdsFiles();
    }

    private static void removeObsoleteFiles(ArraySet<Integer> persistentTaskIds, File[] files) {
        if (files != null) goto L6;
        Slog.e(TAG, "File error accessing recents directory (directory doesn't exist?).");
        return;
    L6:
        int fileNdx = 0;
    L8:
        if (fileNdx >= files.length) goto L20;
        File file = files[fileNdx];
        String filename = file.getName();
        int taskIdEnd = filename.indexOf(95);
        if (taskIdEnd <= 0) goto L18;
        int taskId = Integer.parseInt(filename.substring(0, taskIdEnd));     // Catch: Exception -> L16
        if (persistentTaskIds.contains(Integer.valueOf(taskId)) == true) goto L18;
        file.delete();
    L17:
        Slog.wtf(TAG, "removeObsoleteFiles: Can't parse file=" + file.getName());
        file.delete();
    L18:
        fileNdx = fileNdx + 1;
        goto L8
    }

    private void writeTaskIdsFiles() {
        SparseArray<SparseBooleanArray> changedTaskIdsPerUser = new SparseArray();
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        int[] r2 = this.mRecentTasks.usersWithRecentsLoadedLocked();     // Catch: Throwable -> L11
        int r3 = r2.length;     // Catch: Throwable -> L11
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L15;
        int userId = r2[r4];     // Catch: Throwable -> L11
        SparseBooleanArray taskIdsToSave = this.mRecentTasks.getTaskIdsForLoadedUser(userId);     // Catch: Throwable -> L11
        SparseBooleanArray persistedIdsInFile = this.mTaskIdsInFile.get(userId);     // Catch: Throwable -> L11
        if (persistedIdsInFile != null) goto L9;
    L13:
        SparseBooleanArray taskIdsToSaveCopy = taskIdsToSave.clone();     // Catch: Throwable -> L11
        this.mTaskIdsInFile.put(userId, taskIdsToSaveCopy);     // Catch: Throwable -> L11
        changedTaskIdsPerUser.put(userId, taskIdsToSaveCopy);     // Catch: Throwable -> L11
    L14:
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (persistedIdsInFile.equals(taskIdsToSave) == false) goto L13;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        int i = 0;
    L18:
        if (i >= changedTaskIdsPerUser.size()) goto L21;
        writePersistedTaskIdsForUser(changedTaskIdsPerUser.valueAt(i), changedTaskIdsPerUser.keyAt(i));
        i = i + 1;
        goto L18
    L21:
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void removeObsoleteFiles(ArraySet<Integer> persistentTaskIds) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int[] candidateUserIds = this.mRecentTasks.usersWithRecentsLoadedLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        int r1 = candidateUserIds.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        int userId = candidateUserIds[r2];
        removeObsoleteFiles(persistentTaskIds, getUserImagesDir(userId).listFiles());
        removeObsoleteFiles(persistentTaskIds, getUserTasksDir(userId).listFiles());
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    static Bitmap restoreImage(String filename) {
        return BitmapFactory.decodeFile(filename);
    }

    private File getUserPersistedTaskIdsFile(int userId) {
        File userTaskIdsDir = new File(this.mTaskIdsDir, String.valueOf(userId));
        if (userTaskIdsDir.exists() == true) goto L8;
        if (userTaskIdsDir.mkdirs() == true) goto L8;
        Slog.e(TAG, "Error while creating user directory: " + userTaskIdsDir);
    L8:
        return new File(userTaskIdsDir, PERSISTED_TASK_IDS_FILENAME);
    }

    private static File getUserTasksDir(int userId) {
        return new File(Environment.getDataSystemCeDirectory(userId), TASKS_DIRNAME);
    }

    static File getUserImagesDir(int userId) {
        return new File(Environment.getDataSystemCeDirectory(userId), IMAGES_DIRNAME);
    }

    private static boolean createParentDirectory(String filePath) {
        File parentDir = new File(filePath).getParentFile();
        if (parentDir.isDirectory() == false) goto L5;
    L8:
        return true;
    L5:
        if (parentDir.mkdir() == true) goto L8;
        return false;
    }
}
