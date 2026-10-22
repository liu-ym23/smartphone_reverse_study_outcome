package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BackStackState(Parcel r100) {
        this.mFragments = r100.createStringArrayList();
        this.mTransactions = r100.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    public BackStackState(List<String> r100, List<BackStackRecordState> r101) {
        this.mFragments = r100;
        this.mTransactions = r101;
    }

    public List<BackStackRecord> instantiate(FragmentManager r100, Map<String, Fragment> r101) {
        HashMap r102 = new HashMap(this.mFragments.size());
        Iterator<String> r103 = this.mFragments.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();
        Fragment r105 = r101.get(r104);
        if (r105 != null) goto L7;
        FragmentState r106 = r100.getFragmentStore().setSavedState(r104, null);
        if (r106 == null) goto L4;
        Fragment r107 = r106.instantiate(r100.getFragmentFactory(), r100.getHost().getContext().getClassLoader());
        r102.put(r107.mWho, r107);
        goto L4
    L7:
        r102.put(r105.mWho, r105);
        goto L4
    L11:
        ArrayList r108 = new ArrayList();
        Iterator<BackStackRecordState> r109 = this.mTransactions.iterator();
    L13:
        if (r109.hasNext() == false) goto L15;
        r108.add(r109.next().instantiate(r100, r102));
        goto L13
    L15:
        return r108;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStringList(this.mFragments);
        r100.writeTypedList(this.mTransactions);
    }
}
