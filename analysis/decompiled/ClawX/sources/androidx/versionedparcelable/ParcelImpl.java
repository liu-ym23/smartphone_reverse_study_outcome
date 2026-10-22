package androidx.versionedparcelable;

import a3.a;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import c1.b;
import c1.c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a(5);

    /* renamed from: a, reason: collision with root package name */
    public final c f805a;

    public ParcelImpl(Parcel parcel) {
        this.f805a = new b(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new b(parcel).i(this.f805a);
    }
}
