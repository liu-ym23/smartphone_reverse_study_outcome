package com.bytedance.android.livesdk.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f158899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f158900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f158901c;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (((ArrayList) this.f158899a).isEmpty() == false) goto L5;
        return false;
    L5:
        long r100 = System.currentTimeMillis();
        Iterator r101 = ((ArrayList) this.f158899a).iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if ((r100 - ((Number) r101.next()).longValue()) <= (this.f158900b * 1000)) goto L7;
        r101.remove();
        goto L7
    L12:
        if (((ArrayList) this.f158899a).size() < this.f158901c) goto L20;
        return true;
    L20:
        return false;
    }

    public c(int r100, int r101) {
        this.f158900b = r100;
        this.f158901c = r101;
        this.f158899a = new ArrayList();
    }
}
