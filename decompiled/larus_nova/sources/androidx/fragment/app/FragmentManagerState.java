package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<String> mActive;
    ArrayList<String> mAdded;
    BackStackRecordState[] mBackStack;
    int mBackStackIndex;
    ArrayList<String> mBackStackStateKeys;
    ArrayList<BackStackState> mBackStackStates;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho;
    ArrayList<String> mResultKeys;
    ArrayList<Bundle> mResults;
    ArrayList<FragmentState> mSavedState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
    }

    public FragmentManagerState(Parcel r100) {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
        this.mSavedState = r100.createTypedArrayList(FragmentState.CREATOR);
        this.mActive = r100.createStringArrayList();
        this.mAdded = r100.createStringArrayList();
        this.mBackStack = (BackStackRecordState[]) r100.createTypedArray(BackStackRecordState.CREATOR);
        this.mBackStackIndex = r100.readInt();
        this.mPrimaryNavActiveWho = r100.readString();
        this.mBackStackStateKeys = r100.createStringArrayList();
        this.mBackStackStates = r100.createTypedArrayList(BackStackState.CREATOR);
        this.mResultKeys = r100.createStringArrayList();
        this.mResults = r100.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = r100.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.mSavedState);
        r100.writeStringList(this.mActive);
        r100.writeStringList(this.mAdded);
        r100.writeTypedArray(this.mBackStack, r101);
        r100.writeInt(this.mBackStackIndex);
        r100.writeString(this.mPrimaryNavActiveWho);
        r100.writeStringList(this.mBackStackStateKeys);
        r100.writeTypedList(this.mBackStackStates);
        r100.writeStringList(this.mResultKeys);
        r100.writeTypedList(this.mResults);
        r100.writeTypedList(this.mLaunchedFragments);
    }
}
