package com.stepos.core.ability;

import android.util.Pair;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import com.stepos.core.ota.download.control.DownloadController;
import com.stepos.core.ota.download.control.DownloadStrategy;
import com.stepos.deepbinder.core.api.IRecycle;
import java.util.Map;
import n9.b;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7223a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7224b;

    public /* synthetic */ e(String str, int i10) {
        this.f7223a = i10;
        this.f7224b = str;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean z;
        switch (this.f7223a) {
            case 0:
                return Boolean.valueOf(AbilityManager.releaseAbility$lambda$37(this.f7224b, (Map.Entry) obj));
            case 1:
                return Boolean.valueOf(ModelCallSessionTracker.clear$lambda$9(this.f7224b, (String) obj));
            case 2:
                return OtaInteractiveDownloadFlow.rejectServiceDisabled$lambda$39(this.f7224b, (ConfirmDecisionBus.Decision) obj);
            case 3:
                return Boolean.valueOf(DownloadController.unregister$lambda$2(this.f7224b, (DownloadStrategy) obj));
            default:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.g.f(entry, "entry");
                if (kotlin.jvm.internal.g.b(this.f7224b, ((Pair) entry.getKey()).first)) {
                    Object objA = ((b.a) entry.getValue()).a();
                    if (objA instanceof IRecycle) {
                        ((IRecycle) objA).onRecycle();
                    }
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }
}
