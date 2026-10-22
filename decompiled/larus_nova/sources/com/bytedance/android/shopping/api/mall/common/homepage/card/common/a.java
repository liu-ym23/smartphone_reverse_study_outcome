package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170305a = 0;

    static {
    }

    public static String a(String r110) {
        List r111 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        ArrayList r100 = new ArrayList();
        Iterator r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L8;
        Object r101 = r112.next();
        if ((!Intrinsics.areEqual("1031", (String) r101)) == false) goto L4;
        r100.add(r101);
        goto L4
    L8:
        List r113 = CollectionsKt.toMutableList(r100);
        ArrayList r102 = new ArrayList();
        r102.addAll(r113);
        r102.add("1031");
        return CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null);
    }
}
