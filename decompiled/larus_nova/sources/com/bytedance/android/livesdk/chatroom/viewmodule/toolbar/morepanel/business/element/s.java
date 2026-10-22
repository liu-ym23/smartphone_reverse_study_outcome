package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements kp1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair<ElementType, kp1.c> f116580a = null;

    public s() {
    }

    static {
        s r100 = new s();
        f116580a = TuplesKt.to(ElementType.Extend, r100);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return new c(r100.f505491b);
    }
}
