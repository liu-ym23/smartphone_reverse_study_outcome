package com.alibaba.gaiax.adapter;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.animation.GXLottieAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/alibaba/gaiax/adapter/GXExtensionLottieAnimation;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "()V", "create", "Lcom/alibaba/gaiax/template/animation/GXLottieAnimation;", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXExtensionLottieAnimation implements GXRegisterCenter.GXIExtensionLottieAnimation {
    public GXExtensionLottieAnimation() {
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionLottieAnimation
    public GXLottieAnimation create() {
        return new GXAdapterLottieAnimation();
    }
}
