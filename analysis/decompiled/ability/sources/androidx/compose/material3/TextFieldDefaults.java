package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.o;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Immutable
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JJ\u0010\u0018\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J¨\u0002\u0010+\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020(2\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b+\u0010,J8\u00103\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b1\u00102J8\u00105\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b4\u00102J:\u00107\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b6\u00102J\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u00108JÂ\u0003\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u0002092\b\b\u0002\u0010C\u001a\u0002092\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010F\u001a\u0002092\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u0002092\b\b\u0002\u0010J\u001a\u0002092\b\b\u0002\u0010K\u001a\u0002092\b\b\u0002\u0010L\u001a\u0002092\b\b\u0002\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u0002092\b\b\u0002\u0010O\u001a\u0002092\b\b\u0002\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u0002092\b\b\u0002\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u0002092\b\b\u0002\u0010V\u001a\u0002092\b\b\u0002\u0010W\u001a\u0002092\b\b\u0002\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u0002092\b\b\u0002\u0010Z\u001a\u0002092\b\b\u0002\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u0002092\b\b\u0002\u0010]\u001a\u0002092\b\b\u0002\u0010^\u001a\u0002092\b\b\u0002\u0010_\u001a\u0002092\b\b\u0002\u0010`\u001a\u0002092\b\b\u0002\u0010a\u001a\u0002092\b\b\u0002\u0010b\u001a\u0002092\b\b\u0002\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u0002092\b\b\u0002\u0010e\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ9\u0010h\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\bh\u0010iJ:\u0010k\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bj\u00102J:\u0010m\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bl\u00102J:\u0010o\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bn\u00102R\u001d\u0010p\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001d\u0010t\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bt\u0010q\u001a\u0004\bu\u0010sR\u001d\u0010v\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bv\u0010q\u001a\u0004\bw\u0010sR\u001d\u0010x\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bx\u0010q\u001a\u0004\by\u0010sR&\u0010z\u001a\u00020\u000f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bz\u0010q\u0012\u0004\b|\u0010\u0003\u001a\u0004\b{\u0010sR&\u0010}\u001a\u00020\u000f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b}\u0010q\u0012\u0004\b\u007f\u0010\u0003\u001a\u0004\b~\u0010sR\u0013\u0010\u000e\u001a\u00020\r8G¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0085\u0001\u001a\u00020\u000b*\u00030\u0082\u00018AX\u0080\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0088\u0001\u001a\u00020\r8GX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0087\u0001\u0010\u0003\u001a\u0006\b\u0086\u0001\u0010\u0081\u0001R\u001e\u0010\u008b\u0001\u001a\u00020\r8GX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u008a\u0001\u0010\u0003\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008c\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", AppAgent.CONSTRUCT, "()V", "", "enabled", "isError", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/TextFieldColors;", "colors", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/unit/Dp;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "LC7/r;", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", TextFieldImplKt.ContainerId, "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "indicatorLine", "", "value", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "innerTextField", "singleLine", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "container", "DecorationBox", "(Ljava/lang/String;LS7/n;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;LS7/n;Landroidx/compose/runtime/Composer;III)V", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithLabel", "contentPaddingWithoutLabel-a9UjIt4", "contentPaddingWithoutLabel", "supportingTextPadding-a9UjIt4$material3_release", "supportingTextPadding", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/ui/graphics/Color;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "selectionColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "outlinedTextFieldPadding-a9UjIt4", "outlinedTextFieldPadding", "MinHeight", "F", "getMinHeight-D9Ej5fM", "()F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "getFocusedBorderThickness-D9Ej5fM$annotations", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "getOutlinedShape", "getOutlinedShape$annotations", "outlinedShape", "getFilledShape", "getFilledShape$annotations", "filledShape", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m6844constructorimpl(56);
    private static final float MinWidth = Dp.m6844constructorimpl(280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    static {
        float fM6844constructorimpl = Dp.m6844constructorimpl(1);
        UnfocusedIndicatorThickness = fM6844constructorimpl;
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(2);
        FocusedIndicatorThickness = fM6844constructorimpl2;
        UnfocusedBorderThickness = fM6844constructorimpl;
        FocusedBorderThickness = fM6844constructorimpl2;
    }

    private TextFieldDefaults() {
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2435contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f10 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2446contentPaddingWithLabela9UjIt4(f, f7, f9, f10);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2436contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2447contentPaddingWithoutLabela9UjIt4(f, f7, f9, f10);
    }

    @C7.c
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @C7.c
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2437getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @C7.c
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @C7.c
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2438getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    /* renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2439indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z10, boolean z11, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f7, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedIndicatorThickness;
        }
        return textFieldDefaults.m2454indicatorLinegv0btCI(modifier, z10, z11, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedIndicatorThickness : f7);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2440outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2455outlinedTextFieldPaddinga9UjIt4(f, f7, f9, f10);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2441supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f10 = Dp.m6844constructorimpl(0);
        }
        return textFieldDefaults.m2456supportingTextPaddinga9UjIt4$material3_release(f, f7, f9, f10);
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2442textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f10 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2457textFieldWithLabelPaddinga9UjIt4(f, f7, f9, f10);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2443textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f9 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f10 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2458textFieldWithoutLabelPaddinga9UjIt4(f, f7, f9, f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ed  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: Container-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2444Container4EFweAY(final boolean r22, final boolean r23, final androidx.compose.foundation.interaction.InteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.TextFieldColors r26, androidx.compose.ui.graphics.Shape r27, float r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m2444Container4EFweAY(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.material3.ExperimentalMaterial3Api
    @C7.c
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ContainerBox(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, final androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DecorationBox(final java.lang.String r36, final S7.n r37, final boolean r38, final boolean r39, final androidx.compose.ui.text.input.VisualTransformation r40, final androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, S7.n r43, S7.n r44, S7.n r45, S7.n r46, S7.n r47, S7.n r48, S7.n r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, S7.n r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, S7.n, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, S7.n, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    public final TextFieldColors colors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:336)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultTextFieldColors;
    }

    @Composable
    /* renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2445colors0hiis_0(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, TextSelectionColors textSelectionColors, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, long j49, Composer composer, int i, int i6, int i10, int i11, int i12, int i13, int i14) {
        long j50;
        TextSelectionColors textSelectionColors2;
        long jM4175getUnspecified0d7_KjU = (i13 & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM4175getUnspecified0d7_KjU2 = (i13 & 2) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j6;
        long jM4175getUnspecified0d7_KjU3 = (i13 & 4) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j10;
        long jM4175getUnspecified0d7_KjU4 = (i13 & 8) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        long jM4175getUnspecified0d7_KjU5 = (i13 & 16) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j12;
        long jM4175getUnspecified0d7_KjU6 = (i13 & 32) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j13;
        long jM4175getUnspecified0d7_KjU7 = (i13 & 64) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j14;
        long j51 = jM4175getUnspecified0d7_KjU;
        long jM4175getUnspecified0d7_KjU8 = (i13 & 128) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j15;
        long jM4175getUnspecified0d7_KjU9 = (i13 & 256) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j16;
        long jM4175getUnspecified0d7_KjU10 = (i13 & 512) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j17;
        TextSelectionColors textSelectionColors3 = (i13 & 1024) != 0 ? null : textSelectionColors;
        long jM4175getUnspecified0d7_KjU11 = (i13 & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j18;
        long jM4175getUnspecified0d7_KjU12 = (i13 & 4096) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j19;
        long jM4175getUnspecified0d7_KjU13 = (i13 & 8192) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j20;
        long jM4175getUnspecified0d7_KjU14 = (i13 & 16384) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j21;
        long jM4175getUnspecified0d7_KjU15 = (32768 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j22;
        long jM4175getUnspecified0d7_KjU16 = (65536 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j23;
        long jM4175getUnspecified0d7_KjU17 = (131072 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j24;
        long jM4175getUnspecified0d7_KjU18 = (262144 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j25;
        long jM4175getUnspecified0d7_KjU19 = (524288 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j26;
        long jM4175getUnspecified0d7_KjU20 = (1048576 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j27;
        long jM4175getUnspecified0d7_KjU21 = (2097152 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j28;
        long jM4175getUnspecified0d7_KjU22 = (4194304 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j29;
        long jM4175getUnspecified0d7_KjU23 = (8388608 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j30;
        long jM4175getUnspecified0d7_KjU24 = (16777216 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j31;
        long jM4175getUnspecified0d7_KjU25 = (33554432 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j32;
        long jM4175getUnspecified0d7_KjU26 = (67108864 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j33;
        long jM4175getUnspecified0d7_KjU27 = (134217728 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j34;
        long jM4175getUnspecified0d7_KjU28 = (268435456 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j35;
        long jM4175getUnspecified0d7_KjU29 = (536870912 & i13) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j36;
        long jM4175getUnspecified0d7_KjU30 = (i13 & BasicMeasure.EXACTLY) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j37;
        long jM4175getUnspecified0d7_KjU31 = (i14 & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j38;
        long jM4175getUnspecified0d7_KjU32 = (i14 & 2) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j39;
        long jM4175getUnspecified0d7_KjU33 = (i14 & 4) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j40;
        long jM4175getUnspecified0d7_KjU34 = (i14 & 8) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j41;
        long jM4175getUnspecified0d7_KjU35 = (i14 & 16) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j42;
        long jM4175getUnspecified0d7_KjU36 = (i14 & 32) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j43;
        long jM4175getUnspecified0d7_KjU37 = (i14 & 64) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j44;
        long jM4175getUnspecified0d7_KjU38 = (i14 & 128) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j45;
        long jM4175getUnspecified0d7_KjU39 = (i14 & 256) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j46;
        long jM4175getUnspecified0d7_KjU40 = (i14 & 512) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j47;
        long jM4175getUnspecified0d7_KjU41 = (i14 & 1024) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j48;
        long jM4175getUnspecified0d7_KjU42 = (i14 & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j49;
        if (ComposerKt.isTraceInProgress()) {
            j50 = jM4175getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
            ComposerKt.traceEventStart(1513344955, i, i6, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:438)");
        } else {
            j50 = jM4175getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors textFieldColorsM2382copyejIjP34 = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i12 >> 6) & 112).m2382copyejIjP34(j51, jM4175getUnspecified0d7_KjU2, jM4175getUnspecified0d7_KjU3, jM4175getUnspecified0d7_KjU4, jM4175getUnspecified0d7_KjU5, jM4175getUnspecified0d7_KjU6, jM4175getUnspecified0d7_KjU7, jM4175getUnspecified0d7_KjU8, jM4175getUnspecified0d7_KjU9, jM4175getUnspecified0d7_KjU10, textSelectionColors2, jM4175getUnspecified0d7_KjU11, jM4175getUnspecified0d7_KjU12, jM4175getUnspecified0d7_KjU13, jM4175getUnspecified0d7_KjU14, jM4175getUnspecified0d7_KjU15, jM4175getUnspecified0d7_KjU16, jM4175getUnspecified0d7_KjU17, jM4175getUnspecified0d7_KjU18, jM4175getUnspecified0d7_KjU19, jM4175getUnspecified0d7_KjU20, jM4175getUnspecified0d7_KjU21, jM4175getUnspecified0d7_KjU22, jM4175getUnspecified0d7_KjU23, jM4175getUnspecified0d7_KjU24, jM4175getUnspecified0d7_KjU25, jM4175getUnspecified0d7_KjU26, jM4175getUnspecified0d7_KjU27, jM4175getUnspecified0d7_KjU28, jM4175getUnspecified0d7_KjU29, jM4175getUnspecified0d7_KjU30, jM4175getUnspecified0d7_KjU31, jM4175getUnspecified0d7_KjU32, jM4175getUnspecified0d7_KjU33, jM4175getUnspecified0d7_KjU34, jM4175getUnspecified0d7_KjU35, jM4175getUnspecified0d7_KjU36, jM4175getUnspecified0d7_KjU37, jM4175getUnspecified0d7_KjU38, jM4175getUnspecified0d7_KjU39, jM4175getUnspecified0d7_KjU40, jM4175getUnspecified0d7_KjU41, j50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return textFieldColorsM2382copyejIjP34;
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2446contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m696PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2447contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m696PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @Composable
    public final TextFieldColors getDefaultTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:486)");
        }
        TextFieldColors defaultTextFieldColorsCached = colorScheme.getDefaultTextFieldColorsCached();
        composer.startReplaceGroup(27085453);
        if (defaultTextFieldColorsCached == null) {
            FilledTextFieldTokens filledTextFieldTokens = FilledTextFieldTokens.INSTANCE;
            TextFieldColors textFieldColors = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusInputColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledInputColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorInputColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getCaretColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorFocusCaretColor()), (TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getActiveIndicatorColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledActiveIndicatorColor()), filledTextFieldTokens.getDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getLeadingIconColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledLeadingIconColor()), filledTextFieldTokens.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getTrailingIconColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledTrailingIconColor()), filledTextFieldTokens.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getLabelColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledLabelColor()), filledTextFieldTokens.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledInputColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getSupportingColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledSupportingColor()), filledTextFieldTokens.getDisabledSupportingOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), null);
            colorScheme.setDefaultTextFieldColorsCached$material3_release(textFieldColors);
            defaultTextFieldColorsCached = textFieldColors;
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultTextFieldColorsCached;
    }

    @Composable
    public final Shape getFilledShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:621)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return shape;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2448getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m2449getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2450getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2451getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    public final Shape getOutlinedShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:613)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return shape;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:60)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2452getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m2453getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    @ExperimentalMaterial3Api
    /* renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m2454indicatorLinegv0btCI(Modifier modifier, boolean z10, boolean z11, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f7) {
        final boolean z12;
        final boolean z13;
        final InteractionSource interactionSource2;
        final TextFieldColors textFieldColors2;
        final float f9;
        final float f10;
        k noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            z12 = z10;
            z13 = z11;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f9 = f;
            f10 = f7;
            noInspectorInfo = new k() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return r.f317a;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("indicatorLine");
                    androidx.compose.foundation.b.k(z13, androidx.compose.foundation.b.k(z12, inspectorInfo.getProperties(), "enabled", inspectorInfo), "isError", inspectorInfo).set("interactionSource", interactionSource2);
                    inspectorInfo.getProperties().set("colors", textFieldColors2);
                    androidx.compose.foundation.b.j(f9, inspectorInfo.getProperties(), "focusedIndicatorLineThickness", inspectorInfo).set("unfocusedIndicatorLineThickness", Dp.m6842boximpl(f10));
                }
            };
        } else {
            z12 = z10;
            z13 = z11;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f9 = f;
            f10 = f7;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final float f11 = f10;
        final float f12 = f9;
        final TextFieldColors textFieldColors3 = textFieldColors2;
        final boolean z14 = z13;
        final InteractionSource interactionSource3 = interactionSource2;
        final boolean z15 = z12;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new o() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
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
                composer.startReplaceGroup(-891038934);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, i, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:169)");
                }
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, TextFieldImplKt.m2759animateBorderStrokeAsStateNuRrP5Q(z15, z14, FocusInteractionKt.collectIsFocusedAsState(interactionSource3, composer, 0).getValue().booleanValue(), textFieldColors3, f12, f11, composer, 0));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    @C7.c
    /* renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2455outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m2109contentPaddinga9UjIt4(start, top, end, bottom);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release, reason: not valid java name */
    public final PaddingValues m2456supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m696PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @C7.c
    /* renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2457textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m2446contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    @C7.c
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2458textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m2447contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }
}
