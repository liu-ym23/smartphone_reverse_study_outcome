package com.bytedance.android.live.broadcastgame.opengame.performance;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.android.livesdk.utils.z1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformPerfRuntime implements z1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f60706n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f60707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f60708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f60710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f60711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f60712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f60713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f60714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f60715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f60716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f60717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f60718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f60719m;

    public static final class a {
    }

    static {
    }

    public final c a() {
        return (c) this.f60709c.getValue();
    }

    public final void d() {
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformPerfRuntime$stopUploadData$1.INSTANCE, 7);
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r100 = AnchorGameContext.a.a();
        if (r100 == null) goto L7;
        m<Boolean> r101 = r100.getOpenGamePerfUploadState();
        if (r101 == null) goto L7;
        r101.setValue(Boolean.FALSE);
    L7:
        this.f60715i = false;
        Disposable r102 = this.f60708b;
        if (r102 == null) goto L10;
        Intrinsics.checkNotNullParameter(r102, "d");
        ((CompositeDisposable) this.f60707a.getValue()).remove(r102);
    L10:
        this.f60711e = "invalid";
    }

    public final Context getContext() {
        return this.f60718l;
    }

    @Override // com.bytedance.android.livesdk.utils.z1
    public final void V1(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        ((CompositeDisposable) this.f60707a.getValue()).add(r100);
    }

    public final void c(int r100) {
        if (this.f60714h == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformPerfRuntime$stopPerfCollectAndReport$1.INSTANCE, 7);
        d();
        return;
    L8:
        if (r100 != 2) goto L10;
        c r101 = a();
        Function1<Integer, Unit> r102 = new OpenPlatformPerfRuntime$stopPerfTestBySwitch$1(this);
        Function2<Integer, Long, Unit> r103 = new OpenPlatformPerfRuntime$stopPerfTestBySwitch$2(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "onCanStop");
        Intrinsics.checkNotNullParameter(r103, "onCannotStop");
        boolean r104 = false;
        if (r101.f60726a.length() != 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L23;
    L28:
        r102.invoke(1);
        ALogger.d("OpenPlatformPerfReporter", "appId: " + r101.f60726a + " or taskId: " + r101.f60727b + " is empty!!");
        return;
    L23:
        if (r101.f60727b.length() != 0) goto L25;
        r104 = true;
    L25:
        if (r104 == true) goto L28;
        Lazy r106 = LiveOpenGameClient.f60290d;
        r101.V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).checkPerfTestStatus(r101.f60726a, r101.f60730e, r101.f60727b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r102, r103), new e(r102)));
        return;
    L20:
        r105 = false;
        goto L21
    L10:
        if (r100 != 3) goto L35;
        Disposable r107 = this.f60708b;
        if (r107 != null) goto L15;
    L16:
        d();
        a().a();
        return;
    L15:
        if (r107.isDisposed() != true) goto L16;
        return;
    }

    public OpenPlatformPerfRuntime(long r100, Context r101, c0 r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f60717k = r100;
        this.f60718l = r101;
        this.f60719m = r102;
        this.f60707a = LazyKt.lazy(OpenPlatformPerfRuntime$compositeDisposable$2.INSTANCE);
        this.f60709c = LazyKt.lazy(new OpenPlatformPerfRuntime$openPlatformPerfReporter$2(this));
        this.f60710d = LazyKt.lazy(OpenPlatformPerfRuntime$openPlatformPerfDog$2.INSTANCE);
        this.f60711e = "";
        this.f60712f = "";
        this.f60713g = "";
    }

    public final void b(boolean r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r112, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r113, "appVersion");
        boolean r100 = true;
        if (r110 == true) goto L11;
        LiveMode r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.i<LiveMode> r103 = r102.getLiveMode();
        if (r103 == null) goto L10;
        r101 = r103.getValue();
    L10:
        if (r101 == LiveMode.VIDEO) goto L11;
    L19:
        this.f60711e = r112;
        this.f60712f = r111;
        this.f60713g = r113;
        if (r110 == false) goto L52;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r114 = AnchorGameContext.a.a();
        if (r114 == null) goto L27;
        m<Boolean> r115 = r114.isLaunchFromPerfTest();
        if (r115 == null) goto L27;
        r115.setValue(Boolean.TRUE);
    L27:
        if (this.f60715i == false) goto L30;
        f2.c("性能测试中，无法重新启动性能测试", 0);
    L47:
        AnchorGameContext r116 = AnchorGameContext.a.a();
        if (r116 == null) goto L58;
        m<Boolean> r117 = r116.getOpenGamePerfPanel();
        if (r117 == null) goto L59;
        r117.setValue(Boolean.TRUE);
        return;
    L59:
        return;
    L58:
        return;
    L30:
        if (Intrinsics.areEqual(this.f60711e, "invalid") == false) goto L32;
        f2.c("当前性能测试已结束，需要重新启动扫码方可测试！", 0);
        goto L47
    L32:
        this.f60714h = false;
        this.f60715i = true;
        c r118 = a();
        String r119 = this.f60712f;
        String r120 = this.f60711e;
        String r104 = this.f60713g;
        Function0<Unit> r105 = new OpenPlatformPerfRuntime$startPerfCollectAndReport$1(this);
        Function0<Unit> r106 = new OpenPlatformPerfRuntime$startPerfCollectAndReport$2(this);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "appId");
        Intrinsics.checkNotNullParameter(r120, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "appVersion");
        Intrinsics.checkNotNullParameter(r105, "onSuccess");
        Intrinsics.checkNotNullParameter(r106, LynxVideoManagerLite.EVENT_ON_ERROR);
        r118.f60726a = r119;
        r118.f60727b = r120;
        r118.f60728c = r104;
        if (r119.length() != 0) goto L35;
        boolean r107 = true;
    L36:
        if (r107 == false) goto L38;
    L46:
        ALogger.d("OpenPlatformPerfReporter", "appId: " + r119 + " or taskId: " + r120 + " or " + r118.f60730e + " is empty!!");
        r106.invoke();
        goto L47
    L38:
        if (r118.f60727b.length() == 0) goto L41;
        r100 = false;
    L41:
        if (r100 == true) goto L46;
        if (r118.f60730e == 0) goto L46;
        Lazy r121 = LiveOpenGameClient.f60290d;
        r118.V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).runPerfTestTask(r118.f60726a, r118.f60727b, r118.f60730e, r118.f60728c).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r105), new g(r106)));
        goto L47
    L35:
        r107 = false;
        goto L36
    L52:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r122 = AnchorGameContext.a.a();
        if (r122 == null) goto L61;
        m<Boolean> r123 = r122.isLaunchFromPerfTest();
        if (r123 == null) goto L62;
        r123.setValue(Boolean.FALSE);
        return;
    L62:
        return;
    L61:
        return;
    L11:
        ((OpenPlatformPerfDog) this.f60710d.getValue()).getClass();
        Disposable r108 = OpenPlatformPerfDog.f60704o;
        if (r108 != null) goto L14;
    L15:
        Disposable r109 = OpenPlatformPerfDog.f60704o;
        if (r109 == null) goto L18;
        r109.dispose();
    L18:
        OpenPlatformPerfDog.f60704o = Observable.interval(ge0.f120274a.getValue().d(), TimeUnit.SECONDS).observeOn(Schedulers.computation()).subscribe(com.bytedance.android.live.broadcastgame.opengame.performance.a.f60724a, b.f60725a);
        goto L19
    L14:
        if (r108.isDisposed() == true) goto L18;
        goto L15
    }
}
