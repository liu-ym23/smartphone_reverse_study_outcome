package com.bytedance.android.live.profit.format.voicechat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f87673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CloseReason f87674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f87675c;

        public a(boolean r100, CloseReason r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "closeReason");
            this.f87673a = r100;
            this.f87674b = r101;
            this.f87675c = r102;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f87676a;

        public b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionInfo");
            this.f87676a = r100;
        }
    }

    public f() {
    }
}
