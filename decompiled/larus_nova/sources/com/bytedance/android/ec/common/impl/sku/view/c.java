package com.bytedance.android.ec.common.impl.sku.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f43480a;

    public c(Function0 r100) {
        this.f43480a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f43480a.invoke();
    }
}
