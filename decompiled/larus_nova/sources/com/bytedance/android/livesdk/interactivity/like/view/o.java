package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggCountFlipperLayout f137950a;

    public o(DiggCountFlipperLayout r100) {
        this.f137950a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Iterator<ArrayList<View>> r100 = this.f137950a.f137833v.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Iterator<T> r101 = r100.next().iterator();
    L7:
        if (r101.hasNext() == false) goto L4;
        ((View) r101.next()).clearAnimation();
        goto L7
    }
}
