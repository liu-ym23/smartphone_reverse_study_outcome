package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.y1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.r2;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.i;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.l;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.r;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.s;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.live.datacontext.m;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class PaidRoomTempWatchEndView extends FrameLayout implements l {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f160047r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f160049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f160050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f160051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f160052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f160053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f160054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f160055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f160056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f160057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f160058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f160059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f160060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f160061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f160062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f160063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160064q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidRoomTempWatchEndView f160068a;

        public b(PaidRoomTempWatchEndView r100) {
            this.f160068a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f160068a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f160069a;

        public c(Function0 r100) {
            this.f160069a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f160069a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidRoomTempWatchEndView f160070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f160071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f160072c;

        public d(PaidRoomTempWatchEndView r100, Bitmap r101, Integer r102) {
            this.f160070a = r100;
            this.f160071b = r101;
            this.f160072c = r102;
        }

        public final void a() {
            this.f160070a.h("blur size: width " + this.f160070a.getWidth() + ", height " + this.f160070a.getHeight());
            BlurImageView r100 = PaidRoomTempWatchEndView.d(this.f160070a);
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.getWidth();
        L7:
            if (r102 <= 0) goto L20;
            BlurImageView r103 = PaidRoomTempWatchEndView.d(this.f160070a);
            if (r103 == null) goto L11;
            int r104 = r103.getHeight();
        L12:
            if (r104 <= 0) goto L20;
            HSImageView r105 = PaidRoomTempWatchEndView.f(this.f160070a);
            if (r105 == null) goto L16;
            UtilityKotlinExtentionsKt.w(r105);
        L16:
            BlurImageView r106 = PaidRoomTempWatchEndView.d(this.f160070a);
            if (r106 == null) goto L19;
            r106.setBackground(this.f160071b);
        L19:
            this.f160070a.f160058k = true;
            return;
        L11:
            r104 = 0;
        L20:
            Integer r107 = this.f160072c;
            if (r107 == null) goto L23;
            int r108 = r107.intValue();
        L25:
            if (r108 < 3) goto L27;
            return;
        L27:
            BlurImageView r109 = PaidRoomTempWatchEndView.d(this.f160070a);
            if (r109 == null) goto L30;
            r109.requestLayout();
        L30:
            PaidRoomTempWatchEndView r110 = this.f160070a;
            Bitmap r111 = this.f160071b;
            Integer r112 = this.f160072c;
            if (r112 == null) goto L33;
            r101 = r112.intValue();
        L33:
            r110.k(r111, Integer.valueOf(r101 + 1));
            return;
        L23:
            r108 = 0;
            goto L25
        L5:
            r102 = 0;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    private final ValueAnimator getAlphaAnimator() {
        return (ValueAnimator) this.f160061n.getValue();
    }

    private final r2 getConfig() {
        return (r2) this.f160060m.getValue();
    }

    private final View getMFlPaidLiveWatchEndTipContainer() {
        return (View) this.f160049b.getValue();
    }

    private final BlurImageView getMIvPayPerformWatchEndBlurStream() {
        return (BlurImageView) this.f160051d.getValue();
    }

    private final HSImageView getMIvPayPerformWatchEndBlurStream2() {
        return (HSImageView) this.f160052e.getValue();
    }

    private final View getMLlPaidLiveWatchEndTip() {
        return (View) this.f160050c.getValue();
    }

    private final TextView getMTvPayPerformWatchEndDesc() {
        return (TextView) this.f160054g.getValue();
    }

    private final TextView getMTvPayPerformWatchEndTitle() {
        return (TextView) this.f160053f.getValue();
    }

    public int getLayoutId() {
        return R.layout.ttlive_view_paid_room_temp_end;
    }

    public final TextView getMBtPaidLiveGoBuyTicket() {
        return (TextView) this.f160055h.getValue();
    }

    public final void i() {
        int[] r100 = new int[2];
        TextView r101 = getMBtPaidLiveGoBuyTicket();
        if (r101 == null) goto L5;
        r101.getLocationOnScreen(r100);
    L5:
        int r102 = 0;
        int r103 = r100[0];
        int r104 = r100[1];
        TextView r105 = getMBtPaidLiveGoBuyTicket();
        if (r105 == null) goto L8;
        int r106 = r105.getWidth();
    L9:
        int r107 = r106 + r103;
        int r108 = r100[1];
        TextView r109 = getMBtPaidLiveGoBuyTicket();
        if (r109 == null) goto L12;
        r102 = r109.getHeight();
    L12:
        Rect r110 = new Rect(r103, r104, r107, r108 + r102);
        PaidSceneEnum r111 = this.f160064q.i0();
        int r112 = this.f160056i.f159427a;
        this.f160064q.l().getPaidTempWatchEndViewState().setValue(new r(r111, true, r110));
        h("notifyLayerShowed  type : " + this.f160056i.f159427a + " , btn Rect : " + r110);
        return;
    L8:
        r106 = 0;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void logTempMaskShow() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void onEnter() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void z2() {
    }

    private final ILivePlayerClient getClient() {
        return this.f160064q.D().a().invoke();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void dc() {
        PaidSceneEnum r100 = this.f160064q.i0();
        int r101 = this.f160056i.f159427a;
        r r102 = new r(r100, false, null);
        this.f160059l = false;
        this.f160058k = false;
        this.f160064q.l().getPaidTempWatchEndViewState().setValue(r102);
        if (this.f160064q.l().getMTempWatchEndTime().getValue().longValue() <= 0) goto L5;
        m<Long> r103 = this.f160064q.l().getTempWatchMaskShowDuration();
        r103.setValue(Long.valueOf(r103.getValue().longValue() + (System.currentTimeMillis() - this.f160064q.l().getMTempWatchEndTime().getValue().longValue())));
        this.f160064q.l().getMTempWatchEndTime().setValue(-1L);
    L5:
        h("notifyLayerHide  type : " + this.f160056i.f159427a);
    }

    public final void g() {
        LayoutInflater.from(this.f160064q.D().b()).inflate(getLayoutId(), this);     // Catch: Exception -> L4 Resources.NotFoundException -> L6
    L7:
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        r100.gravity = 1;
        Unit r101 = Unit.INSTANCE;
        setLayoutParams(r100);
        setVisibility(8);
        setAlpha(0.0f);
        this.f160062o = true;
        h("init root view complete");
        return;
    L6:
        LayoutInflater.from(jc1.a.b()).inflate(getLayoutId(), this);
    L4:
        e = move-exception;
        SafetyGuard.c("PaidRoomTempWatchEndView_load_error", e, null);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public View getView() {
        if (this.f160062o == true) goto L5;
        g();
    L5:
        return this;
    }

    public final void j() {
        if (getVisibility() == 0) goto L6;
        return;
    L6:
        if (getGlobalVisibleRect(new Rect()) == false) goto L8;
        String r100 = "true";
    L10:
        if (this.f160056i.f159427a != 1) goto L12;
        String r101 = "temp_end_mask";
    L13:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_audience_mask_view_visible_check", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("mask_view_visibility", r100), TuplesKt.to("mask_type", r101)}), null, this.f160064q.w0().name(), this.f160064q.i0().name(), 4, null);
        postDelayed(new c(new PaidRoomTempWatchEndView$postAction$1(this)), this.f160063p);
        this.f160063p *= (long) 2;
        return;
    L12:
        r101 = "delivery_tips_mask";
        goto L13
    L8:
        r100 = "false";
        goto L10
    }

    public final boolean getHasInitRootView() {
        return this.f160062o;
    }

    public final boolean getHasRender() {
        return this.f160059l;
    }

    public String getLogT() {
        return this.f160048a;
    }

    public final boolean getNeedAlphaAnimation() {
        return this.f160057j;
    }

    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a getScope() {
        return this.f160064q;
    }

    public final s getTempWatchEndViewUiInfo() {
        return this.f160056i;
    }

    public PaidRoomTempWatchEndView(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100.D().b());
        this.f160064q = r100;
        this.f160048a = "PaidRoomTempWatchEndView[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f160049b = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mFlPaidLiveWatchEndTipContainer$2(this));
        this.f160050c = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mLlPaidLiveWatchEndTip$2(this));
        this.f160051d = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mIvPayPerformWatchEndBlurStream$2(this));
        this.f160052e = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mIvPayPerformWatchEndBlurStream2$2(this));
        this.f160053f = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mTvPayPerformWatchEndTitle$2(this));
        this.f160054g = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mTvPayPerformWatchEndDesc$2(this));
        this.f160055h = InfraKotlinExtsKt.mainThreadLazy(new PaidRoomTempWatchEndView$mBtPaidLiveGoBuyTicket$2(this));
        this.f160056i = new s();
        this.f160057j = true;
        this.f160060m = LazyKt.lazy(PaidRoomTempWatchEndView$config$2.INSTANCE);
        this.f160061n = LazyKt.lazy(new PaidRoomTempWatchEndView$alphaAnimator$2(this));
        this.f160063p = 10000;
        this.f160062o = false;
    }

    public static final /* synthetic */ r2 a(PaidRoomTempWatchEndView r100) {
        return r100.getConfig();
    }

    public static final /* synthetic */ View c(PaidRoomTempWatchEndView r100) {
        return r100.getMFlPaidLiveWatchEndTipContainer();
    }

    public static final /* synthetic */ BlurImageView d(PaidRoomTempWatchEndView r100) {
        return r100.getMIvPayPerformWatchEndBlurStream();
    }

    public static final /* synthetic */ HSImageView f(PaidRoomTempWatchEndView r100) {
        return r100.getMIvPayPerformWatchEndBlurStream2();
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.d(getLogT(), r100);
    }

    public final void setHasInitRootView(boolean r100) {
        this.f160062o = r100;
    }

    public final void setHasRender(boolean r100) {
        this.f160059l = r100;
    }

    public final void setNeedAlphaAnimation(boolean r100) {
        this.f160057j = r100;
    }

    public final void setTempWatchEndViewUiInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f160056i = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void setUIInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "uiInfo");
        if ((!Intrinsics.areEqual(this.f160056i, r100)) == false) goto L5;
        this.f160059l = false;
        h("setUIInfo differrent ,set hasRedner = false");
    L5:
        this.f160056i = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void Kb(IRenderView r110, boolean r111) {
        if (this.f160059l == true) goto L5;
        setVisibility(0);
        TextView r100 = getMTvPayPerformWatchEndTitle();
        String r101 = "";
        if (r100 == null) goto L17;
        String r102 = this.f160056i.f159431e;
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        r100.setText(r102);
    L17:
        if (Intrinsics.areEqual(VSSettingKeys.LIVE_PAID_WEAKEN_ENABLE.getValue(), Boolean.TRUE) == true) goto L19;
    L26:
        TextView r103 = getMTvPayPerformWatchEndDesc();
        if (r103 == null) goto L33;
        String r104 = this.f160056i.f159432f;
        if (r104 != null) goto L32;
        r104 = "";
    L32:
        r103.setText(r104);
    L33:
        TextView r105 = getMBtPaidLiveGoBuyTicket();
        if (r105 == null) goto L39;
        String r106 = this.f160056i.f159434h;
        if (r106 == null) goto L38;
        r101 = r106;
    L38:
        r105.setText(r101);
    L39:
        TextView r107 = getMBtPaidLiveGoBuyTicket();
        if (r107 == null) goto L42;
        UtilityKotlinExtentionsKt.z(r107, this.f160056i.f159435i);
    L42:
        if (r111 == false) goto L44;
        getAlphaAnimator().start();
    L48:
        if (r110 == null) goto L72;
        com.bytedance.android.livesdk.vscore_api.paidlive.d r108 = this.f160064q.D().getRoomContext();
        if (r108 == null) goto L52;
        ILiveMode r109 = r108.getLiveMode();
    L54:
        if (r109 == LiveMode.AUDIO) goto L72;
        Intrinsics.checkNotNullParameter(r110, "renderView");
        if (this.f160058k == true) goto L79;
        if ((r110 instanceof SurfaceRenderView) == true) goto L61;
    L63:
        Bitmap r112 = r110.getBitmap();
    L64:
        if (r112 == null) goto L66;
        k(r112, 0);
        goto L79
    L66:
        BlurImageView r113 = getMIvPayPerformWatchEndBlurStream();
        if (r113 == null) goto L69;
        r113.setBackgroundColor(s1.h(R.color.black));
    L69:
        HSImageView r114 = getMIvPayPerformWatchEndBlurStream2();
        if (r114 == null) goto L79;
        UtilityKotlinExtentionsKt.t(r114);
        goto L79
    L61:
        if (Build.VERSION.SDK_INT < 24) goto L63;
        r112 = y1.a(r110, getClient());
    L79:
        if (this.f160064q.l().getMTempWatchEndTime().getValue().longValue() <= 0) goto L81;
        m<Long> r115 = this.f160064q.l().getTempWatchMaskShowDuration();
        r115.setValue(Long.valueOf(r115.getValue().longValue() + (System.currentTimeMillis() - this.f160064q.l().getMTempWatchEndTime().getValue().longValue())));
    L81:
        this.f160064q.l().getMTempWatchEndTime().setValue(Long.valueOf(System.currentTimeMillis()));
        i r116 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.h(this.f160064q);
        if (r116 == null) goto L85;
        r116.Jo();
    L85:
        if (this.f160056i.f159427a != 1) goto L87;
        String r117 = "temp_end_mask";
    L88:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_audience_mask_view_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("mask_type", r117)}), null, this.f160064q.w0().name(), this.f160064q.i0().name(), 4, null);
        this.f160063p = 10000;
        h("onAddedToPlayerContainer, render complete");
        this.f160059l = true;
        j();
        this.f160064q.l().getHasLogPreviewMaskDuration().setValue(Boolean.FALSE);
        return;
    L87:
        r117 = "delivery_tips_mask";
        goto L88
    L52:
        r109 = null;
    L72:
        BlurImageView r118 = getMIvPayPerformWatchEndBlurStream();
        if (r118 == null) goto L75;
        r118.setBackgroundColor(s1.h(R.color.black));
    L75:
        HSImageView r119 = getMIvPayPerformWatchEndBlurStream2();
        if (r119 == null) goto L79;
        UtilityKotlinExtentionsKt.t(r119);
        goto L79
    L44:
        setAlpha(1.0f);
        View r120 = getMFlPaidLiveWatchEndTipContainer();
        if (r120 == null) goto L48;
        r120.setVisibility(0);
        goto L48
    L19:
        if (this.f160064q.i0().getPaidLiveTypeInt() == PaidSceneEnum.SUBSCRIBE_ROOM.getPaidLiveTypeInt()) goto L26;
        TextView r121 = getMTvPayPerformWatchEndDesc();
        if (r121 == null) goto L23;
        r121.setText("解锁后可观看整场直播");
    L23:
        TextView r122 = getMBtPaidLiveGoBuyTicket();
        if (r122 == null) goto L39;
        r122.setText("解锁继续看");
        goto L39
    L5:
        if (getVisibility() == 0) goto L7;
        setVisibility(0);
    L7:
        h("render has rendered, skip");
    }

    public final void k(Bitmap r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        BlurImageView r102 = getMIvPayPerformWatchEndBlurStream();
        if (r102 == null) goto L6;
        r102.post(new d(this, r100, r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void n1(int r100, int r101, int r102) {
        int r103 = -1;
        if (r100 != 0) goto L5;
        r100 = -1;
    L5:
        int r104 = 0;
        if (r101 != 0) goto L9;
        r101 = -1;
        r102 = 0;
    L9:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f160064q.D().getDataCenter()).J0().h(this.f160064q.D().getDataCenter()) == false) goto L11;
        r101 = -1;
    L13:
        if (this.f160062o == true) goto L15;
        g();
    L15:
        h("adjustLayoutParams width : " + r103 + " , height : " + r101 + " , topMargin : " + r104);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(r103, r101);
        r105.topMargin = r104;
        r105.gravity = 1;
        Unit r106 = Unit.INSTANCE;
        setLayoutParams(r105);
        if (r103 >= r101) goto L18;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 1;
        r107.topMargin = s1.f(240.0f);
    L19:
        View r108 = getMLlPaidLiveWatchEndTip();
        if (r108 == null) goto L23;
        r108.setLayoutParams(r107);
    L23:
        if (getVisibility() != 0) goto L26;
        post(new b(this));
        return;
    L26:
        return;
    L18:
        r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 17;
        goto L19
    L11:
        r103 = r100;
        r104 = r102;
        goto L13
    }
}
