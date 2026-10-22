package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import n7.o;

/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9508b = g.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9508b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            p6.e eVarI = p6.e.i(stringExtra);
            if (eVarI == null) {
                j6.a.c(str, "getMessage fail, subTagsStatus is null");
                return null;
            }
            j6.a.b(str, "getMessage success");
            return eVarI;
        } catch (Exception e10) {
            j6.a.c(str, "SubTagsStatus getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "sub_tags_status";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        p6.e eVar = (p6.e) obj;
        if (eVar != null) {
            Log.d(((PushReceiver) cVar).f2691b, "onSubTagsStatus: status=" + eVar);
        }
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        g6.d dVar = (g6.d) f6.a.f3454a.f195i;
        return o.z(context, dVar.f3853c, dVar.f3854d, "sub_tags_status", intent.getStringExtra("messageSign"));
    }
}
