package com.bytedance.android.live.cloudgrouplive.core;

import a40.m;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.cloudgrouplive.rtc.CloudGroupLiveRTCManager;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.d3;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import e40.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CloudGroupLiveManager f64448a;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f64449a = null;

        static {
            f64449a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    public c(CloudGroupLiveManager r100) {
        this.f64448a = r100;
    }

    @Override // a40.m
    public final void b3(long r100) {
        ALogger.i("CloudGroupLiveManager", "joinCloudGroupLive success duration " + r100);
        d r101 = this.f64448a.f64436l;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter("success", "<set-?>");
        r101.f64456g = "success";
    L5:
        d r102 = this.f64448a.f64436l;
        if (r102 == null) goto L8;
        r102.f64457h = r100;
    L8:
        if (r102 == null) goto L10;
        Intrinsics.checkNotNullParameter("success", "<set-?>");
        r102.f64454e = "success";
    L10:
        d r103 = this.f64448a.f64436l;
        if (r103 == null) goto L13;
        r103.f64455f = System.currentTimeMillis() - this.f64448a.f64439o;
    L13:
        d r104 = this.f64448a.f64436l;
        if (r104 == null) goto L16;
        int r110 = f40.a.f475503a;
        f40.a.c(r104);
    L16:
        this.f64448a.g(CloudGroupLivePipelineStatus.START);
        CloudGroupLiveManager r105 = this.f64448a;
        d40.a r106 = r105.f64434j;
        long r107 = 0;
        if (r106 == null) goto L25;
        d3 r108 = r105.f64435k;
        if (r108 == null) goto L23;
        Long r109 = r108.E();
        if (r109 == null) goto L23;
        long r111 = r109.longValue();
    L24:
        r106.a(r111, this.f64448a.d(), "join_success");
    L23:
        r111 = 0;
    L25:
        f r112 = this.f64448a.f64431g;
        if (r112 == null) goto L28;
        ALogger.i("CloudGroupLiveWindowManager", "receive showView");
        int r113 = f40.a.f475503a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "showView", 0, null, 28);
        r112.c(0);
        r112.b(140);
    L28:
        xs2.b r114 = xs2.b.a();
        d3 r115 = this.f64448a.f64435k;
        if (r115 == null) goto L33;
        Long r116 = r115.E();
        if (r116 == null) goto L33;
        r107 = r116.longValue();
    L33:
        d3 r117 = this.f64448a.f64435k;
        if (r117 == null) goto L37;
        IBaseUser r118 = r117.getFromUser();
        if (r118 == null) goto L37;
    L38:
        r114.post(new dh1.b(1, new dh1.a(r107, r118, null)));
        x0.b r119 = new x0.b(this.f64448a.getContext(), 4);
        r119.m(R.string.ttlive_cloud_group_link_success_dialog_title);
        r119.l(R.string.ttlive_cloud_group_link_success_dialog_message);
        r119.i(0, R.string.ttlive_cloud_group_live_success_dialog_confirm, a.f64449a);
        r119.k(0, true);
        r119.n();
        return;
    L37:
        r118 = new User();
        goto L38
    }

    @Override // a40.m
    public final void a3(long r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ALogger.i("CloudGroupLiveManager", "joinCloudGroupLive failed duration " + r100 + " error " + r101);
        d r102 = this.f64448a.f64436l;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r101.getMessage());
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f64456g = r103;
    L5:
        d r104 = this.f64448a.f64436l;
        if (r104 == null) goto L8;
        r104.f64457h = r100;
    L8:
        if (r104 == null) goto L10;
        int r105 = f40.a.f475503a;
        f40.a.c(r104);
    L10:
        this.f64448a.g(CloudGroupLivePipelineStatus.END);
        CloudGroupLiveRTCManager r106 = this.f64448a.f64429e;
        if (r106 == null) goto L14;
        r106.f("join_api_failed");
        return;
    }
}
