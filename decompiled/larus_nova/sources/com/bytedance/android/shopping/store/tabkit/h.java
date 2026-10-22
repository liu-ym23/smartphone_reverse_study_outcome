package com.bytedance.android.shopping.store.tabkit;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f186748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f186749b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f186750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f186751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f186752c;

        public a() {
            this(0);
        }

        public a(int r100) {
            this.f186750a = false;
            this.f186751b = 0;
            this.f186752c = 0;
        }
    }

    public h() {
        this.f186748a = new a(0);
        this.f186749b = new SparseArray();
    }
}
