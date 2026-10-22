package b0;

import android.net.Uri;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f834a;

    /* renamed from: b, reason: collision with root package name */
    public final int f835b;

    /* renamed from: c, reason: collision with root package name */
    public final int f836c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final String f837e;

    /* renamed from: f, reason: collision with root package name */
    public final int f838f;

    public k(Uri uri, int i8, int i9, boolean z, String str, int i10) {
        uri.getClass();
        this.f834a = uri;
        this.f835b = i8;
        this.f836c = i9;
        this.d = z;
        this.f837e = str;
        this.f838f = i10;
    }

    public k(String str, String str2) {
        this.f834a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f835b = 0;
        this.f836c = 400;
        this.d = false;
        this.f837e = str2;
        this.f838f = 0;
    }
}
