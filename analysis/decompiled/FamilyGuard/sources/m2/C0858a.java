package m2;

import C4.G;
import R4.j;
import android.text.TextUtils;
import com.stepos.familyguard.encrypt.AESUtils;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import l0.AbstractC0822a;
import n2.C0877d;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0858a {
    public static int a(Throwable th) {
        int iF;
        if (th == null) {
            return 0;
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof C0877d) {
                C0877d c0877d = (C0877d) cause;
                int i5 = c0877d.f18919a;
                if (i5 != 0) {
                    return i5;
                }
                int iC = c(c0877d.getMessage());
                if (iC != 0) {
                    return iC;
                }
            }
            if ((cause instanceof j) && (iF = f((j) cause)) != 0) {
                return iF;
            }
        }
        return c(th.getMessage());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.Throwable r11) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.C0858a.b(java.lang.Throwable):java.lang.String");
    }

    static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("验证码") && str.contains("频繁")) {
            return 307;
        }
        if (str.contains("验证码") && (str.contains("无效") || str.contains("错误") || str.contains("不正确") || str.contains("过期") || str.contains("失败") || str.contains("不匹配") || str.contains("错误的") || str.contains("有误"))) {
            return 305;
        }
        String lowerCase = str.toLowerCase();
        return ((lowerCase.contains("verification code") || lowerCase.contains("verify code") || lowerCase.contains("sms code") || lowerCase.contains("captcha")) && (lowerCase.contains("invalid") || lowerCase.contains("incorrect") || lowerCase.contains("wrong") || lowerCase.contains("expired") || lowerCase.contains("mismatch") || lowerCase.contains("fail"))) ? 305 : 0;
    }

    public static boolean d(Throwable th) {
        while (th != null) {
            if ((th instanceof UnknownHostException) || (th instanceof ConnectException) || (th instanceof SocketTimeoutException) || (th instanceof SocketException) || (th instanceof SSLException) || (th instanceof InterruptedIOException)) {
                return true;
            }
            String message = th.getMessage();
            if (!TextUtils.isEmpty(message)) {
                String lowerCase = message.toLowerCase();
                if (lowerCase.contains("failed to connect") || lowerCase.contains("unable to resolve host") || lowerCase.contains("network is unreachable") || lowerCase.contains("connection reset") || lowerCase.contains("timeout") || lowerCase.contains("no address associated")) {
                    return true;
                }
            }
            th = th.getCause();
        }
        return false;
    }

    public static int e(int i5, String str) {
        int iC = c(str);
        if (iC != 0) {
            return iC;
        }
        if (i5 == 0 || i5 == 200) {
            return 0;
        }
        return i5;
    }

    private static int f(j jVar) {
        G gD;
        if (jVar.b() == null || (gD = jVar.b().d()) == null) {
            return 0;
        }
        try {
            String strX = gD.x();
            if (TextUtils.isEmpty(strX)) {
                return 0;
            }
            l0.e eVarG = g(strX);
            if (eVarG == null) {
                return c(strX);
            }
            Integer numO = eVarG.O("code");
            if (numO == null) {
                numO = eVarG.O("status");
            }
            if (numO == null) {
                numO = eVarG.O("errCode");
            }
            if (numO == null) {
                numO = eVarG.O("errorCode");
            }
            String strR = eVarG.R("message");
            if (TextUtils.isEmpty(strR)) {
                strR = eVarG.R("msg");
            }
            if (TextUtils.isEmpty(strR)) {
                strR = eVarG.R("errorMsg");
            }
            if (numO == null || numO.intValue() == 0 || numO.intValue() == 200) {
                return c(strR);
            }
            int iC = c(strR);
            return iC != 0 ? iC : numO.intValue();
        } catch (Exception e6) {
            R1.a.b("FamilyGuardCode", "parseBusinessCodeFromHttpException failed: " + e6.getMessage());
            return 0;
        }
    }

    private static l0.e g(String str) {
        try {
            l0.e eVarC = AbstractC0822a.C(str);
            if (eVarC != null) {
                return eVarC;
            }
        } catch (Exception unused) {
        }
        try {
            String strA = AESUtils.a(str);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return AbstractC0822a.C(strA);
        } catch (Exception e6) {
            R1.a.b("FamilyGuardCode", "parseBusinessJson decrypt failed: " + e6.getMessage());
            return null;
        }
    }
}
