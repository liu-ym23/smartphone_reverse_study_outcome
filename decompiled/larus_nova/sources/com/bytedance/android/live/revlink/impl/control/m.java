package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.e4;
import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f92446a = null;

    static {
        f92446a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        int r102 = ((e4) r101.data).getCount();
        com.bytedance.tools.kcp.spongepreference.runtime.a r103 = l51.a.E;
        KProperty<?>[] r104 = l51.a.f507436a;
        r103.setValue(null, r104[30], Integer.valueOf(r102));
        int r105 = ((e4) r101.data).getTotalCount();
        l51.a.F.setValue(null, r104[31], Integer.valueOf(r105));
    }
}
