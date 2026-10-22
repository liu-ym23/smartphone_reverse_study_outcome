package androidx.compose.foundation.text;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\u0088\u0001\u0002¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/MenuItemsAvailability;", "", "value", "", "constructor-impl", "(I)I", "canCopy", "", "canPaste", "canCut", "canSelectAll", "canAutofill", "(ZZZZZ)I", "getValue", "()I", "getCanCopy-impl", "(I)Z", "getCanPaste-impl", "getCanCut-impl", "getCanSelectAll-impl", "getCanAutofill-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class MenuItemsAvailability {
    private static final int AUTO_FILL = 16;
    private static final int COPY = 1;
    private static final int CUT = 4;
    public static final Companion Companion = null;
    private static final int NONE = 0;
    private static final int None = 0;
    private static final int PASTE = 2;
    private static final int SELECT_ALL = 8;
    private final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/MenuItemsAvailability$Companion;", "", "<init>", "()V", "COPY", "", "PASTE", "CUT", "SELECT_ALL", "AUTO_FILL", UserProfileEvent.POSITION_NONE, "None", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "getNone-JKCFgKw", "()I", "I", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getNone-JKCFgKw, reason: not valid java name */
        public final int m1118getNoneJKCFgKw() {
            return MenuItemsAvailability.access$getNone$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MenuItemsAvailability m1105boximpl(int r100) {
        return new MenuItemsAvailability(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1106constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1108equalsimpl(int r100, Object r101) {
        if ((r101 instanceof MenuItemsAvailability) == true) goto L6;
        return false;
    L6:
        if (r100 == ((MenuItemsAvailability) r101).m1117unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1109equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: getCanAutofill-impl, reason: not valid java name */
    public static final boolean m1110getCanAutofillimpl(int r100) {
        if ((r100 & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getCanCopy-impl, reason: not valid java name */
    public static final boolean m1111getCanCopyimpl(int r100) {
        if ((r100 & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: getCanCut-impl, reason: not valid java name */
    public static final boolean m1112getCanCutimpl(int r100) {
        if ((r100 & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getCanPaste-impl, reason: not valid java name */
    public static final boolean m1113getCanPasteimpl(int r100) {
        if ((r100 & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getCanSelectAll-impl, reason: not valid java name */
    public static final boolean m1114getCanSelectAllimpl(int r100) {
        if ((r100 & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1115hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1116toStringimpl(int r100) {
        return "MenuItemsAvailability(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m1108equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m1115hashCodeimpl(this.value);
    }

    public String toString() {
        return m1116toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1117unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        None = m1106constructorimpl(0);
    }

    public static final /* synthetic */ int access$getNone$cp() {
        return None;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ MenuItemsAvailability(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1107constructorimpl(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        int r105 = 0;
        if (r101 == false) goto L5;
        int r106 = 2;
    L6:
        int r107 = (r100 ? 1 : 0) | r106;
        if (r102 == false) goto L9;
        int r108 = 4;
    L10:
        int r109 = r107 | r108;
        if (r103 == false) goto L13;
        int r110 = 8;
    L14:
        int r111 = r109 | r110;
        if (r104 == false) goto L18;
        r105 = 16;
    L18:
        return m1106constructorimpl(r111 | r105);
    L13:
        r110 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }
}
