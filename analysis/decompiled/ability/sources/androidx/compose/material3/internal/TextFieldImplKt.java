package androidx.compose.material3.internal;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a¢\u0002\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u00062\u0006\u0010\t\u001a\u00020\b2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a5\u0010%\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a-\u0010%\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010*\u001a\u00020(*\u00020(2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0002H\u0000¢\u0006\u0004\b*\u0010+\u001a#\u00100\u001a\u00020(*\u00020(2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0000¢\u0006\u0004\b0\u00101\u001a\u0019\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102H\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102H\u0000¢\u0006\u0004\b7\u00106\u001a\u008a\u0001\u0010C\u001a\u00020\u00052\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u00112M\u0010\"\u001aI\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0?\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0?\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?\u0012\u0004\u0012\u00020\u00050>¢\u0006\u0002\b\u0006H\u0083\bø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aH\u0010K\u001a\b\u0012\u0004\u0012\u00020H0?2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020EH\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\"\u0014\u0010L\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bL\u0010M\"\u0014\u0010N\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bN\u0010M\"\u0014\u0010O\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bO\u0010M\"\u0014\u0010P\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bP\u0010M\"\u0014\u0010Q\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bQ\u0010M\"\u0014\u0010R\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bR\u0010M\"\u0014\u0010S\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bS\u0010M\"\u0014\u0010T\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bT\u0010M\"\u0014\u0010U\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bU\u0010M\"\u001a\u0010W\u001a\u00020V8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0014\u0010[\u001a\u0002048\u0000X\u0080T¢\u0006\u0006\n\u0004\b[\u0010\\\"\u0014\u0010]\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010\\\"\u0014\u0010^\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010\\\"\u001a\u0010_\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u001a\u0010c\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010`\u001a\u0004\bd\u0010b\"\u001a\u0010e\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010`\u001a\u0004\bf\u0010b\"\u001a\u0010g\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010`\u001a\u0004\bh\u0010b\"\u001a\u0010i\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010`\u001a\u0004\bj\u0010b\"\u001a\u0010k\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bk\u0010`\u001a\u0004\bl\u0010b\"\u001a\u0010m\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bm\u0010`\u001a\u0004\bn\u0010b\"\u001a\u0010o\u001a\u00020(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u001a\u0010w\u001a\u0004\u0018\u00010t*\u00020s8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bu\u0010v\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006z²\u0006\f\u0010x\u001a\u00020\u00118\nX\u008a\u0084\u0002²\u0006\f\u0010y\u001a\u00020\u00118\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/internal/TextFieldType;", "type", "", "value", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "innerTextField", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "", "singleLine", "enabled", "isError", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Landroidx/compose/material3/TextFieldColors;", "colors", "container", "CommonDecorationBox", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;LS7/n;Landroidx/compose/ui/text/input/VisualTransformation;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;LS7/n;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "content", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Decoration", "Decoration-Iv8Zu3U", "(JLS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "defaultErrorSemantics", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/ColorProducer;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Shape;", "shape", "textFieldBackground", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/Placeable;", "placeable", "", "widthOrZero", "(Landroidx/compose/ui/layout/Placeable;)I", "heightOrZero", "Landroidx/compose/material3/internal/InputPhase;", "inputState", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "showLabel", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLS7/s;Landroidx/compose/runtime/Composer;I)V", "TextFieldTransitionScope", "focused", "Landroidx/compose/ui/unit/Dp;", "focusedBorderThickness", "unfocusedBorderThickness", "Landroidx/compose/foundation/BorderStroke;", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateBorderStrokeAsState", "TextFieldId", "Ljava/lang/String;", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "Landroidx/compose/ui/unit/Constraints;", "ZeroConstraints", "J", "getZeroConstraints", "()J", "TextFieldAnimationDuration", "I", "PlaceholderAnimationDuration", "PlaceholderAnimationDelayOrDuration", "TextFieldPadding", "F", "getTextFieldPadding", "()F", "HorizontalIconPadding", "getHorizontalIconPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "layoutId", "showPlaceholder", "showPrefixSuffix", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final String ContainerId = "Container";
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final int TextFieldAnimationDuration = 150;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float HorizontalIconPadding = Dp.m6844constructorimpl(12);
    private static final float SupportingTopPadding = Dp.m6844constructorimpl(4);
    private static final float PrefixSuffixTextPadding = Dp.m6844constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m6844constructorimpl(24);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        float f = 16;
        TextFieldPadding = Dp.m6844constructorimpl(f);
        MinFocusedLabelLineHeight = Dp.m6844constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m6844constructorimpl(f);
        float f7 = 48;
        IconDefaultSizeModifier = SizeKt.m729defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m6844constructorimpl(f7), Dp.m6844constructorimpl(f7));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06df  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0952  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0976  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0979  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0994  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0a2d  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0a7c  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0a92  */
    /* JADX WARN: Removed duplicated region for block: B:504:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014a  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CommonDecorationBox(final androidx.compose.material3.internal.TextFieldType r47, final java.lang.String r48, final S7.n r49, final androidx.compose.ui.text.input.VisualTransformation r50, final S7.n r51, S7.n r52, S7.n r53, S7.n r54, S7.n r55, S7.n r56, S7.n r57, boolean r58, boolean r59, boolean r60, final androidx.compose.foundation.interaction.InteractionSource r61, final androidx.compose.foundation.layout.PaddingValues r62, final androidx.compose.material3.TextFieldColors r63, final S7.n r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 2744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.internal.TextFieldType, java.lang.String, S7.n, androidx.compose.ui.text.input.VisualTransformation, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, S7.n, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, S7.n, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m2754Decoration3JVO9M(long j5, TextStyle textStyle, n nVar, Composer composer, final int i) {
        int i6;
        final long j6;
        final TextStyle textStyle2;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1208685580);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(j5) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar2 = nVar;
            textStyle2 = textStyle;
            j6 = j5;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208685580, i6, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
            }
            ProvideContentColorTextStyleKt.m2680ProvideContentColorTextStyle3JVO9M(j5, textStyle, nVar, composerStartRestartGroup, i6 & 1022);
            j6 = j5;
            textStyle2 = textStyle;
            nVar2 = nVar;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TextFieldImplKt.m2754Decoration3JVO9M(j6, textStyle2, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m2755DecorationIv8Zu3U(final long j5, final n nVar, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(660142980);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(j5) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(660142980, i6, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4129boximpl(j5)), nVar, composerStartRestartGroup, (i6 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TextFieldImplKt.m2755DecorationIv8Zu3U(j5, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0122  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    /* renamed from: TextFieldTransitionScope-Jy8F4Js, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2756TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase r21, long r22, long r24, long r26, boolean r28, S7.s r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            Method dump skipped, instructions count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.m2756TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase, long, long, long, boolean, S7.s, androidx.compose.runtime.Composer, int):void");
    }

    @Composable
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m2759animateBorderStrokeAsStateNuRrP5Q(boolean z10, boolean z11, boolean z12, TextFieldColors textFieldColors, float f, float f7, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        State<Dp> stateRememberUpdatedState2;
        Composer composer2 = composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        long jM2426indicatorColorXeAY9LY$material3_release = textFieldColors.m2426indicatorColorXeAY9LY$material3_release(z10, z11, z12);
        if (z10) {
            composer2.startReplaceGroup(1023053998);
            stateRememberUpdatedState = SingleValueAnimationKt.m113animateColorAsStateeuL9pac(jM2426indicatorColorXeAY9LY$material3_release, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer, 48, 12);
            composer2 = composer;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(1023165505);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(jM2426indicatorColorXeAY9LY$material3_release), composer2, 0);
            composer2.endReplaceGroup();
        }
        State<Color> state = stateRememberUpdatedState;
        if (z10) {
            composer2.startReplaceGroup(1023269417);
            stateRememberUpdatedState2 = AnimateAsStateKt.m127animateDpAsStateAjpBEmI(z12 ? f : f7, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer2, 48, 12);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(1023478388);
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Dp.m6842boximpl(f7), composer2, (i >> 15) & 14);
            composer2.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m268BorderStrokecXLIe8U(stateRememberUpdatedState2.getValue().m6858unboximpl(), state.getValue().m4149unboximpl()), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState3;
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z10, final String str) {
        return z10 ? SemanticsModifierKt.semantics$default(modifier, false, new k() { // from class: androidx.compose.material3.internal.TextFieldImplKt.defaultErrorSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new k() { // from class: androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                final Outline outlineMo289createOutlinePq9zytI = shape.mo289createOutlinePq9zytI(cacheDrawScope.m3676getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                final ColorProducer colorProducer2 = colorProducer;
                return cacheDrawScope.onDrawBehind(new k() { // from class: androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return r.f317a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        OutlineKt.m4409drawOutlinewDX37Ww$default(drawScope, outlineMo289createOutlinePq9zytI, colorProducer2.mo1813invoke0d7_KjU(), 0.0f, null, null, 0, 60, null);
                    }
                });
            }
        });
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
