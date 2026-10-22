package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvFeedbackDialog f70164a;

    public d(KtvFeedbackDialog r100) {
        this.f70164a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        KtvFeedbackDialog r102 = this.f70164a;
        int r103 = KtvFeedbackDialog.f70132u;
        if (r101 == null) goto L15;
        KtvFeedbackComponentView r104 = (KtvFeedbackComponentView) r102.X90(R.id.feedback_categories);
        List r105 = r101;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        r106.add(((com.bytedance.android.livesdk.rank.model.b) r107.next()).getCategory());
        goto L6
    L8:
        r104.setData(r106);
        if (r102.f70145s == false) goto L11;
    L14:
        ((LinearLayout) r102.X90(R.id.feedback_container)).setVisibility(0);
        return;
    L11:
        if (r102.f70146t == false) goto L14;
        ((LinearLayout) r102.X90(R.id.feedback_container)).setVisibility(8);
        return;
    L15:
        r102.getClass();
    }
}
