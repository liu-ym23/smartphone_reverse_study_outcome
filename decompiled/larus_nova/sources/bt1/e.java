package bt1;

import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.coupon.expandcoupon.model.e f20526b;

    @Override // bt1.h
    public final void onFail() {
        com.bytedance.android.livesdk.coupon.util.a r100 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r101 = this.f20526b.d();
        r100.getClass();
        f2.c(LiveResUtil.getString(R.string.ttlive_expand_coupon_login_fail_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r101)}), 0);
    }

    @Override // bt1.h
    public final void onSuccess() {
        this.f20525a.t();
    }

    public e(b r100, com.bytedance.android.livesdk.coupon.expandcoupon.model.e r101) {
        this.f20525a = r100;
        this.f20526b = r101;
    }
}
