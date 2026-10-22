package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.GroupPurchaseItem;
import com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements IGroupPurchaseItemCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupPurchaseConfig f115995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f115996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f115997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f115998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ToolbarMatchInterface f115999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0 f116000f;

    @Override // com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback
    public final void onFailed(Throwable r100) {
        if (r100 == null) goto L5;
        r100.printStackTrace();
    L5:
        if (r100 == null) goto L7;
        String r101 = r100.getMessage();
    L9:
        if (Intrinsics.areEqual(r101, "empty data") == true) goto L11;
        return;
    L11:
        if (this.f115996b == true) goto L19;
        this.f115997c.invoke("req failed");
        if (this.f115998d == false) goto L20;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("toolbar_server_ctrl", "1");
        IHostLiveLocalLife r103 = (IHostLiveLocalLife) this.f115995a.f115972f.getValue();
        if (r103 == null) goto L21;
        r103.sendLog(com.bytedance.android.live.core.utils.z.d(this.f115995a.f115974h, null), "live_life_performance_icon_first_abnormal_show", r102);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r101 = null;
        goto L9
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback
    public final void onSuccess(GroupPurchaseItem r100) {
        this.f115999e.setExtraDataAfterCheck(r100);
        boolean r101 = true;
        if (com.bytedance.android.live.core.utils.z.m(this.f115995a.f115974h, true) == false) goto L21;
        List<String> r102 = null;
        if (r100 == null) goto L7;
        UrlModel r103 = r100.getDynamicIconUrl();
    L8:
        if (r103 == null) goto L21;
        UrlModel r104 = r100.getDynamicIconUrl();
        if (r104 == null) goto L12;
        r102 = r104.getUrlList();
    L12:
        List<String> r105 = r102;
        if (r105 != null) goto L15;
    L18:
        if (r101 == true) goto L21;
        this.f116000f.invoke();
        return;
    L15:
        if (r105.isEmpty() == true) goto L18;
        r101 = false;
        goto L18
    L7:
        r103 = null;
    L21:
        this.f115997c.invoke("dynamicIconUrl is null");
    }

    public j(GroupPurchaseConfig r100, boolean r101, Function1 r102, boolean r103, ToolbarMatchInterface r104, Function0 r105) {
        this.f115995a = r100;
        this.f115996b = r101;
        this.f115997c = r102;
        this.f115998d = r103;
        this.f115999e = r104;
        this.f116000f = r105;
    }
}
