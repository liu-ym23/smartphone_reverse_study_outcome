package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;

/* renamed from: com.google.android.material.datepicker.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0426e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
        int i4 = parcel.readInt();
        InterfaceC0427f interfaceC0427f = CompositeDateValidator.f10607d;
        if (i4 != 2 && i4 == 1) {
            interfaceC0427f = CompositeDateValidator.f10606c;
        }
        arrayList.getClass();
        return new CompositeDateValidator(arrayList, interfaceC0427f);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new CompositeDateValidator[i4];
    }
}
