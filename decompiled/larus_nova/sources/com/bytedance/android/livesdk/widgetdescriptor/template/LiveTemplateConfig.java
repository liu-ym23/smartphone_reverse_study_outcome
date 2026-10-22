package com.bytedance.android.livesdk.widgetdescriptor.template;

import a80.a;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import d90.b;
import j70.c;
import j70.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveTemplateConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f162463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function0<a<e0>>> f162464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<f, Old2NewRelation.a> f162465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, c> f162466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f162467f;

    public LiveTemplateConfig(e0 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        this.f162467f = r100;
        Lazy r102 = LazyKt.lazy(new LiveTemplateConfig$_elementRegistery$2(this));
        this.f162462a = r102;
        Lazy r103 = LazyKt.lazy(new LiveTemplateConfig$_old2NewRelation$2(this));
        this.f162463b = r103;
        this.f162464c = ((ElementRegistery) r102.getValue()).f162460a;
        Old2NewRelation r104 = (Old2NewRelation) r103.getValue();
        if (r101 == false) goto L5;
        Map<f, Old2NewRelation.a> r105 = (Map) r104.f162475a.getValue();
    L6:
        this.f162465d = r105;
        Map<String, c> r106 = b.f467451a;
        if (r101 == false) goto L9;
        Map<String, c> r107 = b.f467451a;
    L10:
        this.f162466e = r107;
        return;
    L9:
        r107 = b.f467452b;
        goto L10
    L5:
        r105 = (Map) r104.f162476b.getValue();
        goto L6
    }
}
