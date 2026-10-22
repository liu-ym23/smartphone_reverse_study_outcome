package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.nova.R;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 H2\u00020\u0001:\u0001HB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010@\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020=J\u000e\u0010F\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0003J\u000e\u0010G\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0003R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010(\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010,\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010.\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u00100\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u00102\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u00104\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0017\u00106\u001a\u000207¢\u0006\u000e\n\u0000\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "<init>", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "displayCutout", "getDisplayCutout", "ime", "getIme", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "statusBars", "getStatusBars", "systemBars", "getSystemBars", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "waterfall", "Landroidx/compose/foundation/layout/ValueInsets;", "getWaterfall", "()Landroidx/compose/foundation/layout/ValueInsets;", "safeDrawing", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeDrawing", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeGestures", "getSafeGestures", "safeContent", "getSafeContent", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "imeAnimationTarget", "getImeAnimationTarget", "imeAnimationSource", "getImeAnimationSource", "consumes", "", "getConsumes$annotations", "()V", "getConsumes", "()Z", "accessCount", "", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "incrementAccessors", "", "decrementAccessors", "update", "windowInsets", "types", "updateImeAnimationSource", "updateImeAnimationTarget", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsHolder {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static boolean testInsets;
    private static final WeakHashMap<View, WindowInsetsHolder> viewMap = null;
    private int accessCount;
    private final AndroidWindowInsets captionBar;
    private final ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final AndroidWindowInsets displayCutout;
    private final AndroidWindowInsets ime;
    private final ValueInsets imeAnimationSource;
    private final ValueInsets imeAnimationTarget;
    private final InsetsListener insetsListener;
    private final AndroidWindowInsets mandatorySystemGestures;
    private final AndroidWindowInsets navigationBars;
    private final ValueInsets navigationBarsIgnoringVisibility;
    private final WindowInsets safeContent;
    private final WindowInsets safeDrawing;
    private final WindowInsets safeGestures;
    private final AndroidWindowInsets statusBars;
    private final ValueInsets statusBarsIgnoringVisibility;
    private final AndroidWindowInsets systemBars;
    private final ValueInsets systemBarsIgnoringVisibility;
    private final AndroidWindowInsets systemGestures;
    private final AndroidWindowInsets tappableElement;
    private final ValueInsets tappableElementIgnoringVisibility;
    private final ValueInsets waterfall;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\r\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "<init>", "()V", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "testInsets", "", "setUseTestInsets", "", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", "name", "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ DisposableEffectResult a(WindowInsetsHolder r100, View r101, DisposableEffectScope r102) {
            return current$lambda$2$lambda$1(r100, r101, r102);
        }

        private final WindowInsetsHolder getOrCreateFor(View r100) {
            WeakHashMap r101 = WindowInsetsHolder.access$getViewMap$cp();
            monitor-enter(r101);
            WeakHashMap r102 = WindowInsetsHolder.access$getViewMap$cp();     // Catch: Throwable -> L10
            Object r103 = r102.get(r100);     // Catch: Throwable -> L10
            Object r104 = r103;
            if (r103 != null) goto L7;
            WindowInsetsHolder r105 = new WindowInsetsHolder(null, r100, false ? 1 : 0);     // Catch: Throwable -> L10
            r102.put(r100, r105);     // Catch: Throwable -> L10
            r104 = r105;
        L7:
            WindowInsetsHolder r106 = (WindowInsetsHolder) r104;     // Catch: Throwable -> L10
            monitor-exit(r101);
            return r106;
        L10:
            th = move-exception;
            throw th;
        }

        public final void setUseTestInsets(boolean r100) {
            WindowInsetsHolder.access$setTestInsets$cp(r100);
        }

        public final WindowInsetsHolder current(Composer r100, int r101) {
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1366542614, r101, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:549)");
        L5:
            final View r102 = (View) r100.consume(AndroidCompositionLocals_androidKt.getLocalView());
            final WindowInsetsHolder r103 = getOrCreateFor(r102);
            boolean r104 = r100.changedInstance(r103) | r100.changedInstance(r102);
            Object r105 = r100.rememberedValue();
            if (r104 == false) goto L8;
        L9:
            r105 = new h2(r103, r102);
            r100.updateRememberedValue(r105);
        L10:
            EffectsKt.DisposableEffect(r103, (Function1) r105, r100, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            return r103;
        L8:
            if (r105 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        private static final DisposableEffectResult current$lambda$2$lambda$1(final WindowInsetsHolder r100, final View r101, DisposableEffectScope r102) {
            r100.incrementAccessors(r101);
            return new WindowInsetsHolder$Companion$current$lambda$2$lambda$1$$inlined$onDispose$1(r100, r101);
        }

        private final AndroidWindowInsets systemInsets(WindowInsetsCompat r100, int r101, String r102) {
            AndroidWindowInsets r103 = new AndroidWindowInsets(r101, r102);
            if (r100 == null) goto L5;
            r103.update$foundation_layout(r100, r101);
        L5:
            return r103;
        }

        private final ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat r100, int r101, String r102) {
            if (r100 == null) goto L5;
            Insets r103 = r100.getInsetsIgnoringVisibility(r101);
            if (r103 == null) goto L5;
        L7:
            return WindowInsets_androidKt.ValueInsets(r103, r102);
        L5:
            r103 = Insets.NONE;
            goto L7
        }

        public static final /* synthetic */ AndroidWindowInsets access$systemInsets(Companion r100, WindowInsetsCompat r101, int r102, String r103) {
            return r100.systemInsets(r101, r102, r103);
        }

        public static final /* synthetic */ ValueInsets access$valueInsetsIgnoringVisibility(Companion r100, WindowInsetsCompat r101, int r102, String r103) {
            return r100.valueInsetsIgnoringVisibility(r101, r102, r103);
        }
    }

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat r100, View r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static /* synthetic */ void getConsumes$annotations() {
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        viewMap = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getViewMap$cp() {
        return viewMap;
    }

    public final AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public final AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final ValueInsets getImeAnimationSource() {
        return this.imeAnimationSource;
    }

    public final ValueInsets getImeAnimationTarget() {
        return this.imeAnimationTarget;
    }

    public final AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public static final /* synthetic */ void access$setTestInsets$cp(boolean r100) {
        testInsets = r100;
    }

    public final void decrementAccessors(View r100) {
        int r101 = this.accessCount - 1;
        this.accessCount = r101;
        if (r101 != 0) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r100, null);
        ViewCompat.setWindowInsetsAnimationCallback(r100, null);
        r100.removeOnAttachStateChangeListener(this.insetsListener);
        return;
    }

    public final void incrementAccessors(View r100) {
        if (this.accessCount != 0) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r100, this.insetsListener);
        if (r100.isAttachedToWindow() == false) goto L7;
        r100.requestApplyInsets();
    L7:
        r100.addOnAttachStateChangeListener(this.insetsListener);
        ViewCompat.setWindowInsetsAnimationCallback(r100, this.insetsListener);
    L8:
        this.accessCount++;
    }

    public final void updateImeAnimationSource(WindowInsetsCompat r100) {
        this.imeAnimationSource.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void updateImeAnimationTarget(WindowInsetsCompat r100) {
        this.imeAnimationTarget.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsets(WindowInsetsCompat.Type.ime())));
    }

    private WindowInsetsHolder(WindowInsetsCompat r110, View r111) {
        Companion r100 = Companion;
        this.captionBar = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.captionBar(), "captionBar");
        AndroidWindowInsets r101 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.displayCutout(), "displayCutout");
        this.displayCutout = r101;
        AndroidWindowInsets r102 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.ime(), "ime");
        this.ime = r102;
        AndroidWindowInsets r103 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.mandatorySystemGestures(), "mandatorySystemGestures");
        this.mandatorySystemGestures = r103;
        this.navigationBars = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.navigationBars(), "navigationBars");
        this.statusBars = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.statusBars(), "statusBars");
        AndroidWindowInsets r104 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.systemBars(), "systemBars");
        this.systemBars = r104;
        AndroidWindowInsets r105 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.systemGestures(), "systemGestures");
        this.systemGestures = r105;
        AndroidWindowInsets r106 = Companion.access$systemInsets(r100, r110, WindowInsetsCompat.Type.tappableElement(), "tappableElement");
        this.tappableElement = r106;
        if (r110 == null) goto L8;
        DisplayCutoutCompat r107 = r110.getDisplayCutout();
        if (r107 == null) goto L8;
        Insets r108 = r107.getWaterfallInsets();
        if (r108 == null) goto L8;
    L9:
        ValueInsets r109 = WindowInsets_androidKt.ValueInsets(r108, "waterfall");
        this.waterfall = r109;
        WindowInsets r112 = WindowInsetsKt.union(WindowInsetsKt.union(r104, r102), r101);
        this.safeDrawing = r112;
        WindowInsets r113 = WindowInsetsKt.union(WindowInsetsKt.union(WindowInsetsKt.union(r106, r103), r105), r109);
        this.safeGestures = r113;
        this.safeContent = WindowInsetsKt.union(r112, r113);
        this.captionBarIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.captionBar(), "captionBarIgnoringVisibility");
        this.navigationBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.navigationBars(), "navigationBarsIgnoringVisibility");
        this.statusBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.statusBars(), "statusBarsIgnoringVisibility");
        this.systemBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.systemBars(), "systemBarsIgnoringVisibility");
        this.tappableElementIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.tappableElement(), "tappableElementIgnoringVisibility");
        this.imeAnimationTarget = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.ime(), "imeAnimationTarget");
        this.imeAnimationSource = Companion.access$valueInsetsIgnoringVisibility(r100, r110, WindowInsetsCompat.Type.ime(), "imeAnimationSource");
        Object r114 = r111.getParent();
        Boolean r115 = null;
        if ((r114 instanceof View) == false) goto L12;
        View r116 = (View) r114;
    L13:
        if (r116 == null) goto L15;
        Object r117 = r116.getTag(R.id.consume_window_insets_tag);
    L17:
        if ((r117 instanceof Boolean) == false) goto L19;
        r115 = (Boolean) r117;
    L19:
        if (r115 == null) goto L22;
        boolean r118 = r115.booleanValue();
    L25:
        this.consumes = r118;
        this.insetsListener = new InsetsListener(this);
        return;
    L22:
        if (ComposeFoundationLayoutFlags.isWindowInsetsDefaultPassThroughEnabled == true) goto L24;
        r118 = true;
        goto L25
    L24:
        r118 = false;
        goto L25
    L15:
        r117 = null;
        goto L17
    L12:
        r116 = null;
    L8:
        r108 = Insets.NONE;
        goto L9
    }

    public final void update(WindowInsetsCompat r100, int r101) {
        if (testInsets == false) goto L5;
        android.view.WindowInsets r102 = r100.toWindowInsets();
        Intrinsics.checkNotNull(r102);
        r100 = WindowInsetsCompat.toWindowInsetsCompat(r102);
    L5:
        this.captionBar.update$foundation_layout(r100, r101);
        this.ime.update$foundation_layout(r100, r101);
        this.displayCutout.update$foundation_layout(r100, r101);
        this.navigationBars.update$foundation_layout(r100, r101);
        this.statusBars.update$foundation_layout(r100, r101);
        this.systemBars.update$foundation_layout(r100, r101);
        this.systemGestures.update$foundation_layout(r100, r101);
        this.tappableElement.update$foundation_layout(r100, r101);
        this.mandatorySystemGestures.update$foundation_layout(r100, r101);
        if (r101 != 0) goto L10;
        this.captionBarIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
        this.navigationBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
        this.statusBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
        this.systemBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
        this.tappableElementIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r100.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
        DisplayCutoutCompat r103 = r100.getDisplayCutout();
        if (r103 == null) goto L10;
        Insets r104 = r103.getWaterfallInsets();
        this.waterfall.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r104));
    L10:
        Snapshot.Companion.sendApplyNotifications();
    }

    public static /* synthetic */ void update$default(WindowInsetsHolder r100, WindowInsetsCompat r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.update(r101, r102);
    }
}
