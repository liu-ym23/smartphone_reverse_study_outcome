package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayerDescriptorList f162382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayerDescriptorList f162383b;

    public final int a() {
        LayerDescriptorList r100 = this.f162382a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L6:
        LayerDescriptorList r103 = this.f162383b;
        if (r103 == null) goto L10;
        r101 = r103.size();
    L10:
        return r102 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public a(LayerDescriptorList r100, LayerDescriptorList r101) {
        this.f162382a = r100;
        this.f162383b = r101;
    }

    public final void b(boolean r100, j70.h<h70.b> r101) {
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        if (r100 == false) goto L7;
        LayerDescriptorList r102 = this.f162382a;
        if (r102 == null) goto L11;
        r102.add(r101);
        return;
    L11:
        return;
    L7:
        LayerDescriptorList r103 = this.f162383b;
        if (r103 == null) goto L13;
        r103.add(r101);
        return;
    }
}
