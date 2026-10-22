package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "mode", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "<init>", "(FIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", FaceService.girlLabel, "getTrim-EVpEnUU", "()I", "I", "getMode-lzQqcRY", "copy", "copy-38bxuX8", "(FII)Landroidx/compose/ui/text/style/LineHeightStyle;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Trim", "Alignment", "Mode", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LineHeightStyle {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final LineHeightStyle Default = null;
    private final float alignment;
    private final int mode;
    private final int trim;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Alignment {
        private static final float Bottom = 0.0f;
        private static final float Center = 0.0f;
        public static final Companion Companion = null;
        private static final float Proportional = 0.0f;
        private static final float Top = 0.0f;
        private final float topRatio;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "<init>", "()V", "Top", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getTop-PIaL0Z0", "()F", FaceService.girlLabel, "Center", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0", "Bottom", "getBottom-PIaL0Z0", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getBottom-PIaL0Z0, reason: not valid java name */
            public final float m7385getBottomPIaL0Z0() {
                return Alignment.access$getBottom$cp();
            }

            /* JADX INFO: renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m7386getCenterPIaL0Z0() {
                return Alignment.access$getCenter$cp();
            }

            /* JADX INFO: renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m7387getProportionalPIaL0Z0() {
                return Alignment.access$getProportional$cp();
            }

            /* JADX INFO: renamed from: getTop-PIaL0Z0, reason: not valid java name */
            public final float m7388getTopPIaL0Z0() {
                return Alignment.access$getTop$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Alignment m7378boximpl(float r100) {
            return new Alignment(r100);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7380equalsimpl(float r100, Object r101) {
            if ((r101 instanceof Alignment) == true) goto L6;
            return false;
        L6:
            if (Float.compare(r100, ((Alignment) r101).m7384unboximpl()) == 0) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7381equalsimpl0(float r100, float r101) {
            if (Float.compare(r100, r101) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7382hashCodeimpl(float r100) {
            return Float.floatToIntBits(r100);
        }

        public boolean equals(Object r100) {
            return m7380equalsimpl(this.topRatio, r100);
        }

        public int hashCode() {
            return m7382hashCodeimpl(this.topRatio);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ float m7384unboximpl() {
            return this.topRatio;
        }

        static {
            Companion = new Companion(null);
            Top = m7379constructorimpl(0.0f);
            Center = m7379constructorimpl(0.5f);
            Proportional = m7379constructorimpl(-1.0f);
            Bottom = m7379constructorimpl(1.0f);
        }

        public String toString() {
            return m7383toStringimpl(this.topRatio);
        }

        public static final /* synthetic */ float access$getBottom$cp() {
            return Bottom;
        }

        public static final /* synthetic */ float access$getCenter$cp() {
            return Center;
        }

        public static final /* synthetic */ float access$getProportional$cp() {
            return Proportional;
        }

        public static final /* synthetic */ float access$getTop$cp() {
            return Top;
        }

        private /* synthetic */ Alignment(float r100) {
            this.topRatio = r100;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static float m7379constructorimpl(float r100) {
            boolean r101 = true;
            if (0.0f <= r100) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
        L16:
            if (r101 == true) goto L18;
            InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
        L18:
            return r100;
        L10:
            if (r100 != (-1.0f)) goto L12;
            boolean r103 = true;
        L13:
            if (r103 == true) goto L16;
            r101 = false;
            goto L16
        L12:
            r103 = false;
            goto L13
        L5:
            if (r100 > 1.0f) goto L7;
            r102 = true;
            goto L8
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7383toStringimpl(float r100) {
            boolean r101 = true;
            if (r100 != Top) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return "LineHeightStyle.Alignment.Top";
        L9:
            if (r100 != Center) goto L11;
            boolean r103 = true;
        L12:
            if (r103 == false) goto L15;
            return "LineHeightStyle.Alignment.Center";
        L15:
            if (r100 != Proportional) goto L17;
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            return "LineHeightStyle.Alignment.Proportional";
        L21:
            if (r100 == Bottom) goto L24;
            r101 = false;
        L24:
            if (r101 == false) goto L27;
            return "LineHeightStyle.Alignment.Bottom";
        L27:
            return "LineHeightStyle.Alignment(topPercentage = " + r100 + ')';
        L17:
            r104 = false;
            goto L18
        L11:
            r103 = false;
            goto L12
        L5:
            r102 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.access$getDefault$cp();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Mode {
        public static final Companion Companion = null;
        private static final int Fixed = 0;
        private static final int Minimum = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "", "<init>", "()V", "Fixed", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "getFixed-lzQqcRY", "()I", "I", "Minimum", "getMinimum-lzQqcRY", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getFixed-lzQqcRY, reason: not valid java name */
            public final int m7396getFixedlzQqcRY() {
                return Mode.access$getFixed$cp();
            }

            /* JADX INFO: renamed from: getMinimum-lzQqcRY, reason: not valid java name */
            public final int m7397getMinimumlzQqcRY() {
                return Mode.access$getMinimum$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Mode m7389boximpl(int r100) {
            return new Mode(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m7390constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7391equalsimpl(int r100, Object r101) {
            if ((r101 instanceof Mode) == true) goto L6;
            return false;
        L6:
            if (r100 == ((Mode) r101).m7395unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7392equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7393hashCodeimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7394toStringimpl(int r100) {
            return "Mode(value=" + r100 + ')';
        }

        public boolean equals(Object r100) {
            return m7391equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7393hashCodeimpl(this.value);
        }

        public String toString() {
            return m7394toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7395unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Fixed = m7390constructorimpl(0);
            Minimum = m7390constructorimpl(1);
        }

        public static final /* synthetic */ int access$getFixed$cp() {
            return Fixed;
        }

        public static final /* synthetic */ int access$getMinimum$cp() {
            return Minimum;
        }

        private /* synthetic */ Mode(int r100) {
            this.value = r100;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isTrimFirstLineTop", "", "isTrimFirstLineTop-impl$ui_text", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Trim {
        private static final int Both = 0;
        public static final Companion Companion = null;
        private static final int FirstLineTop = 0;
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private static final int LastLineBottom = 0;
        private static final int None = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u000e\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0010\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "<init>", "()V", "FlagTrimTop", "", "FlagTrimBottom", "FirstLineTop", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getFirstLineTop-EVpEnUU", "()I", "I", "LastLineBottom", "getLastLineBottom-EVpEnUU", "Both", "getBoth-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m7407getBothEVpEnUU() {
                return Trim.access$getBoth$cp();
            }

            /* JADX INFO: renamed from: getFirstLineTop-EVpEnUU, reason: not valid java name */
            public final int m7408getFirstLineTopEVpEnUU() {
                return Trim.access$getFirstLineTop$cp();
            }

            /* JADX INFO: renamed from: getLastLineBottom-EVpEnUU, reason: not valid java name */
            public final int m7409getLastLineBottomEVpEnUU() {
                return Trim.access$getLastLineBottom$cp();
            }

            /* JADX INFO: renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m7410getNoneEVpEnUU() {
                return Trim.access$getNone$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Trim m7398boximpl(int r100) {
            return new Trim(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m7399constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7400equalsimpl(int r100, Object r101) {
            if ((r101 instanceof Trim) == true) goto L6;
            return false;
        L6:
            if (r100 == ((Trim) r101).m7406unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7401equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7402hashCodeimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: isTrimFirstLineTop-impl$ui_text, reason: not valid java name */
        public static final boolean m7403isTrimFirstLineTopimpl$ui_text(int r100) {
            if ((r100 & 1) > 0) goto L7;
            return false;
        L7:
            return true;
        }

        /* JADX INFO: renamed from: isTrimLastLineBottom-impl$ui_text, reason: not valid java name */
        public static final boolean m7404isTrimLastLineBottomimpl$ui_text(int r100) {
            if ((r100 & 16) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean equals(Object r100) {
            return m7400equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7402hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7406unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            FirstLineTop = m7399constructorimpl(1);
            LastLineBottom = m7399constructorimpl(16);
            Both = m7399constructorimpl(17);
            None = m7399constructorimpl(0);
        }

        public String toString() {
            return m7405toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getBoth$cp() {
            return Both;
        }

        public static final /* synthetic */ int access$getFirstLineTop$cp() {
            return FirstLineTop;
        }

        public static final /* synthetic */ int access$getLastLineBottom$cp() {
            return LastLineBottom;
        }

        public static final /* synthetic */ int access$getNone$cp() {
            return None;
        }

        private /* synthetic */ Trim(int r100) {
            this.value = r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7405toStringimpl(int r100) {
            if (r100 != FirstLineTop) goto L6;
            return "LineHeightStyle.Trim.FirstLineTop";
        L6:
            if (r100 != LastLineBottom) goto L9;
            return "LineHeightStyle.Trim.LastLineBottom";
        L9:
            if (r100 != Both) goto L12;
            return "LineHeightStyle.Trim.Both";
        L12:
            if (r100 != None) goto L14;
            return "LineHeightStyle.Trim.None";
        L14:
            return "Invalid";
        }
    }

    public /* synthetic */ LineHeightStyle(float r100, int r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ LineHeightStyle(float r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        DefaultConstructorMarker r100 = null;
        Companion = new Companion(r100);
        Default = new LineHeightStyle(Alignment.Companion.m7387getProportionalPIaL0Z0(), Trim.Companion.m7407getBothEVpEnUU(), Mode.Companion.m7396getFixedlzQqcRY(), r100);
    }

    public int hashCode() {
        return (((Alignment.m7382hashCodeimpl(this.alignment) * 31) + Trim.m7402hashCodeimpl(this.trim)) * 31) + Mode.m7393hashCodeimpl(this.mode);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + Alignment.m7383toStringimpl(this.alignment) + ", trim=" + Trim.m7405toStringimpl(this.trim) + ",mode=" + Mode.m7394toStringimpl(this.mode) + ')';
    }

    public static final /* synthetic */ LineHeightStyle access$getDefault$cp() {
        return Default;
    }

    /* JADX INFO: renamed from: getAlignment-PIaL0Z0, reason: not valid java name */
    public final float m7375getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getMode-lzQqcRY, reason: not valid java name */
    public final int m7376getModelzQqcRY() {
        return this.mode;
    }

    /* JADX INFO: renamed from: getTrim-EVpEnUU, reason: not valid java name */
    public final int m7377getTrimEVpEnUU() {
        return this.trim;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LineHeightStyle) == true) goto L8;
        return false;
    L8:
        LineHeightStyle r101 = (LineHeightStyle) r100;
        if (Alignment.m7381equalsimpl0(this.alignment, r101.alignment) == true) goto L12;
        return false;
    L12:
        if (Trim.m7401equalsimpl0(this.trim, r101.trim) == true) goto L15;
        return false;
    L15:
        if (Mode.m7392equalsimpl0(this.mode, r101.mode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private LineHeightStyle(float r100, int r101) {
        this(r100, r101, Mode.Companion.m7396getFixedlzQqcRY(), null);
    }

    private LineHeightStyle(float r100, int r101, int r102) {
        this.alignment = r100;
        this.trim = r101;
        this.mode = r102;
    }

    /* JADX INFO: renamed from: copy-38bxuX8, reason: not valid java name */
    public final LineHeightStyle m7374copy38bxuX8(float r100, int r101, int r102) {
        return new LineHeightStyle(r100, r101, r102, null);
    }

    /* JADX INFO: renamed from: copy-38bxuX8$default, reason: not valid java name */
    public static /* synthetic */ LineHeightStyle m7373copy38bxuX8$default(LineHeightStyle r100, float r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.alignment;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.trim;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.mode;
    L12:
        return r100.m7374copy38bxuX8(r101, r102, r103);
    }
}
