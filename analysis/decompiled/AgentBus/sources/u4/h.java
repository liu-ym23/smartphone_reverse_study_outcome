package u4;

import a6.r;
import ia.d0;
import ia.f1;
import ia.w1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import k5.t;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final File f10069a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.c f10070b;

    /* renamed from: c, reason: collision with root package name */
    public final t f10071c;

    /* renamed from: d, reason: collision with root package name */
    public final na.d f10072d;

    /* renamed from: e, reason: collision with root package name */
    public final ka.g f10073e;

    /* renamed from: f, reason: collision with root package name */
    public final i5.l f10074f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicLong f10075g;

    /* renamed from: h, reason: collision with root package name */
    public final f5.d f10076h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f10077i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f10078j;

    /* renamed from: k, reason: collision with root package name */
    public final SimpleDateFormat f10079k;

    /* renamed from: l, reason: collision with root package name */
    public final w1 f10080l;

    public h(File file, c5.d dVar, k5.a aVar, k5.g gVar) {
        q7.k.e(dVar, "codec");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        this.f10069a = file;
        this.f10070b = dVar;
        this.f10071c = gVar;
        na.d dVarB = d0.b(f1.plus(d0.c(), aVar.f5619d));
        this.f10072d = dVarB;
        this.f10073e = a.a.b(512, 6, null);
        this.f10074f = new i5.l(29);
        this.f10075g = new AtomicLong(0L);
        this.f10076h = new f5.d(2, this);
        this.f10078j = new AtomicLong(0L);
        this.f10079k = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        this.f10080l = d0.s(dVarB, null, null, new r(this, null, 12), 3);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:23|(1:25)|26|(1:(1:(1:46))(2:36|(1:38)))(3:(1:29)|30|(1:32))|47|95|48|52|(1:55)|56|(4:91|59|(1:61)(1:62)|63)|58|(3:97|69|(1:71))) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ce, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Path cross not found for [B:58:0x0114, B:91:0x0116], limit reached: 95 */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0212  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0053 -> B:19:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(u4.h r21, i7.c r22) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.h.a(u4.h, i7.c):java.lang.Object");
    }
}
