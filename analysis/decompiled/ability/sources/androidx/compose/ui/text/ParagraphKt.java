package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001aw\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001au\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010$\u001a1\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"DefaultMaxLines", "", "Paragraph", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "ellipsis", "", "width", "", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "Paragraph-Ul8oQg4", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;II)Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", "Paragraph-czeN-Hc", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JII)Landroidx/compose/ui/text/Paragraph;", "ceilToInt", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ParagraphKt {
    public static final int DefaultMaxLines = Integer.MAX_VALUE;

    @C7.c
    public static final Paragraph Paragraph(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z10, float f, Density density, Font.ResourceLoader resourceLoader) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.ActualParagraph(str, textStyle, list, list2, i, z10, f, density, resourceLoader);
    }

    @C7.c
    /* renamed from: Paragraph-UdtVg6A, reason: not valid java name */
    public static final /* synthetic */ Paragraph m6188ParagraphUdtVg6A(String str, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List list, List list2, int i, boolean z10) {
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6570ActualParagraphXGqx6AY(str, textStyle, list, list2, i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), j5, density, resolver);
    }

    /* renamed from: Paragraph-Ul8oQg4, reason: not valid java name */
    public static final Paragraph m6190ParagraphUl8oQg4(String str, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, int i6) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6570ActualParagraphXGqx6AY(str, textStyle, list, list2, i, i6, j5, density, resolver);
    }

    @C7.c
    /* renamed from: Paragraph-_EkL_-Y, reason: not valid java name */
    public static final /* synthetic */ Paragraph m6192Paragraph_EkL_Y(ParagraphIntrinsics paragraphIntrinsics, long j5, int i, boolean z10) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6569ActualParagraph4FmOz70(paragraphIntrinsics, i, z10 ? TextOverflow.INSTANCE.m6780getEllipsisgIe3tQ8() : TextOverflow.INSTANCE.m6779getClipgIe3tQ8(), j5);
    }

    /* renamed from: Paragraph-_EkL_-Y$default, reason: not valid java name */
    public static /* synthetic */ Paragraph m6193Paragraph_EkL_Y$default(ParagraphIntrinsics paragraphIntrinsics, long j5, int i, boolean z10, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i6 & 8) != 0) {
            z10 = false;
        }
        return m6192Paragraph_EkL_Y(paragraphIntrinsics, j5, i, z10);
    }

    /* renamed from: Paragraph-czeN-Hc, reason: not valid java name */
    public static final Paragraph m6194ParagraphczeNHc(ParagraphIntrinsics paragraphIntrinsics, long j5, int i, int i6) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6569ActualParagraph4FmOz70(paragraphIntrinsics, i, i6, j5);
    }

    /* renamed from: Paragraph-czeN-Hc$default, reason: not valid java name */
    public static /* synthetic */ Paragraph m6195ParagraphczeNHc$default(ParagraphIntrinsics paragraphIntrinsics, long j5, int i, int i6, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i10 & 8) != 0) {
            i6 = TextOverflow.INSTANCE.m6779getClipgIe3tQ8();
        }
        return m6194ParagraphczeNHc(paragraphIntrinsics, j5, i, i6);
    }

    public static final int ceilToInt(float f) {
        return (int) Math.ceil(f);
    }

    @C7.c
    public static final Paragraph Paragraph(String str, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z10) {
        TextOverflow.Companion companion = TextOverflow.INSTANCE;
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6570ActualParagraphXGqx6AY(str, textStyle, list, list2, i, z10 ? companion.m6780getEllipsisgIe3tQ8() : companion.m6779getClipgIe3tQ8(), ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, null), density, resolver);
    }

    public static Paragraph Paragraph$default(String str, TextStyle textStyle, List list, List list2, int i, boolean z10, float f, Density density, Font.ResourceLoader resourceLoader, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            list = EmptyList.f4893a;
        }
        List list3 = list;
        if ((i6 & 8) != 0) {
            list2 = EmptyList.f4893a;
        }
        List list4 = list2;
        if ((i6 & 16) != 0) {
            i = Integer.MAX_VALUE;
        }
        int i10 = i;
        if ((i6 & 32) != 0) {
            z10 = false;
        }
        return Paragraph(str, textStyle, (List<AnnotatedString.Range<SpanStyle>>) list3, (List<AnnotatedString.Range<Placeholder>>) list4, i10, z10, f, density, resourceLoader);
    }

    @C7.c
    public static final Paragraph Paragraph(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z10, float f) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m6569ActualParagraph4FmOz70(paragraphIntrinsics, i, z10 ? TextOverflow.INSTANCE.m6780getEllipsisgIe3tQ8() : TextOverflow.INSTANCE.m6779getClipgIe3tQ8(), ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, null));
    }

    public static /* synthetic */ Paragraph Paragraph$default(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z10, float f, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i6 & 4) != 0) {
            z10 = false;
        }
        return Paragraph(paragraphIntrinsics, i, z10, f);
    }
}
