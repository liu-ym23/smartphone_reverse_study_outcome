package com.android.ttcjpaysdk.base.ui.Utils;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayViewTouchUtils;", "", "()V", "increaseTouchArea", "", "parent", "Landroid/view/View;", "view", "extraPadding", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayViewTouchUtils {
    public static final CJPayViewTouchUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayViewTouchUtils();
    }

    private CJPayViewTouchUtils() {
    }

    public final void increaseTouchArea(final View r100, final View r101, final int r102) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.post(new AnonymousClass1(r101, r102, r100));
        return;
    L8:
        return;
    }
}
