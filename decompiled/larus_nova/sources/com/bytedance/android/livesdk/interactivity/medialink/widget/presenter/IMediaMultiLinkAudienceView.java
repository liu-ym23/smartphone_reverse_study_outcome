package com.bytedance.android.livesdk.interactivity.medialink.widget.presenter;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAudienceView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMediaMultiLinkAudienceView extends IWidget {
    void R6(String r100, boolean r101);

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    /* synthetic */ Context getContext();

    void pA(String r100, boolean r101);
}
