package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion;", "", "linearity", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "subpixelTextPositioning", "", "<init>", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLinearity-4e0Vf04$ui_text", "()I", "I", "getSubpixelTextPositioning$ui_text", "()Z", "copy", "copy-JdDtMQo$ui_text", "(IZ)Landroidx/compose/ui/text/style/TextMotion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "Linearity", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextMotion {
    public static final int $stable = 0;
    private static final TextMotion Animated = null;
    public static final Companion Companion = null;
    private static final TextMotion Static = null;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Companion;", "", "<init>", "()V", "Static", "Landroidx/compose/ui/text/style/TextMotion;", "getStatic", "()Landroidx/compose/ui/text/style/TextMotion;", "Animated", "getAnimated", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TextMotion getAnimated() {
            return TextMotion.access$getAnimated$cp();
        }

        public final TextMotion getStatic() {
            return TextMotion.access$getStatic$cp();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Linearity {
        public static final Companion Companion = null;
        private static final int FontHinting = 0;
        private static final int Linear = 0;
        private static final int None = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "", "<init>", "()V", "Linear", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "getLinear-4e0Vf04", "()I", "I", "FontHinting", "getFontHinting-4e0Vf04", "None", "getNone-4e0Vf04", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getFontHinting-4e0Vf04, reason: not valid java name */
            public final int m7454getFontHinting4e0Vf04() {
                return Linearity.access$getFontHinting$cp();
            }

            /* JADX INFO: renamed from: getLinear-4e0Vf04, reason: not valid java name */
            public final int m7455getLinear4e0Vf04() {
                return Linearity.access$getLinear$cp();
            }

            /* JADX INFO: renamed from: getNone-4e0Vf04, reason: not valid java name */
            public final int m7456getNone4e0Vf04() {
                return Linearity.access$getNone$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Linearity m7447boximpl(int r100) {
            return new Linearity(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m7448constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7449equalsimpl(int r100, Object r101) {
            if ((r101 instanceof Linearity) == true) goto L6;
            return false;
        L6:
            if (r100 == ((Linearity) r101).m7453unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7450equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7451hashCodeimpl(int r100) {
            return r100;
        }

        public boolean equals(Object r100) {
            return m7449equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7451hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7453unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Linear = m7448constructorimpl(1);
            FontHinting = m7448constructorimpl(2);
            None = m7448constructorimpl(3);
        }

        public String toString() {
            return m7452toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getFontHinting$cp() {
            return FontHinting;
        }

        public static final /* synthetic */ int access$getLinear$cp() {
            return Linear;
        }

        public static final /* synthetic */ int access$getNone$cp() {
            return None;
        }

        private /* synthetic */ Linearity(int r100) {
            this.value = r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7452toStringimpl(int r100) {
            if (m7450equalsimpl0(r100, Linear) == false) goto L6;
            return "Linearity.Linear";
        L6:
            if (m7450equalsimpl0(r100, FontHinting) == false) goto L9;
            return "Linearity.FontHinting";
        L9:
            if (m7450equalsimpl0(r100, None) == false) goto L11;
            return "Linearity.None";
        L11:
            return "Invalid";
        }
    }

    public /* synthetic */ TextMotion(int r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        DefaultConstructorMarker r100 = null;
        Companion = new Companion(r100);
        Linearity.Companion r101 = Linearity.Companion;
        Static = new TextMotion(r101.m7454getFontHinting4e0Vf04(), false, r100);
        Animated = new TextMotion(r101.m7455getLinear4e0Vf04(), true, r100);
    }

    public int hashCode() {
        int r100 = Linearity.m7451hashCodeimpl(this.linearity) * 31;
        if (this.subpixelTextPositioning == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        if (Intrinsics.areEqual(this, Static) == false) goto L6;
        return "TextMotion.Static";
    L6:
        if (Intrinsics.areEqual(this, Animated) == false) goto L8;
        return "TextMotion.Animated";
    L8:
        return "Invalid";
    }

    public static final /* synthetic */ TextMotion access$getAnimated$cp() {
        return Animated;
    }

    public static final /* synthetic */ TextMotion access$getStatic$cp() {
        return Static;
    }

    /* JADX INFO: renamed from: getLinearity-4e0Vf04$ui_text, reason: not valid java name */
    public final int m7446getLinearity4e0Vf04$ui_text() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text() {
        return this.subpixelTextPositioning;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextMotion) == true) goto L8;
        return false;
    L8:
        TextMotion r101 = (TextMotion) r100;
        if (Linearity.m7450equalsimpl0(this.linearity, r101.linearity) == true) goto L12;
        return false;
    L12:
        if (this.subpixelTextPositioning == r101.subpixelTextPositioning) goto L14;
        return false;
    L14:
        return true;
    }

    private TextMotion(int r100, boolean r101) {
        this.linearity = r100;
        this.subpixelTextPositioning = r101;
    }

    /* JADX INFO: renamed from: copy-JdDtMQo$ui_text, reason: not valid java name */
    public final TextMotion m7445copyJdDtMQo$ui_text(int r100, boolean r101) {
        return new TextMotion(r100, r101, null);
    }

    /* JADX INFO: renamed from: copy-JdDtMQo$ui_text$default, reason: not valid java name */
    public static /* synthetic */ TextMotion m7444copyJdDtMQo$ui_text$default(TextMotion r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.linearity;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.subpixelTextPositioning;
    L9:
        return r100.m7445copyJdDtMQo$ui_text(r101, r102);
    }
}
