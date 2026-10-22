package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryTabViewHolder f96281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y31.a.C8301a f96282b;

    public a(HistoryTabViewHolder r100, y31.a.C8301a r101) {
        this.f96281a = r100;
        this.f96282b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        y31.a.C8301a r101 = this.f96281a.f96098a;
        if (r101 == null) goto L13;
        y31.b r102 = r101.f565733c;
        if (r102 == null) goto L13;
        if (r101 == null) goto L8;
        int r103 = r101.f565732b;
    L9:
        String r104 = this.f96282b.f565731a;
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        r102.K(r103, r104);
        goto L13
    L8:
        r103 = 0;
    L13:
        TextView r105 = this.f96281a.f96099b;
        if (r105 == null) goto L16;
        r105.setBackground(s1.m(R.drawable.ttlive_pk_record_select_drawable));
    L16:
        TextView r106 = this.f96281a.f96099b;
        if (r106 == null) goto L20;
        r106.setTextColor(s1.h(R.color.black));
        return;
    }
}
