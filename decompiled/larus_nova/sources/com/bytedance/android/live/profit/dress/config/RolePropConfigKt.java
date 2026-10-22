package com.bytedance.android.live.profit.dress.config;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class RolePropConfigKt {
    public static final String a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$describe");
        return "PropConfig(playValueIcon=" + r100.getPlayValueIcon() + ", linkmicEffect=" + r100.getLinkmicEffect() + ", beautyEffectId=" + r100.getBeautyEffectId() + ", staticLinkmicImg=" + r100.getStaticLinkmicImg() + ')';
    }

    public static final <K, V> String b(Map<K, ? extends V> r110, final Function1<? super V, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "$this$describe");
        Intrinsics.checkNotNullParameter(r111, "valueTransformer");
        return SequencesKt.joinToString$default(MapsKt.asSequence(r110), null, "{", com.alipay.sdk.m.u.i.f25855d, 0, null, new RolePropConfigKt$describe$1(r111), 25, null);
    }
}
