package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.G;
import androidx.lifecycle.AbstractC0533m;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0507b implements Parcelable {
    public static final Parcelable.Creator<C0507b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final int[] f10520a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<String> f10521b;

    /* renamed from: c, reason: collision with root package name */
    final int[] f10522c;

    /* renamed from: d, reason: collision with root package name */
    final int[] f10523d;

    /* renamed from: e, reason: collision with root package name */
    final int f10524e;

    /* renamed from: f, reason: collision with root package name */
    final String f10525f;

    /* renamed from: g, reason: collision with root package name */
    final int f10526g;

    /* renamed from: h, reason: collision with root package name */
    final int f10527h;

    /* renamed from: i, reason: collision with root package name */
    final CharSequence f10528i;

    /* renamed from: j, reason: collision with root package name */
    final int f10529j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f10530k;

    /* renamed from: l, reason: collision with root package name */
    final ArrayList<String> f10531l;

    /* renamed from: m, reason: collision with root package name */
    final ArrayList<String> f10532m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f10533n;

    /* renamed from: androidx.fragment.app.b$a */
    class a implements Parcelable.Creator<C0507b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0507b createFromParcel(Parcel parcel) {
            return new C0507b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0507b[] newArray(int i5) {
            return new C0507b[i5];
        }
    }

    C0507b(C0506a c0506a) {
        int size = c0506a.f10430c.size();
        this.f10520a = new int[size * 6];
        if (!c0506a.f10436i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f10521b = new ArrayList<>(size);
        this.f10522c = new int[size];
        this.f10523d = new int[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            G.a aVar = c0506a.f10430c.get(i6);
            int i7 = i5 + 1;
            this.f10520a[i5] = aVar.f10447a;
            ArrayList<String> arrayList = this.f10521b;
            ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
            arrayList.add(componentCallbacksC0511f != null ? componentCallbacksC0511f.f10637f : null);
            int[] iArr = this.f10520a;
            iArr[i7] = aVar.f10449c ? 1 : 0;
            iArr[i5 + 2] = aVar.f10450d;
            iArr[i5 + 3] = aVar.f10451e;
            int i8 = i5 + 5;
            iArr[i5 + 4] = aVar.f10452f;
            i5 += 6;
            iArr[i8] = aVar.f10453g;
            this.f10522c[i6] = aVar.f10454h.ordinal();
            this.f10523d[i6] = aVar.f10455i.ordinal();
        }
        this.f10524e = c0506a.f10435h;
        this.f10525f = c0506a.f10438k;
        this.f10526g = c0506a.f10518v;
        this.f10527h = c0506a.f10439l;
        this.f10528i = c0506a.f10440m;
        this.f10529j = c0506a.f10441n;
        this.f10530k = c0506a.f10442o;
        this.f10531l = c0506a.f10443p;
        this.f10532m = c0506a.f10444q;
        this.f10533n = c0506a.f10445r;
    }

    private void a(C0506a c0506a) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z5 = true;
            if (i5 >= this.f10520a.length) {
                c0506a.f10435h = this.f10524e;
                c0506a.f10438k = this.f10525f;
                c0506a.f10436i = true;
                c0506a.f10439l = this.f10527h;
                c0506a.f10440m = this.f10528i;
                c0506a.f10441n = this.f10529j;
                c0506a.f10442o = this.f10530k;
                c0506a.f10443p = this.f10531l;
                c0506a.f10444q = this.f10532m;
                c0506a.f10445r = this.f10533n;
                return;
            }
            G.a aVar = new G.a();
            int i7 = i5 + 1;
            aVar.f10447a = this.f10520a[i5];
            if (x.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0506a + " op #" + i6 + " base fragment #" + this.f10520a[i7]);
            }
            aVar.f10454h = AbstractC0533m.b.values()[this.f10522c[i6]];
            aVar.f10455i = AbstractC0533m.b.values()[this.f10523d[i6]];
            int[] iArr = this.f10520a;
            int i8 = i5 + 2;
            if (iArr[i7] == 0) {
                z5 = false;
            }
            aVar.f10449c = z5;
            int i9 = iArr[i8];
            aVar.f10450d = i9;
            int i10 = iArr[i5 + 3];
            aVar.f10451e = i10;
            int i11 = i5 + 5;
            int i12 = iArr[i5 + 4];
            aVar.f10452f = i12;
            i5 += 6;
            int i13 = iArr[i11];
            aVar.f10453g = i13;
            c0506a.f10431d = i9;
            c0506a.f10432e = i10;
            c0506a.f10433f = i12;
            c0506a.f10434g = i13;
            c0506a.f(aVar);
            i6++;
        }
    }

    public C0506a c(x xVar) {
        C0506a c0506a = new C0506a(xVar);
        a(c0506a);
        c0506a.f10518v = this.f10526g;
        for (int i5 = 0; i5 < this.f10521b.size(); i5++) {
            String str = this.f10521b.get(i5);
            if (str != null) {
                c0506a.f10430c.get(i5).f10448b = xVar.d0(str);
            }
        }
        c0506a.x(1);
        return c0506a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeIntArray(this.f10520a);
        parcel.writeStringList(this.f10521b);
        parcel.writeIntArray(this.f10522c);
        parcel.writeIntArray(this.f10523d);
        parcel.writeInt(this.f10524e);
        parcel.writeString(this.f10525f);
        parcel.writeInt(this.f10526g);
        parcel.writeInt(this.f10527h);
        TextUtils.writeToParcel(this.f10528i, parcel, 0);
        parcel.writeInt(this.f10529j);
        TextUtils.writeToParcel(this.f10530k, parcel, 0);
        parcel.writeStringList(this.f10531l);
        parcel.writeStringList(this.f10532m);
        parcel.writeInt(this.f10533n ? 1 : 0);
    }

    C0507b(Parcel parcel) {
        this.f10520a = parcel.createIntArray();
        this.f10521b = parcel.createStringArrayList();
        this.f10522c = parcel.createIntArray();
        this.f10523d = parcel.createIntArray();
        this.f10524e = parcel.readInt();
        this.f10525f = parcel.readString();
        this.f10526g = parcel.readInt();
        this.f10527h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f10528i = (CharSequence) creator.createFromParcel(parcel);
        this.f10529j = parcel.readInt();
        this.f10530k = (CharSequence) creator.createFromParcel(parcel);
        this.f10531l = parcel.createStringArrayList();
        this.f10532m = parcel.createStringArrayList();
        this.f10533n = parcel.readInt() != 0;
    }
}
