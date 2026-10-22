package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MatrixCushionManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33723a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f33724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f33725e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f33726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f33727c;

    /* JADX INFO: compiled from: MatrixCushionManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a() {
            if (c.b() == null) goto L7;
            c r1 = c.b();
            o.a(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixCushionManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }
    }

    public static final /* synthetic */ c b() {
        return f33724d;
    }

    static {
        f33723a = new a(null);
        f33725e = new Object();
    }

    public final Context getContext() {
        return this.f33726b;
    }

    public final b a() {
        return this.f33727c;
    }
}
