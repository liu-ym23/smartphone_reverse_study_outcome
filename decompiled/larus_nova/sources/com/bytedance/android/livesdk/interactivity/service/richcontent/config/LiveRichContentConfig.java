package com.bytedance.android.livesdk.interactivity.service.richcontent.config;

import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveImageResourceLoader;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.LiveNinePatchResourceLoader;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.g;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.h;
import com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.l;
import ek6.d;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import ob2.e;
import ob2.f;

/* JADX INFO: loaded from: classes9.dex */
public final class LiveRichContentConfig implements ak6.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f140950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveImageResourceLoader f140951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveNinePatchResourceLoader f140952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends ek6.b>, hk6.b<? extends ek6.b>> f140953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends d>, ik6.a<? extends d>> f140954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ik6.c> f140955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveRichContentConfig$executorServiceProvider$1 f140956g;

    public LiveRichContentConfig() {
        this.f140950a = a.f140958a;
        LiveImageResourceLoader r100 = new LiveImageResourceLoader();
        this.f140951b = r100;
        LiveNinePatchResourceLoader r101 = new LiveNinePatchResourceLoader();
        this.f140952c = r101;
        this.f140953d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ob2.d.class, new g()), TuplesKt.to(ob2.c.class, r100), TuplesKt.to(ob2.a.class, new com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.a()), TuplesKt.to(ob2.g.class, new l()), TuplesKt.to(e.class, new h()), TuplesKt.to(f.class, r101), TuplesKt.to(ob2.b.class, new com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader.b())});
        this.f140954e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(jb2.d.class, new kb2.b()), TuplesKt.to(jb2.c.class, new kb2.a()), TuplesKt.to(jb2.e.class, new kb2.c()), TuplesKt.to(jb2.f.class, new kb2.d())});
        this.f140955f = CollectionsKt.mutableListOf(new ik6.c[]{new nb2.a()});
        this.f140956g = new LiveRichContentConfig$executorServiceProvider$1();
    }

    @Override // ak6.b.a
    public final List<ik6.c> a() {
        return this.f140955f;
    }

    @Override // ak6.b.a
    public final Map<Class<? extends ek6.b>, hk6.b<? extends ek6.b>> b() {
        return this.f140953d;
    }

    @Override // ak6.b.a
    public final Map<Class<? extends d>, ik6.a<? extends d>> c() {
        return this.f140954e;
    }
}
