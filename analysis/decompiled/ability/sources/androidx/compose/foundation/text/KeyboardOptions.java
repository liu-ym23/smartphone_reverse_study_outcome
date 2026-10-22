package androidx.compose.foundation.text;

import C7.c;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QBU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010BS\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0012B1\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0013B=\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J^\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ^\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001dJF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0004\b-\u0010,R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010'R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b4\u0010'R\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b5\u0010'R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00106\u001a\u0004\b7\u00108R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b9\u00103R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010\u0011\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001a\u0010C\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010@\u001a\u0004\bA\u0010>R\u001a\u0010E\u001a\u00020\b8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bD\u0010'R\u0014\u0010G\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010>R\u0014\u0010I\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010>R\u001a\u0010K\u001a\u00020\u00028BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bJ\u0010'R\u001a\u0010M\u001a\u00020\u00068BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bL\u0010'R\u0014\u0010O\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010<R\u0014\u0010P\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010>\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006R"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "capitalization", "", "autoCorrectEnabled", "Landroidx/compose/ui/text/input/KeyboardType;", "keyboardType", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "platformImeOptions", "showKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "hintLocales", AppAgent.CONSTRUCT, "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/e;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/e;)V", "(IZIILkotlin/jvm/internal/e;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/e;)V", "singleLine", "Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions$foundation_release", "(Z)Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions", "copy-INvB4aQ", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "merge", "(Landroidx/compose/foundation/text/KeyboardOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "fillUnspecifiedValuesWith$foundation_release", "fillUnspecifiedValuesWith", "I", "getCapitalization-IUNYP9k", "Ljava/lang/Boolean;", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrect", "()Z", "getAutoCorrect$annotations", "()V", "getShouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "shouldShowKeyboardOnFocus", "getImeActionOrDefault-eUduSuo$foundation_release", "imeActionOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "showKeyboardOnFocusOrDefault", "getAutoCorrectOrDefault", "autoCorrectOrDefault", "getCapitalizationOrDefault-IUNYP9k", "capitalizationOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "keyboardTypeOrDefault", "getHintLocalesOrDefault", "hintLocalesOrDefault", "isCompletelyUnspecified", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardOptions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (e) null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.INSTANCE.m6549getPasswordPjHm6EE(), 0, (PlatformImeOptions) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), (LocaleList) null, 121, (e) null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.SecureTextField;
        }

        private Companion() {
        }
    }

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, e eVar) {
        this(i, bool, i6, i10, platformImeOptions, bool2, localeList);
    }

    /* renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1028copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z10, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i11 & 2) != 0) {
            z10 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i11 & 4) != 0) {
            i6 = keyboardOptions.keyboardType;
        }
        if ((i11 & 8) != 0) {
            i10 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m1034copy3m2b7yw(i, z10, i6, i10);
    }

    /* renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1029copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, Boolean bool, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i11, Object obj) {
        LocaleList localeList2;
        Boolean bool3;
        int i12;
        PlatformImeOptions platformImeOptions2;
        Boolean bool4;
        int i13;
        KeyboardOptions keyboardOptions2;
        int i14;
        if ((i11 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i11 & 2) != 0) {
            bool = keyboardOptions.autoCorrectEnabled;
        }
        if ((i11 & 4) != 0) {
            i6 = keyboardOptions.keyboardType;
        }
        if ((i11 & 8) != 0) {
            i10 = keyboardOptions.imeAction;
        }
        if ((i11 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        if ((i11 & 32) != 0) {
            bool2 = null;
        }
        if ((i11 & 64) != 0) {
            localeList2 = null;
            platformImeOptions2 = platformImeOptions;
            bool3 = bool2;
            i13 = i6;
            i12 = i10;
            i14 = i;
            bool4 = bool;
            keyboardOptions2 = keyboardOptions;
        } else {
            localeList2 = localeList;
            bool3 = bool2;
            i12 = i10;
            platformImeOptions2 = platformImeOptions;
            bool4 = bool;
            i13 = i6;
            keyboardOptions2 = keyboardOptions;
            i14 = i;
        }
        return keyboardOptions2.m1035copyINvB4aQ(i14, bool4, i13, i12, platformImeOptions2, bool3, localeList2);
    }

    /* renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1031copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i11 & 2) != 0) {
            z10 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i11 & 4) != 0) {
            i6 = keyboardOptions.keyboardType;
        }
        if ((i11 & 8) != 0) {
            i10 = keyboardOptions.imeAction;
        }
        if ((i11 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        int i12 = i6;
        return keyboardOptions.m1037copyij11fho(i, z10, i12, i10, platformImeOptions2);
    }

    @c
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m1032getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM6510boximpl = KeyboardCapitalization.m6510boximpl(this.capitalization);
        int value = keyboardCapitalizationM6510boximpl.getValue();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.INSTANCE;
        if (KeyboardCapitalization.m6513equalsimpl0(value, companion.m6525getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM6510boximpl = null;
        }
        return keyboardCapitalizationM6510boximpl != null ? keyboardCapitalizationM6510boximpl.getValue() : companion.m6523getNoneIUNYP9k();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.INSTANCE.getEmpty() : localeList;
    }

    /* renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m1033getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM6527boximpl = KeyboardType.m6527boximpl(this.keyboardType);
        int value = keyboardTypeM6527boximpl.getValue();
        KeyboardType.Companion companion = KeyboardType.INSTANCE;
        if (KeyboardType.m6530equalsimpl0(value, companion.m6552getUnspecifiedPjHm6EE())) {
            keyboardTypeM6527boximpl = null;
        }
        return keyboardTypeM6527boximpl != null ? keyboardTypeM6527boximpl.getValue() : companion.m6551getTextPjHm6EE();
    }

    @c
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    private final boolean isCompletelyUnspecified() {
        return KeyboardCapitalization.m6513equalsimpl0(this.capitalization, KeyboardCapitalization.INSTANCE.m6525getUnspecifiedIUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.m6530equalsimpl0(this.keyboardType, KeyboardType.INSTANCE.m6552getUnspecifiedPjHm6EE()) && ImeAction.m6477equalsimpl0(this.imeAction, ImeAction.INSTANCE.m6498getUnspecifiedeUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null;
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = ImeOptions.INSTANCE.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z10);
    }

    @c
    /* renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1034copy3m2b7yw(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (e) null);
    }

    /* renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1035copyINvB4aQ(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, autoCorrectEnabled, keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (e) null);
    }

    @c
    /* renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1037copyij11fho(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (e) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        return KeyboardCapitalization.m6513equalsimpl0(this.capitalization, keyboardOptions.capitalization) && k.b(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) && KeyboardType.m6530equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m6477equalsimpl0(this.imeAction, keyboardOptions.imeAction) && k.b(this.platformImeOptions, keyboardOptions.platformImeOptions) && k.b(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && k.b(this.hintLocales, keyboardOptions.hintLocales);
    }

    @Stable
    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions other) {
        if (other == null || other.isCompletelyUnspecified() || other.equals(this)) {
            return this;
        }
        if (isCompletelyUnspecified()) {
            return other;
        }
        KeyboardCapitalization keyboardCapitalizationM6510boximpl = KeyboardCapitalization.m6510boximpl(this.capitalization);
        if (KeyboardCapitalization.m6513equalsimpl0(keyboardCapitalizationM6510boximpl.getValue(), KeyboardCapitalization.INSTANCE.m6525getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM6510boximpl = null;
        }
        int value = keyboardCapitalizationM6510boximpl != null ? keyboardCapitalizationM6510boximpl.getValue() : other.capitalization;
        Boolean bool = this.autoCorrectEnabled;
        if (bool == null) {
            bool = other.autoCorrectEnabled;
        }
        Boolean bool2 = bool;
        KeyboardType keyboardTypeM6527boximpl = KeyboardType.m6527boximpl(this.keyboardType);
        if (KeyboardType.m6530equalsimpl0(keyboardTypeM6527boximpl.getValue(), KeyboardType.INSTANCE.m6552getUnspecifiedPjHm6EE())) {
            keyboardTypeM6527boximpl = null;
        }
        int value2 = keyboardTypeM6527boximpl != null ? keyboardTypeM6527boximpl.getValue() : other.keyboardType;
        ImeAction imeActionM6474boximpl = ImeAction.m6474boximpl(this.imeAction);
        ImeAction imeAction = ImeAction.m6477equalsimpl0(imeActionM6474boximpl.getValue(), ImeAction.INSTANCE.m6498getUnspecifiedeUduSuo()) ? null : imeActionM6474boximpl;
        int value3 = imeAction != null ? imeAction.getValue() : other.imeAction;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        if (platformImeOptions == null) {
            platformImeOptions = other.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        Boolean bool3 = this.showKeyboardOnFocus;
        if (bool3 == null) {
            bool3 = other.showKeyboardOnFocus;
        }
        Boolean bool4 = bool3;
        LocaleList localeList = this.hintLocales;
        if (localeList == null) {
            localeList = other.hintLocales;
        }
        return new KeyboardOptions(value, bool2, value2, value3, platformImeOptions2, bool4, localeList, (e) null);
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    /* renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m1040getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM6474boximpl = ImeAction.m6474boximpl(this.imeAction);
        int value = imeActionM6474boximpl.getValue();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        if (ImeAction.m6477equalsimpl0(value, companion.m6498getUnspecifiedeUduSuo())) {
            imeActionM6474boximpl = null;
        }
        return imeActionM6474boximpl != null ? imeActionM6474boximpl.getValue() : companion.m6490getDefaulteUduSuo();
    }

    /* renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public int hashCode() {
        int iM6514hashCodeimpl = KeyboardCapitalization.m6514hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iM6478hashCodeimpl = (ImeAction.m6478hashCodeimpl(this.imeAction) + ((KeyboardType.m6531hashCodeimpl(this.keyboardType) + ((iM6514hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31)) * 31)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        int iHashCode = (iM6478hashCodeimpl + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31;
        Boolean bool2 = this.showKeyboardOnFocus;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return iHashCode2 + (localeList != null ? localeList.hashCode() : 0);
    }

    public final KeyboardOptions merge(KeyboardOptions other) {
        KeyboardOptions keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
        return (other == null || (keyboardOptionsFillUnspecifiedValuesWith$foundation_release = other.fillUnspecifiedValuesWith$foundation_release(this)) == null) ? this : keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m1032getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1033getKeyboardTypeOrDefaultPjHm6EE(), m1040getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), (e) null);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m6515toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m6532toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m6479toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    @c
    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, e eVar) {
        this(i, z10, i6, i10, platformImeOptions, bool, localeList);
    }

    @c
    /* renamed from: copy-INvB4aQ, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1036copyINvB4aQ(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (e) null);
    }

    @c
    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, e eVar) {
        this(i, z10, i6, i10, platformImeOptions);
    }

    @c
    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, e eVar) {
        this(i, z10, i6, i10);
    }

    private KeyboardOptions(int i, Boolean bool, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i6;
        this.imeAction = i10;
        this.platformImeOptions = platformImeOptions;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    /* renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1030copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i11 & 2) != 0) {
            z10 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i11 & 4) != 0) {
            i6 = keyboardOptions.keyboardType;
        }
        if ((i11 & 8) != 0) {
            i10 = keyboardOptions.imeAction;
        }
        if ((i11 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        if ((i11 & 32) != 0) {
            bool = Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release());
        }
        if ((i11 & 64) != 0) {
            localeList = keyboardOptions.hintLocales;
        }
        Boolean bool2 = bool;
        LocaleList localeList2 = localeList;
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        int i12 = i6;
        return keyboardOptions.m1036copyINvB4aQ(i, z10, i12, i10, platformImeOptions2, bool2, localeList2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i11, e eVar) {
        int iM6525getUnspecifiedIUNYP9k = (i11 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6525getUnspecifiedIUNYP9k() : i;
        Boolean bool3 = (i11 & 2) != 0 ? null : bool;
        int iM6552getUnspecifiedPjHm6EE = (i11 & 4) != 0 ? KeyboardType.INSTANCE.m6552getUnspecifiedPjHm6EE() : i6;
        int iM6498getUnspecifiedeUduSuo = (i11 & 8) != 0 ? ImeAction.INSTANCE.m6498getUnspecifiedeUduSuo() : i10;
        PlatformImeOptions platformImeOptions2 = (i11 & 16) != 0 ? null : platformImeOptions;
        Boolean bool4 = (i11 & 32) != 0 ? null : bool2;
        this(iM6525getUnspecifiedIUNYP9k, bool3, iM6552getUnspecifiedPjHm6EE, iM6498getUnspecifiedeUduSuo, platformImeOptions2, bool4, (i11 & 64) == 0 ? localeList : null, (e) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i11, e eVar) {
        this((i11 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6525getUnspecifiedIUNYP9k() : i, z10, (i11 & 4) != 0 ? KeyboardType.INSTANCE.m6552getUnspecifiedPjHm6EE() : i6, (i11 & 8) != 0 ? ImeAction.INSTANCE.m6498getUnspecifiedeUduSuo() : i10, (i11 & 16) != 0 ? null : platformImeOptions, (i11 & 32) != 0 ? null : bool, (i11 & 64) != 0 ? null : localeList, (e) null);
    }

    private KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList) {
        this(i, Boolean.valueOf(z10), i6, i10, platformImeOptions, bool, localeList, (e) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6525getUnspecifiedIUNYP9k() : i, (i11 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z10, (i11 & 4) != 0 ? KeyboardType.INSTANCE.m6552getUnspecifiedPjHm6EE() : i6, (i11 & 8) != 0 ? ImeAction.INSTANCE.m6490getDefaulteUduSuo() : i10, (e) null);
    }

    private KeyboardOptions(int i, boolean z10, int i6, int i10) {
        this(i, Boolean.valueOf(z10), i6, i10, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 96, (e) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions, int i11, e eVar) {
        this((i11 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m6523getNoneIUNYP9k() : i, (i11 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z10, (i11 & 4) != 0 ? KeyboardType.INSTANCE.m6551getTextPjHm6EE() : i6, (i11 & 8) != 0 ? ImeAction.INSTANCE.m6490getDefaulteUduSuo() : i10, (i11 & 16) != 0 ? null : platformImeOptions, (e) null);
    }

    private KeyboardOptions(int i, boolean z10, int i6, int i10, PlatformImeOptions platformImeOptions) {
        this(i, Boolean.valueOf(z10), i6, i10, platformImeOptions, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), (LocaleList) null, 64, (e) null);
    }
}
