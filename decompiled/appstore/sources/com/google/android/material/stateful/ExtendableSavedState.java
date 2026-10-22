package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;

    @NonNull
    public final SimpleArrayMap extendableStates;

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ ExtendableSavedState(Parcel r10, ClassLoader r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        super.writeToParcel(r10, r11);
        int r12 = this.extendableStates.size();
        r10.writeInt(r12);
        String[] r13 = new String[r12];
        Bundle[] r14 = new Bundle[r12];
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r13[r15] = (String) this.extendableStates.keyAt(r15);
        r14[r15] = (Bundle) this.extendableStates.valueAt(r15);
        r15 = r15 + 1;
        goto L3
    L5:
        r10.writeStringArray(r13);
        r10.writeTypedArray(r14, 0);
    }

    public ExtendableSavedState(Parcelable r10) {
        super(r10);
        this.extendableStates = new SimpleArrayMap();
    }

    private ExtendableSavedState(@NonNull Parcel r10, ClassLoader r11) {
        super(r10, r11);
        int r12 = r10.readInt();
        String[] r13 = new String[r12];
        r10.readStringArray(r13);
        Bundle[] r14 = new Bundle[r12];
        r10.readTypedArray(r14, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(r12);
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        this.extendableStates.put(r13[r15], r14[r15]);
        r15 = r15 + 1;
        goto L3
    }
}
