package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new C0280b(0);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3569a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3570b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f3571c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3572d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3573e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3574f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3575g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3576h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f3577i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3578j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f3579k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f3580l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f3581m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3582n;

    public BackStackRecordState(C0279a c0279a) {
        int size = c0279a.f3688a.size();
        this.f3569a = new int[size * 6];
        if (!c0279a.f3694g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3570b = new ArrayList(size);
        this.f3571c = new int[size];
        this.f3572d = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            e0 e0Var = (e0) c0279a.f3688a.get(i5);
            int i6 = i4 + 1;
            this.f3569a[i4] = e0Var.f3735a;
            ArrayList arrayList = this.f3570b;
            D d4 = e0Var.f3736b;
            arrayList.add(d4 != null ? d4.mWho : null);
            int[] iArr = this.f3569a;
            iArr[i6] = e0Var.f3737c ? 1 : 0;
            iArr[i4 + 2] = e0Var.f3738d;
            iArr[i4 + 3] = e0Var.f3739e;
            int i7 = i4 + 5;
            iArr[i4 + 4] = e0Var.f3740f;
            i4 += 6;
            iArr[i7] = e0Var.f3741g;
            this.f3571c[i5] = e0Var.f3742h.ordinal();
            this.f3572d[i5] = e0Var.f3743i.ordinal();
        }
        this.f3573e = c0279a.f3693f;
        this.f3574f = c0279a.f3696i;
        this.f3575g = c0279a.f3706s;
        this.f3576h = c0279a.f3697j;
        this.f3577i = c0279a.f3698k;
        this.f3578j = c0279a.f3699l;
        this.f3579k = c0279a.f3700m;
        this.f3580l = c0279a.f3701n;
        this.f3581m = c0279a.f3702o;
        this.f3582n = c0279a.f3703p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeIntArray(this.f3569a);
        parcel.writeStringList(this.f3570b);
        parcel.writeIntArray(this.f3571c);
        parcel.writeIntArray(this.f3572d);
        parcel.writeInt(this.f3573e);
        parcel.writeString(this.f3574f);
        parcel.writeInt(this.f3575g);
        parcel.writeInt(this.f3576h);
        TextUtils.writeToParcel(this.f3577i, parcel, 0);
        parcel.writeInt(this.f3578j);
        TextUtils.writeToParcel(this.f3579k, parcel, 0);
        parcel.writeStringList(this.f3580l);
        parcel.writeStringList(this.f3581m);
        parcel.writeInt(this.f3582n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f3569a = parcel.createIntArray();
        this.f3570b = parcel.createStringArrayList();
        this.f3571c = parcel.createIntArray();
        this.f3572d = parcel.createIntArray();
        this.f3573e = parcel.readInt();
        this.f3574f = parcel.readString();
        this.f3575g = parcel.readInt();
        this.f3576h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3577i = (CharSequence) creator.createFromParcel(parcel);
        this.f3578j = parcel.readInt();
        this.f3579k = (CharSequence) creator.createFromParcel(parcel);
        this.f3580l = parcel.createStringArrayList();
        this.f3581m = parcel.createStringArrayList();
        this.f3582n = parcel.readInt() != 0;
    }
}
