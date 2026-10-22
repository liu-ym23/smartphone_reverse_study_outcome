package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView<k, Boolean> f41127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f41128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f41129d;

    public a() {
        this.f41126a = ((Number) SwitchCenter.f41314j.getValue()).longValue();
        this.f41127b = ConcurrentHashMap.newKeySet();
    }
}
