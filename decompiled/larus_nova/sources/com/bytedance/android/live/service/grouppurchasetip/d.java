package com.bytedance.android.live.service.grouppurchasetip;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f100872a;

    public d(Function1 r100) {
        this.f100872a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f100872a.invoke(r100);
    }
}
