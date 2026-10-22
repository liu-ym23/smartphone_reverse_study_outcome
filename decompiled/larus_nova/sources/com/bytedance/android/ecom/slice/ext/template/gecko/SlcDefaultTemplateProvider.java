package com.bytedance.android.ecom.slice.ext.template.gecko;

import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcDefaultTemplateProvider implements com.bytedance.android.ecom.arch.slice.render.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f51220a;

    @Override // com.bytedance.android.ecom.arch.slice.render.g
    public final void release() {
        this.f51220a.release();
    }

    public SlcDefaultTemplateProvider(c r100) {
        this.f51220a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.g
    public final void a(com.bytedance.android.ecom.arch.slice.render.i r100, Map<String, ? extends Object> r101, final com.bytedance.android.ecom.arch.slice.render.f r102) {
        this.f51220a.d(r100, r101, new SlcDefaultTemplateProvider$loadTemplate$1(r102));
    }
}
