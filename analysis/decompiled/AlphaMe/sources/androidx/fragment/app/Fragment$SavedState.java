package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
/* loaded from: classes.dex */
public class Fragment$SavedState implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<Fragment$SavedState> CREATOR = new C();

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3588a;

    public Fragment$SavedState(Parcel parcel, ClassLoader classLoader) {
        Bundle bundle = parcel.readBundle();
        this.f3588a = bundle;
        if (classLoader == null || bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeBundle(this.f3588a);
    }
}
