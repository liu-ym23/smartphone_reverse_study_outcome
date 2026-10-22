package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements IExternalIconTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f42764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yd.c f42765b;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public final View getView() {
        return this.f42764a;
    }

    public b(yd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "realTemplate");
        this.f42765b = r100;
        this.f42764a = r100.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public final Animator getEntryAnimation(long r100) {
        return this.f42765b.getEntryAnimation(r100);
    }
}
