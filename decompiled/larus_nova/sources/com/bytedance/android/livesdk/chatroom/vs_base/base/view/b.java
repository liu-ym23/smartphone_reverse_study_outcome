package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f117967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Animator> f117968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends View> f117969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f117970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f117971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f117972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TimeInterpolator f117973g;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f117974a;

        public a(Function1 r100) {
            this.f117974a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f117974a.invoke(r100.getAnimatedValue());
        }
    }

    public b() {
        this.f117967a = new AnimatorSet();
        this.f117968b = new ArrayList();
        this.f117969c = new ArrayList();
        this.f117970d = 300;
    }

    public static void b(b r100, float[] r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "values");
        float[] r102 = Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r102, "values");
        r100.a(View.SCALE_X, Arrays.copyOf(r102, r102.length), null);
        float[] r103 = Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r103, "values");
        r100.a(View.SCALE_Y, Arrays.copyOf(r103, r103.length), null);
    }

    public final void a(Property<View, Float> r100, float[] r101, Function1<Object, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "values");
        Iterator<T> r103 = this.f117969c.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        ObjectAnimator r104 = ObjectAnimator.ofFloat((View) r103.next(), r100, Arrays.copyOf(r101, r101.length));
        r104.setRepeatCount(0);
        if (r102 == null) goto L8;
        r104.addUpdateListener(new a(r102));
    L8:
        this.f117968b.add(r104);
        goto L4
    }
}
