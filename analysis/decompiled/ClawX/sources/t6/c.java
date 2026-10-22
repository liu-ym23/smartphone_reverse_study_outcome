package t6;

import java.io.IOException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.p;
import n6.m;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: e, reason: collision with root package name */
    public long f5589e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5590f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f5591g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, m url) {
        super(fVar, url);
        p.e(url, "url");
        this.f5591g = fVar;
        this.f5589e = -1L;
        this.f5590f = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws NumberFormatException {
        boolean zG;
        if (this.f5588c) {
            return;
        }
        if (this.f5590f) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeZone timeZone = o6.f.f4330a;
            p.e(timeUnit, "timeUnit");
            try {
                zG = o6.f.g(this, 100);
            } catch (IOException unused) {
                zG = false;
            }
            if (!zG) {
                this.f5591g.f5597b.g();
                a(f.f5595f);
            }
        }
        this.f5588c = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
    
        if (r16.f5590f == false) goto L46;
     */
    @Override // t6.b, c7.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(long r17, c7.f r19) throws java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.c.h(long, c7.f):long");
    }
}
