package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sl.q;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemGuideModule;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "Ljava/lang/Runnable;", "d", "Lkotlin/Lazy;", "getHideRunnable", "()Ljava/lang/Runnable;", "hideRunnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemGuideModule extends ECDraweeView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f150120e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePromotionCardArgs f150121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f150122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.ec.common.api.jump.model.e f150123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f150124d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListItemGuideModule f150125a;

        public a(ListItemGuideModule r100) {
            this.f150125a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ListItemGuideModule r101 = this.f150125a;
            int r102 = ListItemGuideModule.f150120e;
            r101.j(true);
        }
    }

    public ListItemGuideModule(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ListItemGuideModule(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Runnable getHideRunnable() {
        return (Runnable) this.f150124d.getValue();
    }

    public final void j(boolean r100) {
        removeCallbacks(getHideRunnable());
        if (getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        com.bytedance.android.ec.common.api.jump.model.e r102 = this.f150123c;
        if (r102 == null) goto L20;
        LivePromotionCardArgs r103 = this.f150121a;
        if (r103 == null) goto L20;
        PromotionListEventActionImpl r104 = r103.f150099h;
        if (r104 == null) goto L20;
        g r105 = r102.f42856b;
        if (r103 == null) goto L18;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r106 = r103.f150037a;
        if (r106 == null) goto L18;
        String r107 = r106.a(ListItemGuideModule$hideGuide$1$1.INSTANCE, r102.f42855a.getIronIndex());
    L19:
        r104.i(true, r105, r100, r107);
    L18:
        r107 = null;
    L20:
        setVisibility(8);
        Function0<Unit> r108 = this.f150122b;
        if (r108 == null) goto L24;
        Unit r109 = r108.invoke();
        return;
    L24:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setArgument(LivePromotionCardArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150121a = r100;
    }

    public final void f(com.bytedance.android.ec.common.api.jump.model.e r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "promotionParams");
        Intrinsics.checkNotNullParameter(r111, "clearGuideData");
        this.f150123c = r110;
        this.f150122b = r111;
        q r112 = r110.f42855a.getClientData().f533696e;
        String r100 = null;
        if (r112 == null) goto L5;
        String r101 = r112.a();
    L7:
        if (r101 != null) goto L9;
    L26:
        j(false);
        return;
    L9:
        if (r112.e() == null) goto L26;
        if (getVisibility() != 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L26;
        LivePromotionCardArgs r103 = this.f150121a;
        if (r103 == null) goto L24;
        PromotionListEventActionImpl r104 = r103.f150099h;
        if (r104 == null) goto L24;
        g r105 = r110.f42856b;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r106 = r103.f150037a;
        if (r106 == null) goto L23;
        r100 = r106.a(ListItemGuideModule$bindData$1.INSTANCE, r110.f42855a.getIronIndex());
    L23:
        r104.i(false, r105, false, r100);
    L24:
        setVisibility(0);
        String r107 = r112.e();
        int r113 = r.f44937h;
        h0.e(this, r107, r.a.b("ec_live_promotion_list_guide_image"), null, null, 120);
        postDelayed(getHideRunnable(), r112.d());
        return;
    L13:
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public ListItemGuideModule(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150124d = LazyKt.lazy(new ListItemGuideModule$hideRunnable$2(this));
        setOnClickListener(new a(this));
        setAutoPlayAnimation(true);
    }

    public /* synthetic */ ListItemGuideModule(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
