package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000b\u001a\u0013\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u0015"}, d2 = {"substring", "", "", FilterData.FilterOptionItem.Type.RANGE, "Landroidx/compose/ui/text/TextRange;", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "TextRange", "start", "", "end", "(II)J", "index", "(I)J", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "packWithCheck", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextRangeKt {
    public static final long TextRange(int r100) {
        return TextRange(r100, r100);
    }

    public static final long TextRange(int r100, int r101) {
        return TextRange.m6987constructorimpl(packWithCheck(r100, r101));
    }

    private static final long packWithCheck(int r100, int r101) {
        if (r100 < 0) goto L5;
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("start and end cannot be negative. [start: " + r100 + ", end: " + r101 + ']');
    L9:
        return (((long) r101) & BodyPartID.bodyIdMax) | (((long) r100) << 32);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m7005substringFDrldGo(CharSequence r100, long r101) {
        return r100.subSequence(TextRange.m6996getMinimpl(r101), TextRange.m6995getMaximpl(r101)).toString();
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m7004coerceIn8ffj60Q(long r100, int r101, int r102) {
        int r103 = TextRange.m6998getStartimpl(r100);
        if (r103 >= r101) goto L5;
        r103 = r101;
    L5:
        if (r103 <= r102) goto L7;
        r103 = r102;
    L7:
        int r104 = TextRange.m6993getEndimpl(r100);
        if (r104 < r101) goto L11;
        r101 = r104;
    L11:
        if (r101 > r102) goto L15;
        r102 = r101;
    L15:
        if (r103 != TextRange.m6998getStartimpl(r100)) goto L21;
        if (r102 != TextRange.m6993getEndimpl(r100)) goto L21;
        return r100;
    L21:
        return TextRange(r103, r102);
    }
}
