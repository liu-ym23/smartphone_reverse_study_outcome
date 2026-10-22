package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f117692a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f117692a.f117702j.getViewTreeObserver().removeOnPreDrawListener(this);
        float r100 = this.f117692a.f117702j.getWidth();
        float r101 = this.f117692a.f117702j.getHeight();
        float r102 = this.f117692a.f117703k.getWidth();
        float r103 = this.f117692a.f117703k.getHeight();
        ViewGroup.LayoutParams r104 = this.f117692a.f117702j.getLayoutParams();
        float r105 = r102 / r100;
        float r106 = r103 / r101;
        if (r100 >= r102) goto L8;
        float r107 = r105 * r101;
        if (r107 > r103) goto L8;
        r104.width = (int) r102;
        r104.height = (int) r107;
    L12:
        this.f117692a.f117702j.setLayoutParams(r104);
        return true;
    L8:
        if (r101 >= r103) goto L12;
        float r108 = r106 * r100;
        if (r108 > r102) goto L12;
        r104.height = (int) r103;
        r104.width = (int) r108;
        goto L12
    }

    public a(b r100) {
        this.f117692a = r100;
    }
}
