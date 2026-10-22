package com.bytedance.android.live.liveinteract.review;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewPresenter$IView;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicReviewWidget extends MiddlewareRoomWidget implements LinkmicReviewPresenter.IView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkmicReviewPresenter f78594a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        LinkmicReviewPresenter r100 = new LinkmicReviewPresenter();
        this.f78594a = r100;
        r100.g0(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        LinkmicReviewPresenter r100 = this.f78594a;
        if (r100 == null) goto L6;
        r100.detachView();
        return;
    }

    public LinkmicReviewWidget() {
    }
}
