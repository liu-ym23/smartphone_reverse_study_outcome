package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class g0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterestSectionProvider.InterestPanelController.InterestKpViewBinder.InterestKpViewHolder f135880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f135881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.model.a f135882c;

    public g0(InterestSectionProvider.InterestPanelController.InterestKpViewBinder.InterestKpViewHolder r100, int r101, com.bytedance.android.livesdk.interactivity.comment.model.a r102) {
        this.f135880a = r100;
        this.f135881b = r101;
        this.f135882c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        List<Integer> r101 = this.f135880a.f135674b.f135672c.f135660l;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(Integer.valueOf(this.f135881b)) == false) goto L8;
        List<Integer> r103 = this.f135880a.f135674b.f135672c.f135660l;
        ArrayList r104 = (ArrayList) r103;
        r104.remove(Integer.valueOf(this.f135881b));
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r105 = this.f135880a.f135674b.f135672c.h();
        if (r105 == null) goto L12;
        r105.remove(this.f135882c);
    L12:
        this.f135880a.f135674b.f135672c.f135666r.notifyItemChanged(this.f135881b);
        int r106 = com.bytedance.android.livesdk.interactivity.comment.utils.i.f136260a;
        com.bytedance.android.livesdk.interactivity.comment.model.a r107 = this.f135882c;
        List<Integer> r108 = this.f135880a.f135674b.f135672c.f135660l;
        ArrayList r109 = (ArrayList) r108;
        com.bytedance.android.livesdk.interactivity.comment.utils.i.a(r107, r109.contains(Integer.valueOf(this.f135881b)), true);
        return;
    L8:
        if (((ArrayList) this.f135880a.f135674b.f135672c.f135660l).size() >= this.f135880a.f135674b.f135672c.f135659k.intValue()) goto L14;
        this.f135880a.f135674b.f135671b.invoke(this.f135882c);
        List<Integer> r110 = this.f135880a.f135674b.f135672c.f135660l;
        ArrayList r111 = (ArrayList) r110;
        r111.add(Integer.valueOf(this.f135881b));
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r112 = this.f135880a.f135674b.f135672c.h();
        if (r112 == null) goto L12;
        r112.add(this.f135882c);
        goto L12
    }
}
