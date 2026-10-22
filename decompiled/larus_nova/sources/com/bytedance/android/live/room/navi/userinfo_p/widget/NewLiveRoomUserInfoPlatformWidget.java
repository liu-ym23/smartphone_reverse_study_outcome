package com.bytedance.android.live.room.navi.userinfo_p.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.navi.userinfo_p.utils.RoomUserInfoUtil;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.common.h;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.config.p7;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;
import zg1.x0;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\tJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/widget/NewLiveRoomUserInfoPlatformWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/common/i;", "Lzg1/n3;", "event", "", "onEvent", "Lzg1/x0;", "Lzg1/f;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewLiveRoomUserInfoPlatformWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData>, i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f100182h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserInfoElementManager f100183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f100184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f100185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f100186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f100187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f100188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f100189g;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLiveRoomUserInfoPlatformWidget f100190a;

        public b(NewLiveRoomUserInfoPlatformWidget r100) {
            this.f100190a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            if (r100 == null) goto L16;
            View r101 = this.f100190a.contentView;
            if (r101 == null) goto L12;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L12;
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L11;
            r102.width = ((Integer) r103).intValue();
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L12:
            View r104 = this.f100190a.contentView;
            if (r104 == null) goto L17;
            r104.requestLayout();
            return;
        L17:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLiveRoomUserInfoPlatformWidget f100191a;

        public c(NewLiveRoomUserInfoPlatformWidget r100) {
            this.f100191a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f100191a.contentView;
            if (r101 == null) goto L7;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L7;
            r102.width = -2;
        L7:
            View r103 = this.f100191a.contentView;
            if (r103 == null) goto L11;
            r103.requestLayout();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f100191a.contentView;
            if (r101 == null) goto L7;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L7;
            r102.width = -2;
        L7:
            View r103 = this.f100191a.contentView;
            if (r103 == null) goto L11;
            r103.requestLayout();
            return;
        }
    }

    public static final class d extends com.bytedance.android.live.core.tetris.task.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewLiveRoomUserInfoPlatformWidget f100192c;

        @Override // java.lang.Runnable
        public final void run() {
            NewLiveRoomUserInfoPlatformWidget r100 = this.f100192c;
            int r101 = NewLiveRoomUserInfoPlatformWidget.f100182h;
            r100.prepareViewOnLoad();
            b(true);
        }

        public d(NewLiveRoomUserInfoPlatformWidget r100) {
            this.f100192c = r100;
            super("live_room_user_info_widget");
        }
    }

    public static final class e<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLiveRoomUserInfoPlatformWidget f100193a;

        public e(NewLiveRoomUserInfoPlatformWidget r100) {
            this.f100193a = r100;
        }

        @Override // h80.a
        public final void accept(Object r100) {
            IRoom r101 = (IRoom) r100;
            UserInfoElementManager r102 = this.f100193a.f100183a;
            if (r102 == null) goto L6;
            r102.j(r101);
            return;
        }
    }

    public final class f implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f100194a;

        public f(Function1 r100) {
            this.f100194a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f100194a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ String Lg() {
        return h.b(this);
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ String cg() {
        return h.c(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a126";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final String nc() {
        return "LiveRoomUserInfoPlatformWidget";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ boolean nq() {
        return h.a();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final Animator startShowAnimation() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final int supportClearScene() {
        return 26;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        if (RoomUserInfoUtil.c(this.dataCenter) == false) goto L5;
        return R.layout.ttlive_module_live_room_user_info_broadcast_mvi;
    L5:
        return R.layout.ttlive_module_live_room_user_info_new_style_mvi;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f100185c.clear();
        this.f100184b = Boolean.FALSE;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        UserInfoElementManager r101 = this.f100183a;
        if (r101 == null) goto L8;
        r101.h();
    L8:
        ValueAnimator r102 = this.f100188f;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f100188f = null;
    }

    public final void prepareViewOnLoad() {
        if (g81.c.f480370a.getValue().booleanValue() == false) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r100 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(getComponentContext());
        if (r100 == null) goto L14;
        PropertyOwner r101 = r100.getLoadState();
        if (r101 == null) goto L14;
        Disposable r102 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r101, new C99571(this));
        if (r102 == null) goto L14;
        RxUtilKt.c(r102, this.f100189g);
    L14:
        runWithRoomEntered(new e(this));
        return;
    L11:
        UserInfoElementManager r103 = this.f100183a;
        if (r103 == null) goto L14;
        r103.i();
        goto L14
    }

    public NewLiveRoomUserInfoPlatformWidget() {
        this.f100184b = Boolean.FALSE;
        this.f100185c = new CompositeDisposable();
        this.f100189g = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        if (isInitialized() == true) goto L9;
        UserInfoElementManager r100 = this.f100183a;
        if (r100 == null) goto L7;
        r100.a();
    L7:
        this.f100183a = null;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        if (r3.l(this.context) == false) goto L6;
        r3.p(this.f100187e);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final View getContentView() {
        return this.contentView;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final Boolean uk() {
        return this.f100184b;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (isViewValid() == false) goto L26;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L31;
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        if (r103 == 294674590) goto L17;
        if (r103 == 1060055221) goto L14;
        return;
    L14:
        if (r102.equals("data_keyboard_status") == false) goto L28;
    L18:
        Boolean r104 = (Boolean) r101.getData();
        if (r104 == null) goto L30;
        ViewGroup r105 = this.containerView;
        if (r104.booleanValue() == false) goto L23;
        int r106 = 8;
    L24:
        UIUtils.setViewVisibility(r105, r106);
        return;
    L23:
        r106 = 0;
        goto L24
    L30:
        return;
    L28:
        return;
    L17:
        if (r102.equals("data_keyboard_status_douyin") == true) goto L18;
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onEnterClear(int r100) {
        View r101 = this.contentView;
        if (r101 != null) goto L5;
    L9:
        p7 r102 = com.bytedance.android.live.room.util.e.f100391a;
        if (r102.enable == true) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
        return;
    L17:
        View r104 = this.contentView;
        if (r104 != null) goto L20;
        return;
    L20:
        if (r100 == 2) goto L22;
        return;
    L22:
        if (2 == r104.getLayerType()) goto L27;
        this.contentView.setLayerType(2, null);
        ALogger.i(LiveRecyclableWidget.ALOG_TAG_WIDGET, "LiveRoomUserInfoWidget Set LAYER_TYPE_HARDWARE");
        return;
    L27:
        return;
    L12:
        if (r102.liveRoomUserInfoWidgetEnable == false) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100 != 8) goto L7;
    L8:
        r101.setVisibility(8);
        goto L9
    L7:
        if (r100 != 16) goto L9;
        goto L8
    }

    public final void onEvent(zg1.f r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.contentView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f100186d == null) goto L22;
        int r102 = r101.getWidth();
        ViewGroup r103 = this.f100186d;
        Intrinsics.checkNotNull(r103);
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r102, r102 - r103.getWidth()});
        this.f100188f = r104;
        if (r104 == null) goto L10;
        r104.setDuration(300);
    L10:
        ValueAnimator r105 = this.f100188f;
        if (r105 == null) goto L13;
        r105.addUpdateListener(new b(this));
    L13:
        ValueAnimator r106 = this.f100188f;
        if (r106 == null) goto L16;
        r106.addListener(new c(this));
    L16:
        ValueAnimator r107 = this.f100188f;
        if (r107 == null) goto L21;
        r107.start();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onExitClear(int r100) {
        View r101 = this.contentView;
        if (r101 != null) goto L5;
    L9:
        p7 r102 = com.bytedance.android.live.room.util.e.f100391a;
        if (r102.enable == true) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
        return;
    L17:
        View r104 = this.contentView;
        if (r104 != null) goto L20;
        return;
    L20:
        if (r100 == 2) goto L22;
        return;
    L22:
        if (2 != r104.getLayerType()) goto L27;
        this.contentView.setLayerType(0, null);
        ALogger.i(LiveRecyclableWidget.ALOG_TAG_WIDGET, "LiveRoomUserInfoWidget Set LAYER_TYPE_NONE");
        return;
    L27:
        return;
    L12:
        if (r102.liveRoomUserInfoWidgetEnable == false) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100 != 8) goto L7;
    L8:
        r101.setVisibility(0);
        goto L9
    L7:
        if (r100 != 16) goto L9;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        UserInfoElementManager r101 = new UserInfoElementManager(this);
        r101.f();
        Unit r102 = Unit.INSTANCE;
        this.f100183a = r101;
        View r103 = this.contentView;
        View r104 = null;
        if (r103 == null) goto L5;
        ViewGroup r105 = (ViewGroup) r103.findViewById(R.id.entrance_container);
    L6:
        this.f100186d = r105;
        View r106 = this.contentView;
        if (r106 == null) goto L9;
        HSImageView r107 = (HSImageView) r106.findViewById(R.id.head);
    L9:
        View r108 = this.contentView;
        if (r108 == null) goto L12;
        r104 = r108.findViewById(R.id.anchor_info_container);
    L12:
        this.f100187e = r104;
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        UserInfoElementManager r101 = this.f100183a;
        if (r101 == null) goto L5;
        r101.g();
    L5:
        this.dataCenter.observeForever("data_keyboard_status", this).observeForever("data_keyboard_status_douyin", this);
        boolean r102 = isScreenPortrait();
        int r103 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r102) == false) goto L12;
        o r104 = z51.a.h(this.dataCenter, 2);
        if (r104 == null) goto L12;
        m<x0> r105 = r104.G2();
        if (r105 == null) goto L12;
        onEvent(r105.getValue());
        ((ObservableSubscribeProxy) r105.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new f(new NewLiveRoomUserInfoPlatformWidget$initEvents$1$1(this)));
    L12:
        wq(zg1.f.class, new NewLiveRoomUserInfoPlatformWidget$initEvents$2(this));
        r r106 = z51.a.e(this.dataCenter);
        if (r106 == null) goto L18;
        if (r106.isInVrLandscape(this.dataCenter) != true) goto L18;
        wq(n3.class, new NewLiveRoomUserInfoPlatformWidget$initEvents$3(this));
    L18:
        if (f0.f65293a.getValue().booleanValue() == false) goto L24;
        final d r107 = new d(this);
        o r108 = z51.a.h(this.dataCenter, 2);
        if (r108 == null) goto L25;
        j<com.bytedance.android.livesdk.widget.schedule.c> r109 = r108.B2();
        if (r109 == null) goto L25;
        r109.c(new AnonymousClass1(this, r107));
    L25:
        ALogger.d("NewLiveRoomUserInfoPlatformWidget", "LiveRoomUserInfoPlatformWidget = " + System.currentTimeMillis());
        r r110 = z51.a.e(this.dataCenter);
        if (r110 != null) goto L28;
        return;
    L28:
        if (r110.isInVrLandscape(this.dataCenter) != true) goto L42;
        View r111 = this.contentView;
        if (r111 == null) goto L43;
        o r112 = z51.a.h(this.dataCenter, 2);
        if (r112 == null) goto L38;
        m<Boolean> r113 = r112.A1();
        if (r113 == null) goto L38;
        if (r113.getValue().booleanValue() != true) goto L38;
        int r114 = 8;
    L39:
        r111.setVisibility(r114);
        return;
    L38:
        r114 = 0;
        goto L39
    L43:
        return;
    L42:
        return;
    L24:
        prepareViewOnLoad();
        goto L25
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final void qo(Boolean r100) {
        this.f100184b = r100;
    }

    public final void onEvent(x0 r100) {
        if (isScreenPortrait() == false) goto L5;
        return;
    L5:
        if (this.contentView == null) goto L15;
        this.containerView.setClipChildren(false);
        this.containerView.setClipToPadding(false);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L11;
        Boolean r102 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r101.get("data_longer_video_within_live_type", r102), r102) == true) goto L11;
        return;
    L11:
        UIUtils.updateLayoutMargin(this.contentView, s1.f(2.0f), -3, -3, -3);
        return;
    }

    public final void onEvent(n3 r100) {
        r r101 = z51.a.e(this.dataCenter);
        if (r101 != null) goto L5;
    L7:
        View r102 = this.contentView;
        if (r102 == null) goto L16;
        if (r100 != null) goto L11;
    L13:
        int r103 = 0;
    L14:
        r102.setVisibility(r103);
        return;
    L11:
        if (r100.f571889a != true) goto L13;
        r103 = 8;
        goto L14
    L16:
        return;
    L5:
        if (r101.isInVrLandscape(this.dataCenter) == true) goto L7;
    }

    public final <T> void wq(Class<T> r100, Function1<? super T, Unit> r101) {
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.dataCenter).b(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r101)), this.f100185c);
    }
}
