package com.bytedance.android.livesdk.vs;

import android.net.Uri;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class d {
    public static Uri a(Uri r100, DataCenter r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        Uri.Builder r102 = r100.buildUpon();
        HashMap r103 = new HashMap();
        f r104 = f.a(r101);
        o r105 = r104.b(ju2.b.class);
        if (r105 == null) goto L7;
        r105.a(r103);
    L7:
        o r106 = r104.b(ju2.f.class);
        if (r106 == null) goto L10;
        r106.a(r103);
    L10:
        Iterator r107 = r103.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (UriProtector.getQueryParameter(r100, (String) r108.getKey()) != null) goto L12;
        r102.appendQueryParameter((String) r108.getKey(), (String) r108.getValue());
        goto L12
    L17:
        if (UriProtector.getQueryParameter(r100, "is_vs") != null) goto L20;
        r102.appendQueryParameter("is_vs", "1");
    L20:
        if (UriProtector.getQueryParameter(r100, "vs_screen_type") != null) goto L26;
        if (((Boolean) r101.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L24;
        r102.appendQueryParameter("vs_screen_type", "portrait");
        r102.appendQueryParameter("is_hor", "0");
        goto L26
    L24:
        r102.appendQueryParameter("vs_screen_type", "landscape");
        r102.appendQueryParameter("is_hor", "1");
    L26:
        return r102.build();
    }
}
