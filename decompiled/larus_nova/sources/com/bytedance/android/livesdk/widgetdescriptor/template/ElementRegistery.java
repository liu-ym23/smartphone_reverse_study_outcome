package com.bytedance.android.livesdk.widgetdescriptor.template;

import a80.a;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ElementRegistery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function0<a<e0>>> f162460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f162461b;

    public ElementRegistery(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        this.f162461b = r100;
        this.f162460a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("media_title", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$1(this)), TuplesKt.to("media_count", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$2(this)), TuplesKt.to("media_avator", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$3(this)), TuplesKt.to("multicam", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$4(this)), TuplesKt.to("dynamic_dsl", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$5(this)), TuplesKt.to("interactive", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$6(this)), TuplesKt.to("public_screen", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$7(this)), TuplesKt.to("anchor_avatar", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$8(this)), TuplesKt.to("anchor_avatar_ec", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$9(this)), TuplesKt.to("user_rank", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$10(this)), TuplesKt.to("full_screen", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$11(this)), TuplesKt.to("discovery", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$12(this)), TuplesKt.to("discovery_ec", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$13(this)), TuplesKt.to("more_live", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$14(this)), TuplesKt.to("user_count", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$15(this)), TuplesKt.to("short_touch", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$16(this)), TuplesKt.to("long_touch", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$17(this)), TuplesKt.to("banner", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$18(this)), TuplesKt.to("enter_anim", new ElementRegistery$ELEMENT_CONFIG_REGISTERY$19(this))});
    }
}
