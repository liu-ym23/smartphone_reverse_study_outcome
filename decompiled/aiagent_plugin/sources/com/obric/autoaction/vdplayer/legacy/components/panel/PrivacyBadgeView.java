package com.obric.autoaction.vdplayer.legacy.components.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.autogui.vdplayer.a.m;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: PrivacyBadgeView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PrivacyBadgeView extends FrameLayout {
    private final m binding;
    private b renderedState;

    /* JADX INFO: compiled from: PrivacyBadgeView.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25844a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25845b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f25846c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25847d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f25844a, f25845b};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25844a = new a("IconOnly", 0);
            f25845b = new a("IconWithText", 1);
            a[] r0 = a();
            f25846c = r0;
            f25847d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f25846c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: PrivacyBadgeView.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f25849b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25848a == r6.f25848a) goto L12;
            return false;
        L12:
            if (this.f25849b == r6.f25849b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f25848a) * 31) + this.f25849b.hashCode();
        }

        public String toString() {
            return "BadgeRenderState(visible=" + this.f25848a + ", mode=" + this.f25849b + ')';
        }

        public b(boolean r2, a r3) {
            o.e(r3, "mode");
            this.f25848a = r2;
            this.f25849b = r3;
        }

        public final boolean a() {
            return this.f25848a;
        }

        public final a b() {
            return this.f25849b;
        }
    }

    /* JADX INFO: compiled from: PrivacyBadgeView.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25850a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f25844a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[a.f25845b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f25850a = r0;
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
        m r8 = m.a(LayoutInflater.from(r6), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        o.c(r8, "inflate(...)");
        this.binding = r8;
        b r9 = new b(false, a.f25844a);
        this.renderedState = r9;
        applyState(r9);
    }

    public final void render(b r2) {
        o.e(r2, "targetState");
        applyState(r2);
    }

    private final void applyState(b r5) {
        this.renderedState = r5;
        OTextView r0 = this.binding.f31641c;
        int r1 = c.f25850a[r5.b().ordinal()];
        if (r1 != 1) goto L5;
        int r2 = 8;
    L10:
        r0.setVisibility(r2);
        if (r5.a() == false) goto L13;
        setVisibility(0);
        setAlpha(1.0f);
        return;
    L13:
        setVisibility(4);
        setAlpha(0.0f);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = 0;
        goto L10
    L8:
        throw new k();
    }
}
