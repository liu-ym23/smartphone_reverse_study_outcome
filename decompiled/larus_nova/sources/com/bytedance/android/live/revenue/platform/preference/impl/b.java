package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.scope.g;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.o;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements o, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wz0.b f91569a;

    public static final class a implements com.bytedance.tools.kcp.spongepreference.runtime.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f91570b;

        public a(b r100) {
            this.f91570b = r100;
        }

        @Override // com.bytedance.tools.kcp.spongepreference.runtime.b
        public final <T> com.bytedance.tools.kcp.spongepreference.runtime.a<T> a(String r100, T r101, Type r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "type");
            return this.f91570b.f91569a.U3(r100, r101, r102);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b(wz0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "spongePreferenceService");
        this.f91569a = r100;
        com.bytedance.tools.kcp.spongepreference.runtime.b r101 = SpongePreferenceManager.f271010a;
        a r102 = new a(this);
        Intrinsics.checkNotNullParameter(r102, "factory");
        SpongePreferenceManager.f271010a = r102;
    }

    @Override // com.bytedance.android.scope.g
    public final boolean c(j r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        Intrinsics.checkNotNullParameter(r100, "parentScope");
        Intrinsics.checkNotNullParameter(r101, "childScope");
        return false;
    }
}
