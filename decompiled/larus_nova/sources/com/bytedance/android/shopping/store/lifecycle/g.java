package com.bytedance.android.shopping.store.lifecycle;

import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f185479e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, Long> f185480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f185481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f185482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f185483d;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (a(this.f185480a, 100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public g() {
        this.f185480a = new HashMap();
        this.f185482c = "none";
        this.f185483d = -1;
    }

    public static long a(HashMap r100, int r101) {
        Long r102 = (Long) r100.get(Integer.valueOf(r101));
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.longValue();
    }

    public final void c(int r100, Long r101) {
        if (a(this.f185480a, r100) != (-1)) goto L10;
        HashMap<Integer, Long> r102 = this.f185480a;
        Integer r103 = Integer.valueOf(r100);
        if (r101 == null) goto L7;
        long r104 = r101.longValue();
    L8:
        r102.put(r103, Long.valueOf(r104));
        return;
    L7:
        r104 = System.currentTimeMillis();
        goto L8
    }
}
