package com.byted.cast.common.auth;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class AuthUtils {
    public AuthUtils() {
    }

    public static List<String> getProtocols(List<String> r100, String r101) {
        ArrayList r102 = new ArrayList();
        if (r100 != null) goto L5;
    L21:
        return r102;
    L5:
        if (r100.size() <= 0) goto L21;
        if (TextUtils.equals(r101, "source") == false) goto L9;
        String r103 = AuthConstants.SERVICE_SOURCE_PROTOCOL_PREFIX;
    L11:
        if (r100.size() <= 0) goto L21;
        Iterator<String> r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L21;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L14;
        if (r105.startsWith(r103) == false) goto L14;
        r102.add(r105.substring(r103.length()));
        goto L14
    L9:
        r103 = AuthConstants.SERVICE_SINK_PROTOCOL_PREFIX;
        goto L11
    }
}
