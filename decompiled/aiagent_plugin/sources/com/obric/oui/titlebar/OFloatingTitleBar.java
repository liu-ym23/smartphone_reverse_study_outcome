package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OFloatingTitleBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFloatingTitleBar extends FrameLayout implements com.obric.oui.material.b, com.obric.oui.material.g {
    private static final com.obric.common.oea.foundation.animation.h.e.a AVOIDANCE_SHIFT_BOUNCE = null;
    private static final com.obric.common.oea.foundation.animation.h.e.c AVOIDANCE_SHIFT_DURATION = null;
    private static final int CENTER_TITLE_GAP = 12;
    private static final int CENTER_TITLE_GAP_IN_LARGE_FONT = 4;
    private static final int CENTER_TITLE_HORIZONTAL_PADDING = 8;
    public static final c Companion = null;
    private static final int SUB_END_TO_END_GAP = 12;
    private static final String TAG = "OFloatingTitleBar";
    public static final int TYPE_FLOATING = 2;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_WINDOW = 1;
    private d.h.a.a<d.x> actionChangeInterruptCallback;
    private View backdropTarget;
    private int batchSetDepth;
    public OButtonGroup centerButtonGroup;
    private int centerButtonGroupStyle;
    private FrameLayout centerContainer;
    private FrameLayout centerCustomContainer;
    private com.obric.common.oea.foundation.animation.manager.d centerShiftAnimator;
    private OTextView centerSubtitleView;
    private int centerTintColor;
    private LinearLayout centerTitleContainer;
    private int centerTitleGapLargeFontPx;
    private int centerTitleGapPx;
    private int centerTitleHorizontalPaddingPx;
    private OTextView centerTitleView;
    private com.obric.oui.titlebar.a.c currentActionsState;
    private com.obric.oui.titlebar.a.c currentHostSyncActionsState;
    private com.obric.oui.material.c currentMaskMaterialConfig;
    private boolean enableFloatingTransition;
    private int endAreaTransitionGeneration;
    public OButtonGroup endButtonGroup;
    private int endButtonGroupStyle;
    private LinearLayout endContainer;
    public OButtonGroup endSubButtonGroup;
    private int endSubButtonGroupStyle;
    private com.obric.common.oea.foundation.animation.manager.d endSubShiftAnimator;
    private int endSubTintColor;
    private int endTintColor;
    private FloatingTransitionBridge floatingTransitionBridge;
    private d.h.a.a<d.x> floatingTransitionDrawUpdateListener;
    private FloatingTransitionBridge.c floatingTransitionEndListener;
    private boolean floatingTransitionOwnerActive;
    private final com.obric.oui.window.floating.a floatingWindowHelper;
    private Integer freezeEndAreaWidth;
    private boolean isActionContentVisible;
    private boolean isActionTouchEventBlocked;
    private boolean isBackdropView;
    private boolean isCenterOverflow;
    private boolean isNonActionContentVisible;
    private boolean keepActionInteractiveWhenHidden;
    private boolean mIsLargeFont;
    private int mType;
    private d.h.a.b<? super Boolean, com.obric.oui.material.c> maskMaterial;
    private View materialMask;
    private int materialSrcType;
    public OButtonGroup startButtonGroup;
    private int startButtonGroupStyle;
    private FrameLayout startContainer;
    private OTextView startSubtitleView;
    private int startTintColor;
    private LinearLayout startTitleContainer;
    private OTextView startTitleView;
    private int subEndToEndGapPx;
    private View titleBarContainer;
    private g titleBarTransitionEndListener;

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<View> f36500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<View> f36501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<View> f36502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<View> f36503d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f36500a, r6.f36500a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f36501b, r6.f36501b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f36502c, r6.f36502c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f36503d, r6.f36503d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f36500a.hashCode() * 31) + this.f36501b.hashCode()) * 31) + this.f36502c.hashCode()) * 31) + this.f36503d.hashCode();
        }

        public String toString() {
            return "ActionTargetViews(start=" + this.f36500a + ", center=" + this.f36501b + ", subEnd=" + this.f36502c + ", end=" + this.f36503d + ')';
        }

        public a(List<? extends View> r3, List<? extends View> r4, List<? extends View> r5, List<? extends View> r6) {
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<View> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<View> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "start");
            d.h.b.o.e(r8, "center");
            d.h.b.o.e(r9, "subEnd");
            d.h.b.o.e(r10, "end");
            this.f36500a = r7;
            this.f36501b = r8;
            this.f36502c = r9;
            this.f36503d = r10;
        }

        public final List<View> a() {
            return this.f36500a;
        }

        public final List<View> b() {
            return this.f36501b;
        }

        public final List<View> c() {
            return this.f36502c;
        }

        public final List<View> d() {
            return this.f36503d;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class aa extends d.h.b.p implements d.h.a.b<Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36504a;

        aa(OFloatingTitleBar r1) {
            this.f36504a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }

        public final void a(int r2) {
            OFloatingTitleBar.access$setEndTintColor$p(this.f36504a, r2);
            OFloatingTitleBar r1 = this.f36504a;
            OFloatingTitleBar.access$updateGroupItemsTint(r1, r1.getEndButtonGroup(), r2);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ab extends d.h.b.p implements d.h.a.b<Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36505a;

        ab(OFloatingTitleBar r1) {
            this.f36505a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }

        public final void a(int r2) {
            OFloatingTitleBar.access$setStartTintColor$p(this.f36505a, r2);
            OFloatingTitleBar r1 = this.f36505a;
            OFloatingTitleBar.access$updateGroupItemsTint(r1, r1.getStartButtonGroup(), r2);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ac extends d.h.b.p implements d.h.a.b<Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36506a;

        ac(OFloatingTitleBar r1) {
            this.f36506a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }

        public final void a(int r2) {
            OFloatingTitleBar.access$setEndSubTintColor$p(this.f36506a, r2);
            OFloatingTitleBar r1 = this.f36506a;
            OFloatingTitleBar.access$updateGroupItemsTint(r1, r1.getEndSubButtonGroup(), r2);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ad extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36508b;

        ad(OFloatingTitleBar r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36507a = r3;
            this.f36508b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$setCenterShiftAnimator$p(this.f36507a, null);
            d.h.a.a<d.x> r2 = this.f36508b;
            if (r2 == null) goto L7;
            r2.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ae extends d.h.b.p implements d.h.a.q<String, Object, Object, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f36509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36510b;

        ae(d.h.a.b<? super Float, d.x> r3, OFloatingTitleBar r4) {
            this.f36509a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f36510b = r4;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return d.x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            d.h.b.o.e(r2, "$noName_0");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r4, "$noName_2");
            this.f36509a.invoke((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin"));
            this.f36510b.notifyFloatingTransitionDrawUpdate$OUI_standardRelease();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class af extends d.h.b.p implements d.h.a.m<Boolean, Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f36511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f36512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36513c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36514d;

        af(d.h.a.b<? super Float, d.x> r3, float r4, OFloatingTitleBar r5, d.h.a.a<d.x> r6) {
            d.h.a.b<Float, d.x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36511a = r7;
            this.f36512b = r4;
            this.f36513c = r5;
            this.f36514d = r8;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            if (r1 == false) goto L8;
            this.f36511a.invoke(Float.valueOf(this.f36512b));
            this.f36513c.notifyFloatingTransitionDrawUpdate$OUI_standardRelease();
            d.h.a.a<d.x> r0 = this.f36514d;
            if (r0 == null) goto L9;
            r0.invoke();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ag extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36518d;

        ag(d.h.b.z.a r3, d.h.b.z.a r4, d.h.b.z.a r5, d.h.a.a<d.x> r6) {
            d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36515a = r3;
            this.f36516b = r4;
            this.f36517c = r5;
            this.f36518d = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f36515a.f38499a = true;
            OFloatingTitleBar.access$updateAction$finishIfReady(this.f36516b, this.f36517c, this.f36515a, this.f36518d);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ah extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36522d;

        ah(d.h.b.z.a r3, d.h.b.z.a r4, d.h.b.z.a r5, d.h.a.a<d.x> r6) {
            d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36519a = r3;
            this.f36520b = r4;
            this.f36521c = r5;
            this.f36522d = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f36519a.f38499a = true;
            OFloatingTitleBar.access$updateAction$finishIfReady(this.f36520b, this.f36519a, this.f36521c, this.f36522d);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class ai extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f36524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36525c;

        ai(d.h.a.a<d.x> r3, boolean r4, OFloatingTitleBar r5) {
            this.f36523a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36524b = r4;
            this.f36525c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            d.h.a.a<d.x> r0 = this.f36523a;
            if (r0 == null) goto L7;
            r0.invoke();
        L7:
            if (this.f36524b == false) goto L10;
            OFloatingTitleBar.access$dispatchTitleBarTransitionEnd(this.f36525c);
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class aj extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f36526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36527b;

        aj(d.h.b.z.d r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36526a = r3;
            this.f36527b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f36526a.f38502a--;
            if (this.f36526a.f38502a != 0) goto L6;
            this.f36527b.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36528a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36529b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36530c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f36531d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f36528a, f36529b, f36530c};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f36531d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36528a = new b("NONE", 0);
            f36529b = new b("FREEZE", 1);
            f36530c = new b("TRANSITION", 2);
            f36531d = a();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f36532a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f36533b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f36534c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f36535d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f36536e = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f36532a, f36533b, f36534c, f36535d};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f36536e.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36532a = new d("EMPTY", 0);
            f36533b = new d("SUB_ONLY", 1);
            f36534c = new d("END_ONLY", 2);
            f36535d = new d("BOTH", 3);
            f36536e = a();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f36537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<View> f36538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<View> f36539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f36541e;
        private final int f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f36537a == r6.f36537a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f36538b, r6.f36538b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f36539c, r6.f36539c) == true) goto L18;
            return false;
        L18:
            if (this.f36540d == r6.f36540d) goto L21;
            return false;
        L21:
            if (this.f36541e == r6.f36541e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f36537a.hashCode() * 31) + this.f36538b.hashCode()) * 31) + this.f36539c.hashCode()) * 31) + Integer.hashCode(this.f36540d)) * 31) + Integer.hashCode(this.f36541e)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "EndAreaSnapshot(state=" + this.f36537a + ", subEndViews=" + this.f36538b + ", endViews=" + this.f36539c + ", width=" + this.f36540d + ", endWidth=" + this.f36541e + ", endContentWidth=" + this.f + ')';
        }

        public e(d r3, List<? extends View> r4, List<? extends View> r5, int r6, int r7, int r8) {
            List<View> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<View> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "state");
            d.h.b.o.e(r9, "subEndViews");
            d.h.b.o.e(r10, "endViews");
            this.f36537a = r3;
            this.f36538b = r9;
            this.f36539c = r10;
            this.f36540d = r6;
            this.f36541e = r7;
            this.f = r8;
        }

        public final d a() {
            return this.f36537a;
        }

        public final List<View> b() {
            return this.f36538b;
        }

        public final List<View> c() {
            return this.f36539c;
        }

        public final int d() {
            return this.f36540d;
        }

        public final int e() {
            return this.f36541e;
        }

        public final int f() {
            return this.f;
        }

        public final boolean g() {
            if (this.f36537a != d.f36533b) goto L5;
        L8:
            return true;
        L5:
            if (this.f36537a == d.f36535d) goto L8;
            return false;
        }

        public final boolean h() {
            if (this.f36537a != d.f36534c) goto L5;
        L8:
            return true;
        L5:
            if (this.f36537a == d.f36535d) goto L8;
            return false;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f36542a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f36543b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f36544c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f36545d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f36546e = null;
        public static final f f = null;
        private static final /* synthetic */ f[] g = null;

        private static final /* synthetic */ f[] a() {
            return new f[]{f36542a, f36543b, f36544c, f36545d, f36546e, f};
        }

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(g.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        private f(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36542a = new f("NONE_OR_CONTENT_CHANGE", 0);
            f36543b = new f("SUB_ONLY_TO_BOTH", 1);
            f36544c = new f("BOTH_TO_SUB_ONLY", 2);
            f36545d = new f("SUB_ONLY_TO_END_ONLY", 3);
            f36546e = new f("END_ONLY_TO_SUB_ONLY", 4);
            f = new f("INTERRUPTED_SHIFT_RETURN", 5);
            g = a();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    public interface g {
        void a(OFloatingTitleBar r1);
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    private static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f36547a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f36548b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f36549c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ h[] f36550d = null;

        private static final /* synthetic */ h[] a() {
            return new h[]{f36547a, f36548b, f36549c};
        }

        public static h valueOf(String r2) {
            return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
        }

        public static h[] values() {
            return (h[]) ZeusTransformUtils.preCheckCast(f36550d.clone(), h[].class, "com.obric.aiagent.plugin");
        }

        private h(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36547a = new h("NONE", 0);
            f36548b = new h("APPEARING", 1);
            f36549c = new h("DISAPPEARING", 2);
            f36550d = a();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    public /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36551a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36552b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f36553c = null;

        static {
            int[] r0 = new int[f.values().length];
            r0[f.f36543b.ordinal()] = 1;
            r0[f.f36544c.ordinal()] = 2;
            r0[f.f36545d.ordinal()] = 3;
            r0[f.f36546e.ordinal()] = 4;
            r0[f.f.ordinal()] = 5;
            r0[f.f36542a.ordinal()] = 6;
            f36551a = r0;
            int[] r1 = new int[h.values().length];
            r1[h.f36548b.ordinal()] = 1;
            r1[h.f36549c.ordinal()] = 2;
            r1[h.f36547a.ordinal()] = 3;
            f36552b = r1;
            int[] r2 = new int[b.values().length];
            r2[b.f36528a.ordinal()] = 1;
            r2[b.f36529b.ordinal()] = 2;
            r2[b.f36530c.ordinal()] = 3;
            f36553c = r2;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class j extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36554a;

        j(OFloatingTitleBar r1) {
            this.f36554a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            this.f36554a.getEndSubButtonGroup().setTranslationX(r1);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class k extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36556b;

        k(OFloatingTitleBar r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36555a = r3;
            this.f36556b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$setEndSubShiftAnimator$p(this.f36555a, null);
            d.h.a.a<d.x> r2 = this.f36556b;
            if (r2 == null) goto L7;
            r2.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class l extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f36558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36559c;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$l$1, reason: invalid class name */
        /* JADX INFO: compiled from: OFloatingTitleBar.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<Float, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OFloatingTitleBar f36560a;

            AnonymousClass1(OFloatingTitleBar r1) {
                this.f36560a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(Float r3) {
                a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
                return d.x.f38692a;
            }

            public final void a(float r1) {
                FrameLayout r0 = OFloatingTitleBar.access$getCenterContainer$p(this.f36560a);
                if (r0 != null) goto L5;
                d.h.b.o.c("centerContainer");
                r0 = null;
            L5:
                r0.setTranslationX(r1);
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$l$2, reason: invalid class name */
        /* JADX INFO: compiled from: OFloatingTitleBar.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.a<d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OFloatingTitleBar f36561a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.a<d.x> f36562b;

            AnonymousClass2(OFloatingTitleBar r3, d.h.a.a<d.x> r4) {
                d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                this.f36561a = r3;
                this.f36562b = r5;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }

            public final void a() {
                FrameLayout r0 = OFloatingTitleBar.access$getCenterContainer$p(this.f36561a);
                if (r0 != null) goto L5;
                d.h.b.o.c("centerContainer");
                r0 = null;
            L5:
                r0.setTranslationX(0.0f);
                d.h.a.a<d.x> r2 = this.f36562b;
                if (r2 == null) goto L10;
                r2.invoke();
                return;
            }
        }

        l(OFloatingTitleBar r3, float r4, d.h.a.a<d.x> r5) {
            d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36557a = r3;
            this.f36558b = r4;
            this.f36559c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            FrameLayout r0 = OFloatingTitleBar.access$getCenterContainer$p(this.f36557a);
            FrameLayout r1 = null;
            if (r0 != null) goto L5;
            d.h.b.o.c("centerContainer");
            r0 = null;
        L5:
            float r2 = r0.getLeft();
            FrameLayout r3 = OFloatingTitleBar.access$getCenterContainer$p(this.f36557a);
            if (r3 != null) goto L8;
            d.h.b.o.c("centerContainer");
            r3 = null;
        L8:
            float r4 = this.f36558b - (r2 + (r3.getWidth() / 2.0f));
            if (r4 != 0.0f) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L22;
            FrameLayout r6 = OFloatingTitleBar.access$getCenterContainer$p(this.f36557a);
            if (r6 != null) goto L16;
            d.h.b.o.c("centerContainer");
        L17:
            r1.setTranslationX(0.0f);
            d.h.a.a<d.x> r7 = this.f36559c;
            if (r7 == null) goto L28;
            r7.invoke();
            return;
        L28:
            return;
        L16:
            r1 = r6;
            goto L17
        L22:
            FrameLayout r8 = OFloatingTitleBar.access$getCenterContainer$p(this.f36557a);
            if (r8 != null) goto L25;
            d.h.b.o.c("centerContainer");
        L26:
            r1.setTranslationX(r4);
            OFloatingTitleBar r9 = this.f36557a;
            OFloatingTitleBar.access$setCenterShiftAnimator$p(r9, OFloatingTitleBar.access$startCenterTranslationXSpring(r9, r4, 0.0f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f36557a), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f36557a, this.f36559c), d.h.a.a.class, "com.obric.aiagent.plugin")));
            return;
        L25:
            r1 = r8;
            goto L26
        L11:
            r5 = false;
            goto L12
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class m extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f36563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f36565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Float f36566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Float f36567e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;

        m(int r1, OFloatingTitleBar r2, h r3, Float r4, Float r5, float r6, float r7) {
            this.f36563a = r1;
            this.f36564b = r2;
            this.f36565c = r3;
            this.f36566d = r4;
            this.f36567e = r5;
            this.f = r6;
            this.g = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            if (this.f36563a == OFloatingTitleBar.access$getEndAreaTransitionGeneration$p(this.f36564b)) goto L5;
            return;
        L5:
            OFloatingTitleBar.access$updateSubEndShiftByEndRawAlpha(this.f36564b, this.f36565c, this.f36566d, this.f36567e, this.f, this.g);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class n extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36569b;

        n(OFloatingTitleBar r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36568a = r3;
            this.f36569b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$releaseFreezeEndAreaWidth(this.f36568a);
            d.h.a.a<d.x> r1 = this.f36569b;
            if (r1 == null) goto L7;
            r1.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class o extends d.h.b.p implements d.h.a.b<com.obric.oui.view.b, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36570a;

        o(OFloatingTitleBar r1) {
            this.f36570a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.oui.view.b r3) {
            a((com.obric.oui.view.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.view.b.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(com.obric.oui.view.b r2) {
            d.h.b.o.e(r2, "rect");
            this.f36570a.updateLayoutForInsetTop(r2.f36822c);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class p extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36571a;

        p(OFloatingTitleBar r1) {
            this.f36571a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r31) {
            if (r31 == false) goto L6;
            return new com.obric.oui.material.c(null, null, com.obric.oui.material.l.a(ZeusTransformUtils.getResources(this.f36571a, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors_light, "array", "oui_titlebar_blur_colors_light"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes_light, "array", "oui_titlebar_blur_blend_modes_light")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        L6:
            return new com.obric.oui.material.c(null, null, com.obric.oui.material.l.a(ZeusTransformUtils.getResources(this.f36571a, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors_dark, "array", "oui_titlebar_blur_colors_dark"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes_dark, "array", "oui_titlebar_blur_blend_modes_dark")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class q extends d.h.b.p implements d.h.a.b<OButtonGroup.f, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36572a;

        q(OFloatingTitleBar r1) {
            this.f36572a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ View invoke(OButtonGroup.f r3) {
            return a((OButtonGroup.f) ZeusTransformUtils.preCheckCast(r3, OButtonGroup.f.class, "com.obric.aiagent.plugin"));
        }

        public final View a(OButtonGroup.f r3) {
            d.h.b.o.e(r3, "it");
            OFloatingTitleBar r0 = this.f36572a;
            return OFloatingTitleBar.access$createViewForSavedAction(r0, r3, OFloatingTitleBar.access$getStartTintColor$p(r0), OFloatingTitleBar.access$getCurrentActionsState$p(this.f36572a).a());
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class r extends d.h.b.p implements d.h.a.b<OButtonGroup.f, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36573a;

        r(OFloatingTitleBar r1) {
            this.f36573a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ View invoke(OButtonGroup.f r3) {
            return a((OButtonGroup.f) ZeusTransformUtils.preCheckCast(r3, OButtonGroup.f.class, "com.obric.aiagent.plugin"));
        }

        public final View a(OButtonGroup.f r3) {
            d.h.b.o.e(r3, "it");
            OFloatingTitleBar r0 = this.f36573a;
            return OFloatingTitleBar.access$createViewForSavedAction(r0, r3, OFloatingTitleBar.access$getCenterTintColor$p(r0), OFloatingTitleBar.access$getCurrentActionsState$p(this.f36573a).b());
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class s extends d.h.b.p implements d.h.a.b<OButtonGroup.f, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36574a;

        s(OFloatingTitleBar r1) {
            this.f36574a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ View invoke(OButtonGroup.f r3) {
            return a((OButtonGroup.f) ZeusTransformUtils.preCheckCast(r3, OButtonGroup.f.class, "com.obric.aiagent.plugin"));
        }

        public final View a(OButtonGroup.f r3) {
            d.h.b.o.e(r3, "it");
            OFloatingTitleBar r0 = this.f36574a;
            return OFloatingTitleBar.access$createViewForSavedAction(r0, r3, OFloatingTitleBar.access$getEndSubTintColor$p(r0), OFloatingTitleBar.access$getCurrentActionsState$p(this.f36574a).c());
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class t extends d.h.b.p implements d.h.a.b<OButtonGroup.f, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36575a;

        t(OFloatingTitleBar r1) {
            this.f36575a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ View invoke(OButtonGroup.f r3) {
            return a((OButtonGroup.f) ZeusTransformUtils.preCheckCast(r3, OButtonGroup.f.class, "com.obric.aiagent.plugin"));
        }

        public final View a(OButtonGroup.f r3) {
            d.h.b.o.e(r3, "it");
            OFloatingTitleBar r0 = this.f36575a;
            return OFloatingTitleBar.access$createViewForSavedAction(r0, r3, OFloatingTitleBar.access$getEndTintColor$p(r0), OFloatingTitleBar.access$getCurrentActionsState$p(this.f36575a).d());
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class u extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f36576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36580e;
        final /* synthetic */ e f;
        final /* synthetic */ b g;
        final /* synthetic */ d.h.a.a<d.x> h;

        u(d.h.b.z.d r3, d.h.b.z.a r4, int r5, OFloatingTitleBar r6, d.h.b.z.a r7, e r8, b r9, d.h.a.a<d.x> r10) {
            d.h.a.a<d.x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36576a = r3;
            this.f36577b = r4;
            this.f36578c = r5;
            this.f36579d = r6;
            this.f36580e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r11;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$runEndAreaTransition$onParticipantFinished(this.f36576a, this.f36577b, this.f36578c, this.f36579d, this.f36580e, this.f, this.g, this.h);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class v extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f36581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f36584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f36585e;
        final /* synthetic */ e f;
        final /* synthetic */ d.h.b.z.a g;
        final /* synthetic */ int h;
        final /* synthetic */ d.h.b.z.a i;
        final /* synthetic */ b j;
        final /* synthetic */ d.h.a.a<d.x> k;

        v(f r3, OFloatingTitleBar r4, d.h.b.z.a r5, d.h.b.z.d r6, e r7, e r8, d.h.b.z.a r9, int r10, d.h.b.z.a r11, b r12, d.h.a.a<d.x> r13) {
            d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36581a = r3;
            this.f36582b = r4;
            this.f36583c = r5;
            this.f36584d = r6;
            this.f36585e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r14;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$runEndAreaTransition$onOneFinished(this.f36581a, this.f36582b, this.f36583c, this.f36584d, this.f36585e, this.f, this.g, this.h, this.i, this.j, this.k, "subEnd");
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class w extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f36586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.d f36589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f36590e;
        final /* synthetic */ e f;
        final /* synthetic */ d.h.b.z.a g;
        final /* synthetic */ int h;
        final /* synthetic */ d.h.b.z.a i;
        final /* synthetic */ b j;
        final /* synthetic */ d.h.a.a<d.x> k;

        w(f r3, OFloatingTitleBar r4, d.h.b.z.a r5, d.h.b.z.d r6, e r7, e r8, d.h.b.z.a r9, int r10, d.h.b.z.a r11, b r12, d.h.a.a<d.x> r13) {
            d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36586a = r3;
            this.f36587b = r4;
            this.f36588c = r5;
            this.f36589d = r6;
            this.f36590e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r14;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OFloatingTitleBar.access$runEndAreaTransition$onOneFinished(this.f36586a, this.f36587b, this.f36588c, this.f36589d, this.f36590e, this.f, this.g, this.h, this.i, this.j, this.k, "end");
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class x extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f36591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f36593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f36594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f36595e;
        final /* synthetic */ Float f;
        final /* synthetic */ Float g;
        final /* synthetic */ f h;
        final /* synthetic */ d.h.b.z.d i;
        final /* synthetic */ e j;
        final /* synthetic */ e k;
        final /* synthetic */ d.h.b.z.a l;
        final /* synthetic */ d.h.b.z.a m;
        final /* synthetic */ b n;
        final /* synthetic */ d.h.a.a<d.x> o;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$x$1, reason: invalid class name */
        /* JADX INFO: compiled from: OFloatingTitleBar.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.a f36596a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ f f36597b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ OFloatingTitleBar f36598c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.d f36599d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ e f36600e;
            final /* synthetic */ e f;
            final /* synthetic */ d.h.b.z.a g;
            final /* synthetic */ int h;
            final /* synthetic */ d.h.b.z.a i;
            final /* synthetic */ b j;
            final /* synthetic */ d.h.a.a<d.x> k;

            AnonymousClass1(d.h.b.z.a r3, f r4, OFloatingTitleBar r5, d.h.b.z.d r6, e r7, e r8, d.h.b.z.a r9, int r10, d.h.b.z.a r11, b r12, d.h.a.a<d.x> r13) {
                d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
                this.f36596a = r3;
                this.f36597b = r4;
                this.f36598c = r5;
                this.f36599d = r6;
                this.f36600e = r7;
                this.f = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r14;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }

            public final void a() {
                if (this.f36596a.f38499a == false) goto L6;
                this.f36596a.f38499a = false;
                OFloatingTitleBar.access$runEndAreaTransition$onOneFinished(this.f36597b, this.f36598c, this.f36596a, this.f36599d, this.f36600e, this.f, this.g, this.h, this.i, this.j, this.k, "subEndShift");
                return;
            }
        }

        x(int r5, OFloatingTitleBar r6, d.h.b.z.a r7, boolean r8, boolean r9, Float r10, Float r11, f r12, d.h.b.z.d r13, e r14, e r15, d.h.b.z.a r16, d.h.b.z.a r17, b r18, d.h.a.a<d.x> r19) {
            d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36591a = r5;
            this.f36592b = r6;
            this.f36593c = r7;
            this.f36594d = r8;
            this.f36595e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            if (this.f36591a == OFloatingTitleBar.access$getEndAreaTransitionGeneration$p(this.f36592b)) goto L11;
            this.f36593c.f38499a = false;
            if (this.f36594d == false) goto L7;
            return;
        L7:
            if (this.f36595e == true) goto L32;
            OFloatingTitleBar.access$runEndAreaTransition$onOneFinished(this.h, this.f36592b, this.f36593c, this.i, this.j, this.k, this.l, this.f36591a, this.m, this.n, this.o, "subEndShiftStale");
            return;
        L32:
            return;
        L11:
            if (this.f36594d == false) goto L14;
            return;
        L14:
            if (this.f36593c.f38499a == false) goto L16;
        L18:
            Float r1 = this.f;
            if (r1 == null) goto L23;
            OFloatingTitleBar r3 = this.f36592b;
            float r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue();
            r3.getEndSubButtonGroup().setTranslationX(r2);
        L23:
            if (this.f36595e == false) goto L25;
            return;
        L25:
            OFloatingTitleBar r4 = this.f36592b;
            Float r5 = this.g;
            if (r5 != null) goto L28;
            float r6 = 0.0f;
        L29:
            OFloatingTitleBar.access$animateEndSubTranslationTo(r4, r6, (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f36593c, this.h, this.f36592b, this.i, this.j, this.k, this.l, this.f36591a, this.m, this.n, this.o), d.h.a.a.class, "com.obric.aiagent.plugin"));
            return;
        L28:
            r6 = r5.floatValue();
            goto L29
        L16:
            if (this.f36595e == true) goto L18;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class y extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f36601a;

        y(d.h.a.a<d.x> r3) {
            this.f36601a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            d.h.a.a<d.x> r0 = this.f36601a;
            if (r0 == null) goto L7;
            r0.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBar.kt */
    static final class z extends d.h.b.p implements d.h.a.b<Integer, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f36602a;

        z(OFloatingTitleBar r1) {
            this.f36602a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Integer r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return d.x.f38692a;
        }

        public final void a(int r2) {
            OFloatingTitleBar.access$setCenterTintColor$p(this.f36602a, r2);
            OFloatingTitleBar r1 = this.f36602a;
            OFloatingTitleBar.access$updateGroupItemsTint(r1, r1.getCenterButtonGroup(), r2);
        }
    }

    public OFloatingTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFloatingTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$ExUP2_wM4TuMdgza7Ka5t-E4SF8, reason: not valid java name */
    public static /* synthetic */ void m1209lambda$ExUP2_wM4TuMdgza7Ka5tE4SF8(OFloatingTitleBar r0, View r1, View r2) {
        m1217withFallbackClickListener$lambda26(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$GGIW8hTwt6el910vM5oPQWwzkK8(OFloatingTitleBar r0, int r1) {
        m1214releaseFreezeEndAreaWidth$lambda49(r0, r1);
    }

    public static /* synthetic */ void lambda$MbCzbbW8hxoF_8PQvLaeQFyexwk(OFloatingTitleBar r0) {
        m1216setFloatingTransitionOwnerActive$lambda63(r0);
    }

    /* JADX INFO: renamed from: lambda$W-U4WHDyMq4h0GWo9Q9ugQXexNA, reason: not valid java name */
    public static /* synthetic */ void m1210lambda$WU4WHDyMq4h0GWo9Q9ugQXexNA(OFloatingTitleBar r0) {
        m1215setFloatingTransitionEnabled$lambda62(r0);
    }

    /* JADX INFO: renamed from: lambda$cJCn-_hWxLMoo6Xpv-4Kdqr_oeA, reason: not valid java name */
    public static /* synthetic */ void m1211lambda$cJCn_hWxLMoo6Xpv4Kdqr_oeA(OFloatingTitleBar r0) {
        m1213onAttachedToWindow$lambda1(r0);
    }

    /* JADX INFO: renamed from: lambda$pUCLHnINpyuadWsBzrHt-e5Bp6s, reason: not valid java name */
    public static /* synthetic */ void m1212lambda$pUCLHnINpyuadWsBzrHte5Bp6s(OFloatingTitleBar r0, View.OnClickListener r1, View r2) {
        m1218wrapActionClickListener$lambda37(r0, r1, r2);
    }

    public final View addCenterAction(View r8) {
        d.h.b.o.e(r8, "view");
        return addCenterAction$default(this, r8, 0, false, 6, null);
    }

    public final View addCenterAction(View r8, int r9) {
        d.h.b.o.e(r8, "view");
        return addCenterAction$default(this, r8, r9, false, 4, null);
    }

    public final View addEndAction(View r8) {
        d.h.b.o.e(r8, "view");
        return addEndAction$default(this, r8, 0, false, 6, null);
    }

    public final View addEndAction(View r8, int r9) {
        d.h.b.o.e(r8, "view");
        return addEndAction$default(this, r8, r9, false, 4, null);
    }

    public final View addStartAction(View r8) {
        d.h.b.o.e(r8, "view");
        return addStartAction$default(this, r8, 0, false, 6, null);
    }

    public final View addStartAction(View r8, int r9) {
        d.h.b.o.e(r8, "view");
        return addStartAction$default(this, r8, r9, false, 4, null);
    }

    public final View addSubEndAction(View r8) {
        d.h.b.o.e(r8, "view");
        return addSubEndAction$default(this, r8, 0, false, 6, null);
    }

    public final View addSubEndAction(View r8, int r9) {
        d.h.b.o.e(r8, "view");
        return addSubEndAction$default(this, r8, r9, false, 4, null);
    }

    public final void applyState(com.obric.oui.titlebar.a r8) {
        d.h.b.o.e(r8, "state");
        applyState$default(this, r8, false, false, 6, null);
    }

    public final void applyState(com.obric.oui.titlebar.a r8, boolean r9) {
        d.h.b.o.e(r8, "state");
        applyState$default(this, r8, r9, false, 4, null);
    }

    public final void batchSet(d.h.a.b<? super OFloatingTitleBar, d.x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "block");
        batchSet$default(this, false, r5, 1, null);
    }

    public final void hideCenterAction() {
        hideCenterAction$default(this, false, 1, null);
    }

    public final void hideEndAction() {
        hideEndAction$default(this, false, 1, null);
    }

    public final void hideStartAction() {
        hideStartAction$default(this, false, 1, null);
    }

    public final void hideSubEndAction() {
        hideSubEndAction$default(this, false, 1, null);
    }

    public final void removeAllCenterAction() {
        removeAllCenterAction$default(this, false, 1, null);
    }

    public final void removeAllEndAction() {
        removeAllEndAction$default(this, false, 1, null);
    }

    public final void removeAllStartAction() {
        removeAllStartAction$default(this, false, 1, null);
    }

    public final void removeAllSubEndAction() {
        removeAllSubEndAction$default(this, false, 1, null);
    }

    public final void removeCenterAction() {
        removeCenterAction$default(this, false, 1, null);
    }

    public final void removeCenterActionAt(int r4) {
        removeCenterActionAt$default(this, r4, false, 2, null);
    }

    public final void removeEndAction() {
        removeEndAction$default(this, false, 1, null);
    }

    public final void removeEndActionAt(int r4) {
        removeEndActionAt$default(this, r4, false, 2, null);
    }

    public final void removeStartAction() {
        removeStartAction$default(this, false, 1, null);
    }

    public final void removeStartActionAt(int r4) {
        removeStartActionAt$default(this, r4, false, 2, null);
    }

    public final void removeSubEndAction() {
        removeSubEndAction$default(this, false, 1, null);
    }

    public final void removeSubEndActionAt(int r4) {
        removeSubEndActionAt$default(this, r4, false, 2, null);
    }

    public final void setDefaultMaskBackground() {
    }

    public final void updateAction(com.obric.oui.titlebar.a.c r4) {
        d.h.b.o.e(r4, "actionsState");
        updateAction$default(this, r4, false, 2, null);
    }

    public /* synthetic */ OFloatingTitleBar(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void access$animateEndSubTranslationTo(OFloatingTitleBar r2, float r3, d.h.a.a r4) {
        r2.animateEndSubTranslationTo(r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ View access$createViewForSavedAction(OFloatingTitleBar r2, OButtonGroup.f r3, int r4, List r5) {
        return r2.createViewForSavedAction(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$dispatchTitleBarTransitionEnd(OFloatingTitleBar r0) {
        r0.dispatchTitleBarTransitionEnd();
    }

    public static final /* synthetic */ FrameLayout access$getCenterContainer$p(OFloatingTitleBar r0) {
        return r0.centerContainer;
    }

    public static final /* synthetic */ int access$getCenterTintColor$p(OFloatingTitleBar r0) {
        return r0.centerTintColor;
    }

    public static final /* synthetic */ com.obric.oui.titlebar.a.c access$getCurrentActionsState$p(OFloatingTitleBar r0) {
        return r0.currentActionsState;
    }

    public static final /* synthetic */ int access$getEndAreaTransitionGeneration$p(OFloatingTitleBar r0) {
        return r0.endAreaTransitionGeneration;
    }

    public static final /* synthetic */ int access$getEndSubTintColor$p(OFloatingTitleBar r0) {
        return r0.endSubTintColor;
    }

    public static final /* synthetic */ int access$getEndTintColor$p(OFloatingTitleBar r0) {
        return r0.endTintColor;
    }

    public static final /* synthetic */ int access$getStartTintColor$p(OFloatingTitleBar r0) {
        return r0.startTintColor;
    }

    public static final /* synthetic */ View access$getTitleBarContainer$p(OFloatingTitleBar r0) {
        return r0.titleBarContainer;
    }

    public static final /* synthetic */ void access$releaseFreezeEndAreaWidth(OFloatingTitleBar r0) {
        r0.releaseFreezeEndAreaWidth();
    }

    public static final /* synthetic */ void access$runEndAreaTransition$onOneFinished(f r13, OFloatingTitleBar r14, d.h.b.z.a r15, d.h.b.z.d r16, e r17, e r18, d.h.b.z.a r19, int r20, d.h.b.z.a r21, b r22, d.h.a.a r23, String r24) {
        runEndAreaTransition$onOneFinished(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin"), r24);
    }

    public static final /* synthetic */ void access$runEndAreaTransition$onParticipantFinished(d.h.b.z.d r8, d.h.b.z.a r9, int r10, OFloatingTitleBar r11, d.h.b.z.a r12, e r13, b r14, d.h.a.a r15) {
        runEndAreaTransition$onParticipantFinished(r8, r9, r10, r11, r12, r13, r14, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$setCenterShiftAnimator$p(OFloatingTitleBar r0, com.obric.common.oea.foundation.animation.manager.d r1) {
        r0.centerShiftAnimator = r1;
    }

    public static final /* synthetic */ void access$setCenterTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.centerTintColor = r1;
    }

    public static final /* synthetic */ void access$setEndSubShiftAnimator$p(OFloatingTitleBar r0, com.obric.common.oea.foundation.animation.manager.d r1) {
        r0.endSubShiftAnimator = r1;
    }

    public static final /* synthetic */ void access$setEndSubTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.endSubTintColor = r1;
    }

    public static final /* synthetic */ void access$setEndTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.endTintColor = r1;
    }

    public static final /* synthetic */ void access$setStartTintColor$p(OFloatingTitleBar r0, int r1) {
        r0.startTintColor = r1;
    }

    public static final /* synthetic */ com.obric.common.oea.foundation.animation.manager.d access$startCenterTranslationXSpring(OFloatingTitleBar r2, float r3, float r4, d.h.a.b r5, d.h.a.a r6) {
        return r2.startCenterTranslationXSpring(r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$updateAction$finishIfReady(d.h.b.z.a r2, d.h.b.z.a r3, d.h.b.z.a r4, d.h.a.a r5) {
        updateAction$finishIfReady(r2, r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$updateGroupItemsTint(OFloatingTitleBar r0, OButtonGroup r1, int r2) {
        r0.updateGroupItemsTint(r1, r2);
    }

    public static final /* synthetic */ void access$updateSubEndShiftByEndRawAlpha(OFloatingTitleBar r0, h r1, Float r2, Float r3, float r4, float r5) {
        r0.updateSubEndShiftByEndRawAlpha(r1, r2, r3, r4, r5);
    }

    public OFloatingTitleBar(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        super(r13, r14, r12);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.isActionContentVisible = true;
        this.isNonActionContentVisible = true;
        this.floatingTransitionOwnerActive = true;
        this.currentActionsState = new com.obric.oui.titlebar.a.c(null, null, null, null, 15, null);
        this.maskMaterial = (d.h.a.b) ZeusTransformUtils.preCheckCast(new p(this), d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.window.floating.a r0 = new com.obric.oui.window.floating.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.floatingWindowHelper = r0;
        this.mIsLargeFont = com.obric.oui.d.h.a(ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getConfiguration().fontScale);
        refreshDimensionCache();
        ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_floating_title_bar_layout, "layout", "o_floating_title_bar_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        initViews();
        if (r14 == null) goto L5;
        initAttrs(r14);
    L5:
        r0.a(49);
    }

    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r0 = this.startButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("startButtonGroup");
        return null;
    }

    public final void setStartButtonGroup(OButtonGroup r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.startButtonGroup = r2;
    }

    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r0 = this.centerButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("centerButtonGroup");
        return null;
    }

    public final void setCenterButtonGroup(OButtonGroup r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.centerButtonGroup = r2;
    }

    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r0 = this.endSubButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("endSubButtonGroup");
        return null;
    }

    public final void setEndSubButtonGroup(OButtonGroup r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.endSubButtonGroup = r2;
    }

    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r0 = this.endButtonGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("endButtonGroup");
        return null;
    }

    public final void setEndButtonGroup(OButtonGroup r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.endButtonGroup = r2;
    }

    static {
        Companion = new c(null);
        AVOIDANCE_SHIFT_BOUNCE = com.obric.common.oea.foundation.animation.h.e.a.f;
        AVOIDANCE_SHIFT_DURATION = com.obric.common.oea.foundation.animation.h.e.c.f;
    }

    public final void updateLayoutForInsetTop(int r9) {
        View r0 = this.materialMask;
        View r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("materialMask");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_title_bar_mask_height, "dimen", "oui_title_bar_mask_height")) + r9;
        View r3 = this.materialMask;
        if (r3 != null) goto L8;
        d.h.b.o.c("materialMask");
        r3 = null;
    L8:
        r3.setLayoutParams(r1);
        View r4 = this.titleBarContainer;
        if (r4 != null) goto L11;
        d.h.b.o.c("titleBarContainer");
        r4 = null;
    L11:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r6.topMargin = r9;
        View r8 = this.titleBarContainer;
        if (r8 != null) goto L14;
        d.h.b.o.c("titleBarContainer");
    L15:
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        r2 = r8;
        goto L15
    }

    private final void initViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.start_container, DbHelper.COL_ID, "start_container"));
        d.h.b.o.c(r0, "findViewById(R.id.start_container)");
        this.startContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r0, FrameLayout.class, "com.obric.aiagent.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.start_button_group, DbHelper.COL_ID, "start_button_group"));
        d.h.b.o.c(r1, "findViewById(R.id.start_button_group)");
        setStartButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r1, OButtonGroup.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, DbHelper.COL_ID, "start_title_container"));
        d.h.b.o.c(r2, "findViewById(R.id.start_title_container)");
        this.startTitleContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.start_title, DbHelper.COL_ID, "start_title"));
        d.h.b.o.c(r3, "findViewById(R.id.start_title)");
        this.startTitleView = (OTextView) ZeusTransformUtils.preCheckCast(r3, OTextView.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.start_sub_title, DbHelper.COL_ID, "start_sub_title"));
        d.h.b.o.c(r4, "findViewById(R.id.start_sub_title)");
        this.startSubtitleView = (OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.center_container, DbHelper.COL_ID, "center_container"));
        d.h.b.o.c(r5, "findViewById(R.id.center_container)");
        this.centerContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.center_button_group, DbHelper.COL_ID, "center_button_group"));
        d.h.b.o.c(r6, "findViewById(R.id.center_button_group)");
        setCenterButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r6, OButtonGroup.class, "com.obric.aiagent.plugin"));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.center_custom_container, DbHelper.COL_ID, "center_custom_container"));
        d.h.b.o.c(r7, "findViewById(R.id.center_custom_container)");
        this.centerCustomContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title_container, DbHelper.COL_ID, "center_title_container"));
        d.h.b.o.c(r8, "findViewById(R.id.center_title_container)");
        this.centerTitleContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, DbHelper.COL_ID, "center_title"));
        d.h.b.o.c(r9, "findViewById(R.id.center_title)");
        this.centerTitleView = (OTextView) ZeusTransformUtils.preCheckCast(r9, OTextView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.center_sub_title, DbHelper.COL_ID, "center_sub_title"));
        d.h.b.o.c(r10, "findViewById(R.id.center_sub_title)");
        this.centerSubtitleView = (OTextView) ZeusTransformUtils.preCheckCast(r10, OTextView.class, "com.obric.aiagent.plugin");
        View r11 = null;
        if (Build.VERSION.SDK_INT < 28) goto L17;
        OTextView r12 = this.startTitleView;
        if (r12 != null) goto L7;
        d.h.b.o.c("startTitleView");
        r12 = null;
    L7:
        r12.setFallbackLineSpacing(false);
        OTextView r13 = this.startSubtitleView;
        if (r13 != null) goto L10;
        d.h.b.o.c("startSubtitleView");
        r13 = null;
    L10:
        r13.setFallbackLineSpacing(false);
        OTextView r14 = this.centerTitleView;
        if (r14 != null) goto L13;
        d.h.b.o.c("centerTitleView");
        r14 = null;
    L13:
        r14.setFallbackLineSpacing(false);
        OTextView r15 = this.centerSubtitleView;
        if (r15 != null) goto L16;
        d.h.b.o.c("centerSubtitleView");
        r15 = null;
    L16:
        r15.setFallbackLineSpacing(false);
    L17:
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.end_container, DbHelper.COL_ID, "end_container"));
        d.h.b.o.c(r16, "findViewById(R.id.end_container)");
        this.endContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r16, LinearLayout.class, "com.obric.aiagent.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.end_sub_button_group, DbHelper.COL_ID, "end_sub_button_group"));
        d.h.b.o.c(r17, "findViewById(R.id.end_sub_button_group)");
        setEndSubButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r17, OButtonGroup.class, "com.obric.aiagent.plugin"));
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, DbHelper.COL_ID, "end_button_group"));
        d.h.b.o.c(r18, "findViewById(R.id.end_button_group)");
        setEndButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r18, OButtonGroup.class, "com.obric.aiagent.plugin"));
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.material_mask, DbHelper.COL_ID, "material_mask"));
        d.h.b.o.c(r19, "findViewById(R.id.material_mask)");
        this.materialMask = r19;
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, DbHelper.COL_ID, "title_bar_container"));
        d.h.b.o.c(r20, "findViewById(R.id.title_bar_container)");
        this.titleBarContainer = r20;
        if (r20 != null) goto L20;
        d.h.b.o.c("titleBarContainer");
    L21:
        r11.setClickable(true);
        this.currentMaskMaterialConfig = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.maskMaterial.invoke(Boolean.valueOf(true ^ isDarkTheme())), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
        setDefaultBackdropTargetForChild();
        return;
    L20:
        r11 = r20;
        goto L21
    }

    private final View getDefaultTargetView() {
        if (com.obric.oui.material.l.c() <= 1) goto L9;
        View r2 = this.titleBarContainer;
        if (r2 != null) goto L10;
        d.h.b.o.c("titleBarContainer");
        return null;
    L10:
        return r2;
    L9:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    private final void initAttrs(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "context");
        int[] r2 = R.styleable.OFloatingTitleBar;
        d.h.b.o.c(r2, TAG);
        TypedArray r12 = r0.obtainStyledAttributes(r11, r2, 0, 0);
        d.h.b.o.c(r12, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type, "styleable", "OFloatingTitleBar_oFloatingTitleBar_type")) == false) goto L6;
        setTitleType(r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type, "styleable", "OFloatingTitleBar_oFloatingTitleBar_type"), 0));
    L6:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitle")) == false) goto L9;
        setStartTitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitle")));
    L9:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitleColor")) == false) goto L12;
        setStartTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
    L12:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitle")) == false) goto L15;
        setStartSubtitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitle")));
    L15:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor")) == false) goto L18;
        setStartSubTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
    L18:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitle")) == false) goto L21;
        setCenterTitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitle")));
    L21:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitleColor")) == false) goto L24;
        setCenterTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
    L24:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitle")) == false) goto L27;
        setCenterSubtitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitle")));
    L27:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor")) == false) goto L29;
        setCenterSubTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
    L29:
        setStartButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setCenterButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setSubEndButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setEndButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground")) == false) goto L36;
        Drawable r1 = r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground"));
        if (r1 == null) goto L34;
        setMaskBackground(r1);
        goto L36
    L34:
        setMaskBackground((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground"), 0)), Drawable.class, "com.obric.aiagent.plugin"));
    L36:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground")) == false) goto L41;
        if (r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground"), false) == false) goto L41;
        setDefaultMaskBackground();
    L41:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurColors, "styleable", "OFloatingTitleBar_oui_widgetBlurColors")) == false) goto L54;
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, "styleable", "OFloatingTitleBar_oui_widgetBlurBlendModes")) == false) goto L54;
        int r3 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurColors, "styleable", "OFloatingTitleBar_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"));
        int r5 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, "styleable", "OFloatingTitleBar_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes"));
        com.obric.oui.material.c r6 = this.currentMaskMaterialConfig;
        if (r6 != null) goto L47;
        d.h.b.o.c("currentMaskMaterialConfig");
        r6 = null;
    L47:
        r6.a(com.obric.oui.material.l.a(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), r3, r5));
        com.obric.oui.material.c r4 = this.currentMaskMaterialConfig;
        if (r4 != null) goto L51;
        d.h.b.o.c("currentMaskMaterialConfig");
        r4 = null;
    L51:
        if (r4.c() != null) goto L54;
        com.obric.oui.d.a.b.e(TAG, "init get widget blur colors or modes error");
    L54:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType, "styleable", "OFloatingTitleBar_oui_widgetMaterialSrcType")) == false) goto L61;
        int r7 = ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType, "styleable", "OFloatingTitleBar_oui_widgetMaterialSrcType");
        if (this.mType != 2) goto L58;
        int r8 = 4;
    L59:
        this.materialSrcType = r12.getInt(r7, r8);
        goto L61
    L58:
        r8 = 2;
    L61:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius")) == false) goto L64;
        setMaskBlurRadius(r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius"), BlurToken.Blur_Progress_Thin));
    L64:
        if (r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetFitInsetTop, "styleable", "OFloatingTitleBar_oui_widgetFitInsetTop"), r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion, "styleable", "OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion"), false)) == true) goto L66;
    L68:
        boolean r9 = false;
    L69:
        this.floatingWindowHelper.a(r9, (d.h.a.b) ZeusTransformUtils.preCheckCast(new o(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition, "styleable", "OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition")) == false) goto L72;
        setFloatingTransitionEnabled(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition, "styleable", "OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition"), false));
    L72:
        r12.recycle();
        return;
    L66:
        if (this.mType == 1) goto L68;
        r9 = true;
        goto L69
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == true) goto L5;
    L13:
        this.floatingWindowHelper.b();
        FloatingTransitionBridge r0 = this.floatingTransitionBridge;
        if (r0 == null) goto L17;
        FloatingTransitionBridge.a(r0, false, 1, null);
    L17:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L21;
        r1.a("attached");
    L21:
        post(new $$Lambda$OFloatingTitleBar$cJCn_hWxLMoo6Xpv4Kdqr_oeA(this));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getParent(), com.obric.oui.material.b.class) == false) goto L8;
    L6:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        showMask(false);
        goto L13
    L8:
        if (ZeusTransformUtils.instanceOf(getParent().getParent(), com.obric.oui.material.b.class) == true) goto L6;
        r2 = false;
        goto L11
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m1213onAttachedToWindow$lambda1(OFloatingTitleBar r1) {
        d.h.b.o.e(r1, "this$0");
        r1.notifyFloatingTransitionStateChanged$OUI_standardRelease();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FloatingTransitionBridge r0 = this.floatingTransitionBridge;
        if (r0 == null) goto L6;
        FloatingTransitionBridge.a(r0, false, false, 3, null);
    L6:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 != 0) goto L9;
        FloatingTransitionBridge r0 = this.floatingTransitionBridge;
        if (r0 == null) goto L10;
        r0.a("windowVisible");
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L9;
        FloatingTransitionBridge r0 = this.floatingTransitionBridge;
        if (r0 == null) goto L10;
        r0.a("windowFocus");
        return;
    L10:
        return;
    }

    public final void setTitleType(int r9) {
        this.mType = r9;
        com.obric.oui.window.floating.a r0 = this.floatingWindowHelper;
        if (r9 != 2) goto L5;
        boolean r3 = true;
    L6:
        r0.a(r3);
        View r6 = null;
        com.obric.oui.material.c r7 = null;
        View r8 = null;
        if (r9 == 0) goto L33;
        if (r9 == 1) goto L25;
        if (r9 != 2) goto L44;
        View r10 = this.titleBarContainer;
        if (r10 != null) goto L14;
        d.h.b.o.c("titleBarContainer");
        r10 = null;
    L14:
        r10.setMinimumHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 56));
        View r11 = this.titleBarContainer;
        if (r11 != null) goto L17;
        d.h.b.o.c("titleBarContainer");
        r11 = null;
    L17:
        r11.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        com.obric.oui.material.c r12 = this.currentMaskMaterialConfig;
        if (r12 != null) goto L20;
        d.h.b.o.c("currentMaskMaterialConfig");
    L21:
        com.obric.oui.blur.a r13 = r7.g();
        if (r13 == null) goto L45;
        setMaskBlurRadius(r13.a());
        return;
    L45:
        return;
    L20:
        r7 = r12;
        goto L21
    L44:
        return;
    L25:
        View r14 = this.titleBarContainer;
        if (r14 != null) goto L28;
        d.h.b.o.c("titleBarContainer");
        r14 = null;
    L28:
        r14.setMinimumHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 64));
        View r15 = this.titleBarContainer;
        if (r15 != null) goto L31;
        d.h.b.o.c("titleBarContainer");
    L32:
        r8.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        return;
    L31:
        r8 = r15;
        goto L32
    L33:
        View r16 = this.titleBarContainer;
        if (r16 != null) goto L36;
        d.h.b.o.c("titleBarContainer");
        r16 = null;
    L36:
        r16.setMinimumHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 56));
        View r17 = this.titleBarContainer;
        if (r17 != null) goto L39;
        d.h.b.o.c("titleBarContainer");
    L40:
        r6.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8));
        return;
    L39:
        r6 = r17;
        goto L40
    L5:
        r3 = false;
        goto L6
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.addStartAction(r1, r2, r3);
    }

    public final View addStartAction(View r2, int r3, boolean r4) {
        d.h.b.o.e(r2, "view");
        return addStartAction(r2, r3, r4, null);
    }

    public final View addStartAction(View r9, int r10, boolean r11, View.OnClickListener r12) {
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "view");
        if (r13 == null) goto L6;
        r9.setOnClickListener(wrapActionClickListener(r13));
    L6:
        updateActionViews$default(this, addActionView(currentActionViews(getStartButtonGroup()), r10, r9), null, null, null, r11, 14, null);
        return r9;
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addStartAction(r2, r3, r7);
    }

    public final View addStartAction(int r3, int r4, View.OnClickListener r5) {
        return addStartAction(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r1, int r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addStartAction(r2, r3, r4, r8);
    }

    public final View addStartAction(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.a(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, addActionItem(this.currentActionsState.a(), r12, r16), null, null, null, r13, 14, null).a().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addStartAction(r2, r3, r7);
    }

    public final View addStartAction(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        return addStartAction(r3, r4, false, r6);
    }

    public static /* synthetic */ View addStartAction$default(OFloatingTitleBar r1, String r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addStartAction(r2, r3, r4, r8);
    }

    public final View addStartAction(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "text");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.a(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, addActionItem(this.currentActionsState.a(), r12, r16), null, null, null, r13, 14, null).a().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ View addStartTitleArrowAction$default(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addStartTitleArrowAction(r2, r3, r7);
    }

    public final View addStartTitleArrowAction(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DBDefinition.TITLE);
        return addStartTitleArrowAction(r3, r4, false, r6);
    }

    public static /* synthetic */ View addStartTitleArrowAction$default(OFloatingTitleBar r1, String r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addStartTitleArrowAction(r2, r3, r4, r8);
    }

    public final View addStartTitleArrowAction(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, DBDefinition.TITLE);
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.b(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.a(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, addActionItem(this.currentActionsState.a(), r12, r16), null, null, null, r13, 14, null).a().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void removeStartActionAt$default(OFloatingTitleBar r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.removeStartActionAt(r1, r2);
    }

    public final void removeStartActionAt(int r10, boolean r11) {
        updateActionsState$default(this, removeActionItemAt(this.currentActionsState.a(), r10), null, null, null, r11, 14, null);
    }

    public static /* synthetic */ void removeStartAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeStartAction(r1);
    }

    public final void removeStartAction(boolean r10) {
        updateActionsState$default(this, removeLastActionItem(this.currentActionsState.a()), null, null, null, r10, 14, null);
    }

    public static /* synthetic */ void removeAllStartAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeAllStartAction(r1);
    }

    public final void removeAllStartAction(boolean r9) {
        updateActionsState$default(this, d.a.p.b(), null, null, null, r9, 14, null);
    }

    public final void showStartAction(boolean r1) {
        OButtonGroup r0 = getStartButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public static /* synthetic */ void hideStartAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.hideStartAction(r1);
    }

    public final void hideStartAction(boolean r3) {
        OButtonGroup.hide$default(getStartButtonGroup(), r3, null, 2, null);
    }

    public final void showStartAction(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        OButtonGroup.show$default(getStartButtonGroup(), r3, null, 2, null);
        return;
    L4:
        hideStartAction(r3);
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.addCenterAction(r1, r2, r3);
    }

    public final View addCenterAction(View r2, int r3, boolean r4) {
        d.h.b.o.e(r2, "view");
        return addCenterAction(r2, r3, r4, null);
    }

    public final View addCenterAction(View r9, int r10, boolean r11, View.OnClickListener r12) {
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "view");
        if (r13 == null) goto L6;
        r9.setOnClickListener(wrapActionClickListener(r13));
    L6:
        updateActionViews$default(this, null, addActionView(currentActionViews(getCenterButtonGroup()), r10, r9), null, null, r11, 13, null);
        return r9;
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addCenterAction(r2, r3, r7);
    }

    public final View addCenterAction(int r3, int r4, View.OnClickListener r5) {
        return addCenterAction(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r1, int r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addCenterAction(r2, r3, r4, r8);
    }

    public final View addCenterAction(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.b(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, addActionItem(this.currentActionsState.b(), r12, r16), null, null, r13, 13, null).b().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addCenterAction(r2, r3, r7);
    }

    public final View addCenterAction(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        return addCenterAction(r3, r4, false, r6);
    }

    public static /* synthetic */ View addCenterAction$default(OFloatingTitleBar r1, String r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addCenterAction(r2, r3, r4, r8);
    }

    public final View addCenterAction(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "text");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.b(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, addActionItem(this.currentActionsState.b(), r12, r16), null, null, r13, 13, null).b().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void removeCenterActionAt$default(OFloatingTitleBar r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.removeCenterActionAt(r1, r2);
    }

    public final void removeCenterActionAt(int r10, boolean r11) {
        updateActionsState$default(this, null, removeActionItemAt(this.currentActionsState.b(), r10), null, null, r11, 13, null);
    }

    public static /* synthetic */ void removeCenterAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeCenterAction(r1);
    }

    public final void removeCenterAction(boolean r10) {
        updateActionsState$default(this, null, removeLastActionItem(this.currentActionsState.b()), null, null, r10, 13, null);
    }

    public static /* synthetic */ void removeAllCenterAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeAllCenterAction(r1);
    }

    public final void removeAllCenterAction(boolean r9) {
        updateActionsState$default(this, null, d.a.p.b(), null, null, r9, 13, null);
    }

    public final void showCenterAction(boolean r1) {
        OButtonGroup r0 = getCenterButtonGroup();
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public static /* synthetic */ void hideCenterAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.hideCenterAction(r1);
    }

    public final void hideCenterAction(boolean r3) {
        OButtonGroup.hide$default(getCenterButtonGroup(), r3, null, 2, null);
    }

    public final void showCenterAction(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        OButtonGroup.show$default(getCenterButtonGroup(), r3, null, 2, null);
        return;
    L4:
        hideCenterAction(r3);
    }

    public final void setCenterCustomView(View r4) {
        d.h.b.o.e(r4, "view");
        FrameLayout r0 = this.centerCustomContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r2 = this.centerCustomContainer;
        if (r2 != null) goto L8;
        d.h.b.o.c("centerCustomContainer");
        r2 = null;
    L8:
        r2.addView(r4);
        FrameLayout r3 = this.centerCustomContainer;
        if (r3 != null) goto L11;
        d.h.b.o.c("centerCustomContainer");
    L12:
        r1.setVisibility(0);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.material.g.class) == false) goto L16;
        ((com.obric.oui.material.g) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.material.g.class, "com.obric.aiagent.plugin")).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void removeCenterCustomView() {
        FrameLayout r0 = this.centerCustomContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r3 = this.centerCustomContainer;
        if (r3 != null) goto L8;
        d.h.b.o.c("centerCustomContainer");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    public final void showCenterCustomView(boolean r1) {
        FrameLayout r0 = this.centerCustomContainer;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerCustomContainer");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.addEndAction(r1, r2, r3);
    }

    public final View addEndAction(View r2, int r3, boolean r4) {
        d.h.b.o.e(r2, "view");
        return addEndAction(r2, r3, r4, null);
    }

    public final View addEndAction(View r9, int r10, boolean r11, View.OnClickListener r12) {
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "view");
        if (r13 == null) goto L6;
        r9.setOnClickListener(wrapActionClickListener(r13));
    L6:
        updateActionViews$default(this, null, null, null, addActionView(currentActionViews(getEndButtonGroup()), r10, r9), r11, 7, null);
        return r9;
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addEndAction(r2, r3, r7);
    }

    public final View addEndAction(int r3, int r4, View.OnClickListener r5) {
        return addEndAction(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r1, int r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addEndAction(r2, r3, r4, r8);
    }

    public final View addEndAction(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.d(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, null, null, addActionItem(this.currentActionsState.d(), r12, r16), r13, 7, null).d().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addEndAction(r2, r3, r7);
    }

    public final View addEndAction(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        return addEndAction(r3, r4, false, r6);
    }

    public static /* synthetic */ View addEndAction$default(OFloatingTitleBar r1, String r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addEndAction(r2, r3, r4, r8);
    }

    public final View addEndAction(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "text");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.d(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, null, null, addActionItem(this.currentActionsState.d(), r12, r16), r13, 7, null).d().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void removeEndActionAt$default(OFloatingTitleBar r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.removeEndActionAt(r1, r2);
    }

    public final void removeEndActionAt(int r10, boolean r11) {
        updateActionsState$default(this, null, null, null, removeActionItemAt(this.currentActionsState.d(), r10), r11, 7, null);
    }

    public static /* synthetic */ void removeEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeEndAction(r1);
    }

    public final void removeEndAction(boolean r10) {
        updateActionsState$default(this, null, null, null, removeLastActionItem(this.currentActionsState.d()), r10, 7, null);
    }

    public static /* synthetic */ void removeAllEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeAllEndAction(r1);
    }

    public final void removeAllEndAction(boolean r9) {
        updateActionsState$default(this, null, null, null, d.a.p.b(), r9, 7, null);
    }

    public final void showEndAction(boolean r2) {
        OButtonGroup r0 = getEndButtonGroup();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        refreshSubEndToEndGapForCurrentState();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static /* synthetic */ void hideEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.hideEndAction(r1);
    }

    public final void hideEndAction(boolean r3) {
        OButtonGroup.hide$default(getEndButtonGroup(), r3, null, 2, null);
    }

    public final void showEndAction(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        OButtonGroup.show$default(getEndButtonGroup(), r3, null, 2, null);
        return;
    L4:
        hideEndAction(r3);
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.addSubEndAction(r1, r2, r3);
    }

    public final View addSubEndAction(View r2, int r3, boolean r4) {
        d.h.b.o.e(r2, "view");
        return addSubEndAction(r2, r3, r4, null);
    }

    public final View addSubEndAction(View r9, int r10, boolean r11, View.OnClickListener r12) {
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "view");
        if (r13 == null) goto L6;
        r9.setOnClickListener(wrapActionClickListener(r13));
    L6:
        updateActionViews$default(this, null, null, addActionView(currentActionViews(getEndSubButtonGroup()), r10, r9), null, r11, 11, null);
        return r9;
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addSubEndAction(r2, r3, r7);
    }

    public final View addSubEndAction(int r3, int r4, View.OnClickListener r5) {
        return addSubEndAction(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r1, int r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addSubEndAction(r2, r3, r4, r8);
    }

    public final View addSubEndAction(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.c(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, null, addActionItem(this.currentActionsState.c(), r12, r16), null, r13, 11, null).c().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.addSubEndAction(r2, r3, r7);
    }

    public final View addSubEndAction(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        return addSubEndAction(r3, r4, false, r6);
    }

    public static /* synthetic */ View addSubEndAction$default(OFloatingTitleBar r1, String r2, int r3, boolean r4, View.OnClickListener r5, int r6, Object r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.addSubEndAction(r2, r3, r4, r8);
    }

    public final View addSubEndAction(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "text");
        com.obric.oui.titlebar.a.C0999a r16 = com.obric.oui.titlebar.a.C0999a.f36629a.a(r11, r15);
        int r17 = getActionInsertIndex(this.currentActionsState.c(), r12);
        return (View) ZeusTransformUtils.preCheckCast(updateActionsState$default(this, null, null, addActionItem(this.currentActionsState.c(), r12, r16), null, r13, 11, null).c().get(r17), View.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void removeSubEndActionAt$default(OFloatingTitleBar r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.removeSubEndActionAt(r1, r2);
    }

    public final void removeSubEndActionAt(int r10, boolean r11) {
        updateActionsState$default(this, null, null, removeActionItemAt(this.currentActionsState.c(), r10), null, r11, 11, null);
    }

    public static /* synthetic */ void removeSubEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeSubEndAction(r1);
    }

    public final void removeSubEndAction(boolean r10) {
        updateActionsState$default(this, null, null, removeLastActionItem(this.currentActionsState.c()), null, r10, 11, null);
    }

    public static /* synthetic */ void removeAllSubEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.removeAllSubEndAction(r1);
    }

    public final void removeAllSubEndAction(boolean r9) {
        updateActionsState$default(this, null, null, d.a.p.b(), null, r9, 11, null);
    }

    public final void showSubEndAction(boolean r2) {
        OButtonGroup r0 = getEndSubButtonGroup();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        refreshSubEndToEndGapForCurrentState();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static /* synthetic */ void hideSubEndAction$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.hideSubEndAction(r1);
    }

    public final void hideSubEndAction(boolean r3) {
        OButtonGroup.hide$default(getEndSubButtonGroup(), r3, null, 2, null);
    }

    public final void showSubEndAction(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        OButtonGroup.show$default(getEndSubButtonGroup(), r3, null, 2, null);
        return;
    L4:
        hideSubEndAction(r3);
    }

    public static /* synthetic */ void updateAction$default(OFloatingTitleBar r0, com.obric.oui.titlebar.a.c r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.updateAction(r1, r2);
    }

    public final void updateAction(com.obric.oui.titlebar.a.c r13, boolean r14) {
        d.h.b.o.e(r13, "actionsState");
        updateAction$default(this, r13, createActionTargetViews$default(this, r13, false, 2, null), r14, false, null, false, 56, null);
    }

    static /* synthetic */ a updateAction$default(OFloatingTitleBar r10, com.obric.oui.titlebar.a.c r11, a r12, boolean r13, boolean r14, d.h.a.a r15, boolean r16, int r17, Object r18) {
        d.h.a.a<d.x> r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r17 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r17 & 16) == 0) goto L9;
        r0 = null;
    L9:
        d.h.a.a<d.x> r8 = r0;
        if ((r17 & 32) == 0) goto L12;
        boolean r9 = true;
    L14:
        return r10.updateAction(r11, r12, r13, r7, r8, r9);
    L12:
        r9 = r16;
        goto L14
    L5:
        r7 = r14;
        goto L7
    }

    private final a updateAction(com.obric.oui.titlebar.a.c r10, a r11, boolean r12, boolean r13, d.h.a.a<d.x> r14, boolean r15) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r13 == true) goto L5;
    L7:
        applyActionGroupsEnabledState(r11);
        boolean r17 = true;
        if (r12 == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r15 == true) goto L15;
    L19:
        boolean r18 = false;
    L20:
        com.obric.oui.titlebar.a.c r19 = null;
        if (r16 != null) goto L25;
        if (r18 == true) goto L25;
        d.h.a.a r110 = (d.h.a.a) ZeusTransformUtils.preCheckCast(null, d.h.a.a.class, "com.obric.aiagent.plugin");
    L26:
        e r3 = createEndAreaSnapshot(currentActionViews(getEndSubButtonGroup()), currentActionViews(getEndButtonGroup()));
        e r4 = createEndAreaSnapshot(r11.c(), r11.d());
        b r6 = resolveCenterAvoidanceMode(r3, r4);
        if (r10 == null) goto L30;
        r19 = createHostSyncActionsState(r10, r11);
    L30:
        if (r19 == null) goto L32;
        this.currentActionsState.a(r19.a(), r19.b(), r19.c(), r19.d());
    L32:
        this.currentHostSyncActionsState = r19;
        getStartButtonGroup().updateItemViews(r11.a(), r5);
        getCenterButtonGroup().updateItemViews(r11.b(), r5);
        d.h.b.z.a r111 = new d.h.b.z.a();
        if (r110 != null) goto L35;
        boolean r112 = true;
    L36:
        r111.f38499a = r112;
        d.h.b.z.a r113 = new d.h.b.z.a();
        if (r110 == null) goto L40;
        r17 = false;
    L40:
        r113.f38499a = r17;
        d.h.b.z.a r114 = new d.h.b.z.a();
        updateEndAreaActions(r3, r4, r5, r6, (d.h.a.a) ZeusTransformUtils.preCheckCast(new ag(r113, r114, r111, r110), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r110 == null) goto L43;
        waitForButtonGroupAnimationsEnd((d.h.a.a) ZeusTransformUtils.preCheckCast(new ah(r111, r114, r113, r110), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L43:
        applyActionGroupsEnabledState(r11);
        applyActionContentVisibility();
        notifyFloatingTransitionStateChanged$OUI_standardRelease();
        return r11;
    L35:
        r112 = false;
    L25:
        r110 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new ai(r16, r18, this), d.h.a.a.class, "com.obric.aiagent.plugin");
        goto L26
    L15:
        if (this.titleBarTransitionEndListener == null) goto L19;
        if (this.batchSetDepth != 0) goto L19;
        r18 = true;
        goto L20
    L10:
        if (this.batchSetDepth != 0) goto L12;
        r5 = true;
        goto L13
    L5:
        if (this.batchSetDepth != 0) goto L7;
        interruptFloatingTransitionForActionChange();
        goto L7
    }

    private static final void updateAction$finishIfReady(d.h.b.z.a r2, d.h.b.z.a r3, d.h.b.z.a r4, d.h.a.a<d.x> r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2.f38499a == false) goto L5;
        return;
    L5:
        if (r3.f38499a == true) goto L7;
        return;
    L7:
        if (r4.f38499a == false) goto L15;
        r2.f38499a = true;
        if (r6 == null) goto L16;
        r6.invoke();
        return;
    L16:
        return;
    }

    private final void waitForButtonGroupAnimationsEnd(d.h.a.a<d.x> r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if (((OButtonGroup) ZeusTransformUtils.preCheckCast(r2, OButtonGroup.class, "com.obric.aiagent.plugin")).isAnimating() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == false) goto L12;
        r7.invoke();
        return;
    L12:
        d.h.b.z.d r1 = new d.h.b.z.d();
        r1.f38502a = r9.size();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r10.next(), OButtonGroup.class, "com.obric.aiagent.plugin")).addAnimationEndListener$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new aj(r1, r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        goto L14
    }

    static /* synthetic */ a createActionTargetViews$default(OFloatingTitleBar r0, com.obric.oui.titlebar.a.c r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.createActionTargetViews(r1, r2);
    }

    private final a createActionTargetViews(com.obric.oui.titlebar.a.c r7, boolean r8) {
        return new a(createActionViews(r7.a(), this.startTintColor, currentActionViews(getStartButtonGroup()), r8), createActionViews(r7.b(), this.centerTintColor, currentActionViews(getCenterButtonGroup()), r8), createActionViews(r7.c(), this.endSubTintColor, currentActionViews(getEndSubButtonGroup()), r8), createActionViews(r7.d(), this.endTintColor, currentActionViews(getEndButtonGroup()), r8));
    }

    static /* synthetic */ a updateActionsState$default(OFloatingTitleBar r6, List r7, List r8, List r9, List r10, boolean r11, int r12, Object r13) {
        List<com.obric.oui.titlebar.a.C0999a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<com.obric.oui.titlebar.a.C0999a> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<com.obric.oui.titlebar.a.C0999a> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<com.obric.oui.titlebar.a.C0999a> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.currentActionsState.a();
    L5:
        List<com.obric.oui.titlebar.a.C0999a> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r15 = r6.currentActionsState.b();
    L8:
        List<com.obric.oui.titlebar.a.C0999a> r2 = r15;
        if ((r12 & 4) == 0) goto L11;
        r16 = r6.currentActionsState.c();
    L11:
        List<com.obric.oui.titlebar.a.C0999a> r3 = r16;
        if ((r12 & 8) == 0) goto L15;
        r17 = r6.currentActionsState.d();
    L15:
        return r6.updateActionsState(r1, r2, r3, r17, r11);
    }

    private final a updateActionsState(List<com.obric.oui.titlebar.a.C0999a> r10, List<com.obric.oui.titlebar.a.C0999a> r11, List<com.obric.oui.titlebar.a.C0999a> r12, List<com.obric.oui.titlebar.a.C0999a> r13, boolean r14) {
        com.obric.oui.titlebar.a.c r1 = new com.obric.oui.titlebar.a.c((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"));
        return updateAction$default(this, r1, createActionTargetViews(r1, false), r14, false, null, false, 56, null);
    }

    static /* synthetic */ a updateActionViews$default(OFloatingTitleBar r6, List r7, List r8, List r9, List r10, boolean r11, int r12, Object r13) {
        List<View> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<View> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<View> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<View> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.currentActionViews(r6.getStartButtonGroup());
    L5:
        List<View> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r15 = r6.currentActionViews(r6.getCenterButtonGroup());
    L8:
        List<View> r2 = r15;
        if ((r12 & 4) == 0) goto L11;
        r16 = r6.currentActionViews(r6.getEndSubButtonGroup());
    L11:
        List<View> r3 = r16;
        if ((r12 & 8) == 0) goto L15;
        r17 = r6.currentActionViews(r6.getEndButtonGroup());
    L15:
        return r6.updateActionViews(r1, r2, r3, r17, r11);
    }

    private final a updateActionViews(List<? extends View> r10, List<? extends View> r11, List<? extends View> r12, List<? extends View> r13, boolean r14) {
        return updateAction$default(this, null, new a((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin")), r14, false, null, false, 56, null);
    }

    public static /* synthetic */ void batchSet$default(OFloatingTitleBar r1, boolean r2, d.h.a.b r3, int r4, Object r5) {
        d.h.a.b<? super OFloatingTitleBar, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = true;
    L5:
        r1.batchSet(r2, r6);
    }

    public final void batchSet(boolean r13, d.h.a.b<? super OFloatingTitleBar, d.x> r14) {
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "block");
        if (this.batchSetDepth <= 0) goto L6;
        r15.invoke(this);
        return;
    L6:
        interruptFloatingTransitionForActionChange();
        com.obric.oui.titlebar.a r0 = captureAnimationState$OUI_standardRelease();
        a r2 = captureActionTargetViews();
        this.batchSetDepth++;
        r15.invoke(this);     // Catch: Throwable -> L10
        this.batchSetDepth--;
        com.obric.oui.titlebar.a.c r4 = new com.obric.oui.titlebar.a.c(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.currentActionsState.a(), Iterable.class, "com.obric.aiagent.plugin")), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.currentActionsState.b(), Iterable.class, "com.obric.aiagent.plugin")), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.currentActionsState.c(), Iterable.class, "com.obric.aiagent.plugin")), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.currentActionsState.d(), Iterable.class, "com.obric.aiagent.plugin")));
        a r5 = captureActionTargetViews();
        restoreActionsInBatch(r0.c(), r2, r0.e());
        updateAction$default(this, r4, r5, r13, false, null, false, 56, null);
        return;
    L10:
        th = move-exception;
        this.batchSetDepth--;
        restoreStateInBatch(r0);
        throw th;
    }

    private final void restoreStateInBatch(com.obric.oui.titlebar.a r2) {
        this.batchSetDepth++;
        restoreState$OUI_standardRelease(r2);     // Catch: Throwable -> L6
        this.batchSetDepth--;
        return;
    L6:
        th = move-exception;
        this.batchSetDepth--;
        throw th;
    }

    private final void restoreActionsInBatch(com.obric.oui.titlebar.a.c r11, a r12, com.obric.oui.titlebar.a.d r13) {
        this.batchSetDepth++;
        updateAction$default(this, r11, r12, false, false, null, false, 16, null);     // Catch: Throwable -> L9
        if (r13 == null) goto L7;
        restoreAnimationState$OUI_standardRelease(r13);     // Catch: Throwable -> L9
    L7:
        this.batchSetDepth--;
        return;
    L9:
        th = move-exception;
        this.batchSetDepth--;
        throw th;
    }

    public static /* synthetic */ void applyState$default(OFloatingTitleBar r1, com.obric.oui.titlebar.a r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = true;
    L8:
        r1.applyState(r2, r3, r4);
    }

    public final void applyState(com.obric.oui.titlebar.a r13, boolean r14, boolean r15) {
        d.h.b.o.e(r13, "state");
        applyStyleState(r13.d());
        if (this.isNonActionContentVisible == true) goto L6;
        applyTitleWidthPlaceholders(r13.b());
    L6:
        if (r13.b().c() <= 0) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        removeCenterCustomView();
    L15:
        com.obric.oui.titlebar.a.c r4 = r13.c();
        a r5 = createActionTargetViews$default(this, r13.c(), false, 2, null);
        if (r14 == true) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if (r13.e() != null) goto L24;
        boolean r9 = true;
    L25:
        updateAction$default(this, r4, r5, r6, r15, null, r9, 16, null);
        com.obric.oui.titlebar.a.d r16 = r13.e();
        if (r16 == null) goto L30;
        restoreAnimationState$OUI_standardRelease(r16);
        return;
    L30:
        return;
    L24:
        r9 = false;
        goto L25
    L18:
        if (r13.e() != null) goto L20;
        r6 = true;
        goto L22
    L14:
        setCenterCustomView(createCenterCustomPlaceholder(r13.b().c(), r13.b().d()));
        goto L15
    L8:
        if (r13.b().d() > 0) goto L11;
        r0 = false;
        goto L12
    }

    public static /* synthetic */ void applyStateForFloatingTransition$OUI_standardRelease$default(OFloatingTitleBar r1, com.obric.oui.titlebar.a r2, boolean r3, d.h.a.a r4, int r5, Object r6) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.applyStateForFloatingTransition$OUI_standardRelease(r2, r3, r7);
    }

    public final void applyStateForFloatingTransition$OUI_standardRelease(com.obric.oui.titlebar.a r11, boolean r12, d.h.a.a<d.x> r13) {
        d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "state");
        d.h.b.o.e(r14, "onTransitionEnd");
        applyStyleState(r11.d());
        if (this.isNonActionContentVisible == true) goto L6;
        applyTitleWidthPlaceholders(r11.b());
    L6:
        if (r11.b().c() <= 0) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        removeCenterCustomView();
    L15:
        com.obric.oui.titlebar.a.c r4 = r11.c();
        a r1 = createActionTargetViews$default(this, r11.c(), false, 2, null);
        if (r12 == true) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if (r11.e() != null) goto L24;
        d.h.a.a<d.x> r8 = r14;
    L25:
        updateAction(r4, r1, r6, false, r8, false);
        com.obric.oui.titlebar.a.d r15 = r11.e();
        if (r15 == null) goto L30;
        restoreAnimationState$OUI_standardRelease(r15);
        r14.invoke();
        return;
    L30:
        return;
    L24:
        r8 = null;
        goto L25
    L18:
        if (r11.e() != null) goto L20;
        r6 = true;
        goto L22
    L14:
        setCenterCustomView(createCenterCustomPlaceholder(r11.b().c(), r11.b().d()));
        goto L15
    L8:
        if (r11.b().d() > 0) goto L11;
        r0 = false;
        goto L12
    }

    public final com.obric.oui.titlebar.a captureState() {
        FrameLayout r0 = this.centerCustomContainer;
        Integer r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerCustomContainer");
        r0 = null;
    L5:
        int r2 = 0;
        View r3 = r0.getChildAt(0);
        com.obric.oui.titlebar.a.e r4 = captureBoundsState();
        LinearLayout r5 = this.startTitleContainer;
        if (r5 != null) goto L8;
        d.h.b.o.c("startTitleContainer");
        r5 = null;
    L8:
        int r8 = captureMeasuredWidth((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        LinearLayout r6 = this.centerTitleContainer;
        if (r6 != null) goto L11;
        d.h.b.o.c("centerTitleContainer");
        r6 = null;
    L11:
        int r9 = captureMeasuredWidth((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        boolean r7 = true;
        if (r3 != null) goto L14;
    L13:
        Integer r10 = null;
    L19:
        if (r10 != null) goto L23;
        if (r3 != null) goto L22;
        int r11 = 0;
    L24:
        if (r3 == null) goto L32;
        Integer r12 = Integer.valueOf(r3.getMeasuredHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L30;
        r7 = false;
    L30:
        if (r7 == false) goto L32;
        r1 = r12;
    L32:
        if (r1 != null) goto L36;
        if (r3 == null) goto L38;
        r2 = Integer.valueOf(r3.getHeight()).intValue();
    L38:
        return new com.obric.oui.titlebar.a(r4, new com.obric.oui.titlebar.a.g(r8, r9, r11, r2, captureContentTopInset()), captureActionsState(), captureStyleState(), null, null, 48, null);
    L36:
        r2 = r1.intValue();
        goto L38
    L22:
        r10 = Integer.valueOf(r3.getWidth());
    L23:
        r11 = r10.intValue();
        goto L24
    L14:
        r10 = Integer.valueOf(r3.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L13;
    L17:
        r13 = false;
        goto L18
    }

    public final com.obric.oui.titlebar.a captureHostSyncState$OUI_standardRelease() {
        com.obric.oui.titlebar.a r0 = captureState();
        com.obric.oui.titlebar.a.c r1 = this.currentHostSyncActionsState;
        if (r1 != null) goto L5;
        com.obric.oui.titlebar.a.c r3 = captureActionsState();
    L7:
        return com.obric.oui.titlebar.a.a(r0, null, null, r3, null, null, null, 59, null);
    L5:
        r3 = r1;
        goto L7
    }

    private final void applyTitleWidthPlaceholders(com.obric.oui.titlebar.a.g r6) {
        OTextView r0 = this.startTitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("startTitleView");
        r0 = null;
    L5:
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.aiagent.plugin");
        OTextView r3 = this.startSubtitleView;
        if (r3 != null) goto L8;
        d.h.b.o.c("startSubtitleView");
        r3 = null;
    L8:
        applyTitleWidthPlaceholder(r2, (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"), r6.a());
        OTextView r4 = this.centerTitleView;
        if (r4 != null) goto L11;
        d.h.b.o.c("centerTitleView");
        r4 = null;
    L11:
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.aiagent.plugin");
        OTextView r7 = this.centerSubtitleView;
        if (r7 != null) goto L14;
        d.h.b.o.c("centerSubtitleView");
    L15:
        applyTitleWidthPlaceholder(r5, (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin"), r6.b());
        return;
    L14:
        r1 = r7;
        goto L15
    }

    private final void applyTitleWidthPlaceholder(TextView r4, TextView r5, int r6) {
        r4.setMinWidth(d.l.n.c(r6, 0));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        if (r6 <= 0) goto L5;
        int r7 = 0;
    L6:
        r4.setVisibility(r7);
        r5.setMinWidth(0);
        r5.setText(null);
        r5.setVisibility(8);
        return;
    L5:
        r7 = 8;
        goto L6
    }

    private final int captureContentTopInset() {
        View r2 = this.titleBarContainer;
        ViewGroup.MarginLayoutParams r0 = null;
        if (r2 != null) goto L5;
        d.h.b.o.c("titleBarContainer");
        r2 = null;
    L5:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 != null) goto L11;
        return 0;
    L11:
        return r0.topMargin;
    }

    private final View createCenterCustomPlaceholder(int r7, int r8) {
        View r0 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setAlpha(0.0f);
        r0.setImportantForAccessibility(2);
        Integer r6 = Integer.valueOf(r7);
        boolean r2 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r9 = true;
    L6:
        Integer r4 = null;
        if (r9 == true) goto L10;
        r6 = null;
    L10:
        int r10 = -2;
        if (r6 != null) goto L13;
        int r11 = -2;
    L14:
        Integer r12 = Integer.valueOf(r8);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L20;
        r4 = r12;
    L20:
        if (r4 == null) goto L23;
        r10 = r4.intValue();
    L23:
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r11, r10), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return r0;
    L13:
        r11 = r6.intValue();
        goto L14
    L5:
        r9 = false;
        goto L6
    }

    public final com.obric.oui.titlebar.a captureAnimationState$OUI_standardRelease() {
        return com.obric.oui.titlebar.a.a(captureState(), null, null, null, null, saveAnimationState$OUI_standardRelease(), null, 47, null);
    }

    public final void restoreState$OUI_standardRelease(com.obric.oui.titlebar.a r2) {
        d.h.b.o.e(r2, "state");
        applyState(r2, false, false);
    }

    private final com.obric.oui.titlebar.a.e captureBoundsState() {
        int[] r0 = new int[2];
        if (isAttachedToWindow() == false) goto L6;
        getLocationOnScreen(r0);
    L6:
        return new com.obric.oui.titlebar.a.e(getWidth(), getHeight(), r0[0], r0[1]);
    }

    private final com.obric.oui.titlebar.a.h captureStyleState() {
        return new com.obric.oui.titlebar.a.h(this.startButtonGroupStyle, this.centerButtonGroupStyle, this.endSubButtonGroupStyle, this.endButtonGroupStyle);
    }

    private final void applyStyleState(com.obric.oui.titlebar.a.h r2) {
        if (r2.a() == 0) goto L6;
        setStartButtonGroupStyle(r2.a());
    L6:
        if (r2.b() == 0) goto L9;
        setCenterButtonGroupStyle(r2.b());
    L9:
        if (r2.c() == 0) goto L12;
        setSubEndButtonGroupStyle(r2.c());
    L12:
        if (r2.d() == 0) goto L15;
        setEndButtonGroupStyle(r2.d());
        return;
    }

    private final com.obric.oui.titlebar.a.c captureActionsState() {
        return new com.obric.oui.titlebar.a.c(captureVisibleActions(getStartButtonGroup(), this.currentActionsState.a(), this.startTintColor), captureVisibleActions(getCenterButtonGroup(), this.currentActionsState.b(), this.centerTintColor), captureVisibleActions(getEndSubButtonGroup(), this.currentActionsState.c(), this.endSubTintColor), captureVisibleActions(getEndButtonGroup(), this.currentActionsState.d(), this.endTintColor));
    }

    private final com.obric.oui.titlebar.a.c createHostSyncActionsState(com.obric.oui.titlebar.a.c r7, a r8) {
        return new com.obric.oui.titlebar.a.c(captureHostSyncActions(r7.a(), r8.a(), this.startTintColor), captureHostSyncActions(r7.b(), r8.b(), this.centerTintColor), captureHostSyncActions(r7.c(), r8.c(), this.endSubTintColor), captureHostSyncActions(r7.d(), r8.d(), this.endTintColor));
    }

    private final void applyActionGroupsEnabledState(a r3) {
        applyActionGroupEnabledState(getStartButtonGroup(), r3.a());
        applyActionGroupEnabledState(getCenterButtonGroup(), r3.b());
        applyActionGroupEnabledState(getEndSubButtonGroup(), r3.c());
        applyActionGroupEnabledState(getEndButtonGroup(), r3.d());
    }

    private final void applyActionGroupEnabledState(OButtonGroup r6, List<? extends View> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        if (r5.isEmpty() == true) goto L5;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r2.add(Boolean.valueOf(((View) ZeusTransformUtils.preCheckCast(r9.next(), View.class, "com.obric.aiagent.plugin")).isEnabled()));
        goto L10
    L12:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L15;
    L17:
        Iterator r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L16;
        if (((View) ZeusTransformUtils.preCheckCast(r12.next(), View.class, "com.obric.aiagent.plugin")).isEnabled() == false) goto L19;
    L22:
        r6.setEnabled(r1);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r13.hasNext() == false) goto L33;
        Object r14 = r13.next();
        int r4 = r3 + 1;
        if (r3 >= 0) goto L28;
        d.a.p.c();
    L28:
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        View r16 = r6.getItemViewAt(r3);
        if (r16 == null) goto L32;
        r16.setEnabled(r15);
    L32:
        r3 = r4;
        goto L24
    L33:
        return;
    L16:
        r1 = false;
        goto L22
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
    L5:
        if (r6.getItemCount() != 0) goto L41;
        r6.setEnabled(true);
        return;
    }

    private final List<com.obric.oui.titlebar.a.C0999a> captureHostSyncActions(List<com.obric.oui.titlebar.a.C0999a> r9, List<? extends View> r10, int r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r13 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L35;
        com.obric.oui.titlebar.a.C0999a r2 = (com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.b r3 = toActionKey(r2, r11);
        int r4 = 0;
        Iterator r5 = r13.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (d.h.b.o.a(((View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.aiagent.plugin")).getTag(), r3) == true) goto L13;
        r4 = r4 + 1;
    L13:
        com.obric.oui.titlebar.a.C0999a r6 = null;
        if (r4 < 0) goto L16;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r13.remove(r4), View.class, "com.obric.aiagent.plugin");
    L17:
        if (r7 != null) goto L19;
    L21:
        if (r7 == null) goto L23;
        boolean r8 = r7.isEnabled();
    L24:
        com.obric.oui.titlebar.a.C0999a r16 = toStateAction(r2, r11);
        if (r7 == null) goto L31;
        com.obric.oui.titlebar.a.C0999a r17 = withFallbackClickListener(r16, r7);
        if (r17 == null) goto L31;
        r16 = r17;
    L31:
        r6 = r16.a(r8);
    L32:
        if (r6 == null) goto L4;
        r0.add(r6);
        goto L4
    L23:
        r8 = r2.f();
        goto L24
    L19:
        if (r7.getVisibility() == 0) goto L21;
    L16:
        r7 = (View) ZeusTransformUtils.preCheckCast(null, View.class, "com.obric.aiagent.plugin");
        goto L17
    L12:
        r4 = -1;
        goto L13
    L35:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    private final List<com.obric.oui.titlebar.a.C0999a> captureVisibleActions(OButtonGroup r12, List<com.obric.oui.titlebar.a.C0999a> r13, int r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r12.getVisibility() != 0) goto L5;
        List<com.obric.oui.titlebar.a.C0999a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r16 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin"));
        int r2 = r12.getItemCount();
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L33;
        int r5 = r4 + 1;
        View r6 = r12.getItemViewAt(r4);
        if (r6 == null) goto L32;
        if (r6.getVisibility() != 0) goto L32;
        Object r7 = r6.getTag();
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.titlebar.a.b.class) == false) goto L17;
        com.obric.oui.titlebar.a.b r8 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.titlebar.a.b.class, "com.obric.aiagent.plugin");
    L18:
        if (r8 == null) goto L32;
        Iterator r9 = r16.iterator();
        int r10 = 0;
    L22:
        if (r9.hasNext() == false) goto L27;
        if (d.h.b.o.a(toActionKey((com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin"), r14), r8) == true) goto L28;
        r10 = r10 + 1;
    L28:
        boolean r11 = r6.isEnabled();
        if (r10 < 0) goto L31;
        r0.add(withFallbackClickListener(toStateAction((com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r16.remove(r10), com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin"), r14), r6).a(r11));
        goto L32
    L31:
        r0.add(withFallbackClickListener(toActionItem(r8), r6).a(r11));
        goto L32
    L27:
        r10 = -1;
        goto L28
    L17:
        r8 = null;
    L32:
        r4 = r5;
        goto L7
    L33:
        return r0;
    L5:
        return d.a.p.b();
    }

    private final com.obric.oui.titlebar.a.C0999a withFallbackClickListener(com.obric.oui.titlebar.a.C0999a r13, final View r14) {
        if (r13.e() == null) goto L7;
        return com.obric.oui.titlebar.a.C0999a.a(r13, 0, 0, null, null, 0, wrapActionClickListener(r13.e()), false, null, 223, null);
    L7:
        if (r14.hasOnClickListeners() == true) goto L10;
        return r13;
    L10:
        return com.obric.oui.titlebar.a.C0999a.a(r13, 0, 0, null, null, 0, new $$Lambda$OFloatingTitleBar$ExUP2_wM4TuMdgza7Ka5tE4SF8(this, r14), false, null, 223, null);
    }

    /* JADX INFO: renamed from: withFallbackClickListener$lambda-26, reason: not valid java name */
    private static final void m1217withFallbackClickListener$lambda26(OFloatingTitleBar r0, View r1, View r2) {
        d.h.b.o.e(r0, "this$0");
        d.h.b.o.e(r1, "$sourceView");
        r0.finishFloatingTransitionForUserInteraction();
        r1.performClick();
    }

    private final com.obric.oui.titlebar.a.C0999a toActionItem(com.obric.oui.titlebar.a.b r5) {
        int r4 = r5.getType();
        if (r4 == 1) goto L16;
        String r3 = "";
        if (r4 == 3) goto L11;
        com.obric.oui.titlebar.a.C0999a.C1000a r6 = com.obric.oui.titlebar.a.C0999a.f36629a;
        String r0 = r5.b();
        if (r0 == null) goto L10;
        r3 = r0;
    L10:
        com.obric.oui.titlebar.a.C0999a r7 = com.obric.oui.titlebar.a.C0999a.C1000a.a(r6, r3, null, 2, null);
    L18:
        return r7.a(r5.d()).a(r5.c()).b(r5.e());
    L11:
        com.obric.oui.titlebar.a.C0999a.C1000a r8 = com.obric.oui.titlebar.a.C0999a.f36629a;
        String r1 = r5.b();
        if (r1 == null) goto L15;
        r3 = r1;
    L15:
        r7 = com.obric.oui.titlebar.a.C0999a.C1000a.b(r8, r3, null, 2, null);
        goto L18
    L16:
        r7 = com.obric.oui.titlebar.a.C0999a.C1000a.a(com.obric.oui.titlebar.a.C0999a.f36629a, r5.a(), null, 2, null);
        goto L18
    }

    private final List<com.obric.oui.titlebar.a.C0999a> addActionItem(List<com.obric.oui.titlebar.a.C0999a> r3, int r4, com.obric.oui.titlebar.a.C0999a r5) {
        List<com.obric.oui.titlebar.a.C0999a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<com.obric.oui.titlebar.a.C0999a> r0 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));
        r0.add(getActionInsertIndex(r6, r4), r5);
        return r0;
    }

    private final List<View> addActionView(List<? extends View> r3, int r4, View r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<View> r0 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));
        r0.add(getActionViewInsertIndex(r6, r4), r5);
        return r0;
    }

    private final int getActionViewInsertIndex(List<? extends View> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 < 0) goto L7;
        if (r3 > r1.size()) goto L7;
        return r3;
    L7:
        return r1.size();
    }

    private final List<View> currentActionViews(OButtonGroup r4) {
        ArrayList r3 = new ArrayList(r4.getItemCount());
        int r0 = r4.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        int r2 = r1 + 1;
        View r5 = r4.getItemViewAt(r1);
        if (r5 == null) goto L8;
        r3.add(r5);
    L8:
        r1 = r2;
        goto L3
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    }

    private final a captureActionTargetViews() {
        return new a(currentActionViews(getStartButtonGroup()), currentActionViews(getCenterButtonGroup()), currentActionViews(getEndSubButtonGroup()), currentActionViews(getEndButtonGroup()));
    }

    private final int getActionInsertIndex(List<com.obric.oui.titlebar.a.C0999a> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 < 0) goto L7;
        if (r3 > r1.size()) goto L7;
        return r3;
    L7:
        return r1.size();
    }

    private final List<com.obric.oui.titlebar.a.C0999a> removeActionItemAt(List<com.obric.oui.titlebar.a.C0999a> r2, int r3) {
        List<com.obric.oui.titlebar.a.C0999a> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 >= 0) goto L5;
        return r1;
    L5:
        if (r3 >= r1.size()) goto L10;
        List<com.obric.oui.titlebar.a.C0999a> r4 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));
        r4.remove(r3);
        return r4;
    L10:
        return r1;
    }

    private final List<com.obric.oui.titlebar.a.C0999a> removeLastActionItem(List<com.obric.oui.titlebar.a.C0999a> r2) {
        List<com.obric.oui.titlebar.a.C0999a> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r1.isEmpty() == false) goto L5;
        return r1;
    L5:
        List<com.obric.oui.titlebar.a.C0999a> r3 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));
        r3.remove(d.a.p.b(r3));
        return r3;
    }

    private final com.obric.oui.titlebar.a.C0999a toStateAction(com.obric.oui.titlebar.a.C0999a r1, int r2) {
        return r1.a(r2).b(resolveIconResourceName(r1.a()));
    }

    private final com.obric.oui.titlebar.a.b toActionKey(com.obric.oui.titlebar.a.C0999a r9, int r10) {
        int r1 = r9.getType();
        int r2 = r9.a();
        String r3 = r9.b();
        String r5 = r9.c();
        String r0 = r9.g();
        if (r0 != null) goto L5;
        String r6 = resolveIconResourceName(r9.a());
    L7:
        return new com.obric.oui.titlebar.a.b(r1, r2, r3, r10, r5, r6);
    L5:
        r6 = r0;
        goto L7
    }

    private final String resolveIconResourceName(int r4) {
        if (r4 != 0) goto L9;
        return null;
    L9:
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getResourceTypeName(r4) + '/' + ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getResourceEntryName(r4);
    L8:
        return (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void setActionContentVisible$OUI_standardRelease$default(OFloatingTitleBar r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1;
    L5:
        r0.setActionContentVisible$OUI_standardRelease(r1, r2);
    }

    public final void setActionContentVisible$OUI_standardRelease(boolean r3, boolean r4) {
        boolean r0 = true;
        if (r3 == false) goto L5;
    L9:
        if (r4 == true) goto L12;
        if (r3 == true) goto L12;
    L14:
        if (this.isActionContentVisible == r3) goto L16;
    L20:
        this.isActionContentVisible = r3;
        this.isActionTouchEventBlocked = r0;
        applyActionContentVisibility();
        return;
    L16:
        if (this.isActionTouchEventBlocked != r0) goto L20;
        if (isActionContentVisibilityApplied(r3, r0) == false) goto L20;
        return;
    L12:
        r0 = false;
        goto L14
    L5:
        if (isFloatingSurfaceTransitionRunning$OUI_standardRelease() == false) goto L7;
    L8:
        r4 = true;
        goto L9
    L7:
        if (this.keepActionInteractiveWhenHidden == false) goto L9;
        goto L8
    }

    private final boolean isActionContentVisibilityApplied(boolean r7, boolean r8) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r6.iterator();
    L9:
        if (r9.hasNext() == false) goto L30;
        OButtonGroup r0 = (OButtonGroup) ZeusTransformUtils.preCheckCast(r9.next(), OButtonGroup.class, "com.obric.aiagent.plugin");
        if (r7 == true) goto L17;
        if (r0.getAlpha() == 0.0f) goto L23;
    L15:
        boolean r4 = false;
    L25:
        if (r0.isTouchEventBlocked$OUI_standardRelease() != r8) goto L28;
        if (r4 == false) goto L28;
        boolean r1 = true;
    L29:
        if (r1 == true) goto L9;
        return false;
    L28:
        r1 = false;
    L23:
        r4 = true;
        goto L25
    L17:
        if (r0.isAnimating() == true) goto L23;
        if (r0.getAlpha() != 1.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L15;
    L21:
        r5 = false;
    L30:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final void setKeepActionInteractiveWhenHidden$OUI_standardRelease(boolean r1) {
        this.keepActionInteractiveWhenHidden = r1;
    }

    public final void setActionChangeInterruptCallback$OUI_standardRelease(d.h.a.a<d.x> r3) {
        this.actionChangeInterruptCallback = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(d.h.a.a<d.x> r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.floatingTransitionDrawUpdateListener = r6;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r4.next(), OButtonGroup.class, "com.obric.aiagent.plugin")).setAnimationUpdateListener$OUI_standardRelease(r6);
        goto L4
    }

    public final void notifyFloatingTransitionDrawUpdate$OUI_standardRelease() {
        d.h.a.a<d.x> r0 = this.floatingTransitionDrawUpdateListener;
        if (r0 == null) goto L7;
        r0.invoke();
        return;
    }

    public final boolean isFloatingSurfaceTransitionRunning$OUI_standardRelease() {
        FloatingTransitionBridge r2 = this.floatingTransitionBridge;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.c() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final boolean isActionContentVisible() {
        return this.isActionContentVisible;
    }

    private final void applyActionContentVisibility() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        OButtonGroup r1 = (OButtonGroup) ZeusTransformUtils.preCheckCast(r0.next(), OButtonGroup.class, "com.obric.aiagent.plugin");
        r1.setTouchEventBlocked$OUI_standardRelease(this.isActionTouchEventBlocked);
        if (this.isActionContentVisible == false) goto L7;
        if (r1.isAnimating() == true) goto L4;
        r1.setAlpha(1.0f);
        goto L4
    L7:
        r1.setAlpha(0.0f);
        goto L4
    }

    public final void setNonActionContentVisible$OUI_standardRelease(boolean r2) {
        if (this.isNonActionContentVisible != r2) goto L5;
        return;
    L5:
        this.isNonActionContentVisible = r2;
        applyNonActionContentVisibility();
    }

    private final void applyNonActionContentVisibility() {
        if (this.isNonActionContentVisible == false) goto L5;
        float r0 = 1.0f;
    L6:
        ViewGroup[] r1 = new ViewGroup[3];
        LinearLayout r3 = this.startTitleContainer;
        FrameLayout r4 = null;
        if (r3 != null) goto L9;
        d.h.b.o.c("startTitleContainer");
        r3 = null;
    L9:
        r1[0] = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
        LinearLayout r5 = this.centerTitleContainer;
        if (r5 != null) goto L12;
        d.h.b.o.c("centerTitleContainer");
        r5 = null;
    L12:
        r1[1] = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        FrameLayout r6 = this.centerCustomContainer;
        if (r6 != null) goto L15;
        d.h.b.o.c("centerCustomContainer");
    L16:
        r1[2] = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(r1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.next(), ViewGroup.class, "com.obric.aiagent.plugin");
        r7.setAlpha(r0);
        r7.setEnabled(this.isNonActionContentVisible);
        r7.setClickable(this.isNonActionContentVisible);
        goto L18
    L20:
        return;
    L15:
        r4 = r6;
        goto L16
    L5:
        r0 = 0.0f;
        goto L6
    }

    public final void setTitleBarContainerClickable$OUI_standardRelease(boolean r1) {
        View r0 = this.titleBarContainer;
        if (r0 != null) goto L5;
        d.h.b.o.c("titleBarContainer");
        r0 = null;
    L5:
        r0.setClickable(r1);
    }

    private final b resolveCenterAvoidanceMode(e r2, e r3) {
        boolean r0 = shouldAvoidCenterForEndArea(r2, r3);
        boolean r1 = shouldFreezeCenterForEndArea(r2, r3);
        if (r0 == true) goto L9;
        if (r1 == false) goto L8;
        return b.f36529b;
    L8:
        return b.f36528a;
    L9:
        return b.f36530c;
    }

    private final boolean shouldAvoidCenterForEndArea(e r8, e r9) {
        int r0 = getMeasuredWidth();
        if (r0 > 0) goto L5;
        return false;
    L5:
        FrameLayout r2 = this.centerContainer;
        View r4 = null;
        if (r2 != null) goto L8;
        d.h.b.o.c("centerContainer");
        r2 = null;
    L8:
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L20;
        FrameLayout r6 = this.centerContainer;
        if (r6 != null) goto L19;
        d.h.b.o.c("centerContainer");
        r6 = null;
    L19:
        int r7 = r6.getMeasuredWidth();
    L21:
        if (r7 > 0) goto L23;
        return false;
    L23:
        int r10 = Math.max(r8.d(), r9.d());
        if (r10 > 0) goto L26;
        return false;
    L26:
        int r11 = getCenterTitleGap();
        View r12 = this.titleBarContainer;
        if (r12 != null) goto L29;
        d.h.b.o.c("titleBarContainer");
        r12 = null;
    L29:
        int r13 = r12.getPaddingLeft();
        View r14 = this.titleBarContainer;
        if (r14 != null) goto L32;
        d.h.b.o.c("titleBarContainer");
    L33:
        int r1 = r0 - r4.getPaddingRight();
        if ((r13 + (((r1 - r13) + r7) / 2)) > ((r1 - r10) - r11)) goto L36;
        return false;
    L36:
        return true;
    L32:
        r4 = r14;
        goto L33
    L20:
        r7 = r3.intValue();
        goto L21
    L11:
        r5 = false;
        goto L12
    }

    private final boolean shouldFreezeCenterForEndArea(e r3, e r4) {
        if (r3.d() == r4.d()) goto L5;
    L14:
        return true;
    L5:
        if (r3.a() != r4.a()) goto L14;
        if (this.freezeEndAreaWidth != null) goto L14;
        if (getEndSubButtonGroup().isAnimating() == true) goto L14;
        if (getEndButtonGroup().isAnimating() == true) goto L14;
        return false;
    }

    static /* synthetic */ List createActionViews$default(OFloatingTitleBar r1, List r2, int r3, List r4, boolean r5, int r6, Object r7) {
        List<com.obric.oui.titlebar.a.C0999a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<? extends View> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = d.a.p.b();
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = true;
    L9:
        return r1.createActionViews(r8, r3, r9, r5);
    }

    private final List<View> createActionViews(List<com.obric.oui.titlebar.a.C0999a> r9, int r10, List<? extends View> r11, boolean r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r14 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L35;
        com.obric.oui.titlebar.a.C0999a r2 = (com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a.b r3 = toActionKey(r2, r10);
        int r4 = 0;
        Iterator r5 = r14.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (d.h.b.o.a(((View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.aiagent.plugin")).getTag(), r3) == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 < 0) goto L15;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r14.remove(r4), View.class, "com.obric.aiagent.plugin");
    L30:
        r6.setTag(r3);
        r6.setOnClickListener(wrapActionClickListener(r2.e()));
        updateViewTint(r6, r10);
        if (r12 == false) goto L33;
        r6.setEnabled(r2.f());
    L33:
        r0.add(r6);
        goto L4
    L15:
        int r7 = r2.getType();
        if (r7 == 1) goto L29;
        String r8 = "";
        if (r7 == 3) goto L24;
        String r17 = r2.b();
        if (r17 == null) goto L23;
        r8 = r17;
    L23:
        r6 = createTextActionView(r8, r10);
        goto L30
    L24:
        String r18 = r2.b();
        if (r18 == null) goto L28;
        r8 = r18;
    L28:
        r6 = createTitleArrowActionView(r8, r10);
        goto L30
    L29:
        r6 = createIconActionView(r2.a(), r10);
        goto L30
    L12:
        r4 = -1;
        goto L13
    L35:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }

    private final View.OnClickListener wrapActionClickListener(View.OnClickListener r3) {
        final View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new $$Lambda$OFloatingTitleBar$pUCLHnINpyuadWsBzrHte5Bp6s(this, r4);
    }

    /* JADX INFO: renamed from: wrapActionClickListener$lambda-37, reason: not valid java name */
    private static final void m1218wrapActionClickListener$lambda37(OFloatingTitleBar r2, View.OnClickListener r3, View r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "this$0");
        r2.finishFloatingTransitionForUserInteraction();
        r5.onClick(r4);
    }

    public final void pauseActionAnimations() {
        cancelEndAreaShiftAnimators();
        getEndSubButtonGroup().clearGroupAlphaAnimationEndListeners$OUI_standardRelease();
        getEndButtonGroup().clearGroupAlphaAnimationEndListeners$OUI_standardRelease();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r3.next(), OButtonGroup.class, "com.obric.aiagent.plugin")).cancelAnimation();
        goto L4
    }

    public final com.obric.oui.titlebar.a.d saveAnimationState$OUI_standardRelease() {
        OButtonGroup.b r1 = getStartButtonGroup().saveAnimationState();
        OButtonGroup.b r2 = getCenterButtonGroup().saveAnimationState();
        OButtonGroup.b r3 = getEndSubButtonGroup().saveAnimationState();
        OButtonGroup.b r4 = getEndButtonGroup().saveAnimationState();
        float r5 = getEndSubButtonGroup().getTranslationX();
        Integer r6 = this.freezeEndAreaWidth;
        FrameLayout r9 = this.centerContainer;
        if (r9 != null) goto L6;
        d.h.b.o.c("centerContainer");
        r9 = null;
    L6:
        return new com.obric.oui.titlebar.a.d(r1, r2, r3, r4, r5, r6, r9.getTranslationX());
    }

    public final void restoreAnimationState$OUI_standardRelease(com.obric.oui.titlebar.a.d r6) {
        d.h.b.o.e(r6, "state");
        pauseActionAnimations();
        getStartButtonGroup().restoreAnimationState(r6.a(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new q(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        getCenterButtonGroup().restoreAnimationState(r6.b(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        getEndSubButtonGroup().restoreAnimationState(r6.c(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        getEndButtonGroup().restoreAnimationState(r6.d(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new t(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        getEndSubButtonGroup().setTranslationX(r6.e());
        setFreezeEndAreaWidth(r6.f());
        FrameLayout r5 = this.centerContainer;
        if (r5 != null) goto L5;
        d.h.b.o.c("centerContainer");
        r5 = null;
    L5:
        r5.setTranslationX(r6.g());
    }

    private final View createViewForSavedAction(OButtonGroup.f r17, int r18, List<com.obric.oui.titlebar.a.C0999a> r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Object r3 = r17.a();
        View.OnClickListener r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.titlebar.a.b.class) == false) goto L5;
        com.obric.oui.titlebar.a.b r4 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.titlebar.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        Integer r6 = Integer.valueOf(r4.c());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        int r8 = r18;
    L18:
        com.obric.oui.titlebar.a.b r9 = com.obric.oui.titlebar.a.b.a(r4, 0, 0, null, r8, null, null, 55, null);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        Object r10 = r2.next();
        if (d.h.b.o.a(toActionKey((com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin"), r8), r9) == false) goto L20;
    L25:
        com.obric.oui.titlebar.a.C0999a r11 = (com.obric.oui.titlebar.a.C0999a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.titlebar.a.C0999a.class, "com.obric.aiagent.plugin");
        int r12 = r4.getType();
        if (r12 == 1) goto L39;
        String r13 = "";
        if (r12 == 3) goto L34;
        String r14 = r4.b();
        if (r14 == null) goto L33;
        r13 = r14;
    L33:
        View r15 = createTextActionView(r13, r8);
    L40:
        r15.setTag(r9);
        if (r11 == null) goto L44;
        r5 = r11.e();
    L44:
        r15.setOnClickListener(wrapActionClickListener(r5));
        if (r11 == null) goto L48;
        r15.setEnabled(r11.f());
    L48:
        return r15;
    L34:
        String r16 = r4.b();
        if (r16 == null) goto L38;
        r13 = r16;
    L38:
        r15 = createTitleArrowActionView(r13, r8);
        goto L40
    L39:
        r15 = createIconActionView(r4.a(), r8);
        goto L40
    L24:
        r10 = null;
        goto L25
    L17:
        r8 = r6.intValue();
        goto L18
    L11:
        r7 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    static /* synthetic */ void updateEndAreaActions$default(OFloatingTitleBar r6, e r7, e r8, boolean r9, b r10, d.h.a.a r11, int r12, Object r13) {
        d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L5;
        r14 = null;
    L5:
        r6.updateEndAreaActions(r7, r8, r9, r10, r14);
    }

    private final void updateEndAreaActions(e r4, e r5, boolean r6, b r7, d.h.a.a<d.x> r8) {
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        cancelEndAreaShiftAnimators();
        this.endAreaTransitionGeneration++;
        getEndSubButtonGroup().clearGroupAlphaAnimationEndListeners$OUI_standardRelease();
        getEndButtonGroup().clearGroupAlphaAnimationEndListeners$OUI_standardRelease();
        if (r7 != b.f36528a) goto L8;
        FrameLayout r0 = this.centerContainer;
        if (r0 != null) goto L7;
        d.h.b.o.c("centerContainer");
        r0 = null;
    L7:
        r0.setTranslationX(0.0f);
        setFreezeEndAreaWidth(null);
    L8:
        if (r6 == true) goto L14;
        updateEndAreaActionsImmediately(r5);
        if (r9 == null) goto L16;
        r9.invoke();
        return;
    L16:
        return;
    L14:
        transitionEndAreaActions(r4, r5, r7, r9);
    }

    private final void updateEndAreaActionsImmediately(e r4) {
        FrameLayout r0 = null;
        setFreezeEndAreaWidth(null);
        FrameLayout r1 = this.centerContainer;
        if (r1 != null) goto L5;
        d.h.b.o.c("centerContainer");
    L6:
        r0.setTranslationX(0.0f);
        getEndSubButtonGroup().setTranslationX(0.0f);
        if (r4.g() == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        setSubEndToEndGapVisible(r2);
        getEndSubButtonGroup().updateItemViews(r4.b(), false);
        getEndButtonGroup().updateItemViews(r4.c(), false);
        return;
    L9:
        if (r4.h() == false) goto L11;
        r2 = true;
        goto L12
    L5:
        r0 = r1;
        goto L6
    }

    private final void cancelEndAreaShiftAnimators() {
        com.obric.common.oea.foundation.animation.manager.d r0 = this.endSubShiftAnimator;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
    L6:
        this.endSubShiftAnimator = null;
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        cancelCenterShiftAnimation();
    }

    private final void cancelCenterShiftAnimation() {
        com.obric.common.oea.foundation.animation.manager.d r0 = this.centerShiftAnimator;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
    L6:
        this.centerShiftAnimator = null;
    }

    static /* synthetic */ void transitionEndAreaActions$default(OFloatingTitleBar r1, e r2, e r3, b r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r8 = null;
    L5:
        r1.transitionEndAreaActions(r2, r3, r4, r8);
    }

    private final void transitionEndAreaActions(e r9, e r10, b r11, d.h.a.a<d.x> r12) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        float r4 = getEndSubButtonGroup().getTranslationX();
        runEndAreaTransition(resolveEndAreaTransitionType(r9, r10, r4), r9, r10, r4, r11, this.endAreaTransitionGeneration, r7);
    }

    private final e createEndAreaSnapshot(List<? extends View> r10, List<? extends View> r11) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        return new e(endAreaState(!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty(), !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()), r4, r5, getEndAreaTargetWidth(r4, r5), getEndActionTargetWidth(r5), getEndActionTargetContentWidth(r5));
    }

    private final f resolveEndAreaTransitionType(e r4, e r5, float r6) {
        boolean r0 = true;
        if (r4.g() == true) goto L5;
    L11:
        boolean r3 = false;
    L13:
        if (r4.g() == true) goto L15;
    L21:
        boolean r2 = false;
    L22:
        if (r3 == true) goto L44;
        if (r2 == false) goto L27;
        return f.f36544c;
    L27:
        if (r4.a() != d.f36533b) goto L32;
        if (r5.a() != d.f36534c) goto L32;
        return f.f36545d;
    L32:
        if (r4.a() != d.f36534c) goto L37;
        if (r5.a() != d.f36533b) goto L37;
        return f.f36546e;
    L37:
        if (r6 == 0.0f) goto L40;
        r0 = false;
    L40:
        if (r0 == true) goto L43;
        return f.f;
    L43:
        return f.f36542a;
    L44:
        return f.f36543b;
    L15:
        if (r5.g() == false) goto L21;
        if (r4.h() == false) goto L21;
        if (r5.h() == true) goto L21;
        r2 = true;
        goto L22
    L5:
        if (r5.g() == false) goto L11;
        if (r4.h() == true) goto L11;
        if (r5.h() == false) goto L11;
        r3 = true;
        goto L13
    }

    private final Float[] resolveSubEndShiftRange(f r9, e r10, e r11, float r12) {
        int r8 = i.f36551a[r9.ordinal()];
        Float r1 = Float.valueOf(0.0f);
        Float r3 = null;
        switch(r8) {
            case 1: goto L59;
            case 2: goto L50;
            case 3: goto L38;
            case 4: goto L26;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Float[] r13 = {null, null};
    L60:
        Float[] r14 = new Float[2];
        Float r15 = r13[0];
        if (r15 != null) goto L64;
    L70:
        r14[0] = r3;
        r14[1] = r13[1];
        return r14;
    L64:
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).floatValue() != 0.0f) goto L66;
        boolean r16 = true;
    L68:
        if ((!r16) == false) goto L70;
        r3 = r15;
        goto L70
    L66:
        r16 = false;
        goto L68
    L7:
        r13 = new Float[2];
        if (r10.a() == d.f36535d) goto L10;
    L12:
        Float r17 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).floatValue() != 0.0f) goto L15;
        boolean r6 = true;
    L17:
        if ((!r6) == true) goto L20;
        r17 = null;
    L20:
        r13[0] = r17;
        if (r10.g() == true) goto L23;
    L25:
        r13[1] = r1;
        goto L60
    L23:
        if (r11.a() != d.f36534c) goto L25;
        r1 = null;
        goto L25
    L15:
        r6 = false;
        goto L17
    L10:
        if (r11.a() != d.f36534c) goto L12;
        r17 = Float.valueOf(r11.e());
        goto L20
    L26:
        r13 = new Float[2];
        Float r18 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).floatValue() != 0.0f) goto L29;
        boolean r19 = true;
    L31:
        if ((!r19) == true) goto L34;
        r18 = null;
    L34:
        if (r18 != null) goto L36;
        float r110 = r10.f();
    L37:
        r13[0] = Float.valueOf(r110);
        r13[1] = null;
        goto L60
    L36:
        r110 = r18.floatValue();
        goto L37
    L29:
        r19 = false;
        goto L31
    L38:
        r13 = new Float[2];
        Float r111 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.aiagent.plugin")).floatValue() != 0.0f) goto L41;
        boolean r112 = true;
    L43:
        if ((!r112) == true) goto L46;
        r111 = null;
    L46:
        if (r111 != null) goto L48;
        float r113 = r11.f();
    L49:
        r13[0] = Float.valueOf(r113);
        r13[1] = null;
        goto L60
    L48:
        r113 = r111.floatValue();
        goto L49
    L41:
        r112 = false;
        goto L43
    L50:
        r13 = new Float[2];
        Float r114 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.aiagent.plugin")).floatValue() != 0.0f) goto L53;
        boolean r115 = true;
    L55:
        if ((!r115) == true) goto L58;
        r114 = null;
    L58:
        r13[0] = r114;
        r13[1] = Float.valueOf(r10.e());
        goto L60
    L53:
        r115 = false;
        goto L55
    L59:
        r13 = new Float[]{Float.valueOf(r11.e()), r1};
        goto L60
    L5:
        throw new d.k();
    }

    private final h resolveSubEndShiftEndRawAlphaBinding(f r1) {
        int r0 = i.f36551a[r1.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return h.f36547a;
    L11:
        return h.f36549c;
    L9:
        return h.f36548b;
    }

    private final float[] resolveEndRawAlphaRange(h r3) {
        int r4 = i.f36552b[r3.ordinal()];
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L9;
        return new float[]{1.0f, 1.0f};
    L9:
        throw new d.k();
    L14:
        return new float[]{getEndButtonGroup().getRawGroupAlphaForTitleBarTransition$OUI_standardRelease(), 0.0f};
    L12:
        return new float[]{0.0f, 1.0f};
    }

    private final boolean bindSubEndShiftToEndRawAlphaIfNeeded(h r11, Float r12, Float r13, float r14, float r15, int r16) {
        if (r11 != h.f36547a) goto L7;
        return false;
    L7:
        if (r11 != h.f36548b) goto L13;
        OButtonGroup r0 = getEndSubButtonGroup();
        if (r12 != null) goto L11;
        float r1 = 0.0f;
    L12:
        r0.setTranslationX(r1);
        goto L13
    L11:
        r1 = r12.floatValue();
    L13:
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new m(r16, this, r11, r12, r13, r14, r15), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return true;
    }

    private final void updateSubEndShiftByEndRawAlpha(h r5, Float r6, Float r7, float r8, float r9) {
        float r0 = getEndButtonGroup().getRawGroupAlphaForTitleBarTransition$OUI_standardRelease();
        int r10 = i.f36552b[r5.ordinal()];
        float r3 = 0.0f;
        if (r10 != 1) goto L5;
        float r11 = r8 - r9;
        if (Math.abs(r11) < 0.001f) goto L30;
        if (r6 == null) goto L29;
        r3 = r6.floatValue();
    L29:
        r3 = r3 * ((r0 - r9) / r11);
    L30:
        getEndSubButtonGroup().setTranslationX(r3);
        notifyFloatingTransitionDrawUpdate$OUI_standardRelease();
        return;
    L5:
        if (r10 != 2) goto L7;
        float r12 = r9 - r8;
        if (Math.abs(r12) >= 0.001f) goto L16;
        if (r7 == null) goto L30;
        r3 = r7.floatValue();
        goto L30
    L16:
        if (r6 != null) goto L18;
        float r13 = 0.0f;
    L19:
        if (r7 == null) goto L22;
        r3 = r7.floatValue();
    L22:
        r3 = ((r3 - r13) * ((d.l.n.b(r0, r8) - r8) / r12)) + r13;
        goto L30
    L18:
        r13 = r6.floatValue();
        goto L19
    L7:
        if (r10 != 3) goto L10;
        return;
    L10:
        throw new d.k();
    }

    static /* synthetic */ void runEndAreaTransition$default(OFloatingTitleBar r9, f r10, e r11, e r12, float r13, b r14, int r15, d.h.a.a r16, int r17, Object r18) {
        d.h.a.a<d.x> r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r17 & 64) == 0) goto L5;
        r0 = null;
    L5:
        r9.runEndAreaTransition(r10, r11, r12, r13, r14, r15, r0);
    }

    private final void runEndAreaTransition(f r28, e r29, e r30, float r31, b r32, int r33, d.h.a.a<d.x> r34) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r34, d.h.a.a.class, "com.obric.aiagent.plugin");
        Float[] r0 = resolveSubEndShiftRange(r28, r29, r30, r31);
        Float r12 = r0[0];
        Float r17 = r0[1];
        h r9 = resolveSubEndShiftEndRawAlphaBinding(r28);
        float[] r1 = resolveEndRawAlphaRange(r9);
        float r10 = r1[0];
        float r18 = r1[1];
        if (r29.g() == false) goto L7;
        if (r29.h() == false) goto L7;
    L10:
        boolean r2 = true;
    L12:
        d.h.b.z.d r8 = new d.h.b.z.d();
        d.h.b.z.a r19 = new d.h.b.z.a();
        d.h.b.z.a r7 = new d.h.b.z.a();
        d.h.b.z.a r6 = new d.h.b.z.a();
        if (r12 == null) goto L16;
        if (r17 != null) goto L16;
        boolean r20 = true;
    L17:
        setSubEndToEndGapVisible(r2);
        if (r32 != b.f36530c) goto L20;
        r8.f38502a++;
    L20:
        int r5 = r29.d();
        int r4 = r30.d();
        if (r32 != b.f36530c) goto L23;
        d.h.a.a<d.x> r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r8, r7, r33, this, r19, r30, r32, r16), d.h.a.a.class, "com.obric.aiagent.plugin");
    L24:
        prepareCenterForEndAreaTransition(r5, r4, r32, r3);
        boolean r13 = bindSubEndShiftToEndRawAlphaIfNeeded(r9, r12, r17, r10, r18, r33);
        getEndSubButtonGroup().updateItemViews(r30.b(), true);
        getEndButtonGroup().updateItemViews(r30.c(), true);
        if (getEndSubButtonGroup().isAnimating() == false) goto L27;
        r8.f38502a++;
        d.h.b.z.d r14 = r8;
        getEndSubButtonGroup().addAnimationEndListener$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new v(r28, this, r6, r8, r29, r30, r7, r33, r19, r32, r16), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L29:
        if (getEndButtonGroup().isAnimating() == false) goto L31;
        r14.f38502a++;
        getEndButtonGroup().addAnimationEndListener$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new w(r28, this, r6, r14, r29, r30, r7, r33, r19, r32, r16), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L31:
        if (r12 != 0) goto L36;
        if (r17 != null) goto L36;
    L41:
        r7.f38499a = true;
        runEndAreaTransition$finishWhenReady(r7, r14, r33, this, r19, r30, r32, r16);
        return;
    L36:
        if (r13 != 0) goto L39;
        if (r20 == true) goto L39;
        r14.f38502a++;
        d.h.b.z.a r11 = r6;
        r11.f38499a = true;
    L40:
        runBeforeNextDraw((d.h.a.a) ZeusTransformUtils.preCheckCast(new x(r33, this, r11, r13, r20, r12, r17, r28, r14, r29, r30, r7, r19, r32, r16), d.h.a.a.class, "com.obric.aiagent.plugin"));
    L39:
        r11 = r6;
        goto L40
    L27:
        r14 = r8;
        goto L29
    L23:
        r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(null, d.h.a.a.class, "com.obric.aiagent.plugin");
    L16:
        r20 = false;
    L7:
        if (r30.g() == true) goto L9;
    L11:
        r2 = false;
        goto L12
    L9:
        if (r30.h() == false) goto L11;
        goto L10
    }

    private static final void runEndAreaTransition$finishTransition(int r2, OFloatingTitleBar r3, d.h.b.z.a r4, e r5, b r6, d.h.a.a<d.x> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2 == r3.endAreaTransitionGeneration) goto L6;
        return;
    L6:
        if (r4.f38499a == false) goto L8;
        return;
    L8:
        boolean r9 = true;
        r4.f38499a = true;
        r3.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r5.g() == true) goto L11;
    L13:
        r9 = false;
    L14:
        r3.setSubEndToEndGapVisible(r9);
        r3.getEndSubButtonGroup().setTranslationX(0.0f);
        r3.finishCenterForEndAreaTransition(r5.d(), r6, (d.h.a.a) ZeusTransformUtils.preCheckCast(new y(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (r5.h() == false) goto L13;
        goto L13
    }

    private static final void runEndAreaTransition$finishWhenReady(d.h.b.z.a r6, d.h.b.z.d r7, int r8, OFloatingTitleBar r9, d.h.b.z.a r10, e r11, b r12, d.h.a.a<d.x> r13) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r6.f38499a == true) goto L5;
        return;
    L5:
        if (r7.f38502a != 0) goto L9;
        runEndAreaTransition$finishTransition(r8, r9, r10, r11, r12, r5);
        return;
    }

    private static final void runEndAreaTransition$onParticipantFinished(d.h.b.z.d r8, d.h.b.z.a r9, int r10, OFloatingTitleBar r11, d.h.b.z.a r12, e r13, b r14, d.h.a.a<d.x> r15) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        r8.f38502a--;
        runEndAreaTransition$finishWhenReady(r9, r8, r10, r11, r12, r13, r14, r7);
    }

    private static final void runEndAreaTransition$settleSubEndShiftWhenEndGoneIfNeeded(f r2, OFloatingTitleBar r3, d.h.b.z.a r4, d.h.b.z.d r5) {
        if (r2 != f.f36544c) goto L5;
    L7:
        r3.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r4.f38499a == false) goto L14;
        r4.f38499a = false;
        com.obric.common.oea.foundation.animation.manager.d r6 = r3.endSubShiftAnimator;
        if (r6 == null) goto L13;
        com.obric.common.oea.foundation.animation.manager.d.a(r6, false, 1, null);
    L13:
        r3.endSubShiftAnimator = null;
        r5.f38502a--;
    L14:
        r3.getEndSubButtonGroup().setTranslationX(0.0f);
        return;
    L5:
        if (r2 == f.f36546e) goto L7;
    }

    private static final void runEndAreaTransition$settleSubEndShiftWhenSubEndGoneIfNeeded(f r1, e r2, e r3, OFloatingTitleBar r4) {
        if (r1 != f.f36545d) goto L5;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        return;
    L15:
        r4.getEndSubButtonGroup().setTranslationX(0.0f);
        return;
    L5:
        if (r1 == f.f) goto L7;
    L11:
        r5 = false;
        goto L13
    L7:
        if (r2.g() == false) goto L11;
        if (r3.a() != d.f36534c) goto L11;
        goto L11
    }

    private static final void runEndAreaTransition$onOneFinished(f r10, OFloatingTitleBar r11, d.h.b.z.a r12, d.h.b.z.d r13, e r14, e r15, d.h.b.z.a r16, int r17, d.h.b.z.a r18, b r19, d.h.a.a<d.x> r20, String r21) {
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r21, "end") == false) goto L6;
        runEndAreaTransition$settleSubEndShiftWhenEndGoneIfNeeded(r10, r11, r12, r13);
    L9:
        runEndAreaTransition$onParticipantFinished(r13, r16, r17, r11, r18, r15, r19, r9);
        return;
    L6:
        if (d.h.b.o.a(r21, "subEnd") == false) goto L9;
        runEndAreaTransition$settleSubEndShiftWhenSubEndGoneIfNeeded(r10, r14, r15, r11);
        goto L9
    }

    private final d endAreaState(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return d.f36535d;
    L5:
        if (r1 == true) goto L12;
        if (r2 == false) goto L10;
        return d.f36534c;
    L10:
        return d.f36532a;
    L12:
        return d.f36533b;
    }

    static /* synthetic */ void animateEndSubTranslationTo$default(OFloatingTitleBar r1, float r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.animateEndSubTranslationTo(r2, r6);
    }

    private final void animateEndSubTranslationTo(float r6, d.h.a.a<d.x> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.manager.d r0 = this.endSubShiftAnimator;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
    L6:
        this.endSubShiftAnimator = startTranslationXSpring(getEndSubButtonGroup().getTranslationX(), r6, (d.h.a.b) ZeusTransformUtils.preCheckCast(new j(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(this, r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void setFreezeEndAreaWidth(Integer r2) {
        if (d.h.b.o.a(this.freezeEndAreaWidth, r2) == false) goto L5;
        return;
    L5:
        this.freezeEndAreaWidth = r2;
        requestLayout();
    }

    static /* synthetic */ void prepareCenterForEndAreaTransition$default(OFloatingTitleBar r1, int r2, int r3, b r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r8 = null;
    L5:
        r1.prepareCenterForEndAreaTransition(r2, r3, r4, r8);
    }

    private final void prepareCenterForEndAreaTransition(int r4, int r5, b r6, d.h.a.a<d.x> r7) {
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        FrameLayout r0 = null;
        if (r6 != b.f36528a) goto L14;
        FrameLayout r9 = this.centerContainer;
        if (r9 != null) goto L7;
        d.h.b.o.c("centerContainer");
    L8:
        r0.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        releaseFreezeEndAreaWidth();
        if (r8 == null) goto L26;
        r8.invoke();
        return;
    L26:
        return;
    L7:
        r0 = r9;
        goto L8
    L14:
        if (r6 != b.f36529b) goto L24;
        cancelCenterShiftAnimation();
        FrameLayout r10 = this.centerContainer;
        if (r10 != null) goto L18;
        d.h.b.o.c("centerContainer");
    L19:
        r0.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        setFreezeEndAreaWidth(Integer.valueOf(r5));
        if (r8 == null) goto L27;
        r8.invoke();
        return;
    L27:
        return;
    L18:
        r0 = r10;
        goto L19
    L24:
        animateFreezeEndAreaWidthTo(r5, r8);
    }

    static /* synthetic */ void animateFreezeEndAreaWidthTo$default(OFloatingTitleBar r1, int r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.animateFreezeEndAreaWidthTo(r2, r6);
    }

    private final void animateFreezeEndAreaWidthTo(int r6, d.h.a.a<d.x> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        FrameLayout r0 = this.centerContainer;
        FrameLayout r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerContainer");
        r0 = null;
    L5:
        float r1 = r0.getX();
        FrameLayout r4 = this.centerContainer;
        if (r4 != null) goto L8;
        d.h.b.o.c("centerContainer");
    L9:
        float r3 = r1 + (r2.getWidth() / 2.0f);
        cancelCenterShiftAnimation();
        setFreezeEndAreaWidth(Integer.valueOf(r6));
        runBeforeNextDraw((d.h.a.a) ZeusTransformUtils.preCheckCast(new l(this, r3, r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r2 = r4;
        goto L9
    }

    private final void releaseFreezeEndAreaWidth() {
        Integer r0 = this.freezeEndAreaWidth;
        if (r0 != null) goto L5;
        return;
    L5:
        final int r1 = r0.intValue();
        LinearLayout r2 = this.endContainer;
        if (r2 != null) goto L8;
        d.h.b.o.c("endContainer");
        r2 = null;
    L8:
        Integer r3 = Integer.valueOf(r2.getWidth());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L20;
        LinearLayout r6 = this.endContainer;
        if (r6 != null) goto L19;
        d.h.b.o.c("endContainer");
        r6 = null;
    L19:
        int r7 = r6.getMeasuredWidth();
    L22:
        if (getEndSubButtonGroup().isAnimating() == false) goto L24;
    L27:
        if (r7 <= r1) goto L31;
        if (r5 == false) goto L31;
        post(new $$Lambda$OFloatingTitleBar$GGIW8hTwt6el910vM5oPQWwzkK8(this, r1));
        return;
    L31:
        setFreezeEndAreaWidth(null);
        return;
    L24:
        if (getEndButtonGroup().isAnimating() == true) goto L27;
        r5 = false;
        goto L27
    L20:
        r7 = r3.intValue();
        goto L22
    L11:
        r4 = false;
        goto L12
    }

    /* JADX INFO: renamed from: releaseFreezeEndAreaWidth$lambda-49, reason: not valid java name */
    private static final void m1214releaseFreezeEndAreaWidth$lambda49(OFloatingTitleBar r1, int r2) {
        d.h.b.o.e(r1, "this$0");
        Integer r0 = r1.freezeEndAreaWidth;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != r2) goto L9;
        r1.releaseFreezeEndAreaWidth();
        return;
    }

    static /* synthetic */ void finishCenterForEndAreaTransition$default(OFloatingTitleBar r1, int r2, b r3, d.h.a.a r4, int r5, Object r6) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.finishCenterForEndAreaTransition(r2, r3, r7);
    }

    private final void finishCenterForEndAreaTransition(int r3, b r4, d.h.a.a<d.x> r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        int r7 = i.f36553c[r4.ordinal()];
        if (r7 != 1) goto L5;
        FrameLayout r8 = this.centerContainer;
        if (r8 != null) goto L25;
        d.h.b.o.c("centerContainer");
        r8 = null;
    L25:
        r8.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        releaseFreezeEndAreaWidth();
        if (r6 == null) goto L36;
        r6.invoke();
        return;
    L36:
        return;
    L5:
        if (r7 != 2) goto L7;
        releaseFreezeEndAreaWidth();
        if (r6 == null) goto L35;
        r6.invoke();
        return;
    L35:
        return;
    L7:
        if (r7 != 3) goto L33;
        Integer r9 = this.freezeEndAreaWidth;
        if (r9 != null) goto L12;
    L14:
        releaseFreezeEndAreaWidth();
        if (r6 == null) goto L34;
        r6.invoke();
        return;
    L34:
        return;
    L12:
        if (r9.intValue() == r3) goto L14;
        animateFreezeEndAreaWidthTo(r3, (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    static /* synthetic */ com.obric.common.oea.foundation.animation.manager.d startCenterTranslationXSpring$default(OFloatingTitleBar r1, float r2, float r3, d.h.a.b r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.b<? super Float, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r9 = null;
    L6:
        return r1.startCenterTranslationXSpring(r2, r3, r8, r9);
    }

    private final com.obric.common.oea.foundation.animation.manager.d startCenterTranslationXSpring(float r3, float r4, d.h.a.b<? super Float, d.x> r5, d.h.a.a<d.x> r6) {
        return startTranslationXSpring(r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new ad(this, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin")), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ com.obric.common.oea.foundation.animation.manager.d startTranslationXSpring$default(OFloatingTitleBar r1, float r2, float r3, d.h.a.b r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.b<? super Float, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r9 = null;
    L6:
        return r1.startTranslationXSpring(r2, r3, r8, r9);
    }

    private final com.obric.common.oea.foundation.animation.manager.d startTranslationXSpring(float r10, float r11, d.h.a.b<? super Float, d.x> r12, d.h.a.a<d.x> r13) {
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        return com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), r10, r11, com.obric.oui.common.util.a.a((com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(AVOIDANCE_SHIFT_BOUNCE, AVOIDANCE_SHIFT_DURATION, com.obric.common.oea.foundation.animation.h.e.b.f32433a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), 10.0f), null, 8, null).a((d.h.a.q) ZeusTransformUtils.preCheckCast(new ae(r14, this), d.h.a.q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new af(r14, r11, this, r15), d.h.a.m.class, "com.obric.aiagent.plugin")).a().a();
    }

    private final boolean isEndAreaOccupiedForCenter(boolean r1) {
        if (r1 == false) goto L4;
    L7:
        return true;
    L4:
        if (this.freezeEndAreaWidth != null) goto L7;
        return false;
    }

    private final int getEndAreaWidthForCenter() {
        Integer r0 = this.freezeEndAreaWidth;
        if (r0 != null) goto L9;
        LinearLayout r1 = this.endContainer;
        if (r1 != null) goto L10;
        d.h.b.o.c("endContainer");
        r1 = null;
    L10:
        return r1.getMeasuredWidth();
    L9:
        return r0.intValue();
    }

    private final int getEndAreaTargetWidth(List<? extends View> r4, List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<? extends View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
        r2 = 0 + getEndSubButtonGroup().measureTargetItemViewsWidth(r6);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L8;
        return r2;
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L11;
        r2 = r2 + getSubEndToEndGap();
    L11:
        return r2 + getEndButtonGroup().measureTargetItemViewsWidth(r7);
    }

    private final int getSubEndToEndGap() {
        return this.subEndToEndGapPx;
    }

    private final void refreshSubEndToEndGapForCurrentState() {
        if (getEndSubButtonGroup().getVisibility() == 0) goto L5;
    L11:
        boolean r0 = false;
    L12:
        setSubEndToEndGapVisible(r0);
        return;
    L5:
        if (getEndButtonGroup().getVisibility() != 0) goto L11;
        if (getEndSubButtonGroup().getItemCount() <= 0) goto L11;
        if (getEndButtonGroup().getItemCount() <= 0) goto L11;
        r0 = true;
        goto L12
    }

    private final void setSubEndToEndGapVisible(boolean r4) {
        ViewGroup.LayoutParams r0 = getEndButtonGroup().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r4 == false) goto L10;
        int r5 = this.subEndToEndGapPx;
    L12:
        if (r1.getMarginStart() != r5) goto L14;
        return;
    L14:
        r1.setMarginStart(r5);
        getEndButtonGroup().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        r5 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final int getEndActionTargetWidth(View r1) {
        return getEndActionTargetWidth(d.a.p.a(r1));
    }

    private final int getEndActionTargetWidth(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4.isEmpty() == false) goto L7;
        return 0;
    L7:
        return getEndButtonGroup().measureTargetItemViewsWidth(r4) + getSubEndToEndGap();
    }

    private final int getEndActionTargetContentWidth(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4.isEmpty() == false) goto L7;
        return 0;
    L7:
        return getEndButtonGroup().measureTargetItemViewsWidth(r4);
    }

    private final void runBeforeNextDraw(d.h.a.a<d.x> r4) {
        final d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        View r0 = this.titleBarContainer;
        if (r0 != null) goto L5;
        d.h.b.o.c("titleBarContainer");
        r0 = null;
    L5:
        final ViewTreeObserver r1 = r0.getViewTreeObserver();
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1, this, r5), ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
    }

    public final void setStartButtonGroupStyle(int r5) {
        this.startButtonGroupStyle = r5;
        applyStyleToGroup(getStartButtonGroup(), r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ab(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void setCenterButtonGroupStyle(int r5) {
        this.centerButtonGroupStyle = r5;
        applyStyleToGroup(getCenterButtonGroup(), r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new z(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void setSubEndButtonGroupStyle(int r5) {
        this.endSubButtonGroupStyle = r5;
        applyStyleToGroup(getEndSubButtonGroup(), r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ac(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void setEndButtonGroupStyle(int r5) {
        this.endButtonGroupStyle = r5;
        applyStyleToGroup(getEndButtonGroup(), r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new aa(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void updateGroupItemsTint(OButtonGroup r4, int r5) {
        int r0 = r4.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        updateViewTint(r4.getItemViewAt(r1), r5);
        r1 = r2;
        goto L3
    }

    private final void updateViewTint(View r14, int r15) {
        com.obric.oui.titlebar.a.b r0 = null;
        if (r14 != null) goto L5;
        Object r1 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.titlebar.a.b.class) == false) goto L9;
        r0 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.titlebar.a.b.class, "com.obric.aiagent.plugin");
    L9:
        com.obric.oui.titlebar.a.b r4 = r0;
        if (r4 == null) goto L14;
        r14.setTag(com.obric.oui.titlebar.a.b.a(r4, 0, 0, null, r15, null, null, 55, null));
    L14:
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.class) == false) goto L19;
        int r2 = 0;
        int r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L16:
        if (r2 >= r3) goto L28;
        updateViewTint(((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r2), r15);
        r2 = r2 + 1;
        goto L16
    L28:
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r14, ImageView.class) == false) goto L22;
        ((ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.aiagent.plugin")).setColorFilter(r15);
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r14, TextView.class) == false) goto L27;
        ((TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.aiagent.plugin")).setTextColor(r15);
        return;
    L27:
        return;
    L5:
        r1 = r14.getTag();
        goto L7
    }

    private final void applyStyleToGroup(OButtonGroup r10, int r11, d.h.a.b<? super Integer, d.x> r12) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r11 != 0) goto L5;
        return;
    L5:
        TypedArray r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r11, R.styleable.OShadowFrame);
        d.h.b.o.c(r14, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r0 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColor, "styleable", "OShadowFrame_oui_widgetBgColor"), 0);
        int r4 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressColor, "styleable", "OShadowFrame_oui_widgetPressColor"), 0);
        int r5 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, "styleable", "OShadowFrame_oui_widgetBgColorDisabled"), 0);
        int r3 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTintColor, "styleable", "OShadowFrame_oui_widgetTintColor"), 0);
        String r6 = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterial, "styleable", "OShadowFrame_oui_widgetMaterial"));
        String r2 = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialDisabled, "styleable", "OShadowFrame_oui_widgetMaterialDisabled"));
        r14.recycle();
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));
        d.h.b.o.c(r9, "context.getString(R.stri…oui_material_bg_floating)");
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
    L10:
        if (r0 == 0) goto L26;
        if (r6 == null) goto L17;
        if (r5 != 0) goto L15;
        r5 = r0;
    L15:
        r10.setBgColors(r0, r5, r6, r2);
        goto L26
    L17:
        if (com.obric.oui.color.d.c(r0) == false) goto L22;
        if (r5 == 0) goto L20;
        int r15 = r5;
    L21:
        r10.setBgColors(r0, r15, com.obric.oui.material.d.f35485a.a(MaterialToken.OUI_Bg_Floating_Tinted_Light, r0), com.obric.oui.material.d.f35485a.a(MaterialToken.OUI_Bg_Floating_Tinted_Light, r5));
        goto L26
    L20:
        r15 = r0;
        goto L21
    L22:
        if (r5 != 0) goto L25;
        r5 = r0;
    L25:
        r10.setBgColors(r0, r5, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin"));
    L26:
        if (r4 == 0) goto L28;
        r10.setPressColor(r4);
    L28:
        if (r3 == 0) goto L31;
        r13.invoke(Integer.valueOf(r3));
        return;
    L31:
        return;
    L8:
        if (com.obric.oui.color.d.c(r0) == false) goto L10;
        r6 = null;
        goto L10
    }

    private final View createIconActionView(int r10, int r11) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "context");
        OUIFrameLayout r7 = new OUIFrameLayout(r1, null, 0, null, 14, null);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        r7.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 7), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 7), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 7), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 7));
        r7.setClickable(true);
        r7.setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 99));
        ImageView r9 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r9.setImageResource(r10);
        if (r11 == 0) goto L5;
        r9.setColorFilter(r11);
    L5:
        View r12 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 22), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 22));
        r13.gravity = 17;
        d.x r14 = d.x.f38692a;
        r7.addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
    }

    private final View createTextActionView(String r19, int r20) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "context");
        OUIFrameLayout r8 = new OUIFrameLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setMinimumHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 36));
        r8.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 7), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 7), 0);
        r8.setClickable(true);
        r8.setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 99));
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r12, "context");
        OTextView r4 = new OTextView(r12, null, 0, null, 14, null);
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setGravity(17);
        r4.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 4), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 4), 0);
        r4.setSingleLine(true);
        r4.setMinHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r4.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Button_2_Medium, "style", "Button_2_Medium"));
    L5:
        if (r20 == 0) goto L7;
        r4.setTextColor(r20);
    L7:
        View r0 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        d.x r3 = d.x.f38692a;
        r8.addView(r0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
    }

    private final View createTitleArrowActionView(String r19, int r20) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "context");
        OUILinearLayout r8 = new OUILinearLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setMinimumHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 36));
        r8.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 7), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 8), 0);
        r8.setClickable(true);
        r8.setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 99));
        r8.setOrientation(0);
        r8.setGravity(16);
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r12, "context");
        OTextView r5 = new OTextView(r12, null, 0, null, 14, null);
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"));
        r5.setGravity(16);
        r5.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), 4), 0, 0, 0);
        r5.setSingleLine(true);
        r5.setMinHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r5.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Bold, "style", "Title_1_Bold"));
    L5:
        if (r20 == 0) goto L7;
        r5.setTextColor(r20);
    L7:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 16;
        d.x r4 = d.x.f38692a;
        r8.addView(r1, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ImageView r6 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r6.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_chevron, "drawable", "o_card_list_item_tail_icon_chevron"));
        if (r20 == 0) goto L10;
        r6.setColorFilter(r20);
    L10:
        View r0 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 20), com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 20));
        r7.gravity = 16;
        r7.setMarginStart(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 4));
        d.x r9 = d.x.f38692a;
        r8.addView(r0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
    }

    public final OTextView getStartTitleView() {
        OTextView r0 = this.startTitleView;
        if (r0 != null) goto L6;
        d.h.b.o.c("startTitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getStartSubtitleView() {
        OTextView r0 = this.startSubtitleView;
        if (r0 != null) goto L6;
        d.h.b.o.c("startSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getCenterTitleView() {
        OTextView r0 = this.centerTitleView;
        if (r0 != null) goto L6;
        d.h.b.o.c("centerTitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getCenterSubtitleView() {
        OTextView r0 = this.centerSubtitleView;
        if (r0 != null) goto L6;
        d.h.b.o.c("centerSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final void setStartTitle(String r6) {
        OTextView r0 = this.startTitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("startTitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r7 = this.startTitleView;
        if (r7 != null) goto L8;
        d.h.b.o.c("startTitleView");
    L9:
        resetTitleVis((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin"));
        notifyFloatingTransitionStateChanged$OUI_standardRelease();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setStartTitle(int r2) {
        setStartTitle(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2));
    }

    public final void setStartTitleColor(int r3) {
        OTextView r0 = this.startTitleView;
        if (r0 != null) goto L5;
        d.h.b.o.c("startTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r3);
        this.currentMaskMaterialConfig = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.maskMaterial.invoke(Boolean.valueOf(isDarkTheme())), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
    }

    public final void setStartSubtitle(String r6) {
        OTextView r0 = this.startSubtitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("startSubtitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r7 = this.startSubtitleView;
        if (r7 != null) goto L8;
        d.h.b.o.c("startSubtitleView");
    L9:
        resetTitleVis((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin"));
        notifyFloatingTransitionStateChanged$OUI_standardRelease();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setStartSubtitle(int r2) {
        setStartSubtitle(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2));
    }

    public final void setStartSubTitleColor(int r1) {
        OTextView r0 = this.startSubtitleView;
        if (r0 != null) goto L5;
        d.h.b.o.c("startSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setCenterTitle(String r6) {
        OTextView r0 = this.centerTitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerTitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r7 = this.centerTitleView;
        if (r7 != null) goto L8;
        d.h.b.o.c("centerTitleView");
    L9:
        resetTitleVis((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin"));
        notifyFloatingTransitionStateChanged$OUI_standardRelease();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setCenterTitle(int r2) {
        setCenterTitle(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2));
    }

    public final void setCenterTitleColor(int r3) {
        OTextView r0 = this.centerTitleView;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r3);
        this.currentMaskMaterialConfig = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.maskMaterial.invoke(Boolean.valueOf(isDarkTheme())), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
    }

    public final void setCenterSubtitle(String r6) {
        OTextView r0 = this.centerSubtitleView;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerSubtitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r7 = this.centerSubtitleView;
        if (r7 != null) goto L8;
        d.h.b.o.c("centerSubtitleView");
    L9:
        resetTitleVis((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin"));
        notifyFloatingTransitionStateChanged$OUI_standardRelease();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setCenterSubTitle(int r2) {
        setCenterSubtitle(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2));
    }

    public final void setCenterSubTitleColor(int r1) {
        OTextView r0 = this.centerSubtitleView;
        if (r0 != null) goto L5;
        d.h.b.o.c("centerSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    private final void resetTitleVis(TextView r4) {
        CharSequence r0 = r4.getText();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r1 = 8;
    L13:
        r4.setVisibility(r1);
        requestLayout();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final void setMaskBackground(Drawable r2) {
        d.h.b.o.e(r2, "drawable");
        showMask(true);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.materialSrcType == (-1)) goto L6;
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin"), this.materialSrcType);
        return;
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r0);
        getCenterButtonGroup().setBackdropTarget(r0);
        getEndButtonGroup().setBackdropTarget(r0);
        getEndSubButtonGroup().setBackdropTarget(r0);
    }

    public final void setMaskBlurRadius(float r6) {
        com.obric.oui.material.c r0 = this.currentMaskMaterialConfig;
        com.obric.oui.material.c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("currentMaskMaterialConfig");
        r0 = null;
    L5:
        com.obric.oui.blur.a r2 = r0.g();
        if (r2 == null) goto L9;
        r2.a(r6);
    L9:
        com.obric.oui.window.floating.a r3 = this.floatingWindowHelper;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.c r5 = this.currentMaskMaterialConfig;
        if (r5 != null) goto L12;
        d.h.b.o.c("currentMaskMaterialConfig");
    L13:
        r3.a(r4, r1, this.materialSrcType);
        if (r6 != 0.0f) goto L16;
        boolean r7 = true;
    L17:
        showMask(!r7);
        return;
    L16:
        r7 = false;
        goto L17
    L12:
        r1 = r5;
        goto L13
    }

    public final void showMask(boolean r1) {
        View r0 = this.materialMask;
        if (r0 != null) goto L5;
        d.h.b.o.c("materialMask");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final void setFloatingTransitionEnabled(boolean r4) {
        if (this.enableFloatingTransition != r4) goto L5;
        return;
    L5:
        this.enableFloatingTransition = r4;
        if (r4 == true) goto L8;
        FloatingTransitionBridge r5 = this.floatingTransitionBridge;
        if (r5 == null) goto L29;
        FloatingTransitionBridge.a(r5, false, false, 3, null);
    L29:
        this.floatingTransitionBridge = null;
        return;
    L8:
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L11;
        return;
    L11:
        if (this.floatingTransitionBridge != null) goto L17;
        FloatingTransitionBridge r6 = new FloatingTransitionBridge(this);
        this.floatingTransitionBridge = r6;
        if (r6 == null) goto L17;
        r6.a(this.floatingTransitionEndListener);
    L17:
        if (isAttachedToWindow() == true) goto L19;
        return;
    L19:
        if (this.floatingTransitionOwnerActive == false) goto L32;
        FloatingTransitionBridge r7 = this.floatingTransitionBridge;
        if (r7 == null) goto L24;
        FloatingTransitionBridge.a(r7, false, 1, null);
    L24:
        post(new $$Lambda$OFloatingTitleBar$WU4WHDyMq4h0GWo9Q9ugQXexNA(this));
        return;
    }

    /* JADX INFO: renamed from: setFloatingTransitionEnabled$lambda-62, reason: not valid java name */
    private static final void m1215setFloatingTransitionEnabled$lambda62(OFloatingTitleBar r1) {
        d.h.b.o.e(r1, "this$0");
        r1.notifyFloatingTransitionStateChanged$OUI_standardRelease();
    }

    public final void interruptFloatingTransitionForHostTargetChange$OUI_standardRelease() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L10;
        r1.a();
        return;
    }

    private final void interruptFloatingTransitionForActionChange() {
        d.h.a.a<d.x> r0 = this.actionChangeInterruptCallback;
        if (r0 != null) goto L5;
        d.x r1 = null;
    L6:
        if (r1 != null) goto L9;
        interruptFloatingTransitionForHostTargetChange$OUI_standardRelease();
        return;
    L9:
        return;
    L5:
        r0.invoke();
        r1 = d.x.f38692a;
        goto L6
    }

    public final void finishFloatingTransitionForUserInteraction() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L10;
        r1.b();
        return;
    }

    public final void setTitleBarTransitionEndListener(g r3) {
        this.titleBarTransitionEndListener = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
    }

    public final void setFloatingTransitionEndListener(FloatingTransitionBridge.c r3) {
        FloatingTransitionBridge.c r4 = (FloatingTransitionBridge.c) ZeusTransformUtils.wrapperContextForParams(r3, FloatingTransitionBridge.c.class, "com.obric.aiagent.plugin");
        this.floatingTransitionEndListener = r4;
        FloatingTransitionBridge r2 = this.floatingTransitionBridge;
        if (r2 == null) goto L7;
        r2.a(r4);
        return;
    }

    public final void setFloatingTransitionOwnerActive$OUI_standardRelease(boolean r2) {
        if (this.floatingTransitionOwnerActive != r2) goto L5;
        return;
    L5:
        this.floatingTransitionOwnerActive = r2;
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L9;
        return;
    L9:
        if (this.enableFloatingTransition == true) goto L11;
        return;
    L11:
        if (isAttachedToWindow() == false) goto L26;
        if (r2 == false) goto L19;
        FloatingTransitionBridge r3 = this.floatingTransitionBridge;
        if (r3 == null) goto L18;
        r3.a(true);
    L18:
        post(new $$Lambda$OFloatingTitleBar$MbCzbbW8hxoF_8PQvLaeQFyexwk(this));
        return;
    L19:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L27;
        r1.a(false, false);
        return;
    L27:
        return;
    }

    /* JADX INFO: renamed from: setFloatingTransitionOwnerActive$lambda-63, reason: not valid java name */
    private static final void m1216setFloatingTransitionOwnerActive$lambda63(OFloatingTitleBar r1) {
        d.h.b.o.e(r1, "this$0");
        r1.notifyFloatingTransitionStateChanged$OUI_standardRelease();
    }

    public final void onActionHostBound$OUI_standardRelease(OFloatingTitleBarActionHost r2) {
        d.h.b.o.e(r2, "host");
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L10;
        r1.a(r2);
        return;
    }

    public static /* synthetic */ boolean prepareFloatingTransitionLaunch$OUI_standardRelease$default(OFloatingTitleBar r0, OFloatingTitleBarActionHost r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.prepareFloatingTransitionLaunch$OUI_standardRelease(r1);
    }

    public final boolean prepareFloatingTransitionLaunch$OUI_standardRelease(OFloatingTitleBarActionHost r5) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        return false;
    L6:
        if (this.floatingTransitionOwnerActive == true) goto L9;
        return false;
    L9:
        if (this.enableFloatingTransition == true) goto L12;
        this.enableFloatingTransition = true;
    L12:
        if (this.floatingTransitionBridge != null) goto L17;
        FloatingTransitionBridge r0 = new FloatingTransitionBridge(this);
        this.floatingTransitionBridge = r0;
        if (r0 == null) goto L17;
        r0.a(this.floatingTransitionEndListener);
    L17:
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L22;
        r1.b(r5);
    L22:
        if (isAttachedToWindow() == true) goto L24;
        return false;
    L24:
        FloatingTransitionBridge r4 = this.floatingTransitionBridge;
        if (r4 == null) goto L28;
        r4.a(true);
    L28:
        return true;
    }

    public final void notifyFloatingTransitionStateChanged$OUI_standardRelease() {
        if (this.batchSetDepth <= 0) goto L6;
        return;
    L6:
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L8;
        return;
    L8:
        if (this.enableFloatingTransition == true) goto L10;
        return;
    L10:
        if (isAttachedToWindow() == true) goto L12;
        return;
    L12:
        if (this.floatingTransitionOwnerActive == false) goto L22;
        FloatingTransitionBridge r1 = this.floatingTransitionBridge;
        if (r1 == null) goto L23;
        r1.e();
        return;
    L23:
        return;
    }

    public static /* synthetic */ void onFloatingTransitionHideActions$OUI_standardRelease$default(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.onFloatingTransitionHideActions$OUI_standardRelease(r1);
    }

    public final void onFloatingTransitionHideActions$OUI_standardRelease(boolean r2) {
        setActionContentVisible$OUI_standardRelease(false, r2);
    }

    public final void onFloatingTransitionRestoreTargetState$OUI_standardRelease(boolean r2) {
        pauseActionAnimations();
        if (r2 == false) goto L6;
        setActionContentVisible$OUI_standardRelease(false, true);
        return;
    }

    public final void onFloatingTransitionEnd$OUI_standardRelease() {
        setActionContentVisible$OUI_standardRelease$default(this, true, false, 2, null);
    }

    private final void dispatchTitleBarTransitionEnd() {
        g r0 = this.titleBarTransitionEndListener;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    @Override // com.obric.oui.material.b
    public void applyMaskMaterial(boolean r4) {
        if (this.materialSrcType == (-1)) goto L6;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.materialSrcType);
        return;
    L6:
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.isBackdropView);
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r4) {
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r5) {
        this.backdropTarget = r5;
        if (r5 != null) goto L6;
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        setDefaultBackdropTargetForChild();
        return;
    L6:
        com.obric.oui.material.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5);
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r5) {
        if (this.isBackdropView == r5) goto L12;
        this.isBackdropView = r5;
        if (this.materialSrcType == (-1)) goto L8;
        return;
    L8:
        if (this.floatingWindowHelper.a() == true) goto L10;
        com.obric.oui.material.k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5);
    L10:
        com.obric.oui.material.h.b((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin"), r5);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r4) {
        this.materialSrcType = r4;
        com.obric.oui.material.h.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.aiagent.plugin"), r4);
    }

    private final int getCenterTitleGap() {
        if (this.mIsLargeFont == false) goto L6;
        return this.centerTitleGapLargeFontPx;
    L6:
        return this.centerTitleGapPx;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r19, int r20) {
        this.isCenterOverflow = false;
        OTextView r2 = this.centerTitleView;
        if (r2 != null) goto L5;
        d.h.b.o.c("centerTitleView");
        r2 = null;
    L5:
        r2.setMaxWidth(Integer.MAX_VALUE);
        OTextView r3 = this.centerSubtitleView;
        if (r3 != null) goto L8;
        d.h.b.o.c("centerSubtitleView");
        r3 = null;
    L8:
        r3.setMaxWidth(Integer.MAX_VALUE);
        OTextView r4 = this.startTitleView;
        if (r4 != null) goto L11;
        d.h.b.o.c("startTitleView");
        r4 = null;
    L11:
        r4.setMaxWidth(Integer.MAX_VALUE);
        OTextView r5 = this.startSubtitleView;
        if (r5 != null) goto L14;
        d.h.b.o.c("startSubtitleView");
        r5 = null;
    L14:
        r5.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r19, r20);
        boolean r6 = isStartVis();
        boolean r7 = isCenterVis();
        boolean r9 = isEndAreaOccupiedForCenter(isEndVis());
        int r10 = getEndAreaWidthForCenter();
        int r11 = getMeasuredWidth();
        View r12 = this.titleBarContainer;
        if (r12 != null) goto L17;
        d.h.b.o.c("titleBarContainer");
        r12 = null;
    L17:
        int r13 = r12.getPaddingLeft();
        View r14 = this.titleBarContainer;
        if (r14 != null) goto L20;
        d.h.b.o.c("titleBarContainer");
        r14 = null;
    L20:
        int r15 = r14.getPaddingRight();
        int r16 = getCenterTitleGap();
        if (r7 == false) goto L26;
        int r17 = r11 / 2;
        FrameLayout r8 = this.centerContainer;
        if (r8 != null) goto L25;
        d.h.b.o.c("centerContainer");
        r8 = null;
    L25:
        int r18 = (r17 - (r8.getMeasuredWidth() / 2)) - r16;
    L30:
        if (r6 == false) goto L35;
        int r110 = (r11 / 2) - r13;
        FrameLayout r1 = this.startContainer;
        if (r1 != null) goto L34;
        d.h.b.o.c("startContainer");
        r1 = null;
    L34:
        int r21 = (r110 - r1.getMeasuredWidth()) - r16;
    L36:
        if (r9 == false) goto L38;
        int r111 = (((r11 / 2) - r15) - r10) - r16;
    L39:
        boolean r22 = true;
        if (r6 == false) goto L53;
        int r23 = Math.max(0, r18 - r13);
        FrameLayout r24 = this.startContainer;
        if (r24 != null) goto L45;
        d.h.b.o.c("startContainer");
        r24 = null;
    L45:
        if (r24.getMeasuredWidth() <= r23) goto L53;
        OTextView r25 = this.startTitleView;
        if (r25 != null) goto L49;
        d.h.b.o.c("startTitleView");
        r25 = null;
    L49:
        r25.setMaxWidth(r23);
        OTextView r26 = this.startSubtitleView;
        if (r26 != null) goto L52;
        d.h.b.o.c("startSubtitleView");
        r26 = null;
    L52:
        r26.setMaxWidth(r23);
        boolean r27 = true;
    L54:
        if (r7 == false) goto L96;
        boolean r28 = false;
        int r29 = Math.max(0, Math.min(r21 * 2, r111 * 2));
        FrameLayout r30 = this.centerContainer;
        if (r30 != null) goto L59;
        d.h.b.o.c("centerContainer");
        r30 = null;
    L59:
        if (r30.getMeasuredWidth() <= r29) goto L96;
        this.isCenterOverflow = true;
        int r31 = r21 + r111;
        OTextView r32 = this.centerTitleView;
        if (r32 != null) goto L63;
        d.h.b.o.c("centerTitleView");
        r32 = null;
    L63:
        r32.setMaxWidth(r31);
        OTextView r33 = this.centerTitleView;
        if (r33 != null) goto L67;
        d.h.b.o.c("centerTitleView");
        r33 = null;
    L67:
        if (r33.getMeasuredWidth() <= r29) goto L72;
        OTextView r34 = this.centerSubtitleView;
        if (r34 != null) goto L71;
        d.h.b.o.c("centerSubtitleView");
        r34 = null;
    L71:
        r34.setMaxWidth(r31);
    L76:
        FrameLayout r35 = this.centerCustomContainer;
        if (r35 != null) goto L80;
        d.h.b.o.c("centerCustomContainer");
        r35 = null;
    L80:
        if (((View) ZeusTransformUtils.preCheckCast(r35, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L82;
        r28 = true;
    L82:
        if (r28 == false) goto L97;
        FrameLayout r36 = this.centerCustomContainer;
        if (r36 != null) goto L86;
        d.h.b.o.c("centerCustomContainer");
        r36 = null;
    L86:
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        FrameLayout r38 = this.centerCustomContainer;
        if (r38 != null) goto L90;
        d.h.b.o.c("centerCustomContainer");
        r38 = null;
    L90:
        if (r38.getMeasuredWidth() <= r31) goto L97;
        r37.width = r31;
        FrameLayout r39 = this.centerCustomContainer;
        if (r39 != null) goto L94;
        d.h.b.o.c("centerCustomContainer");
        FrameLayout r40 = null;
    L95:
        r40.setLayoutParams(r37);
        goto L97
    L94:
        r40 = r39;
    L97:
        if (r22 == false) goto L100;
        super.onMeasure(r19, r20);
        return;
    L100:
        return;
    L72:
        OTextView r41 = this.centerSubtitleView;
        if (r41 != null) goto L75;
        d.h.b.o.c(r6);
        r41 = null;
    L75:
        r41.setMaxWidth(r29);
    L96:
        r22 = r27;
    L53:
        r27 = false;
        goto L54
    L38:
        r111 = ((r11 / 2) - r15) - this.centerTitleHorizontalPaddingPx;
        goto L39
    L35:
        r21 = ((r11 / 2) - r13) - this.centerTitleHorizontalPaddingPx;
        goto L36
    L26:
        if (r9 == false) goto L28;
        r18 = ((r11 - r15) - r10) - r16;
        goto L30
    L28:
        r18 = r11 - r15;
        goto L30
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        if (isCenterVis() == true) goto L5;
        return;
    L5:
        int r12 = getMeasuredWidth();
        View r13 = this.titleBarContainer;
        FrameLayout r14 = null;
        if (r13 != null) goto L8;
        d.h.b.o.c("titleBarContainer");
        r13 = null;
    L8:
        int r15 = r13.getPaddingLeft();
        View r16 = this.titleBarContainer;
        if (r16 != null) goto L11;
        d.h.b.o.c("titleBarContainer");
        r16 = null;
    L11:
        int r17 = r16.getPaddingRight();
        int r0 = getCenterTitleGap();
        boolean r1 = isEndAreaOccupiedForCenter(isEndVis());
        int r2 = getEndAreaWidthForCenter();
        if (isStartVis() == false) goto L17;
        FrameLayout r3 = this.startContainer;
        if (r3 != null) goto L16;
        d.h.b.o.c("startContainer");
        r3 = null;
    L16:
        r15 = (r15 + r3.getMeasuredWidth()) + r0;
    L17:
        if (r1 == false) goto L19;
        int r18 = ((r12 - r17) - r2) - r0;
    L20:
        FrameLayout r4 = this.centerContainer;
        if (r4 != null) goto L23;
        d.h.b.o.c("centerContainer");
        r4 = null;
    L23:
        int r5 = r4.getMeasuredWidth();
        FrameLayout r6 = this.centerContainer;
        if (r6 != null) goto L26;
        d.h.b.o.c("centerContainer");
        r6 = null;
    L26:
        int r19 = r6.getMeasuredHeight();
        int r20 = (r12 - r5) / 2;
        int r21 = r20 + r5;
        int r22 = r18 - r15;
        if (r5 <= r22) goto L30;
        r20 = r15;
    L29:
        r21 = r18;
    L35:
        if (this.isCenterOverflow == false) goto L37;
        int r23 = (r22 - r5) / 2;
        r20 = r15 + r23;
        r21 = r18 - r23;
    L37:
        View r24 = this.titleBarContainer;
        if (r24 != null) goto L40;
        d.h.b.o.c("titleBarContainer");
        r24 = null;
    L40:
        int r25 = r24.getPaddingTop();
        View r110 = this.titleBarContainer;
        if (r110 != null) goto L43;
        d.h.b.o.c("titleBarContainer");
        r110 = null;
    L43:
        int r111 = r110.getMeasuredHeight();
        View r26 = this.titleBarContainer;
        if (r26 != null) goto L46;
        d.h.b.o.c("titleBarContainer");
        r26 = null;
    L46:
        int r27 = r25 + ((((r111 - r26.getPaddingBottom()) - r25) - r19) / 2);
        int r28 = r19 + r27;
        FrameLayout r29 = this.centerContainer;
        if (r29 != null) goto L49;
        d.h.b.o.c("centerContainer");
    L50:
        r14.layout(r20, r27, r21, r28);
        return;
    L49:
        r14 = r29;
        goto L50
    L30:
        if (r20 >= r15) goto L32;
        r21 = r15 + r5;
        r20 = r15;
        goto L35
    L32:
        if (r21 <= r18) goto L35;
        r20 = r18 - r5;
        goto L29
    L19:
        r18 = r12 - r17;
        goto L20
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        d.h.b.o.a(r1);
        this.mIsLargeFont = com.obric.oui.d.h.a(r1.fontScale);
    L6:
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        this.centerTitleHorizontalPaddingPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        this.centerTitleGapPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        this.centerTitleGapLargeFontPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        this.subEndToEndGapPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
    }

    private final boolean isStartVis() {
        if (((View) ZeusTransformUtils.preCheckCast(getStartButtonGroup(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L27;
        OTextView r1 = this.startTitleView;
        OTextView r4 = null;
        if (r1 != null) goto L11;
        d.h.b.o.c("startTitleView");
        r1 = null;
    L11:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L28;
        OTextView r6 = this.startSubtitleView;
        if (r6 != null) goto L18;
        d.h.b.o.c("startSubtitleView");
    L20:
        if (((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        return true;
    L26:
        return false;
    L22:
        r7 = false;
        goto L23
    L18:
        r4 = r6;
        goto L20
    L28:
        return true;
    L13:
        r2 = false;
        goto L14
    L27:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isCenterVis() {
        if (((View) ZeusTransformUtils.preCheckCast(getCenterButtonGroup(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L35;
        OTextView r1 = this.centerTitleView;
        FrameLayout r4 = null;
        if (r1 != null) goto L11;
        d.h.b.o.c("centerTitleView");
        r1 = null;
    L11:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L36;
        OTextView r3 = this.centerSubtitleView;
        if (r3 != null) goto L19;
        d.h.b.o.c("centerSubtitleView");
        r3 = null;
    L19:
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L37;
        FrameLayout r6 = this.centerCustomContainer;
        if (r6 != null) goto L26;
        d.h.b.o.c("centerCustomContainer");
    L28:
        if (((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == false) goto L34;
        return true;
    L34:
        return false;
    L30:
        r7 = false;
        goto L31
    L26:
        r4 = r6;
        goto L28
    L37:
        return true;
    L21:
        r5 = false;
        goto L22
    L36:
        return true;
    L13:
        r2 = false;
        goto L14
    L35:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isEndVis() {
        if (((View) ZeusTransformUtils.preCheckCast(getEndButtonGroup(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (((View) ZeusTransformUtils.preCheckCast(getEndSubButtonGroup(), View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private final boolean isDarkTheme() {
        OTextView r0 = this.startTitleView;
        OTextView r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("startTitleView");
        r0 = null;
    L5:
        boolean r3 = false;
        if (((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        OTextView r7 = this.startTitleView;
        if (r7 != null) goto L13;
        d.h.b.o.c("startTitleView");
    L14:
        int r8 = r2.getTextColors().getDefaultColor();
    L28:
        return !com.obric.oui.color.d.a(r8);
    L13:
        r2 = r7;
        goto L14
    L15:
        OTextView r4 = this.centerTitleView;
        if (r4 != null) goto L19;
        d.h.b.o.c("centerTitleView");
        r4 = null;
    L19:
        if (((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L21;
        r3 = true;
    L21:
        if (r3 == false) goto L30;
        OTextView r9 = this.centerTitleView;
        if (r9 != null) goto L25;
        d.h.b.o.c("centerTitleView");
    L26:
        r8 = r2.getTextColors().getDefaultColor();
        goto L28
    L25:
        r2 = r9;
        goto L26
    L30:
        return com.obric.oui.d.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L8:
        r1 = false;
        goto L9
    }

    private final int captureMeasuredWidth(View r5) {
        boolean r0 = true;
        if (r5.getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        return 0;
    L8:
        Integer r6 = Integer.valueOf(r5.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L12;
        r0 = false;
    L12:
        if (r0 == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L18;
        return r5.getWidth();
    L18:
        return r6.intValue();
    L5:
        r4 = false;
        goto L6
    }
}
