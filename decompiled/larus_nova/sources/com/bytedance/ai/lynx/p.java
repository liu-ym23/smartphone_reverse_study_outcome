package com.bytedance.ai.lynx;

import android.content.Context;
import com.bytedance.ai.resource.AppletResourceTool;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p extends com.bytedance.ai.applet.render.core.lynx.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f36677c;

    @Override // com.bytedance.ai.applet.render.core.lynx.b
    public final void d(String r100, final e8a.a<h8a.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        String r102 = this.f36677c;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = r100;
    L12:
        com.bytedance.ai.utils.g.f37637a.i("AppletResourceLoader", "AppletTemplateResourceFetcher start to load " + r100 + ", realUrl: " + r104);
        AppletResourceTool r105 = AppletResourceTool.f37276a;
        String r106 = this.f36676b;
        Function1 r107 = new n(r101, this);
        Function1 r108 = new o(r101, this);
        r105.getClass();
        AppletResourceTool.q(r106, r104, r107, r108, false);
        return;
    L11:
        r104 = AppletResourceTool.f37276a.g(r100, this.f36677c);
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public p(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f36676b = r101;
        this.f36677c = r102;
    }
}
