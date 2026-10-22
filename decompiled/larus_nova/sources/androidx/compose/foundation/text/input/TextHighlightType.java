package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/TextHighlightType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextHighlightType {
    public static final Companion Companion = null;
    private static final int HandwritingDeletePreview = 0;
    private static final int HandwritingSelectPreview = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/input/TextHighlightType$Companion;", "", "<init>", "()V", "HandwritingSelectPreview", "Landroidx/compose/foundation/text/input/TextHighlightType;", "getHandwritingSelectPreview-s-xJuwY", "()I", "I", "HandwritingDeletePreview", "getHandwritingDeletePreview-s-xJuwY", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getHandwritingDeletePreview-s-xJuwY, reason: not valid java name */
        public final int m1210getHandwritingDeletePreviewsxJuwY() {
            return TextHighlightType.access$getHandwritingDeletePreview$cp();
        }

        /* JADX INFO: renamed from: getHandwritingSelectPreview-s-xJuwY, reason: not valid java name */
        public final int m1211getHandwritingSelectPreviewsxJuwY() {
            return TextHighlightType.access$getHandwritingSelectPreview$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextHighlightType m1203boximpl(int r100) {
        return new TextHighlightType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1204constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1205equalsimpl(int r100, Object r101) {
        if ((r101 instanceof TextHighlightType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextHighlightType) r101).m1209unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1206equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1207hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1208toStringimpl(int r100) {
        return "TextHighlightType(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m1205equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m1207hashCodeimpl(this.value);
    }

    public String toString() {
        return m1208toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1209unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        HandwritingSelectPreview = m1204constructorimpl(0);
        HandwritingDeletePreview = m1204constructorimpl(1);
    }

    public static final /* synthetic */ int access$getHandwritingDeletePreview$cp() {
        return HandwritingDeletePreview;
    }

    public static final /* synthetic */ int access$getHandwritingSelectPreview$cp() {
        return HandwritingSelectPreview;
    }

    private /* synthetic */ TextHighlightType(int r100) {
        this.value = r100;
    }
}
