package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceTokenServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class s extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile u f6441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile an f6442c;

    public s(an r3, u r4) {
        this.f6442c = r3;
        this.f6440a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f6441b = r4;
    }

    @Override // com.bytedance.bdinstall.r
    public void a(String r3, u r4) {
        this.f6441b = r4;
        if (r4 == null) goto L7;
        SharedPreferences r5 = r4.a(this.f6442c);
        if (r5 == null) goto L7;
        r5.edit().putString("device_token", r3).apply();
    L7:
        az.a(this.f6440a).a(this.f6442c.b(), "device_token", r3);
    }
}
