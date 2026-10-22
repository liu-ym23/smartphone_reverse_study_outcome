package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f91035a = 0;

    public static final class a implements IAbility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.revenue.core.a f91036a;

        @Override // com.bytedance.android.livesdk.ability.IAbility
        public final /* synthetic */ void onAbilityClear() {
            IAbility.CC.$default$onAbilityClear(this);
        }

        public a(com.bytedance.android.live.revenue.core.a r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            this.f91036a = r100;
        }
    }

    static {
    }
}
