package com.bytedance.android.livesdk.livecommerce.room;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k {
    public static final <R> R a(j r100, Class<R> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getReceiver");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (Intrinsics.areEqual(r101, lj2.a.class) == false) goto L8;
        R r103 = (R) r100.o(r102);
        if ((r103 instanceof Object) == true) goto L51;
    L49:
        return null;
    L51:
        return r103;
    L8:
        if (Intrinsics.areEqual(r101, oj2.a.class) == false) goto L13;
        R r104 = (R) r100.m(r102);
        if ((r104 instanceof Object) == false) goto L49;
        return r104;
    L13:
        if (Intrinsics.areEqual(r101, fh2.a.class) == false) goto L18;
        R r105 = (R) r100.p(r102);
        if ((r105 instanceof Object) == false) goto L49;
        return r105;
    L18:
        if (Intrinsics.areEqual(r101, o.class) == false) goto L23;
        R r106 = (R) r100.n(r102);
        if ((r106 instanceof Object) == false) goto L49;
        return r106;
    L23:
        if (Intrinsics.areEqual(r101, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c.class) == false) goto L28;
        R r107 = (R) r100.i(r102);
        if ((r107 instanceof Object) == false) goto L49;
        return r107;
    L28:
        if (Intrinsics.areEqual(r101, jk2.a.class) == false) goto L31;
        r100.j(r102);
        goto L49
    L31:
        if (Intrinsics.areEqual(r101, com.bytedance.android.livesdk.livecommerce.intro.message.a.class) == false) goto L36;
        R r108 = (R) r100.q(r102);
        if ((r108 instanceof Object) == false) goto L49;
        return r108;
    L36:
        if (Intrinsics.areEqual(r101, com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j.class) == false) goto L41;
        R r109 = (R) r100.d();
        if ((r109 instanceof Object) == false) goto L49;
        return r109;
    L41:
        if (Intrinsics.areEqual(r101, com.bytedance.android.livesdk.livecommerce.room.api.c.class) == false) goto L46;
        R r110 = (R) r100.k();
        if ((r110 instanceof Object) == false) goto L49;
        return r110;
    L46:
        if (Intrinsics.areEqual(r101, RoomContextController.class) == false) goto L49;
        R r111 = (R) r100.b();
        if ((r111 instanceof Object) == false) goto L49;
        return r111;
    }
}
