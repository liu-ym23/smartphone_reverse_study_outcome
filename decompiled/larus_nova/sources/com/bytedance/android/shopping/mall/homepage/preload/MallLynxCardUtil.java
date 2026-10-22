package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXExperiment;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import com.bytedance.android.ec.hybrid.list.util.q;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallLynxCardUtil implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f178370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f178371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f178372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f178373e;

    public MallLynxCardUtil(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f178373e = r100;
        this.f178369a = LazyKt.lazy(new MallLynxCardUtil$alreadyPreTemplate$2(this));
        this.f178370b = LazyKt.lazy(new MallLynxCardUtil$alreadyPreCreateView$2(this));
        this.f178371c = LazyKt.lazy(new MallLynxCardUtil$annieXPreCreateItems$2(this));
        this.f178372d = LazyKt.lazy(new MallLynxCardUtil$annieXPreLoadItems$2(this));
    }

    @Override // com.bytedance.android.ec.hybrid.list.util.q
    public final ECLynxLoadType a(int r100) {
        Lazy r101 = ECLynxAnnieXService.f46553a;
        if (ECLynxAnnieXExperiment.c().f46260a == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        Set r103 = (Set) this.f178372d.getValue();
        if (r103 != null) goto L12;
    L13:
        Set r104 = (Set) this.f178369a.getValue();
        if (r104 == null) goto L26;
        if (r104.contains(Integer.valueOf(r100)) != true) goto L26;
    L18:
        return ECLynxLoadType.PRE_LOAD;
    L26:
        if (ECLynxAnnieXService.b() == false) goto L33;
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) this.f178371c.getValue();
        if (r105 == null) goto L40;
        if (r105.contains(Integer.valueOf(r100)) != true) goto L40;
        return ECLynxLoadType.PRE_CREATE_VIEW;
    L40:
        return ECLynxLoadType.DEFAULT;
    L33:
        CopyOnWriteArraySet r106 = (CopyOnWriteArraySet) this.f178370b.getValue();
        if (r106 == null) goto L40;
        if (r106.contains(Integer.valueOf(r100)) != true) goto L40;
        return ECLynxLoadType.PRE_CREATE_VIEW;
    L12:
        if (r103.contains(Integer.valueOf(r100)) == true) goto L18;
    L19:
        Set r107 = (Set) this.f178369a.getValue();
        if (r107 == null) goto L26;
        if (r107.contains(Integer.valueOf(r100)) != true) goto L26;
        return ECLynxLoadType.PRE_LOAD;
    L5:
        if (ECLynxAnnieXExperiment.c().f46272m == false) goto L7;
        r102 = true;
        goto L8
    }
}
