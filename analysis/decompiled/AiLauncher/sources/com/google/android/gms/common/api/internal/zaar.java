package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class zaar extends zac {
    private final WeakReference zaa;

    public zaar(C1659z c1659z) {
        this.zaa = new WeakReference(c1659z);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(zak zakVar) {
        C1659z c1659z = (C1659z) this.zaa.get();
        if (c1659z == null) {
            return;
        }
        C1659z.a(c1659z);
        new C1658y(this, c1659z, c1659z, zakVar);
        throw null;
    }
}
