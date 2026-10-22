package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.internal.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1654u {

    /* renamed from: a, reason: collision with root package name */
    public final Map f19683a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Map f19684b = Collections.synchronizedMap(new WeakHashMap());

    public final void b(D2.j jVar, boolean z10) {
        this.f19684b.put(jVar, Boolean.valueOf(z10));
        jVar.a().b(new C1653t(this, jVar));
    }

    public final void c(int i10, String str) {
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        f(true, new Status(20, sb2.toString()));
    }

    public final void d() {
        f(false, C1640f.f19601p);
    }

    public final boolean e() {
        return (this.f19683a.isEmpty() && this.f19684b.isEmpty()) ? false : true;
    }

    public final void f(boolean z10, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f19683a) {
            map = new HashMap(this.f19683a);
        }
        synchronized (this.f19684b) {
            map2 = new HashMap(this.f19684b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((D2.j) entry2.getKey()).d(new ApiException(status));
            }
        }
    }
}
