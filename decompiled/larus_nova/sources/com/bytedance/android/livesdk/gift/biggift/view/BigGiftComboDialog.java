package com.bytedance.android.livesdk.gift.biggift.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.biggift.viewModel.BigGiftViewModel;
import com.bytedance.android.livesdk.gift.biggift.viewModel.CurrentState;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.EXGaugeLevel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.GiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.b0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class BigGiftComboDialog extends Dialog implements View.OnClickListener, WeakHandler.IHandler {
    public final boolean A;
    public final int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f125922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseGiftComboView f125923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f125924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BuffDescribeView f125925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomGiftView f125926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout f125927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f125928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f125929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.service.toolbar.d f125930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zy0.b f125931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHandler f125932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f125933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f125934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f125935n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f125936o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f125937p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f125938q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c f125939r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Activity f125940s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f125941t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f125942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BigGiftViewModel f125943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DataCenter f125944w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f125945x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f125946y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f125947z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/BigGiftComboDialog$AnimType;", "", "ENTER", "EXIT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType ENTER = null;
        public static final AnimType EXIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimType[] f125948a = null;

        static {
            AnimType r100 = new AnimType("ENTER", 0);
            ENTER = r100;
            AnimType r101 = new AnimType("EXIT", 1);
            EXIT = r101;
            f125948a = new AnimType[]{r100, r101};
        }

        public static AnimType valueOf(String r100) {
            return (AnimType) r27.a.a(AnimType.class, r100);
        }

        public static AnimType[] values() {
            return (AnimType[]) f125948a.clone();
        }

        public AnimType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/BigGiftComboDialog$DismissType;", "", EffectConstants.NORMAL, "USER_CANCEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DismissType extends Enum<DismissType> {
        public static final DismissType NORMAL = null;
        public static final DismissType USER_CANCEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DismissType[] f125949a = null;

        static {
            DismissType r100 = new DismissType(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            DismissType r101 = new DismissType("USER_CANCEL", 1);
            USER_CANCEL = r101;
            f125949a = new DismissType[]{r100, r101};
        }

        public static DismissType valueOf(String r100) {
            return (DismissType) r27.a.a(DismissType.class, r100);
        }

        public static DismissType[] values() {
            return (DismissType[]) f125949a.clone();
        }

        public DismissType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimType f125950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboDialog f125951b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            AnimType r101 = this.f125950a;
            int r102 = com.bytedance.android.livesdk.gift.biggift.view.a.f125967a[r101.ordinal()];
            if (r102 != 1) goto L5;
            BigGiftComboDialog.b(this.f125951b);
            return;
        L5:
            if (r102 != 2) goto L11;
            this.f125951b.d(DismissType.NORMAL);
            return;
        }

        public b(BigGiftComboDialog r100, AnimType r101) {
            Intrinsics.checkNotNullParameter(r101, "animType");
            this.f125951b = r100;
            this.f125950a = r101;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboDialog f125952a;

        public c(BigGiftComboDialog r100) {
            this.f125952a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.livesdk.gift.biggift.viewModel.a r101 = (com.bytedance.android.livesdk.gift.biggift.viewModel.a) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f125993a != CurrentState.Combo) goto L28;
            View r102 = this.f125952a.f125928g;
            if (r102 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mDummy");
        L10:
            UtilityKotlinExtentionsKt.w(r102);
            UtilityKotlinExtentionsKt.w(BigGiftComboDialog.a(this.f125952a));
            BigGiftComboDialog.a(this.f125952a).setComboCount(r101.f125994b);
            ViewParent r103 = BigGiftComboDialog.a(this.f125952a);
            if ((r103 instanceof z) == true) goto L13;
            r103 = null;
        L13:
            z r104 = (z) r103;
            if (r104 == null) goto L18;
            BigGiftViewModel r105 = this.f125952a.f125943v;
            EXGaugeLevel r106 = r104.getCurrentEXGaugeLevel();
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "currentEXGaugeLevel");
            t r107 = r105.f125976a;
            if (r107 == null) goto L18;
            r107.isDisposed();
        L18:
            BigGiftComboDialog.a(this.f125952a).c(new com.bytedance.android.livesdk.gift.biggift.view.d(this), r101.f125995c, r101.f125994b);
            BigGiftComboDialog r108 = this.f125952a;
            boolean r109 = r108.f125947z;
            BaseGiftComboView r110 = r108.f125923b;
            if (r110 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("mComboView");
        L21:
            if (r109 == false) goto L23;
            r110.f();
        L24:
            BigGiftComboDialog.b(this.f125952a);
            com.bytedance.android.livesdk.gift.biggift.viewModel.e r111 = r101.f125996d;
            if (r111 == null) goto L28;
            this.f125952a.c(r111);
            goto L28
        L23:
            r110.g();
        L28:
            if (r101.f125993a != CurrentState.DisMiss) goto L31;
            this.f125952a.d(DismissType.NORMAL);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboDialog f125953a;

        public d(BigGiftComboDialog r100) {
            this.f125953a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Long r101 = (Long) r100;
            if (r101 == null) goto L8;
            long r102 = r101.longValue();
            BigGiftComboDialog.b(this.f125953a);
            BaseGiftComboView r103 = BigGiftComboDialog.a(this.f125953a);
            if (r103 == null) goto L9;
            r103.b(GiftManagerKt.l(r102));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboDialog f125954a;

        public e(BigGiftComboDialog r100) {
            this.f125954a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 == null) goto L10;
            BigGiftComboDialog.b(this.f125954a);
            if (((Boolean) r101.getSecond()).booleanValue() == false) goto L11;
            BaseGiftComboView r102 = BigGiftComboDialog.a(this.f125954a);
            if (r102 == null) goto L12;
            r102.a(((Number) r101.getFirst()).longValue());
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BigGiftComboDialog f125955a;

        public f(BigGiftComboDialog r100) {
            this.f125955a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Map<String, ? extends Object> r101 = (Map) r100;
            if ((!r101.isEmpty()) == false) goto L27;
            FrameLayout r102 = this.f125955a.f125922a;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
        L7:
            UtilityKotlinExtentionsKt.w(r102);
            BigGiftComboDialog r103 = this.f125955a;
            if (r103.f125931j != null) goto L28;
            BaseGiftComboView r104 = r103.f125923b;
            if (r104 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mComboView");
        L13:
            if ((r104 instanceof GiftComboView) == false) goto L30;
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r105 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r103.getContext(), UriProtector.parse(com.bytedance.android.livesdk.gift.platform.business.b.f().a()), null);
            r103.f125931j = r105;
            if (r105 == null) goto L23;
            FrameLayout r106 = r103.f125922a;
            if (r106 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
        L20:
            r106.addView((View) r105.f91463d);
            xy0.a<?> r107 = r105.g();
            if (r107 == null) goto L23;
            r107.load(null, r101);
        L23:
            View r108 = r103.findViewById(R.id.dummy_view_expand);
            if (r108 == null) goto L29;
            r108.setVisibility(8);
            return;
        L29:
            return;
        L30:
            return;
        L28:
            return;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        com.bytedance.android.livesdk.revenue.service.toolbar.d r100 = this.f125930i;
        if (r100 == null) goto L5;
        r100.unlock(this);
    L5:
        zy0.b r101 = this.f125931j;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        FrameLayout r102 = this.f125922a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTrayView");
    L11:
        r102.removeAllViews();
        this.f125931j = null;
        BigGiftViewModel r103 = this.f125943v;
        d r104 = this.f125936o;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f125981f.removeObserver(r104);
        BigGiftViewModel r105 = this.f125943v;
        e r106 = this.f125937p;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "observer");
        r105.f125982g.removeObserver(r106);
        this.f125943v.c();
        BigGiftViewModel r107 = this.f125943v;
        c r108 = this.f125935n;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "observer");
        r107.f125978c.removeObserver(r108);
        BigGiftViewModel r109 = this.f125943v;
        f r110 = this.f125938q;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "observer");
        r109.f125980e.removeObserver(r110);
        this.f125932k.removeCallbacksAndMessages(null);
        AnimatorSet r111 = this.f125929h;
        if (r111 == null) goto L22;
        if (r111.isStarted() != true) goto L22;
        AnimatorSet r112 = this.f125929h;
        if (r112 == null) goto L18;
        r112.removeAllListeners();
    L18:
        AnimatorSet r113 = this.f125929h;
        if (r113 == null) goto L22;
        r113.cancel();
    L22:
        if (((Boolean) b02.a.f16823c.getValue(null, b02.a.f16821a[1])).booleanValue() == false) goto L24;
    L25:
        BaseGiftComboView r114 = this.f125923b;
        if (r114 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L28:
        r114.d();
    L30:
        if (u.p() == false) goto L35;
        if (((Number) com.bytedance.android.livesdk.gift.biggift.e.f125918b.getValue(null, com.bytedance.android.livesdk.gift.biggift.e.f125917a[0])).intValue() != 1) goto L35;
        this.f125944w.put("data_vs_room_big_gift_combo_dialog_show", Boolean.FALSE);
    L35:
        if (isShowing() == true) goto L37;
        return;
    L37:
        if (this.f125940s.isFinishing() == false) goto L39;
        return;
    L39:
        if (this.f125940s.isDestroyed() == true) goto L62;
        Handler r115 = DialogLancet.resolveDialogHandler(this);
        if (r115 != null) goto L43;
    L45:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L48 Exception -> L50
    L54:
        DialogLancet.afterDialogDismiss(this);
        return;
    L50:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L48
        Throwable r116 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L48
        if (r116 == null) goto L54;
        com.bytedance.crash.d.d(r116, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L43:
        if (Looper.myLooper() == r115.getLooper()) goto L45;
        r115.post(DialogLancet.createDismissRunnable(this));
        return;
    L62:
        return;
    L24:
        if (this.f125934m.booleanValue() == false) goto L30;
        goto L25
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.revenue.service.toolbar.d r100 = (com.bytedance.android.livesdk.revenue.service.toolbar.d) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.d.class));
        if (r100 == null) goto L10;
        r100.lock(this);
        Unit r101 = Unit.INSTANCE;
    L11:
        this.f125930i = r100;
        BaseGiftComboView r102 = this.f125923b;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L14:
        long r103 = 200;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}).setDuration(r103);
        BaseGiftComboView r105 = this.f125923b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L17:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f}).setDuration(r103);
        AnimatorSet r107 = new AnimatorSet();
        this.f125929h = r107;
        r107.playTogether(new Animator[]{r104, r106});
        AnimatorSet r108 = this.f125929h;
        if (r108 == null) goto L20;
        r108.addListener(new b(this, AnimType.ENTER));
    L20:
        AnimatorSet r109 = this.f125929h;
        if (r109 == null) goto L27;
        r109.start();
        return;
    L27:
        return;
    L10:
        r100 = null;
        goto L11
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final Activity getActivity() {
        return this.f125940s;
    }

    public static final /* synthetic */ BaseGiftComboView a(BigGiftComboDialog r100) {
        BaseGiftComboView r101 = r100.f125923b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L5:
        return r101;
    }

    public static final void b(BigGiftComboDialog r100) {
        if (r100.f125932k.hasMessages(110) == false) goto L5;
        r100.f125932k.removeMessages(110);
    L5:
        r100.f125932k.sendEmptyMessageDelayed(110, ((long) r100.f125933l) * 1000);
    }

    public final void c(com.bytedance.android.livesdk.gift.biggift.viewModel.e r100) {
        if (r100.f126003b > 0) goto L17;
        CustomGiftView r101 = this.f125926e;
        if (r101 == null) goto L7;
        r101.setDialogData(r100.f126002a);
    L7:
        View r102 = this.f125928g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L10:
        UtilityKotlinExtentionsKt.t(r102);
        BaseGiftComboView r103 = this.f125923b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L13:
        UtilityKotlinExtentionsKt.t(r103);
        if (this.f125932k.hasMessages(110) == false) goto L16;
        this.f125932k.removeMessages(110);
    L16:
        jy0.b.d("CustomSpecialGiftEffects", "combo showConfirm dialog relate id: " + r100.f126002a.getRelatedGiftId());
    L17:
        CustomGiftView r104 = this.f125926e;
        if (r104 == null) goto L24;
        int r105 = r100.f126003b;
        TextView r106 = r104.f125966c;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftCount");
    L22:
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        r106.setText(String.format(r104.getContext().getString(R.string.ttlive_custom_gift_left_count), Arrays.copyOf(new Object[]{Integer.valueOf(r105)}, 1)));
        return;
    }

    public final void d(DismissType r100) {
        if (r100 == DismissType.USER_CANCEL) goto L19;
        BigGiftViewModel r101 = this.f125943v;
        n r102 = r101.f125988m;
        if (r102 != null) goto L7;
    L13:
        d0 r103 = r101.f125989n;
        if (r103 == null) goto L19;
        if (r103.f131495b <= 0) goto L19;
        r103.f131495b = 0;
        r103.f131497d = Observable.timer(com.bytedance.android.livesdk.gift.platform.business.b.c().a().a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b0(r103));
        goto L19
    L7:
        if (r102.f131646b <= 0) goto L13;
        if (((System.currentTimeMillis() - r102.f131646b) + com.bytedance.android.livesdk.gift.platform.business.b.c().b().a()) <= com.bytedance.android.livesdk.gift.platform.business.b.c().b().c()) goto L12;
        r102.a();
        goto L13
    L12:
        r102.f131646b = 0;
        r102.f131645a = Observable.timer(com.bytedance.android.livesdk.gift.platform.business.b.c().b().a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r102));
    L19:
        Handler r104 = DialogLancet.resolveDialogHandler(this);
        if (r104 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(this);
        return;
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r105 == null) goto L33;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
        goto L33
    L22:
        if (Looper.myLooper() == r104.getLooper()) goto L24;
        r104.post(DialogLancet.createDismissRunnable(this));
    }

    public final long e(com.bytedance.android.livesdk.gift.biggift.viewModel.a r100) {
        l1 r101 = r100.f125997e;
        if (r101 != null) goto L5;
        com.bytedance.android.livesdk.gift.biggift.viewModel.e r102 = r100.f125996d;
        if (r102 != null) goto L9;
        t r103 = this.f125943v.f125976a;
        if (r103 == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r104 = r103.i();
    L14:
        if (r104 != null) goto L18;
        return 0;
    L18:
        return r104.f130842b;
    L13:
        r104 = null;
        goto L14
    L9:
        return r102.f126002a.getRelatedGiftId();
    L5:
        return r101.getBuffGiftId();
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.what != 110) goto L11;
        BuffDescribeView r101 = this.f125925d;
        if (r101 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r101);
    L9:
        d(DismissType.NORMAL);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BigGiftViewModel r101 = this.f125943v;
        n r102 = r101.f125988m;
        if (r102 == null) goto L7;
        r102.a();
    L7:
        d0 r103 = r101.f125989n;
        if (r103 == null) goto L11;
        r103.c();
        r103.a();
    L11:
        if (r100.getId() != R.id.special_comb_layout) goto L14;
        d(DismissType.USER_CANCEL);
        return;
    L14:
        if (r100.getId() != R.id.dummy_view_v3) goto L16;
        BigGiftViewModel.g(this.f125943v);
        return;
    L16:
        r100.getId();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.requestFeature(1);
        r100.setLayout(-1, -1);
        r100.setGravity(80);
        r100.setDimAmount(0.0f);
    L5:
        setContentView(LayoutInflater.from(this.f125940s).inflate(R.layout.ttlive_dialog_big_gift_comb, null));
        if (r100 == null) goto L22;
        if (this.f125941t == true) goto L10;
    L15:
        r100.addFlags(1024);
        if (this.f125941t == false) goto L18;
    L20:
        r100.setLayout(-1, -1);
        goto L22
    L18:
        if (PadConfigUtils.c() == true) goto L20;
        t8.d(r100);
        goto L20
    L10:
        if (this.f125942u == false) goto L12;
    L14:
        r100.clearFlags(1024);
        goto L20
    L12:
        if (DigHoleScreenUtil.isDigHole(getContext()) == true) goto L14;
    L22:
        if (u.r() == false) goto L25;
        BaseGiftComboView r101 = (BaseGiftComboView) findViewById(R.id.special_comb_view_v3);
    L31:
        this.f125923b = r101;
        this.f125927f = (ConstraintLayout) findViewById(R.id.special_comb_layout);
        this.f125922a = (FrameLayout) findViewById(R.id.gift_carnival_tray_lynx_container);
        this.f125928g = findViewById(R.id.dummy_view_v3);
        BaseGiftComboView r102 = this.f125923b;
        if (r102 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L34:
        this.f125924c = r102.findViewById(R.id.combo_title);
        View r103 = this.f125928g;
        if (r103 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L37:
        UtilityKotlinExtentionsKt.t(r103);
        BaseGiftComboView r104 = this.f125923b;
        if (r104 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L40:
        UtilityKotlinExtentionsKt.t(r104);
        if (b02.a.e() == true) goto L43;
    L48:
        View r105 = this.f125928g;
        if (r105 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L51:
        r105.setOnClickListener(this);
    L52:
        ConstraintLayout r106 = this.f125927f;
        if (r106 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L55:
        r106.setOnClickListener(this);
        BaseGiftComboView r107 = this.f125923b;
        if (r107 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L58:
        r107.setCountDownTime(((long) this.f125933l) * 1000);
        BaseGiftComboView r108 = this.f125923b;
        if (r108 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L61:
        r108.setGiftType(this.f125945x);
        BigGiftViewModel r109 = this.f125943v;
        ComponentCallbacks2 r111 = this.f125940s;
        if (r111 == null) goto L277;
        LifecycleOwner r112 = (LifecycleOwner) r111;
        f r113 = this.f125938q;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r112, "owner");
        Intrinsics.checkNotNullParameter(r113, "observer");
        r109.f125980e.observe(r112, r113);
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r114 = this.f125943v.f125978c.getValue();
        if (r114 == null) goto L75;
        BaseGiftComboView r115 = this.f125923b;
        if (r115 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L68:
        r115.e(GiftManagerKt.l(e(r114)), r114.f125997e, r114.f125998f);
        BaseGiftComboView r116 = this.f125923b;
        if (r116 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L71:
        r116.setIsGroupSend(this.f125946y);
        BaseGiftComboView r117 = this.f125923b;
        if (r117 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L74:
        r117.setIsSeriesSend(this.A);
    L75:
        BigGiftViewModel r118 = this.f125943v;
        ComponentCallbacks2 r119 = this.f125940s;
        if (r119 == null) goto L275;
        LifecycleOwner r120 = (LifecycleOwner) r119;
        c r121 = this.f125935n;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r120, "owner");
        Intrinsics.checkNotNullParameter(r121, "observer");
        r118.f125978c.observe(r120, r121);
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r122 = r118.f125978c.getValue();
        Intrinsics.checkNotNull(r122);
        r121.onChanged(r122);
        com.bytedance.android.livesdk.gift.biggift.viewModel.a r123 = r118.f125978c.getValue();
        if (r123 == null) goto L210;
        com.bytedance.android.livesdk.gift.biggift.viewModel.e r124 = r123.f125996d;
        if (r124 != null) goto L83;
    L128:
        l1 r125 = r123.f125997e;
        if (r125 != null) goto L132;
    L206:
        BaseGiftComboView r126 = this.f125923b;
        if (r126 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L209:
        r126.e(GiftManagerKt.l(e(r123)), r123.f125997e, r123.f125998f);
        goto L210
    L132:
        if (this.f125925d != null) goto L206;
        if (r125.getBuffLevel() < 0) goto L206;
        BuffDescribeView r127 = new BuffDescribeView(this.f125940s);
        this.f125925d = r127;
        if (u.p() == false) goto L161;
        if (this.f125941t == true) goto L161;
        BaseGiftComboView r128 = this.f125923b;
        if (r128 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L144:
        if ((r128.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L206;
        BaseGiftComboView r129 = this.f125923b;
        if (r129 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L148:
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L159;
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        RectF r132 = (RectF) this.f125944w.get("data_vs_interactive_widget_region", null);
        if (r132 == null) goto L153;
        float r133 = (s1.q(getContext()).widthPixels - r132.right) + ((r132.width() - r131.width) / 2);
    L154:
        r131.rightMargin = (int) r133;
        BaseGiftComboView r134 = this.f125923b;
        if (r134 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("mComboView");
    L157:
        r134.setLayoutParams(r131);
        goto L206
    L153:
        r133 = s1.e(144.0f);
        goto L154
    L159:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L161:
        if (r123.f125997e.getBuffLevel() <= 0) goto L206;
        View r135 = this.f125924c;
        if (r135 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTitle");
    L165:
        a1.l(r135, UtilityKotlinExtentionsKt.i(34));
        if (this.f125941t == false) goto L183;
        HSImageView r136 = r127.f125956a;
        if (r136 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L171:
        if ((r136.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L199;
        HSImageView r137 = r127.f125956a;
        if (r137 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L175:
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        if (r138 == null) goto L182;
        ViewGroup.MarginLayoutParams r139 = (ViewGroup.MarginLayoutParams) r138;
        r139.rightMargin = (int) s1.e(9.0f);
        r139.bottomMargin = (int) s1.e(11.0f);
        HSImageView r140 = r127.f125956a;
        if (r140 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L180:
        r140.setLayoutParams(r139);
        goto L199
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L199:
        l1 r141 = r123.f125997e;
        Intrinsics.checkNotNullParameter(r141, "buffInfo");
        k r142 = r141.getBuffDescribeImg();
        HSImageView r143 = r127.f125956a;
        if (r143 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L202:
        ImageLoader.bindImage(r143, r142);
        ConstraintLayout r144 = this.f125927f;
        if (r144 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L205:
        r144.addView(r127);
        goto L206
    L183:
        HSImageView r145 = r127.f125956a;
        if (r145 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L187:
        if ((r145.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L199;
        HSImageView r146 = r127.f125956a;
        if (r146 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L191:
        ViewGroup.LayoutParams r147 = r146.getLayoutParams();
        if (r147 == null) goto L198;
        ViewGroup.MarginLayoutParams r148 = (ViewGroup.MarginLayoutParams) r147;
        r148.rightMargin = (int) s1.e(32.0f);
        r148.bottomMargin = (int) s1.e(110.0f);
        HSImageView r149 = r127.f125956a;
        if (r149 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("buffDescribeView");
    L196:
        r149.setLayoutParams(r148);
        goto L199
    L198:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L83:
        if (this.f125926e != null) goto L128;
        if (r124.f126002a.getLeftScores() < 0) goto L128;
        CustomGiftView r150 = new CustomGiftView(this.f125940s);
        this.f125926e = r150;
        View r151 = this.f125924c;
        if (r151 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mComboTitle");
    L90:
        a1.l(r151, UtilityKotlinExtentionsKt.i(34));
        if (this.f125941t == false) goto L108;
        FrameLayout r152 = r150.f125964a;
        if (r152 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L96:
        if ((r152.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L124;
        FrameLayout r153 = r150.f125964a;
        if (r153 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L100:
        ViewGroup.LayoutParams r154 = r153.getLayoutParams();
        if (r154 == null) goto L107;
        ViewGroup.MarginLayoutParams r155 = (ViewGroup.MarginLayoutParams) r154;
        r155.rightMargin = (int) s1.e(8.0f);
        r155.bottomMargin = (int) s1.e(10.5f);
        FrameLayout r156 = r150.f125964a;
        if (r156 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L105:
        r156.setLayoutParams(r155);
        goto L124
    L107:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L124:
        c(r123.f125996d);
        r150.setOnCustomGiftDialogListener(new com.bytedance.android.livesdk.gift.biggift.view.b(r150, this));
        ConstraintLayout r157 = this.f125927f;
        if (r157 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("mDialogLayout");
    L127:
        r157.addView(r150);
        goto L128
    L108:
        FrameLayout r158 = r150.f125964a;
        if (r158 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L112:
        if ((r158.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L124;
        FrameLayout r159 = r150.f125964a;
        if (r159 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L116:
        ViewGroup.LayoutParams r160 = r159.getLayoutParams();
        if (r160 == null) goto L123;
        ViewGroup.MarginLayoutParams r161 = (ViewGroup.MarginLayoutParams) r160;
        r161.rightMargin = (int) s1.e(32.0f);
        r161.bottomMargin = (int) s1.e(110.0f);
        FrameLayout r162 = r150.f125964a;
        if (r162 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L121:
        r162.setLayoutParams(r161);
        goto L124
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L210:
        BigGiftViewModel r163 = this.f125943v;
        ComponentCallbacks2 r164 = this.f125940s;
        if (r164 == null) goto L273;
        LifecycleOwner r165 = (LifecycleOwner) r164;
        d r166 = this.f125936o;
        r163.getClass();
        Intrinsics.checkNotNullParameter(r165, "owner");
        Intrinsics.checkNotNullParameter(r166, "observer");
        r163.f125981f.observe(r165, r166);
        BigGiftViewModel r167 = this.f125943v;
        ComponentCallbacks2 r168 = this.f125940s;
        if (r168 == null) goto L271;
        LifecycleOwner r169 = (LifecycleOwner) r168;
        e r170 = this.f125937p;
        r167.getClass();
        Intrinsics.checkNotNullParameter(r169, "owner");
        Intrinsics.checkNotNullParameter(r170, "observer");
        r167.f125982g.observe(r169, r170);
        if (u.p() == false) goto L220;
        if (((Number) com.bytedance.android.livesdk.gift.biggift.e.f125918b.getValue(null, com.bytedance.android.livesdk.gift.biggift.e.f125917a[0])).intValue() != 1) goto L220;
        this.f125944w.put("data_vs_room_big_gift_combo_dialog_show", Boolean.TRUE);
    L220:
        if (u.r() == false) goto L226;
        View r171 = this.f125928g;
        if (r171 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L224:
        a1.l(r171, UtilityKotlinExtentionsKt.i(11));
        return;
    L226:
        if (this.B != 1) goto L241;
        View r172 = this.f125928g;
        if (r172 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L230:
        ViewGroup.LayoutParams r173 = r172.getLayoutParams();
        if ((r173 instanceof ViewGroup.MarginLayoutParams) == true) goto L233;
        ViewGroup.LayoutParams r174 = null;
    L234:
        ViewGroup.MarginLayoutParams r175 = (ViewGroup.MarginLayoutParams) r174;
        if (r175 == null) goto L279;
        r175.rightMargin = UtilityKotlinExtentionsKt.i(26);
        r175.bottomMargin = UtilityKotlinExtentionsKt.i(70);
        View r176 = this.f125928g;
        if (r176 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L239:
        r176.setLayoutParams(r175);
        return;
    L279:
        return;
    L233:
        r174 = r173;
        goto L234
    L241:
        if (this.f125941t == true) goto L243;
        return;
    L243:
        if (b02.a.e() == false) goto L282;
        int r177 = ((Number) b02.a.f16822b.getValue(null, b02.a.f16821a[0])).intValue();
        if (r177 <= 0) goto L247;
    L250:
        View r178 = this.f125928g;
        if (r178 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L253:
        ViewGroup.LayoutParams r179 = r178.getLayoutParams();
        if ((r179 instanceof ViewGroup.MarginLayoutParams) == true) goto L256;
        ViewGroup.LayoutParams r180 = null;
    L257:
        ViewGroup.MarginLayoutParams r181 = (ViewGroup.MarginLayoutParams) r180;
        if (r181 == null) goto L263;
        r181.rightMargin = UtilityKotlinExtentionsKt.i(27);
        r181.bottomMargin = UtilityKotlinExtentionsKt.i(62);
        View r182 = this.f125928g;
        if (r182 != null) goto L262;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L262:
        r182.setLayoutParams(r181);
    L263:
        if (r177 != 2) goto L265;
    L266:
        View r183 = findViewById(R.id.dummy_view_expand);
        if (r183 == null) goto L284;
        r183.setOnClickListener(this);
        r183.setVisibility(0);
        return;
    L284:
        return;
    L265:
        if (this.f125934m.booleanValue() == true) goto L266;
        return;
    L256:
        r180 = r179;
        goto L257
    L247:
        if (this.f125934m.booleanValue() == false) goto L263;
    L282:
        return;
    L271:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L273:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L275:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L277:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L43:
        if (this.f125947z == false) goto L48;
        View r184 = this.f125928g;
        if (r184 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mDummy");
    L47:
        r184.setOnTouchListener(new com.bytedance.android.livesdk.gift.biggift.view.c(this));
        goto L52
    L25:
        if (this.B != 1) goto L28;
        r101 = (BaseGiftComboView) findViewById(R.id.rare_shop_combo_view);
        goto L31
    L28:
        if (b02.a.e() == false) goto L30;
        r101 = (BaseGiftComboView) findViewById(R.id.special_comb_view_v3_opt);
        goto L31
    L30:
        r101 = (BaseGiftComboView) findViewById(R.id.special_comb_view_v3);
        goto L31
    }

    public BigGiftComboDialog(Activity r100, boolean r101, boolean r102, BigGiftViewModel r103, DataCenter r104, String r105, boolean r106, boolean r107, boolean r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "dataCenter");
        Intrinsics.checkNotNullParameter(r105, "giftType");
        if (r101 == false) goto L8;
        if (r102 == false) goto L6;
    L7:
        int r108 = R.style.ttlive_special_comb_dialog_anchor;
    L9:
        super(r100, r108);
        this.f125940s = r100;
        this.f125941t = r101;
        this.f125942u = r102;
        this.f125943v = r103;
        this.f125944w = r104;
        this.f125945x = r105;
        this.f125946y = r106;
        this.f125947z = r107;
        this.A = r110;
        this.B = r111;
        this.f125932k = new WeakHandler(this);
        if (nz1.a.e() != 0) goto L12;
        int r109 = 10;
    L13:
        this.f125933l = r109;
        this.f125934m = (Boolean) ((wh6.a) vh6.c.b(wh6.a.class)).getClientABValue(q41.a.f531626h);
        this.f125935n = new c(this);
        this.f125936o = new d(this);
        this.f125937p = new e(this);
        this.f125938q = new f(this);
        this.f125939r = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c(new BigGiftComboDialog$touchController$1(this), new BigGiftComboDialog$touchController$2(this), new BigGiftComboDialog$touchController$3(this), new BigGiftComboDialog$touchController$4(this));
        return;
    L12:
        r109 = nz1.a.e();
        goto L13
    L6:
        if (DigHoleScreenUtil.isDigHole(r100) == true) goto L7;
    L8:
        r108 = R.style.ttlive_special_comb_dialog;
        goto L9
    }
}
