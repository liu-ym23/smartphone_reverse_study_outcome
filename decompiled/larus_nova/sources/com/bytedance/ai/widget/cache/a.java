package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.g;
import com.lynx.tasm.TemplateBundle;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Widget> f37947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, TemplateBundle> f37948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f37949c;

    static {
        f37947a = new ConcurrentHashMap();
        f37948b = new ConcurrentHashMap();
    }

    public static void a() {
        g.f37637a.d("FixedWidgetCachePool", "clear: ");
        Iterator<T> r100 = f37947a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Widget) r100.next()).g();
        goto L4
    L6:
        f37947a.clear();
        f37948b.clear();
    }

    public static String b(String r100, String r110, String r111) {
        String[] r101 = new String[3];
        r101[0] = r100;
        r101[1] = r110;
        if (r111 != null) goto L5;
    L7:
        r111 = null;
    L8:
        r101[2] = r111;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r101), ":", null, null, 0, null, null, 62, null);
    L5:
        if ((true ^ StringsKt.isBlank(r111)) == false) goto L7;
        goto L7
    }
}
