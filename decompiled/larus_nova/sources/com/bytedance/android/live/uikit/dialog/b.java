package com.bytedance.android.live.uikit.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends ArrayAdapter<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecycleListView f102175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f102176b;

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        View r103 = super.getView(r100, r101, r102);
        boolean[] r104 = this.f102176b.B;
        if (r104 != null) goto L5;
    L7:
        return r103;
    L5:
        if (r104[r100] == false) goto L7;
        this.f102175a.setItemChecked(r100, true);
        goto L7
    }

    public b(a.b r100, Context r101, int r102, CharSequence[] r103, RecycleListView r104) {
        this.f102176b = r100;
        this.f102175a = r104;
        super(r101, r102, R.id.text1, r103);
    }
}
