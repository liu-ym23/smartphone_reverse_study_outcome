package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;
import rs0.c0;

/* JADX INFO: loaded from: classes47.dex */
public final class NewProfileEnterExitUseCase implements ut0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f86965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProfileCustomSkin.Panel f86966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Observable<Object>> f86967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f86968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f86969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f86970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f86971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.profile.usecase.a f86972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner<com.bytedance.android.live.profile.model.a> f86973i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewProfileEnterExitUseCase f86974a;

        public a(NewProfileEnterExitUseCase r100) {
            this.f86974a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ProfileMonitor r102 = this.f86974a.f();
            if (r102 == null) goto L5;
            r102.g(EventType.EnterAnimTimeout);
        L5:
            StringBuilder r103 = new StringBuilder("timeout, error ");
            if (r101 == null) goto L8;
            String r104 = r101.getMessage();
        L9:
            r103.append(r104);
            ALogger.i(NewProfileInfoViewModel.TAG, r103.toString());
            return;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewProfileEnterExitUseCase f86975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f86976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f86977c;

        public b(NewProfileEnterExitUseCase r100, View r101, Function0 r102) {
            this.f86975a = r100;
            this.f86976b = r101;
            this.f86977c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            View r102 = this.f86976b;
            if (r102 == null) goto L6;
            r102.post(new com.bytedance.android.live.profile.usecase.b(this));
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f86978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f86979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NewProfileEnterExitUseCase f86980c;

        public c(boolean r100, boolean r101, NewProfileEnterExitUseCase r102) {
            this.f86978a = r100;
            this.f86979b = r101;
            this.f86980c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L18;
            float r103 = r102.floatValue();
            if (this.f86978a == true) goto L10;
        L14:
            View r104 = this.f86980c.f86965a;
            if (r104 == null) goto L21;
            r104.setTranslationX(r103);
            return;
        L21:
            return;
        L10:
            if (this.f86979b == true) goto L14;
            View r105 = this.f86980c.f86965a;
            if (r105 == null) goto L19;
            r105.setTranslationY(r103);
            return;
        L19:
            return;
        }
    }

    @Override // ut0.a
    public final void clear() {
        this.f86965a = null;
        ((ArrayList) this.f86967c).clear();
        Disposable r100 = this.f86968d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Animator r101 = this.f86969e;
        if (r101 != null) goto L8;
    L12:
        this.f86969e = null;
        Animator r102 = this.f86970f;
        if (r102 != null) goto L15;
    L19:
        this.f86970f = null;
        return;
    L15:
        if (r102.isRunning() != true) goto L19;
        Animator r103 = this.f86970f;
        if (r103 == null) goto L19;
        r103.end();
        goto L19
    L8:
        if (r101.isRunning() != true) goto L12;
        Animator r104 = this.f86969e;
        if (r104 == null) goto L12;
        r104.end();
        goto L12
    }

    public final ProfileMonitor f() {
        return (ProfileMonitor) this.f86971g.getValue();
    }

    public static Interpolator e(List r100) {
        if (r100.size() == 4) goto L6;
        return new AccelerateDecelerateInterpolator();
    L6:
        if (CollectionsKt.getLastIndex(r100) < 0) goto L8;
        Object r101 = ListProtector.get(r100, 0);
    L9:
        float r102 = ((Number) r101).floatValue();
        if (1 > CollectionsKt.getLastIndex(r100)) goto L12;
        Object r103 = ListProtector.get(r100, 1);
    L13:
        float r104 = ((Number) r103).floatValue();
        if (2 > CollectionsKt.getLastIndex(r100)) goto L16;
        Object r105 = ListProtector.get(r100, 2);
    L17:
        float r106 = ((Number) r105).floatValue();
        if (3 > CollectionsKt.getLastIndex(r100)) goto L20;
        Object r107 = ListProtector.get(r100, 3);
    L22:
        return PathInterpolatorCompat.create(r102, r104, r106, ((Number) r107).floatValue());
    L20:
        r107 = Float.valueOf(0.0f);
        goto L22
    L16:
        r105 = Float.valueOf(0.0f);
        goto L17
    L12:
        r103 = Float.valueOf(0.0f);
        goto L13
    L8:
        r101 = Float.valueOf(0.0f);
        goto L9
    }

    public static List g(List r100) {
        ArrayList r101 = new ArrayList();
        List r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L16;
        Iterator r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Double r105 = (Double) r104.next();
        if (r105 == null) goto L12;
        r105.doubleValue();
        r101.add(Float.valueOf((float) r105.doubleValue()));
    L16:
        return r101;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // ut0.a
    public final void b(Function0<Unit> r100) {
        ALogger.i(NewProfileInfoViewModel.TAG, "profile exit");
        Disposable r101 = this.f86968d;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Animator r102 = this.f86969e;
        if (r102 != null) goto L8;
    L12:
        this.f86969e = null;
        Animator r103 = this.f86970f;
        if (r103 != null) goto L15;
    L17:
        ValueAnimator r104 = c(this.f86966b, false);
        r104.addListener(new d(this, r100));
        r104.start();
        Unit r105 = Unit.INSTANCE;
        this.f86970f = r104;
        return;
    L15:
        if (r103.isRunning() != true) goto L17;
        return;
    L8:
        if (r102.isRunning() != true) goto L12;
        Animator r106 = this.f86969e;
        if (r106 == null) goto L12;
        r106.end();
        goto L12
    }

    @Override // ut0.a
    public final void enterWaitFor(Observable<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "wait");
        ALogger.i(NewProfileInfoViewModel.TAG, "enterWaitFor: " + r100.toString());
        ((ArrayList) this.f86967c).add(r100.onErrorReturnItem(Unit.INSTANCE));
    }

    public NewProfileEnterExitUseCase(com.bytedance.android.live.profile.usecase.a r100, PropertyOwner<com.bytedance.android.live.profile.model.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "profileViewModel");
        Intrinsics.checkNotNullParameter(r101, "enterExitState");
        this.f86972h = r100;
        this.f86973i = r101;
        this.f86967c = new ArrayList();
        this.f86971g = LazyKt.lazy(new NewProfileEnterExitUseCase$profileMonitor$2(this));
    }

    public final ValueAnimator c(ProfileCustomSkin.Panel r110, boolean r111) {
        if (r110 == null) goto L60;
        if (r111 == false) goto L5;
        long r100 = r110.openInterval;
    L6:
        long r101 = Math.max(0, r100);
        if (r111 == false) goto L9;
        List<Double> r112 = r110.openRateCurve;
    L10:
        List r113 = g(r112);
        int r102 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        boolean r103 = PadConfigUtils.c();
        if (r101 != 0) goto L13;
    L59:
        ValueAnimator r114 = d(r111, r103);
    L61:
        r114.addUpdateListener(new c(this.f86972h.isVertical(), PadConfigUtils.c(), this));
        return r114;
    L13:
        if (((ArrayList) r113).size() != 4) goto L59;
        float r104 = 0.0f;
        if (r111 == true) goto L18;
    L27:
        if (r111 == false) goto L29;
    L37:
        if (r111 == true) goto L39;
    L48:
        if (r111 == false) goto L50;
    L58:
        r114 = d(r111, r103);
        goto L61
    L50:
        if (this.f86972h.isVertical() == false) goto L52;
        if (r103 == false) goto L58;
    L52:
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 横屏出场");
        PropertyValuesHolder[] r115 = new PropertyValuesHolder[1];
        Keyframe[] r105 = new Keyframe[2];
        r105[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r106 = this.f86965a;
        if (r106 == null) goto L55;
        r104 = r106.getWidth();
    L55:
        Keyframe r107 = Keyframe.ofFloat(1.0f, r104);
        r107.setInterpolator(e(r113));
        Unit r116 = Unit.INSTANCE;
        r105[1] = r107;
        r115[0] = PropertyValuesHolder.ofKeyframe("value", r105);
        r114 = ValueAnimator.ofPropertyValuesHolder(r115);
        if (r114 == null) goto L61;
        r114.setDuration(r101);
        goto L61
    L39:
        if (this.f86972h.isVertical() == false) goto L41;
        if (r103 == false) goto L48;
    L41:
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 横屏进场");
        PropertyValuesHolder[] r117 = new PropertyValuesHolder[1];
        Keyframe[] r108 = new Keyframe[2];
        View r109 = this.f86965a;
        if (r109 == null) goto L44;
        float r118 = r109.getWidth();
    L45:
        r108[0] = Keyframe.ofFloat(0.0f, r118);
        Keyframe r119 = Keyframe.ofFloat(1.0f, 0.0f);
        r119.setInterpolator(e(r113));
        Unit r120 = Unit.INSTANCE;
        r108[1] = r119;
        r117[0] = PropertyValuesHolder.ofKeyframe("value", r108);
        r114 = ValueAnimator.ofPropertyValuesHolder(r117);
        if (r114 == null) goto L61;
        r114.setDuration(r101);
        goto L61
    L44:
        r118 = 0.0f;
        goto L45
    L29:
        if (this.f86972h.isVertical() == false) goto L37;
        if (r103 == true) goto L37;
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 竖屏出场");
        PropertyValuesHolder[] r121 = new PropertyValuesHolder[1];
        Keyframe[] r122 = new Keyframe[2];
        r122[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r123 = this.f86965a;
        if (r123 == null) goto L34;
        r104 = r123.getHeight();
    L34:
        Keyframe r124 = Keyframe.ofFloat(1.0f, r104);
        r124.setInterpolator(e(r113));
        Unit r125 = Unit.INSTANCE;
        r122[1] = r124;
        r121[0] = PropertyValuesHolder.ofKeyframe("value", r122);
        r114 = ValueAnimator.ofPropertyValuesHolder(r121);
        if (r114 == null) goto L61;
        r114.setDuration(r101);
        goto L61
    L18:
        if (this.f86972h.isVertical() == false) goto L27;
        if (r103 == true) goto L27;
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 竖屏进场");
        PropertyValuesHolder[] r126 = new PropertyValuesHolder[1];
        Keyframe[] r127 = new Keyframe[2];
        View r128 = this.f86965a;
        if (r128 == null) goto L23;
        float r129 = r128.getHeight();
    L24:
        r127[0] = Keyframe.ofFloat(0.0f, r129);
        Keyframe r130 = Keyframe.ofFloat(1.0f, 0.0f);
        r130.setInterpolator(e(r113));
        Unit r131 = Unit.INSTANCE;
        r127[1] = r130;
        r126[0] = PropertyValuesHolder.ofKeyframe("value", r127);
        r114 = ValueAnimator.ofPropertyValuesHolder(r126);
        if (r114 == null) goto L61;
        r114.setDuration(r101);
        goto L61
    L23:
        r129 = 0.0f;
        goto L24
    L9:
        r112 = r110.closeRateCurve;
        goto L10
    L5:
        r100 = r110.closeInterval;
        goto L6
    L60:
        int r132 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        r114 = d(r111, PadConfigUtils.c());
        goto L61
    }

    public final ValueAnimator d(boolean r110, boolean r111) {
        float r100 = 0.0f;
        if (r110 == true) goto L5;
    L14:
        if (r110 == true) goto L25;
        if (this.f86972h.isVertical() == false) goto L25;
        if (r111 == true) goto L25;
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 竖屏出场");
        PropertyValuesHolder[] r112 = new PropertyValuesHolder[1];
        Keyframe[] r113 = new Keyframe[2];
        r113[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r101 = this.f86965a;
        if (r101 == null) goto L21;
        r100 = r101.getHeight();
    L21:
        Keyframe r102 = Keyframe.ofFloat(1.0f, r100);
        r102.setInterpolator(new DecelerateInterpolator());
        Unit r103 = Unit.INSTANCE;
        r113[1] = r102;
        r112[0] = PropertyValuesHolder.ofKeyframe("value", r113);
        ValueAnimator r114 = ValueAnimator.ofPropertyValuesHolder(r112);
        if (r114 == null) goto L50;
        r114.setDuration(150);
        return r114;
    L50:
        return r114;
    L25:
        if (r110 == true) goto L27;
    L36:
        if (r110 == true) goto L47;
        if (this.f86972h.isVertical() == false) goto L40;
        if (r111 == false) goto L47;
    L40:
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 横屏出场");
        PropertyValuesHolder[] r115 = new PropertyValuesHolder[1];
        Keyframe[] r116 = new Keyframe[2];
        r116[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r104 = this.f86965a;
        if (r104 == null) goto L43;
        r100 = r104.getWidth();
    L43:
        Keyframe r105 = Keyframe.ofFloat(1.0f, r100);
        r105.setInterpolator(new AccelerateDecelerateInterpolator());
        Unit r106 = Unit.INSTANCE;
        r116[1] = r105;
        r115[0] = PropertyValuesHolder.ofKeyframe("value", r116);
        ValueAnimator r117 = ValueAnimator.ofPropertyValuesHolder(r115);
        if (r117 == null) goto L54;
        r117.setDuration(300);
        return r117;
    L54:
        return r117;
    L47:
        return new ValueAnimator();
    L27:
        if (this.f86972h.isVertical() == false) goto L29;
        if (r111 == false) goto L36;
    L29:
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 横屏进场");
        PropertyValuesHolder[] r118 = new PropertyValuesHolder[1];
        Keyframe[] r119 = new Keyframe[2];
        View r107 = this.f86965a;
        if (r107 == null) goto L32;
        float r108 = r107.getWidth();
    L33:
        r119[0] = Keyframe.ofFloat(0.0f, r108);
        Keyframe r109 = Keyframe.ofFloat(1.0f, 0.0f);
        r109.setInterpolator(new AccelerateDecelerateInterpolator());
        Unit r120 = Unit.INSTANCE;
        r119[1] = r109;
        r118[0] = PropertyValuesHolder.ofKeyframe("value", r119);
        ValueAnimator r121 = ValueAnimator.ofPropertyValuesHolder(r118);
        if (r121 == null) goto L52;
        r121.setDuration(300);
        return r121;
    L52:
        return r121;
    L32:
        r108 = 0.0f;
        goto L33
    L5:
        if (this.f86972h.isVertical() == false) goto L14;
        if (r111 == true) goto L14;
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 竖屏进场");
        PropertyValuesHolder[] r122 = new PropertyValuesHolder[1];
        Keyframe[] r123 = new Keyframe[2];
        View r124 = this.f86965a;
        if (r124 == null) goto L10;
        float r125 = r124.getHeight();
    L11:
        r123[0] = Keyframe.ofFloat(0.0f, r125);
        Keyframe r126 = Keyframe.ofFloat(1.0f, 0.0f);
        r126.setInterpolator(new DecelerateInterpolator());
        Unit r127 = Unit.INSTANCE;
        r123[1] = r126;
        r122[0] = PropertyValuesHolder.ofKeyframe("value", r123);
        ValueAnimator r128 = ValueAnimator.ofPropertyValuesHolder(r122);
        if (r128 == null) goto L48;
        r128.setDuration(150);
        return r128;
    L48:
        return r128;
    L10:
        r125 = 0.0f;
        goto L11
    }

    @Override // ut0.a
    public final void a(View r100, ProfileCustomSkin.Panel r101, Function0<Unit> r102) {
        ALogger.i(NewProfileInfoViewModel.TAG, "profile enter");
        this.f86965a = r100;
        this.f86966b = r101;
        int r103 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        if (b0.f539045a.getValue().a() == true) goto L9;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        if (r102 == null) goto L14;
        Unit r104 = r102.invoke();
        return;
    L14:
        return;
    L9:
        ProfileMonitor r105 = f();
        if (r105 == null) goto L12;
        r105.i(TimeType.PrepareEnterAnim);
    L12:
        this.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.WILL_ENTER));
        this.f86968d = Observable.merge(this.f86967c).toList().timeout(Math.max(c0.f539047a.getValue().longValue(), 0), TimeUnit.MILLISECONDS).doOnError(new a(this)).onErrorReturnItem(CollectionsKt.emptyList()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100, r102));
    }
}
