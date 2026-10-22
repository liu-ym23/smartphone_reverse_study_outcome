package com.bytedance.android.livesdk.action.instance;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0005H\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/action/instance/ShowSplashShopAction;", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "Ljava/lang/Void;", "()V", AbsMethodDelegate.TAG_INVOKE, "", "params", "", "", "", "onTerminate", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@ActionMethod("webcast_inroom_usercard_flash_sale")
public final class ShowSplashShopAction extends BaseActionMethod<Void> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public ShowSplashShopAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) {
        e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.b.f158167k;
        Boolean r102 = Boolean.TRUE;
        r101.getClass();
        f.d(r101, r102);
        if (r100 == null) goto L5;
        Object r103 = r100.get("targetId");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L12;
    L17:
        Activity r105 = ((IHostApp) k.n(IHostApp.class)).getTopActivity();
        if (r105 != null) goto L20;
        return;
    L20:
        Bundle r106 = new Bundle();
        if (r104 != null) goto L23;
        r104 = "";
    L23:
        r106.putString("target_id", r104);
        r106.putLong("click_time", System.currentTimeMillis());
        ((IHostCommerceServiceLive) k.n(IHostCommerceServiceLive.class)).tryShowLiveFlashFragment(r105, r106, null);
        return;
    L12:
        if (r104.length() != 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 != true) goto L17;
        return;
    L14:
        r107 = false;
        goto L15
    L5:
        r103 = null;
        goto L7
    }
}
