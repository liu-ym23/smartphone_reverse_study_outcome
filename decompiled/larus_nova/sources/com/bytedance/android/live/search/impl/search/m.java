package com.bytedance.android.live.search.impl.search;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100779a;

    public m(LiveSearchResultFragment r100) {
        this.f100779a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 1) goto L5;
        LiveSearchResultFragment r102 = this.f100779a;
        int r103 = LiveSearchResultFragment.f100627x;
        r102.T90(false);
    L5:
        return false;
    }
}
