package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.t;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f123214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f123215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f123216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f123217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f123218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t f123219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f123220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f123221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a f123222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f123223j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.j
    public final void a(long r100) {
        int r101 = this.f123219f.d();
        if (r101 != 1) goto L5;
    L10:
        b(true, "Pattern TimeOut");
        return;
    L5:
        if (r101 == 2) goto L10;
        if (r101 != 4) goto L13;
        c r102 = this.f123223j;
        String r103 = this.f123218e;
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a r104 = this.f123222i;
        r102.d(r103, r104.f123208b, r104.f123209c);
        return;
    }

    public final void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "stopReason");
        int r102 = b.f123213a;
        b.c(this.f123217d, "NoneEvent", this.f123222i.f123207a + "_:" + this.f123219f.e(), r101);
        this.f123216c = true;
        this.f123214a = 0;
        if (r100 == true) goto L9;
        m r103 = this.f123215b;
        if (r103 == null) goto L9;
        l r104 = this.f123221h;
        if (r104 == null) goto L9;
        r104.c(r103);
    L9:
        this.f123215b = null;
    }

    public d(String r100, String r101, t r102, long r103, l r104, com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.a r105, c r110) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "nfaName");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        Intrinsics.checkNotNullParameter(r105, "cepNfaStateWrapper");
        Intrinsics.checkNotNullParameter(r110, "moveToNextCallback");
        this.f123217d = r100;
        this.f123218e = r101;
        this.f123219f = r102;
        this.f123220g = r103;
        this.f123221h = r104;
        this.f123222i = r105;
        this.f123223j = r110;
        if (r102.g() <= 0) goto L9;
        m r106 = new m(r105.f123207a + '_' + r102.e(), System.nanoTime() + (((long) (r102.g() * 1000)) * 1000000), this);
        if (r104 == null) goto L7;
        r104.b(r106);
    L7:
        Unit r107 = Unit.INSTANCE;
        this.f123215b = r106;
        return;
    }
}
