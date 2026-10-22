package com.bytedance.android.live.broadcastgame.opengame.cloud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59830a = 0;

    static {
    }

    public static boolean a(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$containsKey");
        Intrinsics.checkNotNullParameter(r101, "key");
        Set r102 = r100.keySet();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        String r105 = (String) r104.next();
        if (r105 == null) goto L9;
        r103.add(r105.toLowerCase());
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        return r103.contains(r101.toLowerCase());
    }

    public static Object b(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$remove");
        Intrinsics.checkNotNullParameter(r101, "key");
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        if (StringsKt.equals(r103, r101, true) == false) goto L4;
        return r100.remove(r103);
    L9:
        return null;
    }
}
