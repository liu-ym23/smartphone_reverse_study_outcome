package b8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3129b = b.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3129b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            a8.a aVarA = a8.a.a(stringExtra);
            if (aVarA == null) {
                s7.a.c(str, "getMessage fail, messageData is null");
                return null;
            }
            s7.a.b(str, "getMessage success");
            return aVarA;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "notification_arrived";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        a8.a aVar = (a8.a) obj;
        if (aVar != null) {
            bVar.onNotificationArrived(context, u7.a.a(aVar, "com.stepos.appstore".equalsIgnoreCase(context.getPackageName())));
        }
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        ((a8.a) obj).getClass();
        return true;
    }
}
