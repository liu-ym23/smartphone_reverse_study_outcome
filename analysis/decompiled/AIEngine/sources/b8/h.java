package b8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import o7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3135b = h.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3135b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            y7.e eVarG = y7.e.g(stringExtra);
            if (eVarG == null) {
                s7.a.c(str, "getMessage fail, unRegisterStatus is null");
                return null;
            }
            if (!eVarG.f14175e) {
                s7.a.e(str, "getMessage warn, UnRegister result is false");
                return eVarG;
            }
            String str2 = (String) eVarG.f10167b;
            t7.a.b(context, str2, "");
            t7.a.a(context, str2, 0);
            s7.a.b(str, "getMessage success");
            return eVarG;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "un_register_status";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        y7.e eVar = (y7.e) obj;
        if (eVar != null) {
            bVar.onUnRegisterStatus(context, eVar);
        }
        int i10 = c8.a.f3305a;
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        p7.c cVar = a.C0117a.f10777a.f10772b;
        return a4.a.t(context, cVar.f11458b, cVar.f11459c, "un_register_status", intent.getStringExtra("messageSign"));
    }
}
