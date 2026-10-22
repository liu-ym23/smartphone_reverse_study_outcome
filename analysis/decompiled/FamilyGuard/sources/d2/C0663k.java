package d2;

import f2.C0702g;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: d2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0663k implements InterfaceC0656d, InterfaceC0654b, InterfaceC0662j, InterfaceC0659g, InterfaceC0660h, InterfaceC0657e, InterfaceC0655c {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Long> f16592a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, Integer> f16593b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, long[]> f16594c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, int[]> f16595d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<Long, Long> f16596e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<Long, Integer> f16597f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<Long, Integer> f16598g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private long f16599h;

    /* renamed from: i, reason: collision with root package name */
    private long f16600i;

    /* renamed from: j, reason: collision with root package name */
    private long f16601j;

    /* renamed from: k, reason: collision with root package name */
    private int f16602k;

    /* renamed from: l, reason: collision with root package name */
    private int f16603l;

    /* renamed from: d2.k$a */
    private class a implements Comparator<Long> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Long l5, Long l6) {
            return (int) (l5.longValue() - l6.longValue());
        }

        private a() {
        }
    }

    private <V> Map<Long, V> q(Map<Long, V> map) {
        TreeMap treeMap = new TreeMap(new a());
        treeMap.putAll(map);
        return treeMap;
    }

    @Override // d2.InterfaceC0656d
    public HashMap<String, Long> a() {
        return this.f16592a;
    }

    @Override // d2.InterfaceC0662j
    public long[] b() {
        long[] jArr = new long[7];
        Iterator it = q(this.f16596e).entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr[i5] = ((Long) ((Map.Entry) it.next()).getValue()).longValue();
            i5++;
        }
        return jArr;
    }

    @Override // d2.InterfaceC0654b
    public HashMap<String, Integer> c() {
        return this.f16593b;
    }

    @Override // d2.InterfaceC0660h
    public int[] d() {
        int[] iArr = new int[7];
        Iterator it = q(this.f16597f).entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
            i5++;
        }
        return iArr;
    }

    @Override // d2.InterfaceC0659g
    public int[] e() {
        int[] iArr = new int[7];
        Iterator it = q(this.f16598g).entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
            i5++;
        }
        return iArr;
    }

    @Override // d2.InterfaceC0658f
    public long f() {
        return this.f16599h;
    }

    @Override // d2.InterfaceC0657e
    public HashMap<String, long[]> g() {
        return this.f16594c;
    }

    @Override // d2.InterfaceC0655c
    public HashMap<String, int[]> h() {
        return this.f16595d;
    }

    public HashMap<Long, Integer> i() {
        return this.f16598g;
    }

    public HashMap<Long, Integer> j() {
        return this.f16597f;
    }

    public HashMap<Long, Long> k() {
        return this.f16596e;
    }

    public void l(long j5) {
        this.f16600i = j5;
    }

    public void m(int i5) {
        this.f16602k = i5;
    }

    public void n(int i5) {
        this.f16603l = i5;
    }

    public void o(long j5) {
        this.f16601j = j5;
    }

    public void p(long j5) {
        this.f16599h = j5;
    }

    public String toString() {
        return super.toString() + "{mLongestUseTime = " + this.f16600i + "\tmTotalUsageTime = " + this.f16601j + "\tmTotalPickupTimes = " + this.f16603l + "\tmTotalNotificationTimes = " + this.f16602k + "\tmAppUsageTimeMap = " + C0702g.m(this.f16592a) + "\tmAppNotification = " + C0702g.m(this.f16593b) + "\tmUsageTime = " + C0702g.g(b()) + "\tmPickupTimes = " + C0702g.f(d()) + "\tmNotificationTimes = " + C0702g.f(e()) + "}";
    }
}
