package androidx.compose.foundation.text;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "getDefaultCursorThickness", "()F", "F", "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCursorKt {
    private static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m139infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new k() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
            return r.f317a;
        }

        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            keyframesSpecConfig.setDurationMillis(1000);
            Float fValueOf = Float.valueOf(1.0f);
            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) fValueOf, 0);
            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) fValueOf, 499);
            Float fValueOf2 = Float.valueOf(0.0f);
            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) fValueOf2, 500);
            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) fValueOf2, 999);
        }
    }), null, 0, 6, null);
    private static final float DefaultCursorThickness = Dp.m6844constructorimpl(2);

    public static final Modifier cursor(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, final Brush brush, boolean z10) {
        return z10 ? ComposedModifierKt.composed$default(modifier, null, new o() { // from class: androidx.compose.foundation.text.TextFieldCursorKt.cursor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier modifierDrawWithContent;
                composer.startReplaceGroup(-84507373);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:45)");
                }
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new CursorAnimationState();
                    composer.updateRememberedValue(objRememberedValue);
                }
                final CursorAnimationState cursorAnimationState = (CursorAnimationState) objRememberedValue;
                Brush brush2 = brush;
                boolean z11 = ((brush2 instanceof SolidColor) && ((SolidColor) brush2).getValue() == 16) ? false : true;
                if (((WindowInfo) composer.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m6305getCollapsedimpl(textFieldValue.getSelection()) && z11) {
                    composer.startReplaceGroup(808320157);
                    AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
                    TextRange textRangeM6299boximpl = TextRange.m6299boximpl(textFieldValue.getSelection());
                    boolean zChangedInstance = composer.changedInstance(cursorAnimationState);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.LaunchedEffect(annotatedString, textRangeM6299boximpl, (n) objRememberedValue2, composer, 0);
                    boolean zChangedInstance2 = composer.changedInstance(cursorAnimationState) | composer.changedInstance(offsetMapping) | composer.changed(textFieldValue) | composer.changedInstance(legacyTextFieldState) | composer.changed(brush);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    final Brush brush3 = brush;
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                        Object obj = new k() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((ContentDrawScope) obj2);
                                return r.f317a;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                Rect rect;
                                TextLayoutResult value;
                                contentDrawScope.drawContent();
                                float cursorAlpha = cursorAnimationState.getCursorAlpha();
                                if (cursorAlpha == 0.0f) {
                                    return;
                                }
                                int iOriginalToTransformed = offsetMapping2.originalToTransformed(TextRange.m6311getStartimpl(textFieldValue2.getSelection()));
                                TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                                if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(iOriginalToTransformed)) == null) {
                                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                float fMo381toPx0680j_4 = contentDrawScope.mo381toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                                float f = fMo381toPx0680j_4 / 2;
                                float left = rect.getLeft() + f;
                                float fM3964getWidthimpl = Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - f;
                                if (left > fM3964getWidthimpl) {
                                    left = fM3964getWidthimpl;
                                }
                                if (left >= f) {
                                    f = left;
                                }
                                DrawScope.m4692drawLine1RTmtNc$default(contentDrawScope, brush3, OffsetKt.Offset(f, rect.getTop()), OffsetKt.Offset(f, rect.getBottom()), fMo381toPx0680j_4, 0, null, cursorAlpha, null, 0, 432, null);
                            }
                        };
                        composer.updateRememberedValue(obj);
                        objRememberedValue3 = obj;
                    }
                    modifierDrawWithContent = DrawModifierKt.drawWithContent(modifier2, (k) objRememberedValue3);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(809534830);
                    composer.endReplaceGroup();
                    modifierDrawWithContent = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierDrawWithContent;
            }
        }, 1, null) : modifier;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
