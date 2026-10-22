package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.customview.view.a;
import q.l;

/* loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a(3);

    /* renamed from: a, reason: collision with root package name */
    public final l f10913a;

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i4 = parcel.readInt();
        String[] strArr = new String[i4];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i4];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f10913a = new l(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            this.f10913a.put(strArr[i5], bundleArr[i5]);
        }
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f10913a + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        l lVar = this.f10913a;
        int i5 = lVar.f13970c;
        parcel.writeInt(i5);
        String[] strArr = new String[i5];
        Bundle[] bundleArr = new Bundle[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            strArr[i6] = (String) lVar.f(i6);
            bundleArr[i6] = (Bundle) lVar.i(i6);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
