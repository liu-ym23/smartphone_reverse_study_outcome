package com.bytedance.android.anniex.lite.flow.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.anniex.lite.flow.base.model.b f40928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f40929b;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.base.model.a$a, reason: collision with other inner class name */
    public static final class C0761a {
    }

    public interface b {
        <T extends AnnieXModel> T create(Class<T> r100);
    }

    static {
    }

    public final <T extends AnnieXModel> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        String r101 = r100.getCanonicalName();
        if (r101 == null) goto L15;
        String r102 = "AnnieXModelProvider.DefaultKey:".concat(r101);
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        com.bytedance.android.anniex.lite.flow.base.model.b r103 = this.f40928a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        T r104 = (T) r103.f40930a.get(r102);
        if (r104 != null) goto L7;
    L9:
        r104 = (T) this.f40929b.create(r100);
        com.bytedance.android.anniex.lite.flow.base.model.b r105 = this.f40928a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r104, "AnnieXModel");
        AnnieXModel r106 = r105.f40930a.put(r102, r104);
        if (r106 == null) goto L12;
        r106.a();
    L12:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider.get");
    L13:
        return r104;
    L7:
        if (r100.isInstance(r104) == false) goto L9;
    L15:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public a(com.bytedance.android.anniex.lite.flow.base.model.b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f40928a = r100;
        this.f40929b = r101;
    }
}
