package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements com.bytedance.android.ecom.arch.slice.render.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f173401a;

    public h(t r100) {
        Intrinsics.checkNotNullParameter(r100, "finder");
        this.f173401a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.b
    public final void a(com.bytedance.android.ecom.arch.slice.action.r r100) {
        Intrinsics.checkNotNullParameter(r100, "actionInfo");
        IAction r101 = r100.f49993a;
        View r102 = r100.f49996d;
        v r103 = this.f173401a.a(r101.getType());
        if (r103 == null) goto L6;
        r103.m(r101, r102);
        return;
    }
}
