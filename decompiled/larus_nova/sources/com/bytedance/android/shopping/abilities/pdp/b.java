package com.bytedance.android.shopping.abilities.pdp;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.ab.u;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import df.p;
import df.r;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements com.bytedance.android.shopping.base.event.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f164120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventActionImpl f164121b;

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParamToEntranceInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f164121b.appendEventParamToEntranceInfo(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f164121b.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f164121b.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void clearEventParams() {
        this.f164121b.clearEventParams();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, PageFinder r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f164121b.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, PageFinder r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f164121b.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f164121b.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, Pair<String, ? extends Object>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f164121b.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f164121b.initEventContext(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f164121b.initEventContext(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final Map<String, Object> getEventParams() {
        return this.f164121b.c();
    }

    public b(r r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "pdpRequired");
        Intrinsics.checkNotNullParameter(r101, "pdpOptional");
        this.f164121b = new EventActionImpl();
        this.f164120a = u.a();
        Intrinsics.checkNotNullParameter(r100, "$this$toTrackMap");
        appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r100.f468149a), TuplesKt.to("enter_from", r100.f468150b)}));
        Intrinsics.checkNotNullParameter(r101, "$this$toTrackMap");
        appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", r101.f468135u), TuplesKt.to("enter_method", r101.f468137w), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r101.f468138x), TuplesKt.to("room_id", r101.f468124j), TuplesKt.to("item_id", r101.f468123i), TuplesKt.to("author_id", r101.f468120f), TuplesKt.to("sec_author_id", r101.f468121g), TuplesKt.to("product_id", r101.f468115a), TuplesKt.to("creative_id", r101.L), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r101.f468116b), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_META_PARAM, r101.f468131q), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS, r101.f468132r)}));
    }

    public final void a(int r100, String r101, String r102) {
        Map<String, ? extends Object> r103 = MapsKt.mapOf(new Pair[]{TuplesKt.to("result_state", Integer.valueOf(r100)), TuplesKt.to("result_reason", r101), TuplesKt.to("result_message", r102)});
        if (this.f164120a == false) goto L6;
        doEventAction("shopping_abilities_pdp_preload_result", r103);
        return;
    }

    public final void b(int r100, String r101, String r102) {
        Map<String, ? extends Object> r103 = MapsKt.mapOf(new Pair[]{TuplesKt.to("result_state", Integer.valueOf(r100)), TuplesKt.to("result_reason", r101), TuplesKt.to("result_message", r102)});
        if (this.f164120a == false) goto L6;
        doEventAction("shopping_abilities_pdp_start_result", r103);
        return;
    }
}
