package com.bytedance.android.livesdk.floatview.inner;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f125221b;

    public l(k r100) {
        this.f125220a = r100;
        this.f125221b = 6;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TextView r102 = this.f125220a.f125204l;
        if (r102 == null) goto L6;
        r102.setText(s1.C(R.string.ttlive_float_end_count_down, new Object[]{Long.valueOf((this.f125221b - r101.longValue()) - 1)}));
    L6:
        if (((this.f125221b - r101.longValue()) - 1) != 0) goto L11;
        com.bytedance.android.livesdk.floatview.e r103 = this.f125220a.f125214v;
        if (r103 == null) goto L12;
        r103.b();
        return;
    L12:
        return;
    }
}
