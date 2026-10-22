package androidx.compose.ui.text.input;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class KeyboardType {
    private static final int Ascii = 0;
    public static final Companion Companion = null;
    private static final int Decimal = 0;
    private static final int Email = 0;
    private static final int Number = 0;
    private static final int NumberPassword = 0;
    private static final int Password = 0;
    private static final int Phone = 0;
    private static final int Text = 0;
    private static final int Unspecified = 0;
    private static final int Uri = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/KeyboardType;", "getUnspecified-PjHm6EE$annotations", "getUnspecified-PjHm6EE", "()I", "I", "Text", "getText-PjHm6EE$annotations", "getText-PjHm6EE", "Ascii", "getAscii-PjHm6EE$annotations", "getAscii-PjHm6EE", "Number", "getNumber-PjHm6EE$annotations", "getNumber-PjHm6EE", "Phone", "getPhone-PjHm6EE$annotations", "getPhone-PjHm6EE", "Uri", "getUri-PjHm6EE$annotations", "getUri-PjHm6EE", "Email", "getEmail-PjHm6EE$annotations", "getEmail-PjHm6EE", CancelRetainContactInfoFunctions.Password, "getPassword-PjHm6EE$annotations", "getPassword-PjHm6EE", "NumberPassword", "getNumberPassword-PjHm6EE$annotations", "getNumberPassword-PjHm6EE", "Decimal", "getDecimal-PjHm6EE$annotations", "getDecimal-PjHm6EE", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAscii-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7224getAsciiPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getDecimal-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7225getDecimalPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getEmail-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7226getEmailPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getNumber-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7227getNumberPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7228getNumberPasswordPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getPassword-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7229getPasswordPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getPhone-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7230getPhonePjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getText-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7231getTextPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7232getUnspecifiedPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getUri-PjHm6EE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7233getUriPjHm6EE$annotations() {
        }

        /* JADX INFO: renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m7234getAsciiPjHm6EE() {
            return KeyboardType.access$getAscii$cp();
        }

        /* JADX INFO: renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m7235getDecimalPjHm6EE() {
            return KeyboardType.access$getDecimal$cp();
        }

        /* JADX INFO: renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m7236getEmailPjHm6EE() {
            return KeyboardType.access$getEmail$cp();
        }

        /* JADX INFO: renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m7237getNumberPjHm6EE() {
            return KeyboardType.access$getNumber$cp();
        }

        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m7238getNumberPasswordPjHm6EE() {
            return KeyboardType.access$getNumberPassword$cp();
        }

        /* JADX INFO: renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m7239getPasswordPjHm6EE() {
            return KeyboardType.access$getPassword$cp();
        }

        /* JADX INFO: renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m7240getPhonePjHm6EE() {
            return KeyboardType.access$getPhone$cp();
        }

        /* JADX INFO: renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m7241getTextPjHm6EE() {
            return KeyboardType.access$getText$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-PjHm6EE, reason: not valid java name */
        public final int m7242getUnspecifiedPjHm6EE() {
            return KeyboardType.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m7243getUriPjHm6EE() {
            return KeyboardType.access$getUri$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m7217boximpl(int r100) {
        return new KeyboardType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m7218constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7219equalsimpl(int r100, Object r101) {
        if ((r101 instanceof KeyboardType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((KeyboardType) r101).m7223unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7220equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7221hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7219equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7221hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7223unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Unspecified = m7218constructorimpl(0);
        Text = m7218constructorimpl(1);
        Ascii = m7218constructorimpl(2);
        Number = m7218constructorimpl(3);
        Phone = m7218constructorimpl(4);
        Uri = m7218constructorimpl(5);
        Email = m7218constructorimpl(6);
        Password = m7218constructorimpl(7);
        NumberPassword = m7218constructorimpl(8);
        Decimal = m7218constructorimpl(9);
    }

    public String toString() {
        return m7222toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAscii$cp() {
        return Ascii;
    }

    public static final /* synthetic */ int access$getDecimal$cp() {
        return Decimal;
    }

    public static final /* synthetic */ int access$getEmail$cp() {
        return Email;
    }

    public static final /* synthetic */ int access$getNumber$cp() {
        return Number;
    }

    public static final /* synthetic */ int access$getNumberPassword$cp() {
        return NumberPassword;
    }

    public static final /* synthetic */ int access$getPassword$cp() {
        return Password;
    }

    public static final /* synthetic */ int access$getPhone$cp() {
        return Phone;
    }

    public static final /* synthetic */ int access$getText$cp() {
        return Text;
    }

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    public static final /* synthetic */ int access$getUri$cp() {
        return Uri;
    }

    private /* synthetic */ KeyboardType(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7222toStringimpl(int r100) {
        if (m7220equalsimpl0(r100, Unspecified) == false) goto L6;
        return "Unspecified";
    L6:
        if (m7220equalsimpl0(r100, Text) == false) goto L9;
        return "Text";
    L9:
        if (m7220equalsimpl0(r100, Ascii) == false) goto L12;
        return "Ascii";
    L12:
        if (m7220equalsimpl0(r100, Number) == false) goto L15;
        return "Number";
    L15:
        if (m7220equalsimpl0(r100, Phone) == false) goto L18;
        return "Phone";
    L18:
        if (m7220equalsimpl0(r100, Uri) == false) goto L21;
        return "Uri";
    L21:
        if (m7220equalsimpl0(r100, Email) == false) goto L24;
        return "Email";
    L24:
        if (m7220equalsimpl0(r100, Password) == false) goto L27;
        return CancelRetainContactInfoFunctions.Password;
    L27:
        if (m7220equalsimpl0(r100, NumberPassword) == false) goto L30;
        return "NumberPassword";
    L30:
        if (m7220equalsimpl0(r100, Decimal) == false) goto L32;
        return "Decimal";
    L32:
        return "Invalid";
    }
}
