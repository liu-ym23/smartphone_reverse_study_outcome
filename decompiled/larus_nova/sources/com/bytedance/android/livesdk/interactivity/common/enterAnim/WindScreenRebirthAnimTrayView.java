package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.o;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/WindScreenRebirthAnimTrayView;", "Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/BaseWindScreenAnimEnterTrayView;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "listener", "", "setOnSchemaHandleListener", "", "textSize", "setTextSize", "Landroid/animation/Animator;", ce.f26396k, "Landroid/animation/Animator;", "getDelegateReleaseAnimator", "()Landroid/animation/Animator;", "delegateReleaseAnimator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindScreenRebirthAnimTrayView extends BaseWindScreenAnimEnterTrayView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f136536l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f136537m = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f136538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f136539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f136540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f136541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f136542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RadiusHSImageView f136543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f136544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h3 f136545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.enteranim.utils.i f136546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f136547k;

    public static final class a {
    }

    public static final class b extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindScreenRebirthAnimTrayView f136548a;

        public b(WindScreenRebirthAnimTrayView r100) {
            this.f136548a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            if (r101 <= 0) goto L6;
            if (r102 <= 0) goto L7;
            ViewGroup.LayoutParams r103 = this.f136548a.f136540d.getLayoutParams();
            int r104 = WindScreenRebirthAnimTrayView.f136537m;
            r103.height = r104;
            r103.width = (r101 / r102) * r104;
            this.f136548a.f136540d.setLayoutParams(r103);
            return;
        L7:
            return;
        }
    }

    public static final class c extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindScreenRebirthAnimTrayView f136549a;

        public c(WindScreenRebirthAnimTrayView r100) {
            this.f136549a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            if (r101 <= 0) goto L6;
            if (r102 <= 0) goto L7;
            ViewGroup.LayoutParams r103 = this.f136549a.f136541e.getLayoutParams();
            int r104 = WindScreenRebirthAnimTrayView.f136537m;
            r103.height = r104;
            r103.width = (r101 / r102) * r104;
            this.f136549a.f136541e.setLayoutParams(r103);
            return;
        L7:
            return;
        }
    }

    public static final class d implements ak6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindScreenRebirthAnimTrayView f136550a;

        public d(WindScreenRebirthAnimTrayView r100) {
            this.f136550a = r100;
        }

        @Override // ak6.e
        public final void a(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            Intrinsics.checkNotNullParameter(r100, "rendResult");
        }

        @Override // ak6.e
        public final void b(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            this.f136550a.f136542f.setText(r100.f4074a);
        }
    }

    public static final class e extends Animator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindScreenRebirthAnimTrayView f136551a;

        @Override // android.animation.Animator
        public final long getDuration() {
            return 0;
        }

        @Override // android.animation.Animator
        public final long getStartDelay() {
            return 0;
        }

        @Override // android.animation.Animator
        public final boolean isRunning() {
            return false;
        }

        @Override // android.animation.Animator
        public final Animator setDuration(long r100) {
            return this;
        }

        @Override // android.animation.Animator
        public final void setInterpolator(TimeInterpolator r100) {
        }

        @Override // android.animation.Animator
        public final void setStartDelay(long r100) {
        }

        @Override // android.animation.Animator
        public final void cancel() {
            super.cancel();
            AnimatorSet r100 = this.f136551a.f136544h;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            this.f136551a.f136543g.setVisibility(8);
        }

        public e(WindScreenRebirthAnimTrayView r100) {
            this.f136551a = r100;
        }
    }

    public WindScreenRebirthAnimTrayView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WindScreenRebirthAnimTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void U5(int r100, int r101) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public void setTextSize(float r100) {
    }

    static {
        f136536l = s1.f(24.0f);
        f136537m = s1.f(16.0f);
    }

    public final Animator getDelegateReleaseAnimator() {
        return this.f136547k;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView
    public final void R5(k32.d r110) {
        List<py.k> r100 = null;
        if (r110 == null) goto L5;
        h3 r101 = r110.f501712t;
    L6:
        this.f136545i = r101;
        if (r101 == null) goto L18;
        List<py.k> r102 = r101.N();
        if (r102 == null) goto L18;
        if (r102.size() < 2) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        r100 = r102;
    L16:
        if (r100 == null) goto L18;
        py.k r104 = (py.k) ListProtector.get(r100, 0);
        py.k r105 = (py.k) ListProtector.get(r100, 1);
        ImageLoader.bindImage(this.f136540d, r104, null, -1, -1, null, new b(this), true);
        ImageLoader.bindImage(this.f136541e, r105, null, -1, -1, null, new c(this), true);
    L19:
        yb2.a r106 = w.a();
        r106.f567074m = 7;
        if (r110 == null) goto L35;
        h3 r107 = r110.f501712t;
        if (r107 == null) goto L36;
        com.bytedance.android.live.base.model.message.d r108 = r107.I0();
        if (r108 == null) goto L37;
        List<com.bytedance.android.live.base.model.message.f> r109 = r108.b();
        if (r109 == null) goto L38;
        com.bytedance.android.live.base.model.message.f r111 = (com.bytedance.android.live.base.model.message.f) ListProtector.get(r109, 0);
        if (r111 == null) goto L39;
        o6 r112 = r111.g();
        if (r112 == null) goto L40;
        a5 r113 = r112.a();
        if (r113 == null) goto L41;
        LiveRichContentEngine.a().a().c(mb2.d.a(r113, r106, 1.0f), new qb2.g(false, 0.0f, 7), new d(this));
        return;
    L41:
        return;
    L40:
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
    L13:
        r103 = false;
    L18:
        ALogger.e("WindScreenRebirthAnimTrayView", "icons list is empty!");
        goto L19
    L5:
        r101 = null;
        goto L6
    }

    public final void setOnSchemaHandleListener(final o r100) {
        h3 r101 = this.f136545i;
        if (r101 == null) goto L9;
        com.bytedance.android.live.base.model.message.d r102 = r101.I0();
        if (r102 == null) goto L9;
        m6 r103 = r102.c();
        if (r103 == null) goto L9;
        final String r104 = r103.a();
    L11:
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        setOnClickListener(x0.a(new AnonymousClass1(r104, r100)));
        return;
    L19:
        setOnClickListener(null);
        setClickable(false);
        return;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L9:
        r104 = null;
        goto L11
    }

    public WindScreenRebirthAnimTrayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.inflate(r100, R.layout.ttlive_wind_screen_rebirth_tray_view, this);
        this.f136538b = findViewById(R.id.root_container);
        this.f136539c = findViewById(R.id.nine_patch_container);
        this.f136540d = (HSImageView) findViewById(R.id.old_badge_view);
        this.f136541e = (HSImageView) findViewById(R.id.new_badge_view);
        this.f136542f = (TextView) findViewById(R.id.content_text);
        this.f136543g = (RadiusHSImageView) findViewById(R.id.swipe_effect);
        this.f136547k = new e(this);
    }

    public /* synthetic */ WindScreenRebirthAnimTrayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
