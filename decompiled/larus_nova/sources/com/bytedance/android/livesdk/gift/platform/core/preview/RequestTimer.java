package com.bytedance.android.livesdk.gift.platform.core.preview;

import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class RequestTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f130965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Long> f130967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Long> f130968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f130969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f130970f;

    public RequestTimer() {
        this.f130966b = ((Number) com.bytedance.android.livesdk.gift.platform.business.a.f126509v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.f126488a[20])).longValue();
        this.f130967c = CollectionsKt.emptyList();
        this.f130968d = CollectionsKt.emptyList();
        this.f130970f = RequestTimer$callback$1.INSTANCE;
    }
}
