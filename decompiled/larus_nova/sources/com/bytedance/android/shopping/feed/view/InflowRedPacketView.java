package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.event.y0;
import com.bytedance.android.shopping.feed.utils.InflowRedPacketTimer;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u000e\u0014\u0019\u001dB\u001d\b\u0007\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d¢\u0006\u0004\bf\u0010gR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\bR\u0017\u0010)\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u0017\u0010,\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u0017\u0010/\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001b\u00105\u001a\u000600R\u00020\u00008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u0010;\u001a\u000606R\u00020\u00008\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010A\u001a\u00060<R\u00020\u00008\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010U\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR\"\u0010Y\u001a\u00020J8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bV\u0010L\u001a\u0004\bW\u0010N\"\u0004\bX\u0010PR\"\u0010a\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006h"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getRedPacketNormal", "()Landroid/view/View;", "redPacketNormal", "b", "getRedPacketCollapsed", "redPacketCollapsed", "Lcom/bytedance/android/ec/core/widget/PriceView;", "c", "Lcom/bytedance/android/ec/core/widget/PriceView;", "getRedPacketAmount", "()Lcom/bytedance/android/ec/core/widget/PriceView;", "redPacketAmount", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getRedPacketCountDown", "()Landroid/widget/TextView;", "redPacketCountDown", "e", "getRedPacketCloseButton", "redPacketCloseButton", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "f", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "getCurrentState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;", "setCurrentState", "(Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$f;)V", "currentState", ce.f26391f, "getBottomViewBig", "bottomViewBig", "h", "getBottomTextViewBig", "bottomTextViewBig", RXScreenCaptureService.KEY_INDEX, "getBottomTextViewSmall", "bottomTextViewSmall", ce.f26395j, "getBottomCountDown", "bottomCountDown", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", ce.f26396k, "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", "getStartState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$e;", "startState", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "l", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "getNormalState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$d;", "normalState", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "m", "Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "getCollapsedState", "()Lcom/bytedance/android/shopping/feed/view/InflowRedPacketView$c;", "collapsedState", "", OfficeSDKRequestTag.KEY_NEW_USER, "Z", "getScrollStoped", "()Z", "setScrollStoped", "(Z)V", "scrollStoped", "", "o", "Ljava/lang/String;", "getAwemeid", "()Ljava/lang/String;", "setAwemeid", "(Ljava/lang/String;)V", "awemeid", "p", "getAmount", "setAmount", "amount", "q", "getExpired_minute", "setExpired_minute", "expired_minute", "", "r", "I", "getScrollStoppedTime", "()I", "setScrollStoppedTime", "(I)V", "scrollStoppedTime", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowRedPacketView extends FrameLayout implements l1.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f175524s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f175525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f175526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriceView f175527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f175528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f175529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f175530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f175531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f175532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f175533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f175534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f175535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f175536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f175537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f175538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f175539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f175540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f175541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f175542r;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InflowRedPacketView f175543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175544b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.view.InflowRedPacketView$a$a, reason: collision with other inner class name */
        public static final class CallableC2604a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Integer f175545a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f175546b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f175547c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f175548d;

            public CallableC2604a(Integer r100, Context r101, a r102) {
                this.f175545a = r100;
                this.f175546b = r101;
                this.f175547c = null;
                this.f175548d = r102;
            }

            @Override // java.util.concurrent.Callable
            public final com.bytedance.android.ec.core.event.a call() {
                y0 r100 = new y0("inflow_redpacket_close");
                r100.f174969a = this.f175548d.f175543a.getAwemeid();
                r100.f174970b = this.f175548d.f175543a.getAmount();
                r100.f174971c = this.f175548d.f175543a.getExpired_minute();
                Integer r101 = this.f175545a;
                if (r101 != null) goto L6;
            L8:
                if (r101 != null) goto L11;
            L13:
                r100.buildLogParams();
                com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
                r100.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
                return r100;
            L11:
                if (r101.intValue() != 0) goto L13;
                com.bytedance.android.shopping.feed.event.g.b(r100, this.f175546b);
                goto L13
            L6:
                if (r101.intValue() != 2) goto L8;
                com.bytedance.android.shopping.feed.event.g.a(r100, this.f175546b, this.f175547c);
                goto L13
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FeedProductEventTracker r101 = FeedProductEventTracker.f174442a;
            Single.fromCallable(new CallableC2604a(2, this.f175544b, this)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.f174853a, r0.f174856a);
            InflowRedPacketView r102 = this.f175543a;
            int r103 = InflowRedPacketView.f175524s;
            r102.getClass();
            ExtensionsKt.gone(r102);
        }

        public a(InflowRedPacketView r100, Context r101) {
            this.f175543a = r100;
            this.f175544b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InflowRedPacketView f175549a;

        @Override // java.lang.Runnable
        public final void run() {
            InflowRedPacketView r100 = this.f175549a;     // Catch: Throwable -> L4
            r100.a(r100.getNormalState());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(InflowRedPacketView r100) {
            this.f175549a = r100;
        }
    }

    public final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f175550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InflowRedPacketView f175551b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f175552a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if ((this.f175552a.f175551b.getCurrentState() instanceof d) == false) goto L9;
                ExtensionsKt.gone(this.f175552a.f175551b.getRedPacketCollapsed());     // Catch: Throwable -> L6
                return;
            }

            public a(c r100) {
                this.f175552a = r100;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r100) {
            Intrinsics.checkNotNullParameter(r100, "uiCountDown");
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r100 = new TranslateAnimation(0.0f, -this.f175550a, 0.0f, 0.0f);
            r100.setDuration(500);
            r100.setFillAfter(true);
            r100.setFillEnabled(true);
            this.f175551b.getRedPacketCollapsed().clearAnimation();
            this.f175551b.getRedPacketCloseButton().clearAnimation();
            this.f175551b.getRedPacketCollapsed().startAnimation(r100);
            this.f175551b.getRedPacketCloseButton().startAnimation(r100);
            new Handler().postDelayed(new a(this), 500);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            ExtensionsKt.visible(this.f175551b.getRedPacketCollapsed());
            wg.a.f(this.f175551b.getRedPacketCloseButton(), com.bytedance.android.shopping.extensions.b.b(3) + this.f175550a, 0, 0, 0);
            TranslateAnimation r100 = new TranslateAnimation(-this.f175550a, 0.0f, 0.0f, 0.0f);
            r100.setDuration(500);
            this.f175551b.getRedPacketCollapsed().clearAnimation();
            this.f175551b.getRedPacketCloseButton().clearAnimation();
            this.f175551b.getRedPacketCollapsed().startAnimation(r100);
            this.f175551b.getRedPacketCloseButton().startAnimation(r100);
        }

        public c(InflowRedPacketView r100) {
            this.f175551b = r100;
            this.f175550a = com.bytedance.android.shopping.extensions.b.b(28);
        }
    }

    public final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f175553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f175554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InflowRedPacketView f175555c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f175556a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if ((this.f175556a.f175555c.getCurrentState() instanceof c) == false) goto L9;
                ExtensionsKt.gone(this.f175556a.f175555c.getRedPacketNormal());     // Catch: Throwable -> L6
                return;
            }

            public a(d r100) {
                this.f175556a = r100;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r100 = new TranslateAnimation(0.0f, -this.f175553a, 0.0f, 0.0f);
            r100.setDuration(500);
            r100.setFillAfter(true);
            r100.setFillEnabled(true);
            this.f175555c.getRedPacketNormal().clearAnimation();
            this.f175555c.getRedPacketCloseButton().clearAnimation();
            this.f175555c.getRedPacketNormal().startAnimation(r100);
            this.f175555c.getRedPacketCloseButton().startAnimation(r100);
            new Handler().postDelayed(new a(this), 500);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            if ((this.f175555c.getCurrentState() instanceof c) == false) goto L5;
            ExtensionsKt.visible(this.f175555c.getRedPacketNormal());
            wg.a.f(this.f175555c.getRedPacketCloseButton(), com.bytedance.android.shopping.extensions.b.b(3) + this.f175553a, 0, 0, 0);
            TranslateAnimation r100 = new TranslateAnimation(-this.f175553a, 0.0f, 0.0f, 0.0f);
            r100.setDuration(500);
            this.f175555c.getRedPacketNormal().clearAnimation();
            this.f175555c.getRedPacketCloseButton().clearAnimation();
            this.f175555c.getRedPacketNormal().startAnimation(r100);
            this.f175555c.getRedPacketCloseButton().startAnimation(r100);
            return;
        L5:
            this.f175553a = this.f175555c.getRedPacketNormal().getMeasuredWidth() + this.f175554b;
        }

        public d(InflowRedPacketView r100) {
            this.f175555c = r100;
            this.f175554b = com.bytedance.android.shopping.extensions.b.b(10);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r100) {
            Intrinsics.checkNotNullParameter(r100, "uiCountDown");
            this.f175555c.getBottomCountDown().setText(r100.f45567c + ':' + r100.f45568d + ':' + r100.f45569e);
        }
    }

    public final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InflowRedPacketView f175557a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f175558a;

            @Override // java.lang.Runnable
            public final void run() {
                ExtensionsKt.gone(this.f175558a.f175557a.getRedPacketCountDown());     // Catch: Throwable -> L4
                ExtensionsKt.gone(this.f175558a.f175557a.getBottomTextViewSmall());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f175558a = r100;
            }
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void b() {
            TranslateAnimation r100 = new TranslateAnimation(0.0f, -20.0f, 0.0f, 0.0f);
            AlphaAnimation r101 = new AlphaAnimation(1.0f, 0.0f);
            r100.setDuration(500);
            r101.setDuration(500);
            AnimationSet r102 = new AnimationSet(true);
            r102.addAnimation(r100);
            r102.addAnimation(r101);
            r102.setFillAfter(true);
            r102.setFillEnabled(true);
            this.f175557a.getRedPacketCountDown().clearAnimation();
            this.f175557a.getRedPacketCountDown().startAnimation(r102);
            new Handler().postDelayed(new a(this), 500);
            ExtensionsKt.visible(this.f175557a.getBottomViewBig());
            AlphaAnimation r103 = new AlphaAnimation(0.0f, 1.0f);
            r103.setDuration(500);
            ScaleAnimation r104 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            r104.setDuration(500);
            AnimationSet r105 = new AnimationSet(true);
            r105.addAnimation(r103);
            r105.addAnimation(r104);
            this.f175557a.getBottomViewBig().clearAnimation();
            this.f175557a.getBottomViewBig().startAnimation(r105);
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void c() {
            Animation r100 = AnimationUtils.loadAnimation(this.f175557a.getContext(), R.anim.redpacket_enter);     // Catch: Exception -> L4
            this.f175557a.getRedPacketNormal().clearAnimation();     // Catch: Exception -> L4
            this.f175557a.getRedPacketNormal().startAnimation(r100);     // Catch: Exception -> L4
            TranslateAnimation r101 = new TranslateAnimation(-20.0f, 0.0f, 0.0f, 0.0f);     // Catch: Exception -> L4
            AlphaAnimation r102 = new AlphaAnimation(0.0f, 1.0f);     // Catch: Exception -> L4
            r101.setDuration(500);     // Catch: Exception -> L4
            r102.setDuration(500);     // Catch: Exception -> L4
            AnimationSet r103 = new AnimationSet(true);     // Catch: Exception -> L4
            r103.addAnimation(r101);     // Catch: Exception -> L4
            r103.addAnimation(r102);     // Catch: Exception -> L4
            this.f175557a.getRedPacketCountDown().clearAnimation();     // Catch: Exception -> L4
            this.f175557a.getRedPacketCountDown().startAnimation(r103);     // Catch: Exception -> L4
            return;
        }

        public e(InflowRedPacketView r100) {
            this.f175557a = r100;
        }

        @Override // com.bytedance.android.shopping.feed.view.InflowRedPacketView.f
        public final void a(c2 r100) {
            Intrinsics.checkNotNullParameter(r100, "uiCountDown");
            this.f175557a.getRedPacketCountDown().setText("仅剩 " + r100.f45567c + ':' + r100.f45568d + ':' + r100.f45569e);
        }
    }

    public interface f {
        void a(c2 r100);

        void b();

        void c();
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    public final String getAmount() {
        String r100 = this.f175540p;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("amount");
    L5:
        return r100;
    }

    public final String getAwemeid() {
        String r100 = this.f175539o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("awemeid");
    L5:
        return r100;
    }

    public final String getExpired_minute() {
        String r100 = this.f175541q;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("expired_minute");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = cf.e.f23490a;
        ULong.m9617boximpl(0);
        ULong.m9617boximpl(0);
        InflowRedPacketTimer r101 = (InflowRedPacketTimer) InflowRedPacketTimer.f175429b.getValue();
        l1 r102 = r101.f175430a;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        r101.f175430a = null;
    }

    public final TextView getBottomCountDown() {
        return this.f175534j;
    }

    public final TextView getBottomTextViewBig() {
        return this.f175532h;
    }

    public final TextView getBottomTextViewSmall() {
        return this.f175533i;
    }

    public final View getBottomViewBig() {
        return this.f175531g;
    }

    public final c getCollapsedState() {
        return this.f175537m;
    }

    public final f getCurrentState() {
        return this.f175530f;
    }

    public final d getNormalState() {
        return this.f175536l;
    }

    public final PriceView getRedPacketAmount() {
        return this.f175527c;
    }

    public final View getRedPacketCloseButton() {
        return this.f175529e;
    }

    public final View getRedPacketCollapsed() {
        return this.f175526b;
    }

    public final TextView getRedPacketCountDown() {
        return this.f175528d;
    }

    public final View getRedPacketNormal() {
        return this.f175525a;
    }

    public final boolean getScrollStoped() {
        return this.f175538n;
    }

    public final int getScrollStoppedTime() {
        return this.f175542r;
    }

    public final e getStartState() {
        return this.f175535k;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        ExtensionsKt.gone(this);
    }

    public InflowRedPacketView(Context r100) {
        this(r100, null);
    }

    public final void a(f r100) {
        if (Intrinsics.areEqual(r100, this.f175530f) == false) goto L5;
        return;
    L5:
        f r101 = this.f175530f;
        if (r101 == null) goto L8;
        r101.b();
    L8:
        if (r100 == null) goto L10;
        r100.c();
    L10:
        this.f175530f = r100;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        int r101 = c2.f45564h;
        c2 r102 = c2.a.a(getContext(), r100, false);
        f r103 = this.f175530f;
        if (r103 == null) goto L6;
        r103.a(r102);
    L6:
        if (this.f175538n == true) goto L8;
        this.f175542r = 0;
        return;
    L8:
        if (this.f175542r >= 1) goto L10;
    L12:
        this.f175542r++;
        return;
    L10:
        if ((this.f175530f instanceof c) == false) goto L12;
        a(this.f175536l);
        this.f175542r = -1;
        goto L12
    }

    public final void setAmount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f175540p = r100;
    }

    public final void setAwemeid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f175539o = r100;
    }

    public final void setCurrentState(f r100) {
        this.f175530f = r100;
    }

    public final void setExpired_minute(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f175541q = r100;
    }

    public final void setScrollStoped(boolean r100) {
        this.f175538n = r100;
    }

    public final void setScrollStoppedTime(int r100) {
        this.f175542r = r100;
    }

    public InflowRedPacketView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        e r102 = new e(this);
        this.f175535k = r102;
        this.f175536l = new d(this);
        this.f175537m = new c(this);
        this.f175538n = true;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_redpackect_layout, this, true);
        PriceView r103 = (PriceView) findViewById(R.id.redPacketAmount);
        this.f175527c = r103;
        this.f175528d = (TextView) findViewById(R.id.redPacketCountDown);
        this.f175525a = findViewById(R.id.redPacketNormal);
        this.f175526b = findViewById(R.id.redPacketCollapsed);
        View r104 = findViewById(R.id.redPacketCloseButton);
        this.f175529e = r104;
        this.f175531g = findViewById(R.id.redPacketBottomViewBig);
        TextView r105 = (TextView) findViewById(R.id.redPacketBottomTextViewBig);
        this.f175532h = r105;
        TextView r106 = (TextView) findViewById(R.id.redPacketBottomTextViewSmall);
        this.f175533i = r106;
        this.f175534j = (TextView) findViewById(R.id.redPacketBottomCountdown);
        Typeface r107 = IECHostService.a.a(com.bytedance.android.ec.sdk.helper.d.f48119b, r100);
        if (r107 != null) goto L5;
        r107 = Typeface.DEFAULT;
    L5:
        r106.setTypeface(r107);
        r105.setTypeface(r107);
        r104.setOnClickListener(new a(this, r100));
        r103.C(AnonymousClass3.INSTANCE);
        a(r102);
        new Handler().postDelayed(new b(this), 2000);
    }
}
