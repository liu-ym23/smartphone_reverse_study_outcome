package com.stepos.common.widget;

/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11970a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f11971b;

    public /* synthetic */ v(ScrollTextView scrollTextView, int i4) {
        this.f11970a = i4;
        this.f11971b = scrollTextView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f11970a;
        ScrollTextView scrollTextView = this.f11971b;
        switch (i4) {
            case 0:
                if (scrollTextView.f11758k) {
                    scrollTextView.postInvalidate();
                } else {
                    scrollTextView.postDelayed(scrollTextView.f11743J, 10L);
                }
                scrollTextView.postInvalidate();
                break;
            default:
                scrollTextView.f11738E = scrollTextView.getWidth() / 2.0f;
                if (!scrollTextView.f11758k) {
                    scrollTextView.postDelayed(scrollTextView.f11743J, 10L);
                    break;
                } else {
                    scrollTextView.postInvalidate();
                    break;
                }
        }
    }
}
