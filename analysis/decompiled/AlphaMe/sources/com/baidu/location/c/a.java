package com.baidu.location.c;

import com.stepos.alphame.bluetooth.VehicleBluetoothManager;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f5541a;

    /* renamed from: b, reason: collision with root package name */
    public long f5542b;

    /* renamed from: c, reason: collision with root package name */
    public int f5543c;

    /* renamed from: d, reason: collision with root package name */
    public int f5544d;

    /* renamed from: e, reason: collision with root package name */
    public int f5545e;

    /* renamed from: f, reason: collision with root package name */
    public int f5546f;

    /* renamed from: g, reason: collision with root package name */
    public long f5547g;

    /* renamed from: h, reason: collision with root package name */
    public int f5548h;

    /* renamed from: i, reason: collision with root package name */
    public char f5549i;

    /* renamed from: j, reason: collision with root package name */
    public int f5550j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5551k;

    /* renamed from: l, reason: collision with root package name */
    public int f5552l;

    /* renamed from: m, reason: collision with root package name */
    public int f5553m;

    /* renamed from: n, reason: collision with root package name */
    public String f5554n;

    /* renamed from: o, reason: collision with root package name */
    public String f5555o;

    /* renamed from: p, reason: collision with root package name */
    public String f5556p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5557q;

    public a() {
        this.f5541a = -1;
        this.f5542b = -1L;
        this.f5543c = -1;
        this.f5544d = -1;
        this.f5545e = Integer.MAX_VALUE;
        this.f5546f = Integer.MAX_VALUE;
        this.f5547g = 0L;
        this.f5548h = -1;
        this.f5549i = '0';
        this.f5550j = Integer.MAX_VALUE;
        this.f5551k = false;
        this.f5552l = 0;
        this.f5553m = 0;
        this.f5554n = null;
        this.f5555o = null;
        this.f5556p = null;
        this.f5557q = false;
        this.f5547g = System.currentTimeMillis();
    }

    public boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j4 = this.f5547g;
        return jCurrentTimeMillis - j4 > 0 && jCurrentTimeMillis - j4 < VehicleBluetoothManager.MIN_CONNECT_DISTANCE;
    }

    public boolean b() {
        return this.f5541a > -1 && this.f5542b > 0;
    }

    public boolean c() {
        return this.f5541a == -1 && this.f5542b == -1 && this.f5544d == -1 && this.f5543c == -1;
    }

    public boolean d() {
        return this.f5541a > -1 && this.f5542b > -1 && this.f5544d == -1 && this.f5543c == -1;
    }

    public boolean e() {
        return this.f5541a > -1 && this.f5542b > -1 && this.f5544d > -1 && this.f5543c > -1;
    }

    public a(int i4, long j4, int i5, int i6, int i7, char c4, int i8) {
        this.f5545e = Integer.MAX_VALUE;
        this.f5546f = Integer.MAX_VALUE;
        this.f5547g = 0L;
        this.f5550j = Integer.MAX_VALUE;
        this.f5551k = false;
        this.f5552l = 0;
        this.f5553m = 0;
        this.f5554n = null;
        this.f5555o = null;
        this.f5556p = null;
        this.f5557q = false;
        this.f5541a = i4;
        this.f5542b = j4;
        this.f5543c = i5;
        this.f5544d = i6;
        this.f5548h = i7;
        this.f5549i = c4;
        this.f5547g = System.currentTimeMillis();
        this.f5550j = i8;
    }

    public boolean a(a aVar) {
        if (this.f5541a != aVar.f5541a || this.f5542b != aVar.f5542b || this.f5544d != aVar.f5544d || this.f5543c != aVar.f5543c) {
            return false;
        }
        String str = this.f5555o;
        if (str == null || !str.equals(aVar.f5555o)) {
            return this.f5555o == null && aVar.f5555o == null;
        }
        return true;
    }

    public a(a aVar) {
        this(aVar.f5541a, aVar.f5542b, aVar.f5543c, aVar.f5544d, aVar.f5548h, aVar.f5549i, aVar.f5550j);
        this.f5547g = aVar.f5547g;
        this.f5554n = aVar.f5554n;
        this.f5552l = aVar.f5552l;
        this.f5556p = aVar.f5556p;
        this.f5553m = aVar.f5553m;
        this.f5555o = aVar.f5555o;
    }
}
