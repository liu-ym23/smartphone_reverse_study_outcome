package com.stepos.widget.dialog;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\nJE\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0000\u0010\r*\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u0001H\r2\b\u0010\u000f\u001a\u0004\u0018\u0001H\r2\b\u0010\u0010\u001a\u0004\u0018\u0001H\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001aJ5\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\"¨\u0006#"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogLayoutPolicy;", "", "<init>", "()V", "availableHeight", "", "windowHeight", "topInset", "imeInset", "bottomMargin", "availableHeight$StepOSWidget_release", "orderedButtons", "", ExifInterface.GPS_DIRECTION_TRUE, "positive", "neutral", "negative", "vertical", "", "orderedButtons$StepOSWidget_release", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/util/List;", "isVertical", "count", "mode", "overflows", "legacyVertical", "isVertical$StepOSWidget_release", "headerGaps", "", "icon", "title", "subtitle", "iconGap", "textGap", "headerGaps$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDialogLayoutPolicy {
    public static final StepOSDialogLayoutPolicy INSTANCE = new StepOSDialogLayoutPolicy();

    private StepOSDialogLayoutPolicy() {
    }

    public final int availableHeight$StepOSWidget_release(int windowHeight, int topInset, int imeInset, int bottomMargin) {
        return C5685n.f(((windowHeight - topInset) - imeInset) - bottomMargin, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] headerGaps$StepOSWidget_release(boolean r2, boolean r3, boolean r4, int r5, int r6) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto L7
            if (r3 == 0) goto L7
            r0 = r5
            goto L8
        L7:
            r0 = r1
        L8:
            if (r4 != 0) goto Lc
        La:
            r5 = r1
            goto L12
        Lc:
            if (r3 == 0) goto L10
            r5 = r6
            goto L12
        L10:
            if (r2 == 0) goto La
        L12:
            int[] r1 = new int[]{r1, r0, r5}
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.dialog.StepOSDialogLayoutPolicy.headerGaps$StepOSWidget_release(boolean, boolean, boolean, int, int):int[]");
    }

    public final boolean isVertical$StepOSWidget_release(int count, int mode, boolean overflows, boolean legacyVertical) {
        if (count < 0 || count >= 4) {
            throw new IllegalArgumentException(("button count must be in 0..3 but was " + count).toString());
        }
        if (mode < 0 || mode >= 3) {
            throw new IllegalArgumentException("buttonLayout must be AUTO(0), HORIZONTAL(1) or VERTICAL(2)");
        }
        if (count == 0) {
            return false;
        }
        if (count == 1 || count == 3) {
            return true;
        }
        if (mode != 1) {
            return mode == 2 || overflows || legacyVertical;
        }
        return false;
    }

    public final <T> List<T> orderedButtons$StepOSWidget_release(T positive, T neutral, T negative, boolean vertical) {
        List<T> listR = C1173v.r(negative, neutral, positive);
        return vertical ? (listR.size() == 3 || positive == null) ? C1173v.r(positive, neutral, negative) : listR : listR;
    }
}
