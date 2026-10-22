package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<String>> f131836a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((LinkedHashMap) this.f131836a).clear();
    }

    public x() {
        this.f131836a = new LinkedHashMap();
    }
}
