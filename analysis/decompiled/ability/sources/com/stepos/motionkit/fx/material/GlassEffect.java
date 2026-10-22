package com.stepos.motionkit.fx.material;

import C7.r;
import H4.o;
import S7.n;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.GlassTextParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 ,2\u00020\u0001:\u0001,B±\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R,\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b'\u0010&R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b(\u0010&R,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b)\u0010&R,\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b*\u0010&R,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b+\u0010&¨\u0006-"}, d2 = {"Lcom/stepos/motionkit/fx/material/GlassEffect;", "", "", "cornerRadiusDp", "Lkotlin/Function2;", "Lcom/stepos/motionkit/fx/material/capability/BlurParams;", "LC7/r;", "blur", "Lcom/stepos/motionkit/fx/material/capability/StrokeParams;", "stroke", "Lcom/stepos/motionkit/fx/material/capability/InnerShadowParams;", "innerShadow", "Lcom/stepos/motionkit/fx/material/capability/RefractionParams;", "refraction", "Lcom/stepos/motionkit/fx/material/capability/BlendParams;", "blend", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "glassText", AppAgent.CONSTRUCT, "(FLS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;)V", "density", "resolveBlur", "(F)Lcom/stepos/motionkit/fx/material/capability/BlurParams;", "resolveStroke", "(F)Lcom/stepos/motionkit/fx/material/capability/StrokeParams;", "resolveInnerShadow", "(F)Lcom/stepos/motionkit/fx/material/capability/InnerShadowParams;", "resolveRefraction", "(F)Lcom/stepos/motionkit/fx/material/capability/RefractionParams;", "resolveBlend", "(F)Lcom/stepos/motionkit/fx/material/capability/BlendParams;", "resolveGlassText", "(F)Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "F", "getCornerRadiusDp", "()F", "LS7/n;", "getBlur$motionkit_fx_release", "()LS7/n;", "getStroke$motionkit_fx_release", "getInnerShadow$motionkit_fx_release", "getRefraction$motionkit_fx_release", "getBlend$motionkit_fx_release", "getGlassText$motionkit_fx_release", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassEffect {
    private static final GlassEffect CLEAR;
    private static final GlassEffect CLEAR2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final GlassEffect DARK_MEDIUM;
    private static final GlassEffect DARK_SMALL;
    private static final GlassEffect DARK_SMALL2;
    private static final GlassEffect LIGHT_MEDIUM;
    private static final GlassEffect LIGHT_SMALL;
    private static final GlassEffect LIGHT_SMALL2;
    private static final GlassEffect TEXT;
    private final n blend;
    private final n blur;
    private final float cornerRadiusDp;
    private final n glassText;
    private final n innerShadow;
    private final n refraction;
    private final n stroke;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0&0%H\u0002R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007¨\u0006'"}, d2 = {"Lcom/stepos/motionkit/fx/material/GlassEffect$Companion;", "", AppAgent.CONSTRUCT, "()V", "MEDIUM", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getMEDIUM", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "CLEAR", "getCLEAR", "CLEAR1", "getCLEAR1", "CLEAR2", "getCLEAR2", "TEXT", "getTEXT", "LIGHT_SMALL", "getLIGHT_SMALL", "LIGHT_SMALL2", "getLIGHT_SMALL2", "LIGHT_MEDIUM", "getLIGHT_MEDIUM", "DARK_SMALL", "getDARK_SMALL", "DARK_SMALL2", "getDARK_SMALL2", "DARK_MEDIUM", "getDARK_MEDIUM", "tier", "blurPx", "", "strokeIntensity", "innerDepthDp", "innerIntensity", "innerOpacityPct", "", "blendStages", "", "Lkotlin/Pair;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GlassEffect tier(final float blurPx, final float strokeIntensity, final float innerDepthDp, final float innerIntensity, final int innerOpacityPct, List<Pair<Integer, Integer>> blendStages) {
            final int i = 0;
            n nVar = new n() { // from class: com.stepos.motionkit.fx.material.a
                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    switch (i) {
                        case 0:
                            float fFloatValue = ((Float) obj2).floatValue();
                            return GlassEffect.Companion.tier$lambda$0(blurPx, (BlurParams) obj, fFloatValue);
                        default:
                            float fFloatValue2 = ((Float) obj2).floatValue();
                            return GlassEffect.Companion.tier$lambda$1(blurPx, (StrokeParams) obj, fFloatValue2);
                    }
                }
            };
            final int i6 = 1;
            return new GlassEffect(24.0f, nVar, new n() { // from class: com.stepos.motionkit.fx.material.a
                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    switch (i6) {
                        case 0:
                            float fFloatValue = ((Float) obj2).floatValue();
                            return GlassEffect.Companion.tier$lambda$0(strokeIntensity, (BlurParams) obj, fFloatValue);
                        default:
                            float fFloatValue2 = ((Float) obj2).floatValue();
                            return GlassEffect.Companion.tier$lambda$1(strokeIntensity, (StrokeParams) obj, fFloatValue2);
                    }
                }
            }, new n() { // from class: com.stepos.motionkit.fx.material.b
                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    float fFloatValue = ((Float) obj2).floatValue();
                    return GlassEffect.Companion.tier$lambda$2(innerOpacityPct, innerDepthDp, innerIntensity, (InnerShadowParams) obj, fFloatValue);
                }
            }, new com.stepos.core.a(9), new c(blendStages, 0), null, 64, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r tier$lambda$0(float f, BlurParams GlassEffect, float f7) {
            k.f(GlassEffect, "$this$GlassEffect");
            GlassEffect.setRadius(f);
            GlassEffect.setTintColor(ViewCompat.MEASURED_SIZE_MASK);
            GlassEffect.setFrost(0.0f);
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r tier$lambda$1(float f, StrokeParams GlassEffect, float f7) {
            k.f(GlassEffect, "$this$GlassEffect");
            GlassEffect.setWidth(0.0f);
            GlassEffect.setSoftness(4.0f);
            GlassEffect.setIntensity(f);
            GlassEffect.setSpread(4.0f);
            double radians = Math.toRadians(270.0d);
            double radians2 = Math.toRadians(45.0d);
            GlassEffect.setLight0X((float) Math.cos(radians));
            GlassEffect.setLight0Y((float) Math.sin(radians));
            GlassEffect.setLight1X((float) Math.cos(radians2));
            GlassEffect.setLight1Y((float) Math.sin(radians2));
            GlassEffect.setAmbient(1.0f);
            GlassEffect.setAnisotropicRim(true);
            GlassEffect.setEdgeColor(GlassEffectKt.argbPct(13421772, 20));
            GlassEffect.setDarkColor(GlassEffectKt.argbPct(13684944, 20));
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r tier$lambda$2(int i, float f, float f7, InnerShadowParams GlassEffect, float f9) {
            k.f(GlassEffect, "$this$GlassEffect");
            GlassEffect.setEnabled(true);
            GlassEffect.setColor(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, i));
            GlassEffect.setRadius(f * f9);
            GlassEffect.setIntensity(f7);
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r tier$lambda$3(RefractionParams GlassEffect, float f) {
            k.f(GlassEffect, "$this$GlassEffect");
            GlassEffect.setEnabled(true);
            GlassEffect.setStrength(45.0f);
            GlassEffect.setWidth(130.0f);
            GlassEffect.setDispersion(3.0f);
            GlassEffect.setDepthEffect(0.2f);
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r tier$lambda$4(List list, BlendParams GlassEffect, float f) {
            k.f(GlassEffect, "$this$GlassEffect");
            GlassEffect.setStages(list);
            return r.f317a;
        }

        public final GlassEffect getCLEAR() {
            return GlassEffect.CLEAR;
        }

        public final GlassEffect getCLEAR1() {
            return getCLEAR();
        }

        public final GlassEffect getCLEAR2() {
            return GlassEffect.CLEAR2;
        }

        public final GlassEffect getDARK_MEDIUM() {
            return GlassEffect.DARK_MEDIUM;
        }

        public final GlassEffect getDARK_SMALL() {
            return GlassEffect.DARK_SMALL;
        }

        public final GlassEffect getDARK_SMALL2() {
            return GlassEffect.DARK_SMALL2;
        }

        public final GlassEffect getLIGHT_MEDIUM() {
            return GlassEffect.LIGHT_MEDIUM;
        }

        public final GlassEffect getLIGHT_SMALL() {
            return GlassEffect.LIGHT_SMALL;
        }

        public final GlassEffect getLIGHT_SMALL2() {
            return GlassEffect.LIGHT_SMALL2;
        }

        public final GlassEffect getMEDIUM() {
            return getDARK_SMALL();
        }

        public final GlassEffect getTEXT() {
            return GlassEffect.TEXT;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        CLEAR = companion.tier(18.0f, 0.35f, 22.0f, 0.6f, 15, o.N(new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 4))), new Pair(1, Integer.valueOf(GlassEffectKt.argbPct(1052688, 100)))));
        CLEAR2 = companion.tier(150.0f, 0.35f, 22.0f, 0.8f, 15, o.N(new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 6))), new Pair(1, Integer.valueOf(GlassEffectKt.argbPct(1052688, 100))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 50)))));
        TEXT = new GlassEffect(0.0f, new com.stepos.core.a(1), new com.stepos.core.a(2), new com.stepos.core.a(3), new com.stepos.core.a(4), new com.stepos.core.a(5), new com.stepos.core.a(6));
        LIGHT_SMALL = companion.tier(18.0f, 0.4f, 22.0f, 0.6f, 15, o.N(new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 50))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 4)))));
        LIGHT_SMALL2 = companion.tier(18.0f, 0.4f, 22.0f, 0.6f, 15, o.N(new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 50))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 4)))));
        LIGHT_MEDIUM = companion.tier(150.0f, 0.4f, 22.0f, 0.6f, 15, o.N(new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 70))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 4)))));
        DARK_SMALL = companion.tier(18.0f, 0.27f, 22.0f, 0.6f, 10, o.N(new Pair(1, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 4))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 5)))));
        DARK_SMALL2 = companion.tier(90.0f, 0.27f, 22.0f, 0.6f, 10, o.N(new Pair(1, Integer.valueOf(GlassEffectKt.argbPct(ViewCompat.MEASURED_SIZE_MASK, 4))), new Pair(0, Integer.valueOf(GlassEffectKt.argbPct(0, 5)))));
        DARK_MEDIUM = companion.tier(90.0f, 0.27f, 22.0f, 0.6f, 10, o.N(new Pair(3, Integer.valueOf(GlassEffectKt.argbPct(5066061, 100))), new Pair(4, Integer.valueOf(GlassEffectKt.argbPct(2236962, 70)))));
    }

    public GlassEffect(float f, n blur, n stroke, n innerShadow, n refraction, n blend, n glassText) {
        k.f(blur, "blur");
        k.f(stroke, "stroke");
        k.f(innerShadow, "innerShadow");
        k.f(refraction, "refraction");
        k.f(blend, "blend");
        k.f(glassText, "glassText");
        this.cornerRadiusDp = f;
        this.blur = blur;
        this.stroke = stroke;
        this.innerShadow = innerShadow;
        this.refraction = refraction;
        this.blend = blend;
        this.glassText = glassText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$10(InnerShadowParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setColor(ViewCompat.MEASURED_STATE_MASK);
        GlassEffect.setRadius(f * 9.0f);
        GlassEffect.setIntensity(0.6f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$11(RefractionParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setEnabled(true);
        GlassEffect.setStrength(8.0f);
        GlassEffect.setWidth(14.0f);
        GlassEffect.setDispersion(0.0f);
        GlassEffect.setDepthEffect(0.0f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$12(BlendParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setStages(o.N(new Pair(8, -1), new Pair(1, 1728053247)));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$13(GlassTextParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setSdfScale(64.0f);
        GlassEffect.setErode(0.0f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$8(BlurParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setRadius(60.0f);
        GlassEffect.setTintColor(ViewCompat.MEASURED_SIZE_MASK);
        GlassEffect.setBlendColor(0.0f);
        GlassEffect.setFrost(0.0f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r TEXT$lambda$9(StrokeParams GlassEffect, float f) {
        k.f(GlassEffect, "$this$GlassEffect");
        GlassEffect.setWidth(0.0f);
        GlassEffect.setIntensity(0.25f);
        GlassEffect.setSpread(2.0f);
        GlassEffect.setSoftness(5.0f);
        GlassEffect.setAmbient(0.2f);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        GlassEffect.setLight0X((float) Math.cos(radians));
        GlassEffect.setLight0Y((float) Math.sin(radians));
        GlassEffect.setLight1X((float) Math.cos(radians2));
        GlassEffect.setLight1Y((float) Math.sin(radians2));
        GlassEffect.setAnisotropicRim(true);
        GlassEffect.setEdgeColor(-3355444);
        GlassEffect.setDarkColor(-3092272);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$0(BlendParams blendParams, float f) {
        k.f(blendParams, "<this>");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$1(GlassTextParams glassTextParams, float f) {
        k.f(glassTextParams, "<this>");
        return r.f317a;
    }

    /* renamed from: getBlend$motionkit_fx_release, reason: from getter */
    public final n getBlend() {
        return this.blend;
    }

    /* renamed from: getBlur$motionkit_fx_release, reason: from getter */
    public final n getBlur() {
        return this.blur;
    }

    public final float getCornerRadiusDp() {
        return this.cornerRadiusDp;
    }

    /* renamed from: getGlassText$motionkit_fx_release, reason: from getter */
    public final n getGlassText() {
        return this.glassText;
    }

    /* renamed from: getInnerShadow$motionkit_fx_release, reason: from getter */
    public final n getInnerShadow() {
        return this.innerShadow;
    }

    /* renamed from: getRefraction$motionkit_fx_release, reason: from getter */
    public final n getRefraction() {
        return this.refraction;
    }

    /* renamed from: getStroke$motionkit_fx_release, reason: from getter */
    public final n getStroke() {
        return this.stroke;
    }

    public final BlendParams resolveBlend(float density) {
        BlendParams blendParams = new BlendParams();
        this.blend.invoke(blendParams, Float.valueOf(density));
        return blendParams;
    }

    public final BlurParams resolveBlur(float density) {
        BlurParams blurParams = new BlurParams();
        this.blur.invoke(blurParams, Float.valueOf(density));
        return blurParams;
    }

    public final GlassTextParams resolveGlassText(float density) {
        GlassTextParams glassTextParams = new GlassTextParams();
        this.glassText.invoke(glassTextParams, Float.valueOf(density));
        return glassTextParams;
    }

    public final InnerShadowParams resolveInnerShadow(float density) {
        InnerShadowParams innerShadowParams = new InnerShadowParams();
        this.innerShadow.invoke(innerShadowParams, Float.valueOf(density));
        return innerShadowParams;
    }

    public final RefractionParams resolveRefraction(float density) {
        RefractionParams refractionParams = new RefractionParams();
        this.refraction.invoke(refractionParams, Float.valueOf(density));
        return refractionParams;
    }

    public final StrokeParams resolveStroke(float density) {
        StrokeParams strokeParams = new StrokeParams();
        this.stroke.invoke(strokeParams, Float.valueOf(density));
        return strokeParams;
    }

    public /* synthetic */ GlassEffect(float f, n nVar, n nVar2, n nVar3, n nVar4, n nVar5, n nVar6, int i, e eVar) {
        this(f, nVar, nVar2, nVar3, nVar4, (i & 32) != 0 ? new com.stepos.core.a(7) : nVar5, (i & 64) != 0 ? new com.stepos.core.a(8) : nVar6);
    }
}
