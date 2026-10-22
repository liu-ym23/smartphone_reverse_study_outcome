package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f41134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f41135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f41136c;

    public d() {
        this.f41134a = new ConcurrentLinkedQueue();
        this.f41136c = ((Number) SwitchCenter.f41316k.getValue()).longValue();
    }
}
