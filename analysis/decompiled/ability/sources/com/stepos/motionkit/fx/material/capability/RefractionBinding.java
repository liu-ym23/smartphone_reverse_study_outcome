package com.stepos.motionkit.fx.material.capability;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/RefractionBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "token", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RefractionBinding implements MaterialBinding {
    private final CrossWindowMaterialBackend.Token token;

    public RefractionBinding(CrossWindowMaterialBackend.Token token) {
        k.f(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$1(Object d) {
        k.f(d, "d");
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        Class<?>[] clsArr = {crossWindowMaterialBackend.getB(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        crossWindowMaterialBackend.call(d, "setRefraction", clsArr, bool, fValueOf, fValueOf);
        crossWindowMaterialBackend.call(d, "setDispersion", new Class[]{crossWindowMaterialBackend.getF()}, fValueOf);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(RefractionParams refractionParams, Object d) {
        k.f(d, "d");
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        crossWindowMaterialBackend.call(d, "setRefraction", new Class[]{crossWindowMaterialBackend.getB(), crossWindowMaterialBackend.getF(), crossWindowMaterialBackend.getF()}, Boolean.valueOf(refractionParams.getEnabled()), Float.valueOf(RefractionCapabilityKt.refractStrengthPx(refractionParams.getStrength())), Float.valueOf(RefractionCapabilityKt.refractWidthPx(refractionParams.getWidth())));
        crossWindowMaterialBackend.call(d, "setRefractionDepth", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(refractionParams.getDepthEffect()));
        crossWindowMaterialBackend.call(d, "setDispersion", new Class[]{crossWindowMaterialBackend.getF()}, Float.valueOf(refractionParams.getDispersion()));
        return r.f317a;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        this.token.release(new a(6));
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        k.f(params, "params");
        RefractionParams refractionParams = params instanceof RefractionParams ? (RefractionParams) params : null;
        if (refractionParams == null) {
            return;
        }
        this.token.config(new c(refractionParams, 1));
    }
}
