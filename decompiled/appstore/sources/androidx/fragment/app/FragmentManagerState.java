package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
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

    public class a implements Parcelable.Creator {
        public a() {
        }

        public FragmentManagerState a(Parcel r10) {
            return new FragmentManagerState(r10);
        }

        public FragmentManagerState[] b(int r10) {
            return new FragmentManagerState[r10];
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

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeStringList(this.mActive);
        r10.writeStringList(this.mAdded);
        r10.writeTypedArray(this.mBackStack, r11);
        r10.writeInt(this.mBackStackIndex);
        r10.writeString(this.mPrimaryNavActiveWho);
        r10.writeStringList(this.mBackStackStateKeys);
        r10.writeTypedList(this.mBackStackStates);
        r10.writeTypedList(this.mLaunchedFragments);
    }

    public FragmentManagerState(Parcel r10) {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
        this.mActive = r10.createStringArrayList();
        this.mAdded = r10.createStringArrayList();
        this.mBackStack = (BackStackRecordState[]) r10.createTypedArray(BackStackRecordState.CREATOR);
        this.mBackStackIndex = r10.readInt();
        this.mPrimaryNavActiveWho = r10.readString();
        this.mBackStackStateKeys = r10.createStringArrayList();
        this.mBackStackStates = r10.createTypedArrayList(BackStackState.CREATOR);
        this.mLaunchedFragments = r10.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
