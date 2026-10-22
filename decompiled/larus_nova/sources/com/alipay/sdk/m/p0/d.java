package com.alipay.sdk.m.p0;

import android.database.ContentObserver;

/* JADX INFO: loaded from: classes28.dex */
public class d extends ContentObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25718d = "VMS_IDLG_SDK_Observer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f25721c;

    @Override // android.database.ContentObserver
    public void onChange(boolean r100) {
        c r101 = this.f25721c;
        if (r101 == null) goto L6;
        r101.a(this.f25720b, this.f25719a);
        return;
    }

    public d(c r100, int r101, String r102) {
        super(null);
        this.f25721c = r100;
        this.f25720b = r101;
        this.f25719a = r102;
    }
}
