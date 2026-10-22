package com.bytedance.crash.general;

import com.bytedance.crash.o.l;
import com.bytedance.crash.o.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RomInfo implements Serializable {
    private static final String FILE_NAME = "rom.inf";
    public static final String KEY_OS_TYPE = "os";
    private static final String KEY_ROM_HARMONY_OS = "is_hm_os";
    private static final String KEY_ROM_INCREMENTAL = "rom";
    public static final String KEY_ROM_KERNEL_VERSION = "kernel_version";
    public static final String KEY_ROM_OS_API = "os_api";
    public static final String KEY_ROM_OS_VERSION = "os_version";
    private static final String KEY_ROM_VERSION = "rom_version";
    private static final long serialVersionUID = 1;
    private boolean mIsHarmonyOs;
    private String mKernelVersion;
    private int mOsApiLevel;
    private String mOsVersion;
    private String mRandomDeviceId;
    private String mRomIncremental;
    private String mRomVersion;

    public RomInfo() {
    }

    String getRandomDeviceId() {
        return this.mRandomDeviceId;
    }

    static RomInfo get(File r4) {
        File r2 = new File(r4, FILE_NAME);
        String r5 = c.h();
        RomInfo r0 = (RomInfo) ZeusTransformUtils.preCheckCast((RomInfo) ZeusTransformUtils.preCheckCast(v.a(r2), RomInfo.class, "com.obric.aiagent.plugin"), RomInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
    L6:
        if (r0 != null) goto L8;
    L9:
        RomInfo r1 = new RomInfo();
        r1.mRomVersion = r5;
        r1.mOsVersion = c.b();
        r1.mIsHarmonyOs = c.f();
        r1.mKernelVersion = c.e();
        r1.mRomIncremental = c.g();
        r1.mOsApiLevel = c.c();
        r1.mRandomDeviceId = c.d();
        v.a(r2, r1);
        return r1;
    L8:
        if (r5.equals(String.valueOf(r0.mRomVersion)) == false) goto L9;
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    void putTo(JSONObject r3) {
        l.a(r3, KEY_OS_TYPE, "Android");
        l.a(r3, KEY_ROM_OS_VERSION, this.mOsVersion);
        l.a(r3, KEY_ROM_OS_API, Integer.valueOf(this.mOsApiLevel));
        l.a(r3, KEY_ROM_HARMONY_OS, Boolean.valueOf(this.mIsHarmonyOs));
        l.a(r3, KEY_ROM_KERNEL_VERSION, this.mKernelVersion);
        l.a(r3, KEY_ROM_INCREMENTAL, this.mRomIncremental);
        l.a(r3, KEY_ROM_VERSION, this.mRomVersion);
    }
}
