package com.bytedance.android.ecom.arch.slice.render.util;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes44.dex */
public final class SliceElementDiffKt {
    public static final void a(DiffUtil.DiffResult r100, ListUpdateCallback r101, final boolean r102) {
        final ArrayList r103 = new ArrayList();
        r100.dispatchUpdatesTo(new SliceElementDiffKt$slcDispatchUpdatesTo$1(r103, r102));
        int r104 = r103.size() - 1;
    L3:
        if (r104 < 0) goto L31;
        a r105 = (a) ListProtector.get(r103, r104);
        int r106 = r105.f50710a;
        int r107 = 0;
        if (r106 != 1) goto L7;
        r101.onInserted(r105.f50711b, r105.f50712c);
        int r108 = r103.size();
    L22:
        if (r107 >= r108) goto L30;
        a r109 = (a) ListProtector.get(r103, r107);
        if (r109 == r105) goto L30;
        int r110 = r105.f50711b;
        int r111 = r109.f50711b;
        if (r110 > r111) goto L29;
        r109.f50711b = r111 + r105.f50712c;
    L29:
        r107 = r107 + 1;
    L30:
        r104 = r104 - 1;
        goto L3
    L7:
        if (r106 != 2) goto L9;
        r101.onRemoved(r105.f50711b, r105.f50712c);
        int r112 = r103.size();
    L13:
        if (r107 >= r112) goto L30;
        a r113 = (a) ListProtector.get(r103, r107);
        if (r113 == r105) goto L30;
        int r114 = r105.f50711b;
        int r115 = r113.f50711b;
        if (r114 >= r115) goto L20;
        r113.f50711b = r115 - r105.f50712c;
    L20:
        r107 = r107 + 1;
        goto L13
    L9:
        if (r106 != 3) goto L30;
        r101.onChanged(r105.f50711b, r105.f50712c, r105.f50713d);
        goto L30
    }
}
