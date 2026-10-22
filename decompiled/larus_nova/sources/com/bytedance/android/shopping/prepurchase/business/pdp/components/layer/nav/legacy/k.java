package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface k {
    CommonMeta a();

    V4NativeParams c();

    void d(Function1<? super vg3.z, Unit> r100);

    long getDuration();

    boolean j();
}
