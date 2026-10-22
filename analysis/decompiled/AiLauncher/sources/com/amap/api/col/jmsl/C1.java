package com.amap.api.col.jmsl;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class C1 extends s7 {
    @Override // com.amap.api.col.jmsl.s7
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri uri = Uri.parse(url);
        if (uri.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (uri.getAuthority().startsWith("restsdk.amap.com")) {
            return uri.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return uri.buildUpon().authority("dualstack-" + uri.getAuthority()).build().toString();
    }

    @Override // com.amap.api.col.jmsl.s7
    public boolean isSupportIPV6() {
        return true;
    }
}
