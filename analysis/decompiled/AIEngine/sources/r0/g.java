package r0;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.app.AppCompatDelegateImplV7;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g<T> implements Parcelable.ClassLoaderCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatDelegateImplV7.PanelFeatureState.SavedState.a f11680a;

    public g(AppCompatDelegateImplV7.PanelFeatureState.SavedState.a aVar) {
        this.f11680a = aVar;
    }

    @Override // android.os.Parcelable.Creator
    public final T createFromParcel(Parcel parcel) {
        return (T) this.f11680a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final T[] newArray(int i10) {
        return (T[]) this.f11680a.b(i10);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return (T) this.f11680a.a(parcel, classLoader);
    }
}
