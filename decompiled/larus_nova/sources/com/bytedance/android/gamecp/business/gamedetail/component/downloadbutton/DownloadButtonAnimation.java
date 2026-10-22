package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.business.gamedetail.component.GameCpViewWrapper;
import com.bytedance.android.gamecp.business.gamedetail.view.DetailDownLoadViewV2;
import com.bytedance.android.gamecp.common.utils.a1;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wu.r4;
import wu.s4;

/* JADX INFO: loaded from: classes44.dex */
public final class DownloadButtonAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f54246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f54247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a f54248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a f54249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a f54250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f54251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f54255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f54256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f54257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f54258m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final GameCpViewWrapper f54259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final GameCpViewWrapper f54260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DetailDownLoadViewV2 f54261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinearLayout f54262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f54263r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f54264s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f54265t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f54266u;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadButtonAnimation f54267a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(DownloadButtonAnimation r100) {
            this.f54267a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f54267a.f54257l;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadButtonAnimation f54268a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(DownloadButtonAnimation r100) {
            this.f54268a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f54268a.f54246a.set(false);
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadButtonAnimation f54269a;

        public d(DownloadButtonAnimation r100) {
            this.f54269a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            String r102 = null;
            if ((r101 instanceof Integer) == true) goto L5;
            r101 = null;
        L5:
            Integer r103 = (Integer) r101;
            TextView r104 = this.f54269a.f54264s;
            if (r104 == null) goto L15;
            if (r103 == null) goto L13;
            int r105 = r103.intValue();
            i r106 = this.f54269a.f54266u;
            if (r106 == null) goto L13;
            String r107 = r106.a();
            if (r107 == null) goto L13;
            r102 = r107.substring(0, r105);
        L13:
            r104.setText(r102);
            return;
        }
    }

    static {
    }

    public final void e() {
        int r100 = this.f54251f;
        if (r100 != 2) goto L5;
    L8:
        View r101 = this.f54258m;
        if (r101 == null) goto L13;
        if (r101.getVisibility() != 0) goto L13;
        return;
    L13:
        if (this.f54246a.get() == true) goto L32;
        View r102 = this.f54257l;
        if (r102 == null) goto L17;
        r102.setVisibility(8);
    L17:
        View r103 = this.f54258m;
        if (r103 == null) goto L20;
        r103.setVisibility(0);
    L20:
        GameCpViewWrapper r104 = this.f54259n;
        if (r104 == null) goto L23;
        r104.setTrueWeight(8.0f);
    L23:
        GameCpViewWrapper r105 = this.f54260o;
        if (r105 == null) goto L26;
        r105.setTrueWeight(3.0f);
    L26:
        DetailDownLoadViewV2 r106 = this.f54261p;
        if (r106 == null) goto L33;
        r106.setDownloadPauseText(R.string.game_detail_ttlive_download);
        return;
    L33:
        return;
    L32:
        return;
    L5:
        if (r100 == 6) goto L8;
        if (r100 == 10) goto L8;
    }

    public final void a(boolean r100, boolean r101) {
        if (this.f54252g == false) goto L5;
        return;
    L5:
        int r102 = this.f54251f;
        String r103 = null;
        if (r102 != 6) goto L31;
        LinearLayout r104 = this.f54262q;
        if (r104 == null) goto L10;
        r104.setVisibility(0);
    L10:
        LinearLayout r105 = this.f54263r;
        if (r105 == null) goto L13;
        r105.setVisibility(4);
    L13:
        if (r101 == true) goto L27;
        TextView r106 = this.f54265t;
        if (r106 == null) goto L27;
        i r107 = this.f54266u;
        if (r107 == null) goto L19;
        String r108 = r107.g();
    L21:
        if (TextUtils.isEmpty(r108) == true) goto L25;
        i r109 = this.f54266u;
        if (r109 == null) goto L26;
        r103 = r109.g();
    L26:
        r106.setText(r103);
        goto L27
    L25:
        r103 = y0.i(R.string.gamecp_play_the_same_game);
        goto L26
    L19:
        r108 = null;
    L27:
        TextView r110 = this.f54265t;
        if (r110 == null) goto L56;
        r110.setVisibility(0);
    L56:
        this.f54252g = true;
        return;
    L31:
        if (r102 != 10) goto L33;
    L34:
        if (r100 == false) goto L42;
        LinearLayout r111 = this.f54262q;
        if (r111 == null) goto L38;
        r111.setVisibility(0);
    L38:
        LinearLayout r112 = this.f54263r;
        if (r112 == null) goto L41;
        r112.setVisibility(4);
    L41:
        this.f54249d = null;
        goto L56
    L42:
        LinearLayout r113 = this.f54262q;
        if (r113 == null) goto L45;
        r113.setVisibility(4);
    L45:
        LinearLayout r114 = this.f54263r;
        if (r114 == null) goto L48;
        r114.setVisibility(0);
    L48:
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r115 = this.f54249d;
        LinearLayout r116 = this.f54263r;
        if (r116 == null) goto L56;
        if (this.f54262q == null) goto L56;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r116, View.ALPHA, new float[]{1.0f, 0.0f});
        r117.setDuration(300);
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.f54262q, View.TRANSLATION_X, new float[]{-20.0f, 0.0f});
        ObjectAnimator r119 = ObjectAnimator.ofFloat(this.f54262q, View.ALPHA, new float[]{0.0f, 1.0f});
        r118.setDuration(500);
        r119.setDuration(500);
        r118.addListener(new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.c(this));
        final AnimatorSet r120 = new AnimatorSet();
        r120.play(r117).before(r118).with(r119);
        if (r115 == null) goto L56;
        final long r121 = 1000;
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a.b(r115, null, r120, new DownloadButtonAnimation$setTextViewAnimation$2(this, r120, r121));
        goto L56
    L33:
        if (r102 != 18) goto L56;
        goto L34
    }

    public final void d(com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r100, final long r101) {
        i r102 = this.f54266u;
        if (r102 == null) goto L13;
        String r103 = r102.a();
        if (r103 == null) goto L13;
        i r104 = this.f54266u;
        if (r104 == null) goto L9;
        String r105 = r104.d();
    L11:
        if (r103.equals(r105) != true) goto L13;
        return;
    L9:
        r105 = null;
    L13:
        i r106 = this.f54266u;
        int r107 = 0;
        if (r106 == null) goto L18;
        String r108 = r106.a();
        if (r108 == null) goto L18;
        int r109 = r108.length();
    L19:
        i r110 = this.f54266u;
        if (r110 == null) goto L24;
        String r111 = r110.d();
        if (r111 == null) goto L24;
        int r112 = r111.length();
    L25:
        int r113 = Math.max(r109 - r112, 0);
        int[] r114 = new int[2];
        i r115 = this.f54266u;
        if (r115 == null) goto L30;
        String r116 = r115.d();
        if (r116 == null) goto L30;
        int r117 = r116.length();
    L31:
        r114[0] = r117;
        i r118 = this.f54266u;
        if (r118 == null) goto L36;
        String r119 = r118.a();
        if (r119 == null) goto L36;
        r107 = r119.length();
    L36:
        r114[1] = r107;
        final ValueAnimator r120 = ValueAnimator.ofInt(r114);
        r120.setStartDelay(200);
        r120.setDuration(((long) r113) * ((long) r4.f561382a.getValue().b()));
        r120.addUpdateListener(new d(this));
        if (r100 == null) goto L40;
        Function0<Unit> r121 = new DownloadButtonAnimation$setLeftButtonTextAnimation$2(this, r120, r101);
        r100.f54279b.add(null);
        r100.f54280c.add(null);
        ((ArrayList) r100.f54281d).add(r120);
        r100.f54278a.add(r121);
        return;
    L40:
        return;
    L30:
        r117 = 0;
    L24:
        r112 = 0;
    L18:
        r109 = 0;
        goto L19
    }

    public final void b(com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r110, final boolean r111, final long r112) {
        Set<String> r100 = a1.b().getStringSet("live.key.SP_CLOUD_BUTTON_HAS_EXECUTE_ANIMATION", SetsKt.emptySet());
        if (r100 == null) goto L6;
        Set r101 = CollectionsKt.toMutableSet(r100);
        if (r101 == null) goto L6;
    L7:
        final Set r102 = r101;
        if (r102.contains(this.f54255j) == false) goto L21;
        if (r111 == false) goto L21;
        return;
    L21:
        View r103 = this.f54257l;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L20
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r103, View.ALPHA, new float[]{1.0f, 0.0f});     // Catch: Throwable -> L20
        if (r113 == null) goto L14;
        r113.addListener(new b(this));     // Catch: Throwable -> L20
    L14:
        if (r113 == null) goto L16;
        r113.setDuration(600);     // Catch: Throwable -> L20
    L16:
        View r104 = this.f54258m;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L20
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, View.ALPHA, new float[]{1.0f, 1.0f});     // Catch: Throwable -> L20
        GameCpViewWrapper r106 = this.f54260o;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L20
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r106, "trueWeight", new float[]{3.0f});     // Catch: Throwable -> L20
        GameCpViewWrapper r108 = this.f54259n;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L20
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r108, "trueWeight", new float[]{8.0f});     // Catch: Throwable -> L20
        final AnimatorSet r114 = new AnimatorSet();     // Catch: Throwable -> L20
        r114.playTogether(new Animator[]{r105, r109, r107});     // Catch: Throwable -> L20
        r114.addListener(new c(this));     // Catch: Throwable -> L20
        r114.setDuration((long) r4.f561382a.getValue().c());     // Catch: Throwable -> L20
        if (r110 == null) goto L23;
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a.b(r110, r113, r114, new DownloadButtonAnimation$setLeftButtonAnimation$3(this, r114, r112, r111, r102));     // Catch: Throwable -> L20
        return;
    L23:
        return;
    L24:
        return;
    L6:
        r101 = new LinkedHashSet();
        goto L7
    }

    public static /* synthetic */ void c(DownloadButtonAnimation r100, com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.b(r101, r102, 0);
    }

    public DownloadButtonAnimation(String r100, boolean r101, boolean r102, View r103, View r104, GameCpViewWrapper r105, GameCpViewWrapper r106, DetailDownLoadViewV2 r107, LinearLayout r110, LinearLayout r111, TextView r112, TextView r113, TextView r114, i r115) {
        this.f54255j = r100;
        this.f54256k = r101;
        this.f54257l = r103;
        this.f54258m = r104;
        this.f54259n = r105;
        this.f54260o = r106;
        this.f54261p = r107;
        this.f54262q = r110;
        this.f54263r = r111;
        this.f54264s = r112;
        this.f54265t = r113;
        this.f54266u = r115;
        this.f54246a = new AtomicBoolean(false);
        this.f54247b = new Handler(Looper.getMainLooper());
        this.f54251f = 1;
        yr.b.b(3, "DownloadButtonAnimation", "init");
        if (r101 == false) goto L5;
        this.f54251f = 2;
    L7:
        if (r102 == false) goto L24;
        Integer r116 = s4.f561388a.getValue();
        if (r116 != null) goto L12;
    L14:
        if (r116 != null) goto L17;
    L19:
        if (r116 == null) goto L24;
        if (r116.intValue() != 3) goto L24;
        yr.b.b(3, "DownloadButtonAnimation", "同款实验3");
        this.f54251f |= 16;
        goto L24
    L17:
        if (r116.intValue() != 2) goto L19;
        yr.b.b(3, "DownloadButtonAnimation", "同款实验2");
        this.f54251f |= 8;
        goto L24
    L12:
        if (r116.intValue() != 1) goto L14;
        yr.b.b(3, "DownloadButtonAnimation", "同款实验1");
        this.f54251f |= 4;
    L24:
        String r108 = null;
        if (r101 == false) goto L37;
        if (r114 == null) goto L37;
        if (r115 == null) goto L29;
        String r109 = r115.b();
    L31:
        if (TextUtils.isEmpty(r109) == true) goto L35;
        if (r115 == null) goto L34;
        String r117 = r115.b();
    L36:
        r114.setText(r117);
        goto L37
    L34:
        r117 = null;
        goto L36
    L35:
        r117 = y0.i(R.string.gamecp_play_with_download);
        goto L36
    L29:
        r109 = null;
    L37:
        if (r102 == false) goto L50;
        if (r107 == null) goto L40;
        r107.setDownloadedTxt(R.string.ttlive_promote_list_download_finish);
    L40:
        if (r112 == null) goto L50;
        if (r115 == null) goto L43;
        String r118 = r115.d();
    L45:
        if (TextUtils.isEmpty(r118) == true) goto L48;
        if (r115 == null) goto L49;
        r108 = r115.d();
    L49:
        r112.setText(r108);
        goto L50
    L48:
        r108 = y0.i(R.string.gamecp_mini_game_instant_play);
        goto L49
    L43:
        r118 = null;
    L50:
        int r119 = this.f54251f;
        if (r119 != 2) goto L53;
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r120 = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        this.f54249d = r120;
        c(this, r120, false, 6);
        return;
    L53:
        if (r119 != 6) goto L58;
        if (r113 == null) goto L56;
        r113.setVisibility(4);
    L56:
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r121 = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        this.f54249d = r121;
        c(this, r121, false, 6);
        return;
    L58:
        if (r119 != 10) goto L67;
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r122 = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        this.f54248c = r122;
        c(this, r122, true, 4);
        this.f54249d = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r123 = this.f54248c;
        if (r123 == null) goto L65;
        List<Function0<Unit>> r124 = r123.f54278a;
        if (r124 == null) goto L65;
        if (r124.isEmpty() == true) goto L65;
        return;
    L65:
        c(this, this.f54249d, false, 6);
        d(this.f54249d, 0);
        return;
    L67:
        if (r119 != 18) goto L74;
        com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a r125 = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        this.f54248c = r125;
        r4 r126 = r4.f561382a;
        d(r125, (long) r126.getValue().a());
        b(this.f54248c, false, (long) r126.getValue().a());
        this.f54249d = new com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.a(0);
        return;
    L74:
        return;
    L5:
        this.f54251f = 1;
        goto L7
    }
}
