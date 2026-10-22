package b8;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import o7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f3134b = g.class.getSimpleName();

    @Override // b8.a
    public final Object a(Context context, Intent intent) {
        String str = this.f3134b;
        s7.a.b(str, "getMessage start");
        try {
            String stringExtra = intent.getStringExtra("messageValue");
            if (TextUtils.isEmpty(stringExtra)) {
                s7.a.c(str, "getMessage fail, messageValue is empty");
                return null;
            }
            y7.d dVarG = y7.d.g(stringExtra);
            if (dVarG == null) {
                s7.a.c(str, "getMessage fail, subTagsStatus is null");
                return null;
            }
            s7.a.b(str, "getMessage success");
            return dVarG;
        } catch (Exception e10) {
            s7.a.c(str, "SubTagsStatus getMessage error, " + e10.getMessage());
            return null;
        }
    }

    @Override // b8.a
    public final String b() {
        return "sub_tags_status";
    }

    @Override // b8.a
    public final void c(Context context, Object obj, n7.b bVar) {
        y7.d dVar = (y7.d) obj;
        if (dVar != null) {
            bVar.onSubTagsStatus(context, dVar);
        }
    }

    @Override // b8.a
    public final boolean d(Context context, Object obj, Intent intent) {
        p7.e eVar = a.C0117a.f10777a.f10774d;
        return a4.a.t(context, eVar.f11458b, eVar.f11459c, "sub_tags_status", intent.getStringExtra("messageSign"));
    }
}
