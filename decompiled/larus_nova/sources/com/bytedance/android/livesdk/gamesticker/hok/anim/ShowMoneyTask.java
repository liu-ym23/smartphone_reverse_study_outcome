package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ShowMoneyTask extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c3 f125570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k2 f125571f;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "ShowMoneyTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        final g r100 = this.f125577c;
        if (r100 == null) goto L32;
        boolean r101 = c.h(r100);
        boolean r102 = c.i(r100);
        if (r101 == true) goto L11;
        if (c.i(r100) == true) goto L11;
        b("left gone, right gone");
        r100.d().setRoleInfo(this.f125570e);
        r100.b().setMoneyCount(this.f125571f);
        c(TaskState.END);
        return;
    L11:
        if (r101 == false) goto L15;
        if (r102 == true) goto L15;
        b("left visible, right gone");
        c.g(r100).setRoleInfo(this.f125570e);
        r100.b().setMoneyCount(this.f125571f);
        c(TaskState.END);
        return;
    L15:
        if (r101 == true) goto L19;
        if (r102 == false) goto L19;
        b("left visible, right gone");
        c(TaskState.END);
        return;
    L19:
        b("left visible, right visible");
        boolean r103 = true;
        boolean r104 = !Intrinsics.areEqual(c.g(r100).getRoleInfo(), this.f125570e);
        if (r100.b().getVisibility() != 0) goto L22;
        r100.b().setMoneyCount(this.f125571f);
        r103 = false;
    L22:
        b("left visible, needChangeLeft: " + r104 + ", right visible needChangeRight: " + r103);
        if (r104 == false) goto L26;
        if (r103 == false) goto L26;
        final HokGameRoleView r105 = c.g(r100);
        final HokGameRoleView r106 = c.f(r100);
        final com.bytedance.android.livesdk.gamesticker.hok.e r107 = n(r100);
        b("needChangeRight  rightVisibleView:" + r107);
        l(r106, r105, r100.b(), r107.getView(), new ShowMoneyTask$start$$inlined$let$lambda$1(r106, r100, this), new ShowMoneyTask$start$$inlined$let$lambda$2(r105, r107, this));
    L26:
        if (r104 == false) goto L28;
        final HokGameRoleView r108 = c.g(r100);
        final HokGameRoleView r109 = c.f(r100);
        m(r109, r108, new ShowMoneyTask$start$$inlined$let$lambda$3(r109, this), new ShowMoneyTask$start$$inlined$let$lambda$4(r108, this));
        goto L32
    L28:
        if (r103 == false) goto L30;
        final com.bytedance.android.livesdk.gamesticker.hok.e r110 = n(r100);
        b("needChangeRight  rightVisibleView:" + r110);
        m(r100.b(), r110.getView(), new ShowMoneyTask$start$$inlined$let$lambda$5(r100, this), new ShowMoneyTask$start$$inlined$let$lambda$6(r110, this));
        goto L32
    L30:
        c(TaskState.END);
    L32:
        if (this.f125577c != null) goto L35;
        c(TaskState.END);
        return;
    }

    public final com.bytedance.android.livesdk.gamesticker.hok.e n(g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGetter");
        if (r100.e().getVisibility() != 0) goto L7;
        return r100.e();
    L7:
        if (r100.c().getVisibility() != 0) goto L11;
        return r100.c();
    L11:
        return r100.b();
    }

    public ShowMoneyTask(c3 r100, k2 r101) {
        Intrinsics.checkNotNullParameter(r100, "roleInfo");
        Intrinsics.checkNotNullParameter(r101, "moneyCount");
        this.f125570e = r100;
        this.f125571f = r101;
    }
}
