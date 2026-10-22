package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface n {
    nl.c a();

    s b();

    void c(Context r100, com.bytedance.android.shopping.sku.common.data.e r101);

    void d(Object r100);

    void e(Function1<? super d, Unit> r100);

    boolean f();

    boolean g();

    YataPageInfo getPageInfo();

    String getSourceBtmToken();

    d h();

    void i(Context r100, boolean r101);

    Map<String, Object> j();

    void k(Function0<Unit> r100);

    void release();
}
