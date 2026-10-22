package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.k1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class n extends LinearLayout implements com.bytedance.android.ec.store.common.bubble.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f184717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f184718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f184719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f184720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f184721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f184722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f184723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f184724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f184725i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.store.common.bubble.d
    public final void b() {
        int r100 = this.f184722f.getWidth();
        int r101 = this.f184722f.getHeight();
        int[] r102 = new int[2];
        this.f184722f.getLocationInWindow(r102);
        int r103 = RangesKt.coerceAtLeast((((k1.m(getContext()) - r102[0]) - (r100 / 2)) - this.f184719c) - (this.f184718b / 2), 0);
        d2.e(this.f184717a, r103);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.rightMargin = this.f184719c;
        r104.topMargin = (r102[1] + r101) + this.f184720d;
        r104.gravity = 8388661;
        ViewParent r105 = getParent();
        if ((r105 instanceof ViewGroup) == true) goto L5;
        r105 = null;
    L5:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L8;
        r106.removeView(this);
    L8:
        ViewGroup r107 = this.f184723g;
        if (r107 == null) goto L11;
        r107.addView(this, r104);
    L11:
        new Handler(Looper.getMainLooper()).postDelayed(new o(this), this.f184724h);
        this.f184725i.invoke();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f184721e;
    }

    public n(Context r100, LifecycleOwner r101, View r102, ViewGroup r103, String r104, long r105, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "anchorView");
        Intrinsics.checkNotNullParameter(r104, "contentString");
        Intrinsics.checkNotNullParameter(r110, "showAction");
        super(r100, null, 0);
        this.f184721e = r101;
        this.f184722f = r102;
        this.f184723g = r103;
        this.f184724h = r105;
        this.f184725i = r110;
        this.f184718b = com.bytedance.android.shopping.extensions.b.b(20);
        this.f184719c = com.bytedance.android.shopping.extensions.b.b(4);
        this.f184720d = com.bytedance.android.shopping.extensions.b.b(2);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_store_layout_share_guide_bubble, this, true);
        setOrientation(1);
        this.f184717a = (ImageView) findViewById(R.id.ec_store_share_guide_bubble_up_triangle);
        TextView r106 = (TextView) findViewById(R.id.ec_store_layout_share_bubble_text);
        ((ImageView) findViewById(R.id.ec_store_layout_share_bubble_close_icon)).setOnClickListener(new m(this));
        Unit r107 = Unit.INSTANCE;
        r106.setText(r104);
    }
}
