package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common_ui.dialog.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsOpenDialogMethodIDL.b> f191416a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        f3.h<AbsOpenDialogMethodIDL.b> r100 = this.f191416a;
        Intrinsics.checkNotNullParameter(AbsOpenDialogMethodIDL.b.class, "<this>");
        BaseModel r101 = k3.c.a(AbsOpenDialogMethodIDL.b.class);
        ((AbsOpenDialogMethodIDL.b) r101).setConfirm(true);
        f3.h.a.b(r100, (ResultModel) r101);
    }

    public r(f3.h<AbsOpenDialogMethodIDL.b> r100) {
        this.f191416a = r100;
    }
}
