package com.stepos.common.widget;

import android.widget.FrameLayout;

/* renamed from: com.stepos.common.widget.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1110o implements D {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3811a;
    public final /* synthetic */ FrameLayout b;

    public /* synthetic */ C1110o(FrameLayout frameLayout, int i) {
        this.f3811a = i;
        this.b = frameLayout;
    }

    @Override // com.stepos.common.widget.D
    public final void a(ScrollTextView scrollTextView) {
        switch (this.f3811a) {
            case 0:
                ((DatePicker) this.b).setIsDrawFading(true);
                break;
            default:
                ((DayTimeDatePicker) this.b).setIsDrawFading(true);
                break;
        }
    }
}
