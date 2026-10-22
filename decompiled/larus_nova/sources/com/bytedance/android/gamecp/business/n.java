package com.bytedance.android.gamecp.business;

import com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.d f56186a;

    public n(LiveHostGameCP.C100301 r100) {
        this.f56186a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f56186a.onDownloaded(((Boolean) r100).booleanValue());
    }
}
