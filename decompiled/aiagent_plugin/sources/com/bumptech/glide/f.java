package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.t;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Registry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f3304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.d.a f3305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.d.e f3306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.d.f f3307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.a.f f3308e;
    private final com.bumptech.glide.load.resource.d.f f;
    private final com.bumptech.glide.d.b g;
    private final com.bumptech.glide.d.d h;
    private final com.bumptech.glide.d.c i;
    private final androidx.core.util.f.a<List<Throwable>> j;

    /* JADX INFO: compiled from: Registry.java */
    public static class a extends RuntimeException {
        public a(String r1) {
            super(r1);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class c extends a {
        public c(Object r3) {
            super("Failed to find any ModelLoaders registered for model class: " + r3.getClass());
        }

        public <M> c(M r3, List<n<M, ?>> r4) {
            super("Found ModelLoaders for model class: " + ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")) + ", but none that handle this specific model instance: " + r3);
        }

        public c(Class<?> r3, Class<?> r4) {
            super("Failed to find any ModelLoaders for model: " + r3 + " and data: " + r4);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class d extends a {
        public d(Class<?> r3) {
            super("Failed to find result encoder for resource class: " + r3 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class e extends a {
        public e(Class<?> r3) {
            super("Failed to find source encoder for data class: " + r3);
        }
    }

    public f() {
        this.h = new com.bumptech.glide.d.d();
        this.i = new com.bumptech.glide.d.c();
        androidx.core.util.f.a<List<Throwable>> r0 = com.bumptech.glide.f.a.a.a();
        this.j = r0;
        this.f3304a = new p(r0);
        this.f3305b = new com.bumptech.glide.d.a();
        this.f3306c = new com.bumptech.glide.d.e();
        this.f3307d = new com.bumptech.glide.d.f();
        this.f3308e = new com.bumptech.glide.load.a.f();
        this.f = new com.bumptech.glide.load.resource.d.f();
        this.g = new com.bumptech.glide.d.b();
        a(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    public <Data> f a(Class<Data> r3, com.bumptech.glide.load.d<Data> r4) {
        com.bumptech.glide.load.d r5 = (com.bumptech.glide.load.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.d.class, "com.obric.aiagent.plugin");
        this.f3305b.a(r3, r5);
        return this;
    }

    public <Data, TResource> f a(Class<Data> r3, Class<TResource> r4, k<Data, TResource> r5) {
        a("legacy_append", r3, r4, (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.aiagent.plugin"));
        return this;
    }

    public <Data, TResource> f a(String r3, Class<Data> r4, Class<TResource> r5, k<Data, TResource> r6) {
        k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r6, k.class, "com.obric.aiagent.plugin");
        this.f3306c.a(r3, r7, r4, r5);
        return this;
    }

    public final f a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList(r4.size());
        r0.addAll(r4);
        r0.add(0, "legacy_prepend_all");
        r0.add("legacy_append");
        this.f3306c.a(r0);
        return this;
    }

    public <TResource> f a(Class<TResource> r3, l<TResource> r4) {
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.aiagent.plugin");
        this.f3307d.a(r3, r5);
        return this;
    }

    public f a(com.bumptech.glide.load.a.e.a<?> r3) {
        com.bumptech.glide.load.a.e.a<?> r4 = (com.bumptech.glide.load.a.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.e.a.class, "com.obric.aiagent.plugin");
        this.f3308e.a(r4);
        return this;
    }

    public <TResource, Transcode> f a(Class<TResource> r3, Class<Transcode> r4, com.bumptech.glide.load.resource.d.e<TResource, Transcode> r5) {
        com.bumptech.glide.load.resource.d.e r6 = (com.bumptech.glide.load.resource.d.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.resource.d.e.class, "com.obric.aiagent.plugin");
        this.f.a(r3, r4, r6);
        return this;
    }

    public f a(ImageHeaderParser r3) {
        ImageHeaderParser r4 = (ImageHeaderParser) ZeusTransformUtils.wrapperContextForParams(r3, ImageHeaderParser.class, "com.obric.aiagent.plugin");
        this.g.a(r4);
        return this;
    }

    public <Model, Data> f a(Class<Model> r3, Class<Data> r4, o<Model, Data> r5) {
        o<? extends Model, ? extends Data> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin");
        this.f3304a.a(r3, r4, r6);
        return this;
    }

    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> r10, Class<TResource> r11, Class<Transcode> r12) {
        t<Data, TResource, Transcode> r0 = this.i.a(r10, r11, r12);
        if (this.i.a(r0) == false) goto L5;
        return null;
    L5:
        if (r0 != null) goto L11;
        List<i<Data, TResource, Transcode>> r7 = c(r10, r11, r12);
        if (r7.isEmpty() == false) goto L9;
        r0 = null;
    L10:
        this.i.a(r10, r11, r12, r0);
        goto L11
    L9:
        r0 = new t(r10, r11, r12, r7, this.j);
    L11:
        return r0;
    }

    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> c(Class<Data> r13, Class<TResource> r14, Class<Transcode> r15) {
        ArrayList r0 = new ArrayList();
        Iterator r16 = this.f3306c.b(r13, r14).iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        Class r1 = (Class) ZeusTransformUtils.preCheckCast(r16.next(), Class.class, "com.obric.aiagent.plugin");
        Iterator r2 = this.f.b(r1, r15).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Class r7 = (Class) ZeusTransformUtils.preCheckCast(r2.next(), Class.class, "com.obric.aiagent.plugin");
        r0.add(new i(r13, r1, r7, this.f3306c.a(r13, r1), this.f.a(r1, r7), this.j));
        goto L7
    L9:
        return r0;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> r7, Class<TResource> r8, Class<Transcode> r9) {
        List<Class<?>> r0 = this.h.a(r7, r8, r9);
        if (r0 != null) goto L16;
        r0 = new ArrayList();
        Iterator<Class<?>> r1 = this.f3304a.a(r7).iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Class r2 = (Class) ZeusTransformUtils.preCheckCast(r1.next(), Class.class, "com.obric.aiagent.plugin");
        Iterator r3 = this.f3306c.b(r2, r8).iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        Class<?> r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.aiagent.plugin");
        if (this.f.b(r4, r9).isEmpty() == true) goto L9;
        if (r0.contains(r4) == true) goto L9;
        r0.add(r4);
        goto L9
    L15:
        this.h.a(r7, r8, r9, Collections.unmodifiableList(r0));
    L16:
        return r0;
    }

    public boolean a(v<?> r3) {
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        if (this.f3307d.a(r4.c()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public <X> l<X> b(v<X> r3) {
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
        l<X> r2 = this.f3307d.a(r4.c());
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new d(r4.c());
    }

    public <X> com.bumptech.glide.load.d<X> a(X r2) {
        com.bumptech.glide.load.d<X> r1 = this.f3305b.a(r2.getClass());
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new e(r2.getClass());
    }

    public <X> com.bumptech.glide.load.a.e<X> b(X r1) {
        return this.f3308e.a(r1);
    }

    public <Model> List<n<Model, ?>> c(Model r1) {
        return this.f3304a.a(r1);
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> r1 = this.g.a();
        if (r1.isEmpty() == true) goto L6;
        return r1;
    L6:
        throw new b();
    }
}
