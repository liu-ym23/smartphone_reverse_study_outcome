package com.bytedance.android.live.base.abtest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes45.dex */
public final class ClientABTestKey<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f58802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f58803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f58804d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiType {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58805a;

        public a(int r100) {
            this.f58805a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClientABTestKey(String r100, Type r101, Object r102, int r103) {
        this.f58801a = r100;
        this.f58802b = r101;
        this.f58803c = r102;
        this.f58804d = new a(r103);
    }
}
