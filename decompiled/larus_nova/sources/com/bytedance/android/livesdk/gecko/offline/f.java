package com.bytedance.android.livesdk.gecko.offline;

import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<d> f125830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f125831b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f125832c = null;

    static {
        ArrayList<d> r100 = new ArrayList();
        f125830a = r100;
        f125831b = new b(r100);
        f125832c = new e(r100);
        r100.add(new c());
    }

    public static File a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = f125831b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        return r101.a(r100);
    }

    public static Pair b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r101 = f125832c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        return (Pair) r101.b(r100);
    }
}
