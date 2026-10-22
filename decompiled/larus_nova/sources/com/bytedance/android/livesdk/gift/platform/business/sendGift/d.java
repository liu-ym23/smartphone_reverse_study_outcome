package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f130106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f130107b;

    public d(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f130107b = r100;
    }
}
