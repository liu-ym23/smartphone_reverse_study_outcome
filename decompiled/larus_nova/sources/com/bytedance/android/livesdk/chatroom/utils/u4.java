package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u4 implements dq1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f114641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f114642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f114643c;

    @Override // dq1.d
    public final boolean g1() {
        com.bytedance.android.live.room.h r100 = (com.bytedance.android.live.room.h) this.f114641a.invoke();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.g1();
    }

    @Override // dq1.d
    public final void y6() {
        this.f114643c.invoke();
    }

    @Override // dq1.d
    public final void x6(VSCameraInfo r100, boolean r101) {
        gs0.c r102 = (gs0.c) this.f114642b.invoke();
        if (r102 == null) goto L6;
        r102.x6(r100, r101);
        return;
    }

    public u4(fk1.r r100, fk1.s r101, fk1.c r102) {
        this.f114641a = r100;
        this.f114642b = r101;
        this.f114643c = r102;
    }

    @Override // dq1.d
    public final void Ma(boolean r100, boolean r101, IMultiCameraView.Source r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Object r103 = this.f114641a.invoke();
        if ((r103 instanceof IMultiCameraView) == true) goto L5;
        r103 = null;
    L5:
        IMultiCameraView r104 = (IMultiCameraView) r103;
        if (r104 == null) goto L9;
        r104.Ma(r100, r101, r102);
        return;
    }

    @Override // dq1.d
    public final void X5(boolean r100, boolean r101, IMultiCameraView.Source r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Object r103 = this.f114641a.invoke();
        if ((r103 instanceof IMultiCameraView) == true) goto L5;
        r103 = null;
    L5:
        IMultiCameraView r104 = (IMultiCameraView) r103;
        if (r104 == null) goto L9;
        r104.X5(r100, r101, r102);
        return;
    }

    @Override // dq1.d
    public final void a4(VSCameraInfo r100, boolean r101, boolean r102, boolean r103) {
        gs0.c r104 = (gs0.c) this.f114642b.invoke();
        if (r104 == null) goto L6;
        r104.a4(r100, r101, r102, r103);
        return;
    }
}
