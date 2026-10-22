package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.autoaction.app.PluginGlideModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PluginGlideModule f3210a;

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* synthetic */ RequestManagerRetriever.a b() {
        return d();
    }

    public GeneratedAppGlideModuleImpl(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f3210a = new PluginGlideModule();
        if (a("Glide", 3) == false) goto L6;
        a("Glide", "Discovered AppGlideModule from annotation: com.obric.autoaction.app.PluginGlideModule");
        return;
    }

    @Override // com.bumptech.glide.c.a, com.bumptech.glide.c.b
    public void a(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f3210a.a(r5, r4);
    }

    @Override // com.bumptech.glide.c.d, com.bumptech.glide.c.f
    public void a(Context r3, Glide r4, f r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f3210a.a(r6, r4, r5);
    }

    @Override // com.bumptech.glide.c.a
    public boolean c() {
        return this.f3210a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    a d() {
        return new a();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
