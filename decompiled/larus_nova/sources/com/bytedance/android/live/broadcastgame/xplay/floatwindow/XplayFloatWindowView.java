package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.xplay.l;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.n1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/floatwindow/XplayFloatWindowView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ViewHolder", "ViewState", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayFloatWindowView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f62085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f62086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.xplay.floatwindow.a f62087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewHolder f62088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vlc.d f62089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f62090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f62091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f62092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f62093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f62094j;

    public final class ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewState f62095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CompositeDisposable f62096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DuxTextView f62097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NoMoreSpaceTextView f62098d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FrameLayout f62099e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f62100f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ViewGroup f62101g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final DuxTextView f62102h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final View f62103i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ViewGroup f62104j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f62105k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final float f62106l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final float f62107m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f62108n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f62109o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f62110p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f62111q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f62112r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f62113s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final com.bytedance.android.live.broadcastgame.xplay.floatwindow.a f62114t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ XplayFloatWindowView f62115u;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowView$ViewHolder$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
        final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<View, Unit> {
            public AnonymousClass1(ViewHolder r100) {
                super(1, r100, ViewHolder.class, "onClickToggleLiveInfoBtn", "onClickToggleLiveInfoBtn(Landroid/view/View;)V", 0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View r100) {
                Intrinsics.checkNotNullParameter(r100, "p1");
                ViewHolder r101 = (ViewHolder) this.receiver;
                r101.getClass();
                if (n1.a() == false) goto L7;
                XplayFloatWindowView.S5(r101.f62115u, 1);
                XplayFloatWindowView r102 = r101.f62115u;
                boolean r103 = true ^ r102.f62085a;
                r102.f62085a = r103;
                r101.f62114t.f62140b.a(Boolean.valueOf(r103));
                return;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View r100) {
                invoke2(r100);
                return Unit.INSTANCE;
            }
        }

        public static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewHolder f62117a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f62118b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ float f62119c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f62120d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f62121e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f62122f;

            public a(ViewHolder r100, int r101, float r102, int r103, float r104, boolean r105) {
                this.f62117a = r100;
                this.f62118b = r101;
                this.f62119c = r102;
                this.f62120d = r103;
                this.f62121e = r104;
                this.f62122f = r105;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                Object r101 = r100.getAnimatedValue();
                if (r101 == null) goto L10;
                float r102 = ((Float) r101).floatValue();
                int r103 = this.f62118b;
                float r104 = r103 + ((this.f62119c - r103) * r102);
                int r105 = this.f62120d;
                float r106 = r105 + ((this.f62121e - r105) * r102);
                ViewGroup r107 = this.f62117a.f62104j;
                ViewGroup.LayoutParams r108 = r107.getLayoutParams();
                r108.width = (int) r104;
                r108.height = (int) r106;
                Unit r109 = Unit.INSTANCE;
                r107.setLayoutParams(r108);
                if (this.f62122f == false) goto L7;
                r102 = 1 - r102;
            L7:
                ViewHolder r110 = this.f62117a;
                r110.f62097c.setPadding(0, 0, (int) (r110.f62109o * r102), 0);
                return;
            L10:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public static final class b implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewHolder f62123a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f62124b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f62125c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f62126d;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, "animator");
                View r101 = this.f62124b;
                if (r101 == null) goto L6;
                r101.setVisibility(0);
                this.f62123a.f62104j.setBackground(null);
            L6:
                if (this.f62125c == false) goto L8;
                this.f62123a.f62097c.setText("开启直播间清屏");
                this.f62123a.f62097c.setAlpha(1.0f);
                this.f62123a.f62099e.setForeground(null);
                this.f62123a.f62100f.setVisibility(8);
            L10:
                if (this.f62126d == false) goto L16;
                RecyclerView r102 = (RecyclerView) this.f62123a.f62104j.findViewWithTag("messageRecyclerView");
                if (r102 == null) goto L16;
                RecyclerView.Adapter r103 = r102.getAdapter();
                if (r103 == null) goto L16;
                r102.smoothScrollToPosition(r103.getItemCount());
            L16:
                this.f62123a.f62110p = false;
                return;
            L8:
                this.f62123a.f62097c.setText("取消清屏");
                this.f62123a.f62097c.setAlpha(0.8f);
                this.f62123a.f62099e.setForeground(s1.m(R.drawable.ttlive_xplay_cast_float_dialog_icon_mask));
                this.f62123a.f62100f.setVisibility(0);
                goto L10
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, "animator");
                ViewHolder r101 = this.f62123a;
                Bitmap r102 = Bitmap.createBitmap((int) r101.f62105k, (int) r101.f62108n, Bitmap.Config.RGB_565);
                Canvas r103 = new Canvas(r102);
                this.f62123a.f62104j.draw(r103);
                this.f62123a.f62104j.setBackground(new BitmapDrawable(this.f62123a.f62115u.getResources(), r102));
                View r104 = this.f62124b;
                if (r104 == null) goto L6;
                r104.setVisibility(8);
                return;
            }

            public b(ViewHolder r100, View r101, boolean r102, boolean r103) {
                this.f62123a = r100;
                this.f62124b = r101;
                this.f62125c = r102;
                this.f62126d = r103;
            }
        }

        public final void c(ViewState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = XplayLog.f61931a;
            XplayLog.a("XplayFloatWindowView", "switchState " + r100 + " (" + r100.ordinal() + ')');
            this.f62096b.clear();
            this.f62095a = r100;
            int r102 = e.f62154b[r100.ordinal()];
            if (r102 != 1) goto L5;
            a(true, false);
            return;
        L5:
            if (r102 != 2) goto L7;
            a(false, false);
            return;
        L7:
            if (r102 != 3) goto L15;
            a(false, true);
            return;
        }

        public final void a(boolean r110, boolean r111) {
            this.f62110p = true;
            Drawable r100 = this.f62103i.getBackground();
            if (r100 == null) goto L28;
            GradientDrawable r101 = (GradientDrawable) r100;
            if (r110 == false) goto L7;
            int r102 = 12;
        L8:
            float r103 = UtilityKotlinExtentionsKt.h(r102);
            if (r110 == false) goto L11;
            float r112 = 1.0f;
        L12:
            if (r110 == false) goto L14;
            float r113 = 0.0f;
        L15:
            ObjectAnimator r114 = ObjectAnimator.ofFloat(r101, "cornerRadius", new float[]{r103});
            int r104 = this.f62104j.getWidth();
            int r105 = this.f62104j.getHeight();
            if (r110 == false) goto L19;
            float r106 = this.f62105k;
        L18:
            float r107 = r106;
            if (r110 == false) goto L24;
            float r108 = this.f62108n;
        L25:
            ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r109.addUpdateListener(new a(this, r104, r107, r105, r108, r110));
            ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f62104j, View.ALPHA, new float[]{r112});
            ObjectAnimator r116 = ObjectAnimator.ofFloat(this.f62101g, View.ALPHA, new float[]{r112});
            ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f62100f, View.ROTATION, new float[]{r113});
            View r118 = this.f62104j.getChildAt(0);
            AnimatorSet r119 = new AnimatorSet();
            r119.playTogether(new Animator[]{r114, r109, r115, r116, r117});
            r119.setDuration(200);
            r119.addListener(new b(this, r118, r111, r110));
            RxUtilKt.c(RxUtilKt.a(r119, true), this.f62096b);
            r119.start();
            return;
        L24:
            r108 = 0.0f;
            goto L25
        L19:
            if (r111 == false) goto L21;
            r106 = this.f62107m;
            goto L18
        L21:
            r106 = this.f62106l;
            goto L18
        L14:
            r113 = -180.0f;
            goto L15
        L11:
            r112 = 0.0f;
            goto L12
        L7:
            r102 = 15;
            goto L8
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public final void b(final IPublicScreenService r110, final k<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r111) {
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100 = this.f62111q;
            if ((!r100.isEmpty()) == false) goto L5;
            LinkedList r101 = (LinkedList) r100;
            r110.renderLiveMessageWithPublicScreenProcessor(((com.bytedance.android.livesdk.interactivity.api.entity.f) r101.poll()).f133141b, this.f62098d, r111);
            this.f62098d.setVisibility(0);
            boolean r102 = !r101.isEmpty();
            Function0<Unit> r103 = new XplayFloatWindowView$ViewHolder$showNextCollapsedAnim$1(this, r110, r111);
            ObjectAnimator r112 = ObjectAnimator.ofFloat(this.f62098d, View.ALPHA, new float[]{0.0f});
            r112.setDuration(250);
            r112.addListener(new f(this, r103, r102));
            ObjectAnimator r113 = ObjectAnimator.ofFloat(this.f62098d, View.TRANSLATION_Y, new float[]{-UtilityKotlinExtentionsKt.h(8), 0.0f});
            ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f62098d, View.ALPHA, new float[]{0.0f, 1.0f});
            AnimatorSet r105 = new AnimatorSet();
            r105.playTogether(new Animator[]{r113, r104});
            r105.addListener(new g(this, r112, r102));
            r105.setDuration(250);
            r105.start();
            this.f62112r = true;
            return;
        L5:
            this.f62112r = false;
        }

        public ViewHolder(XplayFloatWindowView r100, XplayFloatWindowView r101, com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r102) {
            Intrinsics.checkNotNullParameter(r101, "rootView");
            Intrinsics.checkNotNullParameter(r102, "floatWindowContext");
            this.f62115u = r100;
            this.f62114t = r102;
            this.f62096b = new CompositeDisposable();
            DuxTextView r103 = (DuxTextView) r101.findViewById(R.id.xplay_float_clear_tips_tv);
            this.f62097c = r103;
            this.f62098d = (NoMoreSpaceTextView) r101.findViewById(R.id.xplay_float_fold_message_text);
            FrameLayout r104 = (FrameLayout) r101.findViewById(R.id.xplay_float_icon_container);
            this.f62099e = r104;
            this.f62100f = r101.findViewById(R.id.xplay_float_fold_iv);
            ViewGroup r105 = (ViewGroup) r101.findViewById(R.id.xplay_float_audience_container);
            this.f62101g = r105;
            this.f62102h = (DuxTextView) r101.findViewById(R.id.xplay_float_audience_num_tv);
            this.f62103i = r101.findViewById(R.id.xplay_float_expanded_container);
            this.f62104j = (ViewGroup) r101.findViewById(R.id.xplay_float_message_container);
            this.f62105k = UtilityKotlinExtentionsKt.h(230);
            this.f62106l = UtilityKotlinExtentionsKt.h(86);
            this.f62107m = UtilityKotlinExtentionsKt.h(119);
            this.f62108n = UtilityKotlinExtentionsKt.h(146);
            this.f62109o = UtilityKotlinExtentionsKt.h(2);
            r103.setOnClickListener(new h(new AnonymousClass1(this)));
            r104.setOnClickListener(new com.bytedance.android.live.broadcastgame.xplay.floatwindow.d(this));
            r105.setOnClickListener(new AnonymousClass3(this));
            a1.n((HSImageView) r100.findViewById(R.id.xplay_float_icon_iv), r102.f62141c.f59508h.f59488e);
            this.f62111q = new LinkedList();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/floatwindow/XplayFloatWindowView$ViewState;", "", "InteractiveExpanded", "InteractiveCollapsed", "NonInteractive", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ViewState extends Enum<ViewState> {
        public static final ViewState InteractiveCollapsed = null;
        public static final ViewState InteractiveExpanded = null;
        public static final ViewState NonInteractive = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewState[] f62127a = null;

        static {
            ViewState r100 = new ViewState("InteractiveExpanded", 0);
            InteractiveExpanded = r100;
            ViewState r101 = new ViewState("InteractiveCollapsed", 1);
            InteractiveCollapsed = r101;
            ViewState r102 = new ViewState("NonInteractive", 2);
            NonInteractive = r102;
            f62127a = new ViewState[]{r100, r101, r102};
        }

        public static ViewState valueOf(String r100) {
            return (ViewState) r27.a.a(ViewState.class, r100);
        }

        public static ViewState[] values() {
            return (ViewState[]) f62127a.clone();
        }

        public ViewState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j80.d f62129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j80.d f62130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ XplayFloatWindowView f62131d;

        public b(XplayFloatWindowView r100) {
            this.f62131d = r100;
            this.f62128a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
            this.f62129b = new j80.d(0.0f, 0.0f);
            this.f62130c = new j80.d(0.0f, 0.0f);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KMutableProperty0 f62132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f62133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f62134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f62135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f62136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f62137f;

        public final RectF c() {
            ViewParent r100 = this.f62137f.getParent();
            if ((r100 instanceof ViewGroup) == true) goto L5;
            r100 = null;
        L5:
            ViewGroup r101 = (ViewGroup) r100;
            if (r101 == null) goto L8;
            this.f62134c.set(0.0f, 0.0f, r101.getWidth(), r101.getHeight());
            return this.f62134c;
        L8:
            return this.f62134c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RectF d() {
            this.f62133b.set(0.0f, 0.0f, this.f62137f.getWidth(), this.f62137f.getHeight());
            this.f62133b.offsetTo(((j80.d) this.f62132a.get()).a().floatValue(), ((j80.d) this.f62132a.get()).b().floatValue());
            return this.f62133b;
        }

        public final j80.d a() {
            RectF r100 = d();
            j80.d r101 = b(r100, c());
            Intrinsics.checkNotNullParameter(r100, "$this$pos");
            j80.d r102 = new j80.d(r100.left, r100.top);
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            this.f62132a.set(r102);
            return r101;
        }

        public c(final View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f62137f = r100;
            this.f62132a = new XplayFloatWindowView$PositionManager$localPos$2(r100);
            this.f62133b = new RectF();
            this.f62134c = new RectF();
            this.f62135d = new int[2];
        }

        public final void e(int[] r100) {
            ViewParent r101 = this.f62137f.getParent();
            if ((r101 instanceof ViewGroup) == true) goto L5;
            r101 = null;
        L5:
            ViewGroup r102 = (ViewGroup) r101;
            if (r102 != null) goto L8;
            return;
        L8:
            int[] r103 = new int[2];
            r102.getLocationOnScreen(r103);
            j80.d r104 = j80.c.b(new j80.d(r100[0], r100[1]), new j80.d(r103[0], r103[1]));
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            this.f62132a.set(r104);
        }

        public static j80.d b(RectF r100, RectF r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$constrainWithinBorder");
            Intrinsics.checkNotNullParameter(r101, "border");
            float r102 = Math.max(0.0f, r101.left - r100.left);
            float r103 = Math.min(0.0f, r101.right - r100.right);
            float r104 = r102 + r103;
            float r105 = Math.max(0.0f, r101.top - r100.top) + Math.min(0.0f, r101.bottom - r100.bottom);
            r100.offset(r104, r105);
            return new j80.d(r104, r105);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f62138a;

        public d(ViewHolder r100) {
            this.f62138a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            this.f62138a.c(ViewState.InteractiveExpanded);
            return;
        L5:
            this.f62138a.c(ViewState.NonInteractive);
        }
    }

    static {
    }

    public XplayFloatWindowView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public XplayFloatWindowView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewHolder r100 = this.f62088d;
        if (r100 == null) goto L26;
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r101 = this.f62087c;
        if (r101 == null) goto L26;
        IPublicScreenService r102 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        if (r102 == null) goto L22;
        View r103 = r102.createFloatTextMessageView(r101.f62139a, getContext(), false, true, new XplayFloatWindowView$setupMessageArea$view$1(this));
        View r104 = null;
        if ((r103 instanceof ViewGroup) == true) goto L13;
        View r105 = null;
    L14:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L17;
        r104 = r106.getChildAt(0);
    L17:
        if (r104 == null) goto L21;
        int r107 = (int) UtilityKotlinExtentionsKt.h(6);
        r104.setPadding(r107, 0, r107, r107);
        if ((r104 instanceof RecyclerView) == false) goto L21;
        ((RecyclerView) r104).setTag("messageRecyclerView");
    L21:
        ViewGroup r108 = r100.f62104j;
        r108.removeAllViews();
        r108.addView(r103);
    L23:
        this.f62090f = new i(r100);
        vlc.d r109 = (vlc.d) r101.f62139a.get("data_message_manager");
        this.f62089e = r109;
        if (r109 == null) goto L26;
        d4.b(r109, "WebcastRoomStatsMessage", this.f62090f);
        goto L26
    L13:
        r105 = r103;
        goto L14
    L22:
        XplayLog.b("XplayFloatWindowView", "failed to obtain IPublicScreenService");
    L26:
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r110 = this.f62087c;
        if (r110 != null) goto L29;
        return;
    L29:
        ViewHolder r111 = this.f62088d;
        if (r111 != null) goto L32;
        return;
    L32:
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r110.f62140b).subscribe(new d(r111)), this.f62086b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewHolder r100 = this.f62088d;
        if (r100 == null) goto L8;
        r100.f62104j.removeAllViews();
        vlc.d r101 = this.f62089e;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this.f62090f);
    L8:
        this.f62086b.clear();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        b r101 = this.f62092h;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        r101.f62130c = j80.b.c(r100);
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L15;
        return true;
    L15:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r102 != 2) goto L11;
        if (j80.c.a(j80.b.c(r100), r101.f62130c) < r101.f62128a) goto L11;
        r101.f62129b = j80.b.c(r100);
        r101.f62131d.requestDisallowInterceptTouchEvent(true);
        r101.f62131d.getClass();
        R5(r101.f62131d, j80.c.b(j80.b.c(r100), r101.f62130c));
        r103 = true;
        goto L12
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        b r101 = this.f62092h;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L6;
        c r103 = r101.f62131d.f62091g;
        r103.f62137f.getLocationOnScreen(r103.f62135d);
        r101.f62131d.performClick();
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        return true;
    L18:
        return super.onTouchEvent(r100);
    L6:
        if (r102 != 2) goto L8;
        j80.d r105 = j80.c.b(j80.b.c(r100), r101.f62129b);
        r101.f62129b = j80.b.c(r100);
        R5(r101.f62131d, r105);
        goto L14
    L8:
        if (r102 == 3) goto L10;
        r104 = false;
        goto L15
    L10:
        c r106 = r101.f62131d.f62091g;
        r106.f62137f.getLocationOnScreen(r106.f62135d);
        goto L14
    L13:
        r101.f62129b = j80.b.c(r100);
        r101.f62131d.requestDisallowInterceptTouchEvent(true);
        r101.f62131d.getClass();
        goto L14
    }

    public static final void R5(XplayFloatWindowView r100, j80.d r101) {
        c r102 = r100.f62091g;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "offset");
        RectF r103 = r102.d();
        r103.offset(r101.a().floatValue(), r101.b().floatValue());
        c.b(r103, r102.c());
        Intrinsics.checkNotNullParameter(r103, "$this$pos");
        j80.d r104 = new j80.d(r103.left, r103.top);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f62132a.set(r104);
    }

    public static final void S5(XplayFloatWindowView r100, int r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r103 = r100.f62087c;
        if (r103 == null) goto L5;
        T5(r102, r103);
    L5:
        r102.put("click_location", String.valueOf(r101));
        u.l().sendLog("livesdk_barrage_clear_screen_page_click", r102, new Object[]{Room.class});
    }

    public static void T5(Map r100, com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r101) {
        r100.put("is_clear_screen", m2.b(r101.f62140b.getValue().booleanValue()));
        l r102 = r101.f62141c.f59508h;
        r100.put(EventConstants.ExtraJson.GAME_NAME, r102.f59486c);
        r100.put("game_app_id", r102.f59485b);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L9;
        LinkedHashMap r102 = new LinkedHashMap();
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r103 = this.f62087c;
        if (r103 == null) goto L7;
        T5(r102, r103);
    L7:
        u.l().sendLog("livesdk_barrage_clear_screen_page_show", r102, new Object[]{Room.class});
        return;
    }

    public XplayFloatWindowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f62086b = new CompositeDisposable();
        this.f62091g = new c(this);
        this.f62092h = new b(this);
    }

    public /* synthetic */ XplayFloatWindowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f62093i = true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        boolean r105 = true;
        if (this.f62094j == false) goto L18;
        this.f62094j = false;
        c r106 = this.f62091g;
        r106.e(r106.f62135d);
        if (this.f62091g.a().b().floatValue() == 0.0f) goto L16;
        XplayLog.a("XplayFloatWindowView", "window position restore failed, moving to default position");
        c r107 = this.f62091g;
        int[] r108 = r107.f62136e;
        if (r108 != null) goto L9;
        boolean r109 = false;
    L10:
        if (r109 == true) goto L15;
        float r110 = t6.a(getContext(), 132.0f);
        c r111 = this.f62091g;
        j80.d r112 = new j80.d(0.0f, r110);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        RectF r113 = r111.d();
        r113.offsetTo(r112.a().floatValue(), r112.b().floatValue());
        c.b(r113, r111.c());
        Intrinsics.checkNotNullParameter(r113, "$this$pos");
        j80.d r114 = new j80.d(r113.left, r113.top);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r111.f62132a.set(r114);
        c r115 = this.f62091g;
        if (r115.f62136e != null) goto L15;
        int[] r116 = new int[2];
        r115.f62137f.getLocationOnScreen(r116);
        r115.f62136e = r116;
    L15:
        this.f62091g.a();
        c r117 = this.f62091g;
        r117.f62137f.getLocationOnScreen(r117.f62135d);
        goto L18
    L9:
        r107.e(r108);
        r109 = true;
        goto L10
    L16:
        c r118 = this.f62091g;
        r118.f62137f.getLocationOnScreen(r118.f62135d);
        XplayLog.a("XplayFloatWindowView", "window position restored");
    L18:
        if (this.f62093i == false) goto L28;
        this.f62093i = false;
        j80.d r119 = this.f62091g.a();
        Intrinsics.checkNotNullParameter(r119, "$this$isZero");
        if (r119.a().floatValue() == 0.0f) goto L22;
    L24:
        r105 = false;
    L25:
        if (r105 == true) goto L29;
        XplayLog.a("XplayFloatWindowView", "constrain after window resize");
        c r120 = this.f62091g;
        r120.f62137f.getLocationOnScreen(r120.f62135d);
        return;
    L29:
        return;
    L22:
        if (r119.b().floatValue() != 0.0f) goto L24;
    }
}
