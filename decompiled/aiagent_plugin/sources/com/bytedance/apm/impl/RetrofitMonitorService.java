package com.bytedance.apm.impl;

import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.q;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.c.w;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface RetrofitMonitorService {
    @h
    e<i> fetch(@ag String r1, @l List<com.bytedance.retrofit2.b.b> r2, @aa Map<String, String> r3, @com.bytedance.retrofit2.c.a boolean r4);

    @h
    e<i> fetch(@ag String r1, @aa Map<String, String> r2, @com.bytedance.retrofit2.c.a boolean r3);

    @t
    e<i> report(@ag String r1, @com.bytedance.retrofit2.c.b j r2, @l List<com.bytedance.retrofit2.b.b> r3, @com.bytedance.retrofit2.c.a boolean r4);

    @q
    @t
    e<i> uploadFiles(@ag String r1, @w Map<String, j> r2, @l List<com.bytedance.retrofit2.b.b> r3);
}
