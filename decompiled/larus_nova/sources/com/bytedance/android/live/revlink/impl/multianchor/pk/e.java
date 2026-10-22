package com.bytedance.android.live.revlink.impl.multianchor.pk;

import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.android.livesdk.link.model.k0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f94507a = null;

    public e() {
    }

    static {
        f94507a = new e();
    }

    public static Map a(Map r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator r102 = r100.values().iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        IBattleUserInfo r103 = (IBattleUserInfo) r102.next();
        if (r103.getMultiPkTeamId() == 0) goto L7;
        k0 r104 = r103.getUserInfo();
        if (r104 == null) goto L7;
        String r105 = r104.getUserId();
        if (r105 == null) goto L7;
        r101.put(r105, Long.valueOf(r103.getMultiPkTeamId()));
        goto L7
    L16:
        return r101;
    }

    public static Map b(Map r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        Map.Entry r103 = (Map.Entry) r102.next();
        long r104 = ((Number) r103.getKey()).longValue();
        List<String> r105 = ((g7) r103.getValue()).getAnchorUidList();
        if (r105 == null) goto L7;
        Iterator r106 = CollectionsKt.toList(r105).iterator();
    L13:
        if (r106.hasNext() == false) goto L7;
        r101.put((String) r106.next(), Long.valueOf(r104));
        goto L13
    L15:
        return r101;
    }
}
