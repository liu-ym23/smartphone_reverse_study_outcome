package com.stepos.common.utils.filestorage;

import P6.BatchQueryStorageObjectResponse;
import P6.DocumentPreviewResponse;
import P6.DownloadUrlResponse;
import P6.UploadRequest;
import P6.UploadResult;
import Ua.C1060i;
import Ua.Y;
import Y8.t;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.common.utils.filestorage.internal.FileStorageApi;
import com.stepos.common.utils.filestorage.internal.GatewayClient;
import com.stepos.common.utils.filestorage.internal.TosUploader;
import com.stepos.common.utils.filestorage.internal.UploadCoordinator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;
import p9.q;
import p9.r;
import tb.z;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001@B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ¯\u0001\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f\u0012\u0004\u0012\u00020\n0\u00142 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u001b2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u001d¢\u0006\u0004\b \u0010!JC\u0010'\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\b'\u0010(JU\u0010-\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00122\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\b-\u0010.Ja\u00102\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00122\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/stepos/common/utils/filestorage/FileStorageManager;", "", "<init>", "()V", "Lcom/stepos/common/utils/filestorage/b;", "config", "Lcom/stepos/common/utils/filestorage/e;", "tokenProvider", "Lcom/stepos/common/utils/filestorage/a;", "headerProvider", "LY8/t;", "m", "(Lcom/stepos/common/utils/filestorage/b;Lcom/stepos/common/utils/filestorage/e;Lcom/stepos/common/utils/filestorage/a;)V", "Landroid/content/Context;", "context", "", "LP6/l;", DidiCardProvider.KEY_ITEMS, "", "taskId", "Lkotlin/Function1;", "", "onTotalProgress", "", "onlyReturnSuccess", "LP6/m;", "onFinished", "Lkotlin/Function3;", "onFileProgress", "Lkotlin/Function4;", "onFileFinished", "Lkotlinx/coroutines/g;", "e", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lp9/l;ZLp9/l;Lp9/q;Lp9/r;)Lkotlinx/coroutines/g;", "fileIds", "LP6/c;", "onSuccess", "", "onError", Const.INTENT_KEY_UMID, "(Ljava/util/List;Lp9/l;Lp9/l;)V", "fileId", "resizePercent", "expiresSeconds", "LP6/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lp9/l;Lp9/l;)V", "dstType", "page", "LP6/f;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lp9/l;Lp9/l;)V", "Lcom/stepos/common/utils/filestorage/FileStorageManager$a;", "l", "()Lcom/stepos/common/utils/filestorage/FileStorageManager$a;", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReference;", "components", "Ljava/util/concurrent/atomic/AtomicReference;", "currentJob", "Ljava/util/concurrent/ConcurrentHashMap;", "concurrentJobs", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileStorageManager {
    private static final String TAG = "FileStorageManager";
    public static final FileStorageManager INSTANCE = new FileStorageManager();
    private static final AtomicReference<Components> components = new AtomicReference<>(null);
    private static final AtomicReference<g> currentJob = new AtomicReference<>(null);
    private static final ConcurrentHashMap<String, g> concurrentJobs = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/common/utils/filestorage/FileStorageManager$a;", "", "Lcom/stepos/common/utils/filestorage/b;", "config", "Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", "api", "Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator;", "coordinator", "<init>", "(Lcom/stepos/common/utils/filestorage/b;Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/common/utils/filestorage/b;", "getConfig", "()Lcom/stepos/common/utils/filestorage/b;", "Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", "Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$a, reason: from toString */
    public static final /* data */ class Components {
        private final FileStorageApi api;
        private final FileStorageConfig config;
        private final UploadCoordinator coordinator;

        public Components(FileStorageConfig config, FileStorageApi api, UploadCoordinator coordinator) {
            p.i(config, "config");
            p.i(api, "api");
            p.i(coordinator, "coordinator");
            this.config = config;
            this.api = api;
            this.coordinator = coordinator;
        }

        /* renamed from: a, reason: from getter */
        public final FileStorageApi getApi() {
            return this.api;
        }

        /* renamed from: b, reason: from getter */
        public final UploadCoordinator getCoordinator() {
            return this.coordinator;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Components)) {
                return false;
            }
            Components components = (Components) other;
            return p.d(this.config, components.config) && p.d(this.api, components.api) && p.d(this.coordinator, components.coordinator);
        }

        public int hashCode() {
            return (((this.config.hashCode() * 31) + this.api.hashCode()) * 31) + this.coordinator.hashCode();
        }

        public String toString() {
            return "Components(config=" + this.config + ", api=" + this.api + ", coordinator=" + this.coordinator + ")";
        }
    }

    public static /* synthetic */ g f(FileStorageManager fileStorageManager, Context context, List list, String str, InterfaceC5074l interfaceC5074l, boolean z10, InterfaceC5074l interfaceC5074l2, q qVar, r rVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = "Task_" + System.currentTimeMillis();
        }
        return fileStorageManager.e(context, list, str, interfaceC5074l, (i10 & 16) != 0 ? false : z10, interfaceC5074l2, (i10 & 64) != 0 ? new q() { // from class: com.stepos.common.utils.filestorage.c
            @Override // p9.q
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return FileStorageManager.g(((Integer) obj2).intValue(), (String) obj3, ((Integer) obj4).intValue());
            }
        } : qVar, (i10 & 128) != 0 ? new r() { // from class: com.stepos.common.utils.filestorage.d
            @Override // p9.r
            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                return FileStorageManager.h(((Integer) obj2).intValue(), (UploadResult) obj3, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
            }
        } : rVar);
    }

    public static final t g(int i10, String str, int i11) {
        p.i(str, "<unused var>");
        return t.f7040a;
    }

    public static final t h(int i10, UploadResult uploadResult, int i11, int i12) {
        p.i(uploadResult, "<unused var>");
        return t.f7040a;
    }

    public static /* synthetic */ void j(FileStorageManager fileStorageManager, String str, Integer num, Integer num2, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i10, Object obj) throws FileStorageException.NotInitialized {
        if ((i10 & 2) != 0) {
            num = null;
        }
        if ((i10 & 4) != 0) {
            num2 = null;
        }
        fileStorageManager.i(str, num, num2, interfaceC5074l, interfaceC5074l2);
    }

    public final void d(List<String> fileIds, InterfaceC5074l<? super BatchQueryStorageObjectResponse, t> onSuccess, InterfaceC5074l<? super Throwable, t> onError) throws FileStorageException.NotInitialized {
        p.i(fileIds, "fileIds");
        p.i(onSuccess, "onSuccess");
        p.i(onError, "onError");
        Components componentsL = l();
        Log.i(TAG, "batchGetObjectDetails count=" + fileIds.size());
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new FileStorageManager$batchGetObjectDetails$1(componentsL, fileIds, onSuccess, onError, null), 3, null);
    }

    public final g e(Context context, List<UploadRequest> items, String taskId, InterfaceC5074l<? super Integer, t> onTotalProgress, boolean onlyReturnSuccess, InterfaceC5074l<? super List<UploadResult>, t> onFinished, q<? super Integer, ? super String, ? super Integer, t> onFileProgress, r<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, t> onFileFinished) throws FileStorageException.NotInitialized {
        p.i(context, "context");
        p.i(items, "items");
        p.i(taskId, "taskId");
        p.i(onTotalProgress, "onTotalProgress");
        p.i(onFinished, "onFinished");
        p.i(onFileProgress, "onFileProgress");
        p.i(onFileFinished, "onFileFinished");
        Components componentsL = l();
        Log.i(TAG, "enqueueBatchUpload taskId=" + taskId + " count=" + items.size());
        g gVarD = C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new FileStorageManager$enqueueBatchUpload$job$1(componentsL, context, items, onlyReturnSuccess, taskId, onTotalProgress, onFileProgress, onFileFinished, onFinished, null), 3, null);
        concurrentJobs.put(taskId, gVarD);
        return gVarD;
    }

    public final void i(String fileId, Integer resizePercent, Integer expiresSeconds, InterfaceC5074l<? super DownloadUrlResponse, t> onSuccess, InterfaceC5074l<? super Throwable, t> onError) throws FileStorageException.NotInitialized {
        p.i(fileId, "fileId");
        p.i(onSuccess, "onSuccess");
        p.i(onError, "onError");
        Components componentsL = l();
        Log.i(TAG, "getDownloadUrl fileId=" + fileId + " resizePercent=" + resizePercent + " expiresSeconds=" + expiresSeconds);
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new FileStorageManager$getDownloadUrl$1(componentsL, fileId, resizePercent, expiresSeconds, onSuccess, onError, null), 3, null);
    }

    public final void k(String fileId, String dstType, Integer expiresSeconds, Integer page, InterfaceC5074l<? super DocumentPreviewResponse, t> onSuccess, InterfaceC5074l<? super Throwable, t> onError) throws FileStorageException.NotInitialized {
        p.i(fileId, "fileId");
        p.i(onSuccess, "onSuccess");
        p.i(onError, "onError");
        Components componentsL = l();
        Log.i(TAG, "getPreviewUrl fileId=" + fileId + " dstType=" + dstType + " expiresSeconds=" + expiresSeconds + " page=" + page);
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new FileStorageManager$getPreviewUrl$1(componentsL, fileId, dstType, expiresSeconds, page, onSuccess, onError, null), 3, null);
    }

    public final Components l() throws FileStorageException.NotInitialized {
        Components components2 = components.get();
        if (components2 != null) {
            return components2;
        }
        throw FileStorageException.NotInitialized.INSTANCE;
    }

    public final void m(FileStorageConfig config, e tokenProvider, a headerProvider) {
        p.i(config, "config");
        p.i(tokenProvider, "tokenProvider");
        p.i(headerProvider, "headerProvider");
        z zVarA = GatewayClient.INSTANCE.a(config);
        z zVarB = TosUploader.INSTANCE.b(config.getTosPutTimeoutMs());
        FileStorageApi fileStorageApi = new FileStorageApi(new GatewayClient(config, tokenProvider, headerProvider, zVarA, null, 16, null));
        components.set(new Components(config, fileStorageApi, new UploadCoordinator(config, fileStorageApi, new TosUploader(zVarB))));
        Log.i(TAG, "FileStorageManager.setup() done. baseUrl=" + config.getGatewayBaseUrl() + ", service=" + config.getServiceName());
    }
}
