package com.amap.api.mapcore.util;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public abstract class s5 extends y7 {
    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL()) == true) goto L5;
        String r100 = getURL();
        Uri r101 = UriProtector.parse(r100);
        if (r101.getAuthority().startsWith("dualstack-") == false) goto L10;
        return r100;
    L10:
        if (r101.getAuthority().startsWith("restsdk.amap.com") == false) goto L14;
        return r101.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
    L14:
        return r101.buildUpon().authority("dualstack-" + r101.getAuthority()).build().toString();
    L5:
        return getURL();
    }

    public s5() {
    }
}
