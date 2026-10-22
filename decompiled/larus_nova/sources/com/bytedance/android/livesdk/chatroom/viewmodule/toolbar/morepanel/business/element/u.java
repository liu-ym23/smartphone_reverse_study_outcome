package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements kp1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair<ElementType, kp1.c> f116582a = null;

    public u() {
    }

    static {
        u r100 = new u();
        f116582a = TuplesKt.to(ElementType.SimpleDivider, r100);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return new o(r100.f505491b);
    }
}
