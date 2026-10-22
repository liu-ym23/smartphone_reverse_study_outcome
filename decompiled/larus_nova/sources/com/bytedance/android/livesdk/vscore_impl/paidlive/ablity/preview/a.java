package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a {
    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a
    public final String c() {
        return PaidSceneEnum.PAID_ROOM.name();
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a
    public final String d() {
        return PaidSceneViewEntry.FEED_PREVIEW.name();
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a, pu2.n
    public final void release() {
        Disposable r100 = this.f160126b;
        if (r100 != null) goto L5;
    L7:
        super.release();
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        a("paidlive_refresh_timer_end", "stop preview timer", null);
        goto L7
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.a
    public final void j(PaidSceneEnum r100) {
        Disposable r101 = this.f160126b;
        if (r101 != null) goto L5;
    L7:
        Disposable r102 = this.f160126b;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        this.f160126b = null;
        return;
    L5:
        if (r101.isDisposed() == true) goto L7;
        a("paidlive_refresh_timer_end", "stop preview timer", null);
        goto L7
    }
}
