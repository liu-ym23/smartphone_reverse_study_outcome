package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KBU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BS\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0012B1\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0013B=\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u0005H\u0000¢\u0006\u0002\b9J[\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b;\u0010<J[\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b;\u0010=JC\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b>\u0010?J7\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b@\u0010AJ\u0013\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0000J\u0017\u0010I\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\bJR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0011\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u0014\u0010+\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u0014\u0010-\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0016R\u0014\u0010/\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010%R\u0014\u00103\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010!R\u0014\u00105\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrectEnabled", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCapitalization-IUNYP9k", "()I", "I", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "hintLocalesOrDefault", "getHintLocalesOrDefault", "isCompletelyUnspecified", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "copy", "copy-INvB4aQ", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "hashCode", "", "toString", "", "merge", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyboardOptions {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final KeyboardOptions Default = null;
    private static final KeyboardOptions SecureTextField = null;
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.access$getDefault$cp();
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.access$getSecureTextField$cp();
        }
    }

    public /* synthetic */ KeyboardOptions(int r100, Boolean r101, int r102, int r103, PlatformImeOptions r104, Boolean r105, LocaleList r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int r100, boolean r101, int r102, int r103, PlatformImeOptions r104, Boolean r105, LocaleList r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int r100, boolean r101, int r102, int r103, PlatformImeOptions r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    static {
        Companion = new Companion(null);
        Default = new KeyboardOptions(0, null, 0, 0, null, null, null, 127, null);
        SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.m7239getPasswordPjHm6EE(), 0, null, null, null, 121, null);
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean r100 = this.autoCorrectEnabled;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    /* JADX INFO: renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m1060getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization r100 = KeyboardCapitalization.m7200boximpl(this.capitalization);
        int r101 = r100.m7206unboximpl();
        KeyboardCapitalization.Companion r102 = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.m7203equalsimpl0(r101, r102.m7215getUnspecifiedIUNYP9k()) == false) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        return r100.m7206unboximpl();
    L9:
        return r102.m7213getNoneIUNYP9k();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList r100 = this.hintLocales;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return LocaleList.Companion.getEmpty();
    }

    /* JADX INFO: renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m1061getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType r100 = KeyboardType.m7217boximpl(this.keyboardType);
        int r101 = r100.m7223unboximpl();
        KeyboardType.Companion r102 = KeyboardType.Companion;
        if (KeyboardType.m7220equalsimpl0(r101, r102.m7242getUnspecifiedPjHm6EE()) == false) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        return r100.m7223unboximpl();
    L9:
        return r102.m7241getTextPjHm6EE();
    }

    private final boolean isCompletelyUnspecified() {
        if (KeyboardCapitalization.m7203equalsimpl0(this.capitalization, KeyboardCapitalization.Companion.m7215getUnspecifiedIUNYP9k()) == true) goto L5;
    L17:
        return false;
    L5:
        if (this.autoCorrectEnabled != null) goto L17;
        if (KeyboardType.m7220equalsimpl0(this.keyboardType, KeyboardType.Companion.m7242getUnspecifiedPjHm6EE()) == false) goto L17;
        if (ImeAction.m7167equalsimpl0(this.imeAction, ImeAction.Companion.m7188getUnspecifiedeUduSuo()) == false) goto L17;
        if (this.platformImeOptions != null) goto L17;
        if (this.showKeyboardOnFocus != null) goto L17;
        if (this.hintLocales != null) goto L17;
        return true;
    }

    /* JADX INFO: renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m1068getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction r100 = ImeAction.m7164boximpl(this.imeAction);
        int r101 = r100.m7170unboximpl();
        ImeAction.Companion r102 = ImeAction.Companion;
        if (ImeAction.m7167equalsimpl0(r101, r102.m7188getUnspecifiedeUduSuo()) == false) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        return r100.m7170unboximpl();
    L9:
        return r102.m7180getDefaulteUduSuo();
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean r100 = this.showKeyboardOnFocus;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean r100 = this.showKeyboardOnFocus;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public int hashCode() {
        int r100 = KeyboardCapitalization.m7204hashCodeimpl(this.capitalization) * 31;
        Boolean r101 = this.autoCorrectEnabled;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((r100 + r103) * 31) + KeyboardType.m7221hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m7168hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions r105 = this.platformImeOptions;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.showKeyboardOnFocus;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        LocaleList r111 = this.hintLocales;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.m7205toStringimpl(this.capitalization) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + KeyboardType.m7222toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m7169toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public static final /* synthetic */ KeyboardOptions access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ KeyboardOptions access$getSecureTextField$cp() {
        return SecureTextField;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m1066getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m1067getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m1069getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KeyboardOptions) == true) goto L8;
        return false;
    L8:
        KeyboardOptions r101 = (KeyboardOptions) r100;
        if (KeyboardCapitalization.m7203equalsimpl0(this.capitalization, r101.capitalization) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoCorrectEnabled, r101.autoCorrectEnabled) == true) goto L15;
        return false;
    L15:
        if (KeyboardType.m7220equalsimpl0(this.keyboardType, r101.keyboardType) == true) goto L18;
        return false;
    L18:
        if (ImeAction.m7167equalsimpl0(this.imeAction, r101.imeAction) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.platformImeOptions, r101.platformImeOptions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showKeyboardOnFocus, r101.showKeyboardOnFocus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hintLocales, r101.hintLocales) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions r110) {
        if (r110 != null) goto L4;
    L46:
        return this;
    L4:
        if (r110.isCompletelyUnspecified() == true) goto L46;
        if (Intrinsics.areEqual(r110, this) == true) goto L46;
        if (isCompletelyUnspecified() == false) goto L11;
        return r110;
    L11:
        KeyboardCapitalization r100 = KeyboardCapitalization.m7200boximpl(this.capitalization);
        ImeAction r101 = null;
        if (KeyboardCapitalization.m7203equalsimpl0(r100.m7206unboximpl(), KeyboardCapitalization.Companion.m7215getUnspecifiedIUNYP9k()) == false) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L17;
        int r102 = r100.m7206unboximpl();
    L18:
        int r103 = r102;
        Boolean r104 = this.autoCorrectEnabled;
        if (r104 != null) goto L21;
        r104 = r110.autoCorrectEnabled;
    L21:
        Boolean r105 = r104;
        KeyboardType r106 = KeyboardType.m7217boximpl(this.keyboardType);
        if (KeyboardType.m7220equalsimpl0(r106.m7223unboximpl(), KeyboardType.Companion.m7242getUnspecifiedPjHm6EE()) == false) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L27;
        int r107 = r106.m7223unboximpl();
    L28:
        int r108 = r107;
        ImeAction r109 = ImeAction.m7164boximpl(this.imeAction);
        if (ImeAction.m7167equalsimpl0(r109.m7170unboximpl(), ImeAction.Companion.m7188getUnspecifiedeUduSuo()) == true) goto L31;
        r101 = r109;
    L31:
        if (r101 == null) goto L33;
        int r111 = r101.m7170unboximpl();
    L34:
        int r112 = r111;
        PlatformImeOptions r113 = this.platformImeOptions;
        if (r113 != null) goto L37;
        r113 = r110.platformImeOptions;
    L37:
        PlatformImeOptions r114 = r113;
        Boolean r115 = this.showKeyboardOnFocus;
        if (r115 != null) goto L40;
        r115 = r110.showKeyboardOnFocus;
    L40:
        Boolean r116 = r115;
        LocaleList r117 = this.hintLocales;
        if (r117 != null) goto L43;
        LocaleList r118 = r110.hintLocales;
    L45:
        return new KeyboardOptions(r103, r105, r108, r112, r114, r116, r118, null);
    L43:
        r118 = r117;
        goto L45
    L33:
        r111 = r110.imeAction;
        goto L34
    L27:
        r107 = r110.keyboardType;
        goto L28
    L17:
        r102 = r110.capitalization;
        goto L18
    }

    public final KeyboardOptions merge(KeyboardOptions r100) {
        if (r100 == null) goto L6;
        KeyboardOptions r101 = r100.fillUnspecifiedValuesWith$foundation_release(this);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return this;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean r110) {
        return new ImeOptions(r110, m1060getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1061getKeyboardTypeOrDefaultPjHm6EE(), m1068getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), null);
    }

    private KeyboardOptions(int r110, boolean r111, int r112, int r113) {
        this(r110, Boolean.valueOf(r111), r112, r113, null, null, null, 96, null);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = ImeOptions.Companion.getDefault().getSingleLine();
    L6:
        return r100.toImeOptions$foundation_release(r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* JADX INFO: renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1062copy3m2b7yw(int r110, boolean r111, int r112, int r113) {
        return new KeyboardOptions(r110, Boolean.valueOf(r111), r112, r113, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    private KeyboardOptions(int r110, boolean r111, int r112, int r113, PlatformImeOptions r114) {
        this(r110, Boolean.valueOf(r111), r112, r113, r114, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), null, 64, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1065copyij11fho(int r110, boolean r111, int r112, int r113, PlatformImeOptions r114) {
        return new KeyboardOptions(r110, Boolean.valueOf(r111), r112, r113, r114, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    public /* synthetic */ KeyboardOptions(int r100, boolean r101, int r102, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = KeyboardCapitalization.Companion.m7215getUnspecifiedIUNYP9k();
    L5:
        int r103 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = Default.getAutoCorrectOrDefault();
    L8:
        boolean r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = KeyboardType.Companion.m7242getUnspecifiedPjHm6EE();
    L11:
        int r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r110 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L14:
        this(r103, r104, r105, r110, null);
    }

    public /* synthetic */ KeyboardOptions(int r100, boolean r101, int r110, int r111, PlatformImeOptions r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = KeyboardCapitalization.Companion.m7213getNoneIUNYP9k();
    L5:
        int r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        r101 = Default.getAutoCorrectOrDefault();
    L8:
        boolean r103 = r101;
        if ((r113 & 4) == 0) goto L11;
        r110 = KeyboardType.Companion.m7241getTextPjHm6EE();
    L11:
        int r104 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L14:
        int r105 = r111;
        if ((r113 & 16) == 0) goto L17;
        r112 = null;
    L17:
        this(r102, r103, r104, r105, r112, null);
    }

    /* JADX INFO: renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1056copy3m2b7yw$default(KeyboardOptions r100, int r101, boolean r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.capitalization;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.getAutoCorrectOrDefault();
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.keyboardType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.imeAction;
    L15:
        return r100.m1062copy3m2b7yw(r101, r102, r103, r104);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1064copyINvB4aQ(int r110, boolean r111, int r112, int r113, PlatformImeOptions r114, Boolean r115, LocaleList r116) {
        return new KeyboardOptions(r110, Boolean.valueOf(r111), r112, r113, r114, r115, r116, null);
    }

    private KeyboardOptions(int r100, Boolean r101, int r102, int r103, PlatformImeOptions r104, Boolean r105, LocaleList r106) {
        this.capitalization = r100;
        this.autoCorrectEnabled = r101;
        this.keyboardType = r102;
        this.imeAction = r103;
        this.platformImeOptions = r104;
        this.showKeyboardOnFocus = r105;
        this.hintLocales = r106;
    }

    /* JADX INFO: renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1063copyINvB4aQ(int r110, Boolean r111, int r112, int r113, PlatformImeOptions r114, Boolean r115, LocaleList r116) {
        return new KeyboardOptions(r110, r111, r112, r113, r114, r115, r116, null);
    }

    private KeyboardOptions(int r110, boolean r111, int r112, int r113, PlatformImeOptions r114, Boolean r115, LocaleList r116) {
        this(r110, Boolean.valueOf(r111), r112, r113, r114, r115, r116, null);
    }

    /* JADX INFO: renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1059copyij11fho$default(KeyboardOptions r100, int r101, boolean r102, int r103, int r104, PlatformImeOptions r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.capitalization;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.getAutoCorrectOrDefault();
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.keyboardType;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.imeAction;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.platformImeOptions;
    L17:
        int r109 = r101;
        return r100.m1065copyij11fho(r109, r111, r107, r108, r105);
    }

    public /* synthetic */ KeyboardOptions(int r100, Boolean r110, int r111, int r112, PlatformImeOptions r113, Boolean r114, LocaleList r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        int r101 = KeyboardCapitalization.Companion.m7215getUnspecifiedIUNYP9k();
    L6:
        LocaleList r102 = null;
        if ((r116 & 2) == 0) goto L9;
        Boolean r103 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r104 = KeyboardType.Companion.m7242getUnspecifiedPjHm6EE();
    L15:
        if ((r116 & 8) == 0) goto L17;
        int r105 = ImeAction.Companion.m7188getUnspecifiedeUduSuo();
    L19:
        if ((r116 & 16) == 0) goto L21;
        PlatformImeOptions r106 = null;
    L23:
        if ((r116 & 32) == 0) goto L25;
        Boolean r107 = null;
    L27:
        if ((r116 & 64) != 0) goto L30;
        r102 = r115;
    L30:
        this(r101, r103, r104, r105, r106, r107, r102, null);
        return;
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }

    public /* synthetic */ KeyboardOptions(int r110, boolean r111, int r112, int r113, PlatformImeOptions r114, Boolean r115, LocaleList r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        int r100 = KeyboardCapitalization.Companion.m7215getUnspecifiedIUNYP9k();
    L7:
        if ((r117 & 4) == 0) goto L9;
        int r101 = KeyboardType.Companion.m7242getUnspecifiedPjHm6EE();
    L11:
        if ((r117 & 8) == 0) goto L13;
        int r102 = ImeAction.Companion.m7188getUnspecifiedeUduSuo();
    L15:
        if ((r117 & 16) == 0) goto L17;
        PlatformImeOptions r103 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r117 & 64) == 0) goto L25;
        LocaleList r105 = null;
    L26:
        this(r100, r111, r101, r102, r103, r104, r105, null);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1058copyINvB4aQ$default(KeyboardOptions r100, int r101, boolean r102, int r103, int r104, PlatformImeOptions r110, Boolean r111, LocaleList r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.capitalization;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.getAutoCorrectOrDefault();
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.keyboardType;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.imeAction;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.platformImeOptions;
    L17:
        PlatformImeOptions r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = Boolean.valueOf(r100.getShowKeyboardOnFocusOrDefault$foundation_release());
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.hintLocales;
    L23:
        int r109 = r101;
        return r100.m1064copyINvB4aQ(r109, r115, r105, r106, r107, r108, r112);
    }

    /* JADX INFO: renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1057copyINvB4aQ$default(KeyboardOptions r100, int r101, Boolean r102, int r103, int r104, PlatformImeOptions r110, Boolean r111, LocaleList r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.capitalization;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.autoCorrectEnabled;
    L8:
        Boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.keyboardType;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.imeAction;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.platformImeOptions;
    L17:
        PlatformImeOptions r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        Boolean r108 = null;
    L22:
        if ((r113 & 64) == 0) goto L24;
        LocaleList r109 = null;
    L26:
        return r100.m1063copyINvB4aQ(r101, r115, r105, r106, r107, r108, r109);
    L24:
        r109 = r112;
        goto L26
    L20:
        r108 = r111;
        goto L22
    }
}
