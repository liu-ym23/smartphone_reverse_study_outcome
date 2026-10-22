package com.bytedance.frameworks.baselib.network.http.g.a.a;

import com.bytedance.retrofit2.e.d;
import com.bytedance.retrofit2.i;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: GsonResponseBodyConverter.java */
/* JADX INFO: loaded from: classes.dex */
final class c<T> implements i<com.bytedance.retrofit2.e.i, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f8344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f8345b;

    @Override // com.bytedance.retrofit2.i
    public /* synthetic */ Object b(com.bytedance.retrofit2.e.i r3) {
        return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
    }

    c(Gson r1, TypeAdapter<T> r2) {
        this.f8344a = r1;
        this.f8345b = r2;
    }

    public T a(com.bytedance.retrofit2.e.i r3) {
        com.bytedance.retrofit2.e.i r4 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        String r1 = "UTF-8";
        if (r4.b() == null) goto L5;
        r1 = d.a(r4.b(), "UTF-8");
    L5:
        InputStreamReader r0 = new InputStreamReader(r4.e_(), r1);
        JsonReader r5 = this.f8344a.newJsonReader(r0);
        T r2 = this.f8345b.read(r5);     // Catch: Throwable -> L9
        r0.close();     // Catch: IOException -> L12
    L8:
        return r2;
    L9:
        th = move-exception;
        r0.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }
}
