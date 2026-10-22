package com.bytedance.android.openlive.inner.platform;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.IHostShareForSaas;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.wrap.AbsHostShare;
import com.bytedance.android.openlive.inner.host.IOpenHostShare;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/openlive/inner/platform/InternalHostShareWrapper;", "Lcom/bytedance/android/livehostapi/wrap/AbsHostShare;", "openHostShare", "Lcom/bytedance/android/openlive/inner/host/IOpenHostShare;", "(Lcom/bytedance/android/openlive/inner/host/IOpenHostShare;)V", "isShareAvailable", "", "hostShareType", "", "activity", "Landroid/app/Activity;", "isSupportLiveShare", "showNativeShareDialog", "", "params", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "showShareDialog", "live-inner-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class InternalHostShareWrapper extends AbsHostShare {
    private final IOpenHostShare openHostShare;

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShareForSaas
    public boolean isSupportLiveShare() {
        IOpenHostShare r100 = this.openHostShare;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSupportLiveShare();
    }

    public InternalHostShareWrapper(IOpenHostShare r100) {
        this.openHostShare = r100;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public boolean isShareAvailable(String r100, Activity r101) {
        IOpenHostShare r102 = this.openHostShare;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isShareAvailable(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShareForSaas
    public void showNativeShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
        IOpenHostShare r103 = this.openHostShare;
        if (r103 == null) goto L5;
        r103.showNativeShareDialog(r100, r101, r102);
        return;
    L5:
        IHostShareForSaas.CC.$default$showNativeShareDialog(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
        IOpenHostShare r103 = this.openHostShare;
        if (r103 == null) goto L5;
        r103.showShareDialog(r100, r101, r102);
        return;
    L5:
        super.showShareDialog(r100, r101, r102);
    }
}
