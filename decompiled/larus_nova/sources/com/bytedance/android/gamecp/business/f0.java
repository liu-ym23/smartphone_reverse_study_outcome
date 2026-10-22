package com.bytedance.android.gamecp.business;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
public final class f0 implements wr.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f53162a;

    public f0(long r100) {
        this.f53162a = r100;
    }

    @Override // wr.b
    public final void onResult(String r100) {
        Lambda r101 = GamePromoteManager.f51751a;
        GamePromoteManager.b(r100, this.f53162a);
    }
}
