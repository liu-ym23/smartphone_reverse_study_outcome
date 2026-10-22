package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.xplay.singlecast.XplayGameCastAbility;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.m30;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayMainService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/android/live/broadcastgame/xplay/IXplayMainService;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayMainService implements com.bytedance.android.scope.o, IXplayMainService, Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f61933m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f61934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IXplayMainService.State f61935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<IXplayMainService.State> f61936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<c1> f61937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f61938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f61939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f61940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f61941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.xplay.p f61942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f61943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final XplayInternalContext f61944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final XplayMonitorSession f61945l;

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XplayMainService f61946a;

        public b(XplayMainService r100) {
            this.f61946a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            XplayMainService r100 = this.f61946a;
            IXplayMainService.State r101 = IXplayMainService.State.Starting;
            IXplayMainService.State r102 = r100.f61935b;
            if (r102 == r101) goto L6;
            r101 = null;
        L6:
            if (r101 != null) goto L8;
            return;
        L8:
            r100.f61938e = null;
            IXplayMainService.State r103 = IXplayMainService.State.Started;
            if (r103 == r102) goto L12;
            r100.f61935b = r103;
            r100.f61936c.onNext(r103);
        L12:
            if (this.f61946a.f61944k.getCurrentScene().getValue() != XplayScene.Video) goto L14;
            this.f61946a.d();
        L14:
            s.a(r103, null, null);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XplayMainService f61947a;

        public c(XplayMainService r100) {
            this.f61947a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            XplayMainService r102 = this.f61947a;
            r102.f61938e = r101;
            IXplayMainService.State r103 = IXplayMainService.State.StartingFailed;
            if (r103 == r102.f61935b) goto L5;
            r102.f61935b = r103;
            r102.f61936c.onNext(r103);
        L5:
            this.f61947a.f61945l.d(r101);
            Set<g10.b> r104 = s.f62349a;
            boolean r105 = r101 instanceof XplayException;
            String r106 = null;
            if (r105 == true) goto L8;
            Throwable r107 = null;
        L9:
            XplayException r108 = (XplayException) r107;
            if (r108 == null) goto L14;
            q r109 = r108.getErrorInfo();
            if (r109 == null) goto L14;
            Integer r110 = Integer.valueOf(r109.a());
        L15:
            if (r105 == true) goto L17;
            r101 = null;
        L17:
            XplayException r111 = (XplayException) r101;
            if (r111 == null) goto L22;
            q r112 = r111.getErrorInfo();
            if (r112 == null) goto L22;
            r106 = r112.b();
        L22:
            s.a(r103, r110, r106);
            return;
        L14:
            r110 = null;
            goto L15
        L8:
            r107 = r101;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayMainService
    public final void a() {
        com.bytedance.android.scope.m r100 = com.bytedance.android.scope.m.f163449e;
        com.bytedance.android.live.broadcastgame.xplay.singlecast.b r101 = (com.bytedance.android.live.broadcastgame.xplay.singlecast.b) r100.a(this.f61941h, com.bytedance.android.live.broadcastgame.xplay.singlecast.b.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (((XplayGameCastAbility) r100.d(r101, XplayGameCastAbility.class)) == null) goto L9;
        XplayGameCastAbility.c(false, null);
        return;
    }

    public final void c() {
        IXplayMainService.State r100 = this.f61935b;
        IXplayMainService.State r101 = IXplayMainService.State.Starting;
        if (r100.isAtLeast(r101) == false) goto L5;
        return;
    L5:
        XplayLog.c("XplayMainService", "starting");
        if (r101 == this.f61935b) goto L8;
        this.f61935b = r101;
        this.f61936c.onNext(r101);
    L8:
        c1 r102 = new c1();
        this.f61937d.onNext(r102);
        XplayMainService$start$1 r103 = new XplayMainService$start$1(this, r102);
        Intrinsics.checkNotNullParameter(r103, "block");
        XplayCompositeTaskBuilderScopeImpl r104 = new XplayCompositeTaskBuilderScopeImpl(XplayTasksDslKt$taskGraph$1.INSTANCE);
        r103.invoke(r104);
        RxUtilKt.c(r104.f61862c.invoke(r104, r104.f61860a).a().a().subscribe(new b(this), new c(this)), this.f61934a);
    }

    public final void d() {
        com.bytedance.android.live.broadcastgame.xplay.singlecast.d r100 = new com.bytedance.android.live.broadcastgame.xplay.singlecast.d(this.f61941h);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r100, "scope");     // Catch: Throwable -> L16
        Object r101 = e33.k.f470908a;     // Catch: Throwable -> L16
        if (r100.f62457e != r101) goto L6;
        String r102 = "newEnv";
    L12:
        if (r102 != null) goto L15;
        com.bytedance.android.scope.l.a(r100);     // Catch: Throwable -> L16
        return;
    L15:
        throw new UninitializedPropertyAccessException(r102);     // Catch: Throwable -> L16
    L6:
        if (r100.f62458f != r101) goto L9;
        r102 = "instance";
        goto L12
    L9:
        if (r100.f62459g != r101) goto L11;
        r102 = "xplayInternalContext";
        goto L12
    L11:
        r102 = null;
    L16:
        th = move-exception;
        ExceptionUtils.handleException(this.f61942i.getContext(), th);
        int r103 = XplayLog.f61931a;
        XplayLog.b("XplayMainService", "Failed to enter single cast scope: " + th);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(this.f61936c.switchMap(new m0(this)).subscribe(), this.f61934a);
        RxUtilKt.c(Observable.merge(this.f61943j.f(), q1.f62342b).subscribe(new n0(this)), this.f61934a);
        DataCenter r100 = this.f61942i.f59509i;
        if (r100 == null) goto L6;
        r100.observe("data_link_state", this);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f61934a.dispose();
        this.f61934a.clear();
        this.f61936c.onComplete();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == 872172481) goto L12;
        return;
    L12:
        if (r102.equals("data_link_state") == false) goto L49;
        Integer r103 = (Integer) r101.getData();
        if (r103 != null) goto L16;
        r103 = 0;
    L16:
        int r104 = r103.intValue();
        if (r104 != 32) goto L46;
        Disposable r105 = this.f61940g;
        if (r105 == null) goto L21;
        r105.dispose();
    L21:
        this.f61940g = null;
        int r106 = XplayLog.f61931a;
        XplayLog.c("XplayMainService", "switchToMultiCastInGaming， isEnableSeverMergeStreamForMultiLink: " + q1.e());
        com.bytedance.android.live.broadcastgame.xplay.singlecast.b r107 = (com.bytedance.android.live.broadcastgame.xplay.singlecast.b) com.bytedance.android.scope.m.f163449e.a(this.f61941h, com.bytedance.android.live.broadcastgame.xplay.singlecast.b.class);
        if (r107 == null) goto L25;
        com.bytedance.android.scope.l.c(r107);
    L25:
        if (q1.e() == false) goto L36;
        XplayGlobalServiceImpl r108 = XplayGlobalServiceImpl.f61917c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r109 = r108.n();
        if (r109 == null) goto L31;
        IXplayCoreService r110 = (IXplayCoreService) r109.getService(IXplayCoreService.class);
        if (r110 == null) goto L31;
        r110.updateEnableVideoFrame(false);
    L31:
        com.bytedance.android.live.broadcastgame.api.xplay.f r111 = r108.n();
        if (r111 == null) goto L46;
        IXplayCoreService r112 = (IXplayCoreService) r111.getService(IXplayCoreService.class);
        if (r112 == null) goto L46;
        r112.R();
        goto L46
    L36:
        XplayGlobalServiceImpl r113 = XplayGlobalServiceImpl.f61917c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r114 = r113.n();
        if (r114 == null) goto L41;
        IXplayCoreService r115 = (IXplayCoreService) r114.getService(IXplayCoreService.class);
        if (r115 == null) goto L41;
        r115.updateEnableVideoFrame(true);
    L41:
        com.bytedance.android.live.broadcastgame.api.xplay.f r116 = r113.n();
        if (r116 == null) goto L46;
        IXplayCoreService r117 = (IXplayCoreService) r116.getService(IXplayCoreService.class);
        if (r117 == null) goto L46;
        r117.R();
    L46:
        if (r104 != 0) goto L50;
        Disposable r118 = Observable.timer(500, TimeUnit.MILLISECONDS).subscribe(new h0(this));
        RxUtilKt.c(r118, this.f61934a);
        this.f61940g = r118;
        return;
    L50:
        return;
    L49:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public XplayMainService(g1 r100, com.bytedance.android.live.broadcastgame.api.xplay.p r101, e r102, XplayInternalContext r103, XplayMonitorSession r104) {
        Intrinsics.checkNotNullParameter(r100, "xplayScope");
        Intrinsics.checkNotNullParameter(r101, "newEnv");
        Intrinsics.checkNotNullParameter(r102, "xplayPanelService");
        Intrinsics.checkNotNullParameter(r103, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r104, "monitorSession");
        this.f61941h = r100;
        this.f61942i = r101;
        this.f61943j = r102;
        this.f61944k = r103;
        this.f61945l = r104;
        this.f61934a = new CompositeDisposable();
        this.f61935b = IXplayMainService.State.Uninitialized;
        this.f61936c = PublishSubject.create();
        this.f61937d = PublishSubject.create();
        if (m30.f120729a.getValue().booleanValue() == true) goto L5;
    L7:
        boolean r105 = false;
    L8:
        this.f61939f = r105;
        return;
    L5:
        if (r103.getCurrentScene().getValue() == XplayScene.RevenueLink) goto L7;
        r105 = true;
        goto L8
    }
}
