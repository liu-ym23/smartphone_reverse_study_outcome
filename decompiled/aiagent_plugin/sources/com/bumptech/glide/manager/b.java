package com.bumptech.glide.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApplicationLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
class b implements h {
    @Override // com.bumptech.glide.manager.h
    public void b(i r2) {
        i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
    }

    b() {
    }

    @Override // com.bumptech.glide.manager.h
    public void a(i r2) {
        ((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin")).onStart();
    }
}
