package com.bytedance.android.openlive.inner.platform;

import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.openlive.inner.host.IOpenHostAction;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostDouPlusWrapper;", "Lcom/bytedance/android/livesdkapi/business/ILiveDouPlusService$DEFAULT;", "openHostAction", "Lcom/bytedance/android/openlive/inner/host/IOpenHostAction;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostAction;)V", "getOpenHostAction", "()Lcom/bytedance/android/openlive/inner/host/IOpenHostAction;", "setOpenHostAction", "logEvent", "", "isV1", "", "event", "", "label", "extra", "", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostDouPlusWrapper extends ILiveDouPlusService.DEFAULT {
    private IOpenHostAction openHostAction;

    public final IOpenHostAction getOpenHostAction() {
        return this.openHostAction;
    }

    public InternalHostDouPlusWrapper(IOpenHostAction r100) {
        this.openHostAction = r100;
        k.l(ILiveDouPlusService.class, this);
    }

    public final void setOpenHostAction(IOpenHostAction r100) {
        this.openHostAction = r100;
    }

    @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService.DEFAULT, com.bytedance.android.livesdkapi.business.ILiveDouPlusService
    public void logEvent(boolean r100, String r101, String r102, Map<String, String> r103) {
        IOpenHostAction r104 = this.openHostAction;
        if (r104 == null) goto L6;
        if (r104 == null) goto L8;
        r104.logEvent(r100, r101, r102, r103);
        return;
    L8:
        return;
    L6:
        super.logEvent(r100, r101, r102, r103);
    }
}
