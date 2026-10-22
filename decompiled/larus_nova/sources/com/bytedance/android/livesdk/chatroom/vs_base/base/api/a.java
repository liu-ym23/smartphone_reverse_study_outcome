package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f117880a;

    public a() {
    }

    public abstract void b(Map<String, ? extends Object> r100);

    public final b a() {
        b r100 = this.f117880a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskGraph");
    L5:
        return r100;
    }
}
