package com.bytedance.android.livesdk.castscreen.views;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.f;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/CastDanmakuServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastDanmakuServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f104741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f104742b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CastDanmakuServiceWidget f104743a;

        public a(CastDanmakuServiceWidget r100) {
            this.f104743a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CastDanmakuServiceWidget.wq(this.f104743a, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CastDanmakuServiceWidget f104744a;

        public b(CastDanmakuServiceWidget r100) {
            this.f104744a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CastDanmakuServiceWidget.wq(this.f104744a, ((Boolean) r100).booleanValue());
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        a r100 = this.f104742b;
        if (r100 == null) goto L5;
        MainThreadPostUtils.d(r100);
    L5:
        this.f104742b = null;
        CompositeDisposable r101 = this.f104741a;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f104741a = null;
    }

    public CastDanmakuServiceWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f104742b = new a(this);
        this.f104741a = new CompositeDisposable();
        MiddlewareRoomContext.a r101 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r102 = MiddlewareRoomContext.a.c(r101, this.dataCenter, 0, 2);
        if (r102 == null) goto L9;
        m<Boolean> r103 = r102.isInExtendedCastMode();
        if (r103 == null) goto L9;
        if (r103.getValue().booleanValue() != true) goto L9;
        MainThreadPostUtils.c(this.f104742b, 500);
    L9:
        MiddlewareRoomContext r104 = MiddlewareRoomContext.a.c(r101, this.dataCenter, 0, 2);
        if (r104 == null) goto L21;
        m<Boolean> r105 = r104.isInExtendedCastMode();
        if (r105 == null) goto L22;
        Observable<Boolean> r106 = r105.a();
        if (r106 == null) goto L23;
        Disposable r107 = r106.subscribe(new b(this));
        if (r107 == null) goto L24;
        CompositeDisposable r108 = this.f104741a;
        if (r108 == null) goto L25;
        r108.add(r107);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public static final void wq(CastDanmakuServiceWidget r100, boolean r101) {
        if (r101 == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r102 = ho1.a.c(r100.getComponentContext());
        if (r102 == null) goto L10;
        r102.Og(f.f112980m1);
        return;
    L10:
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r103 = ho1.a.c(r100.getComponentContext());
        if (r103 == null) goto L12;
        r103.vi(f.f112980m1);
        return;
    }
}
