package com.bytedance.android.livesdk.padutils;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f154216a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f154217b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f154218c = null;

    static {
        f154216a = s1.f(20.0f);
        f154217b = MapsKt.mapOf(TuplesKt.to(GXTemplateKey.FLEXBOX_PADDING, 20));
        f154218c = MapsKt.emptyMap();
    }
}
