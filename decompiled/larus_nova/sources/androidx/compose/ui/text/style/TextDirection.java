package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextDirection {
    public static final Companion Companion = null;
    private static final int Content = 0;
    private static final int ContentOrLtr = 0;
    private static final int ContentOrRtl = 0;
    private static final int Ltr = 0;
    private static final int Rtl = 0;
    private static final int Unspecified = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection$Companion;", "", "<init>", "()V", "Ltr", "Landroidx/compose/ui/text/style/TextDirection;", "getLtr-s_7X-co", "()I", "I", "Rtl", "getRtl-s_7X-co", "Content", "getContent-s_7X-co", "ContentOrLtr", "getContentOrLtr-s_7X-co", "ContentOrRtl", "getContentOrRtl-s_7X-co", "Unspecified", "getUnspecified-s_7X-co", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getContent-s_7X-co, reason: not valid java name */
        public final int m7432getContents_7Xco() {
            return TextDirection.access$getContent$cp();
        }

        /* JADX INFO: renamed from: getContentOrLtr-s_7X-co, reason: not valid java name */
        public final int m7433getContentOrLtrs_7Xco() {
            return TextDirection.access$getContentOrLtr$cp();
        }

        /* JADX INFO: renamed from: getContentOrRtl-s_7X-co, reason: not valid java name */
        public final int m7434getContentOrRtls_7Xco() {
            return TextDirection.access$getContentOrRtl$cp();
        }

        /* JADX INFO: renamed from: getLtr-s_7X-co, reason: not valid java name */
        public final int m7435getLtrs_7Xco() {
            return TextDirection.access$getLtr$cp();
        }

        /* JADX INFO: renamed from: getRtl-s_7X-co, reason: not valid java name */
        public final int m7436getRtls_7Xco() {
            return TextDirection.access$getRtl$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-s_7X-co, reason: not valid java name */
        public final int m7437getUnspecifieds_7Xco() {
            return TextDirection.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m7425boximpl(int r100) {
        return new TextDirection(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m7426constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7427equalsimpl(int r100, Object r101) {
        if ((r101 instanceof TextDirection) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextDirection) r101).m7431unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7428equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7429hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7427equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7429hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7431unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Ltr = m7426constructorimpl(1);
        Rtl = m7426constructorimpl(2);
        Content = m7426constructorimpl(3);
        ContentOrLtr = m7426constructorimpl(4);
        ContentOrRtl = m7426constructorimpl(5);
        Unspecified = m7426constructorimpl(Integer.MIN_VALUE);
    }

    public String toString() {
        return m7430toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getContent$cp() {
        return Content;
    }

    public static final /* synthetic */ int access$getContentOrLtr$cp() {
        return ContentOrLtr;
    }

    public static final /* synthetic */ int access$getContentOrRtl$cp() {
        return ContentOrRtl;
    }

    public static final /* synthetic */ int access$getLtr$cp() {
        return Ltr;
    }

    public static final /* synthetic */ int access$getRtl$cp() {
        return Rtl;
    }

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ TextDirection(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7430toStringimpl(int r100) {
        if (m7428equalsimpl0(r100, Ltr) == false) goto L6;
        return "Ltr";
    L6:
        if (m7428equalsimpl0(r100, Rtl) == false) goto L9;
        return "Rtl";
    L9:
        if (m7428equalsimpl0(r100, Content) == false) goto L12;
        return "Content";
    L12:
        if (m7428equalsimpl0(r100, ContentOrLtr) == false) goto L15;
        return "ContentOrLtr";
    L15:
        if (m7428equalsimpl0(r100, ContentOrRtl) == false) goto L18;
        return "ContentOrRtl";
    L18:
        if (m7428equalsimpl0(r100, Unspecified) == false) goto L20;
        return "Unspecified";
    L20:
        return "Invalid";
    }
}
