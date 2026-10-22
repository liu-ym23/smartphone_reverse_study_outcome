package com.bytedance.android.livesdk.livecommerce.playback.bottom;

import com.bytedance.android.livesdk.livecommerce.playback.video.b;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ExplainPlaybackBottomPresenter$bindSpeedView$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ExplainPlaybackBottomPresenter$bindSpeedView$2();
    }

    public ExplainPlaybackBottomPresenter$bindSpeedView$2() {
        super(b.class, "speedFloat", "getSpeedFloat()F", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Float.valueOf(((b) r100).f150008c);
    }
}
