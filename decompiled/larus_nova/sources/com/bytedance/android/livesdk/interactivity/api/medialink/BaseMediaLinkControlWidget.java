package com.bytedance.android.livesdk.interactivity.api.medialink;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.liveinteract.api.ILinkControlWidget;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import x32.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lcom/bytedance/android/live/liveinteract/api/ILinkControlWidget;", "Lx32/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMediaLinkControlWidget extends RoomWidget implements ILinkControlWidget, x32.a {

    public interface a {
        void a(LiveWidget r100);

        Widget b(b r100);
    }

    @Override // x32.a
    public void a(View r100, MotionEvent r101) {
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // kf1.a
    public String tag() {
        return "BaseMediaLinkControlWidget";
    }

    public BaseMediaLinkControlWidget() {
    }

    @Override // kf1.a
    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
