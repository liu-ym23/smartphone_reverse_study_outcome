package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.NinePatchDrawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s2 implements com.bytedance.android.livesdk.chatroom.utils.a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f116708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f116709b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
        this.f116709b.invoke();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f116708a.invoke(r100, Boolean.FALSE);
    }

    public s2(Function2 r100, Function0 r101) {
        this.f116708a = r100;
        this.f116709b = r101;
    }
}
