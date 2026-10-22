package androidx.compose.animation;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J]\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "<init>", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getFade", "()Landroidx/compose/animation/Fade;", "getSlide", "()Landroidx/compose/animation/Slide;", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getScale", "()Landroidx/compose/animation/Scale;", "getHold", "()Z", "getEffectsMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransitionData {
    public static final int $stable = 0;
    private final ChangeSize changeSize;
    private final Map<TransitionEffectKey<?>, TransitionEffect> effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;

    public TransitionData() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransitionData copy$default(TransitionData r100, Fade r101, Slide r102, ChangeSize r103, Scale r104, boolean r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.fade;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.slide;
    L8:
        Slide r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.changeSize;
    L11:
        ChangeSize r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.scale;
    L14:
        Scale r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.hold;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.effectsMap;
    L20:
        Fade r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Fade component1() {
        return this.fade;
    }

    public final Slide component2() {
        return this.slide;
    }

    public final ChangeSize component3() {
        return this.changeSize;
    }

    public final Scale component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.hold;
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> component6() {
        return this.effectsMap;
    }

    public final TransitionData copy(Fade r100, Slide r110, ChangeSize r111, Scale r112, boolean r113, Map<TransitionEffectKey<?>, ? extends TransitionEffect> r114) {
        return new TransitionData(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TransitionData) == true) goto L8;
        return false;
    L8:
        TransitionData r101 = (TransitionData) r100;
        if (Intrinsics.areEqual(this.fade, r101.fade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.slide, r101.slide) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.changeSize, r101.changeSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scale, r101.scale) == true) goto L21;
        return false;
    L21:
        if (this.hold == r101.hold) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.effectsMap, r101.effectsMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Fade r100 = this.fade;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Slide r104 = this.slide;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ChangeSize r107 = this.changeSize;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Scale r110 = this.scale;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.hold == false) goto L21;
        int r112 = 1231;
    L23:
        return ((r111 + r112) * 31) + this.effectsMap.hashCode();
    L21:
        r112 = 1237;
        goto L23
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> getEffectsMap() {
        return this.effectsMap;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionData(Fade r100, Slide r101, ChangeSize r102, Scale r103, boolean r104, Map<TransitionEffectKey<?>, ? extends TransitionEffect> r105) {
        this.fade = r100;
        this.slide = r101;
        this.changeSize = r102;
        this.scale = r103;
        this.hold = r104;
        this.effectsMap = r105;
    }

    public /* synthetic */ TransitionData(Fade r100, Slide r101, ChangeSize r102, Scale r103, boolean r104, Map r110, int r111, DefaultConstructorMarker r112) {
        Scale r105 = null;
        if ((r111 & 1) == 0) goto L5;
        Fade r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        Slide r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        ChangeSize r107 = null;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = MapsKt.emptyMap();
    L25:
        this(r113, r106, r107, r105, r108, r110);
        return;
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
