package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f162414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f162415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f162416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f162417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f162418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f162419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f162420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f162421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f162422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f162423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f162424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f162425m;

    public final LayerDescriptorList a() {
        return (LayerDescriptorList) this.f162419g.getValue();
    }

    public final LayerDescriptorList b() {
        return (LayerDescriptorList) this.f162423k.getValue();
    }

    public final LayerDescriptorList c() {
        return (LayerDescriptorList) this.f162422j.getValue();
    }

    public final LayerDescriptorList d() {
        return (LayerDescriptorList) this.f162413a.getValue();
    }

    public final LayerDescriptorList e() {
        return (LayerDescriptorList) this.f162420h.getValue();
    }

    public final LayerDescriptorList f() {
        return (LayerDescriptorList) this.f162417e.getValue();
    }

    public final LayerDescriptorList g() {
        return (LayerDescriptorList) this.f162414b.getValue();
    }

    public final LayerDescriptorList h() {
        return (LayerDescriptorList) this.f162418f.getValue();
    }

    public final LayerDescriptorList i() {
        return (LayerDescriptorList) this.f162415c.getValue();
    }

    public final LayerDescriptorList j() {
        return (LayerDescriptorList) this.f162416d.getValue();
    }

    public final LayerDescriptorList k() {
        return (LayerDescriptorList) this.f162421i.getValue();
    }

    public m() {
        this.f162413a = LazyKt.lazy(DescriptorList$fontInteractionDesSet$2.INSTANCE);
        this.f162414b = LazyKt.lazy(DescriptorList$p0FontInteractionDesSet$2.INSTANCE);
        this.f162415c = LazyKt.lazy(DescriptorList$p1interactionDesSet$2.INSTANCE);
        this.f162416d = LazyKt.lazy(DescriptorList$p2interactionDesSet$2.INSTANCE);
        this.f162417e = LazyKt.lazy(DescriptorList$interactionDesSet$2.INSTANCE);
        this.f162418f = LazyKt.lazy(DescriptorList$p0InteractionDesSet$2.INSTANCE);
        this.f162419g = LazyKt.lazy(DescriptorList$firstInNeedDesSet$2.INSTANCE);
        this.f162420h = LazyKt.lazy(DescriptorList$fontPreloadCompSet$2.INSTANCE);
        this.f162421i = LazyKt.lazy(DescriptorList$preloadCompSet$2.INSTANCE);
        this.f162422j = LazyKt.lazy(DescriptorList$fontFirstScreenCompSet$2.INSTANCE);
        this.f162423k = LazyKt.lazy(DescriptorList$firstScreenCompSet$2.INSTANCE);
    }
}
