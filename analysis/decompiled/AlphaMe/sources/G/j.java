package G;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.app.C0878x;

/* loaded from: classes.dex */
public final class j implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final C0878x f466a;

    public j(C0878x c0878x) {
        this.f466a = c0878x;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        this.f466a.getClass();
        return C0878x.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        this.f466a.getClass();
        return C0878x.b(i4);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        this.f466a.getClass();
        return C0878x.a(parcel, classLoader);
    }
}
