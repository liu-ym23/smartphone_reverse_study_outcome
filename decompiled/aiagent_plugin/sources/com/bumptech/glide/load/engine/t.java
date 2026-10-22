package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes.dex */
public class t<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Data> f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.util.f.a<List<Throwable>> f3731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f3732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3733d;

    public t(Class<Data> r3, Class<ResourceType> r4, Class<Transcode> r5, List<i<Data, ResourceType, Transcode>> r6, androidx.core.util.f.a<List<Throwable>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        androidx.core.util.f.a<List<Throwable>> r9 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r7, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3730a = r3;
        this.f3731b = r9;
        this.f3732c = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r8), List.class, "com.obric.aiagent.plugin");
        this.f3733d = "Failed LoadPath{" + r3.getSimpleName() + "->" + r4.getSimpleName() + "->" + r5.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.a.e<Data> r10, com.bumptech.glide.load.i r11, int r12, int r13, i.a<ResourceType> r14) {
        com.bumptech.glide.load.a.e<Data> r3 = (com.bumptech.glide.load.a.e) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.a.e.class, "com.obric.aiagent.plugin");
        i.a<ResourceType> r7 = (i.a) ZeusTransformUtils.wrapperContextForParams(r14, i.a.class, "com.obric.aiagent.plugin");
        List<Throwable> r15 = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3731b.a()), List.class, "com.obric.aiagent.plugin");
        v<Transcode> r16 = a(r3, r11, r12, r13, r7, r15);     // Catch: Throwable -> L6
        this.f3731b.a(r15);
        return r16;
    L6:
        th = move-exception;
        this.f3731b.a(r15);
        throw th;
    }

    private v<Transcode> a(com.bumptech.glide.load.a.e<Data> r16, com.bumptech.glide.load.i r17, int r18, int r19, i.a<ResourceType> r20, List<Throwable> r21) {
        com.bumptech.glide.load.a.e r9 = (com.bumptech.glide.load.a.e) ZeusTransformUtils.wrapperContextForParams(r16, com.bumptech.glide.load.a.e.class, "com.obric.aiagent.plugin");
        i.a<ResourceType> r10 = (i.a) ZeusTransformUtils.wrapperContextForParams(r20, i.a.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        int r12 = this.f3732c.size();
        v<Transcode> r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L12;
        r13 = ((i) ZeusTransformUtils.preCheckCast(this.f3732c.get(r14), i.class, "com.obric.aiagent.plugin")).a(r9, r18, r19, r17, r10);     // Catch: q -> L7
    L9:
        if (r13 != null) goto L12;
        r14 = r14 + 1;
    L7:
        e = move-exception;
        r11.add(e);
    L12:
        if (r13 == null) goto L15;
        return r13;
    L15:
        throw new q(this.f3733d, new ArrayList(r11));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f3732c.toArray()) + '}';
    }
}
