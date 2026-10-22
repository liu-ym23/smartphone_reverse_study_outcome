package j1;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import b0.z2;
import com.stepos.agentbus.R;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class k2 {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f5219a = new LinkedHashMap();

    public static final la.s0 a(Context context) {
        la.s0 s0Var;
        LinkedHashMap linkedHashMap = f5219a;
        synchronized (linkedHashMap) {
            try {
                Object f0Var = linkedHashMap.get(context);
                if (f0Var == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    ka.g gVarB = a.a.b(-1, 6, null);
                    a7.d dVar = new a7.d(new z2(contentResolver, uriFor, new j2(gVarB, Handler.createAsync(Looper.getMainLooper())), gVarB, context, null));
                    ia.x1 x1VarC = ia.d0.c();
                    pa.e eVar = ia.n0.f4982a;
                    na.d dVar2 = new na.d(ia.f1.plus(x1VarC, na.o.f6923a));
                    la.r0 r0Var = new la.r0(0L, Long.MAX_VALUE);
                    Float fValueOf = Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f));
                    h4.s sVarG = la.k0.g(dVar, 1);
                    la.u0 u0VarC = la.k0.c(fValueOf);
                    ia.d0.r(dVar2, (g7.l) sVarG.f4157i, r0Var.equals(la.n0.f5967a) ? ia.c0.f4926f : ia.c0.f4929i, new la.a0(r0Var, (la.j) sVarG.f4155g, u0VarC, fValueOf, (g7.d) null));
                    f0Var = new la.f0(u0VarC);
                    linkedHashMap.put(context, f0Var);
                }
                s0Var = (la.s0) f0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s0Var;
    }

    public static final b0.u b(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof b0.u) {
            return (b0.u) tag;
        }
        return null;
    }
}
