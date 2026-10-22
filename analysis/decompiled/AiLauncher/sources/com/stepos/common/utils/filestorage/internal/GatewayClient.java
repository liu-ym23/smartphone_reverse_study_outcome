package com.stepos.common.utils.filestorage.internal;

import La.H;
import Ua.C1056g;
import Ua.InterfaceC1066l;
import Y8.t;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.utils.filestorage.FileStorageConfig;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.D;
import qb.F;
import qb.j;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;
import tb.x;
import tb.z;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 62\u00020\u0001:\u00017B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0013H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J'\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010,J\u0018\u0010/\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020-H\u0082@¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00104R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00105¨\u00068"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/GatewayClient;", "", "Lcom/stepos/common/utils/filestorage/b;", "config", "Lcom/stepos/common/utils/filestorage/e;", "tokenProvider", "Lcom/stepos/common/utils/filestorage/a;", "headerProvider", "Ltb/z;", "okHttp", "Lqb/a;", "json", "<init>", "(Lcom/stepos/common/utils/filestorage/b;Lcom/stepos/common/utils/filestorage/e;Lcom/stepos/common/utils/filestorage/a;Ltb/z;Lqb/a;)V", "", "path", "bodyJson", "k", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "query", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "method", "body", "Ltb/A;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "request", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/A;Le9/c;)Ljava/lang/Object;", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/C;)Ljava/lang/String;", "raw", "l", "(Ljava/lang/String;)Ljava/lang/String;", "", "code", "httpStatus", "message", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(IILjava/lang/String;)Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "Ltb/e;", "call", "e", "(Ltb/e;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/common/utils/filestorage/b;", "Lcom/stepos/common/utils/filestorage/e;", "Lcom/stepos/common/utils/filestorage/a;", "Ltb/z;", "Lqb/a;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GatewayClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final x JSON_MEDIA = x.INSTANCE.a("application/json; charset=UTF-8");
    private static final Set<String> RESERVED_SIGNATURE_HEADERS = Y.j("zy-app-id", "zy-nonce", "zy-timestamp", "zy-sign");
    private static final String TAG = "FileStorage.Gateway";
    private final FileStorageConfig config;
    private final com.stepos.common.utils.filestorage.a headerProvider;
    private final AbstractC5171a json;
    private final z okHttp;
    private final com.stepos.common.utils.filestorage.e tokenProvider;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/GatewayClient$a;", "", "<init>", "()V", "Lcom/stepos/common/utils/filestorage/b;", "config", "Ltb/z;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/common/utils/filestorage/b;)Ltb/z;", "", "TAG", "Ljava/lang/String;", "Ltb/x;", "JSON_MEDIA", "Ltb/x;", "", "RESERVED_SIGNATURE_HEADERS", "Ljava/util/Set;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.common.utils.filestorage.internal.GatewayClient$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final z a(FileStorageConfig config) {
            p.i(config, "config");
            z.a aVar = new z.a();
            long connectTimeoutMs = config.getConnectTimeoutMs();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return aVar.g(connectTimeoutMs, timeUnit).T(config.getReadTimeoutMs(), timeUnit).W(config.getReadTimeoutMs(), timeUnit).U(true).d();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Throwable, t> {
        final /* synthetic */ InterfaceC5538e $call;

        public b(InterfaceC5538e interfaceC5538e) {
            this.$call = interfaceC5538e;
        }

        public final void a(Throwable th) {
            InterfaceC5538e interfaceC5538e = this.$call;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5538e.cancel();
                Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/common/utils/filestorage/internal/GatewayClient$c", "Ltb/f;", "Ltb/e;", "call", "Ltb/C;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ltb/e;Ltb/C;)V", "Ljava/io/IOException;", "e", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements InterfaceC5539f {
        final /* synthetic */ InterfaceC1066l<C5530C> $cont;

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC1066l<? super C5530C> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        @Override // tb.InterfaceC5539f
        public void a(InterfaceC5538e call, C5530C response) {
            p.i(call, "call");
            p.i(response, "response");
            this.$cont.resumeWith(Result.b(response));
        }

        @Override // tb.InterfaceC5539f
        public void d(InterfaceC5538e call, IOException e10) {
            p.i(call, "call");
            p.i(e10, "e");
            InterfaceC1066l<C5530C> interfaceC1066l = this.$cont;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(e10)));
        }
    }

    public GatewayClient(FileStorageConfig config, com.stepos.common.utils.filestorage.e tokenProvider, com.stepos.common.utils.filestorage.a headerProvider, z okHttp, AbstractC5171a json) {
        p.i(config, "config");
        p.i(tokenProvider, "tokenProvider");
        p.i(headerProvider, "headerProvider");
        p.i(okHttp, "okHttp");
        p.i(json, "json");
        this.config = config;
        this.tokenProvider = tokenProvider;
        this.headerProvider = headerProvider;
        this.okHttp = okHttp;
        this.json = json;
    }

    public final Object e(InterfaceC5538e interfaceC5538e, InterfaceC4014c<? super C5530C> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new b(interfaceC5538e));
        interfaceC5538e.J(new c(cVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0227  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r17, java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19, java.lang.String r20, e9.InterfaceC4014c<? super tb.C5528A> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.GatewayClient.f(java.lang.String, java.lang.String, java.util.Map, java.lang.String, e9.c):java.lang.Object");
    }

    public final Object g(C5528A c5528a, InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new GatewayClient$execute$2(c5528a, this, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, e9.InterfaceC4014c<? super java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.common.utils.filestorage.internal.GatewayClient$get$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.common.utils.filestorage.internal.GatewayClient$get$1 r0 = (com.stepos.common.utils.filestorage.internal.GatewayClient$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.common.utils.filestorage.internal.GatewayClient$get$1 r0 = new com.stepos.common.utils.filestorage.internal.GatewayClient$get$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 == r2) goto L36
            if (r1 != r7) goto L2e
            kotlin.C4849c.b(r11)
            return r11
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r6.L$0
            com.stepos.common.utils.filestorage.internal.GatewayClient r8 = (com.stepos.common.utils.filestorage.internal.GatewayClient) r8
            kotlin.C4849c.b(r11)
            goto L53
        L3e:
            kotlin.C4849c.b(r11)
            r6.L$0 = r8
            r6.label = r2
            java.lang.String r2 = "GET"
            r5 = 0
            r1 = r8
            r3 = r9
            r4 = r10
            java.lang.Object r11 = r1.f(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L52
            goto L60
        L52:
            r8 = r1
        L53:
            tb.A r11 = (tb.C5528A) r11
            r9 = 0
            r6.L$0 = r9
            r6.label = r7
            java.lang.Object r8 = r8.g(r11, r6)
            if (r8 != r0) goto L61
        L60:
            return r0
        L61:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.GatewayClient.h(java.lang.String, java.util.Map, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i(tb.C5530C r10) throws com.stepos.common.utils.filestorage.exceptions.FileStorageException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.GatewayClient.i(tb.C):java.lang.String");
    }

    public final FileStorageException j(int code, int httpStatus, String message) {
        if (code != 11121) {
            if (code == 99999) {
                return new FileStorageException.GatewayException.TokenInvalid(message);
            }
            switch (code) {
                case 10010:
                    return new FileStorageException.GatewayException.SystemMaintenance(message);
                case 10011:
                    return new FileStorageException.GatewayException.DuplicateRequest(message);
                case 10012:
                    return new FileStorageException.GatewayException.MissingCommonParam(message);
                case 10013:
                    break;
                default:
                    return new FileStorageException.GatewayException.Other(code, "http=" + httpStatus + ", gatewayCode=" + code + ", msg=" + message);
            }
        }
        return new FileStorageException.GatewayException.SignatureInvalid(code, message);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r9, java.lang.String r10, e9.InterfaceC4014c<? super java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1 r0 = (com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1 r0 = new com.stepos.common.utils.filestorage.internal.GatewayClient$postJson$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 == r2) goto L36
            if (r1 != r7) goto L2e
            kotlin.C4849c.b(r11)
            return r11
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r6.L$0
            com.stepos.common.utils.filestorage.internal.GatewayClient r8 = (com.stepos.common.utils.filestorage.internal.GatewayClient) r8
            kotlin.C4849c.b(r11)
            goto L56
        L3e:
            kotlin.C4849c.b(r11)
            java.util.Map r4 = kotlin.collections.a.i()
            r6.L$0 = r8
            r6.label = r2
            java.lang.String r2 = "POST"
            r1 = r8
            r3 = r9
            r5 = r10
            java.lang.Object r11 = r1.f(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L55
            goto L63
        L55:
            r8 = r1
        L56:
            tb.A r11 = (tb.C5528A) r11
            r9 = 0
            r6.L$0 = r9
            r6.label = r7
            java.lang.Object r8 = r8.g(r11, r6)
            if (r8 != r0) goto L64
        L63:
            return r0
        L64:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.GatewayClient.k(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final String l(String raw) throws FileStorageException {
        D d10;
        Integer numI;
        String strF;
        if (H.x0(raw)) {
            return null;
        }
        try {
            qb.i iVarG = this.json.g(raw);
            d10 = iVarG instanceof D ? (D) iVarG : null;
        } catch (Throwable unused) {
        }
        if (d10 == null) {
            return null;
        }
        Object obj = d10.get("code");
        F f10 = obj instanceof F ? (F) obj : null;
        if (f10 != null && (numI = j.i(f10)) != null) {
            int iIntValue = numI.intValue();
            if (iIntValue == 200) {
                qb.i iVar = (qb.i) d10.get("data");
                if (iVar == null) {
                    return null;
                }
                return iVar.toString();
            }
            Object obj2 = d10.get("msg");
            F f11 = obj2 instanceof F ? (F) obj2 : null;
            if (f11 == null || (strF = j.f(f11)) == null) {
                strF = "Gateway error " + iIntValue;
            }
            throw j(iIntValue, 200, strF);
        }
        return null;
    }

    public /* synthetic */ GatewayClient(FileStorageConfig fileStorageConfig, com.stepos.common.utils.filestorage.e eVar, com.stepos.common.utils.filestorage.a aVar, z zVar, AbstractC5171a abstractC5171a, int i10, i iVar) {
        this(fileStorageConfig, eVar, aVar, (i10 & 8) != 0 ? INSTANCE.a(fileStorageConfig) : zVar, (i10 & 16) != 0 ? com.stepos.common.utils.filestorage.internal.c.c() : abstractC5171a);
    }
}
