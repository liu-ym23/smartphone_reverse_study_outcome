package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j0 implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDPLynxListenerActionEvent f166649a;

    public j0(PDPLynxListenerActionEvent r100) {
        this.f166649a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.optString(LocationMonitorConst.IDENTIFIER);
        String r102 = this.f166649a.f166588k.getSessionId();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.equals(r101) != true) goto L13;
        this.f166649a.f166588k.q0(false);
        PDPLynxListenerActionEvent r103 = this.f166649a;
        String r104 = r103.f166583f;
        if (r104 == null) goto L14;
        Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r105 = r103.f166585h;
        if (r105 == null) goto L15;
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        Unit r107 = r105.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to(r104, r100)), null, 5));
        return;
    L15:
        return;
    L14:
        return;
    }
}
