package com.bytedance.rpc.transport.ttnet;

import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.c.a;
import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ae;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.d;
import com.bytedance.retrofit2.c.f;
import com.bytedance.retrofit2.c.g;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
interface RetrofitApi {
    @g
    @ae
    @t
    e<i> form(@a boolean r1, @ag String r2, @aa Map<String, String> r3, @f(a = true) Map<String, String> r4, @l List<b> r5, @d Object r6);

    @ae
    @h
    e<i> get(@a boolean r1, @ag String r2, @aa(a = true) Map<String, String> r3, @l List<b> r4, @d Object r5);

    @ae
    @t
    e<i> post(@a boolean r1, @ag String r2, @aa Map<String, String> r3, @com.bytedance.retrofit2.c.b j r4, @l List<b> r5, @d Object r6);
}
