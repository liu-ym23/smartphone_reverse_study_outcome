package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a@\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aF\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0001¢\u0006\u0004\b\f\u0010\u000b\u001a\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\" \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0017\u001a\u00020\u00168\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "colorScheme", "Landroidx/compose/material3/Shapes;", "shapes", "Landroidx/compose/material3/Typography;", "typography", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "MaterialTheme", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;LS7/n;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "rememberTextSelectionColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "TextSelectionBackgroundOpacity", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MaterialThemeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.material3.MaterialThemeKt$LocalUsingExpressiveTheme$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void MaterialExpressiveTheme(final ColorScheme colorScheme, final Shapes shapes, Typography typography, final n nVar, Composer composer, final int i, final int i6) {
        int i10;
        final Typography typography2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1399457222);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(colorScheme) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(shapes) ? 32 : 16;
        }
        int i13 = i6 & 4;
        if (i13 != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(typography) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            typography2 = typography;
        } else {
            if (i11 != 0) {
                colorScheme = null;
            }
            if (i12 != 0) {
                shapes = null;
            }
            final Typography typography3 = i13 == 0 ? typography : null;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1399457222, i10, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:133)");
            }
            ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalUsingExpressiveTheme;
            if (((Boolean) composerStartRestartGroup.consume(providableCompositionLocal)).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(547059915);
                composerStartRestartGroup.startReplaceGroup(1126027167);
                ColorScheme colorScheme2 = colorScheme == null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6) : colorScheme;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(1126029309);
                Typography typography4 = typography3 == null ? MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6) : typography3;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(1126031253);
                Shapes shapes2 = shapes == null ? MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6) : shapes;
                composerStartRestartGroup.endReplaceGroup();
                MaterialTheme(colorScheme2, shapes2, typography4, nVar, composerStartRestartGroup, i10 & 7168, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(547327197);
                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(Boolean.TRUE), ComposableLambdaKt.rememberComposableLambda(2050809758, true, new n() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialExpressiveTheme.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return r.f317a;
                    }

                    @Composable
                    public final void invoke(Composer composer2, int i14) {
                        if ((i14 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2050809758, i14, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:143)");
                        }
                        ColorScheme colorSchemeExpressiveLightColorScheme = colorScheme;
                        if (colorSchemeExpressiveLightColorScheme == null) {
                            colorSchemeExpressiveLightColorScheme = ColorSchemeKt.expressiveLightColorScheme();
                        }
                        ColorScheme colorScheme3 = colorSchemeExpressiveLightColorScheme;
                        Shapes shapes3 = shapes;
                        Shapes shapes4 = shapes3 == null ? new Shapes(null, null, null, null, null, 31, null) : shapes3;
                        Typography typography5 = typography3;
                        MaterialThemeKt.MaterialTheme(colorScheme3, shapes4, typography5 == null ? new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : typography5, nVar, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
        }
        final ColorScheme colorScheme3 = colorScheme;
        final Shapes shapes3 = shapes;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialExpressiveTheme.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i14) {
                    MaterialThemeKt.MaterialExpressiveTheme(colorScheme3, shapes3, typography2, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0143  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MaterialTheme(androidx.compose.material3.ColorScheme r18, androidx.compose.material3.Shapes r19, androidx.compose.material3.Typography r20, final S7.n r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    @Composable
    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long primary = colorScheme.getPrimary();
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(primary, Color.m4138copywmQWz5c$default(primary, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return textSelectionColors2;
    }
}
