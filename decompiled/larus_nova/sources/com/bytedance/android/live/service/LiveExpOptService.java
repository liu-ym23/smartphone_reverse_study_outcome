package com.bytedance.android.live.service;

import com.bytedance.android.live.LiveExpPushHelper;
import com.bytedance.android.live.context.LiveExpRoomContext;
import com.bytedance.android.live.context.NewExpContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.observer.ExpBizPerfObserver;
import com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.tetris.c;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.EventVerify;
import d90.d;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import j70.h;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\b\b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0082\bJ\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001aH\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u001a\u0010&\u001a\u00020%2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R#\u00106\u001a\n 1*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/service/LiveExpOptService;", "Lcom/bytedance/android/live/room/api/experience/service/ILiveExpOptService;", "Lkotlin/Function1;", "Ld61/b;", "", "action", "", "useExpContext", "Lj70/h;", "Ld90/d;", "getExpPushTetrisDesc", "", "tag", EventVerify.TYPE_LAUNCH, "stop", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRoomExpContext", "Le61/a;", "dispatcher", "Ln61/c;", "source", "processSource", "Lj61/b;", "result", "handleResult", "Ll61/b;", "scene", "Lg61/a;", "listener", "Lio/reactivex/disposables/Disposable;", "registerExpBizListener", "unregisterExpBizListener", "showExpOptDialog", "Ll61/c;", "getSceneState", "", BasicTestActionHandler.TEST_ACTION_RESET, "shouldResetPerfBySwitchClose", "checkResetPerfWhenRoomExit", "showWIFISwitch4GPush", "Lcom/bytedance/android/live/context/NewExpContext;", "newExpCtx", "Lcom/bytedance/android/live/context/NewExpContext;", "consumeStatusDp", "Lio/reactivex/disposables/Disposable;", "kotlin.jvm.PlatformType", "enableSampleRoomConfig$delegate", "Lkotlin/Lazy;", "getEnableSampleRoomConfig", "()Ljava/lang/Boolean;", "enableSampleRoomConfig", "getExpCtx", "()Ld61/b;", "expCtx", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveExpOptService implements ILiveExpOptService {
    private Disposable consumeStatusDp;
    private final Lazy enableSampleRoomConfig$delegate;
    private NewExpContext newExpCtx;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f100852a;

        public a(Ref.ObjectRef r100) {
            this.f100852a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Function0 r100 = (Function0) this.f100852a.element;
            if (r100 == null) goto L6;
            Unit r101 = (Unit) r100.invoke();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f100853a;

        public b(long r100) {
            this.f100853a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r100 = LiveExpPushHelper.f58519a;     // Catch: Throwable -> L4
            LiveExpPushHelper.c(String.valueOf(this.f100853a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final Boolean getEnableSampleRoomConfig() {
        return (Boolean) this.enableSampleRoomConfig$delegate.getValue();
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void checkResetPerfWhenRoomExit() {
        NewExpContext r100 = this.newExpCtx;
        if (r100 == null) goto L6;
        r100.checkResetPerfWhenRoomExit();
        return;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public h<? extends d> getExpPushTetrisDesc() {
        return new c();
    }

    public LiveExpOptService() {
        k.l(ILiveExpOptService.class, this);
        k.l(ILiveExpMiddlewareService.class, this);
        this.enableSampleRoomConfig$delegate = LazyKt.lazy(LiveExpOptService$enableSampleRoomConfig$2.INSTANCE);
    }

    private final d61.b getExpCtx() {
        if (PlatformExpUtils.b() == true) goto L7;
        LiveExpRoomContext.Companion.getClass();
        return LiveExpRoomContext.Companion.a();
    L7:
        return this.newExpCtx;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public e61.a dispatcher() {
        d61.b r100 = getExpCtx();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDispatch();
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void showExpOptDialog() {
        xs2.b.a().post(new h61.a());
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void showWIFISwitch4GPush() {
        o r100 = o3.f();
        if (r100 == null) goto L10;
        m<IRoom> r101 = r100.getRoom();
        if (r101 == null) goto L11;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L12;
        i0.h(new b(r102.getRoomId()));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final /* synthetic */ NewExpContext access$getNewExpCtx$p(LiveExpOptService r100) {
        return r100.newExpCtx;
    }

    private final Object useExpContext(Function1<? super d61.b, Unit> r100) {
        if (PlatformExpUtils.b() == false) goto L8;
        NewExpContext r101 = access$getNewExpCtx$p(this);
        if (r101 == null) goto L7;
        r100.invoke(r101);
        return r101;
    L7:
        return null;
    L8:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r100);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void handleResult(final j61.b<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Function1<d61.b, Unit> r101 = new AnonymousClass1(r100);
        if (PlatformExpUtils.b() == false) goto L7;
        NewExpContext r102 = access$getNewExpCtx$p(this);
        if (r102 == null) goto L9;
        r101.invoke(r102);
        return;
    L9:
        return;
    L7:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r101);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void launch(int r100) {
        ALogger.i("LiveExpOptLog", "LiveExpOptService#launch, tag:" + r100);
        Disposable r101 = this.consumeStatusDp;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Lazy r102 = PlatformExpUtils.f98909a;
        if (PlatformExpUtils.f98911c == false) goto L8;
        Disposable r103 = Disposables.empty();
    L9:
        this.consumeStatusDp = r103;
        NewExpContext r104 = this.newExpCtx;
        if (r104 == null) goto L12;
        r104.release();
    L12:
        NewExpContext r105 = new NewExpContext(r100);
        r105.startWork();
        Unit r106 = Unit.INSTANCE;
        this.newExpCtx = r105;
        return;
    L8:
        r103 = RxUtilKt.h(Observable.create(com.bytedance.android.live.room.api.experience.utils.b.f98914a)).subscribe(com.bytedance.android.live.room.api.experience.utils.c.f98915a);
        goto L9
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void processSource(final n61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Function1<d61.b, Unit> r101 = new C99621(r100);
        if (PlatformExpUtils.b() == false) goto L7;
        NewExpContext r102 = access$getNewExpCtx$p(this);
        if (r102 == null) goto L9;
        r101.invoke(r102);
        return;
    L9:
        return;
    L7:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r101);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void shouldResetPerfBySwitchClose(boolean r100) {
        NewExpContext r101 = this.newExpCtx;
        if (r101 == null) goto L6;
        r101.shouldResetPerfBySwitchClose(r100);
        return;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void stop(int r100) {
        ALogger.i("LiveExpOptLog", "LiveExpOptService#stop, tag:" + r100);
        Disposable r101 = this.consumeStatusDp;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        NewExpContext r102 = this.newExpCtx;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getRoomFragmentTag() != r100) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L18;
        r102.release();
        return;
    L18:
        return;
    L10:
        r103 = false;
        goto L11
    }

    public static final /* synthetic */ void access$setNewExpCtx$p(LiveExpOptService r100, NewExpContext r101) {
        r100.newExpCtx = r101;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public l61.c getSceneState(DataCenter r100, l61.b r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        boolean r102 = false;
        if (r100 == null) goto L9;
        if (z.e(r100, false) != true) goto L9;
        l61.c.f507590a.getClass();
        return l61.c.a.f507591a;
    L9:
        if (TopSpeedModeUtils.a() == false) goto L17;
        ILiveTopSpeedExpService r103 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r103 == null) goto L13;
        r102 = r103.isDegradingForScene(r101);
    L13:
        if (r102 == false) goto L15;
        l61.a r104 = new l61.a();
        r104.f507589b = true;
        return r104;
    L15:
        l61.c.f507590a.getClass();
        return l61.c.a.f507591a;
    L17:
        k61.a r105 = o61.a.f522155b;
        if (r105 == null) goto L21;
        ExpBizPerfObserver r106 = new ExpBizPerfObserver(r101, null);
        r106.b(r105);
        l61.a r107 = new l61.a();
        r107.f507589b = r106.f83949a;
        return r107;
    L21:
        l61.c.f507590a.getClass();
        return l61.c.a.f507591a;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpOptService
    public DataContext initRoomExpContext(DataCenter r100, MiddlewareRoomContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        LiveExpRoomContext r102 = new LiveExpRoomContext(r100, r101);
        r102.startWork();
        return r102;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public Disposable registerExpBizListener(final l61.b r100, final g61.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "listener");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        if (TopSpeedModeUtils.a() == false) goto L7;
        ILiveTopSpeedExpService r103 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r103 == null) goto L14;
        r103.registerExpBizListener(r100, r101);
    L14:
        return Disposables.fromAction(new a(r102));
    L7:
        Function1<d61.b, Unit> r104 = new C99631(r100, r101, r102);
        if (PlatformExpUtils.b() == false) goto L12;
        NewExpContext r105 = access$getNewExpCtx$p(this);
        if (r105 == null) goto L14;
        r104.invoke(r105);
        goto L14
    L12:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r104);
        goto L14
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveExpMiddlewareService
    public void unregisterExpBizListener(final l61.b r100, final g61.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (TopSpeedModeUtils.a() == false) goto L7;
        ILiveTopSpeedExpService r102 = (ILiveTopSpeedExpService) k.f(ILiveTopSpeedExpService.class);
        if (r102 == null) goto L14;
        r102.unregisterExpBizListener(r100, r101);
        return;
    L14:
        return;
    L7:
        Function1<d61.b, Unit> r103 = new C99641(r100, r101);
        if (PlatformExpUtils.b() == false) goto L12;
        NewExpContext r104 = access$getNewExpCtx$p(this);
        if (r104 == null) goto L16;
        r103.invoke(r104);
        return;
    L16:
        return;
    L12:
        LiveExpRoomContext.Companion.getClass();
        LiveExpRoomContext.Companion.b(r103);
    }
}
