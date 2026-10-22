package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a extends b0<BasePkAudienceApplyListContract$View> {
    public abstract void d();

    public abstract void e();

    public abstract void f(boolean r100, String r101, long r102, String r103, int r104);

    public abstract void h();

    public abstract void i(Activity r100);

    public a(BasePkAudienceApplyListContract$View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public static /* synthetic */ void g(a r100, boolean r101, String r102, long r110, String r111, int r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        r110 = 20;
    L5:
        long r103 = r110;
        if ((r113 & 8) == 0) goto L8;
        r111 = "";
    L8:
        String r104 = r111;
        if ((r113 & 16) == 0) goto L11;
        r112 = WaitingListType.UNKNOWN.ordinal();
    L11:
        r100.f(r101, r102, r103, r104, r112);
    }
}
