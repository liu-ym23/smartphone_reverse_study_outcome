package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010BG\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0011B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0012JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b \u0010!JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\"\u0010#JA\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSingleLine", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getAutoCorrect", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "copy", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImeOptions {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final ImeOptions Default = null;
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ImeOptions getDefault() {
            return ImeOptions.access$getDefault$cp();
        }
    }

    public /* synthetic */ ImeOptions(boolean r100, int r101, boolean r102, int r103, int r104, PlatformImeOptions r105, LocaleList r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional hintLocales parameter.")
    public /* synthetic */ ImeOptions(boolean r100, int r101, boolean r102, int r103, int r104, PlatformImeOptions r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ ImeOptions(boolean r100, int r101, boolean r102, int r103, int r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    static {
        Companion = new Companion(null);
        Default = new ImeOptions(false, 0, false, 0, 0, null, null, 127, null);
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.singleLine == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + KeyboardCapitalization.m7204hashCodeimpl(this.capitalization)) * 31;
        if (this.autoCorrect == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((((r102 + r100) * 31) + KeyboardType.m7221hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m7168hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions r104 = this.platformImeOptions;
        if (r104 == null) goto L13;
        int r105 = r104.hashCode();
    L15:
        return ((r103 + r105) * 31) + this.hintLocales.hashCode();
    L13:
        r105 = 0;
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.m7205toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m7222toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m7169toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + ", hintLocales=" + this.hintLocales + ')';
    }

    public static final /* synthetic */ ImeOptions access$getDefault$cp() {
        return Default;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m7195getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m7196getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m7197getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImeOptions) == true) goto L8;
        return false;
    L8:
        ImeOptions r101 = (ImeOptions) r100;
        if (this.singleLine == r101.singleLine) goto L12;
        return false;
    L12:
        if (KeyboardCapitalization.m7203equalsimpl0(this.capitalization, r101.capitalization) == true) goto L15;
        return false;
    L15:
        if (this.autoCorrect == r101.autoCorrect) goto L18;
        return false;
    L18:
        if (KeyboardType.m7220equalsimpl0(this.keyboardType, r101.keyboardType) == true) goto L21;
        return false;
    L21:
        if (ImeAction.m7167equalsimpl0(this.imeAction, r101.imeAction) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.platformImeOptions, r101.platformImeOptions) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hintLocales, r101.hintLocales) == true) goto L29;
        return false;
    L29:
        return true;
    }

    private ImeOptions(boolean r110, int r111, boolean r112, int r113, int r114) {
        this(r110, r111, r112, r113, r114, null, null, 64, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-uxg59PA, reason: not valid java name */
    public final /* synthetic */ ImeOptions m7193copyuxg59PA(boolean r110, int r111, boolean r112, int r113, int r114) {
        return new ImeOptions(r110, r111, r112, r113, r114, this.platformImeOptions, this.hintLocales, null);
    }

    private ImeOptions(boolean r110, int r111, boolean r112, int r113, int r114, PlatformImeOptions r115) {
        this(r110, r111, r112, r113, r114, r115, LocaleList.Companion.getEmpty(), null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional hintLocales parameter.")
    /* JADX INFO: renamed from: copy-YTHSh70, reason: not valid java name */
    public final /* synthetic */ ImeOptions m7192copyYTHSh70(boolean r110, int r111, boolean r112, int r113, int r114, PlatformImeOptions r115) {
        return new ImeOptions(r110, r111, r112, r113, r114, r115, this.hintLocales, null);
    }

    public /* synthetic */ ImeOptions(boolean r100, int r101, boolean r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = KeyboardCapitalization.Companion.m7213getNoneIUNYP9k();
    L9:
        int r103 = r101;
        if ((r113 & 4) == 0) goto L12;
        boolean r104 = true;
    L14:
        if ((r113 & 8) == 0) goto L16;
        r111 = KeyboardType.Companion.m7241getTextPjHm6EE();
    L16:
        int r105 = r111;
        if ((r113 & 16) == 0) goto L19;
        r112 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L19:
        this(r102, r103, r104, r105, r112, null);
        return;
    L12:
        r104 = r110;
        goto L14
    L5:
        r102 = r100;
        goto L7
    }

    /* JADX INFO: renamed from: copy-wBHncE4, reason: not valid java name */
    public final ImeOptions m7194copywBHncE4(boolean r110, int r111, boolean r112, int r113, int r114, PlatformImeOptions r115, LocaleList r116) {
        return new ImeOptions(r110, r111, r112, r113, r114, r115, r116, null);
    }

    private ImeOptions(boolean r100, int r101, boolean r102, int r103, int r104, PlatformImeOptions r105, LocaleList r106) {
        this.singleLine = r100;
        this.capitalization = r101;
        this.autoCorrect = r102;
        this.keyboardType = r103;
        this.imeAction = r104;
        this.platformImeOptions = r105;
        this.hintLocales = r106;
    }

    public /* synthetic */ ImeOptions(boolean r100, int r101, boolean r110, int r111, int r112, PlatformImeOptions r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r103 = KeyboardCapitalization.Companion.m7213getNoneIUNYP9k();
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r105 = KeyboardType.Companion.m7241getTextPjHm6EE();
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L23:
        if ((r114 & 32) == 0) goto L25;
        PlatformImeOptions r107 = null;
    L26:
        boolean r108 = r102;
        int r116 = r103;
        boolean r117 = r104;
        int r118 = r105;
        int r119 = r106;
        PlatformImeOptions r120 = r107;
        this(r108, r116, r117, r118, r119, r120, null);
        return;
    L25:
        r107 = r113;
        goto L26
    L21:
        r106 = r112;
        goto L23
    L17:
        r105 = r111;
        goto L19
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }

    /* JADX INFO: renamed from: copy-uxg59PA$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m7190copyuxg59PA$default(ImeOptions r100, boolean r101, int r102, boolean r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.singleLine;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.capitalization;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.autoCorrect;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.keyboardType;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.imeAction;
    L17:
        boolean r109 = r101;
        return r100.m7193copyuxg59PA(r109, r111, r107, r108, r105);
    }

    public /* synthetic */ ImeOptions(boolean r100, int r110, boolean r111, int r112, int r113, PlatformImeOptions r114, LocaleList r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r116 & 2) == 0) goto L9;
        int r102 = KeyboardCapitalization.Companion.m7213getNoneIUNYP9k();
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r116 & 8) == 0) goto L17;
        int r104 = KeyboardType.Companion.m7241getTextPjHm6EE();
    L19:
        if ((r116 & 16) == 0) goto L21;
        int r105 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L23:
        if ((r116 & 32) == 0) goto L25;
        PlatformImeOptions r106 = null;
    L27:
        if ((r116 & 64) == 0) goto L29;
        LocaleList r107 = LocaleList.Companion.getEmpty();
    L30:
        boolean r118 = r101;
        int r119 = r102;
        boolean r120 = r103;
        int r121 = r104;
        int r122 = r105;
        PlatformImeOptions r123 = r106;
        LocaleList r124 = r107;
        this(r118, r119, r120, r121, r122, r123, r124, null);
        return;
    L29:
        r107 = r115;
        goto L30
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    /* JADX INFO: renamed from: copy-YTHSh70$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m7189copyYTHSh70$default(ImeOptions r100, boolean r101, int r102, boolean r103, int r104, int r105, PlatformImeOptions r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.singleLine;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.capitalization;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.autoCorrect;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.keyboardType;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.imeAction;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.platformImeOptions;
    L20:
        boolean r109 = r101;
        return r100.m7192copyYTHSh70(r109, r113, r106, r107, r108, r110);
    }

    /* JADX INFO: renamed from: copy-wBHncE4$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m7191copywBHncE4$default(ImeOptions r100, boolean r101, int r102, boolean r103, int r104, int r110, PlatformImeOptions r111, LocaleList r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.singleLine;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.capitalization;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.autoCorrect;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.keyboardType;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.imeAction;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.platformImeOptions;
    L20:
        PlatformImeOptions r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.hintLocales;
    L23:
        boolean r109 = r101;
        return r100.m7194copywBHncE4(r109, r115, r105, r106, r107, r108, r112);
    }
}
