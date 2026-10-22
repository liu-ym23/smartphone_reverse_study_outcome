package com.bytedance.apm6.cpu.collect;

import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends uu3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f190772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ut3.a f190773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aq7.c f190774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, CpuCacheItem> f190775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, CpuCacheItem> f190776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, CpuCacheItem> f190777f;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public static /* synthetic */ class C2767a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190778a = null;

        static {
            int[] r100 = new int[CpuCacheItem.CpuDataType.values().length];
            f190778a = r100;
            r100[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f190778a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f190778a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public a(aq7.c r100) {
        this.f190772a = new AtomicBoolean(false);
        this.f190774c = r100;
    }

    public final void e(aq7.c.a r100) {
        if (this.f190772a.get() == true) goto L6;
        return;
    L6:
        monitor-enter(a.class);
        b(CpuCacheItem.CpuDataType.FRONT, r100);     // Catch: Throwable -> L10
        b(CpuCacheItem.CpuDataType.BACK, r100);     // Catch: Throwable -> L10
        b(CpuCacheItem.CpuDataType.MIX, r100);     // Catch: Throwable -> L10
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(CpuCacheItem.CpuDataType r210, aq7.c.a r211) {
        long r100 = System.currentTimeMillis();
        int r101 = C2767a.f190778a[r210.ordinal()];
        if (r101 != 1) goto L5;
        Iterator<Map.Entry<String, CpuCacheItem>> r102 = this.f190775d.entrySet().iterator();
    L12:
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.hasNext() == false) goto L26;
        CpuCacheItem r103 = r102.next().getValue();
        if ((r100 - r103.f190769g) <= (this.f190773b.f551633e * 1000)) goto L15;
        r102.remove();
        double r104 = r103.f190764b;
        double r105 = r103.f190770h;
        double r110 = r104 / r105;
        double r111 = r103.f190765c;
        double r106 = r103.f190766d / r105;
        double r107 = r103.f190767e;
        if (xu3.a.a() == false) goto L23;
        av3.b.a("APM-CPU", "cpu cache item: " + r103);
        av3.b.a("APM-CPU", "assemble cpu data, type: " + r210 + " rate: " + r110 + " maxRate: " + r111 + " speed: " + r106 + " maxSpeed: " + r107);
    L23:
        c r108 = new c(r210, r103.f190768f, r110, r111, r106, r107, r211);
        r108.f190796i = ykc.c.c(xu3.a.getContext());
        r108.f190798k = ((bq7.a) this.f190774c).f20045e.a();     // Catch: Throwable -> L27
    L25:
        nu3.b.a(r108);
        r100 = r100;
        goto L15
    L26:
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = this.f190777f.entrySet().iterator();
        goto L12
    L7:
        if (r101 == 3) goto L9;
        r102 = null;
        goto L12
    L9:
        r102 = this.f190776e.entrySet().iterator();
        goto L12
    }

    public final CpuCacheItem c(CpuCacheItem.CpuDataType r100, String r101) {
        int r102 = C2767a.f190778a[r100.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L11;
        return null;
    L11:
        return this.f190776e.get(r101);
    L13:
        return this.f190777f.get(r101);
    L15:
        return this.f190775d.get(r101);
    }

    public final void a(CpuCacheItem.CpuDataType r100, String r101, CpuCacheItem r102) {
        int r103 = C2767a.f190778a[r100.ordinal()];
        if (r103 != 1) goto L5;
        this.f190775d.put(r101, r102);
        return;
    L5:
        if (r103 != 2) goto L7;
        this.f190777f.put(r101, r102);
        return;
    L7:
        if (r103 != 3) goto L15;
        this.f190776e.put(r101, r102);
        return;
    }

    public static CpuCacheItem d(CpuCacheItem.CpuDataType r100, CpuCacheItem r101, double r102, double r103) {
        if (r101 != null) goto L5;
        r101 = new CpuCacheItem(r100, System.currentTimeMillis());
        r101.f190768f = ou3.a.a().e();
    L5:
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
    L8:
        r101.f190770h++;
    L10:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        r101.f190766d += r103;
    L14:
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        r101.f190764b += r102;
    L18:
        if (r101.f190765c >= r102) goto L21;
        r101.f190765c = r102;
    L21:
        if (r101.f190767e >= r103) goto L23;
        r101.f190767e = r103;
    L23:
        return r101;
    L7:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        goto L8
    }
}
