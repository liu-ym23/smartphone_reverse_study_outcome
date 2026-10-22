package com.bytedance.android.live.broadcast.dialog;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PosterGenerateDialog f59109a;

    public b(PosterGenerateDialog r100) {
        this.f59109a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f59109a.f59105g = false;
        f2.c(s1.B(R.string.ttlive_appointment_save_success_toast), 0);
        return;
    L5:
        this.f59109a.f59105g = false;
        f2.c(s1.B(R.string.ttlive_appointment_save_fail_toast), 0);
    }
}
