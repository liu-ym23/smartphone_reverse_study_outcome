package com.bytedance.android.livesdk.gift.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final a a(c r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L22;
        Iterator<T> r103 = r100.getEffectMixImageInfoList().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        s r104 = (s) r103.next();
        r101.add(new q2(r104.getImageKey(), r104.getMixImage()));
        goto L6
    L8:
        List<t> r105 = r100.getEffectMixTextInfoList();
        if (r105 == null) goto L22;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L22;
        t r107 = (t) r106.next();
        String r108 = r107.getPlaceholderKey();
        String r109 = "";
        if (r108 != null) goto L16;
        r108 = "";
    L16:
        String r110 = r107.getContent();
        if (r110 == null) goto L20;
        r109 = r110;
    L20:
        r102.add(new r3(r108, r109, r107.getFontSize(), r107.getFontColor()));
    L22:
        return new a(r101, r102, null, null);
    }
}
