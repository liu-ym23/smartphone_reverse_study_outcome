package com.obric.autogui.platforms.tools.internal.viewhierarchy;

import android.app.ITopActivityAssistDataReceiver;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.EventsUtils;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewHierarchyDumpAsync {
    private static final String TAG = "Ref-VHD-Async";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30374a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f30375e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssistDataReceiver f30376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f30377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile a f30378d;

    /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
    private final class AssistDataReceiver extends ITopActivityAssistDataReceiver.Stub {
        final /* synthetic */ ViewHierarchyDumpAsync this$0;

        public AssistDataReceiver(ViewHierarchyDumpAsync r1) {
            this.this$0 = r1;
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onResultData(int r4, Bundle r5) {
            Loog.INSTANCE.i(ViewHierarchyDumpAsync.TAG, "VHD via AssistData: " + r4 + ", " + r5);
            a r3 = ViewHierarchyDumpAsync.a(this.this$0);
            boolean r0 = false;
            if (r3 != null) goto L5;
        L7:
            if (r0 == false) goto L9;
            r3.a(r5);
            return;
        L9:
            Loog r6 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append(" - calling back VHD via AssistData: ").append(r4).append(", which is not consistent with the ongoing VHD requestId=");
            if (r3 == null) goto L12;
            Integer r8 = Integer.valueOf(r3.a());
        L13:
            r6.w(ViewHierarchyDumpAsync.TAG, r7.append(r8).toString());
            return;
        L12:
            r8 = null;
            goto L13
        L5:
            if (r3.a() != r4) goto L7;
            r0 = true;
            goto L7
        }

        @Override // android.app.ITopActivityAssistDataReceiver
        public void onScreenshotData(int r3, Bundle r4) {
            Loog.INSTANCE.d(ViewHierarchyDumpAsync.TAG, "Screenshot via AssistData: " + r3 + ", " + r4);
        }
    }

    /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewHierarchyDumpAsync f30379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f30381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Collection<a> f30382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final w<Object> f30383e;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.internal.viewhierarchy.ViewHierarchyDumpAsync$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
        @f(b = "ViewHierarchyDumpAsync.kt", c = {200, EventsUtils.FEAT_TYPE_NFC_EVENT, 95, 210}, d = Ext.KEY_REQUEST, e = "com.obric.autogui.platforms.tools.internal.viewhierarchy.ViewHierarchyDumpAsync$AssistDataRequestSession")
        static final class C0814a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f30384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f30385b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f30386c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f30387d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f30388e;
            final /* synthetic */ a f;
            int g;

            C0814a(a r3, d.c.d<? super C0814a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f30388e = r3;
                this.g |= Integer.MIN_VALUE;
                return this.f.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
        @f(b = "ViewHierarchyDumpAsync.kt", c = {96}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.internal.viewhierarchy.ViewHierarchyDumpAsync$AssistDataRequestSession$request$result$1")
        static final class b extends l implements m<am, d.c.d<? super Object>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30389a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f30390b;

            b(a r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30390b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<Object> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30390b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Object> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f30389a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r5);
                w r6 = a.a(this.f30390b);
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30389a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        public a(ViewHierarchyDumpAsync r2, int r3) {
            this.f30379a = r2;
            this.f30380b = r3;
            this.f30381c = ViewHierarchyDumpAsync.a().getAndIncrement();
            this.f30382d = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            this.f30383e = y.a(null, 1, null);
        }

        public static final /* synthetic */ w a(a r0) {
            return r0.f30383e;
        }

        public final int a() {
            return this.f30381c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v25 */
        /* JADX WARN: Type inference failed for: r14v39 */
        /* JADX WARN: Type inference failed for: r14v40 */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v25 */
        /* JADX WARN: Type inference failed for: r4v26 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object a(d.c.d<Object> r15) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r16, C0814a.class) == false) goto L7;
            C0814a r1 = (C0814a) ZeusTransformUtils.preCheckCast(r16, C0814a.class, "com.obric.aiagent.plugin");
            if ((r1.g & Integer.MIN_VALUE) == 0) goto L7;
            r1.g -= Integer.MIN_VALUE;
        L8:
            Object r17 = r1.f30388e;
            Object r3 = d.c.a.b.a();
            a r4 = r1.g;
            if (r4 == 0) goto L22;
            if (r4 == 1) goto L21;
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L17;
            if (r4 != 4) goto L16;
            ViewHierarchyDumpAsync r14 = (ViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r1.f30387d, ViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r5 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f30386c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            Object r6 = r1.f30385b;
            a r2 = (a) ZeusTransformUtils.preCheckCast(r1.f30384a, a.class, "com.obric.aiagent.plugin");
            o.a(r17);
            a r7 = r2;
        L65:
            ViewHierarchyDumpAsync.a(r14, null);     // Catch: Throwable -> L55
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.f30382d, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L55
        L50:
            if (r18.hasNext() == false) goto L52;
            ((a) ZeusTransformUtils.preCheckCast(r18.next(), a.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L55
            goto L50
        L52:
            x r19 = x.f38692a;     // Catch: Throwable -> L55
            r5.b(null);
            return r6;
        L55:
            th = move-exception;
            r5.b(null);
            throw th;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            z.a r110 = (z.a) ZeusTransformUtils.preCheckCast(r1.f30385b, z.a.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.preCheckCast(r1.f30384a, a.class, "com.obric.aiagent.plugin");
            o.a(r17);     // Catch: de -> L40
            r4 = r8;
            z.a this = r110;
        L62:
        L42:
            if (this.f38499a == true) goto L44;
            return r17;
        L44:
            kotlinx.coroutines.f.a r111 = ViewHierarchyDumpAsync.b(r4.f30379a);
            ViewHierarchyDumpAsync r9 = r4.f30379a;
            r1.f30384a = r4;
            r1.f30385b = r17;
            r1.f30386c = r111;
            r1.f30387d = r9;
            r1.g = 4;
            if (r111.a(null, r1) != r3) goto L47;
            return r3;
        L47:
            r5 = r111;
            r7 = r4;
            r14 = r9;
            r6 = r17;
            goto L65
        L20:
            z.a r112 = (z.a) ZeusTransformUtils.preCheckCast(r1.f30385b, z.a.class, "com.obric.aiagent.plugin");
            a r10 = (a) ZeusTransformUtils.preCheckCast(r1.f30384a, a.class, "com.obric.aiagent.plugin");
            o.a(r17);
            a r11 = r10;
            z.a r113 = r112;
        L37:
            m r114 = (m) ZeusTransformUtils.preCheckCast(new b(r11, null), m.class, "com.obric.aiagent.plugin");     // Catch: de -> L40
            r1.f30384a = r11;     // Catch: de -> L40
            r1.f30385b = r113;     // Catch: de -> L40
            r1.f30386c = null;     // Catch: de -> L40
            r1.f30387d = null;     // Catch: de -> L40
            r1.g = 3;     // Catch: de -> L40
            r17 = dg.a(EntityContentProvider.g, r114, r1);     // Catch: de -> L40
            r4 = r11;
            this = r113;
            if (r17 != r3) goto L62;
            return r3;
        L21:
            ViewHierarchyDumpAsync r115 = (ViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r1.f30387d, ViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r12 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f30386c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            z.a r13 = (z.a) ZeusTransformUtils.preCheckCast(r1.f30385b, z.a.class, "com.obric.aiagent.plugin");
            a r116 = (a) ZeusTransformUtils.preCheckCast(r1.f30384a, a.class, "com.obric.aiagent.plugin");
            o.a(r17);
            z.a r117 = r13;
            a r118 = r116;
        L61:
            a r119 = ViewHierarchyDumpAsync.a(r115);     // Catch: Throwable -> L58
            if (r119 != null) goto L29;
            ViewHierarchyDumpAsync.a(r115, r118);     // Catch: Throwable -> L58
            r117.f38499a = true;     // Catch: Throwable -> L58
            x r120 = x.f38692a;     // Catch: Throwable -> L58
        L30:
            r12.b(null);
            if (r117.f38499a == false) goto L35;
            r1.f30384a = r118;
            r1.f30385b = r117;
            r1.f30386c = null;
            r1.f30387d = null;
            r1.g = 2;
            if (r118.b(r1) != r3) goto L35;
            return r3;
        L35:
            r113 = r117;
            r11 = r118;
            goto L37
        L29:
            Loog.INSTANCE.i(ViewHierarchyDumpAsync.TAG, "[VHD-Dump] awaiting for VHDSession(" + r118.f30381c + ")'s result.");     // Catch: Throwable -> L58
            d.c.b.a.b.a(r119.f30382d.add(r118));     // Catch: Throwable -> L58
        L58:
            th = move-exception;
            r12.b(null);
            throw th;
        L22:
            o.a(r17);
            r117 = new z.a();
            r12 = ViewHierarchyDumpAsync.b(this.f30379a);
            ViewHierarchyDumpAsync r121 = this.f30379a;
            r1.f30384a = this;
            r1.f30385b = r117;
            r1.f30386c = r12;
            r1.f30387d = r121;
            r1.g = 1;
            if (r12.a(null, r1) != r3) goto L25;
            return r3;
        L25:
            r118 = this;
            r115 = r121;
        L40:
            Loog.INSTANCE.e(ViewHierarchyDumpAsync.TAG, "[VHD-Dump] timeout for VHDSession(" + r4.f30381c + ").");
            r17 = null;
        L7:
            r1 = new C0814a(this, r16);
            goto L8
        }

        private final Object b(d.c.d<? super x> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            ViewHierarchyDumpAsync r8 = this.f30379a;
            n.a r0 = n.f38560a;     // Catch: Throwable -> L5
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r9 = n.f(d.c.b.a.b.a(ObricProductSdk.INSTANCE.platformService().activityManager().requestTopActivityAssistData(r1.f30381c, r1.f30380b, (ITopActivityAssistDataReceiver) ZeusTransformUtils.preCheckCast(ViewHierarchyDumpAsync.c(r8), ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L5
        L7:
            Throwable r2 = n.c(r9);
            if (r2 == null) goto L12;
            Loog.INSTANCE.e(ViewHierarchyDumpAsync.TAG, "[VHD-Dump] invocation error for VHDSession(" + this.f30381c + ").", r2);
            r9 = d.c.b.a.b.a(false);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L15;
            Loog.INSTANCE.e(ViewHierarchyDumpAsync.TAG, "[VHD-Dump] failed invocation for VHDSession(" + this.f30381c + ") (service_error).");
            a(null);
        L15:
            return x.f38692a;
        L5:
            th = move-exception;
            n.a r3 = n.f38560a;
            r9 = n.f(o.a(th));
            goto L7
        }

        public final void a(Object r1) {
            this.f30383e.a(r1);
        }
    }

    /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ViewHierarchyDumpAsync.kt */
    @f(b = "ViewHierarchyDumpAsync.kt", c = {148}, d = "dumpTopWindow", e = "com.obric.autogui.platforms.tools.internal.viewhierarchy.ViewHierarchyDumpAsync")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f30395e;
        final /* synthetic */ ViewHierarchyDumpAsync f;
        int g;

        c(ViewHierarchyDumpAsync r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30395e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public ViewHierarchyDumpAsync() {
        this.f30376b = new AssistDataReceiver(this);
        this.f30377c = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    public static final /* synthetic */ a a(ViewHierarchyDumpAsync r0) {
        return r0.f30378d;
    }

    public static final /* synthetic */ AtomicInteger a() {
        return f30375e;
    }

    public static final /* synthetic */ void a(ViewHierarchyDumpAsync r0, a r1) {
        r0.f30378d = r1;
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a b(ViewHierarchyDumpAsync r0) {
        return r0.f30377c;
    }

    public static final /* synthetic */ AssistDataReceiver c(ViewHierarchyDumpAsync r0) {
        return r0.f30376b;
    }

    static {
        f30374a = new b(null);
        f30375e = new AtomicInteger(0);
    }

    public final Object a(int r10, d.c.d<? super com.obric.autogui.common.d<AssistStructure>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f30395e;
        Object r2 = d.c.a.b.a();
        int r3 = r0.g;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r9 = r0.f30394d;
        int r4 = r0.f30393c;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r0.f30392b, a.class, "com.obric.aiagent.plugin");
        ViewHierarchyDumpAsync r1 = (ViewHierarchyDumpAsync) ZeusTransformUtils.preCheckCast(r0.f30391a, ViewHierarchyDumpAsync.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L18:
        Loog.INSTANCE.i(TAG, " - dumpTopWindow done: (l=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r9) + ", dId=" + r4 + ", reqId=" + r5.a() + ") data=" + r13);
        if (ZeusTransformUtils.instanceOf(r13, Bundle.class) == false) goto L27;
        Loog.INSTANCE.i(TAG, " - dumpTopWindow bundleSize = " + ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).size());
        Iterator<String> r14 = ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).keySet().iterator();
    L22:
        if (r14.hasNext() == false) goto L25;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "   - " + r15 + " ==> " + ((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")).get(r15));
        goto L22
    L25:
        return com.obric.autogui.common.d.f29012a.a(r1.a((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin")));
    L27:
        return com.obric.autogui.common.d.f29012a.a("not supported");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        r5 = new a(this, r10);
        Loog.INSTANCE.i(TAG, " - dumpTopWindow called: (dId=" + r10 + ", reqId=" + r5.a() + ')');
        long r7 = AOSystemTools.INSTANCE.nowTimeMillis();
        r0.f30391a = this;
        r0.f30392b = r5;
        r0.f30393c = r10;
        r0.f30394d = r7;
        r0.g = 1;
        r13 = r5.a(r0);
        if (r13 != r2) goto L17;
        return r2;
    L17:
        r1 = this;
        r4 = r10;
        r9 = r7;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    private final AssistStructure a(Bundle r6) {
    L16:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "expected AssistStructure for Bundle key `structure`, exc=" + th);
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 33) goto L7;
        AssistStructure r7 = (AssistStructure) ZeusTransformUtils.preCheckCast(r6.getParcelable("structure", AssistStructure.class), AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L12:
        if (r7 != null) goto L15;
        Loog.INSTANCE.w(TAG, "expected non-null AssistStructure for Bundle key `structure`.");
        return null;
    L15:
        return r7;
    L7:
        Parcelable r8 = r6.getParcelable("structure");     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r8, AssistStructure.class) == false) goto L11;
        r7 = (AssistStructure) ZeusTransformUtils.preCheckCast(r8, AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        goto L12
    L11:
        r7 = null;
        goto L12
    }
}
