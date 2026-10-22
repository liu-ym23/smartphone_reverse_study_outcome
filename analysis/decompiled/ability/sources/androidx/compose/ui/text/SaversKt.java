package androidx.compose.ui.text;

import H4.o;
import S7.k;
import S7.n;
import android.view.p;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\t\u001a\u00020\b\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001aN\u0010\f\u001a\u0004\u0018\u00018\u0003\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0006\b\u0003\u0010\u000b\u0018\u00012\b\u0010\u0004\u001a\u0004\u0018\u00018\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\b2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000e2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0013\u001a$\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u000b\u0018\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0080\b¢\u0006\u0004\b\f\u0010\u0013\"&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\".\u0010\u001b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001a0\u0019\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016\".\u0010\u001c\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001a\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u0012\u0004\b\u001d\u0010\u001e\" \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016\"&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\"\u0010\u0016\u0012\u0004\b#\u0010\u001e\" \u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0016\" \u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0016\"&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018\"&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\"&\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018\" \u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0016\" \u00104\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0016\" \u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0016\" \u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0016\" \u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0016\" \u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0016\" \u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0016\" \u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A\" \u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010A\" \u0010E\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010A\" \u0010G\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0016\" \u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0016\" \u0010K\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0016\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b0\u0000*\u00020L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b0\u0000*\u00020P8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010Q\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\b0\u0000*\u00020R8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010S\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b0\u0000*\u00020T8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010U\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\b0\u0000*\u00020V8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010W\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b0\u0000*\u00020X8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010Y\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b0\u0000*\u00020Z8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010[\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\b0\u0000*\u00020\\8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010]\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\b0\u0000*\u00020^8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010_\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\b0\u0000*\u00020`8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010a\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\b0\u0000*\u00020b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010c\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\b0\u0000*\u00020d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010e\"$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\b0\u0000*\u00020f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010g¨\u0006h"}, d2 = {"Landroidx/compose/runtime/saveable/Saver;", ExifInterface.GPS_DIRECTION_TRUE, "Original", "Saveable", "value", "saver", "Landroidx/compose/runtime/saveable/SaverScope;", "scope", "", "save", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "Result", "restore", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "NonNullValueClassSaver", "(LS7/n;LS7/k;)Landroidx/compose/ui/text/NonNullValueClassSaver;", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeListSaver", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "UrlAnnotationSaver", "getUrlAnnotationSaver$annotations", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ClickableSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "ParagraphStyleSaver", "getParagraphStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "SpanStyleSaver", "getSpanStyleSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "TextLinkStylesSaver", "getTextLinkStylesSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "ColorSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/unit/TextUnit;", "TextUnitSaver", "Landroidx/compose/ui/geometry/Offset;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "LocaleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle;", "LineHeightStyleSaver", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Saver", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new H7.b(3), new p(8));
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new H7.b(10), new p(20));
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new H7.b(18), new p(23));
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new H7.b(20), new p(24));
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new H7.b(21), new p(25));
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new H7.b(8), new p(17));
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new H7.b(19), new p(26));
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new H7.b(22), new p(27));
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new H7.b(23), new p(28));
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(new H7.b(24), new p(7));
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new H7.b(4), new p(9));
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new H7.b(5), new p(10));
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new H7.b(6), new p(11));
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new H7.b(7), new p(12));
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new H7.b(9), new p(13));
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new H7.b(11), new p(14));
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new H7.b(12), new p(15));
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(new n() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m6240invoke4WTKRHQ((SaverScope) obj, ((Color) obj2).m4149unboximpl());
        }

        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m6240invoke4WTKRHQ(SaverScope saverScope, long j5) {
            return j5 == 16 ? Boolean.FALSE : Integer.valueOf(ColorKt.m4193toArgb8_81llA(j5));
        }
    }, new k() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // S7.k
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            if (kotlin.jvm.internal.k.b(obj, Boolean.FALSE)) {
                return Color.m4129boximpl(Color.INSTANCE.m4175getUnspecified0d7_KjU());
            }
            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
            return Color.m4129boximpl(ColorKt.Color(((Integer) obj).intValue()));
        }
    });
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(new H7.b(13), new p(16));
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(new H7.b(14), new p(18));
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new H7.b(15), new p(19));
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new H7.b(16), new p(21));
    private static final Saver<LineHeightStyle, Object> LineHeightStyleSaver = SaverKt.Saver(new H7.b(17), new p(22));

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.Link.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.Clickable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotatedStringSaver$lambda$5(SaverScope saverScope, AnnotatedString annotatedString) {
        return o.k(save(annotatedString.getText()), save(annotatedString.getAnnotations$ui_text(), AnnotationRangeListSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString AnnotatedStringSaver$lambda$6(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(1);
        Saver<List<AnnotatedString.Range<? extends Object>>, Object> saver = AnnotationRangeListSaver;
        List<AnnotatedString.Range<? extends Object>> listRestore = ((!kotlin.jvm.internal.k.b(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(0);
        String str = obj3 != null ? (String) obj3 : null;
        kotlin.jvm.internal.k.c(str);
        return new AnnotatedString(listRestore, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List AnnotationRangeListSaver$lambda$10(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            Saver<AnnotatedString.Range<? extends Object>, Object> saver = AnnotationRangeSaver;
            AnnotatedString.Range<? extends Object> rangeRestore = null;
            if ((!kotlin.jvm.internal.k.b(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                rangeRestore = saver.restore(obj2);
            }
            kotlin.jvm.internal.k.c(rangeRestore);
            arrayList.add(rangeRestore);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeListSaver$lambda$8(SaverScope saverScope, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save((AnnotatedString.Range) list.get(i), AnnotationRangeSaver, saverScope));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeSaver$lambda$11(SaverScope saverScope, AnnotatedString.Range range) {
        AnnotationType annotationType;
        Object objSave;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else if (item instanceof UrlAnnotation) {
            annotationType = AnnotationType.Url;
        } else if (item instanceof LinkAnnotation.Url) {
            annotationType = AnnotationType.Link;
        } else if (item instanceof LinkAnnotation.Clickable) {
            annotationType = AnnotationType.Clickable;
        } else {
            if (!(item instanceof StringAnnotation)) {
                throw new UnsupportedOperationException();
            }
            annotationType = AnnotationType.String;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object item2 = range.getItem();
                kotlin.jvm.internal.k.d(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                objSave = save((ParagraphStyle) item2, ParagraphStyleSaver, saverScope);
                break;
            case 2:
                Object item3 = range.getItem();
                kotlin.jvm.internal.k.d(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                objSave = save((SpanStyle) item3, SpanStyleSaver, saverScope);
                break;
            case 3:
                Object item4 = range.getItem();
                kotlin.jvm.internal.k.d(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                objSave = save((VerbatimTtsAnnotation) item4, VerbatimTtsAnnotationSaver, saverScope);
                break;
            case 4:
                Object item5 = range.getItem();
                kotlin.jvm.internal.k.d(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                objSave = save((UrlAnnotation) item5, UrlAnnotationSaver, saverScope);
                break;
            case 5:
                Object item6 = range.getItem();
                kotlin.jvm.internal.k.d(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                objSave = save((LinkAnnotation.Url) item6, LinkSaver, saverScope);
                break;
            case 6:
                Object item7 = range.getItem();
                kotlin.jvm.internal.k.d(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                objSave = save((LinkAnnotation.Clickable) item7, ClickableSaver, saverScope);
                break;
            case 7:
                Object item8 = range.getItem();
                kotlin.jvm.internal.k.d(item8, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                objSave = save(((StringAnnotation) item8).m6265unboximpl());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return o.k(save(annotationType), objSave, save(Integer.valueOf(range.getStart())), save(Integer.valueOf(range.getEnd())), save(range.getTag()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString.Range AnnotationRangeSaver$lambda$12(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        ParagraphStyle paragraphStyleRestore = null;
        clickableRestore = null;
        LinkAnnotation.Clickable clickableRestore = null;
        urlRestore = null;
        LinkAnnotation.Url urlRestore = null;
        urlAnnotationRestore = null;
        UrlAnnotation urlAnnotationRestore = null;
        verbatimTtsAnnotationRestore = null;
        VerbatimTtsAnnotation verbatimTtsAnnotationRestore = null;
        spanStyleRestore = null;
        SpanStyle spanStyleRestore = null;
        paragraphStyleRestore = null;
        AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
        kotlin.jvm.internal.k.c(annotationType);
        Object obj3 = list.get(2);
        Integer num = obj3 != null ? (Integer) obj3 : null;
        kotlin.jvm.internal.k.c(num);
        int iIntValue = num.intValue();
        Object obj4 = list.get(3);
        Integer num2 = obj4 != null ? (Integer) obj4 : null;
        kotlin.jvm.internal.k.c(num2);
        int iIntValue2 = num2.intValue();
        Object obj5 = list.get(4);
        String str = obj5 != null ? (String) obj5 : null;
        kotlin.jvm.internal.k.c(str);
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object obj6 = list.get(1);
                Saver<ParagraphStyle, Object> saver = ParagraphStyleSaver;
                if ((!kotlin.jvm.internal.k.b(obj6, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj6 != null) {
                    paragraphStyleRestore = saver.restore(obj6);
                }
                kotlin.jvm.internal.k.c(paragraphStyleRestore);
                return new AnnotatedString.Range(paragraphStyleRestore, iIntValue, iIntValue2, str);
            case 2:
                Object obj7 = list.get(1);
                Saver<SpanStyle, Object> saver2 = SpanStyleSaver;
                if ((!kotlin.jvm.internal.k.b(obj7, Boolean.FALSE) || (saver2 instanceof NonNullValueClassSaver)) && obj7 != null) {
                    spanStyleRestore = saver2.restore(obj7);
                }
                kotlin.jvm.internal.k.c(spanStyleRestore);
                return new AnnotatedString.Range(spanStyleRestore, iIntValue, iIntValue2, str);
            case 3:
                Object obj8 = list.get(1);
                Saver<VerbatimTtsAnnotation, Object> saver3 = VerbatimTtsAnnotationSaver;
                if ((!kotlin.jvm.internal.k.b(obj8, Boolean.FALSE) || (saver3 instanceof NonNullValueClassSaver)) && obj8 != null) {
                    verbatimTtsAnnotationRestore = saver3.restore(obj8);
                }
                kotlin.jvm.internal.k.c(verbatimTtsAnnotationRestore);
                return new AnnotatedString.Range(verbatimTtsAnnotationRestore, iIntValue, iIntValue2, str);
            case 4:
                Object obj9 = list.get(1);
                Saver<UrlAnnotation, Object> saver4 = UrlAnnotationSaver;
                if ((!kotlin.jvm.internal.k.b(obj9, Boolean.FALSE) || (saver4 instanceof NonNullValueClassSaver)) && obj9 != null) {
                    urlAnnotationRestore = saver4.restore(obj9);
                }
                kotlin.jvm.internal.k.c(urlAnnotationRestore);
                return new AnnotatedString.Range(urlAnnotationRestore, iIntValue, iIntValue2, str);
            case 5:
                Object obj10 = list.get(1);
                Saver<LinkAnnotation.Url, Object> saver5 = LinkSaver;
                if ((!kotlin.jvm.internal.k.b(obj10, Boolean.FALSE) || (saver5 instanceof NonNullValueClassSaver)) && obj10 != null) {
                    urlRestore = saver5.restore(obj10);
                }
                kotlin.jvm.internal.k.c(urlRestore);
                return new AnnotatedString.Range(urlRestore, iIntValue, iIntValue2, str);
            case 6:
                Object obj11 = list.get(1);
                Saver<LinkAnnotation.Clickable, Object> saver6 = ClickableSaver;
                if ((!kotlin.jvm.internal.k.b(obj11, Boolean.FALSE) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) {
                    clickableRestore = saver6.restore(obj11);
                }
                kotlin.jvm.internal.k.c(clickableRestore);
                return new AnnotatedString.Range(clickableRestore, iIntValue, iIntValue2, str);
            case 7:
                Object obj12 = list.get(1);
                String str2 = obj12 != null ? (String) obj12 : null;
                kotlin.jvm.internal.k.c(str2);
                return new AnnotatedString.Range(StringAnnotation.m6259boximpl(StringAnnotation.m6260constructorimpl(str2)), iIntValue, iIntValue2, str);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BaselineShiftSaver$lambda$35(SaverScope saverScope, BaselineShift baselineShift) {
        return Float.valueOf(baselineShift.m6606unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaselineShift BaselineShiftSaver$lambda$36(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Float");
        return BaselineShift.m6600boximpl(BaselineShift.m6601constructorimpl(((Float) obj).floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ClickableSaver$lambda$19(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
        return o.k(save(clickable.getTag()), save(clickable.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Clickable ClickableSaver$lambda$20(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        String str = obj2 != null ? (String) obj2 : null;
        kotlin.jvm.internal.k.c(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        return new LinkAnnotation.Clickable(str, ((!kotlin.jvm.internal.k.b(obj3, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontWeightSaver$lambda$33(SaverScope saverScope, FontWeight fontWeight) {
        return Integer.valueOf(fontWeight.getWeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontWeight FontWeightSaver$lambda$34(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        return new FontWeight(((Integer) obj).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleSaver$lambda$51(SaverScope saverScope, LineHeightStyle lineHeightStyle) {
        return o.k(save(LineHeightStyle.Alignment.m6688boximpl(lineHeightStyle.getAlignment())), save(LineHeightStyle.Trim.m6708boximpl(lineHeightStyle.getTrim())), save(LineHeightStyle.Mode.m6699boximpl(lineHeightStyle.getMode())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle LineHeightStyleSaver$lambda$52(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        e eVar = null;
        LineHeightStyle.Alignment alignment = obj2 != null ? (LineHeightStyle.Alignment) obj2 : null;
        kotlin.jvm.internal.k.c(alignment);
        float topRatio = alignment.getTopRatio();
        Object obj3 = list.get(1);
        LineHeightStyle.Trim trim = obj3 != null ? (LineHeightStyle.Trim) obj3 : null;
        kotlin.jvm.internal.k.c(trim);
        int value = trim.getValue();
        Object obj4 = list.get(2);
        LineHeightStyle.Mode mode = obj4 != null ? (LineHeightStyle.Mode) obj4 : null;
        kotlin.jvm.internal.k.c(mode);
        return new LineHeightStyle(topRatio, value, mode.getValue(), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LinkSaver$lambda$17(SaverScope saverScope, LinkAnnotation.Url url) {
        return o.k(save(url.getUrl()), save(url.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Url LinkSaver$lambda$18(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextLinkStyles textLinkStylesRestore = null;
        String str = obj2 != null ? (String) obj2 : null;
        kotlin.jvm.internal.k.c(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        if ((!kotlin.jvm.internal.k.b(obj3, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textLinkStylesRestore = saver.restore(obj3);
        }
        return new LinkAnnotation.Url(str, textLinkStylesRestore, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleListSaver$lambda$46(SaverScope saverScope, LocaleList localeList) {
        List<Locale> localeList2 = localeList.getLocaleList();
        ArrayList arrayList = new ArrayList(localeList2.size());
        int size = localeList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save(localeList2.get(i), getSaver(Locale.INSTANCE), saverScope));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocaleList LocaleListSaver$lambda$48(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            Saver<Locale, Object> saver = getSaver(Locale.INSTANCE);
            Locale localeRestore = null;
            if ((!kotlin.jvm.internal.k.b(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                localeRestore = saver.restore(obj2);
            }
            kotlin.jvm.internal.k.c(localeRestore);
            arrayList.add(localeRestore);
        }
        return new LocaleList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleSaver$lambda$49(SaverScope saverScope, Locale locale) {
        return locale.toLanguageTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale LocaleSaver$lambda$50(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.String");
        return new Locale((String) obj);
    }

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(final n nVar, final k kVar) {
        return new NonNullValueClassSaver<Original, Saveable>() { // from class: androidx.compose.ui.text.SaversKt.NonNullValueClassSaver.1
            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable value) {
                return (Original) kVar.invoke(value);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                return (Saveable) nVar.invoke(saverScope, original);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object OffsetSaver$lambda$43(SaverScope saverScope, Offset offset) {
        return offset == null ? false : Offset.m3892equalsimpl0(offset.m3905unboximpl(), Offset.INSTANCE.m3910getUnspecifiedF1C5BW0()) ? Boolean.FALSE : o.k(save(Float.valueOf(Float.intBitsToFloat((int) (offset.m3905unboximpl() >> 32)))), save(Float.valueOf(Float.intBitsToFloat((int) (offset.m3905unboximpl() & 4294967295L)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset OffsetSaver$lambda$44(Object obj) {
        if (kotlin.jvm.internal.k.b(obj, Boolean.FALSE)) {
            return Offset.m3884boximpl(Offset.INSTANCE.m3910getUnspecifiedF1C5BW0());
        }
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        kotlin.jvm.internal.k.c(f);
        float fFloatValue = f.floatValue();
        Object obj3 = list.get(1);
        kotlin.jvm.internal.k.c(obj3 != null ? (Float) obj3 : null);
        return Offset.m3884boximpl(Offset.m3887constructorimpl((Float.floatToRawIntBits(fFloatValue) << 32) | (Float.floatToRawIntBits(r1.floatValue()) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ParagraphStyleSaver$lambda$21(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        return o.k(save(TextAlign.m6721boximpl(paragraphStyle.getTextAlign())), save(TextDirection.m6735boximpl(paragraphStyle.getTextDirection())), save(TextUnit.m7028boximpl(paragraphStyle.getLineHeight()), getSaver(TextUnit.INSTANCE), saverScope), save(paragraphStyle.getTextIndent(), getSaver(TextIndent.INSTANCE), saverScope), save(paragraphStyle.getPlatformStyle(), Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE), saverScope), save(paragraphStyle.getLineHeightStyle(), getSaver(LineHeightStyle.INSTANCE), saverScope), save(LineBreak.m6629boximpl(paragraphStyle.getLineBreak()), Savers_androidKt.getSaver(LineBreak.INSTANCE), saverScope), save(Hyphens.m6619boximpl(paragraphStyle.getHyphens())), save(paragraphStyle.getTextMotion(), Savers_androidKt.getSaver(TextMotion.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParagraphStyle ParagraphStyleSaver$lambda$22(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextMotion textMotionRestore = null;
        TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
        kotlin.jvm.internal.k.c(textAlign);
        int value = textAlign.getValue();
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
        kotlin.jvm.internal.k.c(textDirection);
        int value2 = textDirection.getValue();
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver = getSaver(TextUnit.INSTANCE);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = ((!kotlin.jvm.internal.k.b(obj4, bool) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        kotlin.jvm.internal.k.c(textUnitRestore);
        long packedValue = textUnitRestore.getPackedValue();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver2 = getSaver(TextIndent.INSTANCE);
        TextIndent textIndentRestore = ((!kotlin.jvm.internal.k.b(obj5, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj5 != null) ? saver2.restore(obj5) : null;
        Object obj6 = list.get(4);
        Saver<PlatformParagraphStyle, Object> saver3 = Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE);
        PlatformParagraphStyle platformParagraphStyleRestore = ((!kotlin.jvm.internal.k.b(obj6, bool) || (saver3 instanceof NonNullValueClassSaver)) && obj6 != null) ? saver3.restore(obj6) : null;
        Object obj7 = list.get(5);
        Saver<LineHeightStyle, Object> saver4 = getSaver(LineHeightStyle.INSTANCE);
        LineHeightStyle lineHeightStyleRestore = ((!kotlin.jvm.internal.k.b(obj7, bool) || (saver4 instanceof NonNullValueClassSaver)) && obj7 != null) ? saver4.restore(obj7) : null;
        Object obj8 = list.get(6);
        Saver<LineBreak, Object> saver5 = Savers_androidKt.getSaver(LineBreak.INSTANCE);
        LineBreak lineBreakRestore = ((!kotlin.jvm.internal.k.b(obj8, bool) || (saver5 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver5.restore(obj8) : null;
        kotlin.jvm.internal.k.c(lineBreakRestore);
        int mask = lineBreakRestore.getMask();
        Object obj9 = list.get(7);
        Hyphens hyphens = obj9 != null ? (Hyphens) obj9 : null;
        kotlin.jvm.internal.k.c(hyphens);
        int value3 = hyphens.getValue();
        Object obj10 = list.get(8);
        Saver<TextMotion, Object> saver6 = Savers_androidKt.getSaver(TextMotion.INSTANCE);
        if ((!kotlin.jvm.internal.k.b(obj10, bool) || (saver6 instanceof NonNullValueClassSaver)) && obj10 != null) {
            textMotionRestore = saver6.restore(obj10);
        }
        return new ParagraphStyle(value, value2, packedValue, textIndentRestore, platformParagraphStyleRestore, lineHeightStyleRestore, mask, value3, textMotionRestore, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ShadowSaver$lambda$39(SaverScope saverScope, Shadow shadow) {
        return o.k(save(Color.m4129boximpl(shadow.getColor()), getSaver(Color.INSTANCE), saverScope), save(Offset.m3884boximpl(shadow.getOffset()), getSaver(Offset.INSTANCE), saverScope), save(Float.valueOf(shadow.getBlurRadius())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shadow ShadowSaver$lambda$40(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.INSTANCE);
        Boolean bool = Boolean.FALSE;
        Color colorRestore = ((!kotlin.jvm.internal.k.b(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        kotlin.jvm.internal.k.c(colorRestore);
        long jM4149unboximpl = colorRestore.m4149unboximpl();
        Object obj3 = list.get(1);
        Saver<Offset, Object> saver2 = getSaver(Offset.INSTANCE);
        Offset offsetRestore = ((!kotlin.jvm.internal.k.b(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        kotlin.jvm.internal.k.c(offsetRestore);
        long jM3905unboximpl = offsetRestore.m3905unboximpl();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        kotlin.jvm.internal.k.c(f);
        return new Shadow(jM4149unboximpl, jM3905unboximpl, f.floatValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SpanStyleSaver$lambda$23(SaverScope saverScope, SpanStyle spanStyle) {
        Color colorM4129boximpl = Color.m4129boximpl(spanStyle.m6252getColor0d7_KjU());
        Color.Companion companion = Color.INSTANCE;
        Object objSave = save(colorM4129boximpl, getSaver(companion), saverScope);
        TextUnit textUnitM7028boximpl = TextUnit.m7028boximpl(spanStyle.getFontSize());
        TextUnit.Companion companion2 = TextUnit.INSTANCE;
        return o.k(objSave, save(textUnitM7028boximpl, getSaver(companion2), saverScope), save(spanStyle.getFontWeight(), getSaver(FontWeight.INSTANCE), saverScope), save(spanStyle.getFontStyle()), save(spanStyle.getFontSynthesis()), save(-1), save(spanStyle.getFontFeatureSettings()), save(TextUnit.m7028boximpl(spanStyle.getLetterSpacing()), getSaver(companion2), saverScope), save(spanStyle.getBaselineShift(), getSaver(BaselineShift.INSTANCE), saverScope), save(spanStyle.getTextGeometricTransform(), getSaver(TextGeometricTransform.INSTANCE), saverScope), save(spanStyle.getLocaleList(), getSaver(LocaleList.INSTANCE), saverScope), save(Color.m4129boximpl(spanStyle.getBackground()), getSaver(companion), saverScope), save(spanStyle.getBackground(), getSaver(TextDecoration.INSTANCE), saverScope), save(spanStyle.getShadow(), getSaver(Shadow.INSTANCE), saverScope));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 androidx.compose.ui.text.SpanStyle, still in use, count: 2, list:
          (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d8: MOVE (r16v2 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
          (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d0: MOVE (r16v7 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.text.SpanStyle SpanStyleSaver$lambda$24(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt.SpanStyleSaver$lambda$24(java.lang.Object):androidx.compose.ui.text.SpanStyle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextDecorationSaver$lambda$27(SaverScope saverScope, TextDecoration textDecoration) {
        return Integer.valueOf(textDecoration.getMask());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextDecoration TextDecorationSaver$lambda$28(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
        return new TextDecoration(((Integer) obj).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextGeometricTransformSaver$lambda$29(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
        return o.k(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextGeometricTransform TextGeometricTransformSaver$lambda$30(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        List list = (List) obj;
        return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextIndentSaver$lambda$31(SaverScope saverScope, TextIndent textIndent) {
        TextUnit textUnitM7028boximpl = TextUnit.m7028boximpl(textIndent.getFirstLine());
        TextUnit.Companion companion = TextUnit.INSTANCE;
        return o.k(save(textUnitM7028boximpl, getSaver(companion), saverScope), save(TextUnit.m7028boximpl(textIndent.getRestLine()), getSaver(companion), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextIndent TextIndentSaver$lambda$32(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnit.Companion companion = TextUnit.INSTANCE;
        Saver<TextUnit, Object> saver = getSaver(companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = ((!kotlin.jvm.internal.k.b(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        kotlin.jvm.internal.k.c(textUnitRestore2);
        long packedValue = textUnitRestore2.getPackedValue();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(companion);
        if ((!kotlin.jvm.internal.k.b(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnitRestore = saver2.restore(obj3);
        }
        kotlin.jvm.internal.k.c(textUnitRestore);
        return new TextIndent(packedValue, textUnitRestore.getPackedValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextLinkStylesSaver$lambda$25(SaverScope saverScope, TextLinkStyles textLinkStyles) {
        SpanStyle style = textLinkStyles.getStyle();
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        return o.k(save(style, saver, saverScope), save(textLinkStyles.getFocusedStyle(), saver, saverScope), save(textLinkStyles.getHoveredStyle(), saver, saverScope), save(textLinkStyles.getPressedStyle(), saver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLinkStyles TextLinkStylesSaver$lambda$26(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        Boolean bool = Boolean.FALSE;
        SpanStyle spanStyleRestore = null;
        SpanStyle spanStyleRestore2 = ((!kotlin.jvm.internal.k.b(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(1);
        SpanStyle spanStyleRestore3 = ((!kotlin.jvm.internal.k.b(obj3, bool) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null;
        Object obj4 = list.get(2);
        SpanStyle spanStyleRestore4 = ((!kotlin.jvm.internal.k.b(obj4, bool) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        Object obj5 = list.get(3);
        if ((!kotlin.jvm.internal.k.b(obj5, bool) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) {
            spanStyleRestore = saver.restore(obj5);
        }
        return new TextLinkStyles(spanStyleRestore2, spanStyleRestore3, spanStyleRestore4, spanStyleRestore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object TextRangeSaver$lambda$37(SaverScope saverScope, TextRange textRange) {
        return o.k(save(Integer.valueOf(TextRange.m6311getStartimpl(textRange.getPackedValue()))), save(Integer.valueOf(TextRange.m6306getEndimpl(textRange.getPackedValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRange TextRangeSaver$lambda$38(Object obj) {
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        kotlin.jvm.internal.k.c(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        kotlin.jvm.internal.k.c(num2);
        return TextRange.m6299boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextUnitSaver$lambda$41(SaverScope saverScope, TextUnit textUnit) {
        return textUnit == null ? false : TextUnit.m7035equalsimpl0(textUnit.getPackedValue(), TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE()) ? Boolean.FALSE : o.k(save(Float.valueOf(TextUnit.m7038getValueimpl(textUnit.getPackedValue()))), save(TextUnitType.m7063boximpl(TextUnit.m7037getTypeUIouoOA(textUnit.getPackedValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextUnit TextUnitSaver$lambda$42(Object obj) {
        if (kotlin.jvm.internal.k.b(obj, Boolean.FALSE)) {
            return TextUnit.m7028boximpl(TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE());
        }
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        kotlin.jvm.internal.k.c(f);
        float fFloatValue = f.floatValue();
        Object obj3 = list.get(1);
        TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
        kotlin.jvm.internal.k.c(textUnitType);
        return TextUnit.m7028boximpl(TextUnitKt.m7050TextUnitanM5pPY(fFloatValue, textUnitType.getType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object UrlAnnotationSaver$lambda$15(SaverScope saverScope, UrlAnnotation urlAnnotation) {
        return save(urlAnnotation.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UrlAnnotation UrlAnnotationSaver$lambda$16(Object obj) {
        String str = obj != null ? (String) obj : null;
        kotlin.jvm.internal.k.c(str);
        return new UrlAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object VerbatimTtsAnnotationSaver$lambda$13(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
        return save(verbatimTtsAnnotation.getVerbatim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerbatimTtsAnnotation VerbatimTtsAnnotationSaver$lambda$14(Object obj) {
        String str = obj != null ? (String) obj : null;
        kotlin.jvm.internal.k.c(str);
        return new VerbatimTtsAnnotation(str);
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t9) {
        if ((kotlin.jvm.internal.k.b(saveable, Boolean.FALSE) && !(t9 instanceof NonNullValueClassSaver)) || saveable == null) {
            return null;
        }
        t9.restore(saveable);
        kotlin.jvm.internal.k.m();
        throw null;
    }

    public static final <T> T save(T t9) {
        return t9;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t9, SaverScope saverScope) {
        Object objSave;
        return (original == null || (objSave = t9.save(saverScope, original)) == null) ? Boolean.FALSE : objSave;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    public static final <Result> Result restore(Object obj) {
        if (obj == null) {
            return null;
        }
        kotlin.jvm.internal.k.m();
        throw null;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }

    public static final Saver<LineHeightStyle, Object> getSaver(LineHeightStyle.Companion companion) {
        return LineHeightStyleSaver;
    }
}
