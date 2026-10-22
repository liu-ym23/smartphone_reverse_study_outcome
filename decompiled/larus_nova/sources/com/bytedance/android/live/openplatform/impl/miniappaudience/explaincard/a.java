package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements AsyncLayoutInflater.OnInflateFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceExplainCardContextService f84849a;

    public a(AudienceExplainCardContextService r100) {
        this.f84849a = r100;
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        qo0.a.c("AudienceExplainCardContextService", "preload card layout success");
        this.f84849a.f84817a = r100;
    }
}
