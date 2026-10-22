package com.stepos.ailauncher.foundation.credential;

import La.H;
import Ua.C1056g;
import Ua.Y;
import Y8.h;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.foundation.credential.api.ApiEnvelope;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ailauncher.foundation.credential.api.CredentialApi;
import com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto;
import com.stepos.core.ability.AbilityType;
import com.stepos.net.HttpManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002BCB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\f\u0010\rJR\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0019\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001a\u0010\rJ<\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ4\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0086@¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J@\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010$2\"\u0010(\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0&\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0082@¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00100R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010<\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u0010#R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u00100R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u00100R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00100R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00100R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u00100¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient;", "", "<init>", "()V", "", "vendorId", "integrationId", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "Lcom/stepos/ailauncher/foundation/credential/api/CredentialStatusDto;", "n", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "path", "o", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "startPath", "", "body", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$AuthContext;", "context", "", "oauthFlow", "redirectUri", "Lcom/stepos/ailauncher/foundation/credential/api/AuthSessionDto;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/Map;Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$AuthContext;ZLjava/lang/String;Le9/c;)Ljava/lang/Object;", "pollPath", "l", "fields", "LY8/t;", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/credential/api/CredentialApi;", "p", "()Lcom/stepos/ailauncher/foundation/credential/api/CredentialApi;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Le9/c;", "Lcom/stepos/ailauncher/foundation/credential/api/ApiEnvelope;", "block", "f", "(Lp9/l;Le9/c;)Ljava/lang/Object;", "Lretrofit2/HttpException;", "e", "m", "(Lretrofit2/HttpException;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "BASE_URL_KEY", "FALLBACK_PATH_OAUTH_SESSION", "FALLBACK_PATH_AUTH_SESSION", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/google/gson/Gson;", "gson", "api$delegate", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "api", "ERR_NETWORK", "ERR_UNAUTHORIZED", "ERR_NOT_FOUND", "ERR_AUTH_FAILED", "ERR_TIMEOUT", "AuthContext", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CredentialBrokerClient {
    private static final String BASE_URL_KEY = "credentialService";
    public static final String ERR_AUTH_FAILED = "授权失败，请重试";
    public static final String ERR_NETWORK = "网络异常，请稍后重试";
    public static final String ERR_NOT_FOUND = "未找到授权记录";
    public static final String ERR_TIMEOUT = "授权超时，请重试";
    public static final String ERR_UNAUTHORIZED = "登录状态已失效，请重新登录";
    private static final String FALLBACK_PATH_AUTH_SESSION = "v1/auth/sessions";
    private static final String FALLBACK_PATH_OAUTH_SESSION = "v1/oauth/sessions";
    private static final String TAG = "CredentialBroker";
    public static final CredentialBrokerClient INSTANCE = new CredentialBrokerClient();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final h gson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.credential.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CredentialBrokerClient.k();
        }
    });

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.credential.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CredentialBrokerClient.e();
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$AuthContext;", "", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "RETRY", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AuthContext {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ AuthContext[] $VALUES;
        public static final AuthContext CHAT = new AuthContext("CHAT", 0, AbilityType.CHAT);
        public static final AuthContext RETRY = new AuthContext("RETRY", 1, "retry");
        private final String value;

        private static final /* synthetic */ AuthContext[] $values() {
            return new AuthContext[]{CHAT, RETRY};
        }

        static {
            AuthContext[] authContextArr$values = $values();
            $VALUES = authContextArr$values;
            $ENTRIES = kotlin.enums.a.a(authContextArr$values);
        }

        private AuthContext(String str, int i10, String str2) {
            this.value = str2;
        }

        public static InterfaceC4149a<AuthContext> getEntries() {
            return $ENTRIES;
        }

        public static AuthContext valueOf(String str) {
            return (AuthContext) Enum.valueOf(AuthContext.class, str);
        }

        public static AuthContext[] values() {
            return (AuthContext[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", ExifInterface.GPS_DIRECTION_TRUE, "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a$a;", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a$b;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a<T> {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a$a;", "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$a, reason: collision with other inner class name and from toString */
        public static final /* data */ class Fail implements a {
            private final int code;
            private final String message;

            public Fail(int i10, String message) {
                p.i(message, "message");
                this.code = i10;
                this.message = message;
            }

            /* renamed from: a, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            /* renamed from: b, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fail)) {
                    return false;
                }
                Fail fail = (Fail) other;
                return this.code == fail.code && p.d(this.message, fail.message);
            }

            public int hashCode() {
                return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
            }

            public String toString() {
                return "Fail(code=" + this.code + ", message=" + this.message + ")";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/ailauncher/foundation/credential/CredentialBrokerClient$a;", "data", "<init>", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$b, reason: from toString */
        public static final /* data */ class Ok<T> implements a<T> {
            private final T data;

            public Ok(T t10) {
                this.data = t10;
            }

            public final T a() {
                return this.data;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Ok) && p.d(this.data, ((Ok) other).data);
            }

            public int hashCode() {
                T t10 = this.data;
                if (t10 == null) {
                    return 0;
                }
                return t10.hashCode();
            }

            public String toString() {
                return "Ok(data=" + this.data + ")";
            }
        }
    }

    public static final CredentialApi e() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((CredentialApi) HttpManager.INSTANCE.create(CredentialApi.class, BASE_URL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "HttpManager.create<CredentialApi>(\"credentialService\") 失败，授权功能不可用（多半是 credentialService baseUrl 未配置，见 IEnvConfig.getCredentialServiceBaseUrl）", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (CredentialApi) objB;
    }

    public static final Gson k() {
        return new Gson();
    }

    public final <T> Object f(InterfaceC5074l<? super InterfaceC4014c<? super ApiEnvelope<T>>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super a<? extends T>> interfaceC4014c) {
        return C1056g.j(Y.b(), new CredentialBrokerClient$call$2(interfaceC5074l, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a<com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto>> r6) {
        /*
            r3 = this;
            com.stepos.ailauncher.foundation.credential.AuthSessionPoller r0 = com.stepos.ailauncher.foundation.credential.AuthSessionPoller.INSTANCE
            java.lang.String r4 = r0.f(r4)
            if (r4 != 0) goto L12
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$a r3 = new com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$a
            r4 = 0
            java.lang.String r5 = "网络异常，请稍后重试"
            r3.<init>(r4, r5)
            return r3
        L12:
            java.lang.String r0 = "context"
            java.lang.Object r5 = r5.get(r0)
            r1 = 0
            if (r5 == 0) goto L2b
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L2b
            boolean r2 = La.H.x0(r5)
            if (r2 != 0) goto L28
            goto L29
        L28:
            r5 = r1
        L29:
            if (r5 != 0) goto L2d
        L2b:
            java.lang.String r5 = "chat"
        L2d:
            kotlin.Pair r5 = Y8.j.a(r0, r5)
            java.util.Map r5 = Z8.Q.f(r5)
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$completeA2a$2 r0 = new com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$completeA2a$2
            r0.<init>(r4, r5, r1)
            java.lang.Object r3 = r3.f(r0, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.g(java.lang.String, java.util.Map, e9.c):java.lang.Object");
    }

    public final Object h(String str, Map<String, ? extends Object> map, AuthContext authContext, boolean z10, String str2, InterfaceC4014c<? super a<AuthSessionDto>> interfaceC4014c) {
        if (str == null) {
            str = z10 ? FALLBACK_PATH_OAUTH_SESSION : FALLBACK_PATH_AUTH_SESSION;
        }
        Map mapC = Q.c();
        mapC.putAll(map);
        mapC.put("context", authContext.getValue());
        if (str2 != null) {
            if (H.x0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                mapC.put("redirect_uri", str2);
            }
        }
        return f(new CredentialBrokerClient$createSession$2(str, Q.b(mapC), null), interfaceC4014c);
    }

    public final CredentialApi i() {
        return (CredentialApi) api.getValue();
    }

    public final Gson j() {
        return (Gson) gson.getValue();
    }

    public final Object l(String str, InterfaceC4014c<? super a<AuthSessionDto>> interfaceC4014c) {
        return f(new CredentialBrokerClient$pollSessionOnce$2(str, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m(retrofit2.HttpException r3) {
        /*
            r2 = this;
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3d
            yc.v r3 = r3.d()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L3b
            tb.D r3 = r3.d()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L3b
            java.lang.String r3 = r3.A()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L3b
            boolean r1 = La.H.x0(r3)     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L1c
            goto L1d
        L1c:
            r3 = r0
        L1d:
            if (r3 != 0) goto L20
            goto L3b
        L20:
            com.google.gson.Gson r2 = r2.j()     // Catch: java.lang.Throwable -> L3d
            java.lang.Class<com.stepos.ailauncher.foundation.credential.api.ProblemDetailDto> r1 = com.stepos.ailauncher.foundation.credential.api.ProblemDetailDto.class
            java.lang.Object r2 = r2.fromJson(r3, r1)     // Catch: java.lang.Throwable -> L3d
            com.stepos.ailauncher.foundation.credential.api.ProblemDetailDto r2 = (com.stepos.ailauncher.foundation.credential.api.ProblemDetailDto) r2     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L3b
            java.lang.String r2 = r2.getDetail()     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L3b
            boolean r3 = La.H.x0(r2)     // Catch: java.lang.Throwable -> L3d
            if (r3 != 0) goto L3b
            goto L3f
        L3b:
            r2 = r0
            goto L3f
        L3d:
            r2 = move-exception
            goto L44
        L3f:
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L3d
            goto L4e
        L44:
            kotlin.Result$a r3 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.C4849c.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L4e:
            boolean r3 = kotlin.Result.g(r2)
            if (r3 == 0) goto L55
            goto L56
        L55:
            r0 = r2
        L56:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.m(retrofit2.HttpException):java.lang.String");
    }

    public final Object n(String str, String str2, InterfaceC4014c<? super a<CredentialStatusDto>> interfaceC4014c) {
        return f(new CredentialBrokerClient$queryStatus$2(str, str2, null), interfaceC4014c);
    }

    public final Object o(String str, InterfaceC4014c<? super a<CredentialStatusDto>> interfaceC4014c) {
        String strF = AuthSessionPoller.INSTANCE.f(str);
        return strF == null ? new a.Fail(0, ERR_NETWORK) : f(new CredentialBrokerClient$queryStatusAtPath$2(strF, null), interfaceC4014c);
    }

    public final CredentialApi p() {
        CredentialApi credentialApiI = i();
        if (credentialApiI != null) {
            return credentialApiI;
        }
        throw new IllegalStateException("credentialService baseUrl 未配置");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a<Y8.t>> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$1 r0 = (com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$1 r0 = new com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.L$2
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r11)
            goto Lbe
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.C4849c.b(r11)
            java.util.Set r11 = r10.keySet()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r10.size()
            r2.<init>(r4)
            java.util.Set r4 = r10.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L56:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L74
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            int r5 = r5.length()
            java.lang.Integer r5 = g9.C4109a.f(r5)
            r2.add(r5)
            goto L56
        L74:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "submitCredentials vendor="
            r4.append(r5)
            r4.append(r8)
            java.lang.String r5 = " keys="
            r4.append(r5)
            r4.append(r11)
            java.lang.String r11 = " lens="
            r4.append(r11)
            r4.append(r2)
            java.lang.String r11 = r4.toString()
            r2 = 0
            r4 = 4
            java.lang.String r5 = "CredentialBroker"
            r6 = 0
            h8.C4148a.k(r5, r11, r2, r4, r6)
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$r$1 r11 = new com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$submitCredentials$r$1
            r11.<init>(r8, r9, r10, r6)
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            java.lang.Object r8 = g9.h.a(r9)
            r0.L$1 = r8
            java.lang.Object r8 = g9.h.a(r10)
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r11 = r7.f(r11, r0)
            if (r11 != r1) goto Lbe
            return r1
        Lbe:
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a r11 = (com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a) r11
            boolean r7 = r11 instanceof com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Ok
            if (r7 == 0) goto Lcc
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$b r7 = new com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$b
            Y8.t r8 = Y8.t.f7040a
            r7.<init>(r8)
            return r7
        Lcc:
            boolean r7 = r11 instanceof com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Fail
            if (r7 == 0) goto Ld1
            return r11
        Ld1:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.q(java.lang.String, java.lang.String, java.util.Map, e9.c):java.lang.Object");
    }
}
