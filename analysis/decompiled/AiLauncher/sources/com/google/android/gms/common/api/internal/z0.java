package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class z0 extends Fragment implements InterfaceC1642h {

    /* renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f19700d = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Map f19701a = Collections.synchronizedMap(new androidx.collection.a());

    /* renamed from: b, reason: collision with root package name */
    public int f19702b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f19703c;

    public static z0 e(Activity activity) {
        z0 z0Var;
        WeakHashMap weakHashMap = f19700d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (z0Var = (z0) weakReference.get()) != null) {
            return z0Var;
        }
        try {
            z0 z0Var2 = (z0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (z0Var2 == null || z0Var2.isRemoving()) {
                z0Var2 = new z0();
                activity.getFragmentManager().beginTransaction().add(z0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(z0Var2));
            return z0Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f19701a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f19701a.put(str, lifecycleCallback);
        if (this.f19702b > 0) {
            new x2.c(Looper.getMainLooper()).post(new y0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f19701a.get(str));
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final Activity i() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i10, i11, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19702b = 1;
        this.f19703c = bundle;
        for (Map.Entry entry : this.f19701a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f19702b = 5;
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f19702b = 3;
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f19701a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f19702b = 2;
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f19702b = 4;
        Iterator it = this.f19701a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
