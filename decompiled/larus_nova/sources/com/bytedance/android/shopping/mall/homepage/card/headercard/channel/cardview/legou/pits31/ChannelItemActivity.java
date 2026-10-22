package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/ChannelItemActivity;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemActivity extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f177615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f177616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MiaoShaPriceLabelView f177617c;

    public ChannelItemActivity(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelItemActivity(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ChannelItemActivity(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        SimpleDraweeView r103 = new SimpleDraweeView(r100);
        this.f177616b = r103;
        AttributeSet r104 = null;
        MiaoShaPriceLabelView r105 = new MiaoShaPriceLabelView(r100, r104, 6, 0);
        this.f177617c = r105;
        LinearLayout r106 = new LinearLayout(r100);
        int r107 = c.f47296a;
        int r108 = c.c(63, r100, true);
        setVisibility(8);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.gravity = 1;
        Unit r110 = Unit.INSTANCE;
        setLayoutParams(r109);
        r106.setOrientation(1);
        r106.setGravity(1);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r108, r108);
        r111.gravity = 1;
        r106.addView(r103, r111);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, c.c(18, r100, true));
        r112.gravity = 1;
        r106.addView(r105, r112);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        addView(r106, r113);
    }

    public /* synthetic */ ChannelItemActivity(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
