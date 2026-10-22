package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BubbleEnv f115779a;

    public final void a() {
        y3.m(this.f115779a.f115777c).b(ToolbarButton.MORE, new l(T8()));
    }

    public a(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f115779a = r100;
    }
}
