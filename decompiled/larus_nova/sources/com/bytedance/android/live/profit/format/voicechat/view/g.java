package com.bytedance.android.live.profit.format.voicechat.view;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends BaseControllerListener<Object> {
    public g() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (r102 == null) goto L5;
        r102.start();
        return;
    }
}
