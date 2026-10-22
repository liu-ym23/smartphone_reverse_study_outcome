package com.obric.oui.texteffects.runtime;

import android.util.LruCache;
import android.view.animation.PathInterpolator;
import com.GlobalProxyLancet;
import com.obric.oui.texteffects.TextEffectDebugLog;
import com.obric.oui.texteffects.core.EasingSpec;
import com.obric.oui.texteffects.core.EffectLayer;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.EffectStage;
import com.obric.oui.texteffects.core.EffectValue;
import com.obric.oui.texteffects.core.Keyframe;
import com.obric.oui.texteffects.core.LoopSpec;
import com.obric.oui.texteffects.core.PropertyTrack;
import com.obric.oui.texteffects.core.SelectorSpec;
import com.obric.oui.texteffects.core.TextEffectSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextEffectTimelineSampler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\f\u0010(\u001a\u00020\b*\u00020\u0007H\u0002J\u0014\u0010)\u001a\u00020\r*\u00020\u00122\u0006\u0010*\u001a\u00020\rH\u0002J\f\u0010+\u001a\u00020,*\u00020\u001aH\u0002J\u0014\u0010-\u001a\u00020\u0018*\u00020\u00182\u0006\u0010.\u001a\u00020\u0018H\u0002J\f\u0010/\u001a\u000200*\u00020\u0012H\u0002J\u001a\u00101\u001a\u00020,*\b\u0012\u0004\u0012\u00020\u0014022\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\f\u00103\u001a\u00020\u000b*\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler;", "", "()V", "Tag", "", "aeAnimatorInterpolatorCache", "Landroid/util/LruCache;", "Lcom/obric/oui/texteffects/core/EasingSpec$AeAnimator;", "Lcom/obric/oui/texteffects/runtime/AeAnimatorInterpolator;", "interpolatorCache", "Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "Landroid/view/animation/PathInterpolator;", "applyEasing", "", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "progress", "interpolate", "Lcom/obric/oui/texteffects/core/EffectValue;", "from", "Lcom/obric/oui/texteffects/core/Keyframe;", "to", "lerp", "normalizePlayTime", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "playTimeMs", "sample", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "sampleLayerFrame", "Lcom/obric/oui/texteffects/runtime/LayerFrame;", "stageId", "layer", "Lcom/obric/oui/texteffects/core/EffectLayer;", "stagePlayTimeMs", "sampleTrack", "track", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "sampleTrackAsFloat", "aeAnimatorInterpolator", "asFloat", "defaultValue", "estimatedLayerCount", "", "floorMod", "other", "isDimensionLike", "", "nextFrameIndex", "", "pathInterpolator", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextEffectTimelineSampler {
    public static final TextEffectTimelineSampler INSTANCE = null;
    private static final String Tag = "TimelineSampler";
    private static final LruCache<EasingSpec.AeAnimator, AeAnimatorInterpolator> aeAnimatorInterpolatorCache = null;
    private static final LruCache<EasingSpec.CubicBezier, PathInterpolator> interpolatorCache = null;

    /* JADX INFO: compiled from: TextEffectTimelineSampler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EffectProperty.values().length];
            r0[EffectProperty.Alpha.ordinal()] = 1;
            r0[EffectProperty.Tracking.ordinal()] = 2;
            r0[EffectProperty.GradientAlphaScan.ordinal()] = 3;
            r0[EffectProperty.Visibility.ordinal()] = 4;
            r0[EffectProperty.BlurRadius.ordinal()] = 5;
            r0[EffectProperty.TranslationX.ordinal()] = 6;
            r0[EffectProperty.TranslationY.ordinal()] = 7;
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final float lerp(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    private TextEffectTimelineSampler() {
    }

    public final TextEffectFrame sample(TextEffectSpec r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        long r4 = normalizePlayTime(r12, r13);
        ArrayList r0 = new ArrayList(estimatedLayerCount(r12));
        Iterator<T> r11 = r12.getStages().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        EffectStage r1 = (EffectStage) r11.next();
        long r2 = r4 - r1.getStartMs();
        if (r2 < 0) goto L4;
        if (r2 > r1.getDurationMs()) goto L4;
        Iterator<T> r6 = r1.getLayers().iterator();
    L12:
        if (r6.hasNext() == false) goto L4;
        r0.add(INSTANCE.sampleLayerFrame(r1.getId(), (EffectLayer) r6.next(), r2));
        goto L12
    L14:
        TextEffectDebugLog r14 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L20;
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", Tag), "sample spec=" + r12.getId() + ", playTime=" + r13 + ", normalized=" + r4 + ", activeLayers=" + r0.size());
    L20:
        return new TextEffectFrame(r13, r4, r0);
    }

    private final long normalizePlayTime(TextEffectSpec r11, long r12) {
        long r8 = RangesKt.coerceAtLeast(r11.getDurationMs(), 1);
        LoopSpec r0 = r11.getLoop();
        if (Intrinsics.areEqual(r0, LoopSpec.Infinite.INSTANCE) == false) goto L6;
        return floorMod(r12, r8);
    L6:
        if ((r0 instanceof LoopSpec.Count) == false) goto L12;
        if (r12 < (((long) RangesKt.coerceAtLeast(((LoopSpec.Count) r11.getLoop()).getCount(), 1)) * r8)) goto L18;
        return r8;
    L18:
        return floorMod(RangesKt.coerceAtLeast(r12, 0), r8);
    L12:
        if (Intrinsics.areEqual(r0, LoopSpec.None.INSTANCE) == false) goto L16;
        return RangesKt.coerceIn(r12, 0, r8);
    L16:
        throw new NoWhenBranchMatchedException();
    }

    private final LayerFrame sampleLayerFrame(String r20, EffectLayer r21, long r22) {
        Iterator<T> r1 = r21.getProperties().iterator();
        String r3 = null;
        float r6 = Float.NaN;
        float r8 = Float.NaN;
        float r9 = Float.NaN;
        float r11 = Float.NaN;
        SelectorSpec.ScanWindow r10 = null;
        EffectValue r12 = null;
        EffectValue r13 = null;
        EffectValue r14 = null;
    L4:
        if (r1.hasNext() == false) goto L18;
        PropertyTrack r2 = (PropertyTrack) r1.next();
        switch(WhenMappings.$EnumSwitchMapping$0[r2.getProperty().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        r14 = INSTANCE.sampleTrack(r2, r22);
        goto L4
    L9:
        r13 = INSTANCE.sampleTrack(r2, r22);
        goto L4
    L10:
        r12 = INSTANCE.sampleTrack(r2, r22);
        goto L4
    L11:
        r11 = INSTANCE.sampleTrackAsFloat(r2, r22);
        goto L4
    L12:
        r8 = INSTANCE.sampleTrackAsFloat(r2, r22);
        SelectorSpec r4 = r2.getSelector();
        if ((r4 instanceof SelectorSpec.ScanWindow) == true) goto L14;
        r10 = null;
        goto L4
    L14:
        r10 = (SelectorSpec.ScanWindow) r4;
        goto L4
    L16:
        r9 = INSTANCE.sampleTrackAsFloat(r2, r22);
        goto L4
    L17:
        r6 = INSTANCE.sampleTrackAsFloat(r2, r22);
        goto L4
    L18:
        String r5 = r21.getId();
        if ((r21 instanceof EffectLayer.ExternalView) == false) goto L21;
        EffectLayer.ExternalView r0 = (EffectLayer.ExternalView) r21;
    L22:
        if (r0 == null) goto L26;
        r3 = r0.getBindingKey();
    L26:
        return new LayerFrame(r20, r5, r3, r22, r6, Float.NaN, r8, r9, r10, r11, r12, r13, r14, null, 8192, null);
    L21:
        r0 = null;
        goto L22
    }

    private final EffectValue sampleTrack(PropertyTrack r9, long r10) {
        List<Keyframe> r0 = r9.getKeyframes();
        if (r0.isEmpty() == false) goto L7;
        return new EffectValue.FloatValue(0.0f);
    L7:
        if (r10 > ((Keyframe) CollectionsKt.first(r0)).getTimeMs()) goto L11;
        return ((Keyframe) CollectionsKt.first(r0)).getValue();
    L11:
        if (r10 >= ((Keyframe) CollectionsKt.last(r0)).getTimeMs()) goto L13;
        int r1 = nextFrameIndex(r0, r10);
        Keyframe r3 = r0.get(r1 - 1);
        Keyframe r2 = r0.get(r1);
        return interpolate(r3, r2, applyEasing(r9.getEasing(), RangesKt.coerceIn((r10 - r3.getTimeMs()) / RangesKt.coerceAtLeast(r2.getTimeMs() - r3.getTimeMs(), 1), 0.0f, 1.0f)));
    L13:
        return ((Keyframe) CollectionsKt.last(r0)).getValue();
    }

    private final float sampleTrackAsFloat(PropertyTrack r9, long r10) {
        List<Keyframe> r0 = r9.getKeyframes();
        if (r0.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r10 > ((Keyframe) CollectionsKt.first(r0)).getTimeMs()) goto L10;
        return asFloat(((Keyframe) CollectionsKt.first(r0)).getValue(), 0.0f);
    L10:
        if (r10 >= ((Keyframe) CollectionsKt.last(r0)).getTimeMs()) goto L12;
        int r1 = nextFrameIndex(r0, r10);
        Keyframe r3 = r0.get(r1 - 1);
        Keyframe r2 = r0.get(r1);
        return lerp(asFloat(r3.getValue(), 0.0f), asFloat(r2.getValue(), asFloat(r3.getValue(), 0.0f)), applyEasing(r9.getEasing(), RangesKt.coerceIn((r10 - r3.getTimeMs()) / RangesKt.coerceAtLeast(r2.getTimeMs() - r3.getTimeMs(), 1), 0.0f, 1.0f)));
    L12:
        return asFloat(((Keyframe) CollectionsKt.last(r0)).getValue(), 0.0f);
    }

    private final float applyEasing(EasingSpec r2, float r3) {
        if (Intrinsics.areEqual(r2, EasingSpec.Linear.INSTANCE) == false) goto L6;
        return r3;
    L6:
        if ((r2 instanceof EasingSpec.CubicBezier) == false) goto L9;
        return pathInterpolator((EasingSpec.CubicBezier) r2).getInterpolation(r3);
    L9:
        if ((r2 instanceof EasingSpec.AeAnimator) == false) goto L13;
        return aeAnimatorInterpolator((EasingSpec.AeAnimator) r2).getInterpolation(r3);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final EffectValue interpolate(Keyframe r2, Keyframe r3, float r4) {
        EffectValue r5 = r2.getValue();
        EffectValue r6 = r3.getValue();
        if ((r5 instanceof EffectValue.FloatValue) == false) goto L8;
        if ((r6 instanceof EffectValue.FloatValue) == false) goto L8;
        return new EffectValue.FloatValue(lerp(((EffectValue.FloatValue) r5).getValue(), ((EffectValue.FloatValue) r6).getValue(), r4));
    L8:
        if ((r5 instanceof EffectValue.DimensionDp) == false) goto L13;
        if ((r6 instanceof EffectValue.DimensionDp) == false) goto L13;
        return new EffectValue.DimensionDp(lerp(((EffectValue.DimensionDp) r5).getValue(), ((EffectValue.DimensionDp) r6).getValue(), r4));
    L13:
        if (isDimensionLike(r5) == false) goto L18;
        if (isDimensionLike(r6) == false) goto L18;
        return new EffectValue.InterpolatedDimension(r5, r6, r4);
    L18:
        if (r4 >= 1.0f) goto L21;
        return r5;
    L21:
        return r6;
    }

    private final boolean isDimensionLike(EffectValue r1) {
        if ((r1 instanceof EffectValue.FloatValue) == false) goto L5;
    L16:
        return true;
    L5:
        if ((r1 instanceof EffectValue.DimensionDp) == true) goto L16;
        if ((r1 instanceof EffectValue.ParentWidth) == true) goto L16;
        if ((r1 instanceof EffectValue.LayerWidth) == true) goto L16;
        if ((r1 instanceof EffectValue.TextWidthRatio) == true) goto L16;
        if ((r1 instanceof EffectValue.InterpolatedDimension) == true) goto L16;
        return false;
    }

    private final float asFloat(EffectValue r1, float r2) {
        if ((r1 instanceof EffectValue.FloatValue) == false) goto L6;
        return ((EffectValue.FloatValue) r1).getValue();
    L6:
        if ((r1 instanceof EffectValue.DimensionDp) == true) goto L8;
        return r2;
    L8:
        return ((EffectValue.DimensionDp) r1).getValue();
    }

    private final int estimatedLayerCount(TextEffectSpec r3) {
        Iterator<T> r2 = r3.getStages().iterator();
        if (r2.hasNext() == true) goto L5;
        Integer r4 = null;
    L12:
        Integer r5 = r4;
        if (r5 != null) goto L16;
        return 0;
    L16:
        return r5.intValue();
    L5:
        Integer r6 = Integer.valueOf(((EffectStage) r2.next()).getLayers().size());
    L7:
        if (r2.hasNext() == false) goto L11;
        Integer r0 = Integer.valueOf(((EffectStage) r2.next()).getLayers().size());
        if (r6.compareTo(r0) >= 0) goto L7;
        r6 = r0;
        goto L7
    L11:
        r4 = r6;
        goto L12
    }

    private final int nextFrameIndex(List<Keyframe> r5, long r6) {
        int r4 = CollectionsKt.getLastIndex(r5);
        int r0 = 0;
    L4:
        if (r0 >= r4) goto L10;
        int r1 = (r0 + r4) >>> 1;
        if (r5.get(r1).getTimeMs() >= r6) goto L7;
        r0 = r1 + 1;
        goto L4
    L7:
        r4 = r1;
        goto L4
    L10:
        return RangesKt.coerceAtLeast(r0, 1);
    }

    private final PathInterpolator pathInterpolator(EasingSpec.CubicBezier r6) {
        LruCache<EasingSpec.CubicBezier, PathInterpolator> r5 = interpolatorCache;
        PathInterpolator r0 = r5.get(r6);
        if (r0 != null) goto L6;
        PathInterpolator r1 = new PathInterpolator(r6.getX1(), r6.getY1(), r6.getX2(), r6.getY2());
        r5.put(r6, r1);
        return r1;
    L6:
        return r0;
    }

    private final AeAnimatorInterpolator aeAnimatorInterpolator(EasingSpec.AeAnimator r5) {
        LruCache<EasingSpec.AeAnimator, AeAnimatorInterpolator> r4 = aeAnimatorInterpolatorCache;
        AeAnimatorInterpolator r0 = r4.get(r5);
        if (r0 != null) goto L6;
        AeAnimatorInterpolator r1 = new AeAnimatorInterpolator(r5.getMode(), r5.getEaseLow(), r5.getEaseHigh());
        r4.put(r5, r1);
        return r1;
    L6:
        return r0;
    }

    private final long floorMod(long r3, long r5) {
        long r4 = r3 % r5;
        if (r4 < 0) goto L5;
        return r4;
    L5:
        return r4 + r5;
    }

    static {
        INSTANCE = new TextEffectTimelineSampler();
        interpolatorCache = new LruCache(16);
        aeAnimatorInterpolatorCache = new LruCache(16);
    }
}
