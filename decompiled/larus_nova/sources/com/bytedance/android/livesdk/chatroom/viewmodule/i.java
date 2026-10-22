package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class i<T extends Widget> implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f115264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f115265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f115266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetManager f115267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f115268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f115269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ValueAnimator f115270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ValueAnimator f115271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ObjectAnimator f115272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f115273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f115274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f115275l;

    public static final class a {
    }

    public interface b {
        void He(i<? extends Widget> r100);

        void Oa(i r100);
    }

    static {
    }

    public final View c() {
        return (View) this.f115264a.getValue();
    }

    public final void a() {
        if (this.f115269f == false) goto L5;
        return;
    L5:
        this.f115270g.cancel();
        this.f115272i.cancel();
        ((j) this).f115284p.reverseTransition((int) 300);
        j.f115280q = true;
        ValueAnimator r100 = this.f115270g;
        Intrinsics.checkNotNullParameter(r100, "animator");
        int[] r101 = new int[2];
        ViewGroup.LayoutParams r102 = this.f115266c.getLayoutParams();
        if (r102 == null) goto L10;
        r101[0] = ((ViewGroup.MarginLayoutParams) r102).bottomMargin;
        r101[1] = -this.f115266c.getHeight();
        r100.setIntValues(r101);
        this.f115270g.start();
        this.f115272i.reverse();
        this.f115269f = true;
        this.f115275l.Oa(this);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b() {
        if (this.f115269f == true) goto L5;
        return;
    L5:
        this.f115270g.cancel();
        this.f115272i.cancel();
        ((j) this).f115284p.startTransition((int) 300);
        j.f115280q = false;
        ValueAnimator r100 = this.f115271h;
        Intrinsics.checkNotNullParameter(r100, "animator");
        int[] r101 = new int[2];
        ViewGroup.LayoutParams r102 = this.f115266c.getLayoutParams();
        if (r102 == null) goto L10;
        r101[0] = ((ViewGroup.MarginLayoutParams) r102).bottomMargin;
        r101[1] = 0;
        r100.setIntValues(r101);
        this.f115271h.start();
        this.f115272i.start();
        this.f115269f = false;
        this.f115275l.Oa(this);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x0
    public final void hide() {
        if (this.f115268e == true) goto L5;
        return;
    L5:
        TransitionManager.beginDelayedTransition(this.f115273j, new AutoTransition());
        this.f115273j.setVisibility(8);
        this.f115268e = false;
        this.f115275l.He(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x0
    public final void show() {
        if (this.f115268e == false) goto L5;
        return;
    L5:
        TransitionManager.beginDelayedTransition(this.f115273j, new AutoTransition());
        this.f115273j.setVisibility(0);
        this.f115268e = true;
        this.f115275l.He(this);
    }

    public i(ViewGroup r100, b r110) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r110, "stateChangeListener");
        this.f115273j = r100;
        this.f115274k = R.id.regular_widget_container;
        this.f115275l = r110;
        this.f115264a = InfraKotlinExtsKt.mainThreadLazy(new BannerHolder$holderView$2(this));
        View r101 = c().findViewById(R.id.regular_widget_container);
        this.f115266c = r101;
        ValueAnimator r111 = new ValueAnimator();
        j r102 = (j) this;
        r111.addUpdateListener(new e(r102));
        r111.addListener(new f(r102));
        r111.setDuration(300);
        r111.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        Unit r103 = Unit.INSTANCE;
        this.f115270g = r111;
        ValueAnimator r112 = new ValueAnimator();
        r112.addUpdateListener(new g(r102));
        r112.addListener(new h(r102));
        r112.setDuration(300);
        r112.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.f115271h = r112;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f});
        r104.setDuration(300);
        r104.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.f115272i = r104;
    }
}
