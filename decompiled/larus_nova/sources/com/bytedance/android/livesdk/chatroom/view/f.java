package com.bytedance.android.livesdk.chatroom.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.q6;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import nic.p;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f114744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleMediaView f114745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f114746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f114747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SharePanelPreviewProgressBar f114748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f114749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DouyinLoadingLayout f114750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f114751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PreviewType f114752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f114753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.view.c f114754k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f114755a;

        public b(f r100) {
            this.f114755a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f114755a;     // Catch: Throwable -> L14
            SimpleMediaView r101 = r100.f114745b;     // Catch: Throwable -> L14
            if (r101 == null) goto L7;
            c r102 = r100.f114753j;     // Catch: Throwable -> L14
            VideoContext r103 = r101.f455994e;     // Catch: Throwable -> L14
            if (r103 == null) goto L7;
            r103.D0(r102);     // Catch: Throwable -> L14
        L7:
            SimpleMediaView r104 = this.f114755a.f114745b;     // Catch: Throwable -> L14
            if (r104 == null) goto L10;
            r104.k();     // Catch: Throwable -> L14
        L10:
            View r105 = this.f114755a.f114747d;     // Catch: Throwable -> L14
            if (r105 == null) goto L17;
            UtilityKotlinExtentionsKt.t(r105);     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class c extends nic.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f114756a;

        public c(f r100) {
            this.f114756a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            this.f114756a.c(false);
        }

        @Override // nic.l.a, nic.h
        public final void b(oic.f r100, tic.a r101) {
            com.bytedance.android.livesdk.chatroom.view.c r102 = this.f114756a.f114754k;
            if (r102 == null) goto L6;
            r102.a();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void s(oic.f r100, tic.a r101) {
            com.bytedance.android.livesdk.chatroom.view.c r102 = this.f114756a.f114754k;
            if (r102 == null) goto L6;
            r102.onPause();
            return;
        }

        @Override // nic.l.a, nic.h
        public final void u(oic.f r100, tic.a r101) {
            this.f114756a.c(true);
        }

        @Override // nic.l.a, nic.h
        public final void q(oic.f r100, tic.a r101, int r102, int r103) {
            SharePanelPreviewProgressBar r104 = this.f114756a.f114748e;
            if (r104 == null) goto L6;
            if (r103 <= 0) goto L6;
            r104.f114729a = ((r102 * 1.0f) / r103) * 100;
            r104.invalidate();
        L6:
            TextView r105 = this.f114756a.f114749f;
            if (r105 == null) goto L10;
            r105.setText(q6.c(r102));
            return;
        }
    }

    static {
    }

    public f() {
        this(null);
    }

    public final void b() {
        SimpleMediaView r100 = this.f114745b;
        if (r100 == null) goto L5;
        r100.j();
    L5:
        View r101 = this.f114747d;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r101);
    L8:
        SimpleMediaView r102 = this.f114745b;
        if (r102 == null) goto L12;
        r102.p(this.f114753j);
        return;
    }

    public f(com.bytedance.android.livesdk.chatroom.view.c r100) {
        this.f114754k = r100;
        this.f114752i = PreviewType.UNKNOWN;
        this.f114753j = new c(this);
    }

    public final void a(boolean r100) {
        if (PadConfigUtils.c() == false) goto L7;
        SimpleMediaView r101 = this.f114745b;
        if (r101 == null) goto L7;
        VideoContext.n0(r101.getContext()).H0(e5.a());
    L7:
        com.bytedance.android.livesdk.chatroom.view.c r102 = this.f114754k;
        if (r102 == null) goto L10;
        r102.onPlay();
    L10:
        SimpleMediaView r103 = this.f114745b;
        if (r103 == null) goto L18;
        b r104 = new b(this);
        if (r100 == false) goto L15;
        long r105 = 0;
    L16:
        r103.postDelayed(r104, r105);
        return;
    L15:
        r105 = 200;
        goto L16
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L9;
        DouyinLoadingLayout r101 = this.f114750g;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r101);
    L6:
        DouyinLoadingLayout r102 = this.f114750g;
        if (r102 == null) goto L16;
        r102.b();
        return;
    L16:
        return;
    L9:
        DouyinLoadingLayout r103 = this.f114750g;
        if (r103 == null) goto L12;
        r103.c();
    L12:
        DouyinLoadingLayout r104 = this.f114750g;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }

    public final void d(PreviewType r100) {
        this.f114752i = r100;
        View r101 = this.f114744a;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r101);
    L5:
        int r102 = g.f114757a[r100.ordinal()];
        if (r102 != 1) goto L8;
        HSImageView r103 = this.f114746c;
        if (r103 == null) goto L47;
        UtilityKotlinExtentionsKt.w(r103);
    L47:
        ImageView r104 = this.f114751h;
        if (r104 == null) goto L50;
        UtilityKotlinExtentionsKt.w(r104);
    L50:
        SimpleMediaView r105 = this.f114745b;
        if (r105 == null) goto L53;
        UtilityKotlinExtentionsKt.t(r105);
    L53:
        View r106 = this.f114747d;
        if (r106 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r106);
    L56:
        SharePanelPreviewProgressBar r107 = this.f114748e;
        if (r107 == null) goto L59;
        UtilityKotlinExtentionsKt.t(r107);
    L59:
        c(false);
        return;
    L8:
        if (r102 != 2) goto L10;
        HSImageView r108 = this.f114746c;
        if (r108 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r108);
    L31:
        ImageView r109 = this.f114751h;
        if (r109 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r109);
    L34:
        SimpleMediaView r110 = this.f114745b;
        if (r110 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r110);
    L37:
        View r111 = this.f114747d;
        if (r111 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r111);
    L40:
        SharePanelPreviewProgressBar r112 = this.f114748e;
        if (r112 == null) goto L43;
        UtilityKotlinExtentionsKt.t(r112);
    L43:
        c(false);
        return;
    L10:
        if (r102 != 3) goto L63;
        SimpleMediaView r113 = this.f114745b;
        if (r113 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r113);
    L15:
        SharePanelPreviewProgressBar r114 = this.f114748e;
        if (r114 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r114);
    L18:
        HSImageView r115 = this.f114746c;
        if (r115 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r115);
    L21:
        ImageView r116 = this.f114751h;
        if (r116 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r116);
    L24:
        View r117 = this.f114747d;
        if (r117 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r117);
    L27:
        c(false);
        return;
    }
}
