package androidx.compose.foundation.lazy.layout;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class DefaultLazyKey implements Parcelable {
    private final int index;
    public static final b Companion = new b();
    public static final Parcelable.Creator<DefaultLazyKey> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<DefaultLazyKey> {
        @Override // android.os.Parcelable.Creator
        public final DefaultLazyKey createFromParcel(Parcel parcel) {
            return new DefaultLazyKey(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final DefaultLazyKey[] newArray(int i10) {
            return new DefaultLazyKey[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public DefaultLazyKey(int i10) {
        this.index = i10;
    }

    private final int component1() {
        return this.index;
    }

    public static /* synthetic */ DefaultLazyKey copy$default(DefaultLazyKey defaultLazyKey, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = defaultLazyKey.index;
        }
        return defaultLazyKey.copy(i10);
    }

    public final DefaultLazyKey copy(int i10) {
        return new DefaultLazyKey(i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DefaultLazyKey) && this.index == ((DefaultLazyKey) obj).index;
    }

    public int hashCode() {
        return Integer.hashCode(this.index);
    }

    public String toString() {
        return a0.a.l(new StringBuilder("DefaultLazyKey(index="), this.index, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.index);
    }
}
