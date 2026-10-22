package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements y1.e, y1.d {

    /* renamed from: l, reason: collision with root package name */
    public static final TreeMap<Integer, l> f2569l = new TreeMap<>();

    /* renamed from: a, reason: collision with root package name */
    public final int f2570a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f2571b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f2572c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f2573d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f2574e;
    public final byte[][] h;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f2575j;

    /* renamed from: k, reason: collision with root package name */
    public int f2576k;

    public l(int i10) {
        this.f2570a = i10;
        int i11 = i10 + 1;
        this.f2575j = new int[i11];
        this.f2572c = new long[i11];
        this.f2573d = new double[i11];
        this.f2574e = new String[i11];
        this.h = new byte[i11][];
    }

    public static final l w(int i10, String query) {
        kotlin.jvm.internal.g.f(query, "query");
        TreeMap<Integer, l> treeMap = f2569l;
        synchronized (treeMap) {
            Map.Entry<Integer, l> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (entryCeilingEntry == null) {
                lb.n nVar = lb.n.f10413a;
                l lVar = new l(i10);
                lVar.f2571b = query;
                lVar.f2576k = i10;
                return lVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            l value = entryCeilingEntry.getValue();
            value.getClass();
            value.f2571b = query;
            value.f2576k = i10;
            return value;
        }
    }

    public final void C() {
        TreeMap<Integer, l> treeMap = f2569l;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f2570a), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                kotlin.jvm.internal.g.e(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i10 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i10;
                }
            }
            lb.n nVar = lb.n.f10413a;
        }
    }

    @Override // y1.d
    public final void F(byte[] bArr, int i10) {
        this.f2575j[i10] = 5;
        this.h[i10] = bArr;
    }

    @Override // y1.d
    public final void Y(int i10, String value) {
        kotlin.jvm.internal.g.f(value, "value");
        this.f2575j[i10] = 4;
        this.f2574e[i10] = value;
    }

    @Override // y1.e
    public final String a() {
        String str = this.f2571b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // y1.d
    public final void h0(int i10, long j10) {
        this.f2575j[i10] = 2;
        this.f2572c[i10] = j10;
    }

    @Override // y1.e
    public final void o(y1.d dVar) {
        int i10 = this.f2576k;
        if (1 > i10) {
            return;
        }
        int i11 = 1;
        while (true) {
            int i12 = this.f2575j[i11];
            if (i12 == 1) {
                dVar.v0(i11);
            } else if (i12 == 2) {
                dVar.h0(i11, this.f2572c[i11]);
            } else if (i12 == 3) {
                dVar.s(i11, this.f2573d[i11]);
            } else if (i12 == 4) {
                String str = this.f2574e[i11];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                dVar.Y(i11, str);
            } else if (i12 == 5) {
                byte[] bArr = this.h[i11];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                dVar.F(bArr, i11);
            }
            if (i11 == i10) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // y1.d
    public final void s(int i10, double d8) {
        this.f2575j[i10] = 3;
        this.f2573d[i10] = d8;
    }

    @Override // y1.d
    public final void v0(int i10) {
        this.f2575j[i10] = 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
