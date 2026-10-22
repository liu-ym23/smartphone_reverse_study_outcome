package d;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new android.support.v4.os.a(12);

    /* renamed from: c, reason: collision with root package name */
    public final IntentSender f2942c;

    /* renamed from: f, reason: collision with root package name */
    public final Intent f2943f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2944g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2945h;

    public j(IntentSender intentSender, Intent intent, int i, int i3) {
        this.f2942c = intentSender;
        this.f2943f = intent;
        this.f2944g = i;
        this.f2945h = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.f2942c, i);
        parcel.writeParcelable(this.f2943f, i);
        parcel.writeInt(this.f2944g);
        parcel.writeInt(this.f2945h);
    }
}
