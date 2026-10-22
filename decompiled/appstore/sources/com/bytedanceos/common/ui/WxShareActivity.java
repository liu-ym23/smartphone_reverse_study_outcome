package com.bytedanceos.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.wxapi.WxApi;

/* JADX INFO: loaded from: classes2.dex */
public class WxShareActivity extends Activity {
    private WxApi mWxApi;

    public WxShareActivity() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (BaseApplication.c().o() == false) goto L5;
        String r11 = "wxf3aa815c32e6159c";
    L6:
        WxApi r12 = new WxApi();
        this.mWxApi = r12;
        r12.a(this, r11);
        Intent r13 = getIntent();
        String r14 = r13.getStringExtra("app_name");     // Catch: Exception -> L10
        String r15 = BaseApplication.c().getString(R$string.desc_share_app_to_wx);     // Catch: Exception -> L10
        String r16 = r13.getStringExtra(DownloadInfoColumns.APP_URL);     // Catch: Exception -> L10
        byte[] r17 = r13.getByteArrayExtra("app_thumb_bitmap_byte_arry");     // Catch: Exception -> L10
        if (r17 != null) goto L12;
        r17 = com.bytedanceos.common.utils.f.b(BitmapFactory.decodeResource(BaseApplication.c().getResources(), R$drawable.icon_store_launcher), true);     // Catch: Exception -> L10
    L12:
        com.bytedanceos.common.toolbox.j.n("sendWebPageToWxSession, success: " + this.mWxApi.b(r14, r15, r16, r17));     // Catch: Exception -> L10
    L15:
        finish();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r11 = "wxbcef57b3acd0474a";
        goto L6
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WxApi r10 = this.mWxApi;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }
}
