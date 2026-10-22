package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivilegeSettingDetailDialog f132870a;

    public s(PrivilegeSettingDetailDialog r100) {
        this.f132870a = r100;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r100, int r101) {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.b.f158144f1;
        Integer r103 = this.f132870a.f132830e.get(Integer.valueOf(r101));
        Intrinsics.checkNotNull(r103);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        PrivilegeSettingDetailDialog.T90(this.f132870a);
    }
}
