package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x11.a f93596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ld.a f93597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f93598c;

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e a() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f93598c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Ig();
    }

    public final boolean b() {
        ld.a r100 = this.f93597b;
        if (r100 == null) goto L7;
        NextLiveData<Boolean> r101 = r100.Fc();
        if (r101 == null) goto L7;
        Boolean r102 = r101.getValue();
    L9:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L15;
        cy0.e.f465759a.getClass();
        cy0.j r103 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r104 = com.bytedance.android.scope.m.b(r103).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r104);
        String r105 = ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r104)).getCurrentUserId();
        Intrinsics.checkNotNullParameter(r105, "userId");
        qr2.a r106 = ((qr2.c) vh6.c.b(qr2.c.class)).s7(r105);
        if (r106 == null) goto L15;
        if (r106.f534545a != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean e() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f93598c;
        q11.b r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.utils.q r102 = r100.getPkUtils();
    L6:
        if (r102 == null) goto L8;
        q11.b r103 = r102.a();
    L10:
        if ((!Intrinsics.areEqual(r103, q11.b.a.f531272b)) == false) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r104 = this.f93598c;
        if (r104 == null) goto L14;
        com.bytedance.android.live.revlink.impl.pk.utils.q r105 = r104.getPkUtils();
    L15:
        if (r105 == null) goto L18;
        r101 = r105.a();
    L18:
        if ((!Intrinsics.areEqual(r101, q11.b.C7265b.f531273b)) == false) goto L20;
        return true;
    L14:
        r105 = null;
    L20:
        return false;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final boolean f() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f93598c;
        q11.b r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.utils.q r102 = r100.getPkUtils();
    L6:
        if (r102 == null) goto L9;
        r101 = r102.a();
    L9:
        return !Intrinsics.areEqual(r101, q11.b.a.f531272b);
    L5:
        r102 = null;
        goto L6
    }

    public final boolean g() {
        x11.a r100 = this.f93596a;
        if (r100 == null) goto L9;
        y11.b r101 = r100.mo11004do();
        if (r101 == null) goto L9;
        if (r101.e() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean c() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isBattleShow();
    }

    public final boolean d() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInBreakThrough() != true) goto L7;
        return true;
    }

    public final boolean h() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = a();
        if (r100 == null) goto L7;
        PkBaseStateMachine.c r101 = r100.getCurPKBaseState();
        if (r101 == null) goto L7;
        return r101 instanceof PkBaseStateMachine.c.C1444c;
    L7:
        return false;
    }

    public final boolean i() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInVote() != true) goto L7;
        return true;
    }

    public f(ld.a r100, LinkFakeGlobalService r101) {
        this.f93597b = r100;
        this.f93598c = r101;
    }
}
