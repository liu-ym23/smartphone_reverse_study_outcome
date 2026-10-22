package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class NativeCronetProvider extends com.ttnet.org.chromium.net.f {
    @Override // com.ttnet.org.chromium.net.f
    public String a() {
        return "App-Packaged-Cronet-Provider";
    }

    @Override // com.ttnet.org.chromium.net.f
    public boolean c() {
        return true;
    }

    public NativeCronetProvider(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.f
    public com.ttnet.org.chromium.net.d.a a(boolean r2) {
        return new com.ttnet.org.chromium.net.h.a(new v(this.f37898a, r2));
    }

    @Override // com.ttnet.org.chromium.net.f
    public String b() {
        return ImplVersion.b();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.f37898a});
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, NativeCronetProvider.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f37898a.equals(((NativeCronetProvider) ZeusTransformUtils.preCheckCast(r3, NativeCronetProvider.class, "com.obric.aiagent.plugin")).f37898a) == false) goto L9;
        goto L9
    }
}
