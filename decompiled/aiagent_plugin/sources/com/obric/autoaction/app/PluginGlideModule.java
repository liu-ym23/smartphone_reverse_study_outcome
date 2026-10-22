package com.obric.autoaction.app;

import android.content.Context;
import com.bumptech.glide.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PluginGlideModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PluginGlideModule extends com.bumptech.glide.c.a {
    @Override // com.bumptech.glide.c.a, com.bumptech.glide.c.b
    public void a(Context r2, c r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "builder");
    }

    @Override // com.bumptech.glide.c.a
    public boolean c() {
        return false;
    }

    public PluginGlideModule() {
    }
}
