package com.bytedance.android.livesdk.arch.data;

import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.livesdk.arch.state.source.PsType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends r {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.arch.data.a
    public final c a(c r110) {
        s r111 = (s) r110;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111.f103805f == true) goto L41;
        l5 r100 = r111.f103807h;
        if (r100 == null) goto L41;
        DataCenter r101 = r111.f103793d;
        if (r101 == null) goto L10;
        r101.put("data_toolbar_control_message", r100);
    L10:
        Map r102 = MapsKt.mapOf(TuplesKt.to("msg", r100.toString()));
        ke1.a.f502996a.getClass();
        ke1.a r103 = ke1.a.C6543a.a();
        if (r103 == null) goto L34;
        SimpleAlogArgsBuilder r104 = new SimpleAlogArgsBuilder();
        r104.c("dispatch msg");
        Map r105 = null;
        if (r102 != null) goto L15;
    L23:
        Unit r106 = Unit.INSTANCE;
        r103.c(r104.b());
        ke1.f.a r107 = new ke1.f.a("dispatch msg");
        if (r102 != null) goto L26;
    L33:
        Unit r108 = Unit.INSTANCE;
        r103.a(new ke1.f(r107));
        goto L34
    L26:
        if ((!r102.isEmpty()) == false) goto L28;
        r105 = r102;
    L28:
        if (r105 == null) goto L33;
        Iterator r109 = r105.entrySet().iterator();
    L31:
        if (r109.hasNext() == false) goto L33;
        Map.Entry r112 = (Map.Entry) r109.next();
        r107.a((String) r112.getKey(), String.valueOf(r112.getValue()));
        goto L31
    L15:
        if ((!r102.isEmpty()) == false) goto L17;
        Map r113 = r102;
    L18:
        if (r113 == null) goto L23;
        Iterator r114 = r113.entrySet().iterator();
    L21:
        if (r114.hasNext() == false) goto L23;
        Map.Entry r115 = (Map.Entry) r114.next();
        r104.a((String) r115.getKey(), String.valueOf(r115.getValue()));
        goto L21
    L17:
        r113 = null;
    L34:
        z51.e<ne1.d> r116 = r111.c();
        if (r116 == null) goto L41;
        int r117 = ne1.d.f518871b;
        PsType r118 = PsType.DispatchMsg;
        Intrinsics.checkNotNullParameter("dispatch msg", "msg");
        Intrinsics.checkNotNullParameter(r118, "type");
        ne1.d r119 = new ne1.d();
        Iterator r120 = r102.entrySet().iterator();
    L38:
        if (r120.hasNext() == false) goto L40;
        Map.Entry r121 = (Map.Entry) r120.next();
        String r122 = (String) r121.getKey();
        Object r123 = r121.getValue();
        Intrinsics.checkNotNullParameter(r122, "key");
        Intrinsics.checkNotNullParameter(r123, "value");
        ne1.a.C6915a.a(r119, r122, r123);
        goto L38
    L40:
        Unit r124 = Unit.INSTANCE;
        r116.b(r119);
    L41:
        return r111;
    }
}
