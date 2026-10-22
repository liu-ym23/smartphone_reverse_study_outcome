package com.obric.autoaction.vdplayer.components.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.autogui.vdplayer.a.n;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: PrivacyBadgeView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PrivacyBadgeView extends FrameLayout {
    private final n binding;
    private b renderedState;

    /* JADX INFO: compiled from: PrivacyBadgeView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25437a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25438b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f25439c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25440d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f25437a, f25438b};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25437a = new a("IconOnly", 0);
            f25438b = new a("IconWithText", 1);
            a[] r0 = a();
            f25439c = r0;
            f25440d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f25439c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: PrivacyBadgeView.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f25442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f25443c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25441a == r6.f25441a) goto L12;
            return false;
        L12:
            if (this.f25442b == r6.f25442b) goto L15;
            return false;
        L15:
            if (this.f25443c == r6.f25443c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f25441a) * 31) + Boolean.hashCode(this.f25442b)) * 31) + this.f25443c.hashCode();
        }

        public String toString() {
            return "BadgeRenderState(privacyVisible=" + this.f25441a + ", securityVisible=" + this.f25442b + ", mode=" + this.f25443c + ')';
        }

        public b(boolean r2, boolean r3, a r4) {
            o.e(r4, "mode");
            this.f25441a = r2;
            this.f25442b = r3;
            this.f25443c = r4;
        }

        public final boolean a() {
            return this.f25441a;
        }

        public final boolean b() {
            return this.f25442b;
        }

        public final a c() {
            return this.f25443c;
        }
    }

    public PrivacyBadgeView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PrivacyBadgeView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ PrivacyBadgeView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public PrivacyBadgeView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        n r8 = n.a(LayoutInflater.from(r6), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        o.c(r8, "inflate(...)");
        this.binding = r8;
        b r9 = new b(false, false, a.f25437a);
        this.renderedState = r9;
        applyState(r9);
    }

    public final void render(b r2) {
        o.e(r2, "targetState");
        applyState(r2);
    }

    private final void applyState(b r10) {
        this.renderedState = r10;
        if (r10.c() != a.f25438b) goto L5;
        boolean r0 = true;
    L7:
        if (r10.b() == false) goto L10;
        if (r0 == false) goto L10;
        boolean r1 = true;
    L11:
        boolean r11 = r10.a();
        if (r1 == true) goto L16;
        if (r11 == true) goto L16;
        boolean r4 = false;
    L17:
        LinearLayout r5 = this.binding.f31647e;
        if (r1 == false) goto L20;
        int r7 = 0;
    L21:
        r5.setVisibility(r7);
        OTextView r6 = this.binding.g;
        if (r0 == false) goto L24;
        int r8 = 0;
    L25:
        r6.setVisibility(r8);
        LinearLayout r9 = this.binding.f31643a;
        if (r11 == false) goto L28;
        int r12 = 0;
    L29:
        r9.setVisibility(r12);
        OTextView r13 = this.binding.f31645c;
        if (r0 == false) goto L32;
        int r2 = 0;
    L33:
        r13.setVisibility(r2);
        LinearLayout r3 = this.binding.f31643a;
        o.c(r3, "privacyBadgeContent");
        View r14 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r16 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r16, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r1 == false) goto L37;
        if (r11 == false) goto L37;
        int r18 = d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    L38:
        r17.setMarginStart(r18);
        r14.setLayoutParams(r16);
        if (r4 == false) goto L41;
        setVisibility(0);
        setAlpha(1.0f);
        return;
    L41:
        setVisibility(4);
        setAlpha(0.0f);
        return;
    L37:
        r18 = 0;
        goto L38
    L32:
        r2 = 8;
        goto L33
    L28:
        r12 = 8;
        goto L29
    L24:
        r8 = 8;
        goto L25
    L20:
        r7 = 8;
    L16:
        r4 = true;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }
}
