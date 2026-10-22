package com.bytedance.ai.lynx;

import com.bytedance.ai.resource.AppletResourceTool;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends d8a.k<Object, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36653b;

    public e(String r100, String r101) {
        this.f36652a = r100;
        this.f36653b = r101;
    }

    @Override // d8a.k
    public final void request(final LynxResourceRequest<Object> r100, final LynxResourceCallback<byte[]> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = this.f36653b;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = r100.f383547a;
    L12:
        com.bytedance.ai.utils.g.f37637a.i("AppletResourceLoader", "AppletExternalJSProvider start to load " + r100.f383547a + ", realUrl: " + r104);
        AppletResourceTool r105 = AppletResourceTool.f37276a;
        String r106 = this.f36652a;
        Intrinsics.checkNotNull(r104);
        Function1 r107 = new c(r100, r101);
        Function1 r108 = new d(r100, r101);
        r105.getClass();
        AppletResourceTool.q(r106, r104, r107, r108, false);
        return;
    L11:
        r104 = AppletResourceTool.f37276a.g(r100.f383547a, this.f36653b);
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
