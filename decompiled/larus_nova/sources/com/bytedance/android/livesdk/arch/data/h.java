package com.bytedance.android.livesdk.arch.data;

import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends r {
    public h() {
    }

    @Override // com.bytedance.android.livesdk.arch.data.a
    public final c a(c r110) {
        s r111 = (s) r110;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        l5 r100 = r111.f103807h;
        if (r100 == null) goto L56;
        StringBuilder r101 = new StringBuilder("Receive msg:");
        r101.append(r100.getComponentType() + '-' + r100.getText());
        r101.append(" action:");
        int r102 = r100.getEventType();
        if (r102 != 1) goto L7;
        String r103 = "UP";
    L20:
        r101.append(r103);
        r101.append(" operate:");
        int r104 = r100.getOpType();
        if (r104 == 0) goto L25;
        if (r104 == 1) goto L24;
        String r105 = String.valueOf(r100.getOpType());
    L26:
        r101.append(r105);
        r101.append(" msgLogId:");
        r101.append(r100.getMsgLogId());
        if (v.a() == false) goto L29;
        r101.append(" extra:" + r100.getExtraData());
    L29:
        String r106 = r101.toString();
        if (r106 == null) goto L56;
        ke1.a.f502996a.getClass();
        ke1.a r107 = ke1.a.C6543a.a();
        if (r107 == null) goto L56;
        Map r108 = MapsKt.mapOf(TuplesKt.to("msg", r106));
        SimpleAlogArgsBuilder r109 = new SimpleAlogArgsBuilder();
        r109.c("log msg info");
        if (r108 != null) goto L36;
    L44:
        Unit r112 = Unit.INSTANCE;
        r107.c(r109.b());
        ke1.f.a r113 = new ke1.f.a("log msg info");
        if (r108 != null) goto L47;
    L55:
        Unit r114 = Unit.INSTANCE;
        r107.a(new ke1.f(r113));
        goto L56
    L47:
        if ((true ^ r108.isEmpty()) == true) goto L50;
        r108 = null;
    L50:
        if (r108 == null) goto L55;
        Iterator r115 = r108.entrySet().iterator();
    L53:
        if (r115.hasNext() == false) goto L55;
        Map.Entry r116 = (Map.Entry) r115.next();
        r113.a((String) r116.getKey(), String.valueOf(r116.getValue()));
        goto L53
    L36:
        if ((!r108.isEmpty()) == false) goto L38;
        Map r117 = r108;
    L39:
        if (r117 == null) goto L44;
        Iterator r118 = r117.entrySet().iterator();
    L42:
        if (r118.hasNext() == false) goto L44;
        Map.Entry r119 = (Map.Entry) r118.next();
        r109.a((String) r119.getKey(), String.valueOf(r119.getValue()));
        goto L42
    L38:
        r117 = null;
        goto L39
    L24:
        r105 = "toMore";
        goto L26
    L25:
        r105 = "toToolbar";
        goto L26
    L7:
        if (r102 != 2) goto L9;
        r103 = "DOWN";
        goto L20
    L9:
        if (r102 != 3) goto L11;
        r103 = "HasPermission";
        goto L20
    L11:
        if (r102 != 4) goto L13;
        r103 = "NoPermission";
        goto L20
    L13:
        if (r102 == 5) goto L15;
        r103 = "Unknown" + String.valueOf(r100.getEventType());
        goto L20
    L15:
        r103 = "UPDATE";
    L56:
        return r111;
    }
}
