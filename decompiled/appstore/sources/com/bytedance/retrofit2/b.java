package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class b extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallAdapter.a f7946a = null;

    public class a implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f7947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f7948b;

        public a(b r10, Type r11) {
            this.f7948b = r10;
            this.f7947a = r11;
        }

        public Call a(Call r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public Type responseType() {
            return this.f7947a;
        }
    }

    static {
        f7946a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.a
    public CallAdapter a(Type r10, Annotation[] r11, f r12) {
        if (CallAdapter.a.b(r10) == Call.class) goto L7;
        return null;
    L7:
        return new a(this, f6.g.g(r10));
    }
}
