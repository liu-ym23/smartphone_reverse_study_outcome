package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;
    public final SimpleArrayMap<String, Bundle> extendableStates;

    /* synthetic */ ExtendableSavedState(Parcel r1, ClassLoader r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public ExtendableSavedState(Parcelable r1) {
        super(r1);
        this.extendableStates = new SimpleArrayMap();
    }

    private ExtendableSavedState(Parcel r6, ClassLoader r7) {
        super(r6, r7);
        int r8 = r6.readInt();
        String[] r0 = new String[r8];
        r6.readStringArray(r0);
        Bundle[] r1 = new Bundle[r8];
        r6.readTypedArray(r1, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(r8);
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L5;
        this.extendableStates.put(r0[r9], r1[r9]);
        r9 = r9 + 1;
        goto L3
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        super.writeToParcel(r6, r7);
        int r8 = this.extendableStates.size();
        r6.writeInt(r8);
        String[] r0 = new String[r8];
        Bundle[] r1 = new Bundle[r8];
        int r3 = 0;
    L3:
        if (r3 >= r8) goto L5;
        r0[r3] = this.extendableStates.keyAt(r3);
        r1[r3] = this.extendableStates.valueAt(r3);
        r3 = r3 + 1;
        goto L3
    L5:
        r6.writeStringArray(r0);
        r6.writeTypedArray(r1, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
