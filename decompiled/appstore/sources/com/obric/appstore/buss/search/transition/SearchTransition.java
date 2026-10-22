package com.obric.appstore.buss.search.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import bytedanceos.view.animation.TweenInterpolator;
import com.obric.appstore.R;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/appstore/buss/search/transition/SearchTransition;", "", "Companion", "a", "b", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface SearchTransition {

    @NotNull
    public static final a Companion = null;
    public static final float SLIDE_FRACTION = 0.065f;

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_BG_IN_MAIN = "search_bar_bg_in_main";

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_BG_IN_SEARCH = "search_bar_bg_in_search";

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_CANCEL_BTN = "search_bar_cancel_btn";

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_INPUT_IN_SEARCH = "search_bar_input_in_search";

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_IN_MAIN = "search_bar_in_main";

    @NotNull
    public static final String TRANSITION_NAME_SEARCH_BAR_IN_SEARCH = "search_bar_in_search";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10886a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f10887b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f10888c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f10889d = 0;

        static {
            f10886a = new a();
            f10887b = 350;
            f10888c = 450;
            f10889d = 450;
        }

        public a() {
        }

        public final long a() {
            return f10887b;
        }

        public final long b() {
            return f10889d;
        }

        public final Interpolator c(Context r10) {
            q.g(r10, "context");
            Interpolator r11 = AnimationUtils.loadInterpolator(r10, R.anim.smooth_interpolator);
            q.d(r11);
            return r11;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f10890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f10891b;

        public b() {
        }

        public final void a(OFloatingTitleBar r11) {
            q.g(r11, "titleBar");
            int r10 = yf.b.b(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()));
            Context r12 = r11.getContext();
            View r13 = new View(r12);
            View r14 = new View(r12);
            this.f10890a = r13;
            this.f10891b = r14;
            FrameLayout r15 = (FrameLayout) r11.findViewById(R.id.title_bar_container);
            if (r15 == null) goto L5;
            FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(yf.b.b(TypedValue.applyDimension(1, 60, Resources.getSystem().getDisplayMetrics())), r10);
            r16.gravity = 8388629;
            r16.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics())));
            Unit r17 = Unit.f21064a;
            r15.addView(r13, 0, r16);
        L5:
            if (r15 == null) goto L8;
            FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(yf.b.b(TypedValue.applyDimension(1, 60, Resources.getSystem().getDisplayMetrics())), r10);
            r18.gravity = 8388629;
            r18.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics())));
            Unit r19 = Unit.f21064a;
            r15.addView(r14, 0, r18);
            return;
        }

        public final Bundle b(Activity r10) {
            q.g(r10, "activity");
            View r11 = this.f10890a;
            if (r11 != null) goto L7;
            return null;
        L7:
            return ActivityOptions.makeSceneTransitionAnimation(r10, new Pair[]{Pair.create(r11, SearchTransition.TRANSITION_NAME_SEARCH_BAR_BG_IN_SEARCH), Pair.create(this.f10891b, SearchTransition.TRANSITION_NAME_SEARCH_BAR_INPUT_IN_SEARCH)}).toBundle();
        }

        public final void c(Window r10) {
            q.g(r10, "window");
            r10.requestFeature(12);
            r10.requestFeature(13);
            TransitionSet r11 = new TransitionSet();
            Fade r12 = new Fade();
            r12.setInterpolator(new TweenInterpolator(2));
            Token$Duration r13 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
            r12.setDuration(r13.getDuration());
            r11.addTransition(r12);
            r10.setExitTransition(r11);
            TransitionSet r14 = new TransitionSet();
            Fade r15 = new Fade();
            r15.setInterpolator(new TweenInterpolator(1));
            r15.setDuration(r13.getDuration());
            r14.addTransition(r15);
            r10.setReenterTransition(r14);
            Context r16 = r10.getContext();
            TransitionSet r17 = new TransitionSet();
            Transition r18 = TransitionInflater.from(r16).inflateTransition(android.R.transition.move);
            a r19 = SearchTransition.Companion;
            q.d(r16);
            r18.setInterpolator(r19.c(r16));
            r18.setDuration(350);
            r17.addTransition(r18);
            Fade r20 = new Fade();
            r20.setInterpolator(new TweenInterpolator(2));
            r20.setDuration(r13.getDuration());
            r17.addTransition(r20);
            r10.setSharedElementReenterTransition(r17);
        }
    }

    static {
        Companion = a.f10886a;
    }
}
