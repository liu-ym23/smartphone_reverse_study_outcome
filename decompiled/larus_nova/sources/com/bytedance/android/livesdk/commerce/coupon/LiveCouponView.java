package com.bytedance.android.livesdk.commerce.coupon;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0082\u0001\tB)\b\u0007\u0012\u0006\u0010|\u001a\u00020{\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010}\u0012\b\b\u0002\u0010\u007f\u001a\u00020S¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010R\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\"\u0010Z\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010j\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010r\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010v\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010I\u001a\u0004\bt\u0010K\"\u0004\bu\u0010MR\"\u0010z\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010I\u001a\u0004\bx\u0010K\"\u0004\by\u0010M¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "Lcom/bytedance/android/livesdk/commerce/coupon/b;", "data", "", "setActivityData", "Lvl2/b;", "b", "Lvl2/b;", "getMCouponResourcePath", "()Lvl2/b;", "setMCouponResourcePath", "(Lvl2/b;)V", "mCouponResourcePath", "Lrg2/g;", "c", "Lrg2/g;", "getMLottieHelper", "()Lrg2/g;", "setMLottieHelper", "(Lrg2/g;)V", "mLottieHelper", "d", "Landroid/widget/RelativeLayout;", "getMCenterArea", "()Landroid/widget/RelativeLayout;", "setMCenterArea", "(Landroid/widget/RelativeLayout;)V", "mCenterArea", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getMTryGetButton", "()Landroid/widget/TextView;", "setMTryGetButton", "(Landroid/widget/TextView;)V", "mTryGetButton", "f", "getMDescView", "setMDescView", "mDescView", "Lcom/airbnb/lottie/LottieAnimationView;", ce.f26391f, "Lcom/airbnb/lottie/LottieAnimationView;", "getMDoubleCouponLottie", "()Lcom/airbnb/lottie/LottieAnimationView;", "setMDoubleCouponLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "mDoubleCouponLottie", "h", "getMHappyLottie", "setMHappyLottie", "mHappyLottie", "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", "getMCouponClick", "()Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", "setMCouponClick", "(Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;)V", "mCouponClick", "Landroid/widget/FrameLayout;", ce.f26395j, "Landroid/widget/FrameLayout;", "getMCouponView", "()Landroid/widget/FrameLayout;", "setMCouponView", "(Landroid/widget/FrameLayout;)V", "mCouponView", "Landroid/widget/ImageView;", ce.f26396k, "Landroid/widget/ImageView;", "getMCloseView", "()Landroid/widget/ImageView;", "setMCloseView", "(Landroid/widget/ImageView;)V", "mCloseView", "l", "getMDoubleCoupon", "setMDoubleCoupon", "mDoubleCoupon", "", "m", "I", "getMButtonState", "()I", "setMButtonState", "(I)V", "mButtonState", "Lcom/bytedance/android/livesdk/commerce/coupon/d;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/livesdk/commerce/coupon/d;", "getMCouponMsg", "()Lcom/bytedance/android/livesdk/commerce/coupon/d;", "setMCouponMsg", "(Lcom/bytedance/android/livesdk/commerce/coupon/d;)V", "mCouponMsg", "Lvl2/m;", "p", "Lvl2/m;", "getMHideLottieEntity", "()Lvl2/m;", "setMHideLottieEntity", "(Lvl2/m;)V", "mHideLottieEntity", "", "q", "Ljava/lang/String;", "getMMetaId", "()Ljava/lang/String;", "setMMetaId", "(Ljava/lang/String;)V", "mMetaId", "r", "getMFrontView", "setMFrontView", "mFrontView", "s", "getMBehindView", "setMBehindView", "mBehindView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponView extends RelativeLayout implements View.OnClickListener, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f119583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vl2.b f119584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rg2.g f119585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f119586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f119587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f119588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LottieAnimationView f119589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LottieAnimationView f119590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f119591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f119592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f119593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f119594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f119595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f119596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.livesdk.commerce.coupon.b f119597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public vl2.m f119598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f119599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f119600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f119601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f119602t;

    public static final class a {
    }

    public interface b {
        void a(String r100, Function0<Unit> r101);

        void b();

        void onCloseClick();
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCouponView f119603a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(LiveCouponView r100) {
            this.f119603a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LiveCouponView r101 = this.f119603a;
            com.bytedance.android.livesdk.commerce.coupon.b r102 = r101.f119597o;
            if (r102 != null) goto L5;
        L18:
            vl2.b r103 = r101.f119584b;
            if (r103 == null) goto L26;
            WeakHandler r104 = r101.f119583a;
            String r105 = r103.f555640e;
            l56.b r106 = l56.b.a();
            vl2.e r107 = new vl2.e(r105);
            if (r106.f507529a == false) goto L24;
            r106.f507530b.execute(new l56.a(r104, r107, 300));
            return;
        L24:
            throw new IllegalStateException("TaskManager not init");
        L26:
            return;
        L5:
            if (r102.activityType != 1) goto L7;
            boolean r108 = true;
        L9:
            if (r108 == true) goto L12;
            r102 = null;
        L12:
            if (r102 == null) goto L18;
            l56.b r109 = l56.b.a();
            WeakHandler r110 = r101.f119583a;
            if (r109.f507529a == false) goto L17;
            r109.f507530b.execute(new l56.a(r110, null, 400));
            return;
        L17:
            throw new IllegalStateException("TaskManager not init");
        L7:
            r108 = false;
            goto L9
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f119603a.getMDoubleCoupon().setVisibility(4);
        }
    }

    static {
    }

    public LiveCouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveCouponView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getMBehindView() {
        return this.f119601s;
    }

    public final int getMButtonState() {
        return this.f119595m;
    }

    public final RelativeLayout getMCenterArea() {
        return this.f119586d;
    }

    public final ImageView getMCloseView() {
        return this.f119593k;
    }

    public final b getMCouponClick() {
        return this.f119591i;
    }

    public final d getMCouponMsg() {
        return this.f119596n;
    }

    public final vl2.b getMCouponResourcePath() {
        return this.f119584b;
    }

    public final FrameLayout getMCouponView() {
        return this.f119592j;
    }

    public final TextView getMDescView() {
        return this.f119588f;
    }

    public final ImageView getMDoubleCoupon() {
        return this.f119594l;
    }

    public final LottieAnimationView getMDoubleCouponLottie() {
        return this.f119589g;
    }

    public final ImageView getMFrontView() {
        return this.f119600r;
    }

    public final LottieAnimationView getMHappyLottie() {
        return this.f119590h;
    }

    public final vl2.m getMHideLottieEntity() {
        return this.f119598p;
    }

    public final rg2.g getMLottieHelper() {
        return this.f119585c;
    }

    public final String getMMetaId() {
        return this.f119599q;
    }

    public final TextView getMTryGetButton() {
        return this.f119587e;
    }

    public final void a(vl2.b r100) {
        this.f119584b = r100;
        if (r100 == null) goto L11;
        this.f119601s.setImageURI(UriProtector.parse(r100.f555642g));     // Catch: Exception -> L6
        this.f119600r.setImageURI(UriProtector.parse(r100.f555641f));     // Catch: Exception -> L6
        this.f119594l.setImageURI(UriProtector.parse(r100.f555643h));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r110) {
        Object r100 = null;
        if (r110 == null) goto L5;
        Integer r101 = Integer.valueOf(r110.what);
    L6:
        if (r110 == null) goto L9;
        r100 = r110.obj;
    L9:
        if (r101 == null) goto L24;
        if (r101.intValue() != 200) goto L24;
        if ((r100 instanceof vl2.m) == false) goto L44;
        vl2.m r102 = (vl2.m) r100;
        if (r102 != null) goto L18;
        return;
    L18:
        if (r102.f555666a != 5) goto L53;
        this.f119598p = r102;
        this.f119589g.cancelAnimation();
        this.f119589g.setProgress(0.0f);
        this.f119589g.setVisibility(0);
        this.f119594l.setVisibility(8);
        rg2.g r111 = this.f119585c;
        if (r111 == null) goto L46;
        r111.a(r102, this.f119589g, false);
        return;
    L46:
        return;
    L53:
        return;
    L44:
        return;
    L24:
        if (r101 != null) goto L27;
    L38:
        if (r101 != null) goto L41;
        return;
    L41:
        if (r101.intValue() != 400) goto L52;
        this.f119592j.setVisibility(0);
        this.f119589g.setVisibility(8);
        float r112 = this.f119592j.getTranslationY();
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this.f119592j, View.TRANSLATION_Y, new float[]{r112, (r112 - this.f119592j.getHeight()) + t6.a(getContext(), 25.0f)});
        r113.setDuration(600);
        LottieAnimationView r103 = this.f119589g;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, View.TRANSLATION_Y, new float[]{r103.getTranslationY(), -10.0f});
        r104.setDuration(500);
        r104.start();
        r113.start();
        return;
    L52:
        return;
    L27:
        if (r101.intValue() != 300) goto L38;
        if ((r100 instanceof vl2.m) == false) goto L48;
        vl2.m r105 = (vl2.m) r100;
        if (r105 != null) goto L33;
        return;
    L33:
        if (r105.f555666a != 5) goto L54;
        this.f119592j.setVisibility(0);
        float r114 = this.f119592j.getTranslationY();
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f119592j, View.TRANSLATION_Y, new float[]{r114, (r114 - this.f119592j.getHeight()) + t6.a(getContext(), 2.0f)});
        r115.setDuration(600);
        r115.start();
        rg2.g r116 = this.f119585c;
        if (r116 == null) goto L50;
        r116.a(r105, this.f119590h, true);
        return;
    L50:
        return;
    L54:
        return;
    L48:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
    L27:
        if (r100 != null) goto L29;
        return;
    L29:
        if (r100.getId() != R.id.close_view) goto L42;
        b r101 = this.f119591i;
        if (r101 == null) goto L43;
        r101.onCloseClick();
        return;
    L43:
        return;
    L42:
        return;
    L4:
        if (r100.getId() != R.id.try_get_coupon) goto L27;
        int r102 = this.f119595m;
        if (r102 != 0) goto L10;
        this.f119595m = 2;
        b r103 = this.f119591i;
        if (r103 == null) goto L34;
        r103.a(this.f119599q, new AnonymousClass1(this));
        return;
    L34:
        return;
    L10:
        if (r102 != 2) goto L13;
        IESUIUtils.displayToast(getContext(), s1.B(R.string.ttlive_live_coupon_on_apply));
        return;
    L13:
        if (r102 == 1) goto L15;
        return;
    L15:
        if (this.f119596n == null) goto L38;
        IHostCommerceServiceLive r104 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).c();
        if (r104 == null) goto L24;
        Context r105 = getContext();
        JSONObject r106 = new JSONObject();
        r106.put("entry_name", AnchorBenefitToast.TYPE_COUPON);
        d r107 = this.f119596n;
        if (r107 == null) goto L22;
        String r108 = r107.couponMetaId;
        if (r108 == null) goto L22;
    L23:
        r106.put("coupon_id", r108);
        Unit r109 = Unit.INSTANCE;
        com.bytedance.android.livesdk.chatroom.bl.a r110 = new com.bytedance.android.livesdk.chatroom.bl.a(r104.showLivePromotionListFragment(r105, r106));
        PlatformMessageHelper.INSTANCE.setFollowGuideBarrier("EC_GOOD_LIST_DIALOG", r110);
    L22:
        r108 = "";
    L24:
        b r111 = this.f119591i;
        if (r111 == null) goto L39;
        r111.b();
        return;
    L39:
        return;
    }

    public final void setActivityData(com.bytedance.android.livesdk.commerce.coupon.b r100) {
        this.f119597o = r100;
        if (r100 == null) goto L46;
        boolean r101 = false;
        if (r100.activityType != 1) goto L7;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        com.bytedance.android.livesdk.commerce.coupon.b r103 = r100;
    L12:
        if (r103 == null) goto L47;
        TextView r104 = this.f119588f;
        String r105 = r100.beforeText;
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L22:
        if ((!r106) == false) goto L24;
        com.bytedance.android.livesdk.commerce.coupon.b r107 = r100;
    L25:
        if (r107 == null) goto L29;
        String r108 = r107.beforeText;
        if (r108 == null) goto L29;
    L30:
        r104.setText(r108);
        this.f119588f.setTextColor(s1.h(R.color.ttlive_coupon_decs_apply));
        this.f119588f.setAlpha(1.0f);
        this.f119588f.setTextSize(1, 13.0f);
        TextView r109 = this.f119587e;
        String r110 = r100.beforeButton;
        if (r110 != null) goto L33;
    L34:
        r101 = true;
    L36:
        if ((!r101) == true) goto L39;
        r100 = null;
    L39:
        if (r100 == null) goto L43;
        String r111 = r100.beforeButton;
        if (r111 == null) goto L43;
    L44:
        r109.setText(r111);
        this.f119587e.setTextColor(s1.h(R.color.ttlive_follow_btn_bg_color));
        this.f119587e.setTextSize(1, 15.0f);
        this.f119587e.setBackgroundDrawable(s1.m(R.drawable.ttlive_live_coupon_button_bg));
        return;
    L43:
        r111 = s1.B(R.string.ttlive_live_try_get_coupon);
        goto L44
    L33:
        if (r110.length() != 0) goto L36;
    L29:
        r108 = s1.B(R.string.ttlive_live_player_send_coupon);
        goto L30
    L24:
        r107 = null;
        goto L25
    L17:
        if (r105.length() == 0) goto L20;
        r106 = false;
        goto L22
    L47:
        return;
    L11:
        r103 = null;
        goto L12
    L7:
        r102 = false;
        goto L9
    }

    public final void setMBehindView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119601s = r100;
    }

    public final void setMButtonState(int r100) {
        this.f119595m = r100;
    }

    public final void setMCenterArea(RelativeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119586d = r100;
    }

    public final void setMCloseView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119593k = r100;
    }

    public final void setMCouponClick(b r100) {
        this.f119591i = r100;
    }

    public final void setMCouponMsg(d r100) {
        this.f119596n = r100;
    }

    public final void setMCouponResourcePath(vl2.b r100) {
        this.f119584b = r100;
    }

    public final void setMCouponView(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119592j = r100;
    }

    public final void setMDescView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119588f = r100;
    }

    public final void setMDoubleCoupon(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119594l = r100;
    }

    public final void setMDoubleCouponLottie(LottieAnimationView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119589g = r100;
    }

    public final void setMFrontView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119600r = r100;
    }

    public final void setMHappyLottie(LottieAnimationView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119590h = r100;
    }

    public final void setMHideLottieEntity(vl2.m r100) {
        this.f119598p = r100;
    }

    public final void setMLottieHelper(rg2.g r100) {
        this.f119585c = r100;
    }

    public final void setMMetaId(String r100) {
        this.f119599q = r100;
    }

    public final void setMTryGetButton(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119587e = r100;
    }

    public LiveCouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f119583a = new WeakHandler(Looper.getMainLooper(), this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_coupon_center_view, this);
        this.f119586d = (RelativeLayout) findViewById(R.id.center_area);
        this.f119587e = (TextView) findViewById(R.id.try_get_coupon);
        this.f119588f = (TextView) findViewById(R.id.desc_view);
        this.f119589g = (LottieAnimationView) findViewById(R.id.double_coupon_lottie);
        this.f119590h = (LottieAnimationView) findViewById(R.id.happy_lottie);
        this.f119592j = (FrameLayout) findViewById(R.id.real_coupon_container);
        this.f119593k = (ImageView) findViewById(R.id.close_view);
        this.f119594l = (ImageView) findViewById(R.id.double_coupon);
        this.f119601s = (ImageView) findViewById(R.id.behind_view);
        this.f119600r = (ImageView) findViewById(R.id.front_view);
        this.f119587e.setTextColor(s1.h(R.color.ttlive_try_apply_coupon));
        this.f119587e.setOnClickListener(this);
        this.f119593k.setOnClickListener(this);
        this.f119602t = new c(this);
    }

    public /* synthetic */ LiveCouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
