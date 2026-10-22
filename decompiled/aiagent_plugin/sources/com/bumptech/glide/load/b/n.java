package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public interface n<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.g f3466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.g> f3467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.a.d<Data> f3468c;

        public a(com.bumptech.glide.load.g r3, com.bumptech.glide.load.a.d<Data> r4) {
            com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.a.d r6 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
            this(r5, Collections.emptyList(), r6);
        }

        public a(com.bumptech.glide.load.g r3, List<com.bumptech.glide.load.g> r4, com.bumptech.glide.load.a.d<Data> r5) {
            com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.a.d r8 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
            this.f3466a = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r6), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
            this.f3467b = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r7), List.class, "com.obric.aiagent.plugin");
            this.f3468c = (com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r8), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        }
    }

    a<Data> a(Model r1, int r2, int r3, com.bumptech.glide.load.i r4);

    boolean a(Model r1);
}
