package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class InteractionDelegateConfig implements com.bytedance.android.live.core.tetris.layer.core.delegate.c<d90.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f162279b;

    public InteractionDelegateConfig() {
        this.f162278a = LazyKt.lazy(InteractionDelegateConfig$portraitDelegateMap$2.INSTANCE);
        this.f162279b = LazyKt.lazy(InteractionDelegateConfig$landscapeDelegateMap$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.c
    public final Class a(LayerIndex r100, h70.b r101) {
        d90.a r102 = (d90.a) r101;
        Intrinsics.checkNotNullParameter(r100, "layerIndex");
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        if (d90.c.i(r102) == false) goto L6;
        return (Class) ((Map) this.f162278a.getValue()).get(r100);
    L6:
        return (Class) ((Map) this.f162279b.getValue()).get(r100);
    }
}
