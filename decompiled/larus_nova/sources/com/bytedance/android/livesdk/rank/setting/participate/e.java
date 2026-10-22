package com.bytedance.android.livesdk.rank.setting.participate;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParticipateSettingDialog f157019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f157020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f157021c;

    public e(ParticipateSettingDialog r100, Function1 r101, g r102) {
        this.f157019a = r100;
        this.f157020b = r101;
        this.f157021c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f157020b.invoke(Boolean.FALSE);
        ParticipateSettingDialog r102 = this.f157019a;
        int r103 = ParticipateSettingDialog.f156991k;
        r102.U90().b(this.f157021c, true);
        r100.dismiss();
    }
}
