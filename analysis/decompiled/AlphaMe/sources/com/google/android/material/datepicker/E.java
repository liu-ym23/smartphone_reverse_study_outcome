package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class E extends AbstractC0429h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f10613i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10614j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10615k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C f10616l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f10617m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ E(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, v vVar, int i4) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f10613i = i4;
        this.f10617m = rangeDateSelector;
        this.f10614j = textInputLayout2;
        this.f10615k = textInputLayout3;
        this.f10616l = vVar;
    }

    @Override // com.google.android.material.datepicker.AbstractC0429h
    public final void a() {
        int i4 = this.f10613i;
        TextInputLayout textInputLayout = this.f10614j;
        C c4 = this.f10616l;
        TextInputLayout textInputLayout2 = this.f10615k;
        RangeDateSelector rangeDateSelector = this.f10617m;
        switch (i4) {
            case 0:
                rangeDateSelector.f10667d = null;
                RangeDateSelector.c(rangeDateSelector, textInputLayout, textInputLayout2, c4);
                break;
            default:
                rangeDateSelector.f10668e = null;
                RangeDateSelector.c(rangeDateSelector, textInputLayout, textInputLayout2, c4);
                break;
        }
    }

    @Override // com.google.android.material.datepicker.AbstractC0429h
    public final void b(Long l4) {
        int i4 = this.f10613i;
        TextInputLayout textInputLayout = this.f10614j;
        C c4 = this.f10616l;
        TextInputLayout textInputLayout2 = this.f10615k;
        RangeDateSelector rangeDateSelector = this.f10617m;
        switch (i4) {
            case 0:
                rangeDateSelector.f10667d = l4;
                RangeDateSelector.c(rangeDateSelector, textInputLayout, textInputLayout2, c4);
                break;
            default:
                rangeDateSelector.f10668e = l4;
                RangeDateSelector.c(rangeDateSelector, textInputLayout, textInputLayout2, c4);
                break;
        }
    }
}
