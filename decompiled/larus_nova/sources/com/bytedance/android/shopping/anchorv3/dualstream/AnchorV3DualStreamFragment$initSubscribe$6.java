package com.bytedance.android.shopping.anchorv3.dualstream;

import com.bytedance.android.shopping.anchorv3.dualstream.model.DualStreamState;
import com.bytedance.locallife.dito.data.DitoNode;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AnchorV3DualStreamFragment$initSubscribe$6 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new AnchorV3DualStreamFragment$initSubscribe$6();
    }

    public AnchorV3DualStreamFragment$initSubscribe$6() {
        super(DualStreamState.class, DitoNode.LOAD_MORE, "getLoadMore()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((DualStreamState) r100).f165093d);
    }
}
