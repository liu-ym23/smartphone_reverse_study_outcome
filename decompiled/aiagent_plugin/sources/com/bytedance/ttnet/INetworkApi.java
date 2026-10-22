package com.bytedance.ttnet;

import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ae;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.o;
import com.bytedance.retrofit2.c.q;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.c.w;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @com.bytedance.retrofit2.c.h
    com.bytedance.retrofit2.e<String> doGet(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @aa(a = true) Map<String, String> r4, @l List<com.bytedance.retrofit2.b.b> r5, @com.bytedance.retrofit2.c.d Object r6);

    @com.bytedance.retrofit2.c.h
    com.bytedance.retrofit2.e<i> doGetBytes(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @aa(a = true) Map<String, String> r4, @l List<com.bytedance.retrofit2.b.b> r5, @com.bytedance.retrofit2.c.d Object r6);

    @com.bytedance.retrofit2.c.g
    @t
    com.bytedance.retrofit2.e<String> doPost(@o int r1, @ag String r2, @aa Map<String, String> r3, @com.bytedance.retrofit2.c.f(a = true) Map<String, String> r4, @l List<com.bytedance.retrofit2.b.b> r5, @com.bytedance.retrofit2.c.d Object r6);

    @ae
    @com.bytedance.retrofit2.c.h
    com.bytedance.retrofit2.e<i> downloadFile(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @aa(a = true) Map<String, String> r4);

    @ae
    @com.bytedance.retrofit2.c.h
    com.bytedance.retrofit2.e<i> downloadFile(@com.bytedance.retrofit2.c.a boolean r1, @o int r2, @ag String r3, @aa(a = true) Map<String, String> r4, @l List<com.bytedance.retrofit2.b.b> r5, @com.bytedance.retrofit2.c.d Object r6);

    @t
    com.bytedance.retrofit2.e<String> postBody(@o int r1, @ag String r2, @aa(a = true) Map<String, String> r3, @com.bytedance.retrofit2.c.b j r4, @l List<com.bytedance.retrofit2.b.b> r5);

    @q
    @t
    com.bytedance.retrofit2.e<String> postMultiPart(@o int r1, @ag String r2, @aa(a = true) Map<String, String> r3, @w Map<String, j> r4, @l List<com.bytedance.retrofit2.b.b> r5);
}
