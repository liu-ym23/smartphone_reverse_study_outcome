package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements com.bytedance.android.bst.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f180947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jq.a f180948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f180949c;

    @Override // com.bytedance.android.bst.api.g
    public final void a(String r100, Map<Object, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r102 = new LinkedHashMap();
        Map r103 = this.f180949c;
        if (r103 == null) goto L5;
        r102.putAll(r103);
    L5:
        Map<String, String> r104 = this.f180948b.i();
        if (r104 == null) goto L8;
        r102.putAll(r104);
    L8:
        ArrayList r105 = new ArrayList(r101.size());
        Iterator r106 = ((LinkedHashMap) r101).entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.add(TuplesKt.to(r107.getKey().toString(), r107.getValue()));
        goto L10
    L12:
        MapsKt.putAll(r102, r105);
        ContainerTrackAbility.a r108 = this.f180947a.f180946a.a().m();
        r108.f180701a = r102;
        m.a.a(r108, r100, false, null, null, 14);
    }

    public i(h r100, jq.a r101, Map r102) {
        this.f180947a = r100;
        this.f180948b = r101;
        this.f180949c = r102;
    }
}
