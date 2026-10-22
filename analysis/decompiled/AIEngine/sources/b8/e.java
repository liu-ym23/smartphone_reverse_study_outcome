package b8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import o7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3132b = e.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3132b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            y7.b bVarG = y7.b.g(stringExtra);
            if (bVarG == null) {
                s7.a.c(str, "getMessage fail, registerStatus is null");
                return null;
            }
            String str2 = bVarG.f14170j;
            if (!TextUtils.isEmpty(str2)) {
                context.getSharedPreferences("com.stepos.push", 0).edit().putString("server", str2).apply();
                bVarG.f14170j = "";
            }
            String str3 = bVarG.f14169e;
            if (TextUtils.isEmpty(str3)) {
                s7.a.e(str, "getMessage warn, pushId is empty");
                return bVarG;
            }
            String str4 = (String) bVarG.f10167b;
            t7.a.b(context, str4, str3);
            t7.a.a(context, str4, (int) ((System.currentTimeMillis() / 1000) + bVarG.h));
            s7.a.b(str, "getMessage warn success, pushId: " + str3);
            return bVarG;
        } catch (Exception e10) {
            s7.a.c(str, "getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "register_status";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        y7.b bVar2 = (y7.b) obj;
        if (bVar2 != null) {
            bVar.onRegisterStatus(context, bVar2);
        }
        int i10 = c8.a.f3305a;
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        p7.c cVar = a.C0117a.f10777a.f10771a;
        return a4.a.t(context, cVar.f11458b, cVar.f11459c, "register_status", intent.getStringExtra("messageSign"));
    }
}
