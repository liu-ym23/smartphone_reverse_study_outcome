package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.DiffContext;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.d0;
import com.bytedance.android.anya.p;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public interface m<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> extends com.bytedance.android.anya.q {
    void b(ACTION r100);

    void c(Map<q<?, ?>, ? extends d0<?, ?>> r100);

    Disposable d(Function1<? super a0, Boolean> r100);

    void e(Map<q<?, ?>, ? extends d0<?, ?>> r100);

    DiffContext f();
}
