package com.obric.autogui.platforms.tools.f;

import android.content.Context;
import com.obric.aiagent.applog.IAppLog;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import kotlinx.coroutines.a.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseTrackingImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements IAutoActionTrackingApi {
    private static final String TAG = "Tracking";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0809a f30225b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f30226c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<b> f30227a;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseTrackingImpl.kt */
    public static final class C0809a {
        public /* synthetic */ C0809a(h r1) {
            this();
        }

        private C0809a() {
        }
    }

    /* JADX INFO: compiled from: BaseTrackingImpl.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f30229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f30230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f30231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final TrackingReportTarget f30232e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30228a, r6.f30228a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30229b, r6.f30229b) == true) goto L15;
            return false;
        L15:
            if (this.f30230c == r6.f30230c) goto L18;
            return false;
        L18:
            if (this.f30231d == r6.f30231d) goto L21;
            return false;
        L21:
            if (this.f30232e == r6.f30232e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f30228a.hashCode() * 31) + this.f30229b.hashCode()) * 31) + Boolean.hashCode(this.f30230c)) * 31) + Boolean.hashCode(this.f30231d)) * 31) + this.f30232e.hashCode();
        }

        public String toString() {
            return "Event(event=" + this.f30228a + ", keyValue=" + this.f30229b + ", eventAppendObricPrefix=" + this.f30230c + ", paramAppendObricPrefix=" + this.f30231d + ", target=" + this.f30232e + ')';
        }

        public b(String r2, JSONObject r3, boolean r4, boolean r5, TrackingReportTarget r6) {
            o.e(r2, "event");
            o.e(r3, "keyValue");
            o.e(r6, "target");
            this.f30228a = r2;
            this.f30229b = r3;
            this.f30230c = r4;
            this.f30231d = r5;
            this.f30232e = r6;
        }

        public final String a() {
            return this.f30228a;
        }

        public final JSONObject b() {
            return this.f30229b;
        }

        public final boolean c() {
            return this.f30230c;
        }

        public final boolean d() {
            return this.f30231d;
        }

        public final TrackingReportTarget e() {
            return this.f30232e;
        }
    }

    /* JADX INFO: compiled from: BaseTrackingImpl.kt */
    @f(b = "BaseTrackingImpl.kt", c = {94}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.tracking.BaseTrackingImpl$enqueueEvent$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f30237e;
        final /* synthetic */ boolean f;
        final /* synthetic */ TrackingReportTarget g;

        c(a r3, String r4, String r5, boolean r6, boolean r7, TrackingReportTarget r8, d.c.d<? super c> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30234b = r3;
            this.f30235c = r4;
            this.f30236d = r5;
            this.f30237e = r6;
            this.f = r7;
            this.g = r8;
            super(1, r10);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30234b, this.f30235c, this.f30236d, this.f30237e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30233a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            kotlinx.coroutines.a.d r11 = a.a(this.f30234b);
            b r2 = new b(this.f30235c, new JSONObject(this.f30236d), this.f30237e, this.f, this.g);
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30233a = 1;
            if (r11.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BaseTrackingImpl.kt */
    @f(b = "BaseTrackingImpl.kt", c = {50}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.tracking.BaseTrackingImpl$init$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f30240c;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30240c = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30240c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0041 -> B:12:0x0044). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30239b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            kotlinx.coroutines.a.f r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f30238a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
        L13:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L16;
            b r7 = (b) ZeusTransformUtils.preCheckCast(r2.a(), b.class, "com.obric.aiagent.plugin");
            a.a(this.f30240c, r7);
        L9:
            d.c.d<? super Boolean> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30238a = r2;
            this.f30239b = 1;
            r6 = r2.a(r8);
            if (r6 != r0) goto L13;
            return r0;
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            r2 = a.a(this.f30240c).g();
            goto L9
        }
    }

    public a() {
        this.f30227a = g.a(Integer.MAX_VALUE, null, null, 6, null);
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d a(a r0) {
        return r0.f30227a;
    }

    public static final /* synthetic */ void a(a r0, b r1) {
        r0.a(r1);
    }

    static {
        f30225b = new C0809a(null);
        f30226c = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "ao-biz-track-th", false, 2, null);
    }

    @Override // com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi
    public void init(Context r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), "context");
        f30226c.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void a(JSONObject r3) {
        r3.put("aa_common_build_branch", "");
        r3.put("aa_common_build_is_debug", AOSystemTools.INSTANCE.isDebugVersion());
        r3.put("aa_common_build_timestamp", "");
    }

    private final void b(JSONObject r1) {
        a(r1);
    }

    @Override // com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi
    public final void reportEvent(String r2, JSONObject r3, boolean r4, boolean r5, TrackingReportTarget r6) {
        o.e(r2, "event");
        o.e(r3, "keyValue");
        o.e(r6, "reportTarget");
        b(r2, r3, r4, r5, r6);
    }

    private final void b(String r10, JSONObject r11, boolean r12, boolean r13, TrackingReportTarget r14) {
        String r3 = r11.toString();
        o.c(r3, "toString(...)");
        f30226c.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, r10, r3, r12, r13, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void a(b r8) {
        b(r8.b());
        a(r8.a(), r8.b(), r8.c(), r8.d(), r8.e());
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.i(TAG, "[ReportedEvent] " + r8.a() + " | " + r8.b());
        return;
    L5:
        Loog.INSTANCE.d(TAG, "[ReportedEvent] " + r8.a() + " [value omitted in production build]");
    }

    public void a(String r2, JSONObject r3, boolean r4, boolean r5, TrackingReportTarget r6) {
        o.e(r2, "event");
        o.e(r3, "processedKV");
        o.e(r6, "reportTarget");
        if (r6 != TrackingReportTarget.TEA_AGENT_ONLY) goto L6;
        Loog.INSTANCE.w(TAG, "TeaAgent reporting is not supported, skipping event: " + r2);
        return;
    L6:
        a(r2, r3, r4, r5);
    }

    public final void a(String r5, JSONObject r6, boolean r7, boolean r8) {
        o.e(r5, "event");
        o.e(r6, "keyValue");
        if (r7 == false) goto L5;
        r5 = a(r5);
    L5:
        JSONObject r9 = new JSONObject();
        Iterator<String> r0 = r6.keys();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (r8 == true) goto L10;
        r9.put(r1, r6.opt(r1));
        goto L7
    L10:
        o.a(r1);
        r9.put(a(r1), r6.opt(r1));
        goto L7
    L12:
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L16;
        r4.reportToFlow(r5, r9);
    L16:
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L25;
        Loog.INSTANCE.d(TAG, "[ReportedFlowAppLogEvent] " + r5 + " | " + r9);
        return;
    }

    private final String a(String r5) {
        if (d.o.o.b(r5, "obric_oauto_", false, 2, null) == false) goto L6;
        return r5;
    L6:
        if (d.o.o.b(r5, "oauto_", false, 2, null) == false) goto L10;
        return "obric_" + r5;
    L10:
        return "obric_oauto_" + r5;
    }
}
