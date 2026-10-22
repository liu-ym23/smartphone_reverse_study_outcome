package com.bytedance.frameworks.baselib.network.http.g.a.a;

import com.bytedance.retrofit2.ab;
import com.bytedance.retrofit2.e.j;
import com.bytedance.retrofit2.i;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f8340a;

    public static a a() {
        return a(new Gson());
    }

    public static a a(Gson r1) {
        return new a(r1);
    }

    private a(Gson r2) {
        Objects.requireNonNull(r2, "gson == null");
        this.f8340a = r2;
    }

    @Override // com.bytedance.retrofit2.i.a
    public i<com.bytedance.retrofit2.e.i, ?> a(Type r1, Annotation[] r2, ab r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
        TypeAdapter r5 = this.f8340a.getAdapter(TypeToken.get(r4));
        return new c(this.f8340a, r5);
    }

    @Override // com.bytedance.retrofit2.i.a
    public i<?, j> a(Type r1, Annotation[] r2, Annotation[] r3, ab r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
        TypeAdapter r6 = this.f8340a.getAdapter(TypeToken.get(r5));
        return new b(this.f8340a, r6);
    }
}
