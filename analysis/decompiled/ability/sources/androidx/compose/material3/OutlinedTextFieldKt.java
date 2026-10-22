package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÚ\u0002\u0010&\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'\u001aÚ\u0002\u0010&\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020(2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010)\u001a\u0082\u0002\u00105\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\r2\u0019\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\r2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u00022\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\r2\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b5\u00106\u001a\u001b\u00108\u001a\u00020\u001d*\u00020\u001d2\u0006\u00107\u001a\u00020\u001dH\u0002¢\u0006\u0004\b8\u00109\u001aj\u0010F\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020-2\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ar\u0010Q\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020-2\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a¡\u0001\u0010a\u001a\u00020\u0003*\u00020R2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u001d2\b\u0010V\u001a\u0004\u0018\u00010U2\b\u0010W\u001a\u0004\u0018\u00010U2\b\u0010X\u001a\u0004\u0018\u00010U2\b\u0010Y\u001a\u0004\u0018\u00010U2\u0006\u0010Z\u001a\u00020U2\b\u0010[\u001a\u0004\u0018\u00010U2\b\u0010\\\u001a\u0004\u0018\u00010U2\u0006\u0010]\u001a\u00020U2\b\u0010^\u001a\u0004\u0018\u00010U2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010C\u001a\u00020-2\u0006\u0010`\u001a\u00020_2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\ba\u0010b\u001a)\u0010d\u001a\u00020\u0005*\u00020\u00052\f\u0010c\u001a\b\u0012\u0004\u0012\u00020/0\f2\u0006\u00104\u001a\u000203H\u0000¢\u0006\u0004\bd\u0010e\"\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h\"\u001a\u0010j\u001a\u00020i8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006n"}, d2 = {"", "value", "Lkotlin/Function1;", "LC7/r;", "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "readOnly", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "singleLine", "", "maxLines", "minLines", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/TextFieldColors;", "colors", "OutlinedTextField", "(Ljava/lang/String;LS7/k;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;LS7/k;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "textField", "leading", "trailing", "", "animationProgress", "Landroidx/compose/ui/geometry/Size;", "onLabelMeasured", "container", "supporting", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "OutlinedTextFieldLayout", "(Landroidx/compose/ui/Modifier;LS7/n;LS7/o;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZFLS7/k;LS7/n;LS7/n;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", TypedValues.TransitionType.S_FROM, "substractConstraintSafely", "(II)I", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "Landroidx/compose/ui/unit/Constraints;", "constraints", "density", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "Landroidx/compose/ui/layout/Placeable;", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;FZFLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/layout/PaddingValues;)V", "labelSize", "outlineCutout", "(Landroidx/compose/ui/Modifier;LS7/a;Landroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "OutlinedTextFieldInnerPadding", "F", "Landroidx/compose/ui/unit/TextUnit;", "OutlinedTextFieldTopPadding", "J", "getOutlinedTextFieldTopPadding", "()J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m6844constructorimpl(4);
    private static final long OutlinedTextFieldTopPadding;

    static {
        long jM3354getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m3354getBodySmallLineHeightXSAIIZE();
        TextUnitKt.m7051checkArithmeticR2X_6o(jM3354getBodySmallLineHeightXSAIIZE);
        OutlinedTextFieldTopPadding = TextUnitKt.pack(TextUnit.m7036getRawTypeimpl(jM3354getBodySmallLineHeightXSAIIZE), TextUnit.m7038getValueimpl(jM3354getBodySmallLineHeightXSAIIZE) / 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final java.lang.String r68, final S7.k r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, S7.n r74, S7.n r75, S7.n r76, S7.n r77, S7.n r78, S7.n r79, S7.n r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instructions count: 1441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, S7.k, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedTextFieldLayout(final Modifier modifier, final n nVar, final o oVar, n nVar2, final n nVar3, final n nVar4, final n nVar5, final n nVar6, final boolean z10, float f, final k kVar, final n nVar7, n nVar8, PaddingValues paddingValues, Composer composer, final int i, final int i6) {
        int i10;
        int i11;
        PaddingValues paddingValues2;
        float f7;
        Alignment.Companion companion;
        final n nVar9;
        n nVar10;
        final float f9 = f;
        Composer composerStartRestartGroup = composer.startRestartGroup(1408290209);
        if ((i & 6) == 0) {
            i10 = i | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar5) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar6) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i10 |= composerStartRestartGroup.changed(z10) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 805306368) == 0) {
            i10 |= composerStartRestartGroup.changed(f9) ? 536870912 : 268435456;
        }
        int i12 = i10;
        if ((i6 & 6) == 0) {
            i11 = i6 | (composerStartRestartGroup.changedInstance(kVar) ? 4 : 2);
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar7) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar8) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i11 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i13 = i11;
        if ((i12 & 306783379) == 306783378 && (i13 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar9 = nVar2;
            nVar10 = nVar8;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i12, i13, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
            }
            boolean z11 = ((i13 & 7168) == 2048) | ((i13 & 14) == 4) | ((234881024 & i12) == 67108864) | ((1879048192 & i12) == 536870912);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(kVar, z10, f9, paddingValues2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            Updater.m3481setimpl(composerM3474constructorimpl, outlinedTextFieldMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m3481setimpl(composerM3474constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            n setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(setCompositeKeyHash, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            nVar7.invoke(composerStartRestartGroup, Integer.valueOf((i13 >> 3) & 14));
            composerStartRestartGroup.startReplaceGroup(250370369);
            if (nVar3 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                S7.a constructor2 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
                if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar3, composerStartRestartGroup, (i12 >> 12) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(250379492);
            if (nVar4 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                S7.a constructor3 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG2 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
                if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
                }
                Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar4, composerStartRestartGroup, (i12 >> 15) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (nVar3 != null) {
                float fM6844constructorimpl = Dp.m6844constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding());
                float fM6844constructorimpl2 = Dp.m6844constructorimpl(0);
                if (fM6844constructorimpl < fM6844constructorimpl2) {
                    fM6844constructorimpl = fM6844constructorimpl2;
                }
                fCalculateStartPadding = Dp.m6844constructorimpl(fM6844constructorimpl);
            }
            float fM6844constructorimpl3 = fCalculateStartPadding;
            if (nVar4 != null) {
                float fM6844constructorimpl4 = Dp.m6844constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding());
                float fM6844constructorimpl5 = Dp.m6844constructorimpl(0);
                if (fM6844constructorimpl4 < fM6844constructorimpl5) {
                    fM6844constructorimpl4 = fM6844constructorimpl5;
                }
                fCalculateEndPadding = Dp.m6844constructorimpl(fM6844constructorimpl4);
            }
            composerStartRestartGroup.startReplaceGroup(250410106);
            if (nVar5 != null) {
                Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), fM6844constructorimpl3, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default);
                S7.a constructor4 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl4 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG3 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM3474constructorimpl4, currentCompositionLocalMap4);
                if (composerM3474constructorimpl4.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash4, composerM3474constructorimpl4, currentCompositeKeyHash4);
                }
                Updater.m3481setimpl(composerM3474constructorimpl4, modifierMaterializeModifier4, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar5, composerStartRestartGroup, (i12 >> 18) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(250422072);
            if (nVar6 != null) {
                f7 = fCalculateEndPadding;
                Modifier modifierM704paddingqDBjuR0$default2 = PaddingKt.m704paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f7, 0.0f, 10, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default2);
                S7.a constructor5 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl5 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG4 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, composerM3474constructorimpl5, currentCompositionLocalMap5);
                if (composerM3474constructorimpl5.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    androidx.appfunctions.metadata.a.z(nVarG4, currentCompositeKeyHash5, composerM3474constructorimpl5, currentCompositeKeyHash5);
                }
                Updater.m3481setimpl(composerM3474constructorimpl5, modifierMaterializeModifier5, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar6, composerStartRestartGroup, (i12 >> 21) & 14);
            } else {
                f7 = fCalculateEndPadding;
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(companion3, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (nVar5 != null) {
                fM6844constructorimpl3 = Dp.m6844constructorimpl(0);
            }
            Modifier modifierM704paddingqDBjuR0$default3 = PaddingKt.m704paddingqDBjuR0$default(modifierWrapContentHeight$default, fM6844constructorimpl3, 0.0f, nVar6 == null ? f7 : Dp.m6844constructorimpl(0), 0.0f, 10, null);
            composerStartRestartGroup.startReplaceGroup(250444361);
            if (oVar != null) {
                oVar.invoke(LayoutIdKt.layoutId(companion3, TextFieldImplKt.PlaceholderId).then(modifierM704paddingqDBjuR0$default3), composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 112));
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(companion3, TextFieldImplKt.TextFieldId).then(modifierM704paddingqDBjuR0$default3);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), true);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen3);
            S7.a constructor6 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl6 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG5 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy5, composerM3474constructorimpl6, currentCompositionLocalMap6);
            if (composerM3474constructorimpl6.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                androidx.appfunctions.metadata.a.z(nVarG5, currentCompositeKeyHash6, composerM3474constructorimpl6, currentCompositeKeyHash6);
            }
            Updater.m3481setimpl(composerM3474constructorimpl6, modifierMaterializeModifier6, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            nVar.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.startReplaceGroup(250455481);
            if (nVar2 != null) {
                f9 = f;
                Modifier modifierLayoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(companion3, DpKt.m6887lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f9), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.LabelId);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
                S7.a constructor7 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor7);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl7 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG6 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy6, composerM3474constructorimpl7, currentCompositionLocalMap7);
                if (composerM3474constructorimpl7.getInserting()) {
                    companion = companion4;
                } else {
                    companion = companion4;
                    if (!kotlin.jvm.internal.k.b(composerM3474constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl7, modifierMaterializeModifier7, companion2.getSetModifier());
                    nVar9 = nVar2;
                    androidx.compose.foundation.b.A(nVar9, composerStartRestartGroup, (i12 >> 9) & 14);
                }
                androidx.appfunctions.metadata.a.z(nVarG6, currentCompositeKeyHash7, composerM3474constructorimpl7, currentCompositeKeyHash7);
                Updater.m3481setimpl(composerM3474constructorimpl7, modifierMaterializeModifier7, companion2.getSetModifier());
                nVar9 = nVar2;
                androidx.compose.foundation.b.A(nVar9, composerStartRestartGroup, (i12 >> 9) & 14);
            } else {
                f9 = f;
                companion = companion4;
                nVar9 = nVar2;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(250473414);
            if (nVar8 != null) {
                Modifier modifierPadding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(companion3, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2441supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
                S7.a constructor8 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor8);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl8 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG7 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy7, composerM3474constructorimpl8, currentCompositionLocalMap8);
                if (composerM3474constructorimpl8.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    androidx.appfunctions.metadata.a.z(nVarG7, currentCompositeKeyHash8, composerM3474constructorimpl8, currentCompositeKeyHash8);
                }
                Updater.m3481setimpl(composerM3474constructorimpl8, modifierMaterializeModifier8, companion2.getSetModifier());
                nVar10 = nVar8;
                androidx.compose.foundation.b.A(nVar10, composerStartRestartGroup, (i13 >> 6) & 14);
            } else {
                nVar10 = nVar8;
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final n nVar11 = nVar10;
            final PaddingValues paddingValues3 = paddingValues2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, nVar, oVar, nVar9, nVar3, nVar4, nVar5, nVar6, z10, f9, kVar, nVar7, nVar11, paddingValues3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2116calculateHeightmKXJcVc(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, float f, long j5, float f7, PaddingValues paddingValues) {
        int[] iArr = {i14, i10, i11, MathHelpersKt.lerp(i13, 0, f)};
        for (int i16 = 0; i16 < 4; i16++) {
            i12 = Math.max(i12, iArr[i16]);
        }
        float top = paddingValues.getTop() * f7;
        return Math.max(Constraints.m6798getMinHeightimpl(j5), Math.max(i, Math.max(i6, U7.a.U(MathHelpersKt.lerp(top, Math.max(top, i13 / 2.0f), f) + i12 + (paddingValues.getBottom() * f7)))) + i15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m2117calculateWidthDHJA7U0(int i, int i6, int i10, int i11, int i12, int i13, int i14, float f, long j5, float f7, PaddingValues paddingValues) {
        int i15 = i10 + i11;
        int iMax = Math.max(i12 + i15, Math.max(i14 + i15, MathHelpersKt.lerp(i13, 0, f))) + i + i6;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return Math.max(iMax, Math.max(U7.a.U((i13 + (Dp.m6844constructorimpl(paddingValues.mo652calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues.mo651calculateLeftPaddingu2uoSUM(layoutDirection)) * f7)) * f), Constraints.m6799getMinWidthimpl(j5)));
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    public static final Modifier outlineCutout(Modifier modifier, final S7.a aVar, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new k() { // from class: androidx.compose.material3.OutlinedTextFieldKt.outlineCutout.1

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                long jM3969unboximpl = ((Size) aVar.invoke()).m3969unboximpl();
                float fM3964getWidthimpl = Size.m3964getWidthimpl(jM3969unboximpl);
                if (fM3964getWidthimpl <= 0.0f) {
                    contentDrawScope.drawContent();
                    return;
                }
                float fMo381toPx0680j_4 = contentDrawScope.mo381toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                float fMo381toPx0680j_42 = contentDrawScope.mo381toPx0680j_4(paddingValues.mo651calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - fMo381toPx0680j_4;
                float f = 2;
                float fM3964getWidthimpl2 = (fMo381toPx0680j_4 * f) + fM3964getWidthimpl + fMo381toPx0680j_42;
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                float fM3964getWidthimpl3 = iArr[layoutDirection.ordinal()] == 1 ? Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - fM3964getWidthimpl2 : fMo381toPx0680j_42 < 0.0f ? 0.0f : fMo381toPx0680j_42;
                if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                    fM3964getWidthimpl2 = Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()) - (fMo381toPx0680j_42 >= 0.0f ? fMo381toPx0680j_42 : 0.0f);
                }
                float f7 = fM3964getWidthimpl2;
                float fM3961getHeightimpl = Size.m3961getHeightimpl(jM3969unboximpl);
                float f9 = (-fM3961getHeightimpl) / f;
                float f10 = fM3961getHeightimpl / f;
                int iM4127getDifferencertfAjoo = ClipOp.INSTANCE.m4127getDifferencertfAjoo();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo4631clipRectN_I0leg(fM3964getWidthimpl3, f9, f7, f10, iM4127getDifferencertfAjoo);
                    contentDrawScope.drawContent();
                } finally {
                    androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z10, float f7, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable placeable10;
        boolean z11;
        int i10;
        int i11;
        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m6983getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int iU = U7.a.U(paddingValues.getTop() * f7);
        int iU2 = U7.a.U(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f7);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f7;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            placeable10 = placeable6;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, U7.a.U(placeable == null ? 0.0f : (1 - f) * (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding)) + iU2, MathHelpersKt.lerp(z10 ? Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), iHeightOrZero) : iU, -(placeable6.getHeight() / 2), f), 0.0f, 4, null);
        } else {
            placeable10 = placeable6;
        }
        if (placeable3 != null) {
            i11 = iU;
            i10 = iHeightOrZero;
            z11 = z10;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z10, iHeightOrZero, iU, placeable10, placeable3), 0.0f, 4, null);
        } else {
            z11 = z10;
            i10 = iHeightOrZero;
            i11 = iU;
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable3) + TextFieldImplKt.widthOrZero(placeable);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, iWidthOrZero, place$calculateVerticalPosition(z11, i10, i11, placeable10, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, iWidthOrZero, place$calculateVerticalPosition(z11, i10, i11, placeable10, placeable7), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i6 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z11, i10, i11, placeable10, placeable4), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i6 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i10), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, i10, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z10, int i, int i6, Placeable placeable, Placeable placeable2) {
        if (z10) {
            i6 = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i6, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i6) {
        return i == Integer.MAX_VALUE ? i : i - i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r68, final S7.k r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, S7.n r74, S7.n r75, S7.n r76, S7.n r77, S7.n r78, S7.n r79, S7.n r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material3.TextFieldColors r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94, final int r95) {
        /*
            Method dump skipped, instructions count: 1441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, S7.k, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }
}
