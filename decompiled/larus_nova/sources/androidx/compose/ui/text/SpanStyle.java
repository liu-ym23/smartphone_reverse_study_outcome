package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B¿\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"B©\u0001\b\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010$Bµ\u0001\b\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b!\u0010%BÁ\u0001\b\u0016\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010&BË\u0001\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020*\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010+J\u0014\u0010P\u001a\u00020\u00002\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0087\u0002J¯\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\bT\u0010UJ»\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\bV\u0010WJÅ\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\bX\u0010YJÏ\u0001\u0010S\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020]2\b\u0010Q\u001a\u0004\u0018\u00010^H\u0096\u0002J\u0015\u0010_\u001a\u00020]2\u0006\u0010Q\u001a\u00020\u0000H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020]2\u0006\u0010Q\u001a\u00020\u0000H\u0000¢\u0006\u0002\bbJ\b\u0010c\u001a\u00020dH\u0016J\r\u0010e\u001a\u00020dH\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0010\u001a\u00020\u0005¢\u0006\n\n\u0002\u00100\u001a\u0004\b;\u0010/R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u0017\u001a\u00020\u0018¢\u0006\n\n\u0002\u00100\u001a\u0004\bB\u0010/R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010#\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bK\u0010/R\u0013\u0010'\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006h"}, d2 = {"Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "textForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "Landroidx/compose/ui/graphics/Color;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "color", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextForegroundStyle$ui_text", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "getFontSize-XSAIIZE", "()J", "J", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getColor-0d7_KjU", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "()F", "merge", "other", "plus", "copy", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "copy-2BkPm_w", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-GSF8kmg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-NcG25M8", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "", "hasSameLayoutAffectingAttributes", "hasSameLayoutAffectingAttributes$ui_text", "hasSameNonLayoutAttributes", "hasSameNonLayoutAttributes$ui_text", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpanStyle implements AnnotatedString.Annotation {
    public static final int $stable = 0;
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, PlatformSpanStyle r117, DrawStyle r210, DefaultConstructorMarker r211) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public /* synthetic */ SpanStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, PlatformSpanStyle r117, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public /* synthetic */ SpanStyle(long r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, DefaultConstructorMarker r117) {
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116);
    }

    public /* synthetic */ SpanStyle(Brush r100, float r101, long r102, FontWeight r103, FontStyle r104, FontSynthesis r105, FontFamily r106, String r107, long r110, BaselineShift r111, TextGeometricTransform r112, LocaleList r113, long r114, TextDecoration r115, Shadow r116, PlatformSpanStyle r117, DrawStyle r210, DefaultConstructorMarker r211) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r105, String r106, long r107, BaselineShift r110, TextGeometricTransform r111, LocaleList r112, long r113, TextDecoration r114, Shadow r115, PlatformSpanStyle r116, DrawStyle r117, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m6939getColor0d7_KjU() {
        return this.textForegroundStyle.mo7304getColor0d7_KjU();
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text() {
        int r100 = TextUnit.m7743hashCodeimpl(this.fontSize) * 31;
        FontWeight r101 = this.fontWeight;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        FontStyle r105 = this.fontStyle;
        if (r105 == null) goto L9;
        int r106 = FontStyle.m7113hashCodeimpl(r105.m7115unboximpl());
    L10:
        int r107 = (r104 + r106) * 31;
        FontSynthesis r108 = this.fontSynthesis;
        if (r108 == null) goto L13;
        int r109 = FontSynthesis.m7124hashCodeimpl(r108.m7128unboximpl());
    L14:
        int r110 = (r107 + r109) * 31;
        FontFamily r111 = this.fontFamily;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.fontFeatureSettings;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (((r113 + r115) * 31) + TextUnit.m7743hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift r117 = this.baselineShift;
        if (r117 == null) goto L25;
        int r118 = BaselineShift.m7294hashCodeimpl(r117.m7296unboximpl());
    L26:
        int r119 = (r116 + r118) * 31;
        TextGeometricTransform r120 = this.textGeometricTransform;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        LocaleList r123 = this.localeList;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (((r122 + r124) * 31) + Color.m4834hashCodeimpl(this.background)) * 31;
        PlatformSpanStyle r126 = this.platformStyle;
        if (r126 == null) goto L38;
        r102 = r126.hashCode();
    L38:
        return r125 + r102;
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SpanStyle(color=" + Color.m4835toStringimpl(m6939getColor0d7_KjU()) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + TextUnit.m7749toStringimpl(this.fontSize) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + TextUnit.m7749toStringimpl(this.letterSpacing) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + Color.m4835toStringimpl(this.background) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ", drawStyle=" + this.drawStyle + ')';
    }

    public int hashCode() {
        int r100 = Color.m4834hashCodeimpl(m6939getColor0d7_KjU()) * 31;
        Brush r101 = getBrush();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((((r100 + r103) * 31) + Float.floatToIntBits(getAlpha())) * 31) + TextUnit.m7743hashCodeimpl(this.fontSize)) * 31;
        FontWeight r105 = this.fontWeight;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        FontStyle r108 = this.fontStyle;
        if (r108 == null) goto L13;
        int r109 = FontStyle.m7113hashCodeimpl(r108.m7115unboximpl());
    L14:
        int r110 = (r107 + r109) * 31;
        FontSynthesis r111 = this.fontSynthesis;
        if (r111 == null) goto L17;
        int r112 = FontSynthesis.m7124hashCodeimpl(r111.m7128unboximpl());
    L18:
        int r113 = (r110 + r112) * 31;
        FontFamily r114 = this.fontFamily;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.fontFeatureSettings;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (((r116 + r118) * 31) + TextUnit.m7743hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift r120 = this.baselineShift;
        if (r120 == null) goto L29;
        int r121 = BaselineShift.m7294hashCodeimpl(r120.m7296unboximpl());
    L30:
        int r122 = (r119 + r121) * 31;
        TextGeometricTransform r123 = this.textGeometricTransform;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        LocaleList r126 = this.localeList;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (((r125 + r127) * 31) + Color.m4834hashCodeimpl(this.background)) * 31;
        TextDecoration r129 = this.textDecoration;
        if (r129 == null) goto L41;
        int r130 = r129.hashCode();
    L42:
        int r131 = (r128 + r130) * 31;
        Shadow r132 = this.shadow;
        if (r132 == null) goto L45;
        int r133 = r132.hashCode();
    L46:
        int r134 = (r131 + r133) * 31;
        PlatformSpanStyle r135 = this.platformStyle;
        if (r135 == null) goto L49;
        int r136 = r135.hashCode();
    L50:
        int r137 = (r134 + r136) * 31;
        DrawStyle r138 = this.drawStyle;
        if (r138 == null) goto L54;
        r102 = r138.hashCode();
    L54:
        return r137 + r102;
    L49:
        r136 = 0;
        goto L50
    L45:
        r133 = 0;
        goto L46
    L41:
        r130 = 0;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m6937getBackground0d7_KjU() {
        return this.background;
    }

    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m6938getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m6940getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m6941getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m6942getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m6943getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final TextForegroundStyle getTextForegroundStyle$ui_text() {
        return this.textForegroundStyle;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpanStyle) == true) goto L8;
        return false;
    L8:
        SpanStyle r101 = (SpanStyle) r100;
        if (hasSameLayoutAffectingAttributes$ui_text(r101) == true) goto L11;
    L13:
        return false;
    L11:
        if (hasSameNonLayoutAttributes$ui_text(r101) == false) goto L13;
        return true;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text(SpanStyle r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (TextUnit.m7739equalsimpl0(this.fontSize, r100.fontSize) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fontWeight, r100.fontWeight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontStyle, r100.fontStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontSynthesis, r100.fontSynthesis) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontFamily, r100.fontFamily) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontFeatureSettings, r100.fontFeatureSettings) == true) goto L24;
        return false;
    L24:
        if (TextUnit.m7739equalsimpl0(this.letterSpacing, r100.letterSpacing) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.baselineShift, r100.baselineShift) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.textGeometricTransform, r100.textGeometricTransform) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.localeList, r100.localeList) == true) goto L36;
        return false;
    L36:
        if (Color.m4828equalsimpl0(this.background, r100.background) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.platformStyle, r100.platformStyle) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final boolean hasSameNonLayoutAttributes$ui_text(SpanStyle r100) {
        if (Intrinsics.areEqual(this.textForegroundStyle, r100.textForegroundStyle) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.textDecoration, r100.textDecoration) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.shadow, r100.shadow) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.drawStyle, r100.drawStyle) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final SpanStyle merge(SpanStyle r210) {
        if (r210 != null) goto L6;
        return this;
    L6:
        return SpanStyleKt.m6944fastMergedSHsh3o(this, r210.textForegroundStyle.mo7304getColor0d7_KjU(), r210.textForegroundStyle.getBrush(), r210.textForegroundStyle.getAlpha(), r210.fontSize, r210.fontWeight, r210.fontStyle, r210.fontSynthesis, r210.fontFamily, r210.fontFeatureSettings, r210.letterSpacing, r210.baselineShift, r210.textGeometricTransform, r210.localeList, r210.background, r210.textDecoration, r210.shadow, r210.platformStyle, r210.drawStyle);
    }

    public final SpanStyle plus(SpanStyle r100) {
        return merge(r100);
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle r100, SpanStyle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.merge(r101);
    }

    private SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r310, String r311, long r312, BaselineShift r313, TextGeometricTransform r314, LocaleList r315, long r316, TextDecoration r317, Shadow r410) {
        this(TextForegroundStyle.Companion.m7439from8_81llA(r210), r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r410, null, null, 32768, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-IuqyXdg, reason: not valid java name */
    public final /* synthetic */ SpanStyle m6935copyIuqyXdg(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r310, FontFamily r311, String r312, long r313, BaselineShift r314, TextGeometricTransform r315, LocaleList r316, long r317, TextDecoration r410, Shadow r411) {
        if (Color.m4828equalsimpl0(r210, m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.textForegroundStyle;
    L7:
        return new SpanStyle(r100, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, this.platformStyle, this.drawStyle, null);
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L7
    }

    private SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r310, String r311, long r312, BaselineShift r313, TextGeometricTransform r314, LocaleList r315, long r316, TextDecoration r317, Shadow r410, PlatformSpanStyle r411) {
        this(TextForegroundStyle.Companion.m7439from8_81llA(r210), r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, null, 32768, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-2BkPm_w, reason: not valid java name */
    public final /* synthetic */ SpanStyle m6933copy2BkPm_w(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r310, FontFamily r311, String r312, long r313, BaselineShift r314, TextGeometricTransform r315, LocaleList r316, long r317, TextDecoration r410, Shadow r411, PlatformSpanStyle r412) {
        if (Color.m4828equalsimpl0(r210, m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.textForegroundStyle;
    L7:
        return new SpanStyle(r100, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, null, 32768, null);
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L7
    }

    public /* synthetic */ SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r215, String r216, long r217, BaselineShift r310, TextGeometricTransform r311, LocaleList r312, long r313, TextDecoration r314, Shadow r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r316 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r316 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r316 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r316 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        long r218 = r100;
        long r219 = r101;
        FontWeight r220 = r102;
        FontStyle r221 = r103;
        FontSynthesis r222 = r104;
        FontFamily r223 = r105;
        String r224 = r110;
        long r318 = r111;
        BaselineShift r319 = r112;
        TextGeometricTransform r320 = r113;
        LocaleList r321 = r114;
        long r322 = r115;
        TextDecoration r323 = r106;
        Shadow r324 = r107;
        this(r218, r219, r220, r221, r222, r223, r224, r318, r319, r320, r321, r322, r323, r324, null);
        return;
    L57:
        r107 = r315;
        goto L58
    L53:
        r106 = r314;
        goto L55
    L49:
        r115 = r313;
        goto L51
    L45:
        r114 = r312;
        goto L47
    L41:
        r113 = r311;
        goto L43
    L37:
        r112 = r310;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: copy-GSF8kmg, reason: not valid java name */
    public final SpanStyle m6934copyGSF8kmg(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r310, String r311, long r312, BaselineShift r313, TextGeometricTransform r314, LocaleList r315, long r316, TextDecoration r317, Shadow r410, PlatformSpanStyle r411, DrawStyle r412) {
        if (Color.m4828equalsimpl0(r210, m6939getColor0d7_KjU()) == false) goto L5;
        TextForegroundStyle r100 = this.textForegroundStyle;
    L7:
        return new SpanStyle(r100, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, null);
    L5:
        r100 = TextForegroundStyle.Companion.m7439from8_81llA(r210);
        goto L7
    }

    private SpanStyle(TextForegroundStyle r100, long r101, FontWeight r102, FontStyle r103, FontSynthesis r104, FontFamily r110, String r111, long r112, BaselineShift r113, TextGeometricTransform r114, LocaleList r115, long r116, TextDecoration r117, Shadow r210, PlatformSpanStyle r211, DrawStyle r212) {
        this.textForegroundStyle = r100;
        this.fontSize = r101;
        this.fontWeight = r102;
        this.fontStyle = r103;
        this.fontSynthesis = r104;
        this.fontFamily = r110;
        this.fontFeatureSettings = r111;
        this.letterSpacing = r112;
        this.baselineShift = r113;
        this.textGeometricTransform = r114;
        this.localeList = r115;
        this.background = r116;
        this.textDecoration = r117;
        this.shadow = r210;
        this.platformStyle = r211;
        this.drawStyle = r212;
    }

    private SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r215, String r310, long r311, BaselineShift r312, TextGeometricTransform r313, LocaleList r314, long r315, TextDecoration r316, Shadow r317, PlatformSpanStyle r410, DrawStyle r411) {
        this(TextForegroundStyle.Companion.m7439from8_81llA(r210), r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, null);
    }

    public /* synthetic */ SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r215, String r216, long r310, BaselineShift r311, TextGeometricTransform r312, LocaleList r313, long r314, TextDecoration r315, Shadow r316, PlatformSpanStyle r317, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r410 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r410 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r410 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r410 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r410 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        PlatformSpanStyle r108 = null;
    L62:
        long r217 = r100;
        long r218 = r101;
        FontWeight r219 = r102;
        FontStyle r220 = r103;
        FontSynthesis r221 = r104;
        FontFamily r222 = r105;
        String r318 = r110;
        long r319 = r111;
        BaselineShift r320 = r112;
        TextGeometricTransform r321 = r113;
        LocaleList r322 = r114;
        long r323 = r115;
        Shadow r324 = r107;
        PlatformSpanStyle r412 = r108;
        this(r217, r218, r219, r220, r221, r222, r318, r319, r320, r321, r322, r323, r116, r324, r412, null);
        return;
    L61:
        r108 = r317;
        goto L62
    L57:
        r107 = r316;
        goto L59
    L53:
        r106 = r315;
        goto L54
    L49:
        r115 = r314;
        goto L51
    L45:
        r114 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = r311;
        goto L39
    L33:
        r111 = r310;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: copy-IuqyXdg$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m6931copyIuqyXdg$default(SpanStyle r110, long r111, long r112, FontWeight r210, FontStyle r211, FontSynthesis r212, FontFamily r213, String r214, long r215, BaselineShift r216, TextGeometricTransform r217, LocaleList r310, long r311, TextDecoration r312, Shadow r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        long r100 = r110.m6939getColor0d7_KjU();
    L7:
        if ((r314 & 2) == 0) goto L9;
        long r101 = r110.fontSize;
    L11:
        if ((r314 & 4) == 0) goto L13;
        FontWeight r102 = r110.fontWeight;
    L15:
        if ((r314 & 8) == 0) goto L17;
        FontStyle r103 = r110.fontStyle;
    L19:
        if ((r314 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.fontSynthesis;
    L23:
        if ((r314 & 32) == 0) goto L25;
        FontFamily r105 = r110.fontFamily;
    L27:
        if ((r314 & 64) == 0) goto L29;
        String r113 = r110.fontFeatureSettings;
    L31:
        if ((r314 & 128) == 0) goto L33;
        long r114 = r110.letterSpacing;
    L35:
        if ((r314 & 256) == 0) goto L37;
        BaselineShift r115 = r110.baselineShift;
    L39:
        if ((r314 & 512) == 0) goto L41;
        TextGeometricTransform r116 = r110.textGeometricTransform;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        LocaleList r117 = r110.localeList;
    L46:
        LocaleList r316 = r117;
        TextGeometricTransform r218 = r116;
        if ((r314 & 2048) == 0) goto L49;
        long r118 = r110.background;
    L50:
        long r317 = r118;
        if ((r314 & 4096) == 0) goto L53;
        TextDecoration r119 = r110.textDecoration;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Shadow r106 = r110.shadow;
    L59:
        return r110.m6935copyIuqyXdg(r100, r101, r102, r103, r104, r105, r113, r114, r115, r218, r316, r317, r119, r106);
    L57:
        r106 = r313;
        goto L59
    L53:
        r119 = r312;
        goto L55
    L49:
        r118 = r311;
        goto L50
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-NcG25M8, reason: not valid java name */
    public final SpanStyle m6936copyNcG25M8(Brush r210, float r211, long r212, FontWeight r213, FontStyle r310, FontSynthesis r311, FontFamily r312, String r313, long r314, BaselineShift r315, TextGeometricTransform r316, LocaleList r317, long r318, TextDecoration r410, Shadow r411, PlatformSpanStyle r412, DrawStyle r413) {
        return new SpanStyle(TextForegroundStyle.Companion.from(r210, r211), r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, null);
    }

    private SpanStyle(Brush r210, float r211, long r212, FontWeight r213, FontStyle r214, FontSynthesis r215, FontFamily r310, String r311, long r312, BaselineShift r313, TextGeometricTransform r314, LocaleList r315, long r316, TextDecoration r317, Shadow r410, PlatformSpanStyle r411, DrawStyle r412) {
        this(TextForegroundStyle.Companion.from(r210, r211), r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, null);
    }

    public /* synthetic */ SpanStyle(long r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r214, FontFamily r215, String r310, long r311, BaselineShift r312, TextGeometricTransform r313, LocaleList r314, long r315, TextDecoration r316, Shadow r317, PlatformSpanStyle r410, DrawStyle r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        long r100 = Color.Companion.m4863getUnspecified0d7_KjU();
    L7:
        if ((r412 & 2) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r412 & 4) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        FontFamily r105 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        long r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r412 & 256) == 0) goto L37;
        BaselineShift r112 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        TextGeometricTransform r113 = null;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        LocaleList r114 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        long r115 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r412 & 4096) == 0) goto L53;
        TextDecoration r106 = null;
    L54:
        TextDecoration r116 = r106;
        if ((r412 & 8192) == 0) goto L57;
        Shadow r107 = null;
    L58:
        Shadow r117 = r107;
        if ((r412 & 16384) == 0) goto L61;
        PlatformSpanStyle r108 = null;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        DrawStyle r109 = null;
    L66:
        long r216 = r100;
        long r217 = r101;
        FontWeight r218 = r102;
        FontStyle r219 = r103;
        FontSynthesis r220 = r104;
        FontFamily r318 = r105;
        String r319 = r110;
        long r320 = r111;
        BaselineShift r321 = r112;
        TextGeometricTransform r322 = r113;
        LocaleList r323 = r114;
        long r324 = r115;
        PlatformSpanStyle r414 = r108;
        DrawStyle r415 = r109;
        this(r216, r217, r218, r219, r220, r318, r319, r320, r321, r322, r323, r324, r116, r117, r414, r415, null);
        return;
    L65:
        r109 = r411;
        goto L66
    L61:
        r108 = r410;
        goto L63
    L57:
        r107 = r317;
        goto L58
    L53:
        r106 = r316;
        goto L54
    L49:
        r115 = r315;
        goto L51
    L45:
        r114 = r314;
        goto L47
    L41:
        r113 = r313;
        goto L43
    L37:
        r112 = r312;
        goto L39
    L33:
        r111 = r311;
        goto L35
    L29:
        r110 = r310;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX INFO: renamed from: copy-2BkPm_w$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m6929copy2BkPm_w$default(SpanStyle r110, long r111, long r112, FontWeight r210, FontStyle r211, FontSynthesis r212, FontFamily r213, String r214, long r215, BaselineShift r216, TextGeometricTransform r217, LocaleList r310, long r311, TextDecoration r312, Shadow r313, PlatformSpanStyle r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        long r100 = r110.m6939getColor0d7_KjU();
    L7:
        if ((r315 & 2) == 0) goto L9;
        long r101 = r110.fontSize;
    L11:
        if ((r315 & 4) == 0) goto L13;
        FontWeight r102 = r110.fontWeight;
    L15:
        if ((r315 & 8) == 0) goto L17;
        FontStyle r103 = r110.fontStyle;
    L19:
        if ((r315 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.fontSynthesis;
    L23:
        if ((r315 & 32) == 0) goto L25;
        FontFamily r105 = r110.fontFamily;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r113 = r110.fontFeatureSettings;
    L31:
        if ((r315 & 128) == 0) goto L33;
        long r114 = r110.letterSpacing;
    L35:
        if ((r315 & 256) == 0) goto L37;
        BaselineShift r115 = r110.baselineShift;
    L39:
        if ((r315 & 512) == 0) goto L41;
        TextGeometricTransform r116 = r110.textGeometricTransform;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        LocaleList r117 = r110.localeList;
    L46:
        LocaleList r317 = r117;
        TextGeometricTransform r218 = r116;
        if ((r315 & 2048) == 0) goto L49;
        long r118 = r110.background;
    L50:
        long r318 = r118;
        if ((r315 & 4096) == 0) goto L53;
        TextDecoration r119 = r110.textDecoration;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        Shadow r120 = r110.shadow;
    L59:
        if ((r315 & 16384) == 0) goto L61;
        PlatformSpanStyle r106 = r110.platformStyle;
    L63:
        return r110.m6933copy2BkPm_w(r100, r101, r102, r103, r104, r105, r113, r114, r115, r218, r317, r318, r119, r120, r106);
    L61:
        r106 = r314;
        goto L63
    L57:
        r120 = r313;
        goto L59
    L53:
        r119 = r312;
        goto L55
    L49:
        r118 = r311;
        goto L50
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle r210, long r211, FontWeight r212, FontStyle r213, FontSynthesis r310, FontFamily r311, String r312, long r313, BaselineShift r314, TextGeometricTransform r315, LocaleList r316, long r317, TextDecoration r410, Shadow r411, PlatformSpanStyle r412, DrawStyle r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 2) == 0) goto L5;
        long r100 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L7:
        if ((r414 & 4) == 0) goto L9;
        FontWeight r101 = null;
    L11:
        if ((r414 & 8) == 0) goto L13;
        FontStyle r102 = null;
    L15:
        if ((r414 & 16) == 0) goto L17;
        FontSynthesis r103 = null;
    L19:
        if ((r414 & 32) == 0) goto L21;
        FontFamily r110 = null;
    L23:
        if ((r414 & 64) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r414 & 128) == 0) goto L29;
        long r112 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L31:
        if ((r414 & 256) == 0) goto L33;
        BaselineShift r113 = null;
    L35:
        if ((r414 & 512) == 0) goto L37;
        TextGeometricTransform r114 = null;
    L39:
        if ((r414 & 1024) == 0) goto L41;
        LocaleList r115 = null;
    L43:
        if ((r414 & 2048) == 0) goto L45;
        long r116 = Color.Companion.m4863getUnspecified0d7_KjU();
    L47:
        if ((r414 & 4096) == 0) goto L49;
        TextDecoration r117 = null;
    L51:
        if ((r414 & 8192) == 0) goto L53;
        Shadow r214 = null;
    L55:
        if ((r414 & 16384) == 0) goto L57;
        PlatformSpanStyle r215 = null;
    L59:
        if ((r414 & 32768) == 0) goto L61;
        DrawStyle r216 = null;
    L62:
        this(r210, r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r214, r215, r216, null);
        return;
    L61:
        r216 = r413;
        goto L62
    L57:
        r215 = r412;
        goto L59
    L53:
        r214 = r411;
        goto L55
    L49:
        r117 = r410;
        goto L51
    L45:
        r116 = r317;
        goto L47
    L41:
        r115 = r316;
        goto L43
    L37:
        r114 = r315;
        goto L39
    L33:
        r113 = r314;
        goto L35
    L29:
        r112 = r313;
        goto L31
    L25:
        r111 = r312;
        goto L27
    L21:
        r110 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public /* synthetic */ SpanStyle(Brush r210, float r211, long r212, FontWeight r213, FontStyle r310, FontSynthesis r311, FontFamily r312, String r313, long r314, BaselineShift r315, TextGeometricTransform r316, LocaleList r317, long r318, TextDecoration r410, Shadow r411, PlatformSpanStyle r412, DrawStyle r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 2) == 0) goto L5;
        float r100 = Float.NaN;
    L7:
        if ((r414 & 4) == 0) goto L9;
        long r101 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L11:
        if ((r414 & 8) == 0) goto L13;
        FontWeight r102 = null;
    L15:
        if ((r414 & 16) == 0) goto L17;
        FontStyle r103 = null;
    L19:
        if ((r414 & 32) == 0) goto L21;
        FontSynthesis r104 = null;
    L23:
        if ((r414 & 64) == 0) goto L25;
        FontFamily r110 = null;
    L27:
        if ((r414 & 128) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r414 & 256) == 0) goto L33;
        long r112 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L35:
        if ((r414 & 512) == 0) goto L37;
        BaselineShift r113 = null;
    L39:
        if ((r414 & 1024) == 0) goto L41;
        TextGeometricTransform r114 = null;
    L43:
        if ((r414 & 2048) == 0) goto L45;
        LocaleList r115 = null;
    L47:
        if ((r414 & 4096) == 0) goto L49;
        long r116 = Color.Companion.m4863getUnspecified0d7_KjU();
    L51:
        if ((r414 & 8192) == 0) goto L53;
        TextDecoration r117 = null;
    L55:
        if ((r414 & 16384) == 0) goto L57;
        Shadow r214 = null;
    L59:
        if ((32768 & r414) == 0) goto L61;
        PlatformSpanStyle r215 = null;
    L63:
        if ((r414 & 65536) == 0) goto L65;
        DrawStyle r216 = null;
    L66:
        this(r210, r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r214, r215, r216, null);
        return;
    L65:
        r216 = r413;
        goto L66
    L61:
        r215 = r412;
        goto L63
    L57:
        r214 = r411;
        goto L59
    L53:
        r117 = r410;
        goto L55
    L49:
        r116 = r318;
        goto L51
    L45:
        r115 = r317;
        goto L47
    L41:
        r114 = r316;
        goto L43
    L37:
        r113 = r315;
        goto L39
    L33:
        r112 = r314;
        goto L35
    L29:
        r111 = r313;
        goto L31
    L25:
        r110 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    /* JADX INFO: renamed from: copy-GSF8kmg$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m6930copyGSF8kmg$default(SpanStyle r110, long r111, long r210, FontWeight r211, FontStyle r212, FontSynthesis r213, FontFamily r214, String r215, long r216, BaselineShift r217, TextGeometricTransform r310, LocaleList r311, long r312, TextDecoration r313, Shadow r314, PlatformSpanStyle r315, DrawStyle r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        long r100 = r110.m6939getColor0d7_KjU();
    L7:
        if ((r317 & 2) == 0) goto L9;
        long r101 = r110.fontSize;
    L11:
        if ((r317 & 4) == 0) goto L13;
        FontWeight r102 = r110.fontWeight;
    L15:
        if ((r317 & 8) == 0) goto L17;
        FontStyle r103 = r110.fontStyle;
    L19:
        if ((r317 & 16) == 0) goto L21;
        FontSynthesis r104 = r110.fontSynthesis;
    L23:
        if ((r317 & 32) == 0) goto L25;
        FontFamily r105 = r110.fontFamily;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r112 = r110.fontFeatureSettings;
    L31:
        if ((r317 & 128) == 0) goto L33;
        long r113 = r110.letterSpacing;
    L35:
        if ((r317 & 256) == 0) goto L37;
        BaselineShift r114 = r110.baselineShift;
    L39:
        if ((r317 & 512) == 0) goto L41;
        TextGeometricTransform r115 = r110.textGeometricTransform;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        LocaleList r116 = r110.localeList;
    L46:
        LocaleList r319 = r116;
        TextGeometricTransform r320 = r115;
        if ((r317 & 2048) == 0) goto L49;
        long r117 = r110.background;
    L50:
        long r321 = r117;
        if ((r317 & 4096) == 0) goto L53;
        TextDecoration r118 = r110.textDecoration;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        Shadow r119 = r110.shadow;
    L58:
        Shadow r322 = r119;
        if ((r317 & 16384) == 0) goto L61;
        PlatformSpanStyle r120 = r110.platformStyle;
    L63:
        if ((r317 & 32768) == 0) goto L65;
        DrawStyle r106 = r110.drawStyle;
    L67:
        return r110.m6934copyGSF8kmg(r100, r101, r102, r103, r104, r105, r112, r113, r114, r320, r319, r321, r118, r322, r120, r106);
    L65:
        r106 = r316;
        goto L67
    L61:
        r120 = r315;
        goto L63
    L57:
        r119 = r314;
        goto L58
    L53:
        r118 = r313;
        goto L55
    L49:
        r117 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L46
    L41:
        r115 = r310;
        goto L43
    L37:
        r114 = r217;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-NcG25M8$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m6932copyNcG25M8$default(SpanStyle r210, Brush r211, float r212, long r213, FontWeight r214, FontStyle r215, FontSynthesis r216, FontFamily r217, String r218, long r310, BaselineShift r311, TextGeometricTransform r312, LocaleList r313, long r314, TextDecoration r315, Shadow r316, PlatformSpanStyle r317, DrawStyle r410, int r411, Object r412) {
        if ((r411 & 2) == 0) goto L5;
        float r100 = r210.getAlpha();
    L7:
        if ((r411 & 4) == 0) goto L9;
        long r101 = r210.fontSize;
    L11:
        if ((r411 & 8) == 0) goto L13;
        FontWeight r102 = r210.fontWeight;
    L15:
        if ((r411 & 16) == 0) goto L17;
        FontStyle r103 = r210.fontStyle;
    L19:
        if ((r411 & 32) == 0) goto L21;
        FontSynthesis r104 = r210.fontSynthesis;
    L23:
        if ((r411 & 64) == 0) goto L25;
        FontFamily r105 = r210.fontFamily;
    L27:
        if ((r411 & 128) == 0) goto L29;
        String r106 = r210.fontFeatureSettings;
    L31:
        if ((r411 & 256) == 0) goto L33;
        long r110 = r210.letterSpacing;
    L35:
        if ((r411 & 512) == 0) goto L37;
        BaselineShift r111 = r210.baselineShift;
    L39:
        if ((r411 & 1024) == 0) goto L41;
        TextGeometricTransform r112 = r210.textGeometricTransform;
    L43:
        if ((r411 & 2048) == 0) goto L45;
        LocaleList r113 = r210.localeList;
    L46:
        LocaleList r413 = r113;
        if ((r411 & 4096) == 0) goto L49;
        long r114 = r210.background;
    L50:
        long r115 = r114;
        if ((r411 & 8192) == 0) goto L53;
        TextDecoration r116 = r210.textDecoration;
    L55:
        if ((r411 & 16384) == 0) goto L57;
        Shadow r117 = r210.shadow;
    L59:
        if ((r411 & 32768) == 0) goto L61;
        PlatformSpanStyle r118 = r210.platformStyle;
    L63:
        if ((r411 & 65536) == 0) goto L65;
        DrawStyle r107 = r210.drawStyle;
    L67:
        return r210.m6936copyNcG25M8(r211, r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r413, r115, r116, r117, r118, r107);
    L65:
        r107 = r410;
        goto L67
    L61:
        r118 = r317;
        goto L63
    L57:
        r117 = r316;
        goto L59
    L53:
        r116 = r315;
        goto L55
    L49:
        r114 = r314;
        goto L50
    L45:
        r113 = r313;
        goto L46
    L41:
        r112 = r312;
        goto L43
    L37:
        r111 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L35
    L29:
        r106 = r218;
        goto L31
    L25:
        r105 = r217;
        goto L27
    L21:
        r104 = r216;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
