package com.bytedance.android.livesdk.record.admin;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f157071a;

    public c(boolean r100) {
        this.f157071a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (this.f157071a == true) goto L6;
        f2.b(R.string.ttlive_admin_record_tip_anchor_publish_success, 0);
        return;
    }
}
