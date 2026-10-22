package com.google.android.material.datepicker;

import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* renamed from: com.google.android.material.datepicker.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0913p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2432a;
    public int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ RunnableC0913p(Object obj, int i, int i6) {
        this.f2432a = i6;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2432a) {
            case 0:
                ((MaterialCalendar) this.c).f2417j.smoothScrollToPosition(this.b);
                break;
            case 1:
                ((com.google.android.material.slider.f) this.c).h.sendEventForVirtualView(this.b, 4);
                break;
            default:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.c;
                popupNestedScrollingLayout.g(this.b - popupNestedScrollingLayout.p);
                break;
        }
    }

    public RunnableC0913p(com.google.android.material.slider.f fVar) {
        this.f2432a = 1;
        this.c = fVar;
        this.b = -1;
    }
}
