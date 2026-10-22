package com.bytedance.bdturing.ttnet;

import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ae;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @h
    e<i> doGet(@com.bytedance.retrofit2.c.a boolean r1, @ag String r2, @aa Map<String, String> r3, @l List<com.bytedance.retrofit2.b.b> r4);

    @ae
    @t
    e<i> doPost(@ag String r1, @aa Map<String, String> r2, @com.bytedance.retrofit2.c.b j r3, @l List<com.bytedance.retrofit2.b.b> r4);
}
