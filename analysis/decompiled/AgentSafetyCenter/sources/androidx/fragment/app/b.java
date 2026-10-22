package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.os.a(1);

    /* renamed from: c, reason: collision with root package name */
    public int[] f1252c;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f1253f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f1254g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f1255h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public String f1256j;

    /* renamed from: k, reason: collision with root package name */
    public int f1257k;

    /* renamed from: l, reason: collision with root package name */
    public int f1258l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f1259m;

    /* renamed from: n, reason: collision with root package name */
    public int f1260n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f1261o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f1262p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f1263q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1264r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1252c);
        parcel.writeStringList(this.f1253f);
        parcel.writeIntArray(this.f1254g);
        parcel.writeIntArray(this.f1255h);
        parcel.writeInt(this.i);
        parcel.writeString(this.f1256j);
        parcel.writeInt(this.f1257k);
        parcel.writeInt(this.f1258l);
        TextUtils.writeToParcel(this.f1259m, parcel, 0);
        parcel.writeInt(this.f1260n);
        TextUtils.writeToParcel(this.f1261o, parcel, 0);
        parcel.writeStringList(this.f1262p);
        parcel.writeStringList(this.f1263q);
        parcel.writeInt(this.f1264r ? 1 : 0);
    }
}
