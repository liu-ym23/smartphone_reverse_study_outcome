package com.bytedanceos.common.toolbox.glide;

import com.bumptech.glide.load.model.GlideUrl;
import kotlin.Lazy;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomGlideUrl extends GlideUrl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f10057a;

    public CustomGlideUrl(String r10) {
        q.g(r10, "url");
        super(r10);
        this.f10057a = kotlin.b.b(new CustomGlideUrl$key$2(this));
    }

    public static final /* synthetic */ String a(CustomGlideUrl r10) {
        return super.getCacheKey();
    }

    public final String b() {
        return (String) this.f10057a.getValue();
    }

    @Override // com.bumptech.glide.load.model.GlideUrl
    public String getCacheKey() {
        return b();
    }
}
