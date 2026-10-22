package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004\u001a\n\u0010\u0012\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0013\u001a\u00020\n*\u00020\u000b\u001aE\u0010\u0014\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001aE\u0010\u001b\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001a{\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0!H\u0080\b\u001a\u001e\u0010&\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0000¨\u0006'"}, d2 = {"adjustTextRange", "Landroidx/compose/ui/text/TextRange;", "originalRange", "replaceStart", "", "replaceEnd", "insertedTextLength", "adjustTextRange-vJH6DeI", "(JIII)J", "insert", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "index", "text", "", "delete", "start", "end", "placeCursorAtEnd", "selectAll", "forEachChange", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", FilterData.FilterOptionItem.Type.RANGE, "forEachChangeReversed", "findCommonPrefixAndSuffix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "b", "onFound", "Lkotlin/Function4;", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "setSelectionCoerced", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldBufferKt {
    public static final void placeCursorAtEnd(TextFieldBuffer r100) {
        r100.placeCursorBeforeCharAt(r100.getLength());
    }

    public static final void selectAll(TextFieldBuffer r100) {
        r100.m1191setSelection5zctL8(TextRangeKt.TextRange(0, r100.getLength()));
    }

    public static final void forEachChange(TextFieldBuffer.ChangeList r100, Function2<? super TextRange, ? super TextRange, Unit> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.getChangeCount()) goto L6;
        r101.invoke(TextRange.m6986boximpl(r100.mo1194getRangejx7JFs(r102)), TextRange.m6986boximpl(r100.mo1193getOriginalRangejx7JFs(r102)));
        r102 = r102 + 1;
        goto L4
    }

    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList r100, Function2<? super TextRange, ? super TextRange, Unit> r101) {
        int r102 = r100.getChangeCount() - 1;
    L3:
        if (r102 < 0) goto L5;
        r101.invoke(TextRange.m6986boximpl(r100.mo1194getRangejx7JFs(r102)), TextRange.m6986boximpl(r100.mo1193getOriginalRangejx7JFs(r102)));
        r102 = r102 - 1;
        goto L3
    }

    public static final void delete(TextFieldBuffer r100, int r101, int r102) {
        r100.replace(r101, r102, "");
    }

    public static final void findCommonPrefixAndSuffix(CharSequence r100, CharSequence r110, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r111) {
        int r101 = r100.length();
        int r102 = r110.length();
        int r103 = 0;
        if (r100.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L28:
        int r105 = 0;
    L29:
        if (r103 < r101) goto L32;
        if (r105 < r102) goto L32;
        return;
    L32:
        r111.invoke(Integer.valueOf(r103), Integer.valueOf(r101), Integer.valueOf(r105), Integer.valueOf(r102));
        return;
    L8:
        if (r110.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L28;
        int r107 = 0;
        r105 = 0;
        boolean r108 = false;
    L13:
        if (r103 == 0) goto L15;
    L18:
        if (r108 == false) goto L20;
    L23:
        if (r107 >= r101) goto L27;
        if (r105 >= r102) goto L27;
        if (r103 == 0) goto L13;
        if (r108 == false) goto L13;
    L27:
        r103 = r107;
        goto L29
    L20:
        if (r100.charAt(r101 - 1) != r110.charAt(r102 - 1)) goto L22;
        r101 = r101 - 1;
        r102 = r102 - 1;
        goto L23
    L22:
        r108 = true;
        goto L23
    L15:
        if (r100.charAt(r107) != r110.charAt(r105)) goto L17;
        r107 = r107 + 1;
        r105 = r105 + 1;
        goto L18
    L17:
        r103 = 1;
        goto L18
    L10:
        r106 = false;
        goto L11
    L5:
        r104 = false;
        goto L6
    }

    public static final void insert(TextFieldBuffer r100, int r101, String r102) {
        r100.replace(r101, r101, r102);
    }

    public static final void setSelectionCoerced(TextFieldBuffer r100, int r101, int r102) {
        r100.m1191setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(r101, 0, r100.getLength()), RangesKt.coerceIn(r102, 0, r100.getLength())));
    }

    /* JADX INFO: renamed from: adjustTextRange-vJH6DeI, reason: not valid java name */
    public static final long m1195adjustTextRangevJH6DeI(long r100, int r101, int r102, int r103) {
        int r104 = TextRange.m6996getMinimpl(r100);
        int r105 = TextRange.m6995getMaximpl(r100);
        if (r105 >= r101) goto L5;
        return r100;
    L5:
        if (r104 > r101) goto L10;
        if (r102 > r105) goto L10;
        int r106 = r103 - (r102 - r101);
        if (r104 == r105) goto L15;
    L16:
        r101 = r105 + r106;
    L20:
        return TextRangeKt.TextRange(r104, r101);
    L15:
        r104 = r104 + r106;
    L10:
        if (r104 <= r101) goto L13;
        if (r105 >= r102) goto L13;
        r101 = r101 + r103;
        r104 = r101;
    L13:
        if (r104 < r102) goto L17;
        r106 = r103 - (r102 - r101);
        goto L15
    L17:
        if (r101 >= r104) goto L20;
        r104 = r101 + r103;
        r106 = r103 - (r102 - r101);
        goto L16
    }

    public static /* synthetic */ void setSelectionCoerced$default(TextFieldBuffer r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = r101;
    L5:
        setSelectionCoerced(r100, r101, r102);
    }
}
