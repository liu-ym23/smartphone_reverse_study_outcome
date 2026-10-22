package com.bytedance.frameworks.baselib.network.http.g.a.a;

import com.bytedance.retrofit2.e.g;
import com.bytedance.retrofit2.e.j;
import com.bytedance.retrofit2.i;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes.dex */
final class b<T> implements i<T, j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f8341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f8342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TypeAdapter<T> f8343c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.i
    public /* synthetic */ j b(Object r1) {
        return a(r1);
    }

    static {
        f8341a = Charset.forName("UTF-8");
    }

    b(Gson r1, TypeAdapter<T> r2) {
        this.f8342b = r1;
        this.f8343c = r2;
    }

    public j a(T r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r1 = new OutputStreamWriter(r0, f8341a);
        JsonWriter r2 = this.f8342b.newJsonWriter(r1);
        this.f8343c.write(r2, r4);
        r2.close();
        return new g("application/json; charset=UTF-8", r0.toByteArray(), new String[0]);
    }
}
