package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\\\n\u0002\u0018\u0002\n\u0002\b\u0017\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0014\u0010\u0019\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0013\u0010(\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b)\u0010\u000bR\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0014\u00100\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000bR\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0011\u0010^\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0013\u0010`\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\ba\u0010\u000bR\u0011\u0010b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0007R\u0011\u0010l\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0007R\u0013\u0010n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bo\u0010\u000bR\u0011\u0010p\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0007R\u0011\u0010r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0011\u0010z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0007R\u0011\u0010|\u001a\u00020w¢\u0006\b\n\u0000\u001a\u0004\b}\u0010yR\u0011\u0010~\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0007R\u0015\u0010\u0080\u0001\u001a\u00020\t¢\u0006\u000b\n\u0002\u0010\f\u001a\u0005\b\u0081\u0001\u0010\u000bR\u0013\u0010\u0082\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007R\u0015\u0010\u0084\u0001\u001a\u00020\t¢\u0006\u000b\n\u0002\u0010\f\u001a\u0005\b\u0085\u0001\u0010\u000bR\u0013\u0010\u0086\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0007R\u0013\u0010\u0088\u0001\u001a\u00020w¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010yR\u0013\u0010\u008a\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0007R\u0015\u0010\u008c\u0001\u001a\u00020\t¢\u0006\u000b\n\u0002\u0010\f\u001a\u0005\b\u008d\u0001\u0010\u000b¨\u0006\u008e\u0001"}, d2 = {"Landroidx/compose/material3/tokens/OutlinedAutocompleteTokens;", "", "<init>", "()V", "MenuContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getMenuContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "MenuContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getMenuContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "MenuContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getMenuContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "TextFieldCaretColor", "getTextFieldCaretColor", "TextFieldContainerColor", "getTextFieldContainerColor", "TextFieldContainerShape", "getTextFieldContainerShape", "FieldDisabledInputTextColor", "getFieldDisabledInputTextColor", "FieldDisabledInputTextOpacity", "", "getFieldDisabledInputTextOpacity", "FieldDisabledLabelTextColor", "getFieldDisabledLabelTextColor", "FieldDisabledLabelTextOpacity", "getFieldDisabledLabelTextOpacity", "TextFieldDisabledLeadingIconColor", "getTextFieldDisabledLeadingIconColor", "TextFieldDisabledLeadingIconOpacity", "getTextFieldDisabledLeadingIconOpacity", "TextFieldDisabledOutlineColor", "getTextFieldDisabledOutlineColor", "TextFieldDisabledOutlineOpacity", "getTextFieldDisabledOutlineOpacity", "TextFieldDisabledOutlineWidth", "getTextFieldDisabledOutlineWidth-D9Ej5fM", "FieldDisabledSupportingTextColor", "getFieldDisabledSupportingTextColor", "FieldDisabledSupportingTextOpacity", "getFieldDisabledSupportingTextOpacity", "TextFieldDisabledTrailingIconColor", "getTextFieldDisabledTrailingIconColor", "TextFieldDisabledTrailingIconOpacity", "getTextFieldDisabledTrailingIconOpacity", "TextFieldErrorFocusCaretColor", "getTextFieldErrorFocusCaretColor", "FieldErrorFocusInputTextColor", "getFieldErrorFocusInputTextColor", "FieldErrorFocusLabelTextColor", "getFieldErrorFocusLabelTextColor", "TextFieldErrorFocusLeadingIconColor", "getTextFieldErrorFocusLeadingIconColor", "TextFieldErrorFocusOutlineColor", "getTextFieldErrorFocusOutlineColor", "FieldErrorFocusSupportingTextColor", "getFieldErrorFocusSupportingTextColor", "TextFieldErrorFocusTrailingIconColor", "getTextFieldErrorFocusTrailingIconColor", "FieldErrorHoverInputTextColor", "getFieldErrorHoverInputTextColor", "FieldErrorHoverLabelTextColor", "getFieldErrorHoverLabelTextColor", "TextFieldErrorHoverLeadingIconColor", "getTextFieldErrorHoverLeadingIconColor", "TextFieldErrorHoverOutlineColor", "getTextFieldErrorHoverOutlineColor", "FieldErrorHoverSupportingTextColor", "getFieldErrorHoverSupportingTextColor", "TextFieldErrorHoverTrailingIconColor", "getTextFieldErrorHoverTrailingIconColor", "FieldErrorInputTextColor", "getFieldErrorInputTextColor", "FieldErrorLabelTextColor", "getFieldErrorLabelTextColor", "TextFieldErrorLeadingIconColor", "getTextFieldErrorLeadingIconColor", "TextFieldErrorOutlineColor", "getTextFieldErrorOutlineColor", "FieldErrorSupportingTextColor", "getFieldErrorSupportingTextColor", "TextFieldErrorTrailingIconColor", "getTextFieldErrorTrailingIconColor", "FieldFocusInputTextColor", "getFieldFocusInputTextColor", "FieldFocusLabelTextColor", "getFieldFocusLabelTextColor", "TextFieldFocusLeadingIconColor", "getTextFieldFocusLeadingIconColor", "TextFieldFocusOutlineColor", "getTextFieldFocusOutlineColor", "TextFieldFocusOutlineWidth", "getTextFieldFocusOutlineWidth-D9Ej5fM", "FieldFocusSupportingTextColor", "getFieldFocusSupportingTextColor", "TextFieldFocusTrailingIconColor", "getTextFieldFocusTrailingIconColor", "FieldHoverInputTextColor", "getFieldHoverInputTextColor", "FieldHoverLabelTextColor", "getFieldHoverLabelTextColor", "TextFieldHoverLeadingIconColor", "getTextFieldHoverLeadingIconColor", "TextFieldHoverOutlineColor", "getTextFieldHoverOutlineColor", "TextFieldHoverOutlineWidth", "getTextFieldHoverOutlineWidth-D9Ej5fM", "FieldHoverSupportingTextColor", "getFieldHoverSupportingTextColor", "TextFieldHoverTrailingIconColor", "getTextFieldHoverTrailingIconColor", "FieldInputTextColor", "getFieldInputTextColor", "FieldInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getFieldInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "FieldLabelTextColor", "getFieldLabelTextColor", "FieldLabelTextFont", "getFieldLabelTextFont", "TextFieldLeadingIconColor", "getTextFieldLeadingIconColor", "TextFieldLeadingIconSize", "getTextFieldLeadingIconSize-D9Ej5fM", "TextFieldOutlineColor", "getTextFieldOutlineColor", "TextFieldOutlineWidth", "getTextFieldOutlineWidth-D9Ej5fM", "FieldSupportingTextColor", "getFieldSupportingTextColor", "FieldSupportingTextFont", "getFieldSupportingTextFont", "TextFieldTrailingIconColor", "getTextFieldTrailingIconColor", "TextFieldTrailingIconSize", "getTextFieldTrailingIconSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OutlinedAutocompleteTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens FieldDisabledInputTextColor = null;
    private static final float FieldDisabledInputTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FieldDisabledLabelTextColor = null;
    private static final float FieldDisabledLabelTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FieldDisabledSupportingTextColor = null;
    private static final float FieldDisabledSupportingTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FieldErrorFocusInputTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorFocusSupportingTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorHoverInputTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorHoverSupportingTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorInputTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorLabelTextColor = null;
    private static final ColorSchemeKeyTokens FieldErrorSupportingTextColor = null;
    private static final ColorSchemeKeyTokens FieldFocusInputTextColor = null;
    private static final ColorSchemeKeyTokens FieldFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens FieldFocusSupportingTextColor = null;
    private static final ColorSchemeKeyTokens FieldHoverInputTextColor = null;
    private static final ColorSchemeKeyTokens FieldHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens FieldHoverSupportingTextColor = null;
    private static final ColorSchemeKeyTokens FieldInputTextColor = null;
    private static final TypographyKeyTokens FieldInputTextFont = null;
    private static final ColorSchemeKeyTokens FieldLabelTextColor = null;
    private static final TypographyKeyTokens FieldLabelTextFont = null;
    private static final ColorSchemeKeyTokens FieldSupportingTextColor = null;
    private static final TypographyKeyTokens FieldSupportingTextFont = null;
    public static final OutlinedAutocompleteTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens MenuContainerColor = null;
    private static final float MenuContainerElevation = 0.0f;
    private static final ShapeKeyTokens MenuContainerShape = null;
    private static final ColorSchemeKeyTokens TextFieldCaretColor = null;
    private static final ColorSchemeKeyTokens TextFieldContainerColor = null;
    private static final ShapeKeyTokens TextFieldContainerShape = null;
    private static final ColorSchemeKeyTokens TextFieldDisabledLeadingIconColor = null;
    private static final float TextFieldDisabledLeadingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldDisabledOutlineColor = null;
    private static final float TextFieldDisabledOutlineOpacity = 0.0f;
    private static final float TextFieldDisabledOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldDisabledTrailingIconColor = null;
    private static final float TextFieldDisabledTrailingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldErrorFocusCaretColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorFocusOutlineColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorHoverOutlineColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorLeadingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorOutlineColor = null;
    private static final ColorSchemeKeyTokens TextFieldErrorTrailingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldFocusOutlineColor = null;
    private static final float TextFieldFocusOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldHoverOutlineColor = null;
    private static final float TextFieldHoverOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens TextFieldLeadingIconColor = null;
    private static final float TextFieldLeadingIconSize = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldOutlineColor = null;
    private static final float TextFieldOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens TextFieldTrailingIconColor = null;
    private static final float TextFieldTrailingIconSize = 0.0f;

    private OutlinedAutocompleteTokens() {
    }

    static {
        INSTANCE = new OutlinedAutocompleteTokens();
        MenuContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        MenuContainerElevation = ElevationTokens.INSTANCE.m3500getLevel2D9Ej5fM();
        ShapeKeyTokens r100 = ShapeKeyTokens.CornerExtraSmall;
        MenuContainerShape = r100;
        ColorSchemeKeyTokens r101 = ColorSchemeKeyTokens.Primary;
        TextFieldCaretColor = r101;
        TextFieldContainerColor = ColorSchemeKeyTokens.SurfaceContainerHighest;
        TextFieldContainerShape = r100;
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.OnSurface;
        FieldDisabledInputTextColor = r102;
        FieldDisabledInputTextOpacity = 0.38f;
        FieldDisabledLabelTextColor = r102;
        FieldDisabledLabelTextOpacity = 0.38f;
        TextFieldDisabledLeadingIconColor = r102;
        TextFieldDisabledLeadingIconOpacity = 0.38f;
        TextFieldDisabledOutlineColor = r102;
        TextFieldDisabledOutlineOpacity = 0.12f;
        float r103 = (float) 1.0d;
        TextFieldDisabledOutlineWidth = Dp.m7544constructorimpl(r103);
        FieldDisabledSupportingTextColor = r102;
        FieldDisabledSupportingTextOpacity = 0.38f;
        TextFieldDisabledTrailingIconColor = r102;
        TextFieldDisabledTrailingIconOpacity = 0.38f;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.Error;
        TextFieldErrorFocusCaretColor = r104;
        FieldErrorFocusInputTextColor = r102;
        FieldErrorFocusLabelTextColor = r104;
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.OnSurfaceVariant;
        TextFieldErrorFocusLeadingIconColor = r105;
        TextFieldErrorFocusOutlineColor = r104;
        FieldErrorFocusSupportingTextColor = r104;
        TextFieldErrorFocusTrailingIconColor = r104;
        FieldErrorHoverInputTextColor = r102;
        ColorSchemeKeyTokens r106 = ColorSchemeKeyTokens.OnErrorContainer;
        FieldErrorHoverLabelTextColor = r106;
        TextFieldErrorHoverLeadingIconColor = r105;
        TextFieldErrorHoverOutlineColor = r106;
        FieldErrorHoverSupportingTextColor = r104;
        TextFieldErrorHoverTrailingIconColor = r106;
        FieldErrorInputTextColor = r102;
        FieldErrorLabelTextColor = r104;
        TextFieldErrorLeadingIconColor = r105;
        TextFieldErrorOutlineColor = r104;
        FieldErrorSupportingTextColor = r104;
        TextFieldErrorTrailingIconColor = r104;
        FieldFocusInputTextColor = r102;
        FieldFocusLabelTextColor = r101;
        TextFieldFocusLeadingIconColor = r105;
        TextFieldFocusOutlineColor = r101;
        TextFieldFocusOutlineWidth = Dp.m7544constructorimpl((float) 2.0d);
        FieldFocusSupportingTextColor = r105;
        TextFieldFocusTrailingIconColor = r105;
        FieldHoverInputTextColor = r102;
        FieldHoverLabelTextColor = r105;
        TextFieldHoverLeadingIconColor = r105;
        TextFieldHoverOutlineColor = r102;
        TextFieldHoverOutlineWidth = Dp.m7544constructorimpl(r103);
        FieldHoverSupportingTextColor = r105;
        TextFieldHoverTrailingIconColor = r105;
        FieldInputTextColor = r102;
        TypographyKeyTokens r107 = TypographyKeyTokens.BodyLarge;
        FieldInputTextFont = r107;
        FieldLabelTextColor = r105;
        FieldLabelTextFont = r107;
        TextFieldLeadingIconColor = r105;
        float r108 = (float) 24.0d;
        TextFieldLeadingIconSize = Dp.m7544constructorimpl(r108);
        TextFieldOutlineColor = ColorSchemeKeyTokens.Outline;
        TextFieldOutlineWidth = Dp.m7544constructorimpl(r103);
        FieldSupportingTextColor = r105;
        FieldSupportingTextFont = TypographyKeyTokens.BodySmall;
        TextFieldTrailingIconColor = r105;
        TextFieldTrailingIconSize = Dp.m7544constructorimpl(r108);
    }

    public final ColorSchemeKeyTokens getFieldDisabledInputTextColor() {
        return FieldDisabledInputTextColor;
    }

    public final float getFieldDisabledInputTextOpacity() {
        return FieldDisabledInputTextOpacity;
    }

    public final ColorSchemeKeyTokens getFieldDisabledLabelTextColor() {
        return FieldDisabledLabelTextColor;
    }

    public final float getFieldDisabledLabelTextOpacity() {
        return FieldDisabledLabelTextOpacity;
    }

    public final ColorSchemeKeyTokens getFieldDisabledSupportingTextColor() {
        return FieldDisabledSupportingTextColor;
    }

    public final float getFieldDisabledSupportingTextOpacity() {
        return FieldDisabledSupportingTextOpacity;
    }

    public final ColorSchemeKeyTokens getFieldErrorFocusInputTextColor() {
        return FieldErrorFocusInputTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorFocusLabelTextColor() {
        return FieldErrorFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorFocusSupportingTextColor() {
        return FieldErrorFocusSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorHoverInputTextColor() {
        return FieldErrorHoverInputTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorHoverLabelTextColor() {
        return FieldErrorHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorHoverSupportingTextColor() {
        return FieldErrorHoverSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorInputTextColor() {
        return FieldErrorInputTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorLabelTextColor() {
        return FieldErrorLabelTextColor;
    }

    public final ColorSchemeKeyTokens getFieldErrorSupportingTextColor() {
        return FieldErrorSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getFieldFocusInputTextColor() {
        return FieldFocusInputTextColor;
    }

    public final ColorSchemeKeyTokens getFieldFocusLabelTextColor() {
        return FieldFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getFieldFocusSupportingTextColor() {
        return FieldFocusSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getFieldHoverInputTextColor() {
        return FieldHoverInputTextColor;
    }

    public final ColorSchemeKeyTokens getFieldHoverLabelTextColor() {
        return FieldHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getFieldHoverSupportingTextColor() {
        return FieldHoverSupportingTextColor;
    }

    public final ColorSchemeKeyTokens getFieldInputTextColor() {
        return FieldInputTextColor;
    }

    public final TypographyKeyTokens getFieldInputTextFont() {
        return FieldInputTextFont;
    }

    public final ColorSchemeKeyTokens getFieldLabelTextColor() {
        return FieldLabelTextColor;
    }

    public final TypographyKeyTokens getFieldLabelTextFont() {
        return FieldLabelTextFont;
    }

    public final ColorSchemeKeyTokens getFieldSupportingTextColor() {
        return FieldSupportingTextColor;
    }

    public final TypographyKeyTokens getFieldSupportingTextFont() {
        return FieldSupportingTextFont;
    }

    public final ColorSchemeKeyTokens getMenuContainerColor() {
        return MenuContainerColor;
    }

    /* JADX INFO: renamed from: getMenuContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3718getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    public final ShapeKeyTokens getMenuContainerShape() {
        return MenuContainerShape;
    }

    public final ColorSchemeKeyTokens getTextFieldCaretColor() {
        return TextFieldCaretColor;
    }

    public final ColorSchemeKeyTokens getTextFieldContainerColor() {
        return TextFieldContainerColor;
    }

    public final ShapeKeyTokens getTextFieldContainerShape() {
        return TextFieldContainerShape;
    }

    public final ColorSchemeKeyTokens getTextFieldDisabledLeadingIconColor() {
        return TextFieldDisabledLeadingIconColor;
    }

    public final float getTextFieldDisabledLeadingIconOpacity() {
        return TextFieldDisabledLeadingIconOpacity;
    }

    public final ColorSchemeKeyTokens getTextFieldDisabledOutlineColor() {
        return TextFieldDisabledOutlineColor;
    }

    public final float getTextFieldDisabledOutlineOpacity() {
        return TextFieldDisabledOutlineOpacity;
    }

    /* JADX INFO: renamed from: getTextFieldDisabledOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3719getTextFieldDisabledOutlineWidthD9Ej5fM() {
        return TextFieldDisabledOutlineWidth;
    }

    public final ColorSchemeKeyTokens getTextFieldDisabledTrailingIconColor() {
        return TextFieldDisabledTrailingIconColor;
    }

    public final float getTextFieldDisabledTrailingIconOpacity() {
        return TextFieldDisabledTrailingIconOpacity;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorFocusCaretColor() {
        return TextFieldErrorFocusCaretColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorFocusLeadingIconColor() {
        return TextFieldErrorFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorFocusOutlineColor() {
        return TextFieldErrorFocusOutlineColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorFocusTrailingIconColor() {
        return TextFieldErrorFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorHoverLeadingIconColor() {
        return TextFieldErrorHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorHoverOutlineColor() {
        return TextFieldErrorHoverOutlineColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorHoverTrailingIconColor() {
        return TextFieldErrorHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorLeadingIconColor() {
        return TextFieldErrorLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorOutlineColor() {
        return TextFieldErrorOutlineColor;
    }

    public final ColorSchemeKeyTokens getTextFieldErrorTrailingIconColor() {
        return TextFieldErrorTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldFocusLeadingIconColor() {
        return TextFieldFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldFocusOutlineColor() {
        return TextFieldFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3720getTextFieldFocusOutlineWidthD9Ej5fM() {
        return TextFieldFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getTextFieldFocusTrailingIconColor() {
        return TextFieldFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldHoverLeadingIconColor() {
        return TextFieldHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldHoverOutlineColor() {
        return TextFieldHoverOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldHoverOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3721getTextFieldHoverOutlineWidthD9Ej5fM() {
        return TextFieldHoverOutlineWidth;
    }

    public final ColorSchemeKeyTokens getTextFieldHoverTrailingIconColor() {
        return TextFieldHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getTextFieldLeadingIconColor() {
        return TextFieldLeadingIconColor;
    }

    /* JADX INFO: renamed from: getTextFieldLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3722getTextFieldLeadingIconSizeD9Ej5fM() {
        return TextFieldLeadingIconSize;
    }

    public final ColorSchemeKeyTokens getTextFieldOutlineColor() {
        return TextFieldOutlineColor;
    }

    /* JADX INFO: renamed from: getTextFieldOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3723getTextFieldOutlineWidthD9Ej5fM() {
        return TextFieldOutlineWidth;
    }

    public final ColorSchemeKeyTokens getTextFieldTrailingIconColor() {
        return TextFieldTrailingIconColor;
    }

    /* JADX INFO: renamed from: getTextFieldTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3724getTextFieldTrailingIconSizeD9Ej5fM() {
        return TextFieldTrailingIconSize;
    }
}
