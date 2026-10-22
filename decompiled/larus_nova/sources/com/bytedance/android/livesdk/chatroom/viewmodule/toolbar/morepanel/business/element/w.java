package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements kp1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair<ElementType, kp1.c> f116584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f116585b = null;

    public w() {
    }

    static {
        w r100 = new w();
        f116585b = r100;
        f116584a = TuplesKt.to(ElementType.Unknown, r100);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L7;
        return new x(r100.f505491b);
    L7:
        throw new IllegalStateException("AudienceElementFactory：未匹配的element类型");
    }
}
