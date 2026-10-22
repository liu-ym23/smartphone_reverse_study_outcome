package com.google.android.gms.common.images;

import a1.C0154a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.Arrays;
import java.util.Locale;
import t0.J;

@SafeParcelable.Class(creator = "WebImageCreator")
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new C0154a(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f9725a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f9726b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9727c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9728d;

    public WebImage(int i4, Uri uri, int i5, int i6) {
        this.f9725a = i4;
        this.f9726b = uri;
        this.f9727c = i5;
        this.f9728d = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (h.m(this.f9726b, webImage.f9726b) && this.f9727c == webImage.f9727c && this.f9728d == webImage.f9728d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9726b, Integer.valueOf(this.f9727c), Integer.valueOf(this.f9728d)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "Image " + this.f9727c + "x" + this.f9728d + AwarenessDataItem.PERMISSION_SPLITTER + this.f9726b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9725a);
        J.T(parcel, 2, this.f9726b, i4);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9727c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9728d);
        J.b0(parcel, iZ);
    }
}
