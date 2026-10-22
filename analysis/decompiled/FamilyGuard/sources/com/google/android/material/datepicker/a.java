package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0164a();

    /* renamed from: a, reason: collision with root package name */
    private final p f12647a;

    /* renamed from: b, reason: collision with root package name */
    private final p f12648b;

    /* renamed from: c, reason: collision with root package name */
    private final c f12649c;

    /* renamed from: d, reason: collision with root package name */
    private p f12650d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12651e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12652f;

    /* renamed from: g, reason: collision with root package name */
    private final int f12653g;

    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    class C0164a implements Parcelable.Creator<a> {
        C0164a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((p) parcel.readParcelable(p.class.getClassLoader()), (p) parcel.readParcelable(p.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (p) parcel.readParcelable(p.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        static final long f12654f = w.a(p.G(1900, 0).f12772f);

        /* renamed from: g, reason: collision with root package name */
        static final long f12655g = w.a(p.G(2100, 11).f12772f);

        /* renamed from: a, reason: collision with root package name */
        private long f12656a;

        /* renamed from: b, reason: collision with root package name */
        private long f12657b;

        /* renamed from: c, reason: collision with root package name */
        private Long f12658c;

        /* renamed from: d, reason: collision with root package name */
        private int f12659d;

        /* renamed from: e, reason: collision with root package name */
        private c f12660e;

        b(a aVar) {
            this.f12656a = f12654f;
            this.f12657b = f12655g;
            this.f12660e = f.a(Long.MIN_VALUE);
            this.f12656a = aVar.f12647a.f12772f;
            this.f12657b = aVar.f12648b.f12772f;
            this.f12658c = Long.valueOf(aVar.f12650d.f12772f);
            this.f12659d = aVar.f12651e;
            this.f12660e = aVar.f12649c;
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f12660e);
            p pVarH = p.H(this.f12656a);
            p pVarH2 = p.H(this.f12657b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l5 = this.f12658c;
            return new a(pVarH, pVarH2, cVar, l5 == null ? null : p.H(l5.longValue()), this.f12659d, null);
        }

        public b b(long j5) {
            this.f12658c = Long.valueOf(j5);
            return this;
        }
    }

    public interface c extends Parcelable {
        boolean r(long j5);
    }

    /* synthetic */ a(p pVar, p pVar2, c cVar, p pVar3, int i5, C0164a c0164a) {
        this(pVar, pVar2, cVar, pVar3, i5);
    }

    p D(p pVar) {
        return pVar.compareTo(this.f12647a) < 0 ? this.f12647a : pVar.compareTo(this.f12648b) > 0 ? this.f12648b : pVar;
    }

    public c F() {
        return this.f12649c;
    }

    p G() {
        return this.f12648b;
    }

    int H() {
        return this.f12651e;
    }

    int I() {
        return this.f12653g;
    }

    p J() {
        return this.f12650d;
    }

    p K() {
        return this.f12647a;
    }

    int L() {
        return this.f12652f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12647a.equals(aVar.f12647a) && this.f12648b.equals(aVar.f12648b) && D.c.a(this.f12650d, aVar.f12650d) && this.f12651e == aVar.f12651e && this.f12649c.equals(aVar.f12649c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12647a, this.f12648b, this.f12650d, Integer.valueOf(this.f12651e), this.f12649c});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f12647a, 0);
        parcel.writeParcelable(this.f12648b, 0);
        parcel.writeParcelable(this.f12650d, 0);
        parcel.writeParcelable(this.f12649c, 0);
        parcel.writeInt(this.f12651e);
    }

    private a(p pVar, p pVar2, c cVar, p pVar3, int i5) {
        Objects.requireNonNull(pVar, "start cannot be null");
        Objects.requireNonNull(pVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f12647a = pVar;
        this.f12648b = pVar2;
        this.f12650d = pVar3;
        this.f12651e = i5;
        this.f12649c = cVar;
        if (pVar3 != null && pVar.compareTo(pVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (pVar3 != null && pVar3.compareTo(pVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i5 < 0 || i5 > w.i().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f12653g = pVar.P(pVar2) + 1;
        this.f12652f = (pVar2.f12769c - pVar.f12769c) + 1;
    }
}
