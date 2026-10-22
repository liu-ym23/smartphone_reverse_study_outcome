package com.bytedance.android.livesdk.widgetdescriptor;

import android.content.Context;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e0 extends d90.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InteractionContext f162376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f162377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IAbilityCenter f162378m;

    @Override // d90.a, d90.d, h70.b
    public final IAbilityCenter a() {
        return this.f162378m;
    }

    public e0(Context r100, DataCenter r101, AbilityCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "abilityCenter");
        super(r100, r101, r102);
        this.f162378m = r102;
        this.f162377l = LazyKt.lazy(new LiveLayerContext$elementConfigRegistery$2(this));
    }
}
