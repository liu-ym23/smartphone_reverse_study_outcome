package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.w;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002R(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray2/MatchRoomGiftTrayAnimationView;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/BaseGiftTrayAnimationView;", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "", "getOriginalTopMargin", "getGatherHeight", "getGiftToHotMsgTrayMargin", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "value", ce.f26396k, "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setMAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "mAnchor", "Ls02/d;", "l", "Ls02/d;", "getOnGiftTrayIdleStateListener", "()Ls02/d;", "setOnGiftTrayIdleStateListener", "(Ls02/d;)V", "onGiftTrayIdleStateListener", "Lcom/bytedance/android/livesdk/revenue/service/interactivity/b;", "getInteractivityService", "()Lcom/bytedance/android/livesdk/revenue/service/interactivity/b;", "interactivityService", "", "isAnchor", "Z", "setAnchor", "(Z)V", "isPortrait", "()Z", "setPortrait", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomGiftTrayAnimationView extends BaseGiftTrayAnimationView implements y {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f130340o = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f130341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n12.f f130342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s02.c f130343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f130344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup.MarginLayoutParams f130345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f130346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IBaseUser f130347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s02.d f130348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r02.b f130349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f130350n;

    public static final class a implements s02.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchRoomGiftTrayAnimationView f130351a;

        @Override // s02.b
        public final void onPlay() {
            MatchRoomGiftTrayAnimationView.r(this.f130351a);
            MatchRoomGiftTrayAnimationView r100 = this.f130351a;
            r100.getClass();
            GiftTrayMessageManager r101 = GiftTrayMessageManager.f130310r;
            GiftTrayMessageManager r102 = GiftTrayMessageManager.a.a();
            r102.f130320j = r100.f130349m.f535423b;
            s02.d r103 = this.f130351a.getOnGiftTrayIdleStateListener();
            if (r103 == null) goto L5;
            r103.e();
        L5:
            BaseGiftTrayAnimationView.n(this.f130351a, 50, false, 2);
        }

        public a(MatchRoomGiftTrayAnimationView r100) {
            this.f130351a = r100;
        }

        @Override // s02.b
        public final void a(NormalGiftMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "normalGiftMessage");
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.f(Long.valueOf(r100.f129771a), "play onFinish " + r100.f129772b);
            MatchRoomGiftTrayAnimationView r101 = this.f130351a;
            int r102 = MatchRoomGiftTrayAnimationView.f130340o;
            r101.getClass();
            GiftTrayMessageManager r103 = GiftTrayMessageManager.f130310r;
            GiftTrayMessageManager.a.a().f130320j = r101.f130349m.f535423b;
            this.f130351a.f130349m.c();
            MatchRoomGiftTrayAnimationView r104 = this.f130351a;
            if (r104.f130349m.f535423b == false) goto L7;
            s02.d r105 = r104.getOnGiftTrayIdleStateListener();
            if (r105 == null) goto L7;
            r105.onIdle();
        L7:
            GiftTrayMessageManager.a.a().j(r100);
            GiftTrayMessageManager.a.a().m();
            this.f130351a.m(300, true);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchRoomGiftTrayAnimationView f130352a;

        public b(MatchRoomGiftTrayAnimationView r100) {
            this.f130352a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L6;
            this.f130352a.f130349m.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f130352a.f130341e, "hide tray due to needShowGiftEffectSwitch is off");
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchRoomGiftTrayAnimationView f130353a;

        public c(MatchRoomGiftTrayAnimationView r100) {
            this.f130353a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L6;
            this.f130353a.f130349m.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f130353a.f130341e, "hide tray due to needShowGiftTraySwitch is off");
            return;
        }
    }

    public MatchRoomGiftTrayAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MatchRoomGiftTrayAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getGiftToHotMsgTrayMargin() {
        return s1.f(16.0f);
    }

    private final com.bytedance.android.livesdk.revenue.service.interactivity.b getInteractivityService() {
        return (com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void c() {
        GiftTrayMessageManager r100 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager.a.a().c();
        this.f130349m.h();
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final boolean e() {
        return this.f130349m.f535423b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void g() {
        r02.b r100 = this.f130349m;
        if (r100.f535423b == true) goto L6;
        r100.f535426e.g();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void h() {
        r02.b r100 = this.f130349m;
        if (r100.f535423b == true) goto L6;
        r100.f535426e.l();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void i() {
        r02.b r100 = this.f130349m;
        r100.f535431j = this.f130350n;
        r100.f535432k = this.f130343g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.c();
        GiftTrayMessageManager r100 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager.a.a().c();
        GiftTrayMessageManager r101 = GiftTrayMessageManager.a.a();
        r101.f130321k = null;
        r101.c();
        r02.b r102 = this.f130349m;
        if (r102.f535431j == null) goto L6;
        r102.f535431j = null;
    L6:
        if (r102.f535432k == null) goto L8;
        r102.f535432k = null;
    L8:
        r102.h();
        ValueAnimator r103 = this.f130346j;
        if (r103 == null) goto L11;
        r103.removeAllUpdateListeners();
    L11:
        ValueAnimator r104 = this.f130346j;
        if (r104 == null) goto L14;
        r104.cancel();
    L14:
        this.f130344h.clear();
        GiftContext r105 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r105 == null) goto L19;
        m<Boolean> r106 = r105.getCancelComboForDegradeInMatch();
        if (r106 == null) goto L19;
        r106.setValue(Boolean.FALSE);
    L19:
        super.onDetachedFromWindow();
    }

    private final int getGatherHeight() {
        m<hq2.c> r100 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r100 == null) goto L21;
        hq2.c r101 = r100.getValue();
        if (r101 == null) goto L21;
        if (r101.f486498b != true) goto L21;
        m<hq2.c> r102 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r102 == null) goto L13;
        hq2.c r103 = r102.getValue();
        if (r103 == null) goto L13;
        int r104 = r103.f486497a;
    L14:
        if (r104 <= 0) goto L21;
        m<hq2.c> r105 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r105 == null) goto L29;
        hq2.c r106 = r105.getValue();
        if (r106 != null) goto L20;
        return 0;
    L20:
        return r106.f486497a;
    L29:
        return 0;
    L13:
        r104 = 0;
    L21:
        m<Integer> r107 = getInteractivityService().getHotMsgTrayPos();
        if (r107 == null) goto L31;
        Integer r108 = r107.getValue();
        if (r108 == null) goto L32;
        int r109 = r108.intValue();
        if (r109 > 0) goto L28;
        return 0;
    L28:
        return r109 + getGiftToHotMsgTrayMargin();
    L32:
        return 0;
    L31:
        return 0;
    }

    private final int getOriginalTopMargin() {
        if (PadConfigUtils.a() == false) goto L17;
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L7;
        RevPadOrientation r101 = r100.getPadOrientationData();
    L9:
        if (r101 != RevPadOrientation.LANDSCAPE) goto L15;
        Object r102 = getParent();
        if (r102 == null) goto L14;
        return ((((View) r102).getHeight() - getPublicScreenHeight()) - getPublicScreenMarginBottom()) - getHeight();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L15:
        return 0;
    L7:
        r101 = null;
        goto L9
    L17:
        return s1.f(8.0f);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void b() {
        RTLUtil.isAppRTL(getContext());
        this.f130349m.getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        m<hq2.c> r100 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r100 == null) goto L9;
        Observable<hq2.c> r101 = r100.a();
        if (r101 == null) goto L9;
        Disposable r102 = r101.subscribe(new j(this));
        if (r102 == null) goto L9;
        RxUtilKt.c(r102, this.f130344h);
    L9:
        m<Integer> r103 = getInteractivityService().getHotMsgTrayPos();
        if (r103 == null) goto L16;
        Observable<Integer> r104 = r103.a();
        if (r104 == null) goto L16;
        Disposable r105 = r104.subscribe(new i(this));
        if (r105 == null) goto L16;
        RxUtilKt.c(r105, this.f130344h);
    L16:
        ViewGroup.LayoutParams r106 = getLayoutParams();
        if (r106 == null) goto L45;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (PadConfigUtils.a() == false) goto L21;
        float r108 = 20.0f;
    L22:
        r107.leftMargin = s1.f(r108);
        setLayoutParams(r107);
        GiftContext r109 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r109 == null) goto L31;
        m<Boolean> r110 = r109.getNeedShowGiftEffectSwitch();
        if (r110 == null) goto L31;
        Observable<Boolean> r111 = r110.a();
        if (r111 == null) goto L31;
        Disposable r112 = r111.subscribe(new b(this));
        if (r112 == null) goto L31;
        RxUtilKt.c(r112, this.f130344h);
    L31:
        GiftContext r113 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r113 == null) goto L40;
        m<Boolean> r114 = r113.getNeedShowGiftTraySwitch();
        if (r114 == null) goto L40;
        Observable<Boolean> r115 = r114.a();
        if (r115 == null) goto L40;
        Disposable r116 = r115.subscribe(new c(this));
        if (r116 == null) goto L40;
        RxUtilKt.c(r116, this.f130344h);
    L40:
        GiftTrayMessageManager r117 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager r118 = GiftTrayMessageManager.a.a();
        r118.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r118.f130321k = this;
        r02.b r119 = this.f130349m;
        r119.f535431j = this.f130350n;
        r119.f535432k = this.f130343g;
        GiftTrayMessageManager r120 = GiftTrayMessageManager.a.a();
        r120.f130319i = this.f130343g;
        if (((ys1.a) com.bytedance.android.livesdk.gift.platform.business.b.f126560w.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.f126533a[21])).c() == false) goto L46;
        RxUtilKt.c(w.a("EVENT_WEB_SHOW", AnonymousClass4.INSTANCE), this.f130344h);
        RxUtilKt.c(w.a("EVENT_WEB_CLOSE", AnonymousClass5.INSTANCE), this.f130344h);
        return;
    L46:
        return;
    L21:
        r108 = 12.0f;
        goto L22
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public s02.d getOnGiftTrayIdleStateListener() {
        return this.f130348l;
    }

    public static final /* synthetic */ int p(MatchRoomGiftTrayAnimationView r100) {
        return r100.getGiftToHotMsgTrayMargin();
    }

    public static final /* synthetic */ int q(MatchRoomGiftTrayAnimationView r100) {
        return r100.getOriginalTopMargin();
    }

    public static final void r(MatchRoomGiftTrayAnimationView r100) {
        if (r100.f130345i != null) goto L9;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L8;
        r100.f130345i = (ViewGroup.MarginLayoutParams) r101;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ViewGroup.MarginLayoutParams r102 = r100.f130345i;
        if (r102 == null) goto L19;
        int r103 = r100.getGatherHeight();
        if (r103 > 0) goto L16;
        r103 = r100.getOriginalTopMargin();
    L16:
        if (r102.topMargin == r103) goto L20;
        r102.topMargin = r103;
        r100.setLayoutParams(r102);
        return;
    L20:
        return;
    }

    private final void setAnchor(boolean r100) {
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L6;
        r101.getMessageDispatcher().getValue().getClass();
        return;
    }

    private final void setMAnchor(IBaseUser r100) {
        this.f130347k = r100;
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L6;
        r101.getMessageDispatcher().getValue().f130374a = r100;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    public final boolean Lc(NormalGiftMessage r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L18;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a r102 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e;
        r102.f132072b.d(Long.valueOf(r100.f129771a), "onConsumeMessage");
        r101.append("audioGiftTray;");
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L9;
        if (b02.a.b(r100) == true) goto L9;
    L13:
        r02.b r103 = this.f130349m;
        if (r103.f535423b == false) goto L17;
        r103.c();
        GiftTrayMessageManager r104 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager.a.a().i(r100, false);
        GiftTrayMessageManager.a.a().f130317g = r100;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r100);
        this.f130349m.f(r100);
        return true;
    L17:
        r101.append("mTop idle false ");
        r102.f132072b.d(Long.valueOf(r100.f129771a), r100.f129772b + " not consume this time");
    L9:
        if (this.f130349m.i(r100) == false) goto L12;
        GiftTrayMessageManager r105 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager.a.a().i(r100, false);
        GiftTrayMessageManager.a.a().f130317g = r100;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r100);
        return true;
    L12:
        r101.append("mTop continue false;");
    L18:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130341e, "Consume failed " + r100 + ' ' + r101);
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void l(boolean r100) {
        if (getChildCount() > 0) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        BaseGiftTrayAnimationView.n(this, 0, false, 2);
        return;
    L8:
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setOnGiftTrayIdleStateListener(s02.d r100) {
        this.f130348l = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setPortrait(boolean r100) {
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L6;
        r101.getMessageDispatcher().getValue().getClass();
        return;
    }

    public static final void o(MatchRoomGiftTrayAnimationView r100, int r101) {
        if (r100.f130345i != null) goto L9;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L8;
        r100.f130345i = (ViewGroup.MarginLayoutParams) r102;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ViewGroup.MarginLayoutParams r103 = r100.f130345i;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.topMargin == r101) goto L23;
        ValueAnimator r104 = r100.f130346j;
        if (r104 == null) goto L17;
        r104.removeAllUpdateListeners();
    L17:
        ValueAnimator r105 = r100.f130346j;
        if (r105 == null) goto L20;
        r105.cancel();
    L20:
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{r103.topMargin, r101});
        r106.setDuration(100);
        r106.addUpdateListener(new h(r100));
        r106.start();
        Unit r107 = Unit.INSTANCE;
        r100.f130346j = r106;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void k(GiftTrayWidget.c r100, GiftTrayWidget.b r101) {
        Intrinsics.checkNotNullParameter(r100, "topListener");
        Intrinsics.checkNotNullParameter(r101, "bottomListener");
        this.f130343g = r100;
        this.f130349m.f535432k = r100;
        GiftTrayMessageManager r102 = GiftTrayMessageManager.f130310r;
        GiftTrayMessageManager.a.a().f130319i = r100;
    }

    public MatchRoomGiftTrayAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f130341e = "MatchRoomGiftTrayAnimationView";
        this.f130342f = n12.e.a();
        this.f130344h = new CompositeDisposable();
        r02.b r103 = new r02.b(r100, this, 2);
        this.f130349m = r103;
        a r104 = new a(this);
        this.f130350n = r104;
        r103.f535431j = r104;
    }

    public /* synthetic */ MatchRoomGiftTrayAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void j(int r100, boolean r101, boolean r102, User r103) {
        r02.b r104 = this.f130349m;
        r104.f535433l = r100;
        r104.f535439r = r101;
        r104.f535441t = r102;
        r104.j(r104.f535430i);
        setMAnchor(r103);
    }
}
