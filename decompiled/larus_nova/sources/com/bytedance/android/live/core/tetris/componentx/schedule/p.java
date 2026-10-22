package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements ComponentSchedulingManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentSchedulingManager f65629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentSchedulingManager.b f65630b;

    public p(ComponentSchedulingManager r100, com.bytedance.android.live.core.tetris.componentx.c r101) {
        this.f65629a = r100;
        this.f65630b = r101;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager.a
    public final void a(f70.b r100, int r101, m r102) {
        ComponentSchedulingManager r103 = this.f65629a;
        ComponentSchedulingManager.b r104 = this.f65630b;
        r103.getClass();
        if (r102 == null) goto L5;
        LayerDescriptorList r105 = r102.f65623b;
    L6:
        if (r105 == null) goto L12;
        if (r104 == null) goto L11;
        r104.a(r101, r102, r103.f65566j);
        return;
    L11:
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
