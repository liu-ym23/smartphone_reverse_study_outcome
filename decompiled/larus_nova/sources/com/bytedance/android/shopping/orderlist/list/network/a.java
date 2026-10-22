package com.bytedance.android.shopping.orderlist.list.network;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f180237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f180238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e f180239c;

    public a() {
        this(false, 7);
    }

    public /* synthetic */ a(boolean r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = false;
    L5:
        this(false, r100, null);
    }

    public a(boolean r100, boolean r101, com.bytedance.kmp.ec.yata.common.protocol.data.e r102) {
        this.f180237a = r100;
        this.f180238b = r101;
        this.f180239c = r102;
    }
}
