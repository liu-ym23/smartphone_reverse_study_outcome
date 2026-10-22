package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = null;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    final String mTag;
    final int mTargetRequestCode;
    final String mTargetWho;
    final boolean mUserVisibleHint;
    final String mWho;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    FragmentState(Fragment r2) {
        this.mClassName = r2.getClass().getName();
        this.mWho = r2.mWho;
        this.mFromLayout = r2.mFromLayout;
        this.mFragmentId = r2.mFragmentId;
        this.mContainerId = r2.mContainerId;
        this.mTag = r2.mTag;
        this.mRetainInstance = r2.mRetainInstance;
        this.mRemoving = r2.mRemoving;
        this.mDetached = r2.mDetached;
        this.mHidden = r2.mHidden;
        this.mMaxLifecycleState = r2.mMaxState.ordinal();
        this.mTargetWho = r2.mTargetWho;
        this.mTargetRequestCode = r2.mTargetRequestCode;
        this.mUserVisibleHint = r2.mUserVisibleHint;
    }

    FragmentState(Parcel r4) {
        this.mClassName = r4.readString();
        this.mWho = r4.readString();
        boolean r1 = true;
        if (r4.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mFromLayout = r0;
        this.mFragmentId = r4.readInt();
        this.mContainerId = r4.readInt();
        this.mTag = r4.readString();
        if (r4.readInt() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.mRetainInstance = r2;
        if (r4.readInt() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.mRemoving = r3;
        if (r4.readInt() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.mDetached = r5;
        if (r4.readInt() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.mHidden = r6;
        this.mMaxLifecycleState = r4.readInt();
        this.mTargetWho = r4.readString();
        this.mTargetRequestCode = r4.readInt();
        if (r4.readInt() != 0) goto L26;
        r1 = false;
    L26:
        this.mUserVisibleHint = r1;
        return;
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    Fragment instantiate(FragmentFactory r2, ClassLoader r3) {
        Fragment r4 = r2.instantiate(r3, this.mClassName);
        r4.mWho = this.mWho;
        r4.mFromLayout = this.mFromLayout;
        r4.mRestored = true;
        r4.mFragmentId = this.mFragmentId;
        r4.mContainerId = this.mContainerId;
        r4.mTag = this.mTag;
        r4.mRetainInstance = this.mRetainInstance;
        r4.mRemoving = this.mRemoving;
        r4.mDetached = this.mDetached;
        r4.mHidden = this.mHidden;
        r4.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        r4.mTargetWho = this.mTargetWho;
        r4.mTargetRequestCode = this.mTargetRequestCode;
        r4.mUserVisibleHint = this.mUserVisibleHint;
        return r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentState{");
        r0.append(this.mClassName);
        r0.append(" (");
        r0.append(this.mWho);
        r0.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r0.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mContainerId));
    L8:
        String r1 = this.mTag;
        if (r1 == null) goto L14;
        if (r1.isEmpty() == true) goto L14;
        r0.append(" tag=");
        r0.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r0.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r0.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r0.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r0.append(" hidden");
    L26:
        if (this.mTargetWho == null) goto L29;
        r0.append(" targetWho=");
        r0.append(this.mTargetWho);
        r0.append(" targetRequestCode=");
        r0.append(this.mTargetRequestCode);
    L29:
        if (this.mUserVisibleHint == false) goto L32;
        r0.append(" userVisibleHint");
    L32:
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mClassName);
        r1.writeString(this.mWho);
        r1.writeInt(this.mFromLayout ? 1 : 0);
        r1.writeInt(this.mFragmentId);
        r1.writeInt(this.mContainerId);
        r1.writeString(this.mTag);
        r1.writeInt(this.mRetainInstance ? 1 : 0);
        r1.writeInt(this.mRemoving ? 1 : 0);
        r1.writeInt(this.mDetached ? 1 : 0);
        r1.writeInt(this.mHidden ? 1 : 0);
        r1.writeInt(this.mMaxLifecycleState);
        r1.writeString(this.mTargetWho);
        r1.writeInt(this.mTargetRequestCode);
        r1.writeInt(this.mUserVisibleHint ? 1 : 0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
