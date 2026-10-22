package com.obric.agent.intents;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.trace.g;
import com.obric.agent.utils.s;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemLocationRequestParams;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocationRequestIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LocationRequestIntent extends BaseSystemLocationRequestIntent {
    public static final a Companion = null;
    private static final long TIME_OUT = 30000;

    /* JADX INFO: compiled from: LocationRequestIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public LocationRequestIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemLocationRequestParams) ZeusTransformUtils.preCheckCast(r6, SystemLocationRequestParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent
    public Object doAction(SystemLocationRequestParams r22, DispatchContext r23, d<? super IntentResult<Empty>> r24) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r24, d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(getName(), "doAction needHighPrecision:" + r22.getNeedHighPrecision() + " timeout:" + r22.getTimeout());
        Long r2 = r22.getTimeout();
        if (r2 == null) goto L5;
        long r3 = r2.longValue() * 1000;
    L6:
        long r5 = System.currentTimeMillis();
        IFlowAppIntentIDL r4 = r.a(aa.b(IFlowAppIntentIDL.class));
        boolean r9 = true;
        if (r4 == null) goto L9;
        Boolean r6 = d.c.b.a.b.a(r4.checkPermission("location", true, r3));
    L10:
        long r10 = System.currentTimeMillis() - r5;
        ILogDepend.Companion.d(getName(), "doAction isGranted = " + r6 + ", duration:" + r10 + "ms");
        if (o.a(r6, d.c.b.a.b.a(true)) == false) goto L14;
        String r7 = "success";
    L17:
        g.f15449a.a("location", "LocationRequestIntent", o.a(r6, d.c.b.a.b.a(true)), r7);
        if (r6 != null) goto L20;
    L53:
        ILogDepend.Companion.d(getName(), "doAction checkPermission failed reason:" + r7);
        IntentResult r0 = new IntentResult(113, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        if (o.a(r7, "timeout") == false) goto L56;
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_location_request_permission_timeout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_request_permission_timeout"));
    L57:
        r0.setDetails(r8);
        return r0;
    L56:
        r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_location_request_permission_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_request_permission_failed"));
        goto L57
    L20:
        if (o.a(r6, d.c.b.a.b.a(false)) == true) goto L53;
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_location_request_memory_denied, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_request_memory_denied"));
        o.c(r11, "getString(...)");
        MemoryResponse r12 = com.obric.memorydata.sdk.a.a(com.obric.memorydata.sdk.a.f33793a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, 2, null);
        ISecureLogDepend.Companion.i(getName(), "doAction location:" + r12);
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.getData(), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L46;
        n.a r14 = n.f38560a;     // Catch: Throwable -> L41
        LocationRequestIntent r15 = (LocationRequestIntent) ZeusTransformUtils.preCheckCast(this, LocationRequestIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L30;
        r9 = false;
    L30:
        if (r9 == true) goto L32;
    L37:
        Object r16 = n.f(x.f38692a);     // Catch: Throwable -> L39
    L44:
        n.g(r16);
        goto L46
    L32:
        if (o.a(new JSONObject(r13).optString("LOCATION", ""), "") == true) goto L37;
        IntentResult r17 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);     // Catch: Throwable -> L35
        r17.setDetails(r13);     // Catch: Throwable -> L35
        return r17;
    L35:
        th = th;
        r11 = r13;
    L43:
        n.a r18 = n.f38560a;
        r16 = n.f(d.o.a(th));
    L39:
        th = th;
    L41:
        th = th;
    L46:
        Location r19 = s.f16064a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(10000));
        if (r19 == null) goto L51;
        String r20 = s.f16064a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19.getLatitude(), r19.getLongitude());
        if (r20 == null) goto L51;
        String r21 = new JSONObject().put("LOCATION", r20).toString();
        o.c(r21, "toString(...)");
        r11 = r21;
    L51:
        ISecureLogDepend.Companion.i(getName(), "doAction location result:" + r11);
        IntentResult r25 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r25.setDetails(r11);
        return r25;
    L14:
        if (r10 < r3) goto L16;
        r7 = "timeout";
        goto L17
    L16:
        r7 = "denied";
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = 30000;
        goto L6
    }
}
