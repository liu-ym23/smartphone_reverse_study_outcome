package com.bytedance.android.ec.hybrid.list.holder;

import com.bytedance.android.ec.hybrid.card.api.g;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod.a f47195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f47196b;

    @Override // com.bytedance.android.ec.hybrid.card.api.g
    public final void a(HashMap<String, Object> r110) {
        if (r110 == null) goto L27;
        Object r100 = this.f47196b.get("key");
        Object r101 = this.f47196b.get("subKey");
        Object r102 = this.f47196b.get("subSubKey");
        if (r100 != null) goto L7;
        Map<String, ? extends Object> r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r110)});
    L28:
        IDLXBridgeMethod.a r103 = this.f47195a;
        if (r111 != null) goto L31;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("message", "Item data is null")});
    L31:
        r103.invoke(r111);
        return;
    L7:
        Object r104 = r110.get(r100);
        if (r104 != null) goto L10;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r110)});
        goto L28
    L10:
        if (r101 != null) goto L13;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r104)});
        goto L28
    L13:
        if ((r104 instanceof Map) == false) goto L26;
        Object r112 = ((Map) r104).get(r101);
        if (r112 != null) goto L17;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r104)});
        goto L28
    L17:
        if (r102 != null) goto L20;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r112)});
        goto L28
    L20:
        if ((r112 instanceof Map) == false) goto L25;
        Object r105 = ((Map) r112).get(r102);
        if (r105 != null) goto L24;
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r112)});
        goto L28
    L24:
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r105)});
        goto L28
    L25:
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r112)});
        goto L28
    L26:
        r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r104)});
        goto L28
    L27:
        r111 = null;
        goto L28
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.g
    public final void onFail(String r100) {
        this.f47195a.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("message", r100)}));
    }

    public b(IDLXBridgeMethod.a r100, Map r101) {
        this.f47195a = r100;
        this.f47196b = r101;
    }
}
