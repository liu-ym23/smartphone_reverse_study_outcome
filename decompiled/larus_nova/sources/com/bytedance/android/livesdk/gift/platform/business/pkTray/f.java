package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, PriorityQueue<d>> f130050a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((LinkedHashMap) this.f130050a).clear();
    }

    public f() {
        this.f130050a = new LinkedHashMap();
    }
}
