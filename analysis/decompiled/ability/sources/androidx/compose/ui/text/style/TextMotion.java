package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion;", "", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "linearity", "", "subpixelTextPositioning", AppAgent.CONSTRUCT, "(IZLkotlin/jvm/internal/e;)V", "copy-JdDtMQo$ui_text", "(IZ)Landroidx/compose/ui/text/style/TextMotion;", "copy", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "I", "getLinearity-4e0Vf04$ui_text", "Z", "getSubpixelTextPositioning$ui_text", "()Z", "Companion", "Linearity", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextMotion {
    public static final int $stable = 0;
    private static final TextMotion Animated;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Companion;", "", AppAgent.CONSTRUCT, "()V", "Static", "Landroidx/compose/ui/text/style/TextMotion;", "getStatic", "()Landroidx/compose/ui/text/style/TextMotion;", "Animated", "getAnimated", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final TextMotion getAnimated() {
            return TextMotion.Animated;
        }

        public final TextMotion getStatic() {
            return TextMotion.Static;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Linearity {
        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Linear = m6758constructorimpl(1);
        private static final int FontHinting = m6758constructorimpl(2);
        private static final int None = m6758constructorimpl(3);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "", AppAgent.CONSTRUCT, "()V", "Linear", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "getLinear-4e0Vf04", "()I", "I", "FontHinting", "getFontHinting-4e0Vf04", "None", "getNone-4e0Vf04", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* renamed from: getFontHinting-4e0Vf04, reason: not valid java name */
            public final int m6764getFontHinting4e0Vf04() {
                return Linearity.FontHinting;
            }

            /* renamed from: getLinear-4e0Vf04, reason: not valid java name */
            public final int m6765getLinear4e0Vf04() {
                return Linearity.Linear;
            }

            /* renamed from: getNone-4e0Vf04, reason: not valid java name */
            public final int m6766getNone4e0Vf04() {
                return Linearity.None;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Linearity(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Linearity m6757boximpl(int i) {
            return new Linearity(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m6758constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m6759equalsimpl(int i, Object obj) {
            return (obj instanceof Linearity) && i == ((Linearity) obj).getValue();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m6760equalsimpl0(int i, int i6) {
            return i == i6;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m6761hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m6762toStringimpl(int i) {
            return m6760equalsimpl0(i, Linear) ? "Linearity.Linear" : m6760equalsimpl0(i, FontHinting) ? "Linearity.FontHinting" : m6760equalsimpl0(i, None) ? "Linearity.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m6759equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m6761hashCodeimpl(this.value);
        }

        public String toString() {
            return m6762toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }
    }

    static {
        e eVar = null;
        INSTANCE = new Companion(eVar);
        Linearity.Companion companion = Linearity.INSTANCE;
        Static = new TextMotion(companion.m6764getFontHinting4e0Vf04(), false, eVar);
        Animated = new TextMotion(companion.m6765getLinear4e0Vf04(), true, eVar);
    }

    public /* synthetic */ TextMotion(int i, boolean z10, e eVar) {
        this(i, z10);
    }

    /* renamed from: copy-JdDtMQo$ui_text$default, reason: not valid java name */
    public static /* synthetic */ TextMotion m6754copyJdDtMQo$ui_text$default(TextMotion textMotion, int i, boolean z10, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = textMotion.linearity;
        }
        if ((i6 & 2) != 0) {
            z10 = textMotion.subpixelTextPositioning;
        }
        return textMotion.m6755copyJdDtMQo$ui_text(i, z10);
    }

    /* renamed from: copy-JdDtMQo$ui_text, reason: not valid java name */
    public final TextMotion m6755copyJdDtMQo$ui_text(int linearity, boolean subpixelTextPositioning) {
        return new TextMotion(linearity, subpixelTextPositioning, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) other;
        return Linearity.m6760equalsimpl0(this.linearity, textMotion.linearity) && this.subpixelTextPositioning == textMotion.subpixelTextPositioning;
    }

    /* renamed from: getLinearity-4e0Vf04$ui_text, reason: not valid java name and from getter */
    public final int getLinearity() {
        return this.linearity;
    }

    /* renamed from: getSubpixelTextPositioning$ui_text, reason: from getter */
    public final boolean getSubpixelTextPositioning() {
        return this.subpixelTextPositioning;
    }

    public int hashCode() {
        return Boolean.hashCode(this.subpixelTextPositioning) + (Linearity.m6761hashCodeimpl(this.linearity) * 31);
    }

    public String toString() {
        return equals(Static) ? "TextMotion.Static" : equals(Animated) ? "TextMotion.Animated" : "Invalid";
    }

    private TextMotion(int i, boolean z10) {
        this.linearity = i;
        this.subpixelTextPositioning = z10;
    }
}
