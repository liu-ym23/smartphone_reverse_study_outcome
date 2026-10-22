package com.bytedance.android.live.revenuelink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91842a;

    public static final class a extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f91843b = null;

        static {
            f91843b = new a();
        }

        public a() {
            super("JoinFailed");
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f91844b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.f91842a + '_' + this.f91844b;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reqSrc");
            super("RTCEndSuccess");
            this.f91844b = r100;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f91845b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.f91842a + '_' + this.f91845b;
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "endReason");
            super("StopLiveBroadcast");
            this.f91845b = r100;
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f91846b = null;

        static {
            f91846b = new d();
        }

        public d() {
            super("SwitchPk");
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f91847b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.f91842a + '_' + this.f91847b;
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reqSrc");
            super("UnExceptUnload");
            this.f91847b = r100;
        }
    }

    public static final class f extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f91848b = null;

        static {
            f91848b = new f();
        }

        public f() {
            super("Unknown");
        }
    }

    public String toString() {
        return this.f91842a;
    }

    public i(String r100) {
        this.f91842a = r100;
    }
}
