package com.bytedance.ai.settings;

import com.bytedance.ai.debug.f;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f37572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f37573c;

    public final T a() {
        f.a r100 = f.f36213a;
        String r101 = this.f37571a;
        Type r102 = this.f37573c;
        T r103 = this.f37572b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (r103 == null) goto L5;
        return r103;
    L5:
        return this.f37572b;
    }

    public final Type getType() {
        return this.f37573c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        this.f37571a = r100;
        this.f37572b = r101;
        Class<?> r102 = r101.getClass();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.Class<T of com.bytedance.ai.settings.AISDKSetting>");
        this.f37573c = r102;
    }
}
