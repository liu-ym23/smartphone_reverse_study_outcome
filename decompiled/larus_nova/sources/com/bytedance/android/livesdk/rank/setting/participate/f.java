package com.bytedance.android.livesdk.rank.setting.participate;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParticipateSettingDialog f157022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f157023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f157024c;

    public f(ParticipateSettingDialog r100, Function1 r101, g r102) {
        this.f157022a = r100;
        this.f157023b = r101;
        this.f157024c = r102;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f157023b.invoke(Boolean.FALSE);
        ParticipateSettingDialog r101 = this.f157022a;
        int r102 = ParticipateSettingDialog.f156991k;
        r101.U90().b(this.f157024c, true);
    }
}
