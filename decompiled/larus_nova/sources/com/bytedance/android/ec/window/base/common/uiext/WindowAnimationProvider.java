package com.bytedance.android.ec.window.base.common.uiext;

import android.view.animation.Animation;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowAnimationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, KFunction<Animation>> f49217a = null;

    static {
        f49217a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, WindowAnimationProvider$generators$1.INSTANCE), TuplesKt.to(2, WindowAnimationProvider$generators$2.INSTANCE), TuplesKt.to(4, WindowAnimationProvider$generators$3.INSTANCE)});
    }
}
