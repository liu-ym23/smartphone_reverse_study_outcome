package com.bytedance.android.livesdk.privacy.av.universal.observer;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class PrivacyDetectBackgroundObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f156693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f156694b;

    public PrivacyDetectBackgroundObserver() {
        this.f156694b = LazyKt.lazy(new PrivacyDetectBackgroundObserver$appMonitor$2(this));
    }
}
