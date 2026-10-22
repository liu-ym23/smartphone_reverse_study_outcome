package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public final class K extends AbstractC0906i {
    public final /* synthetic */ H i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f2416j;
    public final /* synthetic */ SingleDateSelector k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, H h, TextInputLayout textInputLayout2) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.k = singleDateSelector;
        this.i = h;
        this.f2416j = textInputLayout2;
    }

    @Override // com.google.android.material.datepicker.AbstractC0906i
    public final void a() {
        this.k.error = this.f2416j.getError();
        this.i.a();
    }

    @Override // com.google.android.material.datepicker.AbstractC0906i
    public final void b(Long l) {
        SingleDateSelector singleDateSelector = this.k;
        if (l == null) {
            singleDateSelector.clearSelection();
        } else {
            singleDateSelector.select(l.longValue());
        }
        singleDateSelector.error = null;
        this.i.b(singleDateSelector.getSelection());
    }
}
