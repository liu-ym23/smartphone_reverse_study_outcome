package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Immutable
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u009e\u0002\u0010(\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020%2\u0013\b\u0002\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b(\u0010)J8\u0010&\u001a\u00020%2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u00100JÂ\u0003\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u0002012\b\b\u0002\u00106\u001a\u0002012\b\b\u0002\u00107\u001a\u0002012\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00109\u001a\u0002012\b\b\u0002\u0010:\u001a\u0002012\b\b\u0002\u0010;\u001a\u0002012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010>\u001a\u0002012\b\b\u0002\u0010?\u001a\u0002012\b\b\u0002\u0010@\u001a\u0002012\b\b\u0002\u0010A\u001a\u0002012\b\b\u0002\u0010B\u001a\u0002012\b\b\u0002\u0010C\u001a\u0002012\b\b\u0002\u0010D\u001a\u0002012\b\b\u0002\u0010E\u001a\u0002012\b\b\u0002\u0010F\u001a\u0002012\b\b\u0002\u0010G\u001a\u0002012\b\b\u0002\u0010H\u001a\u0002012\b\b\u0002\u0010I\u001a\u0002012\b\b\u0002\u0010J\u001a\u0002012\b\b\u0002\u0010K\u001a\u0002012\b\b\u0002\u0010L\u001a\u0002012\b\b\u0002\u0010M\u001a\u0002012\b\b\u0002\u0010N\u001a\u0002012\b\b\u0002\u0010O\u001a\u0002012\b\b\u0002\u0010P\u001a\u0002012\b\b\u0002\u0010Q\u001a\u0002012\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u0002012\b\b\u0002\u0010T\u001a\u0002012\b\b\u0002\u0010U\u001a\u0002012\b\b\u0002\u0010V\u001a\u0002012\b\b\u0002\u0010W\u001a\u0002012\b\b\u0002\u0010X\u001a\u0002012\b\b\u0002\u0010Y\u001a\u0002012\b\b\u0002\u0010Z\u001a\u0002012\b\b\u0002\u0010[\u001a\u0002012\b\b\u0002\u0010\\\u001a\u0002012\b\b\u0002\u0010]\u001a\u000201H\u0007ø\u0001\u0000¢\u0006\u0004\b^\u0010_JR\u0010b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b`\u0010aR\u001d\u0010c\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001d\u0010g\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bg\u0010d\u001a\u0004\bh\u0010fR\u001d\u0010i\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bi\u0010d\u001a\u0004\bj\u0010fR\u001d\u0010k\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bk\u0010d\u001a\u0004\bl\u0010fR\u0011\u0010\u000e\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0018\u0010r\u001a\u00020\u000b*\u00020o8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bp\u0010q\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006s"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", AppAgent.CONSTRUCT, "()V", "", "enabled", "isError", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/TextFieldColors;", "colors", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/unit/Dp;", "focusedBorderThickness", "unfocusedBorderThickness", "LC7/r;", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", TextFieldImplKt.ContainerId, "", "value", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "innerTextField", "singleLine", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "container", "DecorationBox", "(Ljava/lang/String;LS7/n;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;LS7/n;Landroidx/compose/runtime/Composer;III)V", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/ui/graphics/Color;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "selectionColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "ContainerBox", "MinHeight", "F", "getMinHeight-D9Ej5fM", "()F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m6844constructorimpl(56);
    private static final float MinWidth = Dp.m6844constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m6844constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m6844constructorimpl(2);

    private OutlinedTextFieldDefaults() {
    }

    /* renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2105contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f7, float f9, float f10, int i, Object obj) {
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
        return outlinedTextFieldDefaults.m2109contentPaddinga9UjIt4(f, f7, f9, f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
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
    public final void m2106Container4EFweAY(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.ui.Modifier r24, androidx.compose.material3.TextFieldColors r25, androidx.compose.ui.graphics.Shape r26, float r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m2106Container4EFweAY(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0102  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.material3.ExperimentalMaterial3Api
    @C7.c
    @androidx.compose.runtime.Composable
    /* renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2107ContainerBoxnbWgWpA(final boolean r18, final boolean r19, final androidx.compose.foundation.interaction.InteractionSource r20, androidx.compose.material3.TextFieldColors r21, androidx.compose.ui.graphics.Shape r22, float r23, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m2107ContainerBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DecorationBox(final java.lang.String r37, final S7.n r38, final boolean r39, final boolean r40, final androidx.compose.ui.text.input.VisualTransformation r41, final androidx.compose.foundation.interaction.InteractionSource r42, boolean r43, S7.n r44, S7.n r45, S7.n r46, S7.n r47, S7.n r48, S7.n r49, S7.n r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, S7.n r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1051
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox(java.lang.String, S7.n, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, S7.n, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    public final TextFieldColors colors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:921)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultOutlinedTextFieldColors;
    }

    @Composable
    /* renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2108colors0hiis_0(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, TextSelectionColors textSelectionColors, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, long j49, Composer composer, int i, int i6, int i10, int i11, int i12, int i13, int i14) {
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
            ComposerKt.traceEventStart(1767617725, i, i6, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1023)");
        } else {
            j50 = jM4175getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors textFieldColorsM2382copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i12 >> 6) & 112).m2382copyejIjP34(j51, jM4175getUnspecified0d7_KjU2, jM4175getUnspecified0d7_KjU3, jM4175getUnspecified0d7_KjU4, jM4175getUnspecified0d7_KjU5, jM4175getUnspecified0d7_KjU6, jM4175getUnspecified0d7_KjU7, jM4175getUnspecified0d7_KjU8, jM4175getUnspecified0d7_KjU9, jM4175getUnspecified0d7_KjU10, textSelectionColors2, jM4175getUnspecified0d7_KjU11, jM4175getUnspecified0d7_KjU12, jM4175getUnspecified0d7_KjU13, jM4175getUnspecified0d7_KjU14, jM4175getUnspecified0d7_KjU15, jM4175getUnspecified0d7_KjU16, jM4175getUnspecified0d7_KjU17, jM4175getUnspecified0d7_KjU18, jM4175getUnspecified0d7_KjU19, jM4175getUnspecified0d7_KjU20, jM4175getUnspecified0d7_KjU21, jM4175getUnspecified0d7_KjU22, jM4175getUnspecified0d7_KjU23, jM4175getUnspecified0d7_KjU24, jM4175getUnspecified0d7_KjU25, jM4175getUnspecified0d7_KjU26, jM4175getUnspecified0d7_KjU27, jM4175getUnspecified0d7_KjU28, jM4175getUnspecified0d7_KjU29, jM4175getUnspecified0d7_KjU30, jM4175getUnspecified0d7_KjU31, jM4175getUnspecified0d7_KjU32, jM4175getUnspecified0d7_KjU33, jM4175getUnspecified0d7_KjU34, jM4175getUnspecified0d7_KjU35, jM4175getUnspecified0d7_KjU36, jM4175getUnspecified0d7_KjU37, jM4175getUnspecified0d7_KjU38, jM4175getUnspecified0d7_KjU39, jM4175getUnspecified0d7_KjU40, jM4175getUnspecified0d7_KjU41, j50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return textFieldColorsM2382copyejIjP34;
    }

    /* renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2109contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m696PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    @Composable
    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1071)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached = colorScheme.getDefaultOutlinedTextFieldColorsCached();
        composer.startReplaceGroup(1540400102);
        if (defaultOutlinedTextFieldColorsCached == null) {
            OutlinedTextFieldTokens outlinedTextFieldTokens = OutlinedTextFieldTokens.INSTANCE;
            long jFromToken = ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusInputColor());
            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputColor());
            long jM4138copywmQWz5c$default = Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorInputColor());
            Color.Companion companion = Color.INSTANCE;
            TextFieldColors textFieldColors = new TextFieldColors(jFromToken, jFromToken2, jM4138copywmQWz5c$default, jFromToken3, companion.m4174getTransparent0d7_KjU(), companion.m4174getTransparent0d7_KjU(), companion.m4174getTransparent0d7_KjU(), companion.m4174getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getCaretColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorFocusCaretColor()), (TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getOutlineColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getLeadingIconColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getTrailingIconColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getLabelColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPlaceholderColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getSupportingColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPrefixColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputSuffixColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, outlinedTextFieldTokens.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3_release(textFieldColors);
            defaultOutlinedTextFieldColorsCached = textFieldColors;
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultOutlinedTextFieldColorsCached;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2110getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2111getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2112getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:729)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2113getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }
}
