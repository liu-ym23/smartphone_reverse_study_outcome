package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174756b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, String.valueOf(this.f174755a));
        appendParam("enter_from", this.f174756b);
    }

    public i1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
