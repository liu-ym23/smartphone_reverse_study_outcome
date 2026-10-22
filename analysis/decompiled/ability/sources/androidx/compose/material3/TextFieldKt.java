package androidx.compose.material3;

import C7.r;
import S7.n;
import S7.o;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÚ\u0002\u0010&\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'\u001aÚ\u0002\u0010&\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020(2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010)\u001aî\u0001\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\r2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0019\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\r2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\r2\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b3\u00104\u001a\u001b\u00106\u001a\u00020\u001d*\u00020\u001d2\u0006\u00105\u001a\u00020\u001dH\u0002¢\u0006\u0004\b6\u00107\u001aR\u0010C\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001ar\u0010O\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-2\u0006\u0010@\u001a\u00020?2\u0006\u0010L\u001a\u00020-2\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a¡\u0001\u0010_\u001a\u00020\u0003*\u00020P2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020S2\b\u0010U\u001a\u0004\u0018\u00010S2\b\u0010V\u001a\u0004\u0018\u00010S2\b\u0010W\u001a\u0004\u0018\u00010S2\b\u0010X\u001a\u0004\u0018\u00010S2\b\u0010Y\u001a\u0004\u0018\u00010S2\b\u0010Z\u001a\u0004\u0018\u00010S2\u0006\u0010[\u001a\u00020S2\b\u0010\\\u001a\u0004\u0018\u00010S2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-2\u0006\u0010L\u001a\u00020-H\u0002¢\u0006\u0004\b_\u0010`\u001a\u0087\u0001\u0010b\u001a\u00020\u0003*\u00020P2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020S2\b\u0010V\u001a\u0004\u0018\u00010S2\b\u0010W\u001a\u0004\u0018\u00010S2\b\u0010X\u001a\u0004\u0018\u00010S2\b\u0010Y\u001a\u0004\u0018\u00010S2\b\u0010Z\u001a\u0004\u0018\u00010S2\u0006\u0010[\u001a\u00020S2\b\u0010\\\u001a\u0004\u0018\u00010S2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010L\u001a\u00020-2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\bb\u0010c\u001a!\u0010g\u001a\u00020\u0005*\u00020\u00052\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0dH\u0000¢\u0006\u0004\bg\u0010h\"\u001a\u0010j\u001a\u00020i8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006n"}, d2 = {"", "value", "Lkotlin/Function1;", "LC7/r;", "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "readOnly", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "singleLine", "", "maxLines", "minLines", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/TextFieldColors;", "colors", TextFieldImplKt.TextFieldId, "(Ljava/lang/String;LS7/k;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;LS7/k;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "textField", "leading", "trailing", "", "animationProgress", "container", "supporting", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "TextFieldLayout", "(Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/o;LS7/n;LS7/n;LS7/n;LS7/n;ZFLS7/n;LS7/n;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", TypedValues.TransitionType.S_FROM, "substractConstraintSafely", "(II)I", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "Landroidx/compose/ui/unit/Constraints;", "constraints", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "calculateWidth", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "Landroidx/compose/ui/layout/Placeable;", "textfieldPlaceable", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithLabel", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ZIIFF)V", "textPlaceable", "placeWithoutLabel", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "indicatorBorder", "drawIndicatorLine", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/State;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "TextFieldWithLabelVerticalPadding", "F", "getTextFieldWithLabelVerticalPadding", "()F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m6844constructorimpl(8);

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
    /* JADX WARN: Removed duplicated region for block: B:271:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:359:? A[RETURN, SYNTHETIC] */
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
    public static final void TextField(final java.lang.String r65, final S7.k r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, S7.n r71, S7.n r72, S7.n r73, S7.n r74, S7.n r75, S7.n r76, S7.n r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, S7.k, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextFieldLayout(final Modifier modifier, n nVar, final n nVar2, o oVar, final n nVar3, final n nVar4, final n nVar5, final n nVar6, final boolean z10, final float f, final n nVar7, n nVar8, PaddingValues paddingValues, Composer composer, final int i, final int i6) {
        int i10;
        int i11;
        PaddingValues paddingValues2;
        float f7;
        o oVar2;
        n nVar9;
        n nVar10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1830307184);
        if ((i & 6) == 0) {
            i10 = i | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(oVar) ? 2048 : 1024;
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
            i10 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        int i12 = i10;
        if ((i6 & 6) == 0) {
            i11 = i6 | (composerStartRestartGroup.changedInstance(nVar7) ? 4 : 2);
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar8) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            paddingValues2 = paddingValues;
            i11 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        int i13 = i11;
        if ((i12 & 306783379) == 306783378 && (i13 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar9 = nVar;
            nVar10 = nVar8;
            oVar2 = oVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i12, i13, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
            }
            boolean z11 = ((1879048192 & i12) == 536870912) | ((234881024 & i12) == 67108864) | ((i13 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z10, f, paddingValues2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            Updater.m3481setimpl(composerM3474constructorimpl, textFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m3481setimpl(composerM3474constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            n setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(setCompositeKeyHash, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            nVar7.invoke(composerStartRestartGroup, Integer.valueOf(i13 & 14));
            composerStartRestartGroup.startReplaceGroup(1341517187);
            if (nVar3 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                S7.a constructor2 = companion.getConstructor();
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
                n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
                if (composerM3474constructorimpl2.getInserting() || !k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                }
                Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar3, composerStartRestartGroup, (i12 >> 12) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1341526310);
            if (nVar4 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                S7.a constructor3 = companion.getConstructor();
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
                n nVarG2 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
                if (composerM3474constructorimpl3.getInserting() || !k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
                }
                Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion.getSetModifier());
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
            composerStartRestartGroup.startReplaceGroup(1341556924);
            if (nVar5 != null) {
                Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), fM6844constructorimpl3, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default);
                S7.a constructor4 = companion.getConstructor();
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
                n nVarG3 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM3474constructorimpl4, currentCompositionLocalMap4);
                if (composerM3474constructorimpl4.getInserting() || !k.b(composerM3474constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash4, composerM3474constructorimpl4, currentCompositeKeyHash4);
                }
                Updater.m3481setimpl(composerM3474constructorimpl4, modifierMaterializeModifier4, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar5, composerStartRestartGroup, (i12 >> 18) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1341568890);
            if (nVar6 != null) {
                float f9 = fCalculateEndPadding;
                Modifier modifierM704paddingqDBjuR0$default2 = PaddingKt.m704paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f9, 0.0f, 10, null);
                f7 = f9;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default2);
                S7.a constructor5 = companion.getConstructor();
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
                n nVarG4 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, composerM3474constructorimpl5, currentCompositionLocalMap5);
                if (composerM3474constructorimpl5.getInserting() || !k.b(composerM3474constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    androidx.appfunctions.metadata.a.z(nVarG4, currentCompositeKeyHash5, composerM3474constructorimpl5, currentCompositeKeyHash5);
                }
                Updater.m3481setimpl(composerM3474constructorimpl5, modifierMaterializeModifier5, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar6, composerStartRestartGroup, (i12 >> 21) & 14);
            } else {
                f7 = fCalculateEndPadding;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1341581092);
            if (nVar2 != null) {
                Modifier modifierM704paddingqDBjuR0$default3 = PaddingKt.m704paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LabelId), DpKt.m6887lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), fM6844constructorimpl3, 0.0f, f7, 0.0f, 10, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default3);
                S7.a constructor6 = companion.getConstructor();
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
                n nVarG5 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy5, composerM3474constructorimpl6, currentCompositionLocalMap6);
                if (composerM3474constructorimpl6.getInserting() || !k.b(composerM3474constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    androidx.appfunctions.metadata.a.z(nVarG5, currentCompositeKeyHash6, composerM3474constructorimpl6, currentCompositeKeyHash6);
                }
                Updater.m3481setimpl(composerM3474constructorimpl6, modifierMaterializeModifier6, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                androidx.compose.foundation.b.A(nVar2, composerStartRestartGroup, (i12 >> 6) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(companion2, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (nVar5 != null) {
                fM6844constructorimpl3 = Dp.m6844constructorimpl(0);
            }
            Modifier modifierM704paddingqDBjuR0$default4 = PaddingKt.m704paddingqDBjuR0$default(modifierWrapContentHeight$default, fM6844constructorimpl3, 0.0f, nVar6 == null ? f7 : Dp.m6844constructorimpl(0), 0.0f, 10, null);
            composerStartRestartGroup.startReplaceGroup(1341611627);
            if (oVar != null) {
                oVar2 = oVar;
                oVar2.invoke(LayoutIdKt.layoutId(companion2, TextFieldImplKt.PlaceholderId).then(modifierM704paddingqDBjuR0$default4), composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 112));
            } else {
                oVar2 = oVar;
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(companion2, TextFieldImplKt.TextFieldId).then(modifierM704paddingqDBjuR0$default4);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), true);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen3);
            S7.a constructor7 = companion.getConstructor();
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
            n nVarG6 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy6, composerM3474constructorimpl7, currentCompositionLocalMap7);
            if (composerM3474constructorimpl7.getInserting() || !k.b(composerM3474constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                androidx.appfunctions.metadata.a.z(nVarG6, currentCompositeKeyHash7, composerM3474constructorimpl7, currentCompositeKeyHash7);
            }
            Updater.m3481setimpl(composerM3474constructorimpl7, modifierMaterializeModifier7, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            nVar9 = nVar;
            nVar9.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.startReplaceGroup(1341622624);
            if (nVar8 != null) {
                Modifier modifierPadding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m733heightInVpY3zN4$default(LayoutIdKt.layoutId(companion2, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2441supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
                S7.a constructor8 = companion.getConstructor();
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
                n nVarG7 = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy7, composerM3474constructorimpl8, currentCompositionLocalMap8);
                if (composerM3474constructorimpl8.getInserting() || !k.b(composerM3474constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    androidx.appfunctions.metadata.a.z(nVarG7, currentCompositeKeyHash8, composerM3474constructorimpl8, currentCompositeKeyHash8);
                }
                Updater.m3481setimpl(composerM3474constructorimpl8, modifierMaterializeModifier8, companion.getSetModifier());
                nVar10 = nVar8;
                androidx.compose.foundation.b.A(nVar10, composerStartRestartGroup, (i13 >> 3) & 14);
            } else {
                nVar10 = nVar8;
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final n nVar11 = nVar9;
            final o oVar3 = oVar2;
            final PaddingValues paddingValues3 = paddingValues2;
            final n nVar12 = nVar10;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TextFieldKt.TextFieldLayout.2
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
                    TextFieldKt.TextFieldLayout(modifier, nVar11, nVar2, oVar3, nVar3, nVar4, nVar5, nVar6, z10, f, nVar7, nVar12, paddingValues3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2461calculateHeightmKXJcVc(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, float f, long j5, float f7, PaddingValues paddingValues) {
        boolean z10 = i6 > 0;
        float fM6844constructorimpl = Dp.m6844constructorimpl(paddingValues.getBottom() + paddingValues.getTop()) * f7;
        if (z10) {
            fM6844constructorimpl = MathHelpersKt.lerp(Dp.m6844constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2) * f7, fM6844constructorimpl, f);
        }
        int[] iArr = {i14, i12, i13, MathHelpersKt.lerp(i6, 0, f)};
        for (int i16 = 0; i16 < 4; i16++) {
            i = Math.max(i, iArr[i16]);
        }
        return Math.max(Constraints.m6798getMinHeightimpl(j5), Math.max(i10, Math.max(i11, U7.a.U(fM6844constructorimpl + MathHelpersKt.lerp(0, i6, f) + i))) + i15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m2462calculateWidthyeHjK3Y(int i, int i6, int i10, int i11, int i12, int i13, int i14, long j5) {
        int i15 = i10 + i11;
        return Math.max(Math.max(i12 + i15, Math.max(i14 + i15, i13)) + i + i6, Constraints.m6799getMinWidthimpl(j5));
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final State<BorderStroke> state) {
        return DrawModifierKt.drawWithContent(modifier, new S7.k() { // from class: androidx.compose.material3.TextFieldKt.drawIndicatorLine.1
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
                contentDrawScope.drawContent();
                float fMo381toPx0680j_4 = contentDrawScope.mo381toPx0680j_4(state.getValue().getWidth());
                float fM3961getHeightimpl = Size.m3961getHeightimpl(contentDrawScope.mo4707getSizeNHjbRc()) - (fMo381toPx0680j_4 / 2);
                DrawScope.m4692drawLine1RTmtNc$default(contentDrawScope, state.getValue().getBrush(), OffsetKt.Offset(0.0f, fM3961getHeightimpl), OffsetKt.Offset(Size.m3964getWidthimpl(contentDrawScope.mo4707getSizeNHjbRc()), fM3961getHeightimpl), fMo381toPx0680j_4, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z10, int i10, int i11, float f, float f7) {
        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m6983getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i6 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), (z10 ? Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), iHeightOrZero) : U7.a.U(TextFieldImplKt.getTextFieldPadding() * f7)) - U7.a.U((r1 - i10) * f), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i11, 0.0f, 4, null);
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable6) + TextFieldImplKt.widthOrZero(placeable4);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iWidthOrZero, i11, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iWidthOrZero, i11, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i11, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z10, float f, PaddingValues paddingValues) {
        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, placeable7, IntOffset.INSTANCE.m6983getZeronOccac(), 0.0f, 2, null);
        int iHeightOrZero = i6 - TextFieldImplKt.heightOrZero(placeable8);
        int iU = U7.a.U(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z10, iHeightOrZero, iU, placeable5), 0.0f, 4, null);
        }
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable5) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iWidthOrZero, placeWithoutLabel$calculateVerticalPosition(z10, iHeightOrZero, iU, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iWidthOrZero, placeWithoutLabel$calculateVerticalPosition(z10, iHeightOrZero, iU, placeable2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z10, iHeightOrZero, iU, placeable6), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), iHeightOrZero), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, iHeightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z10, int i, int i6, Placeable placeable) {
        return z10 ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i) : i6;
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
    /* JADX WARN: Removed duplicated region for block: B:271:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:359:? A[RETURN, SYNTHETIC] */
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
    public static final void TextField(final androidx.compose.ui.text.input.TextFieldValue r65, final S7.k r66, androidx.compose.ui.Modifier r67, boolean r68, boolean r69, androidx.compose.ui.text.TextStyle r70, S7.n r71, S7.n r72, S7.n r73, S7.n r74, S7.n r75, S7.n r76, S7.n r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, int r84, androidx.compose.foundation.interaction.MutableInteractionSource r85, androidx.compose.ui.graphics.Shape r86, androidx.compose.material3.TextFieldColors r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, S7.k, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }
}
