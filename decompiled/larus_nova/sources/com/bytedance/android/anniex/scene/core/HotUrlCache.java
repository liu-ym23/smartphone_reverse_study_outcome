package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes43.dex */
public final class HotUrlCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HotUrlCache$map$1 f41087b;

    public HotUrlCache() {
        Lazy r100 = SwitchCenter.f41296a;
        this.f41086a = ((Number) SwitchCenter.f41318l.getValue()).intValue();
        this.f41087b = new HotUrlCache$map$1(this);
    }
}
