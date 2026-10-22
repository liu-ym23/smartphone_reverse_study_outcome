package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FontLoadingStrategy {
    private static final int Async = 0;
    private static final int Blocking = 0;
    public static final Companion Companion = null;
    private static final int OptionalLocal = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/font/FontLoadingStrategy$Companion;", "", "<init>", "()V", "Blocking", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getBlocking-PKNRLFQ", "()I", "I", "OptionalLocal", "getOptionalLocal-PKNRLFQ", "Async", "getAsync-PKNRLFQ", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAsync-PKNRLFQ, reason: not valid java name */
        public final int m7103getAsyncPKNRLFQ() {
            return FontLoadingStrategy.access$getAsync$cp();
        }

        /* JADX INFO: renamed from: getBlocking-PKNRLFQ, reason: not valid java name */
        public final int m7104getBlockingPKNRLFQ() {
            return FontLoadingStrategy.access$getBlocking$cp();
        }

        /* JADX INFO: renamed from: getOptionalLocal-PKNRLFQ, reason: not valid java name */
        public final int m7105getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.access$getOptionalLocal$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontLoadingStrategy m7096boximpl(int r100) {
        return new FontLoadingStrategy(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m7097constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7098equalsimpl(int r100, Object r101) {
        if ((r101 instanceof FontLoadingStrategy) == true) goto L6;
        return false;
    L6:
        if (r100 == ((FontLoadingStrategy) r101).m7102unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7099equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7100hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7098equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7100hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7102unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Blocking = m7097constructorimpl(0);
        OptionalLocal = m7097constructorimpl(1);
        Async = m7097constructorimpl(2);
    }

    public String toString() {
        return m7101toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAsync$cp() {
        return Async;
    }

    public static final /* synthetic */ int access$getBlocking$cp() {
        return Blocking;
    }

    public static final /* synthetic */ int access$getOptionalLocal$cp() {
        return OptionalLocal;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ FontLoadingStrategy(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7101toStringimpl(int r100) {
        if (m7099equalsimpl0(r100, Blocking) == false) goto L6;
        return "Blocking";
    L6:
        if (m7099equalsimpl0(r100, OptionalLocal) == false) goto L9;
        return "Optional";
    L9:
        if (m7099equalsimpl0(r100, Async) == false) goto L12;
        return "Async";
    L12:
        return "Invalid(value=" + r100 + ')';
    }
}
