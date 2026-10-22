package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface f {
    void a(k r100);

    void b(boolean r100, Function1<? super b, Unit> r101);

    void c(Function0<Unit> r100);

    void d(String r100, int r101, boolean r102);

    NextLiveData<od> e();

    NextLiveData<List<od>> f();

    void g(od r100);

    long getMId();

    String getSingerId();

    void h();

    k i();

    NextLiveData<ArrayList<od>> j();

    void k(boolean r100, Function1<? super a, Unit> r101);

    void release();
}
