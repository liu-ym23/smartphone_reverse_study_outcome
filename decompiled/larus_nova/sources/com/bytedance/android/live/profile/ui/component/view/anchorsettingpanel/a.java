package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f86856a;

    public a(Function1 r100) {
        this.f86856a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f86856a.invoke(r100);
    }
}
