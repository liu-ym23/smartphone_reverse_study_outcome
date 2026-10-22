package com.bytedance.android.window.shop.widget.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/widget/topbar/ECWindowSearchView;", "Landroid/widget/FrameLayout;", "", "progress", "", "update", "Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "getMinMode", "()Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "setMinMode", "(Lcom/bytedance/android/window/shop/widget/topbar/MinMode;)V", "minMode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MinMode f190113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f190114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f190115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f190116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f190117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f190118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f190119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f190120h;

    public final MinMode getMinMode() {
        return this.f190113a;
    }

    public final void a(Integer r100) {
        if (r100 == null) goto L4;
        this.f190115c = r100.intValue();
        update(this.f190116d);
        return;
    L4:
        if (this.f190115c != 0) goto L8;
        TextView r101 = (TextView) findViewById(R.id.ec_window_search_notice);
        this.f190115c = r101.getRight() - r101.getLeft();
        update(0.0f);
        return;
    }

    public final void setMinMode(MinMode r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f190113a = r100;
        if (r100 != MinMode.ICON) goto L5;
        a(Integer.valueOf(this.f190117e));
    L5:
        update(0.0f);
    }

    public final void update(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
        float r101 = 1.0f;
    L6:
        this.f190116d = r101;
        MinMode r102 = this.f190113a;
        MinMode r103 = MinMode.ICON;
        if (r102 != r103) goto L9;
        this.f190120h.setAlpha(r101);
    L11:
        if (this.f190113a != MinMode.TEXT) goto L14;
        this.f190119g.setVisibility(0);
    L18:
        if (this.f190113a != r103) goto L20;
        float r104 = 1 - (0.33f * r101);
        this.f190118f.setScaleX(r104);
        this.f190118f.setScaleY(r104);
    L21:
        int r105 = this.f190115c;
        if (r105 > 0) goto L24;
        return;
    L24:
        if (this.f190113a != r103) goto L26;
        int r106 = this.f190117e;
    L27:
        int r107 = RangesKt.coerceAtLeast(this.f190114b, this.f190115c);
        ViewGroup.LayoutParams r108 = getLayoutParams();
        r108.width = (int) (r106 + ((r107 - r106) * r101));
        Unit r109 = Unit.INSTANCE;
        setLayoutParams(r108);
        return;
    L26:
        r106 = RangesKt.coerceAtLeast(r105, this.f190117e);
        goto L27
    L20:
        this.f190118f.setScaleX(0.66999996f);
        this.f190118f.setScaleY(0.66999996f);
        goto L21
    L14:
        if (r101 >= 0.1d) goto L16;
        this.f190119g.setVisibility(8);
        goto L18
    L16:
        this.f190119g.setVisibility(0);
        goto L18
    L9:
        this.f190120h.setAlpha(1.0f);
        goto L11
    L5:
        r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        goto L6
    }

    public ECWindowSearchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.ec_window_search_widget, this, true);
        this.f190113a = MinMode.TEXT;
        this.f190117e = r100.getResources().getDimensionPixelSize(R.dimen.ec_window_search_icon_width);
        r100.getResources().getDimensionPixelSize(R.dimen.ec_window_search_bar_left_padding);
        this.f190118f = findViewById(R.id.ec_window_search_icon);
        this.f190119g = findViewById(R.id.ec_window_search_notice);
        this.f190120h = findViewById(R.id.ec_window_search_bg);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        a(null);
    }
}
