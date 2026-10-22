package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: VirtualDisplayRecordSetBizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements t {
    private static final String TAG = "VDRecordSetTracking";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f27494a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f27495b = null;

    /* JADX INFO: compiled from: VirtualDisplayRecordSetBizTracking.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetBizTracking.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetBizTracking$report$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f27497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f27498c;

        a(JSONObject r3, s r4, d.c.d<? super a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27497b = r3;
            this.f27498c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27497b, this.f27498c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f27496a != 0) goto L12;
            d.o.a(r10);
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_virtual_display_record_set_abnormal", this.f27497b, false, false, null, 28, null);     // Catch: Exception -> L7
        L10:
            return x.f38692a;
        L7:
            e = move-exception;
            Loog.INSTANCE.w(m.TAG, "tracking submit failed stage=" + this.f27498c.a() + " outcome=" + this.f27498c.b() + " reason=" + this.f27498c.c(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private m() {
    }

    static {
        f27494a = new m();
        f27495b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.t
    public void a(s r2) {
        d.h.b.o.e(r2, "event");
        a(r2, null);
    }

    public final void a(s r10, com.obric.autogui.session.a r11) {
        d.h.b.o.e(r10, "event");
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L80
        r3.put("stage", r10.a());     // Catch: Exception -> L80
        r3.put("outcome", r10.b());     // Catch: Exception -> L80
        r3.put("reason", r10.c());     // Catch: Exception -> L80
        String r4 = r10.d();     // Catch: Exception -> L80
        if (r4 != null) goto L6;
    L11:
        Long r5 = r10.e();     // Catch: Exception -> L80
        if (r5 == null) goto L14;
        r3.put("framework_session_id", ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Exception -> L80
    L14:
        Integer r6 = r10.f();     // Catch: Exception -> L80
        if (r6 == null) goto L17;
        r3.put("display_id", ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L80
    L17:
        String r7 = r10.g();     // Catch: Exception -> L80
        if (r7 != null) goto L20;
    L25:
        String r8 = r10.h();     // Catch: Exception -> L80
        if (r8 != null) goto L28;
    L33:
        String r9 = r10.i();     // Catch: Exception -> L80
        if (r9 != null) goto L36;
    L41:
        Integer r12 = r10.j();     // Catch: Exception -> L80
        if (r12 == null) goto L44;
        r3.put("session_origin", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L80
    L44:
        Boolean r13 = r10.k();     // Catch: Exception -> L80
        if (r13 == null) goto L47;
        r3.put("is_omni", r13.booleanValue());     // Catch: Exception -> L80
    L47:
        String r14 = r10.l();     // Catch: Exception -> L80
        if (r14 != null) goto L50;
    L55:
        Integer r15 = r10.m();     // Catch: Exception -> L80
        if (r15 == null) goto L58;
        r3.put("published_package_count", ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L80
    L58:
        Integer r16 = r10.n();     // Catch: Exception -> L80
        if (r16 == null) goto L61;
        r3.put("attempted_total_count", ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L80
    L61:
        Integer r17 = r10.o();     // Catch: Exception -> L80
        if (r17 == null) goto L64;
        r3.put("framework_reason_code", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L80
    L64:
        Boolean r18 = r10.p();     // Catch: Exception -> L80
        if (r18 == null) goto L67;
        r3.put("operation_blocked", r18.booleanValue());     // Catch: Exception -> L80
    L67:
        Boolean r19 = r10.q();     // Catch: Exception -> L80
        if (r19 == null) goto L70;
        r3.put("fail_closed", r19.booleanValue());     // Catch: Exception -> L80
    L70:
        Boolean r20 = r10.r();     // Catch: Exception -> L80
        if (r20 == null) goto L73;
        r3.put("owner_matched", r20.booleanValue());     // Catch: Exception -> L80
    L73:
        if (r11 == null) goto L75;
        com.obric.autogui.session.c.b.a(r3, r11);     // Catch: Exception -> L80
    L75:
        kotlinx.coroutines.i.a(f27495b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Loog r110 = Loog.INSTANCE;
        StringBuilder r21 = new StringBuilder().append("event=technical_event_submitted stage=").append(r10.a()).append(" outcome=").append(r10.b()).append(" reason=").append(r10.c()).append(" source=");
        String r111 = r10.d();
        if (r111 != null) goto L78;
        r111 = "";
    L78:
        r110.i(TAG, r21.append(r111).toString());
        return;
    L50:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L53;
        r14 = null;
    L53:
        if (r14 == null) goto L55;
        r3.put("package_name", r14);     // Catch: Exception -> L80
        goto L55
    L36:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L39;
        r9 = null;
    L39:
        if (r9 == null) goto L41;
        r3.put("request_session_key", r9);     // Catch: Exception -> L80
        goto L41
    L28:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        r3.put("session_key", r8);     // Catch: Exception -> L80
        goto L33
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        r3.put("session_id", r7);     // Catch: Exception -> L80
        r3.put("instruction_id", r7);     // Catch: Exception -> L80
        goto L25
    L6:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L11;
        r3.put(DBHelper.BATTERY_COL_SOURCE, r4);     // Catch: Exception -> L80
    L80:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "tracking payload failed stage=" + r10.a() + " outcome=" + r10.b() + " reason=" + r10.c(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
