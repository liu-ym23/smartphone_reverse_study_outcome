package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0354a(2);

    /* renamed from: a, reason: collision with root package name */
    public final String f2326a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f2327b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f2328c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f2329d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f2330e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f2331f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f2332g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f2333h;

    /* renamed from: i, reason: collision with root package name */
    public Object f2334i;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f2326a = str;
        this.f2327b = charSequence;
        this.f2328c = charSequence2;
        this.f2329d = charSequence3;
        this.f2330e = bitmap;
        this.f2331f = uri;
        this.f2332g = bundle;
        this.f2333h = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f2327b) + ", " + ((Object) this.f2328c) + ", " + ((Object) this.f2329d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Object objBuild = this.f2334i;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f2326a);
            builder.setTitle(this.f2327b);
            builder.setSubtitle(this.f2328c);
            builder.setDescription(this.f2329d);
            builder.setIconBitmap(this.f2330e);
            builder.setIconUri(this.f2331f);
            builder.setExtras(this.f2332g);
            builder.setMediaUri(this.f2333h);
            objBuild = builder.build();
            this.f2334i = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i4);
    }
}
