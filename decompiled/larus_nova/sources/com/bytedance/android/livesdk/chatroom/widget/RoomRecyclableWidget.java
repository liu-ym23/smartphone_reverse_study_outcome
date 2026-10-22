package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\fJ\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038D@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/g0;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "dataContext", "", "setRoomContext", "handleRoomVisible", "Ljava/lang/Runnable;", "runnable", "runWithRoomVisible", "Lh80/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "consumer", "runWithRoomEntered", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "runWithRoomPreload", "", "isVisible", "onRoomVisible", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getDataContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "setDataContext", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;)V", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomRecyclableWidget extends LiveRecyclableWidget implements g0 {
    private RoomContext dataContext;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomRecyclableWidget f118683a;

        public a(RoomRecyclableWidget r100) {
            this.f118683a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L6;
            boolean r102 = r101.booleanValue();
            this.f118683a.onRoomVisible(r102);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h80.a f118684a;

        public b(h80.a r100) {
            this.f118684a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f118684a.accept(sh6.c.b((sh6.b) r100));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h80.a f118685a;

        public c(h80.a r100) {
            this.f118685a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f118685a.accept(sh6.c.b((sh6.b) r100));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomRecyclableWidget f118686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f118687b;

        public d(RoomRecyclableWidget r100, Runnable r101) {
            this.f118686a = r100;
            this.f118687b = r101;
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
            this.f118687b.run();
            return;
        L12:
            if (r103.getPostVisibleTask() != true) goto L33;
            RoomContext r104 = this.f118686a.getRoomContext();
            if (r104 == null) goto L18;
            com.bytedance.live.datacontext.n<Boolean> r105 = r104.isPostTask();
            if (r105 == null) goto L18;
            Boolean r106 = r105.getValue();
        L20:
            if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L33;
            DataCenter r107 = this.f118686a.dataCenter;
            if (r107 == null) goto L32;
            IRoomPreloadTaskManager r108 = (IRoomPreloadTaskManager) r107.get("data_preload_task_manager", null);
            if (r108 == null) goto L32;
            Runnable r109 = this.f118687b;
            PreloadOpt r110 = r102.getPreloadOpt();
            if (r110 == null) goto L30;
            Long r111 = r110.getPostRoomInnerTaskDelayTime();
            if (r111 == null) goto L30;
            long r112 = r111.longValue();
        L31:
            r108.postTask(r109, r112, this.f118686a.getClass().getSimpleName());
            return;
        L30:
            r112 = 0;
        L32:
            this.f118687b.run();
            return;
        L18:
            r106 = null;
            goto L20
        }
    }

    public void onRoomVisible(boolean r100) {
    }

    public final RoomContext getDataContext() {
        if (this.dataContext != null) goto L13;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.get("data_current_is_preview", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
        return RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
    L7:
        r101 = null;
    L13:
        return this.dataContext;
    }

    public RoomContext getRoomContext() {
        return getDataContext();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void handleRoomVisible() {
        super.handleRoomVisible();
        RoomContext r100 = getRoomContext();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r101 = r100.isRoomVisible();
        if (r101 == null) goto L7;
        Boolean r102 = r101.getValue();
    L8:
        if (r102 == null) goto L10;
        onRoomVisible(r102.booleanValue());
    L10:
        RoomContext r103 = getRoomContext();
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

    public RoomRecyclableWidget() {
    }

    public final void runWithRoomEntered(h80.a<Room> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L5;
        Boolean r102 = (Boolean) r101.get("data_current_is_preview", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L9;
        setRoomContext(RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2));
    L9:
        RoomContext r103 = getDataContext();
        if (r103 != null) goto L12;
        return;
    L12:
        Room r104 = r103.getInteractionDataPrepared().getValue();
        if (r104 == null) goto L15;
        r100.accept(r104);
        return;
    L15:
        ((ObservableSubscribeProxy) r103.getInteractionDataPrepared().a().as(autoDispose())).subscribe(new b(r100));
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void runWithRoomPreload(h80.a<IRoom> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L35;
        DataCenter r101 = this.dataCenter;
        IRoom r102 = null;
        if (r101 == null) goto L7;
        Boolean r103 = (Boolean) r101.get("data_current_is_preview", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L11;
        setRoomContext(RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2));
    L11:
        RoomContext r104 = getDataContext();
        if (r104 != null) goto L14;
        return;
    L14:
        com.bytedance.live.datacontext.n<IRoom> r105 = r104.getPreloadRoom();
        if (r105 == null) goto L17;
        IRoom r106 = r105.getValue();
    L18:
        RoomContext r107 = getDataContext();
        if (r107 == null) goto L23;
        com.bytedance.live.datacontext.n<IRoom> r108 = r107.getFullRoom();
        if (r108 == null) goto L23;
        r102 = r108.getValue();
    L23:
        if (r102 == null) goto L25;
        return;
    L25:
        if (r106 == null) goto L27;
        r100.accept(r106);
        return;
    L27:
        com.bytedance.live.datacontext.n<IRoom> r109 = r104.getPreloadRoom();
        if (r109 == null) goto L37;
        Observable<sh6.b<IRoom>> r110 = r109.a();
        if (r110 == null) goto L38;
        ObservableSubscribeProxy r111 = (ObservableSubscribeProxy) r110.as(autoDispose());
        if (r111 == null) goto L39;
        r111.subscribe(new c(r100));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L17:
        r106 = null;
        goto L18
    L7:
        r103 = null;
        goto L9
    }

    public final void runWithRoomVisible(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L25;
        RoomContext r101 = getRoomContext();
        Boolean r102 = null;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.n<Boolean> r103 = r101.isRoomVisible();
        if (r103 == null) goto L9;
        Boolean r104 = r103.getValue();
    L10:
        if (r104 != null) goto L12;
    L16:
        RoomContext r105 = getRoomContext();
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

    public final void setDataContext(RoomContext r100) {
        this.dataContext = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.g0
    public void setRoomContext(RoomContext r100) {
        this.dataContext = r100;
    }
}
