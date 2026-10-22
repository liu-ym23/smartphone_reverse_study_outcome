package com.bytedance.android.live.search.impl.search;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100784a;

    public r(LiveSearchResultFragment r100) {
        this.f100784a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L12;
        EditText r102 = this.f100784a.f100632g;
        if (r102 == null) goto L7;
        r102.setText(r101);
    L7:
        EditText r103 = this.f100784a.f100632g;
        if (r103 == null) goto L10;
        r103.setSelection(r101.length());
    L10:
        int r104 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.b(this.f100784a.f100632g);
        return;
    }
}
