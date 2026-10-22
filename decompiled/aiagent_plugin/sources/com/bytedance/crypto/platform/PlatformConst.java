package com.bytedance.crypto.platform;

import com.bytedance.crypto.utils.FrameworkSecurityCompat;

/* JADX INFO: loaded from: classes.dex */
public class PlatformConst {
    public static final String BUNDLE_KEY_BRAND = "brand";
    public static final String BUNDLE_KEY_PKG_NAME = "pkg_name";
    public static final String BUNDLE_KEY_SOC_MODEL = "soc_model";
    public static final int EXTERNAL_PLATFORM_KEY_VER = 1;
    public static final int G1_PLATFORM_VERSION = -851967;
    public static final int N1_SM8850_PLATFORM_VERSION = -917501;
    public static final int PLATFORM_KEY_MAGIC_NUM = -65536;
    public static final String PROP_BRAND = "ro.product.brand";
    public static final String PROP_MANUFACTURER = "ro.product.manufacturer";
    public static final String PROP_PRODUCT_TYPE = "ro.system_ext.product.type";
    public static final String PROP_SOC_MODEL = "ro.soc.model";
    public static final int RD_ASSETS_DATA_IV_LEN = 12;
    public static final int RD_ASSETS_VERSION = 1;
    public static final int SM8750_PLATFORM_VERSION = 0;
    public static final int TYPE_MODEL = 1;

    static {
        SM8750_PLATFORM_VERSION = FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_SM8750();
    }

    public PlatformConst() {
    }
}
