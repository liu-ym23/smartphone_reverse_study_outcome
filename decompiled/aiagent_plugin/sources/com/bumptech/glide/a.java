package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.k;
import com.obric.autoaction.app.GlideRequests;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GeneratedRequestManagerFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements RequestManagerRetriever.a {
    a() {
    }

    @Override // com.bumptech.glide.manager.RequestManagerRetriever.a
    public RequestManager a(Glide r2, com.bumptech.glide.manager.h r3, k r4, Context r5) {
        return new GlideRequests(r2, (com.bumptech.glide.manager.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.manager.h.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"));
    }
}
