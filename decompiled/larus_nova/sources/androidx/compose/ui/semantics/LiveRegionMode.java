package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/semantics/LiveRegionMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class LiveRegionMode {
    private static final int Assertive = 0;
    public static final Companion Companion = null;
    private static final int Polite = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/semantics/LiveRegionMode$Companion;", "", "<init>", "()V", "Polite", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getPolite-0phEisY", "()I", "I", "Assertive", "getAssertive-0phEisY", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAssertive-0phEisY, reason: not valid java name */
        public final int m6760getAssertive0phEisY() {
            return LiveRegionMode.access$getAssertive$cp();
        }

        /* JADX INFO: renamed from: getPolite-0phEisY, reason: not valid java name */
        public final int m6761getPolite0phEisY() {
            return LiveRegionMode.access$getPolite$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m6753boximpl(int r100) {
        return new LiveRegionMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m6754constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6755equalsimpl(int r100, Object r101) {
        if ((r101 instanceof LiveRegionMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((LiveRegionMode) r101).m6759unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6756equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6757hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m6755equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6757hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6759unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Polite = m6754constructorimpl(0);
        Assertive = m6754constructorimpl(1);
    }

    public String toString() {
        return m6758toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAssertive$cp() {
        return Assertive;
    }

    public static final /* synthetic */ int access$getPolite$cp() {
        return Polite;
    }

    private /* synthetic */ LiveRegionMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6758toStringimpl(int r100) {
        if (m6756equalsimpl0(r100, Polite) == false) goto L6;
        return "Polite";
    L6:
        if (m6756equalsimpl0(r100, Assertive) == false) goto L8;
        return "Assertive";
    L8:
        return "Unknown";
    }
}
