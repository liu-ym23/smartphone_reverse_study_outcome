package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements VSInputPanelSectionContainer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.b f137320a;

    public o(j.b r100) {
        this.f137320a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer.b
    public final void a(VSInputSectionType r100, VSInputSectionType r101) {
        Intrinsics.checkNotNullParameter(r100, "previousType");
        Intrinsics.checkNotNullParameter(r101, "currentSectionType");
        this.f137320a.c(r101);
    }
}
