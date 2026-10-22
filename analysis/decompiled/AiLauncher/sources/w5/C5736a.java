package w5;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lw5/a;", "", "<init>", "()V", "", "errCode", "", "errMsg", "", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;)Z", "listenMode", "alreadySlaOnly", "slaAvailable", Const.INTENT_KEY_PKGNAME, "(ZZILjava/lang/String;Z)Z", "ERR_MODEL_NOT_READY", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5736a {
    public static final int ERR_MODEL_NOT_READY = 110004;
    public static final C5736a INSTANCE = new C5736a();

    public final boolean a(int errCode, String errMsg) {
        if (errCode == 110004) {
            return true;
        }
        if (errMsg == null) {
            errMsg = "";
        }
        return H.e0(errMsg, "Model not yet ready", true) || H.e0(errMsg, "Model validation failed", true) || H.e0(errMsg, "preinstall extract", true);
    }

    public final boolean b(boolean listenMode, boolean alreadySlaOnly, int errCode, String errMsg, boolean slaAvailable) {
        return listenMode && !alreadySlaOnly && slaAvailable && a(errCode, errMsg);
    }
}
