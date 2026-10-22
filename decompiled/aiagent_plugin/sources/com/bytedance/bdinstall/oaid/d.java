package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoolpadOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends b<IDeviceIdManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6395a;

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "coolpad";
    }

    static /* synthetic */ Context a(d r0) {
        return r0.f6395a;
    }

    d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super("com.coolpad.deviceidsupport");
        this.f6395a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.oaid.b, com.bytedance.bdinstall.oaid.k
    public k.a c(Context r3) {
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
        k.a r1 = new k.a();     // Catch: Throwable -> L9
        r1.f6412b = r0;     // Catch: Throwable -> L9
        return r1;
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<IDeviceIdManager, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r4;
    }
}
