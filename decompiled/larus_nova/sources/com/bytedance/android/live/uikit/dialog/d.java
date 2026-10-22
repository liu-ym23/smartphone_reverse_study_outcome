package com.bytedance.android.live.uikit.dialog;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f102182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f102183b;

    public d(a.b r100, a r101) {
        this.f102183b = r100;
        this.f102182a = r101;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        this.f102183b.f102167t.onClick(this.f102182a.f102121b, r102);
        if (this.f102183b.D == true) goto L6;
        this.f102182a.f102121b.dismiss();
        return;
    }
}
