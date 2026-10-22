package com.bytedance.android.live.room.share.summersinging;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f100360a;

    public m(Function1 r100) {
        this.f100360a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f100360a.invoke(r100);
    }
}
