package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class B0 extends Fragment implements InterfaceC1642h {

    /* renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f19516d = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Map f19517a = Collections.synchronizedMap(new androidx.collection.a());

    /* renamed from: b, reason: collision with root package name */
    public int f19518b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f19519c;

    public static B0 q(androidx.fragment.app.r rVar) {
        B0 b02;
        WeakHashMap weakHashMap = f19516d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(rVar);
        if (weakReference != null && (b02 = (B0) weakReference.get()) != null) {
            return b02;
        }
        try {
            B0 b03 = (B0) rVar.getSupportFragmentManager().l0("SupportLifecycleFragmentImpl");
            if (b03 == null || b03.isRemoving()) {
                b03 = new B0();
                rVar.getSupportFragmentManager().q().d(b03, "SupportLifecycleFragmentImpl").h();
            }
            weakHashMap.put(rVar, new WeakReference(b03));
            return b03;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f19517a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f19517a.put(str, lifecycleCallback);
        if (this.f19518b > 0) {
            new x2.c(Looper.getMainLooper()).post(new A0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f19517a.get(str));
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1642h
    public final /* synthetic */ Activity i() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i10, i11, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19518b = 1;
        this.f19519c = bundle;
        for (Map.Entry entry : this.f19517a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f19518b = 5;
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f19518b = 3;
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f19517a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f19518b = 2;
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f19518b = 4;
        Iterator it = this.f19517a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
