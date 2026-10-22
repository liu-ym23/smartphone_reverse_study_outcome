package com.bytedance.android.ec.core.imagex.common;

import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f44640e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f44642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageRequest[] f44643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageRequest f44644d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final Object getCallerContext() {
        throw null;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest a() {
        return this.f44644d;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.k
    public final ImageRequest[] g() {
        return this.f44643c;
    }

    public c(Object r100, ImageRequest[] r101, ImageRequest r102) {
        this.f44642b = r100;
        this.f44643c = r101;
        this.f44644d = r102;
        this.f44641a = System.nanoTime();
    }
}
