package com.bytedance.android.livesdk.rank.setting.participate;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParticipateSettingDialog f157016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f157017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f157018c;

    public d(ParticipateSettingDialog r100, Function1 r101, g r102) {
        this.f157016a = r100;
        this.f157017b = r101;
        this.f157018c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f157017b.invoke(Boolean.TRUE);
        ParticipateSettingDialog r102 = this.f157016a;
        int r103 = ParticipateSettingDialog.f156991k;
        r102.U90().b(this.f157018c, false);
        r100.dismiss();
    }
}
