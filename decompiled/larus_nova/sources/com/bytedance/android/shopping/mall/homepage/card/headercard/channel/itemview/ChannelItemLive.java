package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.widget.GradientCircleBorderView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t93.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemLive;", "Landroid/widget/FrameLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarSdView", "Landroidx/appcompat/widget/AppCompatTextView;", "d", "Landroidx/appcompat/widget/AppCompatTextView;", "getTagView", "()Landroidx/appcompat/widget/AppCompatTextView;", "tagView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemLive extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientCircleBorderView f177699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientCircleBorderView f177700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f177701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f177702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f177703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f177704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f177705g;

    public ChannelItemLive(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelItemLive(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        Animator r100 = null;
        if (this.f177703e != null) goto L11;
        Animator r101 = AnimatorInflater.loadAnimator(getContext(), R.animator.shopping_mall_live_breath_animation);
        if ((r101 instanceof AnimatorSet) == true) goto L7;
        r101 = null;
    L7:
        AnimatorSet r102 = (AnimatorSet) r101;
        this.f177703e = r102;
        if (r102 == null) goto L11;
        r102.setTarget(this.f177699a);
    L11:
        if (this.f177704f != null) goto L19;
        Animator r103 = AnimatorInflater.loadAnimator(getContext(), R.animator.shopping_mall_live_middel_animation);
        if ((r103 instanceof AnimatorSet) == true) goto L15;
        r103 = null;
    L15:
        AnimatorSet r104 = (AnimatorSet) r103;
        this.f177704f = r104;
        if (r104 == null) goto L19;
        r104.setTarget(this.f177700b);
    L19:
        if (this.f177705g != null) goto L27;
        Animator r105 = AnimatorInflater.loadAnimator(getContext(), R.animator.shopping_mall_live_avatar_animation);
        if ((r105 instanceof AnimatorSet) == false) goto L24;
        r100 = r105;
    L24:
        AnimatorSet r106 = (AnimatorSet) r100;
        this.f177705g = r106;
        if (r106 == null) goto L27;
        r106.setTarget(this.f177701c);
    L27:
        c(this.f177704f);
        c(this.f177703e);
        c(this.f177705g);
    }

    public final SimpleDraweeView getAvatarSdView() {
        return this.f177701c;
    }

    public final AppCompatTextView getTagView() {
        return this.f177702d;
    }

    public static void a(AnimatorSet r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = r100.isStarted();
        boolean r102 = r100.isPaused();
        if (r101 == false) goto L9;
        if (r102 == true) goto L10;
        r100.pause();
        return;
    L10:
        return;
    }

    public static void c(AnimatorSet r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = r100.isStarted();
        boolean r102 = r100.isPaused();
        if (r101 == false) goto L8;
        if (r102 == false) goto L10;
        r100.resume();
        return;
    L10:
        return;
    L8:
        r100.start();
    }

    public ChannelItemLive(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r113 = c.f47296a;
        int r114 = c.c(54, getContext(), true);
        int r115 = c.c(46, getContext(), true);
        GradientCircleBorderView r100 = new GradientCircleBorderView(r110, null, 6, 0);
        r100.setStrokeWidth(c.c(1, getContext(), true));
        r100.setStartColor(ContextCompat.getColor(r110, R.color.shopping_home_color_FF3B52));
        r100.setEndColor(ContextCompat.getColor(r110, R.color.shopping_home_color_00FF3B52));
        Unit r101 = Unit.INSTANCE;
        this.f177699a = r100;
        GradientCircleBorderView r102 = new GradientCircleBorderView(r110, null, 6, 0);
        r102.setStrokeWidth(c.c(2, getContext(), true));
        r102.setStartColor(ContextCompat.getColor(r110, R.color.shopping_home_color_FF3B52));
        r102.setEndColor(ContextCompat.getColor(r110, R.color.shopping_home_color_00FF3B52));
        this.f177700b = r102;
        SimpleDraweeView r103 = new SimpleDraweeView(r110);
        r103.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(r110.getResources()).setRoundingParams(new RoundingParams().setRoundAsCircle(true)).build());
        this.f177701c = r103;
        AppCompatTextView r104 = new AppCompatTextView(r110);
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setColors(new int[]{ContextCompat.getColor(r110, R.color.shopping_home_color_FFFF7075), ContextCompat.getColor(r110, R.color.shopping_home_color_FF3344)});
        r105.setGradientType(0);
        r105.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r105.setCornerRadius(c.c(100, getContext(), true));
        r105.setStroke(c.c(1, getContext(), true), ContextCompat.getColor(r110, R.color.shopping_home_color_FFFFFF));
        r104.setBackground(r105);
        r104.setTextColor(ContextCompat.getColor(r110, R.color.shopping_home_color_FFFFFF));
        ViewCompat.setPaddingRelative(r104, c.c(5, getContext(), true), c.c(1, getContext(), true), c.c(5, getContext(), true), 0);
        r104.setSingleLine();
        r104.setTextSize(0, c.c(10, getContext(), true));
        a.d(r104);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        this.f177702d = r104;
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-1, -1);
        r116.gravity = 17;
        addView(r100, r116);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(r114, r114);
        r117.gravity = 17;
        addView(r102, r117);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r115, r115);
        r118.gravity = 17;
        addView(r103, r118);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(-2, c.c(16, getContext(), true));
        r119.gravity = 81;
        addView(r104, r119);
    }

    public /* synthetic */ ChannelItemLive(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
