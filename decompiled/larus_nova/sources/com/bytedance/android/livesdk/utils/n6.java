package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class n6 {
    static {
    }

    @JvmStatic
    public static final boolean a(Text r100) {
        if (r100 == null) goto L4;
        List<com.bytedance.android.live.base.model.message.c5> r101 = r100.getPieces();
    L5:
        List<com.bytedance.android.live.base.model.message.c5> r102 = r101;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return false;
    L14:
        if (r100 == null) goto L24;
        List<com.bytedance.android.live.base.model.message.c5> r104 = r100.getPieces();
        if (r104 == null) goto L24;
        Iterator<com.bytedance.android.live.base.model.message.c5> r105 = r104.iterator();
    L20:
        if (r105.hasNext() == false) goto L24;
        if (r105.next().getType() != PieceType.IMAGE.getPieceType()) goto L20;
        return true;
    L24:
        return false;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    L4:
        r101 = null;
        goto L5
    }
}
