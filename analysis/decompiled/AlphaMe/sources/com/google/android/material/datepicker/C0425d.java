package com.google.android.material.datepicker;

import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.material.datepicker.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0425d implements InterfaceC0427f {
    @Override // com.google.android.material.datepicker.InterfaceC0427f
    public final int a() {
        return 2;
    }

    @Override // com.google.android.material.datepicker.InterfaceC0427f
    public final boolean b(List list, long j4) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && !dateValidator.l(j4)) {
                return false;
            }
        }
        return true;
    }
}
