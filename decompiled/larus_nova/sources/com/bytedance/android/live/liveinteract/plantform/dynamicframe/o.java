package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, h> f77089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ih0.b f77090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f77091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f77092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f77093e;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        ALogger.i("MultiLinkFeedDynamicWidget", "onDestroy, mBizId: " + this.f77093e);
        Iterator r101 = ((LinkedHashMap) this.f77089a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        Map.Entry r102 = (Map.Entry) r101.next();
        ih0.c r103 = ((h) r102.getValue()).f76947a;
        if (r103 == null) goto L16;
        View r104 = r103.S0();
        if (r104 == null) goto L16;
        ViewGroup r105 = UtilityKotlinExtentionsKt.p(r104);
        if (r105 == null) goto L16;
        ih0.c r106 = ((h) r102.getValue()).f76947a;
        if (r106 == null) goto L14;
        View r107 = r106.S0();
    L15:
        r105.removeView(r107);
        goto L16
    L14:
        r107 = null;
    L16:
        ((h) r102.getValue()).b();
        goto L4
    L17:
        ((LinkedHashMap) this.f77089a).clear();
        int r108 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.f77144a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.c(this.f77093e, r100);
    }

    public final void b(String r100) {
        h r101 = this.f77089a.remove(r100);
        if (r101 == null) goto L16;
        this.f77090b.Tl(r101.f76947a);
        r101.b();
        ih0.c r102 = r101.f76947a;
        if (r102 == null) goto L17;
        View r103 = r102.S0();
        if (r103 == null) goto L18;
        ViewGroup r104 = UtilityKotlinExtentionsKt.p(r103);
        if (r104 == null) goto L19;
        ih0.c r105 = r101.f76947a;
        if (r105 == null) goto L13;
        View r106 = r105.S0();
    L14:
        r104.removeView(r106);
        return;
    L13:
        r106 = null;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public o(ih0.b r100, Context r101, ViewGroup r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "mContext");
        Intrinsics.checkNotNullParameter(r102, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r103, "mBizId");
        this.f77090b = r100;
        this.f77091c = r101;
        this.f77092d = r102;
        this.f77093e = r103;
        this.f77089a = new LinkedHashMap();
    }
}
