package com.stepos.ailauncher.foundation.credential;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import e9.InterfaceC4014c;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJj\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2*\b\u0002\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001c¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", "session", "", "pathTemplate", "e", "(Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;Ljava/lang/String;)Ljava/lang/String;", "pollPath", "", "intervalMs", "timeoutMs", "Lkotlin/Function0;", "", "shouldContinue", "Lkotlin/Function2;", "Le9/c;", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "fetch", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/Long;JLp9/a;Lp9/p;Le9/c;)Ljava/lang/Object;", "raw", "f", "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "DEFAULT_INTERVAL_MS", "J", "MIN_INTERVAL_MS", "DEFAULT_TIMEOUT_MS", "PREFIX_AUTH_SESSION", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthSessionPoller {
    private static final long DEFAULT_INTERVAL_MS = 2000;
    private static final long DEFAULT_TIMEOUT_MS = 900000;
    public static final AuthSessionPoller INSTANCE = new AuthSessionPoller();
    private static final long MIN_INTERVAL_MS = 1000;
    private static final String PREFIX_AUTH_SESSION = "auth_sess_";
    private static final String TAG = "AuthSessionPoller";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", "", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$a;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$b;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$c;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$d;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$a;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.credential.AuthSessionPoller$a$a, reason: collision with other inner class name */
        public static final /* data */ class C0316a implements a {
            public static final C0316a INSTANCE = new C0316a();

            public boolean equals(Object other) {
                return this == other || (other instanceof C0316a);
            }

            public int hashCode() {
                return 46096174;
            }

            public String toString() {
                return "Aborted";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$b;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class b implements a {
            public static final b INSTANCE = new b();

            public boolean equals(Object other) {
                return this == other || (other instanceof b);
            }

            public int hashCode() {
                return -1412167204;
            }

            public String toString() {
                return "Authorized";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$c;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", "", "message", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.credential.AuthSessionPoller$a$c, reason: from toString */
        public static final /* data */ class Failed implements a {
            private final String message;

            public Failed(String message) {
                p.i(message, "message");
                this.message = message;
            }

            /* renamed from: a, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && p.d(this.message, ((Failed) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "Failed(message=" + this.message + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a$d;", "Lcom/stepos/ailauncher/foundation/credential/AuthSessionPoller$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class d implements a {
            public static final d INSTANCE = new d();

            public boolean equals(Object other) {
                return this == other || (other instanceof d);
            }

            public int hashCode() {
                return 2030436632;
            }

            public String toString() {
                return "TimedOut";
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object c(AuthSessionPoller authSessionPoller, String str, Long l10, long j10, InterfaceC5063a interfaceC5063a, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            j10 = DEFAULT_TIMEOUT_MS;
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.credential.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(AuthSessionPoller.d());
                }
            };
        }
        if ((i10 & 16) != 0) {
            pVar = new AuthSessionPoller$await$3(null);
        }
        return authSessionPoller.b(str, l10, j10, interfaceC5063a, pVar, interfaceC4014c);
    }

    public static final boolean d() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0129 -> B:39:0x0130). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r20, java.lang.Long r21, long r22, p9.InterfaceC5063a<java.lang.Boolean> r24, p9.p<? super java.lang.String, ? super e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a<com.stepos.ailauncher.foundation.credential.api.AuthSessionDto>>, ? extends java.lang.Object> r25, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.credential.AuthSessionPoller.a> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.credential.AuthSessionPoller.b(java.lang.String, java.lang.Long, long, p9.a, p9.p, e9.c):java.lang.Object");
    }

    public final String e(AuthSessionDto session, String pathTemplate) {
        String str;
        String strF;
        p.i(session, "session");
        String sessionId = session.getSessionId();
        String str2 = (sessionId == null || H.x0(sessionId)) ? null : sessionId;
        String strF2 = f(session.getPollUrl());
        if (strF2 != null) {
            return strF2;
        }
        if (str2 != null && (strF = f(pathTemplate)) != null) {
            return D.T(D.T(D.T(strF, "{session_id}", str2, false, 4, null), "{sessionId}", str2, false, 4, null), "{id}", str2, false, 4, null);
        }
        if (str2 == null) {
            C4148a.u(TAG, "无法解析轮询路径：poll_url/path_template/session_id 全缺", false, 4, null);
            return null;
        }
        if (D.X(str2, PREFIX_AUTH_SESSION, false, 2, null)) {
            str = "v1/auth/sessions/" + str2;
        } else {
            str = "v1/oauth/sessions/" + str2;
        }
        C4148a.k(TAG, "poll path 按前缀推断: " + str, false, 4, null);
        return str;
    }

    public final String f(String raw) {
        String string;
        if (raw != null && (string = H.D1(raw).toString()) != null) {
            if (H.x0(string)) {
                string = null;
            }
            if (string != null) {
                if (!H.g0(string, "://", false, 2, null) && !D.X(string, "//", false, 2, null)) {
                    if (!H.g0(string, "..", false, 2, null)) {
                        String strI1 = H.I1(string, JsonPointer.SEPARATOR);
                        if (H.x0(strI1)) {
                            return null;
                        }
                        return strI1;
                    }
                    C4148a.u(TAG, "拒绝路径穿越: " + string, false, 4, null);
                    return null;
                }
                C4148a.u(TAG, "拒绝绝对 URL（会绕过网关签名）: " + string, false, 4, null);
            }
        }
        return null;
    }
}
