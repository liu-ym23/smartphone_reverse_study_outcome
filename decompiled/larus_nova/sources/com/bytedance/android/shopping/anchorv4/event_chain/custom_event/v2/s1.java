package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class s1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f166710a = null;

    static {
        f166710a = new s1();
    }

    public s1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        dm.a.a("SchemaSkuActionForCustomUrlEvent").i("diff success");
    }
}
