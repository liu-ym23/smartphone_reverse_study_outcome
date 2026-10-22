package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class FragmentTabHost$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<FragmentTabHost$SavedState> CREATOR = new a();
    String curTab;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<FragmentTabHost$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
            return new FragmentTabHost$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentTabHost$SavedState[] newArray(int i10) {
            return new FragmentTabHost$SavedState[i10];
        }
    }

    public FragmentTabHost$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentTabHost.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" curTab=");
        return ai.onnxruntime.a.o(sb2, this.curTab, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.curTab);
    }

    public FragmentTabHost$SavedState(Parcel parcel) {
        super(parcel);
        this.curTab = parcel.readString();
    }
}
