package com.obric.ui;

import android.view.MotionEvent;
import android.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListTouchHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/obric/ui/ListTouchHelper;", "", "()V", "isTouchOnFooterOrBlank", "", "listView", "Landroid/widget/ListView;", "event", "Landroid/view/MotionEvent;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListTouchHelper {
    public static final ListTouchHelper INSTANCE = null;

    static {
        INSTANCE = new ListTouchHelper();
    }

    private ListTouchHelper() {
    }

    @JvmStatic
    public static final boolean isTouchOnFooterOrBlank(ListView r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r3 != null) goto L5;
        return false;
    L5:
        int r5 = r3.pointToPosition((int) r4.getX(), (int) r4.getY());
        int r1 = r3.getFooterViewsCount();
        int r6 = r3.getCount();
        if (r5 == (-1)) goto L10;
        if (r1 > 0) goto L9;
        return false;
    L9:
        if (r5 >= (r6 - r1)) goto L10;
        return false;
    L10:
        return true;
    }
}
