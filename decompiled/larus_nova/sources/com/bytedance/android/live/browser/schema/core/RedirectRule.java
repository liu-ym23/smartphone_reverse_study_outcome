package com.bytedance.android.live.browser.schema.core;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class RedirectRule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.schema.core.strategy.c f64188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<RedirectRule> f64190c;

    public final com.bytedance.android.live.schema.api.a a(JSONObject r100, final Function1<? super RedirectRule, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(this);
    L5:
        Object r103 = null;
        if (this.f64188a.a(r100) == false) goto L38;
        String r104 = this.f64189b;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L16;
        if (r104 != null) goto L40;
        return null;
    L40:
        return new com.bytedance.android.live.schema.api.a(r104);
    L16:
        final JSONArray r106 = new JSONArray();
        r100.put("state", r106);
        List<RedirectRule> r107 = this.f64190c;
        if (r107 == null) goto L41;
        Sequence r108 = CollectionsKt.asSequence(r107);
        if (r108 == null) goto L42;
        Sequence r109 = SequencesKt.mapIndexed(r108, new RedirectRule$getFinalSchemaInfo$2(r106, r101));
        if (r109 == null) goto L43;
        Iterator r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L32;
        Object r111 = r110.next();
        if (((com.bytedance.android.live.schema.api.a) r111) == null) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L24;
        r103 = r111;
        goto L32
    L28:
        r112 = false;
    L32:
        return (com.bytedance.android.live.schema.api.a) r103;
    L43:
        return null;
    L42:
        return null;
    L41:
        return null;
    L10:
        if (this.f64190c != null) goto L12;
        r105 = true;
        goto L13
    L38:
        return null;
    }

    public RedirectRule(com.bytedance.android.live.browser.schema.core.strategy.c r100, String r101, List<RedirectRule> r102) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f64188a = r100;
        this.f64189b = r101;
        this.f64190c = r102;
    }
}
