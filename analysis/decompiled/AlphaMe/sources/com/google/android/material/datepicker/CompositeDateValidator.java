package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0427f f10608a;

    /* renamed from: b, reason: collision with root package name */
    public final List f10609b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0424c f10606c = new C0424c();

    /* renamed from: d, reason: collision with root package name */
    public static final C0425d f10607d = new C0425d();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new C0426e();

    public CompositeDateValidator(ArrayList arrayList, InterfaceC0427f interfaceC0427f) {
        this.f10609b = arrayList;
        this.f10608a = interfaceC0427f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f10609b.equals(compositeDateValidator.f10609b) && this.f10608a.a() == compositeDateValidator.f10608a.a();
    }

    public final int hashCode() {
        return this.f10609b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean l(long j4) {
        return this.f10608a.b(this.f10609b, j4);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f10609b);
        parcel.writeInt(this.f10608a.a());
    }
}
