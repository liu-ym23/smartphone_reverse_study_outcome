package com.bytedance.android.livesdk.ktvimpl.crossplatform.midi;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.base.component.midi.KaraokeMidiScoreInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvMidiController implements com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KaraokeMidiScoreInfo f143795a;

    public static final class a {
    }

    static {
    }

    public KtvMidiController() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final float c() {
        KaraokeMidiScoreInfo r100 = this.f143795a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getSongScore();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a
    public final void a(final KaraokeMidiScoreInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        this.f143795a = r100;
        UtilityKotlinExtentionsKt.b(this, new KtvMidiController$setMidiScoreInfo$1(r100));
    }
}
