package android.support.v4.media.session;

import B0.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import b.C0354a;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import t0.J;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0354a(9);

    /* renamed from: a, reason: collision with root package name */
    public final int f2347a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2348b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2349c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2350d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2351e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2352f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f2353g;

    /* renamed from: h, reason: collision with root package name */
    public final long f2354h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f2355i;

    /* renamed from: j, reason: collision with root package name */
    public final long f2356j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f2357k;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface Actions {
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new e();

        /* renamed from: a, reason: collision with root package name */
        public final String f2358a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f2359b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2360c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f2361d;

        public CustomAction(Parcel parcel) {
            this.f2358a = parcel.readString();
            this.f2359b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2360c = parcel.readInt();
            this.f2361d = parcel.readBundle(J.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f2359b) + ", mIcon=" + this.f2360c + ", mExtras=" + this.f2361d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f2358a);
            TextUtils.writeToParcel(this.f2359b, parcel, i4);
            parcel.writeInt(this.f2360c);
            parcel.writeBundle(this.f2361d);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface State {
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f2347a = parcel.readInt();
        this.f2348b = parcel.readLong();
        this.f2350d = parcel.readFloat();
        this.f2354h = parcel.readLong();
        this.f2349c = parcel.readLong();
        this.f2351e = parcel.readLong();
        this.f2353g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2355i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f2356j = parcel.readLong();
        this.f2357k = parcel.readBundle(J.class.getClassLoader());
        this.f2352f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f2347a);
        sb.append(", position=");
        sb.append(this.f2348b);
        sb.append(", buffered position=");
        sb.append(this.f2349c);
        sb.append(", speed=");
        sb.append(this.f2350d);
        sb.append(", updated=");
        sb.append(this.f2354h);
        sb.append(", actions=");
        sb.append(this.f2351e);
        sb.append(", error code=");
        sb.append(this.f2352f);
        sb.append(", error message=");
        sb.append(this.f2353g);
        sb.append(", custom actions=");
        sb.append(this.f2355i);
        sb.append(", active item id=");
        return g.p(sb, this.f2356j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2347a);
        parcel.writeLong(this.f2348b);
        parcel.writeFloat(this.f2350d);
        parcel.writeLong(this.f2354h);
        parcel.writeLong(this.f2349c);
        parcel.writeLong(this.f2351e);
        TextUtils.writeToParcel(this.f2353g, parcel, i4);
        parcel.writeTypedList(this.f2355i);
        parcel.writeLong(this.f2356j);
        parcel.writeBundle(this.f2357k);
        parcel.writeInt(this.f2352f);
    }
}
