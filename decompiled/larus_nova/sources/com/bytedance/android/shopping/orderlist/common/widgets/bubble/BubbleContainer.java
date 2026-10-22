package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f179987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f179988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f179989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f179990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BubbleShadowLayout f179991e;

    public BubbleContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BubbleContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static void a(final View r100, final b r101) {
        if (r101.f180002a != BubbleOrientation.BOTTOM) goto L5;
        Point r102 = r101.a();
    L6:
        final int r103 = r102.x;
        final int r104 = r101.f180004c.x;
        int r105 = (r103 - r104) - r101.f180014m;
        int r106 = r101.f180012k;
        r100.setTranslationX(RangesKt.coerceIn(r105 - (r106 / 2), 0.0f, RangesKt.coerceAtLeast(r101.f180009h - r106, 0)));
        Lazy r107 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BubbleContainer", new BubbleContainer$handleTrianglePosition$1(r103, r104, r100, r101));
        return;
    L5:
        r102 = r101.b();
        goto L6
    }

    public BubbleContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.order_list_view_bubble_container, this, true);
        this.f179987a = (ViewGroup) findViewById(R.id.menu_root);
        this.f179988b = findViewById(R.id.bubble_top);
        this.f179989c = findViewById(R.id.bubble_bottom);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.menu_container);
        this.f179990d = r103;
        Drawable r104 = r103.getBackground();
        if ((r104 instanceof BackgroundDrawable) == true) goto L5;
        r104 = null;
    L5:
        BackgroundDrawable r105 = (BackgroundDrawable) r104;
        if (r105 == null) goto L8;
        r105.setBgColor(-1);
        r105.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(8));
        r105.invalidate();
    L8:
        this.f179991e = (BubbleShadowLayout) findViewById(R.id.view_bg_shadow);
    }

    public /* synthetic */ BubbleContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
