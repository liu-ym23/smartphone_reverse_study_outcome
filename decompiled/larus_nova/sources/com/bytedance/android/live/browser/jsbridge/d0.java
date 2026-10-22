package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f63190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f63191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IJsBridgeManager f63192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f63193d;

    public static final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f63194a;

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void onTerminate() {
            ((com.bytedance.ies.xbridge.n) this.f63194a.f63191b.getValue()).a().release();
        }

        public a(d0 r100) {
            this.f63194a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(JSONObject r100, CallContext r101) {
            JSONObject r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Logger.d("XbridgeManager", "xbridge start,fun name:" + this.f63194a.f63190a);
            if ((((com.bytedance.ies.xbridge.n) this.f63194a.f63191b.getValue()).a() instanceof XCoreBridgeMethod) == false) goto L11;
            XBridgeMethod r103 = ((com.bytedance.ies.xbridge.n) this.f63194a.f63191b.getValue()).a();
            if (r103 == null) goto L10;
            g66.c r104 = ((XCoreBridgeMethod) r103).getContextProviderFactory();
            if (r104 == null) goto L11;
            r104.f(CallContext.class, r101);
            goto L11
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod");
        L11:
            r102.put("func", this.f63194a.f63190a);
            XBridgeMethod r105 = ((com.bytedance.ies.xbridge.n) this.f63194a.f63191b.getValue()).a();
            m30.g r106 = new m30.g(r102);
            c0 r107 = new c0(this);
            if (this.f63194a.f63193d != 2) goto L14;
            XBridgePlatformType r108 = XBridgePlatformType.LYNX;
        L15:
            r105.handle(r106, r107, r108);
            return;
        L14:
            r108 = XBridgePlatformType.WEB;
            goto L15
        }
    }

    public d0(String r100, Map.Entry r101, IJsBridgeManager r102, int r103) {
        this.f63190a = r100;
        this.f63191b = r101;
        this.f63192c = r102;
        this.f63193d = r103;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new a(this);
    }
}
