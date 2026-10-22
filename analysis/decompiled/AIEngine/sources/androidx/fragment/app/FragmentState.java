package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import com.stepos.core.common.util.TraceIdKeys;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(s sVar, ClassLoader classLoader) {
        Fragment fragmentA = sVar.a(this.mClassName);
        Bundle bundle = this.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(this.mArguments);
        fragmentA.mWho = this.mWho;
        fragmentA.mFromLayout = this.mFromLayout;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = this.mFragmentId;
        fragmentA.mContainerId = this.mContainerId;
        fragmentA.mTag = this.mTag;
        fragmentA.mRetainInstance = this.mRetainInstance;
        fragmentA.mRemoving = this.mRemoving;
        fragmentA.mDetached = this.mDetached;
        fragmentA.mHidden = this.mHidden;
        fragmentA.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 != null) {
            fragmentA.mSavedFragmentState = bundle2;
            return fragmentA;
        }
        fragmentA.mSavedFragmentState = new Bundle();
        return fragmentA;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
        sb2.append("FragmentState{");
        sb2.append(this.mClassName);
        sb2.append(" (");
        sb2.append(this.mWho);
        sb2.append(")}:");
        if (this.mFromLayout) {
            sb2.append(" fromLayout");
        }
        if (this.mContainerId != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.mContainerId));
        }
        String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.mTag);
        }
        if (this.mRetainInstance) {
            sb2.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb2.append(" removing");
        }
        if (this.mDetached) {
            sb2.append(" detached");
        }
        if (this.mHidden) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
        parcel.writeInt(this.mMaxLifecycleState);
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
        this.mMaxLifecycleState = parcel.readInt();
    }
}
