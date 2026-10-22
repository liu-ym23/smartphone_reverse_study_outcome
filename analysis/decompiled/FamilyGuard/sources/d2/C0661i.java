package d2;

import f2.C0702g;
import java.util.HashMap;

/* renamed from: d2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0661i implements InterfaceC0662j, InterfaceC0659g, InterfaceC0660h, InterfaceC0656d, InterfaceC0654b, InterfaceC0657e, InterfaceC0655c {

    /* renamed from: a, reason: collision with root package name */
    private final long f16580a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f16581b = new long[24];

    /* renamed from: c, reason: collision with root package name */
    private final int[] f16582c = new int[24];

    /* renamed from: d, reason: collision with root package name */
    private final int[] f16583d = new int[24];

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, Long> f16584e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, Integer> f16585f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<String, long[]> f16586g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, int[]> f16587h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private long f16588i;

    /* renamed from: j, reason: collision with root package name */
    private final long f16589j;

    /* renamed from: k, reason: collision with root package name */
    private final int f16590k;

    /* renamed from: l, reason: collision with root package name */
    private final int f16591l;

    public C0661i(long j5, long j6, int i5, int i6, long j7) {
        this.f16588i = j5;
        this.f16589j = j6;
        this.f16590k = i5;
        this.f16591l = i6;
        this.f16580a = j7;
    }

    @Override // d2.InterfaceC0656d
    public HashMap<String, Long> a() {
        return this.f16584e;
    }

    @Override // d2.InterfaceC0662j
    public long[] b() {
        return this.f16581b;
    }

    @Override // d2.InterfaceC0654b
    public HashMap<String, Integer> c() {
        return this.f16585f;
    }

    @Override // d2.InterfaceC0660h
    public int[] d() {
        return this.f16582c;
    }

    @Override // d2.InterfaceC0659g
    public int[] e() {
        return this.f16583d;
    }

    @Override // d2.InterfaceC0658f
    public long f() {
        return this.f16580a;
    }

    @Override // d2.InterfaceC0657e
    public HashMap<String, long[]> g() {
        return this.f16586g;
    }

    @Override // d2.InterfaceC0655c
    public HashMap<String, int[]> h() {
        return this.f16587h;
    }

    public void i(long j5) {
        this.f16588i = j5;
    }

    public String toString() {
        return super.toString() + "{mTotalUsedTime = " + this.f16589j + "\tmTotalTakeupTimes = " + this.f16590k + "\tmTotalNotificationTimes = " + this.f16591l + "\tmLongestTime" + this.f16588i + "\tmUsageTime = " + C0702g.g(this.f16581b) + "\tmTakeupTimes = " + C0702g.f(this.f16582c) + "\tmNotificationTimes = " + C0702g.f(this.f16583d) + "}";
    }
}
