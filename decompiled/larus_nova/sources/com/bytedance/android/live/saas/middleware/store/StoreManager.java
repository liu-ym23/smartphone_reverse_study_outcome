package com.bytedance.android.live.saas.middleware.store;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.InputStream;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096\u0001J\u001f\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0017H\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010%\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010&\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010)\u001a\u00020\u0017H\u0096\u0001J\t\u0010*\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u0010-\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0015\u0010.\u001a\u0004\u0018\u00010\u00172\b\u0010 \u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u00100\u001a\u00020\u0017H\u0096\u0001J\u0011\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J\u0011\u00103\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\fH\u0096\u0001J\u0011\u00104\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u00108\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u00109\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010:\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010;\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010<\u001a\u00020\u0007H\u0096\u0001J\t\u0010=\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010B\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010E\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010I\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\f2\u0006\u00102\u001a\u00020\u0017H\u0096\u0001J!\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010P\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010Q\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0096\u0001¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/StoreManager;", "Lcom/bytedance/android/live/saas/middleware/store/IFileUtils;", "()V", "appendFileSeparateForPath", "", "path", "checkFileExists", "", "checkTypeExternalDirIsExist", "type", "checkTypeInternalDirIsExist", "applicationContext", "Landroid/content/Context;", "clearDir", "", MapBundleKey.MapObjKey.OBJ_DIR, "reserves", "", "copyFile", "sourcePath", "desDir", "destName", "createFile", "Ljava/io/File;", "isFile", "ensureDirExists", "fileChannelCopy", "srcFilePath", "destFilePath", "getByteArray", "", "getCacheDirPath", PerfLog.PARAM_KEY_CONTEXT_ID, "getCacheSize", "", "getConfiJsonFilePath", "filePath", "getDirSize", "getEditExternalTypeDir", "getEidtAbsoluteExternalDir", "dirName", "getExternalAppDir", "getExternalAppPath", "getExternalCacheDir", "getExternalCachePath", "getExternalCacheTypeDir", "getExternalFilesDir", "getExternalModelDir", "getExternalPictureDir", "getFileSize", "file", "getFilesDir", "getImageType", "Lcom/bytedance/common/utility/io/FileUtils$ImageType;", "getInputStream", "Ljava/io/InputStream;", "getInternalAppDir", "getInternalAppDirWithType", "getInternalDataDir", "getOutDataDir", "isSdcardAvailable", "isSdcardWritable", "parseJsonFile", "Lorg/json/JSONObject;", "jsonFilePath", "readConfigJsonFile", "readStringFromFile", "removeDir", "fileOrDirectory", "removeFile", "renameFile", "oldPath", "newPath", "saveImageToGallery", "saveInputStream", "input", "name", "unZipFolder", "zipFilePath", "outPath", "updateMediaStore", "writeString2File", "content", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class StoreManager implements IFileUtils {
    public static final StoreManager INSTANCE = null;
    private final /* synthetic */ FileUtils $$delegate_0;

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String appendFileSeparateForPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.appendFileSeparateForPath(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkFileExists(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.checkFileExists(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeExternalDirIsExist(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.$$delegate_0.checkTypeExternalDirIsExist(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean checkTypeInternalDirIsExist(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        return this.$$delegate_0.checkTypeInternalDirIsExist(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        this.$$delegate_0.clearDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void clearDir(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        Intrinsics.checkNotNullParameter(r101, "reserves");
        this.$$delegate_0.clearDir(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean copyFile(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sourcePath");
        Intrinsics.checkNotNullParameter(r101, "desDir");
        Intrinsics.checkNotNullParameter(r102, "destName");
        return this.$$delegate_0.copyFile(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File createFile(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.createFile(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean ensureDirExists(File r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        return this.$$delegate_0.ensureDirExists(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean fileChannelCopy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "srcFilePath");
        Intrinsics.checkNotNullParameter(r101, "destFilePath");
        return this.$$delegate_0.fileChannelCopy(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public byte[] getByteArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.getByteArray(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getCacheDirPath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.$$delegate_0.getCacheDirPath(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getCacheSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getCacheSize(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getConfiJsonFilePath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        return this.$$delegate_0.getConfiJsonFilePath(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getDirSize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.getDirSize(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getEditExternalTypeDir(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        return this.$$delegate_0.getEditExternalTypeDir(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getEidtAbsoluteExternalDir(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dirName");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        return this.$$delegate_0.getEidtAbsoluteExternalDir(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalAppDir() {
        return this.$$delegate_0.getExternalAppDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalAppPath() {
        return this.$$delegate_0.getExternalAppPath();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getExternalCacheDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String getExternalCachePath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getExternalCachePath(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalCacheTypeDir(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        return this.$$delegate_0.getExternalCacheTypeDir(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalFilesDir(Context r100) {
        return this.$$delegate_0.getExternalFilesDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalModelDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getExternalModelDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getExternalPictureDir() {
        return this.$$delegate_0.getExternalPictureDir();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public long getFileSize(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.$$delegate_0.getFileSize(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getFilesDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.$$delegate_0.getFilesDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public com.bytedance.common.utility.io.FileUtils.ImageType getImageType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.getImageType(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public InputStream getInputStream(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.getInputStream(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getInternalAppDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalAppDirWithType(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        return this.$$delegate_0.getInternalAppDirWithType(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getInternalDataDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getInternalDataDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public File getOutDataDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return this.$$delegate_0.getOutDataDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardAvailable() {
        return this.$$delegate_0.isSdcardAvailable();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean isSdcardWritable() {
        return this.$$delegate_0.isSdcardWritable();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public JSONObject parseJsonFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonFilePath");
        return this.$$delegate_0.parseJsonFile(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readConfigJsonFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonFilePath");
        return this.$$delegate_0.readConfigJsonFile(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public String readStringFromFile(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.$$delegate_0.readStringFromFile(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void removeDir(File r100) {
        Intrinsics.checkNotNullParameter(r100, "fileOrDirectory");
        this.$$delegate_0.removeDir(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean removeFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.$$delegate_0.removeFile(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean renameFile(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "oldPath");
        Intrinsics.checkNotNullParameter(r101, "newPath");
        return this.$$delegate_0.renameFile(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void saveImageToGallery(Context r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "file");
        this.$$delegate_0.saveImageToGallery(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean saveInputStream(InputStream r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_DIR);
        Intrinsics.checkNotNullParameter(r102, "name");
        return this.$$delegate_0.saveInputStream(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void unZipFolder(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "zipFilePath");
        Intrinsics.checkNotNullParameter(r101, "outPath");
        this.$$delegate_0.unZipFolder(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public void updateMediaStore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.$$delegate_0.updateMediaStore(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IFileUtils
    public boolean writeString2File(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "content");
        return this.$$delegate_0.writeString2File(r100, r101);
    }

    static {
        INSTANCE = new StoreManager();
    }

    private StoreManager() {
        this.$$delegate_0 = new FileUtils();
    }
}
