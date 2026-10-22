package m2;

import android.net.Uri;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f6141a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6142b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6143c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6144d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6145e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6146f;

    public d(Uri uri, int i2, int i10, boolean z4, String str, int i11) {
        uri.getClass();
        this.f6141a = uri;
        this.f6142b = i2;
        this.f6143c = i10;
        this.f6144d = z4;
        this.f6145e = str;
        this.f6146f = i11;
    }

    public d(String str, String str2) {
        this.f6141a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f6142b = 0;
        this.f6143c = 400;
        this.f6144d = false;
        this.f6145e = str2;
        this.f6146f = 0;
    }
}
