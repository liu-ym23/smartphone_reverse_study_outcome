package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.larus.nova.R;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f77123a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.a$a, reason: collision with other inner class name */
    public static final class C1194a {
    }

    static {
    }

    public a() {
    }

    public final void b(View r110, String r111, final com.bytedance.android.live.liveinteract.jsbridge.method.j r112) {
        Intrinsics.checkNotNullParameter(r112, "callback");
        ALogger.i("CaptureLynxCardManager", "captureCardView viewName: " + r111);
        if (r110 != null) goto L5;
        return;
    L5:
        if ((r110 instanceof LynxView) == false) goto L32;
        boolean r100 = true;
        if (r111 != null) goto L9;
    L15:
        View r113 = r110;
    L17:
        if (r113 != null) goto L19;
        final Bitmap r114 = null;
    L20:
        if (r114 == null) goto L33;
        final Context r115 = r110.getContext();
        if (this.f77123a == false) goto L25;
        return;
    L25:
        if (((Boolean) vm2.d.V3.getValue(null, vm2.d.f555776a[253(0xfd, float:3.55E-43)])).booleanValue() == false) goto L29;
        Activity r101 = ContextUtil.contextToActivity(r115);
        if (r101 == null) goto L34;
        TimonMedia.withWritePermission$default(r101, new TimonMedia.ExtraInfo("bpea-live_CaptureLynxCardManager_doSavePicBefore", r100, r100, 24), null, new CaptureLynxCardManager$savePic$$inlined$let$lambda$1(this, r115, r114, r112), 4, null);
        return;
    L34:
        return;
    L29:
        Activity r102 = ContextUtil.contextToActivity(r115);
        SettingKey<Boolean> r103 = m60.i.f512260a;
        new m60.i.b(r102).b(new b(this, r115, r114, r112), null, m60.i.f512261b, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        return;
    L33:
        return;
    L19:
        r113.setDrawingCacheEnabled(true);
        r113.buildDrawingCache();
        r114 = r113.getDrawingCache();
        goto L20
    L9:
        if (r111.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r113 = ((LynxView) r110).findViewByName(r111);
        goto L17
    L11:
        r104 = false;
        goto L12
    }

    public static final void a(a r100, Context r101, Bitmap r102, ih0.h r103) {
        boolean r104 = true;
        r100.f77123a = true;
        String r105 = com.bytedance.android.livesdk.share.g.d(r101, r102, "adventure");
        ALogger.i("CaptureLynxCardManager", "savePic imgPath: " + r105);
        if (r105.length() == 0) goto L7;
        r104 = false;
    L7:
        if (r104 == false) goto L9;
        r103.a(UpdateLinkmicStatusResultModel.Code.Failed, r101.getResources().getString(R.string.ttlive_save_pic_fail), null);
    L10:
        r100.f77123a = false;
        return;
    L9:
        r103.a(UpdateLinkmicStatusResultModel.Code.Success, r101.getResources().getString(R.string.ttlive_save_pic_success), null);
        goto L10
    }
}
