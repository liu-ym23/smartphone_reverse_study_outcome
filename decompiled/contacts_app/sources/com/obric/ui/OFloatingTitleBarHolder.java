package com.obric.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFloatingTitleBarHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u0001:\u0001VB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MJ\"\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MJ\"\u0010O\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MJ\"\u0010O\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MJ\u000e\u0010P\u001a\u00020Q2\u0006\u0010I\u001a\u00020\u0007J\u0006\u0010R\u001a\u00020QJ\u0006\u0010S\u001a\u00020QJ\u000e\u0010T\u001a\u00020Q2\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010U\u001a\u00020Q2\u0006\u0010I\u001a\u00020\u0007R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u0014R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u001cR\u0010\u0010&\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b*\u0010\u000eR#\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0-0\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\nR\u001d\u0010/\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b0\u0010!R\u001d\u00102\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b3\u0010\u000eR\u001d\u00105\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b6\u0010\u000eR#\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0-0\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\nR\u001d\u0010:\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b;\u0010\u0014R\u001d\u0010=\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b>\u0010\u001cR\u001d\u0010@\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\bA\u0010!R\u001d\u0010C\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bD\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006W"}, d2 = {"Lcom/obric/ui/OFloatingTitleBarHolder;", "", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "buttonMap", "", "", "Landroid/view/View;", "getButtonMap", "()Ljava/util/Map;", "centerButtonGroup", "Lcom/obric/oui/button/OButtonGroup;", "getCenterButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "centerButtonGroup$delegate", "Lkotlin/Lazy;", "centerContainer", "Landroid/widget/FrameLayout;", "getCenterContainer", "()Landroid/widget/FrameLayout;", "centerContainer$delegate", "centerCustomContainer", "getCenterCustomContainer", "centerCustomContainer$delegate", "centerSubtitleView", "Lcom/obric/oui/text/OTextView;", "getCenterSubtitleView", "()Lcom/obric/oui/text/OTextView;", "centerSubtitleView$delegate", "centerTitleContainer", "Landroid/widget/LinearLayout;", "getCenterTitleContainer", "()Landroid/widget/LinearLayout;", "centerTitleContainer$delegate", "centerTitleView", "getCenterTitleView", "centerTitleView$delegate", "currentEndState", "currentStartState", "currentState", "endButtonGroup", "getEndButtonGroup", "endButtonGroup$delegate", "endButtonMap", "", "getEndButtonMap", "endContainer", "getEndContainer", "endContainer$delegate", "endSubButtonGroup", "getEndSubButtonGroup", "endSubButtonGroup$delegate", "startButtonGroup", "getStartButtonGroup", "startButtonGroup$delegate", "startButtonMap", "getStartButtonMap", "startContainer", "getStartContainer", "startContainer$delegate", "startSubtitleView", "getStartSubtitleView", "startSubtitleView$delegate", "startTitleContainer", "getStartTitleContainer", "startTitleContainer$delegate", "startTitleView", "getStartTitleView", "startTitleView$delegate", "getTitleBar", "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "addEndAction", "stateKey", "iconRes", "", "onClick", "Landroid/view/View$OnClickListener;", "text", "addStartAction", "endButtonToState", "", "removeEndAction", "removeStartAction", "startButtonToState", "stateTo", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OFloatingTitleBarHolder {
    public static final Companion Companion = null;
    public static final String STATE_EDIT = "STATE_EDIT";
    public static final String STATE_NONE = "STATE_NONE";
    public static final String STATE_NORMAL = "STATE_NORMAL";
    private final Map<String, View> buttonMap;
    private final Lazy centerButtonGroup$delegate;
    private final Lazy centerContainer$delegate;
    private final Lazy centerCustomContainer$delegate;
    private final Lazy centerSubtitleView$delegate;
    private final Lazy centerTitleContainer$delegate;
    private final Lazy centerTitleView$delegate;
    private String currentEndState;
    private String currentStartState;
    private String currentState;
    private final Lazy endButtonGroup$delegate;
    private final Map<String, List<View>> endButtonMap;
    private final Lazy endContainer$delegate;
    private final Lazy endSubButtonGroup$delegate;
    private final Lazy startButtonGroup$delegate;
    private final Map<String, List<View>> startButtonMap;
    private final Lazy startContainer$delegate;
    private final Lazy startSubtitleView$delegate;
    private final Lazy startTitleContainer$delegate;
    private final Lazy startTitleView$delegate;
    private final OFloatingTitleBar titleBar;

    /* JADX INFO: compiled from: OFloatingTitleBarHolder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/ui/OFloatingTitleBarHolder$Companion;", "", "()V", OFloatingTitleBarHolder.STATE_EDIT, "", "STATE_NONE", OFloatingTitleBarHolder.STATE_NORMAL, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public OFloatingTitleBarHolder(OFloatingTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "titleBar");
        this.titleBar = r2;
        this.startContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$startContainer$2(this));
        this.startButtonGroup$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$startButtonGroup$2(this));
        this.startTitleContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$startTitleContainer$2(this));
        this.startTitleView$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$startTitleView$2(this));
        this.startSubtitleView$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$startSubtitleView$2(this));
        this.centerContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerContainer$2(this));
        this.centerButtonGroup$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerButtonGroup$2(this));
        this.centerCustomContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerCustomContainer$2(this));
        this.centerTitleContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerTitleContainer$2(this));
        this.centerTitleView$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerTitleView$2(this));
        this.centerSubtitleView$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$centerSubtitleView$2(this));
        this.endContainer$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$endContainer$2(this));
        this.endSubButtonGroup$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$endSubButtonGroup$2(this));
        this.endButtonGroup$delegate = LazyKt.lazy(new OFloatingTitleBarHolder$endButtonGroup$2(this));
        this.buttonMap = new LinkedHashMap();
        this.startButtonMap = new LinkedHashMap();
        this.endButtonMap = new LinkedHashMap();
        r2.setClickable(false);
    }

    public final OFloatingTitleBar getTitleBar() {
        return this.titleBar;
    }

    public final FrameLayout getStartContainer() {
        return (FrameLayout) this.startContainer$delegate.getValue();
    }

    public final OButtonGroup getStartButtonGroup() {
        return (OButtonGroup) this.startButtonGroup$delegate.getValue();
    }

    public final LinearLayout getStartTitleContainer() {
        return (LinearLayout) this.startTitleContainer$delegate.getValue();
    }

    public final OTextView getStartTitleView() {
        return (OTextView) this.startTitleView$delegate.getValue();
    }

    public final OTextView getStartSubtitleView() {
        return (OTextView) this.startSubtitleView$delegate.getValue();
    }

    public final FrameLayout getCenterContainer() {
        return (FrameLayout) this.centerContainer$delegate.getValue();
    }

    public final OButtonGroup getCenterButtonGroup() {
        return (OButtonGroup) this.centerButtonGroup$delegate.getValue();
    }

    public final FrameLayout getCenterCustomContainer() {
        return (FrameLayout) this.centerCustomContainer$delegate.getValue();
    }

    public final LinearLayout getCenterTitleContainer() {
        return (LinearLayout) this.centerTitleContainer$delegate.getValue();
    }

    public final OTextView getCenterTitleView() {
        return (OTextView) this.centerTitleView$delegate.getValue();
    }

    public final OTextView getCenterSubtitleView() {
        return (OTextView) this.centerSubtitleView$delegate.getValue();
    }

    public final LinearLayout getEndContainer() {
        return (LinearLayout) this.endContainer$delegate.getValue();
    }

    public final OButtonGroup getEndSubButtonGroup() {
        return (OButtonGroup) this.endSubButtonGroup$delegate.getValue();
    }

    public final OButtonGroup getEndButtonGroup() {
        return (OButtonGroup) this.endButtonGroup$delegate.getValue();
    }

    public final Map<String, View> getButtonMap() {
        return this.buttonMap;
    }

    public final Map<String, List<View>> getStartButtonMap() {
        return this.startButtonMap;
    }

    public final Map<String, List<View>> getEndButtonMap() {
        return this.endButtonMap;
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBarHolder r0, String r1, String r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.addEndAction(r1, r2, r3);
    }

    public final View addEndAction(String r3, String r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r3, "stateKey");
        Intrinsics.checkNotNullParameter(r4, "text");
        View r6 = this.titleBar.addEndAction(r4, -1, r5);
        Map<String, List<View>> r2 = this.endButtonMap;
        ArrayList r7 = r2.get(r3);
        if (r7 != null) goto L5;
        r7 = new ArrayList();
        r2.put(r3, r7);
    L5:
        r7.add(r6);
        return r6;
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBarHolder r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.addEndAction(r1, r2, r3);
    }

    public final View addEndAction(String r3, int r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r3, "stateKey");
        View r6 = this.titleBar.addEndAction(r4, -1, r5);
        Map<String, List<View>> r2 = this.endButtonMap;
        ArrayList r7 = r2.get(r3);
        if (r7 != null) goto L5;
        r7 = new ArrayList();
        r2.put(r3, r7);
    L5:
        r7.add(r6);
        return r6;
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBarHolder r0, String r1, String r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.addStartAction(r1, r2, r3);
    }

    public final View addStartAction(String r3, String r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r3, "stateKey");
        Intrinsics.checkNotNullParameter(r4, "text");
        View r6 = this.titleBar.addStartAction(r4, -1, r5);
        Map<String, List<View>> r2 = this.startButtonMap;
        ArrayList r7 = r2.get(r3);
        if (r7 != null) goto L5;
        r7 = new ArrayList();
        r2.put(r3, r7);
    L5:
        r7.add(r6);
        return r6;
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBarHolder r0, String r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.addStartAction(r1, r2, r3);
    }

    public final View addStartAction(String r3, int r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r3, "stateKey");
        View r6 = this.titleBar.addStartAction(r4, -1, r5);
        Map<String, List<View>> r2 = this.startButtonMap;
        ArrayList r7 = r2.get(r3);
        if (r7 != null) goto L5;
        r7 = new ArrayList();
        r2.put(r3, r7);
    L5:
        r7.add(r6);
        return r6;
    }

    public final void removeStartAction() {
        this.titleBar.removeStartAction();
        OButtonGroup r0 = getStartButtonGroup();
        if (r0 == null) goto L5;
        int r1 = r0.getItemCount();
    L6:
        if (r1 > 0) goto L9;
        this.titleBar.showStartAction(false);
        return;
    L9:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void removeEndAction() {
        this.titleBar.removeEndAction();
        OButtonGroup r0 = getEndButtonGroup();
        if (r0 == null) goto L5;
        int r1 = r0.getItemCount();
    L6:
        if (r1 > 0) goto L9;
        this.titleBar.showEndAction(false);
        return;
    L9:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void stateTo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stateKey");
        if (Intrinsics.areEqual(this.currentState, r2) == false) goto L5;
        return;
    L5:
        this.currentState = r2;
        startButtonToState(r2);
        endButtonToState(r2);
    }

    public final void startButtonToState(String r6) {
        Intrinsics.checkNotNullParameter(r6, "stateKey");
        if (Intrinsics.areEqual(this.currentStartState, r6) == false) goto L5;
        return;
    L5:
        this.currentStartState = r6;
        this.titleBar.removeAllStartAction();
        List<View> r7 = this.startButtonMap.get(r6);
        if (r7 == null) goto L11;
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        OFloatingTitleBar.addStartAction$default(this.titleBar, (View) r8.next(), 0, 2, null);
    L11:
        OButtonGroup r9 = getStartButtonGroup();
        if (r9 == null) goto L14;
        int r10 = r9.getItemCount();
    L15:
        if (r10 > 0) goto L19;
        this.titleBar.showStartAction(false);
        return;
    L19:
        return;
    L14:
        r10 = 0;
        goto L15
    }

    public final void endButtonToState(String r6) {
        Intrinsics.checkNotNullParameter(r6, "stateKey");
        if (Intrinsics.areEqual(this.currentEndState, r6) == false) goto L5;
        return;
    L5:
        this.currentEndState = r6;
        this.titleBar.removeAllEndAction();
        List<View> r7 = this.endButtonMap.get(r6);
        if (r7 == null) goto L11;
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        OFloatingTitleBar.addEndAction$default(this.titleBar, (View) r8.next(), 0, 2, null);
    L11:
        OButtonGroup r9 = getEndButtonGroup();
        if (r9 == null) goto L14;
        int r10 = r9.getItemCount();
    L15:
        if (r10 > 0) goto L19;
        this.titleBar.showEndAction(false);
        return;
    L19:
        return;
    L14:
        r10 = 0;
        goto L15
    }
}
