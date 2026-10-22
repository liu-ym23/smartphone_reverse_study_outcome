package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvOpusSingerInfoView$onAttach$6 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new KtvOpusSingerInfoView$onAttach$6();
    }

    public KtvOpusSingerInfoView$onAttach$6() {
        super(oe2.f.class, "avatarAnimShow", "getAvatarAnimShow()Z", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((oe2.f) r100).f522956d);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object r100, Object r101) {
        boolean r102 = ((Boolean) r101).booleanValue();
        ((oe2.f) r100).f522956d = r102;
    }
}
