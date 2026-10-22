package com.bytedance.android.shopping.anchorv4.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class x implements com.bytedance.android.ecom.arch.slice.render.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcTemplateViewHelper f166999a;

    public x(SlcTemplateViewHelper r100) {
        this.f166999a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.d
    public final void a(com.bytedance.android.ecom.arch.slice.render.j r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (r100.f50676d == false) goto L8;
        SlcTemplateViewHelper r101 = this.f166999a;
        r101.f166930d = true;
        h r102 = r101.f166932f;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }
}
