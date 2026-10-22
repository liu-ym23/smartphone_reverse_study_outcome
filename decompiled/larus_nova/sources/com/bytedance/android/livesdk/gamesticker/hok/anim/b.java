package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c3 f125578d;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "OnlyShowRoleTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        g r100 = this.f125577c;
        if (r100 == null) goto L5;
        r100.d().setRoleInfo(this.f125578d);
        r100.a().setRoleInfo(null);
        r100.c().setLiveInfo(null);
        r100.b().setMoneyCount(null);
        r100.e().setEquipState(null);
    L5:
        c(TaskState.END);
    }

    public b(c3 r100) {
        Intrinsics.checkNotNullParameter(r100, "roleInfo");
        this.f125578d = r100;
    }
}
