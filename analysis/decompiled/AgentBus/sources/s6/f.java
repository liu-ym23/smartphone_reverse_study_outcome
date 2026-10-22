package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import java.util.Set;
import n7.o;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9507b = f.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9507b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            p6.c cVarI = p6.c.i(stringExtra);
            if (cVarI == null) {
                j6.a.c(str, "getMessage fail, subAliasStatus is null");
                return null;
            }
            String str2 = cVarI.f3853c;
            if ("200".equals(str2)) {
                j6.a.b(str, "getMessage success");
                return cVarI;
            }
            Log.w("[Cloud]Push.SDK", j6.a.d(str, "getMessage warn, subAliasStatus code: " + str2));
            return cVarI;
        } catch (Exception e10) {
            j6.a.c(str, "return subAliasStatus; error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "sub_alias_status";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        p6.c cVar2 = (p6.c) obj;
        if (cVar2 != null) {
            String str = ((PushReceiver) cVar).f2691b;
            Set set = e5.b.f3054a;
            Log.d(str, e5.b.c("onSubAliasStatus: status=" + cVar2));
        }
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        g6.c cVar = (g6.c) f6.a.f3454a.f196j;
        return o.z(context, cVar.f3853c, cVar.f3854d, "sub_alias_status", intent.getStringExtra("messageSign"));
    }
}
