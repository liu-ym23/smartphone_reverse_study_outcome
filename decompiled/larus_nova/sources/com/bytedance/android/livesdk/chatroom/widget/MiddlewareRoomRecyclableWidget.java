package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/h0;", "Lcom/bytedance/live/datacontext/DataContext;", "getRoomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getMiddlewareRoomContext", "roomContext", "", "setRoomContext", "Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "getRoomContextService", "handleRoomVisible", "Ljava/lang/Runnable;", "runnable", "runWithRoomVisible", "Lh80/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "consumer", "runWithRoomEntered", "runWithRoomPreload", "", "isVisible", "onRoomVisible", "dataContext", "Lcom/bytedance/live/datacontext/DataContext;", "dataService", "Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "getDataService", "()Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;", "setDataService", "(Lcom/bytedance/android/livesdk/chatroom/IRoomContextService;)V", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiddlewareRoomRecyclableWidget extends LiveRecyclableWidget implements h0 {
    protected DataContext dataContext;
    private IRoomContextService dataService;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiddlewareRoomRecyclableWidget f118587a;

        public a(MiddlewareRoomRecyclableWidget r100) {
            this.f118587a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L6;
            boolean r102 = r101.booleanValue();
            this.f118587a.onRoomVisible(r102);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h80.a f118588a;

        public b(h80.a r100) {
            this.f118588a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f118588a.accept(sh6.c.b((sh6.b) r100));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h80.a f118589a;

        public c(h80.a r100) {
            this.f118589a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f118589a.accept(sh6.c.b((sh6.b) r100));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiddlewareRoomRecyclableWidget f118590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f118591b;

        public d(MiddlewareRoomRecyclableWidget r100, Runnable r101) {
            this.f118590a = r100;
            this.f118591b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) sh6.c.b((sh6.b) r100);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == true) goto L8;
            r101 = null;
        L8:
            if (r101 == null) goto L36;
            r101.booleanValue();
            MultiRoomConfig r102 = MultiRoomConfig.INSTANCE;
            PreloadOpt r103 = r102.getPreloadOpt();
            if (r103 != null) goto L12;
        L33:
            this.f118591b.run();
            return;
        L12:
            if (r103.getPostVisibleTask() != true) goto L33;
            MiddlewareRoomContext r104 = this.f118590a.getMiddlewareRoomContext();
            if (r104 == null) goto L18;
            com.bytedance.live.datacontext.n<Boolean> r105 = r104.isPostTask();
            if (r105 == null) goto L18;
            Boolean r106 = r105.getValue();
        L20:
            if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L33;
            DataCenter r107 = this.f118590a.dataCenter;
            if (r107 == null) goto L32;
            IRoomPreloadTaskManager r108 = (IRoomPreloadTaskManager) r107.get("data_preload_task_manager", null);
            if (r108 == null) goto L32;
            Runnable r109 = this.f118591b;
            PreloadOpt r110 = r102.getPreloadOpt();
            if (r110 == null) goto L30;
            Long r111 = r110.getPostRoomInnerTaskDelayTime();
            if (r111 == null) goto L30;
            long r112 = r111.longValue();
        L31:
            r108.postTask(r109, r112, this.f118590a.getClass().getSimpleName());
            return;
        L30:
            r112 = 0;
        L32:
            this.f118591b.run();
            return;
        L18:
            r106 = null;
            goto L20
        }
    }

    public void onRoomVisible(boolean r100) {
    }

    public MiddlewareRoomContext getMiddlewareRoomContext() {
        DataContext r100 = this.dataContext;
        if ((r100 instanceof MiddlewareRoomContext) == true) goto L6;
        r100 = null;
    L6:
        return (MiddlewareRoomContext) r100;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void handleRoomVisible() {
        MiddlewareRoomContext r100 = getMiddlewareRoomContext();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r101 = r100.isRoomVisible();
        if (r101 == null) goto L7;
        Boolean r102 = r101.getValue();
    L8:
        if (r102 == null) goto L10;
        onRoomVisible(r102.booleanValue());
    L10:
        MiddlewareRoomContext r103 = getMiddlewareRoomContext();
        if (r103 == null) goto L20;
        com.bytedance.live.datacontext.n<Boolean> r104 = r103.isRoomVisible();
        if (r104 == null) goto L21;
        Observable<sh6.b<Boolean>> r105 = r104.a();
        if (r105 == null) goto L22;
        ObservableSubscribeProxy r106 = (ObservableSubscribeProxy) r105.as(autoDispose());
        if (r106 == null) goto L23;
        r106.subscribe(new a(this));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public MiddlewareRoomRecyclableWidget() {
    }

    public final IRoomContextService getDataService() {
        return this.dataService;
    }

    public DataContext getRoomContext() {
        return this.dataContext;
    }

    public IRoomContextService getRoomContextService() {
        return this.dataService;
    }

    public final void runWithRoomEntered(h80.a<IRoom> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        DataContext r101 = this.dataContext;
        if (r101 != null) goto L5;
        return;
    L5:
        IRoomContextService r102 = this.dataService;
        if (r102 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r103 = r102.getRoomDataContext(r101);
        if (r103 == null) goto L12;
        com.bytedance.live.datacontext.n<IRoom> r104 = r103.getInteractionDataPrepared();
        if (r104 == null) goto L12;
        IRoom r105 = r104.getValue();
    L13:
        if (r105 == null) goto L15;
        r100.accept(r105);
        return;
    L15:
        IRoomContextService r106 = this.dataService;
        if (r106 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.o r107 = r106.getRoomDataContext(r101);
        if (r107 == null) goto L29;
        com.bytedance.live.datacontext.n<IRoom> r108 = r107.getInteractionDataPrepared();
        if (r108 == null) goto L30;
        Observable<sh6.b<IRoom>> r109 = r108.a();
        if (r109 == null) goto L31;
        ObservableSubscribeProxy r110 = (ObservableSubscribeProxy) r109.as(autoDispose());
        if (r110 == null) goto L32;
        r110.subscribe(new b(r100));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L12:
        r105 = null;
        goto L13
    }

    public final void runWithRoomPreload(h80.a<IRoom> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
        return;
    L5:
        if (getMiddlewareRoomContext() != null) goto L7;
        return;
    L7:
        MiddlewareRoomContext r101 = getMiddlewareRoomContext();
        IRoom r102 = null;
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.n<IRoom> r103 = r101.getPreloadRoom();
        if (r103 == null) goto L12;
        IRoom r104 = r103.getValue();
    L13:
        MiddlewareRoomContext r105 = getMiddlewareRoomContext();
        if (r105 == null) goto L18;
        com.bytedance.live.datacontext.n<IRoom> r106 = r105.getFullRoom();
        if (r106 == null) goto L18;
        r102 = r106.getValue();
    L18:
        if (r102 == null) goto L20;
        return;
    L20:
        if (r104 == null) goto L22;
        r100.accept(r104);
        return;
    L22:
        MiddlewareRoomContext r107 = getMiddlewareRoomContext();
        if (r107 == null) goto L34;
        com.bytedance.live.datacontext.n<IRoom> r108 = r107.getPreloadRoom();
        if (r108 == null) goto L35;
        Observable<sh6.b<IRoom>> r109 = r108.a();
        if (r109 == null) goto L36;
        ObservableSubscribeProxy r110 = (ObservableSubscribeProxy) r109.as(autoDispose());
        if (r110 == null) goto L37;
        r110.subscribe(new c(r100));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L12:
        r104 = null;
        goto L13
    }

    public final void runWithRoomVisible(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L25;
        MiddlewareRoomContext r101 = getMiddlewareRoomContext();
        Boolean r102 = null;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.n<Boolean> r103 = r101.isRoomVisible();
        if (r103 == null) goto L9;
        Boolean r104 = r103.getValue();
    L10:
        if (r104 != null) goto L12;
    L16:
        MiddlewareRoomContext r105 = getMiddlewareRoomContext();
        if (r105 == null) goto L27;
        com.bytedance.live.datacontext.n<Boolean> r106 = r105.isRoomVisible();
        if (r106 == null) goto L28;
        Observable<sh6.b<Boolean>> r107 = r106.a();
        if (r107 == null) goto L29;
        ObservableSubscribeProxy r108 = (ObservableSubscribeProxy) r107.as(autoDispose());
        if (r108 == null) goto L30;
        r108.subscribe(new d(this, r100));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L12:
        if (r104.booleanValue() == false) goto L14;
        r102 = r104;
    L14:
        if (r102 == null) goto L16;
        r102.booleanValue();
        r100.run();
    L9:
        r104 = null;
        goto L10
    L25:
        r100.run();
    }

    public final void setDataService(IRoomContextService r100) {
        this.dataService = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.h0
    public void setRoomContext(MiddlewareRoomContext r100) {
        this.dataContext = r100;
        this.dataService = (IRoomContextService) jc1.k.f(IRoomContextService.class);
    }
}
