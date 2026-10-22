package com.bytedance.android.ecom.arch.slice.slices.template;

import com.bytedance.android.ecom.arch.slice.render.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcTemplateViewHolder f51051a;

    public a(SlcTemplateViewHolder r100) {
        this.f51051a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.d
    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (r100.f50676d != true) goto L6;
        SlcTemplateViewHolder r101 = this.f51051a;
        r101.f51046c = true;
        r101.d4();
        return;
    }
}
