package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import n7.o;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9505b = d.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9505b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            p6.a aVarI = p6.a.i(stringExtra);
            if (aVarI == null) {
                j6.a.c(str, "getMessage fail, pushSwitchStatus is null");
                return null;
            }
            String str2 = aVarI.f3853c;
            if ("200".equals(str2)) {
                j6.a.b(str, "getMessage success");
                return aVarI;
            }
            Log.w("[Cloud]Push.SDK", j6.a.d(str, "getMessage warn, pushSwitchStatus code: " + str2));
            return aVarI;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "push_status";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        p6.a aVar = (p6.a) obj;
        if (aVar != null) {
            Log.d(((PushReceiver) cVar).f2691b, "onPushStatus: status=" + aVar);
        }
        int i2 = t6.a.f9769a;
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        g6.c cVar = (g6.c) f6.a.f3454a.f194h;
        return o.z(context, cVar.f3853c, cVar.f3854d, "push_status", intent.getStringExtra("messageSign"));
    }
}
