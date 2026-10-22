package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements com.bytedance.android.bst.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f169061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f169062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f169063c;

    @Override // com.bytedance.android.bst.api.g
    public final void a(String r100, Map<Object, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r102 = new LinkedHashMap();
        AnchorV4HeadV2VO r103 = this.f169061a.f169055b.K10();
        if (r103 == null) goto L7;
        Map<String, String> r104 = r103.getTrackMeta();
        if (r104 == null) goto L7;
        r102.putAll(r104);
    L7:
        Map r105 = this.f169062b;
        if (r105 == null) goto L10;
        r102.putAll(r105);
    L10:
        ArrayList r106 = new ArrayList(r101.size());
        Iterator r107 = ((LinkedHashMap) r101).entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.add(TuplesKt.to(r108.getKey().toString(), r108.getValue()));
        goto L12
    L14:
        MapsKt.putAll(r102, r106);
        this.f169061a.f169055b.rR().o0(r100, r102, this.f169063c);
    }

    public c(a r100, Map r101, boolean r102) {
        this.f169061a = r100;
        this.f169062b = r101;
        this.f169063c = r102;
    }
}
