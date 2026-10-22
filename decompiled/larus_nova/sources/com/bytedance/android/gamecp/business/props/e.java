package com.bytedance.android.gamecp.business.props;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PropAccountListAdapter f56344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PropAccountListAdapter.PropAccountListViewHolder f56345b;

    public e(PropAccountListAdapter r100, PropAccountListAdapter.PropAccountListViewHolder r101) {
        this.f56344a = r100;
        this.f56345b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function2<? super Integer, ? super wt.c, Unit> r101 = this.f56344a.f56296b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Integer.valueOf(this.f56345b.getAdapterPosition()), ListProtector.get(this.f56344a.f56295a, this.f56345b.getAdapterPosition()));
        return;
    }
}
