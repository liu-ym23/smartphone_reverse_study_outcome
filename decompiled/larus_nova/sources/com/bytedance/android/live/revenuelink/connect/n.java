package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdk.link.model.i6;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface n {
    void b(com.bytedance.android.live.revlink.impl.multianchor.utils.t r100);

    void c(i6 r100);

    void d(d11.d r100, Map<String, String> r101);

    void e(d11.c r100, Map<String, String> r101);

    Disposable f(d11.d r100, Function1<? super d11.d, Unit> r101, Function1<? super d11.d, Unit> r102, Map<String, String> r103);

    void g(d11.b r100, Map<String, String> r101);

    void h(d11.g r100, Map<String, String> r101);

    void i(com.bytedance.android.live.revlink.impl.multianchor.utils.t r100);

    void j(d11.e r100);

    void k(d11.f r100, Map<String, String> r101);
}
