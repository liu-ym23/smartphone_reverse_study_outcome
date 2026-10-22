package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import io.reactivex.functions.Action;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggCountFlipperLayout f137953a;

    public q(DiggCountFlipperLayout r100) {
        this.f137953a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Iterator<T> r100 = this.f137953a.f137830s.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((View) r100.next()).clearAnimation();
        goto L4
    L6:
        Iterator<T> r101 = this.f137953a.f137831t.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((View) r101.next()).clearAnimation();
        goto L8
    }
}
