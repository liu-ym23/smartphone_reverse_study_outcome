package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a%\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f\"\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/f;", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/task/space/credential/f;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "iso", "Ljava/time/Instant;", "now", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/time/Instant;)Ljava/lang/Long;", "AUTH_MODE_OAUTH_REDIRECT", "Ljava/lang/String;", "AUTH_MODE_USER_APP_CREDENTIALS", "AUTH_MODE_BOT_DM_CREDENTIALS", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q {
    private static final String AUTH_MODE_BOT_DM_CREDENTIALS = "bot_dm_credentials";
    private static final String AUTH_MODE_OAUTH_REDIRECT = "oauth_redirect";
    private static final String AUTH_MODE_USER_APP_CREDENTIALS = "user_app_credentials";

    public static final String a(CredentialItem credentialItem) {
        kotlin.jvm.internal.p.i(credentialItem, "<this>");
        return kotlin.jvm.internal.p.d(d(credentialItem), "oauth") ? "oauth" : "api_key";
    }

    public static final Long b(String str, Instant now) {
        String string;
        Object objB;
        Object objB2;
        Object objB3;
        kotlin.jvm.internal.p.i(now, "now");
        if (str != null && (string = La.H.D1(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(Instant.parse(string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                Instant instant = (Instant) objB;
                if (instant == null) {
                    try {
                        objB2 = Result.b(OffsetDateTime.parse(string).toInstant());
                    } catch (Throwable th2) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th2));
                    }
                    if (Result.g(objB2)) {
                        objB2 = null;
                    }
                    instant = (Instant) objB2;
                    if (instant == null) {
                        try {
                            objB3 = Result.b(ZonedDateTime.parse(string).toInstant());
                        } catch (Throwable th3) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objB3 = Result.b(C4849c.a(th3));
                        }
                        boolean zG = Result.g(objB3);
                        Object obj = objB3;
                        if (zG) {
                            obj = null;
                        }
                        instant = (Instant) obj;
                        if (instant == null) {
                            return null;
                        }
                    }
                }
                return Long.valueOf(C5685n.g(Duration.between(instant, now).getSeconds(), 0L));
            }
        }
        return null;
    }

    public static /* synthetic */ Long c(String str, Instant instant, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            instant = Instant.now();
            kotlin.jvm.internal.p.h(instant, "now(...)");
        }
        return b(str, instant);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0.equals(com.stepos.ailauncher.task.space.credential.Q.AUTH_MODE_BOT_DM_CREDENTIALS) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if (r0.equals(com.stepos.ailauncher.task.space.credential.Q.AUTH_MODE_USER_APP_CREDENTIALS) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        return com.stepos.ailauncher.task.space.credential.P.AUTH_APPKEY;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String d(com.stepos.ailauncher.task.space.credential.CredentialItem r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r5, r0)
            java.lang.String r0 = r5.getAuthMode()
            java.lang.String r1 = "appkey"
            java.lang.String r2 = "oauth"
            if (r0 == 0) goto L40
            int r3 = r0.hashCode()
            r4 = -1854333590(0xffffffff91791d6a, float:-1.96517E-28)
            if (r3 == r4) goto L35
            r4 = 1603900548(0x5f999484, float:2.213323E19)
            if (r3 == r4) goto L2c
            r4 = 2090258878(0x7c96d1be, float:6.264789E36)
            if (r3 == r4) goto L23
            goto L40
        L23:
            java.lang.String r3 = "bot_dm_credentials"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L3f
            goto L40
        L2c:
            java.lang.String r3 = "oauth_redirect"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L40
            return r2
        L35:
            java.lang.String r3 = "user_app_credentials"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L3f
            goto L40
        L3f:
            return r1
        L40:
            java.lang.String r5 = r5.getAuthMethodLabel()
            if (r5 != 0) goto L48
            java.lang.String r5 = ""
        L48:
            java.lang.String r0 = "OAuth"
            r3 = 1
            boolean r5 = La.H.e0(r5, r0, r3)
            if (r5 == 0) goto L52
            return r2
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.credential.Q.d(com.stepos.ailauncher.task.space.credential.f):java.lang.String");
    }
}
