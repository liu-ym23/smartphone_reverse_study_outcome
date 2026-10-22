package com.bumptech.glide.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<i> f3893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3895c;

    a() {
        this.f3893a = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // com.bumptech.glide.manager.h
    public void a(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        this.f3893a.add(r4);
        if (this.f3895c == false) goto L6;
        r4.onDestroy();
        return;
    L6:
        if (this.f3894b == false) goto L8;
        r4.onStart();
        return;
    L8:
        r4.onStop();
    }

    @Override // com.bumptech.glide.manager.h
    public void b(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        this.f3893a.remove(r4);
    }

    void a() {
        this.f3894b = true;
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3893a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((i) ZeusTransformUtils.preCheckCast(r3.next(), i.class, "com.obric.aiagent.plugin")).onStart();
        goto L4
    }

    void b() {
        this.f3894b = false;
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3893a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((i) ZeusTransformUtils.preCheckCast(r3.next(), i.class, "com.obric.aiagent.plugin")).onStop();
        goto L4
    }

    void c() {
        this.f3895c = true;
        Iterator r3 = com.bumptech.glide.f.k.a(this.f3893a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((i) ZeusTransformUtils.preCheckCast(r3.next(), i.class, "com.obric.aiagent.plugin")).onDestroy();
        goto L4
    }
}
