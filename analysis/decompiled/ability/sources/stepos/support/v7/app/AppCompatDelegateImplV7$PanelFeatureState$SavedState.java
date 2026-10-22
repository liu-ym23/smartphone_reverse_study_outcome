package stepos.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.ParcelableCompat;

/* loaded from: classes4.dex */
class AppCompatDelegateImplV7$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImplV7$PanelFeatureState$SavedState> CREATOR = ParcelableCompat.newCreator(new C1973w(0));
    int featureId;
    boolean isOpen;
    Bundle menuState;

    private AppCompatDelegateImplV7$PanelFeatureState$SavedState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AppCompatDelegateImplV7$PanelFeatureState$SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImplV7$PanelFeatureState$SavedState appCompatDelegateImplV7$PanelFeatureState$SavedState = new AppCompatDelegateImplV7$PanelFeatureState$SavedState();
        appCompatDelegateImplV7$PanelFeatureState$SavedState.featureId = parcel.readInt();
        boolean z10 = parcel.readInt() == 1;
        appCompatDelegateImplV7$PanelFeatureState$SavedState.isOpen = z10;
        if (z10) {
            appCompatDelegateImplV7$PanelFeatureState$SavedState.menuState = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImplV7$PanelFeatureState$SavedState;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.featureId);
        parcel.writeInt(this.isOpen ? 1 : 0);
        if (this.isOpen) {
            parcel.writeBundle(this.menuState);
        }
    }

    public /* synthetic */ AppCompatDelegateImplV7$PanelFeatureState$SavedState(r rVar) {
        this();
    }
}
