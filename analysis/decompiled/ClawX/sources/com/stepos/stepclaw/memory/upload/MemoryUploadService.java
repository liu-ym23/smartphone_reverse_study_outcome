package com.stepos.stepclaw.memory.upload;

import a8.b;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.gateway.d;
import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFileManager;
import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import h5.c;
import h5.e;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;
import m5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000e\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u001f\u0010\u001eJ\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010%R\u0014\u0010,\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/MemoryUploadService;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "baseDir", "Lcom/stepos/stepclaw/memory/upload/MemoryUploadClient;", "uploadClient", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "fileManager", "<init>", "(Ljava/io/File;Lcom/stepos/stepclaw/memory/upload/MemoryUploadClient;Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deviceId", "Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;", "file", "buildObjectKey", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;)Ljava/lang/String;", "Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;)Ljava/lang/String;", "Lcom/stepos/stepclaw/memory/upload/UploadBatchResult;", "result", "Lb5/a0;", "writeUploadDone", "(Lcom/stepos/stepclaw/memory/upload/UploadBatchResult;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isUploadDone", "()Z", "Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;", "getUploadDoneMark", "()Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;", "uploadIfNeeded", "(Lf5/c;)Ljava/lang/Object;", "uploadAll", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/upload/UploadableFile;", "collectUploadableFiles$step_memory_release", "(Ljava/lang/String;)Ljava/util/List;", "collectUploadableFiles", "Ljava/io/File;", "Lcom/stepos/stepclaw/memory/upload/MemoryUploadClient;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "uploadDoneFile", "featureEnable", "Z", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryUploadService {
    private static final String TAG = "MemoryUploadService";
    private static final String UPLOAD_DONE_FILE = "stepmem/.upload_done.json";
    private final File baseDir;
    private final boolean featureEnable;
    private final MemoryFileManager fileManager;
    private final Json json;
    private final MemoryUploadClient uploadClient;
    private final File uploadDoneFile;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.upload.MemoryUploadService", f = "MemoryUploadService.kt", l = {84}, m = "uploadAll", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.upload.MemoryUploadService$uploadAll$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryUploadService.this.uploadAll(this);
        }
    }

    public MemoryUploadService(File baseDir, MemoryUploadClient uploadClient, MemoryFileManager fileManager) {
        p.e(baseDir, "baseDir");
        p.e(uploadClient, "uploadClient");
        p.e(fileManager, "fileManager");
        this.baseDir = baseDir;
        this.uploadClient = uploadClient;
        this.fileManager = fileManager;
        this.json = JsonKt.Json$default(null, new d(10), 1, null);
        this.uploadDoneFile = new File(baseDir, UPLOAD_DONE_FILE);
    }

    private final String buildObjectKey(String deviceId, SingleMemoryFile file) {
        return b.q("memoryHis/", deviceId, "/stepmem/", file.getCategory(), MemoryFile.EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    private final void writeUploadDone(UploadBatchResult result) {
        try {
            boolean z = result.getFailedCount() == 0;
            String string = Instant.now().toString();
            p.d(string, "toString(...)");
            UploadDoneMark uploadDoneMark = new UploadDoneMark(z, string, result.getTotalFiles(), result.getSuccessCount(), result.getFailedCount());
            File parentFile = this.uploadDoneFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            l.G0(this.uploadDoneFile, this.json.encodeToString(UploadDoneMark.INSTANCE.serializer(), uploadDoneMark), x5.a.f6276a);
            ALog.d$default(TAG, ".upload_done.json written: uploaded=" + uploadDoneMark.getUploaded(), null, 4, null);
        } catch (Exception e9) {
            ALog.e(TAG, "writeUploadDone failed", e9);
        }
    }

    public final List<UploadableFile> collectUploadableFiles$step_memory_release(String deviceId) {
        p.e(deviceId, "deviceId");
        ArrayList arrayList = new ArrayList();
        for (SingleMemoryFile singleMemoryFile : this.fileManager.listSingleFiles()) {
            if (singleMemoryFile.getExists()) {
                arrayList.add(new UploadableFile(singleMemoryFile.getFile(), buildObjectKey(deviceId, singleMemoryFile), singleMemoryFile.getCategory(), true));
            }
        }
        List<String> listListCategories = this.fileManager.listCategories();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListCategories) {
            if (!this.fileManager.isSingleFileCategory((String) obj)) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            String str = (String) obj2;
            Iterator<String> it = this.fileManager.listDates(str).iterator();
            while (it.hasNext()) {
                DailyMemoryFile dailyFile = this.fileManager.getDailyFile(str, it.next());
                if (dailyFile.getExists()) {
                    arrayList.add(new UploadableFile(dailyFile.getFile(), buildObjectKey(deviceId, dailyFile), str, false));
                }
            }
        }
        return arrayList;
    }

    public final UploadDoneMark getUploadDoneMark() {
        if (!this.uploadDoneFile.exists()) {
            return null;
        }
        try {
            Json json = this.json;
            String strE0 = l.E0(this.uploadDoneFile, x5.a.f6276a);
            json.getSerializersModule();
            return (UploadDoneMark) json.decodeFromString(UploadDoneMark.INSTANCE.serializer(), strE0);
        } catch (Exception e9) {
            ALog.w$default(TAG, f.c("getUploadDoneMark: parse error: ", e9.getMessage()), null, 4, null);
            return null;
        }
    }

    public final boolean isUploadDone() {
        if (!this.featureEnable) {
            return true;
        }
        if (!this.uploadDoneFile.exists()) {
            return false;
        }
        try {
            Json json = this.json;
            String strE0 = l.E0(this.uploadDoneFile, x5.a.f6276a);
            json.getSerializersModule();
            return ((UploadDoneMark) json.decodeFromString(UploadDoneMark.INSTANCE.serializer(), strE0)).getUploaded();
        } catch (Exception e9) {
            ALog.w$default(TAG, f.c("isUploadDone: failed to read stepmem/.upload_done.json: ", e9.getMessage()), null, 4, null);
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(3:71|12|13)|69|31|(1:33)(1:36)|37|23|(12:25|73|26|27|28|(1:30)|69|31|(0)(0)|37|23|(6:41|(1:43)(3:44|(3:47|(2:86|84)(3:83|52|53)|45)|82)|54|(3:57|(3:60|(2:80|78)(3:77|65|66)|58)|75)|67|68)(0))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2 A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:31:0x00e7, B:33:0x00f2, B:28:0x00de, B:36:0x010d), top: B:69:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010d A[Catch: Exception -> 0x010b, TRY_LEAVE, TryCatch #0 {Exception -> 0x010b, blocks: (B:31:0x00e7, B:33:0x00f2, B:28:0x00de, B:36:0x010d), top: B:69:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00e4 -> B:69:0x00e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0137 -> B:23:0x0092). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadAll(f5.c r17) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.upload.MemoryUploadService.uploadAll(f5.c):java.lang.Object");
    }

    public final Object uploadIfNeeded(f5.c cVar) {
        if (!isUploadDone()) {
            return uploadAll(cVar);
        }
        ALog.d$default(TAG, "uploadIfNeeded: already done, skip", null, 4, null);
        return null;
    }

    private final String buildObjectKey(String deviceId, DailyMemoryFile file) {
        String category = file.getCategory();
        return f.f(b.v("memoryHis/", deviceId, "/stepmem/", category, "/"), file.getDate(), MemoryFile.EXTENSION);
    }
}
