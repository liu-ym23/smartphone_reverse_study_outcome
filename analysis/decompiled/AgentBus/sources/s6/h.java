package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import n7.o;

/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9509b = h.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9509b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            p6.f fVarI = p6.f.i(stringExtra);
            if (fVarI == null) {
                j6.a.c(str, "getMessage fail, unRegisterStatus is null");
                return null;
            }
            if (!fVarI.f8499e) {
                Log.w("[Cloud]Push.SDK", j6.a.d(str, "getMessage warn, UnRegister result is false"));
                return fVarI;
            }
            String str2 = fVarI.f3852b;
            a.a.f(context, str2, "");
            a.a.d(context, str2, 0);
            j6.a.b(str, "getMessage success");
            return fVarI;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "un_register_status";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        p6.f fVar = (p6.f) obj;
        if (fVar != null) {
            Log.d(((PushReceiver) cVar).f2691b, "onUnRegisterStatus: code=" + fVar.f3853c);
        }
        int i2 = t6.a.f9769a;
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        g6.c cVar = (g6.c) f6.a.f3454a.f193g;
        return o.z(context, cVar.f3853c, cVar.f3854d, "un_register_status", intent.getStringExtra("messageSign"));
    }
}
