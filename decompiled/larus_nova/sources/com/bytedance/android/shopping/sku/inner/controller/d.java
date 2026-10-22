package com.bytedance.android.shopping.sku.inner.controller;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f182896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f182897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f182898c;

    public static final class a implements ul.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f182899a;

        public a(d r100) {
            this.f182899a = r100;
        }

        @Override // ul.c
        public final void a(boolean r100) {
            if (r100 == false) goto L8;
            WeakReference<View> r101 = this.f182899a.f182896a;
            if (r101 == null) goto L14;
            View r102 = r101.get();
            if (r102 == null) goto L15;
            r102.setVisibility(0);
            return;
        L15:
            return;
        L14:
            return;
        L8:
            WeakReference<View> r103 = this.f182899a.f182896a;
            if (r103 == null) goto L17;
            View r104 = r103.get();
            if (r104 == null) goto L18;
            r104.setVisibility(8);
            return;
        L18:
            return;
        }
    }

    public d() {
        this.f182897b = new a(this);
    }
}
