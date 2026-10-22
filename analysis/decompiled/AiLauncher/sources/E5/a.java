package E5;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LE5/a;", "", "<init>", "()V", "", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TAG = "ChatTrace";

    public static final void a(String message) {
        p.i(message, "message");
        C4148a.d(TAG, message, false, 4, null);
    }

    public static final void b(String message) {
        p.i(message, "message");
        C4148a.h(TAG, message, false, 4, null);
    }
}
