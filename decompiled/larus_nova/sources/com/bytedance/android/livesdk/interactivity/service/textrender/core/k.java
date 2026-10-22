package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.log.k0;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f141022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f141023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f141024c;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        HashMap r101 = new HashMap();
        r101.put(ReportCardMonitorPlugin.EVENT_NAME, "message badges load error");
        if (r100 == null) goto L5;
        Throwable r102 = r100.error;
    L6:
        if (r102 == null) goto L8;
        String r103 = r100.error.getMessage();
    L9:
        r101.put("error_msg", r103);
        k0.o().f("ttlive_msg", r101);
        boolean r104 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141057a;
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141058b == false) goto L14;
        pm0.a r105 = om0.c.c();
        if (r105 == null) goto L14;
        r105.i("ttlive_render_engine", "rend async failed for : " + this.f141024c + ".toloadImg");
    L14:
        this.f141022a.b(this.f141023b, null);
        return;
    L8:
        r103 = "";
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        j r101 = this.f141022a;
        if (r101.f141020c == false) goto L6;
        return;
    L6:
        if (r100 != null) goto L9;
        r101.b(this.f141023b, null);
        return;
    L9:
        Bitmap r102 = r100.copy(Bitmap.Config.ARGB_8888, true);
        if (r102 != null) goto L13;
        this.f141022a.b(this.f141023b, null);
        return;
    L13:
        int r103 = j.f141017e;
        int r104 = j.f141017e;
        int r105 = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r104, this.f141024c.f141010g);
        int r106 = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r104, this.f141024c.f141010g);
        BitmapDrawable r107 = new BitmapDrawable(s1.getResources(), r102);
        r107.setBounds(0, 0, r105, r106);
        this.f141022a.b(this.f141023b, r107);
    }

    public k(j r100, int r101, b r102) {
        this.f141022a = r100;
        this.f141023b = r101;
        this.f141024c = r102;
    }
}
