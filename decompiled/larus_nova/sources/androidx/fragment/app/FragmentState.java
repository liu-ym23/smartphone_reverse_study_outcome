package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes17.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = null;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;
    final String mWho;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(128);
        r100.append("FragmentState{");
        r100.append(this.mClassName);
        r100.append(" (");
        r100.append(this.mWho);
        r100.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r100.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r100.append(" id=0x");
        r100.append(Integer.toHexString(this.mContainerId));
    L8:
        String r101 = this.mTag;
        if (r101 == null) goto L14;
        if (r101.isEmpty() == true) goto L14;
        r100.append(" tag=");
        r100.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r100.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r100.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r100.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r100.append(" hidden");
    L26:
        return r100.toString();
    }

    public FragmentState(Parcel r100) {
        this.mClassName = r100.readString();
        this.mWho = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.mFromLayout = r102;
        this.mFragmentId = r100.readInt();
        this.mContainerId = r100.readInt();
        this.mTag = r100.readString();
        if (r100.readInt() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.mRetainInstance = r103;
        if (r100.readInt() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.mRemoving = r104;
        if (r100.readInt() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.mDetached = r105;
        this.mArguments = r100.readBundle();
        if (r100.readInt() != 0) goto L22;
        r101 = false;
    L22:
        this.mHidden = r101;
        this.mSavedFragmentState = r100.readBundle();
        this.mMaxLifecycleState = r100.readInt();
        return;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public FragmentState(Fragment r100) {
        this.mClassName = r100.getClass().getName();
        this.mWho = r100.mWho;
        this.mFromLayout = r100.mFromLayout;
        this.mFragmentId = r100.mFragmentId;
        this.mContainerId = r100.mContainerId;
        this.mTag = r100.mTag;
        this.mRetainInstance = r100.mRetainInstance;
        this.mRemoving = r100.mRemoving;
        this.mDetached = r100.mDetached;
        this.mArguments = r100.mArguments;
        this.mHidden = r100.mHidden;
        this.mMaxLifecycleState = r100.mMaxState.ordinal();
    }

    public Fragment instantiate(FragmentFactory r100, ClassLoader r101) {
        Fragment r102 = r100.instantiate(r101, this.mClassName);
        Bundle r103 = this.mArguments;
        if (r103 == null) goto L5;
        r103.setClassLoader(r101);
    L5:
        r102.setArguments(this.mArguments);
        r102.mWho = this.mWho;
        r102.mFromLayout = this.mFromLayout;
        r102.mRestored = true;
        r102.mFragmentId = this.mFragmentId;
        r102.mContainerId = this.mContainerId;
        r102.mTag = this.mTag;
        r102.mRetainInstance = this.mRetainInstance;
        r102.mRemoving = this.mRemoving;
        r102.mDetached = this.mDetached;
        r102.mHidden = this.mHidden;
        r102.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        Bundle r104 = this.mSavedFragmentState;
        if (r104 == null) goto L8;
        r102.mSavedFragmentState = r104;
    L9:
        return r102;
    L8:
        r102.mSavedFragmentState = new Bundle();
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mClassName);
        r100.writeString(this.mWho);
        r100.writeInt(this.mFromLayout ? 1 : 0);
        r100.writeInt(this.mFragmentId);
        r100.writeInt(this.mContainerId);
        r100.writeString(this.mTag);
        r100.writeInt(this.mRetainInstance ? 1 : 0);
        r100.writeInt(this.mRemoving ? 1 : 0);
        r100.writeInt(this.mDetached ? 1 : 0);
        r100.writeBundle(this.mArguments);
        r100.writeInt(this.mHidden ? 1 : 0);
        r100.writeBundle(this.mSavedFragmentState);
        r100.writeInt(this.mMaxLifecycleState);
    }
}
