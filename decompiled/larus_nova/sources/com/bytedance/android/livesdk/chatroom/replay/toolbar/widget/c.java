package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x3 f110225a;

    public c(g3 r100) {
        this.f110225a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        c0.d r101 = (c0.d) r100;
        Intrinsics.checkNotNullParameter(r101, "event");
        Map<ExtendedToolbarButton, View> r102 = this.f110225a.f116829c;
        HashMap r103 = (HashMap) r102;
        View r104 = (View) r103.get(r101.f115860a);
        if (r104 != null) goto L5;
        return;
    L5:
        if (r101.f115861b == false) goto L7;
        r104.setAlpha(0.64f);
        return;
    L7:
        r104.setAlpha(1.0f);
    }
}
