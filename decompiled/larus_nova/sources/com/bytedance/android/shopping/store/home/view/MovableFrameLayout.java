package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.shopping.store.keva.ECStoreDefaultKevaRepo;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/MovableFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/store/home/view/MovableFrameLayout$b;", "moveListener", "", "setMoveListener", "", LiveDegradeFpsAnimator.TRANSLATION_X, "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_Y, "setTranslationY", "", "minTranslationX", "setMinTranslationX", "maxTranslationX", "setMaxTranslationX", "minTranslationY", "setMinTranslationY", "maxTranslationY", "setMaxTranslationY", "", ce.f26391f, "Z", "getQuitMove", "()Z", "setQuitMove", "(Z)V", "quitMove", "h", "getRecordPosition", "setRecordPosition", "recordPosition", RXScreenCaptureService.KEY_INDEX, "getNeedAdsorptionEdge", "setNeedAdsorptionEdge", "needAdsorptionEdge", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MovableFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f184630k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f184631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f184632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f184633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f184634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f184635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f184636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f184637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f184638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f184639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f184640j;

    public static final class a {
    }

    public interface b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MovableFrameLayout f184641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f184642b;

        public c(MovableFrameLayout r100, float r101) {
            this.f184641a = r100;
            this.f184642b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f184641a.setX(this.f184642b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MovableFrameLayout f184643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f184644b;

        public d(MovableFrameLayout r100, float r101) {
            this.f184643a = r100;
            this.f184644b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f184643a.setY(this.f184644b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MovableFrameLayout f184645a;

        public e(MovableFrameLayout r100) {
            this.f184645a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MovableFrameLayout.a(this.f184645a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MovableFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MovableFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setMoveListener(b r100) {
    }

    static {
        f184630k = ExtensionsKt.a(3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new w(this));
    }

    public final boolean getNeedAdsorptionEdge() {
        return this.f184639i;
    }

    public final boolean getQuitMove() {
        return this.f184637g;
    }

    public final boolean getRecordPosition() {
        return this.f184638h;
    }

    public static final void a(MovableFrameLayout r100) {
        int r101 = r100.getLeft();
        int r102 = r100.getTop();
        r100.setMinTranslationX(-r101);
        r100.setMinTranslationY(-r102);
        ViewParent r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
        r100.setMaxTranslationX((r104.getMeasuredWidth() - r101) - r100.getMeasuredWidth());
        r100.setMaxTranslationY((r104.getMeasuredHeight() - r102) - r100.getMeasuredHeight());
    L5:
        r100.d(0.0f, 0.0f);
    }

    private final void setMaxTranslationX(int r100) {
        this.f184632b = r100;
    }

    private final void setMaxTranslationY(int r100) {
        this.f184634d = r100;
    }

    private final void setMinTranslationX(int r100) {
        this.f184631a = r100;
    }

    private final void setMinTranslationY(int r100) {
        this.f184633c = r100;
    }

    public final void b(boolean r100) {
        Resources r101 = getContext().getResources();
        int r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
        if ((getX() + (getWidth() / 2)) > (r102 / 2)) goto L5;
        int r103 = 0;
    L6:
        float r104 = r103;
        if (r100 == false) goto L9;
        animate().x(r104).setDuration(300).withEndAction(new c(this, r104)).start();
    L10:
        float r105 = eh.b.b(getContext());
        if (getY() >= r105) goto L16;
        if (r100 == false) goto L14;
        animate().y(r105).setDuration(300).withEndAction(new d(this, r105)).start();
        return;
    L14:
        setY(r105);
        return;
    L16:
        return;
    L9:
        setX(r104);
        goto L10
    L5:
        r103 = r102 - getWidth();
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f184637g == true) goto L5;
        float r101 = r100.getRawX();
        float r102 = r100.getRawY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L10;
        this.f184635e = r101;
        this.f184636f = r102;
    L18:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r103 != 2) goto L18;
        if (this.f184640j == false) goto L14;
        return true;
    L14:
        if (c(this.f184635e, this.f184636f, r101, r102) == false) goto L18;
        return true;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f184637g == true) goto L5;
        float r101 = r100.getRawX();
        float r102 = r100.getRawY();
        int r103 = r100.getAction();
        if (r103 == 0) goto L29;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L15;
        if (r103 == 3) goto L21;
    L28:
        return super.onTouchEvent(r100);
    L15:
        if (this.f184640j == false) goto L17;
    L18:
        d(r101 - this.f184635e, r102 - this.f184636f);
        this.f184635e = r101;
        this.f184636f = r102;
        this.f184640j = true;
        return true;
    L17:
        if (c(this.f184635e, this.f184636f, r101, r102) == false) goto L28;
    L21:
        if (this.f184640j == false) goto L28;
        if (this.f184639i == false) goto L25;
        b(true);
    L25:
        this.f184640j = false;
        return true;
    L29:
        return true;
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setNeedAdsorptionEdge(boolean r100) {
        this.f184639i = r100;
    }

    public final void setQuitMove(boolean r100) {
        this.f184637g = r100;
    }

    public final void setRecordPosition(boolean r100) {
        this.f184638h = r100;
    }

    @Override // android.view.View
    public void setTranslationX(float r100) {
        super.setTranslationX(r100);
        Lazy r101 = ECStoreDefaultKevaRepo.f185423a;
        Intrinsics.checkNotNullParameter("live_icon_translation_x", "key");
        ((Keva) ECStoreDefaultKevaRepo.f185423a.getValue()).storeFloat("live_icon_translation_x", r100);
    }

    @Override // android.view.View
    public void setTranslationY(float r100) {
        super.setTranslationY(r100);
        Lazy r101 = ECStoreDefaultKevaRepo.f185423a;
        Intrinsics.checkNotNullParameter("live_icon_translation_y", "key");
        ((Keva) ECStoreDefaultKevaRepo.f185423a.getValue()).storeFloat("live_icon_translation_y", r100);
    }

    public final void d(float r100, float r110) {
        float r101 = getTranslationX();
        float r102 = getTranslationY();
        float r103 = (float) Math.max(this.f184631a, Math.min(r101 + r100, this.f184632b));
        float r111 = (float) Math.max(this.f184633c, Math.min(r102 + r110, this.f184634d));
        setTranslationX(r103);
        setTranslationY(r111);
    }

    public MovableFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f184638h = true;
        this.f184639i = true;
    }

    public /* synthetic */ MovableFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final boolean c(float r100, float r101, float r102, float r110) {
        float r103 = (float) Math.abs(r100 - r102);
        float r104 = (float) Math.abs(r101 - r110);
        if (Math.abs((float) Math.sqrt((r103 * r103) + (r104 * r104))) < f184630k) goto L24;
        float r105 = getTranslationX() + (r102 - r100);
        if (r105 >= this.f184631a) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == true) goto L20;
        float r107 = getTranslationY() + (r110 - r101);
        if (r107 >= this.f184633c) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L20;
        boolean r109 = false;
    L21:
        if (r109 == false) goto L25;
        return true;
    L25:
        return false;
    L14:
        if (r107 > this.f184634d) goto L16;
        r108 = true;
    L20:
        r109 = true;
        goto L21
    L7:
        if (r105 > this.f184632b) goto L9;
        r106 = true;
        goto L10
    L24:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        post(new e(this));
    }
}
