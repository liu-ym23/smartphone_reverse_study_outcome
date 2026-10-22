package com.bytedance.android.gamecp.business.props;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CouponAdapter f56342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CouponAdapter.CouponViewHolder f56343b;

    public a(CouponAdapter r100, CouponAdapter.CouponViewHolder r101) {
        this.f56342a = r100;
        this.f56343b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Boolean r101 = ((wt.m) ListProtector.get(this.f56342a.f56276b, this.f56343b.getAdapterPosition())).isDefault;
        int r102 = 0;
        if (r101 == null) goto L5;
        boolean r103 = r101.booleanValue();
    L6:
        ((wt.m) ListProtector.get(this.f56342a.f56276b, this.f56343b.getAdapterPosition())).isDefault = Boolean.valueOf(!r103);
        if (Intrinsics.areEqual(((wt.m) ListProtector.get(this.f56342a.f56276b, this.f56343b.getAdapterPosition())).isDefault, Boolean.TRUE) == false) goto L14;
        int r104 = this.f56342a.f56276b.size();
    L9:
        if (r102 >= r104) goto L14;
        if (r102 == this.f56343b.getAdapterPosition()) goto L13;
        ((wt.m) ListProtector.get(this.f56342a.f56276b, r102)).isDefault = Boolean.FALSE;
    L13:
        r102 = r102 + 1;
    L14:
        this.f56342a.f56279e.invoke(Integer.valueOf(this.f56343b.getAdapterPosition()), Boolean.valueOf(!r103));
        CouponAdapter r105 = this.f56342a;
        r105.f56275a = true;
        r105.notifyDataSetChanged();
        return;
    L5:
        r103 = false;
        goto L6
    }
}
