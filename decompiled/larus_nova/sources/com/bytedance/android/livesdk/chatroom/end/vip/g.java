package com.bytedance.android.livesdk.chatroom.end.vip;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f106144a;

    public g(Function1 r100) {
        this.f106144a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f106144a.invoke(r100);
    }
}
