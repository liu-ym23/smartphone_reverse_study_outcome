package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes4.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f35813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f35815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f35816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f35817e;
    int f;
    int g;
    boolean h;
    boolean i;

    boolean a(RecyclerView.s r1) {
        int r0 = this.f35815c;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= r1.e()) goto L7;
        return true;
    }

    View a(RecyclerView.o r3) {
        View r4 = r3.c(this.f35815c);
        this.f35815c += this.f35816d;
        return r4;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f35814b + ", mCurrentPosition=" + this.f35815c + ", mItemDirection=" + this.f35816d + ", mLayoutDirection=" + this.f35817e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
