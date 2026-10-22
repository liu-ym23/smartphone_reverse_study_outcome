package C4;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class E {

    class a extends E {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ L4.h f691b;

        a(y yVar, L4.h hVar) {
            this.f690a = yVar;
            this.f691b = hVar;
        }

        @Override // C4.E
        public long a() {
            return this.f691b.w();
        }

        @Override // C4.E
        @Nullable
        public y b() {
            return this.f690a;
        }

        @Override // C4.E
        public void h(L4.f fVar) {
            fVar.R(this.f691b);
        }
    }

    class b extends E {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f692a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f693b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f694c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f695d;

        b(y yVar, int i5, byte[] bArr, int i6) {
            this.f692a = yVar;
            this.f693b = i5;
            this.f694c = bArr;
            this.f695d = i6;
        }

        @Override // C4.E
        public long a() {
            return this.f693b;
        }

        @Override // C4.E
        @Nullable
        public y b() {
            return this.f692a;
        }

        @Override // C4.E
        public void h(L4.f fVar) {
            fVar.write(this.f694c, this.f695d, this.f693b);
        }
    }

    public static E c(@Nullable y yVar, L4.h hVar) {
        return new a(yVar, hVar);
    }

    public static E d(@Nullable y yVar, byte[] bArr) {
        return e(yVar, bArr, 0, bArr.length);
    }

    public static E e(@Nullable y yVar, byte[] bArr, int i5, int i6) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        D4.e.f(bArr.length, i5, i6);
        return new b(yVar, i6, bArr, i5);
    }

    public long a() {
        return -1L;
    }

    @Nullable
    public abstract y b();

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract void h(L4.f fVar);
}
