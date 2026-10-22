package com.google.android.gms.common.data;

import a1.C0154a;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import t0.J;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new C0154a(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f9707a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f9708b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f9709c;

    /* renamed from: d, reason: collision with root package name */
    public final CursorWindow[] f9710d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9711e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f9712f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f9713g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9714h = false;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9715i = true;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i4, String[] strArr, CursorWindow[] cursorWindowArr, int i5, Bundle bundle) {
        this.f9707a = i4;
        this.f9708b = strArr;
        this.f9710d = cursorWindowArr;
        this.f9711e = i5;
        this.f9712f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f9714h) {
                    this.f9714h = true;
                    int i4 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f9710d;
                        if (i4 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i4].close();
                        i4++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z4;
        try {
            if (this.f9715i && this.f9710d.length > 0) {
                synchronized (this) {
                    z4 = this.f9714h;
                }
                if (!z4) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        String[] strArr = this.f9708b;
        if (strArr != null) {
            int iZ2 = J.Z(parcel, 1);
            parcel.writeStringArray(strArr);
            J.b0(parcel, iZ2);
        }
        J.V(parcel, 2, this.f9710d, i4);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9711e);
        J.P(parcel, 4, this.f9712f);
        J.c0(parcel, 1000, 4);
        parcel.writeInt(this.f9707a);
        J.b0(parcel, iZ);
        if ((i4 & 1) != 0) {
            close();
        }
    }
}
