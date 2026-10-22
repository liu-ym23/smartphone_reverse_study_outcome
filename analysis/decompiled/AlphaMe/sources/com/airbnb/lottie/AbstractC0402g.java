package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.C0238z;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.map.WeightedLatLng;
import com.stepos.activeview.elements.LottieView;
import com.stepos.alphame.utils.Property;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.airbnb.lottie.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0402g extends androidx.appcompat.widget.G {
    private static final String TAG = "g";
    private String animationName;

    @RawRes
    private int animationResId;
    private boolean autoPlay;

    @Nullable
    private LottieComposition composition;

    @Nullable
    private C compositionTask;
    private final x failureListener;
    private final x loadedListener;
    private final v lottieDrawable;
    private Set<y> lottieOnCompositionLoadedListeners;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;

    public AbstractC0402g(Context context) {
        String string;
        super(context);
        LottieView lottieView = (LottieView) this;
        this.loadedListener = new C0399d(lottieView, 0);
        this.failureListener = new C0399d(lottieView, 1);
        v vVar = new v();
        this.lottieDrawable = vVar;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, E.f4533a);
        if (!isInEditMode()) {
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(7);
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(3);
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(11);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(7, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(11)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(5, false)) {
            vVar.f4576c.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(9)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(9, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(8, -1));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(4));
        setProgress(typedArrayObtainStyledAttributes.getFloat(6, Property.DEFAULT_FLOAT_VALUE));
        enableMergePathsForKitKatAndAbove(typedArrayObtainStyledAttributes.getBoolean(2, false));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            addValueCallback(new J0.e("**"), (J0.e) z.f4607t, new Q0.b(new F(typedArrayObtainStyledAttributes.getColor(1, 0), PorterDuff.Mode.SRC_ATOP)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(10)) {
            vVar.f4577d = typedArrayObtainStyledAttributes.getFloat(10, 1.0f);
            vVar.o();
        }
        typedArrayObtainStyledAttributes.recycle();
        f();
    }

    private void setCompositionTask(C c4) {
        this.composition = null;
        this.lottieDrawable.c();
        e();
        c4.b(this.loadedListener);
        c4.a(this.failureListener);
        this.compositionTask = c4;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.f4576c.addListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.f4576c.addUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull y yVar) {
        return this.lottieOnCompositionLoadedListeners.add(yVar);
    }

    public <T> void addValueCallback(J0.e eVar, T t4, Q0.b bVar) {
        this.lottieDrawable.a(eVar, t4, bVar);
    }

    @MainThread
    public void cancelAnimation() {
        v vVar = this.lottieDrawable;
        vVar.f4578e.clear();
        vVar.f4576c.cancel();
        f();
    }

    public final void e() {
        C c4 = this.compositionTask;
        if (c4 != null) {
            x xVar = this.loadedListener;
            synchronized (c4) {
                c4.f4525b.remove(xVar);
                c4.e();
            }
            C c5 = this.compositionTask;
            x xVar2 = this.failureListener;
            synchronized (c5) {
                c5.f4526c.remove(xVar2);
                c5.e();
            }
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z4) {
        v vVar = this.lottieDrawable;
        if (vVar.f4582i == z4) {
            return;
        }
        vVar.f4582i = z4;
        if (vVar.f4575b != null) {
            vVar.b();
        }
    }

    public final void f() {
        setLayerType((this.useHardwareLayer && this.lottieDrawable.f4576c.f1556k) ? 2 : 1, null);
    }

    public final void g(Drawable drawable, boolean z4) {
        if (z4 && drawable != this.lottieDrawable) {
            recycleBitmaps();
        }
        e();
        super.setImageDrawable(drawable);
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.lottieDrawable.f4576c.f1551f;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.f4580g;
    }

    public float getMaxFrame() {
        return this.lottieDrawable.f4576c.d();
    }

    public float getMinFrame() {
        return this.lottieDrawable.f4576c.e();
    }

    @Nullable
    public D getPerformanceTracker() {
        LottieComposition lottieComposition = this.lottieDrawable.f4575b;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lottieDrawable.f4576c.c();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.f4576c.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.f4576c.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.f4577d;
    }

    public float getSpeed() {
        return this.lottieDrawable.f4576c.f1548c;
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public boolean hasMasks() {
        M0.c cVar = this.lottieDrawable.f4583j;
        return cVar != null && cVar.p();
    }

    public boolean hasMatte() {
        M0.c cVar = this.lottieDrawable.f4583j;
        if (cVar != null) {
            if (cVar.f1388z == null) {
                if (cVar.f1377p != null) {
                    cVar.f1388z = Boolean.TRUE;
                    return true;
                }
                ArrayList arrayList = cVar.f1385w;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((M0.b) arrayList.get(size)).f1377p != null) {
                        cVar.f1388z = Boolean.TRUE;
                        return true;
                    }
                }
                cVar.f1388z = Boolean.FALSE;
            }
            if (cVar.f1388z.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        v vVar = this.lottieDrawable;
        if (drawable2 == vVar) {
            super.invalidateDrawable(vVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.f4576c.f1556k;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.f4582i;
    }

    @Deprecated
    public void loop(boolean z4) {
        this.lottieDrawable.f4576c.setRepeatCount(z4 ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof LottieAnimationView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        LottieAnimationView$SavedState lottieAnimationView$SavedState = (LottieAnimationView$SavedState) parcelable;
        super.onRestoreInstanceState(lottieAnimationView$SavedState.getSuperState());
        String str = lottieAnimationView$SavedState.f4534a;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i4 = lottieAnimationView$SavedState.f4535b;
        this.animationResId = i4;
        if (i4 != 0) {
            setAnimation(i4);
        }
        setProgress(lottieAnimationView$SavedState.f4536c);
        if (lottieAnimationView$SavedState.f4537d) {
            playAnimation();
        }
        this.lottieDrawable.f4580g = lottieAnimationView$SavedState.f4538e;
        setRepeatMode(lottieAnimationView$SavedState.f4539f);
        setRepeatCount(lottieAnimationView$SavedState.f4540g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        LottieAnimationView$SavedState lottieAnimationView$SavedState = new LottieAnimationView$SavedState(super.onSaveInstanceState());
        lottieAnimationView$SavedState.f4534a = this.animationName;
        lottieAnimationView$SavedState.f4535b = this.animationResId;
        lottieAnimationView$SavedState.f4536c = this.lottieDrawable.f4576c.c();
        v vVar = this.lottieDrawable;
        P0.a aVar = vVar.f4576c;
        lottieAnimationView$SavedState.f4537d = aVar.f1556k;
        lottieAnimationView$SavedState.f4538e = vVar.f4580g;
        lottieAnimationView$SavedState.f4539f = aVar.getRepeatMode();
        lottieAnimationView$SavedState.f4540g = this.lottieDrawable.f4576c.getRepeatCount();
        return lottieAnimationView$SavedState;
    }

    public void pauseAnimation() {
        v vVar = this.lottieDrawable;
        vVar.f4578e.clear();
        vVar.f4576c.j(true);
        f();
    }

    @MainThread
    public void playAnimation() {
        this.lottieDrawable.e();
        f();
    }

    @VisibleForTesting
    public void recycleBitmaps() {
        I0.a aVar = this.lottieDrawable.f4579f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.f4576c.removeAllListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.f4576c.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.f4576c.removeListener(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull y yVar) {
        return this.lottieOnCompositionLoadedListeners.remove(yVar);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.f4576c.removeUpdateListener(animatorUpdateListener);
    }

    public List<J0.e> resolveKeyPath(J0.e eVar) {
        return this.lottieDrawable.f(eVar);
    }

    public void reverseAnimationSpeed() {
        P0.a aVar = this.lottieDrawable.f4576c;
        aVar.f1548c = -aVar.f1548c;
    }

    public void setAnimation(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(m.a(str, new j(1, str, jsonReader)));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        Context context = getContext();
        HashMap map = m.f4554a;
        setCompositionTask(new C(new l(1, new android.support.v4.media.session.c(context, str))));
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        HashSet hashSet = AbstractC0398c.f4541a;
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        v vVar = this.lottieDrawable;
        if (vVar.f4575b != lottieComposition) {
            vVar.c();
            vVar.f4575b = lottieComposition;
            vVar.b();
            P0.a aVar = vVar.f4576c;
            z = aVar.f1555j == null;
            aVar.f1555j = lottieComposition;
            if (z) {
                aVar.p((int) Math.max(aVar.f1553h, lottieComposition.getStartFrame()), (int) Math.min(aVar.f1554i, lottieComposition.getEndFrame()));
            } else {
                aVar.p((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
            }
            aVar.n((int) aVar.f1551f);
            aVar.f1550e = System.nanoTime();
            vVar.n(aVar.getAnimatedFraction());
            vVar.f4577d = vVar.f4577d;
            vVar.o();
            vVar.o();
            ArrayList arrayList = vVar.f4578e;
            Iterator it = new ArrayList(arrayList).iterator();
            while (it.hasNext()) {
                ((u) it.next()).run();
                it.remove();
            }
            arrayList.clear();
            lottieComposition.setPerformanceTrackingEnabled(vVar.f4585l);
            z = true;
        }
        f();
        if (getDrawable() != this.lottieDrawable || z) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            requestLayout();
            Iterator<y> it2 = this.lottieOnCompositionLoadedListeners.iterator();
            if (it2.hasNext()) {
                B0.g.y(it2.next());
                throw null;
            }
        }
    }

    public void setFontAssetDelegate(AbstractC0396a abstractC0396a) {
        C0238z c0238z = this.lottieDrawable.f4581h;
        if (c0238z != null) {
            c0238z.f3216e = abstractC0396a;
        }
    }

    public void setFrame(int i4) {
        this.lottieDrawable.g(i4);
    }

    public void setImageAssetDelegate(InterfaceC0397b interfaceC0397b) {
        I0.a aVar = this.lottieDrawable.f4579f;
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.f4580g = str;
    }

    @Override // androidx.appcompat.widget.G, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.G, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        g(drawable, true);
    }

    @Override // androidx.appcompat.widget.G, android.widget.ImageView
    public void setImageResource(int i4) {
        recycleBitmaps();
        e();
        super.setImageResource(i4);
    }

    public void setMaxFrame(int i4) {
        this.lottieDrawable.h(i4);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f4) {
        this.lottieDrawable.i(f4);
    }

    public void setMinAndMaxFrame(int i4, int i5) {
        this.lottieDrawable.j(i4, i5);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f4, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f5) {
        this.lottieDrawable.k(f4, f5);
    }

    public void setMinFrame(int i4) {
        this.lottieDrawable.l(i4);
    }

    public void setMinProgress(float f4) {
        this.lottieDrawable.m(f4);
    }

    public void setPerformanceTrackingEnabled(boolean z4) {
        v vVar = this.lottieDrawable;
        vVar.f4585l = z4;
        LottieComposition lottieComposition = vVar.f4575b;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z4);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f4) {
        this.lottieDrawable.n(f4);
    }

    public void setRepeatCount(int i4) {
        this.lottieDrawable.f4576c.setRepeatCount(i4);
    }

    public void setRepeatMode(int i4) {
        this.lottieDrawable.f4576c.setRepeatMode(i4);
    }

    public void setScale(float f4) {
        v vVar = this.lottieDrawable;
        vVar.f4577d = f4;
        vVar.o();
        if (getDrawable() == this.lottieDrawable) {
            g(null, false);
            g(this.lottieDrawable, false);
        }
    }

    public void setSpeed(float f4) {
        this.lottieDrawable.f4576c.f1548c = f4;
    }

    public void setTextDelegate(G g4) {
        this.lottieDrawable.getClass();
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        v vVar = this.lottieDrawable;
        I0.a aVarD = vVar.d();
        if (aVarD == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        if (bitmap == null) {
            w wVar = (w) aVarD.f834c.get(str);
            bitmap = wVar.f4587b;
            wVar.f4587b = null;
        } else {
            aVarD.a(str, bitmap);
        }
        vVar.invalidateSelf();
        return bitmap;
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public <T> void addValueCallback(J0.e eVar, T t4, Q0.d dVar) {
        this.lottieDrawable.a(eVar, t4, new C0400e());
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration(boolean z4) {
        useHardwareAcceleration(z4);
    }

    public void useHardwareAcceleration(boolean z4) {
        if (this.useHardwareLayer == z4) {
            return;
        }
        this.useHardwareLayer = z4;
        f();
    }

    public void setAnimation(@RawRes int i4) {
        this.animationResId = i4;
        this.animationName = null;
        Context context = getContext();
        HashMap map = m.f4554a;
        setCompositionTask(m.a(AbstractC0351g.m("rawRes_", i4), new k(context.getApplicationContext(), i4)));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        Context context = getContext();
        HashMap map = m.f4554a;
        setCompositionTask(m.a(str, new j(0, str, context.getApplicationContext())));
    }
}
