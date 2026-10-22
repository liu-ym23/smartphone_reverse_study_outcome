package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final a ALL_OPERATOR = null;
    private static final a ANY_OPERATOR = null;
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;
    private final a operator;
    private final List<CalendarConstraints.DateValidator> validators;

    private interface a {
        int a();

        boolean a(List<CalendarConstraints.DateValidator> r1, long r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CompositeDateValidator(List r2, a r3, AnonymousClass1 r4) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ a access$000() {
        return ALL_OPERATOR;
    }

    static /* synthetic */ a access$100() {
        return ANY_OPERATOR;
    }

    static {
        ANY_OPERATOR = new AnonymousClass1();
        ALL_OPERATOR = new AnonymousClass2();
        CREATOR = new AnonymousClass3();
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> r3, a r4) {
        List<CalendarConstraints.DateValidator> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        this.validators = r5;
        this.operator = r6;
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> r2) {
        return new CompositeDateValidator((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), ALL_OPERATOR);
    }

    public static CalendarConstraints.DateValidator anyOf(List<CalendarConstraints.DateValidator> r2) {
        return new CompositeDateValidator((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), ANY_OPERATOR);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r2) {
        return this.operator.a(this.validators, r2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeList(this.validators);
        r1.writeInt(this.operator.a());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CompositeDateValidator.class) == true) goto L8;
        return false;
    L8:
        CompositeDateValidator r6 = (CompositeDateValidator) ZeusTransformUtils.preCheckCast(r5, CompositeDateValidator.class, "com.obric.aiagent.plugin");
        if (this.validators.equals(r6.validators) == false) goto L14;
        if (this.operator.a() != r6.operator.a()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }
}
