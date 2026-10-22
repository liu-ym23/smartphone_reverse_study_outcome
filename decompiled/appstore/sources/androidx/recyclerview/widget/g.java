package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4421i;

    public g() {
        this.f4413a = true;
        this.f4418f = 0;
        this.f4419g = 0;
    }

    public boolean a(RecyclerView.State r10) {
        int r11 = this.f4415c;
        if (r11 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r11 >= r10.c()) goto L7;
        return true;
    }

    public View b(RecyclerView.Recycler r10) {
        View r11 = r10.o(this.f4415c);
        this.f4415c += this.f4416d;
        return r11;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4414b + ", mCurrentPosition=" + this.f4415c + ", mItemDirection=" + this.f4416d + ", mLayoutDirection=" + this.f4417e + ", mStartLine=" + this.f4418f + ", mEndLine=" + this.f4419g + '}';
    }
}
