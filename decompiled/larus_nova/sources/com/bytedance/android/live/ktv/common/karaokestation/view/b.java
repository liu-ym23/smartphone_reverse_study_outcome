package com.bytedance.android.live.ktv.common.karaokestation.view;

import androidx.viewpager.widget.ViewPager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonOrderSongDialog f69613a;

    public b(CommonOrderSongDialog r100) {
        this.f69613a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 == null) goto L28;
        int r102 = ((Number) r101.component1()).intValue();
        Iterator r103 = ((ArrayList) this.f69613a.f69593d).iterator();
        int r104 = 0;
    L7:
        if (r103.hasNext() == false) goto L15;
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r103.next()).VL().getValue() != r102) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L16;
        r104 = r104 + 1;
    L16:
        ViewPager r106 = this.f69613a.f69602m;
        if (r106 != null) goto L19;
    L20:
        ViewPager r107 = this.f69613a.f69602m;
        if (r107 == null) goto L27;
        r107.setCurrentItem(r104, false);
        return;
    L27:
        return;
    L19:
        if (r106.getCurrentItem() != r104) goto L20;
        return;
    L11:
        r105 = false;
        goto L12
    L15:
        r104 = -1;
        goto L16
    }
}
