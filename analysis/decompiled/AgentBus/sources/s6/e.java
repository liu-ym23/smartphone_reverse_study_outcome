package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import java.util.Set;
import n7.o;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9506b = e.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9506b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            p6.b bVarI = p6.b.i(stringExtra);
            if (bVarI == null) {
                j6.a.c(str, "getMessage fail, registerStatus is null");
                return null;
            }
            String str2 = bVarI.f8492g;
            if (!TextUtils.isEmpty(str2)) {
                context.getSharedPreferences("com.stepos.push", 0).edit().putString("server", str2).apply();
                bVarI.f8492g = "";
            }
            String str3 = bVarI.f8490e;
            if (TextUtils.isEmpty(str3)) {
                Log.w("[Cloud]Push.SDK", j6.a.d(str, "getMessage warn, pushId is empty"));
                return bVarI;
            }
            String str4 = bVarI.f3852b;
            a.a.f(context, str4, str3);
            a.a.d(context, str4, (int) ((System.currentTimeMillis() / 1000) + bVarI.f8491f));
            j6.a.b(str, "getMessage warn success, pushId: " + str3);
            return bVarI;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "register_status";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        p6.b bVar = (p6.b) obj;
        if (bVar != null) {
            String str = ((PushReceiver) cVar).f2691b;
            String str2 = bVar.f3853c;
            Set set = e5.b.f3054a;
            Log.d(str, "onRegisterStatus: code=" + str2 + ", pushId=" + e5.b.e(bVar.f8490e));
        }
        int i2 = t6.a.f9769a;
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        g6.c cVar = (g6.c) f6.a.f3454a.f192f;
        return o.z(context, cVar.f3853c, cVar.f3854d, "register_status", intent.getStringExtra("messageSign"));
    }
}
