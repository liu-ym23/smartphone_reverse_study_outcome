package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i9;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f93590a = 0;

    static {
    }

    public static void a(h9 r100, Map r101) {
        if (r100 == null) goto L20;
        List<Long> r102 = r100.getGiftIds();
        Map<Long, i9> r103 = null;
        if ((!r102.isEmpty()) == true) goto L7;
        r102 = null;
    L7:
        if (r102 == null) goto L11;
        Long r104 = (Long) ListProtector.get(r102, 0);
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        r101.put("focus_gift_id", String.valueOf(r105));
        Map<Long, i9> r106 = r100.getGiftMap();
        if ((!r106.isEmpty()) == false) goto L15;
        r103 = r106;
    L15:
        if (r103 == null) goto L21;
        i9 r107 = r103.get(Long.valueOf(r105));
        if (r107 == null) goto L22;
        r101.put("focus_gift_name", r107.getGiftName());
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r105 = 0;
        goto L12
    }
}
