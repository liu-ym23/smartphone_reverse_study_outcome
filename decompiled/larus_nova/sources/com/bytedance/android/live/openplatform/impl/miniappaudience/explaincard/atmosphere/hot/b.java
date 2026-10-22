package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppHotAtmosphereView f84873a;

    public b(MiniAppHotAtmosphereView r100) {
        this.f84873a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        this.f84873a.f84852b = true;
    }
}
