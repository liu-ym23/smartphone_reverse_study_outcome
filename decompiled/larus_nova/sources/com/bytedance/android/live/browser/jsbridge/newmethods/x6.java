package com.bytedance.android.live.browser.jsbridge.newmethods;

import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class x6 implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f63720a;

    public x6(Map r100) {
        this.f63720a = r100;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "JSB 发送 " + this.f63720a.toString();
    }
}
