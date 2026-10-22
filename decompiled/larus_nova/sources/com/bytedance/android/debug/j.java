package com.bytedance.android.debug;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugLocalResourceListAdapter.AssetHolder f42623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DebugLocalResourceListAdapter.a f42624b;

    public j(DebugLocalResourceListAdapter.AssetHolder r100, DebugLocalResourceListAdapter.a r101) {
        this.f42623a = r100;
        this.f42624b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f42623a.f42597b.getContext().getDir(ChameleonAssertResManager.ASSET_FOLDER, 0).getAbsolutePath() + HTTP.URL_DEFAULT + this.f42624b.f42601d + HTTP.URL_DEFAULT);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (c0.b(r101) == false) goto L9;
        int r102 = ToastUtil.f90810a;
        ToastUtil.b("删除资源" + this.f42624b.f42598a + "成功，请点击刷新更新列表", 0);
        return;
    }
}
