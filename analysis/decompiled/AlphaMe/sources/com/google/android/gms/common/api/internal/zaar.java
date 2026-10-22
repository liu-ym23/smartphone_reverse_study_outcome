package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zaar extends zac {
    private final WeakReference zaa;

    public zaar(m mVar) {
        this.zaa = new WeakReference(mVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(zak zakVar) {
        B0.g.y(this.zaa.get());
    }
}
