package com.obric.anim;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsTransition.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a:\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¨\u0006\u000f"}, d2 = {"bottomDeleteBarToEditMode", "", "root", "Landroid/view/ViewGroup;", "deleteView", "Landroid/view/View;", "otherView", "dialpadToEditMode", "onEnd", "Lkotlin/Function0;", "toggleDialpad", "dialpad", "btn", "show", "", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContactsTransitionKt {
    public static /* synthetic */ void toggleDialpad$default(ViewGroup r0, View r1, View r2, boolean r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L5;
        r4 = null;
    L5:
        toggleDialpad(r0, r1, r2, r3, r4);
    }

    public static final void dialpadToEditMode(ViewGroup r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r5, "onEnd");
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r2 = OEAAnimKt.getRunningTransition(r4);
        if (r2 == null) goto L10;
        String r3 = r2.getTag();
    L12:
        if (Intrinsics.areEqual("", r3) == false) goto L14;
        return;
    L10:
        r3 = null;
    L14:
        TransitionManager.endTransitions(r4);
        TransitionSet r6 = new TransitionSet();
        r6.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        Fade r7 = new Fade();
        r7.addTarget(r4);
        r6.addTransition(r7);
        r6.addListener(new TransitionCallback().onEnd(new ContactsTransitionKt$dialpadToEditMode$1$2(r5)));
        r6.setDuration(300);
        TransitionSet r8 = r6;
        OEAAnimKt.access$setRunningTransition(r4, new TransitionEx("", r8));
        r6.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r4)));
        TransitionManager.beginDelayedTransition(r4, r8);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static final void bottomDeleteBarToEditMode(ViewGroup r4, View r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r5, "deleteView");
        Intrinsics.checkNotNullParameter(r6, "otherView");
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r2 = OEAAnimKt.getRunningTransition(r4);
        if (r2 == null) goto L10;
        String r3 = r2.getTag();
    L12:
        if (Intrinsics.areEqual("", r3) == false) goto L14;
        return;
    L10:
        r3 = null;
    L14:
        TransitionManager.endTransitions(r4);
        TransitionSet r7 = new TransitionSet();
        r7.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        Fade r8 = new Fade();
        r8.addTarget(r5);
        r8.addTarget(r6);
        r7.addTransition(r8);
        ChangeBounds r9 = new ChangeBounds();
        r9.addTarget(r4);
        r7.addTransition(r9);
        r7.setDuration(300);
        TransitionSet r10 = r7;
        OEAAnimKt.access$setRunningTransition(r4, new TransitionEx("", r10));
        r7.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r4)));
        TransitionManager.beginDelayedTransition(r4, r10);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static final void bottomDeleteBarToEditMode(ViewGroup r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r5, "deleteView");
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r2 = OEAAnimKt.getRunningTransition(r4);
        if (r2 == null) goto L10;
        String r3 = r2.getTag();
    L12:
        if (Intrinsics.areEqual("", r3) == false) goto L14;
        return;
    L10:
        r3 = null;
    L14:
        TransitionManager.endTransitions(r4);
        TransitionSet r6 = new TransitionSet();
        r6.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        ChangeBounds r7 = new ChangeBounds();
        r7.addTarget(r4);
        r6.addTransition(r7);
        Fade r8 = new Fade();
        r8.addTarget(r5);
        r6.addTransition(r8);
        r6.setDuration(300);
        TransitionSet r9 = r6;
        OEAAnimKt.access$setRunningTransition(r4, new TransitionEx("", r9));
        r6.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r4)));
        TransitionManager.beginDelayedTransition(r4, r9);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static final void toggleDialpad(ViewGroup r4, View r5, View r6, boolean r7, final Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r5, "dialpad");
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r2 = OEAAnimKt.getRunningTransition(r4);
        if (r2 == null) goto L10;
        String r3 = r2.getTag();
    L12:
        if (Intrinsics.areEqual("", r3) == false) goto L14;
        return;
    L10:
        r3 = null;
    L14:
        TransitionManager.endTransitions(r4);
        TransitionSet r9 = new TransitionSet();
        r9.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        Fade r10 = new Fade();
        r10.addTarget(r5);
        if (r6 == null) goto L17;
        r10.addTarget(r6);
    L17:
        r9.addTransition(r10);
        Slide r11 = new Slide();
        r11.setSlideEdge(80);
        r11.addTarget(r5);
        r9.addTransition(r11);
        r9.setDuration(300);
        if (r7 == true) goto L20;
        r9.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_IN_CUBIC));
    L20:
        r9.addListener(new TransitionCallback().onEnd(new ContactsTransitionKt$toggleDialpad$1$3(r8)));
        TransitionSet r12 = r9;
        OEAAnimKt.access$setRunningTransition(r4, new TransitionEx("", r12));
        r9.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r4)));
        TransitionManager.beginDelayedTransition(r4, r12);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
