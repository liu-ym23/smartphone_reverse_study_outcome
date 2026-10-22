package androidx.compose.ui.text.input;

import C7.c;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.intl.LocaleList;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u0000 12\u00020\u0001:\u00011BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010BG\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0011B;\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0012JU\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014JM\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b(\u0010%R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b)\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b*\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "", "singleLine", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "capitalization", "autoCorrect", "Landroidx/compose/ui/text/input/KeyboardType;", "keyboardType", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "platformImeOptions", "Landroidx/compose/ui/text/intl/LocaleList;", "hintLocales", AppAgent.CONSTRUCT, "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/e;)V", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/e;)V", "(ZIZIILkotlin/jvm/internal/e;)V", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "copy", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getSingleLine", "()Z", "I", "getCapitalization-IUNYP9k", "getAutoCorrect", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "Landroidx/compose/ui/text/intl/LocaleList;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImeOptions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, null, null, 127, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", AppAgent.CONSTRUCT, "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, LocaleList localeList, e eVar) {
        this(z10, i, z11, i6, i10, platformImeOptions, localeList);
    }

    /* renamed from: copy-YTHSh70$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m6499copyYTHSh70$default(ImeOptions imeOptions, boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = imeOptions.singleLine;
        }
        if ((i11 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i11 & 4) != 0) {
            z11 = imeOptions.autoCorrect;
        }
        if ((i11 & 8) != 0) {
            i6 = imeOptions.keyboardType;
        }
        if ((i11 & 16) != 0) {
            i10 = imeOptions.imeAction;
        }
        if ((i11 & 32) != 0) {
            platformImeOptions = imeOptions.platformImeOptions;
        }
        int i12 = i10;
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        return imeOptions.m6502copyYTHSh70(z10, i, z11, i6, i12, platformImeOptions2);
    }

    /* renamed from: copy-uxg59PA$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m6500copyuxg59PA$default(ImeOptions imeOptions, boolean z10, int i, boolean z11, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = imeOptions.singleLine;
        }
        if ((i11 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i11 & 4) != 0) {
            z11 = imeOptions.autoCorrect;
        }
        if ((i11 & 8) != 0) {
            i6 = imeOptions.keyboardType;
        }
        if ((i11 & 16) != 0) {
            i10 = imeOptions.imeAction;
        }
        int i12 = i10;
        boolean z12 = z11;
        return imeOptions.m6503copyuxg59PA(z10, i, z12, i6, i12);
    }

    /* renamed from: copy-wBHncE4$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m6501copywBHncE4$default(ImeOptions imeOptions, boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, LocaleList localeList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = imeOptions.singleLine;
        }
        if ((i11 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i11 & 4) != 0) {
            z11 = imeOptions.autoCorrect;
        }
        if ((i11 & 8) != 0) {
            i6 = imeOptions.keyboardType;
        }
        if ((i11 & 16) != 0) {
            i10 = imeOptions.imeAction;
        }
        if ((i11 & 32) != 0) {
            platformImeOptions = imeOptions.platformImeOptions;
        }
        if ((i11 & 64) != 0) {
            localeList = imeOptions.hintLocales;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        LocaleList localeList2 = localeList;
        int i12 = i10;
        boolean z12 = z11;
        return imeOptions.m6504copywBHncE4(z10, i, z12, i6, i12, platformImeOptions2, localeList2);
    }

    @c
    /* renamed from: copy-YTHSh70, reason: not valid java name */
    public final /* synthetic */ ImeOptions m6502copyYTHSh70(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, this.hintLocales, (e) null);
    }

    @c
    /* renamed from: copy-uxg59PA, reason: not valid java name */
    public final /* synthetic */ ImeOptions m6503copyuxg59PA(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, this.platformImeOptions, this.hintLocales, (e) null);
    }

    /* renamed from: copy-wBHncE4, reason: not valid java name */
    public final ImeOptions m6504copywBHncE4(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, LocaleList hintLocales) {
        return new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, hintLocales, (e) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) other;
        return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m6513equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m6530equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m6477equalsimpl0(this.imeAction, imeOptions.imeAction) && k.b(this.platformImeOptions, imeOptions.platformImeOptions) && k.b(this.hintLocales, imeOptions.hintLocales);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
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

    /* renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        int iM6478hashCodeimpl = (ImeAction.m6478hashCodeimpl(this.imeAction) + ((KeyboardType.m6531hashCodeimpl(this.keyboardType) + androidx.appfunctions.metadata.a.d((KeyboardCapitalization.m6514hashCodeimpl(this.capitalization) + (Boolean.hashCode(this.singleLine) * 31)) * 31, 31, this.autoCorrect)) * 31)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        return this.hintLocales.hashCode() + ((iM6478hashCodeimpl + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) KeyboardCapitalization.m6515toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m6532toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m6479toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + ", hintLocales=" + this.hintLocales + ')';
    }

    @c
    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, e eVar) {
        this(z10, i, z11, i6, i10, platformImeOptions);
    }

    @c
    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, e eVar) {
        this(z10, i, z11, i6, i10);
    }

    private ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, LocaleList localeList) {
        this.singleLine = z10;
        this.capitalization = i;
        this.autoCorrect = z11;
        this.keyboardType = i6;
        this.imeAction = i10;
        this.platformImeOptions = platformImeOptions;
        this.hintLocales = localeList;
    }

    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, LocaleList localeList, int i11, e eVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m6523getNoneIUNYP9k() : i, (i11 & 4) != 0 ? true : z11, (i11 & 8) != 0 ? KeyboardType.INSTANCE.m6551getTextPjHm6EE() : i6, (i11 & 16) != 0 ? ImeAction.INSTANCE.m6490getDefaulteUduSuo() : i10, (i11 & 32) != 0 ? null : platformImeOptions, (i11 & 64) != 0 ? LocaleList.INSTANCE.getEmpty() : localeList, (e) null);
    }

    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions, int i11, e eVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m6523getNoneIUNYP9k() : i, (i11 & 4) != 0 ? true : z11, (i11 & 8) != 0 ? KeyboardType.INSTANCE.m6551getTextPjHm6EE() : i6, (i11 & 16) != 0 ? ImeAction.INSTANCE.m6490getDefaulteUduSuo() : i10, (i11 & 32) != 0 ? null : platformImeOptions, (e) null);
    }

    private ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, PlatformImeOptions platformImeOptions) {
        this(z10, i, z11, i6, i10, platformImeOptions, LocaleList.INSTANCE.getEmpty(), (e) null);
    }

    public /* synthetic */ ImeOptions(boolean z10, int i, boolean z11, int i6, int i10, int i11, e eVar) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m6523getNoneIUNYP9k() : i, (i11 & 4) != 0 ? true : z11, (i11 & 8) != 0 ? KeyboardType.INSTANCE.m6551getTextPjHm6EE() : i6, (i11 & 16) != 0 ? ImeAction.INSTANCE.m6490getDefaulteUduSuo() : i10, (e) null);
    }

    private ImeOptions(boolean z10, int i, boolean z11, int i6, int i10) {
        this(z10, i, z11, i6, i10, null, null, 64, null);
    }
}
