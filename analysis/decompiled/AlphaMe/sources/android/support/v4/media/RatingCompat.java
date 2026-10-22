package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import b.C0354a;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new C0354a(4);

    /* renamed from: a, reason: collision with root package name */
    public final int f2336a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2337b;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface Style {
    }

    public RatingCompat(int i4, float f4) {
        this.f2336a = i4;
        this.f2337b = f4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f2336a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f2336a);
        sb.append(" rating=");
        float f4 = this.f2337b;
        sb.append(f4 < Property.DEFAULT_FLOAT_VALUE ? "unrated" : String.valueOf(f4));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2336a);
        parcel.writeFloat(this.f2337b);
    }
}
