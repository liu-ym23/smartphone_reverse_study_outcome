package com.bytedance.crash.general;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HardwareInfo implements Serializable {
    private static final String FILE_NAME = "hardware.inf";
    public static final String KEY_HW_CPU_ABI = "cpu_abi";
    public static final String KEY_HW_CPU_HARDWARE = "hardware";
    public static final String KEY_HW_CPU_MODEL = "cpu_model";
    public static final String KEY_HW_DENSITY_DPI = "density_dpi";
    public static final String KEY_HW_DISPLAY_DENSITY = "display_density";
    public static final String KEY_HW_DISPLAY_RESOLUTION = "resolution";
    public static final String KEY_HW_RAM_SIZE = "ram_size";
    public static final String KEY_HW_VENDOR_BRAND = "device_brand";
    public static final String KEY_HW_VENDOR_MANUFACTURER = "device_manufacturer";
    public static final String KEY_HW_VENDOR_MODEL = "device_model";
    private static final long serialVersionUID = 20241001154124L;
    private String mCpuAbi;
    private String mCpuHardware;
    private String mCpuModel;
    private String mDisplayDensity;
    private int mDisplayDensityDpi;
    private String mDisplayResolution;
    private long mJiffies;
    private String mRamSize;
    private String mVendorBrand;
    private String mVendorManufacturer;
    private String mVendorModel;

    public HardwareInfo() {
    }

    static HardwareInfo get(Context r5, File r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        File r1 = new File(r6, FILE_NAME);
        HardwareInfo r8 = (HardwareInfo) ZeusTransformUtils.preCheckCast((HardwareInfo) ZeusTransformUtils.preCheckCast(v.a(r1), HardwareInfo.class, "com.obric.aiagent.plugin"), HardwareInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
    L6:
        if (r8 != null) goto L11;
        r8 = new HardwareInfo();
        r8.mVendorModel = b.g();
        r8.mVendorBrand = b.f();
        r8.mVendorManufacturer = b.e();
        r8.mJiffies = b.a();
        r8.mCpuAbi = b.b();
        r8.mCpuModel = b.d();
        r8.mCpuHardware = b.c();
        DisplayMetrics r9 = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r9 == null) goto L10;
        r8.mDisplayResolution = b.a(r9);
        r8.mDisplayDensity = b.c(r9);
        r8.mDisplayDensityDpi = b.b(r9);
    L10:
        r8.mRamSize = b.h();
        v.a(r1, r8);
    L11:
        return r8;
    L5:
        r8 = null;
        goto L6
    }

    void putTo(JSONObject r3) {
        l.a(r3, KEY_HW_VENDOR_BRAND, this.mVendorBrand);
        l.a(r3, KEY_HW_VENDOR_MODEL, this.mVendorModel);
        l.a(r3, KEY_HW_VENDOR_MANUFACTURER, this.mVendorManufacturer);
        l.a(r3, KEY_HW_DENSITY_DPI, Integer.valueOf(this.mDisplayDensityDpi));
        l.a(r3, KEY_HW_DISPLAY_RESOLUTION, this.mDisplayResolution);
        l.a(r3, KEY_HW_DISPLAY_DENSITY, this.mDisplayDensity);
        l.a(r3, KEY_HW_CPU_ABI, this.mCpuAbi);
        l.a(r3, KEY_HW_CPU_HARDWARE, this.mCpuHardware);
        l.a(r3, KEY_HW_CPU_MODEL, this.mCpuModel);
        l.a(r3, KEY_HW_RAM_SIZE, this.mRamSize);
    }

    long getJiffy() {
        return this.mJiffies;
    }
}
