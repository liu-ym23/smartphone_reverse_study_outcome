package com.bytedance.android.live.soloktv.fragment;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class SoloKtvEditFragment$initViewModel$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SoloKtvEditFragment$initViewModel$1();
    }

    public SoloKtvEditFragment$initViewModel$1() {
        super(com.bytedance.android.live.soloktv.viewmodel.g.class, "voiceVolume", "getVoiceVolume()I", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Integer.valueOf(((com.bytedance.android.live.soloktv.viewmodel.g) r100).f101908a);
    }
}
