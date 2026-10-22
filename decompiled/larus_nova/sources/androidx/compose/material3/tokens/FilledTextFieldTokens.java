package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b^\n\u0002\u0018\u0002\n\u0002\b\u0019\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0014\u0010*\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000bR\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0014\u0010.\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0014\u00102\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0013\u0010\\\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b]\u0010\u000bR\u0011\u0010^\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0011\u0010`\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0013\u0010j\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bk\u0010\u000bR\u0011\u0010l\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0007R\u0011\u0010n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0007R\u0011\u0010p\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0007R\u0011\u0010r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0007R\u0011\u0010x\u001a\u00020y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u0010|\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0007R\u0011\u0010~\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0007R\u0013\u0010\u0080\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0007R\u0013\u0010\u0082\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007R\u0013\u0010\u0084\u0001\u001a\u00020y¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010{R\u0013\u0010\u0086\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0007R\u0015\u0010\u0088\u0001\u001a\u00020\t¢\u0006\u000b\n\u0002\u0010\f\u001a\u0005\b\u0089\u0001\u0010\u000bR\u0013\u0010\u008a\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0007R\u0013\u0010\u008c\u0001\u001a\u00020y¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010{R\u0013\u0010\u008e\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0007R\u0015\u0010\u0090\u0001\u001a\u00020\t¢\u0006\u000b\n\u0002\u0010\f\u001a\u0005\b\u0091\u0001\u0010\u000b¨\u0006\u0092\u0001"}, d2 = {"Landroidx/compose/material3/tokens/FilledTextFieldTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", FaceService.girlLabel, "CaretColor", "getCaretColor", "ContainerColor", "getContainerColor", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledActiveIndicatorColor", "getDisabledActiveIndicatorColor", "DisabledActiveIndicatorHeight", "getDisabledActiveIndicatorHeight-D9Ej5fM", "DisabledActiveIndicatorOpacity", "", "getDisabledActiveIndicatorOpacity", "DisabledContainerColor", "getDisabledContainerColor", "DisabledContainerOpacity", "getDisabledContainerOpacity", "DisabledInputColor", "getDisabledInputColor", "DisabledInputOpacity", "getDisabledInputOpacity", "DisabledLabelColor", "getDisabledLabelColor", "DisabledLabelOpacity", "getDisabledLabelOpacity", "DisabledLeadingIconColor", "getDisabledLeadingIconColor", "DisabledLeadingIconOpacity", "getDisabledLeadingIconOpacity", "DisabledSupportingColor", "getDisabledSupportingColor", "DisabledSupportingOpacity", "getDisabledSupportingOpacity", "DisabledTrailingIconColor", "getDisabledTrailingIconColor", "DisabledTrailingIconOpacity", "getDisabledTrailingIconOpacity", "ErrorActiveIndicatorColor", "getErrorActiveIndicatorColor", "ErrorFocusActiveIndicatorColor", "getErrorFocusActiveIndicatorColor", "ErrorFocusCaretColor", "getErrorFocusCaretColor", "ErrorFocusInputColor", "getErrorFocusInputColor", "ErrorFocusLabelColor", "getErrorFocusLabelColor", "ErrorFocusLeadingIconColor", "getErrorFocusLeadingIconColor", "ErrorFocusSupportingColor", "getErrorFocusSupportingColor", "ErrorFocusTrailingIconColor", "getErrorFocusTrailingIconColor", "ErrorHoverActiveIndicatorColor", "getErrorHoverActiveIndicatorColor", "ErrorHoverInputColor", "getErrorHoverInputColor", "ErrorHoverLabelColor", "getErrorHoverLabelColor", "ErrorHoverLeadingIconColor", "getErrorHoverLeadingIconColor", "ErrorHoverSupportingColor", "getErrorHoverSupportingColor", "ErrorHoverTrailingIconColor", "getErrorHoverTrailingIconColor", "ErrorInputColor", "getErrorInputColor", "ErrorLabelColor", "getErrorLabelColor", "ErrorLeadingIconColor", "getErrorLeadingIconColor", "ErrorSupportingColor", "getErrorSupportingColor", "ErrorTrailingIconColor", "getErrorTrailingIconColor", "FocusActiveIndicatorColor", "getFocusActiveIndicatorColor", "FocusActiveIndicatorHeight", "getFocusActiveIndicatorHeight-D9Ej5fM", "FocusInputColor", "getFocusInputColor", "FocusLabelColor", "getFocusLabelColor", "FocusLeadingIconColor", "getFocusLeadingIconColor", "FocusSupportingColor", "getFocusSupportingColor", "FocusTrailingIconColor", "getFocusTrailingIconColor", "HoverActiveIndicatorColor", "getHoverActiveIndicatorColor", "HoverActiveIndicatorHeight", "getHoverActiveIndicatorHeight-D9Ej5fM", "HoverInputColor", "getHoverInputColor", "HoverLabelColor", "getHoverLabelColor", "HoverLeadingIconColor", "getHoverLeadingIconColor", "HoverSupportingColor", "getHoverSupportingColor", "HoverTrailingIconColor", "getHoverTrailingIconColor", "InputColor", "getInputColor", "InputFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getInputFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "InputPlaceholderColor", "getInputPlaceholderColor", "InputPrefixColor", "getInputPrefixColor", "InputSuffixColor", "getInputSuffixColor", "LabelColor", "getLabelColor", "LabelFont", "getLabelFont", "LeadingIconColor", "getLeadingIconColor", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "SupportingColor", "getSupportingColor", "SupportingFont", "getSupportingFont", "TrailingIconColor", "getTrailingIconColor", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilledTextFieldTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor = null;
    private static final float ActiveIndicatorHeight = 0.0f;
    private static final ColorSchemeKeyTokens CaretColor = null;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens DisabledActiveIndicatorColor = null;
    private static final float DisabledActiveIndicatorHeight = 0.0f;
    private static final float DisabledActiveIndicatorOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledContainerColor = null;
    private static final float DisabledContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledInputColor = null;
    private static final float DisabledInputOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLabelColor = null;
    private static final float DisabledLabelOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLeadingIconColor = null;
    private static final float DisabledLeadingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledSupportingColor = null;
    private static final float DisabledSupportingOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledTrailingIconColor = null;
    private static final float DisabledTrailingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens ErrorActiveIndicatorColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusActiveIndicatorColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusCaretColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusInputColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusLabelColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusSupportingColor = null;
    private static final ColorSchemeKeyTokens ErrorFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverActiveIndicatorColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverInputColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverLabelColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverSupportingColor = null;
    private static final ColorSchemeKeyTokens ErrorHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ErrorInputColor = null;
    private static final ColorSchemeKeyTokens ErrorLabelColor = null;
    private static final ColorSchemeKeyTokens ErrorLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ErrorSupportingColor = null;
    private static final ColorSchemeKeyTokens ErrorTrailingIconColor = null;
    private static final ColorSchemeKeyTokens FocusActiveIndicatorColor = null;
    private static final float FocusActiveIndicatorHeight = 0.0f;
    private static final ColorSchemeKeyTokens FocusInputColor = null;
    private static final ColorSchemeKeyTokens FocusLabelColor = null;
    private static final ColorSchemeKeyTokens FocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens FocusSupportingColor = null;
    private static final ColorSchemeKeyTokens FocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens HoverActiveIndicatorColor = null;
    private static final float HoverActiveIndicatorHeight = 0.0f;
    private static final ColorSchemeKeyTokens HoverInputColor = null;
    private static final ColorSchemeKeyTokens HoverLabelColor = null;
    private static final ColorSchemeKeyTokens HoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens HoverSupportingColor = null;
    private static final ColorSchemeKeyTokens HoverTrailingIconColor = null;
    public static final FilledTextFieldTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens InputColor = null;
    private static final TypographyKeyTokens InputFont = null;
    private static final ColorSchemeKeyTokens InputPlaceholderColor = null;
    private static final ColorSchemeKeyTokens InputPrefixColor = null;
    private static final ColorSchemeKeyTokens InputSuffixColor = null;
    private static final ColorSchemeKeyTokens LabelColor = null;
    private static final TypographyKeyTokens LabelFont = null;
    private static final ColorSchemeKeyTokens LeadingIconColor = null;
    private static final float LeadingIconSize = 0.0f;
    private static final ColorSchemeKeyTokens SupportingColor = null;
    private static final TypographyKeyTokens SupportingFont = null;
    private static final ColorSchemeKeyTokens TrailingIconColor = null;
    private static final float TrailingIconSize = 0.0f;

    private FilledTextFieldTokens() {
    }

    static {
        INSTANCE = new FilledTextFieldTokens();
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurfaceVariant;
        ActiveIndicatorColor = r100;
        float r101 = (float) 1.0d;
        ActiveIndicatorHeight = Dp.m7544constructorimpl(r101);
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.Primary;
        CaretColor = r102;
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHighest;
        ContainerShape = ShapeKeyTokens.CornerExtraSmallTop;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurface;
        DisabledActiveIndicatorColor = r103;
        DisabledActiveIndicatorHeight = Dp.m7544constructorimpl(r101);
        DisabledActiveIndicatorOpacity = 0.38f;
        DisabledContainerColor = r103;
        DisabledContainerOpacity = 0.04f;
        DisabledInputColor = r103;
        DisabledInputOpacity = 0.38f;
        DisabledLabelColor = r103;
        DisabledLabelOpacity = 0.38f;
        DisabledLeadingIconColor = r103;
        DisabledLeadingIconOpacity = 0.38f;
        DisabledSupportingColor = r103;
        DisabledSupportingOpacity = 0.38f;
        DisabledTrailingIconColor = r103;
        DisabledTrailingIconOpacity = 0.38f;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.Error;
        ErrorActiveIndicatorColor = r104;
        ErrorFocusActiveIndicatorColor = r104;
        ErrorFocusCaretColor = r104;
        ErrorFocusInputColor = r103;
        ErrorFocusLabelColor = r104;
        ErrorFocusLeadingIconColor = r100;
        ErrorFocusSupportingColor = r104;
        ErrorFocusTrailingIconColor = r104;
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.OnErrorContainer;
        ErrorHoverActiveIndicatorColor = r105;
        ErrorHoverInputColor = r103;
        ErrorHoverLabelColor = r105;
        ErrorHoverLeadingIconColor = r100;
        ErrorHoverSupportingColor = r104;
        ErrorHoverTrailingIconColor = r105;
        ErrorInputColor = r103;
        ErrorLabelColor = r104;
        ErrorLeadingIconColor = r100;
        ErrorSupportingColor = r104;
        ErrorTrailingIconColor = r104;
        FocusActiveIndicatorColor = r102;
        FocusActiveIndicatorHeight = Dp.m7544constructorimpl((float) 2.0d);
        FocusInputColor = r103;
        FocusLabelColor = r102;
        FocusLeadingIconColor = r100;
        FocusSupportingColor = r100;
        FocusTrailingIconColor = r100;
        HoverActiveIndicatorColor = r103;
        HoverActiveIndicatorHeight = Dp.m7544constructorimpl(r101);
        HoverInputColor = r103;
        HoverLabelColor = r100;
        HoverLeadingIconColor = r100;
        HoverSupportingColor = r100;
        HoverTrailingIconColor = r100;
        InputColor = r103;
        TypographyKeyTokens r106 = TypographyKeyTokens.BodyLarge;
        InputFont = r106;
        InputPlaceholderColor = r100;
        InputPrefixColor = r100;
        InputSuffixColor = r100;
        LabelColor = r100;
        LabelFont = r106;
        LeadingIconColor = r100;
        float r107 = (float) 24.0d;
        LeadingIconSize = Dp.m7544constructorimpl(r107);
        SupportingColor = r100;
        SupportingFont = TypographyKeyTokens.BodySmall;
        TrailingIconColor = r100;
        TrailingIconSize = Dp.m7544constructorimpl(r107);
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3580getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    public final ColorSchemeKeyTokens getCaretColor() {
        return CaretColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledActiveIndicatorColor() {
        return DisabledActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3581getDisabledActiveIndicatorHeightD9Ej5fM() {
        return DisabledActiveIndicatorHeight;
    }

    public final float getDisabledActiveIndicatorOpacity() {
        return DisabledActiveIndicatorOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    public final float getDisabledContainerOpacity() {
        return DisabledContainerOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledInputColor() {
        return DisabledInputColor;
    }

    public final float getDisabledInputOpacity() {
        return DisabledInputOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLabelColor() {
        return DisabledLabelColor;
    }

    public final float getDisabledLabelOpacity() {
        return DisabledLabelOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLeadingIconColor() {
        return DisabledLeadingIconColor;
    }

    public final float getDisabledLeadingIconOpacity() {
        return DisabledLeadingIconOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledSupportingColor() {
        return DisabledSupportingColor;
    }

    public final float getDisabledSupportingOpacity() {
        return DisabledSupportingOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledTrailingIconColor() {
        return DisabledTrailingIconColor;
    }

    public final float getDisabledTrailingIconOpacity() {
        return DisabledTrailingIconOpacity;
    }

    public final ColorSchemeKeyTokens getErrorActiveIndicatorColor() {
        return ErrorActiveIndicatorColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusActiveIndicatorColor() {
        return ErrorFocusActiveIndicatorColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusCaretColor() {
        return ErrorFocusCaretColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusInputColor() {
        return ErrorFocusInputColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusLabelColor() {
        return ErrorFocusLabelColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusLeadingIconColor() {
        return ErrorFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusSupportingColor() {
        return ErrorFocusSupportingColor;
    }

    public final ColorSchemeKeyTokens getErrorFocusTrailingIconColor() {
        return ErrorFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverActiveIndicatorColor() {
        return ErrorHoverActiveIndicatorColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverInputColor() {
        return ErrorHoverInputColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverLabelColor() {
        return ErrorHoverLabelColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverLeadingIconColor() {
        return ErrorHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverSupportingColor() {
        return ErrorHoverSupportingColor;
    }

    public final ColorSchemeKeyTokens getErrorHoverTrailingIconColor() {
        return ErrorHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getErrorInputColor() {
        return ErrorInputColor;
    }

    public final ColorSchemeKeyTokens getErrorLabelColor() {
        return ErrorLabelColor;
    }

    public final ColorSchemeKeyTokens getErrorLeadingIconColor() {
        return ErrorLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getErrorSupportingColor() {
        return ErrorSupportingColor;
    }

    public final ColorSchemeKeyTokens getErrorTrailingIconColor() {
        return ErrorTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getFocusActiveIndicatorColor() {
        return FocusActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getFocusActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3582getFocusActiveIndicatorHeightD9Ej5fM() {
        return FocusActiveIndicatorHeight;
    }

    public final ColorSchemeKeyTokens getFocusInputColor() {
        return FocusInputColor;
    }

    public final ColorSchemeKeyTokens getFocusLabelColor() {
        return FocusLabelColor;
    }

    public final ColorSchemeKeyTokens getFocusLeadingIconColor() {
        return FocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getFocusSupportingColor() {
        return FocusSupportingColor;
    }

    public final ColorSchemeKeyTokens getFocusTrailingIconColor() {
        return FocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getHoverActiveIndicatorColor() {
        return HoverActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getHoverActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3583getHoverActiveIndicatorHeightD9Ej5fM() {
        return HoverActiveIndicatorHeight;
    }

    public final ColorSchemeKeyTokens getHoverInputColor() {
        return HoverInputColor;
    }

    public final ColorSchemeKeyTokens getHoverLabelColor() {
        return HoverLabelColor;
    }

    public final ColorSchemeKeyTokens getHoverLeadingIconColor() {
        return HoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getHoverSupportingColor() {
        return HoverSupportingColor;
    }

    public final ColorSchemeKeyTokens getHoverTrailingIconColor() {
        return HoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getInputColor() {
        return InputColor;
    }

    public final TypographyKeyTokens getInputFont() {
        return InputFont;
    }

    public final ColorSchemeKeyTokens getInputPlaceholderColor() {
        return InputPlaceholderColor;
    }

    public final ColorSchemeKeyTokens getInputPrefixColor() {
        return InputPrefixColor;
    }

    public final ColorSchemeKeyTokens getInputSuffixColor() {
        return InputSuffixColor;
    }

    public final ColorSchemeKeyTokens getLabelColor() {
        return LabelColor;
    }

    public final TypographyKeyTokens getLabelFont() {
        return LabelFont;
    }

    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return LeadingIconColor;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3584getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    public final ColorSchemeKeyTokens getSupportingColor() {
        return SupportingColor;
    }

    public final TypographyKeyTokens getSupportingFont() {
        return SupportingFont;
    }

    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return TrailingIconColor;
    }

    /* JADX INFO: renamed from: getTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3585getTrailingIconSizeD9Ej5fM() {
        return TrailingIconSize;
    }
}
