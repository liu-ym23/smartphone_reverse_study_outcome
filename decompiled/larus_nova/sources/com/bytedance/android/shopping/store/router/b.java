package com.bytedance.android.shopping.store.router;

import android.content.Intent;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopEntranceCheckActivity f185858a;

    public b(ShopEntranceCheckActivity r100) {
        this.f185858a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intent r101 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("https://bytedance.larkoffice.com/docx/JEIqdXpdVotjvixkjIrcog0nn0g"));
        this.f185858a.startActivity(r101, null);
        this.f185858a.finish();
    }
}
