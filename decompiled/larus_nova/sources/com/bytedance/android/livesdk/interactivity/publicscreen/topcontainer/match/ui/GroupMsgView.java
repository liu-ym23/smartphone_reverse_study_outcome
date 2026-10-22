package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.w;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qa2.l;
import ra2.j;
import ra2.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002BCB\u0019\u0012\u0006\u0010=\u001a\u00020<\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010 \u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView;", "Landroid/widget/FrameLayout;", "Lqa2/l;", "callback", "", "setCallback", "", "getCurCombo", "", "getEnterAnimStartPos", "getEnterAnimEndPos", "getBattleInPos", "getBattleOutPos", "getBattleInWithWebpPos", "getBattleOutWithWebpPos", "getContainerUpPos", "getContainerDownPos", "", "B", "Z", "getEntered", "()Z", "setEntered", "(Z)V", "entered", "C", "getWebpEntered", "setWebpEntered", "webpEntered", "D", "getBattleEnd", "setBattleEnd", "battleEnd", ExifInterface.LONGITUDE_EAST, "getDismissed", "setDismissed", "dismissed", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", FaceService.girlLabel, "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "getPos", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "setPos", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "G", "Ljava/lang/Boolean;", "getImgLoadStatus", "()Ljava/lang/Boolean;", "setImgLoadStatus", "(Ljava/lang/Boolean;)V", "imgLoadStatus", "Lio/reactivex/disposables/Disposable;", FaceService.neutralLabel, "Lio/reactivex/disposables/Disposable;", "getLoadBgDisposable", "()Lio/reactivex/disposables/Disposable;", "setLoadBgDisposable", "(Lio/reactivex/disposables/Disposable;)V", "loadBgDisposable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GroupAnimType", "GroupType", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupMsgView extends FrameLayout {
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public GroupAnimType F;
    public Boolean G;
    public Disposable H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f140080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GroupType f140081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f140082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f140083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f140084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f140085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f140086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f140087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f140088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f140089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f140090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f140091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AnimatorSet f140092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AnimatorSet f140093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AnimatorSet f140094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnimatorSet f140095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f140096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AnimatorSet f140097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatedDrawable2 f140098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f140099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k f140100u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f140101v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f140102w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f140103x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f140104y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f140105z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupAnimType;", "", "TOP", "DOWN", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GroupAnimType extends Enum<GroupAnimType> {
        public static final GroupAnimType DOWN = null;
        public static final GroupAnimType TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupAnimType[] f140106a = null;

        static {
            GroupAnimType r100 = new GroupAnimType("TOP", 0);
            TOP = r100;
            GroupAnimType r101 = new GroupAnimType("DOWN", 1);
            DOWN = r101;
            f140106a = new GroupAnimType[]{r100, r101};
        }

        public static GroupAnimType valueOf(String r100) {
            return (GroupAnimType) r27.a.a(GroupAnimType.class, r100);
        }

        public static GroupAnimType[] values() {
            return (GroupAnimType[]) f140106a.clone();
        }

        public GroupAnimType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/GroupMsgView$GroupType;", "", "", "value", "I", "getValue", "()I", "LEFT", "RIGHT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType LEFT = null;
        public static final GroupType RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupType[] f140107a = null;
        private final int value;

        static {
            GroupType r100 = new GroupType("LEFT", 0, 0);
            LEFT = r100;
            GroupType r101 = new GroupType("RIGHT", 1, 1);
            RIGHT = r101;
            f140107a = new GroupType[]{r100, r101};
        }

        public static GroupType valueOf(String r100) {
            return (GroupType) r27.a.a(GroupType.class, r100);
        }

        public static GroupType[] values() {
            return (GroupType[]) f140107a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public GroupType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140108a;

        public a(GroupMsgView r100) {
            this.f140108a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f140108a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140109a;

        public b(GroupMsgView r100) {
            this.f140109a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f140109a.getDismissed() == true) goto L8;
            this.f140109a.setBattleEnd(true);
            l r101 = this.f140109a.f140091l;
            if (r101 == null) goto L9;
            r101.c();
            return;
        L9:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140110a;

        public c(GroupMsgView r100) {
            this.f140110a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f140110a.getDismissed() == true) goto L8;
            this.f140110a.setBattleEnd(true);
            l r101 = this.f140110a.f140091l;
            if (r101 == null) goto L9;
            r101.c();
            return;
        L9:
            return;
        }
    }

    public static final class d implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScaleAnimation f140112b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            ViewGroup r101 = this.f140111a.f140085f;
            if (r101 == null) goto L6;
            r101.startAnimation(this.f140112b);
            return;
        }

        public d(GroupMsgView r100, ScaleAnimation r101) {
            this.f140111a = r100;
            this.f140112b = r101;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140113a;

        public e(GroupMsgView r100) {
            this.f140113a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f140113a.getDismissed() == true) goto L8;
            this.f140113a.setEntered(true);
            l r101 = this.f140113a.f140091l;
            if (r101 == null) goto L9;
            r101.e();
            return;
        L9:
            return;
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140114a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public f(GroupMsgView r100) {
            this.f140114a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f140114a.setDismissed(true);
            l r101 = this.f140114a.f140091l;
            if (r101 == null) goto L6;
            r101.onEnd();
            return;
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GroupAnimType f140116b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f140115a.setPos(this.f140116b);
        }

        public g(GroupMsgView r100, GroupAnimType r101) {
            this.f140115a = r100;
            this.f140116b = r101;
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupMsgView f140117a;

        public h(GroupMsgView r100) {
            this.f140117a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f140117a.getDismissed() == true) goto L9;
            this.f140117a.setWebpEntered(true);
            l r101 = this.f140117a.f140091l;
            if (r101 == null) goto L7;
            r101.d();
        L7:
            this.f140117a.f140101v = 0;
            return;
        }
    }

    public final void l() {
        this.f140091l = null;
        f(this.f140092m);
        f(this.f140093n);
        f(this.f140094o);
        f(this.f140095p);
        f(this.f140096q);
        f(this.f140097r);
        removeCallbacks(this.f140100u);
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L5;
        r100.clearAnimation();
    L5:
        ViewGroup r101 = this.f140085f;
        if (r101 == null) goto L8;
        r101.clearAnimation();
    L8:
        Disposable r102 = this.H;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        clearAnimation();
    }

    private final float getBattleInPos() {
        if (this.f140081b != GroupType.LEFT) goto L6;
        int r100 = (this.f140102w * (-1)) + this.f140104y;
    L11:
        return r100;
    L6:
        ViewGroup r101 = this.f140080a;
        if (r101 == null) goto L9;
        r100 = (r101.getLeft() + this.f140102w) - this.f140104y;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getBattleInWithWebpPos() {
        if (this.f140081b != GroupType.LEFT) goto L7;
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L12;
        int r101 = r100.getLeft() + this.f140104y;
    L11:
        return r101;
    L12:
        return 0.0f;
    L7:
        ViewGroup r102 = this.f140080a;
        if (r102 == null) goto L13;
        r101 = r102.getLeft() - this.f140104y;
        goto L11
    L13:
        return 0.0f;
    }

    private final float getBattleOutPos() {
        if (this.f140081b != GroupType.LEFT) goto L6;
        int r100 = this.f140102w * (-1);
    L11:
        return r100;
    L6:
        ViewGroup r101 = this.f140080a;
        if (r101 == null) goto L9;
        r100 = r101.getLeft() + this.f140102w;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getBattleOutWithWebpPos() {
        if (this.f140081b != GroupType.LEFT) goto L7;
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L12;
        int r101 = r100.getLeft();
    L11:
        return r101;
    L12:
        return 0.0f;
    L7:
        ViewGroup r102 = this.f140080a;
        if (r102 == null) goto L13;
        r101 = r102.getLeft();
        goto L11
    L13:
        return 0.0f;
    }

    private final float getContainerDownPos() {
        if (this.f140081b != GroupType.LEFT) goto L7;
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L12;
        int r101 = r100.getTop() + this.f140103x;
    L11:
        return r101;
    L12:
        return 0.0f;
    L7:
        ViewGroup r102 = this.f140080a;
        if (r102 == null) goto L13;
        r101 = r102.getTop();
        goto L11
    L13:
        return 0.0f;
    }

    private final float getContainerUpPos() {
        if (this.f140081b != GroupType.LEFT) goto L7;
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L12;
        int r101 = r100.getTop();
    L11:
        return r101;
    L12:
        return 0.0f;
    L7:
        ViewGroup r102 = this.f140080a;
        if (r102 == null) goto L13;
        r101 = r102.getTop() - this.f140103x;
        goto L11
    L13:
        return 0.0f;
    }

    private final float getEnterAnimEndPos() {
        if (this.f140081b != GroupType.LEFT) goto L6;
        int r100 = (this.f140102w * (-1)) + this.f140104y;
    L11:
        return r100;
    L6:
        ViewGroup r101 = this.f140080a;
        if (r101 == null) goto L9;
        r100 = (r101.getLeft() + this.f140102w) - this.f140104y;
        goto L11
    L9:
        return 0.0f;
    }

    private final float getEnterAnimStartPos() {
        if (this.f140081b != GroupType.LEFT) goto L8;
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L15;
        int r101 = r100.getWidth() * (-1);
    L16:
        return r101;
    L15:
        return 0.0f;
    L8:
        ViewGroup r102 = this.f140080a;
        if (r102 == null) goto L17;
        int r103 = r102.getLeft();
        ViewGroup r104 = this.f140080a;
        if (r104 == null) goto L13;
        int r105 = r104.getWidth();
    L14:
        r101 = r103 + r105;
        goto L16
    L13:
        r105 = 0;
        goto L14
    L17:
        return 0.0f;
    }

    public final void b() {
        ViewGroup r100 = this.f140080a;
        if (r100 == null) goto L5;
        r100.setAlpha(1.0f);
    L5:
        this.B = true;
        HSImageView r101 = this.f140086g;
        if (r101 == null) goto L8;
        r101.setAlpha(1.0f);
    L8:
        AnimatedDrawable2 r102 = this.f140098s;
        if (r102 == null) goto L11;
        r102.jumpToFrame(r102.getFrameCount() - 1);
    L11:
        int r103 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r104 = this.f140080a;
        if (r104 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r104, getBattleOutPos(), getBattleInWithWebpPos(), 0, 0.66f, 0.0f, 0.34f).start();
        this.C = true;
        postDelayed(new a(this), 10000);
    }

    public final void c() {
        AnimatorSet r100 = new AnimatorSet();
        Animator[] r101 = new Animator[2];
        int r102 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r103 = this.f140080a;
        if (r103 != null) goto L5;
        return;
    L5:
        r101[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r103, getBattleInWithWebpPos(), getBattleOutWithWebpPos(), 1000, 0.84f, 0.0f, 0.16f);
        ViewGroup r104 = this.f140080a;
        if (r104 != null) goto L8;
        return;
    L8:
        r101[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r104, getBattleOutWithWebpPos(), getBattleInWithWebpPos(), 1000, 0.84f, 0.0f, 0.16f);
        r100.playSequentially(r101);
        Unit r105 = Unit.INSTANCE;
        this.f140094o = r100;
        r100.addListener(new b(this));
        AnimatorSet r106 = this.f140094o;
        if (r106 == null) goto L12;
        r106.start();
        return;
    }

    public final void d() {
        AnimatorSet r100 = new AnimatorSet();
        Animator[] r101 = new Animator[2];
        int r102 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        View r103 = this.f140080a;
        if (r103 != null) goto L6;
        r103 = new View(getContext());
    L6:
        r101[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r103, getBattleInPos(), getBattleOutPos(), 1000, 0.84f, 0.0f, 0.16f);
        View r104 = this.f140080a;
        if (r104 != null) goto L10;
        r104 = new View(getContext());
    L10:
        r101[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r104, getBattleOutPos(), getBattleInPos(), 1000, 0.84f, 0.0f, 0.16f);
        r100.playSequentially(r101);
        Unit r105 = Unit.INSTANCE;
        this.f140096q = r100;
        r100.addListener(new c(this));
        AnimatorSet r106 = this.f140096q;
        if (r106 == null) goto L14;
        r106.start();
        return;
    }

    public final Float e() {
        TextView r100 = this.f140087h;
        CharSequence r101 = null;
        if (r100 == null) goto L11;
        TextPaint r102 = r100.getPaint();
        if (r102 == null) goto L12;
        TextView r103 = this.f140087h;
        if (r103 == null) goto L10;
        r101 = r103.getText();
    L10:
        return Float.valueOf(((r102.measureText(String.valueOf(r101)) + this.f140090k.getPaint().measureText(this.f140090k.getText().toString())) + this.f140089j.getPaint().measureText(this.f140089j.getText().toString())) + s1.f(71));
    L12:
        return null;
    L11:
        return null;
    }

    public final long getCurCombo() {
        return CastLongProtector.parseLong(this.f140090k.getText().toString());
    L4:
        return 0;
    }

    public final void h() {
        AnimatorSet r100 = new AnimatorSet();
        Animator[] r101 = new Animator[2];
        int r102 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r103 = this.f140080a;
        if (r103 != null) goto L5;
        return;
    L5:
        r101[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a(r103);
        ViewGroup r104 = this.f140080a;
        if (r104 != null) goto L8;
        return;
    L8:
        r101[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r104, getEnterAnimStartPos(), getEnterAnimEndPos(), 1250, 0.14f, 1.0f, 0.34f);
        r100.playTogether(r101);
        Unit r105 = Unit.INSTANCE;
        this.f140092m = r100;
        r100.addListener(new e(this));
        AnimatorSet r106 = this.f140092m;
        if (r106 == null) goto L12;
        r106.start();
        return;
    }

    public final void i() {
        removeCallbacks(this.f140100u);
        AnimatorSet r100 = new AnimatorSet();
        this.f140097r = r100;
        ViewGroup r101 = this.f140080a;
        if (r101 == null) goto L5;
        r100.play(ObjectAnimator.ofFloat(r101, "alpha", new float[]{1.0f, 0.0f}));
    L5:
        AnimatorSet r102 = this.f140097r;
        if (r102 == null) goto L8;
        r102.setDuration(300);
    L8:
        AnimatorSet r103 = this.f140097r;
        if (r103 == null) goto L11;
        r103.addListener(new f(this));
    L11:
        AnimatorSet r104 = this.f140097r;
        if (r104 == null) goto L15;
        r104.start();
        return;
    }

    public final void n() {
        AnimatorSet r100 = new AnimatorSet();
        Animator[] r101 = new Animator[2];
        int r102 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        HSImageView r103 = this.f140086g;
        if (r103 != null) goto L5;
        return;
    L5:
        r101[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.a(r103);
        ViewGroup r104 = this.f140080a;
        if (r104 != null) goto L8;
        return;
    L8:
        int r105 = 1;
        r101[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.d(r104, getBattleOutPos(), getBattleInWithWebpPos(), 1000, 0.66f, 0.0f, 0.34f);
        r100.playTogether(r101);
        Unit r106 = Unit.INSTANCE;
        this.f140095p = r100;
        r100.addListener(new h(this));
        HSImageView r107 = this.f140086g;
        Animatable r108 = null;
        if (r107 == null) goto L13;
        DraweeController r109 = r107.getController();
        if (r109 == null) goto L13;
        Animatable r110 = r109.getAnimatable();
    L15:
        if ((r110 instanceof AnimatedDrawable2) == false) goto L18;
        r108 = r110;
    L18:
        AnimatedDrawable2 r111 = (AnimatedDrawable2) r108;
        this.f140098s = r111;
        if (r111 == null) goto L24;
        long r112 = r111.getLoopDurationMs();
        AnimatedDrawable2 r113 = this.f140098s;
        if (r113 == null) goto L23;
        r105 = r113.getFrameCount();
    L23:
        long r114 = r112 / ((long) r105);
    L25:
        this.f140099t = r114;
        post(this.f140100u);
        AnimatorSet r115 = this.f140095p;
        if (r115 == null) goto L29;
        r115.start();
        return;
    L29:
        return;
    L24:
        r114 = 50;
    L13:
        r110 = null;
        goto L15
    }

    public final void k() {
        com.bytedance.android.livesdk.interactivity.api.h r100 = q.g();
        GroupType r101 = this.f140081b;
        GroupType r102 = GroupType.LEFT;
        py.k r103 = null;
        if (r101 != r102) goto L10;
        if (r100 == null) goto L16;
        m<t> r104 = r100.getMatchChatInfo();
        if (r104 == null) goto L16;
        t r105 = r104.getValue();
        if (r105 == null) goto L16;
        py.k r106 = r105.mainGroupBg;
    L18:
        if (this.f140081b != r102) goto L25;
        if (r100 == null) goto L31;
        m<t> r107 = r100.getMatchChatInfo();
        if (r107 == null) goto L31;
        t r108 = r107.getValue();
        if (r108 == null) goto L31;
        r103 = r108.mainGroupIcon;
    L31:
        if (r106 == null) goto L36;
        if (r103 == null) goto L36;
        a1.k(r106).observeOn(AndroidSchedulers.mainThread()).subscribe(new ra2.l(this));
        ImageLoader.bindGifImage(this.f140086g, r103, new j(this));
        return;
    L36:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("GroupMsgView image load failed. bg is null or icon is null");
        this.G = Boolean.FALSE;
        l r109 = this.f140091l;
        if (r109 == null) goto L40;
        r109.a();
        return;
    L40:
        return;
    L25:
        if (r100 == null) goto L31;
        m<t> r110 = r100.getMatchChatInfo();
        if (r110 == null) goto L31;
        t r111 = r110.getValue();
        if (r111 == null) goto L31;
        r103 = r111.guestGroupIcon;
    L16:
        r106 = null;
        goto L18
    L10:
        if (r100 == null) goto L16;
        m<t> r112 = r100.getMatchChatInfo();
        if (r112 == null) goto L16;
        t r113 = r112.getValue();
        if (r113 == null) goto L16;
        r106 = r113.guestGroupBg;
        goto L18
    }

    public final boolean getBattleEnd() {
        return this.D;
    }

    public final boolean getDismissed() {
        return this.E;
    }

    public final boolean getEntered() {
        return this.B;
    }

    public final Boolean getImgLoadStatus() {
        return this.G;
    }

    public final Disposable getLoadBgDisposable() {
        return this.H;
    }

    public final GroupAnimType getPos() {
        return this.F;
    }

    public final boolean getWebpEntered() {
        return this.C;
    }

    public static final void a(GroupMsgView r100) {
        if (Intrinsics.areEqual(r100.G, Boolean.FALSE) == false) goto L7;
        l r101 = r100.f140091l;
        if (r101 == null) goto L13;
        r101.a();
        return;
    L13:
        return;
    L7:
        int r102 = r100.A + 1;
        r100.A = r102;
        if (r102 != 2) goto L15;
        r100.G = Boolean.TRUE;
        l r103 = r100.f140091l;
        if (r103 == null) goto L16;
        r103.b();
        return;
    L16:
        return;
    }

    public static void f(AnimatorSet r100) {
        if (r100 == null) goto L4;
        r100.removeAllListeners();
    L4:
        if (r100 == null) goto L7;
        r100.cancel();
        return;
    }

    public final void j(g3 r100) {
        if (this.f140088i == true) goto L10;
        this.f140088i = true;
        Typeface r101 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L8
        this.f140089j.setTypeface(r101);     // Catch: Exception -> L8
        this.f140090k.setTypeface(r101);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        this.f140088i = false;
        String r102 = "load font asset exception: " + e.getMessage();
        int r103 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.f140149a;
        Intrinsics.checkNotNullParameter(r102, "info");
        ALogger.e("MatchMsgTAG", r102);
    L10:
        TextView r104 = this.f140087h;
        Long r105 = null;
        if (r104 == null) goto L16;
        if (r100 == null) goto L14;
        String r106 = r100.getContent();
    L15:
        r104.setText(r106);
        goto L16
    L14:
        r106 = null;
    L16:
        TextView r107 = this.f140090k;
        if (r107 == null) goto L24;
        if (r100 == null) goto L20;
        r105 = Long.valueOf(r100.getCount());
    L20:
        r107.setText(String.valueOf(r105));
        return;
    }

    public final void m(GroupAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != GroupAnimType.TOP) goto L8;
        AnimatorSet r101 = new AnimatorSet();
        Animator[] r102 = new Animator[1];
        int r103 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r104 = this.f140080a;
        if (r104 != null) goto L7;
        return;
    L7:
        r102[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.e(r104, getContainerDownPos(), getContainerUpPos());
        r101.playSequentially(r102);
        Unit r105 = Unit.INSTANCE;
    L12:
        this.f140093n = r101;
        r101.addListener(new g(this, r100));
        AnimatorSet r106 = this.f140093n;
        if (r106 == null) goto L16;
        r106.start();
        return;
    L16:
        return;
    L8:
        r101 = new AnimatorSet();
        Animator[] r107 = new Animator[1];
        int r108 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r109 = this.f140080a;
        if (r109 != null) goto L11;
        return;
    L11:
        r107[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.e(r109, getContainerUpPos(), getContainerDownPos());
        r101.playSequentially(r107);
        Unit r110 = Unit.INSTANCE;
        goto L12
    }

    public final void setBattleEnd(boolean r100) {
        this.D = r100;
    }

    public final void setCallback(l r100) {
        this.f140091l = r100;
    }

    public final void setDismissed(boolean r100) {
        this.E = r100;
    }

    public final void setEntered(boolean r100) {
        this.B = r100;
    }

    public final void setImgLoadStatus(Boolean r100) {
        this.G = r100;
    }

    public final void setLoadBgDisposable(Disposable r100) {
        this.H = r100;
    }

    public final void setPos(GroupAnimType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.F = r100;
    }

    public final void setWebpEntered(boolean r100) {
        this.C = r100;
    }

    public GroupMsgView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        GroupType r101 = GroupType.LEFT;
        this.f140081b = r101;
        this.f140099t = 50;
        Integer r102 = w.f472066a.getValue();
        s1.j(R.dimen.ttlive_match_group_view_up_down_offset);
        this.f140102w = s1.j(R.dimen.ttlive_match_group_view_offset);
        this.f140103x = s1.j(R.dimen.ttlive_match_group_view_top_down_offset);
        this.f140104y = s1.j(R.dimen.ttlive_match_group_view_battle_depth);
        s1.j(R.dimen.ttlive_match_group_view_righttype_margin_right);
        int r103 = s1.j(R.dimen.ttlive_match_group_view_righttype_margin_left);
        GroupAnimType r104 = GroupAnimType.TOP;
        this.F = r104;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_group_msg_view, this);
        this.f140080a = (ViewGroup) findViewById(R.id.group_container);
        this.f140082c = (ViewGroup) findViewById(R.id.text_container);
        this.f140083d = (HSImageView) findViewById(R.id.text_container_bg);
        ViewGroup r105 = (ViewGroup) findViewById(R.id.hot_msg_text_layout);
        this.f140084e = r105;
        HSImageView r106 = (HSImageView) findViewById(R.id.webp_image);
        this.f140086g = r106;
        this.f140089j = (TextView) findViewById(R.id.hot_msg_combo_count_x);
        this.f140090k = (TextView) findViewById(R.id.hot_msg_combo_count);
        this.f140087h = (TextView) findViewById(R.id.hot_msg_content);
        this.f140085f = (ViewGroup) findViewById(R.id.hot_msg_combo_body);
        if (r110 != null) goto L6;
    L21:
        this.f140100u = new k(this);
        return;
    L6:
        if (r100.obtainStyledAttributes(r110, new int[]{R.attr.ttlive_group_style}).getInt(0, 0) != 0) goto L8;
        GroupType r107 = r101;
    L9:
        this.f140081b = r107;
        if (r107 != r101) goto L15;
        if (r106 == null) goto L13;
        com.bytedance.android.live.core.utils.a1.j(r106, 3);
    L13:
        this.F = r104;
        goto L21
    L15:
        if (r107 != GroupType.RIGHT) goto L21;
        if (r106 == null) goto L18;
        com.bytedance.android.live.core.utils.a1.j(r106, 5);
    L18:
        this.F = GroupAnimType.DOWN;
        if (r105 == null) goto L21;
        com.bytedance.android.live.core.utils.a1.m(r105, r103);
        goto L21
    L8:
        r107 = GroupType.RIGHT;
        goto L9
    }

    public final void g(Long r110, boolean r111) {
        TextView r100 = this.f140090k;
        if (r110 == null) goto L5;
        String r112 = String.valueOf(r110.longValue());
    L6:
        r100.setText(r112);
        ViewGroup r113 = this.f140082c;
        int r101 = 0;
        if (r113 == null) goto L13;
        Float r102 = e();
        if (r102 == null) goto L11;
        int r103 = (int) r102.floatValue();
    L12:
        q32.a.a(r113, r103);
        goto L13
    L11:
        r103 = 0;
    L13:
        HSImageView r114 = this.f140083d;
        if (r114 == null) goto L20;
        Float r104 = e();
        if (r104 == null) goto L18;
        r101 = (int) r104.floatValue();
    L18:
        q32.a.a(r114, r101);
    L20:
        if (this.f140105z == true) goto L30;
        ViewGroup r115 = this.f140085f;
        float r105 = 0.0f;
        if (r115 == null) goto L24;
        r115.setPivotX(0.0f);
    L24:
        ViewGroup r116 = this.f140085f;
        if (r116 == null) goto L29;
        if (r116 == null) goto L28;
        r105 = r116.getHeight();
    L28:
        r116.setPivotY(r105);
    L29:
        this.f140105z = true;
    L30:
        if (r111 == false) goto L32;
        return;
    L32:
        int r117 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r118 = this.f140085f;
        if (r118 == null) goto L44;
        float r106 = r118.getPivotX();
        ViewGroup r119 = this.f140085f;
        if (r119 == null) goto L45;
        ScaleAnimation r120 = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, r106, r119.getPivotY());
        r120.setDuration(50);
        r120.setFillAfter(true);
        r120.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        ViewGroup r107 = this.f140085f;
        if (r107 == null) goto L46;
        float r108 = r107.getPivotX();
        ViewGroup r109 = this.f140085f;
        if (r109 == null) goto L47;
        ScaleAnimation r121 = new ScaleAnimation(1.15f, 1.0f, 1.15f, 1.0f, r108, r109.getPivotY());
        r121.setDuration(200);
        r121.setFillAfter(true);
        r121.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        r120.setAnimationListener(new d(this, r121));
        ViewGroup r122 = this.f140085f;
        if (r122 == null) goto L48;
        r122.startAnimation(r120);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r112 = null;
        goto L6
    }
}
