package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcelable;", "y1/f", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class NavBackStackEntryState implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new C0354a(22);

    /* renamed from: a, reason: collision with root package name */
    public final String f3998a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3999b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f4000c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f4001d;

    public NavBackStackEntryState(Parcel inParcel) {
        Intrinsics.checkNotNullParameter(inParcel, "inParcel");
        String string = inParcel.readString();
        Intrinsics.checkNotNull(string);
        this.f3998a = string;
        this.f3999b = inParcel.readInt();
        this.f4000c = inParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        Bundle bundle = inParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        Intrinsics.checkNotNull(bundle);
        this.f4001d = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f3998a);
        parcel.writeInt(this.f3999b);
        parcel.writeBundle(this.f4000c);
        parcel.writeBundle(this.f4001d);
    }
}
