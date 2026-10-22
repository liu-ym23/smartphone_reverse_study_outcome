package com.stepos.common.picker;

import com.stepos.common.picker.WheelPicker;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements WheelPicker.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DatePicker2 f6533a;

    public c(DatePicker2 datePicker2) {
        this.f6533a = datePicker2;
    }

    @Override // com.stepos.common.picker.WheelPicker.e
    public final void a(String str) {
        DatePicker2 datePicker2 = this.f6533a;
        datePicker2.h = DatePicker2.a(datePicker2, str, datePicker2.h);
    }
}
