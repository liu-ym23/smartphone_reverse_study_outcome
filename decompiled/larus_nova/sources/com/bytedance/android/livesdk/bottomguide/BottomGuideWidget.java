package com.bytedance.android.livesdk.bottomguide;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.authorize.CouponAuthGuideDialog;
import com.bytedance.android.livesdk.authorize.NewAuthGuideManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.z0;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.coupon.CouponDialogWidget;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/BottomGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/livesdk/event/g;", "couponDialogWidgetEvent", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class BottomGuideWidget extends LiveRecyclableWidget implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f104330o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f104331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f104332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f104333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f104334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHandler f104335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f104336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Room f104337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f104338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f104339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f104340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f104341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.bottomguide.f f104342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.bottomguide.f f104343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CouponDialogWidget f104344n;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104345a;

        public b(BottomGuideWidget r100) {
            this.f104345a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f104345a.contentView.setVisibility(8);
            com.bytedance.android.livesdk.bottomguide.b.f104358b = false;
            BottomGuideWidget r101 = this.f104345a;
            int r102 = BottomGuideWidget.f104330o;
            r101.Cq();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104346a;

        public c(BottomGuideWidget r100) {
            this.f104346a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BottomGuideWidget r101 = this.f104346a;
            com.bytedance.android.livesdk.bottomguide.f r102 = (com.bytedance.android.livesdk.bottomguide.f) ((Response) r100).data;
            int r103 = BottomGuideWidget.f104330o;
            r101.getClass();
            if (r102 == null) goto L22;
            RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r104 == null) goto L11;
            m<Boolean> r105 = r104.isLiveRoomPreview();
            if (r105 == null) goto L11;
            if (r105.getValue().booleanValue() != true) goto L11;
            return;
        L11:
            CouponDialogWidget r106 = r101.f104344n;
            if (r106 == null) goto L20;
            Boolean r107 = r106.f121806c;
            if (r107 != null) goto L17;
            r101.f104342l = r102;
            com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "已经暂存短触区", "null");
            return;
        L17:
            if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L19;
            r101.f104343m = r102;
            com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "已经block了", "null");
            return;
        L19:
            r101.Bq(r102);
            com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "依赖的消息已经返回了，并且不需要阻塞", "null");
            return;
        L20:
            com.bytedance.android.livesdk.log.c.a(true, "BottomGuideWidget", "BottomGuideWidget", "couponDialogWidget 为空");
            r101.Bq(r102);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f104347a = null;

        static {
            f104347a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104348a;

        public e(BottomGuideWidget r100) {
            this.f104348a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.FALSE) == false) goto L6;
            BottomGuideWidget r101 = this.f104348a;
            int r102 = BottomGuideWidget.f104330o;
            r101.zq(true);
            return;
        }
    }

    public final class f implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f104349a;

        public f(Function1 r100) {
            this.f104349a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f104349a.invoke(r100);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuideBarResponseItem f104350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104351b;

        public g(GuideBarResponseItem r100, BottomGuideWidget r101) {
            this.f104350a = r100;
            this.f104351b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomGuideWidget r101 = this.f104351b;
            this.f104350a.getClass();
            BottomGuideWidget.xq(r101, "guide");
            BottomGuideWidget.wq(this.f104351b, true);
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuideBarResponseItem f104352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104353b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f104354a;

            public a(h r100) {
                this.f104354a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                BottomGuideWidget.wq(this.f104354a.f104353b, false);
                this.f104354a.f104353b.zq(true);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f104353b.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
            return;
        L5:
            this.f104353b.contentView.setOnClickListener(new a(this));
            View r101 = this.f104353b.f104334d;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
        L8:
            r101.setOnClickListener(com.bytedance.android.livesdk.bottomguide.e.f104363a);
            BottomGuideWidget r102 = this.f104353b;
            if (r102.context != null) goto L11;
        L25:
            this.f104353b.f104339i = System.currentTimeMillis();
            this.f104353b.f104335e.sendMessageDelayed(this.f104353b.f104335e.obtainMessage(1), this.f104352a.e() * 1000);
            return;
        L11:
            if (r102.isAlive() == false) goto L25;
            if (ViewCompat.isAttachedToWindow(this.f104353b.contentView) == false) goto L25;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
            BottomGuideModel r104 = (BottomGuideModel) this.f104353b.getViewModel(BottomGuideModel.class);     // Catch: Throwable -> L20
            if (r104 == null) goto L17;
            r104.getShowing().setValue(Boolean.TRUE);     // Catch: Throwable -> L20
            r104.getCountTime().setValue(0L);     // Catch: Throwable -> L20
            r104.getGuideBar().setValue(this.f104352a);     // Catch: Throwable -> L20
        L18:
            Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L20
        L22:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L25;
            r106.printStackTrace();
            goto L25
        L17:
            r104 = null;
        L20:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L22
        }

        public h(GuideBarResponseItem r100, BottomGuideWidget r101) {
            this.f104352a = r100;
            this.f104353b = r101;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomGuideWidget f104355a;

        public i(BottomGuideWidget r100) {
            this.f104355a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            BottomGuideWidget r100 = this.f104355a;
            com.bytedance.android.livesdk.bottomguide.i r111 = (com.bytedance.android.livesdk.bottomguide.i) ((Response) r110).data;
            int r101 = BottomGuideWidget.f104330o;
            r100.getClass();
            if (r111.b() == null) goto L29;
            IMiddlewareRoomService r102 = (IMiddlewareRoomService) k.f(IMiddlewareRoomService.class);
            if (r102 != null) goto L7;
        L9:
            boolean r103 = false;
        L11:
            if (z0.f117682a == false) goto L30;
            com.bytedance.android.livesdk.sharedpref.e<Long> r104 = com.bytedance.android.livesdk.sharedpref.b.f158214t1;
            Long r105 = r104.getValue();
            long r106 = System.currentTimeMillis();
            Calendar r107 = Calendar.getInstance();
            Calendar r108 = Calendar.getInstance();
            r107.setTime(new Date(r105.longValue()));
            r108.setTime(new Date(r106));
            if (r107.get(6) == r108.get(6)) goto L15;
        L17:
            boolean r109 = false;
        L18:
            if (r109 == true) goto L20;
            com.bytedance.android.livesdk.sharedpref.b.f158209s1.getValue().put(z0.a(), "0");
            int r112 = 0;
        L22:
            if (r112 >= r111.a()) goto L31;
            if (r103 == true) goto L32;
            com.bytedance.android.livesdk.f.d().getClass();
            if (com.bytedance.android.livesdk.f.e() == true) goto L33;
            com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r113 = com.bytedance.android.livesdk.sharedpref.b.f158209s1;
            Map<String, String> r114 = r113.getValue();
            int r115 = d5.b(r114.get(z0.a()));
            r114.put(z0.a(), String.valueOf(r115 + 1));
            com.bytedance.android.livesdk.sharedpref.f.d(r113, r114);
            com.bytedance.android.livesdk.sharedpref.f.d(r104, Long.valueOf(System.currentTimeMillis()));
            z0.f117683b = true;
            z0.f117682a = false;
            ((ILiveActionHandler) k.n(ILiveActionHandler.class)).handle(r100.getContext(), r111.b());
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L20:
            r112 = d5.b(com.bytedance.android.livesdk.sharedpref.b.f158209s1.getValue().get(z0.a()));
            goto L22
        L15:
            if (r107.get(1) != r108.get(1)) goto L17;
            r109 = true;
            goto L18
        L30:
            return;
        L7:
            if (r102.isSlideUpTipShowing() != true) goto L9;
            r103 = true;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.bottomguide.BottomGuideWidget$onInit$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/event/g;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/event/g;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.event.g, Unit> {
        public AnonymousClass1(BottomGuideWidget r100) {
            super(1, r100, BottomGuideWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/event/CouponDialogWidgetEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.bytedance.android.livesdk.event.g r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ((BottomGuideWidget) this.receiver).onEvent(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.event.g r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_bottom_guide_widget;
    }

    public final JSONObject Aq() {
        JSONObject r100 = this.f104338h;
        if (r100 == null) goto L27;
        return r100;
    L27:
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Exception -> L26
        String r102 = (String) this.dataCenter.get("data_enter_ecom_live_params", "");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r102) == false) goto L8;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L26
    L9:
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L26
    L11:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();     // Catch: Exception -> L26
        r101.put(r105, r103.optString(r105));     // Catch: Exception -> L26
        goto L11
    L13:
        CharSequence r106 = (CharSequence) r101.get("enter_request");     // Catch: Exception -> L26
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L23;
        return null;
    L23:
        this.f104338h = new JSONObject((String) r101.get("enter_request"));     // Catch: Exception -> L26
        goto L25
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
        goto L20
    L8:
        r103 = new JSONObject(r102);     // Catch: Exception -> L26
    L25:
        return this.f104338h;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
    L8:
        e = move-exception;
        ALogger.e("BottomGuideWidget", e);
    L10:
        super.onPause();
        return;
    L3:
        if (this.widgetCallback == null) goto L10;
        if (Intrinsics.areEqual(((BottomGuideModel) getViewModel(BottomGuideModel.class)).getShowing().getValue(), Boolean.TRUE) == false) goto L10;
        this.f104335e.removeCallbacksAndMessages(null);     // Catch: Exception -> L8
        long r100 = System.currentTimeMillis() - this.f104339i;     // Catch: Exception -> L8
        Long r101 = ((BottomGuideModel) getViewModel(BottomGuideModel.class)).getCountTime().getValue();     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L8
        long r102 = r101.longValue();     // Catch: Exception -> L8
        ((BottomGuideModel) getViewModel(BottomGuideModel.class)).getCountTime().setValue(Long.valueOf(r100 + r102));     // Catch: Exception -> L8
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
    L10:
        e = move-exception;
        ALogger.e("BottomGuideWidget", e);
    L12:
        super.onResume();
        return;
    L3:
        if (this.widgetCallback == null) goto L12;
        if (Intrinsics.areEqual(((BottomGuideModel) getViewModel(BottomGuideModel.class)).getShowing().getValue(), Boolean.TRUE) == false) goto L12;
        BottomGuideModel r100 = (BottomGuideModel) getViewModel(BottomGuideModel.class);     // Catch: Exception -> L10
        if (r100 == null) goto L12;
        Message r101 = this.f104335e.obtainMessage(1);     // Catch: Exception -> L10
        GuideBarResponseItem r102 = r100.getGuideBar().getValue();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L10
        long r103 = r102.e() * 1000;     // Catch: Exception -> L10
        Long r104 = r100.getCountTime().getValue();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L10
        long r105 = r103 - r104.longValue();     // Catch: Exception -> L10
        this.f104339i = System.currentTimeMillis();     // Catch: Exception -> L10
        this.f104335e.sendMessageDelayed(r101, r105);     // Catch: Exception -> L10
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ViewPropertyAnimator r100 = this.f104341k;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        zq(false);
        View r101 = this.f104334d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
    L8:
        r101.animate().setListener(null);
        this.contentView.setOnClickListener(null);
        View r102 = this.f104334d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
    L11:
        r102.setOnClickListener(null);
        this.f104335e.removeCallbacksAndMessages(null);
        com.bytedance.android.livesdk.bottomguide.b.f104358b = false;
        z0.f117683b = false;
    }

    public BottomGuideWidget() {
        this.f104335e = new WeakHandler(this);
    }

    public final void Cq() {
        IndividualTaskApi r100 = (IndividualTaskApi) com.bytedance.android.live.network.c.b().e(IndividualTaskApi.class);
        Room r101 = this.f104337g;
        Intrinsics.checkNotNull(r101);
        this.f104336f = r100.getIndividualTask(r101.f162599id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new i(this), RxUtil.getNoOpThrowable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, com.bytedance.android.livesdk.bottomguide.GuideBarResponseItem] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T] */
    /* JADX WARN: Type inference failed for: r7v9, types: [T, com.bytedance.android.livesdk.bottomguide.g] */
    public final void Bq(com.bytedance.android.livesdk.bottomguide.f r110) {
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        JSONObject r101 = null;
        r100.element = null;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        List<GuideBarResponseItem> r104 = r110.a();
        if (r104 == null) goto L26;
        Iterator r105 = r104.iterator();
        ?? r106 = 0;
    L9:
        if (r105.hasNext() == false) goto L27;
        ?? r107 = (GuideBarResponseItem) r105.next();
        int r108 = r107.getType();
        if (r108 == GuideBarResponseItem.GuideBarType.OauthConfidenceBar.getType()) goto L12;
        if (r108 == GuideBarResponseItem.GuideBarType.JumpNoticeAfterRejectOauth.getType()) goto L18;
        if (r108 == GuideBarResponseItem.GuideBarType.SilentOauthGuideBar.getType()) goto L21;
        if (r108 == GuideBarResponseItem.GuideBarType.CouponOauthBar.getType()) goto L24;
        GuideBarResponseItem.GuideBarType.CouponSilenceOauthBar5.getType();
        goto L9
    L24:
        r106 = r107;
        goto L9
    L21:
        r103.element = r107;
        goto L9
    L18:
        r102.element = r107.g();
        goto L9
    L12:
        com.bytedance.android.livesdk.bottomguide.g r109 = r107.g();
        ?? r111 = r109;
        if (r109 != null) goto L15;
        r111 = (com.bytedance.android.livesdk.bottomguide.g) r100.element;
    L15:
        r100.element = r111;
    L27:
        IAppLog r112 = BDLiveSdk.appLog();
        if (r112 != null) goto L30;
    L58:
        List<GuideBarResponseItem> r113 = r110.a();
        if (r113 == null) goto L140;
        GuideBarResponseItem r114 = (GuideBarResponseItem) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L141;
        NewAuthGuideManager r115 = NewAuthGuideManager.f104175l;
        if (r115.d(this, (GuideBarResponseItem) r103.element, (com.bytedance.android.livesdk.bottomguide.g) r102.element) == false) goto L65;
        return;
    L65:
        ((IRoomService) k.n(IRoomService.class)).getEnterConfigManager();
        com.bytedance.android.livesdk.bottomguide.g r116 = (com.bytedance.android.livesdk.bottomguide.g) r100.element;
        if (LiveConfigSettingKeys.SAAS_MOCK_AUTH_GUIDE.getValue().booleanValue() == false) goto L69;
        r114.h(new com.bytedance.android.livesdk.bottomguide.g(Integer.MAX_VALUE, 5, Integer.MAX_VALUE, 3, 8));
    L69:
        if (r115.c(this, r114.g(), (com.bytedance.android.livesdk.bottomguide.g) r102.element) == false) goto L71;
        return;
    L71:
        IAppLog r117 = BDLiveSdk.appLog();
        if (r117 == null) goto L77;
        if (r117.isTob() != true) goto L77;
        return;
    L77:
        if (com.bytedance.android.livesdk.bottomguide.b.f104357a == true) goto L79;
        return;
    L79:
        com.bytedance.android.livesdk.sharedpref.e<Long> r118 = com.bytedance.android.livesdk.sharedpref.b.f158204r1;
        Long r119 = r118.getValue();
        long r120 = System.currentTimeMillis();
        Calendar r121 = Calendar.getInstance();
        Calendar r122 = Calendar.getInstance();
        r121.setTime(new Date(r119.longValue()));
        r122.setTime(new Date(r120));
        if (r121.get(6) == r122.get(6)) goto L82;
    L84:
        boolean r123 = false;
    L85:
        if (r123 == true) goto L87;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r124 = com.bytedance.android.livesdk.sharedpref.b.f158199q1;
        r124.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r124, 0);
        int r125 = 0;
    L89:
        if (r125 < r114.d()) goto L92;
        Cq();
        return;
    L92:
        IMiddlewareRoomService r126 = (IMiddlewareRoomService) k.f(IMiddlewareRoomService.class);
        if (r126 != null) goto L95;
    L98:
        HashMap<String, String> r127 = new HashMap();
        yq(r127);
        u.l().sendLog("livesdk_aweme_authorization_guide_show", r127, new Object[0]);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r128 = com.bytedance.android.livesdk.sharedpref.b.f158199q1;
        com.bytedance.android.livesdk.sharedpref.f.d(r128, Integer.valueOf(r128.getValue().intValue() + 1));
        com.bytedance.android.livesdk.sharedpref.f.d(r118, Long.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.bottomguide.b.f104358b = true;
        com.bytedance.android.livesdk.bottomguide.b.f104357a = false;
        this.contentView.setVisibility(0);
        View r129 = this.f104334d;
        if (r129 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
    L101:
        r129.setTranslationY(LiveResUtil.dip2Px(92.0f));
        TextView r130 = this.f104332b;
        if (r130 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mainTextView");
    L104:
        r130.setText(r114.b());
        TextView r131 = this.f104333c;
        if (r131 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("subTextView");
    L107:
        r131.setText(r114.f());
        TextView r132 = this.f104331a;
        if (r132 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("button");
    L110:
        r132.setText(r114.a());
        TextView r133 = this.f104331a;
        if (r133 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("button");
    L113:
        r133.setOnClickListener(new g(r114, this));
        View r134 = this.f104334d;
        if (r134 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
    L116:
        ViewPropertyAnimator r135 = r134.animate().translationY(0.0f).setInterpolator(new PathInterpolator(0.0f, 0.4f, 0.2f, 1.0f)).setListener(new h(r114, this)).setDuration(260);
        this.f104341k = r135;
        if (r135 == null) goto L142;
        r135.start();
        return;
    L142:
        return;
    L95:
        if (r126.isSlideUpTipShowing() != true) goto L98;
        Cq();
        return;
    L87:
        r125 = com.bytedance.android.livesdk.sharedpref.b.f158199q1.getValue().intValue();
        goto L89
    L82:
        if (r121.get(1) != r122.get(1)) goto L84;
        r123 = true;
        goto L85
    L141:
        return;
    L140:
        return;
    L30:
        if (r112.isTob() == false) goto L58;
        JSONObject r136 = Aq();     // Catch: JSONException -> L38
        if (r136 == null) goto L34;
        String r137 = r136.optString(BdpAppEventConstant.PARAMS_AUTH_TYPE);     // Catch: JSONException -> L38
    L35:
        if (Intrinsics.areEqual(r137, "4") == false) goto L40;
        boolean r138 = true;
    L41:
        if (r138 == false) goto L58;
        ((IRoomService) k.n(IRoomService.class)).getEnterConfigManager();
        NewAuthGuideManager r139 = NewAuthGuideManager.f104175l;
        JSONObject r140 = this.f104338h;
        if (r140 == null) goto L45;
        r101 = r140.optJSONObject("params");
    L45:
        r139.getClass();
        Intrinsics.checkNotNullParameter(this, "widget");
        if (r106 == 0) goto L55;
        if (r101 == null) goto L55;
        CouponAuthGuideDialog r141 = new CouponAuthGuideDialog(this.context, r101);
        if (DialogLancet.shouldBlockDialogShow(r141) == false) goto L121;
        DialogLancet.handleBlockedDialogShow(r141);
    L54:
        boolean r142 = true;
    L56:
        if (r142 == false) goto L58;
        return;
    L121:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L120
    L53:
        DialogLancet.beforeDialogShow(r141);
        r141.show();
        DialogLancet.afterDialogShow(r141);
    L55:
        r142 = false;
    L40:
        r138 = false;
        goto L41
    L34:
        r137 = null;
    L38:
        e = move-exception;
        ALogger.e("[parse ecom params error]", e);
        goto L40
    L26:
        r106 = 0;
        goto L27
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 1) goto L8;
        zq(true);
        return;
    }

    public final void onEvent(com.bytedance.android.livesdk.event.g r100) {
        Intrinsics.checkNotNullParameter(r100, "couponDialogWidgetEvent");
        if (this.f104344n != null) goto L5;
        return;
    L5:
        if (r100.f123347a == 0) goto L38;
        com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "收到消息,进入 onEvent 函数", "null");
        int r101 = r100.f123347a;
        if (r101 != 1) goto L10;
        com.bytedance.android.livesdk.bottomguide.f r102 = this.f104343m;
        if (r102 == null) goto L37;
        com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "收到消息，移除阻塞", "null");
        CouponDialogWidget r103 = this.f104344n;
        if (r103 == null) goto L27;
        Boolean r104 = r103.f121806c;
    L29:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == false) goto L31;
        Bq(r102);
    L31:
        this.f104343m = null;
        return;
    L27:
        r104 = null;
        goto L29
    L37:
        return;
    L10:
        if (r101 != 2) goto L39;
        com.bytedance.android.livesdk.bottomguide.f r105 = this.f104342l;
        if (r105 == null) goto L34;
        com.bytedance.android.livesdk.log.c.a(false, "BottomGuideWidget", "收到消息，移除暂存", "null");
        CouponDialogWidget r106 = this.f104344n;
        if (r106 == null) goto L17;
        Boolean r107 = r106.f121806c;
    L19:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L21;
        this.f104343m = this.f104342l;
        this.f104342l = null;
        return;
    L21:
        Bq(r105);
        return;
    L17:
        r107 = null;
        goto L19
    L34:
        return;
    L39:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f104331a = (TextView) this.contentView.findViewById(R.id.ttlive_guide_btn);
        this.f104332b = (TextView) this.contentView.findViewById(R.id.ttlive_guide_title);
        this.f104333c = (TextView) this.contentView.findViewById(R.id.ttlive_guide_sub_title);
        this.f104334d = this.contentView.findViewById(R.id.ttlive_guide_content);
        TextView r101 = this.f104331a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("button");
    L5:
        int r102 = r3.f156924a;
        Intrinsics.checkNotNullParameter(Button.class, "overrideClass");
        r3.b(r101, null, Button.class);
        r3.c(this.contentView, LiveResUtil.getString(R.string.ttlive_a11y_close), true);
        this.f104340j = ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.g.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(new AnonymousClass1(this)));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.contentView.setVisibility(8);
        Room r101 = (Room) this.dataCenter.get("data_room", null);
        if (r101 != null) goto L5;
        return;
    L5:
        this.f104337g = r101;
        if (((IUserService) k.n(IUserService.class)).user().isLogin() == false) goto L9;
        Cq();
        return;
    L9:
        GuideApi r102 = (GuideApi) com.bytedance.android.live.network.c.b().e(GuideApi.class);
        Room r103 = this.f104337g;
        Intrinsics.checkNotNull(r103);
        ((ObservableSubscribeProxy) r102.getGuide(r103.f162599id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).as(autoDispose())).subscribe(new c(this), d.f104347a);
        ((BottomGuideModel) getViewModel(BottomGuideModel.class)).getShowing().observe(this, new e(this));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public final void yq(HashMap<String, String> r100) {
        Room r101 = this.f104337g;
        String r102 = "";
        if (r101 == null) goto L8;
        r100.put("anchor_id", r101.getOwnerUserIdString());
        r100.put("room_id", r101.getIdStr());
        r100.put("request_id", r101.getRequestId());
        String r103 = r101.getLog_pb();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r100.put("log_pb", r103);
    L8:
        o r104 = u.l().c(x.class);
        if (r104 == null) goto L18;
        String r105 = r104.getMap().get("enter_from_merge");
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r100.put("enter_from_merge", r105);
        String r106 = r104.getMap().get("enter_method");
        if (r106 == null) goto L17;
        r102 = r106;
    L17:
        r100.put("enter_method", r102);
    L18:
        r100.put("action_type", "click");
        if (((od1.a) k.n(od1.a.class)).hostIsLogin() == false) goto L21;
        String r107 = "unlogged";
    L22:
        r100.put("user_type", r107);
        return;
    L21:
        r107 = "unauthorized";
        goto L22
    }

    public final void zq(boolean r100) {
        if (r100 == false) goto L7;
        View r101 = this.f104334d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("guideContentView");
    L6:
        r101.animate().translationY(LiveResUtil.dip2Px(92.0f)).setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.9f, 0.6f)).setDuration(160).setListener(new b(this)).start();
    L17:
    L13:
        e = move-exception;
        ALogger.e("BottomGuideWidget", e);
    L15:
        this.f104335e.removeCallbacksAndMessages(null);
        return;
    L10:
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        ((BottomGuideModel) getViewModel(BottomGuideModel.class)).getShowing().setValue(null);     // Catch: Exception -> L13
        goto L15
    L7:
        this.contentView.setVisibility(8);
        com.bytedance.android.livesdk.bottomguide.b.f104358b = false;
        goto L17
    }

    public static final void wq(BottomGuideWidget r100, boolean r101) {
        r100.getClass();
        HashMap<String, String> r102 = new HashMap();
        r100.yq(r102);
        if (r101 == false) goto L5;
        String r103 = "authorization";
    L6:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r103);
        u.l().sendLog("livesdk_aweme_authorization_guide_click", r102, new Object[0]);
        return;
    L5:
        r103 = "cancel";
        goto L6
    }

    public static final void xq(BottomGuideWidget r100, String r101) {
        r100.zq(false);
        com.bytedance.android.livesdk.user.f r102 = ((IUserService) k.n(IUserService.class)).user();
        if (r102.isLogin() == true) goto L8;
        l.a r103 = new l.a();
        r103.f158687c = -1;
        r103.f158688d = r101;
        l r104 = new l(r103);
        Context r105 = r100.context;
        if (r105 == null) goto L9;
        r102.login(r105, r104).subscribe(new com.bytedance.android.livesdk.bottomguide.c(r100, r102), new com.bytedance.android.livesdk.bottomguide.d(r100, r102));
        return;
    L9:
        return;
    }
}
