package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final Operator ALL_OPERATOR = null;
    private static final Operator ANY_OPERATOR = null;
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;

    @NonNull
    private final Operator operator;

    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;

    public interface Operator {
        int getId();

        boolean isValid(@NonNull List<CalendarConstraints.DateValidator> r10, long r11);
    }

    static {
        ANY_OPERATOR = new AnonymousClass1();
        ALL_OPERATOR = new AnonymousClass2();
        CREATOR = new AnonymousClass3();
    }

    public /* synthetic */ CompositeDateValidator(List r10, Operator r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static /* synthetic */ Operator access$000() {
        return ALL_OPERATOR;
    }

    public static /* synthetic */ Operator access$100() {
        return ANY_OPERATOR;
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> r10) {
        return new CompositeDateValidator(r10, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints.DateValidator anyOf(@NonNull List<CalendarConstraints.DateValidator> r10) {
        return new CompositeDateValidator(r10, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CompositeDateValidator) == true) goto L8;
        return false;
    L8:
        CompositeDateValidator r11 = (CompositeDateValidator) r10;
        if (this.validators.equals(r11.validators) == false) goto L14;
        if (this.operator.getId() != r11.operator.getId()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r10) {
        return this.operator.isValid(this.validators, r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeList(this.validators);
        r10.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> r10, Operator r11) {
        this.validators = r10;
        this.operator = r11;
    }
}
