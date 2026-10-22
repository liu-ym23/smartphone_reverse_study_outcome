package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class l1 {
    public static boolean b(char r100) {
        if (r100 != 0) goto L4;
    L22:
        return false;
    L4:
        if (r100 == '\t') goto L22;
        if (r100 == '\n') goto L22;
        if (r100 == '\r') goto L22;
        if (r100 < ' ') goto L14;
        if (r100 <= 55295) goto L22;
    L14:
        if (r100 < 57344) goto L18;
        if (r100 <= 65533) goto L22;
    L18:
        if (r100 >= 0) goto L20;
    L21:
        return true;
    L20:
        if (r100 <= 65535) goto L22;
        goto L21
    }

    public static boolean a(String r100) {
        IMiddleWareHostEmoji r101 = (IMiddleWareHostEmoji) jc1.k.f(IMiddleWareHostEmoji.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator<BaseEmoji> r102 = r101.loadAllBaseEmoji().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (r100.contains(r102.next().getDescription()) == false) goto L7;
        return true;
    L12:
        return false;
    }
}
