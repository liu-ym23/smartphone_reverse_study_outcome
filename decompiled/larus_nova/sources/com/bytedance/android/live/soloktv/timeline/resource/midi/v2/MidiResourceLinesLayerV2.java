package com.bytedance.android.live.soloktv.timeline.resource.midi.v2;

import android.graphics.Paint;
import android.graphics.Path;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class MidiResourceLinesLayerV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f101516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Path, Paint> f101517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f101518c;

    public static final class a {
    }

    static {
    }

    public MidiResourceLinesLayerV2(rb1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        this.f101516a = InfraKotlinExtsKt.mainThreadLazy(MidiResourceLinesLayerV2$linePath$2.INSTANCE);
        this.f101517b = new LinkedHashMap();
        s1.f(7.0f);
        s1.y();
        this.f101518c = InfraKotlinExtsKt.mainThreadLazy(MidiResourceLinesLayerV2$linePaint$2.INSTANCE);
    }
}
