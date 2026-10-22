package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = null;
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

    public class a implements Parcelable.Creator {
        public a() {
        }

        public BackStackRecordState a(Parcel r10) {
            return new BackStackRecordState(r10);
        }

        public BackStackRecordState[] b(int r10) {
            return new BackStackRecordState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public BackStackRecordState(androidx.fragment.app.a r10) {
        int r11 = r10.f3245c.size();
        this.mOps = new int[r11 * 6];
        if (r10.f3251i == false) goto L14;
        this.mFragmentWhos = new ArrayList(r11);
        this.mOldMaxLifecycleStates = new int[r11];
        this.mCurrentMaxLifecycleStates = new int[r11];
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L11;
        FragmentTransaction.a r14 = (FragmentTransaction.a) r10.f3245c.get(r12);
        int r15 = r13 + 1;
        this.mOps[r13] = r14.f3262a;
        ArrayList<String> r16 = this.mFragmentWhos;
        Fragment r17 = r14.f3263b;
        if (r17 == null) goto L9;
        String r18 = r17.mWho;
    L10:
        r16.add(r18);
        int[] r19 = this.mOps;
        r19[r15] = r14.f3264c ? 1 : 0;
        r19[r13 + 2] = r14.f3265d;
        r19[r13 + 3] = r14.f3266e;
        int r20 = r13 + 5;
        r19[r13 + 4] = r14.f3267f;
        r13 = r13 + 6;
        r19[r20] = r14.f3268g;
        this.mOldMaxLifecycleStates[r12] = r14.f3269h.ordinal();
        this.mCurrentMaxLifecycleStates[r12] = r14.f3270i.ordinal();
        r12 = r12 + 1;
        goto L5
    L9:
        r18 = null;
        goto L10
    L11:
        this.mTransition = r10.f3250h;
        this.mName = r10.f3253k;
        this.mIndex = r10.f3296v;
        this.mBreadCrumbTitleRes = r10.f3254l;
        this.mBreadCrumbTitleText = r10.f3255m;
        this.mBreadCrumbShortTitleRes = r10.f3256n;
        this.mBreadCrumbShortTitleText = r10.f3257o;
        this.mSharedElementSourceNames = r10.f3258p;
        this.mSharedElementTargetNames = r10.f3259q;
        this.mReorderingAllowed = r10.f3260r;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(@NonNull androidx.fragment.app.a r10) {
        int r11 = 0;
        int r12 = 0;
    L3:
        boolean r13 = true;
        if (r11 >= this.mOps.length) goto L13;
        FragmentTransaction.a r14 = new FragmentTransaction.a();
        int r15 = r11 + 1;
        r14.f3262a = this.mOps[r11];
        if (FragmentManager.L0(2) == false) goto L8;
        Log.v(TAG, "Instantiate " + r10 + " op #" + r12 + " base fragment #" + this.mOps[r15]);
    L8:
        r14.f3269h = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r12]];
        r14.f3270i = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r12]];
        int[] r16 = this.mOps;
        int r17 = r11 + 2;
        if (r16[r15] != 0) goto L12;
        r13 = false;
    L12:
        r14.f3264c = r13;
        int r18 = r16[r17];
        r14.f3265d = r18;
        int r19 = r16[r11 + 3];
        r14.f3266e = r19;
        int r20 = r11 + 5;
        int r21 = r16[r11 + 4];
        r14.f3267f = r21;
        r11 = r11 + 6;
        int r22 = r16[r20];
        r14.f3268g = r22;
        r10.f3246d = r18;
        r10.f3247e = r19;
        r10.f3248f = r21;
        r10.f3249g = r22;
        r10.f(r14);
        r12 = r12 + 1;
        goto L3
    L13:
        r10.f3250h = this.mTransition;
        r10.f3253k = this.mName;
        r10.f3251i = true;
        r10.f3254l = this.mBreadCrumbTitleRes;
        r10.f3255m = this.mBreadCrumbTitleText;
        r10.f3256n = this.mBreadCrumbShortTitleRes;
        r10.f3257o = this.mBreadCrumbShortTitleText;
        r10.f3258p = this.mSharedElementSourceNames;
        r10.f3259q = this.mSharedElementTargetNames;
        r10.f3260r = this.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public androidx.fragment.app.a instantiate(@NonNull FragmentManager r10) {
        androidx.fragment.app.a r11 = new androidx.fragment.app.a(r10);
        fillInBackStackRecord(r11);
        r11.f3296v = this.mIndex;
        int r12 = 0;
    L4:
        if (r12 >= this.mFragmentWhos.size()) goto L9;
        String r13 = this.mFragmentWhos.get(r12);
        if (r13 == null) goto L8;
        FragmentTransaction.a r14 = (FragmentTransaction.a) r11.f3245c.get(r12);
        r14.f3263b = r10.f0(r13);
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        r11.B(1);
        return r11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeIntArray(this.mOps);
        r10.writeStringList(this.mFragmentWhos);
        r10.writeIntArray(this.mOldMaxLifecycleStates);
        r10.writeIntArray(this.mCurrentMaxLifecycleStates);
        r10.writeInt(this.mTransition);
        r10.writeString(this.mName);
        r10.writeInt(this.mIndex);
        r10.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r10, 0);
        r10.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r10, 0);
        r10.writeStringList(this.mSharedElementSourceNames);
        r10.writeStringList(this.mSharedElementTargetNames);
        r10.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    @NonNull
    public androidx.fragment.app.a instantiate(@NonNull FragmentManager r10, @NonNull Map<String, Fragment> r11) {
        androidx.fragment.app.a r12 = new androidx.fragment.app.a(r10);
        fillInBackStackRecord(r12);
        int r13 = 0;
    L4:
        if (r13 >= this.mFragmentWhos.size()) goto L13;
        String r14 = this.mFragmentWhos.get(r13);
        if (r14 == null) goto L12;
        Fragment r15 = r11.get(r14);
        if (r15 == null) goto L11;
        ((FragmentTransaction.a) r12.f3245c.get(r13)).f3263b = r15;
        goto L12
    L11:
        throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + r14 + ")");
    L12:
        r13 = r13 + 1;
        goto L4
    L13:
        return r12;
    }

    public BackStackRecordState(Parcel r10) {
        this.mOps = r10.createIntArray();
        this.mFragmentWhos = r10.createStringArrayList();
        this.mOldMaxLifecycleStates = r10.createIntArray();
        this.mCurrentMaxLifecycleStates = r10.createIntArray();
        this.mTransition = r10.readInt();
        this.mName = r10.readString();
        this.mIndex = r10.readInt();
        this.mBreadCrumbTitleRes = r10.readInt();
        Parcelable.Creator r11 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) r11.createFromParcel(r10);
        this.mBreadCrumbShortTitleRes = r10.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) r11.createFromParcel(r10);
        this.mSharedElementSourceNames = r10.createStringArrayList();
        this.mSharedElementTargetNames = r10.createStringArrayList();
        if (r10.readInt() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.mReorderingAllowed = r12;
        return;
    L5:
        r12 = false;
        goto L6
    }
}
