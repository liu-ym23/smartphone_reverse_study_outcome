package g5;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4308a;

    /* renamed from: b, reason: collision with root package name */
    public UUID f4309b;

    /* renamed from: c, reason: collision with root package name */
    public p5.p f4310c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f4311d;

    public e0(Class cls) {
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.f4309b = uuidRandomUUID;
        String string = this.f4309b.toString();
        string.getClass();
        this.f4310c = new p5.p(string, 0, cls.getName(), (String) null, (h) null, (h) null, 0L, 0L, 0L, (d) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, (String) null, 16777210);
        String[] strArr = {cls.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(kb.x.L(1));
        linkedHashSet.add(strArr[0]);
        this.f4311d = linkedHashSet;
    }

    public final f0 a() {
        f0 f0VarB = b();
        d dVar = this.f4310c.f9772j;
        boolean z10 = !dVar.i.isEmpty() || dVar.f4291e || dVar.f4289c || dVar.f4290d;
        p5.p pVar = this.f4310c;
        if (pVar.f9779q) {
            if (z10) {
                f.s("Expedited jobs only support network and storage constraints");
                return null;
            }
            if (pVar.f9770g > 0) {
                f.s("Expedited jobs cannot be delayed");
                return null;
            }
        }
        if (pVar.f9786x == null) {
            List listO0 = hc.h.o0(pVar.f9766c, new String[]{"."});
            String strT0 = listO0.size() == 1 ? (String) listO0.get(0) : (String) kb.l.C0(listO0);
            if (strT0.length() > 127) {
                strT0 = hc.h.t0(127, strT0);
            }
            pVar.f9786x = strT0;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.f4309b = uuidRandomUUID;
        String string = uuidRandomUUID.toString();
        string.getClass();
        p5.p pVar2 = this.f4310c;
        pVar2.getClass();
        String str = pVar2.f9766c;
        int i = pVar2.f9765b;
        String str2 = pVar2.f9767d;
        h hVar = new h(pVar2.f9768e);
        h hVar2 = new h(pVar2.f9769f);
        long j10 = pVar2.f9770g;
        long j11 = pVar2.f9771h;
        long j12 = pVar2.i;
        d dVar2 = pVar2.f9772j;
        dVar2.getClass();
        d dVar3 = new d();
        dVar3.f4289c = dVar2.f4289c;
        dVar3.f4290d = dVar2.f4290d;
        dVar3.f4288b = dVar2.f4288b;
        dVar3.f4287a = dVar2.f4287a;
        dVar3.f4291e = dVar2.f4291e;
        dVar3.f4292f = dVar2.f4292f;
        dVar3.i = dVar2.i;
        dVar3.f4293g = dVar2.f4293g;
        dVar3.f4294h = dVar2.f4294h;
        this.f4310c = new p5.p(string, i, str, str2, hVar, hVar2, j10, j11, j12, dVar3, pVar2.f9773k, pVar2.f9774l, pVar2.f9775m, pVar2.f9776n, pVar2.f9777o, pVar2.f9778p, pVar2.f9779q, pVar2.f9780r, pVar2.f9781s, pVar2.f9783u, pVar2.f9784v, pVar2.f9785w, pVar2.f9786x, 524288);
        return f0VarB;
    }

    public abstract f0 b();

    public abstract e0 c();

    public final e0 d(long j10, TimeUnit timeUnit) {
        timeUnit.getClass();
        this.f4308a = true;
        p5.p pVar = this.f4310c;
        pVar.f9774l = 1;
        long millis = timeUnit.toMillis(j10);
        String str = p5.p.f9762y;
        if (millis > 18000000) {
            u.d().g(str, "Backoff delay duration exceeds maximum value");
        }
        if (millis < 10000) {
            u.d().g(str, "Backoff delay duration less than minimum value");
        }
        pVar.f9775m = p5.f.r(millis, 10000L, 18000000L);
        return c();
    }

    public final e0 e(long j10) {
        TimeUnit.MILLISECONDS.getClass();
        this.f4310c.f9770g = j10;
        if (Long.MAX_VALUE - System.currentTimeMillis() > this.f4310c.f9770g) {
            return c();
        }
        f.s("The given initial delay is too large and will cause an overflow!");
        return null;
    }
}
