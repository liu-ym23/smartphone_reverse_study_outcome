package com.bytedance.android.ec.core.gecko;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
@GeckoRegister(boeAccessKey = "c72b7611fbad48bc66a0c8814f20530d", prodAccessKey = "11f41d655db1c7dd83e5c59c5122ca5e", testAccessKey = "67f5c8c81d6fd7f0cf930563f4b520cc")
public class ECGeckoRegister implements IGeckoRegister {
    public ECGeckoRegister() {
    }

    public static String a() {
        String r100 = Integer.toString(44700);     // Catch: Exception -> L8
        int r101 = r100.length();     // Catch: Exception -> L8
        if (r101 < 5) goto L11;
        int r102 = r101 - 4;     // Catch: Exception -> L8
        int r103 = r101 - 3;     // Catch: Exception -> L8
        return r100.substring(0, r102) + "." + r100.substring(r102, r103) + "." + r100.substring(r103, r101 - 2);
    L11:
        return "1.0.0";
    L12:
        return "1.0.0";
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public final Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        HashMap r100 = new HashMap();
        r100.put("business_version", new c());
        return r100;
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public final String registerRootDir(Context r100) {
        return new PolarisFileWrapper(r100.getFilesDir(), "offlineX").getAbsolutePath();
    }
}
