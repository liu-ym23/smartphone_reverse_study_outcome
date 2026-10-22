package com.bytedance.android.ec.core.imagex.common;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes43.dex */
public final class ImageUrlParser$Parser$onUrlParse$1 implements com.bytedance.android.shopping.api.image.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f44594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f44596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ImageUrlParser.c f44597g;

    @Override // com.bytedance.android.shopping.api.image.s
    public final String c() {
        return this.f44595e;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getDomain() {
        return this.f44592b;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String l() {
        return this.f44593c;
    }

    public ImageUrlParser$Parser$onUrlParse$1(ImageUrlParser.c r100) {
        this.f44597g = r100;
        ImageUrlParser r101 = r100.f44615j;
        this.f44591a = r101.f44588x;
        String r102 = r101.f44569e;
        this.f44592b = r101.f44570f;
        this.f44593c = r101.f44577m;
        this.f44594d = r101.f44578n;
        Integer r103 = r101.f44574j;
        if (r103 == null) goto L5;
        r103.intValue();
    L5:
        Integer r104 = r100.f44615j.f44575k;
        if (r104 == null) goto L8;
        r104.intValue();
    L8:
        this.f44595e = r100.f44615j.f44573i;
        this.f44596f = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ImageUrlParser$Parser$onUrlParse$1$domainAfterContent$2(this));
    }
}
