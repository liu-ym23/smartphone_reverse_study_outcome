package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ShowInfoTask extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t3 f125750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r3 f125751f;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "ShowInfoTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r100 = this.f125759c;
        if (r100 == null) goto L24;
        boolean r101 = d.g(new View[]{r100.d(), r100.a()});
        boolean r102 = d.g(new View[]{r100.c(), r100.b()});
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        b("left gone, right gone");
        r100.d().setRoleInfo(this.f125750e);
        r100.c().setLiveInfo(this.f125751f);
        c(TaskState.END);
    L8:
        if (r101 == false) goto L11;
        if (r102 == true) goto L11;
        b("left visible, right gone");
        l(r100).setRoleInfo(this.f125750e);
        r100.c().setLiveInfo(this.f125751f);
        c(TaskState.END);
    L11:
        if (r101 == true) goto L14;
        if (r102 == false) goto L14;
        b("left gone, right visible");
        c(TaskState.END);
    L14:
        b("left visible, right visible");
        boolean r103 = !Intrinsics.areEqual(l(r100).getRoleInfo(), this.f125750e);
        boolean r104 = !Intrinsics.areEqual(((T01GameLiveView) d.f(new T01GameLiveView[]{r100.c(), r100.b()}, r100.c(), 0)).getLiveInfo(), this.f125751f);
        final T01GameRoleView r105 = l(r100);
        final T01GameRoleView r106 = (T01GameRoleView) d.f(new T01GameRoleView[]{r100.d(), r100.a()}, r100.d(), 8);
        final T01GameLiveView r110 = (T01GameLiveView) d.f(new T01GameLiveView[]{r100.c(), r100.b()}, r100.c(), 0);
        final T01GameLiveView r107 = (T01GameLiveView) d.f(new T01GameLiveView[]{r100.c(), r100.b()}, r100.c(), 8);
        b("needChangeLeft: " + r103 + ", needChangeRight: " + r104);
        if (r103 == false) goto L18;
        if (r104 == false) goto L18;
        j(r106, r105, r107, r110, new ShowInfoTask$start$$inlined$let$lambda$1(r106, r107, this), new ShowInfoTask$start$$inlined$let$lambda$2(r105, r110, this));
    L18:
        if (r103 == false) goto L20;
        k(r106, r105, new ShowInfoTask$start$$inlined$let$lambda$3(r106, this), new ShowInfoTask$start$$inlined$let$lambda$4(r105, this));
        goto L24
    L20:
        if (r104 == false) goto L22;
        k(r107, r110, new ShowInfoTask$start$$inlined$let$lambda$5(r107, this), new ShowInfoTask$start$$inlined$let$lambda$6(r110, this));
        goto L24
    L22:
        c(TaskState.END);
    L24:
        if (this.f125759c != null) goto L27;
        c(TaskState.END);
        return;
    }

    public static T01GameRoleView l(i r100) {
        return (T01GameRoleView) d.f(new T01GameRoleView[]{r100.d(), r100.a()}, r100.d(), 0);
    }

    public ShowInfoTask(t3 r100, r3 r101) {
        Intrinsics.checkNotNullParameter(r100, "roleInfo");
        Intrinsics.checkNotNullParameter(r101, "liveInfo");
        this.f125750e = r100;
        this.f125751f = r101;
    }
}
