package com.stepos.motionkit.fx.effects;

import H4.o;
import Y7.a;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.UniformSpec;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Mesh", "Lcom/stepos/motionkit/EffectDefinition;", "getMesh", "()Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MeshKt {
    private static final EffectDefinition Mesh = new EffectDefinition("Mesh", "mesh.agsl", null, o.N(new UniformSpec.Float1("u_originX", 0.5f, new a(0.0f, 1.0f), "起始点X"), new UniformSpec.Float1("u_originY", 0.91f, new a(0.3f, 1.0f), "起始点Y"), new UniformSpec.Float3("u_blendColor1", 0.157f, 0.2f, 1.0f, "color1"), new UniformSpec.Float3("u_blendColor2", 1.0f, 0.569f, 0.216f, "color2")), BackendHint.AUTO, false, null, 100, null);

    public static final EffectDefinition getMesh() {
        return Mesh;
    }
}
