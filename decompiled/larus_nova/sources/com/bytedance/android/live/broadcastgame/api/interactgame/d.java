package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f59301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f59302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f59303c;

    public static final class a {
    }

    static {
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gameGuideParams");
        this.f59301a = (c) GsonHelper.get().fromJson(r100, c.class);     // Catch: Exception -> L5
        this.f59302b = true;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("GameGuideHelper", e.getMessage(), e);
    }
}
