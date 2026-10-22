package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class F extends AbstractC0429h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C f10618i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10619j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SingleDateSelector f10620k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, v vVar, TextInputLayout textInputLayout2) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f10620k = singleDateSelector;
        this.f10618i = vVar;
        this.f10619j = textInputLayout2;
    }

    @Override // com.google.android.material.datepicker.AbstractC0429h
    public final void a() {
        this.f10619j.getError();
        this.f10620k.getClass();
        this.f10618i.a();
    }

    @Override // com.google.android.material.datepicker.AbstractC0429h
    public final void b(Long l4) {
        SingleDateSelector singleDateSelector = this.f10620k;
        if (l4 == null) {
            singleDateSelector.f10669a = null;
        } else {
            singleDateSelector.f10669a = l4;
        }
        singleDateSelector.getClass();
        this.f10618i.b(singleDateSelector.f10669a);
    }
}
