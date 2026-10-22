package com.bytedance.android.live.search.impl.search;

import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;

/* JADX INFO: loaded from: classes47.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100781a;

    public o(LiveSearchResultFragment r100) {
        this.f100781a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveSearchResultFragment r101 = this.f100781a;
        int r102 = LiveSearchResultFragment.f100627x;
        r101.Z90(false, true);
        LiveSearchIntermediateView r103 = this.f100781a.f100629d;
        if (r103 == null) goto L7;
        LiveSearchIntermediateViewModel r104 = r103.f100619a;
        if (r104 == null) goto L7;
        r104.hideIntermediate();
    L7:
        EditText r105 = this.f100781a.f100632g;
        if (r105 == null) goto L10;
        r105.setText("");
    L10:
        View r106 = this.f100781a.f100639n;
        if (r106 == null) goto L13;
        r106.setVisibility(8);
    L13:
        int r107 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.f100781a.f100632g);
        EditText r108 = this.f100781a.f100632g;
        if (r108 == null) goto L16;
        r108.setCursorVisible(false);
    L16:
        this.f100781a.f100640o = "";
    }
}
