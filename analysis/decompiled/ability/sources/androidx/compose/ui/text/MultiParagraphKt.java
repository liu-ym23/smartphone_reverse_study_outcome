package androidx.compose.ui.text;

import D7.v;
import H4.o;
import S7.k;
import android.view.p;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a%\u0010\u0005\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0014\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0014\u0010\u0006\u001a4\u0010\u0017\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\rH\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"", "Landroidx/compose/ui/text/ParagraphInfo;", "paragraphInfoList", "", "index", "findParagraphByIndex", "(Ljava/util/List;I)I", "", "y", "findParagraphByY", "(Ljava/util/List;F)I", "Landroidx/compose/ui/text/TextRange;", "range", "Lkotlin/Function1;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLS7/k;)V", "findParagraphsByRange", "lineIndex", "findParagraphByLineIndex", ExifInterface.GPS_DIRECTION_TRUE, "comparison", "fastBinarySearch", "(Ljava/util/List;LS7/k;)I", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> list, k kVar) {
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i6 = (i + size) >>> 1;
            int iIntValue = ((Number) kVar.invoke(list.get(i6))).intValue();
            if (iIntValue < 0) {
                i = i6 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i6;
                }
                size = i6 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int findParagraphByIndex(List<ParagraphInfo> list, int i) {
        int i6;
        int endIndex = ((ParagraphInfo) v.K0(list)).getEndIndex();
        boolean z10 = false;
        if (!(i <= ((ParagraphInfo) v.K0(list)).getEndIndex())) {
            InlineClassHelperKt.throwIllegalArgumentException("Index " + i + " should be less or equal than last line's end " + endIndex);
        }
        int size = list.size() - 1;
        int i10 = 0;
        while (true) {
            if (i10 > size) {
                i6 = -(i10 + 1);
                break;
            }
            i6 = (i10 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i6);
            char c = paragraphInfo.getStartIndex() > i ? (char) 1 : paragraphInfo.getEndIndex() <= i ? (char) 65535 : (char) 0;
            if (c >= 0) {
                if (c <= 0) {
                    break;
                }
                size = i6 - 1;
            } else {
                i10 = i6 + 1;
            }
        }
        if (i6 >= 0 && i6 < list.size()) {
            z10 = true;
        }
        if (!z10) {
            StringBuilder sbU = B7.a.u(i6, "Found paragraph index ", " should be in range [0, ");
            sbU.append(list.size());
            sbU.append(").\nDebug info: index=");
            sbU.append(i);
            sbU.append(", paragraphs=[");
            sbU.append(ListUtilsKt.fastJoinToString$default(list, null, null, null, 0, null, new p(6), 31, null));
            sbU.append(']');
            InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findParagraphByIndex$lambda$3$lambda$2(ParagraphInfo paragraphInfo) {
        return "[" + paragraphInfo.getStartIndex() + ", " + paragraphInfo.getEndIndex() + ')';
    }

    public static final int findParagraphByLineIndex(List<ParagraphInfo> list, int i) {
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i10 = (i6 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i10);
            char c = paragraphInfo.getStartLineIndex() > i ? (char) 1 : paragraphInfo.getEndLineIndex() <= i ? (char) 65535 : (char) 0;
            if (c < 0) {
                i6 = i10 + 1;
            } else {
                if (c <= 0) {
                    return i10;
                }
                size = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static final int findParagraphByY(List<ParagraphInfo> list, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((ParagraphInfo) v.K0(list)).getBottom()) {
            return o.H(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i6 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i6);
            char c = paragraphInfo.getTop() > f ? (char) 1 : paragraphInfo.getBottom() <= f ? (char) 65535 : (char) 0;
            if (c < 0) {
                i = i6 + 1;
            } else {
                if (c <= 0) {
                    return i6;
                }
                size = i6 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m6178findParagraphsByRangeSbBc2M(List<ParagraphInfo> list, long j5, k kVar) {
        int size = list.size();
        for (int iFindParagraphByIndex = findParagraphByIndex(list, TextRange.m6309getMinimpl(j5)); iFindParagraphByIndex < size; iFindParagraphByIndex++) {
            ParagraphInfo paragraphInfo = list.get(iFindParagraphByIndex);
            if (paragraphInfo.getStartIndex() >= TextRange.m6308getMaximpl(j5)) {
                return;
            }
            if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                kVar.invoke(paragraphInfo);
            }
        }
    }
}
