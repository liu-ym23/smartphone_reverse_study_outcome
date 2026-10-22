package com.stepos.common.picker;

/* loaded from: classes3.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DatePicker2 f3586a;

    public a(DatePicker2 datePicker2) {
        this.f3586a = datePicker2;
    }

    @Override // com.stepos.common.picker.s
    public final void a(String str) {
        DatePicker2 datePicker2 = this.f3586a;
        datePicker2.d = DatePicker2.a(datePicker2, str, datePicker2.d);
        DatePicker2.b(datePicker2);
    }
}
