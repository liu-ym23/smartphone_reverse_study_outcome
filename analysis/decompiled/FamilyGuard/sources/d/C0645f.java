package d;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import j4.g;
import j4.k;

/* renamed from: d.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0645f implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private final IntentSender f16563a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f16564b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16565c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16566d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f16562e = new c(null);
    public static final Parcelable.Creator<C0645f> CREATOR = new b();

    /* renamed from: d.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final IntentSender f16567a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f16568b;

        /* renamed from: c, reason: collision with root package name */
        private int f16569c;

        /* renamed from: d, reason: collision with root package name */
        private int f16570d;

        public a(IntentSender intentSender) {
            k.g(intentSender, "intentSender");
            this.f16567a = intentSender;
        }

        public final C0645f a() {
            return new C0645f(this.f16567a, this.f16568b, this.f16569c, this.f16570d);
        }

        public final a b(Intent intent) {
            this.f16568b = intent;
            return this;
        }

        public final a c(int i5, int i6) {
            this.f16570d = i5;
            this.f16569c = i6;
            return this;
        }
    }

    /* renamed from: d.f$b */
    public static final class b implements Parcelable.Creator<C0645f> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0645f createFromParcel(Parcel parcel) {
            k.g(parcel, "inParcel");
            return new C0645f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0645f[] newArray(int i5) {
            return new C0645f[i5];
        }
    }

    /* renamed from: d.f$c */
    public static final class c {
        public /* synthetic */ c(g gVar) {
            this();
        }

        private c() {
        }
    }

    public C0645f(IntentSender intentSender, Intent intent, int i5, int i6) {
        k.g(intentSender, "intentSender");
        this.f16563a = intentSender;
        this.f16564b = intent;
        this.f16565c = i5;
        this.f16566d = i6;
    }

    public final IntentSender A() {
        return this.f16563a;
    }

    public final Intent a() {
        return this.f16564b;
    }

    public final int c() {
        return this.f16565c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int f() {
        return this.f16566d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        k.g(parcel, "dest");
        parcel.writeParcelable(this.f16563a, i5);
        parcel.writeParcelable(this.f16564b, i5);
        parcel.writeInt(this.f16565c);
        parcel.writeInt(this.f16566d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0645f(Parcel parcel) {
        k.g(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        k.d(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
