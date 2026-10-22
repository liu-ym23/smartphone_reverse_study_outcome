package n5;

import com.scp.moderation.crypto.model.SensitiveWord;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import s5.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ud.a f10636a = ud.b.e(a.class);

    /* renamed from: b, reason: collision with root package name */
    public static final b f10637b = new b("PASS");

    /* renamed from: c, reason: collision with root package name */
    public static final Object f10638c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static volatile s5.b f10639d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile List<SensitiveWord> f10640e;

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s5.b a(java.util.List<com.scp.moderation.crypto.model.SensitiveWord> r16) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.a.a(java.util.List):s5.b");
    }

    public static b b(String str) {
        s5.b bVar = f10639d;
        if (bVar == null) {
            throw new IllegalStateException("moderation SDK is not initialized");
        }
        if (str.length() > 100000) {
            throw new IllegalArgumentException("text length " + str.length() + " exceeds max 100000");
        }
        if (str.trim().isEmpty()) {
            return f10637b;
        }
        long j10 = bVar.f11891b;
        ud.a aVar = s5.b.f11889c;
        ArrayList arrayList = bVar.f11890a;
        boolean z = false;
        if (!arrayList.isEmpty()) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(j10) + System.nanoTime();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                boolean z3 = true;
                if (i10 < size) {
                    int i11 = i10 + 1;
                    s5.a aVar2 = (s5.a) arrayList.get(i10);
                    if (aVar2.c()) {
                        arrayList2.add(aVar2);
                    } else {
                        try {
                            if (aVar2.b(str)) {
                                z = true;
                                break;
                            }
                        } catch (Exception e10) {
                            aVar.b("recognition module {} failed (treated as no-hit): {}", aVar2.getClass().getSimpleName(), e10.getClass().getSimpleName());
                        }
                    }
                    i10 = i11;
                } else {
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    int size2 = arrayList2.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        Object obj = arrayList2.get(i12);
                        i12++;
                        s5.a aVar3 = (s5.a) obj;
                        try {
                            arrayList3.add(new b.a(aVar3, aVar3.a(str)));
                        } catch (RejectedExecutionException unused) {
                            aVar.d(aVar3.getClass().getSimpleName());
                        }
                    }
                    int size3 = arrayList3.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        int i14 = i13 + 1;
                        b.a aVar4 = (b.a) arrayList3.get(i13);
                        long jNanoTime = nanos - System.nanoTime();
                        if (jNanoTime <= 0) {
                            aVar4.f11893b.cancel(z3);
                            aVar.b("recognition module {} exceeded pipeline timeout {}ms (treated as no-hit)", aVar4.f11892a.getClass().getSimpleName(), Long.valueOf(j10));
                        } else {
                            try {
                                try {
                                    if (aVar4.f11893b.get(jNanoTime, TimeUnit.NANOSECONDS).booleanValue()) {
                                        z = true;
                                    }
                                } catch (TimeoutException unused2) {
                                    z3 = true;
                                    aVar4.f11893b.cancel(z3);
                                    aVar.b("recognition module {} exceeded pipeline timeout {}ms (treated as no-hit)", aVar4.f11892a.getClass().getSimpleName(), Long.valueOf(j10));
                                    i13 = i14;
                                }
                            } catch (InterruptedException unused3) {
                                z3 = true;
                                aVar4.f11893b.cancel(true);
                                Thread.currentThread().interrupt();
                            } catch (Exception e11) {
                                aVar.b("recognition module {} failed (treated as no-hit): {}", aVar4.f11892a.getClass().getSimpleName(), e11.getClass().getSimpleName());
                            }
                            z3 = true;
                        }
                        i13 = i14;
                    }
                }
            }
        }
        return new b(z ? "BLOCK" : "PASS");
    }
}
