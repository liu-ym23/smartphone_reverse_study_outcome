package com.bytedance.android.ecom.arch.slice.action;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<ActionParams> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f49983d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f49984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f49985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ActionParams f49986c;

    public static final class a {
        public static d a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return new d(false, r100, null);
        }

        public static d b(Object r100) {
            return new d(true, null, r100);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean r100, String r101, Object r102) {
        this.f49984a = r100;
        this.f49985b = r101;
        this.f49986c = r102;
    }
}
