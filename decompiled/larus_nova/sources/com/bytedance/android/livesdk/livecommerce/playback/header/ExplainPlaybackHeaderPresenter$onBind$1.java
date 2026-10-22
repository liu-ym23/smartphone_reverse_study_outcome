package com.bytedance.android.livesdk.livecommerce.playback.header;

import com.bytedance.android.livesdk.livecommerce.playback.main.f;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ExplainPlaybackHeaderPresenter$onBind$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ExplainPlaybackHeaderPresenter$onBind$1();
    }

    public ExplainPlaybackHeaderPresenter$onBind$1() {
        super(f.class, "showBackToLive", "getShowBackToLive()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((f) r100).f149941b);
    }
}
