package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.scope.o;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements wz0.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nr2.a f91571a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public c(nr2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPropertyService");
        this.f91571a = r100;
    }

    @Override // wz0.b
    public final a U3(final String r100, final Object r101, final Type r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "type");
        return new a(new SpongePreferenceService$createSpongePreference$1(this, r100, r102, r101), new SpongePreferenceService$createSpongePreference$2(this, r100, r102), new SpongePreferenceService$createSpongePreference$3(this, r100));
    }
}
