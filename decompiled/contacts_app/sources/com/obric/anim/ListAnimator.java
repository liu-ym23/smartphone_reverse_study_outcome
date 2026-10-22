package com.obric.anim;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.GlobalProxyLancet;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListAnimator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J)\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/obric/anim/ListAnimator;", "", "transIds", "", "fadeIds", "scaleFadeIds", "([I[I[I)V", "getFadeIds", "()[I", "getScaleFadeIds", "getTransIds", "finishEdit", "", "listView", "Landroid/view/ViewGroup;", "root", "Landroid/widget/ListView;", "visibleChangedView", "Landroid/view/View;", "visibleChangedViews", "", "(Landroid/view/ViewGroup;Landroid/widget/ListView;[Landroid/view/View;)V", "startAnim", "startEdit", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListAnimator {
    public static final Companion Companion = null;
    public static final String TAG = "ListAnimator";
    private final int[] fadeIds;
    private final int[] scaleFadeIds;
    private final int[] transIds;

    /* JADX INFO: compiled from: ListAnimator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/anim/ListAnimator$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ListAnimator() {
        this(null, null, null, 7, null);
    }

    public ListAnimator(int[] r2, int[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r2, "transIds");
        Intrinsics.checkNotNullParameter(r3, "fadeIds");
        Intrinsics.checkNotNullParameter(r4, "scaleFadeIds");
        this.transIds = r2;
        this.fadeIds = r3;
        this.scaleFadeIds = r4;
    }

    public /* synthetic */ ListAnimator(int[] r2, int[] r3, int[] r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = new int[0];
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = new int[0];
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new int[0];
    L11:
        this(r2, r3, r4);
    }

    public final int[] getTransIds() {
        return this.transIds;
    }

    public final int[] getFadeIds() {
        return this.fadeIds;
    }

    public final int[] getScaleFadeIds() {
        return this.scaleFadeIds;
    }

    public final void startEdit(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "listView");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "startEdit " + r3);
        startAnim(r3, null, null);
    }

    public final void finishEdit(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "listView");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "finishEdit " + r3);
        startAnim(r3, null, null);
    }

    public final void startEdit(ViewGroup r3, ListView r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "listView");
        Intrinsics.checkNotNullParameter(r5, "visibleChangedView");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "startEdit " + r3 + ' ' + r4 + ' ' + r5);
        startAnim(r3, r4, new View[]{r5});
    }

    public final void finishEdit(ViewGroup r3, ListView r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "listView");
        Intrinsics.checkNotNullParameter(r5, "visibleChangedView");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "finishEdit " + r3 + ' ' + r4 + ' ' + r5);
        startAnim(r3, r4, new View[]{r5});
    }

    public final void startEdit(ViewGroup r3, ListView r4, View[] r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "listView");
        Intrinsics.checkNotNullParameter(r5, "visibleChangedViews");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "startEdit " + r3 + ' ' + r4 + ' ' + r5);
        startAnim(r3, r4, r5);
    }

    public final void finishEdit(ViewGroup r3, ListView r4, View[] r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "listView");
        Intrinsics.checkNotNullParameter(r5, "visibleChangedViews");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "finishEdit " + r3 + ' ' + r4 + ' ' + r5);
        startAnim(r3, r4, r5);
    }

    private final void startAnim(final ViewGroup r10, final ListView r11, View[] r12) {
        int r2 = 0;
        if ("".length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        TransitionEx r3 = OEAAnimKt.getRunningTransition(r10);
        if (r3 == null) goto L10;
        String r4 = r3.getTag();
    L12:
        if (Intrinsics.areEqual("", r4) == false) goto L14;
        return;
    L10:
        r4 = null;
    L14:
        TransitionManager.endTransitions(r10);
        TransitionSet r5 = new TransitionSet();
        r5.setInterpolator(TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_CUBIC));
        if (this.fadeIds.length != 0) goto L17;
        boolean r6 = true;
    L19:
        if ((!r6) == true) goto L30;
        if (r12 != null) goto L22;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L30;
    L39:
        if (this.scaleFadeIds.length != 0) goto L41;
        boolean r13 = true;
    L43:
        if ((!r13) == false) goto L49;
        OEAHold r14 = new OEAHold();
        int[] r8 = this.scaleFadeIds;
        int r9 = r8.length;
        int r15 = 0;
    L45:
        if (r15 >= r9) goto L47;
        r14.addTarget(r8[r15]);
        r15 = r15 + 1;
        goto L45
    L47:
        r14.withAppear(ListAnimator$startAnim$1$2$2.INSTANCE);
        r14.withDisappear(ListAnimator$startAnim$1$2$3.INSTANCE);
        r5.addTransition(r14);
    L49:
        if (this.transIds.length != 0) goto L51;
        boolean r16 = true;
    L53:
        if ((!r16) == false) goto L60;
        ChangeBounds r17 = new ListAnimator$startAnim$1$3(r11);
        int[] r18 = this.transIds;
        int r19 = r18.length;
    L55:
        if (r2 >= r19) goto L57;
        r17.addTarget(r18[r2]);
        r2 = r2 + 1;
        goto L55
    L57:
        if (r11 == null) goto L59;
        r17.addTarget(r11);
    L59:
        r5.addTransition(r17);
        r5.addListener(new TransitionCallback().onEnd(new ListAnimator$startAnim$1$5(r10, r11)));
    L60:
        r5.setDuration(300);
        TransitionSet r110 = r5;
        OEAAnimKt.access$setRunningTransition(r10, new TransitionEx("", r110));
        r5.addListener(new TransitionCallback().onStart(OEAAnimKt$animTransit$1$1.INSTANCE).onEnd(new OEAAnimKt$animTransit$1$2(r10)));
        TransitionManager.beginDelayedTransition(r10, r110);
        return;
    L51:
        r16 = false;
        goto L53
    L41:
        r13 = false;
        goto L43
    L22:
        if (r12.length != 0) goto L24;
        boolean r20 = true;
    L25:
        if (r20 == true) goto L28;
        r7 = false;
        goto L29
    L24:
        r20 = false;
    L30:
        Fade r21 = new Fade();
        int[] r22 = this.fadeIds;
        int r23 = r22.length;
        int r24 = 0;
    L31:
        if (r24 >= r23) goto L33;
        r21.addTarget(r22[r24]);
        r24 = r24 + 1;
        goto L31
    L33:
        if (r12 == null) goto L37;
        int r25 = r12.length;
        int r26 = 0;
    L35:
        if (r26 >= r25) goto L37;
        r21.addTarget(r12[r26]);
        r26 = r26 + 1;
    L37:
        r5.addTransition(r21);
        goto L39
    L17:
        r6 = false;
        goto L19
    L5:
        r1 = false;
        goto L6
    }
}
