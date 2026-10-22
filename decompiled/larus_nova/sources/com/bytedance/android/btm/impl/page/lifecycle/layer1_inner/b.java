package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends BaseBackResumer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f42275e = null;

    static {
        f42275e = new b();
    }

    public b() {
        super(ResumeFuncOrigin.Background, 1029, 1028);
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer1_inner.BaseBackResumer
    public final void e(Activity r100, h r101) {
        if (BtmSetting.f42469d.c().b().o() != 1) goto L6;
        super.e(r100, r101);
        return;
    L6:
        if (h(r100, r101) == false) goto L8;
        return;
    L8:
        if (i(r101) == false) goto L10;
        return;
    L10:
        if (j(r100, r101) == true) goto L17;
        c(r100, "");
        return;
    }
}
