package U3;

import M0.h;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.stepos.ability.env.config.IEnvConfig;
import e1.C1403b;
import e3.C1417f;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1270a;

    public a(Context context) {
        k.f(context, "context");
        this.f1270a = context;
    }

    @Override // U3.b
    public final IEnvConfig a() {
        String string;
        String str = "prod";
        try {
            ContentResolver contentResolver = this.f1270a.getContentResolver();
            if (contentResolver != null && (string = Settings.Secure.getString(contentResolver, "net_env")) != null) {
                Log.i("EnvManager", "getNetEnv: ".concat(string));
                if (string.equals("test")) {
                    str = "test";
                }
            }
        } catch (Throwable th) {
            Log.e("EnvManager", "getNetEnv error: " + Log.getStackTraceString(th));
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 99349) {
            if (iHashCode != 114214) {
                if (iHashCode == 3556498 && str.equals("test")) {
                    return new V3.a();
                }
            } else if (str.equals("stg")) {
                return new C1417f(5);
            }
        } else if (str.equals("dev")) {
            return new h(5);
        }
        return new C1403b(5);
    }
}
