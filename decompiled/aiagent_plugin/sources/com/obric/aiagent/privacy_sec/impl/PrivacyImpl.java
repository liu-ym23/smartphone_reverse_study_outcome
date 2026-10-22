package com.obric.aiagent.privacy_sec.impl;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.privacy_sec.IPrivacy;
import com.obric.aiagent.trace.ITraceReport;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrivacyImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyImpl implements IPrivacy {
    public static final String CUSTOM_APP_ID = "obric_assistant_aiagent";
    public static final a Companion = null;
    public static final String OAUTO_APP_ID = "ocean_oauto";
    private static final String TAG = "PrivacyImpl";
    private final b accountBridge;
    private final c envBridge;
    private PseudoManager mPseudoManager;
    private String mRpDid;

    /* JADX INFO: compiled from: PrivacyImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PrivacyImpl.kt */
    public static final class b implements IAccountBridge {
        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public String onGetUDID() {
            return null;
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public String onGetUserId() {
            return null;
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public Map<String, String> onGetXttTokenMap() {
            return null;
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public boolean onIsAccountLogin() {
            return false;
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public void onTeaEvent(String r1, JSONObject r2) {
        }

        b() {
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public String onGetDeviceId() {
            ITraceReport r2 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L7;
            return null;
        L7:
            return r2.getFlowDid();
        }
    }

    /* JADX INFO: compiled from: PrivacyImpl.kt */
    public static final class c implements IEnvBridge {
        c() {
        }

        @Override // com.bytedance.privacy.bridge.IEnvBridge
        public boolean onIsBoeEnv() {
            if (Settings.Global.getInt(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), "matrix_env_status_is_boe", 0) == 1) goto L5;
            return false;
        L5:
            return true;
        }
    }

    /* JADX INFO: compiled from: PrivacyImpl.kt */
    @f(b = "PrivacyImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.privacy_sec.impl.PrivacyImpl$initializePseudoManager$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacyImpl f18766b;

        d(PrivacyImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18766b = r3;
            super(2, r5);
        }

        /* JADX INFO: renamed from: lambda$W_gttyFMK--D3s_iE_H3ofO-_H0, reason: not valid java name */
        public static /* synthetic */ x m203lambda$W_gttyFMKD3s_iE_H3ofO_H0(PrivacyImpl r0, String r1) {
            return a(r0, r1);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f18766b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f18765a != 0) goto L14;
            o.a(r4);
            ILogDepend.Companion.i(PrivacyImpl.TAG, " - initialising PseudoManager...");     // Catch: Throwable -> L9
            ITraceReport r5 = (ITraceReport) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceReport.class), ITraceReport.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r5 == null) goto L12;
            final PrivacyImpl r3 = this.f18766b;     // Catch: Throwable -> L9
            r5.whenFlowDidReady(new $$Lambda$PrivacyImpl$d$W_gttyFMKD3s_iE_H3ofO_H0(r3));     // Catch: Throwable -> L9
        L12:
            return x.f38692a;
        L9:
            th = move-exception;
            ILogDepend.Companion.e(PrivacyImpl.TAG, "initializePseudoManager: failed", th);
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final x a(PrivacyImpl r2, String r3) {
            ILogDepend.Companion.i(PrivacyImpl.TAG, " - Flow DID is ready...");
            PrivacyImpl.access$setMPseudoManager$p(r2, PrivacySdk.getPseudoManager());
            PrivacyImpl.access$fetchRpDeviceId(r2);
            return x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$hQF1uuP0y3iSa3c6RGbcq622C3E(PrivacyImpl r0, String r1) {
        return init$lambda$0(r0, r1);
    }

    public PrivacyImpl() {
        this.accountBridge = new b();
        this.envBridge = new c();
    }

    public static final /* synthetic */ void access$fetchRpDeviceId(PrivacyImpl r0) {
        r0.fetchRpDeviceId();
    }

    public static final /* synthetic */ void access$setMPseudoManager$p(PrivacyImpl r0, PseudoManager r1) {
        r0.mPseudoManager = r1;
    }

    @Override // com.obric.aiagent.privacy_sec.IPrivacy
    public void init() {
        com.obric.aiagent.utils.a.a.f22293a.a(new $$Lambda$PrivacyImpl$hQF1uuP0y3iSa3c6RGbcq622C3E(this));
    }

    private static final x init$lambda$0(PrivacyImpl r3, String r4) {
        d.h.b.o.e(r4, "it");
        PrivacySdk.init((IAccountBridge) ZeusTransformUtils.preCheckCast(r3.accountBridge, IAccountBridge.class, "com.obric.aiagent.plugin"), (IEnvBridge) ZeusTransformUtils.preCheckCast(r3.envBridge, IEnvBridge.class, "com.obric.aiagent.plugin"));
        r3.initializePseudoManager();
        return x.f38692a;
    }

    @Override // com.obric.aiagent.privacy_sec.IPrivacy
    public String getPemCertChain(String r5, String r6) {
        d.h.b.o.e(r5, "keyAlias");
        d.h.b.o.e(r6, "customInfo");
        ILogDepend.Companion.d(TAG, "getPemCertChain: called, customInfo = " + r6 + ", keyAlias = " + r5);
        return PrivacySdk.getIdAttestationManager().getIDAttestationString((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), CUSTOM_APP_ID, r5, buildAttestationConfig(r6));
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getPemCertChain: called, ex = " + e);
        return null;
    }

    @Override // com.obric.aiagent.privacy_sec.IPrivacy
    public String getRpDeviceId() {
        String r0 = this.mRpDid;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ILogDepend.Companion.e(TAG, " - RpDid is not fetched; fetching anew.");
        fetchRpDeviceId();
        return this.mRpDid;
    }

    private final void initializePseudoManager() {
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void fetchRpDeviceId() {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        long r2 = System.currentTimeMillis();
        PseudoManager r4 = this.mPseudoManager;
        if (r4 == null) goto L5;
        String r1 = r4.getPseudoDID((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin"), OAUTO_APP_ID);
    L6:
        this.mRpDid = r1;
        ILogDepend.Companion.d(TAG, " - fetched RpDid=" + this.mRpDid + " (latency=" + (System.currentTimeMillis() - r2) + "ms)");
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final AttestationConfig buildAttestationConfig(String r3) {
        AttestationConfig.Builder r2 = new AttestationConfig.Builder();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2.customInfo(r3);
    L9:
        return r2.build();
    L5:
        r0 = false;
        goto L6
    }
}
