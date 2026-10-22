package com.bytedance.android.gamecp.common.ui;

import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f56986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f56987c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f56988a;

    public static f a() {
        if (f56986b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f56986b != null) goto L9;
        f56986b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f56986b;
    }

    public final void b() {
        f56987c--;
        if (f56987c >= 0) goto L6;
        f56987c = 0;
    L6:
        if (f56987c != 0) goto L9;
        this.f56988a.postValue(Boolean.FALSE);
        return;
    }

    public f() {
        this.f56988a = new MutableLiveData();
        new HashSet();
        new HashMap();
    }
}
