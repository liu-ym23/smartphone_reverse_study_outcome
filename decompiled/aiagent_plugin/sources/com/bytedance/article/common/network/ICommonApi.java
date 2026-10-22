package com.bytedance.article.common.network;

import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.f;
import com.bytedance.retrofit2.c.g;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.o;
import com.bytedance.retrofit2.c.t;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @h
    e<String> get(@o int r1, @ag String r2, @l List<b> r3, @com.bytedance.retrofit2.c.a boolean r4);

    @t
    e<String> postData(@o int r1, @ag String r2, @com.bytedance.retrofit2.c.b j r3, @l List<b> r4, @com.bytedance.retrofit2.c.a boolean r5);

    @t
    e<i> postDataStream(@o int r1, @ag String r2, @com.bytedance.retrofit2.c.b j r3, @l List<b> r4, @com.bytedance.retrofit2.c.a boolean r5);

    @g
    @t
    e<String> postForm(@o int r1, @ag String r2, @f(a = true) Map<String, String> r3, @l List<b> r4, @com.bytedance.retrofit2.c.a boolean r5);
}
