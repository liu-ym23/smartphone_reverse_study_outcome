package com.obric.aiagent.product.platform.api.rom;

import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.feature.impl.a;
import com.obric.aiagent.product.platform.impl.rom.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: RomInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RomInfo implements IRomInfo {
    public static final RomInfo INSTANCE = null;
    private static final String TAG = "RomInfo";
    private static IRomInfo instance;

    public static /* synthetic */ Object lambda$CrS5oupOPBkHLh1MEP7fKaeymXc() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$g_n24Wq054LWtcA5OVjBf68mkcQ() {
        return _init_$lambda$0();
    }

    private RomInfo() {
    }

    static {
        INSTANCE = new RomInfo();
    L16:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "init RomInfo failed", th);
    L18:
        instance = (IRomInfo) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRomInfo.class, false), IRomInfo.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "RomInfo instance: " + instance);
        return;
    L4:
        if (a.f18789a.a().isObricOs() == false) goto L24;
        ServiceManager.get().bind(IRomInfo.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$RomInfo$g_n24Wq054LWtcA5OVjBf68mkcQ.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L14:
        ILogDepend.Companion.i(TAG, "bind RomInfo isOs=" + a.f18789a.a().isObricOs());     // Catch: Throwable -> L16
        goto L18
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind PacificRomInfoImpl failed", th);     // Catch: Throwable -> L16
        x r2 = x.f38692a;     // Catch: Throwable -> L16
        goto L14
    L24:
        ServiceManager.get().bind(IRomInfo.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$RomInfo$CrS5oupOPBkHLh1MEP7fKaeymXc.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind PublicRomInfoImpl failed", th);     // Catch: Throwable -> L16
        x r3 = x.f38692a;     // Catch: Throwable -> L16
        goto L14
    }

    private static final Object _init_$lambda$0() {
        return new com.obric.aiagent.product.platform.impl.rom.a();
    }

    private static final Object _init_$lambda$1() {
        return new b();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        r0.tryInit();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceBrand();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceModel();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getOSVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getShortOSVersion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOSDeviceIdFromCache();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(d.h.a.b<? super String, x> r2) {
        d.h.a.b<? super String, x> r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        IRomInfo r3 = instance;
        if (r3 == null) goto L5;
        r3.getOSDeviceIdAsync(r1);
        return;
    L5:
        r1.invoke("");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getFwkApiVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.useAssistantApi();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getRomReleaseRegion();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        IRomInfo r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getRomBuildType();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        IRomInfo r3 = instance;
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.isOautoModelPreinstalled(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        IRomInfo r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isUTRom();
    }
}
