package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.h;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/h;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/live/effect/h;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EffectLivePreviewActivityProxy$liveEffectSQLHelper$2 extends Lambda implements Function0<h> {
    public static final EffectLivePreviewActivityProxy$liveEffectSQLHelper$2 INSTANCE = null;

    static {
        INSTANCE = new EffectLivePreviewActivityProxy$liveEffectSQLHelper$2();
    }

    public EffectLivePreviewActivityProxy$liveEffectSQLHelper$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final h invoke() {
        return new h(s1.getContext());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ h invoke() {
        return invoke();
    }
}
