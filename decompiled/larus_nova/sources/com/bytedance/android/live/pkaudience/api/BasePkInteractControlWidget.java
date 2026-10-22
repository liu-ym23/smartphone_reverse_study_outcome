package com.bytedance.android.live.pkaudience.api;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.liveinteract.api.ILinkControlWidget;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/liveinteract/api/ILinkControlWidget;", "Lcom/bytedance/android/live/pkaudience/api/c;", "<init>", "()V", "livepkaudience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkInteractControlWidget extends LiveWidget implements ILinkControlWidget, c {
    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public abstract void p3(IRoom r100);

    public String tag() {
        return "BasePkInteractControlWidget";
    }

    public BasePkInteractControlWidget() {
    }

    @Override // kf1.a
    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
