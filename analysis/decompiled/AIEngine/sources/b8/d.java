package b8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import o7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3131b = d.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3131b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            y7.a aVarG = y7.a.g(stringExtra);
            if (aVarG == null) {
                s7.a.c(str, "getMessage fail, pushSwitchStatus is null");
                return null;
            }
            String str2 = (String) aVarG.f10168c;
            if ("200".equals(str2)) {
                s7.a.b(str, "getMessage success");
                return aVarG;
            }
            s7.a.e(str, "getMessage warn, pushSwitchStatus code: " + str2);
            return aVarG;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "push_status";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        y7.a aVar = (y7.a) obj;
        if (aVar != null) {
            bVar.onPushStatus(context, aVar);
        }
        int i10 = c8.a.f3305a;
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        p7.d dVar = a.C0117a.f10777a.f10773c;
        return a4.a.t(context, dVar.f11458b, dVar.f11459c, "push_status", intent.getStringExtra("messageSign"));
    }
}
