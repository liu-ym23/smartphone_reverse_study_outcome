package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import b.C0354a;
import e.EnumC0546d;
import java.lang.reflect.InvocationTargetException;
import q0.C0823b;
import q0.InterfaceC0824c;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C0354a(23);

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0824c f4271a;

    public ParcelImpl(Parcel parcel) {
        this.f4271a = new C0823b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new C0823b(parcel).k(this.f4271a);
    }
}
