package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabTitleItemViewHolder f93847a;

    public n(TabTitleItemViewHolder r100) {
        this.f93847a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TabTitleItemViewHolder r101 = this.f93847a;
        MutableLiveData<Integer> r102 = r101.f93818d;
        if (r102 == null) goto L10;
        Integer r103 = r101.f93817c;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        r102.setValue(Integer.valueOf(r104));
        return;
    L7:
        r104 = 0;
        goto L8
    }
}
