package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y implements bw.r {
    public y() {
    }

    @Override // bw.r
    public final boolean handle(Context r100, Uri r101) {
        ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler().handle(r100, r101);
        return true;
    }

    @Override // bw.r
    public final boolean handle(Context r100, String r101) {
        ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler().handle(r100, r101);
        return true;
    }

    @Override // bw.r
    public final boolean handleWithCallback(Context r100, Uri r101, DialogInterface.OnDismissListener r102) {
        return ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler().handleWithCallback(r100, r101, r102);
    }

    @Override // bw.r
    public final void openExternalBrowser(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        if (URLUtil.isNetworkUrl(r101) == true) goto L5;
        return;
    L5:
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101));
        if (r103.resolveActivity(r100.getPackageManager()) == null) goto L8;
        r100.startActivity(r103);
        return;
    L8:
        yr.b.b(6, "openExternalBrowser", "没有找到合适的浏览器，url=" + r101);
    }
}
