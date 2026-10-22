package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d0 extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.readPerfSession";
    }

    public d0(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        Object r104 = r102.get("session_id");
        if ((r104 instanceof String) == true) goto L5;
        r104 = null;
    L5:
        String r105 = (String) r104;
        Object r106 = r102.get("stage");
        if ((r106 instanceof String) == true) goto L8;
        r106 = null;
    L8:
        String r107 = (String) r106;
        boolean r108 = true;
        if (r105 != null) goto L11;
    L14:
        boolean r109 = true;
    L15:
        if (r109 == true) goto L17;
        if (r107 != null) goto L20;
    L23:
        if (r108 == false) goto L25;
        bm.a r110 = ECPerfSessionManager.f48098d.b(r105);
    L26:
        if (r110 == null) goto L35;
        LinkedHashMap r111 = new LinkedHashMap();
        LinkedHashMap r112 = new LinkedHashMap();
        r112.putAll(r110.f19537a);
        Unit r113 = Unit.INSTANCE;
        r111.put("common", r112);
        LinkedList r114 = new LinkedList();
        Iterator<Map.Entry<String, bm.b>> r115 = r110.f19539c.entrySet().iterator();
    L30:
        if (r115.hasNext() == false) goto L32;
        r114.add(r115.next().getValue().b());
        goto L30
    L32:
        Unit r116 = Unit.INSTANCE;
        r111.put("stages", r114);
        r103.putAll(r111);
        return TuplesKt.to(Boolean.TRUE, null);
    L35:
        return TuplesKt.to(Boolean.FALSE, "no session info");
    L25:
        r110 = ECPerfSessionManager.f48098d.c(r105, r107);
        goto L26
    L20:
        if (StringsKt.isBlank(r107) == true) goto L23;
        r108 = false;
        goto L23
    L17:
        return TuplesKt.to(Boolean.FALSE, "invalid session id");
    L11:
        if (StringsKt.isBlank(r105) == true) goto L14;
        r109 = false;
        goto L15
    }
}
