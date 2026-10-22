package androidx.compose.foundation.contextmenu;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001aC\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aK\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000e\u001a:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\\\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001b\b\u0002\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\b\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010 \u001a\u00020\f2\b\b\u0003\u0010\u001e\u001a\u00020\u001d2\b\b\u0003\u0010\u001f\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!\u001a2\u0010(\u001a\u00020\u0018*\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u001d2\b\b\u0001\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a)\u0010*\u001a\u0004\u0018\u00010)*\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u001d2\b\b\u0001\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b*\u0010+\u001a \u0010.\u001a\u00020\u0018*\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u00100\u001a\u00020\u0018*\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010-\"\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103\"\u0014\u00105\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106\" \u00107\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b7\u00108\u0012\u0004\b;\u0010<\u001a\u0004\b9\u0010:\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "Lkotlin/Function0;", "LC7/r;", "onDismiss", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "contextMenuBuilderBlock", "ContextMenuPopup", "(Landroidx/compose/ui/window/PopupPositionProvider;LS7/a;Landroidx/compose/ui/Modifier;LS7/k;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "colors", "(Landroidx/compose/ui/window/PopupPositionProvider;LS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;LS7/k;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "content", "ContextMenuColumn", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;LS7/o;Landroidx/compose/runtime/Composer;II)V", "", "label", "", "enabled", "Landroidx/compose/ui/graphics/Color;", "leadingIcon", "onClick", "ContextMenuItem", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;LS7/o;LS7/a;Landroidx/compose/runtime/Composer;II)V", "", "backgroundStyleId", "foregroundStyleId", "computeContextMenuColors", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColor", "Landroid/content/res/ColorStateList;", "resolveColorStateList", "(Landroid/content/Context;II)Landroid/content/res/ColorStateList;", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "enabledColor", "disabledColor-4WTKRHQ", "disabledColor", "Landroidx/compose/ui/window/PopupProperties;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "", "DisabledAlpha", "F", "DefaultContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuUi_androidKt {
    private static final ContextMenuColors DefaultContextMenuColors;
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, (e) null);
    private static final float DisabledAlpha = 0.38f;

    static {
        Color.Companion companion = Color.INSTANCE;
        DefaultContextMenuColors = new ContextMenuColors(companion.m4176getWhite0d7_KjU(), companion.m4165getBlack0d7_KjU(), companion.m4165getBlack0d7_KjU(), Color.m4138copywmQWz5c$default(companion.m4165getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4138copywmQWz5c$default(companion.m4165getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.annotation.VisibleForTesting
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextMenuColumn(androidx.compose.foundation.contextmenu.ContextMenuColors r23, androidx.compose.ui.Modifier r24, final S7.o r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuColumn(androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b  */
    @android.annotation.SuppressLint({"ComposableLambdaParameterPosition"})
    @androidx.annotation.VisibleForTesting
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextMenuItem(final java.lang.String r22, final boolean r23, final androidx.compose.foundation.contextmenu.ContextMenuColors r24, androidx.compose.ui.Modifier r25, S7.o r26, final S7.a r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuItem(java.lang.String, boolean, androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, S7.o, S7.a, androidx.compose.runtime.Composer, int, int):void");
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ContextMenuPopup(PopupPositionProvider popupPositionProvider, a aVar, Modifier modifier, k kVar, Composer composer, final int i, final int i6) {
        int i10;
        final PopupPositionProvider popupPositionProvider2;
        final a aVar2;
        final k kVar2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(712057293);
        if ((i6 & 1) != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
        }
        int i11 = i6 & 4;
        if (i11 != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(kVar) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            kVar2 = kVar;
            modifier2 = modifier;
            aVar2 = aVar;
            popupPositionProvider2 = popupPositionProvider;
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(712057293, i10, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:103)");
            }
            ContextMenuPopup(popupPositionProvider, aVar, modifier3, computeContextMenuColors(0, 0, composerStartRestartGroup, 0, 3), kVar, composerStartRestartGroup, (i10 & 1022) | ((i10 << 3) & 57344), 0);
            popupPositionProvider2 = popupPositionProvider;
            aVar2 = aVar;
            kVar2 = kVar;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    ContextMenuUi_androidKt.ContextMenuPopup(popupPositionProvider2, aVar2, modifier2, kVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    @Composable
    @VisibleForTesting
    public static final ContextMenuColors computeContextMenuColors(@StyleRes int i, @StyleRes int i6, Composer composer, int i10, int i11) throws Resources.NotFoundException {
        int i12 = (i11 & 1) != 0 ? R.style.Widget.PopupMenu : i;
        int i13 = (i11 & 2) != 0 ? R.style.TextAppearance.Widget.PopupMenu.Large : i6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i10, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:354)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        boolean zChanged = composer.changed((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())) | composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            ContextMenuColors contextMenuColors = DefaultContextMenuColors;
            long jM369resolveColorg2O1Hgs = m369resolveColorg2O1Hgs(context, i12, R.attr.colorBackground, contextMenuColors.getBackgroundColor());
            ColorStateList colorStateListResolveColorStateList = resolveColorStateList(context, i13, R.attr.textColorPrimary);
            long jM368enabledColor4WTKRHQ = m368enabledColor4WTKRHQ(colorStateListResolveColorStateList, contextMenuColors.getTextColor());
            long jM367disabledColor4WTKRHQ = m367disabledColor4WTKRHQ(colorStateListResolveColorStateList, contextMenuColors.getDisabledTextColor());
            Object contextMenuColors2 = new ContextMenuColors(jM369resolveColorg2O1Hgs, jM368enabledColor4WTKRHQ, jM368enabledColor4WTKRHQ, jM367disabledColor4WTKRHQ, jM367disabledColor4WTKRHQ, null);
            composer.updateRememberedValue(contextMenuColors2);
            objRememberedValue = contextMenuColors2;
        }
        ContextMenuColors contextMenuColors3 = (ContextMenuColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return contextMenuColors3;
    }

    /* renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m367disabledColor4WTKRHQ(ColorStateList colorStateList, long j5) {
        int iM4193toArgb8_81llA = ColorKt.m4193toArgb8_81llA(j5);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, iM4193toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM4193toArgb8_81llA) ? j5 : ColorKt.Color(numValueOf.intValue());
    }

    /* renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m368enabledColor4WTKRHQ(ColorStateList colorStateList, long j5) {
        int iM4193toArgb8_81llA = ColorKt.m4193toArgb8_81llA(j5);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, iM4193toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM4193toArgb8_81llA) ? j5 : ColorKt.Color(numValueOf.intValue());
    }

    public static final ContextMenuColors getDefaultContextMenuColors() {
        return DefaultContextMenuColors;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultContextMenuColors$annotations() {
    }

    /* renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m369resolveColorg2O1Hgs(Context context, @StyleRes int i, @AttrRes int i6, long j5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i6});
        int iM4193toArgb8_81llA = ColorKt.m4193toArgb8_81llA(j5);
        int color = typedArrayObtainStyledAttributes.getColor(0, iM4193toArgb8_81llA);
        typedArrayObtainStyledAttributes.recycle();
        return color == iM4193toArgb8_81llA ? j5 : ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, @StyleRes int i, @AttrRes int i6) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i6});
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextMenuPopup(final androidx.compose.ui.window.PopupPositionProvider r14, final S7.a r15, androidx.compose.ui.Modifier r16, final androidx.compose.foundation.contextmenu.ContextMenuColors r17, final S7.k r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup(androidx.compose.ui.window.PopupPositionProvider, S7.a, androidx.compose.ui.Modifier, androidx.compose.foundation.contextmenu.ContextMenuColors, S7.k, androidx.compose.runtime.Composer, int, int):void");
    }
}
