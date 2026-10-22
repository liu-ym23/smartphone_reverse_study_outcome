package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f116235a;

    public e0(Function1 r100) {
        this.f116235a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f116235a.invoke(r100);
    }
}
