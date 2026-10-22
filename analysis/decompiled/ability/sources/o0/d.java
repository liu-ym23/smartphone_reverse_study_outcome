package o0;

import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import com.bytedance.apm.insight.IDynamicParams;

/* loaded from: classes2.dex */
public final class d implements MonitorCrash.Config.IDynamicParams {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f5413a;

    public d(e eVar) {
        this.f5413a = eVar;
    }

    @Override // com.apm.insight.MonitorCrash.Config.IDynamicParams
    public final String getDid() {
        e eVar = this.f5413a;
        IDynamicParams iDynamicParams = eVar.c;
        if (iDynamicParams == null || TextUtils.isEmpty(iDynamicParams.getDid())) {
            return null;
        }
        return eVar.c.getDid();
    }

    @Override // com.apm.insight.MonitorCrash.Config.IDynamicParams
    public final String getUserId() {
        return null;
    }
}
