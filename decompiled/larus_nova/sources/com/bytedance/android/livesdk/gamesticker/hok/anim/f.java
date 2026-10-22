package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f125585d;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "UpdateBattleTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        g r100 = this.f125577c;
        if (r100 == null) goto L52;
        o r101 = this.f125585d;
        k2 r102 = null;
        if (r101 != null) goto L7;
    L16:
        j0 r103 = null;
    L17:
        if (r103 != null) goto L19;
    L21:
        o r104 = this.f125585d;
        if (r104 != null) goto L24;
    L48:
        if (r102 == null) goto L52;
        if (r100.b().getVisibility() != 0) goto L52;
        b("UpdateBattleTask update moneyView");
        r100.b().setMoneyCount(r102);
        goto L52
    L24:
        if (r104.b() == null) goto L48;
        k2 r105 = r104.b();
        if (r105 == null) goto L29;
        String r106 = r105.b();
    L30:
        boolean r107 = true;
        if (r106 != null) goto L33;
    L36:
        boolean r108 = true;
    L37:
        if (r108 == true) goto L48;
        if (r105 == null) goto L40;
        String r109 = r105.a();
    L41:
        if (r109 != null) goto L43;
    L46:
        if (r107 == true) goto L48;
        r102 = r105;
        goto L48
    L43:
        if (r109.length() == 0) goto L46;
        r107 = false;
        goto L46
    L40:
        r109 = null;
        goto L41
    L33:
        if (r106.length() == 0) goto L36;
        r108 = false;
        goto L37
    L29:
        r106 = null;
        goto L30
    L19:
        if (r100.e().getVisibility() != 0) goto L21;
        b("UpdateBattleTask update equipView");
        r100.e().setEquipState(r103);
        goto L21
    L7:
        if (r101.a() == null) goto L16;
        j0 r110 = r101.a();
        if (r110 == null) goto L12;
        long r111 = r110.a();
    L14:
        if (r111 <= 0) goto L16;
        r103 = r101.a();
        goto L17
    L12:
        r111 = 0;
    L52:
        c(TaskState.END);
    }

    public f(o r100) {
        Intrinsics.checkNotNullParameter(r100, "battleInfo");
        this.f125585d = r100;
    }
}
