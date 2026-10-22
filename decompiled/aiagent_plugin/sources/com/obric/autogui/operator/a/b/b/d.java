package com.obric.autogui.operator.a.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.h.b.z;
import d.m;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ax;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OpScrollWheelAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autogui.operator.a.b {
    private static final String TAG = "Op-ScrollWheel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f29543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.operator.a.c.b f29544d;

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    public static final class b implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m<Float, Float> f29545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29546b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29545a, r6.f29545a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29546b, r6.f29546b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29545a.hashCode() * 31) + this.f29546b.hashCode();
        }

        public String toString() {
            return "Input(position=" + this.f29545a + ", target=" + this.f29546b + ')';
        }

        public b(m<Float, Float> r2, String r3) {
            o.e(r2, "position");
            o.e(r3, "target");
            this.f29545a = r2;
            this.f29546b = r3;
        }

        public final m<Float, Float> a() {
            return this.f29545a;
        }

        public final String b() {
            return this.f29546b;
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f29547a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f29548b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f29549c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f29550e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f29551d;

        private static final /* synthetic */ c[] b() {
            return new c[]{f29547a, f29548b, f29549c};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f29551d = r3;
        }

        public final int a() {
            return this.f29551d;
        }

        static {
            f29547a = new c("UP", 0, -1);
            f29548b = new c("DOWN", 1, 1);
            f29549c = new c("UNKNOWN", 2, 0);
            c[] r0 = b();
            f29550e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f29550e.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    public static final class C0762d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f29553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c f29554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f29555d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0762d.class) == true) goto L8;
            return false;
        L8:
            C0762d r6 = (C0762d) ZeusTransformUtils.preCheckCast(r5, C0762d.class, "com.obric.aiagent.plugin");
            if (this.f29552a == r6.f29552a) goto L12;
            return false;
        L12:
            if (this.f29553b == r6.f29553b) goto L15;
            return false;
        L15:
            if (this.f29554c == r6.f29554c) goto L18;
            return false;
        L18:
            if (this.f29555d == r6.f29555d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f29552a) * 31) + Integer.hashCode(this.f29553b)) * 31) + this.f29554c.hashCode()) * 31) + Integer.hashCode(this.f29555d);
        }

        public String toString() {
            return "ScrollStep(beforeValue=" + this.f29552a + ", afterValue=" + this.f29553b + ", direction=" + this.f29554c + ", valueChange=" + this.f29555d + ')';
        }

        public C0762d(int r2, int r3, c r4, int r5) {
            o.e(r4, "direction");
            this.f29552a = r2;
            this.f29553b = r3;
            this.f29554c = r4;
            this.f29555d = r5;
        }

        public /* synthetic */ C0762d(int r1, int r2, c r3, int r4, int r5, d.h.b.h r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = r2 - r1;
        L5:
            this(r1, r2, r3, r4);
        }

        public final int a() {
            return this.f29555d;
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    private static final class e {
        private static final String TAG = "ScrollWheelOCRHelper";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29556a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IBaseModel f29557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.b.b f29558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f29559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.b.f f29560e;

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        private static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f29561a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f29562b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f29563c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f29564d;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (this.f29561a == r6.f29561a) goto L12;
                return false;
            L12:
                if (this.f29562b == r6.f29562b) goto L15;
                return false;
            L15:
                if (this.f29563c == r6.f29563c) goto L18;
                return false;
            L18:
                if (this.f29564d == r6.f29564d) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.f29561a) * 31) + Integer.hashCode(this.f29562b)) * 31) + Integer.hashCode(this.f29563c)) * 31) + Integer.hashCode(this.f29564d);
            }

            public String toString() {
                return "CropParameters(left=" + this.f29561a + ", top=" + this.f29562b + ", width=" + this.f29563c + ", height=" + this.f29564d + ')';
            }

            public b(int r1, int r2, int r3, int r4) {
                this.f29561a = r1;
                this.f29562b = r2;
                this.f29563c = r3;
                this.f29564d = r4;
            }

            public final int a() {
                return this.f29561a;
            }

            public final int b() {
                return this.f29562b;
            }

            public final int c() {
                return this.f29563c;
            }

            public final int d() {
                return this.f29564d;
            }

            public final boolean e() {
                if (this.f29563c > 0) goto L5;
            L7:
                return false;
            L5:
                if (this.f29564d <= 0) goto L7;
                return true;
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        private static final enum c extends Enum<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f29565a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f29566b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ c[] f29567c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ d.d.a f29568d = null;

            private static final /* synthetic */ c[] a() {
                return new c[]{f29565a, f29566b};
            }

            private c(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f29565a = new c("CURRENT_VALUE", 0);
                f29566b = new c("STEP_ANALYSIS", 1);
                c[] r0 = a();
                f29567c = r0;
                f29568d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            public static c valueOf(String r2) {
                return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
            }

            public static c[] values() {
                return (c[]) ZeusTransformUtils.preCheckCast(f29567c.clone(), c[].class, "com.obric.aiagent.plugin");
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.b.d$e$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        public static final class C0763d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f29569a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f29570b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Integer f29571c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Object f29572d;

            public static /* synthetic */ C0763d a(C0763d r0, boolean r1, String r2, Integer r3, Object r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.f29569a;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.f29570b;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.f29571c;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.f29572d;
            L15:
                return r0.a(r1, r2, r3, r4);
            }

            public final C0763d a(boolean r1, String r2, Integer r3, Object r4) {
                return new C0763d(r1, r2, r3, r4);
            }

            public final void d() {
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0763d.class) == true) goto L8;
                return false;
            L8:
                C0763d r6 = (C0763d) ZeusTransformUtils.preCheckCast(r5, C0763d.class, "com.obric.aiagent.plugin");
                if (this.f29569a == r6.f29569a) goto L12;
                return false;
            L12:
                if (o.a(this.f29570b, r6.f29570b) == true) goto L15;
                return false;
            L15:
                if (o.a(this.f29571c, r6.f29571c) == true) goto L18;
                return false;
            L18:
                if (o.a(this.f29572d, r6.f29572d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                int r0 = Boolean.hashCode(this.f29569a) * 31;
                String r1 = this.f29570b;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Integer r5 = this.f29571c;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                Object r8 = this.f29572d;
                if (r8 == null) goto L15;
                r2 = r8.hashCode();
            L15:
                return r7 + r2;
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public String toString() {
                return "CurrentValueOCRResult(reachedTarget=" + this.f29569a + ", centerBoxText=" + this.f29570b + ", currentNumber=" + this.f29571c + ", screenshotResult=" + this.f29572d + ')';
            }

            public C0763d(boolean r1, String r2, Integer r3, Object r4) {
                this.f29569a = r1;
                this.f29570b = r2;
                this.f29571c = r3;
                this.f29572d = r4;
            }

            public /* synthetic */ C0763d(boolean r1, String r2, Integer r3, Object r4, int r5, d.h.b.h r6) {
                if ((r5 & 8) == 0) goto L5;
                r4 = null;
            L5:
                this(r1, r2, r3, r4);
            }

            public final boolean a() {
                return this.f29569a;
            }

            public final String b() {
                return this.f29570b;
            }

            public final Integer c() {
                return this.f29571c;
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.b.d$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        private static final class C0764e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f29573a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f29574b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final List<f> f29575c;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0764e.class) == true) goto L8;
                return false;
            L8:
                C0764e r6 = (C0764e) ZeusTransformUtils.preCheckCast(r5, C0764e.class, "com.obric.aiagent.plugin");
                if (o.a(this.f29573a, r6.f29573a) == true) goto L12;
                return false;
            L12:
                if (this.f29574b == r6.f29574b) goto L15;
                return false;
            L15:
                if (o.a(this.f29575c, r6.f29575c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                f r0 = this.f29573a;
                if (r0 != null) goto L5;
                int r1 = 0;
            L7:
                return (((r1 * 31) + Boolean.hashCode(this.f29574b)) * 31) + this.f29575c.hashCode();
            L5:
                r1 = r0.hashCode();
                goto L7
            }

            public String toString() {
                return "StandardOCRResult(targetTextBlock=" + this.f29573a + ", foundTarget=" + this.f29574b + ", allTextBlocks=" + this.f29575c + ')';
            }

            public C0764e(f r3, boolean r4, List<f> r5) {
                List<f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                o.e(r6, "allTextBlocks");
                this.f29573a = r3;
                this.f29574b = r4;
                this.f29575c = r6;
            }

            public final f a() {
                return this.f29573a;
            }

            public final boolean b() {
                return this.f29574b;
            }

            public final List<f> c() {
                return this.f29575c;
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        public static final class f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final float f29576a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f29577b;

            public final void b() {
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
                return false;
            L8:
                f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
                if (Float.compare(this.f29576a, r6.f29576a) == 0) goto L12;
                return false;
            L12:
                if (o.a(this.f29577b, r6.f29577b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = Float.hashCode(this.f29576a) * 31;
                Object r1 = this.f29577b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "StepAnalysisResult(recommendedStepDistance=" + this.f29576a + ", screenshotResult=" + this.f29577b + ')';
            }

            public f(float r1, Object r2) {
                this.f29576a = r1;
                this.f29577b = r2;
            }

            public /* synthetic */ f(float r1, Object r2, int r3, d.h.b.h r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = null;
            L5:
                this(r1, r2);
            }

            public final float a() {
                return this.f29576a;
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        public /* synthetic */ class g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f29578a = null;

            static {
                int[] r0 = new int[c.values().length];
                r0[c.f29565a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[c.f29566b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f29578a = r0;
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {1120}, d = "analyzeScrollStep", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction$ScrollWheelOCRHelper")
        static final class h extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29579a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f29580b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f29581c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f29582d;

            h(e r3, d.c.d<? super h> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29581c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29580b = r3;
                this.f29582d |= Integer.MIN_VALUE;
                return this.f29581c.a(0.0f, 0.0f, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class i<T> implements Comparator {
            public i() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin")).g()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin")).g()), Comparable.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {1394}, d = "parseOCRResults", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction$ScrollWheelOCRHelper")
        static final class j extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29583a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f29584b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29585c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f29586d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f29587e;
            /* synthetic */ Object f;
            final /* synthetic */ e g;
            int h;

            j(e r3, d.c.d<? super j> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                this.f = r11;
                this.h |= Integer.MIN_VALUE;
                return e.a(this.g, null, 0.0f, 0.0f, 0, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {1097}, d = "performCurrentValueOCR", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction$ScrollWheelOCRHelper")
        static final class k extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29588a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f29589b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f29590c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f29591d;

            k(e r3, d.c.d<? super k> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29590c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29589b = r3;
                this.f29591d |= Integer.MIN_VALUE;
                return this.f29590c.a(0.0f, 0.0f, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {1483}, d = "performEnhancedOCR", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction$ScrollWheelOCRHelper")
        static final class l extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29592a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29593b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29594c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f29595d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f29596e;
            /* synthetic */ Object f;
            final /* synthetic */ e g;
            int h;

            l(e r3, d.c.d<? super l> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                this.f = r8;
                this.h |= Integer.MIN_VALUE;
                return e.a(this.g, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {1221, 1245, 1277}, d = "performStandardOCR", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction$ScrollWheelOCRHelper")
        static final class m extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29597a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29598b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29599c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f29600d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f29601e;
            Object f;
            Object g;
            Object h;
            Object i;
            float j;
            float k;
            int l;
            /* synthetic */ Object m;
            final /* synthetic */ e n;
            int o;

            m(e r3, d.c.d<? super m> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.n = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                this.m = r8;
                this.o |= Integer.MIN_VALUE;
                return e.a(this.n, 0.0f, 0.0f, 0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            f29556a = new a(null);
        }

        /* JADX INFO: renamed from: lambda$0P_N-p8CCjM3-yCqonx-5kFpohQ, reason: not valid java name */
        public static /* synthetic */ CharSequence m833lambda$0P_Np8CCjM3yCqonx5kFpohQ(d.o.i r0) {
            return b(r0);
        }

        public static /* synthetic */ String lambda$8QfqjdUn29IEaz8K5CVNmAs0cx8(d.o.i r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$BNAEnAfPFTYG0Q2TnR-q7bFhmHE, reason: not valid java name */
        public static /* synthetic */ x m834lambda$BNAEnAfPFTYG0Q2TnRq7bFhmHE(z.f r0, z.f r1, String r2, z.f r3, boolean r4, Object r5, JSONObject r6) {
            return a(r0, r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: lambda$L8weZUUJZNQhXkjAL8-UiX3lV0s, reason: not valid java name */
        public static /* synthetic */ x m835lambda$L8weZUUJZNQhXkjAL8UiX3lV0s(Bitmap r0, Bundle r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ x lambda$aAUYekpwpGQqOoxjHqaPyZz8wJs(String r0, int r1, String r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ x lambda$biLa58FV0xn02e3Erfi0NDjTuVo(z.f r0, e r1, String r2, boolean r3, Object r4, JSONObject r5) {
            return a(r0, r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: lambda$da_amVnN79XRHLgY2vmk42MrP-c, reason: not valid java name */
        public static /* synthetic */ x m836lambda$da_amVnN79XRHLgY2vmk42MrPc(Bitmap r0, RequestParams r1) {
            return b(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$ga8EbAcphdn4UPO2e-fCOaUvIfg, reason: not valid java name */
        public static /* synthetic */ x m837lambda$ga8EbAcphdn4UPO2efCOaUvIfg(Bitmap r0, Bundle r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ x lambda$h8nKgwx2oWWh6nPRFwLYtMaOZso(String r0, z.f r1, int r2, String r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ x lambda$l8pp9Ct_pPgY5ovzOKHzP0JuM0g(Bitmap r0, RequestParams r1) {
            return a(r0, r1);
        }

        public e(IBaseModel r3, com.obric.autogui.operator.a.b.b.b r4, boolean r5) {
            IBaseModel r6 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r3, IBaseModel.class, "com.obric.aiagent.plugin");
            com.obric.autogui.operator.a.b.b.b r7 = (com.obric.autogui.operator.a.b.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.a.b.b.b.class, "com.obric.aiagent.plugin");
            o.e(r6, "model");
            o.e(r7, "imageProcessor");
            this.f29557b = r6;
            this.f29558c = r7;
            this.f29559d = r5;
            this.f29560e = new com.obric.autogui.operator.a.b.b.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(e r7, float r8, float r9, int r10, c r11, String r12, d.c.d r13) {
            return r7.a(r8, r9, r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(e r9, IBaseModel r10, Bitmap r11, f r12, b r13, String r14, d.c.d r15) {
            return r9.a((IBaseModel) ZeusTransformUtils.wrapperContextForParams(r10, IBaseModel.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(e r12, String r13, float r14, float r15, int r16, b r17, String r18, IBaseModel r19, Bitmap r20, d.c.d r21) {
            return r12.a(r13, r14, r15, r16, r17, r18, (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r19, IBaseModel.class, "com.obric.aiagent.plugin"), r20, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(float r10, float r11, int r12, d.c.d<? super C0763d> r13) {
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, k.class) == false) goto L7;
            k r0 = (k) ZeusTransformUtils.preCheckCast(r14, k.class, "com.obric.aiagent.plugin");
            if ((r0.f29591d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f29591d -= Integer.MIN_VALUE;
        L8:
            k r8 = r0;
            Object r15 = r8.f29589b;
            Object r1 = d.c.a.b.a();
            int r2 = r8.f29591d;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            e this = (e) ZeusTransformUtils.preCheckCast(r8.f29588a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L17:
            com.obric.autogui.common.d r16 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
            C0764e r17 = (C0764e) ZeusTransformUtils.preCheckCast(r16.a(), C0764e.class, "com.obric.aiagent.plugin");
            Integer r18 = null;
            if (r16.g() == false) goto L30;
            if (r17 == null) goto L30;
            boolean r3 = r17.b();
            f r19 = r17.a();
            if (r19 == null) goto L24;
            String r4 = r19.a();
        L25:
            f r110 = r17.a();
            if (r110 == null) goto L29;
            r18 = r110.a(this.f29559d);
        L29:
            return new C0763d(r3, r4, r18, null, 8, null);
        L24:
            r4 = null;
        L30:
            return null;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r15);
            c r6 = c.f29565a;
            r8.f29588a = this;
            r8.f29591d = 1;
            r15 = a(r10, r11, r12, r6, "获取当前值", r8);
            if (r15 != r1) goto L17;
            return r1;
        L7:
            r0 = new k(this, r14);
            goto L8
        }

        public final Object a(float r10, float r11, d.c.d<? super com.obric.autogui.common.d<f>> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, h.class) == false) goto L7;
            h r0 = (h) ZeusTransformUtils.preCheckCast(r13, h.class, "com.obric.aiagent.plugin");
            if ((r0.f29582d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f29582d -= Integer.MIN_VALUE;
        L8:
            h r8 = r0;
            Object r14 = r8.f29580b;
            Object r1 = d.c.a.b.a();
            int r2 = r8.f29582d;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            e this = (e) ZeusTransformUtils.preCheckCast(r8.f29579a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L17:
            com.obric.autogui.common.d r15 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
            C0764e r16 = (C0764e) ZeusTransformUtils.preCheckCast(r15.a(), C0764e.class, "com.obric.aiagent.plugin");
            if (r15.g() == false) goto L24;
            if (r16 == null) goto L24;
            d.h.b.h r3 = null;
            return com.obric.autogui.common.d.f29012a.a(new f(this.a(r16.c()), r3, 2, r3));
        L24:
            return com.obric.autogui.common.d.f29012a.a((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r14);
            c r6 = c.f29566b;
            r8.f29579a = this;
            r8.f29582d = 1;
            r14 = a(r10, r11, -1, r6, "分析滚轮步长", r8);
            if (r14 != r1) goto L17;
            return r1;
        L7:
            r0 = new h(this, r13);
            goto L8
        }

        private final float a(List<f> r13) {
            List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
            float r2 = 80.0f;
            if (r12.size() >= 2) goto L6;
            Loog.INSTANCE.d(TAG, "文本块数量不足，使用默认步长: 80.0");
            return 80.0f;
        L6:
            List r14 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new i(), Comparator.class, "com.obric.aiagent.plugin"));
            List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            int r3 = r14.size() - 1;
            int r6 = 0;
        L7:
            if (r6 >= r3) goto L9;
            int r7 = r6 + 1;
            float r8 = Math.abs(((f) ZeusTransformUtils.preCheckCast(r14.get(r7), f.class, "com.obric.aiagent.plugin")).g() - ((f) ZeusTransformUtils.preCheckCast(r14.get(r6), f.class, "com.obric.aiagent.plugin")).g());
            r15.add(Float.valueOf(r8));
            Loog.INSTANCE.d(TAG, "相邻文本距离: " + ((f) ZeusTransformUtils.preCheckCast(r14.get(r6), f.class, "com.obric.aiagent.plugin")).a() + " -> " + ((f) ZeusTransformUtils.preCheckCast(r14.get(r7), f.class, "com.obric.aiagent.plugin")).a() + " = " + r8);
            r6 = r7;
            goto L7
        L9:
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
            Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r18 = r16.iterator();
        L11:
            if (r18.hasNext() == false) goto L20;
            Object r4 = r18.next();
            float r9 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue();
            if (20.0f <= r9) goto L15;
        L17:
            boolean r10 = false;
        L18:
            if (r10 == false) goto L11;
            r17.add(r4);
            goto L11
        L15:
            if (r9 > 300.0f) goto L17;
            r10 = true;
            goto L18
        L20:
            List r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.d(TAG, "过滤后的距离列表: " + r19);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L23;
            r2 = (float) p.A((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin"));
        L23:
            float r110 = Math.max(r2, 60.0f);
            Loog.INSTANCE.i(TAG, "滚轮步长计算: 原始=" + ((int) r2) + "px, 最终=" + ((int) r110) + "px (最小=60.0)");
            return r110;
        }

        private final Object a(float r32, float r33, int r34, c r35, String r36, d.c.d<? super com.obric.autogui.common.d<C0764e>> r37) {
            d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, m.class) == false) goto L7;
            m r5 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");
            if ((r5.o & Integer.MIN_VALUE) == 0) goto L7;
            r5.o -= Integer.MIN_VALUE;
        L8:
            m r15 = r5;
            Object r4 = r15.m;
            Object r6 = d.c.a.b.a();
            int r7 = r15.o;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L21;
            if (r7 == 2) goto L20;
            if (r7 != 3) goto L19;
            int r1 = r15.l;
            float r8 = r15.k;
            float r9 = r15.j;
            z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r15.i, z.f.class, "com.obric.aiagent.plugin");
            z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r15.h, z.f.class, "com.obric.aiagent.plugin");
            Bitmap r12 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.g, Bitmap.class, "com.obric.aiagent.plugin");
            Bitmap r13 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.f, Bitmap.class, "com.obric.aiagent.plugin");
            b r14 = (b) ZeusTransformUtils.preCheckCast(r15.f29601e, b.class, "com.obric.aiagent.plugin");
            ScreenshotResult r16 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r15.f29600d, ScreenshotResult.class, "com.obric.aiagent.plugin");
            String r17 = (String) ZeusTransformUtils.preCheckCast(r15.f29599c, String.class, "com.obric.aiagent.plugin");
            c r2 = (c) ZeusTransformUtils.preCheckCast(r15.f29598b, c.class, "com.obric.aiagent.plugin");
            e r18 = (e) ZeusTransformUtils.preCheckCast(r15.f29597a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r4);     // Catch: Exception -> L16
            c r19 = r2;
            z.f r110 = r10;
            int r20 = r1;
            float r21 = r9;
            Object r22 = r4;
            String r111 = TAG;
            e r23 = r18;
            String r24 = "com.obric.aiagent.plugin";
        L90:
            int r27 = r20;
            float r26 = r8;
            float r25 = r21;
            String r28 = r17;
            b r29 = r14;
            ScreenshotResult r30 = r16;
            c r210 = r19;
            final z.f r112 = r110;
            C0764e r113 = (C0764e) ZeusTransformUtils.preCheckCast(r22, C0764e.class, r24);     // Catch: Exception -> L60
            e r114 = r23;
            Bitmap r0 = r12;
            final z.f r31 = r11;
        L75:
            String r38 = (String) ZeusTransformUtils.preCheckCast(r112.f38504a, String.class, r24);
            if (r38 == null) goto L80;
            return com.obric.autogui.common.d.f29012a.a(r38);
        L80:
            if (r31.f38504a == 0) goto L83;
            if (r113 == null) goto L83;
            T r39 = r31.f38504a;
            o.a(r39);
            r114.a(r13, r0, (JSONArray) ZeusTransformUtils.preCheckCast(r39, JSONArray.class, r24), r113, r29, r25, r26, r27, r28, r210);
        L83:
            r13.recycle();
            r0.recycle();
            IScreenshot r40 = r30.getPic();
            if (r40 == null) goto L87;
            r40.release();
        L87:
            return com.obric.autogui.common.d.f29012a.a(r113);
        L60:
            e = e;
            r9 = r21;
            r10 = r110;
        L73:
            Loog.INSTANCE.e(r111, r17 + ": 解析OCR结果失败: " + e.getMessage());
            r10.f38504a = "ocr_f_par";
            r27 = r20;
            r114 = r23;
            r26 = r8;
            r25 = r9;
            r0 = r12;
            r28 = r17;
            r29 = r14;
            r210 = r19;
            r113 = null;
            r112 = r10;
            r31 = r11;
            r30 = r16;
        L16:
            e = e;
            r19 = r2;
            r111 = TAG;
            r20 = r1;
            r23 = r18;
            r24 = "com.obric.aiagent.plugin";
            goto L73
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            int r41 = r15.l;
            float r42 = r15.k;
            float r43 = r15.j;
            Bitmap r44 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.g, Bitmap.class, "com.obric.aiagent.plugin");
            Bitmap r45 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.f, Bitmap.class, "com.obric.aiagent.plugin");
            b r46 = (b) ZeusTransformUtils.preCheckCast(r15.f29601e, b.class, "com.obric.aiagent.plugin");
            ScreenshotResult r115 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r15.f29600d, ScreenshotResult.class, "com.obric.aiagent.plugin");
            String r116 = (String) ZeusTransformUtils.preCheckCast(r15.f29599c, String.class, "com.obric.aiagent.plugin");
            c r117 = (c) ZeusTransformUtils.preCheckCast(r15.f29598b, c.class, "com.obric.aiagent.plugin");
            e r47 = (e) ZeusTransformUtils.preCheckCast(r15.f29597a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r4);
            float r118 = r43;
            r111 = TAG;
            final String r119 = r116;
            float r48 = r42;
            Bitmap r120 = r44;
            r30 = r115;
            int r49 = r41;
            Bitmap r121 = r45;
            b r50 = r46;
            Object r51 = r4;
            e r52 = r47;
            c r53 = r117;
            Object r122 = r6;
        L41:
            r24 = "com.obric.aiagent.plugin";
            Response r54 = (Response) ZeusTransformUtils.preCheckCast(r51, Response.class, r24);
            r31 = new z.f();
            final z.f r55 = new z.f();
            Object r310 = r122;
            r112 = new z.f();
            int r123 = r49;
            if (r54 == null) goto L47;
            Response r56 = ResponseKt.ok(r54, new $$Lambda$d$e$BNAEnAfPFTYG0Q2TnRq7bFhmHE(r31, r55, r119, r112));
            if (r56 == null) goto L47;
            ResponseKt.fail(r56, new $$Lambda$d$e$h8nKgwx2oWWh6nPRFwLYtMaOZso(r119, r112));
        L47:
            if (r55.f38504a != 0) goto L92;
            Bitmap r211 = r120;
            c r124 = r53;
            r24 = r24;
            r25 = r118;
            r26 = r48;
            r27 = r123;
            r210 = r124;
            r29 = r50;
            r13 = r121;
            r28 = r119;
            r0 = r211;
            r113 = null;
            r114 = r52;
            goto L75
        L92:
            T r57 = r55.f38504a;     // Catch: Exception -> L69
            o.a(r57);     // Catch: Exception -> L69
            String r58 = (String) ZeusTransformUtils.preCheckCast(r57, String.class, r24);     // Catch: Exception -> L69
            IBaseModel r59 = r52.f29557b;     // Catch: Exception -> L69
            r15.f29597a = r52;     // Catch: Exception -> L69
            r15.f29598b = r53;     // Catch: Exception -> L69
            r15.f29599c = r119;     // Catch: Exception -> L69
            r15.f29600d = r30;     // Catch: Exception -> L69
            r15.f29601e = r50;     // Catch: Exception -> L69
            r15.f = r121;     // Catch: Exception -> L69
            r15.g = r120;     // Catch: Exception -> L69
            r15.h = r31;     // Catch: Exception -> L69
            r15.i = r112;     // Catch: Exception -> L69
            r15.j = r118;     // Catch: Exception -> L69
            r15.k = r48;     // Catch: Exception -> L69
            int r60 = r123;
            r15.l = r60;     // Catch: Exception -> L66
            r19 = r53;
            r15.o = 3;     // Catch: Exception -> L64
            r24 = r24;
            e r61 = r52;
            r30 = r30;
            r50 = r50;
            r31 = r31;
            r121 = r121;
            r119 = r119;
            r120 = r120;
            r52 = r52;
            r111 = r111;
            r110 = r112;
            r118 = r118;
            r22 = r61.a(r58, r118, r48, r60, r50, r119, r59, r121, r15);     // Catch: Exception -> L62
            if (r22 != r310) goto L57;
            return r310;
        L57:
            r21 = r118;
            r20 = r60;
            r16 = r30;
            r14 = r50;
            r11 = r31;
            r13 = r121;
            r17 = r119;
            r12 = r120;
            r8 = r48;
            r23 = r52;
        L62:
            e = e;
        L72:
            r9 = r118;
            r20 = r60;
            r16 = r30;
            r14 = r50;
            r10 = r110;
            r11 = r31;
            r13 = r121;
            r17 = r119;
            r12 = r120;
            r8 = r48;
            r23 = r52;
        L64:
            e = e;
        L71:
            r110 = r112;
        L66:
            e = e;
            r19 = r53;
        L69:
            e = e;
            r60 = r123;
            r19 = r53;
            goto L71
        L21:
            int r62 = r15.l;
            float r63 = r15.k;
            float r64 = r15.j;
            String r65 = (String) ZeusTransformUtils.preCheckCast(r15.f29599c, String.class, "com.obric.aiagent.plugin");
            c r66 = (c) ZeusTransformUtils.preCheckCast(r15.f29598b, c.class, "com.obric.aiagent.plugin");
            e r67 = (e) ZeusTransformUtils.preCheckCast(r15.f29597a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r4);
            c r125 = r66;
            Object r68 = r4;
            float r69 = r64;
            int r70 = r62;
        L26:
            ScreenshotResult r71 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r68, ScreenshotResult.class, "com.obric.aiagent.plugin");
            IScreenshot r72 = r71.getPic();
            if (r71.ok() == false) goto L88;
            if (r72 == null) goto L88;
            Bitmap r73 = r67.a(r72.getBitmap());
            b r126 = r67.a(r69, r63, r125, r73.getWidth(), r73.getHeight());
            if (r126.e() == true) goto L37;
            Loog.INSTANCE.e(TAG, r65 + ": 裁剪区域无效");
            IScreenshot r74 = r71.getPic();
            if (r74 == null) goto L36;
            r74.release();
        L36:
            return com.obric.autogui.common.d.f29012a.a("invl_crp");
        L37:
            Loog.INSTANCE.d(TAG, r65 + " OCR裁剪参数: 目标点=(" + r69 + ", " + r63 + "), 裁剪区域=(" + r126.a() + ", " + r126.b() + ", " + r126.c() + ", " + r126.d() + ')');
            Bitmap r75 = Bitmap.createBitmap(r73, r126.a(), r126.b(), r126.c(), r126.d());
            o.c(r75, "createBitmap(...)");
            final Bitmap r76 = r67.f29558c.a(r75);
            IBaseModel r77 = r67.f29557b;
            RequestParams r127 = new RequestParams(null, new $$Lambda$d$e$l8pp9Ct_pPgY5ovzOKHzP0JuM0g(r76), 1, null);
            r15.f29597a = r67;
            r15.f29598b = r125;
            r15.f29599c = r65;
            r15.f29600d = r71;
            r15.f29601e = r126;
            r15.f = r75;
            r15.g = r76;
            r15.j = r69;
            r15.k = r63;
            r15.l = r70;
            r15.o = 2;
            r51 = r77.infer(r127, r15);
            r122 = r6;
            if (r51 != r122) goto L40;
            return r122;
        L40:
            r120 = r76;
            r119 = r65;
            r30 = r71;
            r50 = r126;
            r121 = r75;
            r48 = r63;
            r49 = r70;
            float r311 = r69;
            r52 = r67;
            r53 = r125;
            r118 = r311;
        L88:
            Loog.INSTANCE.e(TAG, r65 + ": 无法获取屏幕截图");
            return com.obric.autogui.common.d.f29012a.a("scrsht_f");
        L22:
            d.o.a(r4);
            com.obric.autogui.agents.vlm.models.a.a r78 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1.0f), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
            String r79 = r36 + '_' + System.currentTimeMillis();
            r15.f29597a = this;
            r125 = r35;
            r15.f29598b = r125;
            r15.f29599c = r36;
            r69 = r32;
            r15.j = r69;
            r15.k = r33;
            r15.l = r34;
            r15.o = 1;
            Object r80 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r78, r79, null, false, false, r15, 14, null);
            if (r80 != r6) goto L25;
            return r6;
        L25:
            r70 = r34;
            r65 = r36;
            r68 = r80;
            r67 = this;
            r63 = r33;
        L7:
            r5 = new m(this, r3);
            goto L8
        }

        private static final x a(final Bitmap r1, RequestParams r2) {
            o.e(r2, "$this$RequestParams");
            ParamsKt.setCustomArgs(r2, new $$Lambda$d$e$ga8EbAcphdn4UPO2efCOaUvIfg(r1));
            return x.f38692a;
        }

        private static final x a(Bitmap r2, Bundle r3) {
            o.e(r3, "$this$setCustomArgs");
            r3.putBoolean("useCloud", false);
            r3.putParcelable("bitmapObject", (Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.aiagent.plugin"));
            r3.putInt(IdlKeys.Args_Priority, 1);
            r3.putInt(IdlKeys.Args_Force_Execute, 1);
            return x.f38692a;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, org.json.JSONArray] */
        private static final x a(z.f r0, z.f r1, String r2, z.f r3, boolean r4, Object r5, JSONObject r6) {
            o.e(r6, "<unused var>");
            r0.f38504a = new JSONArray(String.valueOf(r5));     // Catch: Exception -> L5
            r1.f38504a = String.valueOf(r5);     // Catch: Exception -> L5
        L8:
            return x.f38692a;
        L5:
            e = move-exception;
            Loog.INSTANCE.e(TAG, r2 + ": 解析OCR结果失败: " + e.getMessage());
            r3.f38504a = "ocr_f_json_arrf";
            goto L8
        }

        /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.String] */
        private static final x a(String r1, z.f r2, int r3, String r4, JSONObject r5) {
            o.e(r4, "errInfo");
            o.e(r5, "<unused var>");
            Loog.INSTANCE.e(TAG, r1 + " OCR识别失败: " + r3 + ", " + r4);
            r2.f38504a = "ocr_f_aik_f_" + r3;
            return x.f38692a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r12v15 */
        /* JADX WARN: Type inference failed for: r12v16 */
        /* JADX WARN: Type inference failed for: r12v17 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v23 */
        /* JADX WARN: Type inference failed for: r12v24 */
        /* JADX WARN: Type inference failed for: r12v25 */
        /* JADX WARN: Type inference failed for: r12v26 */
        /* JADX WARN: Type inference failed for: r12v27 */
        /* JADX WARN: Type inference failed for: r12v28 */
        /* JADX WARN: Type inference failed for: r48v0, types: [com.obric.autogui.operator.a.b.b.d$e] */
        private final Object a(String r49, float r50, float r51, int r52, b r53, String r54, IBaseModel r55, Bitmap r56, d.c.d<? super C0764e> r57) {
            int r8 = r52;
            String r9 = r54;
            String r3 = "";
            String r10 = "com.obric.aiagent.plugin";
            IBaseModel r4 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r55, IBaseModel.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r57, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L7;
            j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
            if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
            r6.h -= Integer.MIN_VALUE;
        L8:
            j r7 = r6;
            Object r11 = r7.f;
            Object r12 = d.c.a.b.a();
            int r13 = r7.h;
            String r14 = "✅ ";
            if (r13 == 0) goto L18;
            if (r13 != 1) goto L17;
            int r0 = r7.f29584b;
            int r1 = r7.f29583a;
            f r2 = (f) ZeusTransformUtils.preCheckCast(r7.f29587e, f.class, "com.obric.aiagent.plugin");
            List r15 = (List) ZeusTransformUtils.preCheckCast(r7.f29586d, List.class, "com.obric.aiagent.plugin");
            String r16 = (String) ZeusTransformUtils.preCheckCast(r7.f29585c, String.class, "com.obric.aiagent.plugin");
            d.o.a(r11);     // Catch: Exception -> L14
            r8 = r1;
            f r19 = r2;
            r9 = r16;
            String r17 = "✅ ";
            boolean r18 = true;
            ?? r110 = r0;
            String r20 = "com.obric.aiagent.plugin";
        L93:
            Integer r21 = (Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, r20);     // Catch: Exception -> L122
            if (r21 == null) goto L102;
            f r22 = f.a(r19, r21.toString(), 0, 0, 0, 0, 0.0f, 0.0f, 126, null);     // Catch: Exception -> L122
            ?? r111 = r110;
            if (r8 == (-1)) goto L100;
            r111 = r110;
            if (r21.intValue() != r8) goto L100;
            r111 = r18;
        L100:
            Loog.INSTANCE.i(TAG, r17 + r9 + " 补充OCR成功: 增强识别结果=" + r21);     // Catch: Exception -> L122
            List r112 = r15;
            ?? r113 = r111;
        L101:
            ?? r114 = r113;
        L117:
            if (r114 != 0) goto L120;
            r18 = false;
        L120:
            return new C0764e(r22, r18, r112);
        L122:
            Exception e2 = e;
        L123:
            Loog.INSTANCE.e(TAG, r9 + " OCR结果解析失败: " + e2.getMessage());
            return new C0764e(null, false, p.b());
        L102:
            Loog.INSTANCE.w(TAG, "❌ " + r9 + " 补充OCR失败，将作为0处理");     // Catch: Exception -> L122
            r112 = r15;
            r114 = r110 == true ? 1 : 0;
            r22 = r19;
        L14:
            e2 = e;
            r9 = r16;
            goto L123
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r11);
            JSONArray r23 = new JSONArray(r49);     // Catch: Exception -> L122
            r112 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L122
            List r24 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L122
            int r115 = r23.length();     // Catch: Exception -> L122
            boolean r410 = false;
            f r25 = null;
            int r116 = 0;
        L21:
            String r26 = r14;
            List r27 = r24;
            if (r116 >= r115) goto L76;
            int r28 = r115;
            JSONObject r117 = r23.getJSONObject(r116);     // Catch: Exception -> L122
            JSONArray r29 = r23;
            String r30 = r117.getString("text");     // Catch: Exception -> L122
            o.a(r30);     // Catch: Exception -> L122
            int r210 = r116;
            String r118 = d.o.o.a(d.o.o.a(r30, 'O', '0', false, 4, null), 'o', '0', false, 4, null);     // Catch: Exception -> L122
            JSONArray r119 = r117.getJSONArray("region");     // Catch: Exception -> L122
            String r211 = r3;
            JSONArray r31 = r119.getJSONArray(0);     // Catch: Exception -> L122
            String r212 = r10;
            f r120 = new f(r118, r31.getInt(0) + r53.a(), r31.getInt(1) + r53.b(), r119.getJSONArray(1).getInt(0) + r53.a(), r119.getJSONArray(3).getInt(1) + r53.b(), 0.0f, 0.0f, 96, null);     // Catch: Exception -> L122
            r112.add(r120);     // Catch: Exception -> L122
            boolean r32 = r120.a(r50, r51);     // Catch: Exception -> L122
            if (r32 == false) goto L27;
        L35:
            boolean r33 = false;
        L36:
            if (r32 == true) goto L40;
            if (r33 == true) goto L40;
            boolean r34 = false;
        L41:
            if (r34 == false) goto L56;
            if (r25 != null) goto L56;
            if (r8 == (-1)) goto L51;
            Integer r35 = r120.a(this.f29559d);     // Catch: Exception -> L122
            if (r35 == null) goto L48;
            int r36 = r35.intValue();     // Catch: Exception -> L122
        L49:
            if (r36 != r8) goto L51;
            boolean r37 = true;
        L52:
            if (r32 == false) goto L54;
            String r38 = "精确匹配";
        L55:
            Loog.INSTANCE.d(TAG, "🎯 " + r9 + " 找到目标点box(" + r38 + "): 文本='" + r118 + "', 坐标=(" + r120.b() + ", " + r120.c() + '-' + r120.e() + ')');     // Catch: Exception -> L122
            f r39 = r120;
        L58:
            if (o.a(r30, r118) == true) goto L60;
            String r40 = r30 + 8594 + r118;     // Catch: Exception -> L122
        L61:
            Object r41 = r120.a(this.f29559d);     // Catch: Exception -> L122
            d.o.k r121 = new d.o.k("\\d");     // Catch: Exception -> L122
            f r310 = r39;
            CharSequence r122 = (CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, r212);     // Catch: Exception -> L122
            boolean r213 = r37;
            String r42 = d.n.m.a(d.n.m.d(d.o.k.b(r121, r122, 0, 2, null), $$Lambda$d$e$8QfqjdUn29IEaz8K5CVNmAs0cx8.INSTANCE), (CharSequence) ZeusTransformUtils.preCheckCast(r211, CharSequence.class, r212), null, null, 0, null, null, 62, null);     // Catch: Exception -> L122
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r42, CharSequence.class, r212)).length() <= 0) goto L64;
            boolean r123 = true;
        L65:
            if (r123 == false) goto L70;
            StringBuilder r43 = new StringBuilder().append(r42).append(8594);     // Catch: Exception -> L122
            if (r41 != null) goto L69;
            r41 = "null";
        L69:
            String r44 = r43.append(r41).toString();     // Catch: Exception -> L122
        L71:
            StringBuilder r45 = new StringBuilder().append("原始='").append(r40).append("', 数字=").append(r44).append(", box=(").append(r120.b()).append(',').append(r120.c()).append('-').append(r120.e()).append(')');     // Catch: Exception -> L122
            if (r34 == false) goto L74;
            String r46 = " ★中心";
        L75:
            r27.add(r45.append(r46).toString());     // Catch: Exception -> L122
            r116 = r210 + 1;     // Catch: Exception -> L122
            r10 = r212;
            r3 = r211;
            r24 = r27;
            r14 = r26;
            r115 = r28;
            r23 = r29;
            r410 = r213;
            r25 = r310;
            goto L21
        L74:
            r46 = r211;
            goto L75
        L70:
            r44 = "无数字";
            goto L71
        L64:
            r123 = false;
            goto L65
        L60:
            r40 = r118;
            goto L61
        L54:
            r38 = "容错匹配";
            goto L55
        L48:
            r36 = 0;
        L51:
            r37 = r410;
        L56:
            r39 = r25;
            r37 = r410;
        L40:
            r34 = true;
            goto L41
        L27:
            if (r50 < (r120.b() - 10.0f)) goto L35;
            if (r50 > (r120.d() + 10.0f)) goto L35;
            if (r51 < (r120.c() - 10.0f)) goto L35;
            if (r51 > (r120.e() + 10.0f)) goto L35;
            r33 = true;
            goto L36
        L76:
            String r47 = r10;
            Loog.INSTANCE.i(TAG, r9 + " OCR识别结果: " + p.a((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, r47), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, r47), null, null, 0, null, null, 62, null));     // Catch: Exception -> L122
            if (r25 == null) goto L104;
            Loog r48 = Loog.INSTANCE;     // Catch: Exception -> L122
            r17 = r26;
            StringBuilder r58 = new StringBuilder().append(r17).append(r9).append(" 中心box识别: 原始='").append(r25.a()).append("', 数字=");     // Catch: Exception -> L122
            Integer r59 = r25.a(this.f29559d);     // Catch: Exception -> L122
            if (r59 == null) goto L81;
            int r60 = r59.intValue();     // Catch: Exception -> L122
        L82:
            r48.i(TAG, r58.append(r60).toString());     // Catch: Exception -> L122
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r25.a(), CharSequence.class, r47)).length() != 0) goto L85;
            boolean r61 = true;
        L86:
            if (r61 == true) goto L88;
        L103:
            r18 = true;
            r114 = r410;
            r22 = r25;
            goto L117
        L88:
            if (f.a(r25, false, 1, null) != null) goto L103;
            Loog.INSTANCE.w(TAG, "🔍 " + r9 + " 中心box文本为空，尝试补充OCR增强识别");     // Catch: Exception -> L122
            r7.f29585c = r9;     // Catch: Exception -> L122
            r7.f29586d = r112;     // Catch: Exception -> L122
            r7.f29587e = r25;     // Catch: Exception -> L122
            r7.f29583a = r8;     // Catch: Exception -> L122
            boolean r124 = r410;
            r7.f29584b = r124 ? 1 : 0;     // Catch: Exception -> L122
            r18 = true;
            r7.h = 1;     // Catch: Exception -> L122
            r20 = r47;
            f r311 = r25;
            r11 = a(r4, r56, r25, r53, r54, r7);     // Catch: Exception -> L122
            if (r11 != r12) goto L92;
            return r12;
        L92:
            r15 = r112;
            r19 = r311;
            r110 = r124;
            goto L93
        L85:
            r61 = false;
            goto L86
        L81:
            r60 = 0;
            goto L82
        L104:
            boolean r125 = r410;
            r18 = true;
            Loog.INSTANCE.w(TAG, "❌ " + r9 + " 未找到目标点(" + r50 + ", " + r51 + ")对应的OCR box");     // Catch: Exception -> L122
            r22 = a(r112, r50, r51);     // Catch: Exception -> L122
            r113 = r125;
            if (r22 == null) goto L101;
            r113 = r125;
            if (r8 == (-1)) goto L101;
            Integer r62 = r22.a(this.f29559d);     // Catch: Exception -> L122
            if (r62 == null) goto L111;
            int r63 = r62.intValue();     // Catch: Exception -> L122
        L112:
            if (r63 != r8) goto L114;
            boolean r126 = true;
        L115:
            Loog.INSTANCE.w(TAG, "🎯 " + r9 + " 使用最近的数字box作为备选: 原始='" + r22.a() + "', 数字=" + r63);     // Catch: Exception -> L122
            r114 = r126;
            goto L117
        L114:
            r126 = r125 ? 1 : 0;
            goto L115
        L111:
            r63 = 0;
        L7:
            r6 = new j(this, r5);
            goto L8
        }

        private static final String a(d.o.i r2) {
            d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
            o.e(r3, "it");
            return r3.b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v5 */
        private final Object a(IBaseModel r22, Bitmap r23, f r24, b r25, String r26, d.c.d<? super Integer> r27) {
            IBaseModel r2 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r22, IBaseModel.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, l.class) == false) goto L7;
            l r5 = (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.aiagent.plugin");
            if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
            r5.h -= Integer.MIN_VALUE;
        L8:
            Object r6 = r5.f;
            String r7 = d.c.a.b.a();
            int r8 = r5.h;
            if (r8 == 0) goto L18;
            if (r8 != 1) goto L17;
            Bitmap r0 = (Bitmap) ZeusTransformUtils.preCheckCast(r5.f29596e, Bitmap.class, "com.obric.aiagent.plugin");
            Bitmap r1 = (Bitmap) ZeusTransformUtils.preCheckCast(r5.f29595d, Bitmap.class, "com.obric.aiagent.plugin");
            Bitmap r3 = (Bitmap) ZeusTransformUtils.preCheckCast(r5.f29594c, Bitmap.class, "com.obric.aiagent.plugin");
            final String r9 = (String) ZeusTransformUtils.preCheckCast(r5.f29593b, String.class, "com.obric.aiagent.plugin");
            e r10 = (e) ZeusTransformUtils.preCheckCast(r5.f29592a, e.class, "com.obric.aiagent.plugin");
            d.o.a(r6);     // Catch: Exception -> L14
            Bitmap r11 = r3;
            Bitmap r12 = r1;
            final e r13 = r10;
        L30:
            Response r14 = (Response) ZeusTransformUtils.preCheckCast(r6, Response.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
            final z.f r15 = new z.f();     // Catch: Exception -> L14
            if (r14 == null) goto L35;
            Response r16 = ResponseKt.ok(r14, new $$Lambda$d$e$biLa58FV0xn02e3Erfi0NDjTuVo(r15, r13, r9));     // Catch: Exception -> L14
            if (r16 == null) goto L35;
            ResponseKt.fail(r16, new $$Lambda$d$e$aAUYekpwpGQqOoxjHqaPyZz8wJs(r9));     // Catch: Exception -> L14
        L35:
            r11.recycle();     // Catch: Exception -> L14
            r12.recycle();     // Catch: Exception -> L14
            r0.recycle();     // Catch: Exception -> L14
            return r15.f38504a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r6);
            int r17 = d.i.a.a(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics()));     // Catch: Exception -> L42
            int r18 = r24.b() - r25.a();     // Catch: Exception -> L42
            int r19 = r24.c() - r25.b();     // Catch: Exception -> L42
            int r110 = r24.d() - r25.a();     // Catch: Exception -> L42
            int r111 = r24.e() - r25.b();     // Catch: Exception -> L42
            int r112 = r111 - r19;     // Catch: Exception -> L42
            int r113 = (int) (r112 * 1.5f);     // Catch: Exception -> L42
            int r114 = (r113 - r112) / 2;     // Catch: Exception -> L42
            int r20 = Math.max(0, r18 - r17);     // Catch: Exception -> L42
            int r21 = Math.max(0, r19 - r114);     // Catch: Exception -> L42
            int r28 = Math.min(r23.getWidth(), r110 + r17);     // Catch: Exception -> L42
            int r115 = Math.min(r23.getHeight(), r113 + r19);     // Catch: Exception -> L42
            int r116 = r28 - r20;     // Catch: Exception -> L42
            int r29 = r115 - r21;     // Catch: Exception -> L42
            l r117 = r5;
            Loog.INSTANCE.d(TAG, r26 + " 增强OCR区域: bbox=(" + r18 + ',' + r19 + '-' + r110 + ',' + r111 + "), 增强区域=(" + r20 + ',' + r21 + '-' + r28 + ',' + r115 + ')');     // Catch: Exception -> L40
            if (r116 <= 0) goto L37;
            if (r29 <= 0) goto L37;
            Bitmap r30 = Bitmap.createBitmap(r23, r20, r21, r116, r29);     // Catch: Exception -> L40
            o.c(r30, "createBitmap(...)");     // Catch: Exception -> L40
            r13 = this;
            Bitmap r31 = r13.a(r30, r30.getPixel(0, 0), r17, r114);     // Catch: Exception -> L40
            final Bitmap r32 = r13.f29558c.a(r31);     // Catch: Exception -> L40
            RequestParams r33 = new RequestParams(null, new $$Lambda$d$e$da_amVnN79XRHLgY2vmk42MrPc(r32), 1, null);     // Catch: Exception -> L40
            r117.f29592a = r13;     // Catch: Exception -> L40
            r9 = r26;
            r117.f29593b = r9;     // Catch: Exception -> L14
            r117.f29594c = r30;     // Catch: Exception -> L14
            r117.f29595d = r31;     // Catch: Exception -> L14
            r117.f29596e = r32;     // Catch: Exception -> L14
            r117.h = 1;     // Catch: Exception -> L14
            r6 = r2.infer(r33, r117);     // Catch: Exception -> L14
            if (r6 != r7) goto L29;
            return r7;
        L29:
            r12 = r31;
            r0 = r32;
            r11 = r30;
        L37:
            Loog.INSTANCE.w(TAG, r26 + " 增强区域无效: " + r116 + 215 + r29);     // Catch: Exception -> L14
            return null;
        L40:
            e = e;
            r7 = r26;
        L44:
            Loog.INSTANCE.e(TAG, r7 + " 增强OCR执行异常: " + e.getMessage());
            return null;
        L42:
            e = e;
            r7 = r26;
        L14:
            e = e;
        L7:
            r5 = new l(this, r4);
            goto L8
        }

        private static final x b(final Bitmap r1, RequestParams r2) {
            o.e(r2, "$this$RequestParams");
            ParamsKt.setCustomArgs(r2, new $$Lambda$d$e$L8weZUUJZNQhXkjAL8UiX3lV0s(r1));
            return x.f38692a;
        }

        private static final x b(Bitmap r2, Bundle r3) {
            o.e(r3, "$this$setCustomArgs");
            r3.putParcelable("bitmapObject", (Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.aiagent.plugin"));
            r3.putBoolean("recOnly", true);
            r3.putBoolean("useCloud", false);
            r3.putInt(IdlKeys.Args_Priority, 1);
            r3.putInt(IdlKeys.Args_Force_Execute, 1);
            return x.f38692a;
        }

        /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.Integer] */
        private static final x a(z.f r21, e r22, String r23, boolean r24, Object r25, JSONObject r26) {
            o.e(r26, "<unused var>");
            JSONArray r5 = new JSONArray(String.valueOf(r25));     // Catch: Exception -> L7
            if (r5.length() <= 0) goto L10;
            JSONObject r6 = r5.getJSONObject(0);     // Catch: Exception -> L7
            String r7 = r6.getString("text");     // Catch: Exception -> L7
            o.c(r7, "getString(...)");     // Catch: Exception -> L7
            String r8 = d.o.o.a(d.o.o.a(r7, 'O', '0', false, 4, null), 'o', '0', false, 4, null);     // Catch: Exception -> L7
            String r2 = d.n.m.a(d.o.k.b(new d.o.k("\\d+"), (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$e$0P_Np8CCjM3yCqonx5kFpohQ.INSTANCE, 30, null);     // Catch: Exception -> L7
            r21.f38504a = f.f29602a.a(r8, r22.f29559d);     // Catch: Exception -> L7
            Loog.INSTANCE.d(TAG, r23 + " 增强OCR识别: 原始='" + r6.getString("text") + "', 修正='" + r8 + "', 数字='" + r2 + "'→" + r21.f38504a);     // Catch: Exception -> L7
        L10:
            return x.f38692a;
        L7:
            e = move-exception;
            Loog.INSTANCE.e(TAG, r23 + " 增强OCR结果解析失败: " + e.getMessage());
            goto L10
        }

        private static final CharSequence b(d.o.i r2) {
            d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
            o.e(r3, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
        }

        private static final x a(String r1, int r2, String r3, JSONObject r4) {
            o.e(r3, "errInfo");
            o.e(r4, "<unused var>");
            Loog.INSTANCE.e(TAG, r1 + " 增强OCR调用失败: " + r2 + ", " + r3);
            return x.f38692a;
        }

        private final Bitmap a(Bitmap r3, int r4, int r5, int r6) {
            Bitmap r2 = Bitmap.createBitmap(r3.getWidth() + (r5 * 2), r3.getHeight() + (r6 * 2), Bitmap.Config.ARGB_8888);
            o.c(r2, "createBitmap(...)");
            Canvas r0 = new Canvas(r2);
            r0.drawColor(r4);
            r0.drawBitmap(r3, r5, r6, null);
            return r2;
        }

        private final f a(List<f> r7, float r8, float r9) {
            Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin")).iterator();
            f r10 = null;
            float r1 = Float.MAX_VALUE;
        L4:
            if (r6.hasNext() == false) goto L12;
            f r2 = (f) ZeusTransformUtils.preCheckCast(r6.next(), f.class, "com.obric.aiagent.plugin");
            if (new d.o.k("\\d+").b((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L4;
            float r3 = r8 - r2.f();
            float r4 = r9 - r2.g();
            float r5 = (float) Math.sqrt((r3 * r3) + (r4 * r4));
            if (r5 >= 50.0f) goto L4;
            if (r5 >= r1) goto L4;
            r10 = r2;
            r1 = r5;
            goto L4
        L12:
            if (r10 == null) goto L14;
            Loog.INSTANCE.w(TAG, "🔍 最近的数字box: '" + r10.a() + "', 距离=" + ((int) r1) + "px");
        L14:
            return r10;
        }

        private final b a(float r4, float r5, c r6, int r7, int r8) {
            int r3 = g.f29578a[r6.ordinal()];
            if (r3 != 1) goto L5;
            float r9 = d.i.a.a(TypedValue.applyDimension(1, 25, Resources.getSystem().getDisplayMetrics()));
            int r10 = Math.max(0, (int) (r5 - r9));
            return new b(0, r10, r7, Math.min(r8, (int) (r5 + r9)) - r10);
        L5:
            if (r3 != 2) goto L8;
            int r11 = d.i.a.a(TypedValue.applyDimension(1, 50, Resources.getSystem().getDisplayMetrics()));
            int r0 = d.i.a.a(TypedValue.applyDimension(1, 60, Resources.getSystem().getDisplayMetrics()));
            float r12 = r11;
            int r1 = Math.max(0, (int) (r4 - r12));
            int r13 = Math.min(r7, (int) (r4 + r12));
            float r14 = r0;
            int r15 = Math.max(0, (int) (r5 - r14));
            return new b(r1, r15, r13 - r1, Math.min(r8, (int) (r5 + r14)) - r15);
        L8:
            throw new d.k();
        }

        private final Bitmap a(Bitmap r2) {
            if (r2.getConfig() != Bitmap.Config.HARDWARE) goto L6;
            Bitmap r3 = r2.copy(Bitmap.Config.ARGB_8888, false);
            o.a(r3);
            return r3;
        L6:
            return r2;
        }

        private final void a(Bitmap r23, Bitmap r24, JSONArray r25, C0764e r26, b r27, float r28, float r29, int r30, String r31, c r32) {
            int r1 = g.f29578a[r32.ordinal()];     // Catch: Exception -> L13
            if (r1 != 1) goto L6;
            this.f29560e.a(r23, r24, r25, r26.a(), r30, r28, r29, r27.a(), r27.b(), r31);     // Catch: Exception -> L13
        L11:
            Loog.INSTANCE.d(TAG, "✅ " + r31 + " 调试图片已保存");     // Catch: Exception -> L13
            return;
        L6:
            if (r1 != 2) goto L9;
            this.f29560e.a(r23, r24, r25, r26.c(), r28, r29, r27.a(), r27.b());     // Catch: Exception -> L13
            goto L11
        L9:
            throw new d.k();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Loog.INSTANCE.e(TAG, "❌ 保存 " + r31 + " 调试图片失败: " + e.getMessage());
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29602a = null;
        private static final d.o.k i = null;
        private static final d.o.k j = null;
        private static final d.o.k k = null;
        private static final d.o.k l = null;
        private static final d.o.k m = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f29604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f29605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f29606e;
        private final int f;
        private final float g;
        private final float h;

        /* JADX INFO: compiled from: OpScrollWheelAction.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            public static /* synthetic */ CharSequence lambda$4_P4EYdw9zuUKwTXgYnSzPWLoZ8(d.o.i r0) {
                return a(r0);
            }

            public static /* synthetic */ CharSequence lambda$_drMeP9X6yymhoNiwQVPWVYIlFM(d.o.i r0) {
                return b(r0);
            }

            private a() {
            }

            public static /* synthetic */ Integer a(a r0, String r1, boolean r2, int r3, Object r4) {
                if ((r3 & 2) == 0) goto L6;
                r2 = true;
            L6:
                return r0.a(r1, r2);
            }

            public final Integer a(String r18, boolean r19) {
                o.e(r18, "rawText");
                String r0 = d.o.o.a(d.o.o.a(r18, 'O', '0', false, 4, null), 'o', '0', false, 4, null);
                boolean r2 = true;
                if (r19 == true) goto L14;
                String r1 = d.n.m.a(d.o.k.b(new d.o.k("\\d"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$f$a$4_P4EYdw9zuUKwTXgYnSzPWLoZ8.INSTANCE, 30, null);
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L8;
                r2 = false;
            L8:
                if (r2 == true) goto L11;
                r1 = null;
            L11:
                if (r1 != null) goto L13;
                return null;
            L13:
                return d.o.o.d(r1);
            L14:
                d.o.i r7 = d.o.k.a(f.h(), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
                if (r7 != null) goto L17;
                d.o.i r8 = d.o.k.a(f.i(), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
                if (r8 != null) goto L21;
                d.o.i r9 = d.o.k.a(f.j(), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
                if (r9 != null) goto L25;
                d.o.i r10 = d.o.k.a(f.k(), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
                if (r10 != null) goto L29;
                String r3 = d.n.m.a(d.o.k.b(f.l(), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$f$a$_drMeP9X6yymhoNiwQVPWVYIlFM.INSTANCE, 30, null);
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L34;
                r2 = false;
            L34:
                if (r2 == true) goto L37;
                r3 = null;
            L37:
                if (r3 != null) goto L39;
                return null;
            L39:
                return d.o.o.d(r3);
            L29:
                return d.o.o.d(a((String) ZeusTransformUtils.preCheckCast(r10.d().get(1), String.class, "com.obric.aiagent.plugin")));
            L25:
                return a((String) ZeusTransformUtils.preCheckCast(r9.d().get(1), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r9.d().get(2), String.class, "com.obric.aiagent.plugin"));
            L21:
                return a((String) ZeusTransformUtils.preCheckCast(r8.d().get(1), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.d().get(2), String.class, "com.obric.aiagent.plugin"));
            L17:
                return a((String) ZeusTransformUtils.preCheckCast(r7.d().get(1), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.d().get(2), String.class, "com.obric.aiagent.plugin"));
            }

            private static final CharSequence a(d.o.i r2) {
                d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
                o.e(r3, "it");
                return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
            }

            private static final String a(String r2) {
                return d.o.o.a(r2, 2, '0');
            }

            private static final Integer a(String r1, String r2) {
                return d.o.o.d(a(r1) + a(r2));
            }

            private static final CharSequence b(d.o.i r2) {
                d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
                o.e(r3, "it");
                return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
            }
        }

        public static /* synthetic */ f a(f r5, String r6, int r7, int r8, int r9, int r10, float r11, float r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.f29603b;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.f29604c;
        L8:
            int r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.f29605d;
        L11:
            int r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.f29606e;
        L14:
            int r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.f;
        L17:
            int r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.g;
        L20:
            float r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.h;
        L23:
            String r16 = r6;
            return r5.a(r16, r15, r0, r1, r2, r3, r12);
        }

        public final f a(String r9, int r10, int r11, int r12, int r13, float r14, float r15) {
            o.e(r9, "text");
            return new f(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29603b, r6.f29603b) == true) goto L12;
            return false;
        L12:
            if (this.f29604c == r6.f29604c) goto L15;
            return false;
        L15:
            if (this.f29605d == r6.f29605d) goto L18;
            return false;
        L18:
            if (this.f29606e == r6.f29606e) goto L21;
            return false;
        L21:
            if (this.f == r6.f) goto L24;
            return false;
        L24:
            if (Float.compare(this.g, r6.g) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.h, r6.h) == 0) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.f29603b.hashCode() * 31) + Integer.hashCode(this.f29604c)) * 31) + Integer.hashCode(this.f29605d)) * 31) + Integer.hashCode(this.f29606e)) * 31) + Integer.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h);
        }

        public String toString() {
            return "TextBlock(text=" + this.f29603b + ", left=" + this.f29604c + ", top=" + this.f29605d + ", right=" + this.f29606e + ", bottom=" + this.f + ", centerX=" + this.g + ", centerY=" + this.h + ')';
        }

        public f(String r2, int r3, int r4, int r5, int r6, float r7, float r8) {
            o.e(r2, "text");
            this.f29603b = r2;
            this.f29604c = r3;
            this.f29605d = r4;
            this.f29606e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public /* synthetic */ f(String r11, int r12, int r13, int r14, int r15, float r16, float r17, int r18, d.h.b.h r19) {
            if ((r18 & 32) == 0) goto L5;
            float r8 = (r12 + r14) / 2.0f;
        L7:
            if ((r18 & 64) == 0) goto L9;
            float r9 = (r13 + r15) / 2.0f;
        L10:
            this(r11, r12, r13, r14, r15, r8, r9);
            return;
        L9:
            r9 = r17;
            goto L10
        L5:
            r8 = r16;
            goto L7
        }

        public static final /* synthetic */ d.o.k h() {
            return i;
        }

        public static final /* synthetic */ d.o.k i() {
            return j;
        }

        public static final /* synthetic */ d.o.k j() {
            return k;
        }

        public static final /* synthetic */ d.o.k k() {
            return l;
        }

        public static final /* synthetic */ d.o.k l() {
            return m;
        }

        public final String a() {
            return this.f29603b;
        }

        public final int b() {
            return this.f29604c;
        }

        public final int c() {
            return this.f29605d;
        }

        public final int d() {
            return this.f29606e;
        }

        public final int e() {
            return this.f;
        }

        public final float f() {
            return this.g;
        }

        public final float g() {
            return this.h;
        }

        static {
            f29602a = new a(null);
            i = new d.o.k("(\\d{1,2})\\s*月\\s*(\\d{1,2})\\s*(?:日|号)?");
            j = new d.o.k("(\\d{1,2})\\s*(?:时|:|：)\\s*(\\d{1,2})\\s*分?");
            k = new d.o.k("(\\d{1,2})\\s*分\\s*(\\d{1,2})\\s*秒");
            l = new d.o.k("(\\d{1,2})\\s*分");
            m = new d.o.k("\\d+");
        }

        public static /* synthetic */ Integer a(f r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = true;
        L6:
            return r0.a(r1);
        }

        public final Integer a(boolean r2) {
            return f29602a.a(this.f29603b, r2);
        }

        public final boolean a(float r2, float r3) {
            if (r2 >= this.f29604c) goto L5;
        L11:
            return false;
        L5:
            if (r2 > this.f29606e) goto L11;
            if (r3 < this.f29605d) goto L11;
            if (r3 > this.f) goto L11;
            return true;
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {928, 929, 930}, d = "loadScriptModel", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f29609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f29611e;
        int f;

        g(d r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29611e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29610d = r3;
            this.f |= Integer.MIN_VALUE;
            return d.a(this.f29611e, null, false, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {894, 911}, d = "performScroll", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f29612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f29613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29614c;

        h(d r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29613b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f29612a = r7;
            this.f29614c |= Integer.MIN_VALUE;
            return d.a(this.f29613b, 0.0f, 0.0f, 0.0f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {85}, d = "performSingletonOperation", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f29615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f29616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29617c;

        i(d r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29616b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29615a = r3;
            this.f29617c |= Integer.MIN_VALUE;
            return this.f29616b.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {543, 604, 621, 697, 717}, d = "scrollSelectionToLegacy", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction")
    static final class j extends d.c.b.a.d {
        Object A;
        float B;
        float C;
        long D;
        long E;
        long F;
        boolean G;
        int H;
        int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int f29618J;
        int K;
        int L;
        int M;
        /* synthetic */ Object N;
        final /* synthetic */ d O;
        int P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29623e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Object q;
        Object r;
        Object s;
        Object t;
        Object u;
        Object v;
        Object w;
        Object x;
        Object y;
        Object z;

        j(d r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.O = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.N = r3;
            this.P |= Integer.MIN_VALUE;
            return d.b(this.O, 0.0f, 0.0f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpScrollWheelAction.kt */
    @d.c.b.a.f(b = "OpScrollWheelAction.kt", c = {133, 213, 225, 226, 292, 382, AbstractDialog.HORIZONTAL_MAX_WIDTH}, d = "scrollSelectionToOptimized", e = "com.obric.autogui.operator.impl.op.scrollwheel.OpScrollWheelAction")
    static final class k extends d.c.b.a.d {
        Object A;
        Object B;
        float C;
        float D;
        long E;
        long F;
        long G;
        int H;
        int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int f29624J;
        int K;
        int L;
        int M;
        int N;
        boolean O;
        boolean P;
        /* synthetic */ Object Q;
        final /* synthetic */ d R;
        int S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29629e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Object q;
        Object r;
        Object s;
        Object t;
        Object u;
        Object v;
        Object w;
        Object x;
        Object y;
        Object z;

        k(d r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.R = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.Q = r3;
            this.S |= Integer.MIN_VALUE;
            return d.a(this.R, 0.0f, 0.0f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29542b = new a(null);
    }

    private final long a(int r5) {
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L7;
        return 800;
    L7:
        if (r5 != 3) goto L9;
        return 1000;
    L9:
        if (r5 != 4) goto L13;
        return 1000;
    L13:
        return 500;
    }

    public static /* synthetic */ String lambda$I1zUhvnyuWXSlqD0O9nUKUafFcg(d.o.i r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$g3xm9fIOMW_AdpFdfJGAzaqt1dk(d.o.i r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$h03m6SQeZQAmN3HLLki-3CuXoYA, reason: not valid java name */
    public static /* synthetic */ CharSequence m832lambda$h03m6SQeZQAmN3HLLki3CuXoYA(d.o.i r0) {
        return b(r0);
    }

    public d() {
        this.f29544d = new com.obric.autogui.operator.a.c.b("ScrollWheel", p.b(new com.obric.autogui.operator.a.c.c[]{new com.obric.autogui.operator.a.c.a.a(AutoActionConfigs.INSTANCE.getBooleanCfg("operator.precheck.scrollwheel.activity_change.enable", false)), new com.obric.autogui.operator.a.c.a.b.a()}));
    }

    public static final /* synthetic */ Object a(d r6, float r7, float r8, float r9, c r10, d.c.d r11) {
        return r6.a(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, float r3, float r4, String r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, String r3, boolean r4, RequestParams r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(d r2, float r3, float r4, String r5, d.c.d r6) {
        return r2.c(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.b
    public com.obric.autogui.operator.a.c.b a() {
        return this.f29544d;
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L6;
        return false;
    L6:
        this.f29543c = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.obric.autogui.operator.a.b
    public Object c(Context r7, d.c.d<? super com.obric.autogui.common.e> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, i.class) == false) goto L7;
        i r11 = (i) ZeusTransformUtils.preCheckCast(r10, i.class, "com.obric.aiagent.plugin");
        if ((r11.f29617c & Integer.MIN_VALUE) == 0) goto L7;
        r11.f29617c -= Integer.MIN_VALUE;
    L8:
        Object r12 = r11.f29615a;
        Object r0 = d.c.a.b.a();
        int r2 = r11.f29617c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r12);
    L21:
        com.obric.autogui.common.e r6 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r6.g() == true) goto L24;
        r6.a(ZeusTransformUtils.mapRes(R.string.agent_task_scroll_wheel_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_scroll_wheel_failed"));
    L24:
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        b r13 = this.f29543c;
        if (r13 == null) goto L17;
        float r3 = ((Number) ZeusTransformUtils.preCheckCast(r13.a().a(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(r13.a().b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        String r14 = r13.b();
        r11.f29617c = 1;
        r12 = a(r3, r4, r14, r11);
        if (r12 != r0) goto L21;
        return r0;
    L17:
        return com.obric.autogui.common.e.f29014b.b("no input provided");
    L7:
        r11 = new i(this, r10);
        goto L8
    }

    private final Object a(float r3, float r4, String r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.a.d.f28974a.V() == false) goto L7;
        return b(r3, r4, r5, r7);
    L7:
        return c(r3, r4, r5, r7);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 21 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:579:0x20c9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    private final java.lang.Object b(float r254, float r255, java.lang.String r256, d.c.d<? super com.obric.autogui.common.e> r257) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 17466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.operator.a.b.b.d.b(float, float, java.lang.String, d.c.d):java.lang.Object");
    }

    private static final CharSequence a(d.o.i r2) {
        d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final e.C0763d a(z.d r1, z.d r2, z.d r3, z.f<String> r4, z.d r5, e.C0763d r6) {
        r1.f38502a++;
        if (r6 != null) goto L6;
        r2.f38502a++;
        r3.f38502a++;
        r4.f38504a = "ocr_ret_null";
        return null;
    L6:
        if (r6.c() != null) goto L10;
        r2.f38502a++;
        r5.f38502a++;
        r4.f38504a = "ocr_num_null";
        return r6;
    L10:
        return r6;
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5011 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r1v104, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r1v202 */
    /* JADX WARN: Type inference failed for: r1v203 */
    /* JADX WARN: Type inference failed for: r1v204 */
    /* JADX WARN: Type inference failed for: r1v210 */
    /* JADX WARN: Type inference failed for: r1v215 */
    /* JADX WARN: Type inference failed for: r1v229, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r1v266, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r1v392 */
    /* JADX WARN: Type inference failed for: r217v1 */
    /* JADX WARN: Type inference failed for: r217v10 */
    /* JADX WARN: Type inference failed for: r217v11 */
    /* JADX WARN: Type inference failed for: r217v12 */
    /* JADX WARN: Type inference failed for: r217v13 */
    /* JADX WARN: Type inference failed for: r217v16 */
    /* JADX WARN: Type inference failed for: r217v17 */
    /* JADX WARN: Type inference failed for: r217v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r217v19 */
    /* JADX WARN: Type inference failed for: r217v2 */
    /* JADX WARN: Type inference failed for: r217v21 */
    /* JADX WARN: Type inference failed for: r217v22 */
    /* JADX WARN: Type inference failed for: r217v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r217v24 */
    /* JADX WARN: Type inference failed for: r217v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r217v38 */
    /* JADX WARN: Type inference failed for: r217v39 */
    /* JADX WARN: Type inference failed for: r217v4 */
    /* JADX WARN: Type inference failed for: r217v40 */
    /* JADX WARN: Type inference failed for: r217v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r217v42 */
    /* JADX WARN: Type inference failed for: r217v43 */
    /* JADX WARN: Type inference failed for: r217v44 */
    /* JADX WARN: Type inference failed for: r217v45 */
    /* JADX WARN: Type inference failed for: r217v46 */
    /* JADX WARN: Type inference failed for: r217v55 */
    /* JADX WARN: Type inference failed for: r217v56 */
    /* JADX WARN: Type inference failed for: r217v57 */
    /* JADX WARN: Type inference failed for: r217v58 */
    /* JADX WARN: Type inference failed for: r217v59 */
    /* JADX WARN: Type inference failed for: r217v60 */
    /* JADX WARN: Type inference failed for: r217v61 */
    /* JADX WARN: Type inference failed for: r217v62 */
    /* JADX WARN: Type inference failed for: r217v63 */
    /* JADX WARN: Type inference failed for: r217v64 */
    /* JADX WARN: Type inference failed for: r217v65 */
    /* JADX WARN: Type inference failed for: r217v66 */
    /* JADX WARN: Type inference failed for: r217v67 */
    /* JADX WARN: Type inference failed for: r217v68 */
    /* JADX WARN: Type inference failed for: r217v7 */
    /* JADX WARN: Type inference failed for: r217v8 */
    /* JADX WARN: Type inference failed for: r217v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r218v1 */
    /* JADX WARN: Type inference failed for: r218v2 */
    /* JADX WARN: Type inference failed for: r218v25 */
    /* JADX WARN: Type inference failed for: r218v26 */
    /* JADX WARN: Type inference failed for: r218v27 */
    /* JADX WARN: Type inference failed for: r218v28 */
    /* JADX WARN: Type inference failed for: r218v29 */
    /* JADX WARN: Type inference failed for: r218v3 */
    /* JADX WARN: Type inference failed for: r218v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r218v5 */
    /* JADX WARN: Type inference failed for: r218v6 */
    /* JADX WARN: Type inference failed for: r218v7 */
    /* JADX WARN: Type inference failed for: r218v8 */
    /* JADX WARN: Type inference failed for: r218v9 */
    /* JADX WARN: Type inference failed for: r2v179, types: [T, com.obric.autogui.common.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r3v239, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r3v62, types: [T, com.obric.autogui.common.a] */
    /* JADX WARN: Type inference failed for: r7v115, types: [T, com.obric.autogui.common.a, java.lang.Object] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 14 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 37 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:201:0x0f76 -> B:1250:0x0e24). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:674:0x22e1 -> B:675:0x2312). Please report as a decompilation issue!!! */
    private final Object c(float r218, float r219, String r220, d.c.d<? super com.obric.autogui.common.e> r221) {
        String r13 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r221, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, j.class) == false) goto L7;
        j r2 = (j) ZeusTransformUtils.preCheckCast(r1, j.class, "com.obric.aiagent.plugin");
        if ((r2.P & Integer.MIN_VALUE) == 0) goto L7;
        r2.P -= Integer.MIN_VALUE;
    L8:
        j r14 = r2;
        Object r3 = r14.N;
        Object r15 = d.c.a.b.a();
        int r4 = r14.P;
        String r5 = "ocr_ok";
        String r222 = "ocr_fail_cnt";
        String r16 = "total_delay_ms";
        String r17 = "total_swipe_duration_ms";
        String r19 = "avg_swipe_duration_ms";
        String r20 = "duration_ms";
        String r21 = "swipe_count";
        String r22 = "fail_reason";
        String r23 = "ok";
        String r7 = TAG;
        long r24 = 0;
        String r28 = "ocr_total_cnt";
        String r29 = "direction_flip_count";
        String r30 = "avg_delay_ms";
        if (r4 == 0) goto L47;
        if (r4 != 1) goto L12;
        boolean r6 = r14.G;
        long r8 = r14.D;
        float r9 = r14.C;
        float r10 = r14.B;
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r14.p, Integer.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r14.o, String.class, "com.obric.aiagent.plugin");
        z.f r18 = (z.f) ZeusTransformUtils.preCheckCast(r14.n, z.f.class, "com.obric.aiagent.plugin");
        z.d r25 = (z.d) ZeusTransformUtils.preCheckCast(r14.m, z.d.class, "com.obric.aiagent.plugin");
        z.d r26 = (z.d) ZeusTransformUtils.preCheckCast(r14.l, z.d.class, "com.obric.aiagent.plugin");
        z.d r27 = (z.d) ZeusTransformUtils.preCheckCast(r14.k, z.d.class, "com.obric.aiagent.plugin");
        z.d r31 = (z.d) ZeusTransformUtils.preCheckCast(r14.j, z.d.class, "com.obric.aiagent.plugin");
        z.d r32 = (z.d) ZeusTransformUtils.preCheckCast(r14.i, z.d.class, "com.obric.aiagent.plugin");
        z.d r33 = (z.d) ZeusTransformUtils.preCheckCast(r14.h, z.d.class, "com.obric.aiagent.plugin");
        z.e r34 = (z.e) ZeusTransformUtils.preCheckCast(r14.g, z.e.class, "com.obric.aiagent.plugin");
        z.d r35 = (z.d) ZeusTransformUtils.preCheckCast(r14.f, z.d.class, "com.obric.aiagent.plugin");
        z.f r36 = (z.f) ZeusTransformUtils.preCheckCast(r14.f29623e, z.f.class, "com.obric.aiagent.plugin");
        z.e r37 = (z.e) ZeusTransformUtils.preCheckCast(r14.f29622d, z.e.class, "com.obric.aiagent.plugin");
        z.d r38 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29621c, z.d.class, "com.obric.aiagent.plugin");
        String r39 = (String) ZeusTransformUtils.preCheckCast(r14.f29620b, String.class, "com.obric.aiagent.plugin");
        d r110 = (d) ZeusTransformUtils.preCheckCast(r14.f29619a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L45
        r222 = r222;
        r5 = "ocr_ok";
        Integer r83 = r11;
        String r84 = r12;
        String r75 = r16;
        String r76 = r17;
        String r77 = "scroll_attempts";
        r19 = r19;
        String r79 = r20;
        String r80 = r21;
        String r81 = r22;
        String r82 = r23;
        r28 = r28;
        r29 = r29;
        String r61 = r30;
        boolean r210 = r6;
        z.d r40 = r33;
        z.d r41 = r38;
        z.d r211 = r25;
        z.d r212 = r26;
        String r111 = r39;
        float r112 = r9;
        float r113 = r10;
        Class r310 = d.class;
        z.d r114 = r31;
        z.d r42 = r32;
        z.d r115 = r35;
        z.e r43 = r37;
        z.d r44 = r27;
        Object r311 = r15;
        z.e r116 = r34;
        long r312 = r8;
        z.f r45 = r36;
        Object r46 = r3;
        z.f r47 = r18;
    L1168:
        IBaseModel r48 = (IBaseModel) ZeusTransformUtils.preCheckCast(r46, IBaseModel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L870
        if (r48 == null) goto L1198;
        z.f r66 = r47;
        z.d r208 = r42;
        z.d r63 = r44;
        z.e r49 = r43;
        z.d r207 = r40;
        d r313 = r110;
        r115 = r115;
        z.d r62 = r114;
        z.e r50 = r116;
        z.d r65 = r211;
        z.d r64 = r212;
        Class r51 = r310;
        String r117 = r29;
        r16 = r75;
        String r52 = r76;
        String r53 = r77;
        r19 = r19;
        r20 = r79;
        r21 = r80;
        r22 = r81;
        r23 = r82;
        z.f r118 = r45;
        z.d r54 = r41;
        String r55 = r61;
        r29 = r117;
        String r67 = r55;
        com.obric.autogui.operator.a.b.b.f r56 = new com.obric.autogui.operator.a.b.b.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L862
        r76 = r52;
        r75 = r16;
        com.obric.autogui.operator.a.b.b.b r119 = com.obric.autogui.operator.a.b.b.c.a(com.obric.autogui.operator.a.b.b.c.f29536a, null, 1, null);     // Catch: Throwable -> L860
        if (r210 == false) goto L158;
        boolean r57 = true;
    L159:
        e r58 = new e(r48, r119, r57);     // Catch: Throwable -> L860
        List<C0762d> r59 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L860
        Loog r120 = Loog.INSTANCE;     // Catch: Throwable -> L860
        Integer r60 = r83;
        float r68 = r113;
        StringBuilder r69 = new StringBuilder().append("开始智能滚动: 目标='").append(r111).append("' (提取数字='").append(r84).append("'→").append(r60).append("), 起始位置=(").append(r68).append(", ");     // Catch: Throwable -> L860
        float r70 = r112;
        r120.i(r7, r69.append(r70).append(')').toString());     // Catch: Throwable -> L860
        Loog.INSTANCE.i(r7, "调试图片保存已启用，将保存到: " + r56.a());     // Catch: Throwable -> L860
        e r90 = r58;
        r19 = r19;
        r77 = r53;
        List<C0762d> r93 = r59;
        Integer r217 = r60;
        Class r314 = r51;
        r79 = r20;
        r80 = r21;
        r81 = r22;
        r82 = r23;
        j r71 = r14;
        float r91 = r70;
        float r97 = r68;
        z.f r72 = r118;
        z.d r73 = r54;
        z.e r74 = r49;
        z.d r78 = r115;
        z.d r121 = r207;
        d r85 = r313;
        z.e r122 = r50;
        Object r98 = r311;
        long r86 = r312;
        z.d r87 = r62;
        z.d r123 = r63;
        z.d r213 = r64;
        z.d r124 = r65;
        z.f r125 = r66;
        int r88 = 22;
        int r89 = 0;
        int r810 = 0;
        int r811 = 0;
        Float r92 = null;
        Integer r94 = null;
        String r95 = null;
        Integer r96 = null;
        com.obric.autogui.operator.a.b.b.f r126 = r56;
        String r127 = "com.obric.aiagent.plugin";
        z.d r99 = r208;
        c r128 = null;
    L1250:
        if (r78.f38502a < r88) goto L1050;
        z.d r214 = r73;
        z.d r215 = r78;
        z.d r315 = r87;
        String r410 = r7;
        String r199 = r127;
        com.obric.autogui.operator.a.b.b.f r100 = r126;
        z.f r316 = r125;
        z.d r317 = r124;
        z.d r318 = r213;
        String r195 = r67;
        String r101 = r29;
        String r194 = r5;
        String r188 = r28;
        String r187 = r222;
        String r189 = r75;
        String r190 = r76;
        String r206 = r77;
        String r191 = r79;
        String r192 = r80;
        String r196 = r81;
        String r193 = r82;
        z.e r129 = r74;
        z.e r130 = r122;
        z.d r131 = r121;
        z.d r216 = r123;
        String r102 = r19;
        long r132 = r86;
        Integer r133 = r217;
        z.f r134 = r72;
        Loog.INSTANCE.w(r410, "❌ 达到最大滚动次数(" + r88 + ")，未找到目标数字: " + r133);     // Catch: Throwable -> L856
        Loog.INSTANCE.i(r410, "🏁 滚动任务结束，调试图片已保存至: " + r100.a());     // Catch: Throwable -> L856
        ?? r103 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "max_attempt", "at=" + r88 + ",tgt=" + r133, false, null, 0, 28, null);     // Catch: Throwable -> L856
        r134.f38504a = r103;     // Catch: Throwable -> L856
        n.a r104 = n.f38560a;     // Catch: Throwable -> L851
        d r105 = (d) ZeusTransformUtils.preCheckCast(r85, r314, r199);     // Catch: Throwable -> L851
        long r106 = AOSystemTools.INSTANCE.bootTimeMillis() - r132;     // Catch: Throwable -> L851
        com.obric.autogui.common.e r107 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r134.f38504a, com.obric.autogui.common.e.class, r199);     // Catch: Throwable -> L851
        if (r107 != null) goto L1094;
    L809:
        boolean r108 = false;
    L810:
        Object r109 = r134.f38504a;     // Catch: Throwable -> L851
        if (ZeusTransformUtils.instanceOf(r109, com.obric.autogui.common.a.class) == false) goto L813;
        com.obric.autogui.common.a r710 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r109, com.obric.autogui.common.a.class, r199);     // Catch: Throwable -> L807
    L814:
        if (r710 == null) goto L819;
        String r135 = r710.b();     // Catch: Throwable -> L807
        if (r135 == null) goto L819;
        z.d r136 = r214;
    L824:
        if (r136.f38502a <= 0) goto L828;
        z.e r137 = r129;
        long r138 = r137.f38503a / ((long) r136.f38502a);     // Catch: Throwable -> L807
    L829:
        if (r215.f38502a <= 0) goto L835;
        ?? r2110 = r103;
        long r139 = r130.f38503a;     // Catch: Throwable -> L833
        r130 = r130;
        r24 = r139 / ((long) r215.f38502a);     // Catch: Throwable -> L833
        r2110 = r2110;
    L836:
        long r140 = r24;
        IAutoActionTrackingApi r319 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r199);     // Catch: Throwable -> L833
        JSONObject r141 = new JSONObject();     // Catch: Throwable -> L833
        if (r108 == false) goto L839;
        int r142 = 1;
    L840:
        r141.put(r193, r142);     // Catch: Throwable -> L833
        r141.put(r196, r135);     // Catch: Throwable -> L833
        r141.put(r192, r136.f38502a);     // Catch: Throwable -> L833
        r141.put(r191, r106);     // Catch: Throwable -> L833
        r141.put(r102, r138);     // Catch: Throwable -> L833
        r141.put(r206, r215.f38502a);     // Catch: Throwable -> L833
        r141.put(r190, r137.f38503a);     // Catch: Throwable -> L833
        r141.put(r189, r130.f38503a);     // Catch: Throwable -> L833
        r141.put(r195, r140);     // Catch: Throwable -> L833
        r141.put(r101, r131.f38502a);     // Catch: Throwable -> L833
        x r143 = x.f38692a;     // Catch: Throwable -> L833
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r319, "oauto_scrollwheel_exec", r141, false, false, null, 28, null);     // Catch: Throwable -> L833
        IAutoActionTrackingApi r144 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r199);     // Catch: Throwable -> L833
        JSONObject r145 = new JSONObject();     // Catch: Throwable -> L833
        if (r108 == false) goto L843;
        int r146 = 1;
    L844:
        r145.put(r194, r146);     // Catch: Throwable -> L833
        r145.put(r188, r99.f38502a);     // Catch: Throwable -> L833
        r145.put(r187, r315.f38502a);     // Catch: Throwable -> L833
        r145.put("ocr_retry_cnt", r216.f38502a);     // Catch: Throwable -> L833
        String r147 = (String) ZeusTransformUtils.preCheckCast(r316.f38504a, String.class, r199);     // Catch: Throwable -> L833
        if (r147 != null) goto L849;
        if (r108 == false) goto L848;
        r147 = "success";
        goto L849
    L848:
        r147 = SensitiveType.UNKNOWN;
    L849:
        r145.put("ocr_fail_code", r147);     // Catch: Throwable -> L833
        r145.put("ocr_fail_num_null_cnt", r318.f38502a);     // Catch: Throwable -> L833
        r145.put("ocr_fail_ret_null_cnt", r317.f38502a);     // Catch: Throwable -> L833
        x r148 = x.f38692a;     // Catch: Throwable -> L833
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r144, "oauto_scrollwheel_ocr_stat", r145, false, false, null, 28, null);     // Catch: Throwable -> L833
        n.f(x.f38692a);     // Catch: Throwable -> L833
        ?? r2111 = r2110;
    L855:
        return r2111;
    L843:
        r146 = 0;
        goto L844
    L839:
        r142 = 0;
    L833:
        th = th;
        ?? r2112 = r2110;
    L853:
        Throwable r149 = th;
        ?? r2113 = r2112;
    L854:
        n.a r150 = n.f38560a;
        n.f(d.o.a(r149));
        r2111 = r2113;
        goto L855
    L835:
        r2110 = r103;
    L807:
        th = move-exception;
        r149 = th;
        r2113 = r103;
        goto L854
    L828:
        r137 = r129;
        r138 = 0;
    L819:
        r136 = r214;
        if (r108 == false) goto L822;
        r135 = "success";
        goto L824
    L822:
        r135 = SensitiveType.UNKNOWN;
        goto L824
    L813:
        r710 = null;
        goto L814
    L1094:
        if (r107.g() != true) goto L809;
        r108 = true;
    L851:
        th = th;
        r2112 = r103;
    L856:
        th = move-exception;
        r21 = r192;
        r22 = r196;
        r13 = r199;
        r29 = r101;
        r312 = r132;
        r118 = r134;
        r208 = r99;
        r49 = r129;
        r207 = r131;
        r115 = r215;
        r50 = r130;
        z.d r2114 = r318;
        z.d r209 = r315;
        z.d r2115 = r216;
        z.d r2116 = r317;
        r222 = r187;
        r28 = r188;
        r16 = r189;
        r17 = r190;
        r20 = r191;
        r23 = r193;
        r5 = r194;
        r30 = r195;
        z.f r151 = r316;
        r53 = r206;
        Throwable r152 = th;
        r19 = r102;
        r54 = r214;
    L1160:
        n.a r153 = n.f38560a;     // Catch: Throwable -> L1027
        String r711 = r20;
        String r610 = r30;
        long r154 = AOSystemTools.INSTANCE.bootTimeMillis() - r312;     // Catch: Throwable -> L1027
        String r712 = r16;
        String r713 = r17;
        com.obric.autogui.common.e r155 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r118.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L1027
        if (r155 == null) goto L993;
        if (r155.g() != true) goto L993;
        boolean r156 = true;
    L994:
        Object r157 = r118.f38504a;     // Catch: Throwable -> L1027
        if (ZeusTransformUtils.instanceOf(r157, com.obric.autogui.common.a.class) == false) goto L997;
        com.obric.autogui.common.a r714 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r157, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L1027
    L998:
        if (r714 == null) goto L1001;
        String r158 = r714.b();     // Catch: Throwable -> L1027
        if (r158 == null) goto L1001;
    L1005:
        if (r54.f38502a <= 0) goto L1007;
        long r159 = r49.f38503a / ((long) r54.f38502a);     // Catch: Throwable -> L1027
    L1009:
        if (r115.f38502a <= 0) goto L1012;
        r24 = r50.f38503a / ((long) r115.f38502a);     // Catch: Throwable -> L1027
    L1012:
        long r160 = r24;
        IAutoActionTrackingApi r320 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L1027
        JSONObject r161 = new JSONObject();     // Catch: Throwable -> L1027
        if (r156 == false) goto L1015;
        int r162 = 1;
    L1016:
        r161.put(r23, r162);     // Catch: Throwable -> L1027
        r161.put(r22, r158);     // Catch: Throwable -> L1027
        r161.put(r21, r54.f38502a);     // Catch: Throwable -> L1027
        r161.put(r711, r154);     // Catch: Throwable -> L1027
        r161.put(r19, r159);     // Catch: Throwable -> L1027
        r161.put(r53, r115.f38502a);     // Catch: Throwable -> L1027
        r161.put(r713, r49.f38503a);     // Catch: Throwable -> L1027
        r161.put(r712, r50.f38503a);     // Catch: Throwable -> L1027
        r161.put(r610, r160);     // Catch: Throwable -> L1027
        r161.put(r29, r207.f38502a);     // Catch: Throwable -> L1027
        x r163 = x.f38692a;     // Catch: Throwable -> L1027
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r320, "oauto_scrollwheel_exec", r161, false, false, null, 28, null);     // Catch: Throwable -> L1027
        IAutoActionTrackingApi r164 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L1027
        JSONObject r165 = new JSONObject();     // Catch: Throwable -> L1027
        String r166 = r5;
        if (r156 == false) goto L1019;
        int r167 = 1;
    L1020:
        r165.put(r166, r167);     // Catch: Throwable -> L1027
        r165.put(r28, r208.f38502a);     // Catch: Throwable -> L1027
        r165.put(r222, r209.f38502a);     // Catch: Throwable -> L1027
        r165.put("ocr_retry_cnt", r2115.f38502a);     // Catch: Throwable -> L1027
        String r168 = (String) ZeusTransformUtils.preCheckCast(r151.f38504a, String.class, r13);     // Catch: Throwable -> L1027
        if (r168 != null) goto L1025;
        if (r156 == false) goto L1024;
        r168 = "success";
        goto L1025
    L1024:
        r168 = SensitiveType.UNKNOWN;
    L1025:
        r165.put("ocr_fail_code", r168);     // Catch: Throwable -> L1027
        r165.put("ocr_fail_num_null_cnt", r2114.f38502a);     // Catch: Throwable -> L1027
        r165.put("ocr_fail_ret_null_cnt", r2116.f38502a);     // Catch: Throwable -> L1027
        x r169 = x.f38692a;     // Catch: Throwable -> L1027
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r164, "oauto_scrollwheel_ocr_stat", r165, false, false, null, 28, null);     // Catch: Throwable -> L1027
        n.f(x.f38692a);     // Catch: Throwable -> L1027
        throw r152;
    L1019:
        r167 = 0;
        goto L1020
    L1015:
        r162 = 0;
        goto L1016
    L1007:
        r159 = 0;
    L1001:
        if (r156 == false) goto L1003;
        r158 = "success";
        goto L1005
    L1003:
        r158 = SensitiveType.UNKNOWN;
        goto L1005
    L997:
        r714 = null;
    L993:
        r156 = false;
    L1027:
        th = move-exception;
        n.a r170 = n.f38560a;
        n.f(d.o.a(th));
        throw r152;
    L1050:
        r78.f38502a++;     // Catch: Throwable -> L793
        z.d r223 = r123;
        z.d r224 = r87;
        Loog.INSTANCE.i(r7, "📋 第 " + r78.f38502a + " 次滚动尝试 (最多 " + r88 + " 次)");     // Catch: Throwable -> L786
        int r171 = r217.intValue();     // Catch: Throwable -> L786
        r71.f29619a = r85;     // Catch: Throwable -> L786
        r71.f29620b = r73;     // Catch: Throwable -> L786
        r71.f29621c = r74;     // Catch: Throwable -> L786
        r71.f29622d = r72;     // Catch: Throwable -> L786
        r71.f29623e = r78;     // Catch: Throwable -> L786
        r71.f = r122;     // Catch: Throwable -> L786
        r71.g = r121;     // Catch: Throwable -> L786
        r71.h = r128;     // Catch: Throwable -> L786
        r71.i = r99;     // Catch: Throwable -> L786
        z.d r321 = r224;
        r71.j = r321;     // Catch: Throwable -> L784
        r123 = r223;
        r71.k = r123;     // Catch: Throwable -> L782
        c r225 = r128;
        z.d r172 = r213;
        r71.l = r172;     // Catch: Throwable -> L780
        z.d r226 = r123;
        z.d r173 = r124;
        r71.m = r173;     // Catch: Throwable -> L778
        z.d r174 = r121;
        z.f r175 = r125;
        r71.n = r175;     // Catch: Throwable -> L775
        z.e r176 = r122;
        Integer r177 = r217;
        r71.o = r177;     // Catch: Throwable -> L772
        r78 = r78;
        com.obric.autogui.operator.a.b.b.f r178 = r126;
        r71.p = r178;     // Catch: Throwable -> L769
        r74 = r74;
        e r179 = r90;
        r71.q = r179;     // Catch: Throwable -> L767
        r73 = r73;
        Float r180 = r92;
        r71.r = r180;     // Catch: Throwable -> L765
        List<C0762d> r181 = r93;
        r71.s = r181;     // Catch: Throwable -> L765
        Integer r182 = r94;
        r71.t = r182;     // Catch: Throwable -> L765
        String r183 = r95;
        r71.u = r183;     // Catch: Throwable -> L765
        Integer r184 = r96;
        r71.v = r184;     // Catch: Throwable -> L765
        r71.w = r99;     // Catch: Throwable -> L765
        r71.x = r321;     // Catch: Throwable -> L765
        r71.y = r173;     // Catch: Throwable -> L765
        r71.z = r175;     // Catch: Throwable -> L765
        r71.A = r172;     // Catch: Throwable -> L765
        float r185 = r97;
        r71.B = r185;     // Catch: Throwable -> L765
        r124 = r173;
        float r186 = r91;
        r71.C = r186;     // Catch: Throwable -> L763
        z.d r322 = r172;
        r125 = r175;
        long r197 = r86;
        r71.D = r197;     // Catch: Throwable -> L761
        r71.H = r88;     // Catch: Throwable -> L761
        r321 = r321;
        int r198 = r89;
        r71.I = r198;     // Catch: Throwable -> L759
        int r1100 = r810;
        r71.f29618J = r1100;     // Catch: Throwable -> L759
        int r1101 = r811;
        r71.K = r1101 == true ? 1 : 0;     // Catch: Throwable -> L759
        r71.P = 2;     // Catch: Throwable -> L759
        Object r200 = r179.a(r185, r186, r171, r71);     // Catch: Throwable -> L759
        Object r1102 = r98;
        if (r200 != r1102) goto L195;
        return r1102;
    L195:
        e r1010 = r179;
        float r1110 = r185;
        com.obric.autogui.operator.a.b.b.f r1011 = r178;
        z.d r201 = r99;
        r3 = r200;
        d r2117 = r85;
        int r910 = r88;
        Object r1111 = r1102;
        float r1012 = r186;
        z.d r1013 = r226;
        c r1014 = r225;
        z.d r1103 = r78;
        r92 = r180;
        List<C0762d> r1112 = r181;
        Integer r1113 = r182;
        String r1114 = r183;
        Integer r1115 = r184;
        z.d r202 = r124;
        z.d r1015 = r202;
        z.d r203 = r322;
        z.d r1016 = r203;
        z.f r1017 = r125;
        int r1018 = r198;
        int r204 = r1100;
        int r1019 = r1101 == true ? 1 : 0;
        z.f r1104 = r72;
        z.e r227 = r74;
        z.e r228 = r176;
        z.d r229 = r174;
        z.d r205 = r73;
        z.d r1105 = r321;
        z.d r1106 = r201;
        j r1107 = r71;
        z.f r230 = r1017;
        z.d r231 = r1105;
    L197:
        z.d r232 = r205;
        String r233 = r127;
        e.C0763d r234 = (e.C0763d) ZeusTransformUtils.preCheckCast(r3, e.C0763d.class, r233);     // Catch: Throwable -> L754
        d r235 = r2117;
        e.C0763d r236 = b(r201, r231, r202, r230, r203, r234);     // Catch: Throwable -> L754
        if (r236 == null) goto L1176;
        if (r236.a() == true) goto L1220;
        String r1108 = r233;
        String r1210 = r7;
        long r2118 = r197;
        z.d r1109 = r1105;
        z.d r1116 = r1106;
        z.d r237 = r229;
        z.e r238 = r227;
        Class r1211 = r314;
        String r1117 = r67;
        String r1118 = r5;
        String r1119 = r28;
        String r1120 = r222;
        String r1212 = r75;
        String r1213 = r76;
        String r1214 = r77;
        String r1215 = r79;
        String r1216 = r80;
        String r1217 = r81;
        String r1218 = r82;
        z.d r239 = r1013;
        z.f r1121 = r1017;
        z.d r240 = r1015;
        z.d r241 = r1016;
        int r1122 = r204;
        z.e r242 = r228;
        if (r92 != null) goto L368;
        j r243 = r1107;
        r243.f29619a = r235;     // Catch: Throwable -> L363
        r243.f29620b = r232;     // Catch: Throwable -> L363
        r243.f29621c = r238;     // Catch: Throwable -> L363
        r243.f29622d = r1104;     // Catch: Throwable -> L363
        r243.f29623e = r1103;     // Catch: Throwable -> L363
        r243.f = r242;     // Catch: Throwable -> L363
        r243.g = r237;     // Catch: Throwable -> L363
        c r244 = r1014;
        r243.h = r244;     // Catch: Throwable -> L363
        r243.i = r1116;     // Catch: Throwable -> L363
        r243.j = r1109;     // Catch: Throwable -> L363
        r243.k = r239;     // Catch: Throwable -> L363
        r243.l = r241;     // Catch: Throwable -> L363
        r243.m = r240;     // Catch: Throwable -> L363
        r243.n = r1121;     // Catch: Throwable -> L363
        r243.o = r177;     // Catch: Throwable -> L363
        com.obric.autogui.operator.a.b.b.f r245 = r1011;
        r243.p = r245;     // Catch: Throwable -> L363
        com.obric.autogui.operator.a.b.b.f r246 = r245;
        e r247 = r1010;
        r243.q = r247;     // Catch: Throwable -> L363
        z.e r248 = r242;
        List<C0762d> r249 = r1112;
        r243.r = r249;     // Catch: Throwable -> L361
        Integer r250 = r1113;
        r243.s = r250;     // Catch: Throwable -> L361
        Integer r251 = r250;
        String r252 = r1114;
        r243.t = r252;     // Catch: Throwable -> L361
        Integer r253 = r1115;
        r243.u = r253;     // Catch: Throwable -> L361
        Integer r254 = r253;
        r243.v = r236;     // Catch: Throwable -> L361
        r243.w = null;     // Catch: Throwable -> L361
        r243.x = null;     // Catch: Throwable -> L361
        r243.y = null;     // Catch: Throwable -> L361
        r243.z = null;     // Catch: Throwable -> L361
        r243.A = null;     // Catch: Throwable -> L361
        float r255 = r1110;
        r243.B = r255;     // Catch: Throwable -> L361
        z.d r323 = r241;
        float r256 = r1012;
        r243.C = r256;     // Catch: Throwable -> L359
        z.d r324 = r240;
        z.d r325 = r232;
        r243.D = r2118;     // Catch: Throwable -> L357
        r2118 = r2118;
        int r257 = r910;
        r243.H = r257;     // Catch: Throwable -> L355
        int r258 = r1018;
        r243.I = r258;     // Catch: Throwable -> L355
        r243.f29618J = r1122;     // Catch: Throwable -> L355
        boolean r259 = r1019 == true ? 1 : 0;
        r243.K = r259 ? 1 : 0;     // Catch: Throwable -> L355
        r243.P = 3;     // Catch: Throwable -> L355
        Object r260 = r247.a(r255, r256, r243);     // Catch: Throwable -> L355
        Object r261 = r1111;
        if (r260 != r261) goto L270;
        return r261;
    L270:
        c r411 = r244;
        e r326 = r247;
        int r1123 = r258;
        List<C0762d> r327 = r249;
        z.d r262 = r324;
        e.C0763d r2119 = r236;
        Integer r2120 = r177;
        String r2121 = r252;
        j r263 = r243;
        float r1124 = r256;
        d r264 = r235;
        z.d r265 = r325;
        z.d r328 = r323;
        Object r329 = r261;
        r3 = r260;
        z.e r266 = r248;
        int r267 = r257;
        int r330 = r259 ? 1 : 0;
        int r331 = r1122;
        long r1125 = r2118;
        float r1126 = r255;
        z.f r268 = r1121;
    L272:
        z.f r332 = r268;
        r13 = r1108;
        com.obric.autogui.common.d r269 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.d.class, r13);     // Catch: Throwable -> L348
        z.d r1127 = r239;
        e.f r270 = (e.f) ZeusTransformUtils.preCheckCast(r269.a(), e.f.class, r13);     // Catch: Throwable -> L346
        if (r270 == null) goto L1238;
        d r333 = r264;
        z.d r412 = r265;
        z.d r413 = r237;
        z.e r510 = r238;
        float r334 = r1126;
        float r414 = r1124;
        z.d r415 = r1116;
        z.d r416 = r1109;
        z.d r417 = r328;
        r29 = r29;
        String r271 = r1119;
        r5 = r1118;
        String r1128 = r1117;
        String r1129 = r1213;
        r21 = r1216;
        String r1130 = r1217;
        String r272 = r1218;
        Class r273 = r1211;
        r53 = r1214;
        String r1131 = r1210;
        z.e r1132 = r266;
        z.f r335 = r1104;
        z.d r336 = r262;
        String r274 = r1120;
        String r1133 = r1215;
        z.d r275 = r1103;
        String r1134 = r1212;
        Float r418 = d.c.b.a.b.a(r270.a());     // Catch: Throwable -> L342
        r222 = r274;
        r28 = r271;
        Loog.INSTANCE.i(r1131, "🎯 滚轮步长分析: 自适应=" + ((int) r418.floatValue()) + "px");     // Catch: Throwable -> L338
        r270.b();     // Catch: Throwable -> L338
        String r1410 = r2121;
        e.C0763d r276 = r2119;
        Integer r2122 = r2120;
        r29 = r29;
        r53 = r53;
        r30 = r1128;
        r16 = r1134;
        r22 = r1130;
        r17 = r1129;
        r312 = r1125;
        r1018 = r1123;
        com.obric.autogui.operator.a.b.b.f r1411 = r246;
        int r1310 = r267;
        z.d r277 = r275;
        r1113 = r251;
        j r1311 = r263;
        Integer r1312 = r254;
        Object r1412 = r329;
        r118 = r335;
        z.d r1313 = r336;
        r1019 = r330;
        int r1314 = r331;
        List<C0762d> r1413 = r327;
        e r1414 = r326;
        float r1415 = r334;
        d r278 = r333;
        z.f r1315 = r332;
        r54 = r412;
        z.d r1316 = r417;
        z.d r1317 = r1127;
        z.d r1318 = r416;
        z.d r1219 = r415;
        c r1319 = r411;
        float r1416 = r414;
        Float r2123 = r418;
        z.e r1135 = r510;
        Class r1610 = r273;
        z.e r1136 = r1132;
        z.d r1137 = r413;
    L1172:
        r20 = r1133;
        c r279 = r278.a(r276.c(), r2122.intValue());     // Catch: Throwable -> L749
        if (r279 == c.f29549c) goto L1102;
        r23 = r272;
        String r1611 = r21;
        z.e r280 = r1135;
        r207 = r1137;
        r50 = r1136;
        String r1612 = r5;
        String r1613 = r28;
        String r1510 = r222;
        r53 = r53;
        r19 = r19;
        String r1614 = r22;
        r208 = r1219;
        r209 = r1318;
        z.d r1417 = r1317;
        z.d r1511 = r1316;
        z.d r1418 = r1313;
        r151 = r1315;
        c r1138 = r1319;
        if (r1138 == null) goto L1034;
        if (r1138 == r279) goto L1034;
        r207.f38502a++;     // Catch: Throwable -> L429
    L429:
        th = move-exception;
        r152 = th;
        r50 = r50;
        r13 = r13;
        r54 = r54;
        r118 = r118;
        r207 = r207;
        r312 = r312;
        r208 = r208;
        r30 = r30;
        r17 = r17;
        r20 = r20;
        r23 = r23;
        r209 = r209;
        r2115 = r1417;
        r2116 = r1418;
        r151 = r151;
        r222 = r1510;
        r28 = r1613;
        r2114 = r1511;
        r5 = r1612;
        r53 = r53;
        r19 = r19;
        r21 = r1611;
        r22 = r1614;
    L431:
        r115 = r277;
        r49 = r280;
        r16 = r16;
    L1034:
        String r1139 = r276.b();     // Catch: Throwable -> L747
        if (r1139 != null) goto L436;
        r1139 = "";
    L436:
        if (o.a(r1139, r1410) == false) goto L499;
        int r1140 = r1018 + 1;
        if (r1140 >= 3) goto L1240;
        int r1710 = r1140;
    L1234:
        Integer r1141 = r276.c();     // Catch: Throwable -> L743
        if (r1141 != null) goto L1142;
        int r281 = 0;
    L1228:
        z.d r1419 = r1418;
        if (r277.f38502a < 3) goto L526;
        if (r1019 != 0) goto L526;
        List<C0762d> r282 = r1413;
        boolean r283 = r278.a(r282, r281);     // Catch: Throwable -> L523
        if (r283 == false) goto L522;
        Integer r284 = r278.a(r282);     // Catch: Throwable -> L523
        List<C0762d> r1142 = r282;
        r1511 = r1511;
        r1417 = r1417;
        Loog.INSTANCE.i(r1131, "🧠 智能滚动已启用，单步数值变化: " + r284);     // Catch: Throwable -> L532
        Integer r285 = r284;
        ?? r286 = r283;
    L528:
        if (r286 == 0) goto L534;
        if (r285 == null) goto L534;
        int r287 = r278.a(r281, r2122.intValue(), r285.intValue());     // Catch: Throwable -> L532
    L1208:
        long r288 = r278.a(r287);     // Catch: Throwable -> L738
        Integer r289 = r285;
        int r290 = r281;
        z.d r1420 = r209;
        Loog.INSTANCE.i(r1131, "🎯 执行" + r287 + "步滚动，延迟" + r288 + "ms");     // Catch: Throwable -> L736
        r54.f38502a++;     // Catch: Throwable -> L736
        long r291 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L736
        float r337 = r2123.floatValue();     // Catch: Throwable -> L725
        j r1143 = r1311;
        r1143.f29619a = r278;     // Catch: Throwable -> L725
        r1143.f29620b = r54;     // Catch: Throwable -> L725
        r1143.f29621c = r280;     // Catch: Throwable -> L725
        r1143.f29622d = r118;     // Catch: Throwable -> L725
        r1143.f29623e = r277;     // Catch: Throwable -> L725
        r1143.f = r50;     // Catch: Throwable -> L725
        r1143.g = r207;     // Catch: Throwable -> L725
        z.d r292 = r277;
        r1143.h = r279;     // Catch: Throwable -> L723
        r1143.i = r208;     // Catch: Throwable -> L723
        z.d r293 = r54;
        r1143.j = r1420;     // Catch: Throwable -> L721
        r1420 = r1420;
        z.d r294 = r1417;
        r1143.k = r294;     // Catch: Throwable -> L719
        r1417 = r294;
        z.d r295 = r1511;
        r1143.l = r295;     // Catch: Throwable -> L717
        r1511 = r295;
        r1143.m = r1419;     // Catch: Throwable -> L715
        r1419 = r1419;
        r1143.n = r151;     // Catch: Throwable -> L713
        z.f r1512 = r151;
        Integer r296 = r2122;
        r1143.o = r296;     // Catch: Throwable -> L711
        com.obric.autogui.operator.a.b.b.f r297 = r1411;
        r1143.p = r297;     // Catch: Throwable -> L711
        e r298 = r1414;
        r1143.q = r298;     // Catch: Throwable -> L711
        Float r299 = r2123;
        r1143.r = r299;     // Catch: Throwable -> L711
        List<C0762d> r300 = r1142;
        r1143.s = r300;     // Catch: Throwable -> L711
        r1143.t = r289;     // Catch: Throwable -> L711
        Integer r301 = r1312;
        r1143.u = r301;     // Catch: Throwable -> L711
        e.C0763d r302 = r276;
        r1143.v = r302;     // Catch: Throwable -> L711
        r1143.w = r279;     // Catch: Throwable -> L711
        e.C0763d r1144 = r302;
        String r303 = r1139;
        r1143.x = r303;     // Catch: Throwable -> L711
        String r1145 = r303;
        r1143.y = null;     // Catch: Throwable -> L711
        r1143.z = null;     // Catch: Throwable -> L711
        r1143.A = null;     // Catch: Throwable -> L711
        float r304 = r1415;
        r1143.B = r304;     // Catch: Throwable -> L711
        z.e r419 = r280;
        float r305 = r1416;
        r1143.C = r305;     // Catch: Throwable -> L709
        z.f r420 = r118;
        z.d r421 = r208;
        long r1146 = r312;
        r1143.D = r1146;     // Catch: Throwable -> L707
        r312 = r1146;
        int r1147 = r1310;
        r1143.H = r1147;     // Catch: Throwable -> L705
        int r1148 = r1710;
        r1143.I = r1148;     // Catch: Throwable -> L705
        int r1149 = r1314;
        r1143.f29618J = r1149;     // Catch: Throwable -> L705
        ?? r1150 = r286;
        r1143.K = r1150 == true ? 1 : 0;     // Catch: Throwable -> L705
        r1143.L = r290;     // Catch: Throwable -> L705
        r1143.M = r287;     // Catch: Throwable -> L705
        r1143.E = r288;     // Catch: Throwable -> L705
        r1143.F = r291;     // Catch: Throwable -> L705
        r1143.P = 4;     // Catch: Throwable -> L705
        r3 = r278.a(r304, r305, r337, r279, r287, r1143);     // Catch: Throwable -> L705
        Object r306 = r1412;
        if (r3 != r306) goto L562;
        return r306;
    L562:
        Integer r1711 = r296;
        Object r1810 = r306;
        c r2124 = r279;
        c r2125 = r2124;
        long r338 = r291;
        int r2100 = r290;
        int r1712 = r1148;
        z.e r1151 = r50;
        j r1811 = r1143;
        z.d r307 = r207;
        int r1812 = r1150 == true ? 1 : 0;
        List<C0762d> r1152 = r300;
        Integer r1713 = r289;
        z.d r1153 = r292;
        z.d r1154 = r293;
        com.obric.autogui.operator.a.b.b.f r1714 = r297;
        e r1715 = r298;
        Float r1716 = r299;
        Integer r2126 = r301;
        z.e r308 = r419;
        z.f r1155 = r420;
        int r1717 = r1147;
        int r1813 = r1149;
        long r1718 = r288;
        z.d r2101 = r1420;
        z.d r2102 = r1417;
        z.d r1156 = r1419;
        z.f r2103 = r1512;
        z.d r2104 = r1511;
        float r309 = r304;
        int r1157 = r287;
        String r422 = r1131;
        z.d r339 = r421;
        float r1158 = r305;
        d r340 = r278;
        long r341 = r312;
    L564:
        z.d r342 = r339;
        r13 = r13;
        com.obric.autogui.common.e r343 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L700
        z.d r344 = r307;
        z.e r2105 = r1151;
        r308.f38503a += AOSystemTools.INSTANCE.bootTimeMillis() - r338;     // Catch: Throwable -> L698
        if (r343.g() == false) goto L1206;
        z.e r345 = r308;
        z.d r1814 = r1156;
        z.d r1815 = r2104;
        z.f r423 = r2103;
        z.d r1816 = r2102;
        z.d r511 = r2101;
        String r1159 = r53;
        r19 = r19;
        String r1910 = r23;
        String r1817 = r1510;
        String r1818 = r1613;
        String r346 = r29;
        String r1911 = r30;
        String r1819 = r16;
        String r1912 = r20;
        r314 = r1610;
        String r1913 = r1612;
        String r1914 = r17;
        String r1915 = r1611;
        String r1916 = r1614;
        if (r2126 != null) goto L633;
        z.d r2010 = r344;
        r29 = r346;
        z.e r2011 = r2105;
        String r1917 = r13;
        z.e r2012 = r345;
        String r2013 = r1159;
        List<C0762d> r347 = r1152;
        z.d r1918 = r342;
        z.f r2014 = r423;
        z.d r1919 = r511;
        r115 = r1153;
    L1098:
        Integer r348 = d.c.b.a.b.a(r2100);     // Catch: Throwable -> L695
        r1144.d();     // Catch: Throwable -> L695
        z.e r349 = r2011;
        long r1160 = r1718;
        r349.f38503a += r1160;     // Catch: Throwable -> L692
        j r350 = r1811;
        r350.f29619a = r340;     // Catch: Throwable -> L692
        r350.f29620b = r1154;     // Catch: Throwable -> L692
        z.e r351 = r2012;
        r350.f29621c = r351;     // Catch: Throwable -> L690
        r350.f29622d = r1155;     // Catch: Throwable -> L690
        r350.f29623e = r115;     // Catch: Throwable -> L690
        r350.f = r349;     // Catch: Throwable -> L690
        z.d r352 = r2010;
        r350.g = r352;     // Catch: Throwable -> L688
        d r1161 = r340;
        c r353 = r2125;
        r350.h = r353;     // Catch: Throwable -> L688
        z.d r354 = r1918;
        r350.i = r354;     // Catch: Throwable -> L686
        r1918 = r354;
        z.d r355 = r1919;
        r350.j = r355;     // Catch: Throwable -> L684
        r1919 = r355;
        r350.k = r1816;     // Catch: Throwable -> L682
        r1816 = r1816;
        r350.l = r1815;     // Catch: Throwable -> L680
        r1815 = r1815;
        r350.m = r1814;     // Catch: Throwable -> L678
        r1814 = r1814;
        z.f r356 = r2014;
        r350.n = r356;     // Catch: Throwable -> L676
        r2014 = r356;
        Integer r357 = r1711;
        r350.o = r357;     // Catch: Throwable -> L688
        Integer r1162 = r357;
        com.obric.autogui.operator.a.b.b.f r358 = r1714;
        r350.p = r358;     // Catch: Throwable -> L688
        e r359 = r1715;
        r350.q = r359;     // Catch: Throwable -> L688
        Float r360 = r1716;
        r350.r = r360;     // Catch: Throwable -> L688
        r350.s = r347;     // Catch: Throwable -> L688
        Integer r361 = r1713;
        r350.t = r361;     // Catch: Throwable -> L688
        String r362 = r1145;
        r350.u = r362;     // Catch: Throwable -> L688
        r350.v = r348;     // Catch: Throwable -> L688
        r350.w = null;     // Catch: Throwable -> L688
        r350.x = null;     // Catch: Throwable -> L688
        float r363 = r309;
        r350.B = r363;     // Catch: Throwable -> L688
        r350.C = r1158;     // Catch: Throwable -> L688
        r350.D = r341;     // Catch: Throwable -> L688
        int r364 = r1717;
        r350.H = r364;     // Catch: Throwable -> L688
        int r365 = r1712;
        r350.I = r365;     // Catch: Throwable -> L688
        int r366 = r1813;
        r350.f29618J = r366;     // Catch: Throwable -> L688
        int r367 = r1812;
        r350.K = r367 == true ? 1 : 0;     // Catch: Throwable -> L688
        r350.P = 5;     // Catch: Throwable -> L688
        Object r368 = ax.a(r1160, r350);     // Catch: Throwable -> L688
        Object r1163 = r1810;
        if (r368 != r1163) goto L674;
        return r1163;
    L674:
        r86 = r341;
        r93 = r347;
        r96 = r348;
        r71 = r350;
        r74 = r351;
        r98 = r1163;
        r78 = r115;
        r91 = r1158;
        r72 = r1155;
        r95 = r362;
        r90 = r359;
        r92 = r360;
        r94 = r361;
        r88 = r364;
        r89 = r365;
        r810 = r366;
        r811 = r367 == true ? 1 : 0;
        r123 = r1816;
        r87 = r1919;
        r99 = r1918;
        r97 = r363;
        r121 = r352;
        r122 = r349;
        r73 = r1154;
        r85 = r1161;
        r126 = r358;
        r213 = r1815;
        r128 = r353;
    L675:
        r217 = r1162;
        r19 = r19;
        r7 = r422;
        r124 = r1814;
        r222 = r1817;
        r28 = r1818;
        r75 = r1819;
        r76 = r1914;
        r79 = r1912;
        r80 = r1915;
        r82 = r1910;
        r5 = r1913;
        r67 = r1911;
        r81 = r1916;
        r127 = r1917;
        r125 = r2014;
        r77 = r2013;
    L676:
        th = th;
        r2014 = r356;
    L697:
        r152 = th;
        r207 = r352;
        r312 = r341;
        r50 = r349;
        r49 = r351;
        r54 = r1154;
        r118 = r1155;
        r19 = r19;
        r2115 = r1816;
        r2114 = r1815;
        r2116 = r1814;
        r222 = r1817;
        r28 = r1818;
        r16 = r1819;
        r17 = r1914;
        r20 = r1912;
        r21 = r1915;
        r23 = r1910;
        r5 = r1913;
        r30 = r1911;
        r22 = r1916;
        r209 = r1919;
        r208 = r1918;
        r13 = r1917;
        r151 = r2014;
    L735:
        r53 = r2013;
    L678:
        th = th;
        r1814 = r1814;
    L680:
        th = th;
        r1815 = r1815;
    L682:
        th = th;
        r1816 = r1816;
    L684:
        th = th;
        r1919 = r355;
    L686:
        th = th;
        r1918 = r354;
    L688:
        th = th;
    L690:
        th = th;
    L694:
        r352 = r2010;
    L692:
        th = th;
        r351 = r2012;
    L695:
        th = th;
        r351 = r2012;
        r352 = r2010;
        r349 = r2011;
        goto L697
    L633:
        r29 = r346;
        r1919 = r511;
        r1917 = r13;
        r1918 = r342;
        r2014 = r423;
        r2012 = r345;
        r2010 = r344;
        r2013 = r1159;
        r2011 = r2105;
        r115 = r1153;
        r347 = r1152;
        r347.add(new C0762d(((Number) ZeusTransformUtils.preCheckCast(r2126, Number.class, r13)).intValue(), r2100, r2124, 0, 8, null));     // Catch: Throwable -> L642
        if (r347.size() <= 5) goto L640;
        r347.remove(0);     // Catch: Throwable -> L642
    L640:
        x r369 = x.f38692a;     // Catch: Throwable -> L642
    L642:
        th = move-exception;
        r152 = th;
        r312 = r341;
        r54 = r1154;
        r118 = r1155;
        r19 = r19;
        r2115 = r1816;
        r2114 = r1815;
        r2116 = r1814;
        r222 = r1817;
        r28 = r1818;
        r16 = r1819;
        r17 = r1914;
        r20 = r1912;
        r21 = r1915;
        r23 = r1910;
        r5 = r1913;
        r30 = r1911;
        r22 = r1916;
        r209 = r1919;
        r208 = r1918;
        r13 = r1917;
        r151 = r2014;
        r49 = r2012;
        r207 = r2010;
        r50 = r2011;
    L644:
        th = move-exception;
        r115 = r1153;
        r152 = th;
        r312 = r341;
        r53 = r1159;
        r54 = r1154;
        r118 = r1155;
        r19 = r19;
        r2115 = r1816;
        r2114 = r1815;
        r2116 = r1814;
        r222 = r1817;
        r28 = r1818;
        r16 = r1819;
        r17 = r1914;
        r20 = r1912;
        r21 = r1915;
        r23 = r1910;
        r5 = r1913;
        r30 = r1911;
        r22 = r1916;
        r209 = r511;
        r208 = r342;
        r151 = r423;
        r49 = r345;
        r207 = r344;
        r50 = r2105;
        goto L1160
    L1206:
        com.obric.autogui.common.e r370 = com.obric.autogui.common.e.f29014b.b();     // Catch: Throwable -> L627
        StringBuilder r371 = new StringBuilder().append("x=").append(r309).append(",y=").append(r1158).append(",steps=").append(r1157).append(",dbg='");     // Catch: Throwable -> L627
        if (ZeusTransformUtils.instanceOf(r343, com.obric.autogui.common.a.class) == true) goto L1270;
        com.obric.autogui.common.a r372 = null;
    L575:
        if (r372 == null) goto L578;
        String r373 = r372.c();     // Catch: Throwable -> L572
    L579:
        ?? r374 = com.obric.autogui.common.b.a(r370, "scrol_f", r371.append(r373).append('\'').toString(), false, null, 0, 28, null);     // Catch: Throwable -> L627
        r1155.f38504a = r374;     // Catch: Throwable -> L627
        n.a r375 = n.f38560a;     // Catch: Throwable -> L623
        d r376 = (d) ZeusTransformUtils.preCheckCast(r340, r1610, r13);     // Catch: Throwable -> L623
        long r377 = AOSystemTools.INSTANCE.bootTimeMillis() - r341;     // Catch: Throwable -> L623
        com.obric.autogui.common.e r378 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r1155.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L623
        if (r378 != null) goto L583;
    L585:
        boolean r379 = false;
    L586:
        Object r380 = r1155.f38504a;     // Catch: Throwable -> L623
        if (ZeusTransformUtils.instanceOf(r380, com.obric.autogui.common.a.class) == false) goto L589;
        com.obric.autogui.common.a r381 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r380, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L623
    L590:
        if (r381 == null) goto L593;
        String r382 = r381.b();     // Catch: Throwable -> L623
        if (r382 == null) goto L593;
    L597:
        if (r1154.f38502a <= 0) goto L599;
        long r383 = r308.f38503a / ((long) r1154.f38502a);     // Catch: Throwable -> L623
    L601:
        if (r1153.f38502a <= 0) goto L605;
        z.e r384 = r2105;
        ?? r2127 = r374;
        r24 = r384.f38503a / ((long) r1153.f38502a);     // Catch: Throwable -> L621
        r2127 = r2127;
    L606:
        long r385 = r24;
        IAutoActionTrackingApi r386 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L621
        JSONObject r1164 = new JSONObject();     // Catch: Throwable -> L621
        String r1165 = r23;
        if (r379 == false) goto L609;
        int r1166 = 1;
    L610:
        r1164.put(r1165, r1166);     // Catch: Throwable -> L621
        r1164.put(r1614, r382);     // Catch: Throwable -> L621
        r1164.put(r1611, r1154.f38502a);     // Catch: Throwable -> L621
        r1164.put(r20, r377);     // Catch: Throwable -> L621
        r1164.put(r19, r383);     // Catch: Throwable -> L621
        r1164.put(r53, r1153.f38502a);     // Catch: Throwable -> L621
        r1164.put(r17, r308.f38503a);     // Catch: Throwable -> L621
        r1164.put(r16, r384.f38503a);     // Catch: Throwable -> L621
        r1164.put(r30, r385);     // Catch: Throwable -> L621
        r1164.put(r29, r344.f38502a);     // Catch: Throwable -> L621
        x r387 = x.f38692a;     // Catch: Throwable -> L621
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r386, "oauto_scrollwheel_exec", r1164, false, false, null, 28, null);     // Catch: Throwable -> L621
        IAutoActionTrackingApi r388 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L621
        JSONObject r389 = new JSONObject();     // Catch: Throwable -> L621
        String r1167 = r1612;
        if (r379 == false) goto L613;
        int r390 = 1;
    L614:
        r389.put(r1167, r390);     // Catch: Throwable -> L621
        r389.put(r1613, r342.f38502a);     // Catch: Throwable -> L621
        r389.put(r1510, r2101.f38502a);     // Catch: Throwable -> L621
        r389.put("ocr_retry_cnt", r2102.f38502a);     // Catch: Throwable -> L621
        String r391 = (String) ZeusTransformUtils.preCheckCast(r2103.f38504a, String.class, r13);     // Catch: Throwable -> L621
        if (r391 != null) goto L619;
        if (r379 == false) goto L618;
        r391 = "success";
        goto L619
    L618:
        r391 = SensitiveType.UNKNOWN;
    L619:
        r389.put("ocr_fail_code", r391);     // Catch: Throwable -> L621
        r389.put("ocr_fail_num_null_cnt", r2104.f38502a);     // Catch: Throwable -> L621
        r389.put("ocr_fail_ret_null_cnt", r1156.f38502a);     // Catch: Throwable -> L621
        x r392 = x.f38692a;     // Catch: Throwable -> L621
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r388, "oauto_scrollwheel_ocr_stat", r389, false, false, null, 28, null);     // Catch: Throwable -> L621
        n.f(x.f38692a);     // Catch: Throwable -> L621
        ?? r2128 = r2127;
    L626:
        return r2128;
    L613:
        r390 = 0;
        goto L614
    L609:
        r1166 = 0;
    L621:
        th = th;
    L625:
        n.a r393 = n.f38560a;
        n.f(d.o.a(th));
        r2128 = r2127;
        goto L626
    L605:
        r2127 = r374;
        r384 = r2105;
        goto L606
    L599:
        r383 = 0;
    L593:
        if (r379 == false) goto L595;
        r382 = "success";
        goto L597
    L595:
        r382 = SensitiveType.UNKNOWN;
        goto L597
    L589:
        r381 = null;
        goto L590
    L583:
        if (r378.g() != true) goto L585;
        r379 = true;
    L623:
        th = th;
        r2127 = r374;
    L572:
        th = move-exception;
        r152 = th;
        r312 = r341;
        r115 = r1153;
        r54 = r1154;
        r118 = r1155;
        r2116 = r1156;
        r2114 = r2104;
        r151 = r2103;
        r2115 = r2102;
        r209 = r2101;
        r50 = r2105;
        r208 = r342;
        r207 = r344;
        r19 = r19;
        r23 = r23;
        r222 = r1510;
        r28 = r1613;
        r29 = r29;
        r30 = r30;
        r16 = r16;
        r20 = r20;
        r5 = r1612;
        r17 = r17;
        r21 = r1611;
        r22 = r1614;
        r49 = r308;
    L423:
        r53 = r53;
        goto L1160
    L578:
        r373 = null;
        goto L579
    L1270:
        r372 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r343, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L572
    L627:
        th = move-exception;
        r152 = th;
        r207 = r344;
        r312 = r341;
        r50 = r2105;
        r49 = r308;
        r115 = r1153;
        r54 = r1154;
        r118 = r1155;
        r208 = r342;
        r151 = r2103;
        r209 = r2101;
        r53 = r53;
        r19 = r19;
        r23 = r23;
        r222 = r1510;
        r28 = r1613;
        r29 = r29;
        r30 = r30;
        r16 = r16;
        r20 = r20;
        r5 = r1612;
        r17 = r17;
        r21 = r1611;
        r22 = r1614;
        r2115 = r2102;
        r2114 = r2104;
        r2116 = r1156;
    L698:
        th = move-exception;
        r115 = r1153;
        r152 = th;
        r207 = r344;
        r312 = r341;
        r50 = r2105;
        r49 = r308;
        r54 = r1154;
        r118 = r1155;
        r53 = r53;
        r19 = r19;
        r23 = r23;
        r222 = r1510;
        r28 = r1613;
        r29 = r29;
        r30 = r30;
        r16 = r16;
        r20 = r20;
        r5 = r1612;
        r17 = r17;
        r21 = r1611;
        r22 = r1614;
        r2115 = r2102;
        r2114 = r2104;
        r2116 = r1156;
        r209 = r2101;
        r208 = r342;
        r151 = r2103;
    L700:
        th = move-exception;
        String r1920 = r13;
        z.d r1820 = r1156;
        z.f r2015 = r2103;
        z.d r1821 = r2102;
        r2013 = r53;
        r19 = r19;
        String r1921 = r23;
        String r1822 = r1510;
        String r1823 = r1613;
        r29 = r29;
        String r1922 = r30;
        String r1824 = r16;
        String r1923 = r20;
        String r1924 = r1612;
        String r1925 = r17;
        String r1926 = r1611;
        String r1927 = r1614;
        Throwable r394 = th;
        r292 = r1153;
        r293 = r1154;
        r420 = r1155;
        r1417 = r1821;
        r1511 = r2104;
        r1419 = r1820;
        r1420 = r2101;
        r421 = r342;
        r1512 = r2015;
        r207 = r307;
        r50 = r1151;
        z.e r395 = r308;
        r291 = r338;
    L1124:
        r395.f38503a += AOSystemTools.INSTANCE.bootTimeMillis() - r291;     // Catch: Throwable -> L733
        throw r394;     // Catch: Throwable -> L733
    L733:
        th = move-exception;
        r152 = th;
        r312 = r341;
        r50 = r50;
        r207 = r207;
        r19 = r19;
        r115 = r292;
        r54 = r293;
        r118 = r420;
        r208 = r421;
        r209 = r1420;
        r2115 = r1417;
        r2116 = r1419;
        r151 = r1512;
        r2114 = r1511;
        r222 = r1822;
        r28 = r1823;
        r16 = r1824;
        r17 = r1925;
        r20 = r1923;
        r21 = r1926;
        r23 = r1921;
        r5 = r1924;
        r30 = r1922;
        r22 = r1927;
        r13 = r1920;
        r49 = r395;
    L705:
        th = th;
    L730:
        r1920 = r13;
        r2013 = r53;
        r19 = r19;
        r1921 = r23;
        r1822 = r1510;
        r1823 = r1613;
        r29 = r29;
        r1922 = r30;
        r1824 = r16;
        r1923 = r20;
        r1924 = r1612;
        r1925 = r17;
        r1926 = r1611;
        r1927 = r1614;
        r341 = r312;
        r394 = th;
        r395 = r419;
    L707:
        th = th;
        r312 = r1146;
    L709:
        th = th;
    L729:
        r420 = r118;
        r421 = r208;
    L711:
        th = th;
    L728:
        r419 = r280;
    L713:
        th = th;
        r1512 = r151;
    L715:
        th = th;
        r1419 = r1419;
    L717:
        th = th;
        r1511 = r295;
    L719:
        th = th;
        r1417 = r294;
    L721:
        th = th;
        r1420 = r1420;
    L723:
        th = th;
    L727:
        r293 = r54;
    L725:
        th = th;
        r292 = r277;
    L736:
        th = th;
    L746:
        r312 = r312;
        r152 = th;
        r50 = r50;
        r207 = r207;
        r115 = r277;
        r54 = r54;
        r13 = r13;
        r49 = r280;
        r118 = r118;
        r208 = r208;
        r53 = r53;
        r19 = r19;
        r23 = r23;
        r209 = r1420;
        r2115 = r1417;
        r2116 = r1419;
        r151 = r151;
        r2114 = r1511;
        r222 = r1510;
        r28 = r1613;
        r29 = r29;
        r30 = r30;
        r16 = r16;
        r20 = r20;
        r5 = r1612;
        r17 = r17;
        r21 = r1611;
        r22 = r1614;
    L738:
        th = th;
        r1420 = r209;
    L534:
        r287 = 1;
    L532:
        th = th;
    L525:
        r152 = th;
        r2115 = r1417;
        r2116 = r1419;
        r2114 = r1511;
    L506:
        r222 = r1510;
        r28 = r1613;
        r29 = r29;
        r30 = r30;
        r20 = r20;
        r5 = r1612;
        r17 = r17;
        r21 = r1611;
        r22 = r1614;
        r115 = r277;
        r49 = r280;
        r16 = r16;
    L520:
        th = th;
        r1417 = r1417;
        goto L525
    L522:
        r1142 = r282;
        ?? r396 = r283;
    L527:
        r285 = r1113;
        r286 = r396;
    L523:
        th = th;
        r1417 = r1417;
        r1511 = r1511;
    L526:
        r1142 = r1413;
        r396 = r1019;
    L741:
        th = th;
    L745:
        r277 = r277;
        r54 = r54;
        r1419 = r1418;
        r280 = r280;
        r1420 = r209;
        r1511 = r1511;
        goto L746
    L1142:
        r281 = r1141.intValue();     // Catch: Throwable -> L504
    L504:
        th = move-exception;
        r152 = th;
        r2115 = r1417;
        r2116 = r1418;
        r2114 = r1511;
    L743:
        th = th;
        r151 = r151;
        goto L745
    L1240:
        Loog.INSTANCE.w(r1131, "⚠️ 连续" + r1140 + "次文本无变化，停止滚动");     // Catch: Throwable -> L491
        r276.d();     // Catch: Throwable -> L491
        ?? r397 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "scrol_stuck", "text=" + r276.b() + ", attempts=" + r277.f38502a, false, null, 0, 28, null);     // Catch: Throwable -> L491
        r118.f38504a = r397;     // Catch: Throwable -> L491
        n.a r398 = n.f38560a;     // Catch: Throwable -> L487
        d r399 = (d) ZeusTransformUtils.preCheckCast(r278, r1610, r13);     // Catch: Throwable -> L487
        long r400 = AOSystemTools.INSTANCE.bootTimeMillis() - r312;     // Catch: Throwable -> L487
        com.obric.autogui.common.e r401 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r118.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L487
        if (r401 != null) goto L448;
    L450:
        boolean r402 = false;
    L451:
        Object r403 = r118.f38504a;     // Catch: Throwable -> L487
        if (ZeusTransformUtils.instanceOf(r403, com.obric.autogui.common.a.class) == false) goto L454;
        com.obric.autogui.common.a r404 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r403, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L487
    L455:
        if (r404 == null) goto L458;
        String r405 = r404.b();     // Catch: Throwable -> L487
        if (r405 == null) goto L458;
    L462:
        if (r54.f38502a <= 0) goto L464;
        long r1168 = r280.f38503a / ((long) r54.f38502a);     // Catch: Throwable -> L487
    L466:
        if (r277.f38502a <= 0) goto L468;
        z.e r1169 = r50;
        r24 = r50.f38503a / ((long) r277.f38502a);     // Catch: Throwable -> L487
    L469:
        long r1170 = r24;
        IAutoActionTrackingApi r3100 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L487
        JSONObject r1171 = new JSONObject();     // Catch: Throwable -> L487
        ?? r2129 = r397;
        if (r402 == false) goto L473;
        int r1172 = 1;
    L1190:
        r1171.put(r23, r1172);     // Catch: Throwable -> L485
        r1171.put(r1614, r405);     // Catch: Throwable -> L485
        r1171.put(r1611, r54.f38502a);     // Catch: Throwable -> L485
        r1171.put(r20, r400);     // Catch: Throwable -> L485
        r1171.put(r19, r1168);     // Catch: Throwable -> L485
        r1171.put(r53, r277.f38502a);     // Catch: Throwable -> L485
        r1171.put(r17, r280.f38503a);     // Catch: Throwable -> L485
        r1171.put(r16, r1169.f38503a);     // Catch: Throwable -> L485
        r1171.put(r30, r1170);     // Catch: Throwable -> L485
        r1171.put(r29, r207.f38502a);     // Catch: Throwable -> L485
        x r406 = x.f38692a;     // Catch: Throwable -> L485
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3100, "oauto_scrollwheel_exec", r1171, false, false, null, 28, null);     // Catch: Throwable -> L485
        IAutoActionTrackingApi r407 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L485
        JSONObject r408 = new JSONObject();     // Catch: Throwable -> L485
        if (r402 == false) goto L477;
        int r409 = 1;
    L478:
        r408.put(r1612, r409);     // Catch: Throwable -> L485
        r408.put(r1613, r208.f38502a);     // Catch: Throwable -> L485
        r408.put(r1510, r209.f38502a);     // Catch: Throwable -> L485
        r408.put("ocr_retry_cnt", r1417.f38502a);     // Catch: Throwable -> L485
        String r424 = (String) ZeusTransformUtils.preCheckCast(r151.f38504a, String.class, r13);     // Catch: Throwable -> L485
        if (r424 != null) goto L483;
        if (r402 == false) goto L482;
        r424 = "success";
        goto L483
    L482:
        r424 = SensitiveType.UNKNOWN;
    L483:
        r408.put("ocr_fail_code", r424);     // Catch: Throwable -> L485
        r408.put("ocr_fail_num_null_cnt", r1511.f38502a);     // Catch: Throwable -> L485
        r408.put("ocr_fail_ret_null_cnt", r1418.f38502a);     // Catch: Throwable -> L485
        x r425 = x.f38692a;     // Catch: Throwable -> L485
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r407, "oauto_scrollwheel_ocr_stat", r408, false, false, null, 28, null);     // Catch: Throwable -> L485
        n.f(x.f38692a);     // Catch: Throwable -> L485
        ?? r2130 = r2129;
    L490:
        return r2130;
    L477:
        r409 = 0;
    L485:
        th = th;
    L489:
        n.a r426 = n.f38560a;
        n.f(d.o.a(th));
        r2130 = r2129;
        goto L490
    L473:
        r1172 = 0;
        goto L1190
    L468:
        r1169 = r50;
        goto L469
    L464:
        r1168 = 0;
    L458:
        if (r402 == false) goto L460;
        r405 = "success";
        goto L462
    L460:
        r405 = SensitiveType.UNKNOWN;
        goto L462
    L454:
        r404 = null;
        goto L455
    L448:
        if (r401.g() != true) goto L450;
        r402 = true;
    L487:
        th = th;
        r2129 = r397;
    L491:
        th = th;
        z.d r1173 = r207;
        z.e r1174 = r50;
    L497:
        r2115 = r1417;
        r151 = r151;
        r2114 = r1511;
        r2116 = r1418;
        r209 = r209;
        r208 = r208;
        r207 = r1173;
        r50 = r1174;
        r23 = r23;
        r222 = r1510;
        r28 = r1613;
        r5 = r1612;
        r53 = r53;
        r19 = r19;
        r21 = r1611;
        r22 = r1614;
    L420:
        r152 = th;
    L493:
        th = th;
        r1174 = r50;
        r1173 = r207;
    L495:
        th = th;
        r1174 = r50;
        r1173 = r207;
        goto L497
    L499:
        r1710 = 0;
    L747:
        th = move-exception;
        r312 = r312;
        r152 = th;
        r13 = r13;
        r50 = r50;
        r207 = r207;
        r115 = r277;
        r54 = r54;
        r49 = r280;
        r118 = r118;
        r208 = r208;
        r30 = r30;
        r16 = r16;
        r17 = r17;
        r20 = r20;
        r23 = r23;
        r209 = r209;
        r2115 = r1417;
        r2116 = r1418;
        r151 = r151;
        r222 = r1510;
        r28 = r1613;
        r2114 = r1511;
        r5 = r1612;
        r53 = r53;
        r19 = r19;
        r21 = r1611;
        r22 = r1614;
        goto L1160
    L1102:
        Loog r427 = Loog.INSTANCE;     // Catch: Throwable -> L421
        String r812 = r21;
        Integer r1175 = r2122;
        r427.w(r1131, new StringBuilder().append("⚠️ 无法确定滚动方向，当前值='").append(r276.b()).append("', 目标=").append(r1175).toString());     // Catch: Throwable -> L418
        r276.d();     // Catch: Throwable -> L418
        ?? r428 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "dir_confl", "current=" + r276.b() + ", target=" + r1175, false, null, 0, 28, null);     // Catch: Throwable -> L418
        r118.f38504a = r428;     // Catch: Throwable -> L418
        n.a r429 = n.f38560a;     // Catch: Throwable -> L415
        d r430 = (d) ZeusTransformUtils.preCheckCast(r278, r1610, r13);     // Catch: Throwable -> L415
        long r431 = AOSystemTools.INSTANCE.bootTimeMillis() - r312;     // Catch: Throwable -> L415
        com.obric.autogui.common.e r432 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r118.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L415
        if (r432 != null) goto L379;
    L381:
        boolean r433 = false;
    L382:
        Object r434 = r118.f38504a;     // Catch: Throwable -> L415
        if (ZeusTransformUtils.instanceOf(r434, com.obric.autogui.common.a.class) == false) goto L385;
        com.obric.autogui.common.a r435 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r434, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L415
    L386:
        if (r435 == null) goto L389;
        String r436 = r435.b();     // Catch: Throwable -> L415
        if (r436 == null) goto L389;
    L393:
        if (r54.f38502a <= 0) goto L395;
        long r1176 = r1135.f38503a / ((long) r54.f38502a);     // Catch: Throwable -> L415
    L397:
        if (r277.f38502a <= 0) goto L399;
        z.e r1177 = r1136;
        z.e r1178 = r1177;
        r24 = r1177.f38503a / ((long) r277.f38502a);     // Catch: Throwable -> L415
    L400:
        long r1179 = r24;
        IAutoActionTrackingApi r3101 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L415
        JSONObject r1180 = new JSONObject();     // Catch: Throwable -> L415
        if (r433 == false) goto L403;
        int r1181 = 1;
    L404:
        r1180.put(r272, r1181);     // Catch: Throwable -> L415
        r1180.put(r22, r436);     // Catch: Throwable -> L415
        r1180.put(r812, r54.f38502a);     // Catch: Throwable -> L415
        r1180.put(r20, r431);     // Catch: Throwable -> L415
        r1180.put(r19, r1176);     // Catch: Throwable -> L415
        r1180.put(r53, r277.f38502a);     // Catch: Throwable -> L415
        r1180.put(r17, r1135.f38503a);     // Catch: Throwable -> L415
        r1180.put(r16, r1178.f38503a);     // Catch: Throwable -> L415
        r1180.put(r30, r1179);     // Catch: Throwable -> L415
        r1180.put(r29, r1137.f38502a);     // Catch: Throwable -> L415
        x r437 = x.f38692a;     // Catch: Throwable -> L415
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3101, "oauto_scrollwheel_exec", r1180, false, false, null, 28, null);     // Catch: Throwable -> L415
        IAutoActionTrackingApi r438 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L415
        JSONObject r1182 = new JSONObject();     // Catch: Throwable -> L415
        String r1183 = r5;
        if (r433 == false) goto L407;
        int r439 = 1;
    L408:
        r1182.put(r1183, r439);     // Catch: Throwable -> L415
        r1182.put(r28, r1219.f38502a);     // Catch: Throwable -> L415
        r1182.put(r222, r1318.f38502a);     // Catch: Throwable -> L415
        r1182.put("ocr_retry_cnt", r1317.f38502a);     // Catch: Throwable -> L415
        String r440 = (String) ZeusTransformUtils.preCheckCast(r1315.f38504a, String.class, r13);     // Catch: Throwable -> L415
        if (r440 != null) goto L413;
        if (r433 == false) goto L412;
        r440 = "success";
        goto L413
    L412:
        r440 = SensitiveType.UNKNOWN;
    L413:
        r1182.put("ocr_fail_code", r440);     // Catch: Throwable -> L415
        r1182.put("ocr_fail_num_null_cnt", r1316.f38502a);     // Catch: Throwable -> L415
        r1182.put("ocr_fail_ret_null_cnt", r1313.f38502a);     // Catch: Throwable -> L415
        x r441 = x.f38692a;     // Catch: Throwable -> L415
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r438, "oauto_scrollwheel_ocr_stat", r1182, false, false, null, 28, null);     // Catch: Throwable -> L415
        n.f(x.f38692a);     // Catch: Throwable -> L415
    L417:
        return r428;
    L407:
        r439 = 0;
        goto L408
    L403:
        r1181 = 0;
        goto L404
    L399:
        r1178 = r1136;
        goto L400
    L395:
        r1176 = 0;
    L389:
        if (r433 == false) goto L391;
        r436 = "success";
        goto L393
    L391:
        r436 = SensitiveType.UNKNOWN;
        goto L393
    L385:
        r435 = null;
        goto L386
    L379:
        if (r432.g() != true) goto L381;
        r433 = true;
    L415:
        th = move-exception;
        n.a r442 = n.f38560a;
        n.f(d.o.a(th));
    L418:
        th = th;
        r280 = r1135;
        z.d r1184 = r1137;
        r23 = r272;
        r2114 = r1316;
        r207 = r1184;
        r50 = r1136;
        r208 = r1219;
        r53 = r53;
        r19 = r19;
        r21 = r812;
        r22 = r22;
        r209 = r1318;
        r2115 = r1317;
        r2116 = r1313;
        r151 = r1315;
    L421:
        th = move-exception;
        String r443 = r21;
        z.e r444 = r1135;
        z.d r1185 = r1137;
        r23 = r272;
        r2114 = r1316;
        r54 = r54;
        r118 = r118;
        r207 = r1185;
        r312 = r312;
        r50 = r1136;
        r208 = r1219;
        r30 = r30;
        r17 = r17;
        r19 = r19;
        r20 = r20;
        r22 = r22;
        r209 = r1318;
        r2115 = r1317;
        r2116 = r1313;
        r151 = r1315;
        r152 = th;
        r115 = r277;
        r21 = r443;
        r49 = r444;
        r16 = r16;
        r13 = r13;
    L749:
        th = move-exception;
        z.d r1186 = r1137;
        r312 = r312;
        r152 = th;
        r50 = r1136;
        r207 = r1186;
        r115 = r277;
        r49 = r1135;
        r118 = r118;
        r208 = r1219;
        r20 = r20;
        r209 = r1318;
        r2115 = r1317;
        r2116 = r1313;
        r151 = r1315;
        r2114 = r1316;
    L753:
        r23 = r272;
        r54 = r54;
    L751:
        th = move-exception;
        String r1928 = r1133;
        z.d r1187 = r1137;
        r312 = r312;
        r152 = th;
        r50 = r1136;
        r207 = r1187;
        r115 = r277;
        r49 = r1135;
        r118 = r118;
        r208 = r1219;
        r209 = r1318;
        r2115 = r1317;
        r2116 = r1313;
        r151 = r1315;
        r2114 = r1316;
        r20 = r1928;
    L338:
        th = th;
        r13 = r13;
        r29 = r29;
        r53 = r53;
    L345:
        r30 = r1128;
        r17 = r1129;
        r20 = r1133;
        r50 = r1132;
        r312 = r1125;
        r118 = r335;
        r2116 = r336;
        r151 = r332;
        r2114 = r417;
        r2115 = r1127;
        r209 = r416;
        r208 = r415;
        r207 = r413;
        r49 = r510;
        r19 = r19;
        r152 = th;
        r23 = r272;
        r21 = r21;
        r16 = r1134;
        r22 = r1130;
        r115 = r275;
        r54 = r412;
    L340:
        th = th;
    L344:
        r28 = r271;
    L342:
        th = th;
        r222 = r274;
        goto L344
    L1238:
        z.d r3102 = r1109;
        Loog.INSTANCE.e(r1210, "无法分析滚轮步长，终止任务");     // Catch: Throwable -> L326
        ?? r445 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "stp_anal_f", "x=" + r1126 + ", y=" + r1124 + ", err=" + r269.h(), false, null, 0, 28, null);     // Catch: Throwable -> L326
        r1104.f38504a = r445;     // Catch: Throwable -> L326
        n.a r446 = n.f38560a;     // Catch: Throwable -> L322
        d r447 = (d) ZeusTransformUtils.preCheckCast(r264, r1211, r13);     // Catch: Throwable -> L322
        z.d r3103 = r1116;
        long r1188 = AOSystemTools.INSTANCE.bootTimeMillis() - r1125;     // Catch: Throwable -> L322
        com.obric.autogui.common.e r448 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r1104.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L322
        if (r448 != null) goto L283;
    L285:
        boolean r449 = false;
    L286:
        Object r450 = r1104.f38504a;     // Catch: Throwable -> L322
        if (ZeusTransformUtils.instanceOf(r450, com.obric.autogui.common.a.class) == false) goto L289;
        com.obric.autogui.common.a r451 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r450, com.obric.autogui.common.a.class, r13);     // Catch: Throwable -> L322
    L290:
        if (r451 == null) goto L293;
        String r452 = r451.b();     // Catch: Throwable -> L322
        if (r452 == null) goto L293;
    L297:
        if (r265.f38502a <= 0) goto L299;
        long r1189 = r238.f38503a / ((long) r265.f38502a);     // Catch: Throwable -> L322
    L301:
        if (r1103.f38502a <= 0) goto L304;
        r24 = r266.f38503a / ((long) r1103.f38502a);     // Catch: Throwable -> L322
    L304:
        long r453 = r24;
        IAutoActionTrackingApi r454 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L322
        JSONObject r455 = new JSONObject();     // Catch: Throwable -> L322
        ?? r2131 = r445;
        String r456 = r1218;
        if (r449 == false) goto L308;
        int r1190 = 1;
    L1196:
        r455.put(r456, r1190);     // Catch: Throwable -> L320
        r455.put(r1217, r452);     // Catch: Throwable -> L320
        r455.put(r1216, r265.f38502a);     // Catch: Throwable -> L320
        r455.put(r1215, r1188);     // Catch: Throwable -> L320
        r455.put(r19, r1189);     // Catch: Throwable -> L320
        r455.put(r1214, r1103.f38502a);     // Catch: Throwable -> L320
        r455.put(r1213, r238.f38503a);     // Catch: Throwable -> L320
        r455.put(r1212, r266.f38503a);     // Catch: Throwable -> L320
        r455.put(r1117, r453);     // Catch: Throwable -> L320
        r455.put(r29, r237.f38502a);     // Catch: Throwable -> L320
        x r457 = x.f38692a;     // Catch: Throwable -> L320
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r454, "oauto_scrollwheel_exec", r455, false, false, null, 28, null);     // Catch: Throwable -> L320
        IAutoActionTrackingApi r458 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L320
        JSONObject r459 = new JSONObject();     // Catch: Throwable -> L320
        String r460 = r1118;
        if (r449 == false) goto L312;
        int r461 = 1;
    L313:
        r459.put(r460, r461);     // Catch: Throwable -> L320
        r459.put(r1119, r3103.f38502a);     // Catch: Throwable -> L320
        r459.put(r1120, r3102.f38502a);     // Catch: Throwable -> L320
        r459.put("ocr_retry_cnt", r1127.f38502a);     // Catch: Throwable -> L320
        String r462 = (String) ZeusTransformUtils.preCheckCast(r332.f38504a, String.class, r13);     // Catch: Throwable -> L320
        if (r462 != null) goto L318;
        if (r449 == false) goto L317;
        r462 = "success";
        goto L318
    L317:
        r462 = SensitiveType.UNKNOWN;
    L318:
        r459.put("ocr_fail_code", r462);     // Catch: Throwable -> L320
        r459.put("ocr_fail_num_null_cnt", r328.f38502a);     // Catch: Throwable -> L320
        r459.put("ocr_fail_ret_null_cnt", r262.f38502a);     // Catch: Throwable -> L320
        x r463 = x.f38692a;     // Catch: Throwable -> L320
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r458, "oauto_scrollwheel_ocr_stat", r459, false, false, null, 28, null);     // Catch: Throwable -> L320
        n.f(x.f38692a);     // Catch: Throwable -> L320
        ?? r2132 = r2131;
    L325:
        return r2132;
    L312:
        r461 = 0;
    L320:
        th = th;
    L324:
        n.a r464 = n.f38560a;
        n.f(d.o.a(th));
        r2132 = r2131;
        goto L325
    L308:
        r1190 = 0;
        goto L1196
    L299:
        r1189 = 0;
    L293:
        if (r449 == false) goto L295;
        r452 = "success";
        goto L297
    L295:
        r452 = SensitiveType.UNKNOWN;
        goto L297
    L289:
        r451 = null;
        goto L290
    L283:
        if (r448.g() != true) goto L285;
        r449 = true;
    L322:
        th = th;
        r2131 = r445;
    L326:
        th = th;
        z.d r465 = r3102;
    L330:
        r13 = r13;
        r2114 = r328;
        r54 = r265;
        r207 = r237;
        r49 = r238;
        r50 = r266;
        r312 = r1125;
        r115 = r1103;
        r118 = r1104;
        r2116 = r262;
        r151 = r332;
        r2115 = r1127;
        r209 = r465;
        r208 = r1116;
    L354:
        r19 = r19;
        r222 = r1120;
        r28 = r1119;
        r5 = r1118;
        r30 = r1117;
        r16 = r1212;
        r17 = r1213;
        r21 = r1216;
        r22 = r1217;
        r23 = r1218;
        r53 = r1214;
        r20 = r1215;
    L986:
        r152 = th;
    L328:
        th = th;
        r465 = r1109;
    L346:
        th = th;
        z.d r466 = r1127;
    L353:
        r13 = r13;
        r50 = r266;
        r312 = r1125;
        r115 = r1103;
        r118 = r1104;
        r2116 = r262;
        r151 = r332;
        r54 = r265;
        r2114 = r328;
        r2115 = r466;
        r209 = r1109;
        r208 = r1116;
        r207 = r237;
        r49 = r238;
    L348:
        th = th;
        r466 = r239;
    L355:
        th = th;
    L367:
        r312 = r2118;
        r2115 = r239;
        r13 = r1108;
        r50 = r248;
        r2114 = r323;
        r54 = r325;
        r2116 = r324;
        r151 = r1121;
        r209 = r1109;
        r208 = r1116;
        r207 = r237;
        r115 = r1103;
        r118 = r1104;
        r49 = r238;
    L357:
        th = th;
        r2118 = r2118;
    L359:
        th = th;
    L366:
        r324 = r240;
        r325 = r232;
    L361:
        th = th;
    L365:
        r323 = r241;
    L363:
        th = th;
        r248 = r242;
        goto L365
    L368:
        Integer r467 = r177;
        z.f r512 = r1104;
        r13 = r1108;
        j r3104 = r1107;
        boolean r1020 = r1019 == true ? 1 : 0;
        r222 = r1120;
        r28 = r1119;
        r21 = r1216;
        r1610 = r1211;
        r1133 = r1215;
        r1131 = r1210;
        r272 = r1218;
        r312 = r2118;
        r1317 = r239;
        r1415 = r1110;
        r278 = r235;
        r1314 = r1122;
        r1319 = r1014;
        r1411 = r1011;
        r1136 = r242;
        r1413 = r1112;
        r1410 = r1114;
        r1312 = r1115;
        r1316 = r241;
        r54 = r232;
        r1313 = r240;
        r1310 = r910;
        r1414 = r1010;
        r1416 = r1012;
        r1311 = r3104;
        r1412 = r1111;
        r2122 = r467;
        r1315 = r1121;
        r1318 = r1109;
        r1219 = r1116;
        r1137 = r237;
        r277 = r1103;
        r118 = r512;
        r1135 = r238;
        r2123 = r92;
        r5 = r1118;
        r30 = r1117;
        r16 = r1212;
        r17 = r1213;
        r22 = r1217;
        r53 = r1214;
        r276 = r236;
        goto L1172
    L1220:
        Integer r468 = r236.c();     // Catch: Throwable -> L252
        Loog.INSTANCE.i(r7, "✅ 成功滚动到目标数字: " + r177 + " (共滚动" + r1103.f38502a + "次)");     // Catch: Throwable -> L252
        r236.d();     // Catch: Throwable -> L252
        ?? r469 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.a(), "success", "tgt=" + r177 + ";obs=" + r468 + ";at=" + r1103.f38502a + ";ocrF=" + r204 + ";src=ocr", false, null, 0, 28, null);     // Catch: Throwable -> L252
        r1104.f38504a = r469;     // Catch: Throwable -> L252
        n.a r470 = n.f38560a;     // Catch: Throwable -> L249
        d r471 = (d) ZeusTransformUtils.preCheckCast(r235, r314, r233);     // Catch: Throwable -> L249
        long r472 = AOSystemTools.INSTANCE.bootTimeMillis() - r197;     // Catch: Throwable -> L249
        com.obric.autogui.common.e r473 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r1104.f38504a, com.obric.autogui.common.e.class, r233);     // Catch: Throwable -> L249
        if (r473 != null) goto L210;
    L212:
        boolean r474 = false;
    L213:
        Object r475 = r1104.f38504a;     // Catch: Throwable -> L249
        if (ZeusTransformUtils.instanceOf(r475, com.obric.autogui.common.a.class) == false) goto L216;
        com.obric.autogui.common.a r476 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r475, com.obric.autogui.common.a.class, r233);     // Catch: Throwable -> L249
    L217:
        if (r476 == null) goto L222;
        String r477 = r476.b();     // Catch: Throwable -> L249
        if (r477 == null) goto L222;
        z.d r478 = r232;
    L227:
        if (r478.f38502a <= 0) goto L229;
        z.e r479 = r227;
        long r1191 = r479.f38503a / ((long) r478.f38502a);     // Catch: Throwable -> L249
    L231:
        if (r1103.f38502a <= 0) goto L234;
        z.e r480 = r228;
        r228 = r480;
        r24 = r480.f38503a / ((long) r1103.f38502a);     // Catch: Throwable -> L249
    L234:
        long r481 = r24;
        IAutoActionTrackingApi r3105 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r233);     // Catch: Throwable -> L249
        JSONObject r1192 = new JSONObject();     // Catch: Throwable -> L249
        String r1193 = r82;
        if (r474 == false) goto L237;
        int r1194 = 1;
    L238:
        r1192.put(r1193, r1194);     // Catch: Throwable -> L249
        r1192.put(r81, r477);     // Catch: Throwable -> L249
        r1192.put(r80, r478.f38502a);     // Catch: Throwable -> L249
        r1192.put(r79, r472);     // Catch: Throwable -> L249
        r1192.put(r19, r1191);     // Catch: Throwable -> L249
        r1192.put(r77, r1103.f38502a);     // Catch: Throwable -> L249
        r1192.put(r76, r479.f38503a);     // Catch: Throwable -> L249
        r1192.put(r75, r228.f38503a);     // Catch: Throwable -> L249
        r1192.put(r67, r481);     // Catch: Throwable -> L249
        r1192.put(r29, r229.f38502a);     // Catch: Throwable -> L249
        x r482 = x.f38692a;     // Catch: Throwable -> L249
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3105, "oauto_scrollwheel_exec", r1192, false, false, null, 28, null);     // Catch: Throwable -> L249
        IAutoActionTrackingApi r1195 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r233);     // Catch: Throwable -> L249
        JSONObject r1196 = new JSONObject();     // Catch: Throwable -> L249
        String r483 = r5;
        if (r474 == false) goto L241;
        int r484 = 1;
    L242:
        r1196.put(r483, r484);     // Catch: Throwable -> L249
        r1196.put(r28, r1106.f38502a);     // Catch: Throwable -> L249
        r1196.put(r222, r1105.f38502a);     // Catch: Throwable -> L249
        r1196.put("ocr_retry_cnt", r1013.f38502a);     // Catch: Throwable -> L249
        String r485 = (String) ZeusTransformUtils.preCheckCast(r1017.f38504a, String.class, r233);     // Catch: Throwable -> L249
        if (r485 != null) goto L247;
        if (r474 == false) goto L246;
        r485 = "success";
        goto L247
    L246:
        r485 = SensitiveType.UNKNOWN;
    L247:
        r1196.put("ocr_fail_code", r485);     // Catch: Throwable -> L249
        r1196.put("ocr_fail_num_null_cnt", r1016.f38502a);     // Catch: Throwable -> L249
        r1196.put("ocr_fail_ret_null_cnt", r1015.f38502a);     // Catch: Throwable -> L249
        x r486 = x.f38692a;     // Catch: Throwable -> L249
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1195, "oauto_scrollwheel_ocr_stat", r1196, false, false, null, 28, null);     // Catch: Throwable -> L249
        n.f(x.f38692a);     // Catch: Throwable -> L249
    L251:
        return r469;
    L241:
        r484 = 0;
        goto L242
    L237:
        r1194 = 0;
        goto L238
    L229:
        r479 = r227;
        r1191 = 0;
    L222:
        r478 = r232;
        if (r474 == false) goto L225;
        r477 = "success";
        goto L227
    L225:
        r477 = SensitiveType.UNKNOWN;
        goto L227
    L216:
        r476 = null;
        goto L217
    L210:
        if (r473.g() != true) goto L212;
        r474 = true;
    L249:
        th = move-exception;
        n.a r487 = n.f38560a;
        n.f(d.o.a(th));
    L252:
        th = move-exception;
        r49 = r227;
        r209 = r1105;
        r152 = th;
        r208 = r1106;
        r2114 = r1016;
        r2116 = r1015;
        r207 = r229;
        r2115 = r1013;
        r151 = r1017;
        r115 = r1103;
        r312 = r197;
        r118 = r1104;
        r30 = r67;
        r16 = r75;
        r53 = r77;
        r19 = r19;
        r20 = r79;
        r21 = r80;
        r22 = r81;
        r23 = r82;
        r50 = r228;
        r54 = r232;
        r13 = r233;
    L254:
        r17 = r76;
        goto L1160
    L1176:
        Loog.INSTANCE.e(r7, "第 " + r1103.f38502a + " 次OCR失败");     // Catch: Throwable -> L202
        r85 = r235;
        r810 = r204;
        r127 = r233;
        r78 = r1103;
        r217 = r177;
        r86 = r197;
        r72 = r1104;
        r71 = r1107;
        r87 = r1105;
        r99 = r1106;
        r122 = r228;
        r121 = r229;
        r74 = r227;
        r73 = r232;
        r88 = r910;
        r128 = r1014;
        r123 = r1013;
        r126 = r1011;
        r125 = r1017;
        r124 = r1015;
        r213 = r1016;
        r89 = r1018;
        r811 = r1019 == true ? 1 : 0;
        r90 = r1010;
        r91 = r1012;
        r93 = r1112;
        r94 = r1113;
        r95 = r1114;
        r96 = r1115;
        r97 = r1110;
        r98 = r1111;
    L202:
        th = move-exception;
        r152 = th;
        r13 = r233;
        r115 = r1103;
        r312 = r197;
        r118 = r1104;
        r209 = r1105;
        r208 = r1106;
        r50 = r228;
        r207 = r229;
        r49 = r227;
        r54 = r232;
        r30 = r67;
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r19 = r19;
        r20 = r79;
        r21 = r80;
        r22 = r81;
        r23 = r82;
        r2115 = r1013;
        r151 = r1017;
        r2116 = r1015;
        r2114 = r1016;
    L754:
        th = move-exception;
        r312 = r197;
        r152 = th;
        r2115 = r1013;
        r13 = r233;
        r50 = r228;
        r2114 = r1016;
        r54 = r232;
        r2116 = r1015;
        r151 = r1017;
        r209 = r1105;
        r208 = r1106;
        r207 = r229;
        r115 = r1103;
        r118 = r1104;
        r49 = r227;
        r30 = r67;
    L756:
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r19 = r19;
        r20 = r79;
        r21 = r80;
        r22 = r81;
    L872:
        r23 = r82;
    L759:
        th = th;
    L797:
        r72 = r72;
    L798:
        r208 = r99;
        r13 = r127;
        r49 = r74;
        r50 = r176;
        r207 = r174;
        r2115 = r226;
        r115 = r78;
        r54 = r73;
        r2116 = r124;
        r2114 = r322;
        r151 = r125;
        r209 = r321;
        r30 = r67;
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r20 = r79;
        r21 = r80;
        r22 = r81;
        r152 = th;
        r312 = r197;
        r118 = r72;
        r19 = r19;
    L761:
        th = th;
        r72 = r72;
        r321 = r321;
    L763:
        th = th;
        r72 = r72;
        r321 = r321;
        r322 = r172;
        r125 = r175;
    L792:
        r197 = r86;
    L765:
        th = th;
    L777:
        r322 = r172;
        r125 = r175;
        r124 = r173;
    L796:
        r197 = r86;
    L767:
        th = th;
    L771:
        r73 = r73;
    L769:
        th = th;
        r74 = r74;
    L772:
        th = th;
        r74 = r74;
        r73 = r73;
        r78 = r78;
    L775:
        th = th;
        r74 = r74;
        r73 = r73;
        r78 = r78;
        r176 = r122;
    L778:
        th = th;
        r74 = r74;
        r73 = r73;
        r78 = r78;
        r321 = r321;
        r322 = r172;
        r174 = r121;
        r124 = r173;
        r125 = r125;
        r197 = r86;
        r72 = r72;
        r176 = r122;
    L780:
        th = th;
        r74 = r74;
        r73 = r73;
        r78 = r78;
        r321 = r321;
        r322 = r172;
        r226 = r123;
        r72 = r72;
    L791:
        r176 = r122;
        r174 = r121;
    L782:
        th = th;
        r321 = r321;
    L795:
        r125 = r125;
        r124 = r124;
        r322 = r213;
        r176 = r122;
        r174 = r121;
        r226 = r123;
    L784:
        th = th;
        r321 = r321;
    L790:
        r322 = r213;
        r226 = r223;
    L786:
        th = th;
        r74 = r74;
        r73 = r73;
        r72 = r72;
        r322 = r213;
        r226 = r223;
        r321 = r224;
        r78 = r78;
    L788:
        th = th;
        r321 = r87;
    L793:
        th = th;
        r321 = r87;
    L858:
        th = th;
        z.d r2106 = r78;
        z.d r611 = r87;
        z.e r3106 = r122;
        r13 = r127;
        z.f r2016 = r125;
        z.d r1825 = r124;
        r21 = r80;
        r22 = r81;
        z.e r1197 = r74;
        z.d r1198 = r121;
        r312 = r86;
        r118 = r72;
        r208 = r99;
        r54 = r73;
        r49 = r1197;
        r207 = r1198;
        r115 = r2106;
        r50 = r3106;
        r2114 = r213;
        r30 = r67;
        r209 = r611;
        r2115 = r123;
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r19 = r19;
        r20 = r79;
        r23 = r82;
        r2116 = r1825;
        r151 = r2016;
        goto L986
    L158:
        r57 = false;
    L860:
        th = move-exception;
        r21 = r21;
        r13 = "com.obric.aiagent.plugin";
        r22 = r22;
        r152 = th;
        r19 = r19;
        r20 = r20;
        r118 = r118;
        r54 = r54;
        r49 = r49;
        r115 = r115;
        r207 = r207;
        r50 = r50;
        r208 = r208;
        r30 = r67;
        r209 = r62;
        r2115 = r63;
        r2114 = r64;
        r2116 = r65;
        r151 = r66;
        r16 = r75;
    L862:
        th = move-exception;
        r152 = th;
        r17 = r52;
        r30 = r67;
    L869:
        r209 = r62;
        r2115 = r63;
        r2114 = r64;
        r2116 = r65;
        r151 = r66;
    L864:
        th = th;
    L868:
        r152 = th;
        r30 = r55;
        r17 = r52;
    L866:
        th = th;
        r29 = r117;
        goto L868
    L1198:
        Loog.INSTANCE.e(r7, "加载 OCR 模型错误");     // Catch: Throwable -> L146
        ?? r488 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "ocr_load_failed", null, false, null, 0, 30, null);     // Catch: Throwable -> L146
        r45.f38504a = r488;     // Catch: Throwable -> L146
        n.a r489 = n.f38560a;     // Catch: Throwable -> L142
        d r490 = (d) ZeusTransformUtils.preCheckCast(r110, r310, "com.obric.aiagent.plugin");     // Catch: Throwable -> L142
        long r1199 = AOSystemTools.INSTANCE.bootTimeMillis() - r312;     // Catch: Throwable -> L142
        ?? r2133 = r488;
        com.obric.autogui.common.e r491 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r45.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        if (r491 != null) goto L104;
    L106:
        boolean r492 = false;
    L107:
        Object r493 = r45.f38504a;     // Catch: Throwable -> L140
        if (ZeusTransformUtils.instanceOf(r493, com.obric.autogui.common.a.class) == false) goto L110;
        com.obric.autogui.common.a r494 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r493, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
    L111:
        if (r494 == null) goto L114;
        String r495 = r494.b();     // Catch: Throwable -> L140
        if (r495 == null) goto L114;
    L118:
        if (r41.f38502a <= 0) goto L120;
        long r496 = r43.f38503a / ((long) r41.f38502a);     // Catch: Throwable -> L140
    L122:
        if (r115.f38502a <= 0) goto L125;
        r24 = r116.f38503a / ((long) r115.f38502a);     // Catch: Throwable -> L140
    L125:
        long r497 = r24;
        IAutoActionTrackingApi r3107 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        JSONObject r498 = new JSONObject();     // Catch: Throwable -> L140
        String r1200 = r82;
        if (r492 == false) goto L128;
        int r1201 = 1;
    L129:
        r498.put(r1200, r1201);     // Catch: Throwable -> L140
        r498.put(r81, r495);     // Catch: Throwable -> L140
        r498.put(r80, r41.f38502a);     // Catch: Throwable -> L140
        r498.put(r79, r1199);     // Catch: Throwable -> L140
        r498.put(r19, r496);     // Catch: Throwable -> L140
        r498.put(r77, r115.f38502a);     // Catch: Throwable -> L140
        r498.put(r76, r43.f38503a);     // Catch: Throwable -> L140
        r498.put(r75, r116.f38503a);     // Catch: Throwable -> L140
        r498.put(r61, r497);     // Catch: Throwable -> L140
        r498.put(r29, r40.f38502a);     // Catch: Throwable -> L140
        x r499 = x.f38692a;     // Catch: Throwable -> L140
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3107, "oauto_scrollwheel_exec", r498, false, false, null, 28, null);     // Catch: Throwable -> L140
        IAutoActionTrackingApi r500 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        JSONObject r501 = new JSONObject();     // Catch: Throwable -> L140
        String r502 = r5;
        if (r492 == false) goto L132;
        int r503 = 1;
    L133:
        r501.put(r502, r503);     // Catch: Throwable -> L140
        r501.put(r28, r42.f38502a);     // Catch: Throwable -> L140
        r501.put(r222, r114.f38502a);     // Catch: Throwable -> L140
        r501.put("ocr_retry_cnt", r44.f38502a);     // Catch: Throwable -> L140
        String r504 = (String) ZeusTransformUtils.preCheckCast(r47.f38504a, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L140
        if (r504 != null) goto L138;
        if (r492 == false) goto L137;
        r504 = "success";
        goto L138
    L137:
        r504 = SensitiveType.UNKNOWN;
    L138:
        r501.put("ocr_fail_code", r504);     // Catch: Throwable -> L140
        r501.put("ocr_fail_num_null_cnt", r212.f38502a);     // Catch: Throwable -> L140
        r501.put("ocr_fail_ret_null_cnt", r211.f38502a);     // Catch: Throwable -> L140
        x r505 = x.f38692a;     // Catch: Throwable -> L140
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r500, "oauto_scrollwheel_ocr_stat", r501, false, false, null, 28, null);     // Catch: Throwable -> L140
        n.f(x.f38692a);     // Catch: Throwable -> L140
        ?? r2134 = r2133;
    L145:
        return r2134;
    L132:
        r503 = 0;
        goto L133
    L128:
        r1201 = 0;
        goto L129
    L120:
        r496 = 0;
    L114:
        if (r492 == false) goto L116;
        r495 = "success";
        goto L118
    L116:
        r495 = SensitiveType.UNKNOWN;
        goto L118
    L110:
        r494 = null;
        goto L111
    L104:
        if (r491.g() != true) goto L106;
        r492 = true;
    L140:
        th = th;
    L144:
        n.a r506 = n.f38560a;
        n.f(d.o.a(th));
        r2134 = r2133;
    L142:
        th = th;
        r2133 = r488;
    L146:
        th = move-exception;
        z.f r612 = r47;
        z.d r613 = r44;
        z.d r614 = r114;
        r152 = th;
        r2114 = r212;
        r13 = "com.obric.aiagent.plugin";
        r118 = r45;
        r54 = r41;
        r49 = r43;
        r207 = r40;
        r50 = r116;
        r208 = r42;
        r30 = r61;
        r209 = r614;
        r2115 = r613;
        r2116 = r211;
        r151 = r612;
    L870:
        th = move-exception;
        z.f r615 = r47;
        z.d r616 = r44;
        r13 = "com.obric.aiagent.plugin";
        z.d r617 = r114;
        r21 = r80;
        r22 = r81;
        r152 = th;
        r118 = r45;
        r54 = r41;
        r49 = r43;
        r207 = r40;
        r50 = r116;
        r208 = r42;
        r30 = r61;
        r209 = r617;
        r2115 = r616;
        r2114 = r212;
        r2116 = r211;
        r151 = r615;
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r19 = r19;
        r20 = r79;
    L45:
        th = move-exception;
        r151 = r18;
        r2116 = r25;
        r2114 = r26;
        r2115 = r27;
        r222 = r222;
        r5 = "ocr_ok";
        r13 = "com.obric.aiagent.plugin";
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r209 = r31;
        r208 = r32;
        r207 = r33;
        r50 = r34;
        r115 = r35;
        r118 = r36;
        r54 = r38;
        r152 = th;
        r312 = r8;
        r20 = r20;
        r49 = r37;
        goto L1160
    L12:
        if (r4 != 2) goto L14;
        int r507 = r14.K;
        int r508 = r14.f29618J;
        int r509 = r14.I;
        int r513 = r14.H;
        long r514 = r14.D;
        float r1202 = r14.C;
        float r1203 = r14.B;
        z.d r515 = (z.d) ZeusTransformUtils.preCheckCast(r14.A, z.d.class, "com.obric.aiagent.plugin");
        z.f r516 = (z.f) ZeusTransformUtils.preCheckCast(r14.z, z.f.class, "com.obric.aiagent.plugin");
        z.d r517 = (z.d) ZeusTransformUtils.preCheckCast(r14.y, z.d.class, "com.obric.aiagent.plugin");
        z.d r518 = (z.d) ZeusTransformUtils.preCheckCast(r14.x, z.d.class, "com.obric.aiagent.plugin");
        z.d r519 = (z.d) ZeusTransformUtils.preCheckCast(r14.w, z.d.class, "com.obric.aiagent.plugin");
        Integer r520 = (Integer) ZeusTransformUtils.preCheckCast(r14.v, Integer.class, "com.obric.aiagent.plugin");
        String r521 = (String) ZeusTransformUtils.preCheckCast(r14.u, String.class, "com.obric.aiagent.plugin");
        Integer r522 = (Integer) ZeusTransformUtils.preCheckCast(r14.t, Integer.class, "com.obric.aiagent.plugin");
        List<C0762d> r523 = (List) ZeusTransformUtils.preCheckCast(r14.s, List.class, "com.obric.aiagent.plugin");
        Float r524 = (Float) ZeusTransformUtils.preCheckCast(r14.r, Float.class, "com.obric.aiagent.plugin");
        e r525 = (e) ZeusTransformUtils.preCheckCast(r14.q, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.f r526 = (com.obric.autogui.operator.a.b.b.f) ZeusTransformUtils.preCheckCast(r14.p, com.obric.autogui.operator.a.b.b.f.class, "com.obric.aiagent.plugin");
        Integer r527 = (Integer) ZeusTransformUtils.preCheckCast(r14.o, Integer.class, "com.obric.aiagent.plugin");
        z.f r528 = (z.f) ZeusTransformUtils.preCheckCast(r14.n, z.f.class, "com.obric.aiagent.plugin");
        z.d r529 = (z.d) ZeusTransformUtils.preCheckCast(r14.m, z.d.class, "com.obric.aiagent.plugin");
        z.d r530 = (z.d) ZeusTransformUtils.preCheckCast(r14.l, z.d.class, "com.obric.aiagent.plugin");
        z.d r531 = (z.d) ZeusTransformUtils.preCheckCast(r14.k, z.d.class, "com.obric.aiagent.plugin");
        z.d r532 = (z.d) ZeusTransformUtils.preCheckCast(r14.j, z.d.class, "com.obric.aiagent.plugin");
        z.d r533 = (z.d) ZeusTransformUtils.preCheckCast(r14.i, z.d.class, "com.obric.aiagent.plugin");
        c r534 = (c) ZeusTransformUtils.preCheckCast(r14.h, c.class, "com.obric.aiagent.plugin");
        z.d r535 = (z.d) ZeusTransformUtils.preCheckCast(r14.g, z.d.class, "com.obric.aiagent.plugin");
        z.e r536 = (z.e) ZeusTransformUtils.preCheckCast(r14.f, z.e.class, "com.obric.aiagent.plugin");
        z.d r537 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29623e, z.d.class, "com.obric.aiagent.plugin");
        z.f r538 = (z.f) ZeusTransformUtils.preCheckCast(r14.f29622d, z.f.class, "com.obric.aiagent.plugin");
        z.e r539 = (z.e) ZeusTransformUtils.preCheckCast(r14.f29621c, z.e.class, "com.obric.aiagent.plugin");
        z.d r540 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29620b, z.d.class, "com.obric.aiagent.plugin");
        d r541 = (d) ZeusTransformUtils.preCheckCast(r14.f29619a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L40
        r222 = r222;
        r1018 = r509;
        r5 = "ocr_ok";
        r910 = r513;
        r1012 = r1202;
        r1110 = r1203;
        r1111 = r15;
        r75 = r16;
        r76 = r17;
        r77 = "scroll_attempts";
        r19 = r19;
        r79 = r20;
        r80 = r21;
        r81 = r22;
        r82 = r23;
        r28 = r28;
        r29 = r29;
        r67 = r30;
        r1019 = r507;
        r1115 = r520;
        r1114 = r521;
        r1113 = r522;
        r1112 = r523;
        r92 = r524;
        r1010 = r525;
        r1011 = r526;
        r1017 = r528;
        r1015 = r529;
        r1016 = r530;
        r1013 = r531;
        r1105 = r532;
        r1106 = r533;
        r1014 = r534;
        r229 = r535;
        r228 = r536;
        r1103 = r537;
        r1104 = r538;
        r227 = r539;
        r230 = r516;
        r202 = r517;
        r231 = r518;
        r7 = TAG;
        r314 = d.class;
        r127 = "com.obric.aiagent.plugin";
        r1107 = r14;
        r177 = r527;
        r203 = r515;
        r2117 = r541;
        r197 = r514;
        r201 = r519;
        r205 = r540;
        r204 = r508;
    L40:
        th = th;
        r222 = r222;
        r54 = r540;
        r5 = "ocr_ok";
        r312 = r514;
        r13 = "com.obric.aiagent.plugin";
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r151 = r528;
        r2116 = r529;
        r2114 = r530;
        r2115 = r531;
        r209 = r532;
        r208 = r533;
        r207 = r535;
        r50 = r536;
        r115 = r537;
        r118 = r538;
        r49 = r539;
        goto L986
    L14:
        if (r4 != 3) goto L16;
        int r542 = r14.K;
        int r543 = r14.f29618J;
        int r544 = r14.I;
        int r545 = r14.H;
        long r546 = r14.D;
        float r1204 = r14.C;
        float r1205 = r14.B;
        r330 = r542;
        r331 = r543;
        e.C0763d r547 = (e.C0763d) ZeusTransformUtils.preCheckCast(r14.v, e.C0763d.class, "com.obric.aiagent.plugin");
        Integer r548 = (Integer) ZeusTransformUtils.preCheckCast(r14.u, Integer.class, "com.obric.aiagent.plugin");
        String r549 = (String) ZeusTransformUtils.preCheckCast(r14.t, String.class, "com.obric.aiagent.plugin");
        Integer r550 = (Integer) ZeusTransformUtils.preCheckCast(r14.s, Integer.class, "com.obric.aiagent.plugin");
        r327 = (List) ZeusTransformUtils.preCheckCast(r14.r, List.class, "com.obric.aiagent.plugin");
        r326 = (e) ZeusTransformUtils.preCheckCast(r14.q, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.f r551 = (com.obric.autogui.operator.a.b.b.f) ZeusTransformUtils.preCheckCast(r14.p, com.obric.autogui.operator.a.b.b.f.class, "com.obric.aiagent.plugin");
        Integer r552 = (Integer) ZeusTransformUtils.preCheckCast(r14.o, Integer.class, "com.obric.aiagent.plugin");
        z.f r3108 = (z.f) ZeusTransformUtils.preCheckCast(r14.n, z.f.class, "com.obric.aiagent.plugin");
        z.d r4100 = (z.d) ZeusTransformUtils.preCheckCast(r14.m, z.d.class, "com.obric.aiagent.plugin");
        z.d r4101 = (z.d) ZeusTransformUtils.preCheckCast(r14.l, z.d.class, "com.obric.aiagent.plugin");
        z.d r4102 = (z.d) ZeusTransformUtils.preCheckCast(r14.k, z.d.class, "com.obric.aiagent.plugin");
        z.d r4103 = (z.d) ZeusTransformUtils.preCheckCast(r14.j, z.d.class, "com.obric.aiagent.plugin");
        z.d r4104 = (z.d) ZeusTransformUtils.preCheckCast(r14.i, z.d.class, "com.obric.aiagent.plugin");
        r411 = (c) ZeusTransformUtils.preCheckCast(r14.h, c.class, "com.obric.aiagent.plugin");
        z.d r4105 = (z.d) ZeusTransformUtils.preCheckCast(r14.g, z.d.class, "com.obric.aiagent.plugin");
        z.e r4106 = (z.e) ZeusTransformUtils.preCheckCast(r14.f, z.e.class, "com.obric.aiagent.plugin");
        z.d r4107 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29623e, z.d.class, "com.obric.aiagent.plugin");
        z.f r4108 = (z.f) ZeusTransformUtils.preCheckCast(r14.f29622d, z.f.class, "com.obric.aiagent.plugin");
        z.e r553 = (z.e) ZeusTransformUtils.preCheckCast(r14.f29621c, z.e.class, "com.obric.aiagent.plugin");
        z.d r554 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29620b, z.d.class, "com.obric.aiagent.plugin");
        r264 = (d) ZeusTransformUtils.preCheckCast(r14.f29619a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L34
        r1120 = r222;
        r1118 = "ocr_ok";
        r1210 = TAG;
        r1211 = d.class;
        r1212 = r16;
        r1213 = r17;
        r1214 = "scroll_attempts";
        r19 = r19;
        r1215 = r20;
        r1216 = r21;
        r1217 = r22;
        r1218 = r23;
        r1119 = r28;
        r29 = r29;
        r1117 = r30;
        r246 = r551;
        r262 = r4100;
        r328 = r4101;
        r237 = r4105;
        r266 = r4106;
        r254 = r548;
        r251 = r550;
        r1123 = r544;
        r267 = r545;
        r1125 = r546;
        r1124 = r1204;
        r1126 = r1205;
        r1108 = "com.obric.aiagent.plugin";
        r263 = r14;
        r329 = r15;
        r239 = r4102;
        r1109 = r4103;
        r1116 = r4104;
        r1103 = r4107;
        r1104 = r4108;
        r238 = r553;
        r2119 = r547;
        r2121 = r549;
        r265 = r554;
        r2120 = r552;
        r268 = r3108;
    L34:
        th = th;
        r54 = r554;
        r312 = r546;
    L36:
        r13 = "com.obric.aiagent.plugin";
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r151 = r3108;
        r2116 = r4100;
        r2114 = r4101;
        r2115 = r4102;
        r209 = r4103;
        r208 = r4104;
        r207 = r4105;
        r50 = r4106;
        r115 = r4107;
        r118 = r4108;
        r49 = r553;
        goto L986
    L16:
        if (r4 != 4) goto L18;
        long r555 = r14.F;
        long r556 = r14.E;
        int r557 = r14.M;
        int r558 = r14.L;
        int r1206 = r14.K;
        int r1207 = r14.f29618J;
        r338 = r555;
        int r559 = r14.I;
        int r560 = r14.H;
        long r561 = r14.D;
        float r562 = r14.C;
        float r563 = r14.B;
        String r564 = (String) ZeusTransformUtils.preCheckCast(r14.x, String.class, "com.obric.aiagent.plugin");
        c r565 = (c) ZeusTransformUtils.preCheckCast(r14.w, c.class, "com.obric.aiagent.plugin");
        e.C0763d r566 = (e.C0763d) ZeusTransformUtils.preCheckCast(r14.v, e.C0763d.class, "com.obric.aiagent.plugin");
        Integer r567 = (Integer) ZeusTransformUtils.preCheckCast(r14.u, Integer.class, "com.obric.aiagent.plugin");
        Integer r568 = (Integer) ZeusTransformUtils.preCheckCast(r14.t, Integer.class, "com.obric.aiagent.plugin");
        List<C0762d> r569 = (List) ZeusTransformUtils.preCheckCast(r14.s, List.class, "com.obric.aiagent.plugin");
        Float r570 = (Float) ZeusTransformUtils.preCheckCast(r14.r, Float.class, "com.obric.aiagent.plugin");
        e r571 = (e) ZeusTransformUtils.preCheckCast(r14.q, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.f r572 = (com.obric.autogui.operator.a.b.b.f) ZeusTransformUtils.preCheckCast(r14.p, com.obric.autogui.operator.a.b.b.f.class, "com.obric.aiagent.plugin");
        Integer r573 = (Integer) ZeusTransformUtils.preCheckCast(r14.o, Integer.class, "com.obric.aiagent.plugin");
        z.f r574 = (z.f) ZeusTransformUtils.preCheckCast(r14.n, z.f.class, "com.obric.aiagent.plugin");
        z.d r575 = (z.d) ZeusTransformUtils.preCheckCast(r14.m, z.d.class, "com.obric.aiagent.plugin");
        z.d r576 = (z.d) ZeusTransformUtils.preCheckCast(r14.l, z.d.class, "com.obric.aiagent.plugin");
        z.d r577 = (z.d) ZeusTransformUtils.preCheckCast(r14.k, z.d.class, "com.obric.aiagent.plugin");
        z.d r578 = (z.d) ZeusTransformUtils.preCheckCast(r14.j, z.d.class, "com.obric.aiagent.plugin");
        z.d r579 = (z.d) ZeusTransformUtils.preCheckCast(r14.i, z.d.class, "com.obric.aiagent.plugin");
        c r580 = (c) ZeusTransformUtils.preCheckCast(r14.h, c.class, "com.obric.aiagent.plugin");
        z.d r581 = (z.d) ZeusTransformUtils.preCheckCast(r14.g, z.d.class, "com.obric.aiagent.plugin");
        z.e r582 = (z.e) ZeusTransformUtils.preCheckCast(r14.f, z.e.class, "com.obric.aiagent.plugin");
        z.d r583 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29623e, z.d.class, "com.obric.aiagent.plugin");
        z.f r584 = (z.f) ZeusTransformUtils.preCheckCast(r14.f29622d, z.f.class, "com.obric.aiagent.plugin");
        z.e r585 = (z.e) ZeusTransformUtils.preCheckCast(r14.f29621c, z.e.class, "com.obric.aiagent.plugin");
        z.d r586 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29620b, z.d.class, "com.obric.aiagent.plugin");
        d r587 = (d) ZeusTransformUtils.preCheckCast(r14.f29619a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L29
        r1510 = r222;
        r1612 = "ocr_ok";
        r1718 = r556;
        r1812 = r1206;
        r1813 = r1207;
        r1610 = d.class;
        r1811 = r14;
        r1810 = r15;
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r20 = r20;
        r1611 = r21;
        r1614 = r22;
        r23 = r23;
        r1613 = r28;
        r29 = r29;
        r30 = r30;
        r1712 = r559;
        r1717 = r560;
        r1158 = r562;
        r309 = r563;
        r1713 = r568;
        r1152 = r569;
        r1716 = r570;
        r1715 = r571;
        r1714 = r572;
        r1711 = r573;
        r2103 = r574;
        r1156 = r575;
        r2104 = r576;
        r2102 = r577;
        r2101 = r578;
        r307 = r581;
        r1151 = r582;
        r1153 = r583;
        r1155 = r584;
        r1145 = r564;
        r2124 = r565;
        r1144 = r566;
        r2126 = r567;
        r1157 = r557;
        r2100 = r558;
        r422 = TAG;
        r13 = "com.obric.aiagent.plugin";
        r339 = r579;
        r2125 = r580;
        r1154 = r586;
        r340 = r587;
        r341 = r561;
        r308 = r585;
    L29:
        th = move-exception;
        r1822 = r222;
        r394 = th;
        r1924 = "ocr_ok";
        r1920 = "com.obric.aiagent.plugin";
        r1824 = r16;
        r1925 = r17;
        r2013 = "scroll_attempts";
        r1923 = r20;
        r1926 = r21;
        r1927 = r22;
        r1921 = r23;
        r1823 = r28;
        r29 = r29;
        r1922 = r30;
        r291 = r338;
        r341 = r561;
        r1512 = r574;
        r1419 = r575;
        r1511 = r576;
        r1417 = r577;
        r1420 = r578;
        r421 = r579;
        r207 = r581;
        r50 = r582;
        r292 = r583;
        r420 = r584;
        r293 = r586;
        r395 = r585;
        goto L1124
    L18:
        if (r4 != 5) goto L25;
        int r588 = r14.K;
        int r589 = r14.f29618J;
        int r590 = r14.I;
        int r1208 = r14.H;
        long r591 = r14.D;
        float r1209 = r14.C;
        float r592 = r14.B;
        Integer r593 = (Integer) ZeusTransformUtils.preCheckCast(r14.v, Integer.class, "com.obric.aiagent.plugin");
        String r594 = (String) ZeusTransformUtils.preCheckCast(r14.u, String.class, "com.obric.aiagent.plugin");
        Integer r595 = (Integer) ZeusTransformUtils.preCheckCast(r14.t, Integer.class, "com.obric.aiagent.plugin");
        List<C0762d> r596 = (List) ZeusTransformUtils.preCheckCast(r14.s, List.class, "com.obric.aiagent.plugin");
        Float r597 = (Float) ZeusTransformUtils.preCheckCast(r14.r, Float.class, "com.obric.aiagent.plugin");
        e r598 = (e) ZeusTransformUtils.preCheckCast(r14.q, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.f r599 = (com.obric.autogui.operator.a.b.b.f) ZeusTransformUtils.preCheckCast(r14.p, com.obric.autogui.operator.a.b.b.f.class, "com.obric.aiagent.plugin");
        Integer r600 = (Integer) ZeusTransformUtils.preCheckCast(r14.o, Integer.class, "com.obric.aiagent.plugin");
        r3108 = (z.f) ZeusTransformUtils.preCheckCast(r14.n, z.f.class, "com.obric.aiagent.plugin");
        r4100 = (z.d) ZeusTransformUtils.preCheckCast(r14.m, z.d.class, "com.obric.aiagent.plugin");
        r4101 = (z.d) ZeusTransformUtils.preCheckCast(r14.l, z.d.class, "com.obric.aiagent.plugin");
        r4102 = (z.d) ZeusTransformUtils.preCheckCast(r14.k, z.d.class, "com.obric.aiagent.plugin");
        r4103 = (z.d) ZeusTransformUtils.preCheckCast(r14.j, z.d.class, "com.obric.aiagent.plugin");
        r4104 = (z.d) ZeusTransformUtils.preCheckCast(r14.i, z.d.class, "com.obric.aiagent.plugin");
        c r601 = (c) ZeusTransformUtils.preCheckCast(r14.h, c.class, "com.obric.aiagent.plugin");
        r4105 = (z.d) ZeusTransformUtils.preCheckCast(r14.g, z.d.class, "com.obric.aiagent.plugin");
        r4106 = (z.e) ZeusTransformUtils.preCheckCast(r14.f, z.e.class, "com.obric.aiagent.plugin");
        r4107 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29623e, z.d.class, "com.obric.aiagent.plugin");
        r4108 = (z.f) ZeusTransformUtils.preCheckCast(r14.f29622d, z.f.class, "com.obric.aiagent.plugin");
        r553 = (z.e) ZeusTransformUtils.preCheckCast(r14.f29621c, z.e.class, "com.obric.aiagent.plugin");
        r73 = (z.d) ZeusTransformUtils.preCheckCast(r14.f29620b, z.d.class, "com.obric.aiagent.plugin");
        d r602 = (d) ZeusTransformUtils.preCheckCast(r14.f29619a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L22
        r811 = r588;
        r86 = r591;
        r96 = r593;
        r1817 = r222;
        r95 = r594;
        r1913 = "ocr_ok";
        r97 = r592;
        r810 = r589;
        r89 = r590;
        r88 = r1208;
        r91 = r1209;
        r1917 = "com.obric.aiagent.plugin";
        r71 = r14;
        r98 = r15;
        r1819 = r16;
        r1914 = r17;
        r2013 = "scroll_attempts";
        r1912 = r20;
        r1915 = r21;
        r1916 = r22;
        r1910 = r23;
        r1818 = r28;
        r29 = r29;
        r1911 = r30;
        r94 = r595;
        r93 = r596;
        r92 = r597;
        r90 = r598;
        r126 = r599;
        r1162 = r600;
        r2014 = r3108;
        r1814 = r4100;
        r213 = r4101;
        r123 = r4102;
        r87 = r4103;
        r128 = r601;
        r121 = r4105;
        r78 = r4107;
        r72 = r4108;
        r74 = r553;
        r422 = TAG;
        r314 = d.class;
        r122 = r4106;
        r85 = r602;
        r99 = r4104;
    L22:
        th = th;
        r312 = r591;
        r54 = r73;
        goto L36
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L47:
        d.o.a(r3);
        long r603 = AOSystemTools.INSTANCE.bootTimeMillis();
        z.d r604 = new z.d();
        z.e r605 = new z.e();
        z.f r606 = new z.f();
        r310 = d.class;
        r115 = new z.d();
        r116 = new z.e();
        r5 = "ocr_ok";
        z.d r607 = new z.d();
        r312 = r603;
        z.d r608 = new z.d();
        z.d r3109 = new z.d();
        z.d r3110 = new z.d();
        z.d r4109 = new z.d();
        z.d r4110 = new z.d();
        z.f r4111 = new z.f();
        z.d r1220 = r608;
        z.d r618 = r607;
        Loog.INSTANCE.i(TAG, " 目标点位置 x = " + r218 + ", y = " + r219 + ", 目标 = " + r220);     // Catch: Throwable -> L976
        boolean r609 = com.obric.autogui.common.a.d.f28974a.W();     // Catch: Throwable -> L976
        if (r609 == false) goto L59;
        String r619 = d.n.m.a(d.o.k.b(new d.o.k("\\d+"), (CharSequence) ZeusTransformUtils.preCheckCast(r220, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$h03m6SQeZQAmN3HLLki3CuXoYA.INSTANCE, 30, null);     // Catch: Throwable -> L56
        Integer r620 = f.f29602a.a(r220, true);     // Catch: Throwable -> L56
        boolean r1221 = false;
    L61:
        String r621 = r619;
        if (r620 == null) goto L1134;
    L898:
        th = th;
        r606 = r606;
        r605 = r605;
        r604 = r604;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        z.d r622 = r3109;
        z.d r623 = r3110;
        z.d r624 = r4109;
        z.d r625 = r4110;
        z.f r626 = r4111;
        z.d r627 = r1220;
        z.d r628 = r618;
    L900:
        r222 = r222;
        r50 = r116;
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r20 = r20;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r5 = r5;
        r118 = r606;
        r49 = r605;
        r209 = r622;
        r2115 = r623;
        r2114 = r624;
        r2116 = r625;
        r151 = r626;
        r207 = r628;
        r208 = r627;
    L985:
        r54 = r604;
        goto L986
    L64:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r621, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L66;
        boolean r629 = true;
    L67:
        if (r629 == true) goto L1134;
        r14.f29619a = this;     // Catch: Throwable -> L898
        r14.f29620b = r220;     // Catch: Throwable -> L898
        r14.f29621c = r604;     // Catch: Throwable -> L898
        r14.f29622d = r605;     // Catch: Throwable -> L898
        r14.f29623e = r606;     // Catch: Throwable -> L898
        r14.f = r115;     // Catch: Throwable -> L898
        r14.g = r116;     // Catch: Throwable -> L898
        r628 = r618;
        r14.h = r628;     // Catch: Throwable -> L896
        r627 = r1220;
        r14.i = r627;     // Catch: Throwable -> L894
        r14.j = r3109;     // Catch: Throwable -> L888
        r14.k = r3110;     // Catch: Throwable -> L886
        r14.l = r4109;     // Catch: Throwable -> L884
        r14.m = r4110;     // Catch: Throwable -> L882
        r14.n = r4111;     // Catch: Throwable -> L880
        r14.o = r621;     // Catch: Throwable -> L880
        r14.p = r620;     // Catch: Throwable -> L880
        r14.B = r218;     // Catch: Throwable -> L880
        r14.C = r219;     // Catch: Throwable -> L877
        Integer r5100 = r620;
        r14.D = r312;     // Catch: Throwable -> L875
        r312 = r312;
        r14.G = r609;     // Catch: Throwable -> L877
        r14.P = 1;     // Catch: Throwable -> L877
        r61 = r30;
        r29 = r29;
        r210 = r609;
        r5 = r5;
        r28 = r28;
        r222 = r222;
        r75 = r16;
        r76 = r17;
        r77 = "scroll_attempts";
        r19 = r19;
        r79 = r20;
        r80 = r21;
        r81 = r22;
        r82 = r23;
        Object r630 = a(this, "ocr_service", false, null, r14, 6, null);     // Catch: Throwable -> L873
        if (r630 != r15) goto L95;
        return r15;
    L95:
        r112 = r219;
        r46 = r630;
        r311 = r15;
        r113 = r218;
        r111 = r220;
        r84 = r621;
        r83 = r5100;
        r45 = r606;
        r43 = r605;
        r114 = r3109;
        r44 = r3110;
        r212 = r4109;
        r211 = r4110;
        r47 = r4111;
        r40 = r628;
        r42 = r627;
        r41 = r604;
        r110 = this;
    L873:
        th = move-exception;
        r13 = "com.obric.aiagent.plugin";
        r21 = r80;
        r22 = r81;
        r23 = r82;
        r152 = th;
        r50 = r116;
        r118 = r606;
        r49 = r605;
        r30 = r61;
        r209 = r3109;
        r2115 = r3110;
        r2114 = r4109;
        r2116 = r4110;
        r151 = r4111;
        r207 = r628;
        r208 = r627;
        r54 = r604;
        r16 = r75;
        r17 = r76;
        r53 = r77;
        r19 = r19;
        r20 = r79;
    L875:
        th = th;
        r312 = r312;
    L879:
        r626 = r4111;
        r627 = r627;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
        r624 = r4109;
        r625 = r4110;
        r628 = r628;
    L893:
        r604 = r604;
    L877:
        th = th;
    L880:
        th = th;
        r606 = r606;
        r605 = r605;
        r626 = r4111;
        r628 = r628;
        r627 = r627;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
        r624 = r4109;
        r625 = r4110;
    L882:
        th = th;
        r606 = r606;
        r605 = r605;
        r625 = r4110;
        r628 = r628;
        r627 = r627;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
        r624 = r4109;
    L892:
        r626 = r4111;
    L884:
        th = th;
        r606 = r606;
        r605 = r605;
        r624 = r4109;
        r628 = r628;
        r627 = r627;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
    L891:
        r625 = r4110;
    L886:
        th = th;
        r623 = r3110;
        r622 = r3109;
    L890:
        r624 = r4109;
    L888:
        th = th;
        r622 = r3109;
        r623 = r3110;
    L894:
        th = th;
        r606 = r606;
        r605 = r605;
        r604 = r604;
        r628 = r628;
        r627 = r627;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
        r624 = r4109;
        r625 = r4110;
        r626 = r4111;
    L896:
        th = th;
        r606 = r606;
        r605 = r605;
        r604 = r604;
        r628 = r628;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r622 = r3109;
        r623 = r3110;
        r624 = r4109;
        r625 = r4110;
        r626 = r4111;
        r627 = r1220;
        goto L900
    L66:
        r629 = r1221;
    L1134:
    L968:
        th = th;
    L969:
        r17 = r17;
        r53 = "scroll_attempts";
    L975:
        r50 = r116;
        r49 = r605;
        r208 = r1220;
        r209 = r3109;
        r2115 = r3110;
        r2116 = r4110;
        r151 = r4111;
        r115 = r115;
    L984:
        r118 = r606;
        r2114 = r4109;
        r207 = r618;
        goto L985
    L1070:
        r29 = r29;
        Loog.INSTANCE.e(TAG, "目标参数 '" + r11 + "' 中不包含有效数字，停止滚动");     // Catch: Throwable -> L968
        ?? r631 = com.obric.autogui.common.b.a(com.obric.autogui.common.e.f29014b.b(), "target_non_digit", "tgt=" + r220, false, null, 0, 28, null);     // Catch: Throwable -> L968
        r606.f38504a = r631;     // Catch: Throwable -> L964
        n.a r632 = n.f38560a;     // Catch: Throwable -> L959
        d r633 = (d) ZeusTransformUtils.preCheckCast(this, r310, r13);     // Catch: Throwable -> L959
        long r634 = AOSystemTools.INSTANCE.bootTimeMillis() - r312;     // Catch: Throwable -> L959
        com.obric.autogui.common.e r635 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r606.f38504a, com.obric.autogui.common.e.class, r13);     // Catch: Throwable -> L959
        if (r635 != null) goto L1256;
    L921:
        boolean r636 = false;
    L922:
        Object r637 = r606.f38504a;     // Catch: Throwable -> L959
        if (ZeusTransformUtils.instanceOf(r637, com.obric.autogui.common.a.class) == false) goto L925;
        com.obric.autogui.common.a r638 = (com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(r637, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L919
    L926:
        if (r638 == null) goto L929;
        String r639 = r638.b();     // Catch: Throwable -> L919
        if (r639 == null) goto L929;
    L933:
        if (r604.f38502a <= 0) goto L939;
        ?? r2135 = r631;
        long r640 = r605.f38503a / ((long) r604.f38502a);     // Catch: Throwable -> L937
        r2135 = r2135;
    L941:
        if (r115.f38502a <= 0) goto L944;
        r24 = r116.f38503a / ((long) r115.f38502a);     // Catch: Throwable -> L937
    L944:
        long r641 = r24;
        IAutoActionTrackingApi r1222 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L937
        JSONObject r1223 = new JSONObject();     // Catch: Throwable -> L937
        if (r636 == false) goto L947;
        int r1224 = 1;
    L948:
        r1223.put(r23, r1224);     // Catch: Throwable -> L937
        r1223.put(r22, r639);     // Catch: Throwable -> L937
        r1223.put(r21, r604.f38502a);     // Catch: Throwable -> L937
        r1223.put(r20, r634);     // Catch: Throwable -> L937
        r1223.put(r19, r640);     // Catch: Throwable -> L937
        r1223.put("scroll_attempts", r115.f38502a);     // Catch: Throwable -> L937
        r1223.put(r17, r605.f38503a);     // Catch: Throwable -> L937
        r1223.put(r16, r116.f38503a);     // Catch: Throwable -> L937
        r1223.put(r30, r641);     // Catch: Throwable -> L937
        r1223.put(r29, r618.f38502a);     // Catch: Throwable -> L937
        x r642 = x.f38692a;     // Catch: Throwable -> L937
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1222, "oauto_scrollwheel_exec", r1223, false, false, null, 28, null);     // Catch: Throwable -> L937
        IAutoActionTrackingApi r643 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r13);     // Catch: Throwable -> L937
        JSONObject r644 = new JSONObject();     // Catch: Throwable -> L937
        if (r636 == false) goto L951;
        int r645 = 1;
    L952:
        r644.put(r5, r645);     // Catch: Throwable -> L937
        r644.put(r28, r1220.f38502a);     // Catch: Throwable -> L937
        r644.put(r222, r3109.f38502a);     // Catch: Throwable -> L937
        r644.put("ocr_retry_cnt", r3110.f38502a);     // Catch: Throwable -> L937
        String r646 = (String) ZeusTransformUtils.preCheckCast(r4111.f38504a, String.class, r13);     // Catch: Throwable -> L937
        if (r646 != null) goto L957;
        if (r636 == false) goto L956;
        r646 = "success";
        goto L957
    L956:
        r646 = SensitiveType.UNKNOWN;
    L957:
        r644.put("ocr_fail_code", r646);     // Catch: Throwable -> L937
        r644.put("ocr_fail_num_null_cnt", r4109.f38502a);     // Catch: Throwable -> L937
        r644.put("ocr_fail_ret_null_cnt", r4110.f38502a);     // Catch: Throwable -> L937
        x r647 = x.f38692a;     // Catch: Throwable -> L937
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r643, "oauto_scrollwheel_ocr_stat", r644, false, false, null, 28, null);     // Catch: Throwable -> L937
        n.f(x.f38692a);     // Catch: Throwable -> L937
        ?? r2136 = r2135;
    L963:
        return r2136;
    L951:
        r645 = 0;
        goto L952
    L947:
        r1224 = 0;
    L937:
        th = th;
        ?? r2137 = r2135;
    L961:
        Throwable r648 = th;
        ?? r2138 = r2137;
    L962:
        n.a r649 = n.f38560a;
        n.f(d.o.a(r648));
        r2136 = r2138;
        goto L963
    L939:
        r2135 = r631;
        r640 = 0;
    L919:
        th = move-exception;
        r648 = th;
        r2138 = r631;
    L929:
        if (r636 == false) goto L931;
        r639 = "success";
        goto L933
    L931:
        r639 = SensitiveType.UNKNOWN;
        goto L933
    L925:
        r638 = null;
        goto L926
    L1256:
        if (r635.g() != true) goto L921;
        r636 = true;
    L959:
        th = th;
        r2137 = r631;
    L964:
        th = th;
        r606 = r606;
    L966:
        th = th;
        r115 = r115;
        r605 = r605;
        r30 = r30;
        r3109 = r3109;
        r3110 = r3110;
        r4110 = r4110;
        r4111 = r4111;
        r1220 = r1220;
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r29 = r29;
    L970:
        th = th;
        r53 = r18;
        r17 = r17;
    L972:
        th = th;
        r53 = r18;
        r17 = r17;
    L56:
        th = th;
        r222 = r222;
        r118 = r606;
        r49 = r605;
        r54 = r604;
        r13 = "com.obric.aiagent.plugin";
        r50 = r116;
        r16 = r16;
        r17 = r17;
        r53 = "scroll_attempts";
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r28 = r28;
        r29 = r29;
        r30 = r30;
        r5 = r5;
        r209 = r3109;
        r2115 = r3110;
        r2114 = r4109;
        r2116 = r4110;
        r151 = r4111;
        r208 = r1220;
        r207 = r618;
        goto L986
    L59:
        r1221 = false;
        r619 = d.n.m.a(d.n.m.d(d.o.k.b(new d.o.k("\\d"), (CharSequence) ZeusTransformUtils.preCheckCast(r220, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null), $$Lambda$d$I1zUhvnyuWXSlqD0O9nUKUafFcg.INSTANCE), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);     // Catch: Throwable -> L976
        r620 = d.o.o.d(r619);     // Catch: Throwable -> L976
    L976:
        th = th;
        r618 = r618;
    L983:
        r53 = "scroll_attempts";
        r222 = r222;
        r50 = r116;
        r49 = r605;
        r208 = r1220;
        r209 = r3109;
        r2115 = r3110;
        r2116 = r4110;
        r151 = r4111;
        r28 = r28;
        r29 = r29;
        r5 = r5;
    L978:
        th = th;
        r618 = r607;
    L981:
        th = th;
        r606 = r606;
        r618 = r607;
        r604 = r604;
        r13 = "com.obric.aiagent.plugin";
        r116 = r116;
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r30 = r30;
        r3110 = r3110;
        r4109 = r4109;
        r4110 = r4110;
        r4111 = r4111;
        r1220 = r608;
    L7:
        r2 = new j(this, r1);
        goto L8
    }

    private static final CharSequence b(d.o.i r2) {
        d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final String c(d.o.i r2) {
        d.o.i r3 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r2, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return r3.b();
    }

    private static final e.C0763d b(z.d r1, z.d r2, z.d r3, z.f<String> r4, z.d r5, e.C0763d r6) {
        r1.f38502a++;
        if (r6 != null) goto L6;
        r2.f38502a++;
        r3.f38502a++;
        r4.f38504a = "ocr_ret_null";
        return null;
    L6:
        if (r6.c() != null) goto L10;
        r2.f38502a++;
        r5.f38502a++;
        r4.f38504a = "ocr_num_null";
        return r6;
    L10:
        return r6;
    }

    private final c a(Integer r5, int r6) {
        if (r5 != null) goto L6;
        Loog.INSTANCE.e(TAG, "无法提取当前数字: 当前=" + r5 + ", 目标=" + r6 + " 视作当前数值为 0");
        return c.f29547a;
    L6:
        Loog.INSTANCE.d(TAG, "滚动方向分析: 当前值=" + r5 + ", 目标值=" + r6);
        if (r6 <= r5.intValue()) goto L10;
        Loog.INSTANCE.d(TAG, "需要增大数值: " + r5 + " → " + r6 + ", 手指向上滑");
        return c.f29547a;
    L10:
        if (r6 >= r5.intValue()) goto L12;
        Loog.INSTANCE.d(TAG, "需要减小数值: " + r5 + " → " + r6 + ", 手指向下滑");
        return c.f29548b;
    L12:
        Loog.INSTANCE.d(TAG, "已达到目标值: " + r5);
        return c.f29549c;
    }

    private final boolean a(List<C0762d> r4, int r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r3.size() >= 2) goto L5;
        return false;
    L5:
        List r6 = p.f(r3, 2);
        int r7 = Math.abs(((C0762d) ZeusTransformUtils.preCheckCast(r6.get(0), C0762d.class, "com.obric.aiagent.plugin")).a());
        int r8 = Math.abs(((C0762d) ZeusTransformUtils.preCheckCast(r6.get(1), C0762d.class, "com.obric.aiagent.plugin")).a());
        if (r7 != r8) goto L9;
        if (r7 <= 0) goto L9;
        r1 = true;
    L9:
        Loog.INSTANCE.d(TAG, "智能滚动分析: 第1步变化=" + r7 + ", 第2步变化=" + r8 + ", 一致性=" + r1);
        return r1;
    }

    private final Integer a(List<C0762d> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3.size() >= 2) goto L6;
        return null;
    L6:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(p.f(r3, 2), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        r6.add(Integer.valueOf(Math.abs(((C0762d) ZeusTransformUtils.preCheckCast(r7.next(), C0762d.class, "com.obric.aiagent.plugin")).a())));
        goto L8
    L11:
        return Integer.valueOf((int) p.z((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
    }

    private final int a(int r6, int r7, int r8) {
        int r5 = Math.abs(r7 - r6);
        if (r8 <= 0) goto L5;
        int r1 = ((r5 + r8) - 1) / r8;
    L6:
        int r0 = Math.max(1, Math.min(r1, 4));
        Loog.INSTANCE.d(TAG, "步数计算: 当前=" + r6 + ", 目标=" + r7 + ", 差距=" + r5 + ", 单步=" + r8 + ", 需要=" + r1 + ", 实际=" + r0);
        return r0;
    L5:
        r1 = 1;
        goto L6
    }

    private final Object a(float r7, float r8, float r9, c r10, int r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        return a(r7, r8, r9 * r11, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(float r20, float r21, float r22, c r23, d.c.d<? super com.obric.autogui.common.e> r24) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L7;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        if ((r5.f29614c & Integer.MIN_VALUE) == 0) goto L7;
        r5.f29614c -= Integer.MIN_VALUE;
    L8:
        h r14 = r5;
        Object r4 = r14.f29612a;
        Object r6 = d.c.a.b.a();
        int r7 = r14.f29614c;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        d.o.a(r4);
        Object r2 = r4;
        String r0 = "❌ 滚动操作失败: ";
    L33:
        com.obric.autogui.common.e r8 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r8.g() == false) goto L36;
        Loog.INSTANCE.i(TAG, "✅ 滚动操作成功");
    L37:
        return r8;
    L36:
        Loog.INSTANCE.w(r12, r0 + r8.h());
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r4);
        String r1 = "❌ 滚动操作失败: ";
    L25:
        com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r9.g() == false) goto L28;
        Loog.INSTANCE.i(TAG, "✅ 滚动操作成功");
    L29:
        return r9;
    L28:
        Loog.INSTANCE.w(r12, r1 + r9.h());
        goto L29
    L16:
        d.o.a(r4);
        float r10 = r23.a() * r22;
        float r11 = r21 + r10;
        Loog.INSTANCE.i(TAG, "🎯 执行滚动: direct" + r23.a() + ", actualDistance=" + r10 + "px");
        if (Math.abs(r10) >= 60.0f) goto L30;
        Loog.INSTANCE.w(TAG, "滚动距离过小(" + r10 + ")，调整为最小有效距离");
        if (r10 <= 0.0f) goto L21;
        float r12 = 60.0f;
    L22:
        float r13 = r21 + r12;
        Loog.INSTANCE.i(TAG, "🎯 执行滚动: 手指" + r23.name() + ", 原始距离=" + ((int) r22) + ", 调整后距离=" + ((int) Math.abs(r12)));
        Loog.INSTANCE.i(TAG, "🎯 滚动路径: (" + r20 + ", " + ((int) r21) + ") -> (" + r20 + ", " + ((int) r13) + ')');
        com.obric.autogui.operator.a.c r15 = com.obric.autogui.operator.a.c.f29713a;
        m r16 = new m(d.c.b.a.b.a(r20), d.c.b.a.b.a(r21));
        m r17 = new m(d.c.b.a.b.a(r20), d.c.b.a.b.a(r13));
        r14.f29614c = 1;
        r1 = "❌ 滚动操作失败: ";
        r4 = com.obric.autogui.operator.a.c.a(r15, r16, r17, 300, true, null, null, r14, 48, null);
        if (r4 != r6) goto L25;
        return r6;
    L21:
        r12 = -60.0f;
        goto L22
    L30:
        Loog.INSTANCE.i(TAG, "🎯 执行滚动: 手指" + r23.name() + ", 距离=" + r22 + "px");
        Loog.INSTANCE.i(TAG, "🎯 滚动路径: (" + r20 + ", " + r21 + ") -> (" + r20 + ", " + r11 + ')');
        com.obric.autogui.operator.a.c r18 = com.obric.autogui.operator.a.c.f29713a;
        m r19 = new m(d.c.b.a.b.a(r20), d.c.b.a.b.a(r21));
        m r25 = new m(d.c.b.a.b.a(r20), d.c.b.a.b.a(r11));
        r14.f29614c = 2;
        r0 = "❌ 滚动操作失败: ";
        r2 = com.obric.autogui.operator.a.c.a(r18, r19, r25, 300, true, null, null, r14, 48, null);
        if (r2 != r6) goto L33;
        return r6;
    L7:
        r5 = new h(this, r3);
        goto L8
    }

    static /* synthetic */ Object a(d r1, String r2, boolean r3, RequestParams r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super IBaseModel> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = new RequestParams(null, null, 3, null);
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    private final Object a(String r16, boolean r17, RequestParams r18, d.c.d<? super IBaseModel> r19) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r2.f & Integer.MIN_VALUE) == 0) goto L7;
        r2.f -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f29610d;
        Object r9 = d.c.a.b.a();
        int r3 = r2.f;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        d.o.a(r1);
    L34:
        return r1;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r4 = r2.f29609c;
        RequestParams r5 = (RequestParams) ZeusTransformUtils.preCheckCast(r2.f29608b, RequestParams.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.f29607a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
        ((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.aiagent.plugin")).a();
    L31:
        AIKernelManager r7 = AIKernelManager.INSTANCE;
        r2.f29607a = null;
        r2.f29608b = null;
        r2.f = 3;
        r1 = r7.loadPackage(r6, r4, r5, r2);
        if (r1 != r9) goto L34;
        return r9;
    L17:
        boolean r8 = r2.f29609c;
        RequestParams r10 = (RequestParams) ZeusTransformUtils.preCheckCast(r2.f29608b, RequestParams.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2.f29607a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
        boolean r14 = r8;
        RequestParams r13 = r10;
        Object r12 = ((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.aiagent.plugin")).a();
        String r15 = r11;
    L22:
        if (n.b(r12) == false) goto L24;
        r12 = null;
    L24:
        PackageResource r20 = (PackageResource) ZeusTransformUtils.preCheckCast(r12, PackageResource.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L27;
        return null;
    L27:
        AIKernelManager r21 = AIKernelManager.INSTANCE;
        RequestParams r22 = new RequestParams(null, null, 3, null);
        r2.f29607a = r15;
        r2.f29608b = r13;
        r2.f29609c = r14;
        r2.f = 2;
        if (r21.mo394updatePackage0E7RQCE(r20, r22, r2) != r9) goto L30;
        return r9;
    L30:
        r6 = r15;
        r5 = r13;
        r4 = r14;
        goto L31
    L18:
        d.o.a(r1);
        IAIKernelManager r23 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.aiagent.plugin");
        r15 = r16;
        r2.f29607a = r15;
        r13 = r18;
        r2.f29608b = r13;
        r14 = r17;
        r2.f29609c = r14;
        r2.f = 1;
        r12 = IAIKernelManager.DefaultImpls.m395getPackage0E7RQCE$default(r23, r16, null, r2, 2, null);
        if (r12 != r9) goto L22;
        return r9;
    L7:
        r2 = new g(this, r0);
        goto L8
    }
}
