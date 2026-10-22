package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f179605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CartObjectContainer f179606b;

    public e(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f179606b = r100;
        this.f179605a = new AtomicBoolean(false);
    }
}
