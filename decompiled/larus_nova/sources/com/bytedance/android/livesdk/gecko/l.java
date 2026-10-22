package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.OptionCheckUpdateParams;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements OptionCheckUpdateParams.CustomValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f125817a = null;

    static {
        f125817a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
    public final Object getValue() {
        return String.valueOf(com.bytedance.android.livesdk.paas.c.b());
    }
}
