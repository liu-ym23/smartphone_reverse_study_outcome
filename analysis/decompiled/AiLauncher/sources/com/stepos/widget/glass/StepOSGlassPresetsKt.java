package com.stepos.widget.glass;

import A7.C0746n;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\b\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0001\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0003\u0010\n¨\u0006\u000b"}, d2 = {"LA7/n;", "src", "LY8/t;", "copyFrom", "(LA7/n;LA7/n;)V", "LA7/Z;", "(LA7/Z;LA7/Z;)V", "LA7/L;", "(LA7/L;LA7/L;)V", "LA7/S;", "(LA7/S;LA7/S;)V", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSGlassPresetsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyFrom(C0746n c0746n, C0746n c0746n2) {
        c0746n.n(c0746n2.getRadius());
        c0746n.o(c0746n2.getTintColor());
        c0746n.k(c0746n2.getBlendColor());
        c0746n.l(c0746n2.getFrost());
        c0746n.m(c0746n2.getOverlay());
        c0746n.p(c0746n2.getUseAospBlur());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyFrom(A7.Z z10, A7.Z z11) {
        z10.B(z11.getX5.d.EXTRA_ENABLED java.lang.String());
        z10.J(z11.getWidth());
        z10.H(z11.getSoftness());
        z10.C(z11.getIntensity());
        z10.I(z11.getSpread());
        z10.w(z11.getColor());
        z10.D(z11.getLight0X());
        z10.E(z11.getLight0Y());
        z10.F(z11.getLight1X());
        z10.G(z11.getLight1Y());
        z10.u(z11.getAmbient());
        z10.v(z11.getAnisotropicRim());
        z10.z(z11.getEdgeColor());
        z10.x(z11.getDarkColor());
        z10.y(z11.getDarkWidth());
        z10.A(z11.getEdgeWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyFrom(A7.L l10, A7.L l11) {
        l10.l(l11.getX5.d.EXTRA_ENABLED java.lang.String());
        l10.k(l11.getColor());
        l10.p(l11.getRadius());
        l10.n(l11.getOffsetX());
        l10.o(l11.getOffsetY());
        l10.m(l11.getIntensity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void copyFrom(A7.S s10, A7.S s11) {
        s10.l(s11.getX5.d.EXTRA_ENABLED java.lang.String());
        s10.m(s11.getStrength());
        s10.n(s11.getWidth());
        s10.k(s11.getDispersion());
        s10.j(s11.getDepthEffect());
    }
}
