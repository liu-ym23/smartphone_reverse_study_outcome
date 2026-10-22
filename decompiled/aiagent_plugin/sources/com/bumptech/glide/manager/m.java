package com.bumptech.glide.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.target.i<?>> f3905a;

    public m() {
        this.f3905a = Collections.newSetFromMap(new WeakHashMap());
    }

    public void a(com.bumptech.glide.request.target.i<?> r3) {
        com.bumptech.glide.request.target.i<?> r4 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
        this.f3905a.add(r4);
    }

    public void b(com.bumptech.glide.request.target.i<?> r3) {
        com.bumptech.glide.request.target.i r4 = (com.bumptech.glide.request.target.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin");
        this.f3905a.remove(r4);
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3905a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.target.i) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin")).onStart();
        goto L4
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3905a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.target.i) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin")).onStop();
        goto L4
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3905a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.target.i) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.target.i.class, "com.obric.aiagent.plugin")).onDestroy();
        goto L4
    }

    public List<com.bumptech.glide.request.target.i<?>> a() {
        return com.bumptech.glide.f.k.a(this.f3905a);
    }

    public void b() {
        this.f3905a.clear();
    }
}
