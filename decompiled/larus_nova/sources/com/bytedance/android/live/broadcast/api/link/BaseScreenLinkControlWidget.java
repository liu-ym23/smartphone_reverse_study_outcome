package com.bytedance.android.live.broadcast.api.link;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.liveinteract.api.ILinkControlWidget;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/link/BaseScreenLinkControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/liveinteract/api/ILinkControlWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseScreenLinkControlWidget extends LiveWidget implements ILinkControlWidget {

    public interface a {
    }

    @Override // kf1.a
    public final String tag() {
        return "BaseScreenLinkControlWidget";
    }

    public BaseScreenLinkControlWidget() {
    }

    @Override // kf1.a
    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
