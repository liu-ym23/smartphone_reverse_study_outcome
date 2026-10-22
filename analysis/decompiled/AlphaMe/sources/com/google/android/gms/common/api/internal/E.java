package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class E extends androidx.fragment.app.D implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Map f9625a = Collections.synchronizedMap(new q.f());

    /* renamed from: b, reason: collision with root package name */
    public int f9626b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f9627c;

    static {
        new WeakHashMap();
    }

    @Override // androidx.fragment.app.D
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // androidx.fragment.app.D
    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).b(i4, i5, intent);
        }
    }

    @Override // androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9626b = 1;
        this.f9627c = bundle;
        for (Map.Entry entry : this.f9625a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).c(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.D
    public final void onDestroy() {
        super.onDestroy();
        this.f9626b = 5;
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // androidx.fragment.app.D
    public final void onResume() {
        super.onResume();
        this.f9626b = 3;
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).d();
        }
    }

    @Override // androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f9625a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).e(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.D
    public final void onStart() {
        super.onStart();
        this.f9626b = 2;
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).f();
        }
    }

    @Override // androidx.fragment.app.D
    public final void onStop() {
        super.onStop();
        this.f9626b = 4;
        Iterator it = this.f9625a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }
}
