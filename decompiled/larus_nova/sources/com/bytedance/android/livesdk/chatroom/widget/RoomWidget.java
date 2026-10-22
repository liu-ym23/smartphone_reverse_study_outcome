package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/g0;", "<init>", "()V", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomWidget extends LiveWidget implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoomContext f118688a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public final void onMergeLoad() {
        super.onMergeLoad();
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L22;
        RoomContext r100 = this.f118688a;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.n<Boolean> r101 = r100.isRoomVisible();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
    L10:
        if (r102 == null) goto L12;
        r102.booleanValue();
    L12:
        RoomContext r103 = this.f118688a;
        if (r103 == null) goto L23;
        com.bytedance.live.datacontext.n<Boolean> r104 = r103.isRoomVisible();
        if (r104 == null) goto L24;
        Observable<sh6.b<Boolean>> r105 = r104.a();
        if (r105 == null) goto L25;
        ObservableSubscribeProxy r106 = (ObservableSubscribeProxy) r105.as(autoDispose());
        if (r106 == null) goto L26;
        r106.subscribe(new j2(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L9:
        r102 = null;
        goto L10
    }

    public RoomWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.g0
    public final void setRoomContext(RoomContext r100) {
        this.f118688a = r100;
    }
}
