package com.bytedance.android.live.revlink.impl.multianchor.pk;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f94500a = 0;

    static {
    }

    public static Pair a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "userIdToTeamId");
        HashMap r102 = new HashMap();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        long r106 = ((Number) r104.getValue()).longValue();
        if (r106 == 0) goto L4;
        List r107 = (List) r102.get(Long.valueOf(r106));
        if (r107 != null) goto L10;
        r107 = new ArrayList();
        r102.put(Long.valueOf(r106), r107);
    L10:
        r107.add(r105);
        goto L4
    L12:
        if (r102.entrySet().size() != 1) goto L16;
        return TuplesKt.to(ListProtector.get(CollectionsKt.toList(r102.values()), 0), CollectionsKt.emptyList());
    L16:
        if (r102.entrySet().size() != 2) goto L24;
        List r108 = (List) ListProtector.get(CollectionsKt.toList(r102.values()), 0);
        List r109 = (List) ListProtector.get(CollectionsKt.toList(r102.values()), 1);
        if (CollectionsKt.contains(r109, r100) == false) goto L22;
        return TuplesKt.to(r109, r108);
    L22:
        return TuplesKt.to(r108, r109);
    L24:
        return TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
