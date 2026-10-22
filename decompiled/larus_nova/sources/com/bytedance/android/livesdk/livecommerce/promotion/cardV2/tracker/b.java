package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150745a = 0;

    public b() {
    }

    static {
    }

    public static final String a(List r100, String r101) {
        Iterator r102 = r100.iterator();
    L3:
        String r103 = null;
        if (r102.hasNext() == false) goto L21;
        Map<String, Object> r104 = ((LiveSingleAction) r102.next()).getInfo();
        if (r104 == null) goto L8;
        Object r105 = r104.get(r101);
    L10:
        if ((r105 instanceof String) == true) goto L12;
        r105 = null;
    L12:
        String r106 = (String) r105;
        if (r106 == null) goto L3;
        if (r106.length() <= 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
        r103 = r106;
    L20:
        if (r103 == null) goto L3;
    L17:
        r107 = false;
        goto L18
    L8:
        r105 = null;
    L21:
        return r103;
    }
}
