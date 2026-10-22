package com.bytedance.android.annie.service.network;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class r extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f39926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f39927b;

    public final Integer a() {
        return Integer.valueOf(this.f39927b.element);
    }

    public final String b() {
        return this.f39926a.element;
    }

    public r(LinkedHashMap<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<String> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105) {
        this.f39926a = r102;
        this.f39927b = r105;
    }
}
