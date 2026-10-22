package h6;

import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9302a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerActivity f9303b;

    public /* synthetic */ d(ModelManagerActivity modelManagerActivity, int i10) {
        this.f9302a = i10;
        this.f9303b = modelManagerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f9302a;
        ModelManagerActivity modelManagerActivity = this.f9303b;
        switch (i10) {
            case 0:
                modelManagerActivity.f5859q = null;
                if (!modelManagerActivity.isFinishing() && !modelManagerActivity.isDestroyed() && !CTAPermissionManager.INSTANCE.hasCTAPermission() && !modelManagerActivity.f5857o && !modelManagerActivity.v() && !CTADialogGate.INSTANCE.isDialogShowing()) {
                    AIEngineLogger.i(LogModule.SERVICE, modelManagerActivity.f5848b, "stopFinish: abandoned without CTA → finish");
                    modelManagerActivity.finish();
                    break;
                }
                break;
            default:
                boolean z = ModelManagerActivity.f5846t;
                modelManagerActivity.u(null);
                break;
        }
    }
}
