package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.b.g;
import androidx.customview.view.AbsSavedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;
    public final g<String, Bundle> extendableStates;

    /* synthetic */ ExtendableSavedState(Parcel r1, ClassLoader r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public ExtendableSavedState(Parcelable r3) {
        super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        this.extendableStates = new g();
    }

    private ExtendableSavedState(Parcel r6, ClassLoader r7) {
        super(r6, r7);
        int r8 = r6.readInt();
        String[] r0 = new String[r8];
        r6.readStringArray(r0);
        Bundle[] r1 = new Bundle[r8];
        r6.readTypedArray(r1, Bundle.CREATOR);
        this.extendableStates = new g(r8);
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L5;
        this.extendableStates.put(r0[r9], r1[r9]);
        r9 = r9 + 1;
        goto L3
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel r8, int r9) {
        super.writeToParcel(r8, r9);
        int r10 = this.extendableStates.size();
        r8.writeInt(r10);
        String[] r0 = new String[r10];
        Bundle[] r1 = new Bundle[r10];
        int r3 = 0;
    L3:
        if (r3 >= r10) goto L5;
        r0[r3] = (String) ZeusTransformUtils.preCheckCast(this.extendableStates.b(r3), String.class, "com.obric.aiagent.plugin");
        r1[r3] = (Bundle) ZeusTransformUtils.preCheckCast(this.extendableStates.c(r3), Bundle.class, "com.obric.aiagent.plugin");
        r3 = r3 + 1;
        goto L3
    L5:
        r8.writeStringArray(r0);
        r8.writeTypedArray(r1, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
