package com.stepos.widget.toolbar;

import C7.r;
import S7.k;
import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.capability.GradientBlurParams;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4191a;
    public final /* synthetic */ float b;
    public final /* synthetic */ StepOSTitleBar c;
    public final /* synthetic */ int d;

    public /* synthetic */ d(float f, StepOSTitleBar stepOSTitleBar, int i, int i6) {
        this.f4191a = i6;
        this.b = f;
        this.c = stepOSTitleBar;
        this.d = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f4191a;
        int i6 = this.d;
        StepOSTitleBar stepOSTitleBar = this.c;
        float f = this.b;
        switch (i) {
            case 0:
                MaterialBuilder builder = (MaterialBuilder) obj;
                int i10 = StepOSTitleBar.f4156f0;
                kotlin.jvm.internal.k.f(builder, "builder");
                return builder.apply(Materials.GradientBlur.INSTANCE.getTOP_SHORT(), new d(f, stepOSTitleBar, i6, 1));
            default:
                GradientBlurParams apply = (GradientBlurParams) obj;
                int i11 = StepOSTitleBar.f4156f0;
                kotlin.jvm.internal.k.f(apply, "$this$apply");
                apply.setRadius(f);
                int startColor = apply.getStartColor();
                int middleColor = apply.getMiddleColor();
                int endColor = apply.getEndColor();
                apply.setStartColor(StepOSTitleBar.k(stepOSTitleBar.f4171T, i6, startColor));
                apply.setMiddleColor(StepOSTitleBar.k(stepOSTitleBar.f4172U, i6, middleColor));
                apply.setEndColor(StepOSTitleBar.k(stepOSTitleBar.f4173V, i6, endColor));
                return r.f317a;
        }
    }
}
