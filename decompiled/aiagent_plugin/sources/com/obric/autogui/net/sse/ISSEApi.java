package com.obric.autogui.net.sse;

import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ae;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.d;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ISSEApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ISSEApi {
    @ae
    @h
    e<i> doGetSSE(@ag String r1, @aa(a = true) Map<String, String> r2, @l List<b> r3, @d Object r4);

    @ae
    @t
    e<i> doPostSSE(@ag String r1, @aa(a = true) Map<String, String> r2, @com.bytedance.retrofit2.c.b Object r3, @l List<b> r4, @d Object r5);
}
