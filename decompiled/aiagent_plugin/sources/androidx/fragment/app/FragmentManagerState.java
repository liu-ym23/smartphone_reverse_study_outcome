package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<FragmentState> mActive;
    ArrayList<String> mAdded;
    BackStackState[] mBackStack;
    int mBackStackIndex;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho;
    ArrayList<String> mResultKeys;
    ArrayList<Bundle> mResults;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
    }

    public FragmentManagerState(Parcel r4) {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
        this.mActive = r4.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = r4.createStringArrayList();
        this.mBackStack = (BackStackState[]) ZeusTransformUtils.preCheckCast(r4.createTypedArray(BackStackState.CREATOR), BackStackState[].class, "com.obric.aiagent.plugin");
        this.mBackStackIndex = r4.readInt();
        this.mPrimaryNavActiveWho = r4.readString();
        this.mResultKeys = r4.createStringArrayList();
        this.mResults = r4.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = r4.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeTypedList(this.mActive);
        r2.writeStringList(this.mAdded);
        r2.writeTypedArray(this.mBackStack, r3);
        r2.writeInt(this.mBackStackIndex);
        r2.writeString(this.mPrimaryNavActiveWho);
        r2.writeStringList(this.mResultKeys);
        r2.writeTypedList(this.mResults);
        r2.writeTypedList(this.mLaunchedFragments);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
