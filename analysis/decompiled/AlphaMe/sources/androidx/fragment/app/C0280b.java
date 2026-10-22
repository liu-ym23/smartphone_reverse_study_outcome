package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0280b implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3714a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3714a) {
            case 0:
                return new BackStackRecordState(parcel);
            case 1:
                return new BackStackState(parcel);
            case 2:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo();
                fragmentManager$LaunchedFragmentInfo.f3593a = parcel.readString();
                fragmentManager$LaunchedFragmentInfo.f3594b = parcel.readInt();
                return fragmentManager$LaunchedFragmentInfo;
            case 3:
                FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.f3599e = null;
                fragmentManagerState.f3600f = new ArrayList();
                fragmentManagerState.f3601g = new ArrayList();
                fragmentManagerState.f3595a = parcel.createStringArrayList();
                fragmentManagerState.f3596b = parcel.createStringArrayList();
                fragmentManagerState.f3597c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
                fragmentManagerState.f3598d = parcel.readInt();
                fragmentManagerState.f3599e = parcel.readString();
                fragmentManagerState.f3600f = parcel.createStringArrayList();
                fragmentManagerState.f3601g = parcel.createTypedArrayList(BackStackState.CREATOR);
                fragmentManagerState.f3602h = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
                return fragmentManagerState;
            case 4:
                return new FragmentState(parcel);
            default:
                FragmentTabHost$SavedState fragmentTabHost$SavedState = new FragmentTabHost$SavedState(parcel);
                fragmentTabHost$SavedState.f3616a = parcel.readString();
                return fragmentTabHost$SavedState;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f3714a) {
            case 0:
                return new BackStackRecordState[i4];
            case 1:
                return new BackStackState[i4];
            case 2:
                return new FragmentManager$LaunchedFragmentInfo[i4];
            case 3:
                return new FragmentManagerState[i4];
            case 4:
                return new FragmentState[i4];
            default:
                return new FragmentTabHost$SavedState[i4];
        }
    }
}
