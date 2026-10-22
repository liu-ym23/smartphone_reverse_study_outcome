package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMusicFeedbackDialog f70168a;

    public h(KtvMusicFeedbackDialog r100) {
        this.f70168a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 != null) goto L5;
    L14:
        KtvMusicFeedbackDialog r102 = this.f70168a;
        int r103 = KtvMusicFeedbackDialog.f70149o;
        r102.getClass();
        Unit r104 = Unit.INSTANCE;
        return;
    L5:
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L14;
        KtvFeedbackComponentView r105 = (KtvFeedbackComponentView) this.f70168a.X90(R.id.feedback_categories);
        List r106 = r101;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        r107.add(((com.bytedance.android.livesdk.rank.model.b) r108.next()).getCategory());
        goto L11
    L13:
        r105.setData(r107);
    }
}
