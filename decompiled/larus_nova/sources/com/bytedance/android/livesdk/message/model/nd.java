package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f153673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f153674b;

    public static final class a extends nd {
        public a(int r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class b extends nd {
        public b(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "userId");
            super(r100, r101);
        }
    }

    public nd(int r100, int r101) {
        this.f153673a = r100;
        this.f153674b = r101;
    }
}
