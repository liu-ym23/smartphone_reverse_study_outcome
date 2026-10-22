package com.bytedance.android.livesdk;

import android.app.Dialog;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.IDialogListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f123390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f123391h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f123392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f123393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f123394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f123395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, WeakReference<Dialog>> f123396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, IDialogListener> f123397f;

    public static f d() {
        if (f123390g != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f123390g != null) goto L9;
        f123390g = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f123390g;
    }

    public static boolean e() {
        if (f123391h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a() {
        f123391h++;
        this.f123392a.postValue(Boolean.TRUE);
    }

    public final void f() {
        f123391h--;
        if (f123391h >= 0) goto L6;
        f123391h = 0;
    L6:
        if (f123391h != 0) goto L9;
        this.f123392a.postValue(Boolean.FALSE);
        return;
    }

    public f() {
        this.f123392a = new MutableLiveData();
        this.f123393b = new HashSet();
        this.f123394c = false;
        this.f123395d = false;
        this.f123396e = new HashMap();
        this.f123397f = new HashMap();
    }

    public final Dialog c(String r100) {
        WeakReference r101 = (WeakReference) ((HashMap) this.f123396e).get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return (Dialog) r101.get();
    }

    public final void g(String r100) {
        ((HashMap) this.f123396e).remove(r100);
    }

    public final void b(String r100, Dialog r101) {
        Map<String, WeakReference<Dialog>> r102 = this.f123396e;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, new WeakReference(r101));
        ((HashSet) this.f123393b).add(r100);
    }
}
