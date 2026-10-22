package com.obric.agent.intents.permission;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.agent.permission.bean.GetLocationResult;
import com.obric.agent.utils.s;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.o;

/* JADX INFO: compiled from: GetLocationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GetLocationIntent extends BaseSystemGetLocationIntent {
    public static final a Companion = null;
    private static final long TIMEOUT = 10000;

    /* JADX INFO: compiled from: GetLocationIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: GetLocationIntent.kt */
    @f(b = "GetLocationIntent.kt", c = {30}, d = "doAction", e = "com.obric.agent.intents.permission.GetLocationIntent")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ GetLocationIntent f14857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14858e;

        b(GetLocationIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14857d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14856c = r3;
            this.f14858e |= Integer.MIN_VALUE;
            return this.f14857d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: GetLocationIntent.kt */
    @f(b = "GetLocationIntent.kt", c = {49}, d = "getLocation", e = "com.obric.agent.intents.permission.GetLocationIntent")
    static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f14859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GetLocationIntent f14860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14861c;

        c(GetLocationIntent r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14860b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14859a = r3;
            this.f14861c |= Integer.MIN_VALUE;
            return GetLocationIntent.access$getLocation(this.f14860b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public GetLocationIntent() {
    }

    public static final /* synthetic */ Object access$getLocation(GetLocationIntent r2, d.c.d r3) {
        return r2.getLocation((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent
    public Object doAction(Empty r19, DispatchContext r20, d.c.d<? super IntentResult<Empty>> r21) {
        GetLocationIntent r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if ((r3.f14858e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f14858e -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14856c;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f14858e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        DispatchContext r6 = (DispatchContext) ZeusTransformUtils.preCheckCast(r3.f14855b, DispatchContext.class, "com.obric.aiagent.plugin");
        GetLocationIntent r7 = (GetLocationIntent) ZeusTransformUtils.preCheckCast(r3.f14854a, GetLocationIntent.class, "com.obric.aiagent.plugin");
        o.a(r2);
        DispatchContext r8 = r6;
        r0 = r7;
        Object r9 = r2;
    L17:
        GetLocationResult r10 = (GetLocationResult) ZeusTransformUtils.preCheckCast(r9, GetLocationResult.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L21;
        String r11 = new Gson().newBuilder().setPrettyPrinting().create().toJson(r10);
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, return details = " + r11);
        IntentResult r12 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r12.setDetails(r11);
        return r12;
    L21:
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_location_request_memory_denied, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_request_memory_denied"));
        d.h.b.o.c(r13, "getString(...)");
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, return details = " + r13);
        IntentResult r14 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r14.setDetails(r13);
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        ISecureLogDepend.Companion.i(getName(), "doAction called, params = " + r19);
        r3.f14854a = r0;
        r8 = r20;
        r3.f14855b = r8;
        r3.f14858e = 1;
        r9 = r0.getLocation(r3);
        if (r9 != r4) goto L17;
        return r4;
    L7:
        r3 = new b(r0, r1);
        goto L8
    }

    private final Object getLocation(d.c.d<? super GetLocationResult> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f14861c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14861c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f14859a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f14861c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r6);
    L17:
        OLocationInfo r10 = (OLocationInfo) ZeusTransformUtils.preCheckCast(r6, OLocationInfo.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L22;
        return null;
    L22:
        return new GetLocationResult(d.c.b.a.b.a(r10.getLongitude()), d.c.b.a.b.a(r10.getLatitude()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        s r11 = s.f16064a;
        Long r3 = d.c.b.a.b.a(TIMEOUT);
        r0.f14861c = 1;
        r6 = r11.a(r3, r0);
        if (r6 != r9) goto L17;
        return r9;
    L7:
        r0 = new c(this, r8);
        goto L8
    }
}
