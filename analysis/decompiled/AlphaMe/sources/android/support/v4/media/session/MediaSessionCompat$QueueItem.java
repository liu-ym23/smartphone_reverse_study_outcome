package android.support.v4.media.session;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import b.C0354a;

/* loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new C0354a(5);

    /* renamed from: a, reason: collision with root package name */
    public final MediaDescriptionCompat f2338a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2339b;

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f2338a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f2339b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
        sb.append(this.f2338a);
        sb.append(", Id=");
        return g.p(sb, this.f2339b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        this.f2338a.writeToParcel(parcel, i4);
        parcel.writeLong(this.f2339b);
    }
}
