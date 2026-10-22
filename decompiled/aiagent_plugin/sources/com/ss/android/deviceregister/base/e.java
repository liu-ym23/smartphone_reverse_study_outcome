package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoolpadOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class e extends c<IDeviceIdManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f37368a;

    static /* synthetic */ Context a(e r0) {
        return r0.f37368a;
    }

    e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super("com.coolpad.deviceidsupport");
        this.f37368a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.deviceregister.base.c, com.ss.android.deviceregister.base.o
    public o.a c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        return super.c(r4);
    L4:
        if (Build.VERSION.SDK_INT < 17) goto L12;
        String r0 = Settings.Global.getString(r4.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r0) == true) goto L12;
        o.a r1 = new o.a();     // Catch: Throwable -> L9
        r1.f37379a = r0;     // Catch: Throwable -> L9
        return r1;
    }

    @Override // com.ss.android.deviceregister.base.c
    public ServiceBlockBinder.a<IDeviceIdManager, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.base.c
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r4;
    }
}
