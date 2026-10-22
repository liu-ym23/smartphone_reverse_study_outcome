package com.bytedance.android.shopping.anchorv4.event_chain;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements v96.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f166744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f166745b;

    @Override // v96.g
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        iq.b r101 = new iq.b(r100, false);
        Context r102 = this.f166744a;
        if (r102 == null) goto L6;
        this.f166745b.e(r102, r101);
        return;
    }

    public g(Context r100, v r101) {
        Intrinsics.checkNotNullParameter(r101, "pdpCommonEventService");
        this.f166744a = r100;
        this.f166745b = r101;
    }
}
