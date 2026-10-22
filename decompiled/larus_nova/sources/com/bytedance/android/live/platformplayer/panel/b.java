package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$AnimType;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements jg1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClearScreenConst$InteractType f85759a;

    @Override // jg1.a
    public final boolean a() {
        return false;
    }

    @Override // jg1.a
    public final boolean b() {
        return false;
    }

    @Override // jg1.a
    public final void c() {
    }

    @Override // jg1.a
    public final long d() {
        return 300;
    }

    @Override // jg1.a
    public final boolean e(jg1.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return true;
    }

    @Override // jg1.a
    public final void f() {
    }

    public b() {
        this.f85759a = ClearScreenConst$InteractType.GAME_PANEL_CLEAR;
    }

    @Override // jg1.a
    public final ClearScreenConst$AnimType g() {
        return ClearScreenConst$AnimType.TRANS;
    }

    @Override // jg1.a
    public final ClearScreenConst$InteractType getInteractType() {
        return this.f85759a;
    }
}
