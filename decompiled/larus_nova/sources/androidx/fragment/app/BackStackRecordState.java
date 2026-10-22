package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BackStackRecordState(BackStackRecord r100) {
        int r101 = r100.mOps.size();
        this.mOps = new int[r101 * 6];
        if (r100.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r101);
        this.mOldMaxLifecycleStates = new int[r101];
        this.mCurrentMaxLifecycleStates = new int[r101];
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r101) goto L11;
        FragmentTransaction.Op r104 = (FragmentTransaction.Op) ListProtector.get(r100.mOps, r102);
        int r105 = r103 + 1;
        this.mOps[r103] = r104.mCmd;
        ArrayList<String> r106 = this.mFragmentWhos;
        Fragment r107 = r104.mFragment;
        if (r107 == null) goto L9;
        String r108 = r107.mWho;
    L10:
        r106.add(r108);
        int[] r109 = this.mOps;
        int r110 = r105 + 1;
        r109[r105] = r104.mFromExpandedOp ? 1 : 0;
        int r111 = r110 + 1;
        r109[r110] = r104.mEnterAnim;
        int r112 = r111 + 1;
        r109[r111] = r104.mExitAnim;
        int r113 = r112 + 1;
        r109[r112] = r104.mPopEnterAnim;
        int r114 = r113 + 1;
        r109[r113] = r104.mPopExitAnim;
        this.mOldMaxLifecycleStates[r102] = r104.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r102] = r104.mCurrentMaxState.ordinal();
        r102 = r102 + 1;
        r103 = r114;
        goto L5
    L9:
        r108 = null;
        goto L10
    L11:
        this.mTransition = r100.mTransition;
        this.mName = r100.mName;
        this.mIndex = r100.mIndex;
        this.mBreadCrumbTitleRes = r100.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r100.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = r100.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r100.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = r100.mSharedElementSourceNames;
        this.mSharedElementTargetNames = r100.mSharedElementTargetNames;
        this.mReorderingAllowed = r100.mReorderingAllowed;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(BackStackRecord r110) {
        int r100 = 0;
        int r101 = 0;
    L3:
        boolean r102 = true;
        if (r100 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r103 = new FragmentTransaction.Op();
        int r104 = r100 + 1;
        r103.mCmd = this.mOps[r100];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Objects.toString(r110);
        int r105 = this.mOps[r104];
    L8:
        r103.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r101]];
        r103.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r101]];
        int[] r106 = this.mOps;
        int r107 = r104 + 1;
        if (r106[r104] != 0) goto L12;
        r102 = false;
    L12:
        r103.mFromExpandedOp = r102;
        int r108 = r107 + 1;
        int r109 = r106[r107];
        r103.mEnterAnim = r109;
        int r111 = r108 + 1;
        int r112 = r106[r108];
        r103.mExitAnim = r112;
        int r113 = r111 + 1;
        int r114 = r106[r111];
        r103.mPopEnterAnim = r114;
        int r115 = r106[r113];
        r103.mPopExitAnim = r115;
        r110.mEnterAnim = r109;
        r110.mExitAnim = r112;
        r110.mPopEnterAnim = r114;
        r110.mPopExitAnim = r115;
        r110.addOp(r103);
        r101 = r101 + 1;
        r100 = r113 + 1;
        goto L3
    L13:
        r110.mTransition = this.mTransition;
        r110.mName = this.mName;
        r110.mAddToBackStack = true;
        r110.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r110.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r110.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r110.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r110.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r110.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r110.mReorderingAllowed = this.mReorderingAllowed;
    }

    public BackStackRecord instantiate(FragmentManager r100) {
        BackStackRecord r101 = new BackStackRecord(r100);
        fillInBackStackRecord(r101);
        r101.mIndex = this.mIndex;
        int r102 = 0;
    L4:
        if (r102 >= this.mFragmentWhos.size()) goto L9;
        String r103 = (String) ListProtector.get(this.mFragmentWhos, r102);
        if (r103 == null) goto L8;
        FragmentTransaction.Op r104 = (FragmentTransaction.Op) ListProtector.get(r101.mOps, r102);
        r104.mFragment = r100.findActiveFragment(r103);
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        r101.bumpBackStackNesting(1);
        return r101;
    }

    public BackStackRecordState(Parcel r100) {
        this.mOps = r100.createIntArray();
        this.mFragmentWhos = r100.createStringArrayList();
        this.mOldMaxLifecycleStates = r100.createIntArray();
        this.mCurrentMaxLifecycleStates = r100.createIntArray();
        this.mTransition = r100.readInt();
        this.mName = r100.readString();
        this.mIndex = r100.readInt();
        this.mBreadCrumbTitleRes = r100.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        this.mBreadCrumbShortTitleRes = r100.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        this.mSharedElementSourceNames = r100.createStringArrayList();
        this.mSharedElementTargetNames = r100.createStringArrayList();
        if (r100.readInt() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.mReorderingAllowed = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public BackStackRecord instantiate(FragmentManager r100, Map<String, Fragment> r101) {
        BackStackRecord r102 = new BackStackRecord(r100);
        fillInBackStackRecord(r102);
        int r103 = 0;
    L4:
        if (r103 >= this.mFragmentWhos.size()) goto L13;
        String r104 = (String) ListProtector.get(this.mFragmentWhos, r103);
        if (r104 == null) goto L12;
        Fragment r105 = r101.get(r104);
        if (r105 == null) goto L11;
        ((FragmentTransaction.Op) ListProtector.get(r102.mOps, r103)).mFragment = r105;
        goto L12
    L11:
        throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + r104 + ")");
    L12:
        r103 = r103 + 1;
        goto L4
    L13:
        return r102;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeIntArray(this.mOps);
        r100.writeStringList(this.mFragmentWhos);
        r100.writeIntArray(this.mOldMaxLifecycleStates);
        r100.writeIntArray(this.mCurrentMaxLifecycleStates);
        r100.writeInt(this.mTransition);
        r100.writeString(this.mName);
        r100.writeInt(this.mIndex);
        r100.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r100, 0);
        r100.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r100, 0);
        r100.writeStringList(this.mSharedElementSourceNames);
        r100.writeStringList(this.mSharedElementTargetNames);
        r100.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
