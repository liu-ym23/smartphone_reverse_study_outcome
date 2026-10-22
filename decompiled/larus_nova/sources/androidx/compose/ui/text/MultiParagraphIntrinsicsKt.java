package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiParagraphIntrinsicsKt {
    public static final /* synthetic */ List access$getLocalPlaceholders(List r100, int r101, int r102) {
        return getLocalPlaceholders(r100, r101, r102);
    }

    private static final List<AnnotatedString.Range<Placeholder>> getLocalPlaceholders(List<AnnotatedString.Range<Placeholder>> r100, int r101, int r110) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L16;
        AnnotatedString.Range r105 = (AnnotatedString.Range) ListProtector.get(r100, r104);
        if (AnnotatedStringKt.intersect(r101, r110, r105.getStart(), r105.getEnd()) == false) goto L15;
        if (r101 <= r105.getStart()) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == true) goto L14;
        InlineClassHelperKt.throwIllegalArgumentException("placeholder can not overlap with paragraph.");
    L14:
        r102.add(new AnnotatedString.Range(r105.getItem(), r105.getStart() - r101, r105.getEnd() - r101));
        goto L15
    L9:
        if (r105.getEnd() > r110) goto L11;
        r106 = true;
    L15:
        r104 = r104 + 1;
        goto L3
    L16:
        return r102;
    }
}
