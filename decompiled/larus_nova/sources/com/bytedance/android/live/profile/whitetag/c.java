package com.bytedance.android.live.profile.whitetag;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f87066a;

    public c(Function1 r100) {
        this.f87066a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f87066a.invoke(r100);
    }
}
