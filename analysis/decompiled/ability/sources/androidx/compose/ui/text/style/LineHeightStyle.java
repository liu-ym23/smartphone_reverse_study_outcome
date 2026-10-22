package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "mode", AppAgent.CONSTRUCT, "(FIILkotlin/jvm/internal/e;)V", "(FILkotlin/jvm/internal/e;)V", "copy-38bxuX8", "(FII)Landroidx/compose/ui/text/style/LineHeightStyle;", "copy", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getAlignment-PIaL0Z0", "()F", "I", "getTrim-EVpEnUU", "getMode-lzQqcRY", "Companion", "Trim", "Alignment", "Mode", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LineHeightStyle {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int mode;
    private final int trim;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Alignment {
        private final float topRatio;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final float Top = m6689constructorimpl(0.0f);
        private static final float Center = m6689constructorimpl(0.5f);
        private static final float Proportional = m6689constructorimpl(-1.0f);
        private static final float Bottom = m6689constructorimpl(1.0f);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", AppAgent.CONSTRUCT, "()V", "Top", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getTop-PIaL0Z0", "()F", "F", "Center", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0", "Bottom", "getBottom-PIaL0Z0", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* renamed from: getBottom-PIaL0Z0, reason: not valid java name */
            public final float m6695getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }

            /* renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m6696getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m6697getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* renamed from: getTop-PIaL0Z0, reason: not valid java name */
            public final float m6698getTopPIaL0Z0() {
                return Alignment.Top;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Alignment(float f) {
            this.topRatio = f;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Alignment m6688boximpl(float f) {
            return new Alignment(f);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static float m6689constructorimpl(float f) {
            if (!((0.0f <= f && f <= 1.0f) || f == -1.0f)) {
                InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m6690equalsimpl(float f, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f, ((Alignment) obj).getTopRatio()) == 0;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6691equalsimpl0(float f, float f7) {
            return Float.compare(f, f7) == 0;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m6692hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m6693toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        public boolean equals(Object other) {
            return m6690equalsimpl(this.topRatio, other);
        }

        public int hashCode() {
            return m6692hashCodeimpl(this.topRatio);
        }

        public String toString() {
            return m6693toStringimpl(this.topRatio);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ float getTopRatio() {
            return this.topRatio;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", AppAgent.CONSTRUCT, "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mode {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Fixed = m6700constructorimpl(0);
        private static final int Minimum = m6700constructorimpl(1);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "", AppAgent.CONSTRUCT, "()V", "Fixed", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "getFixed-lzQqcRY", "()I", "I", "Minimum", "getMinimum-lzQqcRY", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* renamed from: getFixed-lzQqcRY, reason: not valid java name */
            public final int m6706getFixedlzQqcRY() {
                return Mode.Fixed;
            }

            /* renamed from: getMinimum-lzQqcRY, reason: not valid java name */
            public final int m6707getMinimumlzQqcRY() {
                return Mode.Minimum;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Mode(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Mode m6699boximpl(int i) {
            return new Mode(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m6700constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m6701equalsimpl(int i, Object obj) {
            return (obj instanceof Mode) && i == ((Mode) obj).getValue();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6702equalsimpl0(int i, int i6) {
            return i == i6;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m6703hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m6704toStringimpl(int i) {
            return androidx.appfunctions.metadata.a.k("Mode(value=", i, ')');
        }

        public boolean equals(Object other) {
            return m6701equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m6703hashCodeimpl(this.value);
        }

        public String toString() {
            return m6704toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isTrimFirstLineTop", "", "isTrimFirstLineTop-impl$ui_text", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Trim {
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int FirstLineTop = m6709constructorimpl(1);
        private static final int LastLineBottom = m6709constructorimpl(16);
        private static final int Both = m6709constructorimpl(17);
        private static final int None = m6709constructorimpl(0);

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u000e\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0010\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", AppAgent.CONSTRUCT, "()V", "FlagTrimTop", "", "FlagTrimBottom", "FirstLineTop", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getFirstLineTop-EVpEnUU", "()I", "I", "LastLineBottom", "getLastLineBottom-EVpEnUU", "Both", "getBoth-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m6717getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getFirstLineTop-EVpEnUU, reason: not valid java name */
            public final int m6718getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* renamed from: getLastLineBottom-EVpEnUU, reason: not valid java name */
            public final int m6719getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m6720getNoneEVpEnUU() {
                return Trim.None;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Trim(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Trim m6708boximpl(int i) {
            return new Trim(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m6709constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m6710equalsimpl(int i, Object obj) {
            return (obj instanceof Trim) && i == ((Trim) obj).getValue();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6711equalsimpl0(int i, int i6) {
            return i == i6;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m6712hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text, reason: not valid java name */
        public static final boolean m6713isTrimFirstLineTopimpl$ui_text(int i) {
            return (i & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text, reason: not valid java name */
        public static final boolean m6714isTrimLastLineBottomimpl$ui_text(int i) {
            return (i & 16) > 0;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m6715toStringimpl(int i) {
            return i == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i == Both ? "LineHeightStyle.Trim.Both" : i == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public boolean equals(Object other) {
            return m6710equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m6712hashCodeimpl(this.value);
        }

        public String toString() {
            return m6715toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }
    }

    static {
        e eVar = null;
        INSTANCE = new Companion(eVar);
        Default = new LineHeightStyle(Alignment.INSTANCE.m6697getProportionalPIaL0Z0(), Trim.INSTANCE.m6717getBothEVpEnUU(), Mode.INSTANCE.m6706getFixedlzQqcRY(), eVar);
    }

    public /* synthetic */ LineHeightStyle(float f, int i, int i6, e eVar) {
        this(f, i, i6);
    }

    /* renamed from: copy-38bxuX8$default, reason: not valid java name */
    public static /* synthetic */ LineHeightStyle m6683copy38bxuX8$default(LineHeightStyle lineHeightStyle, float f, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = lineHeightStyle.alignment;
        }
        if ((i10 & 2) != 0) {
            i = lineHeightStyle.trim;
        }
        if ((i10 & 4) != 0) {
            i6 = lineHeightStyle.mode;
        }
        return lineHeightStyle.m6684copy38bxuX8(f, i, i6);
    }

    /* renamed from: copy-38bxuX8, reason: not valid java name */
    public final LineHeightStyle m6684copy38bxuX8(float alignment, int trim, int mode) {
        return new LineHeightStyle(alignment, trim, mode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) other;
        return Alignment.m6691equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m6711equalsimpl0(this.trim, lineHeightStyle.trim) && Mode.m6702equalsimpl0(this.mode, lineHeightStyle.mode);
    }

    /* renamed from: getAlignment-PIaL0Z0, reason: not valid java name and from getter */
    public final float getAlignment() {
        return this.alignment;
    }

    /* renamed from: getMode-lzQqcRY, reason: not valid java name and from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: getTrim-EVpEnUU, reason: not valid java name and from getter */
    public final int getTrim() {
        return this.trim;
    }

    public int hashCode() {
        return Mode.m6703hashCodeimpl(this.mode) + ((Trim.m6712hashCodeimpl(this.trim) + (Alignment.m6692hashCodeimpl(this.alignment) * 31)) * 31);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m6693toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m6715toStringimpl(this.trim)) + ",mode=" + ((Object) Mode.m6704toStringimpl(this.mode)) + ')';
    }

    public /* synthetic */ LineHeightStyle(float f, int i, e eVar) {
        this(f, i);
    }

    private LineHeightStyle(float f, int i, int i6) {
        this.alignment = f;
        this.trim = i;
        this.mode = i6;
    }

    private LineHeightStyle(float f, int i) {
        this(f, i, Mode.INSTANCE.m6706getFixedlzQqcRY(), null);
    }
}
