package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ShowEquipTask extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c3 f125568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f125569f;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "ShowEquipTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        final g r100 = this.f125577c;
        if (r100 == null) goto L31;
        boolean r101 = c.h(r100);
        boolean r102 = c.i(r100);
        if (r101 == true) goto L10;
        if (r102 == true) goto L10;
        b("left gone, right gone");
        r100.d().setRoleInfo(this.f125568e);
        r100.e().setEquipState(this.f125569f);
        c(TaskState.END);
        return;
    L10:
        if (r101 == false) goto L14;
        if (r102 == true) goto L14;
        b("left visible, right gone");
        c.g(r100).setRoleInfo(this.f125568e);
        r100.e().setEquipState(this.f125569f);
        c(TaskState.END);
        return;
    L14:
        if (r101 == true) goto L18;
        if (r102 == false) goto L18;
        b("left visible, right gone");
        c(TaskState.END);
        return;
    L18:
        b("left visible, right visible");
        boolean r103 = true;
        boolean r104 = !Intrinsics.areEqual(c.g(r100).getRoleInfo(), this.f125568e);
        if (r100.e().getVisibility() != 0) goto L21;
        r100.e().setEquipState(this.f125569f);
        r103 = false;
    L21:
        b("left visible, needChangeLeft: " + r104 + ", right visible needChangeRight: " + r103);
        if (r104 == false) goto L25;
        if (r103 == false) goto L25;
        final HokGameRoleView r105 = c.g(r100);
        final HokGameRoleView r106 = c.f(r100);
        final com.bytedance.android.livesdk.gamesticker.hok.e r107 = n(r100);
        b("needChangeRight  rightVisibleView:" + r107);
        l(r106, r105, r100.e(), r107.getView(), new ShowEquipTask$start$$inlined$let$lambda$1(r106, r100, this), new ShowEquipTask$start$$inlined$let$lambda$2(r105, r107, this));
    L25:
        if (r104 == false) goto L27;
        final HokGameRoleView r108 = c.g(r100);
        final HokGameRoleView r109 = c.f(r100);
        m(r109, r108, new ShowEquipTask$start$$inlined$let$lambda$3(r109, this), new ShowEquipTask$start$$inlined$let$lambda$4(r108, this));
        goto L31
    L27:
        if (r103 == false) goto L29;
        final com.bytedance.android.livesdk.gamesticker.hok.e r110 = n(r100);
        b("needChangeRight  rightVisibleView:" + r110);
        m(r100.e(), r110.getView(), new ShowEquipTask$start$$inlined$let$lambda$5(r100, this), new ShowEquipTask$start$$inlined$let$lambda$6(r110, this));
        goto L31
    L29:
        c(TaskState.END);
    L31:
        if (this.f125577c != null) goto L34;
        c(TaskState.END);
        return;
    }

    public final com.bytedance.android.livesdk.gamesticker.hok.e n(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.b().getVisibility() != 0) goto L7;
        return r100.b();
    L7:
        if (r100.c().getVisibility() != 0) goto L11;
        return r100.c();
    L11:
        return r100.e();
    }

    public ShowEquipTask(c3 r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, "roleInfo");
        Intrinsics.checkNotNullParameter(r101, "equipState");
        this.f125568e = r100;
        this.f125569f = r101;
    }
}
