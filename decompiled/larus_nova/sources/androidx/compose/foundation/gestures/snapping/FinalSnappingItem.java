package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FinalSnappingItem {
    private static final int ClosestItem = 0;
    public static final Companion Companion = null;
    private static final int NextItem = 0;
    private static final int PreviousItem = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem$Companion;", "", "<init>", "()V", "ClosestItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "getClosestItem-bbeMdSM", "()I", "I", "NextItem", "getNextItem-bbeMdSM", "PreviousItem", "getPreviousItem-bbeMdSM", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getClosestItem-bbeMdSM, reason: not valid java name */
        public final int m548getClosestItembbeMdSM() {
            return FinalSnappingItem.access$getClosestItem$cp();
        }

        /* JADX INFO: renamed from: getNextItem-bbeMdSM, reason: not valid java name */
        public final int m549getNextItembbeMdSM() {
            return FinalSnappingItem.access$getNextItem$cp();
        }

        /* JADX INFO: renamed from: getPreviousItem-bbeMdSM, reason: not valid java name */
        public final int m550getPreviousItembbeMdSM() {
            return FinalSnappingItem.access$getPreviousItem$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FinalSnappingItem m541boximpl(int r100) {
        return new FinalSnappingItem(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m542constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m543equalsimpl(int r100, Object r101) {
        if ((r101 instanceof FinalSnappingItem) == true) goto L6;
        return false;
    L6:
        if (r100 == ((FinalSnappingItem) r101).m547unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m544equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m545hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m546toStringimpl(int r100) {
        return "FinalSnappingItem(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m543equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m545hashCodeimpl(this.value);
    }

    public String toString() {
        return m546toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m547unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        ClosestItem = m542constructorimpl(0);
        NextItem = m542constructorimpl(1);
        PreviousItem = m542constructorimpl(2);
    }

    public static final /* synthetic */ int access$getClosestItem$cp() {
        return ClosestItem;
    }

    public static final /* synthetic */ int access$getNextItem$cp() {
        return NextItem;
    }

    public static final /* synthetic */ int access$getPreviousItem$cp() {
        return PreviousItem;
    }

    private /* synthetic */ FinalSnappingItem(int r100) {
        this.value = r100;
    }
}
