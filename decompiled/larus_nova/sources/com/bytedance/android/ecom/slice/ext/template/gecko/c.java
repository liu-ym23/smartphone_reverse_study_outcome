package com.bytedance.android.ecom.slice.ext.template.gecko;

import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface c {
    void a();

    void b(SlcRenderContext r100);

    com.bytedance.android.ecom.arch.slice.expr.b c();

    void d(com.bytedance.android.ecom.arch.slice.render.i r100, Map<String, ? extends Object> r101, Function2<? super i, ? super r, Unit> r102);

    void release();
}
