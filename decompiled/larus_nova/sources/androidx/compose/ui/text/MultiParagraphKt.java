package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a9\u0010\t\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0001H\u0000\u001a-\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00010\u000eH\u0082\b¨\u0006\u0016"}, d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByY", "y", "", "findParagraphsByRange", "", FilterData.FilterOptionItem.Type.RANGE, "Landroidx/compose/ui/text/TextRange;", "action", "Lkotlin/Function1;", "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLkotlin/jvm/functions/Function1;)V", "findParagraphByLineIndex", "lineIndex", "fastBinarySearch", ExifInterface.GPS_DIRECTION_TRUE, "comparison", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiParagraphKt {
    public static /* synthetic */ CharSequence a(ParagraphInfo r100) {
        return findParagraphByIndex$lambda$3$lambda$2(r100);
    }

    private static final CharSequence findParagraphByIndex$lambda$3$lambda$2(ParagraphInfo r100) {
        return "[" + r100.getStartIndex() + ", " + r100.getEndIndex() + ')';
    }

    private static final <T> int fastBinarySearch(List<? extends T> r100, Function1<? super T, Integer> r101) {
        int r102 = r100.size() - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L11;
        int r104 = (r103 + r102) >>> 1;
        int r105 = r101.invoke((Object) ListProtector.get(r100, r104)).intValue();
        if (r105 < 0) goto L6;
        if (r105 <= 0) goto L9;
        r102 = r104 - 1;
        goto L3
    L9:
        return r104;
    L6:
        r103 = r104 + 1;
        goto L3
    L11:
        return -(r103 + 1);
    }

    public static final int findParagraphByIndex(List<ParagraphInfo> r110, int r111) {
        int r100 = ((ParagraphInfo) CollectionsKt.last(r110)).getEndIndex();
        boolean r101 = false;
        if (r111 > ((ParagraphInfo) CollectionsKt.last(r110)).getEndIndex()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Index " + r111 + " should be less or equal than last line's end " + r100);
    L8:
        int r103 = r110.size() - 1;
        int r104 = 0;
    L9:
        if (r104 > r103) goto L21;
        int r105 = (r104 + r103) >>> 1;
        ParagraphInfo r106 = (ParagraphInfo) ListProtector.get(r110, r105);
        if (r106.getStartIndex() <= r111) goto L14;
        byte r107 = 1;
    L17:
        if (r107 < 0) goto L18;
        if (r107 <= 0) goto L22;
        r103 = r105 - 1;
    L22:
        if (r105 >= 0) goto L24;
    L26:
        if (r101 == true) goto L28;
        InlineClassHelperKt.throwIllegalArgumentException("Found paragraph index " + r105 + " should be in range [0, " + r110.size() + ").\nDebug info: index=" + r111 + ", paragraphs=[" + ListUtilsKt.fastJoinToString$default(r110, null, null, null, 0, null, new l(), 31, null) + ']');
    L28:
        return r105;
    L24:
        if (r105 >= r110.size()) goto L26;
        r101 = true;
        goto L26
    L18:
        r104 = r105 + 1;
        goto L9
    L14:
        if (r106.getEndIndex() > r111) goto L16;
        r107 = -1;
        goto L17
    L16:
        r107 = 0;
        goto L17
    L21:
        r105 = -(r104 + 1);
        goto L22
    L5:
        r102 = false;
        goto L6
    }

    public static final int findParagraphByLineIndex(List<ParagraphInfo> r100, int r101) {
        int r102 = r100.size() - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L16;
        int r104 = (r103 + r102) >>> 1;
        ParagraphInfo r105 = (ParagraphInfo) ListProtector.get(r100, r104);
        if (r105.getStartLineIndex() <= r101) goto L8;
        byte r106 = 1;
    L11:
        if (r106 < 0) goto L12;
        if (r106 <= 0) goto L24;
        r102 = r104 - 1;
        goto L3
    L24:
        return r104;
    L12:
        r103 = r104 + 1;
        goto L3
    L8:
        if (r105.getEndLineIndex() > r101) goto L10;
        r106 = -1;
        goto L11
    L10:
        r106 = 0;
        goto L11
    L16:
        return -(r103 + 1);
    }

    public static final int findParagraphByY(List<ParagraphInfo> r100, float r101) {
        if (r101 > 0.0f) goto L6;
        return 0;
    L6:
        if (r101 >= ((ParagraphInfo) CollectionsKt.last(r100)).getBottom()) goto L8;
        int r102 = r100.size() - 1;
        int r103 = 0;
    L10:
        if (r103 > r102) goto L23;
        int r104 = (r103 + r102) >>> 1;
        ParagraphInfo r105 = (ParagraphInfo) ListProtector.get(r100, r104);
        if (r105.getTop() <= r101) goto L15;
        byte r106 = 1;
    L18:
        if (r106 < 0) goto L19;
        if (r106 <= 0) goto L31;
        r102 = r104 - 1;
        goto L10
    L31:
        return r104;
    L19:
        r103 = r104 + 1;
        goto L10
    L15:
        if (r105.getBottom() > r101) goto L17;
        r106 = -1;
        goto L18
    L17:
        r106 = 0;
        goto L18
    L23:
        return -(r103 + 1);
    L8:
        return CollectionsKt.getLastIndex(r100);
    }

    /* JADX INFO: renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m6865findParagraphsByRangeSbBc2M(List<ParagraphInfo> r100, long r101, Function1<? super ParagraphInfo, Unit> r102) {
        int r103 = findParagraphByIndex(r100, TextRange.m6996getMinimpl(r101));
        int r104 = r100.size();
    L3:
        if (r103 >= r104) goto L10;
        ParagraphInfo r105 = (ParagraphInfo) ListProtector.get(r100, r103);
        if (r105.getStartIndex() >= TextRange.m6995getMaximpl(r101)) goto L15;
        if (r105.getStartIndex() == r105.getEndIndex()) goto L9;
        r102.invoke(r105);
    L9:
        r103 = r103 + 1;
        goto L3
    L15:
        return;
    }
}
