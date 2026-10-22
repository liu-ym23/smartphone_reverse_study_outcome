package r2;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import h2.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11694a = h2.j.f("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str = f11694a;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z3 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z3 = true;
            }
            if (z == z3) {
                h2.j.d().a(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            h2.j jVarD = h2.j.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" ");
            sb2.append(z ? "enabled" : "disabled");
            jVarD.a(str, sb2.toString());
        } catch (Exception e10) {
            h2.j jVarD2 = h2.j.d();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            sb3.append(z ? "enabled" : "disabled");
            String string = sb3.toString();
            if (((j.a) jVarD2).f9274c <= 3) {
                Log.d(str, string, e10);
            }
        }
    }
}
