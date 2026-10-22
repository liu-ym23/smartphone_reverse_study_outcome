package com.zyql.common.utils.upload;

import C7.r;
import D7.w;
import H4.o;
import J7.c;
import S7.n;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.volcengine.tos.TOSV2;
import j9.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.sync.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.c0;
import u9.d;
import w9.InterfaceC2108a;
import w9.f;
import w9.g;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u000245B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006JH\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017Je\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u000101008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/zyql/common/utils/upload/UploadManager;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "checkInit", "(LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "", "bucket", "", "Lcom/zyql/common/utils/upload/UploadManager$UploadTask;", "tasks", "Lkotlin/Function1;", "", "onTotalProgress", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "uploadBatchInternal", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;LS7/k;LH7/c;)Ljava/lang/Object;", "Lcom/zyql/common/utils/upload/UploadConfig;", "config", "setup", "(Lcom/zyql/common/utils/upload/UploadConfig;)V", "urlList", "", "onlyReturnSuccess", "onFinished", "startBatchUpload", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;LS7/k;ZLS7/k;)V", "stop", "isUploading", "()Z", "TAG", "Ljava/lang/String;", "MAX_RETRY", "I", "CONCURRENCY", "Lcom/volcengine/tos/TOSV2;", "tosClient", "Lcom/volcengine/tos/TOSV2;", "initialized", "Z", "Lw9/a;", "initMutex", "Lw9/a;", "currentConfig", "Lcom/zyql/common/utils/upload/UploadConfig;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lm9/c0;", "currentJob", "Ljava/util/concurrent/atomic/AtomicReference;", "UploadTask", "UploadResult", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadManager {
    private static final int CONCURRENCY = 5;
    private static final int MAX_RETRY = 3;
    private static final String TAG = "UploadManager";
    private static boolean initialized;
    private static TOSV2 tosClient;
    public static final UploadManager INSTANCE = new UploadManager();
    private static final InterfaceC2108a initMutex = new a();
    private static UploadConfig currentConfig = new UploadConfig(null, null, null, null, null, false, null, 0, 0, 511, null);
    private static final AtomicReference<c0> currentJob = new AtomicReference<>(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "", "sourcePath", "", BffConstant.Type.Url, "success", "", "error", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Throwable;)V", "getSourcePath", "()Ljava/lang/String;", "getUrl", "getSuccess", "()Z", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class UploadResult {
        private final Throwable error;
        private final String sourcePath;
        private final boolean success;
        private final String url;

        public UploadResult(String sourcePath, String str, boolean z10, Throwable th) {
            k.f(sourcePath, "sourcePath");
            this.sourcePath = sourcePath;
            this.url = str;
            this.success = z10;
            this.error = th;
        }

        public static /* synthetic */ UploadResult copy$default(UploadResult uploadResult, String str, String str2, boolean z10, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uploadResult.sourcePath;
            }
            if ((i & 2) != 0) {
                str2 = uploadResult.url;
            }
            if ((i & 4) != 0) {
                z10 = uploadResult.success;
            }
            if ((i & 8) != 0) {
                th = uploadResult.error;
            }
            return uploadResult.copy(str, str2, z10, th);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSourcePath() {
            return this.sourcePath;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component4, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final UploadResult copy(String sourcePath, String url, boolean success, Throwable error) {
            k.f(sourcePath, "sourcePath");
            return new UploadResult(sourcePath, url, success, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadResult)) {
                return false;
            }
            UploadResult uploadResult = (UploadResult) other;
            return k.b(this.sourcePath, uploadResult.sourcePath) && k.b(this.url, uploadResult.url) && this.success == uploadResult.success && k.b(this.error, uploadResult.error);
        }

        public final Throwable getError() {
            return this.error;
        }

        public final String getSourcePath() {
            return this.sourcePath;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = this.sourcePath.hashCode() * 31;
            String str = this.url;
            int iD = androidx.appfunctions.metadata.a.d((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.success);
            Throwable th = this.error;
            return iD + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            String str = this.sourcePath;
            String str2 = this.url;
            boolean z10 = this.success;
            Throwable th = this.error;
            StringBuilder sbW = B7.a.w("UploadResult(sourcePath=", str, ", url=", str2, ", success=");
            sbW.append(z10);
            sbW.append(", error=");
            sbW.append(th);
            sbW.append(")");
            return sbW.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/zyql/common/utils/upload/UploadManager$UploadTask;", "", "uriOrPath", "", "objectKey", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getUriOrPath", "()Ljava/lang/String;", "getObjectKey", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class UploadTask {
        private final String objectKey;
        private final String uriOrPath;

        public UploadTask(String uriOrPath, String objectKey) {
            k.f(uriOrPath, "uriOrPath");
            k.f(objectKey, "objectKey");
            this.uriOrPath = uriOrPath;
            this.objectKey = objectKey;
        }

        public static /* synthetic */ UploadTask copy$default(UploadTask uploadTask, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uploadTask.uriOrPath;
            }
            if ((i & 2) != 0) {
                str2 = uploadTask.objectKey;
            }
            return uploadTask.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUriOrPath() {
            return this.uriOrPath;
        }

        /* renamed from: component2, reason: from getter */
        public final String getObjectKey() {
            return this.objectKey;
        }

        public final UploadTask copy(String uriOrPath, String objectKey) {
            k.f(uriOrPath, "uriOrPath");
            k.f(objectKey, "objectKey");
            return new UploadTask(uriOrPath, objectKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadTask)) {
                return false;
            }
            UploadTask uploadTask = (UploadTask) other;
            return k.b(this.uriOrPath, uploadTask.uriOrPath) && k.b(this.objectKey, uploadTask.objectKey);
        }

        public final String getObjectKey() {
            return this.objectKey;
        }

        public final Uri getUri() {
            if (t.e0(this.uriOrPath, "content://", false) || t.e0(this.uriOrPath, "file://", false)) {
                return Uri.parse(this.uriOrPath);
            }
            Uri uriFromFile = Uri.fromFile(new File(this.uriOrPath));
            k.c(uriFromFile);
            return uriFromFile;
        }

        public final String getUriOrPath() {
            return this.uriOrPath;
        }

        public int hashCode() {
            return this.objectKey.hashCode() + (this.uriOrPath.hashCode() * 31);
        }

        public String toString() {
            return androidx.appfunctions.metadata.a.m("UploadTask(uriOrPath=", this.uriOrPath, ", objectKey=", this.objectKey, ")");
        }
    }

    @c(c = "com.zyql.common.utils.upload.UploadManager", f = "UploadManager.kt", l = {247}, m = "checkInit")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.zyql.common.utils.upload.UploadManager$checkInit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadManager.this.checkInit(this);
        }
    }

    @c(c = "com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2", f = "UploadManager.kt", l = {221}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $bucket;
        final /* synthetic */ Context $context;
        final /* synthetic */ S7.k $onTotalProgress;
        final /* synthetic */ List<UploadTask> $tasks;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<UploadTask> list, Context context, String str, S7.k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$tasks = list;
            this.$context = context;
            this.$bucket = str;
            this.$onTotalProgress = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$tasks, this.$context, this.$bucket, this.$onTotalProgress, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            int size = this.$tasks.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            int i6 = g.f6856a;
            f fVar = new f(5);
            List<UploadTask> list = this.$tasks;
            Context context = this.$context;
            String str = this.$bucket;
            S7.k kVar = this.$onTotalProgress;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC1683A.d(interfaceC1733z, null, new UploadManager$uploadBatchInternal$2$1$1(fVar, (UploadTask) it.next(), context, str, atomicInteger, size, kVar, null), 3));
            }
            this.label = 1;
            Object objB = kotlinx.coroutines.a.b(arrayList, this);
            return objB == coroutineSingletons ? coroutineSingletons : objB;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<UploadResult>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private UploadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkInit(H7.c<? super C7.r> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "TOS 初始化完成: Region="
            boolean r1 = r9 instanceof com.zyql.common.utils.upload.UploadManager.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r9
            com.zyql.common.utils.upload.UploadManager$checkInit$1 r1 = (com.zyql.common.utils.upload.UploadManager.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.zyql.common.utils.upload.UploadManager$checkInit$1 r1 = new com.zyql.common.utils.upload.UploadManager$checkInit$1
            r1.<init>(r9)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r1.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r9 = r1.L$0
            w9.a r9 = (w9.InterfaceC2108a) r9
            kotlin.b.b(r8)
            goto L4e
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.b.b(r8)
            boolean r8 = com.zyql.common.utils.upload.UploadManager.initialized
            if (r8 == 0) goto L40
            return r3
        L40:
            w9.a r8 = com.zyql.common.utils.upload.UploadManager.initMutex
            r1.L$0 = r8
            r1.label = r4
            java.lang.Object r1 = r8.lock(r5, r1)
            if (r1 != r9) goto L4d
            return r9
        L4d:
            r9 = r8
        L4e:
            boolean r8 = com.zyql.common.utils.upload.UploadManager.initialized     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L56
            r9.unlock(r5)
            return r3
        L56:
            com.volcengine.tos.TOSV2ClientBuilder r8 = new com.volcengine.tos.TOSV2ClientBuilder     // Catch: java.lang.Throwable -> L96
            r8.<init>()     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadConfig r1 = com.zyql.common.utils.upload.UploadManager.currentConfig     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = r1.getRegion()     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadConfig r2 = com.zyql.common.utils.upload.UploadManager.currentConfig     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r2.getStsEndPoint()     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadConfig r6 = com.zyql.common.utils.upload.UploadManager.currentConfig     // Catch: java.lang.Throwable -> L96
            java.lang.String r6 = r6.getAccessKey()     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadConfig r7 = com.zyql.common.utils.upload.UploadManager.currentConfig     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r7.getSecretKey()     // Catch: java.lang.Throwable -> L96
            com.volcengine.tos.TOSV2 r8 = r8.build(r1, r2, r6, r7)     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadManager.tosClient = r8     // Catch: java.lang.Throwable -> L96
            com.zyql.common.utils.upload.UploadManager.initialized = r4     // Catch: java.lang.Throwable -> L96
            java.lang.String r8 = "UploadManager"
            com.zyql.common.utils.upload.UploadConfig r1 = com.zyql.common.utils.upload.UploadManager.currentConfig     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = r1.getRegion()     // Catch: java.lang.Throwable -> L96
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L96
            r2.append(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L96
            android.util.Log.i(r8, r0)     // Catch: java.lang.Throwable -> L96
            r9.unlock(r5)
            return r3
        L96:
            r8 = move-exception
            r9.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.upload.UploadManager.checkInit(H7.c):java.lang.Object");
    }

    public static /* synthetic */ void startBatchUpload$default(UploadManager uploadManager, Context context, List list, String str, S7.k kVar, boolean z10, S7.k kVar2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = currentConfig.getDefaultBucket();
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z10 = false;
        }
        uploadManager.startBatchUpload(context, list, str2, kVar, z10, kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadBatchInternal(Context context, String str, List<UploadTask> list, S7.k kVar, H7.c<? super List<UploadResult>> cVar) {
        return AbstractC1683A.f(new AnonymousClass2(list, context, str, kVar, null), cVar);
    }

    public final boolean isUploading() {
        c0 c0Var = currentJob.get();
        return c0Var != null && c0Var.isActive();
    }

    public final void setup(UploadConfig config) {
        k.f(config, "config");
        currentConfig = config;
        initialized = false;
    }

    public final void startBatchUpload(Context context, List<String> urlList, String bucket, S7.k onTotalProgress, boolean onlyReturnSuccess, S7.k onFinished) {
        k.f(context, "context");
        k.f(urlList, "urlList");
        k.f(bucket, "bucket");
        k.f(onTotalProgress, "onTotalProgress");
        k.f(onFinished, "onFinished");
        stop();
        List<String> list = urlList;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            String str = (String) obj;
            Pair<String, String> fileNameAndSuffixFromUri = FileNameUtilKt.getFileNameAndSuffixFromUri(context, str);
            Log.i(TAG, "开始处理: fileNameAndSuffix: " + fileNameAndSuffixFromUri);
            arrayList.add(new UploadTask(str, "upload/" + fileNameAndSuffixFromUri.f4886a + "_" + System.currentTimeMillis() + "_" + i + "." + fileNameAndSuffixFromUri.b));
            i = i6;
        }
        d dVar = AbstractC1691I.f5315a;
        currentJob.set(AbstractC1683A.n(AbstractC1683A.b(u9.c.f6743a), null, new UploadManager$startBatchUpload$job$1(context, bucket, arrayList, onTotalProgress, onlyReturnSuccess, onFinished, null), 3));
    }

    public final void stop() {
        c0 andSet = currentJob.getAndSet(null);
        if (andSet == null || !andSet.isActive()) {
            return;
        }
        Log.i(TAG, "停止上传任务");
        andSet.cancel(null);
    }
}
