package com.bytedance.android.live.room.discovery.inspector;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f99552a;

    public f(Function1 r100) {
        this.f99552a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f99552a.invoke(r100);
    }
}
