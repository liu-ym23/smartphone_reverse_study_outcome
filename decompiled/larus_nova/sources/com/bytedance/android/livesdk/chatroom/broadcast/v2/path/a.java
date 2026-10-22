package com.bytedance.android.livesdk.chatroom.broadcast.v2.path;

import java.util.ArrayList;
import java.util.HashMap;
import s00.c;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(c r100, HashMap r101, c... r102) {
        ArrayList r103 = (ArrayList) r101.get(r100);
        if (r103 != null) goto L5;
        r103 = new ArrayList();
    L5:
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103.add(r102[r105].getName());
        r105 = r105 + 1;
        goto L6
    L8:
        r101.put(r100, r103);
    }
}
