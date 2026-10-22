package s6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.push.PushReceiver;
import java.util.Set;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f9503b = b.class.getSimpleName();

    @Override // s6.a
    public final Object a(Context context, Intent intent) {
        String str = this.f9503b;
        j6.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                j6.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            r6.a aVarA = r6.a.a(stringExtra);
            if (aVarA == null) {
                j6.a.c(str, "getMessage fail, messageData is null");
                return null;
            }
            j6.a.b(str, "getMessage success");
            return aVarA;
        } catch (Exception e10) {
            j6.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // s6.a
    public final String b() {
        return "notification_arrived";
    }

    @Override // s6.a
    public final void c(Context context, Object obj, q6.c cVar) {
        r6.a aVar = (r6.a) obj;
        if (aVar != null) {
            g3.e eVarO = g3.e.o(aVar, "com.stepos.appstore".equalsIgnoreCase(context.getPackageName()));
            String str = ((PushReceiver) cVar).f2691b;
            Set set = e5.b.f3054a;
            Log.d(str, e5.b.c("onNotificationArrived: pushMessage=" + eVarO));
        }
    }

    @Override // s6.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((r6.a) obj).getClass();
        return true;
    }
}
