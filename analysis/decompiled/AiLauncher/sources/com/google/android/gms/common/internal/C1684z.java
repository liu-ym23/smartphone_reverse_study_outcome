package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* renamed from: com.google.android.gms.common.internal.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1684z {

    /* renamed from: a, reason: collision with root package name */
    public final SparseIntArray f19856a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.c f19857b;

    public C1684z(com.google.android.gms.common.c cVar) {
        C1669j.k(cVar);
        this.f19857b = cVar;
    }

    public final int a(Context context, int i10) {
        return this.f19856a.get(i10, -1);
    }

    @ResultIgnorabilityUnspecified
    public final int b(Context context, a.f fVar) throws PackageManager.NameNotFoundException {
        C1669j.k(context);
        C1669j.k(fVar);
        int iH = 0;
        if (!fVar.e()) {
            return 0;
        }
        int iL = fVar.l();
        int iA = a(context, iL);
        if (iA != -1) {
            return iA;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f19856a.size()) {
                iH = -1;
                break;
            }
            int iKeyAt = this.f19856a.keyAt(i10);
            if (iKeyAt > iL && this.f19856a.get(iKeyAt) == 0) {
                break;
            }
            i10++;
        }
        if (iH == -1) {
            iH = this.f19857b.h(context, iL);
        }
        this.f19856a.put(iL, iH);
        return iH;
    }

    public final void c() {
        this.f19856a.clear();
    }
}
