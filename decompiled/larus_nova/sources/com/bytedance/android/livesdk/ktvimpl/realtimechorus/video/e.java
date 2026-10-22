package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import fd2.n;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f146945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Integer> f146946b;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f146945a = 100;
        this.f146946b = new HashMap(15);
    }

    @Override // fd2.n
    public final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        if (this.f146946b.containsKey(r100) == false) goto L9;
        Integer r101 = this.f146946b.get(r100);
        if (r101 != null) goto L10;
        r101 = Integer.valueOf(this.f146945a);
    L10:
        return r101.intValue();
    L9:
        return this.f146945a;
    }
}
