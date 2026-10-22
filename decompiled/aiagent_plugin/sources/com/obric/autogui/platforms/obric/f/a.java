package com.obric.autogui.platforms.obric.f;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.obric.autogui.common.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import org.json.JSONObject;
import os.teatracker.d;
import os.teatracker.e;

/* JADX INFO: compiled from: ObricTrackingImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.platforms.tools.f.a {
    private static final String TAG = "Tracking/Obric";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0797a f30130a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f30131c;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricTrackingImpl.kt */
    public static final class C0797a {
        public /* synthetic */ C0797a(h r1) {
            this();
        }

        private C0797a() {
        }
    }

    static {
        f30130a = new C0797a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.platforms.tools.f.a, com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi
    public void init(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super.init(r6);
        Loog.INSTANCE.i(TAG, "[Obric] initialising BizTrack");
        d.a(r6, new e.a().a(r6.getString(ZeusTransformUtils.mapRes(R.string.oauto_app_id, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_app_id"))).a());
        this.f30131c = true;
    }

    @Override // com.obric.autogui.platforms.tools.f.a
    public void a(String r7, JSONObject r8, boolean r9, boolean r10, TrackingReportTarget r11) {
        o.e(r7, "event");
        o.e(r8, "processedKV");
        o.e(r11, "reportTarget");
        if (r11 == TrackingReportTarget.TEA_AGENT_ONLY) goto L5;
        boolean r12 = true;
    L6:
        a(r7, r8, r9, r10, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    private final void a(String r2, JSONObject r3, boolean r4, boolean r5, boolean r6) {
        if (this.f30131c == true) goto L6;
        Loog.INSTANCE.e(TAG, "BizTrack not initialised, skipping event: " + r2);
        return;
    L6:
        a(r2, r3);
        if (r6 == false) goto L10;
        a(r2, r3, r4, r5);
        return;
    }

    private final void a(String r3, JSONObject r4) {
        d.a(r3, r4);
        if (b.f29001a.a() == false) goto L6;
        Loog.INSTANCE.d(TAG, "[ReportedTeaAgentEvent] " + r3 + " | " + r4);
        return;
    }
}
