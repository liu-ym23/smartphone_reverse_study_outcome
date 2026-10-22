package gb;

import ab.p;
import eb.m;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import q7.k;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: i, reason: collision with root package name */
    public final p f4040i;

    /* renamed from: j, reason: collision with root package name */
    public long f4041j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4042k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h f4043l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, p pVar) {
        super(hVar);
        k.e(pVar, "url");
        this.f4043l = hVar;
        this.f4040i = pVar;
        this.f4041j = -1L;
        this.f4042k = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f4035g) {
            return;
        }
        if (this.f4042k) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = bb.b.f1659a;
            k.e(timeUnit, "timeUnit");
            try {
                zU = bb.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((m) this.f4043l.f4054d).k();
                a();
            }
        }
        this.f4035g = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        if (r11.f4042k == false) goto L27;
     */
    @Override // gb.b, ob.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(ob.h r12, long r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.d.read(ob.h, long):long");
    }
}
