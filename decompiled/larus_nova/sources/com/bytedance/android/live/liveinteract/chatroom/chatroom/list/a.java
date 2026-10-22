package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a extends ge0.a<BaseTalkApplyListContract$View> {
    public abstract void d(long r100);

    public abstract void e(boolean r100, String r101, long r102, String r103, int r104, boolean r105);

    public abstract Pair<Integer, Integer> g();

    public abstract void h();

    public a(BaseTalkApplyListContract$View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public static /* synthetic */ void f(a r100, boolean r101, String r110, long r111, String r112, int r113) {
        r100.e(r101, r110, r111, r112, r113, false);
    }
}
