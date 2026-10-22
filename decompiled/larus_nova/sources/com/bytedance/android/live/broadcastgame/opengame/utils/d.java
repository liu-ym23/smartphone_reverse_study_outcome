package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f61152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, Long> f61153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PluginContext f61154c;

    public d(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f61154c = r100;
        this.f61153b = new HashMap();
    }
}
