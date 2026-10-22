package com.bytedance.android.live.wallet.platform.business.verify;

import android.content.DialogInterface;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f102742a;

    public class a implements com.bytedance.android.livesdk.revenue.service.network.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f102743a;

        @Override // com.bytedance.android.livesdk.revenue.service.network.b
        public final void a() {
            s r100 = this.f102743a.f102742a;
            r100.f102745a.onSuccess(r100.f102747c);
        }

        @Override // com.bytedance.android.livesdk.revenue.service.network.b
        public final void b() {
            s r100 = this.f102743a.f102742a;
            r100.f102745a.onSuccess(r100.f102747c);
        }

        @Override // com.bytedance.android.livesdk.revenue.service.network.b
        public final void onVerifySuccess() {
            s r100 = this.f102743a.f102742a;
            r100.f102745a.onSuccess(r100.f102747c);
        }

        public a(o r100) {
            this.f102743a = r100;
        }
    }

    public o(s r100) {
        this.f102742a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r110, int r111) {
        r110.dismiss();
        HashMap r112 = new HashMap();
        r112.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "2");
        ed1.a.a("livesdk_real_name_unfinished_remind_toast_click", r112);
        ((com.bytedance.android.livesdk.revenue.service.network.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.network.a.class)).Pf(this.f102742a.f102748d, 42201, "", new a(this), "wallet_withdraw", "webcast_common", "", null, false);
    }
}
