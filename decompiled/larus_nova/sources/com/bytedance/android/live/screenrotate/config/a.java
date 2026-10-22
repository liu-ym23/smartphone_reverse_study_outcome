package com.bytedance.android.live.screenrotate.config;

import a81.b;
import io.reactivex.functions.Action;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f100563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f100564b;

    public a(Map r100, b r101) {
        this.f100563a = r100;
        this.f100564b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f100563a.remove(this.f100564b);
    }
}
