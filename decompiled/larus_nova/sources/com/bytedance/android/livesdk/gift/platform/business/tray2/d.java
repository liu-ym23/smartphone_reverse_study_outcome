package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, i02.f> f130362a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((LinkedHashMap) this.f130362a).clear();
    }

    public d() {
        this.f130362a = new LinkedHashMap();
    }
}
