package com.bytedance.android.livesdk.revenue.message;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements com.bytedance.android.livesdk.revenue.service.message.e {
    public j() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.e
    public final void b3() {
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.e
    public final void N1(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.bytedance.android.livesdk.chatroom.bl.a r101 = new com.bytedance.android.livesdk.chatroom.bl.a(r100);
        PlatformMessageHelper.INSTANCE.setFollowGuideBarrier("EC_GOOD_LIST_DIALOG", r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.e
    public final void Eb(boolean r100, boolean r101, EffectMessage r102) {
        PlatformMessageHelper.INSTANCE.setBigGiftPlayStateEvent(r100, r101, r102);
    }
}
