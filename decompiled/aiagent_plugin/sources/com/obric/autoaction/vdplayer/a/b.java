package com.obric.autoaction.vdplayer.a;

import com.obric.aiagent.sharedstate.SharedState;

/* JADX INFO: compiled from: VDPlayerSpaceBadgeDebugConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25180a = null;

    static {
        f25180a = new b();
    }

    private b() {
    }

    public final boolean a() {
        return SharedState.INSTANCE.getBoolean("space_type_badge_enabled", false);
    }
}
