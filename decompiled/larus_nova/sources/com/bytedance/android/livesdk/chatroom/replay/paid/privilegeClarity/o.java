package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import com.bytedance.android.livesdk.chatroom.vs_base.base.paid.PrivilegeClarityEventHub;
import com.bytedance.android.livesdk.chatroom.vs_base.element.AbsReplayPlayerWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayPrivilegeClarityManager f109455a;

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b
    public final void a() {
        this.f109455a.j("auto change to paid res failed");
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity.b
    public final void b() {
        this.f109455a.getClass();
        p.a("auto change to paid res success");
        final ReplayPrivilegeClarityManager r100 = this.f109455a;
        h80.d<AbsReplayPlayerWidget> r101 = r100.f109412u;
        if (r101 == null) goto L7;
        AbsReplayPlayerWidget r102 = r101.get();
        if (r102 == null) goto L7;
        r102.ri();
    L7:
        r100.f109402k = true;
        r100.f109409r.f117901b.setValue(r100.f109408q.d() + "试看中");
        r100.f109409r.f117902c.setValue("去购买");
        r100.f109409r.f117900a.setValue(PrivilegeClarityEventHub.State.CLARITY_TEMP_WATCH);
        r100.f109406o = "clarity_try_toast";
        r100.k();
        a r103 = r100.f109407p;
        n r104 = r100.f109399h;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f109415a.observeForever(r104);
        a r105 = r100.f109407p;
        Integer r106 = r100.f().getTrialTime();
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
    L11:
        r105.c(r107, r100.f109410s, new ReplayPrivilegeClarityManager$onPaidResChangeSuccess$1(r100));
        return;
    L10:
        r107 = 15;
        goto L11
    }

    public o(ReplayPrivilegeClarityManager r100) {
        this.f109455a = r100;
    }
}
