package com.stepos.motionkit.fx.material.capability;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/StrokeBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "token", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class StrokeBinding implements MaterialBinding {
    private final CrossWindowMaterialBackend.Token token;

    public StrokeBinding(CrossWindowMaterialBackend.Token token) {
        k.f(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$1(Object d) {
        k.f(d, "d");
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        Class<?>[] clsArr = {crossWindowMaterialBackend.getB(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getI()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        crossWindowMaterialBackend.call(d, "setGlassStroke", clsArr, bool, fValueOf, fValueOf, fValueOf, 0);
        crossWindowMaterialBackend.call(d, "setAmbient", new Class[]{crossWindowMaterialBackend.getF()}, fValueOf);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(StrokeParams strokeParams, Object d) {
        k.f(d, "d");
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        crossWindowMaterialBackend.call(d, "setGlassStroke", new Class[]{crossWindowMaterialBackend.getB(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getI()}, Boolean.valueOf(strokeParams.getEnabled()), Float.valueOf(strokeParams.getWidth()), Float.valueOf(strokeParams.getSoftness()), Float.valueOf(strokeParams.getIntensity()), Integer.valueOf(strokeParams.getColor()));
        crossWindowMaterialBackend.call(d, "setStrokeSpread", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(strokeParams.getSpread()));
        crossWindowMaterialBackend.call(d, "setLightDirs", new Class[]{crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF()}, Float.valueOf(strokeParams.getLight0X()), Float.valueOf(strokeParams.getLight0Y()), Float.valueOf(strokeParams.getLight1X()), Float.valueOf(strokeParams.getLight1Y()));
        crossWindowMaterialBackend.call(d, "setAmbient", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(strokeParams.getAmbient()));
        crossWindowMaterialBackend.call(d, "setAnisoRim", new Class[]{crossWindowMaterialBackend.getB()}, Boolean.valueOf(strokeParams.getAnisotropicRim()));
        crossWindowMaterialBackend.call(d, "setEdgeColors", new Class[]{crossWindowMaterialBackend.getI(), crossWindowMaterialBackend.getI()}, Integer.valueOf(strokeParams.getEdgeColor()), Integer.valueOf(strokeParams.getDarkColor()));
        crossWindowMaterialBackend.call(d, "setDarkWidth", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(strokeParams.getDarkWidth()));
        crossWindowMaterialBackend.call(d, "setEdgeWidth", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(strokeParams.getEdgeWidth()));
        return r.f317a;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        this.token.release(new a(7));
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        k.f(params, "params");
        StrokeParams strokeParams = params instanceof StrokeParams ? (StrokeParams) params : null;
        if (strokeParams == null) {
            return;
        }
        this.token.config(new d(strokeParams, 1));
    }
}
