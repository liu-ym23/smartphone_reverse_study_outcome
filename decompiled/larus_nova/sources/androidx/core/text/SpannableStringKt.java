package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", FilterData.FilterOptionItem.Type.RANGE, "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringKt {
    public static final void clearSpans(Spannable r100) {
        int r101 = 0;
        Object[] r102 = r100.getSpans(0, r100.length(), Object.class);
        int r103 = r102.length;
    L3:
        if (r101 >= r103) goto L5;
        r100.removeSpan(r102[r101]);
        r101 = r101 + 1;
        goto L3
    }

    public static final Spannable toSpannable(CharSequence r100) {
        return SpannableString.valueOf(r100);
    }

    public static final void set(Spannable r100, IntRange r101, Object r102) {
        r100.setSpan(r102, r101.getStart().intValue(), r101.getEndInclusive().intValue(), 17);
    }

    public static final void set(Spannable r100, int r101, int r102, Object r103) {
        r100.setSpan(r103, r101, r102, 17);
    }
}
