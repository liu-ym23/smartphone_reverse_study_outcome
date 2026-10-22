package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements t22.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinAnswerProcessor f138756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j42.b f138757b;

    @Override // t22.d
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        PinAnswerProcessor.u(this.f138756a, r100.toString(), this.f138757b, null);
    }

    public g(PinAnswerProcessor r100, j42.b r101) {
        this.f138756a = r100;
        this.f138757b = r101;
    }
}
