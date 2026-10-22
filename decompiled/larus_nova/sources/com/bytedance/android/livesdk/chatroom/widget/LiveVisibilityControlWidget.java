package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveVisibilityControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget extends LiveRecyclableWidget implements Observer<KVData>, com.bytedance.android.live.room.api.visibilitycontrol.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f118554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetManager f118555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f118557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f118563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<LiveVisibilityControl.KEY, com.bytedance.android.live.room.api.visibilitycontrol.d> f118564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Observable<Unit> f118565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f118566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IVisibilityControlBrickService f118567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IVisibilityControlService f118568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LiveVisibilityControlContext f118569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CompositeDisposable f118570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f118571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f118572s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f118573t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f118574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<Animator> f118575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f118576w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlContext f118577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlWidget f118578b;

        public b(LiveVisibilityControlContext r100, LiveVisibilityControlWidget r101) {
            this.f118577a = r100;
            this.f118578b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Boolean r100 = (Boolean) r110;
            ALogger.d(LiveVisibilityControlContext.visibilityControlTag, "in LiveVisibility, subscribe value is  " + r100);
            LiveVisibilityControlWidget r101 = this.f118578b;
            if (r101.f118556c == true) goto L5;
            r101.f118557d = true;
            return;
        L5:
            Boolean r102 = Boolean.FALSE;
            if (Intrinsics.areEqual(r100, r102) == false) goto L11;
            if (this.f118577a.isLocked().getValue().booleanValue() == true) goto L11;
            LiveVisibilityControlWidget.Lq(this.f118578b.f118560g);
            LiveVisibilityControlWidget.Lq(this.f118578b.f118561h);
            LiveVisibilityControlWidget.Lq(this.f118578b.f118562i);
            LiveVisibilityControlWidget.Lq(this.f118578b.f118563j);
            this.f118578b.Kq();
        L11:
            if (this.f118577a.getCustomAnimDuration().getValue().longValue() == (-1)) goto L13;
            long r103 = this.f118577a.getCustomAnimDuration().getValue().longValue();
            this.f118577a.getCustomAnimDuration().setValue(-1L);
        L14:
            LiveVisibilityControlWidget r111 = this.f118578b;
            boolean r112 = r100.booleanValue();
            if (r111.isViewValid() == false) goto L31;
            String r104 = r111.f118554a;
            StringBuilder r105 = new StringBuilder(" start changeInteractionVisibility to ");
            r105.append(r112);
            r105.append(",lock state=");
            LiveVisibilityControlContext r106 = r111.f118569p;
            if (r106 == null) goto L22;
            com.bytedance.live.datacontext.m<Boolean> r107 = r106.isLocked();
            if (r107 == null) goto L22;
            Boolean r108 = r107.getValue();
        L23:
            r105.append(r108);
            ALogger.d(r104, r105.toString());
            ((ArrayList) r111.f118575v).clear();
            long r109 = r103;
            r111.Fq(r111.f118558e, r112, false, r109);
            r111.Cq(r111.f118559f, r112, false, r109);
            r111.Jq(r111.f118560g, r112, false, r109);
            r111.Eq(r111.f118561h, r112, false, r109);
            r111.Gq(r111.f118562i, r112, false, r109);
            r111.Iq(r111.f118563j, r112, false, r109);
            AnimatorSet r113 = new AnimatorSet();
            r113.playTogether(r111.f118575v);
            r113.addListener(new f1(r111, r112, r113));
            r113.start();
            if (r3.l(r111.context) == false) goto L31;
            Context r114 = r111.context;
            if (r112 == false) goto L28;
            String r115 = "已显示播放控制栏";
        L29:
            r3.q(r114, r115);
            goto L31
        L28:
            r115 = "已隐藏播放控制栏";
        L22:
            r108 = null;
        L31:
            if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L34;
            this.f118578b.Mq();
        L34:
            if (Intrinsics.areEqual(r100, r102) == false) goto L38;
            this.f118577a.getPlayerViewVisibleTriggeredByUser().setValue(r102);
            return;
        L38:
            return;
        L13:
            r103 = 200;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlWidget f118579a;

        public c(LiveVisibilityControlWidget r100) {
            this.f118579a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            ALogger.d(this.f118579a.f118554a, "receive resetHideTaskEvent");
            this.f118579a.Mq();
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlWidget f118580a;

        public d(LiveVisibilityControlWidget r100) {
            this.f118580a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 == null) goto L8;
            boolean r102 = r101.booleanValue();
            IVisibilityControlService r103 = this.f118580a.f118568o;
            if (r103 == null) goto L9;
            r103.setLockStatus(r102);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlWidget f118581a;

        public e(LiveVisibilityControlWidget r100) {
            this.f118581a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L8;
            IVisibilityControlService r101 = this.f118581a.f118568o;
            if (r101 == null) goto L9;
            r101.setVisibilityStatus(false);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVisibilityControlWidget f118582a;

        public f(LiveVisibilityControlWidget r100) {
            this.f118582a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            LiveVisibilityControlWidget r102 = this.f118582a;
            if (r102.f118576w == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.live.core.utils.z.m(r102.dataCenter, true) == false) goto L12;
            VSDataContext r103 = VSDataContext.a.c(VSDataContext.Companion, this.f118582a.dataCenter);
            if (r103 == null) goto L19;
            com.bytedance.live.datacontext.m<Boolean> r104 = r103.isVerticalVideo();
            if (r104 != null) goto L11;
            return;
        L11:
            if (r104.getValue().booleanValue() == true) goto L12;
            return;
        L19:
            return;
        L12:
            LiveVisibilityControlWidget r105 = this.f118582a;
            IVisibilityControlBrickService r106 = r105.f118567n;
            if (r106 == null) goto L22;
            IVisibilityControlService r107 = r106.provideVisibilityControlService(r105.dataCenter);
            if (r107 == null) goto L23;
            r107.setVisibilityStatus(false);
            return;
        L23:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void Kq() {
        WidgetInfo r100 = getWidgetInfo(ShadowPlayerWidget.class);
        if (r100 == null) goto L6;
        int[] r101 = r100.getLocationOnScreen();
        int r102 = r101[0];
        this.f118573t = r102;
        this.f118571r = r101[1];
        this.f118574u = r102 + r100.getContentViewWidth();
        this.f118572s = this.f118571r + r100.getContentViewHeight();
        return;
    }

    public final void Mq() {
        ALogger.d(this.f118554a, "--resetHideViewTask");
        Disposable r100 = null;
        this.f118565l = null;
        IVisibilityControlService r101 = this.f118568o;
        if (r101 == null) goto L6;
        Observable<Unit> r102 = r101.startVisibilityTimer();
        if (r102 == null) goto L6;
    L7:
        this.f118565l = r102;
        Disposable r103 = this.f118566m;
        if (r103 == null) goto L10;
        r103.dispose();
    L10:
        Observable<Unit> r104 = this.f118565l;
        if (r104 == null) goto L13;
        r100 = RxUtilKt.n(r104, new LiveVisibilityControlWidget$resetHideViewTask$1(this));
    L13:
        this.f118566m = r100;
        return;
    L6:
        r102 = Observable.timer(5000, TimeUnit.MILLISECONDS).map(i1.f118819a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        String r100 = this.f118554a;
        StringBuilder r101 = new StringBuilder("start onUnload: dataCenter:");
        r101.append(this.dataCenter.hashCode());
        r101.append(", viewControlService:");
        IVisibilityControlBrickService r102 = this.f118567n;
        if (r102 == null) goto L5;
        IVisibilityControlService r103 = r102.provideVisibilityControlService(this.dataCenter);
    L7:
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        r101.append(r104);
        ALogger.d(r100, r101.toString());
        this.dataCenter.removeObserver(this);
        this.f118576w = false;
        this.f118555b = null;
        ((LinkedHashMap) this.f118564k).clear();
        ((ArrayList) this.f118558e).clear();
        ((ArrayList) this.f118559f).clear();
        ((ArrayList) this.f118560g).clear();
        ((ArrayList) this.f118561h).clear();
        ((ArrayList) this.f118562i).clear();
        ((ArrayList) this.f118563j).clear();
        this.f118569p = null;
        IVisibilityControlBrickService r105 = this.f118567n;
        if (r105 == null) goto L15;
        IVisibilityControlService r106 = r105.provideVisibilityControlService(this.dataCenter);
        if (r106 == null) goto L15;
        r106.clearControlWidget();
    L15:
        this.f118567n = null;
        ((ArrayList) this.f118575v).clear();
        Disposable r107 = this.f118566m;
        if (r107 != null) goto L18;
    L23:
        this.f118566m = null;
        this.f118570q.dispose();
        return;
    L18:
        if (r107.isDisposed() == false) goto L21;
        r107 = null;
    L21:
        if (r107 == null) goto L23;
        r107.dispose();
        goto L23
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public LiveVisibilityControlWidget() {
        this.f118554a = "PlayerVisibilityControllerWidget[" + hashCode() + ']';
        this.f118558e = new ArrayList();
        this.f118559f = new ArrayList();
        this.f118560g = new ArrayList();
        this.f118561h = new ArrayList();
        this.f118562i = new ArrayList();
        this.f118563j = new ArrayList();
        this.f118564k = new LinkedHashMap();
        this.f118570q = new CompositeDisposable();
        this.f118575v = new ArrayList();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        this.f118576w = false;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        Mq();
        LiveVisibilityControlContext r100 = this.f118569p;
        if (r100 == null) goto L5;
        r100.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.FALSE);
    L5:
        this.f118576w = true;
    }

    public static void Lq(List r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$refreshViewPosition");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.android.live.room.api.visibilitycontrol.d) r101.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.live.room.api.visibilitycontrol.c
    public final void addControlItem(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        ALogger.d(this.f118554a, "start addControl Item for " + r100.f99168f.getDescribe());
        removeControlItem(r100.f99168f);
        switch(e1.f118787b[r100.getType().ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        ((ArrayList) this.f118559f).add(r100);
        goto L11
    L6:
        ((ArrayList) this.f118558e).add(r100);
        goto L11
    L7:
        ((ArrayList) this.f118563j).add(r100);
        goto L11
    L8:
        ((ArrayList) this.f118562i).add(r100);
        goto L11
    L9:
        ((ArrayList) this.f118561h).add(r100);
        goto L11
    L10:
        ((ArrayList) this.f118560g).add(r100);
    L11:
        View r101 = r100.f99170h;
        r101.setAlpha(1.0f);
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        this.f118564k.put(r100.f99168f, r100);
        LiveVisibilityControlContext r102 = this.f118569p;
        if (r102 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getViewVisibleMutable();
        if (r103 == null) goto L18;
        boolean r104 = true;
        if (r103.getValue().booleanValue() != true) goto L18;
    L19:
        boolean r105 = !r104;
        Integer r106 = r100.f99167e.getValue();
        if (r106 != null) goto L23;
    L25:
        ((ArrayList) this.f118575v).clear();
        switch(e1.f118786a[r100.getType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L34;
        };
    L28:
        Cq(CollectionsKt.listOf(r100), r104, false, 0);
        goto L34
    L29:
        Fq(CollectionsKt.listOf(r100), r104, false, 0);
        goto L34
    L30:
        Iq(CollectionsKt.listOf(r100), r104, false, 0);
        goto L34
    L31:
        Gq(CollectionsKt.listOf(r100), r104, false, 0);
        goto L34
    L32:
        Eq(CollectionsKt.listOf(r100), r104, false, 0);
        goto L34
    L33:
        Jq(CollectionsKt.listOf(r100), r104, false, 0);
    L34:
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(this.f118575v);
        r107.start();
        ALogger.d(this.f118554a, "add control item and init it's status Item:[" + r100.f99168f.getDescribe() + "] Visibility to [" + r104 + ']');
        return;
    L23:
        if (r106.intValue() != r105) goto L25;
        return;
    L18:
        r104 = false;
        goto L19
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r111 = (KVData) r110;
        if (r111 == null) goto L52;
        String r112 = r111.getKey();
        if (r112.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r112.equals("cmd_widget_loaded") == false) goto L53;
        Kq();
        WidgetManager r113 = this.f118555b;
        if (r113 == null) goto L54;
        Iterator<Map.Entry<Widget, ViewGroup>> r114 = r113.widgetViewGroupHashMap.entrySet().iterator();
    L13:
        if (r114.hasNext() == false) goto L22;
        Map.Entry<Widget, ViewGroup> r100 = r114.next();
        Widget r101 = r100.getKey();
        LiveVisibilityControl r102 = (LiveVisibilityControl) r101.getClass().getAnnotation(LiveVisibilityControl.class);
        if (r102 == null) goto L13;
        ViewGroup r103 = r100.getValue();
        if (r103 == null) goto L13;
        LiveVisibilityControl.KEY r104 = r102.key();
        if ((r101 instanceof com.bytedance.android.live.room.api.visibilitycontrol.a) == true) goto L21;
        r101 = null;
    L21:
        addControlItem(new com.bytedance.android.live.room.api.visibilitycontrol.d(r104, (com.bytedance.android.live.room.api.visibilitycontrol.a) r101, r103, r102.type(), r102.style(), r102.attachMarginDp(), r102.needDynamicControl(), r102.ignoreLock(), r102.reverse()));
        goto L13
    L22:
        LiveVisibilityControlContext r115 = this.f118569p;
        if (r115 == null) goto L29;
        ALogger.d(this.f118554a, "initViewList: tmp list size:" + r115.getTmpControlItemList().size());
        Iterator<T> r105 = r115.getTmpControlItemList().iterator();
    L26:
        if (r105.hasNext() == false) goto L28;
        addControlItem((com.bytedance.android.live.room.api.visibilitycontrol.d) r105.next());
        goto L26
    L28:
        r115.getTmpControlItemList().clear();
    L29:
        this.f118556c = true;
        RoomContext.a r106 = RoomContext.Companion;
        RoomContext r107 = RoomContext.a.c(r106, this.dataCenter, 0, 2);
        if (r107 != null) goto L32;
    L38:
        ALogger.d(this.f118554a, "init complete. size: \ndirect[" + ((ArrayList) this.f118558e).size() + "]\nalpha[" + ((ArrayList) this.f118559f).size() + "]\ntop[" + ((ArrayList) this.f118560g).size() + "]\nbottom[" + ((ArrayList) this.f118561h).size() + "]\nleft[" + ((ArrayList) this.f118562i).size() + "]\nright[" + ((ArrayList) this.f118563j).size() + "]\n");
        if (this.f118557d == false) goto L55;
        LiveVisibilityControlContext r116 = this.f118569p;
        if (r116 == null) goto L56;
        r116.setViewVisibleValue(r116.getViewVisibleMutable().getValue().booleanValue());
        ALogger.w(this.f118554a, "beforeInitStatusChangeFlag == true, refresh status");
        return;
    L56:
        return;
    L55:
        return;
    L32:
        if (r107.isVSRoom() != true) goto L38;
        RoomContext r117 = RoomContext.a.c(r106, this.dataCenter, 0, 2);
        if (r117 == null) goto L38;
        com.bytedance.live.datacontext.k<Boolean> r118 = r117.getMatchPlayerControlInitComplete();
        if (r118 == null) goto L38;
        r118.post(Boolean.TRUE);
        goto L38
    L54:
        return;
    L53:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IVisibilityControlBrickService r101 = (IVisibilityControlBrickService) jc1.k.f(IVisibilityControlBrickService.class);
        this.f118567n = r101;
        LiveVisibilityControlContext r102 = null;
        if (r101 == null) goto L5;
        IVisibilityControlService r103 = r101.provideVisibilityControlService(this.dataCenter);
    L6:
        this.f118568o = r103;
        if (r103 == null) goto L9;
        r103.registerControlWidget(this);
    L9:
        String r104 = this.f118554a;
        StringBuilder r105 = new StringBuilder("start onLoad: dataCenter:");
        r105.append(this.dataCenter.hashCode());
        r105.append(", viewControlService:");
        IVisibilityControlBrickService r106 = this.f118567n;
        if (r106 == null) goto L14;
        IVisibilityControlService r107 = r106.provideVisibilityControlService(this.dataCenter);
        if (r107 == null) goto L14;
        Integer r108 = Integer.valueOf(r107.hashCode());
    L15:
        r105.append(r108);
        ALogger.d(r104, r105.toString());
        this.f118556c = false;
        this.f118557d = false;
        IVisibilityControlBrickService r109 = this.f118567n;
        if (r109 == null) goto L20;
        IVisibilityControlService r110 = r109.provideVisibilityControlService(this.dataCenter);
        if (r110 == null) goto L20;
        WidgetManager r111 = r110.getWidgetManager();
    L21:
        this.f118555b = r111;
        this.f118576w = false;
        this.f118570q = new CompositeDisposable();
        ((ArrayList) this.f118575v).clear();
        IVisibilityControlBrickService r112 = this.f118567n;
        if (r112 == null) goto L26;
        IVisibilityControlService r113 = r112.provideVisibilityControlService(this.dataCenter);
        if (r113 == null) goto L26;
        r102 = r113.provideContext();
    L26:
        this.f118569p = r102;
        if (r102 == null) goto L34;
        r102.setViewVisibleValue(r102.getInitVisible());
        Disposable r114 = r102.getViewVisibleMutable().a().subscribe(new b(r102, this));
        if (r114 == null) goto L31;
        RxUtilKt.c(r114, this.f118570q);
    L31:
        Disposable r115 = r102.getResetHideTaskEvent().onEvent().subscribe(new c(this));
        if (r115 == null) goto L34;
        RxUtilKt.c(r115, this.f118570q);
    L34:
        LandscapeInteractionModel r116 = (LandscapeInteractionModel) getViewModel(LandscapeInteractionModel.class);
        r116.isLocked().observe(this, new d(this));
        r116.isInZoomState().observe(this, new e(this));
        this.dataCenter.observe("cmd_widget_loaded", this);
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new f(this));
        return;
    L20:
        r111 = null;
    L14:
        r108 = null;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.visibilitycontrol.c
    public final void removeControlItem(LiveVisibilityControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r101 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.f118564k).get(r100);
        if (r101 == null) goto L15;
        LiveVisibilityControl.Type r102 = r101.getType();
        switch(e1.f118788c[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ((ArrayList) this.f118559f).remove(r101);
        return;
    L9:
        ((ArrayList) this.f118558e).remove(r101);
        return;
    L10:
        ((ArrayList) this.f118563j).remove(r101);
        return;
    L11:
        ((ArrayList) this.f118562i).remove(r101);
        return;
    L12:
        ((ArrayList) this.f118561h).remove(r101);
        return;
    L13:
        ((ArrayList) this.f118560g).remove(r101);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.room.api.visibilitycontrol.c
    public final NextLiveData<Integer> wd(LiveVisibilityControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r101 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.f118564k).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f99167e;
    }

    @Override // com.bytedance.android.live.room.api.visibilitycontrol.c
    public final void Gc(LiveVisibilityControl.KEY r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r103 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.f118564k).get(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        ((ArrayList) this.f118575v).clear();
        switch(e1.f118789d[r103.getType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L14;
        };
    L8:
        Cq(CollectionsKt.listOf(r103), r101, true, r102);
        goto L14
    L9:
        Fq(CollectionsKt.listOf(r103), r101, true, r102);
        goto L14
    L10:
        Iq(CollectionsKt.listOf(r103), r101, true, r102);
        goto L14
    L11:
        Gq(CollectionsKt.listOf(r103), r101, true, r102);
        goto L14
    L12:
        Eq(CollectionsKt.listOf(r103), r101, true, r102);
        goto L14
    L13:
        Jq(CollectionsKt.listOf(r103), r101, true, r102);
    L14:
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(this.f118575v);
        r104.start();
        ALogger.d(this.f118554a, "start change Item:[" + r100.getDescribe() + "] Visibility to [" + r101 + ']');
    }

    public static final Animator wq(LiveVisibilityControlWidget r100, View r101, float r102, long r103) {
        r100.getClass();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{r101.getAlpha(), r102});
        r104.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r104.setDuration(r103);
        return r104;
    }

    public final void Bq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, Function1<? super com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> r101, boolean r110, boolean r111) {
        ArrayList r102 = new ArrayList();
        r102.addAll(r100);
        LiveVisibilityControlContext r103 = this.f118569p;
        List r104 = r102;
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r105 = r103.isLocked();
        r104 = r102;
        if (r105 == null) goto L16;
        r104 = r102;
        r104 = r102;
        if (r105.getValue().booleanValue() != true) goto L16;
        if (r110 == false) goto L16;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L11:
        if (r107.hasNext() == false) goto L15;
        Object r108 = r107.next();
        if (((com.bytedance.android.live.room.api.visibilitycontrol.d) r108).f99175m == false) goto L11;
        r106.add(r108);
        goto L11
    L15:
        r104 = CollectionsKt.toMutableList(r106);
    L16:
        Iterator r109 = r104.iterator();
    L18:
        if (r109.hasNext() == false) goto L36;
        com.bytedance.android.live.room.api.visibilitycontrol.d r112 = (com.bytedance.android.live.room.api.visibilitycontrol.d) r109.next();
        if (r112.f99174l == false) goto L21;
        if (r111 == true) goto L23;
        com.bytedance.android.live.room.api.visibilitycontrol.a r113 = r112.f99169g;     // Catch: Exception -> L30
        if ((r113 instanceof com.bytedance.android.live.room.api.visibilitycontrol.a) == false) goto L32;
        if (r113 == null) goto L29;
        boolean r114 = r113.Uh(r112.f99168f);     // Catch: Exception -> L30
    L33:
        if (r114 == true) goto L34;
        ALogger.i(this.f118554a, "dynamic check failed, skip action [" + r110 + "] for " + r112.f99168f.getDescribe());
        goto L18
    L34:
        ALogger.i(this.f118554a, "dynamic check success, start do action [" + r110 + "] for " + r112.f99168f.getDescribe());
        r101.invoke(r112);
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.visibilitycontrol.ILiveVisibilityControlFlag");     // Catch: Exception -> L30
    L32:
        r114 = true;
    L30:
        e = move-exception;
        ALogger.e(this.f118554a, "canHandleByAnnotation: " + e);
        goto L32
    L23:
        r101.invoke(r112);
        ALogger.w(this.f118554a, "skip dynamic check for " + r112.f99168f.getDescribe() + " when visible [" + r110 + ']');
        goto L18
    L21:
        ALogger.i(this.f118554a, "start do action [" + r110 + "] for " + r112.f99168f.getDescribe());
        r101.invoke(r112);
        goto L18
    }

    public final void Cq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118559f).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleAlphaViews$2(new LiveVisibilityControlWidget$handleAlphaViews$1(this, r101, r103)), r101, r102);
    }

    public final void Eq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118561h).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleBottomViews$2(new LiveVisibilityControlWidget$handleBottomViews$1(this, r101, r103)), r101, r102);
    }

    public final void Fq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118558e).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleDirectHideViews$2(new LiveVisibilityControlWidget$handleDirectHideViews$1(this, r101, r103)), r101, r102);
    }

    public final void Gq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118562i).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleLeftViews$2(new LiveVisibilityControlWidget$handleLeftViews$1(this, r101, r103)), r101, r102);
    }

    public final void Iq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118563j).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleRightViews$2(new LiveVisibilityControlWidget$handleRightViews$1(this, r101, r103)), r101, r102);
    }

    public final void Jq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r100, boolean r101, boolean r102, long r103) {
        if (((ArrayList) this.f118560g).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r100, new LiveVisibilityControlWidget$handleTopViews$2(new LiveVisibilityControlWidget$handleTopViews$1(this, r101, r103)), r101, r102);
    }

    public static final Animator Aq(LiveVisibilityControlWidget r100, View r101, float r102, float r103, long r104) {
        r100.getClass();
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, r103});
        r105.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r105.setDuration(r104);
        return r105;
    }

    public static final Animator zq(LiveVisibilityControlWidget r100, View r101, float r102, float r103, long r104) {
        r100.getClass();
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r103});
        r105.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r105.setDuration(r104);
        return r105;
    }

    public static final Animator xq(LiveVisibilityControlWidget r100, View r101, float r102, float r103, float r104, long r105) {
        r100.getClass();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.addUpdateListener(new g1(r104, r101));
        r106.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r106.setDuration(r105);
        return r106;
    }

    public static final Animator yq(LiveVisibilityControlWidget r100, View r101, float r102, float r103, float r104, long r105) {
        r100.getClass();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.addUpdateListener(new h1(r104, r101));
        r106.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r106.setDuration(r105);
        return r106;
    }
}
