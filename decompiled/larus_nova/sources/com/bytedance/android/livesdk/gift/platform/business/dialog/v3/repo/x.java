package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements dy0.c, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, String>> f128574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f128575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f128576c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ((LinkedHashMap) this.f128574a).clear();
    }

    public x() {
        this.f128574a = new LinkedHashMap();
        ReadOnlyProperty r100 = zz1.d.f574022b;
        KProperty<?>[] r101 = zz1.d.f574021a;
        this.f128575b = ((zz1.b) r100.getValue(null, r101[0])).b();
        this.f128576c = ((zz1.b) r100.getValue(null, r101[0])).a();
    }
}
