package com.stepos.motionkit;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/motionkit/FxBackend;", "", "Lcom/stepos/motionkit/MotionHost;", "host", "Landroid/view/View;", "targetView", "Lcom/stepos/motionkit/CompiledShader;", "compiled", "Lcom/stepos/motionkit/FxConfig;", "config", "Lcom/stepos/motionkit/EffectDefinition;", "definition", "Lcom/stepos/motionkit/FxInstance;", "createInstance", "(Lcom/stepos/motionkit/MotionHost;Landroid/view/View;Lcom/stepos/motionkit/CompiledShader;Lcom/stepos/motionkit/FxConfig;Lcom/stepos/motionkit/EffectDefinition;)Lcom/stepos/motionkit/FxInstance;", "LC7/r;", "release", "()V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FxBackend {
    FxInstance createInstance(MotionHost host, View targetView, CompiledShader compiled, FxConfig config, EffectDefinition definition);

    void release();
}
