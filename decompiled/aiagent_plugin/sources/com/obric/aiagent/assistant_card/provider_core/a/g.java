package com.obric.aiagent.assistant_card.provider_core.a;

import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: UriEx.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = "UriEx";

    public static final String a(Uri r2) {
        o.e(r2, "<this>");
        List<String> r3 = r2.getPathSegments();
        if (r3 == null) goto L5;
        String r4 = (String) ZeusTransformUtils.preCheckCast(p.l(r3), String.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }
}
