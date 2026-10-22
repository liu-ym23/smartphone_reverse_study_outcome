package q5;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import g5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10085a = u.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z10) {
        String str = f10085a;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z11 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z11 = true;
            }
            if (z10 == z11) {
                u.d().a(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z10 ? 1 : 2, 1);
            u uVarD = u.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" ");
            sb2.append(z10 ? "enabled" : "disabled");
            uVarD.a(str, sb2.toString());
        } catch (Exception e10) {
            u uVarD2 = u.d();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            sb3.append(z10 ? "enabled" : "disabled");
            String string = sb3.toString();
            if (uVarD2.f4344a <= 3) {
                Log.d(str, string, e10);
            }
        }
    }
}
