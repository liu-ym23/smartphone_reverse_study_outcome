package com.bytedance.android.livesdk.feedback;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.feedback.service.d;
import com.bytedance.android.livesdk.feedback.service.e;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/LiveRoomFeedbackWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomFeedbackWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f124626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.feedback.room.a f124627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILiveRoomPlayFragment.LiveRoomListener f124628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f124629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoomSession f124630e;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Iterator r100 = ((List) this.f124629d.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        d r101 = (d) r100.next();
        e r102 = r101.a();
        if (r102 == null) goto L8;
        r102.reset();
    L8:
        r101.onLeaveRoom();
        goto L4
    L9:
        Disposable r103 = this.f124626a;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        this.f124626a = null;
        this.f124628c = null;
    }

    public final void wq() {
        Pair r100 = com.bytedance.live.datacontext.d.a(LiveRoomFeedbackWidget$onStartRoom$1.INSTANCE);
        com.bytedance.live.datacontext.d.c((DataContext) r100.getFirst(), RoomFeedbackContext.TAG);
        this.f124627b = (com.bytedance.android.livesdk.feedback.room.a) r100.getFirst();
        this.f124626a = (Disposable) r100.getSecond();
        com.bytedance.android.livesdk.feedback.room.a r101 = this.f124627b;
        if (r101 == null) goto L7;
        ILiveRoomPlayFragment.LiveRoomListener r102 = this.f124628c;
        if (r102 == null) goto L7;
        r101.updateRoomListener(r102);
    L7:
        Iterator r103 = ((List) this.f124629d.getValue()).iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        d r104 = (d) r103.next();
        r104.c();
        e r105 = r104.a();
        if (r105 == null) goto L9;
        r105.startFeedbackObserve();
        goto L9
    }

    public LiveRoomFeedbackWidget(RoomSession r100) {
        Intrinsics.checkNotNullParameter(r100, "roomSession");
        this.f124630e = r100;
        this.f124629d = LazyKt.lazy(new LiveRoomFeedbackWidget$mFeedbackConfigs$2(this));
    }
}
