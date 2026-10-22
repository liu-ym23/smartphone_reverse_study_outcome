package com.bytedance.android.live.broadcastgame.common.utils;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import jc1.k;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f59588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f59589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f59590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f59591d;

    public a(Function0 r100, String r101, String r102, u r103) {
        this.f59588a = r100;
        this.f59589b = r101;
        this.f59590c = r102;
        this.f59591d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f59588a.invoke();
        int r102 = n.f59316a;
        String r103 = this.f59589b;
        String r104 = this.f59590c;
        u r105 = this.f59591d;
        String r106 = r105.name;
        r r107 = r105.c();
        if (r107 == null) goto L6;
        String r108 = String.valueOf(r107.p());
        if (r108 == null) goto L6;
    L7:
        n.b(r103, r104, r106, r108, "cancel");
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logInteractGamePreCheck(1, this.f59591d, IInteractGameMonitorService.FAILURE_CODE_SWITCH_GAME_CHECK, this.f59590c, this.f59589b);
        return;
    L6:
        r108 = "";
        goto L7
    }
}
