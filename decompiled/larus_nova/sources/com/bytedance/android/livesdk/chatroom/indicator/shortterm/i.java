package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f106645a;

    public i(Function1 r100) {
        this.f106645a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f106645a.invoke(r100);
    }
}
