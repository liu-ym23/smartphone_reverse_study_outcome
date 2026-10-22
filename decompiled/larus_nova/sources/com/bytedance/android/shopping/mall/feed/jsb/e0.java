package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class e0 extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.writePerfSession";
    }

    public e0(qf3.d r100) {
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
        if (r109 == true) goto L44;
        if (r107 != null) goto L18;
    L21:
        if (r108 == true) goto L44;
        Object r110 = r102.get("timestamp");
        if ((r110 instanceof String) == true) goto L26;
        r110 = null;
    L26:
        String r111 = (String) r110;
        if (r111 != null) goto L29;
        r111 = "0";
    L29:
        Object r112 = r102.get("stage_type");
        if ((r112 instanceof String) == true) goto L32;
        r112 = null;
    L32:
        String r113 = (String) r112;
        Object r114 = r102.get("stage_data");
        if ((r114 instanceof Map) == true) goto L35;
        r114 = null;
    L35:
        Map<String, ? extends Object> r115 = (Map) r114;
        if (r115 != null) goto L38;
        r115 = MapsKt.emptyMap();
    L38:
        bm.b r116 = new bm.b(r107, r111);
        StageType.Companion.getClass();
        StageType r117 = StageType.a.a(r113);
        if (r117 != null) goto L41;
        r117 = StageType.NORMAL;
    L41:
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r116.f19540a = r117;
        r116.update(r115);
        ECPerfSessionManager.f48098d.d(r105, r107, r116);
        return TuplesKt.to(Boolean.TRUE, null);
    L18:
        if (StringsKt.isBlank(r107) == true) goto L21;
        r108 = false;
    L44:
        return TuplesKt.to(Boolean.FALSE, "invalid id or stage");
    L11:
        if (StringsKt.isBlank(r105) == true) goto L14;
        r109 = false;
        goto L15
    }
}
