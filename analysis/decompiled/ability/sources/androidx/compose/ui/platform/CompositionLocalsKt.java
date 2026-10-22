package androidx.compose.ui.platform;

import C7.r;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillManager;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"(\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u0014\"&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001c\u0010\u0014\"\u001f\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\"&\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u0012\u0012\u0004\b$\u0010\u0019\u001a\u0004\b#\u0010\u0014\"\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000f8\u0006¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014\"\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u000f8\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u000f8\u0006¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u000f8\u0006¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014\"&\u00102\u001a\b\u0012\u0004\u0012\u0002010\u000f8GX\u0087\u0004¢\u0006\u0012\n\u0004\b2\u0010\u0012\u0012\u0004\b4\u0010\u0019\u001a\u0004\b3\u0010\u0014\"\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002050\u000f8\u0006¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010\u0014\"\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002080\u000f8\u0006¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0014\"\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u000f8\u0006¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010\u0014\"\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u000f8\u0006¢\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\b@\u0010\u0014\"(\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bB\u0010\u0012\u0012\u0004\bD\u0010\u0019\u001a\u0004\bC\u0010\u0014\"\u001f\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0\u000f8\u0006¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010\u0014\"\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u000f8\u0006¢\u0006\f\n\u0004\bI\u0010\u0012\u001a\u0004\bJ\u0010\u0014\"\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\bK\u0010\u0012\u001a\u0004\bL\u0010\u0014\"\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u000f8\u0006¢\u0006\f\n\u0004\bN\u0010\u0012\u001a\u0004\bO\u0010\u0014\"\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u000f8\u0006¢\u0006\f\n\u0004\bQ\u0010\u0012\u001a\u0004\bR\u0010\u0014\"\"\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010\u0012\u001a\u0004\bU\u0010\u0014\" \u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010\u0012\u001a\u0004\bX\u0010\u0014\"\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u000f8\u0006¢\u0006\f\n\u0004\bY\u0010\u0012\u001a\u0004\bZ\u0010\u0014\"\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020V0[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Landroidx/compose/ui/node/Owner;", "owner", "Landroidx/compose/ui/platform/UriHandler;", "uriHandler", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "ProvideCommonCompositionLocals", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/UriHandler;LS7/n;Landroidx/compose/runtime/Composer;I)V", "", HintConstants.AUTOFILL_HINT_NAME, "", "noLocalProvidedFor", "(Ljava/lang/String;)Ljava/lang/Void;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/AccessibilityManager;", "LocalAccessibilityManager", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAccessibilityManager", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/autofill/Autofill;", "LocalAutofill", "getLocalAutofill", "getLocalAutofill$annotations", "()V", "Landroidx/compose/ui/autofill/AutofillTree;", "LocalAutofillTree", "getLocalAutofillTree", "getLocalAutofillTree$annotations", "Landroidx/compose/ui/autofill/AutofillManager;", "LocalAutofillManager", "getLocalAutofillManager", "Landroidx/compose/ui/platform/ClipboardManager;", "LocalClipboardManager", "getLocalClipboardManager", "getLocalClipboardManager$annotations", "Landroidx/compose/ui/platform/Clipboard;", "LocalClipboard", "getLocalClipboard", "Landroidx/compose/ui/graphics/GraphicsContext;", "LocalGraphicsContext", "getLocalGraphicsContext", "Landroidx/compose/ui/unit/Density;", "LocalDensity", "getLocalDensity", "Landroidx/compose/ui/focus/FocusManager;", "LocalFocusManager", "getLocalFocusManager", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "LocalFontLoader", "getLocalFontLoader", "getLocalFontLoader$annotations", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "LocalFontFamilyResolver", "getLocalFontFamilyResolver", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "LocalHapticFeedback", "getLocalHapticFeedback", "Landroidx/compose/ui/input/InputModeManager;", "LocalInputModeManager", "getLocalInputModeManager", "Landroidx/compose/ui/unit/LayoutDirection;", "LocalLayoutDirection", "getLocalLayoutDirection", "Landroidx/compose/ui/text/input/TextInputService;", "LocalTextInputService", "getLocalTextInputService", "getLocalTextInputService$annotations", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "LocalSoftwareKeyboardController", "getLocalSoftwareKeyboardController", "Landroidx/compose/ui/platform/TextToolbar;", "LocalTextToolbar", "getLocalTextToolbar", "LocalUriHandler", "getLocalUriHandler", "Landroidx/compose/ui/platform/ViewConfiguration;", "LocalViewConfiguration", "getLocalViewConfiguration", "Landroidx/compose/ui/platform/WindowInfo;", "LocalWindowInfo", "getLocalWindowInfo", "Landroidx/compose/ui/input/pointer/PointerIconService;", "LocalPointerIconService", "getLocalPointerIconService", "", "LocalProvidableScrollCaptureInProgress", "getLocalProvidableScrollCaptureInProgress", "LocalCursorBlinkEnabled", "getLocalCursorBlinkEnabled", "Landroidx/compose/runtime/CompositionLocal;", "getLocalScrollCaptureInProgress", "()Landroidx/compose/runtime/CompositionLocal;", "LocalScrollCaptureInProgress", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionLocalsKt {
    private static final ProvidableCompositionLocal<AccessibilityManager> LocalAccessibilityManager = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAccessibilityManager$1
        @Override // S7.a
        public final AccessibilityManager invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<Autofill> LocalAutofill = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofill$1
        @Override // S7.a
        public final Autofill invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<AutofillTree> LocalAutofillTree = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillTree$1
        @Override // S7.a
        public final AutofillTree invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalAutofillTree");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<AutofillManager> LocalAutofillManager = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillManager$1
        @Override // S7.a
        public final AutofillManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalAutofillManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<ClipboardManager> LocalClipboardManager = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboardManager$1
        @Override // S7.a
        public final ClipboardManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalClipboardManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<Clipboard> LocalClipboard = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboard$1
        @Override // S7.a
        public final Clipboard invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalClipboard");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<GraphicsContext> LocalGraphicsContext = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalGraphicsContext$1
        @Override // S7.a
        public final GraphicsContext invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalGraphicsContext");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<Density> LocalDensity = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalDensity$1
        @Override // S7.a
        public final Density invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalDensity");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<FocusManager> LocalFocusManager = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFocusManager$1
        @Override // S7.a
        public final FocusManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFocusManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<Font.ResourceLoader> LocalFontLoader = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontLoader$1
        @Override // S7.a
        public final Font.ResourceLoader invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFontLoader");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<FontFamily.Resolver> LocalFontFamilyResolver = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontFamilyResolver$1
        @Override // S7.a
        public final FontFamily.Resolver invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFontFamilyResolver");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<HapticFeedback> LocalHapticFeedback = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalHapticFeedback$1
        @Override // S7.a
        public final HapticFeedback invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalHapticFeedback");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<InputModeManager> LocalInputModeManager = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalInputModeManager$1
        @Override // S7.a
        public final InputModeManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalInputManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<LayoutDirection> LocalLayoutDirection = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalLayoutDirection$1
        @Override // S7.a
        public final LayoutDirection invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalLayoutDirection");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<TextInputService> LocalTextInputService = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextInputService$1
        @Override // S7.a
        public final TextInputService invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<SoftwareKeyboardController> LocalSoftwareKeyboardController = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalSoftwareKeyboardController$1
        @Override // S7.a
        public final SoftwareKeyboardController invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<TextToolbar> LocalTextToolbar = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextToolbar$1
        @Override // S7.a
        public final TextToolbar invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalTextToolbar");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<UriHandler> LocalUriHandler = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalUriHandler$1
        @Override // S7.a
        public final UriHandler invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalUriHandler");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<ViewConfiguration> LocalViewConfiguration = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalViewConfiguration$1
        @Override // S7.a
        public final ViewConfiguration invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalViewConfiguration");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<WindowInfo> LocalWindowInfo = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalWindowInfo$1
        @Override // S7.a
        public final WindowInfo invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalWindowInfo");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<PointerIconService> LocalPointerIconService = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalPointerIconService$1
        @Override // S7.a
        public final PointerIconService invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalProvidableScrollCaptureInProgress = CompositionLocalKt.compositionLocalOf$default(null, new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalProvidableScrollCaptureInProgress$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Boolean> LocalCursorBlinkEnabled = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalCursorBlinkEnabled$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    @Composable
    @ExperimentalComposeUiApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ProvideCommonCompositionLocals(final Owner owner, final UriHandler uriHandler, final S7.n nVar, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1925803616);
        if ((i & 6) == 0) {
            i6 = ((i & 8) == 0 ? composerStartRestartGroup.changed(owner) : composerStartRestartGroup.changedInstance(owner) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= (i & 64) == 0 ? composerStartRestartGroup.changed(uriHandler) : composerStartRestartGroup.changedInstance(uriHandler) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1925803616, i6, -1, "androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:214)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalAccessibilityManager.provides(owner.getAccessibilityManager()), LocalAutofill.provides(owner.getAutofill()), LocalAutofillManager.provides(owner.getAutofillManager()), LocalAutofillTree.provides(owner.getAutofillTree()), LocalClipboardManager.provides(owner.getClipboardManager()), LocalClipboard.provides(owner.getClipboard()), LocalDensity.provides(owner.getDensity()), LocalFocusManager.provides(owner.getFocusOwner()), LocalFontLoader.providesDefault(owner.getFontLoader()), LocalFontFamilyResolver.providesDefault(owner.getFontFamilyResolver()), LocalHapticFeedback.provides(owner.getHapticFeedBack()), LocalInputModeManager.provides(owner.getInputModeManager()), LocalLayoutDirection.provides(owner.getLayoutDirection()), LocalTextInputService.provides(owner.getTextInputService()), LocalSoftwareKeyboardController.provides(owner.getSoftwareKeyboardController()), LocalTextToolbar.provides(owner.getTextToolbar()), LocalUriHandler.provides(uriHandler), LocalViewConfiguration.provides(owner.getViewConfiguration()), LocalWindowInfo.provides(owner.getWindowInfo()), LocalPointerIconService.provides(owner.getPointerIconService()), LocalGraphicsContext.provides(owner.getGraphicsContext())}, nVar, composerStartRestartGroup, ((i6 >> 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new S7.n() { // from class: androidx.compose.ui.platform.CompositionLocalsKt.ProvideCommonCompositionLocals.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    CompositionLocalsKt.ProvideCommonCompositionLocals(owner, uriHandler, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<AccessibilityManager> getLocalAccessibilityManager() {
        return LocalAccessibilityManager;
    }

    public static final ProvidableCompositionLocal<Autofill> getLocalAutofill() {
        return LocalAutofill;
    }

    @C7.c
    public static /* synthetic */ void getLocalAutofill$annotations() {
    }

    public static final ProvidableCompositionLocal<AutofillManager> getLocalAutofillManager() {
        return LocalAutofillManager;
    }

    public static final ProvidableCompositionLocal<AutofillTree> getLocalAutofillTree() {
        return LocalAutofillTree;
    }

    @C7.c
    public static /* synthetic */ void getLocalAutofillTree$annotations() {
    }

    public static final ProvidableCompositionLocal<Clipboard> getLocalClipboard() {
        return LocalClipboard;
    }

    public static final ProvidableCompositionLocal<ClipboardManager> getLocalClipboardManager() {
        return LocalClipboardManager;
    }

    @C7.c
    public static /* synthetic */ void getLocalClipboardManager$annotations() {
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalCursorBlinkEnabled() {
        return LocalCursorBlinkEnabled;
    }

    public static final ProvidableCompositionLocal<Density> getLocalDensity() {
        return LocalDensity;
    }

    public static final ProvidableCompositionLocal<FocusManager> getLocalFocusManager() {
        return LocalFocusManager;
    }

    public static final ProvidableCompositionLocal<FontFamily.Resolver> getLocalFontFamilyResolver() {
        return LocalFontFamilyResolver;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ProvidableCompositionLocal<Font.ResourceLoader> getLocalFontLoader() {
        return LocalFontLoader;
    }

    @C7.c
    public static /* synthetic */ void getLocalFontLoader$annotations() {
    }

    public static final ProvidableCompositionLocal<GraphicsContext> getLocalGraphicsContext() {
        return LocalGraphicsContext;
    }

    public static final ProvidableCompositionLocal<HapticFeedback> getLocalHapticFeedback() {
        return LocalHapticFeedback;
    }

    public static final ProvidableCompositionLocal<InputModeManager> getLocalInputModeManager() {
        return LocalInputModeManager;
    }

    public static final ProvidableCompositionLocal<LayoutDirection> getLocalLayoutDirection() {
        return LocalLayoutDirection;
    }

    public static final ProvidableCompositionLocal<PointerIconService> getLocalPointerIconService() {
        return LocalPointerIconService;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalProvidableScrollCaptureInProgress() {
        return LocalProvidableScrollCaptureInProgress;
    }

    public static final CompositionLocal<Boolean> getLocalScrollCaptureInProgress() {
        return LocalProvidableScrollCaptureInProgress;
    }

    public static final ProvidableCompositionLocal<SoftwareKeyboardController> getLocalSoftwareKeyboardController() {
        return LocalSoftwareKeyboardController;
    }

    public static final ProvidableCompositionLocal<TextInputService> getLocalTextInputService() {
        return LocalTextInputService;
    }

    @C7.c
    public static /* synthetic */ void getLocalTextInputService$annotations() {
    }

    public static final ProvidableCompositionLocal<TextToolbar> getLocalTextToolbar() {
        return LocalTextToolbar;
    }

    public static final ProvidableCompositionLocal<UriHandler> getLocalUriHandler() {
        return LocalUriHandler;
    }

    public static final ProvidableCompositionLocal<ViewConfiguration> getLocalViewConfiguration() {
        return LocalViewConfiguration;
    }

    public static final ProvidableCompositionLocal<WindowInfo> getLocalWindowInfo() {
        return LocalWindowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
