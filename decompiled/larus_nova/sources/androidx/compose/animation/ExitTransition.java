package androidx.compose.animation;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0002J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/ExitTransition;", "", "<init>", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation", "()Landroidx/compose/animation/TransitionData;", "plus", "exit", "equals", "", "other", "toString", "", "hashCode", "", "Companion", "Landroidx/compose/animation/ExitTransitionImpl;", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExitTransition {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final ExitTransition KeepUntilTransitionsFinished = null;
    private static final ExitTransition None = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/animation/ExitTransition$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/animation/ExitTransition;", "getNone", "()Landroidx/compose/animation/ExitTransition;", "KeepUntilTransitionsFinished", "getKeepUntilTransitionsFinished$animation", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ExitTransition getKeepUntilTransitionsFinished$animation() {
            return ExitTransition.access$getKeepUntilTransitionsFinished$cp();
        }

        public final ExitTransition getNone() {
            return ExitTransition.access$getNone$cp();
        }
    }

    private ExitTransition() {
    }

    public /* synthetic */ ExitTransition(DefaultConstructorMarker r100) {
        this();
    }

    public abstract TransitionData getData$animation();

    static {
        Companion = new Companion(null);
        Fade r100 = null;
        Slide r101 = null;
        ChangeSize r102 = null;
        Scale r103 = null;
        Map r104 = null;
        DefaultConstructorMarker r105 = null;
        None = new ExitTransitionImpl(new TransitionData(r100, r101, r102, r103, false, r104, 63, r105));
        KeepUntilTransitionsFinished = new ExitTransitionImpl(new TransitionData(r100, r101, r102, r103, true, r104, 47, r105));
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None) == false) goto L6;
        return "ExitTransition.None";
    L6:
        if (Intrinsics.areEqual(this, KeepUntilTransitionsFinished) == false) goto L8;
        return "ExitTransition.KeepUntilTransitionsFinished";
    L8:
        TransitionData r100 = getData$animation();
        StringBuilder r101 = new StringBuilder("ExitTransition: \nFade - ");
        Fade r102 = r100.getFade();
        String r103 = null;
        if (r102 == null) goto L11;
        String r104 = r102.toString();
    L12:
        r101.append(r104);
        r101.append(",\nSlide - ");
        Slide r105 = r100.getSlide();
        if (r105 == null) goto L15;
        String r106 = r105.toString();
    L16:
        r101.append(r106);
        r101.append(",\nShrink - ");
        ChangeSize r107 = r100.getChangeSize();
        if (r107 == null) goto L19;
        String r108 = r107.toString();
    L20:
        r101.append(r108);
        r101.append(",\nScale - ");
        Scale r109 = r100.getScale();
        if (r109 == null) goto L23;
        r103 = r109.toString();
    L23:
        r101.append(r103);
        r101.append(",\nKeepUntilTransitionsFinished - ");
        r101.append(r100.getHold());
        return r101.toString();
    L19:
        r108 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    }

    public int hashCode() {
        return getData$animation().hashCode();
    }

    public static final /* synthetic */ ExitTransition access$getKeepUntilTransitionsFinished$cp() {
        return KeepUntilTransitionsFinished;
    }

    public static final /* synthetic */ ExitTransition access$getNone$cp() {
        return None;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ExitTransition) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((ExitTransition) r100).getData$animation(), getData$animation()) == false) goto L7;
        return true;
    }

    public final ExitTransition plus(ExitTransition r110) {
        Fade r100 = r110.getData$animation().getFade();
        if (r100 != null) goto L5;
        r100 = getData$animation().getFade();
    L5:
        Fade r101 = r100;
        Slide r102 = r110.getData$animation().getSlide();
        if (r102 != null) goto L8;
        r102 = getData$animation().getSlide();
    L8:
        Slide r103 = r102;
        ChangeSize r104 = r110.getData$animation().getChangeSize();
        if (r104 != null) goto L11;
        r104 = getData$animation().getChangeSize();
    L11:
        ChangeSize r105 = r104;
        Scale r106 = r110.getData$animation().getScale();
        if (r106 != null) goto L14;
        r106 = getData$animation().getScale();
    L14:
        Scale r107 = r106;
        if (r110.getData$animation().getHold() == false) goto L17;
    L20:
        boolean r108 = true;
    L22:
        return new ExitTransitionImpl(new TransitionData(r101, r103, r105, r107, r108, MapsKt.plus(getData$animation().getEffectsMap(), r110.getData$animation().getEffectsMap())));
    L17:
        if (getData$animation().getHold() == true) goto L20;
        r108 = false;
        goto L22
    }
}
