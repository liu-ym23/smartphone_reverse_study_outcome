package com.bytedance.android.livesdk.utils.animate.frame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.os.Build;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class FrameAnimatorSet extends xt2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f158828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeInterpolator f158829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayMode f158830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Animator> f158831d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/utils/animate/frame/FrameAnimatorSet$PlayMode;", "", "Together", "Sequentially", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlayMode extends Enum<PlayMode> {
        public static final PlayMode Sequentially = null;
        public static final PlayMode Together = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayMode[] f158832a = null;

        static {
            PlayMode r100 = new PlayMode("Together", 0);
            Together = r100;
            PlayMode r101 = new PlayMode("Sequentially", 1);
            Sequentially = r101;
            f158832a = new PlayMode[]{r100, r101};
        }

        public static PlayMode valueOf(String r100) {
            return (PlayMode) r27.a.a(PlayMode.class, r100);
        }

        public static PlayMode[] values() {
            return (PlayMode[]) f158832a.clone();
        }

        public PlayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameAnimatorSet f158833a;

        public a(FrameAnimatorSet r100) {
            this.f158833a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ArrayList<Animator.AnimatorListener> r101 = this.f158833a.getListeners();
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Animator.AnimatorListener) r102.next()).onAnimationEnd(this.f158833a);
            goto L6
        L10:
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameAnimatorSet f158834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f158835b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ((Animator) ListProtector.get(this.f158834a.f158831d, this.f158835b + 1)).start();
        }

        public b(FrameAnimatorSet r100, int r101) {
            this.f158834a = r100;
            this.f158835b = r101;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameAnimatorSet f158836a;

        public c(FrameAnimatorSet r100) {
            this.f158836a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ArrayList<Animator.AnimatorListener> r101 = this.f158836a.getListeners();
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((Animator.AnimatorListener) r102.next()).onAnimationEnd(this.f158836a);
            goto L6
        L10:
            return;
        }
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return false;
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long r100) {
    }

    @Override // android.animation.Animator
    public final void cancel() {
        Iterator<T> r100 = this.f158831d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Animator) r100.next()).cancel();
        goto L4
    }

    public final long d() {
        PlayMode r100 = this.f158830c;
        int r101 = com.bytedance.android.livesdk.utils.animate.frame.b.f158884d[r100.ordinal()];
        boolean r102 = false;
        long r103 = 0;
        if (r101 != 1) goto L5;
        ArrayList<Animator> r104 = this.f158831d;
        if ((r104 instanceof Collection) == true) goto L31;
    L33:
        Iterator<Animator> r105 = r104.iterator();
    L35:
        if (r105.hasNext() == false) goto L42;
        if (a(r105.next()) != (-1)) goto L39;
        boolean r106 = true;
    L40:
        if (r106 == false) goto L35;
        r102 = true;
        goto L42
    L39:
        r106 = false;
    L42:
        if (r102 == true) goto L76;
        Iterator<Animator> r107 = this.f158831d.iterator();
        if (r107.hasNext() == true) goto L47;
        Animator r108 = null;
    L57:
        Animator r109 = r108;
        if (r109 == null) goto L61;
        r103 = a(r109);
    L61:
        return r103;
    L47:
        Animator r110 = r107.next();
        if (r107.hasNext() == true) goto L50;
    L49:
        r108 = r110;
        goto L57
    L50:
        long r111 = a(r110);
    L51:
        Animator r112 = r107.next();
        long r113 = a(r112);
        if (r111 >= r113) goto L55;
        r110 = r112;
        r111 = r113;
    L55:
        if (r107.hasNext() == true) goto L51;
    L76:
        return -1;
    L31:
        if (r104.isEmpty() == false) goto L33;
    L5:
        if (r101 != 2) goto L27;
        ArrayList<Animator> r114 = this.f158831d;
        if ((r114 instanceof Collection) == true) goto L9;
    L11:
        Iterator<Animator> r115 = r114.iterator();
    L13:
        if (r115.hasNext() == false) goto L20;
        if (a(r115.next()) != (-1)) goto L17;
        boolean r116 = true;
    L18:
        if (r116 == false) goto L13;
        r102 = true;
        goto L20
    L17:
        r116 = false;
    L20:
        if (r102 == true) goto L75;
        Iterator<Animator> r117 = this.f158831d.iterator();
    L24:
        if (r117.hasNext() == false) goto L61;
        r103 = r103 + a(r117.next());
        goto L24
    L75:
        return -1;
    L9:
        if (r114.isEmpty() == false) goto L11;
    L27:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.animation.Animator
    public final boolean isPaused() {
        ArrayList<Animator> r100 = this.f158831d;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((Animator) r101.next()).isPaused() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    @Override // android.animation.Animator
    public final void pause() {
        PlayMode r100 = this.f158830c;
        int r101 = com.bytedance.android.livesdk.utils.animate.frame.b.f158883c[r100.ordinal()];
        if (r101 != 1) goto L5;
        Iterator<T> r102 = this.f158831d.iterator();
    L19:
        if (r102.hasNext() == false) goto L28;
        ((Animator) r102.next()).pause();
        goto L19
    L28:
        return;
    L5:
        if (r101 != 2) goto L27;
        Iterator<T> r103 = this.f158831d.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((Animator) r104).isRunning() == false) goto L9;
    L14:
        Animator r105 = (Animator) r104;
        if (r105 == null) goto L21;
        r105.pause();
        return;
    L21:
        return;
    L13:
        r104 = null;
        goto L14
    }

    @Override // android.animation.Animator
    public final void resume() {
        PlayMode r100 = this.f158830c;
        int r101 = com.bytedance.android.livesdk.utils.animate.frame.b.f158882b[r100.ordinal()];
        if (r101 != 1) goto L5;
        Iterator<T> r102 = this.f158831d.iterator();
    L19:
        if (r102.hasNext() == false) goto L28;
        ((Animator) r102.next()).resume();
        goto L19
    L28:
        return;
    L5:
        if (r101 != 2) goto L27;
        Iterator<T> r103 = this.f158831d.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((Animator) r104).isPaused() == false) goto L9;
    L14:
        Animator r105 = (Animator) r104;
        if (r105 == null) goto L21;
        r105.resume();
        return;
    L21:
        return;
    L13:
        r104 = null;
        goto L14
    }

    @Override // android.animation.Animator
    public final void start() {
        if (this.f158828a <= 0) goto L8;
        Iterator<Animator> r100 = this.f158831d.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().setDuration(this.f158828a);
    L8:
        TimeInterpolator r101 = this.f158829b;
        if (r101 == null) goto L14;
        Iterator<Animator> r102 = this.f158831d.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        r102.next().setInterpolator(r101);
    L14:
        ArrayList<Animator.AnimatorListener> r103 = getListeners();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        ((Animator.AnimatorListener) r104.next()).onAnimationStart(this);
    L20:
        PlayMode r105 = this.f158830c;
        int r106 = com.bytedance.android.livesdk.utils.animate.frame.b.f158881a[r105.ordinal()];
        if (r106 != 1) goto L23;
        Iterator<Animator> r107 = this.f158831d.iterator();
        if (r107.hasNext() == true) goto L39;
        Animator r108 = null;
    L49:
        Animator r109 = r108;
        if (r109 == null) goto L52;
        r109.addListener(new a(this));
    L52:
        Iterator<Animator> r110 = this.f158831d.iterator();
    L54:
        if (r110.hasNext() == false) goto L66;
        r110.next().start();
        goto L54
    L66:
        return;
    L39:
        Animator r111 = r107.next();
        if (r107.hasNext() == true) goto L42;
    L41:
        r108 = r111;
        goto L49
    L42:
        long r112 = a(r111);
    L43:
        Animator r113 = r107.next();
        long r114 = a(r113);
        if (r112 >= r114) goto L47;
        r111 = r113;
        r112 = r114;
    L47:
        if (r107.hasNext() == true) goto L43;
    L23:
        if (r106 != 2) goto L65;
        int r115 = this.f158831d.size();
        if (r115 < 2) goto L30;
        int r116 = r115 - 1;
        int r117 = 0;
    L28:
        if (r117 >= r116) goto L30;
        ((Animator) ListProtector.get(this.f158831d, r117)).addListener(new b(this, r117));
        r117 = r117 + 1;
    L30:
        Animator r118 = (Animator) CollectionsKt.lastOrNull(this.f158831d);
        if (r118 == null) goto L33;
        r118.addListener(new c(this));
    L33:
        Animator r119 = (Animator) CollectionsKt.firstOrNull(this.f158831d);
        if (r119 == null) goto L56;
        r119.start();
        return;
    L56:
        return;
    }

    public FrameAnimatorSet() {
        this.f158828a = -1;
        this.f158830c = PlayMode.Sequentially;
        this.f158831d = new ArrayList();
    }

    @Override // android.animation.Animator
    public final long getTotalDuration() {
        return d();
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.f158828a;
    }

    @Override // android.animation.Animator
    public final TimeInterpolator getInterpolator() {
        return this.f158829b;
    }

    public static long a(Animator r100) {
        if ((r100 instanceof FrameAnimatorSet) == false) goto L6;
        return ((FrameAnimatorSet) r100).d();
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        return r100.getTotalDuration();
    L9:
        return r100.getDuration();
    }

    public final void b(List<? extends Animator> r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f158830c = PlayMode.Sequentially;
        this.f158831d.clear();
        this.f158831d.addAll(r100);
    }

    public final void c(Collection<? extends Animator> r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f158830c = PlayMode.Together;
        this.f158831d.clear();
        this.f158831d.addAll(r100);
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long r100) {
        this.f158828a = r100;
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator r100) {
        this.f158829b = r100;
    }
}
