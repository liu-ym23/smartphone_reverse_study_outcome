package com.bytedance.android.livehostapi.business.depend.share;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareCallback;", "Lcom/bytedance/android/livehostapi/business/depend/share/SimpleShareCallback;", "()V", "onChannelShare", "", "channel", "", "onContactSelect", "hasSelectContact", "", "onDialogDismiss", "onPreShare", d.f25926p, "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveWebShareCallback extends SimpleShareCallback {
    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback
    public void onChannelShare(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    public void onContactSelect(boolean r100) {
    }

    public void onDialogDismiss() {
    }

    public void onPreShare() {
    }

    public void onRefresh() {
    }

    public LiveWebShareCallback() {
    }
}
