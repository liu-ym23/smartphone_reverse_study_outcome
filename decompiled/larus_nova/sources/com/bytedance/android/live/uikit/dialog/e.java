package com.bytedance.android.live.uikit.dialog;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecycleListView f102184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f102185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.b f102186c;

    public e(a.b r100, RecycleListView r101, a r102) {
        this.f102186c = r100;
        this.f102184a = r101;
        this.f102185b = r102;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        boolean[] r104 = this.f102186c.B;
        if (r104 == null) goto L5;
        r104[r102] = this.f102184a.isItemChecked(r102);
    L5:
        this.f102186c.F.onClick(this.f102185b.f102121b, r102, this.f102184a.isItemChecked(r102));
    }
}
