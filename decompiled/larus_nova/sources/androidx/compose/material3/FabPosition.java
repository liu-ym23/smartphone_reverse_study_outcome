package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/FabPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FabPosition {
    private static final int Center = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int EndOverlay = 0;
    private static final int Start = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/FabPosition$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/material3/FabPosition;", "getStart-ERTFSPs", "()I", "I", "Center", "getCenter-ERTFSPs", "End", "getEnd-ERTFSPs", "EndOverlay", "getEndOverlay-ERTFSPs", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-ERTFSPs, reason: not valid java name */
        public final int m2231getCenterERTFSPs() {
            return FabPosition.access$getCenter$cp();
        }

        /* JADX INFO: renamed from: getEnd-ERTFSPs, reason: not valid java name */
        public final int m2232getEndERTFSPs() {
            return FabPosition.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getEndOverlay-ERTFSPs, reason: not valid java name */
        public final int m2233getEndOverlayERTFSPs() {
            return FabPosition.access$getEndOverlay$cp();
        }

        /* JADX INFO: renamed from: getStart-ERTFSPs, reason: not valid java name */
        public final int m2234getStartERTFSPs() {
            return FabPosition.access$getStart$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FabPosition m2224boximpl(int r100) {
        return new FabPosition(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2225constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2226equalsimpl(int r100, Object r101) {
        if ((r101 instanceof FabPosition) == true) goto L6;
        return false;
    L6:
        if (r100 == ((FabPosition) r101).m2230unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2227equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2228hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m2226equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m2228hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2230unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Start = m2225constructorimpl(0);
        Center = m2225constructorimpl(1);
        End = m2225constructorimpl(2);
        EndOverlay = m2225constructorimpl(3);
    }

    public String toString() {
        return m2229toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getCenter$cp() {
        return Center;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getEndOverlay$cp() {
        return EndOverlay;
    }

    public static final /* synthetic */ int access$getStart$cp() {
        return Start;
    }

    private /* synthetic */ FabPosition(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2229toStringimpl(int r100) {
        if (m2227equalsimpl0(r100, Start) == false) goto L6;
        return "FabPosition.Start";
    L6:
        if (m2227equalsimpl0(r100, Center) == false) goto L9;
        return "FabPosition.Center";
    L9:
        if (m2227equalsimpl0(r100, End) == false) goto L11;
        return "FabPosition.End";
    L11:
        return "FabPosition.EndOverlay";
    }
}
