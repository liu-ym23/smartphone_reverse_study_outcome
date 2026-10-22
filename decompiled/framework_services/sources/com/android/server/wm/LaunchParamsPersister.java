package com.android.server.wm;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManagerInternal;
import android.graphics.Rect;
import android.os.Process;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import android.view.DisplayInfo;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.pm.PackageList;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes3.dex */
class LaunchParamsPersister {
    private static final char ESCAPED_COMPONENT_SEPARATOR = '-';
    private static final String LAUNCH_PARAMS_DIRNAME = "launch_params";
    private static final String LAUNCH_PARAMS_FILE_SUFFIX = ".xml";
    private static final char OLD_ESCAPED_COMPONENT_SEPARATOR = '_';
    private static final char ORIGINAL_COMPONENT_SEPARATOR = '/';
    private static final String TAG = "LaunchParamsPersister";
    private static final String TAG_LAUNCH_PARAMS = "launch_params";
    private final SparseArray<ArrayMap<ComponentName, PersistableLaunchParams>> mLaunchParamsMap;
    private final SparseArray<LoadingTask> mLoadingTaskMap;
    private PackageList mPackageList;
    private final PersisterQueue mPersisterQueue;
    private final ActivityTaskSupervisor mSupervisor;
    private final IntFunction<File> mUserFolderGetter;
    private final ArrayMap<String, ArraySet<ComponentName>> mWindowLayoutAffinityMap;

    private static class CleanUpComponentQueueItem implements PersisterQueue.WriteQueueItem {
        private final List<File> mComponentFiles;

        /* synthetic */ CleanUpComponentQueueItem(List r1, LaunchParamsPersisterIA r2) {
            this(r1);
        }

        private CleanUpComponentQueueItem(List<File> componentFiles) {
            this.mComponentFiles = componentFiles;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            Iterator<File> r0 = this.mComponentFiles.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            File file = r0.next();
            if (file.delete() == true) goto L4;
            Slog.w(LaunchParamsPersister.TAG, "Failed to delete " + file.getAbsolutePath());
            goto L4
        }
    }

    private class LaunchParamsWriteQueueItem implements PersisterQueue.WriteQueueItem<LaunchParamsWriteQueueItem> {
        private final ComponentName mComponentName;
        private PersistableLaunchParams mLaunchParams;
        private final int mUserId;
        final /* synthetic */ LaunchParamsPersister this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m10048$$Nest$fgetmComponentName(LaunchParamsWriteQueueItem r0) {
            return r0.mComponentName;
        }

        /* synthetic */ LaunchParamsWriteQueueItem(LaunchParamsPersister r1, int r2, ComponentName r3, PersistableLaunchParams r4, LaunchParamsPersisterIA r5) {
            this(r1, r2, r3, r4);
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public /* bridge */ /* synthetic */ boolean matches(PersisterQueue.WriteQueueItem r1) {
            return matches((LaunchParamsWriteQueueItem) r1);
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public /* bridge */ /* synthetic */ void updateFrom(PersisterQueue.WriteQueueItem r1) {
            updateFrom((LaunchParamsWriteQueueItem) r1);
        }

        private LaunchParamsWriteQueueItem(LaunchParamsPersister r1, int userId, ComponentName componentName, PersistableLaunchParams launchParams) {
            this.this$0 = r1;
            this.mUserId = userId;
            this.mComponentName = componentName;
            this.mLaunchParams = launchParams;
        }

        private byte[] saveParamsToXml() {
            ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: IOException -> L5
            TypedXmlSerializer serializer = Xml.resolveSerializer(os);     // Catch: IOException -> L5
            serializer.startDocument(null, true);     // Catch: IOException -> L5
            serializer.startTag(null, "launch_params");     // Catch: IOException -> L5
            this.mLaunchParams.saveToXml(serializer);     // Catch: IOException -> L5
            serializer.endTag(null, "launch_params");     // Catch: IOException -> L5
            serializer.endDocument();     // Catch: IOException -> L5
            serializer.flush();     // Catch: IOException -> L5
            return os.toByteArray();
        L6:
            return null;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            byte[] data = saveParamsToXml();
            File launchParamFolder = LaunchParamsPersister.m10046$$Nest$mgetLaunchParamFolder(this.this$0, this.mUserId);
            if (launchParamFolder.isDirectory() == false) goto L5;
        L8:
            File launchParamFile = LaunchParamsPersister.m10047$$Nest$mgetParamFile(this.this$0, launchParamFolder, this.mComponentName);
            AtomicFile atomicFile = new AtomicFile(launchParamFile);
            FileOutputStream stream = null;
            stream = atomicFile.startWrite();     // Catch: Exception -> L12
            stream.write(data);     // Catch: Exception -> L12
            atomicFile.finishWrite(stream);
            return;
        L12:
            e = move-exception;
            Slog.e(LaunchParamsPersister.TAG, "Failed to write param file for " + this.mComponentName, e);
            if (stream == null) goto L19;
            atomicFile.failWrite(stream);
            return;
        L19:
            return;
        L5:
            if (launchParamFolder.mkdir() == true) goto L8;
            Slog.w(LaunchParamsPersister.TAG, "Failed to create folder for " + this.mUserId);
        }

        public boolean matches(LaunchParamsWriteQueueItem item) {
            if (this.mUserId == item.mUserId) goto L5;
        L7:
            return false;
        L5:
            if (this.mComponentName.equals(item.mComponentName) == false) goto L7;
            return true;
        }

        public void updateFrom(LaunchParamsWriteQueueItem item) {
            this.mLaunchParams = item.mLaunchParams;
        }
    }

    private class LoadingTask implements Callable<ArrayMap<ComponentName, PersistableLaunchParams>> {
        private final FutureTask<ArrayMap<ComponentName, PersistableLaunchParams>> mFutureTask;
        private final int mUserId;
        final /* synthetic */ LaunchParamsPersister this$0;

        /* JADX INFO: renamed from: -$$Nest$mexecute, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10049$$Nest$mexecute(LoadingTask r0) {
            r0.execute();
        }

        /* JADX INFO: renamed from: -$$Nest$mget, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m10050$$Nest$mget(LoadingTask r0) {
            return r0.get();
        }

        /* synthetic */ LoadingTask(LaunchParamsPersister r1, int r2, LaunchParamsPersisterIA r3) {
            this(r1, r2);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ ArrayMap<ComponentName, PersistableLaunchParams> call() throws Exception {
            return call();
        }

        private LoadingTask(LaunchParamsPersister r1, int userId) {
            this.this$0 = r1;
            this.mUserId = userId;
            this.mFutureTask = new FutureTask(this);
        }

        private void execute() {
            new Thread(this.mFutureTask).start();
        }

        private ArrayMap<ComponentName, PersistableLaunchParams> get() {
            return this.mFutureTask.get();
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            e = move-exception;
            Slog.e(LaunchParamsPersister.TAG, "Failed to load launch params for user#" + this.mUserId, e);
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public ArrayMap<ComponentName, PersistableLaunchParams> call() {
            Process.setThreadPriority(10);
            List<File> filesToDelete = new ArrayList();
            File launchParamsFolder = LaunchParamsPersister.m10046$$Nest$mgetLaunchParamFolder(this.this$0, this.mUserId);
            if (launchParamsFolder.isDirectory() == true) goto L6;
            Slog.i(LaunchParamsPersister.TAG, "Didn't find launch param folder for user " + this.mUserId);
            return null;
        L6:
            Set<String> packages = new ArraySet(LaunchParamsPersister.m10042$$Nest$fgetmPackageList(this.this$0).getPackageNames());
            File[] paramsFiles = launchParamsFolder.listFiles();
            ArrayMap<ComponentName, PersistableLaunchParams> map = new ArrayMap(paramsFiles.length);
            int r9 = paramsFiles.length;
            int r11 = 0;
        L7:
            if (r11 >= r9) goto L76;
            File paramsFile = paramsFiles[r11];
            if (paramsFile.isFile() == true) goto L12;
            Slog.w(LaunchParamsPersister.TAG, paramsFile.getAbsolutePath() + " is not a file.");
            File launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
        L74:
            r11 = r11 + 1;
            launchParamsFolder = launchParamsFolder2;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L7
        L12:
            if (paramsFile.getName().endsWith(LaunchParamsPersister.LAUNCH_PARAMS_FILE_SUFFIX) == true) goto L14;
            Slog.w(LaunchParamsPersister.TAG, "Unexpected params file name: " + paramsFile.getName());
            filesToDelete.add(paramsFile);
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L74
        L14:
            String paramsFileName = paramsFile.getName();
            int oldSeparatorIndex = paramsFileName.indexOf(95);
            if (oldSeparatorIndex != (-1)) goto L17;
        L23:
            String componentNameString = paramsFileName.substring(0, paramsFileName.length() - LaunchParamsPersister.LAUNCH_PARAMS_FILE_SUFFIX.length()).replace(LaunchParamsPersister.ESCAPED_COMPONENT_SEPARATOR, LaunchParamsPersister.ORIGINAL_COMPONENT_SEPARATOR);
            ComponentName name = ComponentName.unflattenFromString(componentNameString);
            if (name != null) goto L27;
            Slog.w(LaunchParamsPersister.TAG, "Unexpected file name: " + paramsFileName);
            filesToDelete.add(paramsFile);
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L74
        L27:
            if (packages.contains(name.getPackageName()) == true) goto L93;
            filesToDelete.add(paramsFile);
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L74
        L93:
            InputStream in = new FileInputStream(paramsFile);     // Catch: Exception -> L71
            launchParamsFolder2 = launchParamsFolder;
            PersistableLaunchParams params = new PersistableLaunchParams(null);     // Catch: Throwable -> L62
            TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L62
        L34:
            oldSeparatorIndex = oldSeparatorIndex;
            int event = parser.next();     // Catch: Throwable -> L60
            packages = packages;
            if (event == 1) goto L55;
            if (event == 3) goto L55;
            if (event != 2) goto L34;
            String tagName = parser.getName();     // Catch: Throwable -> L50
            if ("launch_params".equals(tagName) == false) goto L45;
            params.restore(paramsFile, parser);     // Catch: Throwable -> L48
            paramsFiles = paramsFiles;
            goto L34
        L45:
            StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L50
            paramsFiles = paramsFiles;
            r6.append("Unexpected tag name: ");     // Catch: Throwable -> L48
            r6.append(tagName);     // Catch: Throwable -> L48
            Slog.w(LaunchParamsPersister.TAG, r6.toString());     // Catch: Throwable -> L48
            paramsFiles = paramsFiles;
        L48:
            th = move-exception;
            Throwable r3 = th;
        L87:
            in.close();     // Catch: Throwable -> L68
        L70:
            throw r3;     // Catch: Exception -> L58
        L68:
            th = move-exception;
            r3.addSuppressed(th);     // Catch: Exception -> L58
        L58:
            e = e;
        L73:
            Slog.w(LaunchParamsPersister.TAG, "Failed to restore launch params for " + name, e);
            filesToDelete.add(paramsFile);
        L50:
            th = move-exception;
            paramsFiles = paramsFiles;
            r3 = th;
        L55:
            map.put(name, params);     // Catch: Throwable -> L48
            LaunchParamsPersister.m10045$$Nest$maddComponentNameToLaunchParamAffinityMapIfNotNull(this.this$0, name, params.mWindowLayoutAffinity);     // Catch: Throwable -> L48
            in.close();     // Catch: Exception -> L58
        L60:
            th = move-exception;
            packages = packages;
            paramsFiles = paramsFiles;
            r3 = th;
        L62:
            th = move-exception;
            packages = packages;
            paramsFiles = paramsFiles;
            r3 = th;
        L64:
            th = move-exception;
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            r3 = th;
        L71:
            e = e;
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L73
        L17:
            if (paramsFileName.indexOf(95, oldSeparatorIndex + 1) == (-1)) goto L19;
            filesToDelete.add(paramsFile);
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L74
        L19:
            paramsFileName = paramsFileName.replace(LaunchParamsPersister.OLD_ESCAPED_COMPONENT_SEPARATOR, LaunchParamsPersister.ESCAPED_COMPONENT_SEPARATOR);
            File newFile = new File(launchParamsFolder, paramsFileName);
            if (paramsFile.renameTo(newFile) == false) goto L22;
            paramsFile = newFile;
            goto L23
        L22:
            filesToDelete.add(paramsFile);
            launchParamsFolder2 = launchParamsFolder;
            packages = packages;
            paramsFiles = paramsFiles;
            goto L74
        L76:
            if (filesToDelete.isEmpty() == true) goto L78;
            LaunchParamsPersister.m10043$$Nest$fgetmPersisterQueue(this.this$0).addItem(new CleanUpComponentQueueItem(filesToDelete, null), true);
        L78:
            return map;
        }
    }

    private class PackageListObserver implements PackageManagerInternal.PackageListObserver {
        final /* synthetic */ LaunchParamsPersister this$0;

        /* synthetic */ PackageListObserver(LaunchParamsPersister r1, LaunchParamsPersisterIA r2) {
            this(r1);
        }

        private PackageListObserver(LaunchParamsPersister r1) {
            this.this$0 = r1;
        }

        @Override // android.content.pm.PackageManagerInternal.PackageListObserver
        public void onPackageAdded(String packageName, int uid) {
        }

        @Override // android.content.pm.PackageManagerInternal.PackageListObserver
        public void onPackageRemoved(String packageName, int uid) {
            WindowManagerGlobalLock r0 = LaunchParamsPersister.m10044$$Nest$fgetmSupervisor(this.this$0).mService.getGlobalLock();
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.removeRecordForPackage(packageName);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private static class PersistableLaunchParams {
        private static final String ATTR_BOUNDS = "bounds";
        private static final String ATTR_DISPLAY_UNIQUE_ID = "display_unique_id";
        private static final String ATTR_WINDOWING_MODE = "windowing_mode";
        private static final String ATTR_WINDOW_LAYOUT_AFFINITY = "window_layout_affinity";
        final Rect mBounds;
        String mDisplayUniqueId;
        long mTimestamp;
        String mWindowLayoutAffinity;
        int mWindowingMode;

        /* synthetic */ PersistableLaunchParams(LaunchParamsPersisterIA r1) {
            this();
        }

        private PersistableLaunchParams() {
            this.mBounds = new Rect();
        }

        void saveToXml(TypedXmlSerializer serializer) throws IOException {
            serializer.attribute(null, ATTR_DISPLAY_UNIQUE_ID, this.mDisplayUniqueId);
            serializer.attributeInt(null, ATTR_WINDOWING_MODE, this.mWindowingMode);
            serializer.attribute(null, ATTR_BOUNDS, this.mBounds.flattenToString());
            if (this.mWindowLayoutAffinity == null) goto L6;
            serializer.attribute(null, ATTR_WINDOW_LAYOUT_AFFINITY, this.mWindowLayoutAffinity);
            return;
        }

        void restore(File xmlFile, TypedXmlPullParser parser) {
            int i = 0;
        L4:
            if (i >= parser.getAttributeCount()) goto L30;
            String attrValue = parser.getAttributeValue(i);
            String r2 = parser.getAttributeName(i);
            switch(r2.hashCode()) {
                case -1499361012: goto L18;
                case -1383205195: goto L15;
                case 748872656: goto L12;
                case 1999609934: goto L9;
                default: goto L20;
            };
        L20:
            byte r3 = -1;
        L21:
            switch(r3) {
                case 0: goto L28;
                case 1: goto L27;
                case 2: goto L24;
                case 3: goto L23;
                default: goto L29;
            };
        L23:
            this.mWindowLayoutAffinity = attrValue;
            goto L29
        L24:
            Rect bounds = Rect.unflattenFromString(attrValue);
            if (bounds == null) goto L29;
            this.mBounds.set(bounds);
            goto L29
        L27:
            this.mWindowingMode = Integer.parseInt(attrValue);
            goto L29
        L28:
            this.mDisplayUniqueId = attrValue;
        L29:
            i = i + 1;
            goto L4
        L9:
            if (r2.equals(ATTR_WINDOW_LAYOUT_AFFINITY) == false) goto L20;
            r3 = 3;
            goto L21
        L12:
            if (r2.equals(ATTR_WINDOWING_MODE) == false) goto L20;
            r3 = 1;
            goto L21
        L15:
            if (r2.equals(ATTR_BOUNDS) == false) goto L20;
            r3 = 2;
            goto L21
        L18:
            if (r2.equals(ATTR_DISPLAY_UNIQUE_ID) == false) goto L20;
            r3 = 0;
            goto L21
        L30:
            this.mTimestamp = xmlFile.lastModified();
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("PersistableLaunchParams{");
            builder.append(" windowingMode=" + this.mWindowingMode);
            builder.append(" displayUniqueId=" + this.mDisplayUniqueId);
            builder.append(" bounds=" + this.mBounds);
            if (this.mWindowLayoutAffinity == null) goto L5;
            builder.append(" launchParamsAffinity=" + this.mWindowLayoutAffinity);
        L5:
            builder.append(" timestamp=" + this.mTimestamp);
            builder.append(" }");
            return builder.toString();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Ip_uUCJLGuS3Gr9M-J6e9lMwVq4, reason: not valid java name */
    public static /* synthetic */ PersistableLaunchParams m10040$r8$lambda$Ip_uUCJLGuS3Gr9MJ6e9lMwVq4(ComponentName r0) {
        return lambda$saveTask$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$SuSbIWUcHvyh2nJ-2XrpVocJaLc, reason: not valid java name */
    public static /* synthetic */ boolean m10041$r8$lambda$SuSbIWUcHvyh2nJ2XrpVocJaLc(String r0, LaunchParamsWriteQueueItem r1) {
        return lambda$removeRecordForPackage$2(r0, r1);
    }

    public static /* synthetic */ ArraySet $r8$lambda$dzkIUtZw9QdSf01gGQQHsakwwiQ(String r0) {
        return lambda$addComponentNameToLaunchParamAffinityMapIfNotNull$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageList, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageList m10042$$Nest$fgetmPackageList(LaunchParamsPersister r0) {
        return r0.mPackageList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersisterQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ PersisterQueue m10043$$Nest$fgetmPersisterQueue(LaunchParamsPersister r0) {
        return r0.mPersisterQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupervisor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskSupervisor m10044$$Nest$fgetmSupervisor(LaunchParamsPersister r0) {
        return r0.mSupervisor;
    }

    /* JADX INFO: renamed from: -$$Nest$maddComponentNameToLaunchParamAffinityMapIfNotNull, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10045$$Nest$maddComponentNameToLaunchParamAffinityMapIfNotNull(LaunchParamsPersister r0, ComponentName r1, String r2) {
        r0.addComponentNameToLaunchParamAffinityMapIfNotNull(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLaunchParamFolder, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m10046$$Nest$mgetLaunchParamFolder(LaunchParamsPersister r0, int r1) {
        return r0.getLaunchParamFolder(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetParamFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m10047$$Nest$mgetParamFile(LaunchParamsPersister r0, File r1, ComponentName r2) {
        return r0.getParamFile(r1, r2);
    }

    LaunchParamsPersister(PersisterQueue persisterQueue, ActivityTaskSupervisor supervisor) {
        this(persisterQueue, supervisor, new LaunchParamsPersister$$ExternalSyntheticLambda2());
    }

    LaunchParamsPersister(PersisterQueue persisterQueue, ActivityTaskSupervisor supervisor, IntFunction<File> userFolderGetter) {
        this.mLoadingTaskMap = new SparseArray();
        this.mLaunchParamsMap = new SparseArray();
        this.mWindowLayoutAffinityMap = new ArrayMap();
        this.mPersisterQueue = persisterQueue;
        this.mSupervisor = supervisor;
        this.mUserFolderGetter = userFolderGetter;
    }

    void onSystemReady() {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mPackageList = pmi.getPackageList(new PackageListObserver(this, null));
    }

    void onUnlockUser(int userId) {
        if (this.mLoadingTaskMap.contains(userId) == false) goto L6;
        Slog.e(TAG, "Duplicated onUnlockUser " + userId);
        return;
    L6:
        LoadingTask task = new LoadingTask(this, userId, null);
        this.mLoadingTaskMap.put(userId, task);
        LoadingTask.m10049$$Nest$mexecute(task);
    }

    void onCleanupUser(int userId) {
        this.mLoadingTaskMap.remove(userId);
        this.mLaunchParamsMap.remove(userId);
    }

    private void waitAndMoveResultIfLoading(int userId) {
        LoadingTask task = (LoadingTask) this.mLoadingTaskMap.removeReturnOld(userId);
        if (task != null) goto L5;
        return;
    L5:
        ArrayMap<ComponentName, PersistableLaunchParams> map = LoadingTask.m10050$$Nest$mget(task);
        if (map != null) goto L8;
        return;
    L8:
        this.mLaunchParamsMap.put(userId, map);
    }

    void saveTask(Task task) {
        saveTask(task, task.getDisplayContent());
    }

    void saveTask(Task task, DisplayContent display) {
        ComponentName name = task.realActivity;
        if (name != null) goto L5;
        return;
    L5:
        int userId = task.mUserId;
        waitAndMoveResultIfLoading(userId);
        ArrayMap<ComponentName, PersistableLaunchParams> map = this.mLaunchParamsMap.get(userId);
        if (map != null) goto L8;
        ArrayMap<ComponentName, PersistableLaunchParams> map2 = new ArrayMap();
        this.mLaunchParamsMap.put(userId, map2);
        ArrayMap<ComponentName, PersistableLaunchParams> map3 = map2;
    L9:
        PersistableLaunchParams params = map3.computeIfAbsent(name, new LaunchParamsPersister$$ExternalSyntheticLambda0());
        boolean changed = saveTaskToLaunchParam(task, display, params);
        addComponentNameToLaunchParamAffinityMapIfNotNull(name, params.mWindowLayoutAffinity);
        if (changed == false) goto L13;
        this.mPersisterQueue.updateLastOrAddItem(new LaunchParamsWriteQueueItem(this, userId, name, params, null), false);
        return;
    L13:
        return;
    L8:
        map3 = map;
        goto L9
    }

    private static /* synthetic */ PersistableLaunchParams lambda$saveTask$0(ComponentName componentName) {
        return new PersistableLaunchParams(null);
    }

    private boolean saveTaskToLaunchParam(Task task, DisplayContent display, PersistableLaunchParams params) {
        DisplayInfo info = new DisplayInfo();
        display.mDisplay.getDisplayInfo(info);
        boolean changed = !Objects.equals(params.mDisplayUniqueId, info.uniqueId);
        params.mDisplayUniqueId = info.uniqueId;
        if (params.mWindowingMode == task.getWindowingMode()) goto L5;
        boolean r3 = true;
    L6:
        boolean changed2 = changed | r3;
        params.mWindowingMode = task.getWindowingMode();
        if (task.mLastNonFullscreenBounds == null) goto L9;
        boolean changed3 = changed2 | (true ^ Objects.equals(params.mBounds, task.mLastNonFullscreenBounds));
        params.mBounds.set(task.mLastNonFullscreenBounds);
    L10:
        String launchParamAffinity = task.mWindowLayoutAffinity;
        boolean changed4 = changed3 | Objects.equals(launchParamAffinity, params.mWindowLayoutAffinity);
        params.mWindowLayoutAffinity = launchParamAffinity;
        if (changed4 == false) goto L13;
        params.mTimestamp = System.currentTimeMillis();
    L13:
        return changed4;
    L9:
        changed3 = changed2 | (true ^ params.mBounds.isEmpty());
        params.mBounds.setEmpty();
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private void addComponentNameToLaunchParamAffinityMapIfNotNull(ComponentName name, String launchParamAffinity) {
        if (launchParamAffinity != null) goto L4;
        return;
    L4:
        this.mWindowLayoutAffinityMap.computeIfAbsent(launchParamAffinity, new LaunchParamsPersister$$ExternalSyntheticLambda3()).add(name);
    }

    private static /* synthetic */ ArraySet lambda$addComponentNameToLaunchParamAffinityMapIfNotNull$1(String affinity) {
        return new ArraySet();
    }

    void getLaunchParams(Task task, ActivityRecord activity, LaunchParamsController.LaunchParams outParams) {
        if (task == null) goto L5;
        ComponentName name = task.realActivity;
    L6:
        if (task == null) goto L8;
        int userId = task.mUserId;
    L9:
        waitAndMoveResultIfLoading(userId);
        if (task == null) goto L12;
        String windowLayoutAffinity = task.mWindowLayoutAffinity;
    L17:
        outParams.reset();
        Map<ComponentName, PersistableLaunchParams> map = this.mLaunchParamsMap.get(userId);
        if (map != null) goto L20;
        return;
    L20:
        PersistableLaunchParams persistableParams = map.get(name);
        if (windowLayoutAffinity != null) goto L23;
    L35:
        if (persistableParams != null) goto L37;
        return;
    L37:
        DisplayContent display = this.mSupervisor.mRootWindowContainer.getDisplayContent(persistableParams.mDisplayUniqueId);
        if (display == null) goto L40;
        outParams.mPreferredTaskDisplayArea = display.getDefaultTaskDisplayArea();
    L40:
        outParams.mWindowingMode = persistableParams.mWindowingMode;
        outParams.mBounds.set(persistableParams.mBounds);
        return;
    L23:
        if (this.mWindowLayoutAffinityMap.get(windowLayoutAffinity) == null) goto L35;
        ArraySet<ComponentName> candidates = this.mWindowLayoutAffinityMap.get(windowLayoutAffinity);
        int i = 0;
    L26:
        if (i >= candidates.size()) goto L35;
        ComponentName candidate = candidates.valueAt(i);
        PersistableLaunchParams candidateParams = map.get(candidate);
        if (candidateParams == null) goto L34;
        if (persistableParams != null) goto L32;
    L33:
        persistableParams = candidateParams;
        goto L34
    L32:
        if (candidateParams.mTimestamp > persistableParams.mTimestamp) goto L33;
    L34:
        i = i + 1;
        goto L26
    L12:
        ActivityInfo.WindowLayout layout = activity.info.windowLayout;
        if (layout != null) goto L15;
        String r6 = null;
    L16:
        windowLayoutAffinity = r6;
        goto L17
    L15:
        r6 = layout.windowLayoutAffinity;
        goto L16
    L8:
        userId = activity.mUserId;
        goto L9
    L5:
        name = activity.mActivityComponent;
        goto L6
    }

    void removeRecordForPackage(final String packageName) {
        List<File> fileToDelete = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mLaunchParamsMap.size()) goto L12;
        int userId = this.mLaunchParamsMap.keyAt(i);
        File launchParamsFolder = getLaunchParamFolder(userId);
        ArrayMap<ComponentName, PersistableLaunchParams> map = this.mLaunchParamsMap.valueAt(i);
        int j = map.size() - 1;
    L6:
        if (j < 0) goto L11;
        ComponentName name = map.keyAt(j);
        if (name.getPackageName().equals(packageName) == false) goto L10;
        map.removeAt(j);
        fileToDelete.add(getParamFile(launchParamsFolder, name));
    L10:
        j = j - 1;
        goto L6
    L11:
        i = i + 1;
        goto L4
    L12:
        PersisterQueue r1 = this.mPersisterQueue;
        monitor-enter(r1);
        this.mPersisterQueue.removeItems(new LaunchParamsPersister$$ExternalSyntheticLambda1(packageName), LaunchParamsWriteQueueItem.class);     // Catch: Throwable -> L17
        this.mPersisterQueue.addItem(new CleanUpComponentQueueItem(fileToDelete, null), true);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeRecordForPackage$2(String packageName, LaunchParamsWriteQueueItem item) {
        return LaunchParamsWriteQueueItem.m10048$$Nest$fgetmComponentName(item).getPackageName().equals(packageName);
    }

    private File getParamFile(File launchParamFolder, ComponentName name) {
        String componentNameString = name.flattenToShortString().replace(ORIGINAL_COMPONENT_SEPARATOR, ESCAPED_COMPONENT_SEPARATOR);
        return new File(launchParamFolder, componentNameString + LAUNCH_PARAMS_FILE_SUFFIX);
    }

    private File getLaunchParamFolder(int userId) {
        File userFolder = this.mUserFolderGetter.apply(userId);
        return new File(userFolder, "launch_params");
    }
}
