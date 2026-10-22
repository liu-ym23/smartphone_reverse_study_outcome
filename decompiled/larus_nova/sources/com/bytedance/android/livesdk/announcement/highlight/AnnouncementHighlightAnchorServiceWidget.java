package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/highlight/AnnouncementHighlightAnchorServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementHighlightAnchorServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f103420a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f103420a.clear();
    }

    public AnnouncementHighlightAnchorServiceWidget() {
        this.f103420a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        o32.a.a("autoPublishAnnouncementIfNeeded");
        RxUtilKt.c(AnnouncementApi.CC.getAnnouncementInfoListV2$default((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class), 0, 0, 3, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), new e(this)), this.f103420a);
    }
}
