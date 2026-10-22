package com.stepos.common.picker;

/* loaded from: classes3.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3587a;
    public final /* synthetic */ DatePicker2 b;

    public /* synthetic */ b(DatePicker2 datePicker2, int i) {
        this.f3587a = i;
        this.b = datePicker2;
    }

    @Override // com.stepos.common.picker.s
    public final void a(String str) {
        switch (this.f3587a) {
            case 0:
                DatePicker2 datePicker2 = this.b;
                datePicker2.e = DatePicker2.a(datePicker2, str, datePicker2.e);
                DatePicker2.b(datePicker2);
                break;
            default:
                DatePicker2 datePicker22 = this.b;
                datePicker22.f = DatePicker2.a(datePicker22, str, datePicker22.f);
                break;
        }
    }
}
