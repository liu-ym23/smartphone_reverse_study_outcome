package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.io.InterruptedIOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final CacheStrategy DEFAULT_CACHE_STRATEGY = null;
    private static final String TAG = "LAViewInterTAG";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private int buildDrawingCacheDepth;
    private LottieComposition composition;
    private LottieTask compositionTask;
    private CacheStrategy defaultCacheStrategy;
    private boolean disableOptInit;
    private final LottieListener<Throwable> failureListener;
    private boolean forceMarkViewShown;
    private boolean hasSetUseHardwareLayer;
    private boolean isAssetLazyLoadEnable;
    private boolean isInitialized;
    private k0.c<?, LottieTask<LottieComposition>> lazyRes;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private final Set<j> lottieOnCompositionLoadedListeners;
    private final t0.a mIDCard;
    private final Runnable playAction;
    private boolean playActionInQueue;
    private boolean playAnimationWhenDrawableNotThisLottie;
    private boolean playAnimationWhenShown;
    private RenderMode renderMode;
    private int reportTime;
    private boolean resumeAnimationWhenDrawableNotThisLottie;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;

    public static final enum CacheStrategy extends Enum<CacheStrategy> {
        public static final CacheStrategy None = null;
        public static final CacheStrategy Strong = null;
        public static final CacheStrategy Weak = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheStrategy[] f24675a = null;

        static {
            CacheStrategy r100 = new CacheStrategy("None", 0);
            None = r100;
            CacheStrategy r101 = new CacheStrategy("Weak", 1);
            Weak = r101;
            CacheStrategy r102 = new CacheStrategy("Strong", 2);
            Strong = r102;
            f24675a = new CacheStrategy[]{r100, r101, r102};
        }

        public static CacheStrategy[] values() {
            return (CacheStrategy[]) f24675a.clone();
        }

        public static CacheStrategy valueOf(String r100) {
            return (CacheStrategy) r27.a.a(CacheStrategy.class, r100);
        }

        public CacheStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f24678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f24680e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f24681f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f24682g;

        public static class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f24676a = r100.readString();
            this.f24678c = r100.readFloat();
            boolean r101 = true;
            if (r100.readInt() == 1) goto L6;
            r101 = false;
        L6:
            this.f24679d = r101;
            this.f24680e = r100.readString();
            this.f24681f = r100.readInt();
            this.f24682g = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeString(this.f24676a);
            r100.writeFloat(this.f24678c);
            r100.writeInt(this.f24679d ? 1 : 0);
            r100.writeString(this.f24680e);
            r100.writeInt(this.f24681f);
            r100.writeInt(this.f24682g);
        }
    }

    public class a implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f24683a;

        public a(LottieAnimationView r100) {
            this.f24683a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(LottieComposition r100) {
            LottieAnimationView r101 = this.f24683a;
            r101.setComposition(r100);
        }
    }

    public class b implements LottieListener<Throwable> {
        public b() {
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Throwable r100) {
            Throwable r101 = r100;
            if (r0.c.a.f535397a == false) goto L23;
            u0.f.a r102 = u0.f.f548112a;
            if ((r101 instanceof SocketException) == false) goto L7;
        L20:
            boolean r103 = true;
        L21:
            if (r103 == false) goto L23;
            return;
        L7:
            if ((r101 instanceof ClosedChannelException) == true) goto L20;
            if ((r101 instanceof InterruptedIOException) == true) goto L20;
            if ((r101 instanceof ProtocolException) == true) goto L20;
            if ((r101 instanceof SSLException) == true) goto L20;
            if ((r101 instanceof UnknownHostException) == true) goto L20;
            if ((r101 instanceof UnknownServiceException) == true) goto L20;
            r103 = false;
        L23:
            i r104 = i.a();
            new IllegalStateException("Unable to parse composition", r101);
            LottieCompositionFactory.getCurCacheList();
            r104.getClass();
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class c implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24684a;

        public c(String r100) {
            this.f24684a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(LottieComposition r100) {
            m0.g r101 = m0.g.f511472b;
            String r102 = this.f24684a;
            r101.b(r102, r100);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class d implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24685a;

        public d(String r100) {
            this.f24685a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(LottieComposition r100) {
            m0.g r101 = m0.g.f511472b;
            String r102 = this.f24685a;
            r101.b(r102, r100);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: loaded from: classes28.dex */
    public class e<T> extends v0.c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v0.e f24686c;

        public e(v0.e r100) {
            this.f24686c = r100;
        }

        @Override // v0.c
        public final T a(v0.b<T> r100) {
            return (T) this.f24686c.a(r100);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f24687a;

        public final void a() {
            if (this.f24687a.isShown() == false) goto L11;
            LottieAnimationView.access$102(this.f24687a, true);
            if (LottieAnimationView.access$200(this.f24687a) == false) goto L8;
            this.f24687a.playAnimation();
        L10:
            LottieAnimationView.access$102(this.f24687a, false);
            goto L11
        L8:
            if (LottieAnimationView.access$300(this.f24687a) == false) goto L10;
            this.f24687a.resumeAnimation();
        L11:
            LottieAnimationView.access$402(this.f24687a, false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(LottieAnimationView r100) {
            this.f24687a = r100;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class g implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24688a;

        public g(String r100) {
            this.f24688a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(LottieComposition r100) {
            m0.g r101 = m0.g.f511472b;
            String r102 = this.f24688a;
            r101.b(r102, r100);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24689a = null;

        static {
            int[] r100 = new int[RenderMode.values().length];
            f24689a = r100;
            r100[RenderMode.HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f24689a[RenderMode.SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f24689a[RenderMode.AUTOMATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        this.playAnimationWhenDrawableNotThisLottie = false;
        removePlayActon();
        this.lottieDrawable.c();
        enableOrDisableHardwareLayer();
    }

    public void cancelAsyncDrawWork() {
    }

    public void clearComposition() {
        this.composition = null;
        LottieDrawable r100 = this.lottieDrawable;
        u0.c r101 = r100.f24726c;
        if (r101.f548108k == false) goto L5;
        r101.cancel();
    L5:
        r100.f24725b = null;
        r100.f24738o = null;
        r100.f24732i = null;
        u0.c r102 = r100.f24726c;
        r102.f548107j = null;
        r102.f548105h = -2.1474836E9f;
        r102.f548106i = 2.1474836E9f;
        r100.invalidateSelf();
    }

    public void disableOptInit() {
        this.disableOptInit = true;
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        this.playAnimationWhenDrawableNotThisLottie = false;
        removePlayActon();
        LottieDrawable r100 = this.lottieDrawable;
        r100.getClass();
        int r101 = r0.c.f535396a;
        r100.f24728e.clear();
        r100.f24726c.g(true);
        enableOrDisableHardwareLayer();
    }

    public void setDrawFpsTracerOutputListener(r0.a r100) {
    }

    public void startDrawFpsTracer() {
    }

    public void stopDrawFpsTracer() {
    }

    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    static {
        DEFAULT_CACHE_STRATEGY = CacheStrategy.Weak;
    }

    private void cancelLoaderTask() {
        LottieTask r100 = this.compositionTask;
        if (r100 == null) goto L8;
        r100.removeListener(this.loadedListener);
        this.compositionTask.removeFailureListener(this.failureListener);
        if (this.isAssetLazyLoadEnable == false) goto L9;
        this.compositionTask = null;
        this.lazyRes = null;
        return;
    L9:
        return;
    }

    private void enableOrDisableHardwareLayer() {
        boolean r100 = false;
        int r101 = 2;
        if (r0.c.a.f535397a == false) goto L26;
        if (this.hasSetUseHardwareLayer == true) goto L26;
        if (r0.c.a.f535399c == false) goto L26;
        int r102 = h.f24689a[this.renderMode.ordinal()];     // Catch: Throwable -> L36
        if (r102 == 1) goto L22;
        if (r102 != 2) goto L12;
    L20:
        r101 = 1;
        goto L22
    L12:
        if (r102 != 3) goto L20;
        if (Build.VERSION.SDK_INT < 26) goto L18;
        r100 = true;
    L18:
        if (r100 == false) goto L20;
    L22:
        if (r101 == getLayerType()) goto L38;
        setLayerType(r101, null);     // Catch: Throwable -> L36
        return;
    L38:
        return;
    L26:
        if (this.useHardwareLayer == true) goto L28;
    L30:
        boolean r103 = r0.c.a.f535397a;     // Catch: Throwable -> L36
        if (r100 == true) goto L34;
        r101 = 1;
    L34:
        setLayerType(r101, null);     // Catch: Throwable -> L36
        return;
    L28:
        if (this.lottieDrawable.h() == false) goto L30;
        r100 = true;
        goto L30
    }

    private void ensureAssetLoad() {
        if (this.isAssetLazyLoadEnable == true) goto L6;
        return;
    L6:
        if (this.composition == null) goto L8;
        return;
    L8:
        if (this.compositionTask != null) goto L18;
        k0.c<?, LottieTask<LottieComposition>> r100 = this.lazyRes;
        if (r100 == null) goto L19;
        int r101 = r0.c.f535396a;
        String r102 = r100.a();
        LottieComposition r103 = m0.g.f511472b.a(r102);
        if (r103 == null) goto L15;
        this.lazyRes = null;
        setComposition(r103);
        return;
    L15:
        this.compositionTask = this.lazyRes.b(getContext()).addListener(new g(r102)).addListener(this.loadedListener).addFailureListener(this.failureListener);
        this.lazyRes = null;
        return;
    L19:
        return;
    }

    private boolean isAssetLazyLoadEnable() {
        if (this.isAssetLazyLoadEnable == true) goto L6;
        return false;
    L6:
        if (this.isInitialized == true) goto L8;
    L13:
        return true;
    L8:
        if (isLottieAttachedToWindow() == false) goto L13;
        if (this.forceMarkViewShown == false) goto L12;
        return false;
    L12:
        if (isShown() == false) goto L13;
        return false;
    }

    private void postPlayAction() {
        post(this.playAction);
    }

    private void removePlayActon() {
        removeCallbacks(this.playAction);
    }

    public void disableAsyncDraw() {
        this.lottieDrawable.getClass();
        this.mIDCard.getClass();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.f24731h = false;
    }

    public void disableRecycleBitmap() {
        LottieComposition r100 = this.composition;
        if (r100 == null) goto L6;
        r100.getNM();
    L6:
        this.lottieDrawable.hashCode();
        i.a().getClass();
        disableAsyncDraw();
    }

    public long getDuration() {
        LottieComposition r100 = this.composition;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return (long) r100.getDuration();
    }

    public int getFrame() {
        return (int) this.lottieDrawable.f24726c.f548103f;
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.f24733j;
    }

    public float getMaxFrame() {
        return this.lottieDrawable.f24726c.d();
    }

    public float getMinFrame() {
        return this.lottieDrawable.f24726c.e();
    }

    public n getPerformanceTracker() {
        LottieComposition r100 = this.lottieDrawable.f24725b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPerformanceTracker();
    }

    public float getProgress() {
        return this.lottieDrawable.f24726c.c();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.f24726c.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.f24726c.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.f24727d;
    }

    public float getSpeed() {
        return this.lottieDrawable.f24726c.f548100c;
    }

    public boolean hasMasks() {
        com.airbnb.lottie.model.layer.b r100 = this.lottieDrawable.f24738o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.t() == false) goto L7;
        return true;
    }

    public boolean hasMatte() {
        com.airbnb.lottie.model.layer.b r100 = this.lottieDrawable.f24738o;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.A == null) goto L7;
    L23:
        boolean r101 = r100.A.booleanValue();
    L24:
        if (r101 == false) goto L30;
        return true;
    L30:
        return false;
    L7:
        if (r100.f24903q == null) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r100.A = Boolean.TRUE;
    L20:
        r101 = true;
        goto L24
    L12:
        int r103 = ((ArrayList) r100.f24912x).size() - 1;
    L13:
        if (r103 < 0) goto L22;
        if (((com.airbnb.lottie.model.layer.a) ListProtector.get(r100.f24912x, r103)).f24903q == null) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L19;
        r103 = r103 - 1;
        goto L13
    L19:
        r100.A = Boolean.TRUE;
        goto L20
    L17:
        r104 = false;
        goto L18
    L22:
        r100.A = Boolean.FALSE;
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public boolean isAnimating() {
        return this.lottieDrawable.h();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.f24737n;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        int r100 = r0.c.f535396a;
        if (isAnimating() == false) goto L5;
        cancelAnimation();
        this.wasAnimatingWhenDetached = true;
    L5:
        cancelAsyncDrawWork();
        super.onDetachedFromWindow();
    }

    public void playAnimation() {
        if (r0.c.a.f535397a == true) goto L5;
        this.lottieDrawable.k();
        enableOrDisableHardwareLayer();
        return;
    L5:
        if (isShownM() == false) goto L11;
        ensureAssetLoad();
        Drawable r100 = getDrawable();
        LottieDrawable r101 = this.lottieDrawable;
        if (r100 == r101) goto L10;
        this.playAnimationWhenDrawableNotThisLottie = true;
        return;
    L10:
        r101.k();
        enableOrDisableHardwareLayer();
    L12:
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        return;
    L11:
        this.playAnimationWhenShown = true;
        goto L12
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.f24726c.removeAllListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        LottieDrawable r100 = this.lottieDrawable;
        r100.f24726c.removeAllUpdateListeners();
        r100.f24726c.addUpdateListener(r100.f24743t);
    }

    public void resetFailureListener() {
        LottieTask r100 = this.compositionTask;
        if (r100 == null) goto L6;
        r100.removeFailureListener(this.failureListener);
        return;
    }

    public void resumeAnimation() {
        if (r0.c.a.f535397a == true) goto L5;
        this.lottieDrawable.l();
        enableOrDisableHardwareLayer();
        return;
    L5:
        if (isShownM() == false) goto L11;
        ensureAssetLoad();
        Drawable r100 = getDrawable();
        LottieDrawable r101 = this.lottieDrawable;
        if (r100 == r101) goto L10;
        this.resumeAnimationWhenDrawableNotThisLottie = true;
        return;
    L10:
        r101.l();
        enableOrDisableHardwareLayer();
    L12:
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        return;
    L11:
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
        goto L12
    }

    public void reverseAnimationSpeed() {
        u0.c r100 = this.lottieDrawable.f24726c;
        r100.f548100c = -r100.f548100c;
    }

    private boolean isLottieAttachedToWindow() {
        return isAttachedToWindow();
    }

    private boolean isLottieTmpDetached() {
        if (isLottieAttachedToWindow() == true) goto L5;
        return false;
    L5:
        View r100 = this;
    L6:
        Object r101 = r100.getParent();
        if (r101 == null) goto L8;
        if ((r101 instanceof View) == false) goto L13;
        r100 = (View) r101;
        goto L6
    L13:
        return false;
    L8:
        return true;
    }

    private boolean isShownM() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = r0.c.f535396a;
        if (r0.c.a.f535397a == false) goto L16;
        if (isInEditMode() == true) goto L12;
        if (this.autoPlay == false) goto L9;
    L10:
        playAnimation();
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        goto L12
    L9:
        if (this.wasAnimatingWhenDetached == true) goto L10;
    L12:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        onVisibilityChanged(this, getVisibility());
        return;
    L21:
        return;
    L16:
        if (this.autoPlay == false) goto L18;
    L19:
        playAnimation();
        return;
    L18:
        if (this.wasAnimatingWhenDetached == true) goto L19;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f24676a = this.animationName;
        r100.f24677b = this.animationResId;
        r100.f24678c = this.lottieDrawable.f24726c.c();
        if (r0.c.a.f535397a == true) goto L5;
        r100.f24679d = this.lottieDrawable.h();
    L15:
        LottieDrawable r101 = this.lottieDrawable;
        r100.f24680e = r101.f24733j;
        r100.f24681f = r101.f24726c.getRepeatMode();
        r100.f24682g = this.lottieDrawable.f24726c.getRepeatCount();
        return r100;
    L5:
        if (this.lottieDrawable.h() == false) goto L7;
    L12:
        boolean r102 = true;
    L13:
        r100.f24679d = r102;
        goto L15
    L7:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L9;
    L11:
        r102 = false;
        goto L13
    L9:
        if (this.wasAnimatingWhenDetached == false) goto L11;
        goto L11
    }

    public String getAnimationName() {
        return this.animationName;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public void onAsyncDrawEnableChanged() {
        enableOrDisableHardwareLayer();
    }

    public LottieAnimationView(Context r100) {
        super(r100);
        this.loadedListener = new a(this);
        this.failureListener = new b();
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.hasSetUseHardwareLayer = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.disableOptInit = false;
        this.mIDCard = new t0.a();
        this.isAssetLazyLoadEnable = false;
        this.lazyRes = null;
        this.buildDrawingCacheDepth = 0;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.forceMarkViewShown = false;
        this.playActionInQueue = false;
        this.playAction = new f(this);
        this.reportTime = 0;
        init(null);
    }

    public static /* synthetic */ boolean access$200(LottieAnimationView r100) {
        return r100.playAnimationWhenShown;
    }

    public static /* synthetic */ boolean access$300(LottieAnimationView r100) {
        return r100.wasAnimatingWhenNotShown;
    }

    private void init(AttributeSet r100) {
        t0.a r101 = this.mIDCard;
        r101.getClass();
        r101.f544118h = getClass().getName();
        r101.f544117g = new WeakReference(this);
        LottieDrawable r102 = this.lottieDrawable;
        r102.f24741r = this.mIDCard;
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.lottie_autoPlay, R.attr.lottie_cacheStrategy, R.attr.lottie_colorFilter, R.attr.lottie_enableMergePathsForKitKatAndAbove, R.attr.lottie_fileName, R.attr.lottie_imageAssetsFolder, R.attr.lottie_lazyLoad, R.attr.lottie_loop, R.attr.lottie_progress, R.attr.lottie_rawRes, R.attr.lottie_repeatCount, R.attr.lottie_repeatMode, R.attr.lottie_scale, R.attr.lottie_url});
        int r104 = r103.getInt(1, DEFAULT_CACHE_STRATEGY.ordinal());
        this.defaultCacheStrategy = CacheStrategy.values()[r104];
        if (isInEditMode() == true) goto L23;
        boolean r105 = r103.hasValue(9);
        boolean r106 = r103.hasValue(4);
        boolean r107 = r103.hasValue(13);
        if (r105 == false) goto L10;
        if (r106 == false) goto L10;
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
    L10:
        if (r105 == false) goto L14;
        int r108 = r103.getResourceId(9, 0);
        if (r108 == 0) goto L23;
        setAnimation(r108);
        goto L23
    L14:
        if (r106 == false) goto L18;
        String r109 = r103.getString(4);
        if (r109 == null) goto L23;
        setAnimation(r109);
        goto L23
    L18:
        if (r107 == false) goto L23;
        String r110 = r103.getString(13);
        if (r110 == null) goto L23;
        setAnimationFromUrl(r110);
    L23:
        if (r103.getBoolean(0, false) == false) goto L26;
        this.wasAnimatingWhenDetached = true;
        this.autoPlay = true;
    L26:
        if (r103.getBoolean(7, false) == false) goto L29;
        this.lottieDrawable.w(-1);
    L29:
        if (r103.hasValue(11) == false) goto L32;
        setRepeatMode(r103.getInt(11, 1));
    L32:
        if (r103.hasValue(10) == false) goto L34;
        setRepeatCount(r103.getInt(10, -1));
    L34:
        setImageAssetsFolder(r103.getString(5));
        setProgress(r103.getFloat(8, 0.0f));
        enableMergePathsForKitKatAndAbove(r103.getBoolean(3, false));
        if (r103.hasValue(2) == false) goto L38;
        o r111 = new o(r103.getColor(2, 0));
        m0.e r112 = new m0.e(new String[]{"**"});
        v0.c r113 = new v0.c(r111);
        addValueCallback(r112, k.C, r113);
    L38:
        if (r103.hasValue(12) == false) goto L40;
        LottieDrawable r114 = this.lottieDrawable;
        r114.f24727d = r103.getFloat(12, 1.0f);
        r114.x();
    L40:
        r103.recycle();
        enableOrDisableHardwareLayer();
        if (r0.c.a.f535397a == false) goto L43;
        LottieCompositionFactory.checkAndRegisterLowMemoryListener(getContext());
    L43:
        this.isInitialized = true;
    }

    private void setCompositionAfter(boolean r100) {
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable) goto L10;
        if (r100 == true) goto L10;
        if (r0.c.a.f535397a == false) goto L31;
        onVisibilityChanged(this, getVisibility());
        return;
    L31:
        return;
    L10:
        if (r0.c.a.f535397a == false) goto L12;
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        onVisibilityChanged(this, getVisibility());
    L13:
        requestLayout();
        if (this.lottieOnCompositionLoadedListeners.size() <= 0) goto L26;
        Object[] r101 = this.lottieOnCompositionLoadedListeners.toArray();
        if (r101 == null) goto L32;
        int r102 = 0;
    L19:
        if (r102 >= r101.length) goto L33;
        Object r103 = r101[r102];
        if (r103 == null) goto L25;
        if ((r103 instanceof j) == false) goto L25;
        ((j) r103).a(this.composition);
    L25:
        r102 = r102 + 1;
        goto L19
    L33:
        return;
    L32:
        return;
    L26:
        return;
    L12:
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        goto L13
    }

    public void addAnimatorListener(Animator.AnimatorListener r100) {
        this.lottieDrawable.f24726c.addListener(r100);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        this.lottieDrawable.f24726c.addUpdateListener(r100);
    }

    public boolean addLottieOnCompositionLoadedListener(j r100) {
        LottieComposition r101 = this.composition;
        if (r101 == null) goto L6;
        r100.a(r101);
    L6:
        return this.lottieOnCompositionLoadedListeners.add(r100);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean r100) {
    L22:
        int r101 = this.reportTime + 1;
        this.reportTime = r101;
        if (r101 > 3) goto L28;
        i r102 = i.a();
        t0.a r103 = this.mIDCard;
        r103.getClass();
        r103.a();
        r102.getClass();
        return;
    L28:
        return;
    L4:
        if (r0.c.a.f535397a == false) goto L20;
        LottieDrawable r104 = this.lottieDrawable;     // Catch: Exception -> L22
        if (r104.f24744u == false) goto L8;
        r104.f24744u = false;     // Catch: Exception -> L22
    L8:
        Set<String> r105 = com.airbnb.lottie.f.f24776a;     // Catch: Exception -> L22
        this.buildDrawingCacheDepth++;     // Catch: Exception -> L22
        super.buildDrawingCache(r100);     // Catch: Exception -> L22
        if (this.buildDrawingCacheDepth == 1) goto L11;
    L19:
        this.buildDrawingCacheDepth--;     // Catch: Exception -> L22
        com.airbnb.lottie.f.a();     // Catch: Exception -> L22
        return;
    L11:
        if (getWidth() <= 0) goto L19;
        if (getHeight() <= 0) goto L19;
        if (getLayerType() != 1) goto L19;
        if (getDrawingCache(r100) != null) goto L19;
        setRenderMode(RenderMode.HARDWARE);     // Catch: Exception -> L22
        goto L19
    L20:
        super.buildDrawingCache(r100);     // Catch: Exception -> L22
    }

    public void enableAssetLazyLoad(boolean r100) {
        if (this.isAssetLazyLoadEnable == false) goto L6;
        if (r100 == true) goto L6;
        ensureAssetLoad();
    L6:
        if (r100 == false) goto L8;
        boolean r101 = r0.c.a.f535397a;
    L8:
        this.isAssetLazyLoadEnable = false;
    }

    public void enableMergePathsForKitKatAndAbove(boolean r100) {
        LottieDrawable r101 = this.lottieDrawable;
        if (r101.f24737n == r100) goto L10;
        r101.f24737n = r100;
        if (r101.f24725b == null) goto L9;
        r101.b();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean r100) {
        if (r0.c.a.f535397a == false) goto L8;
        LottieDrawable r101 = this.lottieDrawable;
        if (r101.f24744u == false) goto L8;
        r101.f24744u = false;
    L8:
        return super.getDrawingCache(r100);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (getDrawable() != this.lottieDrawable) goto L5;
        ensureAssetLoad();
        super.invalidateDrawable(this.lottieDrawable);
        return;
    L5:
        super.invalidateDrawable(r100);
    }

    public void loop(boolean r100) {
        LottieDrawable r101 = this.lottieDrawable;
        if (r100 == false) goto L5;
        int r102 = -1;
    L6:
        r101.w(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        String r102 = r101.f24676a;
        this.animationName = r102;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        setAnimation(this.animationName);
    L9:
        int r103 = r101.f24677b;
        this.animationResId = r103;
        if (r103 == 0) goto L12;
        setAnimation(r103);
    L12:
        setProgress(r101.f24678c);
        if (r101.f24679d == false) goto L15;
        playAnimation();
    L15:
        LottieDrawable r104 = this.lottieDrawable;
        r104.f24733j = r101.f24680e;
        setRepeatMode(r101.f24681f);
        setRepeatCount(r101.f24682g);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r100) {
        this.lottieDrawable.f24726c.removeListener(r100);
    }

    public boolean removeLottieOnCompositionLoadedListener(j r100) {
        return this.lottieOnCompositionLoadedListeners.remove(r100);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        this.lottieDrawable.f24726c.removeUpdateListener(r100);
    }

    public List<m0.e> resolveKeyPath(m0.e r100) {
        LottieDrawable r101 = this.lottieDrawable;
        if (r101.f24738o == null) goto L7;
        ArrayList r102 = new ArrayList();
        r101.f24738o.f(r100, 0, r102, new m0.e(new String[0]));
        return r102;
    L7:
        return Collections.emptyList();
    }

    public void setAnimation(JSONObject r100) {
        int r101 = r0.c.f535396a;
        setAnimation(new JsonReader(new StringReader(r100.toString())));
    }

    public void setAnimationFromJson(String r100) {
        int r101 = r0.c.f535396a;
        setAnimationFromJson(r100, null);
    }

    public void setAnimationFromUrl(String r100) {
        int r101 = r0.c.f535396a;
        t0.a r102 = this.mIDCard;
        r102.b();
        r102.f544114d = r100;
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = LottieCompositionFactory.fromUrl(getContext(), r100).addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    public void setComposition(LottieComposition r100) {
        Set<String> r101 = com.airbnb.lottie.f.f24776a;
        this.lottieDrawable.setCallback(this);
        this.composition = r100;
        boolean r102 = r0.c.a.f535397a;
        setCompositionAfter(this.lottieDrawable.m(r100));
    }

    public void setFailureListener(LottieListener<Throwable> r100) {
        LottieTask r101 = this.compositionTask;
        if (r101 == null) goto L6;
        r101.removeFailureListener(this.failureListener);
        this.compositionTask.addFailureListener(r100);
        return;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.c r100) {
        LottieDrawable r101 = this.lottieDrawable;
        r101.f24736m = r100;
        l0.a r102 = r101.f24735l;
        if (r102 == null) goto L6;
        r102.f506836e = r100;
        return;
    }

    public void setFrame(int r100) {
        this.lottieDrawable.o(r100);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.d r100) {
        LottieDrawable r101 = this.lottieDrawable;
        r101.f24734k = r100;
        l0.b r102 = r101.f24732i;
        if (r102 == null) goto L6;
        r102.f506841c = r100;
        return;
    }

    public void setImageAssetsFolder(String r100) {
        this.lottieDrawable.f24733j = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        cancelAsyncDrawWork();
        cancelLoaderTask();
        super.setImageBitmap(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        if (r100 == this.lottieDrawable) goto L5;
        cancelAsyncDrawWork();
    L5:
        cancelLoaderTask();
        super.setImageDrawable(r100);
        if (r0.c.a.f535397a == true) goto L8;
        return;
    L8:
        if (this.isInitialized == true) goto L10;
        return;
    L10:
        if (r100 == this.lottieDrawable) goto L13;
        return;
    L13:
        if (isAnimating() == false) goto L15;
    L20:
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        return;
    L15:
        if (this.playAnimationWhenDrawableNotThisLottie == false) goto L18;
        playAnimation();
        goto L20
    L18:
        if (this.resumeAnimationWhenDrawableNotThisLottie == false) goto L20;
        resumeAnimation();
        goto L20
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        cancelAsyncDrawWork();
        cancelLoaderTask();
        super.setImageResource(r100);
    }

    public void setMaxFrame(int r100) {
        this.lottieDrawable.p(r100);
    }

    public void setMaxProgress(float r100) {
        this.lottieDrawable.q(r100);
    }

    public void setMinFrame(int r100) {
        this.lottieDrawable.t(r100);
    }

    public void setMinProgress(float r100) {
        this.lottieDrawable.u(r100);
    }

    public void setPerformanceTrackingEnabled(boolean r100) {
        LottieDrawable r101 = this.lottieDrawable;
        r101.f24740q = r100;
        LottieComposition r102 = r101.f24725b;
        if (r102 == null) goto L6;
        r102.setPerformanceTrackingEnabled(r100);
        return;
    }

    public void setProgress(float r100) {
        this.lottieDrawable.v(r100);
    }

    public void setRenderMode(RenderMode r100) {
        this.renderMode = r100;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int r100) {
        this.lottieDrawable.w(r100);
        this.mIDCard.getClass();
    }

    public void setRepeatMode(int r100) {
        this.lottieDrawable.f24726c.setRepeatMode(r100);
    }

    public void setSafeMode(boolean r100) {
        this.lottieDrawable.f24730g = r100;
    }

    public void setScale(float r100) {
        LottieDrawable r101 = this.lottieDrawable;
        r101.f24727d = r100;
        r101.x();
        if (getDrawable() != this.lottieDrawable) goto L6;
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        return;
    }

    public void setSpeed(float r100) {
        this.lottieDrawable.f24726c.f548100c = r100;
    }

    public void setTextDelegate(p r100) {
        this.lottieDrawable.getClass();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable r100) {
        if (r0.c.a.f535397a == true) goto L5;
    L11:
        super.unscheduleDrawable(r100);
        return;
    L5:
        if (r100 == this.lottieDrawable) goto L11;
        if ((r100 instanceof LottieDrawable) == false) goto L11;
        LottieDrawable r101 = (LottieDrawable) r100;
        if (r101.h() == false) goto L11;
        r101.c();
        goto L11
    }

    public void useExperimentalHardwareAcceleration(boolean r100) {
        useHardwareAcceleration(r100);
    }

    public void useHardwareAcceleration(boolean r100) {
        this.hasSetUseHardwareLayer = true;
        if (this.useHardwareLayer != r100) goto L5;
        return;
    L5:
        this.useHardwareLayer = r100;
        enableOrDisableHardwareLayer();
    }

    public void setAnimation(int r100) {
        setAnimation(r100, false);
    }

    public void setAnimation(JsonReader r100) {
        setAnimation(r100, null);
    }

    public void setAnimation(String r100) {
        setAnimation(r100, false);
    }

    public LottieAnimationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.loadedListener = new a(this);
        this.failureListener = new b();
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.hasSetUseHardwareLayer = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.disableOptInit = false;
        this.mIDCard = new t0.a();
        this.isAssetLazyLoadEnable = false;
        this.lazyRes = null;
        this.buildDrawingCacheDepth = 0;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.forceMarkViewShown = false;
        this.playActionInQueue = false;
        this.playAction = new f(this);
        this.reportTime = 0;
        init(r101);
    }

    public static /* synthetic */ void access$000(LottieAnimationView r100, boolean r101) {
        r100.setCompositionAfter(r101);
    }

    public static /* synthetic */ boolean access$102(LottieAnimationView r100, boolean r101) {
        r100.forceMarkViewShown = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(LottieAnimationView r100, boolean r101) {
        r100.playActionInQueue = r101;
        return r101;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r0.c.a.f535397a == true) goto L5;
        return;
    L5:
        if (this.isInitialized == true) goto L8;
        return;
    L8:
        if (isShownM() == false) goto L20;
        if (isShown() == false) goto L13;
        ensureAssetLoad();
    L13:
        if (this.wasAnimatingWhenNotShown == false) goto L16;
        resumeAnimation();
    L18:
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
    L22:
        int r102 = r0.c.f535396a;
        return;
    L16:
        if (this.playAnimationWhenShown == false) goto L18;
        playAnimation();
        goto L18
    L20:
        if (isAnimating() == false) goto L22;
        pauseAnimation();
        this.wasAnimatingWhenNotShown = true;
        goto L22
    }

    public void setAnimation(int r100, boolean r101) {
        int r102 = r0.c.f535396a;
        this.animationResId = r100;
        t0.a r103 = this.mIDCard;
        Resources r104 = getResources();
        r103.b();
        if (r104 != null) goto L21;
    L7:
        this.animationName = null;
        if ((r101 | false) == false) goto L10;
        String r105 = LottieCompositionFactory.rawResCacheKey(r100);
    L11:
        LottieComposition r106 = m0.g.f511472b.a(r105);
        if (r106 == null) goto L15;
        setComposition(r106);
        return;
    L15:
        clearComposition();
        cancelLoaderTask();
        if (isAssetLazyLoadEnable() == false) goto L19;
        this.lazyRes = new k0.b(this.animationResId);
        return;
    L19:
        this.compositionTask = LottieCompositionFactory.fromRawRes(getContext(), r100).addListener(new c(r105)).addListener(this.loadedListener).addFailureListener(this.failureListener);
        return;
    L10:
        r105 = Integer.toString(r100);
        goto L11
    L21:
        r103.f544113c = r104.getResourceEntryName(r100);     // Catch: Exception -> L6
        i.a().getClass();     // Catch: Exception -> L6
        goto L7
    }

    public void setAnimationFromJson(String r100, String r101) {
        setAnimation(new JsonReader(new StringReader(r100)), r101);
    }

    public void setMinAndMaxFrame(int r100, int r101) {
        this.lottieDrawable.r(r100, r101);
    }

    public void setMinAndMaxProgress(float r100, float r101) {
        this.lottieDrawable.s(r100, r101);
    }

    public Bitmap updateBitmap(String r100, Bitmap r101) {
        LottieDrawable r102 = this.lottieDrawable;
        l0.b r103 = r102.f();
        if (r103 == null) goto L13;
        if (r101 != null) goto L8;
        com.airbnb.lottie.h r104 = r103.f506842d.get(r100);
        r101 = r104.f24784g;
        r104.f24784g = null;
    L11:
        r102.invalidateSelf();
        return r101;
    L8:
        if (r0.c.a.f535397a == false) goto L10;
        Bitmap r105 = r103.f506842d.get(r100).f24784g;
        r103.b(r100, r101);
        r101 = r105;
        goto L11
    L10:
        r103.b(r100, r101);
        goto L11
    L13:
        return null;
    }

    public void setAnimation(String r100, boolean r101) {
        int r102 = r0.c.f535396a;     // Catch: Exception -> L16
        this.animationName = r100;     // Catch: Exception -> L16
        t0.a r103 = this.mIDCard;     // Catch: Exception -> L16
        r103.b();     // Catch: Exception -> L16
        r103.f544112b = r100;     // Catch: Exception -> L16
        this.animationResId = 0;     // Catch: Exception -> L16
        if ((r101 | false) == false) goto L5;
        String r104 = LottieCompositionFactory.assetCacheKey(r100);     // Catch: Exception -> L16
    L6:
        LottieComposition r105 = m0.g.f511472b.a(r104);     // Catch: Exception -> L16
        if (r105 == null) goto L10;
        setComposition(r105);     // Catch: Exception -> L16
        return;
    L10:
        clearComposition();     // Catch: Exception -> L16
        cancelLoaderTask();     // Catch: Exception -> L16
        if (isAssetLazyLoadEnable() == false) goto L14;
        this.lazyRes = new k0.a(this.animationName);     // Catch: Exception -> L16
        return;
    L14:
        this.compositionTask = LottieCompositionFactory.fromAsset(getContext(), r100).addListener(new d(r104)).addListener(this.loadedListener).addFailureListener(this.failureListener);     // Catch: Exception -> L16
        return;
    L5:
        r104 = r100;
    L16:
        e = move-exception;
        i r106 = i.a();
        new IllegalStateException("setAnimation error!", e);
        r106.getClass();
    }

    public void setAnimation(JsonReader r100, String r101) {
        int r102 = r0.c.f535396a;
        clearComposition();
        cancelLoaderTask();
        this.mIDCard.b();
        this.compositionTask = LottieCompositionFactory.fromJsonReader(r100, r101).addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    public void setAnimation(int r100, CacheStrategy r101) {
        setAnimation(r100);
    }

    public void setAnimation(String r100, CacheStrategy r101) {
        setAnimation(r100);
    }

    public LottieAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.loadedListener = new a(this);
        this.failureListener = new b();
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.playAnimationWhenDrawableNotThisLottie = false;
        this.resumeAnimationWhenDrawableNotThisLottie = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.hasSetUseHardwareLayer = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.disableOptInit = false;
        this.mIDCard = new t0.a();
        this.isAssetLazyLoadEnable = false;
        this.lazyRes = null;
        this.buildDrawingCacheDepth = 0;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.forceMarkViewShown = false;
        this.playActionInQueue = false;
        this.playAction = new f(this);
        this.reportTime = 0;
        init(r101);
    }

    public <T> void addValueCallback(m0.e r100, T r101, v0.e<T> r102) {
        this.lottieDrawable.a(r100, r101, new e(r102));
    }

    public <T> void addValueCallback(m0.e r100, T r101, v0.c<T> r102) {
        this.lottieDrawable.a(r100, r101, r102);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
