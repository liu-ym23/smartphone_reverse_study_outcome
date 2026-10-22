package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes11.dex */
public final class e3<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAssetsManager f158935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f158936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f3 f158937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f158938d;

    public e3(IAssetsManager r100, long r101, f3 r102) {
        this.f158935a = r100;
        this.f158936b = r101;
        this.f158937c = r102;
        this.f158938d = 4;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        return Boolean.valueOf(this.f158935a.j4(this.f158936b, this.f158937c, this.f158938d));
    }
}
