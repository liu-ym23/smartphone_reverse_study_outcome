package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes5.dex */
public abstract class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public int f35855a = 0;

    public UninitializedMessageException b() {
        return new UninitializedMessageException(this);
    }

    public void c(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(serializedSize) + serializedSize));
        codedOutputStreamJ.o0(serializedSize);
        a(codedOutputStreamJ);
        codedOutputStreamJ.I();
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0449a<BuilderType extends AbstractC0449a> implements h.a {
        public static UninitializedMessageException f(h hVar) {
            return new UninitializedMessageException(hVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        /* renamed from: d */
        public abstract BuilderType m(c cVar, d dVar) throws IOException;

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        public static final class C0450a extends FilterInputStream {

            /* renamed from: a, reason: collision with root package name */
            public int f35856a;

            public C0450a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f35856a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f35856a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f35856a <= 0) {
                    return -1;
                }
                int i10 = super.read();
                if (i10 >= 0) {
                    this.f35856a--;
                }
                return i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                long jSkip = super.skip(Math.min(j10, this.f35856a));
                if (jSkip >= 0) {
                    this.f35856a = (int) (this.f35856a - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f35856a;
                if (i12 <= 0) {
                    return -1;
                }
                int i13 = super.read(bArr, i10, Math.min(i11, i12));
                if (i13 >= 0) {
                    this.f35856a -= i13;
                }
                return i13;
            }
        }
    }
}
