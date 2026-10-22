package com.bytedance.android.livesdk.utils;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a7 extends com.bytedance.android.livesdk.chatroom.ui.u5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f158827d;

    public a7(Function1 r100) {
        this.f158827d = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.u5
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f158827d.invoke(r100);
    }
}
