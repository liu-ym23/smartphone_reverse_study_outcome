package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextUnitType {
    public static final Companion Companion = null;
    private static final long Em = 0;
    private static final long Sp = 0;
    private static final long Unspecified = 0;
    private final long type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/unit/TextUnitType;", "getUnspecified-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Em", "getEm-UIouoOA", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m7774getEmUIouoOA() {
            return TextUnitType.access$getEm$cp();
        }

        /* JADX INFO: renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m7775getSpUIouoOA() {
            return TextUnitType.access$getSp$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m7776getUnspecifiedUIouoOA() {
            return TextUnitType.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m7767boximpl(long r100) {
        return new TextUnitType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7768constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7769equalsimpl(long r100, Object r101) {
        if ((r101 instanceof TextUnitType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextUnitType) r101).m7773unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7770equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7771hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7769equalsimpl(this.type, r100);
    }

    public int hashCode() {
        return m7771hashCodeimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7773unboximpl() {
        return this.type;
    }

    static {
        Companion = new Companion(null);
        Unspecified = m7768constructorimpl(0);
        Sp = m7768constructorimpl(4294967296L);
        Em = m7768constructorimpl(8589934592L);
    }

    public String toString() {
        return m7772toStringimpl(this.type);
    }

    public static final /* synthetic */ long access$getEm$cp() {
        return Em;
    }

    public static final /* synthetic */ long access$getSp$cp() {
        return Sp;
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ TextUnitType(long r100) {
        this.type = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7772toStringimpl(long r100) {
        if (m7770equalsimpl0(r100, Unspecified) == false) goto L6;
        return "Unspecified";
    L6:
        if (m7770equalsimpl0(r100, Sp) == false) goto L9;
        return "Sp";
    L9:
        if (m7770equalsimpl0(r100, Em) == false) goto L11;
        return "Em";
    L11:
        return "Invalid";
    }
}
