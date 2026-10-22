package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.c;
import com.obric.aiagent.product.a.d;
import com.obric.aiagent.product.a.f;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.rom.IRomInfoKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: CommonRomInfoImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommonRomInfoImpl implements IRomInfo {
    private static final String AIKERNEL_PACKAGE_NAME = "com.obric.aikernel";
    private static final long AIKERNEL_PREINSTALLED_MIN_VERSION_CODE = 500010300;
    private static final a Companion = null;
    private static final String TAG = "CommonRomInfoImpl";

    /* JADX INFO: compiled from: CommonRomInfoImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        return null;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
    }

    public CommonRomInfoImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        String r1 = Build.BRAND;
        o.c(r1, "BRAND");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        String r1 = Build.MODEL;
        o.c(r1, "MODEL");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        String r1 = Build.VERSION.INCREMENTAL;
        o.c(r1, "INCREMENTAL");
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        String r4 = Build.VERSION.INCREMENTAL;
        c r0 = c.f18771a;
        o.a(r4);
        String r1 = r0.c(r4);
        ILogDepend.Companion.i(TAG, "getShortOSVersion: incrementalVersion " + r4 + ", shortVersion " + r1);
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        Long.parseLong(d.f18776a.a("ro.build.date.utc", "0"));
        int r5 = f.f18787a.a(Build.TIME);
        Integer r0 = f.f18787a.a(d.f18776a.a("ro.build.date", "0"));
        ILogDepend.Companion.i(TAG, "getOSReleaseDate: time " + Build.TIME + ", date " + r5 + ", data2 " + r0 + ' ');
        if (r0 != null) goto L5;
        return r5;
    L5:
        return r0.intValue();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(d.h.a.b<? super String, x> r2) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        r1.invoke("");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        return com.obric.aiagent.product.a.b.f18770a.b();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return com.obric.aiagent.product.a.b.f18770a.a();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return d.f18776a.a("ro.vendor.feature.zte_feature_abroad", IRomInfoKt.REGION_CN);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        String r4 = d.f18776a.a("ro.build.type", SensitiveType.UNKNOWN);
        if (o.a(d.f18776a.a("ro.debuggable", "0"), "1") == false) goto L5;
        String r0 = "root";
    L6:
        ILogDepend.Companion.i(TAG, "getRomBuildType: buildType " + r4 + ", isRoot " + r0);
        return r4 + r0;
    L5:
        r0 = "";
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L23
        PackageInfo r11 = r10.getPackageManager().getPackageInfo("com.obric.aikernel", 0);     // Catch: Throwable -> L23
        boolean r3 = true;
        if ((r11.applicationInfo.flags & 1) == 0) goto L6;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L14;
        ILogDepend.Companion.i(TAG, "isOautoModelPreinstalled: package flags=" + r11.applicationInfo.flags);     // Catch: Throwable -> L23
        return false;
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        long r5 = r11.getLongVersionCode();     // Catch: Throwable -> L23
    L18:
        if (r5 >= AIKERNEL_PREINSTALLED_MIN_VERSION_CODE) goto L21;
        r3 = false;
    L21:
        ILogDepend.Companion.i(TAG, "isOautoModelPreinstalled: package=com.obric.aikernel, versionCode=" + r5 + ", isPreinstalled=" + r3);     // Catch: Throwable -> L23
        Object r12 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L23
    L25:
        Throwable r6 = n.c(r12);
        if (r6 == null) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, PackageManager.NameNotFoundException.class) == false) goto L31;
        ILogDepend.Companion.i(TAG, "isOautoModelPreinstalled: package com.obric.aikernel not found");
    L32:
        r12 = false;
        goto L34
    L31:
        ILogDepend.Companion.e(TAG, "isOautoModelPreinstalled failed", r6);
    L34:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L16:
        r5 = r11.versionCode;     // Catch: Throwable -> L23
        goto L18
    L6:
        if ((r11.applicationInfo.flags & 128) != 0) goto L9;
        r4 = false;
    L23:
        th = move-exception;
        n.a r7 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L25
    }
}
