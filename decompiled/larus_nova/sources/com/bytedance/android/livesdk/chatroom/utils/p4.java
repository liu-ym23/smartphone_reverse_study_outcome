package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class p4 implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f114583a;

    public p4(boolean r100) {
        this.f114583a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        boolean r101 = r100.booleanValue();
        boolean r102 = this.f114583a;
        if (r101 == true) goto L5;
        o4.a("live_follow_desktop", "follow_leave_living_room", "", "normal", new q4(r102));
        return null;
    L5:
        o4.b(r102);
        return null;
    }
}
