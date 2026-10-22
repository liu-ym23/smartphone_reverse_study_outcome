package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public abstract class bp extends cy {
    @Override // com.amap.api.col.s.cy
    public final boolean k() {
        return true;
    }

    @Override // com.amap.api.col.s.cy
    public String a_() {
        if (TextUtils.isEmpty(h()) == true) goto L5;
        String r100 = h();
        Uri r101 = UriProtector.parse(r100);
        if (r101.getAuthority().startsWith("dualstack-") == false) goto L10;
        return r100;
    L10:
        return r101.buildUpon().authority("dualstack-" + r101.getAuthority()).build().toString();
    L5:
        return h();
    }

    public bp() {
    }
}
