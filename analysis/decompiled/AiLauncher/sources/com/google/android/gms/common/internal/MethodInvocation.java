package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new A();
    private final int zaa;
    private final int zab;
    private final int zac;
    private final long zad;
    private final long zae;
    private final String zaf;
    private final String zag;
    private final int zah;
    private final int zai;

    @Deprecated
    public MethodInvocation(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13) {
        this(i10, i11, i12, j10, j11, str, str2, i13, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.p(parcel, 2, this.zab);
        C5047a.p(parcel, 3, this.zac);
        C5047a.r(parcel, 4, this.zad);
        C5047a.r(parcel, 5, this.zae);
        C5047a.x(parcel, 6, this.zaf, false);
        C5047a.x(parcel, 7, this.zag, false);
        C5047a.p(parcel, 8, this.zah);
        C5047a.p(parcel, 9, this.zai);
        C5047a.b(parcel, iA);
    }

    public MethodInvocation(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = i12;
        this.zad = j10;
        this.zae = j11;
        this.zaf = str;
        this.zag = str2;
        this.zah = i13;
        this.zai = i14;
    }
}
