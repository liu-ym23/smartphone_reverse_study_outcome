package com.stepos.common.widget;

/* loaded from: classes3.dex */
public final class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3623a;
    public final /* synthetic */ ScrollTextView b;

    public /* synthetic */ B(ScrollTextView scrollTextView, int i) {
        this.f3623a = i;
        this.b = scrollTextView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3623a) {
            case 0:
                ScrollTextView scrollTextView = this.b;
                if (scrollTextView.k) {
                    scrollTextView.postInvalidate();
                } else {
                    scrollTextView.postDelayed(scrollTextView.f3749N, 10L);
                }
                scrollTextView.postInvalidate();
                break;
            default:
                ScrollTextView scrollTextView2 = this.b;
                scrollTextView2.E = scrollTextView2.getWidth() / 2.0f;
                if (!scrollTextView2.k) {
                    scrollTextView2.postDelayed(scrollTextView2.f3749N, 10L);
                    break;
                } else {
                    scrollTextView2.postInvalidate();
                    break;
                }
        }
    }
}
