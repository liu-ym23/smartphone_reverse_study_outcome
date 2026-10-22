package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameRoleView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t3 f125769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<r3> f125770e;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "UpdateInfoTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r100 = this.f125759c;
        if (r100 == null) goto L12;
        ((T01GameRoleView) f(new T01GameRoleView[]{r100.d(), r100.a()}, r100.d())).setRoleInfo(this.f125769d);
        T01GameLiveView r101 = (T01GameLiveView) f(new T01GameLiveView[]{r100.c(), r100.b()}, r100.c());
        Iterator<r3> r102 = this.f125770e.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        r3 r103 = r102.next();
        r3 r104 = r101.getLiveInfo();
        if (r104 == null) goto L6;
        if (r104.a() != r103.a()) goto L6;
        b("updateLiveInfoView index " + r103.a());
        r101.setLiveInfo(r103);
    L12:
        c(TaskState.END);
    }

    public h(t3 r100, List<r3> r101) {
        Intrinsics.checkNotNullParameter(r100, "roleInfo");
        Intrinsics.checkNotNullParameter(r101, "liveInfos");
        this.f125769d = r100;
        this.f125770e = r101;
    }

    public static Object f(Object[] r100, Object r101) {
        int r102 = 0;
        if (r100.length != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return r101;
    L8:
        int r104 = r100.length;
    L9:
        if (r102 >= r104) goto L16;
        Object r105 = r100[r102];
        if ((r105 instanceof View) == false) goto L15;
        if (((View) r105).getVisibility() != 0) goto L15;
        return r105;
    L15:
        r102 = r102 + 1;
        goto L9
    L16:
        return r101;
    L5:
        r103 = false;
        goto L6
    }
}
