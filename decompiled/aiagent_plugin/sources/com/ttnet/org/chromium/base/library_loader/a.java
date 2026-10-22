package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.a.b;

/* JADX INFO: compiled from: ModernLinker.java */
/* JADX INFO: loaded from: classes4.dex */
class a extends Linker {
    private static final String TAG = "ModernLinker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37720a = true;

    static {
    }

    a() {
    }

    public static void a(long r1) {
        b.a("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", r1);
    }

    public static void b(long r1) {
        b.a("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", r1);
    }
}
