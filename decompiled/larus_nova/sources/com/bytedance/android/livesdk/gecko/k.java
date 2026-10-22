package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.geckox.OptionCheckUpdateParams;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements OptionCheckUpdateParams.CustomValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f125816a = null;

    static {
        f125816a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
    public final Object getValue() {
        return ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getVersionName();
    }
}
