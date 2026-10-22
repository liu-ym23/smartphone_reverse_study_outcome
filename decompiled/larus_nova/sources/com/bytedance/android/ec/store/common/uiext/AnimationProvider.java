package com.bytedance.android.ec.store.common.uiext;

import android.view.animation.Animation;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes44.dex */
public final class AnimationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, KFunction<Animation>> f48228a = null;

    static {
        f48228a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, AnimationProvider$generators$1.INSTANCE), TuplesKt.to(2, AnimationProvider$generators$2.INSTANCE), TuplesKt.to(4, AnimationProvider$generators$3.INSTANCE)});
    }
}
