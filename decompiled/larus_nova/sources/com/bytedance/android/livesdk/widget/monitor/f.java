package com.bytedance.android.livesdk.widget.monitor;

import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.KVData;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f161856a;

    public f(l r100) {
        this.f161856a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        a r102 = this.f161856a.f161862a;
        if (r102 == null) goto L6;
        r102.c("P2_widget_loaded", null);
        return;
    }
}
