package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
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

    public class a implements Parcelable.Creator {
        public a() {
        }

        public FragmentState a(Parcel r10) {
            return new FragmentState(r10);
        }

        public FragmentState[] b(int r10) {
            return new FragmentState[r10];
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

    public FragmentState(Fragment r10) {
        this.mClassName = r10.getClass().getName();
        this.mWho = r10.mWho;
        this.mFromLayout = r10.mFromLayout;
        this.mFragmentId = r10.mFragmentId;
        this.mContainerId = r10.mContainerId;
        this.mTag = r10.mTag;
        this.mRetainInstance = r10.mRetainInstance;
        this.mRemoving = r10.mRemoving;
        this.mDetached = r10.mDetached;
        this.mHidden = r10.mHidden;
        this.mMaxLifecycleState = r10.mMaxState.ordinal();
        this.mTargetWho = r10.mTargetWho;
        this.mTargetRequestCode = r10.mTargetRequestCode;
        this.mUserVisibleHint = r10.mUserVisibleHint;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Fragment instantiate(@NonNull p r10, @NonNull ClassLoader r11) {
        Fragment r12 = r10.a(r11, this.mClassName);
        r12.mWho = this.mWho;
        r12.mFromLayout = this.mFromLayout;
        r12.mRestored = true;
        r12.mFragmentId = this.mFragmentId;
        r12.mContainerId = this.mContainerId;
        r12.mTag = this.mTag;
        r12.mRetainInstance = this.mRetainInstance;
        r12.mRemoving = this.mRemoving;
        r12.mDetached = this.mDetached;
        r12.mHidden = this.mHidden;
        r12.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        r12.mTargetWho = this.mTargetWho;
        r12.mTargetRequestCode = this.mTargetRequestCode;
        r12.mUserVisibleHint = this.mUserVisibleHint;
        return r12;
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("FragmentState{");
        r10.append(this.mClassName);
        r10.append(" (");
        r10.append(this.mWho);
        r10.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r10.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r10.append(" id=0x");
        r10.append(Integer.toHexString(this.mContainerId));
    L8:
        String r11 = this.mTag;
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        r10.append(" tag=");
        r10.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r10.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r10.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r10.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r10.append(" hidden");
    L26:
        if (this.mTargetWho == null) goto L29;
        r10.append(" targetWho=");
        r10.append(this.mTargetWho);
        r10.append(" targetRequestCode=");
        r10.append(this.mTargetRequestCode);
    L29:
        if (this.mUserVisibleHint == false) goto L32;
        r10.append(" userVisibleHint");
    L32:
        return r10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.mClassName);
        r10.writeString(this.mWho);
        r10.writeInt(this.mFromLayout ? 1 : 0);
        r10.writeInt(this.mFragmentId);
        r10.writeInt(this.mContainerId);
        r10.writeString(this.mTag);
        r10.writeInt(this.mRetainInstance ? 1 : 0);
        r10.writeInt(this.mRemoving ? 1 : 0);
        r10.writeInt(this.mDetached ? 1 : 0);
        r10.writeInt(this.mHidden ? 1 : 0);
        r10.writeInt(this.mMaxLifecycleState);
        r10.writeString(this.mTargetWho);
        r10.writeInt(this.mTargetRequestCode);
        r10.writeInt(this.mUserVisibleHint ? 1 : 0);
    }

    public FragmentState(Parcel r10) {
        this.mClassName = r10.readString();
        this.mWho = r10.readString();
        boolean r11 = false;
        if (r10.readInt() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.mFromLayout = r12;
        this.mFragmentId = r10.readInt();
        this.mContainerId = r10.readInt();
        this.mTag = r10.readString();
        if (r10.readInt() == 0) goto L9;
        boolean r13 = true;
    L10:
        this.mRetainInstance = r13;
        if (r10.readInt() == 0) goto L13;
        boolean r14 = true;
    L14:
        this.mRemoving = r14;
        if (r10.readInt() == 0) goto L17;
        boolean r15 = true;
    L18:
        this.mDetached = r15;
        if (r10.readInt() == 0) goto L21;
        boolean r16 = true;
    L22:
        this.mHidden = r16;
        this.mMaxLifecycleState = r10.readInt();
        this.mTargetWho = r10.readString();
        this.mTargetRequestCode = r10.readInt();
        if (r10.readInt() == 0) goto L25;
        r11 = true;
    L25:
        this.mUserVisibleHint = r11;
        return;
    L21:
        r16 = false;
        goto L22
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }
}
