package com.bytedanceos.common.toolbox.glide;

import kotlin.text.o;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final Object a(Object r10) {
        if ((r10 instanceof String) == false) goto L12;
        String r11 = (String) r10;
        if (o.B(r11, "https", false, 2, null) == true) goto L11;
        if (o.B(r11, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) == true) goto L11;
        return r10;
    L11:
        return new CustomGlideUrl(r10.toString());
    L12:
        return r10;
    }
}
