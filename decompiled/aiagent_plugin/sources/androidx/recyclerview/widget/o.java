package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2567e;
    int f;
    int g;
    boolean h;
    boolean i;

    o() {
        this.f2563a = true;
        this.f = 0;
        this.g = 0;
    }

    boolean a(RecyclerView.r r1) {
        int r0 = this.f2565c;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= r1.e()) goto L7;
        return true;
    }

    View a(RecyclerView.n r3) {
        View r4 = r3.c(this.f2565c);
        this.f2565c += this.f2566d;
        return r4;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2564b + ", mCurrentPosition=" + this.f2565c + ", mItemDirection=" + this.f2566d + ", mLayoutDirection=" + this.f2567e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
