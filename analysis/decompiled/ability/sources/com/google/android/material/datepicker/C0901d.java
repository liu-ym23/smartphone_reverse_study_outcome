package com.google.android.material.datepicker;

import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.material.datepicker.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0901d implements InterfaceC0904g {
    @Override // com.google.android.material.datepicker.InterfaceC0904g
    public final boolean a(List list, long j5) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && dateValidator.isValid(j5)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.InterfaceC0904g
    public final int getId() {
        return 1;
    }
}
