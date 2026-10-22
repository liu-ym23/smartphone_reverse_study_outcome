package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new k(1);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9953a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9954b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9955c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9956d;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r8.f9956d = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzq(int r9, int r10, java.lang.String r11, boolean r12) {
        /*
            r8 = this;
            r0 = 2
            r1 = 3
            r2 = 6
            r3 = 1
            r8.<init>()
            r8.f9953a = r12
            r8.f9954b = r11
            int[] r11 = new int[r2]
            r11 = {x003e: FILL_ARRAY_DATA , data: [1, 2, 3, 4, 5, 6} // fill-array
            r12 = 0
            r4 = r12
        L12:
            r5 = 0
            if (r4 >= r2) goto L21
            r6 = r11[r4]
            int r7 = r6 + (-1)
            if (r6 == 0) goto L20
            if (r7 != r9) goto L1e
            goto L22
        L1e:
            int r4 = r4 + r3
            goto L12
        L20:
            throw r5
        L21:
            r6 = r3
        L22:
            int r6 = r6 + (-1)
            r8.f9955c = r6
            int[] r9 = new int[]{r3, r0, r1}
        L2a:
            if (r12 >= r1) goto L39
            r11 = r9[r12]
            int r0 = r11 + (-1)
            if (r11 == 0) goto L38
            if (r0 != r10) goto L36
            r3 = r11
            goto L39
        L36:
            int r12 = r12 + r3
            goto L2a
        L38:
            throw r5
        L39:
            int r3 = r3 + (-1)
            r8.f9956d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzq.<init>(int, int, java.lang.String, boolean):void");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9953a ? 1 : 0);
        J.U(parcel, 2, this.f9954b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9955c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9956d);
        J.b0(parcel, iZ);
    }
}
