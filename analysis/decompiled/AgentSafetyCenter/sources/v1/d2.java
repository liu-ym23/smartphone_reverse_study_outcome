package v1;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import k0.p2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d2 {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f14405a = new LinkedHashMap();

    public static final nc.r0 a(Context context) {
        nc.r0 r0Var;
        LinkedHashMap linkedHashMap = f14405a;
        synchronized (linkedHashMap) {
            try {
                Object objM = linkedHashMap.get(context);
                if (objM == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    mc.e eVarC = h5.t.c(-1, 6, null);
                    l5.j jVarK = nc.k0.k(new p2(contentResolver, uriFor, new i9.o(eVarC, Handler.createAsync(Looper.getMainLooper())), eVarC, context, null));
                    kc.k1 k1VarC = kc.w.c();
                    rc.e eVar = kc.e0.f7430a;
                    pc.c cVar = new pc.c(ac.a.N(k1VarC, pc.n.f9978a));
                    nc.q0 q0Var = new nc.q0();
                    VarHandle.storeStoreFence();
                    objM = nc.k0.m(jVarK, cVar, q0Var, Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    linkedHashMap.put(context, objM);
                }
                r0Var = (nc.r0) objM;
            } catch (Throwable th) {
                throw th;
            }
        }
        return r0Var;
    }

    public static final k0.v b(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof k0.v) {
            return (k0.v) tag;
        }
        return null;
    }
}
