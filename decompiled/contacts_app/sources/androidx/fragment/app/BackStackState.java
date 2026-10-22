package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    BackStackState(List<String> r1, List<BackStackRecordState> r2) {
        this.mFragments = r1;
        this.mTransactions = r2;
    }

    BackStackState(Parcel r2) {
        this.mFragments = r2.createStringArrayList();
        this.mTransactions = r2.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    List<BackStackRecord> instantiate(FragmentManager r9, Map<String, Fragment> r10) {
        HashMap r0 = new HashMap(this.mFragments.size());
        Iterator<String> r1 = this.mFragments.iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        String r2 = r1.next();
        Fragment r3 = r10.get(r2);
        if (r3 != null) goto L7;
        Bundle r4 = r9.getFragmentStore().setSavedState(r2, null);
        if (r4 == null) goto L4;
        ClassLoader r5 = r9.getHost().getContext().getClassLoader();
        Fragment r6 = ((FragmentState) r4.getParcelable("state")).instantiate(r9.getFragmentFactory(), r5);
        r6.mSavedFragmentState = r4;
        if (r6.mSavedFragmentState.getBundle("savedInstanceState") != null) goto L13;
        r6.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
    L13:
        Bundle r7 = r4.getBundle("arguments");
        if (r7 == null) goto L16;
        r7.setClassLoader(r5);
    L16:
        r6.setArguments(r7);
        r0.put(r6.mWho, r6);
        goto L4
    L7:
        r0.put(r3.mWho, r3);
        goto L4
    L17:
        ArrayList r11 = new ArrayList();
        Iterator<BackStackRecordState> r8 = this.mTransactions.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r11.add(r8.next().instantiate(r9, r0));
        goto L19
    L21:
        return r11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeStringList(this.mFragments);
        r1.writeTypedList(this.mTransactions);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
