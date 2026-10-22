package z8;

import android.util.SparseArray;
import com.bytedanceos.common.model.ClickCode;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f26307a = null;

    static {
        f26307a = new SparseArray();
    }

    public static void a(int r10, int... r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.length <= 0) goto L17;
        ClickCode r12 = new ClickCode(r10, r11);
        int r13 = 0;
    L7:
        if (r13 >= r11.length) goto L18;
        SparseArray r14 = f26307a;
        if (r14.get(r11[r13]) == null) goto L11;
        j.m("ClickType[" + r11[r13] + "] has been registed with CellKey[" + ((ClickCode) r14.get(r11[0])).cellKey() + "] and cannot registe again with CellKey[" + r10 + "]");
    L12:
        r13 = r13 + 1;
        goto L7
    L11:
        r14.put(r11[r13], r12);
        goto L12
    L18:
        return;
    }
}
