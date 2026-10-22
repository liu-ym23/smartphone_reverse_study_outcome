package d;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: d.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0640a implements Parcelable {
    public static final Parcelable.Creator<C0640a> CREATOR = new C0203a();

    /* renamed from: a, reason: collision with root package name */
    private final int f16539a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f16540b;

    /* renamed from: d.a$a, reason: collision with other inner class name */
    class C0203a implements Parcelable.Creator<C0640a> {
        C0203a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0640a createFromParcel(Parcel parcel) {
            return new C0640a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0640a[] newArray(int i5) {
            return new C0640a[i5];
        }
    }

    public C0640a(int i5, Intent intent) {
        this.f16539a = i5;
        this.f16540b = intent;
    }

    public static String f(int i5) {
        return i5 != -1 ? i5 != 0 ? String.valueOf(i5) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f16540b;
    }

    public int c() {
        return this.f16539a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + f(this.f16539a) + ", data=" + this.f16540b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f16539a);
        parcel.writeInt(this.f16540b == null ? 0 : 1);
        Intent intent = this.f16540b;
        if (intent != null) {
            intent.writeToParcel(parcel, i5);
        }
    }

    C0640a(Parcel parcel) {
        this.f16539a = parcel.readInt();
        this.f16540b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
