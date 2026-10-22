package com.bytedance.android.livesdk.record.admin;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f157072a;

    public d(boolean r100) {
        this.f157072a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (this.f157072a == true) goto L6;
        f2.b(R.string.ttlive_admin_record_tip_anchor_publish_failed, 0);
        ALogger.d("AdminRecordManager", "notifyItemOperation -> " + r101.getMessage());
        return;
    }
}
