package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/animation/core/ArcMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ArcMode {
    private static final int ArcAbove = 0;
    private static final int ArcBelow = 0;
    private static final int ArcLinear = 0;
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/animation/core/ArcMode$Companion;", "", "<init>", "()V", "ArcAbove", "Landroidx/compose/animation/core/ArcMode;", "getArcAbove--9T-Mq4", "()I", "I", "ArcBelow", "getArcBelow--9T-Mq4", "ArcLinear", "getArcLinear--9T-Mq4", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getArcAbove--9T-Mq4, reason: not valid java name */
        public final int m152getArcAbove9TMq4() {
            return ArcMode.access$getArcAbove$cp();
        }

        /* JADX INFO: renamed from: getArcBelow--9T-Mq4, reason: not valid java name */
        public final int m153getArcBelow9TMq4() {
            return ArcMode.access$getArcBelow$cp();
        }

        /* JADX INFO: renamed from: getArcLinear--9T-Mq4, reason: not valid java name */
        public final int m154getArcLinear9TMq4() {
            return ArcMode.access$getArcLinear$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ArcMode m145boximpl(int r100) {
        return new ArcMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m146constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m147equalsimpl(int r100, Object r101) {
        if ((r101 instanceof ArcMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ArcMode) r101).m151unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m148equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m149hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m150toStringimpl(int r100) {
        return "ArcMode(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m147equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m149hashCodeimpl(this.value);
    }

    public String toString() {
        return m150toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m151unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        ArcAbove = m146constructorimpl(5);
        ArcBelow = m146constructorimpl(4);
        ArcLinear = m146constructorimpl(0);
    }

    public static final /* synthetic */ int access$getArcAbove$cp() {
        return ArcAbove;
    }

    public static final /* synthetic */ int access$getArcBelow$cp() {
        return ArcBelow;
    }

    public static final /* synthetic */ int access$getArcLinear$cp() {
        return ArcLinear;
    }

    private /* synthetic */ ArcMode(int r100) {
        this.value = r100;
    }
}
