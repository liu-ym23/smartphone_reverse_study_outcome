package com.stepos.motionkit.fx.material.capability;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/BackdropStrokeBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "token", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BackdropStrokeBinding implements MaterialBinding {
    private final InWindowMaterialBackend.Token token;

    public BackdropStrokeBinding(InWindowMaterialBackend.Token token) {
        k.f(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$1(InWindowMaterialBackend.Config c) {
        k.f(c, "c");
        c.setStrokeEnabled(false);
        c.setAmbient(0.0f);
        c.setAnisoRim(false);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(StrokeParams strokeParams, InWindowMaterialBackend.Config c) {
        k.f(c, "c");
        c.setStrokeEnabled(strokeParams.getEnabled());
        c.setStrokeWidth(strokeParams.getWidth());
        c.setStrokeSoftness(strokeParams.getSoftness());
        c.setStrokeIntensity(strokeParams.getIntensity());
        c.setStrokeSpread(strokeParams.getSpread());
        c.setStrokeColor(strokeParams.getColor());
        c.setLight0X(strokeParams.getLight0X());
        c.setLight0Y(strokeParams.getLight0Y());
        c.setLight1X(strokeParams.getLight1X());
        c.setLight1Y(strokeParams.getLight1Y());
        c.setAmbient(strokeParams.getAmbient());
        c.setAnisoRim(strokeParams.getAnisotropicRim());
        c.setEdgeColor(strokeParams.getEdgeColor());
        c.setDarkColor(strokeParams.getDarkColor());
        c.setDarkWidth(strokeParams.getDarkWidth());
        c.setEdgeWidth(strokeParams.getEdgeWidth());
        return r.f317a;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        this.token.release(new a(2));
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        k.f(params, "params");
        StrokeParams strokeParams = params instanceof StrokeParams ? (StrokeParams) params : null;
        if (strokeParams == null) {
            return;
        }
        this.token.config(new d(strokeParams, 0));
    }
}
