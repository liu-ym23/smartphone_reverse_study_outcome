package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public final class J extends AbstractC0906i {
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f2415j;
    public final /* synthetic */ TextInputLayout k;
    public final /* synthetic */ H l;
    public final /* synthetic */ RangeDateSelector m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, H h, int i) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.i = i;
        this.m = rangeDateSelector;
        this.f2415j = textInputLayout2;
        this.k = textInputLayout3;
        this.l = h;
    }

    @Override // com.google.android.material.datepicker.AbstractC0906i
    public final void a() {
        switch (this.i) {
            case 0:
                RangeDateSelector rangeDateSelector = this.m;
                rangeDateSelector.proposedTextStart = null;
                rangeDateSelector.updateIfValidTextProposal(this.f2415j, this.k, this.l);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.m;
                rangeDateSelector2.proposedTextEnd = null;
                rangeDateSelector2.updateIfValidTextProposal(this.f2415j, this.k, this.l);
                break;
        }
    }

    @Override // com.google.android.material.datepicker.AbstractC0906i
    public final void b(Long l) {
        switch (this.i) {
            case 0:
                RangeDateSelector rangeDateSelector = this.m;
                rangeDateSelector.proposedTextStart = l;
                rangeDateSelector.updateIfValidTextProposal(this.f2415j, this.k, this.l);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.m;
                rangeDateSelector2.proposedTextEnd = l;
                rangeDateSelector2.updateIfValidTextProposal(this.f2415j, this.k, this.l);
                break;
        }
    }
}
