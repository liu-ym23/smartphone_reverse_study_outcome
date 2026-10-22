package com.bytedance.android.shopping.anchorv3.track;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f165293a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv3.track.a$a, reason: collision with other inner class name */
    public static final class C2514a {
    }

    static {
    }

    public a() {
        this.f165293a = new HashMap();
    }

    public final void a(com.bytedance.android.ec.core.event.a r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 == null) goto L13;
        HashMap r102 = new HashMap();
        Iterator<T> r103 = this.f165293a.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        if (r101.contains(r104) == true) goto L6;
        String r105 = this.f165293a.get(r104);
        if (r105 == null) goto L6;
        String r106 = (String) r102.put(r104, r105);
        goto L6
    L12:
        r100.appendExtraParams(r102);
        return;
    L13:
        r100.appendExtraParams(this.f165293a);
    }
}
