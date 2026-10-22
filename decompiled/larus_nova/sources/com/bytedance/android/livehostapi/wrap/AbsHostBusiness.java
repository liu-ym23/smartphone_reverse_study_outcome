package com.bytedance.android.livehostapi.wrap;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livehostapi/wrap/AbsHostBusiness;", "Lcom/bytedance/android/livehostapi/hostdefault/HostBusinessDefault;", "()V", "ecOpenSchema", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "bundle", "Landroid/os/Bundle;", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public class AbsHostBusiness extends HostBusinessDefault {
    public AbsHostBusiness() {
        k.l(IHostBusiness.class, this);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness
    public void ecOpenSchema(Context r100, String r101, Bundle r102) {
        ILiveService r103 = TTLiveService.getLiveService();
        if (r103 == null) goto L6;
        r103.handleSchema(r100, UriProtector.parse(r101));
        return;
    }
}
