package com.bytedance.android.live.core.anim;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.liveinteract.f;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public class LiveDegradeFpsAnimator extends ValueAnimator {
    public static final String ALPHA = "alpha";
    public static final String ROTATION = "rotation";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    private long mFpsConfig;
    private ValueAnimator.AnimatorUpdateListener mMainUpdateListener;
    private ArrayList<ValueAnimator.AnimatorUpdateListener> mUpdateListeners;

    public @interface Method {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f64748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveDegradeFpsAnimator f64749b;

        public a(LiveDegradeFpsAnimator r100) {
            this.f64749b = r100;
            this.f64748a = 0;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            if ((this.f64748a % LiveDegradeFpsAnimator.access$000(this.f64749b)) == 0) goto L5;
        L9:
            this.f64748a++;
            return;
        L5:
            if (LiveDegradeFpsAnimator.access$100(this.f64749b) == null) goto L9;
            int r101 = LiveDegradeFpsAnimator.access$100(this.f64749b).size();
            int r102 = 0;
        L7:
            if (r102 >= r101) goto L9;
            ((ValueAnimator.AnimatorUpdateListener) ListProtector.get(LiveDegradeFpsAnimator.access$100(this.f64749b), r102)).onAnimationUpdate(r100);
            r102 = r102 + 1;
            goto L7
        }
    }

    public static /* synthetic */ void a(View r100, String r101, ValueAnimator r102) {
        lambda$ofFloat$0(r100, r101, r102);
    }

    public LiveDegradeFpsAnimator() {
        this.mFpsConfig = 1;
        this.mUpdateListeners = null;
        this.mMainUpdateListener = new a(this);
        SettingKey<Integer> r100 = LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT;
        if (((Integer) f.b(r100)).intValue() <= 0) goto L6;
        this.mFpsConfig = ((Integer) f.b(r100)).intValue();
        return;
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        super.removeAllUpdateListeners();
        ArrayList<ValueAnimator.AnimatorUpdateListener> r100 = this.mUpdateListeners;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear();
        this.mUpdateListeners = null;
    }

    public static /* synthetic */ long access$000(LiveDegradeFpsAnimator r100) {
        return r100.mFpsConfig;
    }

    public static /* synthetic */ ArrayList access$100(LiveDegradeFpsAnimator r100) {
        return r100.mUpdateListeners;
    }

    public static LiveDegradeFpsAnimator ofFloat(float... r100) {
        LiveDegradeFpsAnimator r101 = new LiveDegradeFpsAnimator();
        r101.setFloatValues(r100);
        return r101;
    }

    public static LiveDegradeFpsAnimator ofInt(int... r100) {
        LiveDegradeFpsAnimator r101 = new LiveDegradeFpsAnimator();
        r101.setIntValues(r100);
        return r101;
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (this.mUpdateListeners != null) goto L5;
        this.mUpdateListeners = new ArrayList();
        super.addUpdateListener(this.mMainUpdateListener);
    L5:
        this.mUpdateListeners.add(r100);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        ArrayList<ValueAnimator.AnimatorUpdateListener> r101 = this.mUpdateListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
        if (this.mUpdateListeners.size() != 0) goto L9;
        super.removeUpdateListener(this.mMainUpdateListener);
        this.mUpdateListeners = null;
        return;
    }

    public LiveDegradeFpsAnimator setFpsConfig(int r100) {
        if (r100 <= 0) goto L4;
        this.mFpsConfig = r100;
    L4:
        return this;
    }

    public static LiveDegradeFpsAnimator ofObject(TypeEvaluator r100, Object... r101) {
        LiveDegradeFpsAnimator r102 = new LiveDegradeFpsAnimator();
        r102.setObjectValues(r101);
        r102.setEvaluator(r100);
        return r102;
    }

    private static void callMethod(View r100, String r101, float r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r101.getClass();
        byte r103 = -1;
        switch(r101.hashCode()) {
            case -1225497657: goto L28;
            case -1225497656: goto L24;
            case -908189618: goto L20;
            case -908189617: goto L16;
            case -40300674: goto L12;
            case 92909918: goto L8;
            default: goto L31;
        };
    L31:
        switch(r103) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            default: goto L45;
        };
    L33:
        r100.setAlpha(r102);
        return;
    L34:
        r100.setRotation(r102);
        return;
    L35:
        r100.setScaleY(r102);
        return;
    L36:
        r100.setScaleX(r102);
        return;
    L37:
        r100.setTranslationY(r102);
        return;
    L38:
        r100.setTranslationX(r102);
        return;
    L45:
        return;
    L8:
        if (r101.equals("alpha") == false) goto L31;
        r103 = 5;
        goto L31
    L12:
        if (r101.equals("rotation") == false) goto L31;
        r103 = 4;
        goto L31
    L16:
        if (r101.equals(SCALE_Y) == false) goto L31;
        r103 = 3;
        goto L31
    L20:
        if (r101.equals(SCALE_X) == false) goto L31;
        r103 = 2;
        goto L31
    L24:
        if (r101.equals(TRANSLATION_Y) == false) goto L31;
        r103 = 1;
        goto L31
    L28:
        if (r101.equals(TRANSLATION_X) == false) goto L31;
        r103 = 0;
        goto L31
    }

    private static /* synthetic */ void lambda$ofFloat$0(View r100, String r101, ValueAnimator r102) {
        callMethod(r100, r101, ((Float) r102.getAnimatedValue()).floatValue());
    }

    public static LiveDegradeFpsAnimator ofFloat(final View r100, final String r101, float... r102) {
        LiveDegradeFpsAnimator r103 = new LiveDegradeFpsAnimator();
        r103.setFloatValues(r102);
        r103.addUpdateListener(new y40.a(r100, r101));
        return r103;
    }
}
