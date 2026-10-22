package com.bytedance.android.livesdk.account.impl;

import com.bytedance.android.livehostapi.platform.depend.Callback;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Callback<Boolean> {
    public a() {
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.Callback
    public /* bridge */ /* synthetic */ void call(Boolean r100) {
        call(r100.booleanValue());
    }

    public void call(boolean r100) {
        Lazy r101 = AuthReporter.f103001a;
        AuthReporter.c(true, r100, null, "");
    }
}
