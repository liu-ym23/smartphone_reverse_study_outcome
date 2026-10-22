package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsOpenDialogMethodIDL.b> f191415a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        f3.h<AbsOpenDialogMethodIDL.b> r100 = this.f191415a;
        Intrinsics.checkNotNullParameter(AbsOpenDialogMethodIDL.b.class, "<this>");
        BaseModel r101 = k3.c.a(AbsOpenDialogMethodIDL.b.class);
        ((AbsOpenDialogMethodIDL.b) r101).setConfirm(false);
        f3.h.a.b(r100, (ResultModel) r101);
    }

    public q(f3.h<AbsOpenDialogMethodIDL.b> r100) {
        this.f191415a = r100;
    }
}
