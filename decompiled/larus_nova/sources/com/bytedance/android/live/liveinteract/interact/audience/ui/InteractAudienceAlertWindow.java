package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.e;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b$\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/ui/InteractAudienceAlertWindow;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setAcceptClickListener", "setCloseListener", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "b", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "", "c", "Z", "getHasAnim", "()Z", "setHasAnim", "(Z)V", "hasAnim", "d", "isLoading", "setLoading", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "compositeDisposable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceAlertWindow extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f73983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBaseUser f73984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f73985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f73986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f73987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f73988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f73989g;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceAlertWindow f73990a;

        public a(InteractAudienceAlertWindow r100) {
            this.f73990a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L14;
            float r102 = ((Float) r101).floatValue();
            this.f73990a.setAlpha(r102);
            if (r102 != 0.0f) goto L15;
            ViewParent r103 = this.f73990a.getParent();
            if ((r103 instanceof ViewGroup) == true) goto L9;
            r103 = null;
        L9:
            ViewGroup r104 = (ViewGroup) r103;
            if (r104 == null) goto L16;
            r104.removeView(this.f73990a);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractAudienceAlertWindow f73991a;

        public b(InteractAudienceAlertWindow r100) {
            this.f73991a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ViewGroup.LayoutParams r101 = this.f73991a.getLayoutParams();
            if (r101 == null) goto L11;
            FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L9;
            r102.bottomMargin = ((Integer) r103).intValue();
            this.f73991a.setLayoutParams(r102);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void b() {
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        r100.addUpdateListener(new a(this));
        r100.setInterpolator(new e(0.0f, 0.0f, 0.58f, 1.0f));
        r100.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageUtil.loadGifImage((ImageView) a(R.id.border), this.f73987e, R.color.transparent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f73988f.clear();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.f73988f;
    }

    public final boolean getHasAnim() {
        return this.f73985c;
    }

    public final IBaseUser getUser() {
        return this.f73984b;
    }

    public InteractAudienceAlertWindow(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f73983a = new LinkedHashMap();
        this.f73987e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f73988f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_interact_audience_alert, this);
    }

    public final View a(int r100) {
        if (this.f73983a != null) goto L5;
        this.f73983a = new LinkedHashMap();
    L5:
        View r101 = this.f73983a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f73983a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void c(int r100) {
        if (getLayoutParams() != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L10;
        int r102 = ((FrameLayout.LayoutParams) r101).bottomMargin;
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r102, r102 + r100}).setDuration(300);
        r103.addUpdateListener(new b(this));
        r103.setInterpolator(new e(0.25f, 0.1f, 0.25f, 0.1f));
        r103.start();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void setAcceptClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f73989g = r100;
    }

    public final void setCloseListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ImageView) a(R.id.close)).setOnClickListener(r100);
    }

    public final void setCompositeDisposable(CompositeDisposable r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f73988f = r100;
    }

    public final void setHasAnim(boolean r100) {
        this.f73985c = r100;
    }

    public final void setLoading(boolean r100) {
        this.f73986d = r100;
    }

    public final void setUser(IBaseUser r100) {
        this.f73984b = r100;
    }

    public InteractAudienceAlertWindow(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f73983a = new LinkedHashMap();
        this.f73987e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f73988f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_interact_audience_alert, this);
    }

    public InteractAudienceAlertWindow(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f73983a = new LinkedHashMap();
        this.f73987e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f73988f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_interact_audience_alert, this);
    }
}
