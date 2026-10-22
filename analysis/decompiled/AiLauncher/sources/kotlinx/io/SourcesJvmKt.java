package kotlinx.io;

import com.autonavi.aps.amapapi.config.Const;
import fb.C4074a;
import fb.C4075b;
import fb.buffered;
import fb.v;
import fb.z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.p;
import kotlinx.io.SourcesJvmKt;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lfb/v;", "Ljava/io/InputStream;", Const.INTENT_KEY_PKGNAME, "(Lfb/v;)Ljava/io/InputStream;", "Ljava/nio/ByteBuffer;", "sink", "", Const.INTENT_KEY_UMID, "(Lfb/v;Ljava/nio/ByteBuffer;)I", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SourcesJvmKt {
    public static final InputStream b(final v vVar) {
        InterfaceC5063a interfaceC5063a;
        p.i(vVar, "<this>");
        if (vVar instanceof buffered) {
            interfaceC5063a = new MutablePropertyReference0Impl(vVar) { // from class: kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1
                @Override // w9.InterfaceC5753l
                public Object get() {
                    return Boolean.valueOf(((buffered) this.receiver).closed);
                }
            };
        } else {
            if (!(vVar instanceof C4074a)) {
                throw new NoWhenBranchMatchedException();
            }
            interfaceC5063a = new InterfaceC5063a() { // from class: fb.w
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(SourcesJvmKt.c());
                }
            };
        }
        return new a(interfaceC5063a, vVar);
    }

    public static final boolean c() {
        return false;
    }

    public static final int d(v vVar, ByteBuffer sink) {
        p.i(vVar, "<this>");
        p.i(sink, "sink");
        if (vVar.getBufferField().n() == 0) {
            vVar.request(8192L);
            if (vVar.getBufferField().n() == 0) {
                return -1;
            }
        }
        return C4075b.a(vVar.getBufferField(), sink);
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"kotlinx/io/SourcesJvmKt$a", "Ljava/io/InputStream;", "", "read", "()I", "", "data", "offset", "byteCount", "([BII)I", "available", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5063a<Boolean> f36832a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f36833b;

        public a(InterfaceC5063a<Boolean> interfaceC5063a, v vVar) {
            this.f36832a = interfaceC5063a;
            this.f36833b = vVar;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.f36832a.invoke().booleanValue()) {
                throw new IOException("Underlying source is closed.");
            }
            return (int) Math.min(this.f36833b.getBufferField().n(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f36833b.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f36832a.invoke().booleanValue()) {
                throw new IOException("Underlying source is closed.");
            }
            if (this.f36833b.k()) {
                return -1;
            }
            return this.f36833b.readByte() & 255;
        }

        public String toString() {
            return this.f36833b + ".asInputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int offset, int byteCount) throws IOException {
            p.i(data, "data");
            if (!this.f36832a.invoke().booleanValue()) {
                z.b(data.length, offset, byteCount);
                return this.f36833b.G0(data, offset, byteCount + offset);
            }
            throw new IOException("Underlying source is closed.");
        }
    }
}
