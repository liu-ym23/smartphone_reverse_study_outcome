package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001as\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"ceilToIntPx", "", "", "updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextDelegateKt {
    public static final int ceilToIntPx(float r100) {
        return Math.round((float) Math.ceil(r100));
    }

    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA, reason: not valid java name */
    public static final TextDelegate m1127updateTextDelegaterm0N8CA(TextDelegate r110, AnnotatedString r111, TextStyle r112, Density r113, FontFamily.Resolver r114, boolean r115, int r116, int r117, int r210, List<AnnotatedString.Range<Placeholder>> r211) {
        if (Intrinsics.areEqual(r110.getText(), r111) == false) goto L35;
        if (Intrinsics.areEqual(r110.getStyle(), r112) == false) goto L35;
        if (r110.getSoftWrap() != r115) goto L35;
        if (TextOverflow.m7460equalsimpl0(r110.m1125getOverflowgIe3tQ8(), r116) == false) goto L35;
        if (r110.getMaxLines() != r117) goto L35;
        if (r110.getMinLines() != r210) goto L35;
        if (Intrinsics.areEqual(r110.getDensity(), r113) == false) goto L35;
        if (Intrinsics.areEqual(r110.getPlaceholders(), r211) == false) goto L35;
        if (r110.getFontFamilyResolver() != r114) goto L35;
        return r110;
    L35:
        return new TextDelegate(r111, r112, r117, r210, r115, r116, r113, r114, r211, null);
    }

    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA$default, reason: not valid java name */
    public static /* synthetic */ TextDelegate m1128updateTextDelegaterm0N8CA$default(TextDelegate r110, AnnotatedString r111, TextStyle r112, Density r113, FontFamily.Resolver r114, boolean r115, int r116, int r210, int r211, List r212, int r213, Object r214) {
        if ((r213 & 32) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r213 & 64) == 0) goto L9;
        int r101 = TextOverflow.Companion.m7469getClipgIe3tQ8();
    L11:
        if ((r213 & 128) == 0) goto L13;
        int r117 = Integer.MAX_VALUE;
    L15:
        if ((r213 & 256) == 0) goto L17;
        int r118 = 1;
    L19:
        return m1127updateTextDelegaterm0N8CA(r110, r111, r112, r113, r114, r100, r101, r117, r118, r212);
    L17:
        r118 = r211;
        goto L19
    L13:
        r117 = r210;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
