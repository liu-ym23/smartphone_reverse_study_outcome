package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class AppCompatDelegateImpl$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl$PanelFeatureState$SavedState> CREATOR = new D();

    /* renamed from: a, reason: collision with root package name */
    public int f2460a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2461b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f2462c;

    public static AppCompatDelegateImpl$PanelFeatureState$SavedState c(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.f2460a = parcel.readInt();
        boolean z4 = parcel.readInt() == 1;
        appCompatDelegateImpl$PanelFeatureState$SavedState.f2461b = z4;
        if (z4) {
            appCompatDelegateImpl$PanelFeatureState$SavedState.f2462c = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2460a);
        parcel.writeInt(this.f2461b ? 1 : 0);
        if (this.f2461b) {
            parcel.writeBundle(this.f2462c);
        }
    }
}
