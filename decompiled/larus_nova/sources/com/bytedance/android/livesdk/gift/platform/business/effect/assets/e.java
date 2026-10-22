package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f129091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f129092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f129093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f129094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f129095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f129096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f129097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f129098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f129099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String[] f129100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f129101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f129102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f129103m;

    public static final class a {
    }

    static {
    }

    public int a() {
        return 0;
    }

    public final String b() {
        return this.f129100j[Math.min(this.f129092b, this.f129100j.length - 1)];
    }

    public final void c() {
        this.f129092b++;
    }

    public String toString() {
        return "GetResourceRequest{id=" + this.f129099i + ", urls='" + this.f129100j.toString() + "', md5='" + this.f129101k + "', sourceFrom='" + this.f129102l + "', needToUnzip=" + this.f129103m + '}';
    }

    public e(long r100, String[] r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "urls");
        Intrinsics.checkNotNullParameter(r102, "md5");
        this.f129099i = r100;
        this.f129100j = r101;
        this.f129101k = r102;
        this.f129102l = r103;
        this.f129103m = true;
        this.f129092b = -1;
        this.f129093c = 0;
        this.f129094d = 1;
        i97.a r104 = i97.a.f488802a;
        this.f129095e = System.currentTimeMillis();
    }
}
