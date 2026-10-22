package com.bytedance.ai.applet.douyinAuth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f34619a = null;

    static {
        f34619a = CollectionsKt.listOf(new String[]{"user_info", "mobile", "flow_audio.luna.preference"});
    }

    public static String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<T> r101 = f34619a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add((String) r101.next());
        goto L4
    L6:
        List r111 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L8:
        if (r112.hasNext() == false) goto L10;
        r102.add(StringsKt.trim((String) r112.next()).toString());
        goto L8
    L10:
        ArrayList r113 = new ArrayList();
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        if (((String) r104).length() <= 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L12;
        r113.add(r104);
        goto L12
    L16:
        r105 = false;
        goto L17
    L19:
        Iterator r114 = r113.iterator();
    L21:
        if (r114.hasNext() == false) goto L24;
        r100.add((String) r114.next());
        goto L21
    L24:
        return CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
    }
}
