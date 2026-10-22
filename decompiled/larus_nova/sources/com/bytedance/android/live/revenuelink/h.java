package com.bytedance.android.live.revenuelink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91838a;

    public static final class a extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f91839b;

        @Override // com.bytedance.android.live.revenuelink.h
        public final String toString() {
            return this.f91838a + '_' + this.f91839b;
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super("Close");
            this.f91839b = r100;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f91840b = null;

        static {
            f91840b = new b();
        }

        public b() {
            super("Leave");
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f91841b = null;

        static {
            f91841b = new c();
        }

        public c() {
            super("SeiUnload");
        }
    }

    public String toString() {
        return this.f91838a;
    }

    public h(String r100) {
        this.f91838a = r100;
    }
}
