package H0;

import A0.d;
import H0.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0033b<Data> f1958a;

    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: H0.b$a$a, reason: collision with other inner class name */
        class C0032a implements InterfaceC0033b<ByteBuffer> {
            C0032a() {
            }

            @Override // H0.b.InterfaceC0033b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // H0.b.InterfaceC0033b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // H0.o
        public n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0032a());
        }

        @Override // H0.o
        public void b() {
        }
    }

    /* renamed from: H0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0033b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class c<Data> implements A0.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f1960a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0033b<Data> f1961b;

        c(byte[] bArr, InterfaceC0033b<Data> interfaceC0033b) {
            this.f1960a = bArr;
            this.f1961b = interfaceC0033b;
        }

        @Override // A0.d
        public Class<Data> a() {
            return this.f1961b.a();
        }

        @Override // A0.d
        public void b() {
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        @Override // A0.d
        public void e(v0.g gVar, d.a<? super Data> aVar) {
            aVar.f(this.f1961b.b(this.f1960a));
        }
    }

    public static class d implements o<byte[], InputStream> {

        class a implements InterfaceC0033b<InputStream> {
            a() {
            }

            @Override // H0.b.InterfaceC0033b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // H0.b.InterfaceC0033b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // H0.o
        public n<byte[], InputStream> a(r rVar) {
            return new b(new a());
        }

        @Override // H0.o
        public void b() {
        }
    }

    public b(InterfaceC0033b<Data> interfaceC0033b) {
        this.f1958a = interfaceC0033b;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(byte[] bArr, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(bArr), new c(bArr, this.f1958a));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }
}
