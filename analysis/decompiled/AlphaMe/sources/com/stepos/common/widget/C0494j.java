package com.stepos.common.widget;

/* renamed from: com.stepos.common.widget.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0494j implements z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11916a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DatePicker f11917b;

    public /* synthetic */ C0494j(DatePicker datePicker, int i4) {
        this.f11916a = i4;
        this.f11917b = datePicker;
    }

    @Override // com.stepos.common.widget.z
    public final void a(ScrollTextView scrollTextView) {
        switch (this.f11916a) {
            case 0:
                scrollTextView.setIsDrawFading(true);
                break;
            case 1:
                scrollTextView.setIsDrawFading(true);
                break;
            default:
                this.f11917b.setIsDrawFading(true);
                break;
        }
    }
}
