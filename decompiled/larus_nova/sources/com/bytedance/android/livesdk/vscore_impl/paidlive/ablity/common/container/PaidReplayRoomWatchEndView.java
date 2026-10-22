package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.container;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.m;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.i;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.l;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.r;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.s;
import com.bytedance.android.livesdk.vscore_impl.paidlive.f;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nm1.e;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0013\u001a\u00020\u000e8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010 \u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001d\u0010&\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001d\u0010)\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010-R\"\u00105\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u0002068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\u0017\u0010G\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010O\u001a\u0004\u0018\u00010L8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/paidlive/ablity/common/container/PaidReplayRoomWatchEndView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/l;", "Landroid/view/View$OnTouchListener;", "Landroid/graphics/Rect;", "getBtnRect", "", "getLayoutId", "Landroid/view/View;", "getView", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/s;", "uiInfo", "", "setUIInfo", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getLogT", "()Ljava/lang/String;", "logT", "Landroid/widget/TextView;", "b", "Lkotlin/Lazy;", "getMTitle", "()Landroid/widget/TextView;", "mTitle", "c", "getMSubTitle", "mSubTitle", "d", "getMBuyBtn", "()Landroid/view/View;", "mBuyBtn", "e", "getMBuyBtnText", "mBuyBtnText", "f", "getMDeliveryBtn", "mDeliveryBtn", ce.f26391f, "getMPriceView", "mPriceView", "Lcom/bytedance/android/livesdk/chatroom/view/BlurImageView;", "h", "getMMask", "()Lcom/bytedance/android/livesdk/chatroom/view/BlurImageView;", "mMask", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/s;", "getTempWatchEndViewUiInfo", "()Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/s;", "setTempWatchEndViewUiInfo", "(Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/s;)V", "tempWatchEndViewUiInfo", "", ce.f26395j, "Z", "getHasRender", "()Z", "setHasRender", "(Z)V", "hasRender", "l", "getHasInitRootView", "setHasInitRootView", "hasInitRootView", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/scope/a;", "q", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/scope/a;", "getScope", "()Lcom/bytedance/android/livesdk/vscore_api/paidlive/scope/a;", "scope", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/ss/android/videoshop/context/VideoContext;", "getVideoContext", "()Lcom/ss/android/videoshop/context/VideoContext;", "videoContext", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PaidReplayRoomWatchEndView extends ConstraintLayout implements l, View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f160148r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f160150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f160151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f160152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f160153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f160154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f160155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f160156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f160157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f160158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f160159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f160160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f160161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f160162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f160163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f160164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160165q;

    public static final class a implements cjc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayRoomWatchEndView f160166a;

        public a(PaidReplayRoomWatchEndView r100) {
            this.f160166a = r100;
        }

        @Override // cjc.d
        public final void a(Bitmap r100) {
            if (r100 == null) goto L4;
            PaidReplayRoomWatchEndView r101 = this.f160166a;
            int r102 = PaidReplayRoomWatchEndView.f160148r;
            r101.U5(r100, 0);
        L4:
            VideoContext r103 = PaidReplayRoomWatchEndView.S5(this.f160166a);
            if (r103 != null) goto L7;
        L8:
            VideoContext r104 = PaidReplayRoomWatchEndView.S5(this.f160166a);
            if (r104 == null) goto L13;
            r104.pause();
            return;
        L13:
            return;
        L7:
            if (r103.isPlaying() == true) goto L8;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayRoomWatchEndView f160167a;

        public b(PaidReplayRoomWatchEndView r100) {
            this.f160167a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (v.a() == false) goto L8;
            ILiveSdkProjectModeService r102 = (ILiveSdkProjectModeService) k.f(ILiveSdkProjectModeService.class);
            if (r102 == null) goto L9;
            r102.openPaidLiveDebugWindow(this.f160167a.getScope());
            return;
        L9:
            return;
        }
    }

    public static final class c extends br1.a {
        @Override // br1.a
        public final int a() {
            return 10;
        }

        public c(View.OnTouchListener r100) {
            super(r100);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidReplayRoomWatchEndView f160168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f160169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f160170c;

        public d(PaidReplayRoomWatchEndView r100, Bitmap r101, Integer r102) {
            this.f160168a = r100;
            this.f160169b = r101;
            this.f160170c = r102;
        }

        public final void a() {
            this.f160168a.T5("blur size: width " + this.f160168a.getWidth() + ", height " + this.f160168a.getHeight());
            BlurImageView r100 = PaidReplayRoomWatchEndView.R5(this.f160168a);
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.getWidth();
        L7:
            if (r102 <= 0) goto L17;
            BlurImageView r103 = PaidReplayRoomWatchEndView.R5(this.f160168a);
            if (r103 == null) goto L11;
            int r104 = r103.getHeight();
        L12:
            if (r104 <= 0) goto L17;
            BlurImageView r105 = PaidReplayRoomWatchEndView.R5(this.f160168a);
            if (r105 == null) goto L16;
            r105.setBackground(this.f160169b);
        L16:
            this.f160168a.f160159k = true;
            return;
        L11:
            r104 = 0;
        L17:
            Integer r106 = this.f160170c;
            if (r106 == null) goto L20;
            int r107 = r106.intValue();
        L22:
            if (r107 < 3) goto L24;
            return;
        L24:
            BlurImageView r108 = PaidReplayRoomWatchEndView.R5(this.f160168a);
            if (r108 == null) goto L27;
            r108.requestLayout();
        L27:
            PaidReplayRoomWatchEndView r109 = this.f160168a;
            Bitmap r110 = this.f160169b;
            Integer r111 = this.f160170c;
            if (r111 == null) goto L30;
            r101 = r111.intValue();
        L30:
            r109.U5(r110, Integer.valueOf(r101 + 1));
            return;
        L20:
            r107 = 0;
            goto L22
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

    private final View getMBuyBtn() {
        return (View) this.f160152d.getValue();
    }

    private final TextView getMBuyBtnText() {
        return (TextView) this.f160153e.getValue();
    }

    private final TextView getMDeliveryBtn() {
        return (TextView) this.f160154f.getValue();
    }

    private final BlurImageView getMMask() {
        return (BlurImageView) this.f160156h.getValue();
    }

    private final TextView getMPriceView() {
        return (TextView) this.f160155g.getValue();
    }

    private final TextView getMSubTitle() {
        return (TextView) this.f160151c.getValue();
    }

    private final TextView getMTitle() {
        return (TextView) this.f160150b.getValue();
    }

    public int getLayoutId() {
        return R.layout.ttlive_paid_replay_temp_end_view;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void logTempMaskShow() {
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
    public final void z2() {
    }

    private final Rect getBtnRect() {
        View r100 = this.f160161m;
        if (r100 == null) goto L5;
        int[] r101 = new int[2];
        if (r100 == null) goto L9;
        r100.getLocationOnScreen(r101);
    L9:
        int r102 = 0;
        int r103 = r101[0];
        int r104 = r101[1];
        View r105 = this.f160161m;
        if (r105 == null) goto L12;
        int r106 = r105.getWidth();
    L13:
        int r107 = r106 + r103;
        int r108 = r101[1];
        View r109 = this.f160161m;
        if (r109 == null) goto L17;
        r102 = r109.getHeight();
    L17:
        return new Rect(r103, r104, r107, r108 + r102);
    L12:
        r106 = 0;
        goto L13
    L5:
        return new Rect();
    }

    private final DataCenter getDataCenter() {
        return this.f160165q.D().getDataCenter();
    }

    private final VideoContext getVideoContext() {
        return this.f160165q.D().d();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void dc() {
        T5("onRemoveFromPlayerContainer  type : " + this.f160157i.f159427a);
        PaidSceneEnum r100 = this.f160165q.i0();
        int r101 = this.f160157i.f159427a;
        r r102 = new r(r100, false, null);
        this.f160158j = false;
        this.f160159k = false;
        this.f160165q.l().getPaidTempWatchEndViewState().setValue(r102);
        BlurImageView r103 = getMMask();
        if (r103 == null) goto L5;
        r103.setBackground(null);
    L5:
        TextView r104 = getMSubTitle();
        if (r104 == null) goto L8;
        r104.setVisibility(8);
    L8:
        UtilityKotlinExtentionsKt.t(this);
        SparseArray<br1.b> r105 = br1.b.f20120d;
        br1.b r106 = br1.b.a.a(getDataCenter());
        c r107 = this.f160164p;
        Intrinsics.checkNotNullParameter(r107, "listener");
        ((ArrayList) r106.f20122b).remove(r107);
        VideoContext r108 = getVideoContext();
        if (r108 != null) goto L11;
    L12:
        VideoContext r109 = getVideoContext();
        if (r109 == null) goto L17;
        r109.play();
        return;
    L17:
        return;
    L11:
        if (r108.isPlaying() != true) goto L12;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public View getView() {
        if (this.f160160l == false) goto L14;
    L13:
        return this;
    L14:
        LayoutInflater.from(this.f160165q.D().b()).inflate(getLayoutId(), this);     // Catch: Exception -> L6 Resources.NotFoundException -> L8
    L9:
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        r100.gravity = 1;
        Unit r101 = Unit.INSTANCE;
        setLayoutParams(r100);
        setVisibility(8);
        TextView r102 = getMSubTitle();
        if (r102 == null) goto L12;
        r102.setVisibility(8);
    L12:
        this.f160160l = true;
        T5("init root view complete");
        goto L13
    L8:
        LayoutInflater.from(jc1.a.b()).inflate(getLayoutId(), this);
    L6:
        e = move-exception;
        SafetyGuard.c("PaidRoomTempWatchEndView_load_error", e, null);
        goto L9
    }

    public final boolean getHasInitRootView() {
        return this.f160160l;
    }

    public final boolean getHasRender() {
        return this.f160158j;
    }

    public String getLogT() {
        return this.f160149a;
    }

    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a getScope() {
        return this.f160165q;
    }

    public final s getTempWatchEndViewUiInfo() {
        return this.f160157i;
    }

    public PaidReplayRoomWatchEndView(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100.D().b());
        this.f160165q = r100;
        this.f160149a = "PaidReplayRoomWatchEndView[" + hashCode() + ']';
        this.f160150b = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mTitle$2(this));
        this.f160151c = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mSubTitle$2(this));
        this.f160152d = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mBuyBtn$2(this));
        this.f160153e = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mBuyBtnText$2(this));
        this.f160154f = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mDeliveryBtn$2(this));
        this.f160155g = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mPriceView$2(this));
        this.f160156h = InfraKotlinExtsKt.mainThreadLazy(new PaidReplayRoomWatchEndView$mMask$2(this));
        this.f160157i = new s();
        this.f160164p = new c(this);
    }

    public static final /* synthetic */ BlurImageView R5(PaidReplayRoomWatchEndView r100) {
        return r100.getMMask();
    }

    public static final /* synthetic */ VideoContext S5(PaidReplayRoomWatchEndView r100) {
        return r100.getVideoContext();
    }

    public final void T5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.d(getLogT(), r100);
    }

    public final void setHasInitRootView(boolean r100) {
        this.f160160l = r100;
    }

    public final void setHasRender(boolean r100) {
        this.f160158j = r100;
    }

    public final void setTempWatchEndViewUiInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f160157i = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void setUIInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "uiInfo");
        if ((!Intrinsics.areEqual(this.f160157i, r100)) == false) goto L5;
        this.f160158j = false;
        T5("setUIInfo differrent ,set hasRender = false");
    L5:
        this.f160157i = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void Kb(IRenderView r100, boolean r101) {
        if (this.f160158j == false) goto L10;
        if (getVisibility() == 0) goto L7;
        setVisibility(0);
    L7:
        T5("render has rendered, skip");
        return;
    L10:
        if (this.f160159k == true) goto L16;
        VideoContext r102 = getVideoContext();
        if (r102 == null) goto L16;
        SimpleMediaView r103 = r102.f455950d;
        if (r103 == null) goto L16;
        r103.d(new a(this));
    L16:
        SparseArray<br1.b> r104 = br1.b.f20120d;
        br1.b r105 = br1.b.a.a(getDataCenter());
        c r106 = this.f160164p;
        Intrinsics.checkNotNullParameter(r106, "listener");
        LocalTestManager.a(new Class[]{wy.a.class});
        ((ArrayList) r105.f20122b).add(r106);
        CollectionsKt.sortWith(r105.f20122b, r105.f20123c);
        UtilityKotlinExtentionsKt.w(this);
        TextView r107 = getMTitle();
        if (r107 == null) goto L19;
        r107.setText(this.f160157i.f159431e);
    L19:
        SettingKey<Boolean> r108 = VSSettingKeys.LIVE_PAID_WEAKEN_ENABLE;
        Boolean r109 = r108.getValue();
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r109, r110) == true) goto L22;
    L26:
        TextView r111 = getMSubTitle();
        if (r111 == null) goto L29;
        r111.setText(this.f160157i.f159432f);
    L29:
        TextView r112 = getMSubTitle();
        if (r112 == null) goto L33;
        UtilityKotlinExtentionsKt.z(r112, this.f160157i.f159433g);
    L33:
        if (this.f160157i.f159435i == true) goto L35;
        View r113 = getMBuyBtn();
        if (r113 == null) goto L57;
        UtilityKotlinExtentionsKt.t(r113);
    L57:
        TextView r114 = getMDeliveryBtn();
        if (r114 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r114);
    L60:
        this.f160161m = getMDeliveryBtn();
        this.f160162n = this.f160157i.f159437k;
    L61:
        i r115 = f.h(this.f160165q);
        if (r115 == null) goto L64;
        r115.Jo();
    L64:
        T5("onAddedToPlayerContainer, render complete");
        this.f160158j = true;
        return;
    L35:
        if (Intrinsics.areEqual(r108.getValue(), r110) == true) goto L37;
    L41:
        TextView r116 = getMBuyBtnText();
        if (r116 == null) goto L44;
        r116.setText(this.f160157i.f159434h);
    L44:
        View r117 = getMBuyBtn();
        if (r117 == null) goto L47;
        UtilityKotlinExtentionsKt.w(r117);
    L47:
        TextView r118 = getMDeliveryBtn();
        if (r118 == null) goto L50;
        UtilityKotlinExtentionsKt.t(r118);
    L50:
        TextView r119 = getMPriceView();
        if (r119 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r119);
    L53:
        this.f160161m = getMBuyBtn();
        this.f160162n = new PaidReplayRoomWatchEndView$onAddedToPlayerContainer$2(this);
        goto L61
    L37:
        if (this.f160165q.i0().getPaidLiveTypeInt() == PaidSceneEnum.SUBSCRIBE_ROOM.getPaidLiveTypeInt()) goto L41;
        TextView r120 = getMBuyBtnText();
        if (r120 == null) goto L44;
        r120.setText("解锁继续看");
        goto L44
    L22:
        if (this.f160165q.i0().getPaidLiveTypeInt() == PaidSceneEnum.SUBSCRIBE_ROOM.getPaidLiveTypeInt()) goto L26;
        TextView r121 = getMSubTitle();
        if (r121 == null) goto L29;
        r121.setText("解锁后可观看整场回放");
        goto L29
    }

    public final void U5(Bitmap r100, Integer r101) {
        BlurImageView r102 = getMMask();
        if (r102 == null) goto L6;
        r102.post(new d(this, r100, r101));
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (getVisibility() == 0) goto L5;
        return false;
    L5:
        int[] r102 = new int[2];
        if (r100 == null) goto L8;
        r100.getLocationOnScreen(r102);
    L8:
        float r103 = -1.0f;
        if (r101 == null) goto L11;
        float r104 = r101.getX();
    L12:
        float r105 = r104 + r102[0];
        if (r101 == null) goto L15;
        r103 = r101.getY();
    L15:
        float r106 = r103 + r102[1];
        float r107 = 0;
        if (r105 >= r107) goto L18;
    L57:
        return false;
    L18:
        if (r106 < r107) goto L57;
        Rect r108 = getBtnRect();
        float r109 = r108.left;
        float r110 = r108.right;
        if (r105 < r109) goto L36;
        if (r105 > r110) goto L36;
        float r111 = r108.top;
        float r112 = r108.bottom;
        if (r106 < r111) goto L36;
        if (r106 > r112) goto L36;
        if (r101 != null) goto L30;
    L34:
        return true;
    L30:
        if (r101.getAction() != 1) goto L34;
        Function0<Unit> r113 = this.f160162n;
        if (r113 == null) goto L34;
        Unit r114 = r113.invoke();
    L36:
        if (v.a() == false) goto L57;
        if (r101 == null) goto L39;
        Integer r115 = Integer.valueOf(r101.getAction());
    L40:
        if (r115 != null) goto L43;
    L45:
        if (r115 != null) goto L48;
    L50:
        if (r115 == null) goto L57;
        if (r115.intValue() != 3) goto L57;
    L54:
        Disposable r116 = this.f160163o;
        if (r116 == null) goto L57;
        r116.dispose();
        goto L57
    L48:
        if (r115.intValue() != 1) goto L50;
    L43:
        if (r115.intValue() != 0) goto L45;
        this.f160163o = Observable.timer(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        goto L57
    L39:
        r115 = null;
        goto L40
    L11:
        r104 = -1.0f;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void n1(int r100, int r101, int r102) {
        e r103 = pm1.f.c();
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L9;
        ReplayDataContext r105 = r103.h(getDataCenter());
        if (r105 == null) goto L9;
        n<ViewGroup.LayoutParams> r106 = r105.getVideoContainerPositionInfo();
        if (r106 == null) goto L9;
        ViewGroup.LayoutParams r107 = r106.getValue();
    L10:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r108 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((m) ReplayRoomFragmentScopeUtil.a(m.class)).l() == false) goto L35;
        int r109 = -1;
        if (r107 == null) goto L15;
        int r110 = r107.width;
    L16:
        if (r107 == null) goto L18;
        r109 = r107.height;
    L18:
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r110, r109);
        boolean r112 = r107 instanceof ViewGroup.MarginLayoutParams;
        if (r112 == true) goto L21;
        ViewGroup.LayoutParams r113 = null;
    L22:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L25;
        int r115 = r114.topMargin;
    L26:
        r111.topMargin = r115;
        if (r112 == false) goto L30;
        r104 = r107;
    L30:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r104;
        if (r116 == null) goto L33;
        int r117 = r116.bottomMargin;
    L34:
        r111.bottomMargin = r117;
        r111.gravity = 0;
        Unit r118 = Unit.INSTANCE;
    L36:
        setLayoutParams(r111);
        return;
    L33:
        r117 = 0;
        goto L34
    L25:
        r115 = 0;
        goto L26
    L21:
        r113 = r107;
        goto L22
    L15:
        r110 = -1;
        goto L16
    L35:
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(r100, r101);
        r119.topMargin = r102;
        r119.gravity = 1;
        Unit r120 = Unit.INSTANCE;
        r111 = r119;
    L9:
        r107 = null;
        goto L10
    }
}
