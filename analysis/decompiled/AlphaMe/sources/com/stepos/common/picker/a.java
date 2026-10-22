package com.stepos.common.picker;

import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f11369b;

    public /* synthetic */ a(FrameLayout frameLayout, int i4) {
        this.f11368a = i4;
        this.f11369b = frameLayout;
    }

    @Override // com.stepos.common.picker.s
    public final void a(String str) {
        int i4 = this.f11368a;
        FrameLayout frameLayout = this.f11369b;
        switch (i4) {
            case 0:
                DatePicker2 datePicker2 = (DatePicker2) frameLayout;
                datePicker2.f11315d = DatePicker2.a(datePicker2, str, datePicker2.f11315d);
                DatePicker2.b(datePicker2);
                break;
            case 1:
                DatePicker2 datePicker22 = (DatePicker2) frameLayout;
                datePicker22.f11316e = DatePicker2.a(datePicker22, str, datePicker22.f11316e);
                DatePicker2.b(datePicker22);
                break;
            case 2:
                DatePicker2 datePicker23 = (DatePicker2) frameLayout;
                datePicker23.f11317f = DatePicker2.a(datePicker23, str, datePicker23.f11317f);
                break;
            default:
                TimePicker2 timePicker2 = (TimePicker2) frameLayout;
                timePicker2.f11333g = timePicker2.f11334h.equals(str);
                timePicker2.a(timePicker2, timePicker2.f11330d, timePicker2.f11331e);
                break;
        }
    }
}
