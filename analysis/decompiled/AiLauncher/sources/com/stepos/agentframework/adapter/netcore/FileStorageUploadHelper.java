package com.stepos.agentframework.adapter.netcore;

import P6.UploadRequest;
import P6.UploadResult;
import Ua.InterfaceC1066l;
import Z8.C1172u;
import Z8.C1173v;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.utils.filestorage.FileStorageConfig;
import com.stepos.common.utils.filestorage.FileStorageManager;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.TimeoutKt;
import l9.C4877a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJP\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2.\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014JP\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152.\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 JP\u0010\"\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00102.\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0082@¢\u0006\u0004\b\"\u0010#JP\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00102.\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0082@¢\u0006\u0004\b%\u0010#JH\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020$2.\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0082@¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003R\u0014\u0010-\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/FileStorageUploadHelper;", "", "<init>", "()V", "Lcom/stepos/agentframework/adapter/netcore/k;", "config", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/adapter/netcore/k;)V", "Landroid/content/Context;", "context", "Ljava/io/File;", Const.STR_FILE, "Lkotlin/Function5;", "", "", "", "", "onProgress", "l", "(Landroid/content/Context;Ljava/io/File;Lp9/s;Le9/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "uri", "n", "(Landroid/content/Context;Landroid/net/Uri;Lp9/s;Le9/c;)Ljava/lang/Object;", "", "cause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Throwable;)Z", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Landroid/net/Uri;)Ljava/io/File;", "k", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "uriOrPath", "e", "(Landroid/content/Context;Ljava/lang/String;Lp9/s;Le9/c;)Ljava/lang/Object;", "LP6/m;", "m", "result", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LP6/m;Lp9/s;Le9/c;)Ljava/lang/Object;", "fileId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "f", "TAG", "Ljava/lang/String;", "UPLOAD_TIMEOUT_MS", "J", "DOWNLOAD_URL_TIMEOUT_MS", "initialized", "Z", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorageUploadHelper {
    private static final long DOWNLOAD_URL_TIMEOUT_MS = 15000;
    public static final FileStorageUploadHelper INSTANCE = new FileStorageUploadHelper();
    private static final String TAG = "FileStorageUploadHelper";
    private static final long UPLOAD_TIMEOUT_MS = 120000;
    private static volatile boolean initialized;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.common.utils.filestorage.e {
        final /* synthetic */ FileStorageConfig $config;

        public a(FileStorageConfig fileStorageConfig) {
            this.$config = fileStorageConfig;
        }

        @Override // com.stepos.common.utils.filestorage.e
        public final Object a(InterfaceC4014c<? super String> interfaceC4014c) {
            return this.$config.getTokenProvider().a(interfaceC4014c);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Integer, Y8.t> {
        final /* synthetic */ p9.s<Integer, Boolean, String, String, Long, Y8.t> $onProgress;

        /* JADX WARN: Multi-variable type inference failed */
        public b(p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar) {
            this.$onProgress = sVar;
        }

        public final void a(int i10) {
            if (i10 < 0 || i10 >= 100) {
                return;
            }
            this.$onProgress.invoke(Integer.valueOf(i10), Boolean.FALSE, "", null, null);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Integer num) {
            a(num.intValue());
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5074l<List<? extends UploadResult>, Y8.t> {
        final /* synthetic */ InterfaceC1066l<UploadResult> $cont;

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC1066l<? super UploadResult> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        public final void a(List<UploadResult> results) {
            kotlin.jvm.internal.p.i(results, "results");
            UploadResult uploadResult = (UploadResult) Z8.F.s0(results);
            if (uploadResult != null) {
                this.$cont.resumeWith(Result.b(uploadResult));
                return;
            }
            InterfaceC1066l<UploadResult> interfaceC1066l = this.$cont;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(new IllegalStateException("FileStorage 上传无返回结果"))));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(List<? extends UploadResult> list) {
            a(list);
            return Y8.t.f7040a;
        }
    }

    public final File d(Context context, Uri uri) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        String strK = k(context, uri);
        File file = new File(context.getCacheDir(), "filestorage_upload");
        file.mkdirs();
        File file2 = new File(file, "upload_" + System.currentTimeMillis() + "_" + System.nanoTime() + strK);
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            throw new IllegalStateException("无法打开上传 URI 输入流: " + uri);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                C4877a.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                l9.b.a(fileOutputStream, null);
                l9.b.a(inputStreamOpenInputStream, null);
                C4148a.k(TAG, "Copied uri to temp file: " + file2.getAbsolutePath() + " (" + file2.length() + " bytes)", false, 4, null);
                return file2;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        if (g(r15, r14, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.content.Context r12, java.lang.String r13, p9.s<? super java.lang.Integer, ? super java.lang.Boolean, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, Y8.t> r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$1
            if (r0 == 0) goto L13
            r0 = r15
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$1 r0 = (com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$1 r0 = new com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$1
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 4
            r4 = 0
            java.lang.String r5 = "FileStorageUploadHelper"
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L5b
            if (r2 == r7) goto L49
            if (r2 != r6) goto L41
            java.lang.Object r11 = r0.L$3
            P6.m r11 = (P6.UploadResult) r11
            java.lang.Object r11 = r0.L$2
            p9.s r11 = (p9.s) r11
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$0
            android.content.Context r11 = (android.content.Context) r11
            kotlin.C4849c.b(r15)
            goto Lb2
        L41:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L49:
            java.lang.Object r12 = r0.L$2
            r14 = r12
            p9.s r14 = (p9.s) r14
            java.lang.Object r12 = r0.L$1
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r12 = r0.L$0
            android.content.Context r12 = (android.content.Context) r12
            kotlin.C4849c.b(r15)
            goto L8d
        L5b:
            kotlin.C4849c.b(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "Starting FileStorage upload: "
            r15.append(r2)
            r15.append(r13)
            java.lang.String r15 = r15.toString()
            h8.C4148a.k(r5, r15, r4, r3, r8)
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$result$1 r15 = new com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$result$1
            r15.<init>(r12, r13, r14, r8)
            java.lang.Object r2 = g9.h.a(r12)
            r0.L$0 = r2
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r7
            r9 = 120000(0x1d4c0, double:5.9288E-319)
            java.lang.Object r15 = kotlinx.coroutines.TimeoutKt.e(r9, r15, r0)
            if (r15 != r1) goto L8d
            goto Lb1
        L8d:
            P6.m r15 = (P6.UploadResult) r15
            if (r15 == 0) goto Lb5
            java.lang.Object r12 = g9.h.a(r12)
            r0.L$0 = r12
            java.lang.Object r12 = g9.h.a(r13)
            r0.L$1 = r12
            java.lang.Object r12 = g9.h.a(r14)
            r0.L$2 = r12
            java.lang.Object r12 = g9.h.a(r15)
            r0.L$3 = r12
            r0.label = r6
            java.lang.Object r11 = r11.g(r15, r14, r0)
            if (r11 != r1) goto Lb2
        Lb1:
            return r1
        Lb2:
            Y8.t r11 = Y8.t.f7040a
            return r11
        Lb5:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "FileStorage upload timeout after 120000ms: "
            r11.append(r12)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            h8.C4148a.h(r5, r11, r4, r3, r8)
            java.util.concurrent.TimeoutException r11 = new java.util.concurrent.TimeoutException
            java.lang.String r12 = "FileStorage 上传超时（120000ms 未返回结果）"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper.e(android.content.Context, java.lang.String, p9.s, e9.c):java.lang.Object");
    }

    public final void f() {
        if (!initialized) {
            throw new IllegalStateException("FileStorageUploadHelper 未初始化，请在 ChatCoreSdk.initialize 传入 FileStorageConfig");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(P6.UploadResult r17, p9.s<? super java.lang.Integer, ? super java.lang.Boolean, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, Y8.t> r18, e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper.g(P6.m, p9.s, e9.c):java.lang.Object");
    }

    public final void h(FileStorageConfig config) {
        kotlin.jvm.internal.p.i(config, "config");
        if (initialized) {
            return;
        }
        synchronized (this) {
            try {
                if (initialized) {
                    return;
                }
                String appId = config.getAppId();
                String appSecret = config.getAppSecret();
                String defaultBizCode = config.getDefaultBizCode();
                String defaultSourceType = config.getDefaultSourceType();
                String gatewayBaseUrl = config.getGatewayBaseUrl();
                if (gatewayBaseUrl == null) {
                    gatewayBaseUrl = "https://biz-gw-in.zyql.com";
                }
                String str = gatewayBaseUrl;
                String serviceName = config.getServiceName();
                if (serviceName == null) {
                    serviceName = "file-storage";
                }
                FileStorageManager.INSTANCE.m(new FileStorageConfig(appId, appSecret, defaultBizCode, str, serviceName, "Android", defaultSourceType, C1173v.m(), 3, 2, 1000L, 10000L, 30000L, UPLOAD_TIMEOUT_MS), new a(config), new FileStorageUploadHelper$init$1$2(config));
                initialized = true;
                C4148a.k(TAG, "FileStorage SDK initialized", false, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(Throwable cause) {
        while (cause != null) {
            if (cause instanceof FileStorageException.AuditBlocked) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }

    public final Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return TimeoutKt.e(15000L, new FileStorageUploadHelper$resolveDownloadUrl$2(str, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(android.content.Context r11, android.net.Uri r12) {
        /*
            r10 = this;
            java.lang.String r10 = "_display_name"
            r1 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L6d
            android.content.ContentResolver r2 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L6d
            java.lang.String[] r4 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L6d
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L57
            if (r12 == 0) goto L68
            java.io.Closeable r12 = (java.io.Closeable) r12     // Catch: java.lang.Throwable -> L57
            r0 = r12
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch: java.lang.Throwable -> L39
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L5a
            int r10 = r0.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L39
            if (r10 < 0) goto L5a
            java.lang.String r4 = r0.getString(r10)     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L3c
            r8 = 6
            r9 = 0
            r5 = 46
            r6 = 0
            r7 = 0
            int r10 = La.H.A0(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L39
            goto L3d
        L39:
            r0 = move-exception
            r10 = r0
            goto L62
        L3c:
            r10 = -1
        L3d:
            if (r10 < 0) goto L5a
            kotlin.jvm.internal.p.f(r4)     // Catch: java.lang.Throwable -> L39
            int r0 = r4.length()     // Catch: java.lang.Throwable -> L39
            int r0 = r0 + (-1)
            if (r10 >= r0) goto L5a
            java.lang.String r10 = r4.substring(r10)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "substring(...)"
            kotlin.jvm.internal.p.h(r10, r0)     // Catch: java.lang.Throwable -> L39
            l9.b.a(r12, r1)     // Catch: java.lang.Throwable -> L57
            return r10
        L57:
            r0 = move-exception
        L58:
            r10 = r0
            goto L70
        L5a:
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L39
            l9.b.a(r12, r1)     // Catch: java.lang.Throwable -> L57
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L57
            goto L69
        L62:
            throw r10     // Catch: java.lang.Throwable -> L63
        L63:
            r0 = move-exception
            l9.b.a(r12, r10)     // Catch: java.lang.Throwable -> L57
            throw r0     // Catch: java.lang.Throwable -> L57
        L68:
            r10 = r1
        L69:
            kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L57
            goto L79
        L6d:
            r0 = move-exception
            r3 = r12
            goto L58
        L70:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            kotlin.Result.b(r10)
        L79:
            android.content.ContentResolver r10 = r11.getContentResolver()
            java.lang.String r10 = r10.getType(r3)
            if (r10 == 0) goto L8b
            android.webkit.MimeTypeMap r11 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r1 = r11.getExtensionFromMimeType(r10)
        L8b:
            if (r1 == 0) goto La6
            int r10 = r1.length()
            if (r10 != 0) goto L94
            goto La6
        L94:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "."
            r10.append(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            goto La8
        La6:
            java.lang.String r10 = ""
        La8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper.k(android.content.Context, android.net.Uri):java.lang.String");
    }

    public final Object l(Context context, File file, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        f();
        String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.p.h(absolutePath, "getAbsolutePath(...)");
        Object objE = e(context, absolutePath, sVar, interfaceC4014c);
        return objE == C4063a.g() ? objE : Y8.t.f7040a;
    }

    public final Object m(Context context, String str, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super UploadResult> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        try {
            FileStorageManager.f(FileStorageManager.INSTANCE, context, C1172u.e(new UploadRequest(str, null, null, null, null, null, null, 126, null)), null, new b(sVar), false, new c(cVar), null, null, 212, null);
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            cVar.resumeWith(Result.b(C4849c.a(th)));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(android.content.Context r11, android.net.Uri r12, p9.s<? super java.lang.Integer, ? super java.lang.Boolean, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, Y8.t> r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$uploadUri$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$uploadUri$1 r0 = (com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$uploadUri$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$uploadUri$1 r0 = new com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$uploadUri$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r6 = "Failed to delete temp upload file: "
            java.lang.String r7 = "FileStorageUploadHelper"
            r8 = 1
            if (r2 == 0) goto L4a
            if (r2 != r8) goto L42
            java.lang.Object r10 = r0.L$3
            java.io.File r10 = (java.io.File) r10
            java.lang.Object r11 = r0.L$2
            p9.s r11 = (p9.s) r11
            java.lang.Object r11 = r0.L$1
            android.net.Uri r11 = (android.net.Uri) r11
            java.lang.Object r11 = r0.L$0
            android.content.Context r11 = (android.content.Context) r11
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L40
            goto L7b
        L40:
            r11 = move-exception
            goto Lb6
        L42:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L4a:
            kotlin.C4849c.b(r14)
            r10.f()
            java.io.File r14 = r10.d(r11, r12)
            java.lang.String r2 = r14.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r9 = "getAbsolutePath(...)"
            kotlin.jvm.internal.p.h(r2, r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r9 = g9.h.a(r11)     // Catch: java.lang.Throwable -> Lb4
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> Lb4
            r0.L$1 = r12     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r12 = g9.h.a(r13)     // Catch: java.lang.Throwable -> Lb4
            r0.L$2 = r12     // Catch: java.lang.Throwable -> Lb4
            r0.L$3 = r14     // Catch: java.lang.Throwable -> Lb4
            r0.label = r8     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r10 = r10.e(r11, r2, r13, r0)     // Catch: java.lang.Throwable -> Lb4
            if (r10 != r1) goto L7a
            return r1
        L7a:
            r10 = r14
        L7b:
            kotlin.Result$a r11 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L8a
            boolean r11 = r10.delete()     // Catch: java.lang.Throwable -> L8a
            java.lang.Boolean r11 = g9.C4109a.a(r11)     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L8a
            goto L95
        L8a:
            r11 = move-exception
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        L95:
            java.lang.Throwable r11 = kotlin.Result.e(r11)
            if (r11 == 0) goto Lb1
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            h8.C4148a.u(r7, r10, r5, r4, r3)
        Lb1:
            Y8.t r10 = Y8.t.f7040a
            return r10
        Lb4:
            r11 = move-exception
            r10 = r14
        Lb6:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            boolean r12 = r10.delete()     // Catch: java.lang.Throwable -> Lc5
            java.lang.Boolean r12 = g9.C4109a.a(r12)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> Lc5
            goto Ld0
        Lc5:
            r12 = move-exception
            kotlin.Result$a r13 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        Ld0:
            java.lang.Throwable r12 = kotlin.Result.e(r12)
            if (r12 == 0) goto Lec
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r6)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            h8.C4148a.u(r7, r10, r5, r4, r3)
        Lec:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper.n(android.content.Context, android.net.Uri, p9.s, e9.c):java.lang.Object");
    }
}
