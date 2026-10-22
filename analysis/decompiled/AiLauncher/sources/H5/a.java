package H5;

import I5.b;
import I5.c;
import I5.d;
import I5.e;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LH5/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LI5/b;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LI5/b;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "env_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();

    public final b a(Context context) {
        String strB = b(context);
        int iHashCode = strB.hashCode();
        if (iHashCode != 99349) {
            if (iHashCode != 114214) {
                if (iHashCode == 3556498 && strB.equals("test")) {
                    return new e();
                }
            } else if (strB.equals("stg")) {
                return new d();
            }
        } else if (strB.equals("dev")) {
            return new I5.a();
        }
        return new c();
    }

    public final String b(Context context) {
        String string;
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || (string = Settings.Secure.getString(contentResolver, "net_env")) == null) {
                    return "prod";
                }
                C4148a.k("EnvManager", "getNetEnv: " + string, false, 4, null);
                return p.d(string, "test") ? "test" : "prod";
            } catch (Throwable th) {
                C4148a.h("EnvManager", "getNetEnv error: " + Log.getStackTraceString(th), false, 4, null);
            }
        }
        return "prod";
    }
}
