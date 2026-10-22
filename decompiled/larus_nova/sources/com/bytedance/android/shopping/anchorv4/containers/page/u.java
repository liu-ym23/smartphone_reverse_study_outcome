package com.bytedance.android.shopping.anchorv4.containers.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.PdpViewModelHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f166325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f166326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f166327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f166328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f166329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f166330f;

    public final Context getContext() {
        return this.f166328d;
    }

    public static void a(n r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        PageLifeCycleOwner r101 = r100.getLifecycleOwner();
        r101.getClass();
        r101.a(Lifecycle.State.DESTROYED);
        r101.f166267b.getLifecycle().removeObserver(r101);
        PdpViewModelHelper.INSTANCE.clearViewModelByKey(r100.getViewModelStore(), r100.s());
    }

    public final void b(Bundle r100) {
        m r101 = this.f166330f;
        AnchorV4Param r102 = r101.O00();
        StringBuilder r103 = new StringBuilder("product_detail_");
        int r104 = this.f166326b;
        this.f166326b = r104 + 1;
        r103.append(r104);
        n r105 = r101.e20(r102, r100, r103.toString());
        n r106 = this.f166325a;
        if (r106 != null) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == true) goto L8;
        a(r106);
        this.f166327c = new t(this);
    L8:
        p r108 = r105.k();
        this.f166329e.f166292b.addView(r108.f166300a, -1, -1);
        View r109 = r108.f166301b;
        if (r109 == null) goto L13;
        ViewGroup r110 = this.f166329e.f166293c;
        if (r110 == null) goto L13;
        r110.addView(r109, -1, -1);
    L13:
        View r111 = r108.f166302c;
        if (r111 == null) goto L18;
        ViewGroup r112 = this.f166329e.f166294d;
        if (r112 == null) goto L18;
        r112.addView(r111, -1, -1);
    L18:
        if (r107 == true) goto L20;
        this.f166329e.a(false);
    L20:
        PageLifeCycleOwner r113 = r105.getLifecycleOwner();
        r113.f166267b.getLifecycle().addObserver(r113);
        this.f166325a = r105;
        return;
    L5:
        r107 = false;
        goto L6
    }

    public final void c(BaseProductDetailPage r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        if (Intrinsics.areEqual(r100, this.f166325a) == false) goto L8;
        Runnable r101 = this.f166327c;
        if (r101 == null) goto L9;
        r101.run();
        return;
    L9:
        return;
    }

    public u(Context r100, g r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "creator");
        this.f166328d = r100;
        this.f166329e = r101;
        this.f166330f = r102;
    }
}
