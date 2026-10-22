package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XiaoAnSettingDialog f132877a;

    public z(XiaoAnSettingDialog r100) {
        this.f132877a = r100;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r100, int r101) {
        XiaoAnSettingDialog r102 = this.f132877a;
        r102.f132843i = r102.f132841g.get(Integer.valueOf(r101));
    }
}
