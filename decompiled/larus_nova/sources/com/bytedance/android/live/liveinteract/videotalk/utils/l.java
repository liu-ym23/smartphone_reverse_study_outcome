package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class l {

    public static final class a implements rj0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f79811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m00.g f79812b;

        @Override // rj0.a
        public final boolean a() {
            return true;
        }

        @Override // rj0.a
        public final boolean b() {
            return false;
        }

        @Override // rj0.a
        public final void c() {
        }

        @Override // rj0.a
        public final String getCancelText() {
            return "";
        }

        @Override // rj0.a
        public final vc0.a getSurfaceView() {
            m00.g r100 = this.f79812b;
            if (r100 != null) goto L7;
            return null;
        L7:
            return new vc0.a(r100);
        }

        @Override // rj0.a
        public final void onCancel() {
            j r100 = this.f79811a;
            if (r100 == null) goto L6;
            r100.onRefuse();
            return;
        }

        @Override // rj0.a
        public final void onConfirm() {
            j r100 = this.f79811a;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // rj0.a
        public final String getConfirmText() {
            return s1.B(R.string.ttlive_interact_beauty_start_video_talk);
        }

        public a(j r100, m00.g r101) {
            this.f79811a = r100;
            this.f79812b = r101;
        }
    }

    public static final void a(j r100) {
        rj0.l.f537955n2.getClass();
        rj0.l r101 = rj0.l.a.a();
        if (r101 == null) goto L5;
        m00.g r102 = r101.hh();
    L6:
        rj0.l r103 = rj0.l.a.a();
        if (r103 == null) goto L10;
        r103.So(1, new a(r100, r102), "link_invite", false);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
