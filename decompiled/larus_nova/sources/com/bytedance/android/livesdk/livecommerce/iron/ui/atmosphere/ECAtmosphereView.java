package com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere;

import android.animation.Animator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/atmosphere/ECAtmosphereView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/atmosphere/ECAtmosphereView$b;", "atmosphereListener", "", "setListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAtmosphereView extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f148958k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f148959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Runnable> f148960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f148961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f148962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f148963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CountDownTimer f148964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f148965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPropertyAnimator f148966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECHotAtmosphereView f148967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECOtherAtmosphereView f148968j;

    public static final class a {
    }

    public interface b extends ECOtherAtmosphereView.b {
        void c();

        void d(ECAtmosphereItem r100);

        void e(ECHotAtmosphereView r100);
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECAtmosphereView f148969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f148970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f148971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f148972d;

        public static final class a extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f148973a;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.ECAtmosphereView$c$a$a, reason: collision with other inner class name */
            public static final class RunnableC2305a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f148974a;

                public RunnableC2305a(a r100) {
                    this.f148974a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c r100 = this.f148974a.f148973a;     // Catch: Throwable -> L4
                    ECAtmosphereView r101 = r100.f148969a;     // Catch: Throwable -> L4
                    View r102 = r100.f148970b;     // Catch: Throwable -> L4
                    int r103 = ECAtmosphereView.f148958k;     // Catch: Throwable -> L4
                    r101.c(r102, false, null);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            @Override // android.os.CountDownTimer
            public final void onTick(long r100) {
            }

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                dm.a.a("ECAtmosphereView").a("CountDownTimer onFinish");
                if (((ArrayList) this.f148973a.f148969a.f148960b).isEmpty() == false) goto L5;
                ECAtmosphereView r100 = this.f148973a.f148969a;
                r100.f148961c = new RunnableC2305a(this);
                return;
            L5:
                c r101 = this.f148973a;
                r101.f148969a.c(r101.f148970b, false, null);
            }

            public a(c r100, long r101, long r102) {
                this.f148973a = r100;
                super(r101, r102);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f148971c == false) goto L12;
            Long r101 = this.f148972d;
            if (r101 != null) goto L7;
        L11:
            this.f148969a.f148965g = true;
            return;
        L7:
            if (r101.longValue() <= 0) goto L11;
            ECAtmosphereView r102 = this.f148969a;
            r102.f148965g = false;
            r102.f148964f = new a(this, this.f148972d.longValue(), this.f148972d.longValue());
            CountDownTimer r103 = this.f148969a.f148964f;
            if (r103 == null) goto L14;
            r103.start();
            return;
        L14:
            return;
        L12:
            ECAtmosphereView r104 = this.f148969a;
            r104.f148962d = false;
            r104.d();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f148970b.setVisibility(0);
        }

        public c(ECAtmosphereView r100, View r101, boolean r102, Long r103) {
            this.f148969a = r100;
            this.f148970b = r101;
            this.f148971c = r102;
            this.f148972d = r103;
        }
    }

    static {
    }

    public ECAtmosphereView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECAtmosphereView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        if (this.f148962d == true) goto L5;
    L12:
        this.f148962d = true;
        Runnable r100 = (Runnable) CollectionsKt.removeFirstOrNull(this.f148960b);
        if (r100 == null) goto L17;
        r100.run();
        return;
    L17:
        return;
    L5:
        if (this.f148965g == true) goto L12;
        Runnable r101 = this.f148961c;
        if (r101 == null) goto L16;
        if (r101 == null) goto L10;
        r101.run();
    L10:
        this.f148961c = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ((ArrayList) this.f148959a).clear();
        ((ArrayList) this.f148960b).clear();
        this.f148961c = null;
        this.f148962d = false;
        CountDownTimer r100 = this.f148964f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f148964f = null;
        this.f148965g = false;
        ViewPropertyAnimator r101 = this.f148966h;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f148966h = null;
        ECHotAtmosphereView r102 = this.f148967i;
        r102.i();
        r102.setVisibility(8);
        r102.setAlpha(0.0f);
        ECOtherAtmosphereView r103 = this.f148968j;
        r103.setVisibility(8);
        r103.setAlpha(0.0f);
        super.onDetachedFromWindow();
    }

    public final void a(ECAtmosphere r100) {
        Intrinsics.checkNotNullParameter(r100, "atmospheres");
        if ((CollectionsKt.firstOrNull(this.f148959a) instanceof ECHotAtmosphere) == false) goto L5;
        return;
    L5:
        List<ECAtmosphereItem> r101 = r100.getAtmosphereItems();
        List<ECAtmosphereItem> r102 = r101;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        Iterator<T> r104 = r101.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        ECAtmosphereItem r105 = (ECAtmosphereItem) r104.next();
        List<Runnable> r106 = this.f148960b;
        ArrayList r107 = (ArrayList) r106;
        r107.add(new com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.a(this, r105));
        goto L16
    L18:
        ((ArrayList) this.f148959a).addAll(r102);
        d();
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void b(ECHotAtmosphere r100) {
        Intrinsics.checkNotNullParameter(r100, "hotAtmosphere");
        ((ArrayList) this.f148959a).clear();
        ((ArrayList) this.f148959a).add(r100);
        ((ArrayList) this.f148960b).clear();
        List<Runnable> r101 = this.f148960b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.b(this, r100));
        d();
    }

    public final void setListener(b r100) {
        this.f148963e = r100;
    }

    public ECAtmosphereView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148959a = new ArrayList();
        this.f148960b = new ArrayList();
        th.a.c(r100, R.layout.shopping_layout_ec_atmosphere, this, true);
        this.f148967i = (ECHotAtmosphereView) findViewById(R.id.hot_atmosphere);
        this.f148968j = (ECOtherAtmosphereView) findViewById(R.id.other_atmosphere);
    }

    public final void c(View r100, boolean r101, Long r102) {
        ViewPropertyAnimator r103 = r100.animate();
        if (r101 == false) goto L5;
        float r104 = 1.0f;
    L6:
        ViewPropertyAnimator r105 = r103.alpha(r104);
        r105.setListener(new c(this, r100, r101, r102));
        if (r101 == false) goto L9;
        long r106 = 240;
    L10:
        r105.setDuration(r106);
        r105.start();
        Unit r107 = Unit.INSTANCE;
        this.f148966h = r105;
        return;
    L9:
        r106 = 160;
        goto L10
    L5:
        r104 = 0.0f;
        goto L6
    }

    public /* synthetic */ ECAtmosphereView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
