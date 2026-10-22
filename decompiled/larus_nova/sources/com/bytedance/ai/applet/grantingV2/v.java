package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v {
    public static final boolean b(String r100, u2.f r101) {
        if (g.b(r101, r100) == false) goto L5;
        return true;
    L5:
        String r102 = r101.c();
        if (r102 != null) goto L8;
    L32:
        com.bytedance.ai.utils.g.f37637a.w("McpGrantingManagerV2", "Unknown permission status: " + r101.c() + ", treating as needs processing");
        return true;
    L8:
        switch(r102.hashCode()) {
            case -682587753: goto L31;
            case 280295099: goto L28;
            case 664583344: goto L25;
            case 854280074: goto L21;
            case 1085547216: goto L17;
            case 1100137118: goto L14;
            case 2084348283: goto L11;
            default: goto L32;
        };
    L11:
        if (r102.equals("refused_by_history") == false) goto L32;
        return true;
    L14:
        if (r102.equals("revoked") == false) goto L32;
        return true;
    L17:
        if (r102.equals("refused") == false) goto L32;
        return r101.f();
    L21:
        if (r102.equals("granted_without_system") == false) goto L32;
        return r101.f();
    L25:
        if (r102.equals("granted_by_history") == false) goto L32;
        return true;
    L28:
        if (r102.equals("granted") == false) goto L32;
        return false;
    L31:
        if (r102.equals(AiBotPollingAuthResult.STATUS_PENDING) == false) goto L32;
        return true;
    }

    public static final u2.e c(u2.e r100, u2.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        List<u2.f> r102 = r100.h();
        if (r102 != null) goto L5;
        return r100;
    L5:
        Iterator<u2.f> r103 = r102.iterator();
        int r104 = 0;
    L7:
        if (r103.hasNext() == false) goto L17;
        u2.f r105 = r103.next();
        if (r105.d() == r101.d()) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L18;
        r104 = r104 + 1;
    L18:
        if (r104 == (-1)) goto L23;
        List r107 = CollectionsKt.toMutableList(r102);
        ListProtector.set(r107, r104, r101);
        return u2.e.a(r100, null, CollectionsKt.toList(r107), 127);
    L23:
        return r100;
    L11:
        if (Intrinsics.areEqual(r105.b(), r101.b()) == false) goto L13;
        r106 = true;
        goto L14
    L17:
        r104 = -1;
        goto L18
    }

    public static final u2.f a(List<u2.f> r100, Integer r101, String r102) {
        Object r103 = null;
        if (r101 != null) goto L11;
        Iterator<T> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L32;
        Object r105 = r104.next();
        if (b(r102, (u2.f) r105) == false) goto L6;
        r103 = r105;
    L32:
        return (u2.f) r103;
    L11:
        Iterator<T> r106 = r100.iterator();
    L13:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        u2.f r108 = (u2.f) r107;
        if (r108.d() > r101.intValue()) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L13;
        r103 = r107;
        goto L23
    L17:
        if (b(r102, r108) == false) goto L19;
        r109 = true;
    L23:
        return (u2.f) r103;
    }
}
