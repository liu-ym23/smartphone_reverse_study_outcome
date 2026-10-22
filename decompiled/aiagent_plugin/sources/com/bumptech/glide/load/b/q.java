package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f3473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.util.f.a<List<Throwable>> f3474b;

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.a.d<Data>, com.bumptech.glide.load.a.d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.a.d<Data>> f3475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.util.f.a<List<Throwable>> f3476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bumptech.glide.e f3478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bumptech.glide.load.a.d.a<? super Data> f3479e;
        private List<Throwable> f;
        private boolean g;

        a(List<com.bumptech.glide.load.a.d<Data>> r3, androidx.core.util.f.a<List<Throwable>> r4) {
            List<com.bumptech.glide.load.a.d<Data>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f3476b = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.f.j.a(r5);
            this.f3475a = r5;
            this.f3477c = 0;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r3, com.bumptech.glide.load.a.d.a<? super Data> r4) {
            com.bumptech.glide.load.a.d.a<? super Data> r5 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            this.f3478d = r3;
            this.f3479e = r5;
            this.f = (List) ZeusTransformUtils.preCheckCast(this.f3476b.a(), List.class, "com.obric.aiagent.plugin");
            ((com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(this.f3475a.get(this.f3477c), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin")).a(r3, this);
            if (this.g == false) goto L6;
            c();
            return;
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            List<Throwable> r0 = this.f;
            if (r0 == null) goto L5;
            this.f3476b.a(r0);
        L5:
            this.f = null;
            Iterator<com.bumptech.glide.load.a.d<Data>> r3 = this.f3475a.iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            ((com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin")).b();
            goto L7
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
            this.g = true;
            Iterator<com.bumptech.glide.load.a.d<Data>> r3 = this.f3475a.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin")).c();
            goto L4
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return ((com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(this.f3475a.get(0), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return ((com.bumptech.glide.load.a.d) ZeusTransformUtils.preCheckCast(this.f3475a.get(0), com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin")).d();
        }

        @Override // com.bumptech.glide.load.a.d.a
        public void a(Data r1) {
            if (r1 == null) goto L4;
            this.f3479e.a(r1);
            return;
        L4:
            e();
        }

        @Override // com.bumptech.glide.load.a.d.a
        public void a(Exception r4) {
            ((List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f), List.class, "com.obric.aiagent.plugin")).add(r4);
            e();
        }

        private void e() {
            if (this.g == false) goto L6;
            return;
        L6:
            if (this.f3477c >= (this.f3475a.size() - 1)) goto L8;
            this.f3477c++;
            a(this.f3478d, this.f3479e);
            return;
        L8:
            com.bumptech.glide.f.j.a(this.f);
            this.f3479e.a(new com.bumptech.glide.load.engine.q("Fetch failed", new ArrayList(this.f)));
        }
    }

    q(List<n<Model, Data>> r3, androidx.core.util.f.a<List<Throwable>> r4) {
        List<n<Model, Data>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        androidx.core.util.f.a<List<Throwable>> r6 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3473a = r5;
        this.f3474b = r6;
    }

    @Override // com.bumptech.glide.load.b.n
    public n.a<Data> a(Model r9, int r10, int r11, com.bumptech.glide.load.i r12) {
        int r0 = this.f3473a.size();
        ArrayList r1 = new ArrayList(r0);
        int r3 = 0;
        com.bumptech.glide.load.g r4 = null;
    L3:
        if (r3 >= r0) goto L11;
        n r5 = (n) ZeusTransformUtils.preCheckCast(this.f3473a.get(r3), n.class, "com.obric.aiagent.plugin");
        if (r5.a(r9) == false) goto L9;
        n.a<Data> r6 = r5.a(r9, r10, r11, r12);
        if (r6 == null) goto L9;
        r4 = r6.f3466a;
        r1.add(r6.f3468c);
    L9:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r1.isEmpty() == true) goto L19;
        if (r4 != null) goto L14;
        return null;
    L14:
        return new n.a(r4, new a(r1, this.f3474b));
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.b.n
    public boolean a(Model r4) {
        Iterator<n<Model, Data>> r3 = this.f3473a.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin")).a(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f3473a.toArray()) + '}';
    }
}
