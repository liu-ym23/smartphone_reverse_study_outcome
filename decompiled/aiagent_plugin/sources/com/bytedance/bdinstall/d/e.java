package com.bytedance.bdinstall.d;

import android.content.Context;
import android.os.Build;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: BuildLoader.java */
/* JADX INFO: loaded from: classes.dex */
class e extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6213e;

    e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6213e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r2) {
        r2.put(RomInfo.KEY_OS_TYPE, "Android");
        r2.put(RomInfo.KEY_ROM_OS_VERSION, Build.VERSION.RELEASE);
        r2.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT);
        if (Build.BRAND.equals("Pico") == false) goto L5;
        String r1 = com.bytedance.bdinstall.j.p.c();
    L6:
        r2.put(HardwareInfo.KEY_HW_VENDOR_MODEL, r1);
        r2.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);
        r2.put(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, Build.MANUFACTURER);
        r2.put(HardwareInfo.KEY_HW_CPU_ABI, Build.CPU_ABI);
        return true;
    L5:
        r1 = Build.MODEL;
        goto L6
    }
}
