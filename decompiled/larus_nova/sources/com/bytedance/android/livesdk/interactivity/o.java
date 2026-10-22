package com.bytedance.android.livesdk.interactivity;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f138615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f138616b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
        this.f138616b.invoke();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f138615a.invoke(r100, Boolean.FALSE);
    }

    public o(Function2 r100, Function0 r101) {
        this.f138615a = r100;
        this.f138616b = r101;
    }
}
