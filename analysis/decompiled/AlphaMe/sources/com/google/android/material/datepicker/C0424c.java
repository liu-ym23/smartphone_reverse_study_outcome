package com.google.android.material.datepicker;

import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.material.datepicker.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0424c implements InterfaceC0427f {
    @Override // com.google.android.material.datepicker.InterfaceC0427f
    public final int a() {
        return 1;
    }

    @Override // com.google.android.material.datepicker.InterfaceC0427f
    public final boolean b(List list, long j4) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
            if (dateValidator != null && dateValidator.l(j4)) {
                return true;
            }
        }
        return false;
    }
}
