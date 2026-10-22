package com.stepos.common.widget;

/* renamed from: com.stepos.common.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0497m implements z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DayTimeDatePicker f11920b;

    public /* synthetic */ C0497m(DayTimeDatePicker dayTimeDatePicker, int i4) {
        this.f11919a = i4;
        this.f11920b = dayTimeDatePicker;
    }

    @Override // com.stepos.common.widget.z
    public final void a(ScrollTextView scrollTextView) {
        switch (this.f11919a) {
            case 0:
                scrollTextView.setIsDrawFading(true);
                break;
            case 1:
                scrollTextView.setIsDrawFading(true);
                break;
            default:
                this.f11920b.setIsDrawFading(true);
                break;
        }
    }
}
