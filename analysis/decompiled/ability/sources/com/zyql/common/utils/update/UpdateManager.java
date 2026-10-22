package com.zyql.common.utils.update;

import C7.r;
import C9.AbstractC0200b;
import D6.i;
import D7.K;
import D7.N;
import J7.c;
import S7.k;
import S7.n;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.compose.material3.MenuKt;
import androidx.core.content.FileProvider;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.task.executor.e;
import com.stepos.taskrobot.llmapi.stepfun.g;
import com.uxsense.parse.b;
import com.zyql.common.utils.update.model.BaseResponse;
import com.zyql.common.utils.update.model.UpdateCheckRequest;
import com.zyql.common.utils.update.model.UpdateCheckResponse;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.AbstractC1607a;
import j9.l;
import j9.m;
import j9.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.text.Regex;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.c0;
import u9.d;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJS\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J[\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u000b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\u0004\b!\u0010\"J;\u0010$\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b$\u0010%J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\b¢\u0006\u0004\b)\u0010\u0003J\u001d\u0010,\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b3\u0010/J\u0015\u00104\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b6\u00107J \u00109\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00108\u001a\u00020\fH\u0082@¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020*H\u0002¢\u0006\u0004\b<\u0010=J!\u0010@\u001a\u0004\u0018\u00010*2\u0006\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020*H\u0002¢\u0006\u0004\b@\u0010AJ!\u0010B\u001a\u0004\u0018\u0001002\u0006\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020*H\u0002¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020&2\u0006\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020*H\u0002¢\u0006\u0004\bD\u0010EJ\"\u0010G\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010F\u001a\u00020*H\u0082@¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bI\u00105R\u0014\u0010J\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010KR\u001c\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010KR$\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR$\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR$\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006`"}, d2 = {"Lcom/zyql/common/utils/update/UpdateManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Lcom/zyql/common/utils/update/UpdateConfig;", "config", "LC7/r;", "init", "(Landroid/content/Context;Lcom/zyql/common/utils/update/UpdateConfig;)V", "Lkotlin/Function1;", "Lcom/zyql/common/utils/update/model/UpdateCheckRequest;", "onRequest", "Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "onResponse", "", "onError", "checkUpdate", "(Landroid/content/Context;LS7/k;LS7/k;LS7/k;)V", "response", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "Ljava/io/File;", "onComplete", "downloadApk", "(Landroid/content/Context;Lcom/zyql/common/utils/update/model/UpdateCheckResponse;LS7/k;LS7/k;LS7/k;)V", "apkFile", "installApk", "(Landroid/content/Context;Ljava/io/File;)V", "Lkotlin/Function0;", "onDownload", "onIgnore", "showUpdateDialog", "(Landroid/content/Context;Lcom/zyql/common/utils/update/model/UpdateCheckResponse;LS7/a;LS7/a;)V", "onNoUpdate", "checkAndDownloadUpdate", "(Landroid/content/Context;LS7/a;LS7/k;)V", "", "isDownloading", "()Z", "stopDownload", "", "packageName", "isAppInstalled", "(Landroid/content/Context;Ljava/lang/String;)Z", "getVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "", "getVersionCode", "(Landroid/content/Context;)J", "getPackageName", "hasInstallPermission", "(Landroid/content/Context;)Z", "requestInstallPermission", "(Landroid/content/Context;)V", "request", "performCheckUpdate", "(Landroid/content/Context;Lcom/zyql/common/utils/update/model/UpdateCheckRequest;LH7/c;)Ljava/lang/Object;", "jsonString", "parseUpdateResponse", "(Ljava/lang/String;)Lcom/zyql/common/utils/update/model/UpdateCheckResponse;", "json", "key", "parseJsonString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "parseJsonLong", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "parseJsonBoolean", "(Ljava/lang/String;Ljava/lang/String;)Z", "downloadUrl", "downloadFile", "(Landroid/content/Context;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "isWiFiConnected", "TAG", "Ljava/lang/String;", "APK_MIME_TYPE", "Ljava/util/concurrent/atomic/AtomicReference;", "Lm9/c0;", "currentJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentConfig", "Lcom/zyql/common/utils/update/UpdateConfig;", "currentVersionCode", "J", "currentPackageName", "onDownloadProgress", "LS7/k;", "onDownloadComplete", "onDownloadFailed", "LC9/b;", "jsonParser", "LC9/b;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateManager {
    private static final String APK_MIME_TYPE = "application/vnd.android.package-archive";
    private static final String TAG = "UpdateManager";
    private static UpdateConfig currentConfig;
    private static long currentVersionCode;
    private static k onDownloadComplete;
    private static k onDownloadFailed;
    private static k onDownloadProgress;
    public static final UpdateManager INSTANCE = new UpdateManager();
    private static final AtomicReference<c0> currentJob = new AtomicReference<>(null);
    private static final AtomicBoolean isStopped = new AtomicBoolean(false);
    private static String currentPackageName = "";
    private static final AbstractC0200b jsonParser = e.b(new b(8));

    @c(c = "com.zyql.common.utils.update.UpdateManager$checkUpdate$2", f = "UpdateManager.kt", l = {114, 115, MenuKt.InTransitionDuration}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.update.UpdateManager$checkUpdate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ Context $context;
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onResponse;
        final /* synthetic */ UpdateCheckRequest $request;
        int label;

        @c(c = "com.zyql.common.utils.update.UpdateManager$checkUpdate$2$1", f = "UpdateManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: com.zyql.common.utils.update.UpdateManager$checkUpdate$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ k $onResponse;
            final /* synthetic */ UpdateCheckResponse $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(k kVar, UpdateCheckResponse updateCheckResponse, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$onResponse = kVar;
                this.$response = updateCheckResponse;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$onResponse, this.$response, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                this.$onResponse.invoke(this.$response);
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "com.zyql.common.utils.update.UpdateManager$checkUpdate$2$2", f = "UpdateManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: com.zyql.common.utils.update.UpdateManager$checkUpdate$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01712 extends SuspendLambda implements n {
            final /* synthetic */ Exception $e;
            final /* synthetic */ k $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01712(k kVar, Exception exc, H7.c<? super C01712> cVar) {
                super(2, cVar);
                this.$onError = kVar;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01712(this.$onError, this.$e, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                this.$onError.invoke(this.$e);
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01712) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, UpdateCheckRequest updateCheckRequest, k kVar, k kVar2, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$context = context;
            this.$request = updateCheckRequest;
            this.$onResponse = kVar;
            this.$onError = kVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$context, this.$request, this.$onResponse, this.$onError, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        
            if (m9.AbstractC1683A.w(r1, r5, r7) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        
            if (m9.AbstractC1683A.w(r1, r4, r7) != r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r7.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L26
                if (r1 == r5) goto L22
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.b.b(r8)
                goto L69
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                kotlin.b.b(r8)     // Catch: java.lang.Exception -> L20
                goto L69
            L20:
                r8 = move-exception
                goto L4e
            L22:
                kotlin.b.b(r8)     // Catch: java.lang.Exception -> L20
                goto L38
            L26:
                kotlin.b.b(r8)
                com.zyql.common.utils.update.UpdateManager r8 = com.zyql.common.utils.update.UpdateManager.INSTANCE     // Catch: java.lang.Exception -> L20
                android.content.Context r1 = r7.$context     // Catch: java.lang.Exception -> L20
                com.zyql.common.utils.update.model.UpdateCheckRequest r6 = r7.$request     // Catch: java.lang.Exception -> L20
                r7.label = r5     // Catch: java.lang.Exception -> L20
                java.lang.Object r8 = com.zyql.common.utils.update.UpdateManager.access$performCheckUpdate(r8, r1, r6, r7)     // Catch: java.lang.Exception -> L20
                if (r8 != r0) goto L38
                goto L68
            L38:
                com.zyql.common.utils.update.model.UpdateCheckResponse r8 = (com.zyql.common.utils.update.model.UpdateCheckResponse) r8     // Catch: java.lang.Exception -> L20
                u9.d r1 = m9.AbstractC1691I.f5315a     // Catch: java.lang.Exception -> L20
                n9.d r1 = s9.k.f6003a     // Catch: java.lang.Exception -> L20
                com.zyql.common.utils.update.UpdateManager$checkUpdate$2$1 r5 = new com.zyql.common.utils.update.UpdateManager$checkUpdate$2$1     // Catch: java.lang.Exception -> L20
                S7.k r6 = r7.$onResponse     // Catch: java.lang.Exception -> L20
                r5.<init>(r6, r8, r2)     // Catch: java.lang.Exception -> L20
                r7.label = r4     // Catch: java.lang.Exception -> L20
                java.lang.Object r7 = m9.AbstractC1683A.w(r1, r5, r7)     // Catch: java.lang.Exception -> L20
                if (r7 != r0) goto L69
                goto L68
            L4e:
                java.lang.String r1 = "UpdateManager"
                java.lang.String r4 = "检查更新失败"
                android.util.Log.e(r1, r4, r8)
                u9.d r1 = m9.AbstractC1691I.f5315a
                n9.d r1 = s9.k.f6003a
                com.zyql.common.utils.update.UpdateManager$checkUpdate$2$2 r4 = new com.zyql.common.utils.update.UpdateManager$checkUpdate$2$2
                S7.k r5 = r7.$onError
                r4.<init>(r5, r8, r2)
                r7.label = r3
                java.lang.Object r7 = m9.AbstractC1683A.w(r1, r4, r7)
                if (r7 != r0) goto L69
            L68:
                return r0
            L69:
                C7.r r7 = C7.r.f317a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.update.UpdateManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.zyql.common.utils.update.UpdateManager$downloadApk$2", f = "UpdateManager.kt", l = {260, 267, 271}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.update.UpdateManager$downloadApk$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13712 extends SuspendLambda implements n {
        final /* synthetic */ Context $context;
        final /* synthetic */ k $onComplete;
        final /* synthetic */ k $onError;
        final /* synthetic */ UpdateCheckResponse $response;
        int label;

        @c(c = "com.zyql.common.utils.update.UpdateManager$downloadApk$2$1", f = "UpdateManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: com.zyql.common.utils.update.UpdateManager$downloadApk$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ File $apkFile;
            final /* synthetic */ k $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(k kVar, File file, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$onComplete = kVar;
                this.$apkFile = file;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$onComplete, this.$apkFile, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                this.$onComplete.invoke(this.$apkFile);
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "com.zyql.common.utils.update.UpdateManager$downloadApk$2$2", f = "UpdateManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: com.zyql.common.utils.update.UpdateManager$downloadApk$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01722 extends SuspendLambda implements n {
            final /* synthetic */ k $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01722(k kVar, H7.c<? super C01722> cVar) {
                super(2, cVar);
                this.$onError = kVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01722(this.$onError, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                this.$onError.invoke(new Exception("下载失败"));
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01722) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13712(Context context, UpdateCheckResponse updateCheckResponse, k kVar, k kVar2, H7.c<? super C13712> cVar) {
            super(2, cVar);
            this.$context = context;
            this.$response = updateCheckResponse;
            this.$onComplete = kVar;
            this.$onError = kVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13712(this.$context, this.$response, this.$onComplete, this.$onError, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0081 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r7.label
                C7.r r2 = C7.r.f317a
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L25
                if (r1 == r5) goto L21
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                kotlin.b.b(r8)
                return r2
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1d:
                kotlin.b.b(r8)
                return r2
            L21:
                kotlin.b.b(r8)
                goto L43
            L25:
                kotlin.b.b(r8)
                java.util.concurrent.atomic.AtomicBoolean r8 = com.zyql.common.utils.update.UpdateManager.access$isStopped$p()
                r1 = 0
                r8.set(r1)
                com.zyql.common.utils.update.UpdateManager r8 = com.zyql.common.utils.update.UpdateManager.INSTANCE
                android.content.Context r1 = r7.$context
                com.zyql.common.utils.update.model.UpdateCheckResponse r6 = r7.$response
                java.lang.String r6 = r6.getDownloadUrl()
                r7.label = r5
                java.lang.Object r8 = com.zyql.common.utils.update.UpdateManager.access$downloadFile(r8, r1, r6, r7)
                if (r8 != r0) goto L43
                goto L81
            L43:
                java.io.File r8 = (java.io.File) r8
                java.util.concurrent.atomic.AtomicBoolean r1 = com.zyql.common.utils.update.UpdateManager.access$isStopped$p()
                boolean r1 = r1.get()
                if (r1 == 0) goto L57
                java.lang.String r7 = "UpdateManager"
                java.lang.String r8 = "下载已取消"
                android.util.Log.i(r7, r8)
                return r2
            L57:
                r1 = 0
                if (r8 == 0) goto L6e
                u9.d r3 = m9.AbstractC1691I.f5315a
                n9.d r3 = s9.k.f6003a
                com.zyql.common.utils.update.UpdateManager$downloadApk$2$1 r5 = new com.zyql.common.utils.update.UpdateManager$downloadApk$2$1
                S7.k r6 = r7.$onComplete
                r5.<init>(r6, r8, r1)
                r7.label = r4
                java.lang.Object r7 = m9.AbstractC1683A.w(r3, r5, r7)
                if (r7 != r0) goto L82
                goto L81
            L6e:
                u9.d r8 = m9.AbstractC1691I.f5315a
                n9.d r8 = s9.k.f6003a
                com.zyql.common.utils.update.UpdateManager$downloadApk$2$2 r4 = new com.zyql.common.utils.update.UpdateManager$downloadApk$2$2
                S7.k r5 = r7.$onError
                r4.<init>(r5, r1)
                r7.label = r3
                java.lang.Object r7 = m9.AbstractC1683A.w(r8, r4, r7)
                if (r7 != r0) goto L82
            L81:
                return r0
            L82:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.update.UpdateManager.C13712.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13712) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.zyql.common.utils.update.UpdateManager$downloadFile$2", f = "UpdateManager.kt", l = {332}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Ljava/io/File;", "<anonymous>", "(Lm9/z;)Ljava/io/File;"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.update.UpdateManager$downloadFile$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13722 extends SuspendLambda implements n {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $downloadUrl;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13722(String str, Context context, H7.c<? super C13722> cVar) {
            super(2, cVar);
            this.$downloadUrl = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13722(this.$downloadUrl, this.$context, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00d5 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:6:0x002e, B:23:0x00cc, B:25:0x00d5, B:27:0x00df, B:30:0x00ec, B:32:0x00fa, B:34:0x0102, B:22:0x00bd), top: B:50:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0131  */
        /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0129 -> B:38:0x012c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 344
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.update.UpdateManager.C13722.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super File> cVar) {
            return ((C13722) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private UpdateManager() {
    }

    public static /* synthetic */ void checkAndDownloadUpdate$default(UpdateManager updateManager, Context context, S7.a aVar, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = new com.uxsense.parse.a(15);
        }
        if ((i & 4) != 0) {
            kVar = new b(10);
        }
        updateManager.checkAndDownloadUpdate(context, aVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$15(Throwable it) {
        kotlin.jvm.internal.k.f(it, "it");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$16(UpdateCheckRequest it) {
        kotlin.jvm.internal.k.f(it, "it");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24(S7.a aVar, Context context, k kVar, UpdateCheckResponse response) {
        kotlin.jvm.internal.k.f(response, "response");
        boolean hasUpdate = response.getHasUpdate();
        r rVar = r.f317a;
        if (hasUpdate) {
            INSTANCE.showUpdateDialog(context, response, new androidx.compose.runtime.changelist.b(context, response, kVar, 4), new com.uxsense.parse.a(18));
            return rVar;
        }
        aVar.invoke();
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24$lambda$22(Context context, UpdateCheckResponse updateCheckResponse, k kVar) {
        UpdateProgressDialog updateProgressDialog = new UpdateProgressDialog(context, updateCheckResponse.getForceUpdate());
        updateProgressDialog.setOnCancelListener(new i(updateProgressDialog, 26));
        updateProgressDialog.show();
        INSTANCE.downloadApk(context, updateCheckResponse, new g(updateProgressDialog, 2), new R3.b(23, updateProgressDialog, context), new R3.b(24, updateProgressDialog, kVar));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24$lambda$22$lambda$17(UpdateProgressDialog updateProgressDialog) {
        INSTANCE.stopDownload();
        updateProgressDialog.dismiss();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24$lambda$22$lambda$18(UpdateProgressDialog updateProgressDialog, int i) {
        updateProgressDialog.setProgress(i);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24$lambda$22$lambda$20(UpdateProgressDialog updateProgressDialog, Context context, File apkFile) {
        kotlin.jvm.internal.k.f(apkFile, "apkFile");
        updateProgressDialog.onDownloadComplete();
        new Handler(Looper.getMainLooper()).postDelayed(new A4.e(updateProgressDialog, context, apkFile, 7), 500L);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndDownloadUpdate$lambda$24$lambda$22$lambda$20$lambda$19(UpdateProgressDialog updateProgressDialog, Context context, File file) {
        updateProgressDialog.dismiss();
        INSTANCE.installApk(context, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkAndDownloadUpdate$lambda$24$lambda$22$lambda$21(UpdateProgressDialog updateProgressDialog, k kVar, Throwable error) {
        kotlin.jvm.internal.k.f(error, "error");
        updateProgressDialog.dismiss();
        kVar.invoke(error);
        return r.f317a;
    }

    public static /* synthetic */ void checkUpdate$default(UpdateManager updateManager, Context context, k kVar, k kVar2, k kVar3, int i, Object obj) {
        if ((i & 8) != 0) {
            kVar3 = new b(11);
        }
        updateManager.checkUpdate(context, kVar, kVar2, kVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r checkUpdate$lambda$1(Throwable it) {
        kotlin.jvm.internal.k.f(it, "it");
        return r.f317a;
    }

    public static /* synthetic */ void downloadApk$default(UpdateManager updateManager, Context context, UpdateCheckResponse updateCheckResponse, k kVar, k kVar2, k kVar3, int i, Object obj) {
        if ((i & 16) != 0) {
            kVar3 = new b(9);
        }
        updateManager.downloadApk(context, updateCheckResponse, kVar, kVar2, kVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r downloadApk$lambda$7(Throwable it) {
        kotlin.jvm.internal.k.f(it, "it");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(Context context, String str, H7.c<? super File> cVar) {
        return AbstractC1683A.f(new C13722(str, context, null), cVar);
    }

    public static /* synthetic */ void init$default(UpdateManager updateManager, Context context, UpdateConfig updateConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            updateConfig = new UpdateConfig(null, 0L, null, false, false, 31, null);
        }
        updateManager.init(context, updateConfig);
    }

    private final boolean isWiFiConnected(Context context) {
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r jsonParser$lambda$0(C9.g Json) {
        kotlin.jvm.internal.k.f(Json, "$this$Json");
        Json.c = true;
        Json.f325a = true;
        Json.g = true;
        Json.d = true;
        return r.f317a;
    }

    private final boolean parseJsonBoolean(String json, String key) {
        l lVarB = new Regex(B7.a.m("\"", key, "\"\\s*:\\s*(true|false)")).b(json);
        return kotlin.jvm.internal.k.b(lVarB != null ? (String) ((K) lVarB.a()).get(1) : null, "true");
    }

    private final Long parseJsonLong(String json, String key) {
        String str;
        l lVarB = new Regex(B7.a.m("\"", key, "\"\\s*:\\s*(\\d+)")).b(json);
        if (lVarB == null || (str = (String) ((K) lVarB.a()).get(1)) == null) {
            return null;
        }
        return t.g0(str);
    }

    private final String parseJsonString(String json, String key) {
        l lVarB = new Regex(B7.a.m("\"", key, "\"\\s*:\\s*\"([^\"]+)\"")).b(json);
        if (lVarB != null) {
            return (String) ((K) lVarB.a()).get(1);
        }
        return null;
    }

    private final UpdateCheckResponse parseUpdateResponse(String jsonString) {
        Log.d(TAG, "解析更新响应: " + jsonString);
        boolean z10 = false;
        if (t.e0(m.R0(jsonString).toString(), "{", false)) {
            if (m.h0(jsonString, "\"hasUpdate\"", false) && m.h0(jsonString, "true", false)) {
                z10 = true;
            }
            return new UpdateCheckResponse(z10, parseJsonLong(jsonString, "newVersionCode"), parseJsonString(jsonString, "newVersionName"), parseJsonString(jsonString, "updateDescription"), parseJsonBoolean(jsonString, "forceUpdate"), parseJsonString(jsonString, "downloadUrl"), parseJsonLong(jsonString, "apkSize"), parseJsonString(jsonString, "md5"));
        }
        return new UpdateCheckResponse(false, (Long) null, (String) null, (String) null, false, (String) null, (Long) null, (String) null, 254, (kotlin.jvm.internal.e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performCheckUpdate(Context context, UpdateCheckRequest updateCheckRequest, H7.c<? super UpdateCheckResponse> cVar) throws IOException {
        BufferedReader bufferedReader;
        UpdateConfig updateConfig = currentConfig;
        if (updateConfig == null) {
            throw new IllegalStateException("UpdateManager 未初始化");
        }
        URLConnection uRLConnectionOpenConnection = new URL(updateConfig.getCheckUpdateUrl()).openConnection();
        kotlin.jvm.internal.k.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout((int) updateConfig.getTimeout());
                httpURLConnection.setReadTimeout((int) updateConfig.getTimeout());
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                AbstractC0200b abstractC0200b = jsonParser;
                abstractC0200b.getClass();
                String strB = abstractC0200b.b(UpdateCheckRequest.INSTANCE.serializer(), updateCheckRequest);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    Charset charset = AbstractC1607a.f4778a;
                    byte[] bytes = strB.getBytes(charset);
                    kotlin.jvm.internal.k.e(bytes, "getBytes(...)");
                    outputStream.write(bytes);
                    outputStream.flush();
                    String str = null;
                    N.t(outputStream, null);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        if (errorStream != null) {
                            bufferedReader = new BufferedReader(new InputStreamReader(errorStream, charset), 8192);
                            try {
                                String strO1 = S0.b.o1(bufferedReader);
                                bufferedReader.close();
                                str = strO1;
                            } finally {
                            }
                        }
                        if (str == null) {
                            str = "No detail";
                        }
                        throw new IOException("HTTP " + responseCode + ": " + str);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    kotlin.jvm.internal.k.e(inputStream, "getInputStream(...)");
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
                    try {
                        String strO12 = S0.b.o1(bufferedReader);
                        bufferedReader.close();
                        abstractC0200b.getClass();
                        BaseResponse baseResponse = (BaseResponse) abstractC0200b.a(BaseResponse.INSTANCE.serializer(UpdateCheckResponse.INSTANCE.serializer()), strO12);
                        if (!baseResponse.isSuccess()) {
                            throw new IOException("业务错误: " + baseResponse.getCode() + ", " + baseResponse.getMsg());
                        }
                        UpdateCheckResponse updateCheckResponse = (UpdateCheckResponse) baseResponse.getData();
                        if (updateCheckResponse == null) {
                            updateCheckResponse = new UpdateCheckResponse(false, (Long) null, (String) null, (String) null, false, (String) null, (Long) null, (String) null, 254, (kotlin.jvm.internal.e) null);
                        }
                        return updateCheckResponse;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } finally {
                }
            } catch (Exception e) {
                Log.e(TAG, "POST 请求失败: " + updateConfig.getCheckUpdateUrl(), e);
                throw e;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static /* synthetic */ void showUpdateDialog$default(UpdateManager updateManager, Context context, UpdateCheckResponse updateCheckResponse, S7.a aVar, S7.a aVar2, int i, Object obj) {
        if ((i & 4) != 0) {
            aVar = new com.uxsense.parse.a(16);
        }
        if ((i & 8) != 0) {
            aVar2 = new com.uxsense.parse.a(17);
        }
        updateManager.showUpdateDialog(context, updateCheckResponse, aVar, aVar2);
    }

    public final void checkAndDownloadUpdate(Context context, S7.a onNoUpdate, k onError) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(onNoUpdate, "onNoUpdate");
        kotlin.jvm.internal.k.f(onError, "onError");
        checkUpdate(context, new b(12), new R3.k(onNoUpdate, context, onError, 10), onError);
    }

    public final void checkUpdate(Context context, k onRequest, k onResponse, k onError) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(onRequest, "onRequest");
        kotlin.jvm.internal.k.f(onResponse, "onResponse");
        kotlin.jvm.internal.k.f(onError, "onError");
        if (currentConfig == null) {
            onError.invoke(new IllegalStateException("UpdateManager 未初始化，请先调用 init()"));
            return;
        }
        long j5 = currentVersionCode;
        String versionName = getVersionName(context);
        if (versionName == null) {
            versionName = "";
        }
        UpdateCheckRequest updateCheckRequest = new UpdateCheckRequest(j5, versionName, currentPackageName);
        onRequest.invoke(updateCheckRequest);
        d dVar = AbstractC1691I.f5315a;
        AbstractC1683A.n(AbstractC1683A.b(u9.c.f6743a), null, new AnonymousClass2(context, updateCheckRequest, onResponse, onError, null), 3);
    }

    public final void downloadApk(Context context, UpdateCheckResponse response, k onProgress, k onComplete, k onError) {
        String downloadUrl;
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(response, "response");
        kotlin.jvm.internal.k.f(onProgress, "onProgress");
        kotlin.jvm.internal.k.f(onComplete, "onComplete");
        kotlin.jvm.internal.k.f(onError, "onError");
        if (!response.getHasUpdate() || (downloadUrl = response.getDownloadUrl()) == null || m.s0(downloadUrl)) {
            onError.invoke(new IllegalArgumentException("没有可下载的更新"));
            return;
        }
        UpdateConfig updateConfig = currentConfig;
        if (updateConfig != null && updateConfig.getWifiOnly() && !isWiFiConnected(context)) {
            onError.invoke(new Exception("当前为移动网络，请在 WiFi 下下载"));
            return;
        }
        onDownloadProgress = onProgress;
        onDownloadComplete = onComplete;
        onDownloadFailed = onError;
        d dVar = AbstractC1691I.f5315a;
        AbstractC1683A.n(AbstractC1683A.b(u9.c.f6743a), null, new C13712(context, response, onComplete, onError, null), 3);
    }

    public final String getPackageName(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        String packageName = context.getPackageName();
        kotlin.jvm.internal.k.e(packageName, "getPackageName(...)");
        return packageName;
    }

    public final long getVersionCode(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException unused) {
            return 0L;
        }
    }

    public final String getVersionName(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean hasInstallPermission(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        return Environment.isExternalStorageManager();
    }

    public final void init(Context context, UpdateConfig config) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(config, "config");
        currentConfig = config;
        currentVersionCode = getVersionCode(context);
        String packageName = getPackageName(context);
        currentPackageName = packageName;
        Log.i(TAG, "UpdateManager 初始化完成, versionCode=" + currentVersionCode + ", packageName=" + packageName);
    }

    public final void installApk(Context context, File apkFile) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(apkFile, "apkFile");
        if (!apkFile.exists()) {
            Log.e(TAG, "APK 文件不存在: " + apkFile.getPath());
            return;
        }
        try {
            if (context.getPackageManager().getPackageArchiveInfo(apkFile.getPath(), 1) == null) {
                Log.e(TAG, "APK 不是有效的应用包");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", apkFile), APK_MIME_TYPE);
            try {
                context.startActivity(intent);
                Log.i(TAG, "开始安装 APK: " + apkFile.getPath());
            } catch (Exception e) {
                Log.e(TAG, "启动安装失败", e);
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.fromFile(apkFile), APK_MIME_TYPE);
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } catch (Exception e6) {
                    Log.e(TAG, "无法启动安装", e6);
                }
            }
        } catch (Exception e9) {
            Log.e(TAG, "无法读取 APK 信息", e9);
        }
    }

    public final boolean isAppInstalled(Context context, String packageName) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(packageName, "packageName");
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isDownloading() {
        c0 c0Var = currentJob.get();
        return c0Var != null && c0Var.isActive();
    }

    public final void requestInstallPermission(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        if (context.getPackageManager().canRequestPackageInstalls()) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
        }
    }

    public final void showUpdateDialog(Context context, UpdateCheckResponse response, final S7.a onDownload, final S7.a onIgnore) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(response, "response");
        kotlin.jvm.internal.k.f(onDownload, "onDownload");
        kotlin.jvm.internal.k.f(onIgnore, "onIgnore");
        String str = response.getForceUpdate() ? "发现新版本" : "更新可用";
        String updateDescription = response.getUpdateDescription();
        if (updateDescription == null) {
            updateDescription = "有新版本可用，是否更新？";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(updateDescription);
        if (!response.getForceUpdate()) {
            final int i = 0;
            builder.setPositiveButton("稍后", new DialogInterface.OnClickListener() { // from class: com.zyql.common.utils.update.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i6) {
                    int i10 = i;
                    S7.a aVar = onIgnore;
                    switch (i10) {
                        case 0:
                            aVar.invoke();
                            break;
                        default:
                            aVar.invoke();
                            break;
                    }
                }
            });
        }
        final int i6 = 1;
        builder.setNegativeButton("立即更新", new DialogInterface.OnClickListener() { // from class: com.zyql.common.utils.update.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i62) {
                int i10 = i6;
                S7.a aVar = onDownload;
                switch (i10) {
                    case 0:
                        aVar.invoke();
                        break;
                    default:
                        aVar.invoke();
                        break;
                }
            }
        });
        builder.show();
    }

    public final void stopDownload() {
        isStopped.set(true);
        c0 andSet = currentJob.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(null);
        }
        Log.i(TAG, "停止下载");
    }
}
