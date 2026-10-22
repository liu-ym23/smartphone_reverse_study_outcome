package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0095\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007J\u009f\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    private ExposedDropdownMenuBoxScope() {
    }

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker r100) {
        this();
    }

    private static final Unit ExposedDropdownMenu$lambda$9(ExposedDropdownMenuBoxScope r110, boolean r111, Function0 r112, Modifier r113, ScrollState r114, Function3 r115, int r116, int r117, Composer r118, int r119) {
        r110.ExposedDropdownMenu(r111, r112, r113, r114, r115, r118, RecomposeScopeImplKt.updateChangedFlags(r116 | 1), r117);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenu_kbRbctU$lambda$8(ExposedDropdownMenuBoxScope r110, boolean r111, Function0 r210, Modifier r211, ScrollState r212, boolean r213, boolean r214, Shape r215, long r216, float r217, float r218, BorderStroke r310, Function3 r311, int r312, int r313, int r314, Composer r315, int r316) {
        r110.m2204ExposedDropdownMenukbRbctU(r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r315, RecomposeScopeImplKt.updateChangedFlags(r312 | 1), RecomposeScopeImplKt.updateChangedFlags(r313), r314);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$7(ExposedDropdownMenuBoxScope r110, boolean r111, Function0 r112, Modifier r210, ScrollState r211, boolean r212, Shape r213, long r214, float r215, float r216, BorderStroke r217, Function3 r218, int r310, int r311, int r312, Composer r313, int r314) {
        r110.m2205ExposedDropdownMenuvNxi1II(r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r313, RecomposeScopeImplKt.updateChangedFlags(r310 | 1), RecomposeScopeImplKt.updateChangedFlags(r311), r312);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableState r100, IntRect r101, IntRect r102) {
        return ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(ExposedDropdownMenuBoxScope r100, boolean r101, Function0 r102, Modifier r103, ScrollState r104, Function3 r105, int r106, int r107, Composer r108, int r109) {
        return ExposedDropdownMenu$lambda$9(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* synthetic */ Unit c(ExposedDropdownMenuBoxScope r100, boolean r101, Function0 r102, Modifier r103, ScrollState r104, boolean r105, Shape r106, long r107, float r110, float r111, BorderStroke r112, Function3 r113, int r114, int r115, int r116, Composer r117, int r118) {
        return ExposedDropdownMenu_vNxi1II$lambda$7(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    public static /* synthetic */ Unit d(ExposedDropdownMenuBoxScope r100, boolean r101, Function0 r102, Modifier r103, ScrollState r104, boolean r105, boolean r106, Shape r107, long r108, float r110, float r111, BorderStroke r112, Function3 r113, int r114, int r115, int r116, Composer r117, int r118) {
        return ExposedDropdownMenu_kbRbctU$lambda$8(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    public static /* synthetic */ Unit e(MutableState r100) {
        return ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(r100);
    }

    public abstract Modifier exposedDropdownSize(Modifier r100, boolean r101);

    public abstract boolean getAlwaysFocusable$material3();

    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3, reason: not valid java name */
    public abstract String mo2206getAnchorTypeoYjWRB4$material3();

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac, reason: not valid java name */
    public abstract Modifier mo2207menuAnchor2Hz36ac(Modifier r100, String r101, boolean r102);

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(MutableState r100) {
        Unit r101 = Unit.INSTANCE;
        r100.setValue(r101);
        return r101;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier r100) {
        return m2203menuAnchor2Hz36ac$default(this, r100, ExposedDropdownMenuAnchorType.Companion.m2201getPrimaryNotEditableoYjWRB4(), false, 2, null);
    }

    private static final Unit ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(MutableState r100, IntRect r101, IntRect r102) {
        r100.setValue(TransformOrigin.m5231boximpl(MenuKt.calculateTransformOrigin(r101, r102)));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope r100, Modifier r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r102 = true;
    L7:
        return r100.exposedDropdownSize(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2203menuAnchor2Hz36ac$default(ExposedDropdownMenuBoxScope r100, Modifier r101, String r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r103 = true;
    L7:
        return r100.mo2207menuAnchor2Hz36ac(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    public final /* synthetic */ void ExposedDropdownMenu(final boolean r210, final Function0 r211, Modifier r212, ScrollState r310, final Function3 r311, Composer r312, final int r313, final int r314) {
        Composer r100 = r312.startRestartGroup(-1501437777);
        if ((r314 & 1) == 0) goto L6;
        int r101 = r313 | 6;
    L14:
        if ((r314 & 2) == 0) goto L17;
        r101 = r101 | 48;
    L24:
        int r102 = r314 & 4;
        if (r102 == 0) goto L28;
        r101 = r101 | 384;
    L34:
        Modifier r103 = r212;
    L36:
        if ((r313 & 3072) == 0) goto L38;
        ScrollState r104 = r310;
    L47:
        if ((r314 & 16) == 0) goto L50;
        r101 = r101 | 24576;
    L57:
        if ((r314 & 32) == 0) goto L60;
        r101 = r101 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    L67:
        if ((74899 & r101) == 74898) goto L69;
        boolean r105 = true;
    L71:
        if (r100.shouldExecute(r105, r101 & 1) == false) goto L95;
        r100.startDefaults();
        if ((r313 & 1) != 0) goto L75;
    L81:
        if (r102 == 0) goto L83;
        Modifier r106 = Modifier.Companion;
    L85:
        if ((r314 & 8) == 0) goto L87;
        ScrollState r107 = ScrollKt.rememberScrollState(0, r100, 0, 1);
        r101 = r101 & (-7169);
    L88:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventStart(-1501437777, r101, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
    L91:
        MenuDefaults r108 = MenuDefaults.INSTANCE;
        Shape r110 = r108.getShape(r100, 6);
        long r111 = r108.getContainerColor(r100, 6);
        float r112 = r108.m2374getTonalElevationD9Ej5fM();
        float r113 = r108.m2373getShadowElevationD9Ej5fM();
        int r213 = ((((r101 & 14) | 906166272) | (r101 & 112)) | (r101 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT)) | (r101 & 7168);
        int r109 = r101 >> 9;
        Modifier r114 = r106;
        ScrollState r115 = r107;
        m2204ExposedDropdownMenukbRbctU(r210, r211, r114, r115, false, true, r110, r111, r112, r113, null, r311, r100, r213, ((r109 & 112) | 6) | (r109 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventEnd();
    L94:
        r104 = r107;
    L96:
        ScopeUpdateScope r116 = r100.endRestartGroup();
        if (r116 == null) goto L100;
        final Modifier r117 = r106;
        final ScrollState r118 = r104;
        r116.updateScope(new ma(this, r210, r211, r117, r118, r311, r313, r314));
        return;
    L100:
        return;
    L87:
        r107 = r104;
        goto L88
    L83:
        r106 = r103;
        goto L85
    L75:
        if (r100.getDefaultsInvalid() == true) goto L81;
        r100.skipToGroupEnd();
        if ((r314 & 8) == 0) goto L80;
        r101 = r101 & (-7169);
    L80:
        r106 = r103;
        goto L87
    L95:
        r100.skipToGroupEnd();
        r106 = r103;
        goto L96
    L69:
        r105 = false;
        goto L71
    L60:
        if ((r313 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) goto L67;
        if (r100.changed(this) == false) goto L64;
        int r119 = 131072;
    L65:
        r101 = r101 | r119;
        goto L67
    L64:
        r119 = 65536;
        goto L65
    L50:
        if ((r313 & 24576) != 0) goto L57;
        if (r100.changedInstance(r311) == false) goto L54;
        int r120 = 16384;
    L55:
        r101 = r101 | r120;
        goto L57
    L54:
        r120 = 8192;
        goto L55
    L38:
        if ((r314 & 8) != 0) goto L42;
        r104 = r310;
        if (r100.changed(r104) == false) goto L43;
        int r121 = 2048;
    L44:
        r101 = r101 | r121;
    L43:
        r121 = 1024;
        goto L44
    L42:
        r104 = r310;
        goto L43
    L28:
        if ((r313 & 384) != 0) goto L34;
        r103 = r212;
        if (r100.changed(r103) == false) goto L32;
        int r122 = 256;
    L33:
        r101 = r101 | r122;
        goto L36
    L32:
        r122 = 128;
        goto L33
    L17:
        if ((r313 & 48) != 0) goto L24;
        if (r100.changedInstance(r211) == false) goto L21;
        int r123 = 32;
    L22:
        r101 = r101 | r123;
        goto L24
    L21:
        r123 = 16;
        goto L22
    L6:
        if ((r313 & 6) == 0) goto L8;
        r101 = r313;
        goto L14
    L8:
        if (r100.changed(r210) == false) goto L10;
        int r124 = 4;
    L11:
        r101 = r124 | r313;
        goto L14
    L10:
        r124 = 2;
        goto L11
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    public final void m2205ExposedDropdownMenuvNxi1II(final boolean r310, final Function0<Unit> r311, Modifier r410, ScrollState r411, boolean r412, Shape r413, long r414, float r415, float r416, BorderStroke r417, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r418, Composer r510, final int r511, final int r512, final int r513) {
        Composer r100 = r510.startRestartGroup(-126848451);
        if ((r513 & 1) == 0) goto L6;
        int r101 = r511 | 6;
    L14:
        if ((r513 & 2) == 0) goto L17;
        r101 = r101 | 48;
    L24:
        int r102 = r513 & 4;
        if (r102 == 0) goto L28;
        r101 = r101 | 384;
    L36:
        if ((r511 & 3072) == 0) goto L38;
        ScrollState r110 = r411;
    L46:
        int r111 = r513 & 16;
        if (r111 == 0) goto L50;
        r101 = r101 | 24576;
    L56:
        boolean r112 = r412;
    L58:
        if ((r511 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) goto L68;
        if ((r513 & 32) == 0) goto L62;
    L64:
        int r113 = 65536;
    L65:
        r101 = r101 | r113;
        goto L68
    L62:
        if (r100.changed(r413) == false) goto L64;
        r113 = 131072;
    L68:
        if ((r511 & 1572864) != 0) goto L77;
        if ((r513 & 64) == 0) goto L72;
    L74:
        int r114 = 524288;
    L75:
        r101 = r101 | r114;
        goto L77
    L72:
        if (r100.changed(r414) == false) goto L74;
        r114 = 1048576;
    L77:
        int r103 = r513 & 128;
        if (r103 == 0) goto L81;
        r101 = r101 | 12582912;
    L87:
        int r104 = r513 & 256;
        if (r104 == 0) goto L91;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L97:
        int r105 = r513 & 512;
        if (r105 == 0) goto L101;
        r101 = r101 | 805306368;
    L108:
        if ((r513 & 1024) == 0) goto L111;
        int r115 = r512 | 6;
    L119:
        if ((r513 & 2048) == 0) goto L122;
        r115 = r115 | 48;
    L129:
        int r106 = r115;
        if ((r101 & 306783379) == 306783378) goto L132;
    L135:
        boolean r107 = true;
    L137:
        if (r100.shouldExecute(r107, r101 & 1) == false) goto L214;
        r100.startDefaults();
        if ((r511 & 1) != 0) goto L141;
    L153:
        if (r102 == 0) goto L155;
        Modifier r108 = Modifier.Companion;
    L157:
        if ((r513 & 8) == 0) goto L159;
        r110 = ScrollKt.rememberScrollState(0, r100, 0, 1);
        r101 = r101 & (-7169);
    L159:
        if (r111 == 0) goto L162;
        r112 = true;
    L162:
        if ((r513 & 32) == 0) goto L164;
        Shape r109 = MenuDefaults.INSTANCE.getShape(r100, 6);
        r101 = r101 & (-458753);
    L166:
        if ((r513 & 64) == 0) goto L168;
        long r116 = MenuDefaults.INSTANCE.getContainerColor(r100, 6);
        r101 = r101 & (-3670017);
    L169:
        if (r103 == 0) goto L171;
        float r117 = MenuDefaults.INSTANCE.m2374getTonalElevationD9Ej5fM();
    L172:
        if (r104 == 0) goto L174;
        float r118 = MenuDefaults.INSTANCE.m2373getShadowElevationD9Ej5fM();
    L175:
        if (r105 == 0) goto L177;
        int r119 = r101;
        long r120 = r116;
        BorderStroke r121 = null;
    L178:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L181;
        ComposerKt.traceEventStart(-126848451, r119, r106, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
    L181:
        Object r122 = r100.rememberedValue();
        Composer.Companion r123 = Composer.Companion;
        if (r122 != r123.getEmpty()) goto L184;
        r122 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        r100.updateRememberedValue(r122);
    L184:
        final MutableState r124 = (MutableState) r122;
        Density r125 = (Density) r100.consume(CompositionLocalsKt.getLocalDensity());
        int r126 = r119;
        int r127 = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, r100, 6).getTop(r125);
        if (r310 == false) goto L190;
        r100.startReplaceGroup(629991660);
        Object r128 = r100.rememberedValue();
        if (r128 != r123.getEmpty()) goto L189;
        r128 = new oa(r124);
        r100.updateRememberedValue(r128);
    L189:
        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) r128, r100, 6);
        r100.endReplaceGroup();
    L191:
        Object r129 = r100.rememberedValue();
        if (r129 != r123.getEmpty()) goto L194;
        r129 = new MutableTransitionState(Boolean.FALSE);
        r100.updateRememberedValue(r129);
    L194:
        final MutableTransitionState r130 = (MutableTransitionState) r129;
        r130.setTargetState(Boolean.valueOf(r310));
        if (((Boolean) r130.getCurrentState()).booleanValue() == false) goto L197;
    L200:
        r100.startReplaceGroup(630396489);
        Object r131 = r100.rememberedValue();
        final BorderStroke r419 = r121;
        if (r131 != r123.getEmpty()) goto L204;
        r131 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.m5231boximpl(TransformOrigin.Companion.m5244getCenterSzJe1aQ()), null, 2, null);
        r100.updateRememberedValue(r131);
    L204:
        final MutableState r132 = (MutableState) r131;
        boolean r133 = r100.changed(r125) | r100.changed(r127);
        Object r134 = r100.rememberedValue();
        if (r133 == false) goto L207;
    L208:
        r134 = new ExposedDropdownMenuPositionProvider(r125, r127, r124, 0, new pa(r132), 8, null);
        r100.updateRememberedValue(r134);
    L209:
        final Modifier r210 = r108;
        final boolean r211 = r112;
        final ScrollState r212 = r110;
        final Shape r213 = r109;
        final long r214 = r120;
        final float r215 = r117;
        final float r312 = r118;
        AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) r134, r311, ExposedDropdownMenu_androidKt.m2223popupPropertiesForAnchorTypeBTG8q0(mo2206getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), r100, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new AnonymousClass2(this, r210, r211, r130, r132, r212, r213, r214, r215, r312, r419, r418), r100, 54), r100, (r126 & 112) | 3072, 0);
        r100.endReplaceGroup();
    L211:
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final BorderStroke r135 = r419;
        final float r136 = r117;
        final ScrollState r137 = r110;
        final boolean r138 = r112;
        final float r139 = r118;
        final Modifier r140 = r108;
        final Shape r141 = r109;
        final long r142 = r120;
    L215:
        ScopeUpdateScope r143 = r100.endRestartGroup();
        if (r143 == null) goto L219;
        r143.updateScope(new qa(this, r310, r311, r140, r137, r138, r141, r142, r136, r139, r135, r418, r511, r512, r513));
        return;
    L219:
        return;
    L207:
        if (r134 != r123.getEmpty()) goto L209;
    L197:
        if (((Boolean) r130.getTargetState()).booleanValue() == true) goto L200;
        r100.startReplaceGroup(631807237);
        r100.endReplaceGroup();
        r118 = r118;
        r419 = r121;
        goto L211
    L190:
        r100.startReplaceGroup(630077189);
        r100.endReplaceGroup();
        goto L191
    L177:
        r121 = r417;
        r119 = r101;
        r120 = r116;
        goto L178
    L174:
        r118 = r416;
        goto L175
    L171:
        r117 = r415;
        goto L172
    L168:
        r116 = r414;
        goto L169
    L164:
        r109 = r413;
        goto L166
    L155:
        r108 = r410;
        goto L157
    L141:
        if (r100.getDefaultsInvalid() == true) goto L153;
        r100.skipToGroupEnd();
        if ((r513 & 8) == 0) goto L147;
        r101 = r101 & (-7169);
    L147:
        if ((r513 & 32) == 0) goto L150;
        r101 = r101 & (-458753);
    L150:
        if ((r513 & 64) == 0) goto L152;
        r101 = r101 & (-3670017);
    L152:
        r108 = r410;
        r109 = r413;
        r117 = r415;
        r118 = r416;
        r121 = r417;
        r119 = r101;
        r120 = r414;
        goto L178
    L214:
        r100.skipToGroupEnd();
        r140 = r410;
        r141 = r413;
        r142 = r414;
        r136 = r415;
        r135 = r417;
        r137 = r110;
        r138 = r112;
        r139 = r416;
        goto L215
    L132:
        if ((r106 & 19) != 18) goto L135;
        r107 = false;
        goto L137
    L122:
        if ((r512 & 48) != 0) goto L129;
        if (r100.changed(this) == false) goto L126;
        int r144 = 32;
    L127:
        r115 = r115 | r144;
        goto L129
    L126:
        r144 = 16;
        goto L127
    L111:
        if ((r512 & 6) == 0) goto L113;
        r115 = r512;
        goto L119
    L113:
        if (r100.changedInstance(r418) == false) goto L115;
        int r145 = 4;
    L116:
        r115 = r512 | r145;
        goto L119
    L115:
        r145 = 2;
        goto L116
    L101:
        if ((r511 & 805306368) != 0) goto L108;
        if (r100.changed(r417) == false) goto L105;
        int r146 = 536870912;
    L106:
        r101 = r101 | r146;
        goto L108
    L105:
        r146 = 268435456;
        goto L106
    L91:
        if ((r511 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L97;
        if (r100.changed(r416) == false) goto L95;
        int r147 = 67108864;
    L96:
        r101 = r101 | r147;
        goto L97
    L95:
        r147 = 33554432;
        goto L96
    L81:
        if ((r511 & 12582912) != 0) goto L87;
        if (r100.changed(r415) == false) goto L85;
        int r148 = 8388608;
    L86:
        r101 = r101 | r148;
        goto L87
    L85:
        r148 = 4194304;
        goto L86
    L50:
        if ((r511 & 24576) != 0) goto L56;
        r112 = r412;
        if (r100.changed(r112) == false) goto L54;
        int r149 = 16384;
    L55:
        r101 = r101 | r149;
        goto L58
    L54:
        r149 = 8192;
        goto L55
    L38:
        if ((r513 & 8) != 0) goto L42;
        r110 = r411;
        if (r100.changed(r110) == false) goto L43;
        int r150 = 2048;
    L44:
        r101 = r101 | r150;
    L43:
        r150 = 1024;
        goto L44
    L42:
        r110 = r411;
        goto L43
    L28:
        if ((r511 & 384) != 0) goto L36;
        if (r100.changed(r410) == false) goto L32;
        int r151 = 256;
    L33:
        r101 = r101 | r151;
        goto L36
    L32:
        r151 = 128;
        goto L33
    L17:
        if ((r511 & 48) != 0) goto L24;
        if (r100.changedInstance(r311) == false) goto L21;
        int r152 = 32;
    L22:
        r101 = r101 | r152;
        goto L24
    L21:
        r152 = 16;
        goto L22
    L6:
        if ((r511 & 6) == 0) goto L8;
        r101 = r511;
        goto L14
    L8:
        if (r100.changed(r310) == false) goto L10;
        int r153 = 4;
    L11:
        r101 = r153 | r511;
        goto L14
    L10:
        r153 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    public final void m2204ExposedDropdownMenukbRbctU(final boolean r310, final Function0<Unit> r311, Modifier r312, ScrollState r313, boolean r410, boolean r411, Shape r412, long r413, float r414, float r415, BorderStroke r416, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r417, Composer r418, final int r510, final int r511, final int r512) {
        Composer r100 = r418.startRestartGroup(-1772805535);
        if ((r512 & 1) == 0) goto L6;
        int r101 = r510 | 6;
    L14:
        if ((r512 & 2) == 0) goto L17;
        r101 = r101 | 48;
    L24:
        int r102 = r512 & 4;
        if (r102 == 0) goto L28;
        r101 = r101 | 384;
    L34:
        Modifier r110 = r312;
    L36:
        if ((r510 & 3072) != 0) goto L46;
        if ((r512 & 8) != 0) goto L43;
        if (r100.changed(r313) == false) goto L43;
        int r111 = 2048;
    L44:
        r101 = r101 | r111;
    L43:
        r111 = 1024;
    L46:
        int r112 = r512 & 32;
        if (r112 == 0) goto L50;
        r101 = r101 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    L57:
        if ((r510 & 1572864) != 0) goto L67;
        if ((r512 & 64) == 0) goto L61;
    L63:
        int r113 = 524288;
    L64:
        r101 = r101 | r113;
        goto L67
    L61:
        if (r100.changed(r412) == false) goto L63;
        r113 = 1048576;
    L67:
        if ((r510 & 12582912) != 0) goto L75;
        long r114 = r413;
        if ((r512 & 128) == 0) goto L71;
    L73:
        int r210 = 4194304;
    L74:
        r101 = r101 | r210;
    L76:
        int r103 = r512 & 256;
        if (r103 == 0) goto L80;
        r101 = r101 | AVLogger.LEVEL_LOG_SILENT;
    L86:
        int r104 = r512 & 512;
        if (r104 == 0) goto L90;
        r101 = r101 | 805306368;
    L96:
        int r105 = r512 & 1024;
        if (r105 == 0) goto L100;
        int r115 = r511 | 6;
    L108:
        if ((r512 & 2048) == 0) goto L111;
        r115 = r115 | 48;
    L118:
        int r106 = r115;
        if ((r512 & 4096) == 0) goto L122;
        r106 = r106 | 384;
    L129:
        final boolean r107 = true;
        if ((r101 & 306775187) == 306775186) goto L132;
    L135:
        boolean r108 = true;
    L137:
        if (r100.shouldExecute(r108, r101 & 1) == false) goto L191;
        r100.startDefaults();
        if ((r510 & 1) != 0) goto L141;
    L154:
        if (r102 == 0) goto L156;
        Modifier r109 = Modifier.Companion;
    L158:
        if ((r512 & 8) == 0) goto L160;
        ScrollState r116 = ScrollKt.rememberScrollState(0, r100, 0, 1);
        r101 = r101 & (-7169);
    L162:
        if ((r512 & 16) == 0) goto L164;
        boolean r117 = true;
    L165:
        if (r112 != 0) goto L168;
        r107 = r411;
    L168:
        Modifier r314 = r109;
        if ((r512 & 64) == 0) goto L171;
        Shape r118 = MenuDefaults.INSTANCE.getShape(r100, 6);
        r101 = r101 & (-3670017);
    L173:
        if ((r512 & 128) == 0) goto L175;
        r114 = MenuDefaults.INSTANCE.getContainerColor(r100, 6);
        r101 = r101 & (-29360129);
    L175:
        if (r103 == 0) goto L177;
        float r119 = MenuDefaults.INSTANCE.m2374getTonalElevationD9Ej5fM();
    L178:
        if (r104 == 0) goto L180;
        float r120 = MenuDefaults.INSTANCE.m2373getShadowElevationD9Ej5fM();
    L181:
        if (r105 == 0) goto L183;
        int r121 = r101;
        BorderStroke r122 = null;
        float r123 = r120;
        boolean r124 = r117;
        r110 = r314;
    L184:
        r100.endDefaults();
        boolean r315 = r124;
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventStart(-1772805535, r121, r106, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
    L187:
        int r125 = (((r121 & 14) | (r121 & 112)) | (r121 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT)) | (r121 & 7168);
        int r126 = r121 >> 3;
        int r316 = (((((r125 | (57344 & r126)) | (458752 & r126)) | (3670016 & r126)) | (29360128 & r126)) | (r126 & 234881024)) | ((r106 << 27) & 1879048192);
        int r127 = r106 >> 3;
        m2205ExposedDropdownMenuvNxi1II(r310, r311, r110, r116, r107, r118, r114, r119, r123, r122, r417, r100, r316, (r127 & 14) | (r127 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventEnd();
    L190:
        final Shape r128 = r118;
        final BorderStroke r129 = r122;
        final ScrollState r130 = r116;
        final long r131 = r114;
        final Modifier r132 = r110;
        final float r133 = r123;
        final float r134 = r119;
        final boolean r135 = r315;
    L192:
        ScopeUpdateScope r136 = r100.endRestartGroup();
        if (r136 == null) goto L196;
        r136.updateScope(new na(this, r310, r311, r132, r130, r135, r107, r128, r131, r134, r133, r129, r417, r510, r511, r512));
        return;
    L196:
        return;
    L183:
        r123 = r120;
        r121 = r101;
        r124 = r117;
        r110 = r314;
    L153:
        r122 = r416;
        goto L184
    L180:
        r120 = r415;
        goto L181
    L177:
        r119 = r414;
        goto L178
    L171:
        r118 = r412;
        goto L173
    L164:
        r117 = r410;
        goto L165
    L160:
        r116 = r313;
        goto L162
    L156:
        r109 = r110;
        goto L158
    L141:
        if (r100.getDefaultsInvalid() == true) goto L154;
        r100.skipToGroupEnd();
        if ((r512 & 8) == 0) goto L147;
        r101 = r101 & (-7169);
    L147:
        if ((r512 & 64) == 0) goto L150;
        r101 = r101 & (-3670017);
    L150:
        if ((r512 & 128) == 0) goto L152;
        r101 = r101 & (-29360129);
    L152:
        r116 = r313;
        r124 = r410;
        r107 = r411;
        r118 = r412;
        r119 = r414;
        r123 = r415;
        r121 = r101;
        goto L153
    L191:
        r100.skipToGroupEnd();
        r130 = r313;
        r135 = r410;
        r107 = r411;
        r128 = r412;
        r129 = r416;
        r131 = r114;
        r132 = r110;
        r134 = r414;
        r133 = r415;
        goto L192
    L132:
        if ((r106 & 147) != 146) goto L135;
        r108 = false;
        goto L137
    L122:
        if ((r511 & 384) != 0) goto L129;
        if (r100.changed(this) == false) goto L126;
        int r211 = 256;
    L127:
        r106 = r106 | r211;
        goto L129
    L126:
        r211 = 128;
        goto L127
    L111:
        if ((r511 & 48) != 0) goto L118;
        if (r100.changedInstance(r417) == false) goto L115;
        int r137 = 32;
    L116:
        r115 = r115 | r137;
        goto L118
    L115:
        r137 = 16;
        goto L116
    L100:
        if ((r511 & 6) == 0) goto L102;
        r115 = r511;
        goto L108
    L102:
        if (r100.changed(r416) == false) goto L104;
        int r138 = 4;
    L105:
        r115 = r511 | r138;
        goto L108
    L104:
        r138 = 2;
        goto L105
    L90:
        if ((r510 & 805306368) != 0) goto L96;
        if (r100.changed(r415) == false) goto L94;
        int r212 = 536870912;
    L95:
        r101 = r101 | r212;
        goto L96
    L94:
        r212 = 268435456;
        goto L95
    L80:
        if ((r510 & AVLogger.LEVEL_LOG_SILENT) != 0) goto L86;
        if (r100.changed(r414) == false) goto L84;
        int r213 = 67108864;
    L85:
        r101 = r101 | r213;
        goto L86
    L84:
        r213 = 33554432;
        goto L85
    L71:
        if (r100.changed(r114) == false) goto L73;
        r210 = 8388608;
        goto L74
    L75:
        r114 = r413;
        goto L76
    L50:
        if ((r510 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) goto L57;
        if (r100.changed(r411) == false) goto L54;
        int r139 = 131072;
    L55:
        r101 = r101 | r139;
        goto L57
    L54:
        r139 = 65536;
        goto L55
    L28:
        if ((r510 & 384) != 0) goto L34;
        r110 = r312;
        if (r100.changed(r110) == false) goto L32;
        int r140 = 256;
    L33:
        r101 = r101 | r140;
        goto L36
    L32:
        r140 = 128;
        goto L33
    L17:
        if ((r510 & 48) != 0) goto L24;
        if (r100.changedInstance(r311) == false) goto L21;
        int r141 = 32;
    L22:
        r101 = r101 | r141;
        goto L24
    L21:
        r141 = 16;
        goto L22
    L6:
        if ((r510 & 6) == 0) goto L8;
        r101 = r510;
        goto L14
    L8:
        if (r100.changed(r310) == false) goto L10;
        int r142 = 4;
    L11:
        r101 = r142 | r510;
        goto L14
    L10:
        r142 = 2;
        goto L11
    }
}
