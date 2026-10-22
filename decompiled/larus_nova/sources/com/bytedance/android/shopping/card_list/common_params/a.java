package com.bytedance.android.shopping.card_list.common_params;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.card_list.container.b;
import com.bytedance.android.shopping.card_list.container.init.e;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CardPassThroughData f171309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f171310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<AndroidYaTaInstance> f171311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f171312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f171313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f171314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PageFinder f171315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f171316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f171317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f171318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, j> f171319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final hb3.a f171320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f171321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f171322n;

    public final Map<String, ?> a() {
        Map<String, Object> r100 = this.f171311c.invoke().j();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("feature_conf");
    L7:
        if ((r102 instanceof Map) == false) goto L11;
        r101 = r102;
    L11:
        return (Map) r101;
    L5:
        r102 = null;
        goto L7
    }

    public a(Function0 r100, String r101, boolean r110) {
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        b r105 = new b();
        LinkedHashMap r106 = new LinkedHashMap();
        hb3.a r107 = new hb3.a();
        Intrinsics.checkNotNullParameter(r100, "yataInstance");
        Intrinsics.checkNotNullParameter(r102, "containerCallbacks");
        Intrinsics.checkNotNullParameter(r103, "selectedCartIds");
        Intrinsics.checkNotNullParameter(r104, "selectedShopIds");
        Intrinsics.checkNotNullParameter(r105, "renderState");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r106, "subscribeBridgeEvents");
        Intrinsics.checkNotNullParameter(r107, "customDataCenter");
        this.f171311c = r100;
        this.f171312d = r102;
        this.f171313e = r103;
        this.f171314f = r104;
        this.f171315g = null;
        this.f171316h = r105;
        this.f171317i = r101;
        this.f171318j = false;
        this.f171319k = r106;
        this.f171320l = r107;
        this.f171321m = r110;
        this.f171322n = 100;
        this.f171310b = new LinkedHashMap();
    }
}
