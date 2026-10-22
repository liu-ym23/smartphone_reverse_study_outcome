package com.bytedance.android.ec.hybrid.list.play;

import android.os.CountDownTimer;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f47238a;

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        cancel();
        if (this.f47238a.getAdapterPosition() >= 0) goto L5;
        return;
    L5:
        this.f47238a.D();
        this.f47238a.K();
    }

    public b(BaseViewHolder r100, long r101) {
        this.f47238a = r100;
        super(r101, 1000);
    }
}
