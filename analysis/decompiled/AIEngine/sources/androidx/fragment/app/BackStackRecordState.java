package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.d0;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f2095a.size();
        this.mOps = new int[size * 6];
        if (!aVar.f2101g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.mFragmentWhos = new ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            d0.a aVar2 = aVar.f2095a.get(i11);
            int i12 = i10 + 1;
            this.mOps[i10] = aVar2.f2110a;
            ArrayList<String> arrayList = this.mFragmentWhos;
            Fragment fragment = aVar2.f2111b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.mOps;
            iArr[i12] = aVar2.f2112c ? 1 : 0;
            iArr[i10 + 2] = aVar2.f2113d;
            iArr[i10 + 3] = aVar2.f2114e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar2.f2115f;
            i10 += 6;
            iArr[i13] = aVar2.f2116g;
            this.mOldMaxLifecycleStates[i11] = aVar2.h.ordinal();
            this.mCurrentMaxLifecycleStates[i11] = aVar2.f2117i.ordinal();
        }
        this.mTransition = aVar.f2100f;
        this.mName = aVar.f2102i;
        this.mIndex = aVar.f2076s;
        this.mBreadCrumbTitleRes = aVar.f2103j;
        this.mBreadCrumbTitleText = aVar.f2104k;
        this.mBreadCrumbShortTitleRes = aVar.f2105l;
        this.mBreadCrumbShortTitleText = aVar.f2106m;
        this.mSharedElementSourceNames = aVar.f2107n;
        this.mSharedElementTargetNames = aVar.f2108o;
        this.mReorderingAllowed = aVar.f2109p;
    }

    private void fillInBackStackRecord(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z = true;
            if (i10 >= this.mOps.length) {
                aVar.f2100f = this.mTransition;
                aVar.f2102i = this.mName;
                aVar.f2101g = true;
                aVar.f2103j = this.mBreadCrumbTitleRes;
                aVar.f2104k = this.mBreadCrumbTitleText;
                aVar.f2105l = this.mBreadCrumbShortTitleRes;
                aVar.f2106m = this.mBreadCrumbShortTitleText;
                aVar.f2107n = this.mSharedElementSourceNames;
                aVar.f2108o = this.mSharedElementTargetNames;
                aVar.f2109p = this.mReorderingAllowed;
                return;
            }
            d0.a aVar2 = new d0.a();
            int i12 = i10 + 1;
            aVar2.f2110a = this.mOps[i10];
            if (FragmentManager.G(2)) {
                Log.v(TAG, "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.mOps[i12]);
            }
            aVar2.h = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i11]];
            aVar2.f2117i = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i11]];
            int[] iArr = this.mOps;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z = false;
            }
            aVar2.f2112c = z;
            int i14 = iArr[i13];
            aVar2.f2113d = i14;
            int i15 = iArr[i10 + 3];
            aVar2.f2114e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar2.f2115f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar2.f2116g = i18;
            aVar.f2096b = i14;
            aVar.f2097c = i15;
            aVar.f2098d = i17;
            aVar.f2099e = i18;
            aVar.b(aVar2);
            i11++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a instantiate(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        fillInBackStackRecord(aVar);
        aVar.f2076s = this.mIndex;
        for (int i10 = 0; i10 < this.mFragmentWhos.size(); i10++) {
            String str = this.mFragmentWhos.get(i10);
            if (str != null) {
                aVar.f2095a.get(i10).f2111b = fragmentManager.f2015c.b(str);
            }
        }
        aVar.f(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    public androidx.fragment.app.a instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        fillInBackStackRecord(aVar);
        for (int i10 = 0; i10 < this.mFragmentWhos.size(); i10++) {
            String str = this.mFragmentWhos.get(i10);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment != null) {
                    aVar.f2095a.get(i10).f2111b = fragment;
                } else {
                    throw new IllegalStateException(com.stepos.core.ota.d.j(new StringBuilder("Restoring FragmentTransaction "), this.mName, " failed due to missing saved state for Fragment (", str, ")"));
                }
            }
        }
        return aVar;
    }

    public BackStackRecordState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
