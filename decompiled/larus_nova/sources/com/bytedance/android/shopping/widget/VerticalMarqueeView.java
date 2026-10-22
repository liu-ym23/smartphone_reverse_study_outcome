package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/widget/VerticalMarqueeView;", "Landroid/widget/ViewFlipper;", "", "Landroid/view/View;", "b", "Ljava/util/List;", "getViews", "()Ljava/util/List;", "views", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalMarqueeView extends ViewFlipper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f187251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f187252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f187253c;

    public static final class a {
    }

    static {
    }

    public VerticalMarqueeView() {
        throw null;
    }

    public VerticalMarqueeView(Context r100) {
        this(r100, null, 62);
    }

    public VerticalMarqueeView(Context r100, AttributeSet r101) {
        this(r100, r101, 60);
    }

    public final List<View> getViews() {
        return this.f187252b;
    }

    public VerticalMarqueeView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        List<View> r103 = CollectionsKt.emptyList();
    L10:
        if ((r102 & 8) == 0) goto L12;
        int r104 = 5000;
    L14:
        if ((r102 & 16) == 0) goto L16;
        long r105 = 3000;
    L17:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f187252b = r103;
        this.f187253c = null;
        Function0<Unit> r106 = new VerticalMarqueeView$delayAddViewCB$1(this);
        this.f187251a = r106;
        setFlipInterval(r104);
        Animation r107 = AnimationUtils.loadAnimation(r100, R.anim.ec_commerce_anim_bottom_in);
        r107.setAnimationListener(new p(this));
        Unit r108 = Unit.INSTANCE;
        setInAnimation(r107);
        setOutAnimation(AnimationUtils.loadAnimation(r100, R.anim.ec_commerce_anim_top_out));
        postDelayed(new q(r106), r105);
        return;
    L16:
        r105 = 0;
        goto L17
    L12:
        r104 = 0;
        goto L14
    L8:
        r103 = null;
        goto L10
    }
}
