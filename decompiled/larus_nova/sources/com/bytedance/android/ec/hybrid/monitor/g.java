package com.bytedance.android.ec.hybrid.monitor;

import com.bytedance.android.ec.hybrid.card.util.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.k;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f47561a = 0;

    static {
    }

    public static void b(com.bytedance.lynx.service.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initParams");
        Object r101 = p.a(p.a(p.a(r100, "param"), "initData"), "mData");     // Catch: Exception -> L5
        Method r102 = r101.getClass().getDeclaredMethod("markReadOnly", new Class[0]);     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.invoke(r101, new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        boolean r103 = f.f47559a;
        JSONObject r104 = new JSONObject();
        r104.put("scene", "markInitTemplateDataReadOnly");
        r104.put("message", "ECLynxCard: markInitTemplateDataReadOnly fail");
        String r105 = e.getMessage();
        if (r105 != null) goto L9;
        r105 = "";
    L9:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r105);
        Unit r106 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "params");
        IHybridHostService r107 = com.bytedance.android.ec.hybrid.a.h();
        if (r107 == null) goto L17;
        k r108 = r107.getIHybridHostEventService();
        if (r108 == null) goto L18;
        r108.logV3("ec_hybrid_reflect_error", r104);
        return;
    L18:
        return;
    }

    public static void a(t07.a r100, IKitView r101, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "lynxService");
        Intrinsics.checkNotNullParameter(r101, "kitView");
        Intrinsics.checkNotNullParameter(r110, "monitors");
        Method r102 = r100.getClass().getMethod("addMonitorContext", new Class[]{IKitView.class, String.class, String.class});     // Catch: Exception -> L12
        Iterator r103 = r110.keySet().iterator();     // Catch: Exception -> L12
    L5:
        if (r103.hasNext() == false) goto L19;
        String r104 = (String) r103.next();     // Catch: Exception -> L12
        Object[] r105 = new Object[3];     // Catch: Exception -> L12
        r105[0] = r101;     // Catch: Exception -> L12
        r105[1] = r104;     // Catch: Exception -> L12
        String r106 = (String) r110.get(r104);     // Catch: Exception -> L12
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        r105[2] = r106;     // Catch: Exception -> L12
        r102.invoke(r100, r105);     // Catch: Exception -> L12
    L19:
        return;
    }
}
