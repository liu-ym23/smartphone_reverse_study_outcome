package h6;

import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGateGuard;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerActivity f9301b;

    public /* synthetic */ c(ModelManagerActivity modelManagerActivity, int i10) {
        this.f9300a = i10;
        this.f9301b = modelManagerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        int i10 = this.f9300a;
        ModelManagerActivity modelManagerActivity = this.f9301b;
        switch (i10) {
            case 0:
                boolean z = ModelManagerActivity.f5846t;
                boolean zIsFinishing = modelManagerActivity.isFinishing();
                String str = modelManagerActivity.f5848b;
                if (!zIsFinishing && !modelManagerActivity.isDestroyed() && !CTAPermissionManager.INSTANCE.hasCTAPermission()) {
                    if (!modelManagerActivity.v() && !CTADialogGate.INSTANCE.isDialogShowing()) {
                        modelManagerActivity.f5857o = true;
                        try {
                            modelManagerActivity.startActivity(CtaGateGuard.INSTANCE.createPolicyIntent(modelManagerActivity).addFlags(603979776));
                            modelManagerActivity.overridePendingTransition(0, 0);
                            AIEngineLogger.i(LogModule.SERVICE, str, "ensureCtaEntryFlow: started PolicyActivity");
                            objA = lb.n.f10413a;
                        } catch (Throwable th) {
                            objA = kotlin.c.a(th);
                        }
                        Throwable thB = Result.b(objA);
                        if (thB != null) {
                            modelManagerActivity.f5857o = false;
                            AIEngineLogger.e(LogModule.SERVICE, str, "ensureCtaEntryFlow: start failed", thB);
                            modelManagerActivity.finish();
                            break;
                        }
                    } else {
                        AIEngineLogger.d(LogModule.SERVICE, str, "ensureCtaEntryFlow: PolicyActivity already foreground");
                        break;
                    }
                }
                break;
            default:
                boolean z3 = ModelManagerActivity.f5846t;
                modelManagerActivity.u(null);
                break;
        }
    }
}
