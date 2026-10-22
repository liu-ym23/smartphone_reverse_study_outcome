package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class q4 implements Function2<Boolean, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f114607a;

    public q4(boolean r100) {
        this.f114607a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Boolean r100, String r101) {
        Boolean r102 = r100;
        o4.f114576f = r102.booleanValue();
        if (r102.booleanValue() == true) goto L7;
        o4.b(this.f114607a);
        return null;
    L7:
        return null;
    }
}
