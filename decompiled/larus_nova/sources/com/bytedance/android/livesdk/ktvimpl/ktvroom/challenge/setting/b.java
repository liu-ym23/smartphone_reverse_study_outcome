package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvChallengeSettingViewBinder.KtvChallengeSettingHolder f144592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a f144593b;

    public b(KtvChallengeSettingViewBinder.KtvChallengeSettingHolder r100, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r101) {
        this.f144592a = r100;
        this.f144593b = r101;
    }

    public final void a() {
        Object r100 = this.f144592a.itemView.getParent();
        if ((r100 instanceof View) == true) goto L5;
        r100 = null;
    L5:
        View r101 = (View) r100;
        if (r101 == null) goto L13;
        int r102 = r101.getWidth();
        if (this.f144593b.f144687c != 1) goto L10;
        int r103 = 3;
    L11:
        int r104 = ((r102 - (UtilityKotlinExtentionsKt.i(8) * (r103 - 1))) - (UtilityKotlinExtentionsKt.i(4) * 2)) / r103;
        ViewGroup.LayoutParams r105 = this.f144592a.itemView.getLayoutParams();
        r105.width = r104;
        this.f144592a.itemView.setLayoutParams(r105);
        return;
    L10:
        r103 = 4;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
