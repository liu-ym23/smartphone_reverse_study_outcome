package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Lifecycle;
import androidx.fragment.app.K;
import java.util.ArrayList;
import java.util.Map;

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

    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(C1363a c1363a) {
        int size = c1363a.f13995c.size();
        this.mOps = new int[size * 6];
        if (!c1363a.f14001i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.mFragmentWhos = new ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            K.a aVar = c1363a.f13995c.get(i11);
            int i12 = i10 + 1;
            this.mOps[i10] = aVar.f14012a;
            ArrayList<String> arrayList = this.mFragmentWhos;
            Fragment fragment = aVar.f14013b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.mOps;
            iArr[i12] = aVar.f14014c ? 1 : 0;
            iArr[i10 + 2] = aVar.f14015d;
            iArr[i10 + 3] = aVar.f14016e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar.f14017f;
            i10 += 6;
            iArr[i13] = aVar.f14018g;
            this.mOldMaxLifecycleStates[i11] = aVar.f14019h.ordinal();
            this.mCurrentMaxLifecycleStates[i11] = aVar.f14020i.ordinal();
        }
        this.mTransition = c1363a.f14000h;
        this.mName = c1363a.f14003k;
        this.mIndex = c1363a.f14085v;
        this.mBreadCrumbTitleRes = c1363a.f14004l;
        this.mBreadCrumbTitleText = c1363a.f14005m;
        this.mBreadCrumbShortTitleRes = c1363a.f14006n;
        this.mBreadCrumbShortTitleText = c1363a.f14007o;
        this.mSharedElementSourceNames = c1363a.f14008p;
        this.mSharedElementTargetNames = c1363a.f14009q;
        this.mReorderingAllowed = c1363a.f14010r;
    }

    private void fillInBackStackRecord(C1363a c1363a) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.mOps.length) {
                c1363a.f14000h = this.mTransition;
                c1363a.f14003k = this.mName;
                c1363a.f14001i = true;
                c1363a.f14004l = this.mBreadCrumbTitleRes;
                c1363a.f14005m = this.mBreadCrumbTitleText;
                c1363a.f14006n = this.mBreadCrumbShortTitleRes;
                c1363a.f14007o = this.mBreadCrumbShortTitleText;
                c1363a.f14008p = this.mSharedElementSourceNames;
                c1363a.f14009q = this.mSharedElementTargetNames;
                c1363a.f14010r = this.mReorderingAllowed;
                return;
            }
            K.a aVar = new K.a();
            int i12 = i10 + 1;
            aVar.f14012a = this.mOps[i10];
            if (FragmentManager.N0(2)) {
                Log.v(TAG, "Instantiate " + c1363a + " op #" + i11 + " base fragment #" + this.mOps[i12]);
            }
            aVar.f14019h = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i11]];
            aVar.f14020i = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i11]];
            int[] iArr = this.mOps;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar.f14014c = z10;
            int i14 = iArr[i13];
            aVar.f14015d = i14;
            int i15 = iArr[i10 + 3];
            aVar.f14016e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar.f14017f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar.f14018g = i18;
            c1363a.f13996d = i14;
            c1363a.f13997e = i15;
            c1363a.f13998f = i17;
            c1363a.f13999g = i18;
            c1363a.e(aVar);
            i11++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public C1363a instantiate(FragmentManager fragmentManager) {
        C1363a c1363a = new C1363a(fragmentManager);
        fillInBackStackRecord(c1363a);
        c1363a.f14085v = this.mIndex;
        for (int i10 = 0; i10 < this.mFragmentWhos.size(); i10++) {
            String str = this.mFragmentWhos.get(i10);
            if (str != null) {
                c1363a.f13995c.get(i10).f14013b = fragmentManager.i0(str);
            }
        }
        c1363a.w(1);
        return c1363a;
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

    public C1363a instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        C1363a c1363a = new C1363a(fragmentManager);
        fillInBackStackRecord(c1363a);
        for (int i10 = 0; i10 < this.mFragmentWhos.size(); i10++) {
            String str = this.mFragmentWhos.get(i10);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment != null) {
                    c1363a.f13995c.get(i10).f14013b = fragment;
                } else {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + str + ")");
                }
            }
        }
        return c1363a;
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
