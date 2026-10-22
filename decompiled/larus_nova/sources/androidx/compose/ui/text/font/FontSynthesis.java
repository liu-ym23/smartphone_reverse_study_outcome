package androidx.compose.ui.text.font;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isWeightOn", "", "isWeightOn-impl$ui_text", "(I)Z", "isStyleOn", "isStyleOn-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FontSynthesis {
    private static final int All = 0;
    public static final Companion Companion = null;
    private static final int None = 0;
    private static final int Style = 0;
    private static final int Weight = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNone-GVVA2EU", "()I", "I", "Weight", "getWeight-GVVA2EU", "Style", "getStyle-GVVA2EU", CancelRetainContactInfoFunctions.All, "getAll-GVVA2EU", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m7129getAllGVVA2EU() {
            return FontSynthesis.access$getAll$cp();
        }

        /* JADX INFO: renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m7130getNoneGVVA2EU() {
            return FontSynthesis.access$getNone$cp();
        }

        /* JADX INFO: renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m7131getStyleGVVA2EU() {
            return FontSynthesis.access$getStyle$cp();
        }

        /* JADX INFO: renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m7132getWeightGVVA2EU() {
            return FontSynthesis.access$getWeight$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m7120boximpl(int r100) {
        return new FontSynthesis(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m7121constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7122equalsimpl(int r100, Object r101) {
        if ((r101 instanceof FontSynthesis) == true) goto L6;
        return false;
    L6:
        if (r100 == ((FontSynthesis) r101).m7128unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7123equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7124hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: isStyleOn-impl$ui_text, reason: not valid java name */
    public static final boolean m7125isStyleOnimpl$ui_text(int r100) {
        if ((r100 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isWeightOn-impl$ui_text, reason: not valid java name */
    public static final boolean m7126isWeightOnimpl$ui_text(int r100) {
        if ((r100 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean equals(Object r100) {
        return m7122equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7124hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7128unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        None = m7121constructorimpl(0);
        Weight = m7121constructorimpl(1);
        Style = m7121constructorimpl(2);
        All = m7121constructorimpl(65535);
    }

    public String toString() {
        return m7127toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAll$cp() {
        return All;
    }

    public static final /* synthetic */ int access$getNone$cp() {
        return None;
    }

    public static final /* synthetic */ int access$getStyle$cp() {
        return Style;
    }

    public static final /* synthetic */ int access$getWeight$cp() {
        return Weight;
    }

    private /* synthetic */ FontSynthesis(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7127toStringimpl(int r100) {
        if (m7123equalsimpl0(r100, None) == false) goto L6;
        return "None";
    L6:
        if (m7123equalsimpl0(r100, Weight) == false) goto L9;
        return "Weight";
    L9:
        if (m7123equalsimpl0(r100, Style) == false) goto L12;
        return "Style";
    L12:
        if (m7123equalsimpl0(r100, All) == false) goto L14;
        return CancelRetainContactInfoFunctions.All;
    L14:
        return "Invalid";
    }
}
