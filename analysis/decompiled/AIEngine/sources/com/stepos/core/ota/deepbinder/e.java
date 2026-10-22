package com.stepos.core.ota.deepbinder;

import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.domain.TriggerSource;
import com.stepos.core.ota.process.OtaRuntime;
import h6.w;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7554a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7555b;

    public /* synthetic */ e(String str, int i10) {
        this.f7554a = i10;
        this.f7555b = str;
    }

    @Override // zb.a
    public final Object invoke() {
        Object objA;
        switch (this.f7554a) {
            case 0:
                return OtaInteractiveDownloadFlow.requestStartUpdate$lambda$5(this.f7555b);
            case 1:
                return OtaInteractiveDownloadFlow.requestStartDownload$lambda$1(this.f7555b);
            default:
                w.f9354a.getClass();
                String otaId = this.f7555b;
                g.f(otaId, "otaId");
                w.f9355b.put(otaId, Boolean.TRUE);
                try {
                    objA = Boolean.valueOf(OtaRuntime.INSTANCE.dispatcher().attach(otaId, TriggerSource.USER));
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.OTA, "SilentDownloadGate", "attach USER failed otaId=".concat(otaId), thB);
                }
                Boolean bool = Boolean.FALSE;
                if (objA instanceof Result.Failure) {
                    objA = bool;
                }
                boolean zBooleanValue = ((Boolean) objA).booleanValue();
                AIEngineLogger.i(LogModule.OTA, "SilentDownloadGate", "reveal otaId=" + otaId + " attached=" + zBooleanValue);
                OtaModelClient.f5871a.getClass();
                OtaModelClient.b(-3, otaId);
                return n.f10413a;
        }
    }
}
