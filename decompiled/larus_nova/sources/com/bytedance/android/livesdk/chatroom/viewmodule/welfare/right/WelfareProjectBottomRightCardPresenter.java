package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public final class WelfareProjectBottomRightCardPresenter extends n<IView> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareProjectBottomRightCardPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    public WelfareProjectBottomRightCardPresenter() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        super.detachView();
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final void c0(IWidget r100) {
        super.c0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
    }
}
