package com.bytedance.android.gamecp.business.gamedetail.component.interactionplay;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class InteractionPlayEntranceLayerWidget$onUpdate$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new InteractionPlayEntranceLayerWidget$onUpdate$1();
    }

    public InteractionPlayEntranceLayerWidget$onUpdate$1() {
        super(d.class, "layerVisible", "getLayerVisible()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((d) r100).f54367g);
    }
}
