package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningEffectListView f70545a;

    public e(TuningEffectListView r100) {
        this.f70545a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List<h> r101 = (List) r100;
        if ((!r101.isEmpty()) == false) goto L16;
        this.f70545a.setDataAndNotify(r101);
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L22;
        T r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        h r106 = (h) r104;
        if (r106.f69999a == false) goto L15;
        if (TuningEffectListView.r(this.f70545a).y2(r106) < 0) goto L15;
        TuningEffectListView r107 = this.f70545a;
        r107.smoothScrollToPosition(TuningEffectListView.r(r107).y2(r106));
        return;
    L15:
        r103 = r105;
        goto L6
    L22:
        return;
    }
}
