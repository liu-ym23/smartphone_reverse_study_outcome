package k5;

import com.stepos.account.oauth.OAuthConstants;

/* loaded from: classes.dex */
public abstract class s {
    public static void debug$default(t tVar, String str, String str2, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        ((g) tVar).getClass();
        q7.k.e(str, "tag");
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        g.b(b.f5620n, str, str2, th);
    }

    public static /* synthetic */ void error$default(t tVar, String str, String str2, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        ((g) tVar).a(str, str2, th);
    }

    public static void info$default(t tVar, String str, String str2, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        ((g) tVar).getClass();
        q7.k.e(str, "tag");
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        g.b(d.f5622n, str, str2, th);
    }

    public static void verbose$default(t tVar, String str, String str2, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        ((g) tVar).getClass();
        q7.k.e(str, "tag");
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        g.b(e.f5623n, str, str2, th);
    }

    public static /* synthetic */ void warn$default(t tVar, String str, String str2, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        ((g) tVar).c(str, str2, th);
    }
}
