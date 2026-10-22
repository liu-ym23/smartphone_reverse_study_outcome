package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.ak0;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.bytedance.android.livesdk.chatroom.broadcast.startlive.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f105549a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f105550a;

        public a(y r100) {
            this.f105550a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f105550a.f105549a.c(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.broadcast.startlive.a
    public final HSImageView Gb() {
        com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100 = this.f105549a.f105554d.e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (HSImageView) r100.e(R.id.stream_container_bg_cover);
    }

    @Override // com.bytedance.android.livesdk.chatroom.broadcast.startlive.a
    public final boolean Rt() {
        return this.f105549a.f105556f.f105509b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.broadcast.startlive.a
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        return this.f105549a.f105557g.getLiveStream();
    }

    @Override // com.bytedance.android.livesdk.chatroom.broadcast.startlive.a
    public final void restartLiveFragment() {
        this.f105549a.a();
        MainThreadPostUtils.b(new a(this));
        if (ak0.f119800a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f105549a.f105555e.a().f105428a == false) goto L9;
        ALogger.i("ttlive_anchor_merged_stream", "preview restart fragment");
        b0 r100 = this.f105549a.f105557g;
        r100.getClass();
        r100.c(new StreamUrlExtra(), "", "click_restart");
        return;
    }

    public y(z r100) {
        this.f105549a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.broadcast.startlive.a
    public final void dA(Map<String, String> r100) {
        com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r101 = this.f105549a.f105554d.e();
        if ((r101 instanceof com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L8;
        r101.f(r100);
        return;
    }
}
