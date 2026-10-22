package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import android.os.Handler;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.d;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.k;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.f;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmakuCarnivalTrayManager.d f139744a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f139745a;

        public a(c r100) {
            this.f139745a = r100;
        }

        public final void a() {
            DanmakuMonitor.a("success");
            n22.a.f516688d = true;
            this.f139745a.f139744a.f139738a.getClass();
            DanmakuCarnivalTrayManager.m("Download Model Success");
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r100 = this.f139745a.f139744a.f139738a.f139713h;
            if (r100 == null) goto L32;
            m<Boolean> r101 = r100.isCarnivalStarted();
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.getValue().booleanValue() != true) goto L34;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r102 = this.f139745a.f139744a.f139738a.f139713h;
            if (r102 == null) goto L16;
            n<d> r103 = r102.getChatCarnivalMessage();
            if (r103 == null) goto L16;
            d r104 = r103.getValue();
            if (r104 == null) goto L16;
            if (r104.p() != 1) goto L16;
        L30:
            this.f139745a.f139744a.f139738a.k().b();
            return;
        L16:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.b r105 = this.f139745a.f139744a.f139738a.f139713h;
            if (r105 == null) goto L35;
            j<GeneralCarnivalDataSyncModel> r106 = r105.getGeneralCarnivalSyncModel();
            if (r106 == null) goto L36;
            GeneralCarnivalDataSyncModel r107 = r106.getValue();
            if (r107 == null) goto L37;
            dc2.c<k> r108 = r107.getCarnivalMessage();
            if (r108 == null) goto L38;
            k r109 = r108.c();
            if (r109 == null) goto L39;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.j r110 = r109.a();
            if (r110 != null) goto L29;
            return;
        L29:
            if (r110.q() == 1) goto L30;
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L34:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a
    public final void onFailure() {
        ((Handler) this.f139744a.f139738a.f139712g.getValue()).post(new b(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.utils.f.a
    public final void onSuccess() {
        ((Handler) this.f139744a.f139738a.f139712g.getValue()).post(new a(this));
    }

    public c(DanmakuCarnivalTrayManager.d r100) {
        this.f139744a = r100;
    }
}
