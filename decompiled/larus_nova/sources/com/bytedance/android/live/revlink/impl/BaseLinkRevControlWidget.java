package com.bytedance.android.live.revlink.impl;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.liveinteract.api.ILinkControlWidget;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/BaseLinkRevControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/liveinteract/api/ILinkControlWidget;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseLinkRevControlWidget extends LiveWidget implements ILinkControlWidget {
    @Override // kf1.a
    public String tag() {
        return "BaseLinkRevControlWidget";
    }

    public BaseLinkRevControlWidget() {
    }

    @Override // kf1.a
    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
