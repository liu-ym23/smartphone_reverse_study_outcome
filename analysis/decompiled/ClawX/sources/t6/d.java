package t6;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.p;
import n6.k;
import n6.m;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: e, reason: collision with root package name */
    public long f5592e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f f5593f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, m url, long j4) throws NumberFormatException {
        super(fVar, url);
        p.e(url, "url");
        this.f5593f = fVar;
        this.f5592e = j4;
        if (j4 == 0) {
            a(k.f4053b);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws NumberFormatException {
        boolean zG;
        if (this.f5588c) {
            return;
        }
        if (this.f5592e != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeZone timeZone = o6.f.f4330a;
            p.e(timeUnit, "timeUnit");
            try {
                zG = o6.f.g(this, 100);
            } catch (IOException unused) {
                zG = false;
            }
            if (!zG) {
                this.f5593f.f5597b.g();
                a(f.f5595f);
            }
        }
        this.f5588c = true;
    }

    @Override // t6.b, c7.v
    public final long h(long j4, c7.f fVar) throws NumberFormatException, IOException {
        if (this.f5588c) {
            throw new IllegalStateException("closed");
        }
        long j8 = this.f5592e;
        if (j8 == 0) {
            return -1L;
        }
        long jH = super.h(Math.min(j8, 8192L), fVar);
        if (jH == -1) {
            this.f5593f.f5597b.g();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(f.f5595f);
            throw protocolException;
        }
        long j9 = this.f5592e - jH;
        this.f5592e = j9;
        if (j9 == 0) {
            a(k.f4053b);
        }
        return jH;
    }
}
