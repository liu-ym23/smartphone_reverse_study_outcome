package com.stepos.motionkit.fx;

import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.fx.effects.EdgeBlurDispersionKt;
import com.stepos.motionkit.fx.effects.EdgeGlowKt;
import com.stepos.motionkit.fx.effects.MeshKt;
import com.stepos.motionkit.fx.effects.SpectrumBorderKt;
import com.stepos.motionkit.fx.effects.WaveGlowKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/Effects;", "", AppAgent.CONSTRUCT, "()V", "EdgeGlow", "Lcom/stepos/motionkit/EffectDefinition;", "getEdgeGlow", "()Lcom/stepos/motionkit/EffectDefinition;", "SpectrumBorder", "getSpectrumBorder", "Mesh", "getMesh", "EdgeBlurDispersion", "getEdgeBlurDispersion", "WaveGlow", "getWaveGlow", "all", "", "getAll", "()Ljava/util/List;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Effects {
    private static final EffectDefinition EdgeBlurDispersion;
    private static final EffectDefinition EdgeGlow;
    public static final Effects INSTANCE = new Effects();
    private static final EffectDefinition Mesh;
    private static final EffectDefinition SpectrumBorder;
    private static final EffectDefinition WaveGlow;
    private static final List<EffectDefinition> all;

    static {
        EffectDefinition edgeGlow = EdgeGlowKt.getEdgeGlow();
        EdgeGlow = edgeGlow;
        EffectDefinition spectrumBorder = SpectrumBorderKt.getSpectrumBorder();
        SpectrumBorder = spectrumBorder;
        EffectDefinition mesh = MeshKt.getMesh();
        Mesh = mesh;
        EffectDefinition edgeBlurDispersion = EdgeBlurDispersionKt.getEdgeBlurDispersion();
        EdgeBlurDispersion = edgeBlurDispersion;
        EffectDefinition waveGlow = WaveGlowKt.getWaveGlow();
        WaveGlow = waveGlow;
        all = o.N(edgeGlow, spectrumBorder, mesh, edgeBlurDispersion, waveGlow);
    }

    private Effects() {
    }

    public final List<EffectDefinition> getAll() {
        return all;
    }

    public final EffectDefinition getEdgeBlurDispersion() {
        return EdgeBlurDispersion;
    }

    public final EffectDefinition getEdgeGlow() {
        return EdgeGlow;
    }

    public final EffectDefinition getMesh() {
        return Mesh;
    }

    public final EffectDefinition getSpectrumBorder() {
        return SpectrumBorder;
    }

    public final EffectDefinition getWaveGlow() {
        return WaveGlow;
    }
}
