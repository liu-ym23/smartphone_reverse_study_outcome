package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LRUCleanStrategy.d f129310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f129311b;

    public r(LRUCleanStrategy.d r100, Map r101) {
        this.f129310a = r100;
        this.f129311b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        LRUCleanStrategy.g(this.f129310a.f129230a, this.f129311b);
        return;
    }
}
