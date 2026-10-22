package com.stepos.motionkit.fx.material.capability;

import C7.r;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/SelfBlurBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "token", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SelfBlurBinding implements MaterialBinding {
    private final CrossWindowMaterialBackend.Token token;

    public SelfBlurBinding(CrossWindowMaterialBackend.Token token) {
        k.f(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(BlurParams blurParams, Object d) {
        k.f(d, "d");
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        crossWindowMaterialBackend.call(d, "setBlurRadius", new Class[]{crossWindowMaterialBackend.getI()}, Integer.valueOf((int) blurParams.getRadius()));
        crossWindowMaterialBackend.call(d, "setColor", new Class[]{crossWindowMaterialBackend.getI()}, Integer.valueOf(blurParams.getTintColor()));
        crossWindowMaterialBackend.call(d, "setFrost", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(blurParams.getFrost()));
        if (blurParams.getOverlay()) {
            crossWindowMaterialBackend.call(d, "setOverlay", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(blurParams.getBlendColor()));
        } else {
            crossWindowMaterialBackend.call(d, "setDodge", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(blurParams.getBlendColor()));
        }
        if (blurParams instanceof GradientBlurParams) {
            GradientBlurParams gradientBlurParams = (GradientBlurParams) blurParams;
            Log.d("MotionKitGradientBlur", "reflect setBlurGradient mode=" + gradientBlurParams.getDirection().getMode() + " scale=" + gradientBlurParams.getGradientScale());
            crossWindowMaterialBackend.call(d, "setBlurGradient", new Class[]{crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI()}, Integer.valueOf(gradientBlurParams.getDirection().getMode()), Integer.valueOf(gradientBlurParams.getGradientScale()));
            crossWindowMaterialBackend.call(d, "setColorGradient", new Class[]{crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getI()}, Integer.valueOf(gradientBlurParams.getStartColor()), Integer.valueOf(gradientBlurParams.getMiddleColor()), Integer.valueOf(gradientBlurParams.getEndColor()), Float.valueOf(gradientBlurParams.getColorMidpoint()), Integer.valueOf(BlurCapabilityKt.colorGradMode(gradientBlurParams)));
        } else {
            crossWindowMaterialBackend.call(d, "setBlurGradient", new Class[]{crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI()}, 0, 0);
            crossWindowMaterialBackend.call(d, "setColorGradient", new Class[]{crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getI()}, 0, 0, 0, Float.valueOf(0.5f), 0);
        }
        return r.f317a;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        CrossWindowMaterialBackend.Token.release$default(this.token, null, 1, null);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        k.f(params, "params");
        BlurParams blurParams = params instanceof BlurParams ? (BlurParams) params : null;
        if (blurParams == null) {
            return;
        }
        this.token.config(new i(blurParams, 1));
    }
}
