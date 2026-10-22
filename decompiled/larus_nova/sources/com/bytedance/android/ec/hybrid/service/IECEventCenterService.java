package com.bytedance.android.ec.hybrid.service;

import com.bytedance.android.ec.hybrid.card.event.b;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.ec.hybrid.card.event.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/service/IECEventCenterService;", "", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECEventCenterService {
    void a(b r100);

    void b(String r100, e r101, String r102, long r103, String r104);

    void c(Function1<? super f, Boolean> r100);

    void d(boolean r100, List<String> r101);

    void e(f r100, String r101, boolean r102);

    void f(f r100, String r101);

    void g(String r100, e r101);

    void h(String r100, String r101, Boolean r102, Long r103, Long r104);
}
