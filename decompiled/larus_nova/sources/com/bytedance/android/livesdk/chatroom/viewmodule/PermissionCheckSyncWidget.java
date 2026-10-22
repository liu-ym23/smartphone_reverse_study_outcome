package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.zh;
import com.bytedance.android.livesdk.wrds.syncdata.PermissionCheckTriggerSyncModel;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/PermissionCheckSyncWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionCheckSyncWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f115023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f115024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f115025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f115026d;

    public static final class a implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f115027a = null;

        static {
            f115027a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionCheckSyncWidget f115028a;

        public b(PermissionCheckSyncWidget r100) {
            this.f115028a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dc2.c.b r101 = (dc2.c.b) r100;
            PermissionCheckSyncWidget r102 = this.f115028a;
            if (r101 == null) goto L5;
            zh r103 = (zh) r101.f467859b;
        L6:
            r102.getClass();
            if (r103 != null) goto L10;
            return;
        L10:
            if (r103.b() < 1) goto L13;
            r102.f115026d = r103.b();
            r102.f115025c.postDelayed(new p2(r102), Random.Default.nextLong(r103.a() * 1000));
            return;
        L13:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public PermissionCheckSyncWidget() {
        this.f115023a = new CompositeDisposable();
        this.f115024b = new CompositeDisposable();
        this.f115025c = new WeakHandler(Looper.getMainLooper(), a.f115027a);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f115025c.removeCallbacksAndMessages(null);
        this.f115023a.clear();
        this.f115024b.clear();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        RoomContext r101 = getDataContext();
        if (r101 != null) goto L5;
        r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        PermissionCheckTriggerSyncModel r102 = (PermissionCheckTriggerSyncModel) dc2.b.a(com.bytedance.android.livesdk.chatroom.utils.n3.g(r101), PermissionCheckSyncWidget$onLoad$1$roomDataSyncModel$1.INSTANCE);
        this.f115023a.add(r102.getPermissionCheckTriggerSyncData().b().subscribe(new b(this)));
    }
}
