package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuInputLoggerPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DanmuInputLoggerPresenter extends DanmuPanelBasePresenter {
    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final List<String> k() {
        return null;
    }

    public DanmuInputLoggerPresenter() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void g(DanmuPanelBasePresenter.IView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.g(r100);
        int r101 = pl1.a.f529750a;
        LinkedHashMap r102 = new LinkedHashMap();
        pl1.a.a(r102);
        Unit r103 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("input_comment_word_panel_show", "eventName");
        Intrinsics.checkNotNullParameter(r102, "param");
        DataCenter r104 = pl1.a.f529752c;
        if (r104 == null) goto L6;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r104).e("input_comment_word_panel_show", r102, new Object[0]);
        return;
    }
}
