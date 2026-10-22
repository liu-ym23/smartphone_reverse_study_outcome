package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.net.Uri;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class w {
    public static Uri a(Uri r100, DataCenter r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        Uri.Builder r102 = r100.buildUpon();
        Episode r103 = (Episode) r101.get("data_vs_episode_data", null);
        if (r103 == null) goto L20;
        if (r103.isReplay() == false) goto L20;
        HashMap r104 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r105 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r101).c(am2.a0.class);
        com.bytedance.android.livesdk.log.filter.o r106 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r101).c(am2.b0.class);
        if (r105 == null) goto L11;
        r105.a(r104);
    L11:
        if (r106 == null) goto L13;
        r106.a(r104);
    L13:
        Iterator r107 = r104.entrySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L20;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (UriProtector.getQueryParameter(r100, (String) r108.getKey()) != null) goto L15;
        r102.appendQueryParameter((String) r108.getKey(), (String) r108.getValue());
    L20:
        if (UriProtector.getQueryParameter(r100, "is_vs") != null) goto L23;
        r102.appendQueryParameter("is_vs", "1");
    L23:
        if (UriProtector.getQueryParameter(r100, "vs_screen_type") != null) goto L29;
        if (((Boolean) r101.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L27;
        r102.appendQueryParameter("vs_screen_type", "portrait");
        r102.appendQueryParameter("is_hor", "0");
        goto L29
    L27:
        r102.appendQueryParameter("vs_screen_type", "landscape");
        r102.appendQueryParameter("is_hor", "1");
    L29:
        return r102.build();
    }
}
