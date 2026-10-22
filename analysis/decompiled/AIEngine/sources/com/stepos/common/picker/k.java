package com.stepos.common.picker;

import com.stepos.common.picker.WheelPicker;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k implements WheelPicker.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimePicker2 f6554a;

    public k(TimePicker2 timePicker2) {
        this.f6554a = timePicker2;
    }

    @Override // com.stepos.common.picker.WheelPicker.e
    public final void a(String str) {
        TimePicker2 timePicker2 = this.f6554a;
        timePicker2.f6501j = timePicker2.f6502k.equals(str);
    }
}
