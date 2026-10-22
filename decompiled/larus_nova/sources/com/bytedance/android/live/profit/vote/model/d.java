package com.bytedance.android.live.profit.vote.model;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f89248d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f89249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f89250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f89251c;

    public static final class a {
    }

    static {
        f89248d = -1;
    }

    public static long c() {
        i97.a r100 = i97.a.f488802a;
        return SystemClock.elapsedRealtime();
    }

    public final boolean b() {
        long r100 = this.f89249a;
        long r101 = f89248d;
        if (r100 != r101) goto L5;
    L7:
        return false;
    L5:
        if (this.f89251c == r101) goto L7;
        return true;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("VoteClock(start=");
        r100.append(this.f89249a);
        r100.append(", pause=");
        r100.append(this.f89250b);
        r100.append(", finish=");
        r100.append(this.f89251c);
        r100.append(", total=");
        if (b() == false) goto L7;
        long r101 = this.f89251c - this.f89249a;
        if (r101 >= 0) goto L8;
        r101 = 0;
    L8:
        r100.append(r101);
        r100.append(", remain=");
        r100.append(a());
        r100.append(')');
        return r100.toString();
    L7:
        r101 = f89248d;
        goto L8
    }

    public d() {
        long r100 = f89248d;
        this.f89249a = r100;
        this.f89250b = r100;
        this.f89251c = r100;
    }

    public final long a() {
        boolean r100 = b();
        long r101 = f89248d;
        if (r100 == false) goto L14;
        long r102 = this.f89250b;
        if (r102 != r101) goto L9;
        long r103 = this.f89251c - c();
        if (r103 < 0) goto L15;
    L13:
        return r103;
    L15:
        return 0;
    L9:
        r103 = this.f89251c - r102;
        if (r103 >= 0) goto L13;
    L14:
        return r101;
    }
}
